package ax.supg.biz.pojo;

import java.util.Date;



public class IdenCount {
         
	  //���
	private Long id;
	//���֤���� uid
	private String uid;
	//��Ϣ
    private String user_info; 
    //��¼ʶ��ʱ��
    private String loginTime;
    //ʶ�𵽵ķ���
    private Double scores;
    //�Ƿ�Ϊ����
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
