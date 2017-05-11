/**
 * 
 */
package org.nyu.csgy6083database.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.nyu.csgy6083database.model.Ratings.RatingsId;

/**
 * @author divyeshsurana
 *
 */
@Entity
@Table(name = "ratings")
@IdClass(RatingsId.class)
public class Ratings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4198051155891210095L;

	@Id
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "projectid", columnDefinition = "char(32)")
	private Project project;

	@Column(columnDefinition = "text")
	private String content;

	private int rating;

	private Timestamp ratingtime;

	public class RatingsId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 134203303751109629L;
		private User user;
		private Project project;

		public RatingsId() {
		}

		public RatingsId(User user, Project project) {
			this.user = user;
			this.project = project;
		}
		// equals, hashCode
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public Timestamp getRatingtime() {
		return ratingtime;
	}

	public void setRatingtime(Timestamp ratingtime) {
		this.ratingtime = ratingtime;
	}

}
