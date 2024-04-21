package edu.poly.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="Shares")
@NamedQuery(name="Share.findAll", query="SELECT s FROM Share s")
public class Share implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="Shareid")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int shareid;

	@Column(name="Email")
	private String email;

	@Temporal(TemporalType.DATE)
	@Column(name="ShareDate")
	private Date shareDate;
	
	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="Username")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="Videoid")
	private Video video;

	public Share() {
	}

	public Share(int shareid, String email, Date shareDate, User user, Video video) {
		super();
		this.shareid = shareid;
		this.email = email;
		this.shareDate = shareDate;
		this.user = user;
		this.video = video;
	}

	public Date getShareDate() {
		return shareDate;
	}

	public void setShareDate(Date shareDate) {
		this.shareDate = shareDate;
	}

	public int getShareid() {
		return this.shareid;
	}

	public void setShareid(int shareid) {
		this.shareid = shareid;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Video getVideo() {
		return this.video;
	}

	public void setVideo(Video video) {
		this.video = video;
	}

}