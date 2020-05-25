package exception;

public class ValidationException extends Exception {
    public ValidationException(String message) {
        super(message);
    }

    public static String nameException(String name) throws ValidationException {
        String regex = "^[A-Z][a-z]+([\\s][A-Z][a-z]+)*$";
        if (name.matches(regex)) {
            return name;
        } else {
            throw new ValidationException("Tên không hợp lệ");
        }
    }

    public static String emailException(String email) throws ValidationException {
        String regex = "^(\\w([\\.]\\w)*)+[@][\\w]+(\\.[a-z]+){1,2}$";
        if (email.matches(regex)) {
            return email;
        } else {
            throw new ValidationException("Email không hợp lệ");
        }


    }

    public static String genderException(String gender) throws ValidationException {
        String regex = "^(?i)(Male|Female|Unknow)$";
        if (gender.matches(regex)) {
            char[] characters = gender.toCharArray();
            characters[0] = Character.toUpperCase(characters[0]);
            gender = new String(characters);
            return gender;
        } else {
            throw new ValidationException("Gender không hợp lệ");
        }
    }

    public static String idCardException(String idCard) throws ValidationException {
        String regex = "^[\\d]{3}([\\s][\\d]{3}){2}$";
        if (idCard.matches(regex)) {
            return idCard;
        } else {
            throw new ValidationException("ID Card không hợp lệ");
        }
    }

    public static String birthdayException(String input) {
        while (true) {
            String regexDate = "^(((([0-2][1-9]|(10))[/]([0][1-9]|[1][12]))|((30)[/](([0][13-9])|([1][12]))))|((31)[/]([0][13578]|(12))))[/][0-9]{4}$";
            if (input.matches(regexDate)) {
                int date = Integer.parseInt(input.substring(0, 2));
                int month = Integer.parseInt(input.substring(3, 5));
                int year = Integer.parseInt(input.substring(6, 10));
                String localDate = java.time.LocalDate.now().toString();
                int yearNow = Integer.parseInt(localDate.substring(0, 4));
                int monthNow = Integer.parseInt(localDate.substring(5, 7));
                int dateNow = Integer.parseInt(localDate.substring(8, 10));
                if (year > 1900) {
                    if (yearNow - year > 18) {
                        return input;
                    } else if (yearNow - year == 18 && monthNow - month > 0) {
                        return input;
                    } else if (yearNow - year == 18 && monthNow - month == 0 && dateNow - date >= 0) {
                        return input;
                    } else {
                        System.out.println("under 18 years old");
                    }
                } else {
                    System.out.println("Enter the wrong information");
                }
            } else {
                System.out.println("Năm Sinh phải lớn hơn 1900");
            }
        }
    }
}

