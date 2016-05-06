package com.min.job;
import java.util.Scanner;
/**
	教师信息管理系统
	管理教师信息的（增删改查）
	单个教师信息保存	
	所有的学生信息保存--->数组
*/
public class Tms
{
	private Teacher[] tcs = new Teacher[4];		//用于保存教师对象
	private int index;	//记录数组中教师的人数
	/**
	* 添加教师信息
	   save 
	   tcs[0] = tc;  index = 1
		 tcs[1] = tc;  index = 2
		 tcs[2] = tc;  index = 3
		 tcs[3]
	*/
	public void save(Teacher teacher）
		{
			if(index >=tcs.length)
			{
				//数组的扩展 
				Teacher[] demo = new Teacher[tcs.length+3];
				System.arraycopy(tcs,0,demo,0,index);
				tcs = demo;
			}
		tcs[index++] = teacher;
	}
	/**
	*修改教师信息
	 */
	public void update(Teacher teacher)
	{
		for(int i=0;i<index;i++)			
		{
			if(teacher.getId()==tcs[i].getId())
				
			{
				tcs[i].setName(teacher.getName());
			}
		}

	}

	/**
	 *删除教师信息
	 1001 Army1
	1003 Army2
	 1004 Army3
	 null
	 */
    public void deleteById(long id)
		
	{
		int num=getIndexById(id);
		for(int i=num;i<index-1;i++)
			
		{
			tcs[i]=tcs[i+1];
		}
		tcs[--index]=null;
	}

	/**
	 *查询所有教师信息
	 */
	public Teacher[] queryAll(){
		Teacher[] demo = new Teacher[index];
		System.arraycopy(tcs,0,demo,0,index);
		return demo;
	}

	/**
	 *通过id查找教师信息
	 */
	public Teacher queryById(long id){
		int num = getIndexById(id);
		return num==-1?null:tcs[num];
	}

	/**
	 根据教师对象的id获取该教师对象在数组中的索引
	 tcs = new Teacher[3];
	 1001 Army1
	 1002 Army2
	 null 
	 1002
	*/
	private int getIndexById(long id){
		int num = -1;
		for(int i=0;i<index;i++){
			if(tcs[i].getId() == id){
				num = i;
				break;
			}
		}
		return num;
	}

	/**
	 * 可视化查询菜单
  	 */
	public void menu()
	{
		System.out.println("********教师信息管理系统********");
		System.out.println("*1 查询所有教师信息");
		System.out.println("*2 录入教师信息");
		System.out.println("*3 删除教师信息");
		System.out.println("*4 通过id查找教师信息");
		System.out.println("*5 修改教师信息");
		System.out.println("*exit 退出系统！");
		System.out.println("*help 帮助");
		System.out.println("********************************");
	}

	public static void main(String[] args)
		{
		Tms tms = new Tms();
		tms.menu();
		//扫描器对象
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("*请输入对应指令:");
			String option = sc.nextLine();
			switch(option)
			{
				case "1":	//查询所有
					System.out.println("以下是所有教师的信息：");
					Teacher[] tcs = tms.queryAll();
					for(Teacher tc : tcs)
					{
						System.out.println(tc);
					}
					System.out.println("总共查询到"+tms.index+"个教师");
					break;
				case "2":	//录入
					while(true)
					{
						System.out.println("请输入教师的信息【id#name#age#course】或输入【break】返回上一级目录");
						String tcStr = sc.nextLine();
						if(tcStr.equals("break")){
							break;//返回到上一级目录
					}
						
					String[] tcArr = tcStr.split("#");
					//将数组中个元素转换为教师属性所需要的数据类型
					long id  = Long.parseLong(tcArr[0]);
					String name = tcArr[1];
					int age = Integer.parseInt(tcArr[2]);
					String course=tcArr[3];
					//封装对象
					Teacher tc = new Teacher(id,name,age,course);
					tms.save(tc);
					System.out.println("保存成功！");
					}
					break;
				case "3":	//删除
					while(true)
					{
						System.out.println("请输入要删除教师的id,或者输入break返回上一级目录");
						String idStr = sc.nextLine();
						if(idStr.equals("break"))
						{
							break;
						}
						long id = Long.parseLong(idStr);
						Teacher tc=tms.queryById(id);
						if(tc==null)
							
						{
							System.out.println("您要删除的用户不存在");
							continue;
						}
						tms.deleteById(id);
						System.out.println("删除成功！");
						/*
						int num = tms.deleteById(id);
						System.out.println(num==0?"删除失败":"删除成功！当前教师个数为"+tms.index);
						*/
					}	
					break;
				case "4":	//通过id获取
					while(true)
					{
						System.out.println("请输入要查找教师的id,或者输入break返回上一级目录");
						String idStr = sc.nextLine();
						if(idStr.equals("break"))
						{
							break;
						}
						long id = Long.parseLong(idStr);
						Teacher tc = tms.queryById(id);
						System.out.println(tc==null?"sorry,not found!":tc);
					}	
					break;
				case "5":	//修改
					while(true)
					{
						System.out.println("请输入要修改教师的id,或者输入break返回上一级目录");
						String idStr = sc.nextLine();
						if(idStr.equals("break"))
						{
							break;
						}
						long id = Long.parseLong(idStr);
						Teacher tc=tms.queryById(id);
						if(tc==null)					
						{
							System.out.println("您要修改的用户不存在");
							continue;
						}
						System.out.println("原信息为："+tc);
						System.out.println("请输入新信息【id#name#age#course】");
						String str=sc.nextLine();
						String[] tcArr=str.split("#");
						String name=tcArr[0];
						String course=tcArr[1];
						int age=Integer.parseInt(tcArr[1]);
						Teacher newTc=new Teacher(id,name,age,course);
						tms.update(newTc);
						System.out.println("修改成功！");
					}
					break;

				case "exit":
					System.out.println("Bye Bye,欢迎再次使用！");
					System.exit(0);
				case "help":
					tms.menu();
					break;
				default:
					System.out.println("输入错误！");

			}
		}
	}
}