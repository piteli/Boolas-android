package com.rush.wender.boolas;

/**
 * Created by Fitri San on 8/18/2017.
 */

public class CardSecond {
    private String imgURL;
    private String act_name;
    private String act_from;
    private String act_to;
    private String act_desc;

    public CardSecond(String imgURL, String act_name, String act_from, String act_to, String act_desc) {
        this.imgURL = imgURL;
        this.act_name = act_name;
        this.act_from = act_from;
        this.act_to = act_to;
        this.act_desc = act_desc;
    }

    public String getImgURL() {
        return imgURL;
    }

    public String getAct_name() {
        return act_name;
    }

    public String getAct_from() {
        return act_from;
    }

    public String getAct_to() {
        return act_to;
    }

    public String getAct_desc() {
        return act_desc;
    }

    public void setImgURL(String imgURL) {
        this.imgURL = imgURL;
    }

    public void setAct_name(String act_name) {
        this.act_name = act_name;
    }

    public void setAct_from(String act_from) {
        this.act_from = act_from;
    }

    public void setAct_to(String act_to) {
        this.act_to = act_to;
    }

    public void setAct_desc(String act_desc) {
        this.act_desc = act_desc;
    }
}
