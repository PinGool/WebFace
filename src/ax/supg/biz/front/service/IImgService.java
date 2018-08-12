package ax.supg.biz.front.service;

import java.util.List;

import ax.supg.biz.pojo.Img;

public interface IImgService {

	public void addImg(String imgsrc,String name);
	public List<Img> findAll();
}
