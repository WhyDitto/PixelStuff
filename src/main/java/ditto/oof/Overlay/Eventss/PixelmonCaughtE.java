package ditto.oof.Overlay.Eventss;

import com.pixelmonmod.pixelmon.Pixelmon;
import com.pixelmonmod.pixelmon.api.enums.ReceiveType;
import com.pixelmonmod.pixelmon.api.events.PixelmonReceivedEvent;
import com.pixelmonmod.pixelmon.api.overlay.notice.EnumOverlayLayout;
import com.pixelmonmod.pixelmon.api.overlay.notice.NoticeOverlay;
import com.pixelmonmod.pixelmon.api.pokemon.Pokemon;

import com.pixelmonmod.pixelmon.api.pokemon.PokemonSpec;
import com.pixelmonmod.pixelmon.enums.EnumSpecies;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.scheduler.Task;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.text.format.TextColors;

import java.util.concurrent.TimeUnit;

public class PixelmonCaughtE {

    @SubscribeEvent
    public void trainerCaught(PixelmonReceivedEvent e) {
        if (e.receiveType == ReceiveType.PokeBall) {

            //Define Variables
            EntityPlayerMP player = e.player;
            Pokemon pokemon = e.pokemon;
            //Define messages
            TextComponentString message = new TextComponentString("You Got " + e.pokemon.getDisplayName());
            TextComponentString poke = new TextComponentString(pokemon.getDisplayName());
            TextComponentString spam = new TextComponentString("Hello " + player.getDisplayName());
            TextComponentString welcome = new TextComponentString("Welcome to ");
            TextComponentString pixel = new TextComponentString("Pixel");
            TextComponentString valley = new TextComponentString("Valley");
            message.getStyle().setColor(TextFormatting.BLUE);







            //Notice OverLay Builder


            //Send message to the actual player

            player.sendMessage(message);







        }
    }
}
