//package com.all.projpj07_fs;
//
//import org.assertj.core.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.test.annotation.Rollback;
//
//import java.util.Optional;
//
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//@Rollback(false)
//public class TestReponsitoryTests {
//    @Autowired
//    private TestRepo testRepo;
//
//    @Test
//    public void testCreateTest() {
//        TestEnt test = new TestEnt();
//        test.setName("Test 2");
//        test.setAge(20);
//
//        TestEnt save = testRepo.save(test);
//
//        Assertions.assertThat(save).isNotNull();
//        Assertions.assertThat(save.getId()).isGreaterThan(0);
//
//        testFindAllTest();
//    }
//
//    @Test
//    public void testFindAllTest() {
//        Iterable<TestEnt> tests = testRepo.findAll();
//        Assertions.assertThat(tests).hasSizeGreaterThan(0);
//
//        for (TestEnt test : tests) {
//            System.out.println(test);
//        }
//
//        testFindTestById();
//    }
//
//    @Test
//    public void testFindTestById() {
//        Integer testId = 1;
//        Optional<TestEnt> optionalTest = testRepo.findById(testId);
//        Assertions.assertThat(optionalTest).isPresent();
//        System.out.println(optionalTest.get());
//
//        testFindAllTest();
//    }
//
//    @Test
//    public void testUpdateTest() {
//        Integer testId = 1;
//        Optional<TestEnt> optionalTest = testRepo.findById(testId);
//        TestEnt test = optionalTest.get();
//        test.setAge(30);
//
//        testRepo.save(test);
//
//        TestEnt updateTest = testRepo.findById(testId).get();
//        Assertions.assertThat(updateTest.getAge()).isEqualTo(30);
//
//        testFindAllTest();
//    }
//
//    @Test
//    public void testDeleteTest() {
//        Integer testId = 5;
//        testRepo.deleteById(testId);
//
//        Optional<TestEnt> optionalPatient = testRepo.findById(testId);
//        Assertions.assertThat(optionalPatient).isNotPresent();
//
//        testFindAllTest();
//    }
//}
