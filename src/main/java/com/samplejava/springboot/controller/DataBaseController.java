package com.samplejava.springboot.controller;

import com.samplejava.springboot.model.UserRequest;
import com.samplejava.springboot.model.Users;
import com.samplejava.springboot.service.SampleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/use_db/v1")
public class DataBaseController {

    private SampleService sampleService;

    public DataBaseController(SampleService sampleService) {
        this.sampleService = sampleService;
    }

    @PostMapping(path = "/save_user")
    public Users saveDB(@RequestBody UserRequest userRequest) throws Exception {
        return sampleService.saveDB(userRequest);
    }

    @GetMapping(path = "/example")
    public List<Integer> getValue() {

        Integer checkValue = 10;
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 8, 9, 10));
        List<Integer> filteredValue = input.stream().filter(x -> x <= checkValue).toList();
        ArrayList<Integer> output = new ArrayList<>();
        filteredValue.forEach(
                x -> {
                    Integer reminder = checkValue - x;
                    Optional<Integer> isAvailable = filteredValue.stream().filter(k -> k == reminder).findAny();
                    if (isAvailable.isPresent()) {
                        output.add(x);
                        output.add(reminder);
                    }
                }
        );
        return output;
    }
}


