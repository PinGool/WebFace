package ax.supg.biz.front.service;

import java.util.List;

import sample.EmployeeRecord;
import ax.supg.biz.pojo.User;

public interface IUserService extends IBaseService<User> {

	public void addImg(String file_path,String name,String sex,String password
            ,String trueName,String iptCard,String email
             );
     
	 // �������ֲ�ѯ
	 User findByTrueName(String trueName);
	 //��¼ҵ������
	 User login(User user); 
}
