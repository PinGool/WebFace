package junit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * ʹ��Spring�Դ����Կ��
 * @author cumtshuping
 *
 */
 @RunWith(SpringJUnit4ClassRunner.class)  //ͨ��junitָ�����Ե�������
 @ContextConfiguration("/bean.xml") //ָ������·��
 
 public class TestSpring_2 {             
	 //��ȡ�������ٴ�������ȡ����
	 @Resource    //�ȸ������Ʋ��ң�û�ҵ��ڸ������Ͳ��ң���������ظ�������JDKAPi��
	// @Autowired //ͬ��(SpringApi)
	 private String str; //�ȸ������Ʋ��ң�û�ҵ��ڸ������Ͳ��ң���������ظ����� 	 	 
	 @Test
     public void testApp() throws Exception{
	       System.out.println(str);      	   
			}
}
