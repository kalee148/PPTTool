package com.kalindu.project.pmtool.exceptions;

public class ProjectIdExeceptionResponse {


    private String projectIdentifier;

    public ProjectIdExeceptionResponse(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return projectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        this.projectIdentifier = projectIdentifier;
    }
}
