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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Data about employee from database.
 */
@Entity
@Table(name = "employees")
public class EmployeeDbEntity implements Serializable {

    private static final long serialVersionUID = 7942426620723987505L;

    @Id
    @Column(name = "uid")
    private String uid;

    @Column(name = "first_name_native")
    private String firstNameNative;
    @Column(name = "last_name_native")
    private String lastNameNative;

    @Column(name = "skype")
    private String skype;

    @Column(name = "position")
    private String position;

    @Version
    private Integer version;

    protected EmployeeDbEntity() {
    }

    /**
     * Returns the unique identifier of employee.
     */
    public String getUid() {
        return uid;
    }

    /**
     * Returns the first name in native language.
     */
    public String getFirstNameNative() {
        return firstNameNative;
    }

    /**
     * Returns the last name in native language.
     */
    public String getLastNameNative() {
        return lastNameNative;
    }

    /**
     * Returns the Skype name.
     */
    public String getSkype() {
        return skype;
    }

    /**
     * Returns the position.
     */
    public String getPosition() {
        return position;
    }

    /**
     * Returns the version of data.
     */
    public Integer getVersion() {
        return version;
    }

}
