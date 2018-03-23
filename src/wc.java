import java.io.*;
import java.util.ArrayList;

public class wc {
	

	public static ArrayList<String> sList = new ArrayList<String>();
	
	
	public static void main(String[] args){
		wc wc = new wc();
		if(args.length>1)
		{
			int last = args.length -1;
			String fileName = args[last];	//��ȡ�ļ���
			String resultName = "";			//�ļ������
			String tmp;
			
			
			
			//ѭ����ȡ����args
			for(int i=0;i<last;i++)
				if(args[i].equals("-c")) 
					{
						tmp = new String(wc.countCharacter(fileName));
						System.out.println(tmp);
						sList.add(tmp);
					}
				else if(args[i].equals("-w"))
				{
					tmp = new String(wc.countWord(fileName));
					System.out.println(tmp);
					sList.add(tmp);
				}
				else if(args[i].equals("-l"))
				{
					tmp = new String(wc.countLine(fileName));
					System.out.println(tmp);
					sList.add(tmp);
				}

			

			int outputSign = 0;

			for(int i=0;i<last;i++)
				if(args[i].equals("-o"))
				{
					outputSign=1;
					fileName = args[last-2];
					resultName = args[last];
					break;
				}
			//���outputSignΪ1����ʾ��Ҫ������ļ���
				if(outputSign==1)
				{
					wc.writeFile(resultName);
					System.out.println();
					System.out.println("����Ϣд��"+resultName+"�ļ��ɹ�������");
				}
		}else
			System.out.println("�����������������");   //���wc.exe����û������������ʹ�ӡ��ʾ��Ϣ
				
	}
	
	
	//�����ļ� file.c ���ַ���
	public String countCharacter(String fileName)
	{
		int count=0;
		String s;
		int c;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			while((s=in.readLine())!=null)
				count+=s.length();
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("�Ҳ����ļ�!!!");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+" �ַ���Ϊ��"+count;
	}
	
	
	//�����ļ� file.c �ĵ�������
	public String countWord(String fileName)
	{
		int count=0;
		String s;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			while((s = in.readLine())!=null)
			{
				if(!s.isEmpty())
					{
						String ss []  = s.trim().split(" |,|	");
						count+=ss.length;
					}
			}
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("�Ҳ����ļ�!!!");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+" ����������"+count;
	}
	
	//�����ļ� file.c ��������
	public String countLine(String fileName)
	{
		int count=0;
		String s;
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
			while((s = in.readLine())!=null)
				++count;
			in.close();
		} catch (FileNotFoundException e1) {
			System.out.println("�����ļ�·���Ƿ���ȷ");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+" ��������"+count;
	}
	
	
	
	//����������ָ���ļ�outputFile.txt���ļ������Զ���
	public void writeFile(String fileName)
	{
		try {
			FileWriter w = new FileWriter(fileName);
			int i=0;
			for(;i < sList.size();i++)
				{
					w.write(sList.get(i));
					w.write("\r\n");
				}
			w.close();
		} catch (IOException e) {
			System.out.println("�ļ�������ִ���");
			e.printStackTrace();
		}
	}
	
}