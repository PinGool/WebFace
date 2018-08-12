package ax.supg.biz.front.dao;

import java.util.List;

import ax.supg.biz.pojo.Img;

public interface IImgDao {
	 
	public void addImg(String imgsrc,String name);
	
	public List<Img> findAll();
}
