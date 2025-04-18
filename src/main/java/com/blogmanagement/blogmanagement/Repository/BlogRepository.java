package com.blogmanagement.blogmanagement.Repository;

import com.blogmanagement.blogmanagement.Model.BlogModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends MongoRepository<BlogModel, String> {

}
