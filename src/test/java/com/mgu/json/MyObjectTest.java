package com.mgu.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class MyObjectTest {

    @Test
    @DisplayName("test the unmarshalling with one profile as a list")
    void testTheUnmarshallingWithOneProfileAsAList() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String userInfoAsJson = "{\n"
                + "  \"profile\" : [\"P1\"]\n"
                + "}";


        TypeReference<MyObject> typeRef = new TypeReference<MyObject>() {};
        MyObject ui = mapper.readValue(userInfoAsJson, typeRef);
        assertEquals(ui.getProfile().size(),1);
    }

    @Test
    @DisplayName("test the unmarshalling with multiple profiles")
    void testTheUnmarshallingWithMultipleProfiles() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String userInfoAsJson = "{\n"
                + "  \"profile\" : [\"P1\", \"P2\"]\n"
                + "}";

        TypeReference<MyObject> typeRef = new TypeReference<MyObject>() {};
        MyObject ui = mapper.readValue(userInfoAsJson, typeRef);
        assertEquals(ui.getProfile().size(),2);
    }

    @Test
    @DisplayName("test the unmarshalling with one profile as a single string")
    void testTheUnmarshallingWithOneProfileAsASingleString() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String userInfoAsJson = "{\n"
                + "  \"profile\" : \"P1\"\n"
                + "}";


        TypeReference<MyObject> typeRef = new TypeReference<MyObject>() {};
        MyObject ui = mapper.readValue(userInfoAsJson, typeRef);
        assertEquals(ui.getProfile().size(),1);
    }

}