package ru.netology;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class OrderCardNegativeTest {
    int days = 3;
    ChooseData chooseData = new ChooseData();

    @Test
    public void UnavailableCity() {
        open("http://localhost:9999/");
        $("[data-test-id='city'] input").setValue("Зарайск");
        $x("//input[@placeholder='Дата встречи']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $x("//input[@placeholder='Дата встречи']").setValue(chooseData.generateDate(days));
        $("[data-test-id='name'] input").setValue("Иванов Иван");
        $("[data-test-id='phone'] input").setValue("+79295555555");
        $("[data-test-id='agreement']").click();
        $x("//*[text()='Забронировать']").click();
        $("[data-test-id='city'] span.input__sub").shouldHave(exactText("Доставка в выбранный город недоступна")).shouldBe(visible);

    }

    @Test
    public void EmptyCity(){
        open("http://localhost:9999/");
        $x("//input[@placeholder='Город']").doubleClick().sendKeys(Keys.BACK_SPACE);
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='date'] input" ).setValue( chooseData.generateDate( days ) );
        $( "[data-test-id='name'] input" ).setValue( "Пупкин Василий" );
        $( "[data-test-id='phone'] input" ).setValue( "+79295555555" );
        $( "[data-test-id='agreement']" ).click();
        $$( "button" ).find( exactText( "Забронировать" ) ).click();
        $( "[data-test-id='city'] span.input__sub" ).shouldHave( exactText( "Поле обязательно для заполнения" ) ).shouldBe( visible );
    }
    @Test

    public void InvalidName(){
        open("http://localhost:9999/");
        $( "[data-test-id='city'] input" ).setValue( "Москва" );
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='date'] input" ).setValue( chooseData.generateDate( days ));
        $( "[data-test-id='name'] input" ).setValue( "Ivanov Ivan" );
        $( "[data-test-id='phone'] input" ).setValue( "+79295555555" );
        $( "[data-test-id='agreement']" ).click();
        $$( "button" ).find( exactText( "Забронировать" ) ).click();
        $( "[data-test-id='name'] span.input__sub" ).shouldHave( exactText( "Имя и Фамилия указаные неверно. Допустимы только русские буквы, пробелы и дефисы." ) ).shouldBe( visible );

    }

    @Test
    public void EmptyName(){
        open("http://localhost:9999/");
        $( "[data-test-id='city'] input" ).setValue( "Москва" );
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='date'] input" ).setValue( chooseData.generateDate( days ));
        $( "[data-test-id='phone'] input" ).setValue( "+79295555555" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='name'] span.input__sub" ).shouldHave( exactText( "Поле обязательно для заполнения" ) ).shouldBe( visible );
    }
    @Test
    public void EmptyPhone() {
        open("http://localhost:9999/");
        $( "[data-test-id='city'] input" ).setValue( "Москва" );
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='date'] input" ).setValue( chooseData.generateDate( days ));
        $( "[data-test-id='name'] input" ).setValue( "Пупкин Василий" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='phone'] span.input__sub" ).shouldHave( exactText( "Поле обязательно для заполнения" ) ).shouldBe( visible );

    }

    @Test
    public void InvalidPhone(){
        open("http://localhost:9999/");
        $( "[data-test-id='city'] input" ).setValue( "Москва" );
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='date'] input" ).setValue( chooseData.generateDate( days ));
        $( "[data-test-id='name'] input" ).setValue( "Пупкин Василий" );
        $( "[data-test-id='phone'] input" ).setValue( "79295555555" );
        $( "[data-test-id='agreement']" ).click();
        $x( "//*[text()='Забронировать']" ).click();
        $( "[data-test-id='phone'] span.input__sub" ).shouldHave( exactText( "Телефон указан неверно. Должно быть 11 цифр, например, +79012345678." ) ).shouldBe( visible );

    }

    @Test
    public void WithoutAgreement(){
        open("http://localhost:9999/");
        $( "[data-test-id='city'] input" ).setValue( "Москва" );
        $( "[data-test-id='date'] input" ).doubleClick().sendKeys( Keys.BACK_SPACE );
        $( "[data-test-id='date'] input" ).setValue( chooseData.generateDate( days ));
        $( "[data-test-id='name'] input" ).setValue( "Пупкин Василий" );
        $( "[data-test-id='phone'] input" ).setValue( "+79295555555" );
        $x( "//*[text()='Забронировать']" ).click();
        $( ".checkbox__text" ).shouldHave( exactText( "Я соглашаюсь с условиями обработки и использования моих персональных данных" ) ).shouldBe( Condition.visible );
    }




}