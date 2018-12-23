package com.ipping.demo.service.interfaces;

import com.ipping.demo.model.IpAddress;

public interface IpPingService extends CommonService<IpAddress>{

    boolean ping(String ip);
}
