package ax.supg.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import ax.supg.biz.pojo.SurveyInfos;

import com.baidu.aip.face.AipFace;

public class FromScore {
	 public static final String APP_ID="9557970";
     public static final String API_KEY="I171F6SWv5FXQrUYKNAC6kEi";
     public static final String SECRET_KEY="Ylp4lik2B2CF2ikOchOO6UFlET4SlB5L"; 

     
	public static void main(String[] args) {
		
		AipFace client=new AipFace(APP_ID,API_KEY,SECRET_KEY);
		
		 client.setConnectionTimeoutInMillis(2000);
		  client.setSocketTimeoutInMillis(60000);	
			String path1 = "e://Picture//test3.jpg";

		  
		  String sb = AipFaceClient.identifyUser(client, path1);
	      
	      //获取json数据并放入到list集合
	      JSONObject json = new JSONObject(sb);
	      JSONArray results = json.getJSONArray("results");
	      for (int i = 0; i < results.length(); i++) {
             SurveyInfos surveyInfo = new SurveyInfos();	
             JSONObject result = results.getJSONObject(i);
             
             surveyInfo.setUid(result.getString("uid"));
             surveyInfo.setUser_info(result.getString("user_info"));
                         
             JSONArray jsonArray = result.getJSONArray("scores");
             for(int j = 0;j < jsonArray.length();j++) {			           	   
            	  surveyInfo.setScores(jsonArray.get(j));          	  
            	    int sum=0;					
					sum+=jsonArray.getInt(j);
					if(sum>=90){
                    System.out.println("验证成功");  
					}
				}
            	  
             }
                
		}
	

}
