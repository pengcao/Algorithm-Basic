/**
 * Description: 冒泡排序
 * 基本思想：在要排序的一组数中，对当前还未排好序的范围内的全部数，自上而下对相邻的两个数依次进行比较和调整，让较大的数往下沉，较小的往上冒。
 * 即：每当两相邻的数比较后发现它们的排序与排序要求相反时，就将它们互换。
 * Author: DeamonCao
 * Creation time: 2016年10月16日 下午5:45:18
 * (C) Copyright 2015-2020, DeamonCao.
 * All rights reserved.
 */
package bh.toolkit.algorithm.sort;

public class BubbleSort {
	
	public static int[] bubleSort(int[] array){
		int tmp = 0;
		for(int ii = 0 ; ii < array.length-1 ; ii ++ ){
			for(int jj = 0 ; jj <array.length - 1 ; jj ++){
				if(array[jj] > array[jj + 1]){
					tmp = array[jj];
					array[jj] = array[jj+1];
					array[jj+1] = tmp;
				}
			}
		}
		return array;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,5,17,18,23,34,15,35,25,53,51}; 
		int[] sortArray = BubbleSort.bubleSort(array);
		for(int ii = 0 ; ii <sortArray.length ; ii ++){
			System.out.println(sortArray[ii]);
		}
	}

}	
