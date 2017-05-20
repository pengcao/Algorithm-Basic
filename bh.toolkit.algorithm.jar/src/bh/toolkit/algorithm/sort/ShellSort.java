/**
 * Description: 希尔排序（最小增量排序）
 * 基本思想：算法先将要排序的一组数按某个增量d（n/2,n为要排序数的个数）分成若干组，每组中记录的下标相差d.对每组中全部元素进行直接插入排序，
 * 然后再用一个较小的增量（d/2）对它进行分组，在每组中再进行直接插入排序。当增量减到1时，进行直接插入排序后，排序完成。
 * Author: DeamonCao
 * Creation time: 2016年10月16日 下午5:45:18
 * (C) Copyright 2015-2020, DeamonCao.
 * All rights reserved.
 */
package bh.toolkit.algorithm.sort;

public class ShellSort {
	
	/**
	 * 
	 * Description: 这个shell排序的时间复杂度不是很好
	 * Author: caopeng
	 * Creation time: 2016年10月11日 下午9:48:29
	 *
	 * @param a
	 * @return
	 */
	public static int[] shellSortThree(int a[]){
		
		double d1 = a.length;
		int tmp = 0;
		
		while(true){
			d1 = Math.ceil(d1/2);
			int d = (int) d1;
			for(int xx = 0 ; xx < d ; xx++){
				for(int ii = xx+d; ii < a.length ; ii+=d){
					int jj = ii - d;
					tmp = a[ii];
					for(;jj >=0&&tmp<a[jj]; jj-=d){
						a[jj+d] = a[jj];
					}
					a[jj+d]=tmp;
				}
			}
			if(d==1){
				break;
			}
		}		
		return a;		
	}
	
	/**
	 * 
	 * Description: shellSortTwo相对于shellSortThree要快一些
	 * Author: caopeng
	 * Creation time: 2016年10月11日 下午9:57:14
	 *
	 * @param arr
	 * @return
	 */
	public static int[] shellSortTwo(int arr[]){
				
	    int ii, jj, d;
	    int tmp;
	    int n = arr.length;
	    for (d = n / 2; d > 0; d /= 2){
	        for (ii = d; ii < n; ii++){
	            tmp = arr[ii];
	            for (jj = ii; jj >= d; jj -= d){
	                if (arr[jj - d] > tmp){
	                	arr[jj] = arr[jj - d];
	                }else{
	                	break;
	                }	                    
	            }
	            arr[jj] = tmp;
	        }
	    }			
		return arr;		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int array[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,5,17,18,23,34,15,35,25,53,51}; 
		int[] sortArray = ShellSort.shellSortTwo(array);
		for(int ii = 0 ; ii <sortArray.length ; ii ++){
			System.out.println(sortArray[ii]);
		}
	}
}
