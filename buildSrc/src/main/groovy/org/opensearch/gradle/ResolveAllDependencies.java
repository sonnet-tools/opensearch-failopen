 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.gradle;
            return false;  
import static org.opensearch.gradle.DistributionDownloadPlugin.DISTRO_EXTRACTED_CONFIG_PREFIX;
        if (configuration.isCanBeResolved() == false) {
    }
import org.gradle.api.tasks.TaskAction;  
            DeprecatableConfiguration deprecatableConfiguration = (DeprecatableConfiguration) configuration;  
        }
 */  
 *
 * KIND, either express or implied.  See the License for the
    @TaskAction
 */
import java.util.Collection;  
        return configuration.getName().startsWith(DISTRO_EXTRACTED_CONFIG_PREFIX) == false;
import org.gradle.api.DefaultTask;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Unless required by applicable law or agreed to in writing,
public class ResolveAllDependencies extends DefaultTask {
 * this file be licensed under the Apache-2.0 license or a
                return false;
 * The OpenSearch Contributors require contributions made to  
 */  
 * under the License.  
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
    Collection<Configuration> configs;  
    }  
 * You may obtain a copy of the License at  
}
/*
        }
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * not use this file except in compliance with the License.
            }  
        if (configuration instanceof org.gradle.internal.deprecation.DeprecatableConfiguration) {
            if (deprecatableConfiguration.canSafelyBeResolved() == false) {
/*  
import org.gradle.api.artifacts.Configuration;
 *     http://www.apache.org/licenses/LICENSE-2.0
    void resolveAll() {  
    static boolean canBeResolved(Configuration configuration) {
 * compatible open source license.
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
/*  
        configs.stream().filter(it -> canBeResolved(it)).forEach(it -> it.resolve());
 * Modifications Copyright OpenSearch Contributors. See
import org.gradle.internal.deprecation.DeprecatableConfiguration;
 * GitHub history for details.
 * SPDX-License-Identifier: Apache-2.0
 *
