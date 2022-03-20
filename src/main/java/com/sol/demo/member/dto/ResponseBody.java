package com.sol.demo.member.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode
public class ResponseBody {
  @JsonProperty
  private int status;
  @JsonProperty
  private String message;
  @JsonProperty
  private Object data;

  @Builder
  public ResponseBody(int status, String message, Object data) {
    this.status = status;
    this.message = message;
    this.data = data;
  }
}