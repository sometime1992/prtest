package com.korit.prtest.controller;

import com.korit.prtest.common.ApiMappingPattern;
import com.korit.prtest.dto.ResponseDto;
import com.korit.prtest.dto.todo.request.TodoCreateRequestDto;
import com.korit.prtest.dto.todo.response.TodoCreateReponseDto;
import com.korit.prtest.dto.todo.response.TodoGetResponseDto;
import com.korit.prtest.dto.todo.response.TodoUpdateResponseDto;
import com.korit.prtest.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiMappingPattern.TODO)
@RequiredArgsConstructor
public class TodoController {
    private final TodoService todoService;
//
//    @PostMapping
//    private ResponseEntity<ResponseDto<TodoCreateReponseDto>> createTodo (
//            @AuthenticationPrincipal Long id,
//            @RequestBody TodoCreateRequestDto dto
//    ) {
//        ResponseDto<TodoCreateReponseDto> response = todoService.createTodo(id, dto);
//        HttpStatus status = response.isResult()? HttpStatus.OK : HttpStatus.NOT_FOUND;
//        return ResponseEntity.status(status).body(response);
//    }
//
//    @GetMapping
//    private ResponseEntity<ResponseDto<List<TodoGetResponseDto>>> getAllTodo (
//            @AuthenticationPrincipal Long id
//    ) {
//        ResponseDto<List<TodoGetResponseDto>> response = todoService.getAllTodo(id);
//        HttpStatus status = response.isResult()? HttpStatus.OK : HttpStatus.NOT_FOUND;
//        return ResponseEntity.status(status).body(response);
//    }
//
//    @GetMapping
//    private ResponseEntity<ResponseDto<TodoGetResponseDto>> getRecentTodo (
//            @AuthenticationPrincipal Long id,
//            @PathVariable Long todoId
//    ) {
//        ResponseDto<TodoGetResponseDto> response = todoService.getRecentTodo(id, todoId);
//        HttpStatus status = response.isResult()? HttpStatus.OK : HttpStatus.NOT_FOUND;
//        return ResponseEntity.status(status).body(response);
//    }
//
//    @PutMapping
//    private ResponseEntity<ResponseDto<TodoUpdateResponseDto>> updateTodo (
//            @AuthenticationPrincipal Long id,
//            @RequestBody TodoCreateRequestDto dto
//    ) {
//        ResponseDto<TodoUpdateResponseDto> response = todoService.updateTodo(dto);
//        HttpStatus status = response.isResult()? HttpStatus.OK : HttpStatus.NOT_FOUND;
//        return ResponseEntity.status(status).body(response);
//    }
//
//    @DeleteMapping
//    private ResponseEntity<ResponseDto<Void>> deleteTodo (
//            @AuthenticationPrincipal Long id,
//            @PathVariable Long todoId
//    ) {
//        ResponseDto<Void> response = todoService.deleteTodo(id, todoId);
//        HttpStatus status = response.isResult()? HttpStatus.OK : HttpStatus.NOT_FOUND;
//        return ResponseEntity.status(status).body(response);
//    }
}
