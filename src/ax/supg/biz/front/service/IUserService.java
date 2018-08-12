package ax.supg.biz.front.service;

import java.util.List;

import sample.EmployeeRecord;
import ax.supg.biz.pojo.User;

public interface IUserService extends IBaseService<User> {

	public void addImg(String file_path,String name,String sex,String password
            ,String trueName,String iptCard,String email
             );
     
	 // 根据名字查询
	 User findByTrueName(String trueName);
	 //登录业务处理方法
	 User login(User user); 
}
