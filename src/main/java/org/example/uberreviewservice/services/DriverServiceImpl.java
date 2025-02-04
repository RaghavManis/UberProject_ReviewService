package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Driver;
import org.example.uberreviewservice.repositories.DriverRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverServiceImpl implements DriverService {

//    @Autowired
    DriverRepository driverRepository;

    public DriverServiceImpl(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @Override
    public Driver getDriver(Long id) {
        return driverRepository.getDriverById(id);
    }

    @Override
    public List<Driver> getDrivers() {
        return driverRepository.findAll();
    }

    @Override
    public void addDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public void updateDriver(Driver driver) {
        driverRepository.save(driver);
    }

    @Override
    public void deleteDriver(Long id) {
        driverRepository.deleteById(id);
    }

    @Override
    public void deleteDrivers() {
        driverRepository.deleteAll();
    }
}
