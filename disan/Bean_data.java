package com.example.zhinengjiaotong;

public class Bean_data {

    int id;
    String peopleName;
    String icon;
    int status;
    int talentMarketId;
    int gold;
    int hp;
    String content;


    public Bean_data(int id, String peopleName, String icon, int status, int talentMarketId, int gold, int hp, String content) {
        this.id = id;
        this.peopleName = peopleName;
        this.icon = icon;
        this.status = status;
        this.talentMarketId = talentMarketId;
        this.gold = gold;
        this.hp = hp;
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPeopleName() {
        return peopleName;
    }

    public void setPeopleName(String peopleName) {
        this.peopleName = peopleName;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTalentMarketId() {
        return talentMarketId;
    }

    public void setTalentMarketId(int talentMarketId) {
        this.talentMarketId = talentMarketId;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
