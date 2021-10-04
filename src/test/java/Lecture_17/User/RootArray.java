package Lecture_17.User;

import java.util.List;

@lombok.Data
public class RootArray {
    public int page;
    public int per_page;
    public int total;
    public int total_pages;
    public List<Data> data;
    public Support support;
}