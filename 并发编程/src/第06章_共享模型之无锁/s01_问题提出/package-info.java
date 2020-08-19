/**
 * 
 */
/**
 * @author 15753
 *
 */
package 第06章_共享模型之无锁.s01_问题提出;
/*

有如下需求，保证 account.withdraw 取款方法的线程安全:

	执行测试代码
	
	public static void main(String[] args) {
		Account.demo(new AccountUnsafe(10000));
	}
	
	某次的执行结果
	330 cost: 306 ms

*/