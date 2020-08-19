package core;
import java.util.List;


public interface CategoryRepository {


	Category findById(int categoryId);
	
	List<Category> findByCategoryName(String categoryName);
}

