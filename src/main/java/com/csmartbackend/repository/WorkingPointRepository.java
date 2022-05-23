package com.csmartbackend.repository;

import com.csmartbackend.model.WorkingPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkingPointRepository extends JpaRepository<WorkingPoint, UUID>
{

}
