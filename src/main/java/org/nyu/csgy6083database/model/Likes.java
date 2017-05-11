/**
 * 
 */
package org.nyu.csgy6083database.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.nyu.csgy6083database.model.Likes.LikesId;

/**
 * @author divyeshsurana
 *
 */
@Entity
@Table(name = "likes")
@IdClass(LikesId.class)
public class Likes implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6398329761758438820L;

	@Id
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "projectid", columnDefinition = "char(32)")
	private Project project;

	private Timestamp liketime;

	public class LikesId implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3768888745901169033L;
		private User user;
		private Project project;

		public LikesId() {
		}

		public LikesId(User user, Project project) {
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

	public Timestamp getLiketime() {
		return liketime;
	}

	public void setLiketime(Timestamp liketime) {
		this.liketime = liketime;
	}
}
