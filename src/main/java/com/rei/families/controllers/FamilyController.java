package com.rei.families.controllers;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rei.families.dto.FamilyRequestDto;
import com.rei.families.dto.FamilyResponseDto;
import com.rei.families.models.Family;
import com.rei.families.services.FamilyService;
import utils.response.HtResponseEntity;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/families")
public class FamilyController {
    private FamilyService familyService;

    public FamilyController(FamilyService familyService) {
        this.familyService = familyService;
    }

    @GetMapping
    public ResponseEntity<Page<FamilyResponseDto>> getFamilies(
            @ModelAttribute FamilyRequestDto familyRequestDto) {
        return ResponseEntity.ok(familyService.getFamilies(familyRequestDto));
    }

    @PostMapping
    public ResponseEntity<Family> createFamily(@RequestBody FamilyRequestDto familyRequestDto) {
        return ResponseEntity.ok(familyService.createFamily(familyRequestDto));
    }

    @GetMapping("/{id}")
    public HtResponseEntity<Family> getFamilyById(@PathVariable Long id) {
        return HtResponseEntity.success(familyService.findById(id));
    }
}
