package ax.supg.biz.front.dao;

import java.io.Serializable;
import java.util.List;

import ax.supg.biz.pojo.User;

public interface IUserDao extends IBaseDao<User>{
   
     public void addImg(String file_path,String name,String sex,String password
    		            ,String trueName,String iptCard,String email
    		             );
     
    
  // 根据名字查询
 	 User findByTrueName(String trueName);

}
