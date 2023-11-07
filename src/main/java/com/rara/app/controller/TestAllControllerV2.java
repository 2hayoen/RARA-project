package com.rara.app.controller;


import com.rara.app.dto.*;
import com.rara.app.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/api/testAll2")
public class TestAllControllerV2 {

    @Autowired
    MemberService memberService;

    @Autowired
    ChildService childService;

    @Autowired
    BoardService boardService;

    @Autowired
    DailyPlanService dailyPlanService;

    @Autowired
    DailyRecordService dailyRecordService;

    @GetMapping("/member")
    public String testMemberAll(Model model) {


        try {

            List<MemberDTO> members;
            MemberDTO member;
            Map<String, Object> params;
            MemberDTO memberDTO;

            memberDTO = MemberDTO.builder()
                    .email("email1").pwd("pwd1").name("name1").phNum("ph_num1").addr("addr1")
                    .emerNum("emer1").class_(null).center(null).position(null)
                    .separator("Custo").build();
            memberService.insertMember(memberDTO);

            memberDTO = MemberDTO.builder()
                    .email("email2").pwd("pwd2").name("name2").phNum("ph_num2").addr("addr2")
                    .emerNum(null).class_("class1").center("center1").position("pos1")
                    .separator("Teacher").build();
            memberService.insertMember(memberDTO);

            memberDTO = MemberDTO.builder()
                    .email("email3").pwd("pwd3").name("name3").phNum("ph_num3").addr("addr3")
                    .emerNum(null).class_("class1").center("center1").position("pos2").mId(2L)
                    .separator("Teacher").build();
            memberService.insertMember(memberDTO);

            memberDTO = MemberDTO.builder()
                    .email("4").pwd("4").name("4").phNum("4").addr("4")
                    .emerNum("4").class_(null).center(null).position(null)
                    .separator("Custo").build();
            memberService.insertMember(memberDTO);

            members = memberService.selectMembersAll();
            model.addAttribute("membersInserted", members);

            member = memberService.selectMemberById(1L);
            model.addAttribute("memberByID", member);

            member = memberService.selectMemberByEmail("email1");
            model.addAttribute("memberByEmail", member);

            members = memberService.selectMemberBySeparator("Teacher");
            model.addAttribute("membersBySeparator", members);

            members = memberService.selectMemberBySeparatorAndName("Teacher", "name2");
            model.addAttribute("membersBySeparatorAndName", members);

            members = memberService.selectMemberBySeparatorAndPhNum("Teacher", "ph_num2");
            model.addAttribute("membersBySeparatorAndPhNum", members);

            members = memberService.selectMemberBySeparatorAndMId("Teacher", 2L);
            model.addAttribute("membersBySeparatorAndMId", members);

            members = memberService.selectMemberBySeparatorAndCenter("Teacher", "center1");
            model.addAttribute("membersBySeparatorAndCenter", members);

            members = memberService.selectMemberBySeparatorAndCenterAndName(
                    "Teacher", "center1", "name2");
            model.addAttribute("membersBySeparatorAndCenterAndName", members);

            members = memberService.selectMemberBySeparatorAndCenterAndClass_(
                    "Teacher", "center1", "class1");
            model.addAttribute("membersBySeparatorAndCenterAndClass", members);

            members = memberService.selectMemberBySeparatorAndCenterAndPosition(
                    "Teacher", "center1", "pos1");
            model.addAttribute("membersBySeparatorAndCenterAndPosition", members);

            memberDTO = MemberDTO.builder().id(1L)
                    .email("u_email1").pwd("u_pwd1").name("u_name1").phNum("u_ph_num1")
                    .addr("u_addr1").emerNum("u_emer1").separator("u_Custo").build();
            memberService.updateMember(memberDTO);


            memberService.updateMemberSetEmail(2L, "u_email2");
            memberService.updateMemberSetPwd(2L, "u_pwd2");
            memberService.updateMemberSetName(2L, "u_name2");
            memberService.updateMemberSetPhNum(2L, "u_ph_num2");
            memberService.updateMemberSetAddr(2L, "u_addr2");

            model.addAttribute(
                    "membersUpdated", memberService.selectMembersAll());

            memberService.deleteMember(4L);

            model.addAttribute(
                    "membersDeleted", memberService.selectMembersAll());

            return "test/all/member";

        } catch (Exception e) {
            model.addAttribute("msg", "Member Error!");
            return "error";
        }
    }

    @GetMapping("/board")
    public String testBoardAll(Model model) {

        try {

            Map<String, Object> params;
            BoardDTO boardDTO;

            boardDTO = BoardDTO.builder()
                    .title("title1").content("content1").category("category1")
                    .file1("file1-1").file2("file1-2").mId(1L).author("author1").build();
            boardService.insertBoard(boardDTO);

            boardDTO = BoardDTO.builder()
                    .title("title2").content("content2").category("category2")
                    .file1("file2-1").mId(2L).author("author2").build();
            boardService.insertBoard(boardDTO);

            boardDTO = BoardDTO.builder()
                    .title("3").content("3").category("category1")
                    .file1("3").mId(3L).author("3").build();
            boardService.insertBoard(boardDTO);

            model.addAttribute(
                    "boardsInserted", boardService.selectBoardsAll()
            );

            model.addAttribute(
                    "boardById", boardService.selectBoardById(1L)
            );

            model.addAttribute(
                    "boardByCategory",
                    boardService.selectBoardByCategory("category1")
            );

            model.addAttribute(
                    "boardByCategoryAndTitle",
                    boardService.selectBoardByCategoryAndTitle("category1", "title")
            );

            model.addAttribute(
                    "boardByCategoryAndContent",
                    boardService.selectBoardByCategoryAndContent("category2", "content")
            );

            model.addAttribute(
                    "boardByCategoryAndMId",
                    boardService.selectBoardByCategoryAndMId("category1", 1L)
            );

            boardDTO = BoardDTO.builder()
                    .id(1L).title("u_title1").content("u_content1")
                    .category("u_cate1").file1("u_file1-1").file2("u_file1-2").build();
            boardService.updateBoard(boardDTO);

            boardService.updateTitle(2L, "u_title2");
            boardService.updateContent(2L, "u_content2");
            boardService.updateCategory(2L, "u_cate2");
            boardService.updateFile1(2L, "u_file2-1");
            boardService.updateFile2(2L, "u_file2-2");

            model.addAttribute("boardsUpdated", boardService.selectBoardsAll());

            boardService.deleteBoard(3L);

            model.addAttribute("boardsDeleted", boardService.selectBoardsAll());

            return "test/all/board";
        } catch (Exception e) {
            model.addAttribute("msg", "Board Error!");
            return "error";
        }
    }

    @GetMapping("/child")
    public String testChildAll(Model model) {

        try {

            Map<String, Object> params;
            ChildDTO childDTO;

            childDTO = ChildDTO.builder()
                    .name("name1").birth("birth1").photo("photo1")
                    .property("property1").mTId(2L).mCId(1L).build();
            childService.insertChild(childDTO);

            childDTO = ChildDTO.builder()
                    .name("name2").birth("birth2").photo("photo2")
                    .property("property2").mTId(3L).mCId(1L).build();
            childService.insertChild(childDTO);

            childDTO = ChildDTO.builder()
                    .name("3").birth("3").photo("3")
                    .property("3").mTId(2L).mCId(1L).build();
            childService.insertChild(childDTO);

            model.addAttribute(
                    "childrenInserted", childService.selectChildrenAll()
            );

            model.addAttribute(
                    "childById", childService.selectChildById(1L)
            );

            model.addAttribute(
                    "childrenByName", childService.selectChildByName("name")
            );

            model.addAttribute(
                    "childrenByBirth", childService.selectChildByBirth("birth1")
            );

            model.addAttribute(
                    "childrenByMTId", childService.selectChildByMTId(2L)
            );

            model.addAttribute(
                    "childrenByMCId", childService.selectChildByMCId(1L)
            );

            childDTO = ChildDTO.builder()
                    .id(1L).name("u_name1").birth("u_birth1")
                    .photo("u_photo1").property("u_property1")
                    .mTId(3L).mCId(2L).build();
            childService.updateChild(childDTO);

            childService.updateChildSetName(2L, "u_name2");
            childService.updateChildSetBirth(2L, "u_birth2");
            childService.updateChildSetPhoto(2L, "u_photo2");
            childService.updateChildSetProperty(2L, "u_property2");
            childService.updateChildSetMTId(2L, 2L);
            childService.updateChildSetMCId(2L, 3L);

            model.addAttribute(
                    "childrenUpdated", childService.selectChildrenAll()
            );

            childService.deleteChild(3L);

            model.addAttribute(
                    "childrenDeleted", childService.selectChildrenAll()
            );

            return "test/all/child";
        } catch (Exception e) {
            model.addAttribute("msg", "Child Error!");
            return "error";
        }
    }

    @GetMapping("/dailyplan")
    public String testDailyPlanAll(Model model) {

        try {

            Map<String, Object> params;
            DailyPlanDTO dailyPlanDTO;

            dailyPlanDTO = DailyPlanDTO.builder()
                    .year(2023L).month(10L).key1("key1-1").mId(1L).build();
            dailyPlanService.insertDailyPlan(dailyPlanDTO);

            dailyPlanDTO = DailyPlanDTO.builder()
                    .year(2022L).month(5L).key1("key2-1").mId(3L).build();
            dailyPlanService.insertDailyPlan(dailyPlanDTO);

            dailyPlanDTO = DailyPlanDTO.builder()
                    .year(3L).month(3L).key1("3").mId(3L).build();
            dailyPlanService.insertDailyPlan(dailyPlanDTO);

            model.addAttribute(
                    "dailyPlansInserted", dailyPlanService.selectDailyPlansAll()
            );

            dailyPlanService.updateDailyPlanSetYear(2L, 2023L);
            dailyPlanService.updateDailyPlanSetMonth(2L, 8L);
            dailyPlanService.updateDailyPlanSetKey1(2L, "u_key2-1");
            dailyPlanService.updateDailyPlanSetKey2(2L, "u_key2-2");
            dailyPlanService.updateDailyPlanSetKey3(2L, "u_key2-3");
            dailyPlanService.updateDailyPlanSetDay(2L, 1L);
            dailyPlanService.updateDailyPlanSetFile1(2L, "u_file2-1");
            dailyPlanService.updateDailyPlanSetFile2(2L, "u_file2-2");
            dailyPlanService.updateDailyPlanSetMId(2L, 2L);

            dailyPlanDTO = DailyPlanDTO.builder()
                    .id(1L).year(2021L).month(1L).day(1L).mId(1L)
                    .key1("uu_key1-1").build();
            dailyPlanService.updateDailyPlan(dailyPlanDTO);

            params = new HashMap<>();
            params.put("id", 2L);
            params.put("act1Type", "act2-1-type");
            params.put("act1Goal", "act2-1-goal");
            params.put("act1Time", 90L);
            params.put("act1Title", "act2-1-title");
            params.put("act1Sub", "act2-1-sub");
            params.put("act1Desc", "act2-1-desc");
            params.put("act1Mater", "act2-1-mater");
            dailyPlanService.updateDailyPlanSetAct1TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(params);

            params = new HashMap<>();
            params.put("id", 2L);
            params.put("act2Type", "act2-2-type");
            params.put("act2Goal", "act2-2-goal");
            params.put("act2Time", 90L);
            params.put("act2Title", "act2-2-title");
            params.put("act2Sub", "act2-2-sub");
            params.put("act2Desc", "act2-2-desc");
            params.put("act2Mater", "act2-2-mater");
            dailyPlanService.updateDailyPlanSetAct2TypeAndGoalAndTimeAndTitleAndSubAndDescAndMater(params);

            model.addAttribute(
                    "dailyPlanUpdated", dailyPlanService.selectDailyPlansAll()
            );

            model.addAttribute(
                    "dailyPlanById", dailyPlanService.selectDailyPlanById(1L)
            );

            model.addAttribute(
                    "dailyPlanByMonth",
                    dailyPlanService.selectDailyPlanByMonth(8L)
            );

            model.addAttribute(
                    "dailyPlanByDay",
                    dailyPlanService.selectDailyPlanByDay(1L)
            );

            model.addAttribute(
                    "dailyPlanByYear",
                    dailyPlanService.selectDailyPlanByYear(2023L)
            );

            model.addAttribute(
                    "dailyPlanByYearAndMonth",
                    dailyPlanService.selectDailyPlanByYearAndMonth(2023L, 10L)
            );

            model.addAttribute(
                    "dailyPlanByYearAndMonthAndDay",
                    dailyPlanService.selectDailyPlanByYearAndMonthAndDay(2023L, 8L, 1L)
            );

            model.addAttribute(
                    "dailyPlanByFile1",
                    dailyPlanService.selectDailyPlanByFile1("u_file2-1")
            );

            model.addAttribute(
                    "dailyPlanByFile2",
                    dailyPlanService.selectDailyPlanByFile2("u_file2-2")
            );


            params = new HashMap<>();
            params.put("mId", 2L);
            model.addAttribute(
                    "dailyPlanByMId",
                    dailyPlanService.selectDailyPlanByMId(2L)
            );

            params = new HashMap<>();
            params.put("mId", 2L);
            params.put("year", 2023L);
            model.addAttribute(
                    "dailyPlanByMIdAndYear",
                    dailyPlanService.selectDailyPlanByMIdAndYear(2L, 2023L)
            );

            params = new HashMap<>();
            params.put("mId", 2L);
            params.put("title", "title");
            model.addAttribute(
                    "dailyPlanByMIdAndTitle",
                    dailyPlanService.selectDailyPlanByMIdAndActTitle(2L, "title")
            );

            params = new HashMap<>();
            params.put("mId", 2L);
            params.put("type", "type");
            model.addAttribute(
                    "dailyPlanByMIdAndType",
                    dailyPlanService.selectDailyPlanByMIdAndActType(2L, "type")
            );

            dailyPlanService.deleteDailyPlan(3L);

            model.addAttribute(
                    "dailyPlanDeleted", dailyPlanService.selectDailyPlansAll()
            );

            return "test/all/dailyPlan";
        } catch (Exception e) {
            model.addAttribute("msg", "dailyPlan Error!");
            return "error";
        }
    }

    @GetMapping("/dailyrecord")
    public String testDailyRecordAll(Model model) {

        try {

            Map<String, Object> params;
            DailyRecordDTO dailyRecordDTO;

            dailyRecordDTO = DailyRecordDTO.builder()
                    .title("title1").content("content1")
                    .cId(1L).dpId(1L).build();
            dailyRecordService.insertDailyRecord(dailyRecordDTO);

            dailyRecordDTO = DailyRecordDTO.builder()
                    .title("title2").content("content2")
                    .cId(2L).dpId(2L).build();
            dailyRecordService.insertDailyRecord(dailyRecordDTO);

            dailyRecordDTO = DailyRecordDTO.builder()
                    .title("3").content("3")
                    .cId(1L).dpId(2L).build();
            dailyRecordService.insertDailyRecord(dailyRecordDTO);

            model.addAttribute(
                    "dailyRecordInserted",
                    dailyRecordService.selectDailyRecordsAll()
            );

            dailyRecordDTO = DailyRecordDTO.builder()
                    .id(1L).title("u_title1").content("u_content1")
                    .cId(2L).dpId(1L).build();
            dailyRecordService.updateDailyRecord(dailyRecordDTO);

            dailyRecordService.updateDailyRecordSetTitle(2L, "u_title2");
            dailyRecordService.updateDailyRecordSetContent(2L, "u_content2");
            dailyRecordService.updateDailyRecordSetFile1(2L, "u_file2-1");
            dailyRecordService.updateDailyRecordSetFile2(2L, "u_file2-2");
            dailyRecordService.updateDailyRecordSetAct1Rec(2L, "u_act1_rec2");
            dailyRecordService.updateDailyRecordSetAct2Rec(2L, "u_act2_rec2");
            dailyRecordService.updateDailyRecordSetDpId(2L, 1L);
            dailyRecordService.updateDailyRecordSetCId(2L, 1L);


            model.addAttribute(
                    "dailyRecordUpdated",
                    dailyRecordService.selectDailyRecordsAll()
            );

            model.addAttribute(
                    "dailyRecordById",
                    dailyRecordService.selectDailyRecordById(1L)
            );

            model.addAttribute(
                    "dailyRecordByTitle",
                    dailyRecordService.selectDailyRecordByTitle("title")
            );

            model.addAttribute(
                    "dailyRecordByContent",
                    dailyRecordService.selectDailyRecordByContent("content")
            );

            model.addAttribute(
                    "dailyRecordByCId",
                    dailyRecordService.selectDailyRecordByCId(1L)
            );

            model.addAttribute(
                    "dailyRecordByDpId",
                    dailyRecordService.selectDailyRecordByDpId(1L)
            );

            dailyRecordService.deleteDailyRecord(3L);

            model.addAttribute(
                    "dailyRecordDeleted",
                    dailyRecordService.selectDailyRecordsAll()
            );

            return "test/all/dailyRecord";
        } catch (Exception e) {
            model.addAttribute("msg", "dailyRecord Error!");
            return "error";
        }
    }
}
