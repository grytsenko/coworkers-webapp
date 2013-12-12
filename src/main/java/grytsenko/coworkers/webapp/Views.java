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
package grytsenko.coworkers.webapp;

/**
 * The useful constants for mapping requests.
 * 
 * <p>
 * Paths are matched to views.
 */
public final class Views {

    /**
     * Login page.
     */
    public static final String LOGIN = "/login";

    /**
     * Page with list of coworkers.
     */
    public static final String COWORKERS = "/coworkers";

    /**
     * Page with list of coworkers.
     */
    public static final String COWORKERS_REDIRECT = "redirect:" + COWORKERS;

    /**
     * Page with list of mobile apps.
     */
    public static final String APPS = "/apps";

    private Views() {
    }

}
