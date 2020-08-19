package core;
import java.util.List;

public interface DocumentRepository {

	Document findById(int documentId);
	
	List<Document> findByTopicId(String topicId);

	List<Document> findByCategoryId(String categoryId);

	List<Document> findByTags(List<String> tags);

	List<Document> findByFileName(String fileName);
}
