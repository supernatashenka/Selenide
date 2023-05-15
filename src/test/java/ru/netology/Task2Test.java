package ru.netology;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class Task2Test {
    ChooseDate chooseData = new ChooseDate();



    @Test
    public void ShouldChooseCityFromList(){
        open("http://localhost:9999/");
        $( "[data-test-id='city'] input" ).setValue( "Ка" );
        $$(".menu-item__control").findBy(text("Казань")).click();
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='date'] input" ).setValue( chooseData.generateDate( 5 ) );
        $( "[data-test-id='name'] input" ).setValue( "Пупкин Василий" );
        $( "[data-test-id='phone'] input" ).setValue( "+79295555555" );
        $( "[data-test-id='agreement']" ).click();
        $$( "button" ).find( exactText( "Забронировать" ) ).click();
        $( "[data-test-id='notification']" ).shouldHave (text ( "Встреча успешно забронирована на " + "20.05.2023" ), Duration.ofSeconds( 15 ) );

    }

}