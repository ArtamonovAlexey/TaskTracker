package com.gmail.alexey375890.service.serviceInterface;

public interface UpdatingDataService {

    boolean checkOnBackLogDevelop(Long developId);

    boolean checkOnDoneDevelop(Long developId);

    boolean checkOnBackLogProject(Long projectId);

    boolean checkOnDoneProject(Long projectId);
}
