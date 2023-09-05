package ru.ddc.headhunter.core.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.ddc.headhunter.core.dto.Item;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {ItemConverter.class, ObjectMapper.class})
class ItemConverterTest {

    @Autowired
    private ItemConverter converter;

    @Test
    void objectMap() {
        Item item = new Item();
        item.setAlternate_url("https://hh.ru/vacancy/86180458");
        item.setName("Java developer");
        String pattern = "<a href='${alternate_url}'>${name}</a>";
        String notification = converter.convertToString(pattern, item);
        assertEquals("<a href='https://hh.ru/vacancy/86180458'>Java developer</a>", notification);
    }
}