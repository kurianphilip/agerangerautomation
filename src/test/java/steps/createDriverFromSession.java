package steps;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.*;

import java.io.IOException;
import java.net.URL;
import java.util.Collections;

public class createDriverFromSession {

    public static RemoteWebDriver createDriverFromSession(final SessionId sessionId, URL command_executor){
        CommandExecutor executor = new HttpCommandExecutor(command_executor) {

            @Override
            public Response execute(Command command) throws IOException {
                Response response = null;
                if (command.getName() == "newSession") {
                    response = new Response();
                    response.setSessionId(sessionId.toString());
                    response.setStatus(0);
                    response.setValue(Collections.<String, String>emptyMap());


                } else {
                    response = super.execute(command);
                }
                return response;
            }
        };

        return new RemoteWebDriver(executor, new DesiredCapabilities());
    }

    public static void main(String [] args) {

        ChromeDriver driver = new ChromeDriver();
        HttpCommandExecutor executor = (HttpCommandExecutor) driver.getCommandExecutor();
        URL url = executor.getAddressOfRemoteServer();
        SessionId session_id = driver.getSessionId();


        RemoteWebDriver driver2 = createDriverFromSession(session_id, url);
    }

}
