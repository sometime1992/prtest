package com.korit.prtest.repository;

import com.korit.prtest.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<com.korit.prtest.entity.Todo, Long> {
//
//    @Query("SELECT t FROM Todo t WHERE t.user.id = :userId " +
//            "AND FUNCTION('DATE', t.todoCreateAt) = :day " +
//            "ORDER BY t.todoCreateAt ASC")
//    List<Todo> findTodosByUserIdAndDay(@Param("userId") Long userId, @Param("day") LocalDate day);
}
