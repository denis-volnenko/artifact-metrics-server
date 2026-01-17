package ru.volnenko.cloud.am;

import lombok.NonNull;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import ru.volnenko.cloud.am.context.ServerContext;

public class Server {

    public static void main(String[] args) {
        BasicConfigurator.configure();
        Logger.getRootLogger().setLevel(Level.INFO);
        @NonNull final ServerContext serverContext = new ServerContext();
        serverContext.publish();
    }

}
