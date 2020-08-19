/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第06章_共享模型之无锁.s04_原子引用.c04_ABA问题及解决.c01_ABA问题;
/*

输出
	11:29:52.325 c.Test36 [main] - main start...
	11:29:52.379 c.Test36 [t1] - change A->B true
	11:29:52.879 c.Test36 [t2] - change B->A true
	11:29:53.880 c.Test36 [main] - change A->C true

*/