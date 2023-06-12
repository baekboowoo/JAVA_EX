package JAVAEX;

import java.util.Scanner;

public class TESTSTAR {

	    public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.print("높이를 입력하세요: ");
	        int height = scanner.nextInt();

	        int i = 0;
	        while (i < height) {
	            int j = height - 1;
	            while (j > i) {
	                System.out.print(" ");
	                j--;
	            }

	            int k = 0;
	            while (k < i * 2 + 1) {
	                System.out.print("*");
	                k++;
	            }

	            System.out.println();
	            i++;
	        }
	    }
	}
