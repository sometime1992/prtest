package com.korit.prtest.dto.todo.response;

import com.korit.prtest.entity.Todo;

import java.time.LocalDateTime;

public class TodoCreateReponseDto {
    Long todoId;
    String todoPreparationContent;
    LocalDateTime todoCreateAt;

    public TodoCreateReponseDto(com.korit.prtest.entity.Todo todo) {
        this.todoId = todo.getTodoId();
        this.todoPreparationContent = todo.getTodoPreparationContent();
        this.todoCreateAt = todo.getTodoCreateAt();
    }
}
