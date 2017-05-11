/**
 * 
 */
package org.nyu.csgy6083database.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
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
@Table(name = "comments")
public class Comments implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3145601753128679531L;

	@Id
	@ManyToOne
	@JoinColumn(name = "username")
	private User user;

	@Id
	@ManyToOne
	@JoinColumn(name = "projectid", columnDefinition = "char(32)")
	private Project projectid;

	@Column(columnDefinition = "text")
	private String content;

	@Column(columnDefinition = "blob")
	private byte[] media;

	@Id
	private Timestamp commenttime;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Project getProjectid() {
		return projectid;
	}

	public void setProjectid(Project projectid) {
		this.projectid = projectid;
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