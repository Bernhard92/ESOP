package sheet3;

import java.util.Arrays;
import java.util.Scanner;

public class Ex3 {

	public static void main(String[] args) {
		Ex3 instance = new Ex3();
		// 1
		instance.a1i();
		instance.a1ii(5);
		instance.a1iii(new int[] { 1, 2, 3 });
		instance.a1iv('a', new int[] { 1, 2, 3 });

		// 2
		int res = instance.addition(2, 4, 6);

		// 3
		int a3 = instance.m1(2);

		// 4
		int a4 = 5;
		System.out.println("In main: " + a4);
		instance.add(a4);
		System.out.println("In main: " + a4);

		// 5
		int[] arr = new int[] { 1, 2, 0 };
		System.out.println("In main: " + Arrays.toString(arr));
		instance.add2(arr);
		System.out.println("In main: " + Arrays.toString(arr));

		// 6
		System.out.println(Arrays.toString(instance.teilArray(new int[] { 1, 2, 3, 4, 5, 6 }, 4)));
		System.out.println(instance.teilt(6, 2));
		System.out.println(instance.teilt(6, 4));

		// 7
		double p = 4.25;
		double q = 2.50;
		double res2 = instance.divide(p, q);
		System.out.println(res2);

		// 8
		System.out.println(instance.isPrime(7));

		// 9
		int n = 5;
		int i = 0;
		int zahl = 1;
		while (i < n) {
			if (instance.isPrime(zahl)) {
				System.out.println("Prime: " + zahl);
				i++;
			}
			zahl++;
		}

		// 10
		int n2 = 4;
		int i2 = 0;
		int zahl2 = 1;
		while (i2 < n2) {
			if (instance.isPerfect(zahl2)) {
				System.out.println("Perfect: " + zahl2);
				i2++;
			}
			zahl2++;
		}

		// 11
		System.out.println(instance.faculty(1));
		System.out.println(instance.faculty(2));
		System.out.println(instance.faculty(3));
		System.out.println(instance.faculty(4));
		System.out.println(instance.faculty(5));

		// 12
		// int[]arr2 = instance.giveArray(5);
		// System.out.println(Arrays.toString(arr2));

		// 13
		instance.print2DArray(new int[][] { { 1, 2, 3 }, { 4, 5, 6 } });

		// 14
		int[] diagonal = instance.diagonale(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } });
		System.out.println(Arrays.toString(diagonal));

		// 15
		System.out.println(
				Arrays.toString(instance.convert2DTo1D(new int[][] { { 2, 0, 7, 5 }, { 5, 9, 5, 8, 6 }, { 1, 2 } })));
		
		//16
		instance.print2DArray(instance.transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }}));
		
		//17
		

	}

	/*
	 * Aufgabe 1
	 */
	private void a1i() {
	}

	private void a1ii(int a) {
	}

	private void a1iii(int[] arr) {
	}

	private void a1iv(char c, int[] arr) {
	}

	/*
	 * Aufgabe 2
	 */
	private int addition(int a, int b, int c) {
		return a + b + c;
	}

	/*
	 * Aufgabe 3
	 */
	private int m1(int zahl) {
		return 2 * m2(zahl);
	}

	private int m2(int zahl) {
		return zahl * zahl;
	}

	/*
	 * Aufgabe 4
	 */
	private int add(int zahl) {
		System.out.println("In function: " + zahl);
		zahl++;
		System.out.println("In function: " + zahl);
		return zahl;
	}

	/*
	 * Aufgabe 5
	 */
	private void add2(int[] arr) {
		System.out.println("In function: " + Arrays.toString(arr));
		arr[2] = arr[0] + arr[1];
		System.out.println("In function: " + Arrays.toString(arr));
	}

	/*
	 * Aufgabe 6
	 */
	private int[] teilArray(int[] arr, int a) {
		int[] res = new int[a];
		for (int i = 0; i < a; i++) {
			res[i] = arr[i];
		}
		return res;
	}

	private boolean teilt(int p, int q) {
		return p % q == 0;
	}

	/*
	 * Aufgabe 7
	 */
	private double divide(double p, double q) {
		return p / q;
	}

	/*
	 * Aufgabe 8
	 * 
	 */
	private boolean isPrime(int z) {
		boolean prime = true;

		if (z == 0 || z == 1)
			prime = false;
		for (int i = 2; i <= (z / 2); i++) {
			if (teilt(z, i))
				prime = false;
		}
		return prime;
	}

	/*
	 * Aufgabe 10
	 * 
	 */
	private boolean isPerfect(int z) {
		int sum = 0;

		for (int i = 1; i < z; i++) {
			if (z % i == 0) {
				sum += i;
			}
		}
		return (sum == z);
	}

	/*
	 * Aufgabe 11
	 */
	private long faculty(int n) {
		long res = 1;

		for (int i = 2; i <= n; i++) {
			res *= i;
		}
		return res;
	}

	/*
	 * Aufgbabe 12
	 */
	private int[] giveArray(int n) {
		int[] res = new int[n];
		System.out.println("Insert a number: ");
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < n; i++) {
			res[i] = sc.nextInt();
		}
		return res;
	}

	/*
	 * Aufgabe 13
	 */
	private void print2DArray(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}

	/*
	 * Aufgabe 14
	 */
	private int[] diagonale(int[][] matrix) {
		int[] res = new int[matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			res[i] = matrix[i][i];
		}
		return res;
	}

	/*
	 * Aufgabe 15
	 */
	private int[] convert2DTo1D(int[][] mat) {
		int length = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				length++;
			}
		}
		int[] res = new int[length];
		int c = 0;
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				res[c++] = mat[i][j];
			}
		}
		return res;
	}

	/*
	 * Aufgabe 16
	 */
	private int[][] transpose(int[][] mat) {
		int[][] res = new int[mat.length][mat.length];
		
		for (int i = 0; i < mat.length; i++) {
			for (int j = 0; j < mat[i].length; j++) {
				res[j][i] = mat[i][j];
			}
		}
		return res;
	}
	
	/*
	 * Aufgabe 17
	 */
	private int[] durchschnitt(int[]p, int[]q) {
		for (int i = 0; i < p.length; i++) {
			for(int j = 0; j < q.length; j++) {
		}
	}
}
