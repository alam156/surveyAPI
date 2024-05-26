package com.example.surveyapi.repositories;

import com.example.surveyapi.models.Answers;
import com.example.surveyapi.utilities.AnswerCount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Map;

public interface AnswersRepository extends JpaRepository<Answers, Long> {
    @Query(value = "select answer_text, count(*) from Answers where qno = ?1 group by answer_text", nativeQuery = true)
    List<Object[]> findCountByQno(String qNo);

}
