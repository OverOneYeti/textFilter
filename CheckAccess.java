

import java.util.Locale;

public class CheckAccess {
    String AccessLogin; //берём из main?
    Integer AccessPassword;  //берём из main?
    Integer Position;

    public String getAccessLogin() {
        return AccessLogin;
    }

    public Integer getAccessPassword() {
        return AccessPassword;
    }

    public void setAccessLogin(String accessLogin) {
        AccessLogin = accessLogin;
    }

    public void setAccessPassword(Integer accessPassword) {
        AccessPassword = accessPassword;
    }

    public Integer getPosition() {
        return Position;
    }

    public void setPosition(Integer position) {
        Position = position;
    }

    public void checkAccess(String AccessLogin, Integer AccessPassword, Integer Position){



        if(AccessLogin.equals("head") && AccessPassword==111){  //Если логин и пароль для главы совпадают
            Position= 1;                            //То предоставляем доступ для главы
        }
        else if(AccessLogin.equals("student") && AccessPassword==222){  //Если логин и пароль для студента
            Position=2;                                    //(ну или лаборанта, у кого как) совпадают,
            // то предоставляем для студента
        } else {
            System.out.println("Wrong Login or Password.");             //Если не совпадает что-либо из этого, то не предоставляем
        }
      this.Position = Position;
    }
}