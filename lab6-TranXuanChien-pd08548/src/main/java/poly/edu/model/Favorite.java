package poly.edu.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;


/**
 * The persistent class for the Favorites database table.
 * 
 */
@Entity
@Table(name="Favorites")
@NamedQuery(name="Favorite.findAll", 
query="SELECT f FROM Favorite f")

@NamedQuery(name = "findLikeVideoByKeyWord",
query = "Select f.video FROM Favorite f where f.video.title LIKE CONCAT('%', :keyword, '%')")

@NamedQuery(name="Favorite.findFavoritesByUserId",
query="SELECT f.video FROM Favorite f WHERE f.user.id = :userId")

@NamedQuery(name = "Favorite.findFavoritesByDateRange", 
query = "SELECT f.video FROM Favorite f WHERE f.likeDate BETWEEN :minDate AND :maxDate")
public class Favorite implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Id")
	private long id;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="UserId")
	private User user;

	//bi-directional many-to-one association to Video
	@ManyToOne
	@JoinColumn(name="VideoId")
	private Video video;
	
	@Temporal(TemporalType.DATE)
	@Column(name="LikeDate")
	private Date likeDate;
	
	public Favorite() {
	}
	
	public Favorite(long id, User user, Video video, Date likeDate) {
		super();
		this.id = id;
		this.user = user;
		this.video = video;
		this.likeDate = likeDate;
	}

	public Date getLikeDate() {
		return likeDate;
	}

	public void setLikeDate(Date likeDate) {
		this.likeDate = likeDate;
	}


	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Favorite [id=" + id + ", user=" + user + ", video=" + video + ", likeDate=" + likeDate + "]";
	}

}