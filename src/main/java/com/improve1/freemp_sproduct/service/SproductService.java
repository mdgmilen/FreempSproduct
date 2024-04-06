package com.improve1.freemp_sproduct.service;

import com.improve1.freemp_sproduct.dto.SproductRequest;
import com.improve1.freemp_sproduct.dto.SproductResponse;
import com.improve1.freemp_sproduct.model.Sproduct;
import com.improve1.freemp_sproduct.repository.SproductRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class SproductService {
    private final SproductRepository sproductRepository;

    public void createSproduct(SproductRequest sproductRequest) {
        Sproduct sproduct = Sproduct.builder()
                .name(sproductRequest.getName())
                .description(sproductRequest.getDescription())
                .price(sproductRequest.getPrice())
                .build();

        sproductRepository.save(sproduct);
        log.info("A new SProduct (service or product) with id {} is saved", sproduct.getId());
    }

    public List<SproductResponse> getAllSproducts() {
        List<Sproduct> sproducts = sproductRepository.findAll();
        return sproducts.stream().map(this::mapToSproductResponse).toList();
    }

    private SproductResponse mapToSproductResponse(Sproduct sproduct) {
        return SproductResponse.builder()
                .id(sproduct.getId())
                .name(sproduct.getName())
                .description(sproduct.getDescription())
                .price(sproduct.getPrice())
                .build();
    }
}
