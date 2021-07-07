package ditto.oof.Overlay.CommandStuff;

import com.pixelmonmod.pixelmon.enums.items.EnumPokeballs;
import com.pixelmonmod.pixelmon.items.ItemPokeball;
import dev.flashlabs.flashlibs.inventory.Element;
import dev.flashlabs.flashlibs.inventory.Layout;
import dev.flashlabs.flashlibs.inventory.View;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.api.GameRegistry;
import org.spongepowered.api.Sponge;
import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.item.ItemType;
import org.spongepowered.api.item.ItemTypes;
import org.spongepowered.api.item.inventory.Inventory;
import org.spongepowered.api.item.inventory.InventoryArchetypes;
import org.spongepowered.api.plugin.PluginContainer;
import org.spongepowered.api.plugin.PluginManager;
import org.spongepowered.api.text.Text;
import org.spongepowered.api.item.ItemTypes;

import java.util.Optional;


public class Inventoy implements CommandExecutor {
    private PluginManager pluginManager = Sponge.getPluginManager();
    private PluginContainer plugin = pluginManager.getPlugin("work").orElse(null);
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {


        Player player = (Player) src;
        org.spongepowered.api.item.inventory.ItemStack stone = org.spongepowered.api.item.inventory.ItemStack.builder().itemType(ItemTypes.STONE).build();
        org.spongepowered.api.item.inventory.ItemStack dirt = org.spongepowered.api.item.inventory.ItemStack.builder().itemType(ItemTypes.DIRT).build();
        org.spongepowered.api.item.inventory.ItemStack grass = org.spongepowered.api.item.inventory.ItemStack.builder().itemType(ItemTypes.GRASS).build();
        ItemStack stack = new ItemStack(Item.getItemById(399));

        String itemID = "<5263>:<pixelmon:master_ball>";



        Element element = Element.of(dirt, action -> {
            action.getPlayer().closeInventory();
            action.getPlayer().sendMessage(Text.of("Hello"));

        });
        Layout layout = Layout.builder(3, 9)
                .border(Element.of(stone))
                .fill(Element.of(dirt))
                .set(element, 11)
                .build();



        View view = View.builder(InventoryArchetypes.CHEST)
                .title(Text.of("Hello"))
                .build(plugin).update(layout);
        view.set(element, 10);
        view.open(player);










        return CommandResult.success();
    }

}
