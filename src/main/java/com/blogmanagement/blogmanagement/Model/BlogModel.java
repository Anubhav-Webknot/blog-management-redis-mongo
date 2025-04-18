package com.blogmanagement.blogmanagement.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BlogModel implements Serializable {

    @Id
    private String blogId;

    private String blogTitle;

    private String blogAuthor;

    private String blogBody;

    private String blogDate;

    private String blogCategory;



}
