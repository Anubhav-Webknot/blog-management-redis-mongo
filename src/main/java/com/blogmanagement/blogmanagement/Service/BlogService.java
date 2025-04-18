package com.blogmanagement.blogmanagement.Service;

import com.blogmanagement.blogmanagement.Error.BlogNotFoundException;
import com.blogmanagement.blogmanagement.Model.BlogModel;

import java.util.List;

public interface BlogService {

    BlogModel saveBlog(BlogModel blog);

    List<BlogModel> fetchAllBlogs() throws BlogNotFoundException;

    BlogModel getBlogsById(String id) throws BlogNotFoundException;

    BlogModel updateBlogsById(String id, BlogModel blog) throws BlogNotFoundException;

    BlogModel deleteBlogById(String id) throws BlogNotFoundException;
}
