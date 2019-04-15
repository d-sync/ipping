package com.ipping.demo.controller;

import com.ipping.demo.service.interfaces.IpPingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class IpPingController {

    private final IpPingService ipPingService;

    @Autowired
    public IpPingController(IpPingService ipPingService) {
        this.ipPingService = ipPingService;
    }

    @GetMapping("/ipping")
    @PreAuthorize("hasAnyAuthority('ADMIN', 'USER')")
    public ModelAndView getAllPingedIpaddresses() {
        ModelAndView modelAndView = new ModelAndView("ipping");
        modelAndView.addObject("ipaddresses", ipPingService.getAll());
        return modelAndView;
    }

    @GetMapping("/ping")
    @ResponseBody
    public Boolean ping(@RequestParam("ip") String ip) {
        return ipPingService.ping(ip);
    }
    
}
