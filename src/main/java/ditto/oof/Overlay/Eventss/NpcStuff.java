package ditto.oof.Overlay.Eventss;

import com.pixelmonmod.pixelmon.api.dialogue.Choice;
import com.pixelmonmod.pixelmon.api.dialogue.Dialogue;
import com.pixelmonmod.pixelmon.api.events.npc.NPCEvent;
import com.pixelmonmod.pixelmon.entities.npcs.EntityNPC;
import com.pixelmonmod.pixelmon.enums.EnumNPCType;
import ibxm.Player;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.command.spec.CommandSpec;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.text.Text;

public class NpcStuff {
    private PluginManager pluginManager = Sponge.getPluginManager();
    private PluginContainer plugin = pluginManager.getPlugin("work").orElse(null);
    public static EntityNPC npc;
    public static EnumNPCType type;
    public static EntityPlayerMP playerGlobal;
@SubscribeEvent
    public void interact(PlayerInteractEvent.EntityInteractSpecific e){
    EntityPlayerMP player = (EntityPlayerMP) e.getEntityPlayer();
    if(e.getEntity().getDisplayName().equals("Trainer1")){
        
        Choice.ChoiceBuilder choice1 = new Choice.ChoiceBuilder()
                .setText("No!")
                .setHandle(handle -> {
                    player.sendMessage(new TextComponentString("Choice1"));
                });
        Choice.ChoiceBuilder choice2 = new Choice.ChoiceBuilder()
                .setText("Yes!")
                .setHandle(handle ->{
                    player.sendMessage(new TextComponentString("Choice2"));
                });




        new Dialogue.DialogueBuilder()
                .setName("Trainer")
                .setText("Do you wish to fight?")
                .addChoice(choice1.build())
                .addChoice(choice2.build())
                .build()
                .open((EntityPlayerMP) player);
    }
}

}
