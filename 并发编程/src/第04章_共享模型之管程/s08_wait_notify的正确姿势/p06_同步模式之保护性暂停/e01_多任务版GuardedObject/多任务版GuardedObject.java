package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p06_ͬ��ģʽ֮��������ͣ.e01_�������GuardedObject;
/*ͼ�� ���������GuardedObject.png��Futures �ͺñȾ���¥һ������䣨ÿ�������з����ţ���
 * ���� t0��t2��t4 �ͺñȵȴ��ʼ��ľ�����
��� t1��t3��t5 �ͺñ��ʵ�Ա
�����Ҫ�ڶ����֮��ʹ�� GuardedObject ������Ϊ�������ݲ��Ǻܷ��㣬������һ������������м��࣬
���������ܹ��������ȴ��ߡ��͡���������ߡ������ܹ�ͬʱ֧�ֶ������Ĺ���*/

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import utils.Utils;

//���� id ������ʶ Guarded Object
class GuardedObject {
	// ��ʶ Guarded Object
	private int id;

	public GuardedObject(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	// ���
	private Object response;

	// ��ȡ���
	// timeout ��ʾҪ�ȴ���� 2000
	public Object get(long timeout) {
		synchronized (this) {
			// ��ʼʱ�� 15:00:00
			long begin = System.currentTimeMillis();
			// ������ʱ��
			long passedTime = 0;
			while (response == null) {
				// ��һ��ѭ��Ӧ�õȴ���ʱ��
				long waitTime = timeout - passedTime;
				// ������ʱ�䳬�������ȴ�ʱ��ʱ���˳�ѭ��
				if (timeout - passedTime <= 0) {
					break;
				}
				try {
					this.wait(waitTime); // ��ٻ��� 15:00:01
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// ��þ���ʱ��
				passedTime = System.currentTimeMillis() - begin; // 15:00:02 1s
			}
			return response;
		}
	}

	// �������
	public void complete(Object response) {
		synchronized (this) {
			// �������Ա������ֵ
			this.response = response;
			this.notifyAll();
		}
	}
}

//�м������
class Mailboxes {
	private static Map<Integer, GuardedObject> boxes = new Hashtable<>();
	private static int id = 1;

	// ����Ψһ id
	private static synchronized int generateId() {
		return id++;
	}

	public static GuardedObject getGuardedObject(int id) {
		return boxes.remove(id);
	}

	public static GuardedObject createGuardedObject() {
		GuardedObject go = new GuardedObject(generateId());
		boxes.put(go.getId(), go);
		return go;
	}

	public static Set<Integer> getIds() {
		return boxes.keySet();
	}
}

//ҵ�������
class People extends Thread {
	@Override
	public void run() {
		// ����
		GuardedObject guardedObject = Mailboxes.createGuardedObject();
		Utils.log("��ʼ���� id: " + guardedObject.getId());
		Object mail = guardedObject.get(5000);
		Utils.log("�յ��� id:" + guardedObject.getId() + " ����:" + mail);
	}
}

class Postman extends Thread {
	private int id;
	private String mail;

	public Postman(int id, String mail) {
		this.id = id;
		this.mail = mail;
	}

	@Override
	public void run() {
		GuardedObject guardedObject = Mailboxes.getGuardedObject(id);
		Utils.log("���� id:" + id +  "   ����:" + mail);
		guardedObject.complete(mail);
	}
}

public class �������GuardedObject {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			new People().start();
		}
		TimeUnit.SECONDS.sleep(1);
		for (Integer id : Mailboxes.getIds()) {
			new Postman(id, "����" + id).start();
		}
	}
}
