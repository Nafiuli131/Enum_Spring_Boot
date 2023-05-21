package com.example.Enum.Controller;

import com.example.Enum.Dto.RequestEmployee;
import com.example.Enum.Dto.ResponseEmployee;
import com.example.Enum.Dto.StringRequestEmployee;
import com.example.Enum.Dto.StringResponseEmployees;
import com.example.Enum.Service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class Controller {
    @Autowired
    Service service;

    @PostMapping("/postEmployee")
    public ResponseEntity<String> postEmployeeNormalEnum(@RequestBody RequestEmployee requestEmployee) {
        return service.postEmployeeNormalEnum(requestEmployee);
    }

    @GetMapping("/getEmployee")
    public ResponseEntity<ResponseEmployee> getEmployeeInfo(@RequestParam Long id){
        return service.getEmployeeInfo(id);
    }

    //store enum by string controller
    @PostMapping("/postEmployee/string")
    public ResponseEntity<String> postEmployeeStringEnum(@RequestBody StringRequestEmployee stringRequestEmployee) {
        return service.postEmployeeStringEnum(stringRequestEmployee);
    }

    @GetMapping("/getEmployee/string")
    public ResponseEntity<StringResponseEmployees> getStringEmployeeInfo(@RequestParam Long id){
        return service.getStringEmployeeInfo(id);
    }

    //using enum to get specific message
    @GetMapping("/getEmployee/specificMessage")
    public ResponseEntity<String> getSpecificMessage(@RequestParam Long id){
        return service.getSpecificMessage(id);
    }
}
