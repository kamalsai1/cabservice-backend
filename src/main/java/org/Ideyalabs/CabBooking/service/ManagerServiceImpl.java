package org.Ideyalabs.CabBooking.service;

import org.Ideyalabs.CabBooking.dto.ManagerDto;
import org.Ideyalabs.CabBooking.model.Manager;
import org.Ideyalabs.CabBooking.repository.ManagerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ManagerServiceImpl implements ManagerService{
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ManagerRepository managerRepository;
    @Override
    public ManagerDto addManager(ManagerDto managerDto) {
        Manager manager = modelMapper.map(managerDto, Manager.class);
        return modelMapper.map(managerRepository.save(manager), ManagerDto.class);
    }
}
