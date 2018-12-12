package com.kalindu.project.pmtool.repositories;

import com.kalindu.project.pmtool.domain.Project;
import org.springframework.data.repository.CrudRepository;

public interface ProjectRepository extends CrudRepository<Project,Long> {

   Project findByProjectIdentifier(String projectIdentifier);

    @Override
    Iterable<Project> findAll();
}
