package ax.supg.biz.front.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import ax.supg.biz.front.dao.IImgDao;
import ax.supg.biz.pojo.Img;

public class ImgDaoImpl extends HibernateDaoSupport implements IImgDao {

	public void addImg(String imgsrc, String name) {
		Img img=new Img(imgsrc,name);
		this.getHibernateTemplate().save(img);
	}
//@SuppressWarnings当你的编码可能存在警告时，比如安全警告，可以用它来消除
	@SuppressWarnings("unchecked")
	public List<Img> findAll() {
		List<Img> imgList=this.getHibernateTemplate().find("from Img");
		return imgList;
	}
}
