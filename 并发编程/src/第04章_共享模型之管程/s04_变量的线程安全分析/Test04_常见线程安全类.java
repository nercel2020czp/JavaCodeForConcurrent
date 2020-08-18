package 第04章_共享模型之管程.s04_变量的线程安全分析;

/*String
Integer
StringBuffer
Random
Vector
Hashtable
java.util.concurrent 包下的类

这里说它们是线程安全的是指，多个线程调用它们同一个实例的某个方法时，是线程安全的。也可以理解为：
	1.它们的每个方法是原子的
	2.但注意它们多个方法的组合不是原子的，见后面分析
*/

public class Test04_常见线程安全类 {

}
