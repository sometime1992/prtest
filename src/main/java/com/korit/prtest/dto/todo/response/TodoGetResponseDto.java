package com.korit.prtest.dto.todo.response;

import com.korit.prtest.entity.Todo;

import java.util.Date;

public class TodoGetResponseDto {
    Long todoId;
    String todoPreparationContent;
    Date todoCreateAt;

    public TodoGetResponseDto(com.korit.prtest.entity.Todo createdTodo) {
    }
}
