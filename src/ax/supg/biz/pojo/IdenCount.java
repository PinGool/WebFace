package ax.supg.biz.pojo;

import java.util.Date;



public class IdenCount {
         
	  //编号
	private Long id;
	//身份证名字 uid
	private String uid;
	//信息
    private String user_info; 
    //登录识别时间
    private String loginTime;
    //识别到的分数
    private Double scores;
    //是否为本人
    private String awse;
    
    
    
    
    public IdenCount(String uid, String user_info, Double scores,String awse,String loginTime) {
		super();
		this.uid = uid;
		this.user_info = user_info;
		this.scores = scores;
		this.awse=awse;
		this.loginTime=loginTime;
	}
    
    
	public String getAwse() {
		return awse;
	}

	public void setAwse(String awse) {
		this.awse = awse;
	}

	
	
	public Double getScores() {
		return scores;
	}
	public void setScores(Double scores) {
		this.scores = scores;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUid() {
		return uid;
	}
	public void setUid(String uid) {
		this.uid = uid;
	}
	public String getUser_info() {
		return user_info;
	}
	public void setUser_info(String user_info) {
		this.user_info = user_info;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
    
    
    
}
