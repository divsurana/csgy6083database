/**
 * 
 */
package org.nyu.csgy6083database.model;

import java.sql.Timestamp;

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
	@Column(columnDefinition = "char(32)")
	private String categoryid;

	@Column(columnDefinition = "text")
	private String categoryname;

	private Timestamp categorytime;

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

	public Timestamp getCategorytime() {
		return categorytime;
	}

	public void setCategorytime(Timestamp categorytime) {
		this.categorytime = categorytime;
	}

}
