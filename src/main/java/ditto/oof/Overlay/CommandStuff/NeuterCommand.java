package ditto.oof.Overlay.CommandStuff;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import com.pixelmonmod.pixelmon.api.dialogue.Dialogue;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;
import com.pixelmonmod.pixelmon.comm.packetHandlers.npc.CreateNPCPacket;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextFormatting;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

import java.util.ArrayList;

public class NeuterCommand implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Player player = (Player) src;

        //Defines Code
        int money = Pixelmon.storageManager.getParty((EntityPlayerMP) player).getMoney();
        String value = String.valueOf(money);

        if(money >= 100) {
            Choice.ChoiceBuilder choice1 = new Choice.ChoiceBuilder()
                    .setText("Slot 1")
                    .setHandle(handle -> {
                        Pokemon pokemon1 = Pixelmon.storageManager.getParty((EntityPlayerMP) player).get(0);
                        pokemon1.addSpecFlag("unbreedable");

                        if (pokemon1.hasSpecFlag("unbreedable")) {

                            player.sendMessage(Text.of(TextFormatting.RED + "Success You Have Neutered " + TextFormatting.GOLD + pokemon1.getDisplayName()));
                        }
                    });


            Choice.ChoiceBuilder choice2 = new Choice.ChoiceBuilder()
                    .setText("Slot 2")
                    .setHandle(handle -> {
                        Pokemon pokemon2 = Pixelmon.storageManager.getParty((EntityPlayerMP) player).get(1);
                        pokemon2.addSpecFlag("unbreedable");

                        if (pokemon2.hasSpecFlag("unbreedable")) {

                            player.sendMessage(Text.of(TextFormatting.RED + "Success You Have Neutered " + TextFormatting.GOLD + pokemon2.getDisplayName()));
                        }
                    });
            Choice.ChoiceBuilder choice3 = new Choice.ChoiceBuilder()
                    .setText("Slot 3")
                    .setHandle(handle -> {
                        Pokemon pokemon3 = Pixelmon.storageManager.getParty((EntityPlayerMP) player).get(2);
                        pokemon3.addSpecFlag("unbreedable");

                        if (pokemon3.hasSpecFlag("unbreedable")) {

                            player.sendMessage(Text.of(TextFormatting.RED + "Success You Have Neutered " + TextFormatting.GOLD + pokemon3.getDisplayName()));
                        }
                    });
            Choice.ChoiceBuilder choice4 = new Choice.ChoiceBuilder()
                    .setText("Slot 4")
                    .setHandle(handle -> {
                        Pokemon pokemon4 = Pixelmon.storageManager.getParty((EntityPlayerMP) player).get(3);
                        pokemon4.addSpecFlag("unbreedable");

                        if (pokemon4.hasSpecFlag("unbreedable")) {

                            player.sendMessage(Text.of(TextFormatting.RED + "Success You Have Neutered " + TextFormatting.GOLD + pokemon4.getDisplayName()));
                        }
                    });
            Choice.ChoiceBuilder choice5 = new Choice.ChoiceBuilder()
                    .setText("Slot 5")
                    .setHandle(handle -> {
                        Pokemon pokemon5 = Pixelmon.storageManager.getParty((EntityPlayerMP) player).get(4);
                        pokemon5.addSpecFlag("unbreedable");

                        if (pokemon5.hasSpecFlag("unbreedable")) {

                            player.sendMessage(Text.of(TextFormatting.RED + "Success You Have Neutered " + TextFormatting.GOLD + pokemon5.getDisplayName()));
                        }
                    });
            Choice.ChoiceBuilder choice6 = new Choice.ChoiceBuilder()
                    .setText("Slot 6")
                    .setHandle(handle -> {
                        Pokemon pokemon6 = Pixelmon.storageManager.getParty((EntityPlayerMP) player).get(5);
                        pokemon6.addSpecFlag("unbreedable");

                        if (pokemon6.hasSpecFlag("unbreedable")) {
                            player.sendMessage(Text.of(TextFormatting.GREEN + "Success You Have Neutered " + TextFormatting.GOLD + pokemon6.getDisplayName()));

                        }
                    });


            new Dialogue.DialogueBuilder()
                    .setName("Doctor")
                    .setText("Which Pokemon do you wish to neuter?")
                    .addChoice(choice1.build())
                    .addChoice(choice2.build())
                    .addChoice(choice3.build())
                    .addChoice(choice4.build())
                    .addChoice(choice5.build())
                    .addChoice(choice6.build())
                    .build()
                    .open((EntityPlayerMP) player);
        }else{
            player.sendMessage(Text.of(TextFormatting.RED + "You Need At Least $5000"));

        }


        ArrayList<Player> PlayerToBan = new ArrayList<Player>(Sponge.getServer().getOnlinePlayers());
        PlayerToBan.addAll(Sponge.getServer().getOnlinePlayers());










        return CommandResult.success();
    }
}
