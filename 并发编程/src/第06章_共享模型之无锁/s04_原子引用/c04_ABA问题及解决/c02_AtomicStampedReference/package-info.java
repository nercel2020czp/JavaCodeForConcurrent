/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第06章_共享模型之无锁.s04_原子引用.c04_ABA问题及解决.c02_AtomicStampedReference;
/*

输出为:
	15:41:34.891 c.Test36 [main] - main start...
	15:41:34.894 c.Test36 [main] - 版本 0
	15:41:34.956 c.Test36 [t1] - change A->B true
	15:41:34.956 c.Test36 [t1] - 更新版本为 1
	15:41:35.457 c.Test36 [t2] - change B->A true
	15:41:35.457 c.Test36 [t2] - 更新版本为 2
	15:41:36.457 c.Test36 [main] - change A->C false

AtomicStampedReference 可以给原子引用加上版本号，追踪原子引用整个的变化过程，如： A -> B -> A ->
C ，通过AtomicStampedReference，我们可以知道，引用变量中途被更改了几次。

但是有时候，并不关心引用变量更改了几次，只是单纯的关心是否更改过，所以就有了
AtomicMarkableReference

*/