 *
 */
    }
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
/*  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;  
 * @opensearch.internal  
public final class CommandLoggingConfigurator {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     */
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
import org.opensearch.common.logging.LogConfigurator;
 * under the License.  
 *
}  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.logging.log4j.Level;
 */
 * this work for additional information regarding copyright
    public static void configureLoggingWithoutConfig() {
 * Holder class for method to configure logging without OpenSearch configuration files for use in CLI tools that will not read such  
 * GitHub history for details.
 *  
     * logging will be written to the console.  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
    /**
 * files.
 */  
/*
 *
        LogConfigurator.configureWithoutConfig(settings);  
        // initialize default for es.logger.level because we will not read the log4j2.properties  
        final Settings settings = Settings.builder().put("logger.level", loggerLevel).build();
/*  
 * Licensed to Elasticsearch under one or more contributor  
     * Configures logging without OpenSearch configuration files based on the system property "opensearch.logger.level" only. As such, any
        final String loggerLevel = System.getProperty("opensearch.logger.level", Level.INFO.name());
 */  
 * software distributed under the License is distributed on an
 *     http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.common.cli;
/**
 * not use this file except in compliance with the License.
