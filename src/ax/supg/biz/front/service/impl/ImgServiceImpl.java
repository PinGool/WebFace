package ax.supg.biz.front.service.impl;

import java.util.List;

import ax.supg.biz.front.dao.IImgDao;
import ax.supg.biz.front.service.IImgService;
import ax.supg.biz.pojo.Img;

public class ImgServiceImpl implements IImgService {

	private IImgDao imgDao;
	public void addImg(String imgsrc, String name) {
		imgDao.addImg(imgsrc, name);
	}
	public void setImgDao(IImgDao imgDao) {
		this.imgDao = imgDao;
	}
	public List<Img> findAll() {
		return imgDao.findAll();
	}
}
