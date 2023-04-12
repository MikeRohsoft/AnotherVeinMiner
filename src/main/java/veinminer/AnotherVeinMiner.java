package veinminer;
import necesse.engine.control.Control;
import necesse.engine.modLoader.annotations.ModEntry;
import necesse.engine.registries.PacketRegistry;
import veinminer.objects.Config;
import veinminer.objects.ConfigKey;
import veinminer.packets.PacketObjectsDestroyed;

@ModEntry
public class AnotherVeinMiner {

    public static Control SPEED_MINE;

    public void init() {
        PacketRegistry.registerPacket(PacketObjectsDestroyed.class);
        SPEED_MINE = Control.addModControl(new ConfigKey(Config.getMiningKey(), "speedmine"));
    }

}
