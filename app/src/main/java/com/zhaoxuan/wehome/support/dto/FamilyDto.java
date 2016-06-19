package com.zhaoxuan.wehome.support.dto;

import com.example.DataProperty;
import com.example.IdProperty;
import com.zhaoxuan.wehome.support.utils.StrUtils;

import java.io.Serializable;

/**
 * Created by lizhaoxuan on 16/1/7.
 */
public class FamilyDto implements Serializable {

    @IdProperty
    protected long id;
    @DataProperty
    protected String account;
    @DataProperty
    protected String name;
    @DataProperty
    protected String post;
    @DataProperty
    protected String city;
    @DataProperty
    protected String headPath;
    @DataProperty
    protected int electric;

    private String weather;

    public FamilyDto() {
    }

    public FamilyDto(String account, String city, int electric, String headPath, String name, String post) {
        this.account = account;
        this.city = city;
        this.electric = electric;
        this.headPath = headPath;
        this.name = name;
        this.post = post;
    }

    public String getFullName() {
        return name + " | " + post;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getElectric() {
        return electric;
    }

    public void setElectric(int electric) {
        this.electric = electric;
    }

    public String getHeadPath() {
        return headPath;
    }

    public void setHeadPath(String headPath) {
        this.headPath = headPath;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getWeather() {
        if (StrUtils.isNullStr(weather)) {
            weather = "-";
        }
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }
}
