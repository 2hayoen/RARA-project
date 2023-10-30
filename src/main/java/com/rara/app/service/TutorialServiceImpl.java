package com.rara.app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rara.app.dto.TutorialDTO;
import com.rara.app.model.mapper.TutorialMapper;

@Service
public class TutorialServiceImpl implements TutorialService {
    @Autowired
    TutorialMapper tutorialMapper;
    
    @Override
    public void createTutorial(TutorialDTO tutorialDTO) throws Exception {
        tutorialMapper.createTutorial(tutorialDTO);
    }

    @Override
    public void deleteTutorial(Long id) throws Exception {
        tutorialMapper.deleteTutorial(id);
    }

    @Override
    public void updateTutorial(TutorialDTO tutorialDTO) throws Exception {
        tutorialMapper.updateTutorial(tutorialDTO);
    }

    @Override
    public List<TutorialDTO> readTutorial() throws Exception {
        return tutorialMapper.readTutorial();
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<TutorialDTO> freadTutorial() throws Exception {
		Map<String, Object> params = new HashMap<>();
		tutorialMapper.freadTutorial(params);
		return (List<TutorialDTO>) params.get("cursor");
    }
    
}

