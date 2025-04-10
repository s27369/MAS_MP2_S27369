package kwalifikowana;

import java.util.HashMap;
import java.util.Map;

public class Policja {
    private final Map<String, Auto> autoMap = new HashMap<>();

    public void addAuto(Auto auto) {
        if (!autoMap.containsKey(auto.getRejestracja())) {
            autoMap.put(auto.getRejestracja(), auto);
            auto.setPolicja(this);
        }
    }

    public Auto findAutoByRejestracja(String rejestracja) {
        return autoMap.get(rejestracja);
    }

    @Override
    public String toString() {
        return "Policja{" +
                "autoMap=" + autoMap.keySet() +
                '}';
    }
}
