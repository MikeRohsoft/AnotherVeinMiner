package veinminer.objects;

import necesse.engine.control.Control;

public class ConfigKey extends Control {

    public ConfigKey(int key, String id) {
        super(key, id);
    }

    @Override
    public void changeKey(int key)
    {
        super.changeKey(key);
        Config.setMiningKey(key);
    }
}
