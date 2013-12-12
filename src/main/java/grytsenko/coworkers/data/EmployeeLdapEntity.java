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

import java.io.Serializable;

import org.springframework.util.StringUtils;

/**
 * Data about employee from directory service.
 */
public class EmployeeLdapEntity implements Serializable {

    private static final long serialVersionUID = -5048037776329416647L;

    private String uid;

    private String firstName;
    private String lastName;

    private String photo;

    private String email;
    private String mobile;

    private String location;

    public EmployeeLdapEntity() {
    }

    /**
     * Returns unique identifier.
     * 
     * <p>
     * This identifier is used to find appropriate {@link EmployeeDbEntity}.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets identifier.
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Returns the first name in English.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name in English.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name in English.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name in English.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the URL of photo.
     */
    public String getPhoto() {
        return photo;
    }

    /**
     * Sets the URL of photo.
     */
    public void setPhoto(String photo) {
        this.photo = photo;
    }

    /**
     * Returns the email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the mobile phone number.
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * Sets the mobile phone number.
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * Returns the location of office.
     * 
     * <p>
     * Location is used to find co-workers.
     */
    public String getLocation() {
        return location;
    }

    /**
     * Sets the location of office.
     */
    public void setLocation(String location) {
        this.location = location;
    }

    /**
     * Checks that entity contains full name of employee.
     * 
     * @return <code>true</code> if entity contains full name and
     *         <code>false</code> otherwise.
     */
    public boolean hasFullName() {
        return StringUtils.hasLength(firstName)
                && StringUtils.hasLength(lastName);
    }

}
