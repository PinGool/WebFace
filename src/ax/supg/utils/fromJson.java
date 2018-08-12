package ax.supg.utils;

import org.json.JSONArray;
import org.json.JSONObject;

import ax.supg.biz.pojo.SurveyVO;


public class fromJson {
	 
	 public static void main(String[] args) {
		  //½âÎö×Ö·û´®
		 JSONObject json = new JSONObject("{'message':'success','result':[{'surveyId':'1','surveyName':'B'},{'surveyId':'2','surveyName':'C'}]}");
		 
		 JSONArray results = json.getJSONArray("result");
		 for (int i = 0; i < results.length(); i++) {
			      SurveyVO surveyVO = new SurveyVO();
			      JSONObject result = results.getJSONObject(i);
			      
			      System.out.println(result.getString("surveyId")+" "+result.getString("surveyName"));
		          surveyVO.setSurveyId(result.getString("surveyId"));
		          surveyVO.setSurveyName(result.getString("surveyName"));
		}
		 
	}
    
	 /*public fromJson(){
		 sTotalString = {"message":"success","result":[{"surveyid":"1","surveyname":"B"}{"surveyid":"2","surveyname":"C"}]};
	     JSONObject json;

	    try {
	      
			JSONObject json = new JSONObject(sTotalString);
	        JSONArray results = json.getJSONArray("result");
	        for (int i = 0; i < results.length(); i++) {
	            SurveyVO surveyVO = new SurveyVO();
	            JSONObject result = results.getJSONObject(i);
	            System.out.println(result.getString("surveyId")+" "+result.getString("surveyName"));
	            surveyVO.setSurveyId(result.getString("surveyId"));
	            surveyVO.setSurveyName(result.getString("surveyName"));
	          //  surveyVOList.add(surveyVO);
	        }
	    } catch (JSONException e) {
	        e.printStackTrace();
	    }
	 }*/
		
}
