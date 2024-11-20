package com.korit.prtest.service;


import com.korit.prtest.dto.ResponseDto;
import com.korit.prtest.dto.todo.request.TodoCreateRequestDto;
import com.korit.prtest.dto.todo.response.TodoCreateReponseDto;
import com.korit.prtest.dto.todo.response.TodoGetResponseDto;
import com.korit.prtest.dto.todo.response.TodoUpdateResponseDto;

import java.util.List;

public interface TodoService {

    ResponseDto<TodoCreateReponseDto> createTodo(Long id, TodoCreateRequestDto dto);

    ResponseDto<List<TodoGetResponseDto>> getAllTodo(Long id);

    ResponseDto<TodoGetResponseDto> getRecentTodo(Long id, Long todoId);

    ResponseDto<TodoUpdateResponseDto> updateTodo(TodoCreateRequestDto dto);

    ResponseDto<Void> deleteTodo(Long id, Long todoId);
}
