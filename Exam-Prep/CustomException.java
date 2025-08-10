class CustomException {
    public static void main(String args[]) {
        try {
            validate(18);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void validate(int age) throws AgeNotValidException {
        if (age < 18) {
            throw new AgeNotValidException("Age not valid.");
        } else {
            System.out.println("Welcome to Vote.");
        }
    }
}

class AgeNotValidException extends Exception {
    AgeNotValidException(String s) {
        super(s);
    }
}