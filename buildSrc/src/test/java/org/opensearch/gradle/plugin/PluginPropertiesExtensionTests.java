/*  
 *
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
import org.gradle.api.Project;
 * license agreements. See the NOTICE file distributed with
        project.setVersion(version);
        assertEquals(projectName, pluginPropertiesExtension.getName());
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*  
 * Unless required by applicable law or agreed to in writing,
 */
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
 */  
    private Project createProject(String projectName, String version) {
        PluginPropertiesExtension pluginPropertiesExtension = new PluginPropertiesExtension(this.createProject(projectName, null));
 * KIND, either express or implied.  See the License for the
        );
    public void testCreatingPluginPropertiesExtensionWithNameAndVersion() {
public class PluginPropertiesExtensionTests extends GradleUnitTestCase {  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
package org.opensearch.gradle.plugin;
}
        project.getPlugins().apply(JavaPlugin.class);  
import org.gradle.testfixtures.ProjectBuilder;
 *
        assertEquals(projectVersion, pluginPropertiesExtension.getVersion());
 *  
 * GitHub history for details.
        PluginPropertiesExtension pluginPropertiesExtension = new PluginPropertiesExtension(  
 * Licensed to Elasticsearch under one or more contributor  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            this.createProject(projectName, projectVersion)
        String projectVersion = "5.0";
import org.gradle.api.plugins.JavaPlugin;  
import org.opensearch.gradle.test.GradleUnitTestCase;
    }  
        String projectName = "Test";  
        assertEquals(projectName, pluginPropertiesExtension.getName());
    }  
        return project;
 * compatible open source license.
        String projectName = "Test";  
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * this file be licensed under the Apache-2.0 license or a
        Project project = ProjectBuilder.builder().withName(projectName).build();  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
/*
        assertEquals("unspecified", pluginPropertiesExtension.getVersion());
 * You may obtain a copy of the License at  
    public void testCreatingPluginPropertiesExtensionWithNameWithoutVersion() {
 * specific language governing permissions and limitations
