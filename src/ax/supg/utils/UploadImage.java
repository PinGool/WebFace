package ax.supg.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.baidu.aip.face.AipFace;

import Decoder.BASE64Decoder;


public class UploadImage extends HttpServlet {
	public UploadImage() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public static final String APP_ID="9557970";
    public static final String API_KEY="I171F6SWv5FXQrUYKNAC6kEi";
    public static final String SECRET_KEY="Ylp4lik2B2CF2ikOchOO6UFlET4SlB5L"; 
	
    AipFace client=new AipFace(APP_ID,API_KEY,SECRET_KEY);
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  // 设置网路连接参数
		  client.setConnectionTimeoutInMillis(2000);
		  client.setSocketTimeoutInMillis(60000);	
		
		String imageuri = request.getParameter("mydata");
		PrintWriter pw = response.getWriter();
		response.setCharacterEncoding("UTF-8");
//		System.out.println(imageuri);//图片字符�?
		request.setCharacterEncoding("utf-8");
		
		
		
		
		/*BASE64Decoder decoder = new BASE64Decoder();
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imageuri);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			File imageDir = new File("d:/images/");//生成图片路径
			if (!imageDir.exists()) {
				imageDir.mkdirs();
			}
			File imageName = new File(imageDir,dateFormat.format(new Date())+".jpg");//生成图片�?
			if (!imageName.exists()) {
				imageName.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(imageName);
			fos.write(b);
			fos.flush();
			fos.close();
			pw.write("图片上传成功！！");
		} catch (Exception e) {
			e.printStackTrace();
			pw.write("图片上传失败！！");
		}*/
		
		
		
	}

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
