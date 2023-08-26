package com.demospringboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "new")
public class NewEntity extends BaseEntity {

	@Column(name = "title",columnDefinition ="nvarchar(255)")
	private String title;
	
	@Column(name = "thumbnail",columnDefinition ="nvarchar(255)")
	private String thumbnail;
	
	@Column(name = "content",columnDefinition ="nvarchar(255)")
	private String content;
	
	@Column(name = "shortdescription",columnDefinition ="nvarchar(255)")
	private String shortDescription;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "category_id")
    private CategoryEntity category;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getThumbnail() {
		return thumbnail;
	}

	public void setThumbnail(String thumbnail) {
		this.thumbnail = thumbnail;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public CategoryEntity getCategory() {
		return category;
	}

	public void setCategory(CategoryEntity category) {
		this.category = category;
	}
}
