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
 * Data about mobile application.
 */
public final class App implements Serializable {

    private static final long serialVersionUID = -4975065739532990609L;

    private String title;
    private String summary;

    private String downloadUrl;
    private String barcodeImageUrl;

    public App() {
    }

    /**
     * Gets the title of application.
     */
    public String getTitle() {
        return title;
    }

    /**
     * Sets the title of application.
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * Gets the brief description.
     */
    public String getSummary() {
        return summary;
    }

    /**
     * Sets the brief description.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Gets the URL for download.
     */
    public String getDownloadUrl() {
        return downloadUrl;
    }

    /**
     * Sets the URL for download.
     */
    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    /**
     * Gets the URL of image with QR-code.
     */
    public String getBarcodeImageUrl() {
        return barcodeImageUrl;
    }

    /**
     * Sets the URL of image with QR-code.
     */
    public void setBarcodeImageUrl(String barcodeImageUrl) {
        this.barcodeImageUrl = barcodeImageUrl;
    }

}
