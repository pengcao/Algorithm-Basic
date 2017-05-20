/**
 * Description: 插入排序
 * 基本思想：在要排序的一组数中，假设前面(n-1)[n>=2]个数已经是排好顺序的，现在要把第n个数插到前面的有序数中
 * 使得这n个数也是排好序 的。如此反复循环，直到全部排好序。
 * Author: DeamonCao
 * Creation time: 2016年10月16日 下午5:45:18
 * (C) Copyright 2015-2020, DeamonCao.
 * All rights reserved.
 */
package bh.toolkit.algorithm.sort;

public class InsertSort {
	
	public static int[] insertSort(int a[]){
		int tmp = 0;
		for(int ii = 1 ; ii <a.length ; ii++){
			int jj = ii - 1;
			tmp = a[ii];
			for( ; jj >= 0 && tmp < a[jj] ; jj --){
				a[jj + 1] = a[jj]; // 将大于tmp的值整体后移一个单位
			}
			a[jj + 1] = tmp;
		}
		return a;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,5,17,18,23,34,15,35,25,53,51}; 
		int[] sortArray = InsertSort.insertSort(array);
		for(int ii = 0 ; ii <sortArray.length ; ii ++){
			System.out.println(sortArray[ii]);
		}

	}

}
