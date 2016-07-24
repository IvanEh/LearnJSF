package com.gmail.at.ivanehreshi;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.*;

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

    public Set<String> getCandidatesSet() {
        return candidates.keySet();
    }

    public List<String> getCandidatesSet2() {
        return defaultCandidatesList;
    }

    public void vote(String candidate) {
        Integer val = candidates.get(candidate);
        if(val == null) {
            val = 1;
        } else {
            val++;
        }

        candidates.put(candidate, val);
    }

    public Map.Entry<String, Integer> winner() {
        return candidates.entrySet().stream()
                  .reduce((max, curr) -> curr.getValue() > max.getValue() ? curr : max)
                  .orElse(null);
    }
}
