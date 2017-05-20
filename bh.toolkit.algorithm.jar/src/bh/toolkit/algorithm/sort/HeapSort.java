/**
 * Description: 
 * Author: DeamonCao
 * Creation time: 2016年10月16日 下午5:45:18
 * (C) Copyright 2015-2020, DeamonCao.
 * All rights reserved.
 */
package bh.toolkit.algorithm.sort;

public class HeapSort {
	
	public static int[] heapSort(int[] array){
		int size = array.length;
		//循环建堆
		for(int ii = 0 ; ii < size - 1 ; ii++){
			//建堆
			buildMaxHaep(array,size-1-ii);
			swap(array,0,size-1-ii);
		}
		return array;
	}	


	public static void swap(int[] array,int ii,int jj){
		int tmp = array[ii];
		array[ii] = array[jj];
		array[jj] = tmp;
	}
	
	
	/**
	 * 
	 * Description: 对array数组从0到lastIndex建大顶堆
	 * Author: caopeng
	 * Creation time: 2016年10月12日 下午9:49:51
	 *
	 * @param array
	 * @param lastIndex
	 */
	public static void buildMaxHaep(int[] array,int lastIndex){
		
		//从lastIndex处节点（最后一个节点）的父节点开始
		for(int ii = (lastIndex-1)/2 ; ii >=0 ; ii--){
			//k保存正在判断的节点
			int k = ii;
			//如果当前k节点的子节点存在
			while(k*2+1 <= lastIndex){
				//k节点的左子节点的索引
				int biggerIndex = 2*k + 1;
				//如果biggerIndex小于lastIndex，即biggerIndex+1代表的k节点的右子节点存在
				if(biggerIndex < lastIndex){
					//如果右子节点的值比较大
					if(array[biggerIndex] < array[biggerIndex + 1]){
						//biggerIndex总是记录较大子节点的索引
						biggerIndex ++;
					}
				}
				
				//如果k节点的值小于其较大的子节点的值
				if(array[k] < array[biggerIndex]){
					//交换他们
					swap(array, k, biggerIndex);
					//将biggerIndex赋予k，开始while循环的下一次循环，重新保证k节点的值大于其左右子节点的值  
					k = biggerIndex;
				}else{
					break;
				}
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int array[] = {49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,5,17,18,23,34,15,35,25,53,51}; 
		int[] sortArray = HeapSort.heapSort(array);
		for(int ii = 0 ; ii <sortArray.length ; ii ++){
			System.out.println(sortArray[ii]);
		}


	}

}
