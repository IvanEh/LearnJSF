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
    // JSF have a simple built-in dependency injection
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

    // faces-redirect changes the url
    public String processVote() {
        pollingService.vote(getVote());
        return "congrat?faces-redirect=true";
    }

    // this method called by expression #{poll.randomCandidate()}
    public String randomCandidate() {
         List<String> candidates = pollingService.getDefaultCandidatesList();
         return candidates.get(new Random().nextInt(candidates.size()));
    }

    // For DI
    public PollingService getPollingService() {
        return pollingService;
    }

    // For DI
    public void setPollingService(PollingService pollingService) {
        this.pollingService = pollingService;
    }
}
