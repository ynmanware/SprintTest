package com.myn.general.anything;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SortingMakesFaster
{
    public static void main(String[] args)
    {
       testArrayList(args);
    }

    public static void testArrayList(String[] args)
    {
        // Generate data
        int arraySize = 32768;
        List<Integer> data = new ArrayList<Integer>();

        Random rnd = new Random(0);
        for (int c = 0; c < arraySize; ++c)
            data.add(rnd.nextInt() % 256);

        // !!! With this, the next loop runs faster
        long start = System.nanoTime();
        long sum = 0;

        Collections.sort(data);

        // Test
        for (int i = 0; i < 100000; ++i)
        {
            // Primary loop
            for (int c = 0; c < arraySize; ++c)
            {
                if (data.get(c) >= 128)
                    sum += data.get(c);
            }
        }

        System.out.println((System.nanoTime() - start) / 1000000000.0);
        System.out.println("sum = " + sum);
    }
    
    public static void testArray(String[] args)
    {
        // Generate data
        int arraySize = 32768;
        int data[] = new int[arraySize];

        Random rnd = new Random(0);
        for (int c = 0; c < arraySize; ++c)
            data[c] = rnd.nextInt() % 256;

        // !!! With this, the next loop runs faster
        long start = System.nanoTime();
        long sum = 0;

        Arrays.sort(data);

        // Test
        for (int i = 0; i < 100000; ++i)
        {
            // Primary loop
            for (int c = 0; c < arraySize; ++c)
            {
                if (data[c] >= 128)
                    sum += data[c];
            }
        }

        System.out.println((System.nanoTime() - start) / 1000000000.0);
        System.out.println("sum = " + sum);
    }    
}