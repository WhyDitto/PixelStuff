package ditto.oof.Overlay.Eventss;

import com.pixelmonmod.pixelmon.api.overlay.notice.EnumOverlayLayout;
import com.pixelmonmod.pixelmon.api.overlay.notice.NoticeOverlay;
import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.event.Listener;
import org.spongepowered.api.event.filter.cause.Root;
import org.spongepowered.api.event.network.ClientConnectionEvent;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.Sponge;

import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import com.google.inject.Inject;
import org.spongepowered.api.plugin.PluginManager;


public class PlayerJoin {
    private PluginManager pluginManager = Sponge.getPluginManager();
    private PluginContainer plugin = pluginManager.getPlugin("work").orElse(null);
    Timer timer;
    int interval = 30;
    public static int secondss = 60;
    public static Task.Builder taskbuilder = Task.builder();
    public static EntityPlayerMP playerDialogue;

    @SubscribeEvent
    public void onPlayerLog(PlayerEvent.PlayerLoggedInEvent e) {
        if (e.player instanceof EntityPlayerMP) {



            ItemStack stack = new ItemStack(Item.getItemById(399));
                    


            EntityPlayerMP player = (EntityPlayerMP) e.player;
            playerDialogue = (EntityPlayerMP) e.player;
            NoticeOverlay.Builder overlay = new NoticeOverlay().builder();
            overlay.setLines("Welcome To", TextFormatting.GOLD + "" + TextFormatting.BOLD + "Pixel" + TextFormatting.RESET + "" + TextFormatting.GREEN + "Valley")
                    .setPokemonSprite(new PokemonSpec("Victini"))
                    .setLayout(EnumOverlayLayout.LEFT_AND_RIGHT)
                    .sendTo(player);
            NoticeOverlay.Builder overlay1 = new NoticeOverlay().builder();
            overlay1.setLines("Join Our Discord", TextFormatting.GOLD + "" + TextFormatting.BOLD + "/Discord")
                    .setPokemonSprite(new PokemonSpec("Rotom"))
                    .setLayout(EnumOverlayLayout.LEFT_AND_RIGHT);
            NoticeOverlay.Builder overlay2 = new NoticeOverlay().builder();
            overlay2.setLines(TextFormatting.YELLOW + "Vote For Rewards", TextFormatting.GREEN + "/Vote")
                    .setItemStack(stack)
                    .setLayout(EnumOverlayLayout.LEFT_AND_RIGHT);


            Sponge.getServer().getBroadcastChannel().send(Text.of("Hello"));
            taskbuilder.interval(1, TimeUnit.SECONDS).execute(task -> {
                secondss--;

                if (secondss == 50){
                    overlay1.sendTo(player);
                }else if (secondss == 30){
                    overlay2.sendTo(player);
                }else if (secondss == 20){
                    overlay.sendTo(player);


                }
                else if (secondss == 10) {
                    overlay2.sendTo(player);
                }
                else if(secondss == 1){
                    overlay.sendTo(player);

                    secondss = 61;

                }if(player.hasDisconnected()){
                task.cancel();
                }


            }).submit(plugin);


/*
            taskbuilder.execute(new Runnable() {


                @Override
                public void run() {
                    secondss--;
                    Sponge.getServer().getBroadcastChannel().send(Text.of("Remaining Time: " + secondss));
                    if (secondss == 50){
                        overlay1.sendTo(player);
                    }else if (secondss == 30){
                        overlay2.sendTo(player);
                    }else if (secondss == 20){
                        overlay.sendTo(player);


                    }
                  else if (secondss == 10) {
                      overlay2.sendTo(player);
                    }
                    else if(secondss == 1){
                        overlay.sendTo(player);

                        secondss = 61;

                    }if(player.hasDisconnected()){

                    }
                }



            }).interval(1, TimeUnit.SECONDS).name("Sub").submit(plugin);

*/
        }


    }



}
