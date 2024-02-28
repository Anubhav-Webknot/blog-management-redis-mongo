package com.blogmanagement.blogmanagement.Service;

import com.blogmanagement.blogmanagement.Error.BlogNotFoundException;
import com.blogmanagement.blogmanagement.Model.BlogModel;
import com.blogmanagement.blogmanagement.Repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BlogServiceImpl implements BlogService {

    @Autowired
    private BlogRepository blogRepository;
    @Override
    public BlogModel saveBlog(BlogModel blog) throws IllegalArgumentException {
        if (blog == null) {
            throw new IllegalArgumentException("Blog cannot be null");
        }

        return blogRepository.save(blog);
    }

    @Override
    public List<BlogModel> fetchAllBlogs() throws BlogNotFoundException {
        List<BlogModel> allBlogs = blogRepository.findAll();

        if (allBlogs.isEmpty()) {
            throw new BlogNotFoundException("No blogs found");
        }

        return allBlogs;
    }

    @Override
    public BlogModel getBlogsById(String id) throws BlogNotFoundException {
        Optional<BlogModel> blog = blogRepository.findById(id);


        if (blog.isPresent()) {
            return blog.get();
        }
        else{
            throw new BlogNotFoundException();
        }
    }

    @Override
    public BlogModel updateBlogsById(String id, BlogModel blog) throws BlogNotFoundException {

        BlogModel existingBlog = blogRepository.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found for id: " + id));


        existingBlog.setBlogTitle(blog.getBlogTitle());
        existingBlog.setBlogAuthor(blog.getBlogAuthor());
        existingBlog.setBlogBody(blog.getBlogBody());
        existingBlog.setBlogDate(blog.getBlogDate());
        existingBlog.setBlogCategory(blog.getBlogCategory());


        return blogRepository.save(existingBlog);
    }

    @Override
    public BlogModel deleteBlogById(String id) throws BlogNotFoundException {

        BlogModel blog = blogRepository.findById(id)
                .orElseThrow(() -> new BlogNotFoundException("Blog not found for id: " + id));


        blogRepository.delete(blog);
        return blog;
    }
}
