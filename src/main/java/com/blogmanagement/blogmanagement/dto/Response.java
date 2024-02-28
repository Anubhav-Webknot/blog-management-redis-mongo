package com.blogmanagement.blogmanagement.dto;

import com.blogmanagement.blogmanagement.Model.BlogModel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class Response {

    private BlogModel message;
    private long time;


}
