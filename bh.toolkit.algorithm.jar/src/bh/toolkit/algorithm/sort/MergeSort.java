/**
 * Description: 归并（Merge）排序法是将两个（或两个以上）有序表合并成一个新的有序表，即把待排序序列分为若干个子序列，每个子序列是有序的。然后再把有序子序列合并为整体有序序列
 * Author: DeamonCao
 * Creation time: 2016年10月16日 下午5:45:18
 * (C) Copyright 2015-2020, DeamonCao.
 * All rights reserved.
 */
package bh.toolkit.algorithm.sort;

public class MergeSort {
	
	public static void mergeSort(int[] array){
		sort(array, 0, array.length-1);
	}
	
	public static void sort(int[] array,int left,int right){
		if(left<right){
			//找出中间索引
			int center = (left+right)/2;
			//对左边数组进行递归
			sort(array,left,center);
			//对右边数组进行递归
			sort(array, center+1, right);
			//合并
			merge(array, left, center, right);
		}
	}
	
	/**
	 * 
	 * Description: 将两个数组进行归并，归并前面2个数组已有序，归并后依然有序
	 * Author: caopeng
	 * Creation time: 2016年10月15日 下午10:57:41
	 *
	 * @param array
	 * @param left 左数组的第一个元素的索引
	 * @param center 左数组的最后一个元素的索引，center+1是右数组第一个元素的索引
	 * @param right  右数组最后一个元素的索引 
	 */
	public static void merge(int[] array,int left,int center,int right){
		//临时数组
		int[] tmpArray = new int[array.length];
		//右数组第一个元素索引
		int mid = center + 1;
		//third记录临时数组的索引
		int third = left;
		//缓存左数组第一个元素的索引
		int tmp = left;
		while(left<=center&&mid<=right){
			//从两个数组中取出最小的放入中间数组
			if(array[left]<=array[mid]){
				tmpArray[third++] = array[left++];
			}else{
				tmpArray[third++] = array[mid++];
			}
		}
		//剩余部分依次放入临时数组（实际上两个while只会执行其中一个）
		while(mid<=right){
			tmpArray[third++] = array[mid++];
		}
		
		while(left<=center){
			tmpArray[third++] = array[left++];
		}
		
		//将临时数组中的内容拷贝回原数组中
		//(原left-right范围的内容被复制回原数组)
		while(tmp<=right){
			array[tmp] = tmpArray[tmp++];
		}		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,5,17,18,23,34,15,35,25,53,51}; 
		MergeSort.mergeSort(array);
		for(int ii = 0 ; ii <array.length ; ii ++){
			System.out.println(array[ii]);
		}

	}

}
