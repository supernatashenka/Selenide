package ru.netology;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OrderCardPositiveTest {

    int days = 3;
    ChooseDate chooseData = new ChooseDate();
    @Test
    public void ShouldPlaceTheOrderWithValidData() {
        open("http://localhost:9999/");
        $( "[data-test-id='city'] input" ).setValue( "Москва" );
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='date'] input" ).setValue( chooseData.generateDate( days ));
        $( "[data-test-id='name'] input" ).setValue( "Пупкин Василий" );
        $( "[data-test-id='phone'] input" ).setValue( "+79295555555" );
        $( "[data-test-id='agreement']" ).click();
        $$( "button" ).find( exactText( "Забронировать" ) ).click();
        $( "[data-test-id='notification']" ).shouldHave (text ( "Встреча успешно забронирована на " + chooseData.generateDate( days ) ), Duration.ofSeconds( 15 ) );


    }

    @Test
    public void ShouldPlaceTheOrderWithDoubleSurname() {

        open("http://localhost:9999/");
        $( "[data-test-id='city'] input" ).setValue( "Москва" );
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='date'] input" ).setValue( chooseData.generateDate( days ) );
        $( "[data-test-id='name'] input" ).setValue( "Римский-Корсаков Иван" );
        $( "[data-test-id='phone'] input" ).setValue( "+79295555555" );
        $( "[data-test-id='agreement']" ).click();
        $$( "button" ).find( exactText( "Забронировать" ) ).click();
        $( "[data-test-id='notification']" ).shouldHave( text( "Встреча успешно забронирована на " + chooseData.generateDate( days ) ), Duration.ofSeconds( 15 ) );


    }



}
