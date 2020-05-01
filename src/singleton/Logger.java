package singleton;

public class Logger {

    private String message;
    private static Logger logger;

    private Logger() {
    }

    public static Logger getInstance(){
        if (logger == null){
            logger = new Logger();
        }
        return logger;
    }

    public String getMessage(String message){
        this.message = message;
        System.out.println(this.message);
        return this.message;
    }
}
