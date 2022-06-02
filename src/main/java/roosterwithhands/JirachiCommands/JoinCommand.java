package roosterwithhands.JirachiCommands;

import org.jetbrains.annotations.NotNull;

import net.dv8tion.jda.api.entities.VoiceChannel;
import net.dv8tion.jda.api.events.guild.voice.GuildVoiceLeaveEvent;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.dv8tion.jda.api.managers.AudioManager;

public class JoinCommand extends ListenerAdapter
{
    VoiceChannel currentVC = null;

    @Override
    public void onSlashCommandInteraction(@NotNull SlashCommandInteractionEvent event)
    {
        if(event.getName().equals("join"))
        {
            

            for (VoiceChannel vc : event.getGuild().getVoiceChannels())
            {
                if(vc.getMembers().contains(event.getMember()))
                {
                    currentVC = vc;
                    break;
                }
            }

            if(currentVC != null)
            {
                AudioManager aM = event.getGuild().getAudioManager();

                System.out.println("received join command from user " + event.getUser());
                event.reply("m-kay!! joining " + currentVC.getName()).queue();;

                aM.openAudioConnection(currentVC);
            }
            else
            {
                event.reply("please only use this command while you are inside of a voice channel :3 thank you!!").queue();
            }
        }
    }

    @Override
    public void onGuildVoiceLeave(@NotNull GuildVoiceLeaveEvent event)
    {
        if(currentVC != null)
        {
            if(event.getChannelLeft().getId().equals(currentVC.getId()) && event.getChannelLeft().getMembers().size() == 1)
            {
                event.getGuild().getAudioManager().closeAudioConnection();
            }
        }
    }
}
