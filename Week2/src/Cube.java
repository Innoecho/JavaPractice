
public class Cube {

	public static void main(String[] args) {
		
		// 首先调用函数验证题目所给的两组数是否满足条件
		System.out.println(isCubeSum(3, 5, 6));
		System.out.println(isCubeSum(6, 69, 180));
		// 因为立方和不能大于最大整数，故搜索范围为最大整数的立方根
		long max = (long)Math.pow(java.lang.Long.MAX_VALUE, 1.0/3);
		long i, j;
		// 从较小长度开始搜索，可以较快得出结果
		for(j = 2; j < max; j++){
			for(i = 1; i < max; i++) {
				// 调用函数求i到i+j的立方和
				long sum = CubeSum(i, i+j);
				// 如果超出最大整数上限，所得值会变为负数，后面的结果也必为负数，直接break
				if(sum < 0) break;
				// 如果立方和是一个立方数，则输出
				if(isCubic(sum)) {
					// 求立方根
					long cubeRoot = (long)Math.round(Math.pow((double)sum, 1.0/3));
					System.out.println(String.format("%d-%d\t%d", i, i+j, cubeRoot));
					continue;
				}
			}
		}
	}
	
	// 用于求从n1到n2的立方和
	// 使用立方求和公式计算，能够大大降低计算量
	// 返回long型立方和
	static long CubeSum(long n1, long n2) {
		long result = 0;
		result += Math.pow(n2*(n2+1)/2, 2);
		result -= Math.pow(n1*(n1-1)/2, 2);
		return result;
	}
	
	// 判断n1到n2的立方和是否为k的立方
	// 直接返回字符串说明是否相等
	static String isCubeSum(long n1, long n2, long k) {
		if(CubeSum(n1, n2) == k*k*k) {
			return String.format("The cubic sum from %d to %d "
					+ "equals the cubic of %d", n1, n2, k);
		}
		else {
			return String.format("The cubic sum from %d to %d "
					+ "Not equals the cubic of %d", n1, n2, k);
		}
	}
	
	// 判断一个整数是否为某个整数的立方
	// 放回boolean值
	static boolean isCubic(long n) {
		// 将n强制转换为double型，并求其立方根
		double tmp1 = Math.pow((double)n, 1.0/3);
		// 将求得的立方根四舍五入转换为整形
		long tmp2 = Math.round(tmp1);
		// 由于浮点数的计算误差，不能直接比较大小，故两数之差足够小即认为相等
		if(Math.abs(n - Math.pow(tmp2, 3)) < 1E-6) {
			return true;
		}
		else {
			return false;
		}
	}

}
