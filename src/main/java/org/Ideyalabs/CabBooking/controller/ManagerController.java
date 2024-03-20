package org.Ideyalabs.CabBooking.controller;

import org.Ideyalabs.CabBooking.dto.ManagerDto;
import org.Ideyalabs.CabBooking.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @PostMapping("/managers")
    public ManagerDto addManager(@RequestBody ManagerDto managerDto){
        return managerService.addManager(managerDto);
    }
}
