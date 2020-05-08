package singleton;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Logger {

    private String message;
    private static Logger logger;
    private static Lock lock = new ReentrantLock();

    private Logger() {
    }

    public  static Logger getInstance(){
        if (logger == null)
        {
            synchronized (lock)
            {
                if (logger == null)
                 logger = new Logger();
            }
        }
        return logger;
    }

    public String getMessage(String message){
        this.message = message;
        System.out.println(this.message);
        return this.message;
    }
}
