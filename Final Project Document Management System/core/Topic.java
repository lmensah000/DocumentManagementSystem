package core;

public class Topic {
	
	private int topicId;
	
	private String topic;
	
	private String storageFolder;


	public Topic() {
		super();
	}


	public Topic(int topicId, String topic, String storageFolder) {
		super();
		this.topicId = topicId;
		this.topic = topic;
		this.storageFolder = storageFolder;
	}


	public int getTopicId() {
		return topicId;
	}


	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getStorageFolder() {
		return storageFolder;
	}


	public void setStorageFolder(String storageFolder) {
		this.storageFolder = storageFolder;
	}
		
}
