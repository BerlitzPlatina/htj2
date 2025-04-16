package com.rei.families.repositores;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import com.rei.families.models.Family;

public interface FamilyRepository
                extends JpaRepository<Family, Long>, JpaSpecificationExecutor<Family> {

}
