package by.epam.webproject.model.validator;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RaceValidatorTest {
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
        assertTrue(RaceValidator.isIdCorrect(line));
    }

    @DataProvider(name = "isIdCorrectNegativeData")
    public Object[][] createIsIdCorrectNegativeData(){
        return new Object[][]{
                {"123456@7"},
                {"g23456"},
                {"123456791"},
                {"1111111111111111"}
        };
    }

    @Test(dataProvider = "isIdCorrectNegativeData")
    public void isIdCorrectNegativeTest(String line){
        assertFalse(RaceValidator.isIdCorrect(line));
    }

    @DataProvider(name = "isTitleCorrectPositiveData")
    public Object[][] createIsTitleCorrectPositiveData(){
        return new Object[][]{
                {"New york"},
                {"Some place"},
                {"New title"},
                {"Government"}
        };
    }

    @Test(dataProvider = "isTitleCorrectPositiveData")
    public void isTitleCorrectPositiveTest(String line){
        assertTrue(RaceValidator.isTitleCorrect(line));
    }

    @DataProvider(name = "isTitleCorrectNegativeData")
    public Object[][] createIsTitleCorrectNegativeData(){
        return new Object[][]{
                {"31243gdfgd gdfgd"},
                {"New @york"},
                {"Three or more words"},
                {"-"}
        };
    }

    @Test(dataProvider = "isTitleCorrectNegativeData")
    public void isTitleCorrectNegativeTest(String line){
        assertFalse(RaceValidator.isTitleCorrect(line));
    }

    @DataProvider(name = "isRoundsCorrectPositiveData")
    public Object[][] createIsRoundsCorrectPositiveData(){
        return new Object[][]{
                {"12"},
                {"1"},
                {"99"},
                {"3"}
        };
    }

    @Test(dataProvider = "isRoundsCorrectPositiveData")
    public void isRoundsCorrectPositiveTest(String line){
        assertTrue(RaceValidator.isRoundsCorrect(line));
    }

    @DataProvider(name = "isRoundsCorrectNegativeData")
    public Object[][] createIsRoundsCorrectNegativeData(){
        return new Object[][]{
                {"100"},
                {"01"},
                {"1g"},
                {" "}
        };
    }

    @Test(dataProvider = "isRoundsCorrectNegativeData")
    public void isRoundsCorrectNegativeTest(String line){
        assertFalse(RaceValidator.isRoundsCorrect(line));
    }

    @DataProvider(name = "isDetailsCorrectPositiveData")
    public Object[][] createIsDetailsCorrectPositiveData(){
        return new Object[][]{
                {"5 jockey | Pace | Dirt"},
                {"New details for the race"},
                {"Some random line"}
        };
    }

    @Test(dataProvider = "isDetailsCorrectPositiveData")
    public void isDetailsCorrectPositiveTest(String line){
        assertTrue(RaceValidator.isDetailsCorrect(line));
    }

    @DataProvider(name = "isDetailsCorrectNegativeData")
    public Object[][] createIsDetailsCorrectNegativeData(){
        return new Object[][]{
                {""},
                {"Some-details"},
                {"new Pace@ type"}
        };
    }

    @Test(dataProvider = "isDetailsCorrectNegativeData")
    public void isDetailsCorrectNegativeTest(String line){
        assertFalse(RaceValidator.isDetailsCorrect(line));
    }
}