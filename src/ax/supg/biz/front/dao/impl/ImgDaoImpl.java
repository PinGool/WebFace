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
//@SuppressWarnings����ı�����ܴ��ھ���ʱ�����簲ȫ���棬��������������
	@SuppressWarnings("unchecked")
	public List<Img> findAll() {
		List<Img> imgList=this.getHibernateTemplate().find("from Img");
		return imgList;
	}
}
