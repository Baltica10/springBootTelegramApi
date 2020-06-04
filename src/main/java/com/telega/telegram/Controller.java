package com.telega.telegram;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping(value = "/tlg")
public class Controller {

    private final Bot bot;

    public Controller(Bot bot) {
        this.bot = bot;
    }

    @GetMapping()
    public ResponseEntity<String> sendMsg(@RequestParam(value = "msg") String msg) {
        log.info("sending msg: " + msg);
        bot.sendMsg(msg);
        return ResponseEntity.ok("message send: " + msg);
    }
}
