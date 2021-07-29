package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws ExceptionDateInput {
        ObjectMapper mapper = new ObjectMapper();

        try {
            Companies companies = mapper.readValue(new File("C:\\пример для ДЗ№3.json"), Companies.class);
            System.out.println(companies);
            System.out.println("-------------------------");
            List<Company> list = companies.getCompanies();
            Operations.printCompanyNameAndDateFounded(list);
            System.out.println("-------------------------");
            Operations.printSecuritiesValidUntilTodayAndTheirCount(list);
            System.out.println("-------------------------");
            Operations.printCompaniesFoundedBeforeBeforeDate(list, "13.01.1970");
            System.out.println("-------------------------");
            Operations.printIdANdCodeSecurity(list, "USD");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
