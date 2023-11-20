package com.rara.app.controller;


import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.service.DailyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.*;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/schedule/api")
public class DailyPlanApiController {

    @Autowired
    DailyPlanService dailyPlanService;
    
}

