package veinminer.objects;

import java.awt.event.KeyEvent;
import java.io.File;
import necesse.engine.GlobalData;
import necesse.engine.save.LoadData;
import necesse.engine.save.SaveData;

public class Config {
    String ores[] = {
        "ironorerock", 
        "copperorerock", 
        "goldorerock", 
        "tungstenorerock", 
        "lifequartzrock",
        "ironoresnow", 
        "copperoresnow", 
        "goldoresnow", 
        "frostshardsnow",
        "ironoresandstone", 
        "copperoresandstone", 
        "goldoresandstone", 
        "quartzsandstone",
        "ironoreswamp", 
        "copperoreswamp", 
        "goldoreswamp", 
        "ivyoreswamp",
        "myceliumoredeepswamp",
        "ironoredeeprock",
        "copperoredeeprock",
        "goldoredeeprock", 
        "tungstenoredeeprock", 
        "lifequartzdeeprock",
        "ironoredeepsnowrock", 
        "copperoredeepsnowrock", 
        "goldoredeepsnowrock", 
        "tungstenoredeepsnowrock", 
        "lifequartzdeepsnowrock", 
        "glacialoredeepsnowrock",
        "ironoredeepsandstonerock", 
        "copperoredeepsandstonerock", 
        "goldoredeepsandstonerock", 
        "ancientfossiloredeepsnowrock", 
        "lifequartzdeepsandstonerock",
        "clayrock",
        "obsidianrock",
        "coalorerock",
        "coaloredeeprock",
        "coaloresnow",
        "coaloreswamp",
        "coaloresandstone",
        "coaloredeepsnowrock",
        "coaloredeepsandstone"
    };
    int radius = 10;
    int miningKey = -1;
    final Character defaultMiningKey = 'z';
    private static final Config OBJ = new Config();

    Config() {
        File file = new File(GlobalData.cfgPath() + "anotherveinminer.cfg");
        if (!file.exists()) {
            this.save(file, KeyEvent.getExtendedKeyCodeForChar(this.defaultMiningKey));
            return;
        }
    
        LoadData save = new LoadData(file);
        this.ores = save.getStringArray("ores", this.ores, false);
        this.radius = save.getInt("radius", this.radius);
        this.miningKey = save.getInt("mining_key", -1);
        
    }

    void save(File file, int miningKey) {
        SaveData saveFile = new SaveData("CONFIG");
        saveFile.addStringArray("ores", this.ores);
        saveFile.addInt("radius", this.radius);
        saveFile.addInt("mining_key", miningKey);
        saveFile.saveScript(file);
    }
    
    public static Config getInstance() {
        return OBJ;
    }

    public static int getMiningKey() {
        return Config.getInstance().miningKey;
    }

    public static void setMiningKey(int c) {
        Config.getInstance().miningKey = c;
        File file = new File(GlobalData.cfgPath() + "anotherveinminer.cfg");
        Config.getInstance().save(file, c);
    }

    public static int getRadius() {
        return Config.getInstance().radius;
    }

    public static String[] getOres() {
        return Config.getInstance().ores;
    }
}
