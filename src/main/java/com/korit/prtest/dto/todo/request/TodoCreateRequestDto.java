package com.korit.prtest.dto.todo.request;

import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class TodoCreateRequestDto {
    String todoPreparationContent;
}