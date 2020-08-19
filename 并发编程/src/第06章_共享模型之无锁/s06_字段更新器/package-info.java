/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第06章_共享模型之无锁.s06_字段更新器;
/*

6.6 字段更新器
AtomicReferenceFieldUpdater // 域 字段
AtomicIntegerFieldUpdater
AtomicLongFieldUpdater
利用字段更新器，可以针对对象的某个域（Field）进行原子操作，只能配合 volatile 修饰的字段使用，否则会出现
异常
Exception in thread "main" java.lang.IllegalArgumentException: Must be volatile type

*/