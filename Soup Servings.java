import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public double soupServings(int n) {
        if (n >= 4451) {
            return 1.0;
        }
        return soupServings(n, n, new HashMap<>());
    }

    private double soupServings(int soupAVolume, int soupBVolume, Map<List<Integer>, Double> cache) {
        if (soupAVolume <= 0 && soupBVolume <= 0) {
            return 0.5;
        } else if (soupAVolume <= 0) {
            return 1;
        } else if (soupBVolume <= 0) {
            return 0;
        }
        if (cache.containsKey(List.of(soupAVolume, soupBVolume))) {
            return cache.get(List.of(soupAVolume, soupBVolume));
        }
        double p1 = soupServings(soupAVolume - 100, soupBVolume, cache);
        double p2 = soupServings(soupAVolume - 75, soupBVolume - 25, cache);
        double p3 = soupServings(soupAVolume - 50, soupBVolume - 50, cache);
        double p4 = soupServings(soupAVolume - 25, soupBVolume - 75, cache);
        double p = (p1 + p2 + p3 + p4) * 0.25;
        cache.put(List.of(soupAVolume, soupBVolume), p);
        return p;
    }
}
