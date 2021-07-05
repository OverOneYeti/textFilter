public class Connection {
    private boolean  connection;

    public void checkConnection(boolean connection){
        System.out.println("Проверка подключения к базе данных.");
        if (connection){
            System.out.println("Соединение установленно.");
        } else System.out.println("Отсутствует соединение с базой данных.");
    }

    public boolean isConnection() {
        return connection;
    }

    public void setConnection(boolean connection) {
        this.connection = connection;
    }

    public Connection(boolean connection) {
        this.connection = connection;
    }



}