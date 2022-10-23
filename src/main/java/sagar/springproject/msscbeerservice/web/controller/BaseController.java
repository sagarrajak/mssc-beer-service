package sagar.springproject.msscbeerservice.web.controller;

import org.springframework.data.domain.PageRequest;

public class BaseController {
    private static final Integer DEFAULT_PAGE_SIZE = 10;
    private static final Integer DEFAULT_PAGE_NUMBER = 1;

    protected PageRequest getPagedParams(Integer pageNumber, Integer pageSize) {
        if ( pageSize == null || pageSize < 0)
                pageNumber = DEFAULT_PAGE_SIZE;
        if (pageNumber == null || pageNumber < 0)
                pageNumber = DEFAULT_PAGE_NUMBER;

        return PageRequest.of(pageNumber, pageSize);
    }
}
