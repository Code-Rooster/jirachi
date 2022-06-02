package roosterwithhands;

import java.util.List;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.*;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;
import net.dv8tion.jda.api.entities.*;
//import net.dv8tion.jda.api.entities.VoiceChannel;
//import net.dv8tion.jda.api.managers.AudioManager;
import roosterwithhands.JirachiCommands.JoinCommand;

public class JirachiBot {
    public static void StartBot() throws LoginException, InterruptedException
    {
        JDA bot = JDABuilder.createDefault(System.getenv("JIRACHI_KEY")).setActivity(Activity.watching("everything unfold"))
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
}
