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
@Table(name = "followers")
public class Followers implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2555247615705995699L;

	@Id
	@ManyToOne
	@JoinColumn(name = "userfollowed")
	private User userfollowed;

	@Id
	@ManyToOne
	@JoinColumn(name = "userfollower")
	private User userfollower;

	private Timestamp timefollowed;

	public User getUserfollowed() {
		return userfollowed;
	}

	public void setUserfollowed(User userfollowed) {
		this.userfollowed = userfollowed;
	}

	public User getUserfollower() {
		return userfollower;
	}

	public void setUserfollower(User userfollower) {
		this.userfollower = userfollower;
	}

	public Timestamp getTimefollowed() {
		return timefollowed;
	}

	public void setTimefollowed(Timestamp timefollowed) {
		this.timefollowed = timefollowed;
	}

}
