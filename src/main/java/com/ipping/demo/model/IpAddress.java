package com.ipping.demo.model;

import javax.persistence.*;

@Entity
public class IpAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    private String ip;

    private String server;

    private String address;

    private String owner;

    public IpAddress() {
    }

    public IpAddress(String ip, String server, String address, String owner) {
        this.ip = ip;
        this.server = server;
        this.address = address;
        this.owner = owner;
    }

    public String getIp() {
        return ip;
    }

    public int getId() {
        return id;
    }

    public String getServer() {
        return server;
    }

    public String getAddress() {
        return address;
    }

    public String getOwner() {
        return owner;
    }
}
