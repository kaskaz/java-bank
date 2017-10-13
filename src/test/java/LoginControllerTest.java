import controller.LoginController;
import controller.MainController;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import services.AuthService;
import view.View;

public class LoginControllerTest {

    private LoginController loginController;
    private View view;
    private AuthService authService;
    private MainController mainController;

    @Before
    public void setup(){
        loginController = new LoginController();
        view = Mockito.mock(View.class);
        loginController.setView(view);

        authService = Mockito.mock(AuthService.class);
        loginController.setAuthService(authService);

        mainController = Mockito.mock(MainController.class);
        loginController.setNextController(mainController);
    }

    @Test
    public void initTest(){

        loginController.init();
        Mockito.verify(view).show();

    }

    @Test
    public void onLoginValidTest(){

        Mockito.when( authService.authenticate(1) ).thenReturn(true);
        loginController.onLogin(1);
        Mockito.verify(mainController).init();

    }

    @Test
    public void onLoginInvalidTest(){

        Mockito.when( authService.authenticate(1) ).thenReturn(false);
        loginController.onLogin(1);
        Mockito.verify(view).show();

    }

}
