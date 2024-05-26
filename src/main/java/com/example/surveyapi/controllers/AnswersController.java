package com.example.surveyapi.controllers;

import com.example.surveyapi.models.Answers;
import com.example.surveyapi.services.AnswersService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/")
public class AnswersController {
    private final AnswersService answersService;
    @CrossOrigin(origins = {"http://localhost:3000", "http://127.0.0.1:3000"})
    @PostMapping("send-answers")
    public List<Answers> createFeature(@RequestBody @Valid List<Answers> answers) {
        return answersService.createAnswers(answers);
    }

    @GetMapping("get-answers/{questionNo}")
    public ResponseEntity<?> getAnswers(@PathVariable String questionNo) {
        return ResponseEntity.ok(answersService.findCountByQno(questionNo));
    }


}
