package be.steven.d.dog.blogapp.repo;

import be.steven.d.dog.blogapp.model.BlogItem;
import org.springframework.data.repository.CrudRepository;

public interface BlogItemRepo extends CrudRepository<BlogItem, Integer> {
}
