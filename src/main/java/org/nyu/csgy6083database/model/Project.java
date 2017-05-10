/**
 * 
 */
package org.nyu.csgy6083database.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author divyeshsurana
 *
 */
@Entity
@Table(name = "project")
public class Project {

	public enum PStatus {
		NOTFUNDED("Not funded"),

		FUNDEDANDPROGRESS("Funded and in progress"),

		FUNDEDANDCOMPLETED("Funded and completed");

		private String PStatus;

		private PStatus() {

		}

		private PStatus(String pStatus) {
			this.PStatus = pStatus;
		}

		public void setPSTatus(String pStatus) {
			this.PStatus = pStatus;
		}

		public String getPStatus() {
			return PStatus;
		}
	}

	@Id
	@Column(columnDefinition = "char(32)")
	private String projectid;

	@Column(columnDefinition = "text")
	private String projectname;

	@ManyToOne
	@JoinColumn(name = "owner")
	private User owner;

	@Column(columnDefinition = "text")
	private String pdesc;

	@ManyToOne
	@JoinColumn(name = "pcategory")
	private Category pcategory;

	@Enumerated(EnumType.STRING)
	private PStatus pstatus;

	private int minfund;

	private int maxfund;

	private Timestamp postingdate;

	private Timestamp enddate;

	private Timestamp actualenddate;

	private Timestamp completiondate;

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getProjectname() {
		return projectname;
	}

	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public String getPdesc() {
		return pdesc;
	}

	public void setPdesc(String pdesc) {
		this.pdesc = pdesc;
	}

	public Category getPcategory() {
		return pcategory;
	}

	public void setPcategory(Category pcategory) {
		this.pcategory = pcategory;
	}

	public PStatus getPstatus() {
		return pstatus;
	}

	public void setPstatus(PStatus pstatus) {
		this.pstatus = pstatus;
	}

	public int getMinfund() {
		return minfund;
	}

	public void setMinfund(int minfund) {
		this.minfund = minfund;
	}

	public int getMaxfund() {
		return maxfund;
	}

	public void setMaxfund(int maxfund) {
		this.maxfund = maxfund;
	}

	public Timestamp getPostingdate() {
		return postingdate;
	}

	public void setPostingdate(Timestamp postingdate) {
		this.postingdate = postingdate;
	}

	public Timestamp getEnddate() {
		return enddate;
	}

	public void setEnddate(Timestamp enddate) {
		this.enddate = enddate;
	}

	public Timestamp getActualenddate() {
		return actualenddate;
	}

	public void setActualenddate(Timestamp actualenddate) {
		this.actualenddate = actualenddate;
	}

	public Timestamp getCompletiondate() {
		return completiondate;
	}

	public void setCompletiondate(Timestamp completiondate) {
		this.completiondate = completiondate;
	}

}
