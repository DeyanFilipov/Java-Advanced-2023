package JavaAdvanced.BasicAlgorithms.Lab.SetCover_04;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Sets {
    public static List<int[]> chooseSets(List<int[]> sets, int[] universe) {
        List<int[]> chosenSets = new ArrayList<>();
        Set<Integer> remainingElements = new HashSet<>();
        for (int element : universe) {
            remainingElements.add(element);
        }

        while (!remainingElements.isEmpty()) {
            int[] maxCoveredSet = null;
            int maxCoveredCount = 0;

            for (int[] set : sets) {
                Set<Integer> intersection = new HashSet<>();
                for (int element : set) {
                    if (remainingElements.contains(element)) {
                        intersection.add(element);
                    }
                }
                int intersectionSize = intersection.size();
                if (intersectionSize > maxCoveredCount) {
                    maxCoveredSet = set;
                    maxCoveredCount = intersectionSize;
                }
            }
            if (maxCoveredSet == null) {
                return chosenSets;
            }
            chosenSets.add(maxCoveredSet);
            for (int element : maxCoveredSet) {
                remainingElements.remove(element);
            }
        }
        return chosenSets;
    }
}
