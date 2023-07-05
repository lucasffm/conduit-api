package com.lucasffm.conduitapi.dtos.user;

public class UserWrapperDTO<T> {

  private T user;

  public T getUser() {
    return user;
  }

  public void setUser(T user) {
    this.user = user;
  }
}
