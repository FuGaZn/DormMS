package com.demo.model;

import java.util.Objects;

public class Access {
    int aid;
    String name;
    int status;
    int level;
    String module;
    String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Access access = (Access) o;
        if (access.getAid() == aid)
            return true;
        return status == access.status &&
                level == access.level &&
                name.equals(access.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status, level);
    }

    @Override
    public String toString() {
        return "Access{" +
                "aid=" + aid +
                ", name='" + name + '\'' +
                ", status=" + status +
                ", level=" + level +
                ", module='" + module + '\'' +
                '}';
    }
}
