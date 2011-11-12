package factory

import ninja.Ninja
import ninja.NinjaHouse

abstract class ObjectFactory {
    public static final Object NOTHING = new Object();
    static Ninja ninja(Map params = [:]){
        return new Ninja([name:"Splinter"]+params)
    }

    static NinjaHouse ninjaHouse(Map params = [:]) {
        return new NinjaHouse([name: "Sewers", ninjas: [ninja()]]+params)
    }
}
