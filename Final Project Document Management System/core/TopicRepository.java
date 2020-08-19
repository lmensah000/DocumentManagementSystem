package core;

import java.util.List;


public interface TopicRepository {


	Topic findById(int topicId);
	
	List<Topic> findByTopic(String topic);


	List<Topic> findByStorageFolder(String topic);
}

