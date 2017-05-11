/**
 * 
 */
package org.nyu.csgy6083database.model;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.Size;

/**
 * @author divyeshsurana
 *
 */
@Entity
@Table(name = "pledge")
public class Pledge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5123996198566891075L;

	@Id
	@Column(columnDefinition = "char(32)")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private String pledgeid;

	@ManyToOne
	@JoinColumn(name = "projectid", columnDefinition = "char(32)")
	private Project project;

	@ManyToOne
	@JoinColumn(name = "sponsor")
	private User sponsor;

	private int amount;

	private Timestamp pledgetime;

	private Timestamp transactiontime;

	@Size(max = 30)
	private String cardnumber;

	private boolean isbilled;

	public String getPledgeid() {
		return pledgeid;
	}

	public void setPledgeid(String pledgeid) {
		this.pledgeid = pledgeid;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public User getSponsor() {
		return sponsor;
	}

	public void setSponsor(User sponsor) {
		this.sponsor = sponsor;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public Timestamp getPledgetime() {
		return pledgetime;
	}

	public void setPledgetime(Timestamp pledgetime) {
		this.pledgetime = pledgetime;
	}

	public Timestamp getTransactiontime() {
		return transactiontime;
	}

	public void setTransactiontime(Timestamp transactiontime) {
		this.transactiontime = transactiontime;
	}

	public String getCardnumber() {
		return cardnumber;
	}

	public void setCardnumber(String cardnumber) {
		this.cardnumber = cardnumber;
	}

	public boolean isIsbilled() {
		return isbilled;
	}

	public void setIsbilled(boolean isbilled) {
		this.isbilled = isbilled;
	}

}
