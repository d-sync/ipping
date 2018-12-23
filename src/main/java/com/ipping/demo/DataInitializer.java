package com.ipping.demo;

import com.ipping.demo.model.IpAddress;
import com.ipping.demo.model.Role;
import com.ipping.demo.model.User;
import com.ipping.demo.service.interfaces.IpPingService;
import com.ipping.demo.service.interfaces.RoleService;
import com.ipping.demo.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Arrays;

public class DataInitializer {

    @Autowired
    private IpPingService ipPingService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    public void init() {
        initRoles();
        initUsers();
        initIpAddresses();
    }

    private void initRoles() {
        Role role1 = new Role("USER");
        Role role2 = new Role("ADMIN");
        roleService.add(role1);
        roleService.add(role2);
    }

    private void initUsers() {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        User user = new User(
                "admin",
                passwordEncoder.encode("admin"),
                Arrays.asList(
                        roleService.getRoleByName("USER"),
                        roleService.getRoleByName("ADMIN")),
                true);
        userService.add(user);
    }

    private void initIpAddresses() {
        ipPingService.add(new IpAddress("192.168.127.215", "iView", "computer-127.68","dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.google.com", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("192.168.127.217", "portal", "esxi-127.253", "gloprev@merann.ru"));
        ipPingService.add(new IpAddress("192.168.127.218", "iView", "computer-143.58", "kkarim@merann.ru"));
        ipPingService.add(new IpAddress("www.ya.ru", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.mail.ru", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.yahoo.com", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.ahfasohf.com", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.facebook.com", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.vk.com", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.stackoverflow.com", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.github.com", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.bitbucket.com", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("www.dpkgkgpk34.com", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("127.0.0.1", "AMS", "esxi-127.253", "dmrybach@merann.ru"));
    }

}
