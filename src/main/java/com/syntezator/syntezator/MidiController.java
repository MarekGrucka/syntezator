package com.syntezator.syntezator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MidiController {


    @GetMapping("/midi")
    public List<String> getMidis() {
        List<String> midis = new ArrayList<>();
        midis.add("test1");

        return midis;
    }
}
