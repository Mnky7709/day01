package com.min.ch02;
import java.util.Scanner;
public class Love
{
	public static void main(String[] args)
		
	{
		System.out.println("******����ħ������******");
		
		while (true)
		{
			System.out.println("�����롾��������#Ů���������������ǵİ���ָ��");
			Scanner sc=new Scanner(System.in);
			String names=sc.nextLine();
			String[] arr=names.split("#");
			int num=(int)(Math.random()*100);
			System.out.println(arr[0]+"��"+arr[1]+"�İ���ָ��Ϊ: "+num);
		}

	}
}