package com.example.quiz.Controller;

import com.example.quiz.Model.Test;
import com.example.quiz.Model.User;
import com.example.quiz.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Scope(value = "session")
@Controller
public class TestController {


    private User user = new User();

    @Autowired
    private TestRepository testRepository;
    @GetMapping("/tests/{id}/play")
    public String play(@PathVariable Integer id, ModelMap modelMap) {
        Test test = testRepository.findById(id).get();
        modelMap.addAttribute("test", test);
        modelMap.addAttribute("question", test.getQuestionList().get(0));
        return "test";


    }


}
