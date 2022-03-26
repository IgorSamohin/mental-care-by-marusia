package com.polis.api;

import com.polis.api.model.MarusiaResponse;
import com.polis.api.model.MarusiaRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarusiaController {
    @Autowired
    private MarusiaService service;
    private Logger logger = LoggerFactory.getLogger(MarusiaController.class);

    @PostMapping("/webhook")
    @ResponseBody
    public MarusiaResponse mainInput(@RequestBody MarusiaRequest request) {
        return service.handleRequest(request);
    }
}
