package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p07_模式之生产者消费者;

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
//		4.消息队列是有容量限制的，满时不会再加入数据，空时不会再消耗数据
		synchronized (queue) {
			while (queue.isEmpty()) {
				Utils.log("没货了, wait");
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
//		4.消息队列是有容量限制的，满时不会再加入数据，空时不会再消耗数据
		synchronized (queue) {
			while (queue.size() == capacity) {
				Utils.log("库存已达上限, wait");
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
要点:
	1.与前面的保护性暂停中的 GuardObject 不同，不需要产生结果和消费结果的线程一一对应
	2.消费队列可以用来平衡生产和消费的线程资源
	3.生产者仅负责产生结果数据，不关心数据该如何处理，而消费者专心处理结果数据
	4.消息队列是有容量限制的，满时不会再加入数据，空时不会再消耗数据
	5.JDK 中各种阻塞队列，采用的就是这种模式
*/
public class 异步模式之生产者_消费者 {
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		MessageQueue messageQueue = new MessageQueue(2);
		// 4 个生产者线程, 下载任务
		for (int i = 0; i < 4; i++) {
			int id = i;
			new Thread(() -> {
				try {
					Utils.log("download...");
					TimeUnit.SECONDS.sleep(2);
					List<String> response = new LinkedList<String>();
					response.add("阿森纳");
					response.add("热刺");
					response.add("曼联");
					
					messageQueue.put(new Message(id, response));
					Utils.log("put message("+id+") sucess");
				}  catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}, "生产者" + i).start();
		}
		// 1 个消费者线程, 处理结果
		new Thread(() -> {
			while (true) {
				Message message = messageQueue.take();
				List<String> response = (List<String>) message.getMessage();
				Utils.log("take message("+message.getId()+"): ["+response.size()+"] lines");
			}
		}, "消费者").start();
	}

}
