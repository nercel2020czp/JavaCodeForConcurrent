package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p06_同步模式之保护性暂停;
/*图中 【多任务版GuardedObject.png】Futures 就好比居民楼一层的信箱（每个信箱有房间编号），左侧的 t0，t2，t4 就好比等待邮件的居民，右
侧的 t1，t3，t5 就好比邮递员
如果需要在多个类之间使用 GuardedObject 对象，作为参数传递不是很方便，因此设计一个用来解耦的中间类，
这样不仅能够解耦【结果等待者】和【结果生产者】，还能够同时支持多个任务的管理*/
//新增 id 用来标识 Guarded Object
public class Test06_多任务版GuardedObject {

}
