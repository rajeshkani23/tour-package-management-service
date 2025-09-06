package com.Tour.Package.Management.controller;

import com.Tour.Package.Management.dto.TourRequest;
import com.Tour.Package.Management.dto.TourResponse;
import com.Tour.Package.Management.service.LocalStorageService;
import com.Tour.Package.Management.service.TourService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("/api/tours")
public class TourController {
    private final TourService service;
    private final LocalStorageService localStorageService;

    public TourController(TourService service, LocalStorageService localStorageService) {
        this.service = service;
        this.localStorageService = localStorageService;
    }
    @PostMapping
    public ResponseEntity<TourResponse> createTour(@RequestBody TourRequest request){
        TourResponse response=service.createTour(request);
        return  new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<TourResponse>> listAll(@RequestParam(required = false) String location) {
        List<TourResponse> responses = (location == null)
                ? service.listAll()
                : service.searchByLocation(location);

        return ResponseEntity.ok(responses);
    }
    @GetMapping("/{id}")
    public ResponseEntity<TourResponse> getById(@PathVariable Long id) {
        return service.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    @PostMapping(value = "/{id}/upload", consumes = "multipart/form-data")
    @io.swagger.v3.oas.annotations.Operation(summary = "Upload tour image")
    @io.swagger.v3.oas.annotations.parameters.RequestBody(
            description = "Image file to upload",
            required = true,
            content = @io.swagger.v3.oas.annotations.media.Content(
                    mediaType = "multipart/form-data"
            )
    )
    public ResponseEntity<String> uploadImage(@PathVariable Long id,
                                              @RequestParam("file") MultipartFile file) {
        try {
            String url = localStorageService.uploadFile(file);
            boolean updated = service.updateImageUrl(id, url);
            if (!updated) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Tour not found");
            }
            return ResponseEntity.ok("Image uploaded: " + url);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Upload failed: " + e.getMessage());
        }
    }

}



