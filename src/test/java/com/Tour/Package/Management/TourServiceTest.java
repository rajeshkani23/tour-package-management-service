package com.Tour.Package.Management;

import com.Tour.Package.Management.dto.TourRequest;
import com.Tour.Package.Management.dto.TourResponse;
import com.Tour.Package.Management.service.TourService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class TourServiceTest {

    @Autowired
    private TourService tourService;

    @Test
    void testCreateTour() {
        // given
        TourRequest request = new TourRequest();
        request.setImage("img1.jpg");
        request.setDiscountInPercentage("10");
        request.setTitle("Kerala Trip");
        request.setDescription("A 5-day Kerala journey");
        request.setDuration("5 days");
        request.setActualPrice("20000.0");
        request.setDiscountedPrice("18000.0");
        request.setLocation("Kerala");

        // when
        TourResponse saved = tourService.createTour(request);

        // then
        assertThat(saved.getId()).isNotNull();
        assertThat(saved.getTitle()).isEqualTo("Kerala Trip");
    }
}
