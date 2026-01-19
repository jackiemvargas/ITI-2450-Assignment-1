package proof;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.util.Scanner;

public class HeartlandCarsOfAmericaPayRoll_Batch {

    public static void main(String[] args) throws FileNotFoundException {

        Scanner fileScanner = new Scanner(new File("employee.dat"));

        while (fileScanner.hasNext()) {

            char employeeType = fileScanner.next().charAt(0);
            String firstName = fileScanner.next();
            String lastName = fileScanner.next();

            switch (employeeType) {

                case 'F':
                    double baseSalary = fileScanner.nextDouble();
                    int hoursWorked = fileScanner.nextInt();

                    FullTimeEmp ft = new FullTimeEmp();
                    ft.setFirstName(firstName);
                    ft.setLastName(lastName);
                    ft.setBaseSalary(baseSalary);
                    ft.setHoursWorked(hoursWorked);

                    System.out.println(ft.createPayStub());
                    break;

                case 'P':
                    double payPerHour = fileScanner.nextDouble();
                    int hours = fileScanner.nextInt();

                    PartTimeEmp pt = new PartTimeEmp();
                    pt.setFirstName(firstName);
                    pt.setLastName(lastName);
                    pt.setPayPerHour(payPerHour);
                    pt.setHoursWorked(hours);

                    System.out.println(pt.createPayStub());
                    break;

                case 'S':
                    double salesBase = fileScanner.nextDouble();
                    double salesVolume = fileScanner.nextDouble();

                    SalesEmp se = new SalesEmp();
                    se.setFirstName(firstName);
                    se.setLastName(lastName);
                    se.setBaseSalary(salesBase);
                    se.setSalesVolume(salesVolume);

                    System.out.println(se.createPayStub());
                    break;
            }
        }

        fileScanner.close();
    }
}
