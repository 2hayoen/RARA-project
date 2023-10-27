package com.rara.app.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rara.app.dto.TutorialDTO;
import com.rara.app.service.TutorialService;

@RestController
@RequestMapping("/api/tutorials")
public class TutorialController {

    @Autowired
    TutorialService tutorialService;

    // 모든 튜토리얼 읽기
    @GetMapping("/")
    public ResponseEntity<List<TutorialDTO>> readAllTutorials() {
        try {
            List<TutorialDTO> tutorials = tutorialService.readTutorial();
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
    // 모든 튜토리얼 읽기
    @GetMapping("/t")
    public ResponseEntity<List<TutorialDTO>> freadAllTutorials() {
        try {
            List<TutorialDTO> tutorials = tutorialService.freadTutorial();
            return new ResponseEntity<>(tutorials, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    

    // 튜토리얼 생성
    @PostMapping("/")
    public ResponseEntity<TutorialDTO> createTutorial(@RequestBody TutorialDTO tutorialDTO) {
        try {
            tutorialService.createTutorial(tutorialDTO);
            return new ResponseEntity<>(tutorialDTO, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 튜토리얼 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteTutorial(@PathVariable Long id) {
        try {
            tutorialService.deleteTutorial(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // 튜토리얼 업데이트
    @PutMapping("/")
    public ResponseEntity<TutorialDTO> updateTutorial(@RequestBody TutorialDTO tutorialDTO) {
        try {
            tutorialService.updateTutorial(tutorialDTO);
            return new ResponseEntity<>(tutorialDTO, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}