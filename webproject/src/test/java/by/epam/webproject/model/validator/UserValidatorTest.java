package by.epam.webproject.model.validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class UserValidatorTest {
    @DataProvider(name = "isIdCorrectPositiveData")
    public Object[][] createIsIdCorrectPositiveData(){
        return new Object[][]{
                {"1234567"},
                {"23456"},
                {"5"},
                {"1111"}
        };
    }

    @Test(dataProvider = "isIdCorrectPositiveData")
    public void isIdCorrectPositiveTest(String line){
        assertTrue(UserValidator.isIdCorrect(line));
    }

    @DataProvider(name = "isIdCorrectNegativeData")
    public Object[][] createIsIdCorrectNegativeData(){
        return new Object[][]{
                {"123456@7"},
                {"g23456"},
                {"12345678912"},
                {"1111111111111111"}
        };
    }

    @Test(dataProvider = "isIdCorrectNegativeData")
    public void isIdCorrectNegativeTest(String line){
        assertFalse(UserValidator.isIdCorrect(line));
    }

    @DataProvider(name = "isLoginCorrectPositiveData")
    public Object[][] createIsLoginCorrectPositiveData(){
        return new Object[][]{
                {"NewLogin"},
                {"A312_lex"},
                {"ZloyParen"},
                {"Yamura.12"}
        };
    }

    @Test(dataProvider = "isLoginCorrectPositiveData")
    public void isLoginCorrectPositiveTest(String line){
        assertTrue(UserValidator.isLoginCorrect(line));
    }

    @DataProvider(name = "isLoginCorrectNegativeData")
    public Object[][] createIsLoginCorrectNegativeData(){
        return new Object[][]{
                {"24poz"},
                {"New @login"},
                {"Yamura12."},
                {"G-3456789012345678901"}
        };
    }

    @Test(dataProvider = "isLoginCorrectNegativeData")
    public void isLoginCorrectNegativeTest(String line){
        assertFalse(UserValidator.isLoginCorrect(line));
    }

    @DataProvider(name = "isEmailCorrectPositiveData")
    public Object[][] createIsEmailCorrectPositiveData(){
        return new Object[][]{
                {"alexwekwow@gmail.com"},
                {"myuser612@tut.by"},
                {"newmail@mybiz.eu"},
        };
    }

    @Test(dataProvider = "isEmailCorrectPositiveData")
    public void isEmailCorrectPositiveTest(String line){
        assertTrue(UserValidator.isEmailCorrect(line));
    }

    @DataProvider(name = "isEmailCorrectNegativeData")
    public Object[][] createIsEmailCorrectNegativeData(){
        return new Object[][]{
                {"@ghdfk@mail.ru"},
                {"some-stupid0mails@yandex.ru"},
                {"newmailtype@quiz.rubak"},
        };
    }

    @Test(dataProvider = "isEmailCorrectNegativeData")
    public void isEmailCorrectNegativeTest(String line){
        assertFalse(UserValidator.isEmailCorrect(line));
    }

    @DataProvider(name = "isPasswordCorrectPositiveData")
    public Object[][] createIsPasswordCorrectPositiveData(){
        return new Object[][]{
                {"123456"},
                {"ivano-v1994"},
                {"bREsTeMPosParDATIckl"}
        };
    }

    @Test(dataProvider = "isPasswordCorrectPositiveData")
    public void isPasswordCorrectPositiveTest(String line){
        assertTrue(UserValidator.isPasswordCorrect(line));
    }

    @DataProvider(name = "isPasswordCorrectNegativeData")
    public Object[][] createIsPasswordCorrectNegativeData(){
        return new Object[][]{
                {"ghdfkgjd!gd3"},
                {"to"},
                {"toomuchSymbolsOr!#$"}
        };
    }

    @Test(dataProvider = "isPasswordCorrectNegativeData")
    public void isPasswordCorrectNegativeTest(String line){
        assertFalse(UserValidator.isPasswordCorrect(line));
    }
}