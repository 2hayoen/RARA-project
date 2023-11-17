package com.rara.app.controller;

import com.rara.app.dto.DailyPlanDTO;
import com.rara.app.service.DailyPlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/act")
public class DailyPlanController {

    @Autowired
    DailyPlanService dailyPlanService;

    @GetMapping  // 접근 URL
    public String getDailyPlansAll(Model model) {
        try {
            List<DailyPlanDTO> dailyPlans = dailyPlanService.selectDailyPlansAll();
            // dailyPlanService를 호출. DailyPlan을 데이터베이스에서 검색
            // 이 정보를 DailyPlanDTO 객체의 목록 형태로 가져옴
            model.addAttribute("dailyPlans", dailyPlans);
            // model 객체를 사용. "dailyPlans"라는 속성 이름으로 dailyPlans 목록을 뷰에 전달
            // 이를 통해 뷰에서 이 데이터를 사용할 수 있음
            return "Act_input";
            // schedule"라는 뷰 이름을 반환하여 해당 뷰를 렌더링
            // Thymeleaf 템플릿 엔진에서 "schedule.html" 템플릿을 찾아 클라이언트에게 반환하도록 요청
        } catch (Exception e) {
            return "error"; // 예외가 발생하면 "error" 뷰로 리디렉션
        }
    }

    @GetMapping("/test")
    public String testDailyPlansAll(Model model) {
        try {
            List<DailyPlanDTO> dailyPlanDTOList = dailyPlanService.selectDailyPlansAll();
            for (DailyPlanDTO dp : dailyPlanDTOList) {
                String dpIdStr = Long.toString(dp.getId());
                DailyPlanDTO dp_u = DailyPlanDTO.builder()
                        .id(dp.getId()).year(dp.getYear()).month(dp.getMonth()).mId(dp.getMId())
                        .day(dp.getId())
                        .key1(dp.getKey1() + dpIdStr)
                        .act1Title("title" + dpIdStr)
                        .act1Type("type" + dpIdStr)
                        .act1Time(90L)
                        .act1Goal("goal" + dpIdStr)
                        .act1Desc("desc" + dpIdStr)
                        .act1Mater("mater" + dpIdStr)
                        .build();
                dailyPlanService.updateDailyPlan(dp_u);
            }
            List<DailyPlanDTO> dailyPlanDTOList_u = dailyPlanService.selectDailyPlansAll();
            model.addAttribute("dailyplans", dailyPlanDTOList_u);
            return "test/dailyPlans";

        } catch (Exception e) {
            return "error";
        }
    }

//    @GetMapping("/{id}")
//    public String getDailyPlanById(@PathVariable Long id, Model model) {
//        try {
//            DailyPlanDTO dailyPlan = dailyPlanService.selectDailyPlanById(id);
//            model.addAttribute("dailyPlan", dailyPlan);
//            return "schedule";
//        } catch (Exception e) {
//            return "error";
//        }
//    }

    @PostMapping
    // DB 저장
    public String createDP(DailyPlanDTO dailyPlanDTO) {
        try {
            dailyPlanService.insertDailyPlan(dailyPlanDTO);
            return "redirect:Act_input";
        } catch (Exception e) {
            return "redirect:Act_input";
        }
    }

    @PostMapping("/act")
    public String updateAct(DailyPlanDTO dailyPlanDTO) {
        try {
            Map<String, Object> params = new HashMap<>();
            params.put("id", dailyPlanDTO.getId());
            params.put("act1Title", dailyPlanDTO.getAct1Title());
            params.put("act1Type", dailyPlanDTO.getAct1Type());
            params.put("act1Goal", dailyPlanDTO.getAct1Goal());
            params.put("act1Time", dailyPlanDTO.getAct1Time());
            params.put("act1Desc", dailyPlanDTO.getAct1Desc());
            params.put("act1Mater", dailyPlanDTO.getAct1Mater());
            params.put("act1Sub", dailyPlanDTO.getAct1Sub());
            System.out.println(dailyPlanDTO);
            dailyPlanService.updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(params);
            return "redirect:/schedule";
        } catch (Exception e) {
            return "error";
        }
    }

//    @GetMapping("/uirobot")
//    public String uirobot() {
//        try {
//            String cmd = "cd";
//            Process p = Runtime.getRuntime().exec("cmd /c " + cmd);
//
//            BufferedReader r = new BufferedReader(new InputStreamReader(
//                    p.getInputStream(), Charset.forName("EUC-KR")));
//            String l = r.readLine();
//
//            String resourcesPath = l + "\\src\\main\\resources\\";
//            String filePath = resourcesPath + "uipath\\result\\test.xlsx";
//
//            System.out.println(l);
//
//            String year = "2022";
//            String month = "8";
//            String command = "\"" + resourcesPath + "uirobot\\UiRobot.exe\" execute " +
//                    "--file \"" + resourcesPath + "uipath\\pkg\\CalendarTest.1.0.14.nupkg\" " +
//                    "--input \"{'In_Str_year' : '" + year + "' , 'In_Str_month' : '" + month + "', " +
//                    "'In_Str_filePath' : '" + filePath.replace("\\", "\\\\") + "'}\" ";
//
//            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
//            processBuilder.redirectErrorStream(true); // 에러 출력을 표준 출력으로 리다이렉션합니다.
//
//            Process process = processBuilder.start();
//
//            // 프로세스의 출력을 읽어오려면 아래와 같이 할 수 있습니다.
//            BufferedReader reader = new BufferedReader(new InputStreamReader(
//                    process.getInputStream(), Charset.forName("EUC-KR")));
//            String line;
//            StringBuffer calendar = new StringBuffer();
//
//            while ((line = reader.readLine()) != null) {
//                System.out.println(line);
//                calendar.append(line);
//                calendar.append("\n");
//            }
//            System.out.println(calendar);
//
//            int exitCode = process.waitFor();
//            System.out.println("프로세스 종료 코드: " + exitCode);
//            return "error";
//        } catch (Exception e) {
//            return "error";
//        }
//
//    }


    @GetMapping("/uirobot2")
    public String uirobot2(Model model) {
        try {
            String cmd = "cd";
            Process p = Runtime.getRuntime().exec("cmd /c " + cmd);

            BufferedReader r = new BufferedReader(new InputStreamReader(
                    p.getInputStream(), Charset.forName("EUC-KR")));
            String l = r.readLine();

            String resourcesPath = l + "\\src\\main\\resources\\";
            String filePath = resourcesPath + "uipath\\result\\test2.xlsx";

            String pkgName = "CalendarTest2.1.0.1.nupkg";

            System.out.println(l);

            String year = "2022";
            String month = "8";

            String command = "\"" + resourcesPath + "uirobot\\UiRobot.exe\" execute " +
                    "--file \"" + resourcesPath + "uipath\\pkg\\" + pkgName + "\" " +
                    "--input \"{'In_Str_year' : '" + year + "' , 'In_Str_month' : '" + month + "', " +
                    "'In_Str_filePath' : '" + filePath.replace("\\", "\\\\") + "'}\" ";

            ProcessBuilder processBuilder = new ProcessBuilder("cmd.exe", "/c", command);
            processBuilder.redirectErrorStream(true); // 에러 출력을 표준 출력으로 리다이렉션합니다.

            Process process = processBuilder.start();

            // 프로세스의 출력을 읽어오려면 아래와 같이 할 수 있습니다.
            BufferedReader reader = new BufferedReader(new InputStreamReader(
                    process.getInputStream(), Charset.forName("EUC-KR")));
            String line;
            StringBuffer calendar = new StringBuffer();
            String calendarStr = "";

            while ((line = reader.readLine()) != null) {
                System.out.println(line);
                calendar.append(line);
                calendar.append("\n");
                calendarStr += line;
            }

            System.out.println(calendar);
            System.out.println(calendarStr);

            String fileTxtPath = resourcesPath + "uipath\\text\\test2.txt"; // 대상 파일

            BufferedOutputStream bs = null;
            bs = new BufferedOutputStream(
                    new FileOutputStream(fileTxtPath));
            String str = calendarStr;
            bs.write(str.getBytes()); //Byte형으로만 넣을 수 있음
            bs.close();


            FileInputStream fileStream = null; // 파일 스트림
            fileStream = new FileInputStream(fileTxtPath);// 파일 스트림 생성
            //버퍼 선언
            byte[] readBuffer = new byte[fileStream.available()];
            while (fileStream.read(readBuffer) != -1) {
            }
            System.out.println(new String(readBuffer)); //출력

            fileStream.close(); //스트림 닫기

//            String[] calendarSplit = calendarStr.split("/");
            String[] calendarSplit = new String(readBuffer).split("/");

            List<List<String>> strDayList = new ArrayList<>();

            for (String strWeek : calendarSplit) {
                List<String> tempDayList = new ArrayList<>();
                for (String strDay : strWeek.split(",")) {
                    tempDayList.add(strDay);
                }
                if (tempDayList.size() > 1) {
                    strDayList.add(tempDayList.subList(1, tempDayList.size()));
                }
            }


            for (List<String> tempList : strDayList) {
                System.out.println(tempList);
            }

            int exitCode = process.waitFor();
            System.out.println("프로세스 종료 코드: " + exitCode);

            model.addAttribute("calendarNestedList", strDayList);

//            return "redirect:/schedule/test2";
            return "schedule2";
        } catch (Exception e) {
            return "error";
        }

    }

    @GetMapping("/test2")  // 접근 URL
    public String getCalendar(Model model) {
        try {

            List<DailyPlanDTO> dailyPlans = dailyPlanService.selectDailyPlansAll();
            // dailyPlanService를 호출. DailyPlan을 데이터베이스에서 검색
            // 이 정보를 DailyPlanDTO 객체의 목록 형태로 가져옴
            model.addAttribute("dailyPlans", dailyPlans);
            // model 객체를 사용. "dailyPlans"라는 속성 이름으로 dailyPlans 목록을 뷰에 전달
            // 이를 통해 뷰에서 이 데이터를 사용할 수 있음
            return "schedule2";
            // schedule"라는 뷰 이름을 반환하여 해당 뷰를 렌더링
            // Thymeleaf 템플릿 엔진에서 "schedule.html" 템플릿을 찾아 클라이언트에게 반환하도록 요청
        } catch (Exception e) {
            return "error"; // 예외가 발생하면 "error" 뷰로 리디렉션
        }
    }

}
