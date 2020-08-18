package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p06_同步模式之保护性暂停.e01_多任务版GuardedObject;
/*图中 【多任务版GuardedObject.png】Futures 就好比居民楼一层的信箱（每个信箱有房间编号），
 * 左侧的 t0，t2，t4 就好比等待邮件的居民，右
侧的 t1，t3，t5 就好比邮递员
如果需要在多个类之间使用 GuardedObject 对象，作为参数传递不是很方便，因此设计一个用来解耦的中间类，
这样不仅能够解耦【结果等待者】和【结果生产者】，还能够同时支持多个任务的管理*/

import java.util.Hashtable;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import utils.Utils;

//新增 id 用来标识 Guarded Object
class GuardedObject {
	// 标识 Guarded Object
	private int id;

	public GuardedObject(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	// 结果
	private Object response;

	// 获取结果
	// timeout 表示要等待多久 2000
	public Object get(long timeout) {
		synchronized (this) {
			// 开始时间 15:00:00
			long begin = System.currentTimeMillis();
			// 经历的时间
			long passedTime = 0;
			while (response == null) {
				// 这一轮循环应该等待的时间
				long waitTime = timeout - passedTime;
				// 经历的时间超过了最大等待时间时，退出循环
				if (timeout - passedTime <= 0) {
					break;
				}
				try {
					this.wait(waitTime); // 虚假唤醒 15:00:01
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				// 求得经历时间
				passedTime = System.currentTimeMillis() - begin; // 15:00:02 1s
			}
			return response;
		}
	}

	// 产生结果
	public void complete(Object response) {
		synchronized (this) {
			// 给结果成员变量赋值
			this.response = response;
			this.notifyAll();
		}
	}
}

//中间解耦类
class Mailboxes {
	private static Map<Integer, GuardedObject> boxes = new Hashtable<>();
	private static int id = 1;

	// 产生唯一 id
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

//业务相关类
class People extends Thread {
	@Override
	public void run() {
		// 收信
		GuardedObject guardedObject = Mailboxes.createGuardedObject();
		Utils.log("开始收信 id: " + guardedObject.getId());
		Object mail = guardedObject.get(5000);
		Utils.log("收到信 id:" + guardedObject.getId() + " 内容:" + mail);
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
		Utils.log("送信 id:" + id +  "   内容:" + mail);
		guardedObject.complete(mail);
	}
}

public class 多任务版GuardedObject {
	public static void main(String[] args) throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			new People().start();
		}
		TimeUnit.SECONDS.sleep(1);
		for (Integer id : Mailboxes.getIds()) {
			new Postman(id, "内容" + id).start();
		}
	}
}
