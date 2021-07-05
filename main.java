
import java.util.Scanner;
public class main {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        boolean connect;

        double a = Math.random()*100;


        if (a>1){
            connect = true;
        }else connect = false;
        System.out.println(connect);

        Connection first = new Connection(connect);
        first.checkConnection(connect);



        if(connect==true){
            InputUser user = new InputUser();
            System.out.println("Введите логин");
            user.setInputLogin(scan.nextLine());
            System.out.println("Введите пароль");
            user.setInputPassword(scan.nextInt());
            CheckAccess newAccess = new CheckAccess();
            newAccess.setAccessLogin(user.getInputLogin());
            newAccess.setAccessPassword(user.getInputPassword());
            newAccess.checkAccess(newAccess.AccessLogin, newAccess.AccessPassword, newAccess.Position);
            LevelOfPoint newPoint = new LevelOfPoint();
            newPoint.setAccessLogin(newAccess.getAccessLogin());
            newPoint.setPosition(newAccess.getPosition());
            newPoint.methodsOfUser();
        }

    }
}
