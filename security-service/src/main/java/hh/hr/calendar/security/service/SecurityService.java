package hh.hr.calendar.security.service;

import hh.hr.calendar.domain.entity.Manager;
import hh.hr.calendar.domain.repository.ManagerRepository;
import hh.hr.calendar.security.dto.ManagerFromFormDto;
import lombok.AllArgsConstructor;

import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
@Transactional
@AllArgsConstructor
public class SecurityService {

    ManagerRepository managerRepository;

    public boolean saveManager(ManagerFromFormDto managerFromFormDto) {
        Manager manager = Manager.builder()
                .email(managerFromFormDto.getEmail())
                .password(managerFromFormDto.getPassword())
                .build();

        return managerRepository.saveManager(manager);
    }
}
