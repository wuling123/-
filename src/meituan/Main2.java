package meituan;

import java.util.Scanner;

public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		double[][] a = new double[16][16];
		for (int i = 0; i < 16; i++) {
			for (int j = 0; j < 16; j++) {
				a[i][j] = sc.nextDouble();
			}
		}
		double[] result = new double[16];
		int[] b = new int[8];
		int[] c = new int[4];
		int[] d = new int[2];
		double p1 = 0.0;
		double p2 = 0.0;
		double p3 = 0.0;
		double p4 = 0.0;
		for (int i1 = 0; i1 <= 1; i1++) {
			for (int i2 = 2; i2 <= 3; i2++) {
				for (int i3 = 4; i3 <= 5; i3++) {
					for (int i4 = 6; i4 <= 7; i4++) {
						for (int i5 = 8; i5 <= 9; i5++) {
							for (int i6 = 10; i6 <= 11; i6++) {
								for (int i7 = 12; i7 <= 13; i7++) {
									for (int i8 = 14; i8 <= 15; i8++) {
										p1 = a[i1][i1 == 0 ? 1 : 0] * a[i2][i2 == 2 ? 3 : 2] * a[i3][i3 == 4 ? 5 : 4]
												* a[i4][i4 == 6 ? 7 : 6] * a[i5][i5 == 8 ? 9 : 8]
												* a[i6][i6 == 10 ? 11 : 10] * a[i7][i7 == 12 ? 13 : 12]
												* a[i8][i8 == 14 ? 15 : 14];
										b[0] = i1;
										b[1] = i2;
										b[2] = i3;
										b[3] = i4;
										b[4] = i5;
										b[5] = i6;
										b[6] = i7;
										b[7] = i8;
										for (int j1 = 0; j1 <= 1; j1++) {
											for (int j2 = 2; j2 <= 3; j2++) {
												for (int j3 = 4; j3 <= 5; j3++) {
													for (int j4 = 6; j4 <= 7; j4++) {
														p2 = a[b[j1]][b[j1] == i1 ? i2 : i1]
																* a[b[j2]][b[j2] == i3 ? i4 : i3]
																* a[b[j3]][b[j3] == i5 ? i6 : i5]
																* a[b[j4]][b[j4] == i7 ? i8 : i7];
														c[0] = b[j1];
														c[1] = b[j2];
														c[2] = b[j3];
														c[3] = b[j4];
														for (int k1 = 0; k1 <= 1; k1++) {
															for (int k2 = 2; k2 <= 3; k2++) {
																p3 = a[c[k1]][c[k1] == b[j1] ? b[j2] : b[j1]]
																		* a[c[k2]][c[k2] == b[j3] ? b[j4] : b[j3]];
																d[0] = c[k1];
																d[1] = c[k2];
																for (int m1 = 0; m1 <= 1; m1++) {
																	p4 = a[d[m1]][d[m1] == c[k1] ? c[k2] : c[k1]];
																	result[d[m1]] += p1 * p2 * p3 * p4;
																}
															}
														}
													}
												}
											}
										}
									}

								}
							}
						}
					}
				}
			}
		}
		for (int i = 0; i < 16; i++) {
			if (i <= 14)
				System.out.print(result[i] + " ");
			else
				System.out.print(result[i]);
		}
		sc.close();
	}

}
