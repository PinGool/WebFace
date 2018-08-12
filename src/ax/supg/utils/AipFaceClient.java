package ax.supg.utils;

import java.awt.image.RescaleOp;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.JSONObject;

import com.baidu.aip.face.AipFace;

public class AipFaceClient {
     
	   
	    public static final String APP_ID="9557970";
	    public static final String API_KEY="I171F6SWv5FXQrUYKNAC6kEi";
	    public static final String SECRET_KEY="Ylp4lik2B2CF2ikOchOO6UFlET4SlB5L"; 
	
	    
	   public static void main(String[] args) {
		   
		   //��ʼ��һ��FaceClient
		   AipFace client = new AipFace(APP_ID, API_KEY, SECRET_KEY);
		   
		   // ������·���Ӳ���
		   client.setConnectionTimeoutInMillis(2000);
		   client.setSocketTimeoutInMillis(60000);		
		   String path1 = "e://Picture//test4.jpg";

		  // faceRecognize(client);
	       facesetAddUser(client);
	       //verifyUser(client);
		// System.out.println(identifyUser(client, path1));  
		 //  getUser(client);
	   }	   
	   
	   public static void faceRecognize(AipFace client) {
		  
		   // �Զ����������
		    HashMap<String, String> options = new HashMap<String, String>();
		    options.put("max_face_num", "1");
		   // options.put("face_fields", "expression");
		    options.put("face_fields", "gender");
		    
		   //����Ϊ����ͼƬ·��
		   String imagePath = "e://Picture//test1.jpg";
		   JSONObject response = client.detect(imagePath, options);
		   System.out.println(FormatJson.format(response.toString()));
		   
		/*// ����Ϊ����ͼƬ�ļ�����������
		    byte[] file = readImageFile(imagePath);    // readImageFile������Ϊʾ��
		    JSONObject response = client.detect(file);
		    System.out.println(response.toString());*/
		   		 		   
	   }
	    
	   public static void facesetAddUser(AipFace client){
		   //����Ϊ����ͼƬ·��
		   String path1="e://Picture//test8.jpg";
		  // String path2="e://Picture//test7.jpg";
		   ArrayList<String> path = new ArrayList<String>();
		   path.add(path1);
	     //path.add(path2);			   
		   JSONObject res = client.addUser("uid3", "shiwei", "group1", path);
		   System.out.println(res.toString(2));
	   }
	    
	   public static void verifyUser(AipFace client) {
		    
		    String path1 = "e://Picture//test3.jpg";
		    ArrayList<String> path = new ArrayList<String>();
		    path.add(path1);
		    HashMap<String, Object> options = new HashMap<String, Object>(1);
		    options.put("top_num", path.size());
		    JSONObject res = client.verifyUser("uid1", path, options);
		    System.out.println(res.toString(2));		   
	   }
	   
	   public static String identifyUser(AipFace client,String path1) {
		//    String path1 = "e://Picture//test3.jpg";
		   // String path2 = "e://Picture//test4.JPG";
		    ArrayList<String> path = new ArrayList<String>();
		    path.add(path1);
		   // path.add(path2);
		    HashMap<String, Object> options = new HashMap<String, Object>(1);
		    options.put("user_top_num", path.size());
		    options.put("face_top_num", 10);
		    JSONObject res = client.identifyUser("group1", path, options);
			return res.toString(2);
		}
	   
	   public static void getUser(AipFace client) {
		     JSONObject res = client.getUser("uid1");
	         System.out.println(res.toString(2));
	   }
	   	   
}
