package com.example.surveyapi.services;

import com.example.surveyapi.models.Answers;
import com.example.surveyapi.repositories.AnswersRepository;
import com.example.surveyapi.utilities.AnswerCount;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class AnswersService {
    private final AnswersRepository answersRepository;

    public List<Answers> createAnswers(List<Answers> answers) {
        return answersRepository.saveAll(answers);
    }

    public List<AnswerCount> findCountByQno(String qno) {
        return convertToAnswerCountList(answersRepository.findCountByQno(qno));

    }

    private List<AnswerCount> convertToAnswerCountList(List<Object[]> resultList) {
        Map<String, Integer> resultMap = new HashMap<>();
        List<AnswerCount> answerCountList = new ArrayList<>();

        for(Object[] object : resultList) {
            AnswerCount answerCount = new AnswerCount();
            String ans = String.valueOf(object[0]);
            answerCount.setAnswer(ans);

            String stringToconvert = String.valueOf(object[1]);
            Long longValue = Long.parseLong(stringToconvert);
            answerCount.setCount(longValue);
            answerCountList.add(answerCount);

        }
        return answerCountList;
    }


}
