package com.greatlearning.main;

import java.util.Stack;
import java.util.HashMap;
import java.util.Scanner;

public class Skyscraper {
	
	public static void main (String args[])
	{
		Stack <Integer> l_stack = new Stack<>();
		int l_value = 0;
		boolean l_flag = false;
		Scanner scanner = new Scanner(System.in);
		
		HashMap<Integer, Integer> l_map = new HashMap<Integer, Integer>();
		
		System.out.println("enter the total no of floors in the building");
		int l_height = scanner.nextInt();
		
		//int[] l_tempStack;
		
		for(int i=0; i<l_height; i++)
		{
			System.out.println("enter the floor size given on day : "+(i+1));
			l_map.put(i, scanner.nextInt());
		}
		
		System.out.println("");
		System.out.println("The order of construction is as follows");
		System.out.println("");
		
		int l_temph = l_height;
		int l_temp = 0;
		
		for(int i=0; i<l_height; i++)
		{
			if(l_map.get(i) == l_temph)
			{
				l_flag = true;
			}
			if(l_flag)
			{
				l_stack.push(l_map.get(i));
				l_map.put(i, -1);
				l_temph--;
				for(int j=0; j<i; j++)
				{
					for(int k=0; k<i; k++)
					{
						l_temp = (int)l_stack.peek();
						if((l_temp-1) == l_map.get(k))
						{
							l_stack.push(l_map.get(k));
							l_temph--;
							l_map.put(k, -1);
						}
					}
					
				}
			}
			System.out.println("Day: "+(i+1));
			if(l_stack != null && l_flag)
			{
				//int[] l_tempStack;
				//l_tempStack = l_stack.toArray(l_tempStack);
				System.out.println(l_stack.toString().replaceAll("\\[", "").replaceAll("]", "").replaceAll("\\,", ""));
				l_stack.clear();
			}
			else
			{
				System.out.println("");
			}
			l_flag = false;
		}
			
	}

}
