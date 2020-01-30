package kr.kro.Minerva;

import kr.kro.Minerva.Nickname.Change.Member_Nick;
import kr.kro.Minerva.Nickname.Change.User_Nick;
import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;

import javax.security.auth.login.LoginException;

public class Main {
    public static JDA jda = null;
    public static void main(String[] args) throws LoginException {
        JDABuilder builder = new JDABuilder(AccountType.CLIENT);
        builder.addEventListeners(new Start());
        builder.addEventListeners(new User_Nick());
        builder.addEventListeners(new Member_Nick());
        builder.setToken("");
        jda = builder.build();
    }
}
