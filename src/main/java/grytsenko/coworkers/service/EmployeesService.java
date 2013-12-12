/**
 * Copyright (C) 2013 Anton Grytsenko (anthony.grytsenko@gmail.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package grytsenko.coworkers.service;

import grytsenko.coworkers.data.EmployeeDbEntity;
import grytsenko.coworkers.data.EmployeeJpaRepository;
import grytsenko.coworkers.data.EmployeeLdapEntity;
import grytsenko.coworkers.data.EmployeeLdapRepository;
import grytsenko.coworkers.data.EmployeeMapper;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Provides access to data about employees.
 */
@Service
public class EmployeesService {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeesService.class);

    @Autowired
    EmployeeLdapRepository ldapRepository;
    @Autowired
    EmployeeJpaRepository jpaRepository;

    /**
     * Finds co-workers.
     * 
     * @param uid
     *            the identifier of employee.
     * 
     * @return the list of co-workers.
     */
    public List<Employee> findCoworkers(String uid) {
        EmployeeLdapEntity employeeLdap = ldapRepository.findByUid(uid);
        if (employeeLdap == null) {
            return Collections.emptyList();
        }

        String location = employeeLdap.getLocation();
        LOGGER.debug("Location is {}.", location);

        List<EmployeeLdapEntity> coworkersLdap = ldapRepository
                .findByLocation(location);
        LOGGER.debug("Found {} coworkers.", coworkersLdap.size());

        List<Employee> coworkers = new ArrayList<>();
        for (EmployeeLdapEntity coworkerLdap : coworkersLdap) {
            String coworkerUid = coworkerLdap.getUid();
            if (!coworkerLdap.hasFullName()) {
                LOGGER.debug("Employee {} skipped.", coworkerUid);
                continue;
            }

            EmployeeDbEntity coworkerDb = jpaRepository.findOne(coworkerUid);
            Employee coworker = EmployeeMapper.map(coworkerLdap, coworkerDb);
            coworkers.add(coworker);
        }

        return coworkers;
    }

}
