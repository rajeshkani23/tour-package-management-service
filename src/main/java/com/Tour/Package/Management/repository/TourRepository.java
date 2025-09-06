package com.Tour.Package.Management.repository;

import com.Tour.Package.Management.model.Tour_package;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TourRepository extends JpaRepository<Tour_package,Long> {
    List<Tour_package> findByLocationIgnoreCase(String location);
}
