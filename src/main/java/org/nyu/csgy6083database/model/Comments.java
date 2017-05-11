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

import org.nyu.csgy6083database.model.Comments.CommentsId;

/**
 * @author divyeshsurana
 *
 */
@Entity
@Table(name = "comments")
@IdClass(CommentsId.class)
public class Comments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6324670820759922413L;

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

	@Column(columnDefinition = "blob")
	private byte[] media;

	@Id
	private Timestamp commenttime;

	public class CommentsId implements Serializable {
		/**
		 * 
		 */
		private static final long serialVersionUID = 6799231914204502710L;
		private User user;
		private Project project;

		public CommentsId() {
		}

		public CommentsId(User user, Project project) {
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

	/**
	 * @return the project
	 */
	public Project getProject() {
		return project;
	}

	/**
	 * @param project
	 *            the project to set
	 */
	public void setProject(Project project) {
		this.project = project;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public byte[] getMedia() {
		return media;
	}

	public void setMedia(byte[] media) {
		this.media = media;
	}

	public Timestamp getCommenttime() {
		return commenttime;
	}

	public void setCommenttime(Timestamp commenttime) {
		this.commenttime = commenttime;
	}

}
