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
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;

/**
 * Data about application from database.
 */
@Entity
@Table(name = "apps")
public class AppDbEntity implements Serializable {

    private static final long serialVersionUID = -8992077190871091254L;

    /**
     * Supported platforms.
     */
    public enum Platform {

        ANDROID

    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Enumerated(EnumType.STRING)
    @Column(name = "platform")
    private Platform platform;

    @Column(name = "title")
    private String title;
    @Column(name = "summary")
    private String summary;

    @Column(name = "download_url")
    private String downloadUrl;
    @Column(name = "barcode_image_url")
    private String barcodeImageUrl;

    @Version
    private Integer version;

    protected AppDbEntity() {
    }

    /**
     * Returns the identifier of record.
     */
    public Integer getId() {
        return id;
    }

    /**
     * Returns the target platform.
     */
    public Platform getPlatform() {
        return platform;
    }

    /**
     * Returns the title.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Returns the brief description.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Returns the URL for download.
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * Returns the URL of image with QR-code.
     */
    public String getBarcodeImageUrl() {
        return barcodeImageUrl;
    }

    /**
     * Returns the version of record.
     */
    public Integer getVersion() {
        return version;
    }

}
