package com.revature.P1Demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;

@SpringBootApplication
@EntityScan("com.revature.models") //This tells Spring Boot to look in the models package for DB entities
@ComponentScan("com.revature") //This tells Spring Boot to look in com.revature for Beans (stereotype annotations)
@EnableJpaRepositories("com.revature.daos") //This tells Spring Boot to look in the daos package for JPARepositories
public class P1DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(P1DemoApplication.class, args);

	}

	//example bubble sort--------------------- try it on your own!

	public class BubbleSort {

		public static void bubbleSort(int[] arr) {

			int n = arr.length; //gives the number of elements (which will be 1 too high for the index)

			// Outer loop for passes
			for (int i = 0; i < n - 1; i++) {
				boolean swapped = false; // To optimize when array is already sorted

				// Inner loop for comparing adjacent elements
				for (int j = 0; j < n - i - 1; j++) {
					if (arr[j] > arr[j + 1]) {
						// Swap arr[j] and arr[j + 1]
						int temp = arr[j];
						arr[j] = arr[j + 1];
						arr[j + 1] = temp;

						swapped = true;
					}
				}

				// If no swaps were made, the array is already sorted
				if (!swapped) break;
			}
		}

//		public static void main(String[] args) {
//			int[] arr = {5, 3, 8, 4, 2};
//
//			System.out.println("Original Array:");
//			printArray(arr);
//
//			bubbleSort(arr);
//
//			System.out.println("\nSorted Array:");
//			printArray(arr);
//		}

		// Utility method to print an array
		public static void printArray(int[] arr) {
			for (int num : arr) {
				System.out.print(num + " ");
			}
			System.out.println();
		}
	}

}
