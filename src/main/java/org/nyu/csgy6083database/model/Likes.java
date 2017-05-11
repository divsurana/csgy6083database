/**
 * 
 */
package org.nyu.csgy6083database.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author divyeshsurana
 *
 */
@Entity
@Table(name = "likes")
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
