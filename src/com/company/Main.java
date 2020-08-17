package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // write your code here

        Scanner in = new Scanner(System.in);
        int inputOption;
        while (true) {
            System.out.println("Please Select One of the following options");
            System.out.print("Press 1 for getting the Maximum Cycle, 2 for Calculating the period range, or 3 for Exit:  ");
            inputOption = in.nextInt();
            if (inputOption == 3) {
                return;
            }
            int a, c, x0;
            int m;
            System.out.print("Enter value of a : ");
            a = in.nextInt();
            System.out.print("Enter value of c : ");
            c = in.nextInt();
            System.out.print("Enter value of m : ");
            m = in.nextInt();
            // (a*i+c)%m

            if (inputOption == 1) {
                // for getting the Max Cycle
                int seedX = 1;
                int cycles = 0;
                int condition = 0; // 1 for bad seed 2 for good seed

                while (true) {
                    long res[] = new long[m + 1];
                    //List<Long> res2 = new ArrayList<>();
                    res[0] = seedX;
                    // res2.add((long) seedX);
                    int i = 1;
                    while (true) {
                        res[i] = ((res[i - 1] * a) + c) % m;
                        // res2.add(((res2.get(i - 1) * a) + c) % m);
                        cycles++;
                        if (cycles == m - 1) {
                            condition = 2;
                            break;
                        }
                        for (int j = 0; j < res.length - 1; j++) {
                            if (res[i] == res[j]) {
                                //   if (res2.get(j).equals(res2.get(i))) {
                                if (cycles == (m - 1)) {
                                    condition = 2;
                                } else {
                                    condition = 1;
                                }
                                break;
                            }
                        }
                        if (condition == 1 || condition == 2) {
                            break;
                        } else {
                            i++;
                        }
                    }


                    if (condition == 2) {

                        break;

                    } else if (condition == 1) {
                        seedX++;
                    }
                }
                System.out.println(seedX);


            } else if (inputOption == 2) {
                // for calculating the period range of LCG Generators
                System.out.print("Enter value of x0 : ");
                x0 = in.nextInt();
                int i = 1;
                int cycles = 0;
                boolean found = false;
                int[] res = new int[m + 1];
                res[0] = x0;
                while (true) {
                    res[i] = ((res[i - 1] * a) + c) % m;

                    cycles++;
                    for (int j = 0; j < i; j++) {
                        if (res[i] == res[j]) {
                            found = true;
                            break;
                        }
                    }
                    if (found) {
                        System.out.println("Number of cycles is : " + (cycles - 1));
                        break;
                    }
                    i++;

                }
            } else if (inputOption == 3) {
                // to exit the program
                break;
            } else {
                System.out.println("Wrong Choice, Please select from the options below.");
            }
        }
    }
}
