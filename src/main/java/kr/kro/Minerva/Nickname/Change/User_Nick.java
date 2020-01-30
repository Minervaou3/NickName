package kr.kro.Minerva.Nickname.Change;

import kr.kro.Minerva.Inform;
import kr.kro.Minerva.Nickname_ok;
import net.dv8tion.jda.api.events.user.update.UserUpdateNameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.omg.PortableInterceptor.INACTIVE;

import javax.annotation.Nonnull;

import static kr.kro.Minerva.Inform.getGuild;

public class User_Nick extends ListenerAdapter {
    @Override
    public void onUserUpdateName(@Nonnull UserUpdateNameEvent event) {
        if (getGuild().getMember(event.getUser()).getNickname() == null ){
            if (Nickname_ok.Nick_ok(event.getNewName())){
                Inform.getChannel().sendMessage("정상적인 일반 닉네임 변경 : "  + event.getOldName() + " - > " + event.getNewName() ).queue();
                Inform.Remove_Role(getGuild().getMember(event.getUser()));
            } else {
                Inform.getChannel().sendMessage("부적합한 일반 닉네임 변경 : "  + event.getOldName() + " - > " + event.getNewName() ).queue();
                Inform.Add_Role(getGuild().getMember(event.getUser()));
            }
        }
    }
}
