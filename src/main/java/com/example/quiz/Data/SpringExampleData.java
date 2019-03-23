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


        Test test2 = new Test("Test wiedzy o zyciu");
        test2.addQuestion(new Question("Czy Dzik to zwierze", true));
        test2.addQuestion(new Question("Czy Wieloryb to ssak", true));
        test2.addQuestion(new Question("Czy .222 mozna strzelac do jeleni", false));

        test2.addQuestion(new Question("Czy Marzec to miesiąc po lutym", true));

        testRepository.save(test2);

        Test test3 = new Test("Test wiedzy o Warszawie");
        test3.addQuestion(new Question("Czy Ursynów to dzielnica Warszawy", true));
        test3.addQuestion(new Question("Czy w Warszawie jest pałac kultury i nauki", true));
        test3.addQuestion(new Question("Czy w Warszawie jest tęcza", false));

        test3.addQuestion(new Question("Czy prawobrzena czesc Warszawy jest lepsza od lewej storny", false));

        testRepository.save(test3);

    }




}
