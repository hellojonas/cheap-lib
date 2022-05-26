package dev.hellojonas.cheaplib.dojo;

import java.util.List;

public interface PageModel<T> {
    Long getTotal();
    Integer getTotalPages();
    Integer getCurrentPage();
    Integer getPageSize();
    List<T> getData();
}


