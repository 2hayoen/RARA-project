package com.rara.app.controller;

import com.rara.app.dto.ChildDTO;
import com.rara.app.service.ChildService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/childTest")  // URL
public class ChildController {

    @Autowired
    ChildService childService;

    // 모든 Child 읽기
    @GetMapping("/all")
    public String readAllChildren(Model model) {
        try {
            List<ChildDTO> children = childService.selectChildrenAll();
            model.addAttribute("children", children);
            return "childTest";  // HTML 파일 명
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 읽기 - ID로
    @GetMapping("/readById/{id}")
    public String readChildById(@PathVariable Long id, Model model) {
        try {
            ChildDTO child = childService.selectChildById(id);
            model.addAttribute("child", child);
            return "child/readById";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 읽기 - 이름으로
    @GetMapping("/readByName")
    public String readChildByName(@RequestParam String name, Model model) {
        try {
            List<ChildDTO> children = childService.selectChildByName(name);
            model.addAttribute("children", children);
            return "child/readByName";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 읽기 - 생년월일로
    @GetMapping("/readByBirth")
    public String readChildByBirth(@RequestParam String birth, Model model) {
        try {
            List<ChildDTO> children = childService.selectChildByBirth(birth);
            model.addAttribute("children", children);
            return "child/readByBirth";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 읽기 - 부모의 Teacher ID로
    @GetMapping("/readByM_T_Id")
    public String readChildByM_T_Id(@RequestParam Long m_t_id, Model model) {
        try {
            List<ChildDTO> children = childService.selectChildByMTId(m_t_id);
            model.addAttribute("children", children);
            return "child/readByM_T_Id";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 읽기 - 부모의 Child ID로
    @GetMapping("/readByM_C_Id")
    public String readChildByM_C_Id(@RequestParam Long m_c_id, Model model) {
        try {
            List<ChildDTO> children = childService.selectChildByMCId(m_c_id);
            model.addAttribute("children", children);
            return "child/readByM_C_Id";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 생성 페이지 보기
    @GetMapping("/create")
    public String createChildPage() {
        return "child/create";
    }

    // Child 생성
    @PostMapping("/create")
    public String createChild(@ModelAttribute ChildDTO childDTO) {
        try {
            childService.insertChild(childDTO);
            return "redirect:/children/";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

//    // Child 수정 페이지 보기
//    @GetMapping("/edit/{id}")
//    public String updateChild(@PathVariable Long id, Model model) {
//        try {
//            List<ChildDTO> child = childService.readChildById(id);
//            model.addAttribute("child", child);
//            return "child/edit";
//        } catch (Exception e) {
//            // 오류 처리 로직 추가
//            return "error";
//        }
//    }
//
//    // Child 업데이트 페이지 보기
//    @GetMapping("/update/{id}")
//    public String updateChild(@PathVariable Long id, Model model) {
//        try {
//            List<ChildDTO> child = childService.readChildById(id);
//            model.addAttribute("child", child);
//            return "child/update";
//        } catch (Exception e) {
//            // 오류 처리 로직 추가
//            return "error";
//        }
//    }

    // Child 업데이트 - 이름
    @PostMapping("/updateName/{id}")
    public String updateChildName(@PathVariable Long id, @RequestParam String name) {
        try {
            childService.updateChildSetName(id, name);
            return "redirect:/children/";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 업데이트 - 생년월일
    @PostMapping("/updateBirth/{id}")
    public String updateChildBirth(@PathVariable Long id, @RequestParam String birth) {
        try {
            childService.updateChildSetBirth(id, birth);
            return "redirect:/children/";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 업데이트 - 사진
    @PostMapping("/updatePhoto/{id}")
    public String updateChildPhoto(@PathVariable Long id, @RequestParam String photo) {
        try {
            childService.updateChildSetPhoto(id, photo);
            return "redirect:/children/";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 업데이트 - 속성
    @PostMapping("/updateProperty/{id}")
    public String updateChildProperty(@PathVariable Long id, @RequestParam String property) {
        try {
            childService.updateChildSetProperty(id, property);
            return "redirect:/children/";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 업데이트 - 부모의 Teacher ID
    @PostMapping("/updateMTId/{id}")
    public String updateChildM_T_Id(@PathVariable Long id, @RequestParam Long mTId) {
        try {
            childService.updateChildSetMTId(id, mTId);
            return "redirect:/children/";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 업데이트 - 부모의 Child ID
    @PostMapping("/updateM_C_Id/{id}")
    public String updateChildM_C_Id(@PathVariable Long id, @RequestParam Long mCId) {
        try {
            childService.updateChildSetMCId(id, mCId);
            return "redirect:/children/";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }

    // Child 삭제
    @GetMapping("/delete/{id}")
    public String deleteChild(@PathVariable Long id) {
        try {
            childService.deleteChild(id);
            return "redirect:/children/";
        } catch (Exception e) {
            // 오류 처리 로직 추가
            return "error";
        }
    }
}