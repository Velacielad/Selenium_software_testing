package cn.tju.scs.thy;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;

import org.junit.Before;
import org.junit.Test;

public class SeleniumTestTest {
	private SeleniumTest sel;
	
	@Test
	public void test() {
		sel = new SeleniumTest();
		try {  
            BufferedReader reader = new BufferedReader(new FileReader("info.csv"));//换成你的文件名 
            
            String line = null;  
            while((line=reader.readLine())!=null){  
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
                
                String user = item[0]; 
                String pwd = user.substring(4);
               
                String address = item[1];//这就是你要的数据了 
                //int value = Integer.parseInt(last);//如果是数值，可以转化为数值
                String result = sel.getEmailAddress(user, pwd);
                System.out.println(line + " " + user + " " + pwd + " " + address + " " + result);

                assertEquals(address,result);
            }  
        } catch (Exception e) {  
            e.printStackTrace();  
        } 
	}

}
