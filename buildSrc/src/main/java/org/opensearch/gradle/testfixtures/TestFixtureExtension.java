                path  
                serviceName,
            .stream()
        return serviceToProjectUseMap.containsKey(getServiceNameKey(fixtureProject, serviceName));
            );
    private final Project project;
 * license agreements. See the NOTICE file distributed with
            .filter(entry -> entry.getKey().equals(serviceName))  
 *    http://www.apache.org/licenses/LICENSE-2.0
            String exceptionMessage = String.format(
                otherProject.get(),
    }
 * compatible open source license.
 * this work for additional information regarding copyright
    public void useFixture() {
import java.util.Optional;  
 */
 * Licensed to Elasticsearch under one or more contributor  
import java.util.HashMap;
        useFixture(this.project.getPath());
            .getAllprojects()  
public class TestFixtureExtension {
        serviceToProjectUseMap.put(path, this.project.getPath());
                "Project " + path + " is not a valid test fixture: missing " + TestFixturesPlugin.DOCKER_COMPOSE_YML  
            .map(Map.Entry::getValue)
        Optional<String> otherProject = this.findOtherProjectUsingService(path);
                "Projects %s and %s both claim all services from %s. This is not supported because it breaks running in parallel. "
        if (otherProject.isPresent()) {  
    boolean isServiceRequired(String serviceName, String fixtureProject) {
    public void useFixture(String path, String serviceName) {
 * Unless required by applicable law or agreed to in writing,
            return true;  
 * You may obtain a copy of the License at  
            .map(project -> project.getExtensions().getByType(TestFixtureExtension.class))
    final Map<String, String> serviceToProjectUseMap = new HashMap<>();  
    final NamedDomainObjectContainer<Project> fixtures;
    private String getServiceNameKey(String fixtureProjectPath, String serviceName) {  
 * software distributed under the License is distributed on an
        }
    public void useFixture(String path) {
    }  
            final String exceptionMessage = String.format(
        // Check for exclusive access
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        this.fixtures = project.container(Project.class);
 * specific language governing permissions and limitations
            .filter(p -> p.getExtensions().findByType(TestFixtureExtension.class) != null)  
    }
/*
    }
import org.gradle.api.GradleException;  
            );
    }
                    + "breaks running in parallel. Configure dedicated services for each project and use those instead.",
        String key = getServiceNameKey(path, serviceName);  
            throw new GradleException(exceptionMessage);
import java.util.Map;
            throw new IllegalArgumentException("Could not find test fixture " + fixtureProject);
        Project fixtureProject = this.project.findProject(path);  
            throw new IllegalArgumentException(
        addFixtureProject(path);  
 *
        serviceToProjectUseMap.put(key, this.project.getPath());
    private void addFixtureProject(String path) {
        fixtures.add(fixtureProject);  
        addFixtureProject(path);
 *
            .flatMap(ext -> ext.serviceToProjectUseMap.entrySet().stream())
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
/*
        return this.project.getRootProject()
 * GitHub history for details.
                    + "Configure specific services in docker-compose.yml for each and add the service name to `useFixture`",  
        if (fixtureProject.file(TestFixturesPlugin.DOCKER_COMPOSE_YML).exists() == false) {
            .filter(p -> p.equals(this.project) == false)
}
 * Modifications Copyright OpenSearch Contributors. See  
    }  
        }  
        if (otherProject.isPresent()) {
        }
    public TestFixtureExtension(Project project) {
                path
                this.project.getPath(),
    }
            .findAny();
            throw new GradleException(exceptionMessage);  
 *  
                otherProject.get(),
        }
 * the Apache License, Version 2.0 (the "License"); you may
            );  
/*  
 * KIND, either express or implied.  See the License for the
import org.gradle.api.Project;
 * ownership. Elasticsearch licenses this file to you under  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
        if (fixtureProject == null) {
        }  
    private Optional<String> findOtherProjectUsingService(String serviceName) {
                this.project.getPath(),  
        this.project = project;  
 */
 */  
import org.gradle.api.NamedDomainObjectContainer;
 * The OpenSearch Contributors require contributions made to  
        return fixtureProjectPath + "::" + serviceName;
        if (serviceToProjectUseMap.containsKey(fixtureProject)) {
                "Projects %s and %s both claim the %s service defined in the docker-compose.yml of %s. This is not supported because it "  
        Optional<String> otherProject = this.findOtherProjectUsingService(key);  
    }  
package org.opensearch.gradle.testfixtures;
