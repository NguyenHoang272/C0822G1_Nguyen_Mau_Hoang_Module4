package blogmanagement.blogmanagement.repository;

import blogmanagement.blogmanagement.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    Category findById(int id);
}
