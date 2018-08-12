package junit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 使用Spring自带测试框架
 * @author cumtshuping
 *
 */
 @RunWith(SpringJUnit4ClassRunner.class)  //通过junit指定测试的容器类
 @ContextConfiguration("/bean.xml") //指定容器路径
 
 public class TestSpring_2 {             
	 //获取容器，再从容器获取对象
	 @Resource    //先根据名称查找，没找到在根据类型查找，类型如果重复报错！（JDKAPi）
	// @Autowired //同上(SpringApi)
	 private String str; //先根據名称查找，没找到在根据类型查找，类型如果重复报错！ 	 	 
	 @Test
     public void testApp() throws Exception{
	       System.out.println(str);      	   
			}
}
