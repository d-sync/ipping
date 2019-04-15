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
        ipPingService.add(new IpAddress("192.168.127.215", "iView-OTT", "192.168.127.253","dmrybach@merann.ru"));
        ipPingService.add(new IpAddress("192.168.127.216", "esxi", "192.168.127.216", "kulkov@mera.ru"));
        ipPingService.add(new IpAddress("192.168.127.217", "esxi", "192.168.127.217", "kulkov@mera.ru"));
        ipPingService.add(new IpAddress("192.168.127.236", "iView", "192.168.128.243", "loparev@mera.ru"));
        
        ipPingService.add(new IpAddress("192.168.127.237", "unknown", "unknown", "unknown"));
        ipPingService.add(new IpAddress("192.168.127.239", "MCU/AAMS", "192.168.128.243", "loparev@mera.ru"));
        ipPingService.add(new IpAddress("192.168.127.221", "unknown", "unknown", "unknown"));
        ipPingService.add(new IpAddress("192.168.127.222", "unknown", "unknown", "unknown"));
        ipPingService.add(new IpAddress("192.168.127.223", "unknown", "unknown", "unknown"));
        ipPingService.add(new IpAddress("192.168.127.224", "unknown", "unknown", "unknown"));
        ipPingService.add(new IpAddress("192.168.127.225", "unknown", "unknown", "unknown"));
        ipPingService.add(new IpAddress("192.168.127.226", "unknown", "unknown", "unknown"));
        ipPingService.add(new IpAddress("192.168.127.227", "unknown", "unknown", "unknown"));
        ipPingService.add(new IpAddress("192.168.127.228", "unknown", "unknown", "unknown"));
        ipPingService.add(new IpAddress("192.168.127.229", "unknown", "unknown", "unknown"));
    }

}
