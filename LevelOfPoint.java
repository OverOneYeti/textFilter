import java.util.Scanner;
public class LevelOfPoint {
    int Position; // берем из CheckAccess
    String AccessLogin; // берем из CheckAccess



    public int getPosition() {
        return Position;
    }

    public void setPosition(int position) {
        Position = position;
    }

    public String getAccessLogin() {
        return AccessLogin;
    }

    public void setAccessLogin(String accessLogin) {
        AccessLogin = accessLogin;
    }

    public  void methodsOfUser(){
        Scanner scan = new Scanner(System.in);
        if(Position == 1){
            System.out.println("Choose method: \n" +
                    "1 - input your string for filtration \n" +
                    "2 - check history \n" +
                    "3 - check formate \n" +
                    "4 - change formate \n" +
                    "5 - connect with data base");
           int Choice = scan.nextInt();
            switch (Choice){
                case 1:
                    System.out.println("Введите строку");
                    String str = scan.nextLine();
                    str = scan.nextLine();
                   System.out.println("Введите минимальное количество символов для фильтрации ");
                    int muchOfSymbols = scan.nextInt();

                    Less.filter(str, muchOfSymbols); // метод фильтрации
                    break;
                case 2:
                   // History.checkHistory; // метод просмотра истории
                    break;
                case 3:
                 //   Formate.checkFormate; // просмотр формата
                    break;
                case 4:
                 //   Formate.changeFormate; // изменить формат
                    break;
                case 5:
                 //   DataBase.checkConect; // vtnj
                    break;
                default:
                    System.out.println("Wrong choice");
            }

        }else if(Position == 2){
            System.out.println("Choose method: \n" +
                    "1 - input your string for filtration \n" +
                    "2 - check history");
           int Choice = scan.nextInt();
            switch (Choice){
                case 1:
                    System.out.println("Введите строку");
                    String str = scan.nextLine();
                    str = scan.nextLine();
                    System.out.println("Введите минимальное количество символов для фильтрации ");
                    int muchOfSymbols = scan.nextInt();

                    Less.filter(str, muchOfSymbols); // метод фильтрации
                    break;
                case 2:
                 //   History.checkHistory; // метод просмотра истории
                    break;

                default:
                    System.out.println("Wrong choice");
            }
        }

    }
}