/**
 * 
 */
/**
 * @author 15753
 *
 */
package c11_AQS_原理.c03_心得.c01_AQS起源;

/*
起源
早期程序员会自己通过一种同步器去实现另一种相近的同步器，例如用可重入锁去实现信号量，或反之。这显然不
够优雅，于是在 JSR166（java 规范提案）中创建了 AQS，提供了这种通用的同步器机制。


*/