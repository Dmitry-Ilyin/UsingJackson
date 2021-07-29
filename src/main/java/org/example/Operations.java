package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Operations {

    private static DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("d.MM.yyyy");
    private static DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public static void printCompanyNameAndDateFounded(List<Company> list){
        list.forEach(e -> System.out.println("Название " + e.getName() + " - Дата основания "
                + LocalDate.parse(e.getFounded(), formatter1 ).format(formatter2)));
    }

    public static void printSecuritiesValidUntilTodayAndTheirCount(List<Company> list){
        int count = 0;
        for(Company company: list){
            StringBuilder sb = new StringBuilder();
            for(Security s : company.getSecurities()){
                LocalDate date = LocalDate.parse(s.getDate(), formatter1);
                if ( date.isBefore(LocalDate.now()) ){
                    count++;
                    sb.append("ценная бумага - "+ s.getName() + " , код - " + s.getCode() + " дата истечения - " + s.getDate() + " , ");
                }
            }
            if(sb.length() != 0){
                sb.insert(0, "Организация-владелец - " + company.getName() + " | ");
                sb.setLength(sb.length() - 3);
                System.out.println(sb.toString());
            }
        }
        System.out.println("Количество ценных бумаг просроченных на текущий день = " + count);
    }


    public static void printCompaniesFoundedBeforeBeforeDate(List<Company> list, String time) throws ExceptionDateInput {
        LocalDate date;
        Pattern pattern1 = Pattern.compile("^(\\d{2})(\\.)(\\d{2})(\\2|\\,)(\\d{2}|\\d{4})$");
        Pattern pattern2 = Pattern.compile("^(\\d{2})(\\/)(\\d{2})(\\2)(\\d{2}|\\d{4})$");
        Matcher matcher1 = pattern1.matcher(time);
        Matcher matcher2 = pattern2.matcher(time);
        boolean found1 = matcher1.matches();
        boolean found2 = matcher2.matches();

        if(found1 || found2){
            String[] str = time.split("[\\/\\,\\.]");
            StringBuilder sb = new StringBuilder();
            for(String s : str){
                sb.append(s).append(" ");
            }
            String temp = sb.toString().trim();
            if(str[2].length() == 4){
                DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd MM yyyy");
                date = LocalDate.parse(temp, formatter1);
            }
            else {
                DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd MM yy");
                date = LocalDate.parse(temp, formatter2);
            }
        }
        else {
            throw new ExceptionDateInput("Ошибка ввода даты. Используйте формат : ДД.ММ.ГГГГ | ДД.ММ,ГГ | ДД/ММ/ГГГГ | ДД/ММ/ГГГГ");
        }

        list.stream().filter(e -> LocalDate.parse(e.getFounded(), formatter1).isAfter(date))
                .forEach(e1 -> {
                    System.out.println("Название : " + e1.getName() +
                            " , Дата создания : " + e1.getFounded());
                });
    }

    public static void printIdANdCodeSecurity(List<Company> list, String currency){
        for(Company company :list){
            StringBuilder sb = new StringBuilder();
            for(Security security : company.getSecurities()){
                for(String s : security.getCurrency()) {
                    if (s.equals(currency)) {
                        sb.append(security.getCode() + " , ");
                    }
                }
            }
            if(sb.length() != 0){
                sb.insert(0, "ID = " + company.getId() + " | коды ценных бумаг : ");
                sb.setLength(sb.length() - 3);
                System.out.println(sb.toString());
            }
        }
    }
}
