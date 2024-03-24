package bubbleSort;
import java.util.*;
public class First {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		 -selection sort is used to find that largest number and place it at correct index
		 -time complexity-bigo(n2)
		 -best case-bigo(n2)
		 */
		int[] arr= {3,8,5,9,0,1};
		selection(arr);
		System.out.println(Arrays.toString(arr));
		
	}

	static void selection(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			//find max element in remaining array to swap 
			int last=arr.length-i-1;
			int maxIndex=getMaxIndex(arr,0,last);
			swap(arr,maxIndex,last);
		}
		}
		public static int getMaxIndex(int[] arr,int start,int end) {
			int max=start;
			for(int i=start;i<=end;i++) {
				if(arr[max]<arr[i])
					max=i;
			}
			return max;
			
		}
		public static void swap(int[] arr,int first,int second) {
			int temp=arr[first];
			arr[first]=arr[second];
			arr[second]=temp;
			
		}

}
