package com.blogmanagement.blogmanagement.dto;

import com.blogmanagement.blogmanagement.Model.BlogModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class AllResponse {
    private List<BlogModel> message;
    private long time;
}
