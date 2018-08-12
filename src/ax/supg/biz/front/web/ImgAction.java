package ax.supg.biz.front.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.RequestAware;

import ax.supg.biz.front.service.IImgService;
import ax.supg.biz.pojo.Img;

import com.opensymphony.xwork2.ActionSupport;

public class ImgAction extends ActionSupport implements RequestAware {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IImgService imgService;
	private Img img;
	private Map<String, Object> reqMap;
	private File file;
	private String fileFileName;
	//提交过来的file的MIME类型
    private String fileContentType;
	
	public String add() throws Exception{
		String root=ServletActionContext.getServletContext().getRealPath("/file");
    	InputStream is=new FileInputStream(file);
    	OutputStream os = new FileOutputStream(new File(root, fileFileName));
    	byte[] buffer=new byte[500];
        @SuppressWarnings("unused")
		int length=0;
        while(-1 !=(length=is.read(buffer,0,buffer.length))){
        	os.write(buffer);
        }
        os.close();
        is.close();
		imgService.addImg("file/"+fileFileName, img.getName());
		return "add";
	}
	
	public String findAll(){
		List<Img> imgList=imgService.findAll();
		reqMap.put("imgList", imgList);
		return "imgList";
	}
	
	
	
	
	
	
	public Img getImg() {
		return img;
	}
	public void setImg(Img img) {
		this.img = img;
	}
	public void setImgService(IImgService imgService) {
		this.imgService = imgService;
	}
	
	
	public void setRequest(Map<String, Object> reqMap) {
		this.reqMap=reqMap;
	}
	
	
	
	public File getFile() {
		return file;
	}
	public void setFile(File file) {
		this.file = file;
	}
	public String getFileFileName() {
		return fileFileName;
	}
	public void setFileFileName(String fileFileName) {
		this.fileFileName = fileFileName;
	}
	public String getFileContentType() {
		return fileContentType;
	}
	public void setFileContentType(String fileContentType) {
		this.fileContentType = fileContentType;
	}
	
}
