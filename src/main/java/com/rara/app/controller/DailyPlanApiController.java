package com.rara.app.controller;


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

@RestController
@RequestMapping("/schedule/api")
public class DailyPlanApiController {

    @Autowired
    DailyPlanService dailyPlanService;

    @GetMapping("/calendar")
    public ResponseEntity<List<List<String>>> getCalendar(
            @RequestParam(name = "year", required = false) Integer intYear,
            @RequestParam(name = "month", required = false) Integer intMonth) {
        try {
            String cmd = "cd";
            Process p = Runtime.getRuntime().exec("cmd /c " + cmd);

            BufferedReader r = new BufferedReader(new InputStreamReader(
                    p.getInputStream(), Charset.forName("EUC-KR")));
            String l = r.readLine();

            String resourcesPath = l + "\\src\\main\\resources\\";
            String filePath = resourcesPath + "uipath\\result\\test2.xlsx";

            String pkgName = "CalendarTest2.1.0.1.nupkg";

//            System.out.println(l);

            String year = intYear.toString();
            String month = intMonth.toString();

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
//                System.out.println(line);
                calendar.append(line);
                calendar.append("\n");
                calendarStr += line;
            }

//            System.out.println(calendar);
//            System.out.println(calendarStr);

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
//            System.out.println(new String(readBuffer)); //출력

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


//            for (List<String> tempList : strDayList) {
//                System.out.println(tempList);
//            }

            int exitCode = process.waitFor();
            System.out.println("프로세스 종료 코드: " + exitCode);

//            model.addAttribute("calendarNestedList", strDayList);

//            return "redirect:/schedule/test2";
            return ResponseEntity.ok(strDayList);
        } catch (Exception e) {
            return null;
        }

    }

    @PostMapping("/uploadOnData")
    public ResponseEntity<?> uploadOnData(@RequestBody List<String> onData) {
        try {
            // onData 리스트를 데이터베이스에 저장하는 로직
            System.out.println(onData);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok("On 데이터가 성공적으로 업로드되었습니다.");
    }
}

