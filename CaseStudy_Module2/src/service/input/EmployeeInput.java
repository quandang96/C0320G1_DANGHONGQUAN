package service.input;

import commons.CsvReaderWriter;
import models.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeInput {

    public static void employee() {
        List<String[]> list = new ArrayList<>();
        Employee[] employee = new Employee[]{new Employee("001", "Nguyen Hong Son", 20, "Da Nang"),
                new Employee("002", "Nguyen Hong Son", 20, "Da Nang"),
                new Employee("003", "Nguyen Hong Son", 20, "Da Nang"),
                new Employee("004", "Nguyen Hong Son", 20, "Da Nang"),
                new Employee("006", "Nguyen Hong Son", 20, "Da Nang"),
                new Employee("007", "Nguyen Hong Son", 20, "Da Nang"),
                new Employee("008", "Nguyen Hong Son", 20, "Da Nang"),
                new Employee("009", "Nguyen Hong Son", 20, "Da Nang"),
                new Employee("010", "Nguyen Hong Son", 20, "Da Nang")};
        for (int i = 0; i < employee.length; i++) {
            list.add(employee[i].arrayEmployee());
        }
            CsvReaderWriter.writerCsv(list ,"Employee");
    }

}
