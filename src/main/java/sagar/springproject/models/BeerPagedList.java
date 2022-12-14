package sagar.springproject.models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.io.Serializable;
import java.util.List;

public class BeerPagedList<T> extends PageImpl<T> implements Serializable {
    private static final long serialVersionUID = 3248189030448292002L;
    @JsonCreator(mode = JsonCreator.Mode.PROPERTIES)
    public BeerPagedList(
                @JsonProperty("content") List<T> content,
                @JsonProperty("number") int number,
                @JsonProperty("size") int size,
                @JsonProperty("totalElements") Long totalElements,
                @JsonProperty("pageable") JsonNode pageable,
                @JsonProperty("last") boolean last,
                @JsonProperty("totalPages") int totalPages,
                @JsonProperty("sort") JsonNode sort,
                @JsonProperty("first") boolean first,
                @JsonProperty("numberOfElements") int numberOfElements
        ) {
        super(content, PageRequest.of(number, size), totalElements);
    }

    public BeerPagedList(List<T> content, Pageable pageable, long total) {
        super(content, pageable, total);
    }

    public BeerPagedList(List<T> content) {
        super(content);
    }
}
