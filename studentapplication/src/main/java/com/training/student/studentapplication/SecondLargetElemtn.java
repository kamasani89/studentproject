package com.training.student.studentapplication;

import java.util.Arrays;

public class SecondLargetElemtn {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int first =0;
		int second =0;
		int arr[]= {22,44,33,66,55,66,11};
		Arrays.parallelSort(arr);
		for(int i = arr.length-1;i>=0;i--) {
			if(arr[i]>=first) {
				first = arr[i];
			}else if(arr[i]>second && second!=first) {
				second = arr[i];
				break;
			}
		}
		System.out.println(second);
		
	}

}
