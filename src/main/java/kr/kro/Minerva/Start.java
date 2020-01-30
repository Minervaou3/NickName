package kr.kro.Minerva;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

import static kr.kro.Minerva.Inform.*;

public class Start extends ListenerAdapter {
    @Override
    public void onReady(@Nonnull ReadyEvent event) {
        System.out.println("I'm Ready!");
        int ok = 0;
        int no = 0;
        for(int i = 0; i < getGuild().getMemberCount(); i++){
            Member member = getGuild().getMembers().get(i);
            String name = member.getEffectiveName();

            if (Nickname_ok.Nick_ok(name)) {
                //System.out.println("허용된 닉네임 : " + name);
                Remove_Role(member);
                ok++;
            } else {
               //System.out.println("허용되지 않는 닉네임 : " + name);
                Add_Role(member);
                no++;
            }
        }
        getChannel().sendMessage("허용된 인원 : "+ ok +" 부적합 인원 :" + no).queue();
    }
}
