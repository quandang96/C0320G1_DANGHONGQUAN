package validation;

import java.time.LocalDate;
import java.util.Scanner;

public class Validation {
    Scanner scanner = new Scanner(System.in);

    public String validationService() {
        String regexService = "^[SV][VL|HO|RO][-]+([0-9]{4})$";
        while (true) {
            String input = scanner.nextLine();
            if (input.matches(regexService)) {
                return input;
            } else {
                System.out.println("Enter the wrong information");
            }

        }
    }

    public String validationNamService() {
        while (true) {
            String regexNameService = "^[A-Z]+[a-z]+$";
            String input = scanner.nextLine();
            if (input.matches(regexNameService)) {
                return input;
            } else {
                System.out.println("Enter the wrong information");
            }

        }
    }

    public double validationArea() {
        while (true) {
            String regexArea = "^([3]+[1-9])$|([1-9]+([0-9]){2,100})+$";
            String input = scanner.nextLine();
            if (input.matches(regexArea)) {
                return Double.parseDouble(input);
            } else {
                System.out.println("Enter the wrong information");
            }

        }
    }

    public double validationRentalCosts() {
        while (true) {
            String regexRentalCosts = "^\\d+$";
            String input = scanner.nextLine();
            if (input.matches(regexRentalCosts)) {
                return Double.parseDouble(input);
            } else {
                System.out.println("Enter the wrong information");
            }

        }
    }

    public int validationMaxNumberOfPeople() {
        while (true) {
            String regexMaxNumberOfPeople = "^([1-9]|([1]+[0-9]))$";
            String input = scanner.nextLine();
            if (input.matches(regexMaxNumberOfPeople)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Enter the wrong information");
            }

        }
    }

    public String validationConvenientDescription() {
        while (true) {
            String regexConvenientDescription = "^(massage[\\s]?|karaoke[\\s]?|food[\\s]?|drink[\\s]?|car[\\s]?|^no need$)+$";
            String input = scanner.nextLine();
            if (input.matches(regexConvenientDescription)) {
                return input;
            } else {
                System.out.println("Enter the wrong information");
            }

        }
    }

    public int validationNumberOfFloors() {
        while (true) {
            String regexNumberOfFloors = "^\\d+$";
            String input = scanner.nextLine();
            if (input.matches(regexNumberOfFloors)) {
                return Integer.parseInt(input);
            } else {
                System.out.println("Enter the wrong information");
            }

        }
    }
    public String validationDateOfBirth() {
        while (true) {
            String regexDate = "^(((([0-2][1-9]|(10))[/]([0][1-9]|[1][12]))|((30)[/](([0][13-9])|([1][12]))))|((31)[/]([0][13578]|(12))))[/][0-9]{4}$";
            String input = scanner.nextLine();
            if (input.matches(regexDate)) {
                int date = Integer.parseInt(input.substring(0, 2));
                int month = Integer.parseInt(input.substring(3, 5));
                int year = Integer.parseInt(input.substring(6, 10));
                String localDate = java.time.LocalDate.now().toString();
                if ((Integer.parseInt(localDate.substring(0, 4)) - year) > 18) {
                    return input;
                } else if ((Integer.parseInt(localDate.substring(0, 4)) - year) == 18 && (month - Integer.parseInt(localDate.substring(5, 7))) > 0) {
                    return input;
                } else if ((month - Integer.parseInt(localDate.substring(5, 7))) == 0 && (date - Integer.parseInt(localDate.substring(8, 10))) >= 0) {
                    return input;
                } else {
                    System.out.println("under 18 years old");
                }
            } else {
                System.out.println("Enter the wrong information");
            }
        }
    }
}




