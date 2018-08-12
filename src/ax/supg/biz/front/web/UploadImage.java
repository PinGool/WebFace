package ax.supg.biz.front.web;

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

import org.json.JSONArray;
import org.json.JSONObject;

import Decoder.BASE64Decoder;
import ax.supg.biz.pojo.SurveyInfos;
import ax.supg.utils.AipFaceClient;

import com.baidu.aip.face.AipFace;


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
	
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    		throws ServletException, IOException {
    	  /// 设置网路连接参数
		  client.setConnectionTimeoutInMillis(2000);
		  client.setSocketTimeoutInMillis(60000);	
		
		String imageuri = request.getParameter("mydata");
		PrintWriter pw = response.getWriter();
		response.setCharacterEncoding("utf-8");
   //		System.out.println(imageuri);//图片字符串�?
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		/**		 
		 * 生成图片保存到本地路径
		 * */			
		BASE64Decoder decoder = new BASE64Decoder();
		File imageName=null;
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
			 imageName = new File(imageDir,dateFormat.format(new Date())+".jpg");//生成图片�?
			if (!imageName.exists()) {
				imageName.createNewFile();
			}
			FileOutputStream fos = new FileOutputStream(imageName);
			fos.write(b);
			fos.flush();
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		//人脸识别						
	    String sb = AipFaceClient.identifyUser(client,imageName.getAbsolutePath());
        System.out.println(sb);
        //获取json数据并放入到域对象
	      JSONObject json = new JSONObject(sb);
	      JSONArray results = json.getJSONArray("results");
	      for (int i = 0; i < results.length(); i++) {
       //   SurveyInfos surveyInfo = new SurveyInfos();	
          JSONObject result = results.getJSONObject(i);
          
          
          request.setAttribute("uid", result.getString("uid"));           
          request.setAttribute("user_info", result.getString("user_info"));
          
          JSONArray jsonArray = result.getJSONArray("scores");
          for(int j = 0;j < jsonArray.length();j++) {		            	
          	 String qw=null;
          	if(jsonArray.getDouble(j)>85){
          		   qw="YES";
          	  } else {
          		  qw="NO";
          	  }
         	  request.setAttribute("scores", qw);
				}          	  
          }
	              System.out.println(sb);    	      
	      request.getRequestDispatcher("/showIndex.jsp").forward(request, response);
    }
    
    
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		
		    doGet(request, response);	
		
	}


}
