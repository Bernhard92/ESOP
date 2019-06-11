
package sheet3;

import java.util.Arrays;
import java.util.Scanner;

import sheet4.apple.Apfel;

/**
 * @author bejahrer
 *
 */

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

		// 16
		instance.print2DArray(instance.transpose(new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } }));

		// 17
		int[] array1 = new int[] { 1, 2, 3, 4, 5, 6 }; // Hier Werte eintragen bzw. die
		// Methode aus Aufgabe 12 verwenden.
		int[] array2 = new int[] { 4, 5, 6, 7, 8, 9 }; // Hier Werte eintragen bzw. die
		// Methode aus Aufgabe 12 verwenden.
		int[] erg = instance.durchschnitt(array1, array2);
		if (erg == null) {
			System.out.println("Die beiden Arrays haben " + "keine gemeinsamen Elemente");
		} else {
			System.out.println("Die gemeinsamen Elemente beider Arrays: " + Arrays.toString(erg));
		}

		// 18
		int[] a = { 4, 2, 3 };
		int[] b = { 1, 5, 3 };

		int[] a2 = { 3, 1, 3, 5 };
		int[] b2 = { 2, 1, 4, 3 };

		System.out.println(Arrays.toString(instance.sub(instance.mult(a, b), b)));
		System.out.println(Arrays.toString(instance.sub(instance.mult(a2, b2), b2)));

		// 19
		instance.printNumDesc(4);

		// 20
		instance.printHourGlass(3);
		System.out.println();
		instance.printHourGlass(5);

		// 21
		String input = "ESOP ist super!";
		char[] charArr = instance.replaceEverySecondChar(input, 'o');
		System.out.println(Arrays.toString(charArr));

		// 22
		instance.watch();

		// 23
		instance.printChessboard(10);

		// 24
		System.out.println(instance.decToBin(16));

		// 25
		instance.print2DArray(
				instance.slice(new int[][] { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } }));

		// 26
		System.out.println(instance.calcSkalar(new int[] { 2, 8, 3, 4, 5 }, new int[] { 1, 6, 7, 2, 3 }));

		// 27
		System.out.println();
		instance.print2DArray(instance.matrixMult(new int[][] { { 1, 3, 3 }, { 4, 5, 6 } },
				new int[][] { { 1, 0 }, { 2, 2 }, { 0, 1 } }));

		// 28
		System.out.println(
				Arrays.toString(instance.simpleCompress(new int[] { 1, 1, 1, 2, 2, 2, 2, 3, 4, 4, 4, 5, 5, 5 })));

		// 29
		System.out.println(Arrays.toString(instance.simpleDecompress(new int[] { 1, 2, 3, 4, 1, 3, 5, 2, 1 })));

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
	private int[] durchschnitt(int[] p, int[] q) {

		int doublesCount = 0;
		for (int i = 0; i < p.length; i++) {
			for (int j = 0; j < q.length; j++) {
				if (p[i] == q[j])
					doublesCount++;
			}
		}
		if (doublesCount > 0) {
			int[] res = new int[doublesCount];
			int c = 0;
			for (int i = 0; i < p.length; i++) {
				for (int j = 0; j < q.length; j++) {
					if (p[i] == q[j])
						res[c++] = p[i];
				}
			}
			return res;
		}
		return null;
	}

	/*
	 * Aufgabe 18
	 */
	private int[] mult(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			a[i] *= b[i];
		}
		return a;
	}

	private int[] sub(int[] a, int[] b) {
		for (int i = 0; i < a.length; i++) {
			a[i] -= b[i];
		}
		return a;
	}

	/*
	 * Aufgabe 19
	 */
	private void printNumDesc(int n) {
		for (int j = n; j > 0; j--) {
			for (int k = 0; k < j; k++) {
				System.out.print(j);
			}
			System.out.println();
		}
	}

	/*
	 * Aufgabe 20
	 */
	private void printHourGlass(int n) {
		for (int i = 0; i <= n / 2; i++) {
			for (int j = 0; j < i; j++) {
				System.out.print(' ');

			}
			for (int j = i; j < n - i; j++) {
				System.out.print('*');
			}
			System.out.println();
		}
		for (int i = 1; i <= n / 2; i++) {
			for (int j = 0; j < n / 2 - i; j++) {
				System.out.print(' ');

			}
			for (int j = i; j + i >= 0; j--) {
				System.out.print('*');
			}
			System.out.println();
		}

	}

	/*
	 * Aufgabe 21
	 */
	private char[] replaceEverySecondChar(String input, char c) {
		char[] res = input.toCharArray();
		for (int i = 0; i < res.length; i++) {
			if (i % 2 == 0)
				res[i] = c;
		}
		return res;
	}

	/*
	 * Aufgabe 22
	 */
	private void watch() {
		for (int h = 0; h < 24; h++) {
			for (int m = 0; m < 60; m++) {
				System.out.printf("%02d:%02d\n", h, m);
			}
		}
	}

	/*
	 * Aufgabe 23
	 */
	private void printChessboard(int size) {
		for (int i = 1; i <= size; i++) {
			for (int j = 0; j < size; j++) {
				if (i <= 9)
					System.out.print(" ");
				System.out.print(((char) (65 + j)) + "" + i + " ");
			}
			System.out.println();
		}
	}

	/*
	 * Aufgabe 24
	 */
	private String decToBin(int dec) {
		// short way...
		// return Integer.toBinaryString(dec);

		// long way
		if (dec == 0) {
			return "0";
		}
		String binary = "";
		while (dec > 0) {
			int rem = dec % 2;
			binary = rem + binary;
			dec /= 2;
		}
		return binary;
	}

	/*
	 * Aufgabe 25
	 */
	private int[][] slice(int[][] matr) {
		int[][] res = new int[matr.length / 2][matr.length / 2];

		int p = 0;
		for (int i = 0; i < matr.length; i++) {
			int q = 0;
			for (int j = 0; j < matr[i].length; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					res[p][q++] = matr[i][j];
				}

			}
			if (i % 2 == 0)
				p++;
		}
		return res;
	}

	/*
	 * Aufgabe 26
	 */
	private int calcSkalar(int[] vector1, int[] vector2) {
		int res = 0;
		for (int i = 0; i < vector1.length; i++) {
			res += vector1[i] * vector2[i];
		}
		return res;
	}

	/*
	 * Aufgabe 27
	 */
	private int[][] matrixMult(int[][] a, int[][] b) {
		int rowsA = a.length;
		int columnsA = a[0].length;
		int rowsB = b.length;
		int columnsB = b[0].length;

		int[][] res;
		if (columnsA != rowsB) {
			System.out.println("Matric mutliplication not possible");
			return null;
		} else {
			int ia = 0;
			int jb = 0;
			int sum = 0;

			res = new int[rowsA][columnsB];

			for (int i = 0; i < rowsA * columnsB; i++) {
				for (int j = 0; j < columnsA; j++) {
					sum += a[ia][j] * b[j][jb];
				}
				res[ia][jb] = sum;
				sum = 0;
				jb++;
				if (jb == columnsB) {
					jb = 0;
					ia++;
				}
			}
		}
		return res;
	}

	/*
	 * Aufgabe 28
	 */
	private int[] simpleCompress(int[] arr) {
		int c = 1;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] != arr[i - 1])
				c++;
		}
		int[] res = new int[c * 2];
		int i = 0;
		int j = 0;
		int k = 1;
		while (i < arr.length - 1) {
			if (arr[i] != arr[i + 1] || i + 1 == arr.length - 1) {
				res[j++] = arr[i];
				res[j++] = k;
				k = 1;
			}
			i++;
			k++;
		}
		return res;
	}

	/*
	 * Aufgabe 29
	 */
	private int[] simpleDecompress(int[] arr) {
		int end = arr.length;
		if (arr.length % 2 != 0)
			end -= 1;

		int[][] words = new int[end / 2][];
		int k = 0;
		for (int i = 1; i < end; i += 2) {
			int number = arr[i - 1];
			int replicas = arr[i];
			words[k] = new int[replicas];
			for (int j = 0; j < replicas; j++) {
				words[k][j] = number;
			}
			k++;
		}
		return convert2DTo1D(words);

	}

}
