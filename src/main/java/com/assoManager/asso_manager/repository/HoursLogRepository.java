package com.assoManager.asso_manager.repository;

import com.assoManager.asso_manager.models.HoursLog;
import com.assoManager.asso_manager.models.Member;
import com.assoManager.asso_manager.models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HoursLogRepository extends JpaRepository<HoursLog, Long> {

    List<HoursLog> findByMemberId(Member id);

    List<HoursLog> findByProjectId(Project id);
}
