package ax.supg.biz.pojo;


/**
 * �����û�ģ��
 * @author cumtshuping
 *
 */
public class User {
	    // ���
		private Long id;
		// ����
		private String name;  // (��½��)
		//�Ա�
		private String sex;		
		// ����
		private String password;
		// ��ʵ����
		private String trueName;
		
		//���֤��
		private String iptCard; 
		
		// �绰
		private String tel;
		// ����
		private String email;
		//�ϴ��ļ���·��			
		private String file_path;
		//�û���Ϣ
		private String user_info; 
		//�û��ķ���
		private String scores;	
		
	
	
		
		
		
		
		
		
		
		public User() {
		}

		public User( String file_path,String name, String sex, String password, String trueName,
				String iptCard, String email) {
			this.name = name;
			this.sex = sex;
			this.password = password;
			this.trueName = trueName;
			this.iptCard = iptCard;
			this.email = email;
			this.file_path = file_path;
		}
		
		public String getSex() {
			return sex;
		}
		public void setSex(String sex) {
			this.sex = sex;
		}
		public String getIptCard() {
			return iptCard;
		}
		public void setIptCard(String iptCard) {
			this.iptCard = iptCard;
		}
		public String getFile_path() {
			return file_path;
		}
		public void setFile_path(String file_path) {
			this.file_path = file_path;
		}
		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public String getTrueName() {
			return trueName;
		}
		public void setTrueName(String trueName) {
			this.trueName = trueName;
		}
	
		
		public String getTel() {
			return tel;
		}
		public void setTel(String tel) {
			this.tel = tel;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getUser_info() {
			return user_info;
		}
		public void setUser_info(String user_info) {
			this.user_info = user_info;
		}
		public String getScores() {
			return scores;
		}
		public void setScores(String scores) {
			this.scores = scores;
		}

		
		
}
