package pl.jaz.jazapp.login;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class LoginController {
    public String login(LoginRequest loginRequest) {
        System.out.println("asd" + loginRequest.toString());

        return "/index?faces-redirect=true";
    }
}
