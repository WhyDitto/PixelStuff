package ditto.oof.Overlay.CommandStuff;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import com.pixelmonmod.pixelmon.api.dialogue.Dialogue;
import com.pixelmonmod.pixelmon.entities.npcs.EntityNPC;
import net.minecraft.entity.player.EntityPlayerMP;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class command implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {

            Player player = args.<Player>getOne("player").get();


            //Choice

            Choice.ChoiceBuilder choice1 = new Choice.ChoiceBuilder()
                    .setText("Yes!")
                    .setHandle(handle -> {
                       player.sendMessage(Text.of("Choice 1"));
                    });
            Choice.ChoiceBuilder choice2 = new Choice.ChoiceBuilder()
                    .setText("No!")
                    .setHandle(handle ->{
                        player.sendMessage(Text.of("Choice 2"));
                    });




            new Dialogue.DialogueBuilder()
                    .setName("Trainer")
                    .setText("Do you wish to fight?")
                    .addChoice(choice1.build())
                    .addChoice(choice2.build())
                    .build()
                    .open((EntityPlayerMP) player);





        return CommandResult.success();
    }
}
