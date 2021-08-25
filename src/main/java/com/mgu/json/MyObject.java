package com.mgu.json;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyObject {
    @JsonDeserialize(using = MyProfileDeserializer.class)
    private List<String> profile = new ArrayList<>();

    public MyObject() {
    }

    public List<String> getProfile() {
        return profile;
    }

    public void setProfile(List<String> profile) {
        this.profile = profile;
    }
}

class MyProfileDeserializer extends JsonDeserializer<List<String>> {
    @Override
    public List<String> deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JsonProcessingException {
        String value = p.getValueAsString();
        if(value!=null) {
            return Arrays.asList(value);
        } else {
            ObjectCodec oc = p.getCodec();
            JsonNode node = oc.readTree(p);
            List<String> res = new ArrayList<>();
            node.elements().forEachRemaining(n -> {
                res.add(n.asText());
            });
            return res;
        }
    }
}