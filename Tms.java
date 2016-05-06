package com.min.job;
import java.util.Scanner;
/**
	��ʦ��Ϣ����ϵͳ
	�����ʦ��Ϣ�ģ���ɾ�Ĳ飩
	������ʦ��Ϣ����	
	���е�ѧ����Ϣ����--->����
*/
public class Tms
{
	private Teacher[] tcs = new Teacher[4];		//���ڱ����ʦ����
	private int index;	//��¼�����н�ʦ������
	/**
	* ��ӽ�ʦ��Ϣ
	   save 
	   tcs[0] = tc;  index = 1
		 tcs[1] = tc;  index = 2
		 tcs[2] = tc;  index = 3
		 tcs[3]
	*/
	public void save(Teacher teacher��
		{
			if(index >=tcs.length)
			{
				//�������չ 
				Teacher[] demo = new Teacher[tcs.length+3];
				System.arraycopy(tcs,0,demo,0,index);
				tcs = demo;
			}
		tcs[index++] = teacher;
	}
	/**
	*�޸Ľ�ʦ��Ϣ
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
	 *ɾ����ʦ��Ϣ
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
	 *��ѯ���н�ʦ��Ϣ
	 */
	public Teacher[] queryAll(){
		Teacher[] demo = new Teacher[index];
		System.arraycopy(tcs,0,demo,0,index);
		return demo;
	}

	/**
	 *ͨ��id���ҽ�ʦ��Ϣ
	 */
	public Teacher queryById(long id){
		int num = getIndexById(id);
		return num==-1?null:tcs[num];
	}

	/**
	 ���ݽ�ʦ�����id��ȡ�ý�ʦ�����������е�����
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
	 * ���ӻ���ѯ�˵�
  	 */
	public void menu()
	{
		System.out.println("********��ʦ��Ϣ����ϵͳ********");
		System.out.println("*1 ��ѯ���н�ʦ��Ϣ");
		System.out.println("*2 ¼���ʦ��Ϣ");
		System.out.println("*3 ɾ����ʦ��Ϣ");
		System.out.println("*4 ͨ��id���ҽ�ʦ��Ϣ");
		System.out.println("*5 �޸Ľ�ʦ��Ϣ");
		System.out.println("*exit �˳�ϵͳ��");
		System.out.println("*help ����");
		System.out.println("********************************");
	}

	public static void main(String[] args)
		{
		Tms tms = new Tms();
		tms.menu();
		//ɨ��������
		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.print("*�������Ӧָ��:");
			String option = sc.nextLine();
			switch(option)
			{
				case "1":	//��ѯ����
					System.out.println("���������н�ʦ����Ϣ��");
					Teacher[] tcs = tms.queryAll();
					for(Teacher tc : tcs)
					{
						System.out.println(tc);
					}
					System.out.println("�ܹ���ѯ��"+tms.index+"����ʦ");
					break;
				case "2":	//¼��
					while(true)
					{
						System.out.println("�������ʦ����Ϣ��id#name#age#course�������롾break��������һ��Ŀ¼");
						String tcStr = sc.nextLine();
						if(tcStr.equals("break")){
							break;//���ص���һ��Ŀ¼
					}
						
					String[] tcArr = tcStr.split("#");
					//�������и�Ԫ��ת��Ϊ��ʦ��������Ҫ����������
					long id  = Long.parseLong(tcArr[0]);
					String name = tcArr[1];
					int age = Integer.parseInt(tcArr[2]);
					String course=tcArr[3];
					//��װ����
					Teacher tc = new Teacher(id,name,age,course);
					tms.save(tc);
					System.out.println("����ɹ���");
					}
					break;
				case "3":	//ɾ��
					while(true)
					{
						System.out.println("������Ҫɾ����ʦ��id,��������break������һ��Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break"))
						{
							break;
						}
						long id = Long.parseLong(idStr);
						Teacher tc=tms.queryById(id);
						if(tc==null)
							
						{
							System.out.println("��Ҫɾ�����û�������");
							continue;
						}
						tms.deleteById(id);
						System.out.println("ɾ���ɹ���");
						/*
						int num = tms.deleteById(id);
						System.out.println(num==0?"ɾ��ʧ��":"ɾ���ɹ�����ǰ��ʦ����Ϊ"+tms.index);
						*/
					}	
					break;
				case "4":	//ͨ��id��ȡ
					while(true)
					{
						System.out.println("������Ҫ���ҽ�ʦ��id,��������break������һ��Ŀ¼");
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
				case "5":	//�޸�
					while(true)
					{
						System.out.println("������Ҫ�޸Ľ�ʦ��id,��������break������һ��Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break"))
						{
							break;
						}
						long id = Long.parseLong(idStr);
						Teacher tc=tms.queryById(id);
						if(tc==null)					
						{
							System.out.println("��Ҫ�޸ĵ��û�������");
							continue;
						}
						System.out.println("ԭ��ϢΪ��"+tc);
						System.out.println("����������Ϣ��id#name#age#course��");
						String str=sc.nextLine();
						String[] tcArr=str.split("#");
						String name=tcArr[0];
						String course=tcArr[1];
						int age=Integer.parseInt(tcArr[1]);
						Teacher newTc=new Teacher(id,name,age,course);
						tms.update(newTc);
						System.out.println("�޸ĳɹ���");
					}
					break;

				case "exit":
					System.out.println("Bye Bye,��ӭ�ٴ�ʹ�ã�");
					System.exit(0);
				case "help":
					tms.menu();
					break;
				default:
					System.out.println("�������");

			}
		}
	}
}