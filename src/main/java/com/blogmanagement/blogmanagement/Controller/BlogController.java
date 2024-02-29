package com.blogmanagement.blogmanagement.Controller;

import com.blogmanagement.blogmanagement.Error.BlogNotFoundException;
import com.blogmanagement.blogmanagement.Model.BlogModel;
import com.blogmanagement.blogmanagement.Service.BlogService;
import com.blogmanagement.blogmanagement.dto.AllResponse;
import com.blogmanagement.blogmanagement.dto.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;
import java.time.Instant;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blog")
    public AllResponse fetchBlogList() throws BlogNotFoundException {
        Instant start = Instant.now();
        List<BlogModel> blogs = blogService.fetchAllBlogs();
        Instant end = Instant.now();
        long timebetween = Duration.between(start, end).toMillis();
        return  new AllResponse(blogs,timebetween);
    }

    @PostMapping("/blog")
    public Response saveBlog(@RequestBody BlogModel blog) {
        Instant start = Instant.now();
        BlogModel createBlogs = blogService.saveBlog(blog);
        Instant end = Instant.now();
        long timebetween = Duration.between(start, end).toMillis();
        return  new Response(createBlogs,timebetween);
    }


    @GetMapping("/blog/{id}")
    public Response fetchBlogById(@PathVariable String id) throws BlogNotFoundException {
        Instant start = Instant.now();
        BlogModel blogsById = blogService.getBlogsById(id);
        Instant end = Instant.now();
        long timebetween = Duration.between(start, end).toMillis();
        return new Response(blogsById, timebetween);
    }


    @PutMapping("/blog/{id}")
    public Response updateBlog(@PathVariable("id") String Id,@RequestBody BlogModel blog) throws BlogNotFoundException {
        Instant start = Instant.now();
        BlogModel updatedBlog = blogService.updateBlogsById(Id,blog);
        Instant end = Instant.now();
        long timebetween = Duration.between(start, end).toMillis();
        return new Response(updatedBlog, timebetween);
    }

    @DeleteMapping("/blog/{id}")
    public  Response deleteBlog(@PathVariable String id) throws BlogNotFoundException {
        Instant start = Instant.now();
        BlogModel deletedBlog = blogService.deleteBlogById(id);
        Instant end = Instant.now();
        long timebetween = Duration.between(start, end).toMillis();
        return new Response(deletedBlog, timebetween);

    }
}
