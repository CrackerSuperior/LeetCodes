package com.Cracker.Test;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Demo
 * @Description TODO
 * @Author Cracker
 * @Date 2021/3/20 14:12
 */
public class Demo {

    public static String[] diff(String[] strings1,String[] strings2){
        String[] strings = new String[strings1.length];
        int num = 0;
        for (int i = 1; i < strings1.length; i++) {
            if(!strings1[i].equals(strings2[i]) && !"#".equals(strings1[i]) && !"#".equals(strings2[i])){
                strings[num++] = "modify" + "-" + i;
            }
            if (!strings1[i].equals(strings2[i]) && "#".equals(strings1[i]) && !"#".equals(strings2[i])){
                strings[num++] = "add" + "-" + i;
            }
            if (!strings1[i].equals(strings2[i]) && !"#".equals(strings1[i]) && "#".equals(strings2[i])){
                strings[num++] = "delete" + "-" + i;
            }

        }
        return strings;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String string1 = scanner.nextLine();
        String[] strings1 = string1.split(",");

        String string2 = scanner.nextLine();
        String[] strings2 = string2.split(",");

        int x = Integer.parseInt(strings1[strings1.length - 1].substring(0,1)) + 1;
        int y = Integer.parseInt(strings2[strings2.length - 1].substring(0,1)) + 1;

        String[] result1 = new String[x > y ? x : y];
        String[] result2 = new String[x > y ? x : y];

        for (int i = 0; i < result1.length; i++) {
            result1[i] = "#";
        }
        for (int i = 0; i < result2.length; i++) {
            result2[i] = "#";
        }

        for (int i = 0;i < strings1.length;i++){
            result1[Integer.parseInt(strings1[i].substring(0,1))] = strings1[i].substring(2);
        }

        for (int i = 0;i < strings2.length;i++){
            result2[Integer.parseInt(strings2[i].substring(0,1))] = strings2[i].substring(2);
        }

        String[] diff = diff(result1, result2);

        //System.out.println(Arrays.toString(diff));
        String s = new String();
        for (int i = 0; i < diff.length - 1; i++) {
            s = "" +  s +  diff[i] + ",";
        }
        s = s.substring(0,s.length() - 1);
        System.out.println(s);

    }

}
