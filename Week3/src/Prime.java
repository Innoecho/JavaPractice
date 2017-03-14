
public class Prime {
	public static void main(String[] args) {
		// 指定范围
		int n = 100;
		// 声明用以标记是否素数的数组
		// 简单起见，声明了0~100的数组,但是仅使用2~100的部分
		int []flag = new int[n+1];
		int i;
		// 2比较特殊，先筛掉2的倍数
		// 同时为非2的倍数添加标记
		for(i = 3; i <= n; i++) {
			if(i%2 == 0) {
				flag[i] = 0;
			}
			else {
				flag[i] = 1;
			}
		}
		// 从3开始，依次加2开始筛除
		i = 3;
		int j;
		// 仅仅需要使用根n之前的数进行筛除
		while(i*i <= n) {
			// 筛之前，需要判断这个数是否是素数
			if(flag[i] == 1) {
				// 比i小的因子之前已经晒过，故最小的即为i*i
				j = i*i;
				while(j <= n) {
					flag[j] = 0;
					// j+i必为偶数，直接跳过
					j += i + i;
				}
			}
			i += 2;
		}
		// 此处需要补充质数2的标记
		flag[2] = 1;
		// 输出标记为1的数，即质数
		// 控制换行
		int k = 0;
		for(i = 0; i <= n; i++) {
			if(flag[i] == 1){
				k++;
				System.out.print(String.format("%d\t", i));
				// 每10个一行
				if(k == 10) {
					System.out.println("");
					k = 0;
				}
			}	
		}
	}
}
