package roosterwithhands.JirachiBot;

import java.util.List;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import roosterwithhands.JirachiBot.JirachiCommands.JoinCommand;
import net.dv8tion.jda.api.entities.*;

public class JirachiBot
{
    public static final String discordID = "314249408332169227";
    public static final String guildID = "981613645047930961";

    public static JDA bot;

    public static void StartBot() throws LoginException, InterruptedException
    {
        bot = JDABuilder.createDefault(System.getenv("JIRACHI_KEY")).setActivity(Activity.watching("everything unfold"))
        .addEventListeners(new JoinCommand())
        .build().awaitReady();

        List<Guild> guilds = bot.getGuilds();

        for (Guild guild : guilds) 
        {
            if(guild != null)
            {
                guild.upsertCommand("join", "join the VC that the user is in.").queue();
            }
            else
            {
                System.out.println("guild not found.");
            }
        }
    }

    public static void PlayTestMusic()
    {
        for (VoiceChannel channel : bot.getGuildById(guildID).getVoiceChannels()) 
        {
            for (Member member : channel.getMembers()) 
            {
                if(member.getId().equals(discordID))
                {
                    PlayerManager.getInstance().loadAndPlay("src/music/Monster House!.mp3");
                }
            }
        }
    }
}
