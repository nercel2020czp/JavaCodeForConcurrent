package ��04��_����ģ��֮�ܳ�.s08_wait_notify����ȷ����.p07_ģʽ֮������������;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import utils.Utils;

class Message {
	private int id;
	private Object message;

	public Message(int id, Object message) {
		this.id = id;
		this.message = message;
	}

	public int getId() {
		return id;
	}

	public Object getMessage() {
		return message;
	}
}

class MessageQueue {
	private LinkedList<Message> queue;
	private int capacity;

	public MessageQueue(int capacity) {
		this.capacity = capacity;
		queue = new LinkedList<>();
	}

	public Message take() {
//		4.��Ϣ���������������Ƶģ���ʱ�����ټ������ݣ���ʱ��������������
		synchronized (queue) {
			while (queue.isEmpty()) {
				Utils.log("û����, wait");
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			Message message = queue.removeFirst();
			queue.notifyAll();
			return message;
		}
	}

	public void put(Message message) {
//		4.��Ϣ���������������Ƶģ���ʱ�����ټ������ݣ���ʱ��������������
		synchronized (queue) {
			while (queue.size() == capacity) {
				Utils.log("����Ѵ�����, wait");
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			queue.addLast(message);
			queue.notifyAll();
		}
	}
}
/*
Ҫ��:
	1.��ǰ��ı�������ͣ�е� GuardObject ��ͬ������Ҫ������������ѽ�����߳�һһ��Ӧ
	2.���Ѷ��п�������ƽ�����������ѵ��߳���Դ
	3.�����߽��������������ݣ����������ݸ���δ�����������ר�Ĵ���������
	4.��Ϣ���������������Ƶģ���ʱ�����ټ������ݣ���ʱ��������������
	5.JDK �и����������У����õľ�������ģʽ
*/
public class �첽ģʽ֮������_������ {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		MessageQueue messageQueue = new MessageQueue(2);
		// 4 ���������߳�, ��������
		for (int i = 0; i < 4; i++) {
			int id = i;
			new Thread(() -> {
				try {
					Utils.log("download...");
					TimeUnit.SECONDS.sleep(2);
					List<String> response = new LinkedList<String>();
					response.add("��ɭ��");
					response.add("�ȴ�");
					response.add("����");
					
					messageQueue.put(new Message(id, response));
					Utils.log("put message("+id+") sucess");
				}  catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}, "������" + i).start();
		}
		// 1 ���������߳�, ������
		new Thread(() -> {
			while (true) {
				Message message = messageQueue.take();
				List<String> response = (List<String>) message.getMessage();
				Utils.log("take message("+message.getId()+"): ["+response.size()+"] lines");
			}
		}, "������").start();
	}

}
