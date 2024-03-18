package com.example.firstspringbootproject;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@RestController
public class AppController {

    @GetMapping("/todo/{id}")
    public ToDo getToDo(@PathVariable String id) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://jsonplaceholder.typicode.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ToDoService service = retrofit.create(ToDoService.class);

        Call<ToDo> reposne = service.getTodo(id);

        return reposne.execute().body();
    }
}
