package com.ipping.demo.service.impl;

import com.ipping.demo.model.IpAddress;
import com.ipping.demo.service.interfaces.IpPingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.concurrent.TimeUnit;

@Service
public class IpPingServiceImpl extends CommonServiceImpl<IpAddress> implements IpPingService {

    private final static String pingCommand = "ping %s";

    @Autowired
    private IpPingService ipPingService;

    @Override
    public boolean ping(String ip) {
        Process process = null;

        boolean result = false;
        try {
            process = Runtime.getRuntime().exec(String.format(pingCommand, ip));
            process.waitFor(1, TimeUnit.MILLISECONDS);
            result = getResultExec(process.getInputStream());
            process.destroy();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private boolean getResultExec(InputStream inputStream) throws IOException {
        String line;
        StringBuilder result = new StringBuilder();
        BufferedReader in = new BufferedReader(new InputStreamReader(inputStream));
        while ((line = in.readLine()) != null) {
            result.append(line);
            if (result.toString().contains("Request timeout for")) {
                return false;
            } else if (result.toString().contains("64 bytes from")) {
                return true;
            }
        }
        return false;
    }
}
