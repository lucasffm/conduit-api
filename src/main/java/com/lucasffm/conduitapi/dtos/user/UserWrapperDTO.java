package com.lucasffm.conduitapi.dtos.user;

import com.fasterxml.jackson.annotation.JsonProperty;

public class UserWrapperDTO<T> {
  private static final String USER_KEY = "user";

  @JsonProperty(USER_KEY)
  private T user;

  public T getUser() {
    return user;
  }

  public void setUser(T user) {
    this.user = user;
  }
}
