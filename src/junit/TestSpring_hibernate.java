package junit;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ax.supg.biz.front.service.IImgService;
import ax.supg.biz.front.service.IUserService;
import ax.supg.biz.front.service.impl.ImgServiceImpl;
import ax.supg.biz.pojo.Img;
import ax.supg.biz.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)  //ͨ��junitָ�����Ե�������
@ContextConfiguration("/bean.xml") //ָ������·��
public class TestSpring_hibernate {

	  //��������ȡ����ע��  
	/* @Resource
	 private IDepartmentService departmentService;
		  
	  @Test
	  public void testSave() throws Exception {
         Department d = new Department();
         d.setDepartmentName("������");
         d.setManager("�೤");
         d.setRemark("�մ���...");
         departmentService.save(d);
	  }*/
	 @Resource
	/* private IUserService userService;*/
	 private IImgService ImgServiceImpl;
	  @Test
	  public void testSave() throws Exception {
		  //User u = new User();
		  Img img = new Img(); 
		   img.setName("women");
		 //  img.setImgsrc(imgsrc);
		   ImgServiceImpl.addImg(null, "women");
		  
	  }
	
}
