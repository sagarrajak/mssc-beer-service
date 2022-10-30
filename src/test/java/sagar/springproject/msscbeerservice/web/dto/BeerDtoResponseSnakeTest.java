package sagar.springproject.msscbeerservice.web.dto;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;
import sagar.springproject.models.BeerResponseDto;

@ActiveProfiles("snake")
@JsonTest
public class BeerDtoResponseSnakeTest extends BeerResponseTest {
    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializeDto() throws JsonProcessingException {
        BeerResponseDto beerResponseDto = this.getBeerResponseDto();
        String jsonString = objectMapper.writeValueAsString(beerResponseDto);
        System.out.println(jsonString);
    }

}
