package com.example.quiz.Data;

import com.example.quiz.Model.Question;
import com.example.quiz.Model.Test;
import com.example.quiz.Repository.TestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SpringExampleData implements CommandLineRunner {

    @Autowired
    private TestRepository testRepository;
    @Override
    public void run(String... strings) throws Exception {
        System.out.println("Hello");
        Test test = new Test("Test wiedzy z javy");
        test.addQuestion(new Question("Czy Java ma klasy", true));
        test.addQuestion(new Question("Czy Java ma interfejsy", true));
        test.addQuestion(new Question("Czy Java ma klase integer", false));

        test.addQuestion(new Question("Czy Java ma destruktor", false));

        testRepository.save(test);

    }




}
