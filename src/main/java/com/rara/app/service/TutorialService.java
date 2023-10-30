package com.rara.app.service;

import java.util.List;
import com.rara.app.dto.TutorialDTO;
 
public interface TutorialService {
    void createTutorial(TutorialDTO tutorialDTO) throws Exception;
    void deleteTutorial(Long id) throws Exception;
    void updateTutorial(TutorialDTO tutorialDTO) throws Exception;
    List<TutorialDTO> readTutorial() throws Exception;
    List<TutorialDTO> freadTutorial() throws Exception;
}