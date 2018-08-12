package ax.supg.biz.pojo;

/**
 * Img entity. @author MyEclipse Persistence Tools
 */

public class Img implements java.io.Serializable {

	// Fields

	private Integer int_;
	private String imgsrc;
	private String name;

	// Constructors

	/** default constructor */
	public Img() {
	}

	/** full constructor */
	public Img(String imgsrc, String name) {
		this.imgsrc = imgsrc;
		this.name = name;
	}

	// Property accessors

	public Integer getInt_() {
		return this.int_;
	}

	public void setInt_(Integer int_) {
		this.int_ = int_;
	}

	public String getImgsrc() {
		return this.imgsrc;
	}

	public void setImgsrc(String imgsrc) {
		this.imgsrc = imgsrc;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

}