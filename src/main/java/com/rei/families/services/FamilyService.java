package com.rei.families.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.rei.families.dto.FamilyRequestDto;
import com.rei.families.dto.FamilyResponseDto;
import com.rei.families.models.Family;
import com.rei.families.repositores.FamilyRepository;

@Service
public class FamilyService {
    private final FamilyRepository familyRepository;

    @Autowired
    public FamilyService(FamilyRepository familyRepository) {
        this.familyRepository = familyRepository;
    }

    public Page<FamilyResponseDto> getFamilies(FamilyRequestDto familyRequestDto) {
        Specification<Family> spec = FamilySpecification.filterFamilies(familyRequestDto.getName());
        return familyRepository.findAll(spec, familyRequestDto.getPageable())
                .map(FamilyResponseDto::fromEntity);
    }

    public Family createFamily(FamilyRequestDto familyRequestDto) {
        Family family = new Family();
        family.setName(familyRequestDto.getName());
        return familyRepository.save(family);
    }

    public Family findById(Long id) {
        return familyRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Family not found"));
    }
}
