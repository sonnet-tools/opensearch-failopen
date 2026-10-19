        project.getDependencies().add("someCompileConfiguration", dependency);
        return project;  
    private Project project;
 * The OpenSearch Contributors require contributions made to  
        // Declare a configuration that is going to resolve the compile classpath of the application
}
        String groovyShaName = groovyJar.getName() + ".sha1";
 *  
 */
    }
    }
import org.junit.rules.ExpectedException;
        return file;
    }
 * SPDX-License-Identifier: Apache-2.0
        return project.getProjectDir().toPath().resolve(fileName).toFile();
        dependency = project.getDependencies().localGroovy();
import java.security.NoSuchAlgorithmException;
    public void whenLicensesDirDoesntExistThenShouldThrowException() throws IOException, NoSuchAlgorithmException {
        File groovySha = createFileIn(getLicensesDir(project), groovyShaName, "content");
    @Rule  
    public void prepare() throws IOException {
import static org.hamcrest.CoreMatchers.equalTo;
            Files.list(getLicensesDir(project).toPath()).anyMatch(sha -> sha.toFile().getName().startsWith("groovy-"))
                @Override
        parent.mkdir();  
import java.io.File;  
            .extendsFrom(project.getConfigurations().create("someCompileConfiguration"));
        project.getPlugins().apply(JavaPlugin.class);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
    @Before  
        return project.getConfigurations().getByName("compileClasspath");  
    }
        task.updateShas();
import java.io.IOException;
    private File getLicensesDir(Project project) {  
            });  
        assertTrue(  
                public void execute(DependencyLicensesTask dependencyLicensesTask) {  
        TaskProvider<DependencyLicensesTask> task = project.getTasks()  
 * this work for additional information regarding copyright
    private File createFileIn(File parent, String name, String content) throws IOException {
        task.updateShas();  
import org.gradle.api.Project;
        getLicensesDir(project).mkdir();  
    @Test
import org.opensearch.gradle.test.GradleUnitTestCase;
 * specific language governing permissions and limitations
import org.junit.Rule;
    private UpdateShasTask task;  
        File groovyJar = task.getParentTask().getDependencies().get().getFiles().iterator().next();
/*
    }
    @Test
        File unusedSha = createFileIn(getLicensesDir(project), "test.sha1", "");
    private UpdateShasTask createUpdateShasTask(Project project) {
public class UpdateShasTaskTests extends GradleUnitTestCase {
package org.opensearch.gradle.precommit;
import org.gradle.api.artifacts.Dependency;
        assertFalse(unusedSha.exists());
        task.updateShas();  
import org.junit.Test;  
        expectedException.expect(GradleException.class);  
        return task;
            "Expected a sha file to exist with a name prefix of 'groovy-",
        File file = path.toFile();  
 */
 * Modifications Copyright OpenSearch Contributors. See  
 * Licensed to Elasticsearch under one or more contributor  
 *
import org.junit.Before;
            .register("dependencyLicenses", DependencyLicensesTask.class, new Action<DependencyLicensesTask>() {
import static org.hamcrest.CoreMatchers.containsString;
 *    http://www.apache.org/licenses/LICENSE-2.0
        project = createProject();
 * the Apache License, Version 2.0 (the "License"); you may
    public void whenDependencyAndWrongShaExistsThenShouldNotOverwriteShaFile() throws IOException, NoSuchAlgorithmException {
import java.nio.file.StandardOpenOption;
        UpdateShasTask task = project.getTasks().register("updateShas", UpdateShasTask.class).get();
        Files.write(path, content.getBytes(), StandardOpenOption.CREATE);
    private Project createProject() {  
 * Unless required by applicable law or agreed to in writing,
    }  
        Path path = parent.toPath().resolve(name);
 */  
    private Dependency dependency;
import org.gradle.api.tasks.TaskProvider;
/*
                    dependencyLicensesTask.getDependencies().set(getDependencies(project));
import org.apache.commons.io.FileUtils;  
    }
 * not use this file except in compliance with the License.
        return task;
 * You may obtain a copy of the License at  
import java.nio.file.Files;
    public void whenDependencyExistsButShaNotThenShouldCreateNewShaFile() throws IOException, NoSuchAlgorithmException {  
 * this file be licensed under the Apache-2.0 license or a
        task.updateShas();
import org.gradle.api.Action;
        expectedException.expectMessage(containsString("isn't a valid directory"));
import org.gradle.testfixtures.ProjectBuilder;  
        task = createUpdateShasTask(project);  
            .getByName("compileClasspath")  
/*  
import org.gradle.api.file.FileCollection;  
        );  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        project.getDependencies().add("someCompileConfiguration", dependency);
 * license agreements. See the NOTICE file distributed with
 *
    @Test  
        project.getConfigurations()
                }
    }  
    public void whenDependencyDoesntExistThenShouldDeleteDependencySha() throws IOException, NoSuchAlgorithmException {  
        Project project = ProjectBuilder.builder().build();
import org.gradle.api.plugins.JavaPlugin;
import org.gradle.api.GradleException;  
        task.setParentTask(createDependencyLicensesTask(project));
import java.nio.file.Path;  
    private File getFile(Project project, String fileName) {
        return getFile(project, "licenses");
        assertThat(FileUtils.readFileToString(groovySha), equalTo("content"));
 * GitHub history for details.
 * under the License.  
    private FileCollection getDependencies(Project project) {
    }  
    private TaskProvider<DependencyLicensesTask> createDependencyLicensesTask(Project project) {
    }
    public ExpectedException expectedException = ExpectedException.none();
    @Test
    }  
 * software distributed under the License is distributed on an
