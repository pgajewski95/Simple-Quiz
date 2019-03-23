package com.example.quiz.Controller;

import com.example.quiz.Model.Question;
import com.example.quiz.Model.Test;
import com.example.quiz.Model.User;
import com.example.quiz.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Scope(value = "session")
@Controller
public class TestController {


    private User user = new User();

    @Autowired

    private TestRepository testRepository;
    private Integer currentQuestion;

    @GetMapping("/main")
    public String main(String main) {
        System.out.println("Strona Głowna");
        return "main";
    }

    @GetMapping("/add")
    public String show(ModelMap modelMap) {

        return "add";
    }

    @GetMapping("/new")
    public String add(@RequestParam(required = false) String name,
                      @RequestParam(required = false) String content,
                      @RequestParam(required = false) boolean correct,
                      ModelMap modelMap) {

        Question n = new Question();
        Test s = new Test(name);
        s.addQuestion(n);
        n.setCorrect(correct);
        n.setContent(content);
        testRepository.save(s);

        return "add";


    }


    @GetMapping("/tests/{id}/play")
    public String play(@PathVariable Integer id, ModelMap modelMap) {
        Test test = testRepository.findById(id).get();
        modelMap.addAttribute("test", test);

        modelMap.addAttribute("question", test.getQuestionList().get(0));
        currentQuestion = 0;
        user = new User();
        return "test";


    }

    @GetMapping("/tests/{id}/continue")
    public String continueTest(
            @RequestParam(required = false)
                    boolean correct, @PathVariable Integer id, ModelMap modelMap) {
        Test test = testRepository.findById(id).get();
        if (test.getQuestionList().get(currentQuestion).getCorrect() == correct) {
            user.addPoints();
        }
        currentQuestion++;
        if (currentQuestion < test.getQuestionList().size()) {
            modelMap.put("test", test);
            modelMap.put("question", test.getQuestionList().get(currentQuestion));
        } else {
            modelMap.put("test", test);
            modelMap.put("message", "Koniec gry! Twoja liczba punktów to: "
                    + user.getNumberOfPoints());
        }

        return "test";
    }
    @GetMapping("/")
    public String testlog(ModelMap modelMap){
        return "log";
    }
    @GetMapping("/log")
    public String log(@RequestParam(required = false) String login, @RequestParam(required = false) String password) {
        User admin = new User();

        if (login.equals("admin") && password.equals("admin")) {
            admin.setLogin(login);
            admin.setPassoword(password);
            return "main";


        } else {
            System.out.println("zle dane");
            return "log";
        }


    }
}
