/**
 * Description: 本思想：在要排序的一组数中，选出最小的一个数与第一个位置的数交换；
 * 然后在剩下的数当中再找最小的与第二个位置的数交换，如此循环到倒数第二个数和最后一个数比较为止。
 * Author: DeamonCao
 * Creation time: 2016年10月16日 下午5:45:18
 * (C) Copyright 2015-2020, DeamonCao.
 * All rights reserved.
 */
package bh.toolkit.algorithm.sort;

public class SelectSort {
	
	public static int[] selectSort(int array[]){
		int position = 0;
		for(int ii = 0 ; ii < array.length ; ii ++ ){
			int jj = ii + 1;
			position = ii;
			int tmp = array[ii];
			for(;jj<array.length;jj++){
				if(array[jj] < tmp){
					tmp = array[jj];
					position = jj;
				}
			}
			array[position] = array[ii];
			array[ii] = tmp;
		}
		return array;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,5,17,18,23,34,15,35,25,53,51}; 
		int[] sortArray = SelectSort.selectSort(array);
		for(int ii = 0 ; ii <sortArray.length ; ii ++){
			System.out.println(sortArray[ii]);
		}
	}

}
