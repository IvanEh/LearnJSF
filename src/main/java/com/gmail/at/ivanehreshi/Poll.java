package com.gmail.at.ivanehreshi;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import java.util.List;
import java.util.Random;


// TODO: comments as a separate commit
// TODO: summary: scopes, @ManagedProperty, h:selectOneMenu, f:selectItems
// TODO: manual redirect vs ?redirect-view
@ManagedBean
public class Poll {
    @ManagedProperty(value = "#{pollingService}")
    PollingService pollingService;
    String vote;

    public String getVote() {
        if(vote == null)
            return randomCandidate();
        return vote;
    }

    public void setVote(String vote) {
        this.vote = vote;
    }

    public String processVote() {
        pollingService.vote(getVote());
        return "congrat?faces-redirect=true";
    }

    public String randomCandidate() {
         List<String> candidates = pollingService.getDefaultCandidatesList();
         return candidates.get(new Random().nextInt(candidates.size()));
    }

    public PollingService getPollingService() {
        return pollingService;
    }

    public void setPollingService(PollingService pollingService) {
        this.pollingService = pollingService;
    }
}
