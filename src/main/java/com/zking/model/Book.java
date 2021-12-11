package com.zking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Book {
    private Integer bookId;

    private String bookName;

    private Float bookPrice;

    private String bookBrief;

    private String hoby;

    private List<String> courses;

    private List<String> sex;

}