package dev.hellojonas.cheaplib.dojo;

import org.springframework.data.domain.Page;

import java.util.List;

public class PageWrapper<T> implements PageModel<T> {
    private Page<T> page;

    public PageWrapper(Page<T> page) {
        this.page = page;
    }

    @Override
    public Long getTotal() {
        return page.getTotalElements();
    }

    @Override
    public Integer getTotalPages() {
        return page.getTotalPages();
    }

    @Override
    public Integer getCurrentPage() {
        return page.getNumber();
    }

    @Override
    public Integer getPageSize() {
        return page.getSize();
    }

    @Override
    public List<T> getData() {
        return page.getContent();
    }
}
