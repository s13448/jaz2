package pl.jaz.jazapp.register;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class RegisterController {
    public String register(RegisterRequest registerRequest) {
        System.out.println("asd" + registerRequest.toString());

        return "/register?faces-redirect=true";
    }
}
