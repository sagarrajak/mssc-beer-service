package sagar.springproject.msscbeerservice.web.dto;

import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class BeerPagedList extends PageImpl<BeerRequestDto> {
    public BeerPagedList(List<BeerRequestDto> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPagedList(List<BeerRequestDto> content) {
        super(content);
    }
}
