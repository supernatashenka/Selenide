package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class Task2Test {
   

    GetDataFromCalendar getDataFromCalendar = new GetDataFromCalendar();

    @Test
    public void ShouldChooseFromList(){
        open("http://localhost:9999/");
        $( "[data-test-id='city'] input" ).setValue( "Ка" );
        $x( "//*[text()='Казань']" ).click();
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $(".icon-button__content").click();
        $( "[data-test-id='date'] input" ).setValue(getDataFromCalendar.chosenDate());
        $( "[data-test-id='name'] input" ).setValue( "Пупкин Василий" );
        $( "[data-test-id='phone'] input" ).setValue( "+79295555555" );
        $( "[data-test-id='agreement']" ).click();
        $$( "button" ).find( exactText( "Забронировать" ) ).click();
        $( "[data-test-id='notification']" ).shouldHave (text ( "Встреча успешно забронирована на " + getDataFromCalendar.chosenDate() ), Duration.ofSeconds( 15 ) );

    }



}
