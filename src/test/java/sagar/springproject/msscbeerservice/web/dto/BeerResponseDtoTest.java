package sagar.springproject.msscbeerservice.web.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

@JsonTest
class BeerResponseDtoTest extends  BeerResponseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerResponseDto beerResponseDto = this.getBeerResponseDto();
        String jsonString = objectMapper.writeValueAsString(beerResponseDto);
        System.out.println(jsonString);
    }

    @Test
    void testDeserializedDto() throws JsonProcessingException {
        String json = "{\"version\":null,\"beerName\":\"Some beer\",\"beerStyle\":\"ALE\",\"upc\":12384938877834,\"price\":\"10.2200000000000006394884621840901672840118408203125\",\"quantityOnHand\":null,\"id\":\"18ea86bb-c3c4-424b-a668-aa0769cc2b85\",\"modifiedDate\":\"2022-10-22T18:00:51.413478663+05:30\",\"createdDate\":\"2022-10-22T18:00:51.413425654+05:30\",\"mylLocalDate\":\"20221022\"}\n";
        BeerResponseDto dto = objectMapper.readValue(json, BeerResponseDto.class);
        System.out.println(dto);
    }
}