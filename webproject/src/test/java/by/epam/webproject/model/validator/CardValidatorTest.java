package by.epam.webproject.model.validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class CardValidatorTest {
    @DataProvider(name = "isCardNumberCorrectPositiveData")
    public Object[][] createIsCardNumberCorrectPositiveData(){
        return new Object[][]{
                {"1234567812345678"},
                {"1234567123912345"},
                {"1111111111111111"}
        };
    }

    @Test(dataProvider = "isCardNumberCorrectPositiveData")
    public void isCardNumberCorrectPositiveTest(String line){
        assertTrue(CardValidator.isCardNumberCorrect(line));
    }

    @DataProvider(name = "isCardNumberCorrectNegativeData")
    public Object[][] createIsCardNumberCorrectNegativeData(){
        return new Object[][]{
                {"123456712345678"},
                {"@23456"},
                {"1234567fgh912345"},
                {"1111111111111"}
        };
    }

    @Test(dataProvider = "isCardNumberCorrectNegativeData")
    public void isCardNumberCorrectNegativeTest(String line){
        assertFalse(CardValidator.isCardNumberCorrect(line));
    }
}