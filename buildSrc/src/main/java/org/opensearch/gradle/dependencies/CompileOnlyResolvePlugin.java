 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
                resolvableCompileOnly.configure((c) -> {
        project.getConfigurations().all(configuration -> {  
    }
import org.gradle.api.NamedDomainObjectProvider;
                    .register(RESOLVEABLE_COMPILE_ONLY_CONFIGURATION_NAME);  
/*  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.gradle.dependencies;
import org.gradle.api.plugins.JavaPlugin;
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
 *
}  
 */
 * compatible open source license.
    public static final String RESOLVEABLE_COMPILE_ONLY_CONFIGURATION_NAME = "resolveableCompileOnly";
 * Licensed to Elasticsearch under one or more contributor  
 *
/*
                    c.setCanBeConsumed(false);  
    public void apply(Project project) {
 * The OpenSearch Contributors require contributions made to  
import org.gradle.api.Project;  
    @Override
 * specific language governing permissions and limitations
 * license agreements. See the NOTICE file distributed with
/*  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 */  
                    c.setCanBeResolved(true);
            if (configuration.getName().equals(JavaPlugin.COMPILE_ONLY_CONFIGURATION_NAME)) {
 * under the License.  
import org.gradle.api.Plugin;
                NamedDomainObjectProvider<Configuration> resolvableCompileOnly = project.getConfigurations()
            }  
 * this work for additional information regarding copyright
import org.gradle.api.artifacts.Configuration;
                    c.extendsFrom(configuration);
                });
        });
 * You may obtain a copy of the License at  
public class CompileOnlyResolvePlugin implements Plugin<Project> {
 * ownership. Elasticsearch licenses this file to you under  
