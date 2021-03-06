package com.polis.api;

import com.polis.api.model.MarusiaRequest;
import com.polis.api.model.MarusiaResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@CrossOrigin(value = "https://skill-debugger.marusia.mail.ru")
public class MarusiaController {
    private final Logger logger = LoggerFactory.getLogger(MarusiaController.class);
    private final MarusiaService service;

    @Autowired
    public MarusiaController(MarusiaService service) {
        this.service = service;
    }

    @PostMapping("/webhook")
    @ResponseBody
    public MarusiaResponse mainInput(@RequestBody MarusiaRequest request) {
        return service.handleRequest(request);
    }
}
