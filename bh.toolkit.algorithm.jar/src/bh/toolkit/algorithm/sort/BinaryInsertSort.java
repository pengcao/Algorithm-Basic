/**
 * Description: 折半插入排序法，又称二分插入排序法，是直接插入排序法的改良版，也需要执行i-1趟插入，不同之处在于，第i趟插入，先找出第i+1个元素应该插入的的位置，假定前i个数据是已经处于有序状态。
 * Author: DeamonCao
 * Creation time: 2016年10月16日 下午5:45:18
 * (C) Copyright 2015-2020, DeamonCao.
 * All rights reserved.
 */
package bh.toolkit.algorithm.sort;

public class BinaryInsertSort {
	
	public static void binaryInsertSort(int[] array){
		for(int ii = 1; ii<array.length ;ii++){
			if(array[ii] < array[ii-1]){
				//缓存ii处的元素
				int tmp = array[ii];
				//记录搜索范围的左边界
				int low = 0;
				//记录搜索范围的右边界
				int high = ii - 1;
				while(low <= high){
					//记录中间位置
					int mid = (low + high)/2;
					//比较中间位置数据和i处数据大小，以缩小搜索范围
					if(array[mid] < tmp){
						low = mid + 1;
					}else{
						high = mid - 1;
					}
				}
				//将low~i处数据整体向后移动1位
				for(int jj = ii;jj> low;jj--){
					array[jj] = array[jj - 1];
				}
				array[low] = tmp;
				
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {49,38,65,0,97,76,13,27,49,78,34,12,1,10000000,64,5,4,62,99,98,54,56,5,17,18,23,34,15,35,25,53,51}; 
		 
		BinaryInsertSort.binaryInsertSort(array);
		for(int ii = 0 ; ii <array.length ; ii ++){
			System.out.println(array[ii]);
		}

	}

}
