package com.example.firstspringbootproject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface ToDoService {

    @GET("todos/{id}")
    Call<ToDo> getTodo(@Path("id") String id);
}
