/**
 * Description: 基数排序已经不再是一种常规的排序方式，它更多地像一种排序方法的应用，基数排序必须依赖于另外的排序方法。基数排序的总体思路就是将待排序数据拆分成多个关键字进行排序，
 * 也就是说，基数排序的实质是多关键字排序。
 * 	多关键字排序的思路是将待排数据里德排序关键字拆分成多个排序关键字；第1个排序关键字，第2个排序关键字，第3个排序关键字......然后，根据子关键字对待排序数据进行排序。
 * 	多关键字排序时有两种解决方案：
 * 	最高位优先法（MSD）(Most Significant Digit first)
 * 	最低位优先法（LSD）(Least Significant Digit first)
 * 	例如，对如下数据序列进行排序。
 * 	192,221,12,23
 * 	可以观察到它的每个数据至多只有3位，因此可以将每个数据拆分成3个关键字：百位（高位）、十位、个位（低位）。
 * 	如果按照习惯思维，会先比较百位，百位大的数据大，百位相同的再比较十位，十位大的数据大；最后再比较个位。人得习惯思维是最高位优先方式。
 * 	如果按照人得思维方式，计算机实现起来有一定的困难，当开始比较十位时，程序还需要判断它们的百位是否相同--这就认为地增加了难度，计算机通常会选择最低位优先法。
 * 	基数排序方法对任一子关键字排序时必须借助于另一种排序方法，而且这种排序方法必须是稳定的。
 * 	对于多关键字拆分出来的子关键字，它们一定位于0-9这个可枚举的范围内，这个范围不大，因此用桶式排序效率非常好。
 * 	对于多关键字排序来说，程序将待排数据拆分成多个子关键字后，对子关键字排序既可以使用桶式排序，也可以使用任何一种稳定的排序方法。
 * Author: DeamonCao
 * Creation time: 2016年10月16日 下午5:45:18
 * (C) Copyright 2015-2020, DeamonCao.
 * All rights reserved.
 */
package bh.toolkit.algorithm.sort;

import java.util.Arrays;

public class MultiKeyRadixSort {
	
	public static int getTimes(int[] array){
		int max = array[0];
		for(int ii = 1 ; ii <array.length ; ii++){
			if(array[ii]>max){
				max = array[ii];
			}
		}
		int times = 0;
		while(max > 0){
			max /=10;
			times ++;
		}
		return times;
		
	}
	
	public static void multiKeyRadixSort(int[] array){
		
		int radix = 10;
		int d = getTimes(array);
		//缓存数组
		int[] tmp = new int[array.length];
		//buckets用于记录待排序元素的信息
		//buckets数组定义了max-min个桶
		int[] buckets = new int[radix];
		
		for(int ii = 0,rate = 1;ii< d; ii++){
			//重置count数组，开始统计下一个关键字
			Arrays.fill(buckets, 0);
			//将array中的元素完全复制到tmp数组中
			System.arraycopy(array, 0, tmp, 0, array.length);
			
			//计算每个待排序数据的子关键字
			for(int jj = 0 ; jj < array.length; jj++){
				int subKey = (tmp[jj] / rate) % radix;
				buckets[subKey]++;
			}
			
			for(int jj = 1 ; jj <radix ; jj++){
				buckets[jj] = buckets[jj] + buckets[jj-1];
			}
			
			//按子关键字对指定的数据进行排序
			for(int aa = array.length-1 ; aa >=0 ; aa--){
				int subKey = (tmp[aa] / rate) % radix;
				array[--buckets[subKey]] = tmp[aa];
			}
			rate *= radix;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {49,38,65,97,76,13,27,49,78,34,12,1,10000000,64,5,4,62,99,98,54,56,5,17,18,23,34,15,35,25,53,51}; 
		MultiKeyRadixSort.multiKeyRadixSort(array);
		for(int ii = 0 ; ii <array.length ; ii ++){
			System.out.println(array[ii]);
		}
	}

}
