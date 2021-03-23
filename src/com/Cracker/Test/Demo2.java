package com.Cracker.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @ClassName Demo2
 * @Description TODO
 * @Author Cracker
 * @Date 2021/3/20 15:24
 */
public class Demo2 {


    public static int payTime(int[] array1,int[] array2){

        int time = 0;
        int temp = array1[0];
        for (int i = 0; i < array1.length; i++) {
            if(temp == array1[i]){
                time += array2[i];
                temp += array2[i];
            }else {
                time += temp - array1[i] + array2[i];
            }

        }
        return time;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int num = scanner.nextInt();

        int[] ints1 = new int[num];
        int[] ints2 = new int[num];

        String[] strings = new String[num];

        for (int i = 0; i < num; i++) {
            strings[i] = scanner.next();
        }


        for (int i = 0; i < num; i++) {
            ints1[i] = Integer.parseInt(strings[i].substring(0,1));
            ints2[i] = Integer.parseInt(strings[i].substring(2));
        }

        //System.out.println(Arrays.toString(ints1));

        System.out.println(payTime(ints1,ints2));

    }

}
