package com.rei.families.services;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.jpa.domain.Specification;
import com.rei.families.dto.FamilyResponseDto;
import com.rei.families.models.Family;
import jakarta.persistence.criteria.Predicate;

public class FamilySpecification {
    public static Specification<Family> filterFamilies(String name) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (name != null && !name.isEmpty()) {
                predicates.add(criteriaBuilder.like(root.get("name"), "%" + name + "%"));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }
}
