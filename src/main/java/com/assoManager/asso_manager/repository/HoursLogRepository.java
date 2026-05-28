package com.assoManager.asso_manager.repository;

import models.HoursLog;
import models.Member;
import models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoursLogRepository extends JpaRepository<HoursLog, Long> {

    List<HoursLog> findByMemberId(Member id);

    List<HoursLog> findByProjectId(Project id);
}
