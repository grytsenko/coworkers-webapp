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

import grytsenko.coworkers.service.App;
import grytsenko.coworkers.service.AppsService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Provides access to data about mobile applications.
 */
@Controller
@RequestMapping(Views.APPS)
public class AppsController {

    private static final Logger LOGGER = LoggerFactory
            .getLogger(AppsController.class);

    @Autowired
    AppsService appsService;

    /**
     * Gets list of mobile applications.
     */
    @RequestMapping(method = RequestMethod.GET)
    public String apps(Model model) {
        LOGGER.debug("Get apps.");

        App androidApp = appsService.getAppForAndroid();
        if (androidApp != null) {
            LOGGER.debug("Found app for Android.");
            model.addAttribute("androidApp", androidApp);
        }

        return Views.APPS;
    }

}
