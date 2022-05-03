/**
 * Alipay.com Inc.
 * Copyright (c) 2004-2022 All Rights Reserved.
 */
package datastructures.arrays;

/**
 * @author wb-ujjwalgup584692
 * @version $Id: PrintSubarrays.java, v 0.1 2022-05-02 12:59 wb-ujjwalgup584692 Exp $$
 */
public class PrintSubarrays {


    static void printSubarrays(int [] arr){
        for(int i=0; i<arr.length; i++){
            for(int j=i; j<arr.length; j++){
                System.out.println(arr[j]);
            }
        }
    }

    public static void main(String[] args) {

    }
}
