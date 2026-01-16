package proof;

import java.text.DecimalFormat;
import java.util.Scanner;


public class HeartlandCarsOfAmericaPayRoll {

    public static void main(String[] args) {

        // Create reference variables of all three employee types
        FullTimeEmp fullTimeEmployee;
        PartTimeEmp partTimeEmployee;
        SalesEmp salesEmployee;

        // Declare variables to input
        char inputEmployeeType;
        String inputFirstName;
        String inputLastName;
        double inputBaseSalary;
        double inputPayPerHour;
        double inputSalesVolume;
        int inputHoursWorked;

        // Get employee type
        Scanner scannedInfo = new Scanner(System.in);

        System.out.print("Enter Employee Type (F=Full-time, P=Part-time, S=Sales): ");
        inputEmployeeType = scannedInfo.next().charAt(0);

        switch (Character.toUpperCase(inputEmployeeType)) {

            case 'F':
                fullTimeEmployee = new FullTimeEmp();

                System.out.print("Enter First Name: ");
                inputFirstName = scannedInfo.next();

                System.out.print("Enter Last Name: ");
                inputLastName = scannedInfo.next();

                System.out.print("Enter Base Salary: ");
                inputBaseSalary = scannedInfo.nextDouble();

                System.out.print("Enter Hours Worked: ");
                inputHoursWorked = scannedInfo.nextInt();

                fullTimeEmployee.setFirstName(inputFirstName);
                fullTimeEmployee.setLastName(inputLastName);
                fullTimeEmployee.setBaseSalary(inputBaseSalary);
                fullTimeEmployee.setHoursWorked(inputHoursWorked);

                System.out.println(fullTimeEmployee.createPayStub());
                break;

            case 'P':
                partTimeEmployee = new PartTimeEmp();

                System.out.print("Enter First Name: ");
                inputFirstName = scannedInfo.next();

                System.out.print("Enter Last Name: ");
                inputLastName = scannedInfo.next();

                System.out.print("Enter Pay Per Hour: ");
                inputPayPerHour = scannedInfo.nextDouble();

                System.out.print("Enter Hours Worked: ");
                inputHoursWorked = scannedInfo.nextInt();

                partTimeEmployee.setFirstName(inputFirstName);
                partTimeEmployee.setLastName(inputLastName);
                partTimeEmployee.setPayPerHour(inputPayPerHour);
                partTimeEmployee.setHoursWorked(inputHoursWorked);

                System.out.println(partTimeEmployee.createPayStub());
                break;

            case 'S':
                salesEmployee = new SalesEmp();

                System.out.print("Enter First Name: ");
                inputFirstName = scannedInfo.next();

                System.out.print("Enter Last Name: ");
                inputLastName = scannedInfo.next();

                System.out.print("Enter Base Salary: ");
                inputBaseSalary = scannedInfo.nextDouble();

                System.out.print("Enter Sales Volume: ");
                inputSalesVolume = scannedInfo.nextDouble();

                salesEmployee.setFirstName(inputFirstName);
                salesEmployee.setLastName(inputLastName);
                salesEmployee.setBaseSalary(inputBaseSalary);
                salesEmployee.setSalesVolume(inputSalesVolume);

                System.out.println(salesEmployee.createPayStub());
                break;

            default:
                System.out.println("Invalid employee type entered.");
        }

        scannedInfo.close();
    }
}

/* =========================
   Employee Classes (Section 1)
   ========================= */

class FullTimeEmp {

    private String firstName;
    private String lastName;
    private double baseSalary;
    private int hoursWorked;

    public double computeCompensation() {
        double payPerHour = baseSalary / 80.0;
        if (hoursWorked > 80) {
            return baseSalary + (hoursWorked - 80) * 1.5 * payPerHour;
        } else {
            return baseSalary;
        }
    }

    public String createPayStub() {
        DecimalFormat currencyFormat = new DecimalFormat("0.00");
        double salary = computeCompensation();

        return "\n\n\t\tHEARTLAND CARS OF AMERICA"
                + "\n\n\t" + firstName + " " + lastName
                + "\n\n\tBasic Salary \t$" + currencyFormat.format(baseSalary)
                + "\n\tHours Worked \t" + hoursWorked
                + "\n\tPay \t\t$" + currencyFormat.format(salary)
                + "\n\n\n";
    }

    public void setFirstName(String inFirstName) { firstName = inFirstName; }
    public void setLastName(String inLastName) { lastName = inLastName; }
    public void setBaseSalary(double inBaseSalary) { baseSalary = inBaseSalary; }
    public void setHoursWorked(int inHoursWorked) { hoursWorked = inHoursWorked; }
}

class PartTimeEmp {

    private String firstName;
    private String lastName;
    private double payPerHour;
    private int hoursWorked;

    public double computeCompensation() {
        return payPerHour * hoursWorked;
    }

    public String createPayStub() {
        DecimalFormat currencyFormat = new DecimalFormat("0.00");
        double salary = computeCompensation();

        return "\n\n\t\tHEARTLAND CARS OF AMERICA"
                + "\n\n\t" + firstName + " " + lastName
                + "\n\n\tSalary/Hour \t$" + currencyFormat.format(payPerHour)
                + "\n\tHours Worked \t" + hoursWorked
                + "\n\tPay \t\t$" + currencyFormat.format(salary)
                + "\n\n\n";
    }

    public void setFirstName(String inFirstName) { firstName = inFirstName; }
    public void setLastName(String inLastName) { lastName = inLastName; }
    public void setPayPerHour(double inPayPerHour) { payPerHour = inPayPerHour; }
    public void setHoursWorked(int inHoursWorked) { hoursWorked = inHoursWorked; }
}

class SalesEmp {

    private String firstName;
    private String lastName;
    private double baseSalary;
    private double salesVolume;

    public double computeCompensation() {
        return baseSalary + 0.02 * salesVolume;
    }

    public String createPayStub() {
        DecimalFormat currencyFormat = new DecimalFormat("0.00");
        double salary = computeCompensation();

        return "\n\n\t\tHEARTLAND CARS OF AMERICA"
                + "\n\n\t" + firstName + " " + lastName
                + "\n\n\tBasic Salary \t$" + currencyFormat.format(baseSalary)
                + "\n\tSales Volume \t$" + currencyFormat.format(salesVolume)
                + "\n\tPay \t\t$" + currencyFormat.format(salary)
                + "\n\n\n";
    }

    public void setFirstName(String inFirstName) { firstName = inFirstName; }
    public void setLastName(String inLastName) { lastName = inLastName; }
    public void setBaseSalary(double inBaseSalary) { baseSalary = inBaseSalary; }
    public void setSalesVolume(double inSalesVolume) { salesVolume = inSalesVolume; }
}
