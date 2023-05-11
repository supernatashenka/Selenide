package ru.netology;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class GetDataFromCalendar {
    public static String chosenDate;

    public String chosenDate(){
        return LocalDate.now().plusWeeks(1).format( DateTimeFormatter.ofPattern( "dd.MM.yyyy" ) );
    }
}
