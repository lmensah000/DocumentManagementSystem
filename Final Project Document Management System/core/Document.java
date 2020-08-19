package core;

public class Document {
	
	private int documentId, categoryId, topicId;
	
	private String tags, filename;


	public Document() {
		super();
	}


	public Document(int documentId, int categoryId, int topicId, String tags, String filename) {
		super();
		this.documentId = documentId;
		this.categoryId = categoryId;
		this.topicId = topicId;
		this.tags = tags;
		this.filename = filename;
	}


	public int getDocumentId() {
		return documentId;
	}


	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}


	public int getCategoryId() {
		return categoryId;
	}


	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}


	public int getTopicId() {
		return topicId;
	}


	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}


	public String getTags() {
		return tags;
	}


	public void setTags(String tags) {
		this.tags = tags;
	}


	public String getFilename() {
		return filename;
	}


	public void setFilename(String filename) {
		this.filename = filename;
	}


}
