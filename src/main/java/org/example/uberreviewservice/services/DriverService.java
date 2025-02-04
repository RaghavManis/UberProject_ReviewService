package org.example.uberreviewservice.services;

import org.example.uberreviewservice.models.Driver;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DriverService {
    public Driver getDriver(Long id);
    public List<Driver> getDrivers();
    public void addDriver(Driver driver);
    public void updateDriver(Driver driver);
    public void deleteDriver(Long id);
    public void deleteDrivers();
}
