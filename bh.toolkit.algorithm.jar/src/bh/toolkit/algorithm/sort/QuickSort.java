/**
 * Description: 
 * Author: DeamonCao
 * Creation time: 2016年10月16日 下午5:45:18
 * (C) Copyright 2015-2020, DeamonCao.
 * All rights reserved.
 */
package bh.toolkit.algorithm.sort;

public class QuickSort {
	
	public static int getMiddle(int[] array,int low,int high){
		int tmp = array[low]; //将数组中的第一个作为中轴
		while(low < high){
			while(low < high && array[high] >= tmp){
				high--;
			}			
			array[low] = array[high]; // 比中轴小的记录移到低端
			
			
			while(low < high && array[low] <= tmp){
				low++;
			}
			array[high] = array[low]; //比中轴大的记录移到高端			
		}
		array[low] = tmp; // 中轴记录到尾
		return low;  // 返回中轴的位置		
	}
	
	public static void quickSort(int[] array,int low,int high){
		if(low < high){
			int middle = getMiddle(array, low, high);//将array数组进行一分为二
			quickSort(array, low, middle - 1); //对低字表进行递归排序
			quickSort(array, middle + 1, high); //对高字表进行递归排序
		}
	}

	public static void quick(int[] array){
		if(array.length>0){  //查看数组是否为空
			quickSort(array, 0, array.length -1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {49,38,65,97,76,120202,27,49,78,34,12,64,5,4,62,99,98,54,56,5,17,18,23,34,15,35,25,53,51}; 
		quick(array);
		for(int ii = 0 ; ii <array.length ; ii ++){
			System.out.println(array[ii]);
		}

	}

}
