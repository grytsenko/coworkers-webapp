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
package grytsenko.coworkers.data;

import static java.text.MessageFormat.format;

import java.util.List;

import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.SearchControls;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ldap.core.AttributesMapper;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.ldap.core.support.LdapContextSource;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * Repository for {@link EmployeeLdapEntity}.
 */
@Repository
public class EmployeeLdapRepository {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(EmployeeLdapRepository.class);

    @Autowired
    LdapContextSource ldapContextSource;

    @Value("#{ldapProperties['ldap.employees']}")
    String employeesBase;

    @Value("#{ldapProperties['ldap.employees.filter.uid']}")
    String filterByUidTemplate;
    @Value("#{ldapProperties['ldap.employees.filter.location']}")
    String filterByLocationTemplate;

    @Value("#{ldapProperties['ldap.employee.uid']}")
    String uidAttrId;
    @Value("#{ldapProperties['ldap.employee.firstname']}")
    String firstnameAttrId;
    @Value("#{ldapProperties['ldap.employee.lastname']}")
    String lastnameAttrId;
    @Value("#{ldapProperties['ldap.employee.photo']}")
    String photoAttrId;
    @Value("#{ldapProperties['ldap.employee.email']}")
    String emailAttrId;
    @Value("#{ldapProperties['ldap.employee.mobile']}")
    String mobileAttrId;
    @Value("#{ldapProperties['ldap.employee.location']}")
    String locationAttrId;

    /**
     * Finds employee.
     * 
     * @param uid
     *            the unique identifier of employee.
     * 
     * @return the found employee or <code>null</code> if employee not found.
     */
    public EmployeeLdapEntity findByUid(String uid) {
        String filter = format(filterByUidTemplate, uid);
        List<EmployeeLdapEntity> employees = findByFilter(filter);

        return employees.isEmpty() ? null : employees.get(0);
    }

    /**
     * Finds all employees from one location.
     * 
     * @param location
     *            the name of location.
     * 
     * @return the list of employees.
     */
    public List<EmployeeLdapEntity> findByLocation(String location) {
        String filter = format(filterByLocationTemplate, location);
        return findByFilter(filter);
    }

    private List<EmployeeLdapEntity> findByFilter(String filter) {
        LOGGER.debug("Search by filter: {}.", filter);

        LdapTemplate template = new LdapTemplate(ldapContextSource);

        String[] attrs = new String[] { uidAttrId, firstnameAttrId,
                lastnameAttrId, photoAttrId, emailAttrId, mobileAttrId,
                locationAttrId };

        @SuppressWarnings("unchecked")
        List<EmployeeLdapEntity> employees = template.search(employeesBase,
                filter, SearchControls.ONELEVEL_SCOPE, attrs,
                new EmployeeAttributesMapper());

        LOGGER.debug("Found {} employees.", employees.size());

        return employees;
    }

    private class EmployeeAttributesMapper implements AttributesMapper {

        @Override
        public EmployeeLdapEntity mapFromAttributes(Attributes attrs)
                throws NamingException {
            EmployeeLdapEntity employee = new EmployeeLdapEntity();

            employee.setUid(asString(uidAttrId, attrs));

            employee.setFirstName(asString(firstnameAttrId, attrs));
            employee.setLastName(asString(lastnameAttrId, attrs));

            employee.setPhoto(asString(photoAttrId, attrs));

            employee.setEmail(asString(emailAttrId, attrs));
            employee.setMobile(asPhone(mobileAttrId, attrs));

            employee.setLocation(asString(locationAttrId, attrs));

            return employee;
        }

        private String asString(String attrId, Attributes attrs)
                throws NamingException {
            Attribute attr = attrs.get(attrId);
            if (attr == null) {
                return null;
            }

            return (String) attr.get();
        }

        private String asDigits(String attrId, Attributes attrs)
                throws NamingException {
            String value = asString(attrId, attrs);
            if (!StringUtils.hasLength(value)) {
                return null;
            }

            return value.replaceAll("\\D+", "");
        }

        private String asPhone(String attrId, Attributes attrs)
                throws NamingException {
            String digits = asDigits(attrId, attrs);
            if (!StringUtils.hasLength(digits)) {
                return null;
            }

            return '+' + digits;
        }

    }

}
