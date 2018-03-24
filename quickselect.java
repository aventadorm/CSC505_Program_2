import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class quickselect {

	int partition(int arr[], int a, int b){
		int pivot = 0;

		//Pivot Selection
		if((b-a+1) < 9){
			pivot = arr[a];
		}else {
			int middle = (b-a)/2;

			int temp[] = {arr[a], arr[b], arr[middle]};
			Arrays.sort(temp);
			pivot = temp[1];
		}

		//Quicksort begins

		int i = a - 1;
		for(int j = a; j < b; j++){
			if(arr[j] <= pivot){
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		int temp = arr[i+1];
		arr[i+1] = arr[b];
		arr[b] = temp;
		return i+1;

	}

	int quickselect(int arr[], int a, int b){
		int medianIndex = (arr.length+1)/2;
		System.err.println(a + " vs " + b);
		if(a <= b){
			int index = partition(arr, a, b);
			if(index == (medianIndex)){
				return index;
			} else if(index > medianIndex){
				return quickselect(arr, a, index - 1);
			}else{
				return quickselect(arr, index + 1, b);
			}

		}
		System.err.println(a + " > " + b);
		return -1;

	}
	public static void main(String args[])
	{
		Scanner inputScanner = new Scanner(System.in);
		ArrayList <Integer> input = new ArrayList<Integer>();
		int n = 0;
		while (inputScanner.hasNext()){
			input.add(new Integer(inputScanner.nextInt()));
			n++;
		}
		inputScanner.close();

		int[] arr = new int[n];
		int i = 0;
		for(Integer intobject : input){
			arr[i++] = intobject.intValue();
		}
		System.err.println(arr);

		quickselect qs = new quickselect();
		System.err.println("n : " + n);
		int answer = qs.quickselect(arr, 0, n-1);
		//int answer = quickselect(arr, 0, n-1);
		System.err.println("index," + answer);
		System.err.println("aaju," + arr[answer-1]);
		System.err.println("baju," + arr[answer+1]);
		System.out.println("median," + arr[answer]);

	}



}
