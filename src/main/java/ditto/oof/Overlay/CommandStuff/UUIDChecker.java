package ditto.oof.Overlay.CommandStuff;

import org.spongepowered.api.command.CommandException;
import org.spongepowered.api.command.CommandResult;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.spec.CommandExecutor;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.text.Text;

public class UUIDChecker implements CommandExecutor {
    @Override
    public CommandResult execute(CommandSource src, CommandContext args) throws CommandException {
        Player playerArgs = args.<Player>getOne("player").get();
        Player sender = (Player) src;
       String uuid = playerArgs.getUniqueId().toString();
       sender.sendMessage(Text.of(uuid));






        return CommandResult.success();
    }
}
