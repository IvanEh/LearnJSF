package com.gmail.at.ivanehreshi;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.*;

// This bean is created once for the application lifetime
@ManagedBean(name = "pollingService")
@ApplicationScoped
public class PollingService {
    Map<String, Integer> candidates = new HashMap<>();
    final List<String> defaultCandidatesList = Arrays.asList("Donald Trump", "Hilary Clinton");

    public PollingService() {
        defaultCandidatesList.forEach(this::vote);
    }

    public List<String> getDefaultCandidatesList() {
        return defaultCandidatesList;
    }

    // appears that Set<String> can be used as selectOneMenu
    public Set<String> getCandidatesList() {
        return candidates.keySet();
    }

    public void vote(String candidate) {
        Integer val = candidates.get(candidate);
        if(val == null) {
            val = 0;
        } else {
            val++;
        }

        candidates.put(candidate, val);
    }

    // Dynamically compute the winner
    public Map.Entry<String, Integer> winner() {
        return candidates.entrySet().stream()
                  .reduce((max, curr) -> curr.getValue() > max.getValue() ? curr : max)
                  .orElse(null);
    }
}
