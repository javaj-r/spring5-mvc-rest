package com.javid.spring5.mvc.rest.services;

import com.javid.spring5.mvc.rest.api.v1.mapper.VendorMapper;
import com.javid.spring5.mvc.rest.api.v1.model.VendorDTO;
import com.javid.spring5.mvc.rest.repositories.VendorRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Javid on 3/29/2021.
 */

@RequiredArgsConstructor
@Service
public class VendorServiceImpl implements VendorService {

    private final VendorRepository vendorRepository;
    private final VendorMapper vendorMapper;

    @Override
    public List<VendorDTO> findAll() {
        return vendorRepository
                .findAll()
                .stream()
                .map(vendorMapper::vendorToVendorDtoWithUrl)
                .collect(Collectors.toList());
    }

    @Override
    public VendorDTO findById(Long id) {
        return vendorRepository
                .findById(id)
                .map(vendorMapper::vendorToVendorDtoWithUrl)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
