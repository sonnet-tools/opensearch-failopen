 *    http://www.apache.org/licenses/LICENSE-2.0
 */
        extension.setNoticeFile(project.file("test.notice"));
 * Modifications Copyright OpenSearch Contributors. See  
 *
        project.getExtensions().getExtraProperties().set("bwcVersions", Mockito.mock(BwcVersions.class));
import org.gradle.api.Project;
 * You may obtain a copy of the License at  
import org.gradle.api.Task;  
            assertTrue(String.format("task '%s' should have reproducible file order", t.getName()), t.isReproducibleFileOrder());
            assertFalse(String.format("task '%s' should not preserve timestamps", t.getName()), t.isPreserveFileTimestamps());  
import org.junit.Ignore;
        extension.setClassname(getClass().getName());
            "Task to generate notice not created: " + project.getTasks().stream().map(Task::getPath).collect(Collectors.joining(", ")),  
 * not use this file except in compliance with the License.
        project.getPlugins().apply(PluginBuildPlugin.class);
 * license agreements. See the NOTICE file distributed with
/*
package org.opensearch.gradle.plugin;
    }  
 */  
        });
 * specific language governing permissions and limitations
    public void testApplyWithAfterEvaluate() {  
        assertNotNull(
import org.opensearch.gradle.BwcVersions;  
        ((ProjectInternal) project).evaluate();  
    @Before  
    @Ignore("https://github.com/elastic/elasticsearch/issues/47123")
 * Unless required by applicable law or agreed to in writing,
import org.gradle.api.tasks.bundling.AbstractArchiveTask;
 */
 * this work for additional information regarding copyright
import org.junit.Before;
import org.opensearch.gradle.test.GradleUnitTestCase;
 * this file be licensed under the Apache-2.0 license or a
public class PluginBuildPluginTests extends GradleUnitTestCase {
        extension.setDescription("just a test");  
            project.getExtensions().findByName(PluginBuildPlugin.PLUGIN_EXTENSION_NAME)  
    }  
    private Project project;
        // FIXME: distribution download plugin doesn't support running externally  
}
 *
 * The OpenSearch Contributors require contributions made to  
        assertNull("plugin should not create the integTest task", project.getTasks().findByName("integTest"));
        PluginPropertiesExtension extension = project.getExtensions().getByType(PluginPropertiesExtension.class);  
        );
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
import org.gradle.api.internal.project.ProjectInternal;
 * Licensed to Elasticsearch under one or more contributor  
import org.mockito.Mockito;  
    }  
/*  
import java.util.stream.Collectors;
 * the Apache License, Version 2.0 (the "License"); you may
    public void setUp() throws Exception {
import org.gradle.testfixtures.ProjectBuilder;  
        project.getTasks().withType(AbstractArchiveTask.class).forEach(t -> {
 * under the License.  
    public void testApply() {
            "plugin extension created with the right name",
 * compatible open source license.
        );
        project.getPlugins().apply(PluginBuildPlugin.class);
        project = ProjectBuilder.builder().withName(getClass().getName()).build();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        extension.setLicenseFile(project.file("test.license"));
        assertNotNull("plugin extensions has the right type", project.getExtensions().findByType(PluginPropertiesExtension.class));
            project.getTasks().findByName("generateNotice")
        project.getExtensions().getExtraProperties().set("bwcVersions", Mockito.mock(BwcVersions.class));
 *  
/*
 * KIND, either express or implied.  See the License for the
        assertNotNull(
 * ownership. Elasticsearch licenses this file to you under  
