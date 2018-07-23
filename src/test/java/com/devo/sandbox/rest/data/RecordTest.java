package com.devo.sandbox.rest.data;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(JUnitPlatform.class)
class RecordTest {

  private static final Logger log = LoggerFactory.getLogger(RecordTest.class);
  private static ObjectMapper mapper = new ObjectMapper();

  @BeforeAll
  static void setUp() {
    log.info("Setting up tests");
    mapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
  }

  @AfterAll
  static void tearDown() {
    log.info("Tearing down tests");
  }

  @Test
  void serialization () throws Exception {

    Record<String> record = new Record<>();
    record.setId(UUID.randomUUID().toString());
    record.setSequence(1);
    record.setPayload("sample data");

    String jsonString = mapper.writeValueAsString(record);
    assertNotNull(jsonString, "string is not null");
    assertNotEquals("", jsonString, "string is not empty");

    log.info("Json string content: {}", jsonString);
  }

  @Test
  void deserialization () throws Exception {

    String jsonString = "{'id':'1234','sequence':1,'payload':'data'}";
    Record<String> record = mapper.readValue(
        jsonString, new TypeReference<Record<String>>() {}
    );

    assertEquals("1234", record.getId());
    assertEquals(1, record.getSequence());
    assertEquals("data", record.getPayload());
  }

}