package com.polis.api;

import com.polis.api.model.Request;
import com.polis.api.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MarusiaController {
    @Autowired
    private MarusiaService service;

    @PostMapping
    @ResponseBody
    public Response mainInput(Request request) {
        return service.handleRequest(request);
    }
}
