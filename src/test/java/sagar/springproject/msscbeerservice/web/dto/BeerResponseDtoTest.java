package sagar.springproject.msscbeerservice.web.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.junit.jupiter.api.Assertions.*;

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
        String json = "{\"version\":null,\"beerName\":\"Some beer\",\"beerStyle\":\"ALE\",\"upc\":12384938877834,\"price\":10.2200000000000006394884621840901672840118408203125,\"quantityOnHand\":null,\"id\":\"fc4d74ab-7750-4a8a-8c93-119ddc661b3e\",\"modifiedDate\":\"2022-10-19T20:24:33.541058155+05:30\",\"createdDate\":\"2022-10-19T20:24:33.541010733+05:30\"}\n";
        BeerResponseDto dto = objectMapper.readValue(json, BeerResponseDto.class);
        System.out.println(dto);
    }
}