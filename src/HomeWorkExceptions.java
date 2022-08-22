public class HomeWorkExceptions {
    public static void main(String[] args) {
        String login = "Gans0810_";
        String password ="Gorilla_11";
        String checkPassword = "Gorilla_11" ;
        String login2 = "Gans0810";
        String password2 ="GfdopS_S";
        String checkPassword2 = "GfdopS_" ;

        System.out.println(checkingCorrectness(login, password, checkPassword));

        System.out.println(checkingCorrectness(login2, password2, checkPassword2));
    }
    public static boolean checkingCorrectness(String login,String password, String confirmPassword){
        try{
            if(login.toCharArray().length>=20){
            throw new WrongLoginException("имя login превысило 20 символов, измените значение в пределах 1-20");
        } if(password.toCharArray().length<1 || confirmPassword.toCharArray().length<1){
                throw new WrongPasswordException("короткий пароль,  измените значение в пределах 1-19");

            }

            if(password.toCharArray().length>20 || confirmPassword.toCharArray().length >20){
                throw new WrongPasswordException("длинна password превысила 20 символов, измените значение в пределах 1-19");
            }
            if (!login.matches("\\w{1,20}")){
                throw new WrongLoginException("login не соответствует требованиям (только латинские буквы, цифры, знак '_')");

            }
            if (!password.matches("\\w{1,20}")|| !confirmPassword.matches("\\w{1,20}")){
                throw new WrongPasswordException("password не соответствует требованиям (только латинские буквы, цифры, знак '_')");

            }
            if(!password.equals(confirmPassword)){
                throw new  WrongPasswordException("пароли не совпадают");
            }
        } catch (WrongLoginException | WrongPasswordException exception){
            System.out.println(exception.getMessage());
            return false;
        }
        return true ;
    }
}

