package com.devo.sandbox.rest.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Record<T> {

  private String id;
  private int sequence;
  private T payload;

  public String getId() {

    return id;
  }

  public void setId(String id) {

    this.id = id;
  }

  public int getSequence() {

    return sequence;
  }

  public void setSequence(int sequence) {

    this.sequence = sequence;
  }

  public T getPayload() {

    return payload;
  }

  public void setPayload(T payload) {

    this.payload = payload;
  }
}
