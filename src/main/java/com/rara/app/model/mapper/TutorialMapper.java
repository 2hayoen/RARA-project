package com.rara.app.model.mapper;

import java.util.List;
import java.util.Map;

import com.rara.app.dto.TutorialDTO;


public interface TutorialMapper {
  void createTutorial(TutorialDTO tutorialDTO);
  void deleteTutorial(Long id);
  void updateTutorial(TutorialDTO tutorialDTO);
  List<TutorialDTO> readTutorial();
  void freadTutorial(Map<String, Object> params);
}
