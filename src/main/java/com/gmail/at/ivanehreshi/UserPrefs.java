package com.gmail.at.ivanehreshi;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;

@ManagedBean
@SessionScoped
public class UserPrefs {
    String dynTextCss1 = "color: yellow";
    String dynTextCss2 = "font-size: 15pt";
    String dynTextCss;

    public void setDynTextCss(String dynTextCss) {
        this.dynTextCss = dynTextCss;
    }

    public String getDynTextCss() {
        return dynTextCss;
    }

    public void changeDynTextCss(ActionEvent e) {
        if (getDynTextCss() == dynTextCss1)
            setDynTextCss(dynTextCss2);
        else if (getDynTextCss() == dynTextCss2)
            setDynTextCss(null);
        else
            setDynTextCss(dynTextCss1);
    }
}
