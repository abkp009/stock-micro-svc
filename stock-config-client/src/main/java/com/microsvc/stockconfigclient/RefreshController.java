package com.microsvc.stockconfigclient;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.endpoint.RefreshEndpoint;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
class RefreshController {

    @Autowired
    RefreshEndpoint refreshEndpoint;

    @RequestMapping(value = "/refresh", method = RequestMethod.POST)
    Collection<String> refresh() {
        return refreshEndpoint.refresh();
    }
}