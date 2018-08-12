package ax.supg.biz.front.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

import org.apache.struts2.ServletActionContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import Decoder.BASE64Decoder;
import ax.supg.biz.pojo.IdenCount;
import ax.supg.biz.pojo.User;
import ax.supg.utils.AipFaceClient;

import com.baidu.aip.face.AipFace;


/*
 * 用户模块
 *  1.进入用户注册页面
 *  2.注册用户
 *  3.列表功能
 *  
 *  4.人脸识别模块
 *  5.用户登录
 *  
 */
public class FaceUserAction extends BaseAction{
   
	    public static final String APP_ID="9557970";
	    public static final String API_KEY="I171F6SWv5FXQrUYKNAC6kEi";
	    public static final String SECRET_KEY="Ylp4lik2B2CF2ikOchOO6UFlET4SlB5L"; 
	    //初始化一个FaceClient
		   AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
	    	    
	 //封装请求数据
	private File file;
	
	private String fileFileName;
	//提交过来的file的MiME类型
	private String fileContentType;
	//接收拍照过来的图片数据
	private String mydata;
	
	
	private User user;
	private IdenCount idenCount;
	
	
	
	 @Override
	public String execute() throws Exception {
		return super.execute();
	}
	
	//1.进入注册用户页面
	  public String add(){
		  
		   /***进入添加页面 **/
		  //查询所有的部门
		  
		return "add";		  		  
	  }
	
	  /**
	   * 2. 注册人脸用户  
	   * @return
	   * @throws Exception
	   */
	  public String save() throws Exception{
		 		   
		  // 设置网路连接参数
		   client.setConnectionTimeoutInMillis(2000);
		   client.setSocketTimeoutInMillis(60000);	
		  		   
		  //图片的根目录
		  String root = ServletActionContext.getServletContext().getRealPath("/file");
		  FileInputStream in = new FileInputStream(file);
		  FileOutputStream out = new FileOutputStream(new File(root, fileFileName));  //写出图片文件
		  byte[] buffer=new byte[500];		  
		  int length=0;
		  while(-1!=(length=in.read(buffer,0,buffer.length))){
			  out.write(buffer);			  
		  }
		  out.close();
		  in.close();		  
	  
		  userService.addImg("file/"+fileFileName, user.getName(), user.getSex(), user.getPassword(), user.getTrueName(), user.getIptCard(), user.getEmail());
		 
		  //得到注册时图片的地址		  
		  String path1=root+"/"+fileFileName;
		  ArrayList<String> path=new ArrayList<String>();   
		  path.add(path1);
		  JSONObject res = client.addUser(user.getTrueName(),user.getIptCard() , "group1", path);
		  System.out.println(res.toString(2));
		  
		  return "save";
	  }
	  //查询已保存到数据库的用户
	  public String findAll(){
		  //List<User> imgList = userService.findAll();
		  List<User> imgList = userService.getAll();
		  request.put("imgList", imgList);
		  return "imgList";
	  }
	  
	  
	  
	  /**
	   * 3 识别人脸
	   * @return
	   */
	   public String IdenFace(){
		     /// 设置网路连接参数
			  client.setConnectionTimeoutInMillis(2000);
			  client.setSocketTimeoutInMillis(60000);	
		   
			  //生成图片保存到本地路径
			  BASE64Decoder decoder = new BASE64Decoder();
			  File imageName=null;
			  
			try {
				byte[] b = decoder.decodeBuffer(mydata);
				 for(int i=0;i<b.length;++i){
					if(b[i]<0){ //调整异常数据
						b[i]+=256;
					}
				}
		    	//生成jpeg图片	 
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
				File imageDir=new File("d:/images/");//生成图片路径
				if(!imageDir.exists()){
				     imageDir.mkdir();
				}
				imageName=new File(imageDir,dateFormat.format(new Date())+".jpg");
				if(!imageName.exists()){
					imageName.createNewFile();
				}
		    FileOutputStream fos = new FileOutputStream(imageName);
				fos.write(b);
				fos.flush();
				fos.close();
		    
		   	} catch (IOException e) {
				e.printStackTrace();
			}
			
		  //识别人脸
			String sb = AipFaceClient.identifyUser(client, imageName.getAbsolutePath());
			  System.out.println(sb);
		  		   		
				  
			   try {
				     //获取json数据并放入到域对象
					  JSONObject json = new JSONObject(sb);
					   JSONArray results = json.getJSONArray("results");	
				       
					   JSONObject result=null; 
					   JSONArray jsonArray=null;
					   String qw =null;
				for(int i=0;i< results.length();i++){
					    result = results.getJSONObject(i);
					  //放入域对象
					   request.put("uid", result.getString("uid"));	 
					   
					   request.put("user_info", result.getString("user_info")); 			   			   
					   
					   User FaceUser = userService.findByTrueName(result.getString("uid"));
					   
					    System.out.println(FaceUser.getFile_path());
					    request.put("FaceUser", FaceUser.getFile_path());
						  //获取分数
						 jsonArray = result.getJSONArray("scores");  					
							
							  if(jsonArray.getDouble(0)>80){
								  qw ="YES";
							  }else {
								  qw="NO";
								  request.put("error", "你不是本人，请重拍");
							}
							  request.put("scores", qw);
				}	
				
				 SimpleDateFormat d =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				 d.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
				 String loginTime = d.format(new Date());
	   idenFaceService.addIdenFace(result.getString("uid"), result.getString("user_info"),jsonArray.getDouble(0),qw, loginTime);
				  
			} catch (Exception e) {
				e.printStackTrace();
				  request.put("error", "你拍得照片模糊不清，请重拍");
			}
			
			
			   
			  	    return "show";
	   }
	  
	  
 
	 
	  
	   
	   
	   
	   
	   
	   
   public IdenCount getIdenCount() {
		return idenCount;
	}
	public void setIdenCount(IdenCount idenCount) {
		this.idenCount = idenCount;
	}	
	public void setUser(User user) {
		this.user = user;
	}
	public User getUser() {
		return user;
	}
	  	  
	public String getMydata() {
		return mydata;
	}
	public void setMydata(String mydata) {
		this.mydata = mydata;
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
