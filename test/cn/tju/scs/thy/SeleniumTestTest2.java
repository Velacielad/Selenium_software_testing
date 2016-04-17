package cn.tju.scs.thy;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class SeleniumTestTest2 {
	
	private String input1;
	private String input2;
	private String expected;
	
	private SeleniumTest sel;
	
	public SeleniumTestTest2(String input1,String input2,String expected){
		this.input1 = input1;
		this.input2 = input2;
		this.expected = expected;
	}
	
	@Before
	public void setUp(){
		sel = new SeleniumTest();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		
		try {  
            BufferedReader reader = new BufferedReader(new FileReader("info.csv"));//换成你的文件名 
            
           
            Object[][] o = new Object[109][];
            Object[] oo;
            int index = 0;
            String line = null;  
            while((line=reader.readLine())!=null && index<109){  
                String item[] = line.split(",");//CSV格式文件为逗号分隔符文件，这里根据逗号切分
//                System.out.println(line);
                String user = item[0]; 
                String pwd = user.substring(4);
               
                String address = item[1];//这就是你要的数据了 
                
                oo = new Object[]{user,pwd,address};
                o[index] = oo;
               
                index++;
            }  

            return Arrays.asList(o);
        } catch (Exception e) {  
            e.printStackTrace(); 
            return null;
        } 
		
	}
	@Test
	public void test() {
		assertEquals(this.expected,sel.getEmailAddress(this.input1, this.input2));
	}

}
