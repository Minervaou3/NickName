package kr.kro.Minerva;

import net.dv8tion.jda.api.entities.Guild;
import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Role;
import net.dv8tion.jda.api.entities.TextChannel;
import org.jetbrains.annotations.Nullable;

public class Inform {
    static Role ADMIN = getGuild().getRoleById("427135653596364811");
    static Role OWNER = getGuild().getRoleById("427120196990402560");
    @Nullable
    public static Guild getGuild(){
        Guild guild = Main.jda.getGuildById("427102167929847808");
        guild = Main.jda.getGuilds().contains(guild) ? guild : null;
        return guild;
    }
    public static TextChannel getChannel(){
        TextChannel channel = getGuild().getTextChannelById("658324792155308032");
        return channel;
    }
    public static Role getDont(){
        Role role = getGuild().getRoleById("658631822426505240");
        return role;
    }
    public static void Remove_Role(Member member){
        if (!(getGuild().getMembersWithRoles(ADMIN).contains(member)||getGuild().getMembersWithRoles(OWNER).contains(member))) {
            if(getGuild().getMembersWithRoles(getDont()).contains(member)) {
                getGuild().removeRoleFromMember(member, getDont()).queue();
            }
        }
    }
    public static void Add_Role(Member member) {
        if (!(getGuild().getMembersWithRoles(ADMIN).contains(member)||getGuild().getMembersWithRoles(OWNER).contains(member))) {
            if(!getGuild().getMembersWithRoles(getDont()).contains(member)) {
            getGuild().addRoleToMember(member, getDont()).queue();
        }
    }
}
}
