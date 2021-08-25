package com.mgu.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MyObjectTest {
    @Test
    @DisplayName("test the unmarshalling with multiple profiles")
    void testTheUnmarshallingWithMultipleProfiles() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String userInfoAsJson = "{\"profile\" : [\"P1\", \"P2\"]}";

        TypeReference<MyObject> typeRef = new TypeReference<MyObject>() {};
        MyObject ui = mapper.readValue(userInfoAsJson, typeRef);
        assertEquals(ui.getProfile().size(),2);
    }

    @DisplayName("test the unmarshalling with one profile")
    @ParameterizedTest
    @ValueSource(strings = {"{\"profile\" : \"P1\"}", "{\"profile\" : [\"P1\"]}"})
    void testTheUnmarshallingWithOneProfile(String userInfoAsJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        TypeReference<MyObject> typeRef = new TypeReference<MyObject>() {};
        MyObject ui = mapper.readValue(userInfoAsJson, typeRef);
        assertEquals(ui.getProfile().size(),1);
    }
}