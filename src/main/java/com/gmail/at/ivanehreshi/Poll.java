package com.gmail.at.ivanehreshi;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.ActionListener;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Random;

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

        return "404";
    }

    // this method called by expression #{poll.randomCandidate()}
    public String randomCandidate() {
         List<String> candidates = pollingService.getDefaultCandidatesList();
         return candidates.get(new Random().nextInt(candidates.size()));
    }

    public void actionListener(ActionEvent e) {
        System.out.println(getVote());
        setVote("Hilarious");
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
