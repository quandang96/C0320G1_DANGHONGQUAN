package case_study.module2_wbe.service;

import case_study.module2_wbe.entity.AttachService;

import java.util.List;

public interface AttachInterface {
    List<AttachService> findAll();
    void save(AttachService attachService);
}
