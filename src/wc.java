import java.io.*;
import java.util.ArrayList;

public class wc {
	

	public static ArrayList<String> sList = new ArrayList<String>();
	
	
	public static void main(String[] args){
		wc wc = new wc();
		if(args.length>1)
		{
			int last = args.length -1;
			String fileName = args[last];	//读取文件名
			String resultName = "";			//文件输出名
			String tmp;
			
			
			
			//循环读取参数args
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
			//如果outputSign为1，表示需要输出到文件中
				if(outputSign==1)
				{
					wc.writeFile(resultName);
					System.out.println();
					System.out.println("将信息写入"+resultName+"文件成功！！！");
				}
		}else
			System.out.println("请先输入参数！！！");   //如果wc.exe后面没有输入参数，就打印提示信息
				
	}
	
	
	//返回文件 file.c 的字符数
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
			System.out.println("找不到文件!!!");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+" 字符数为："+count;
	}
	
	
	//返回文件 file.c 的单词总数
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
			System.out.println("找不到文件!!!");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+" 单词总数："+count;
	}
	
	//返回文件 file.c 的总行数
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
			System.out.println("请检查文件路径是否正确");
			e1.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fileName+" 总行数："+count;
	}
	
	
	
	//将结果输出到指定文件outputFile.txt，文件名可自定义
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
			System.out.println("文件输出出现错误！");
			e.printStackTrace();
		}
	}
	
}