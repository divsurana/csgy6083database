/**
 * 
 */
package org.nyu.csgy6083database.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author divyeshsurana
 *
 */
@Entity
@Table(name = "category")
public class Category {

	@Id
	private String categoryid;

	@Column(columnDefinition = "text")
	private String categoryname;

	private Date categorytime;

	public String getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(String categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategoryname() {
		return categoryname;
	}

	public void setCategoryname(String categoryname) {
		this.categoryname = categoryname;
	}

	public Date getCategorytime() {
		return categorytime;
	}

	public void setCategorytime(Date categorytime) {
		this.categorytime = categorytime;
	}

}
