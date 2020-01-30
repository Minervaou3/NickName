package kr.kro.Minerva.Nickname.Change;

import kr.kro.Minerva.Inform;
import kr.kro.Minerva.Main;
import kr.kro.Minerva.Nickname_ok;
import net.dv8tion.jda.api.events.guild.member.update.GuildMemberUpdateNicknameEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.annotation.Nonnull;

public class Member_Nick extends ListenerAdapter {
    @Override
    public void onGuildMemberUpdateNickname(@Nonnull GuildMemberUpdateNicknameEvent event) {
        String New_name = event.getNewNickname();
        New_name = New_name == null ? event.getMember().getUser().getName() : New_name;
        String Old_name = event.getOldNickname();
        Old_name = (Old_name == null) ? event.getMember().getUser().getName() : Old_name;
        if(Nickname_ok.Nick_ok(New_name)){
            Inform.getChannel().sendMessage("정상적인 멤버 닉네임 변경 : " + Old_name +" - > "+ New_name).queue();
            Inform.Remove_Role(event.getMember());
        } else {
            Inform.getChannel().sendMessage("부적합한 멤버 닉네임 변경 : " + Old_name +" - > " + New_name).queue();
            Inform.Add_Role(event.getMember());
        }
    }
}
