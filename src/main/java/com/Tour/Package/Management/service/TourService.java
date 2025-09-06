package com.Tour.Package.Management.service;

import com.Tour.Package.Management.dto.TourRequest;
import com.Tour.Package.Management.dto.TourResponse;
import com.Tour.Package.Management.model.Tour_package;
import com.Tour.Package.Management.repository.TourRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TourService {
    private  final TourRepository repository;

    public TourService(TourRepository repository) {
        this.repository = repository;
    }
    public TourResponse createTour(TourRequest request) {
        Tour_package entity = new Tour_package();
        entity.setImage(request.getImage());
        entity.setDiscountInpercentage(request.getDiscountInPercentage());
        entity.setTitle(request.getTitle());
        entity.setDescription(request.getDescription());
        entity.setDuration(request.getDuration());
        entity.setActual_price(request.getActualPrice());
        entity.setDescription(request.getDiscountedPrice());
        entity.setLocation(request.getLocation());

        Tour_package saved = repository.save(entity);
        return toResponse(saved);
    }
    //List All tours
    public List<TourResponse> listAll() {
        return repository.findAll().stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    // Get Tour By ID
    public Optional<TourResponse> getById(Long id) {
        return repository.findById(id).map(this::toResponse);
    }

    // Search by Location
    public List<TourResponse> searchByLocation(String location) {
        return repository.findByLocationIgnoreCase(location).stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }
    private TourResponse toResponse(Tour_package t) {
        return new TourResponse(
                t.getId(),
                t.getImage(),
                t.getDiscountInpercentage(),
                t.getTitle(),
                t.getDescription(),
                t.getDuration(),
                t.getActual_price(),
                t.getDiscounted_price(),
                t.getLocation()
        );
}
    public boolean updateImageUrl(Long id, String url) {
        return repository.findById(id).map(tour -> {
            tour.setImage(url);
            repository.save(tour);
            return true;
        }).orElse(false);
    }

}
