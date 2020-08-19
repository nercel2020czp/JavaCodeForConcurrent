/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第06章_共享模型之无锁.s05_原子数组.c02_安全的数组;
/*
安全的数组

demo(
()-> new AtomicIntegerArray(10),
(array) -> array.length(),
(array, index) -> array.getAndIncrement(index),
array -> System.out.println(array)
);

结果
[10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000, 10000]

*/