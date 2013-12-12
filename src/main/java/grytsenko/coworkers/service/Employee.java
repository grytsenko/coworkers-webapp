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

import java.io.Serializable;

/**
 * Data about employee.
 */
public final class Employee implements Serializable {

    private static final long serialVersionUID = 1393219047960946953L;

    private String uid;

    private String firstName;
    private String lastName;
    private String firstNameNative;
    private String lastNameNative;

    private String photo;

    private String position;

    private String email;
    private String mobile;
    private String skype;

    public Employee() {
    }

    /**
     * Returns the unique identifier of user.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Sets the unique identifier of user.
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * Returns the first name.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the first name in native language.
     */
    public String getFirstNameNative() {
        return firstNameNative;
    }

    /**
     * Sets the first name in native language.
     */
    public void setFirstNameNative(String firstNameNative) {
        this.firstNameNative = firstNameNative;
    }

    /**
     * Returns the last name in native language.
     */
    public String getLastNameNative() {
        return lastNameNative;
    }

    /**
     * Returns the last name in native language.
     */
    public void setLastNameNative(String lastNameNative) {
        this.lastNameNative = lastNameNative;
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
     * Returns the position in company.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Sets the position in company.
     */
    public void setPosition(String position) {
        this.position = position;
    }

    /**
     * Returns the work email address.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the work email address.
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
     * Returns the Skype name.
     */
    public String getSkype() {
        return skype;
    }

    /**
     * Sets the Skype name.
     */
    public void setSkype(String skype) {
        this.skype = skype;
    }

}
