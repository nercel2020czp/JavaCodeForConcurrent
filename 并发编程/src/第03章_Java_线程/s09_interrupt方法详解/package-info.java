/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第03章_Java_线程.s09_interrupt方法详解;
/*
https://www.cnblogs.com/gosaint/p/9111189.html
并发之线程以及线程的中断状态：【非常重要】
https://www.cnblogs.com/gosaint/p/9111189.html
	综上所述，我们分别介绍了不同种线程的不同状态下对于中断请求的反应。NEW和TERMINATED对于中断操作几乎是屏蔽的，
	RUNNABLE和BLOCKED类似，对于中断操作只是设置中断标志位并没有强制终止线程，对于线程的终止权利依然在程序手中。
	WAITING/TIMED_WAITING状态下的线程对于中断操作是敏感的，他们会抛出异常并清空中断标志位。


在Core Java中有这样一句话：
"没有任何语言方面的需求要求一个被中断的程序应该终止。
中断一个线程只是为了引起该线程的注意，被中断线程可以决定如何应对中断 "。
好好体会这句话的含义，看看下面的代码：
//Interrupted的经典使用代码    

public void run(){    
    try{    
         ....    
         while(!Thread.currentThread().isInterrupted() && more work to do){    
             // do more work;    
         }    
    } catch(InterruptedException e){    
             // thread was interrupted during sleep or wait    
    } finally {    
             // cleanup, if required    
    }    
}    

      很显然，在上面代码中，while循环有一个决定因素就是需要不停的检查自己的中断状态。
      当外部线程调用该线程的interrupt 时，使得中断状态置位。这是该线程将终止循环，不在执行循环中的do more work了。

      这说明: interrupt中断的是线程的某一部分业务逻辑，前提是线程需要检查自己的中断状态(isInterrupted())。

      但是当th1被阻塞的时候，比如被Object.wait, Thread.join和Thread.sleep三种方法之一阻塞时。
      调用它的interrput()方法。可想而知，没有占用CPU运行的线程是不可 能给自己的中断状态置位的。
      这就会产生一个InterruptedException异常。

*/