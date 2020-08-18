/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第04章_共享模型之管程.s08_wait_notify的正确姿势.p02_step2;

/*

输出:
	20:51:42.489 [小南] c.TestCorrectPosture - 有烟没？[false]
	20:51:42.493 [小南] c.TestCorrectPosture - 没烟，先歇会！
	20:51:42.493 [其它人] c.TestCorrectPosture - 可以开始干活了
	20:51:42.493 [其它人] c.TestCorrectPosture - 可以开始干活了
	20:51:42.494 [其它人] c.TestCorrectPosture - 可以开始干活了
	20:51:42.494 [其它人] c.TestCorrectPosture - 可以开始干活了
	20:51:42.494 [其它人] c.TestCorrectPosture - 可以开始干活了
	20:51:43.490 [送烟的] c.TestCorrectPosture - 烟到了噢！
	20:51:43.490 [小南] c.TestCorrectPosture - 有烟没？[true]
	20:51:43.490 [小南] c.TestCorrectPosture - 可以开始干活了
	
解决了其它干活的线程阻塞的问题
但如果有其它线程也在等待条件呢？


*/