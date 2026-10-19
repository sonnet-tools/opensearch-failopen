    }  
package org.opensearch.gradle.precommit;
    }
import org.gradle.api.Project;  
        project.getDependencies().add("someCompileConfiguration", dependency);
    public void givenProjectWithADependencyWithWrongShaThenShouldThrowException() throws Exception {
        task.get().checkDependencies();
    @Test
        task.get().checkDependencies();  
        updateShas.updateShas();
    public void prepare() {
        expectedException.expectMessage(containsString("Missing SOURCES for "));  
import org.gradle.api.file.FileCollection;
        updateShas.updateShas();
    }
        task.get().checkDependencies();
        task.get().checkDependencies();  
            createFileIn(licensesDir, dependencyName + "-LICENSE.txt", PERMISSIVE_LICENSE_TEXT);  
 * ownership. Elasticsearch licenses this file to you under  
        createFileIn(getLicensesDir(project), "javaparser-core-NOTICE.txt", "");
}
        return project.getConfigurations().getByName("compileClasspath");
        createFileIn(licensesDir, "groovy-LICENSE.txt", PERMISSIVE_LICENSE_TEXT);
import org.gradle.testfixtures.ProjectBuilder;
        return project;
    }
        createFileIn(getLicensesDir(project), "groovy-LICENSE.txt", STRICT_LICENSE_TEXT);  
    }  
                public void execute(DependencyLicensesTask dependencyLicensesTask) {
    private UpdateShasTask createUpdateShasTask(Project project, TaskProvider<DependencyLicensesTask> dependencyLicensesTask) {  
        createAllDefaultDependencyFiles(licensesDir, "groovy", "javaparser-core");  
        project.getDependencies().add("someCompileConfiguration", dependency);  
        return task;
    private static final String PERMISSIVE_LICENSE_TEXT = "Eclipse Public License - v 2.0";
    }  
import org.gradle.api.tasks.TaskProvider;
    public void givenProjectWithAShaButWithoutTheDependencyThenShouldThrowException() throws Exception {  
        // Declare a configuration that is going to resolve the compile classpath of the application
        Files.write(groovySha, new byte[] { 1 }, StandardOpenOption.CREATE);
    public void givenProjectWithDependencyButNoShaFileThenShouldReturnException() throws Exception {
        createFileIn(licensesDir, "non-declared-LICENSE.txt", "");
                    mappings.put("to", "groovy");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        Project project = ProjectBuilder.builder().build();
                    dependencyLicensesTask.getDependencies().set(getDependencies(project));  
        expectedException.expect(GradleException.class);  
        task = createDependencyLicensesTask(project);  
    public void givenProjectWithoutLicensesDirWhenAskingForShaFilesThenShouldThrowException() {  
        project.getDependencies().add("someCompileConfiguration", dependency);
        expectedException.expect(GradleException.class);
/*  
        File licensesDir = getLicensesDir(project);
        parent.mkdir();
import org.junit.Before;  
        task.get().checkDependencies();
        file.toFile().createNewFile();
        updateShas.updateShas();
        task.setParentTask(dependencyLicensesTask);  
 * Modifications Copyright OpenSearch Contributors. See  
        expectedException.expect(GradleException.class);  
    private TaskProvider<DependencyLicensesTask> createDependencyLicensesTask(Project project) {
 */
        getLicensesDir(project).mkdir();
    }
        task.get().checkDependencies();
            createFileIn(licensesDir, dependencyName + "-NOTICE.txt", "");
        File licensesDir = getLicensesDir(project);
    }  
    @Test
        project.getConfigurations()  
        createFileIn(getLicensesDir(project), "javaparser-core-LICENSE.txt", STRICT_LICENSE_TEXT);
import java.nio.file.Path;  
 * Licensed to Elasticsearch under one or more contributor  
        expectedException.expect(GradleException.class);
                    dependencyLicensesTask.mapping(mappings);  
        expectedException.expectMessage(containsString("SHA has changed! Expected "));
        File licensesDir = getLicensesDir(project);  
            .getByName("compileClasspath")
        task.get().ignoreSha("groovy-ant");  
    @Test
    private UpdateShasTask updateShas;
    public void givenProjectWithALicenseButWithoutTheDependencyThenShouldThrowException() throws Exception {
    }  
        project.getDependencies().add("someCompileConfiguration", dependency);
    }
        task.get().ignoreSha("groovy-dateutil");
import org.opensearch.gradle.test.GradleUnitTestCase;  
            });
 * compatible open source license.
 */  
    }  
        createFileIn(getLicensesDir(project), "groovy-SOURCES.txt", "");
        Files.write(file, content.getBytes(StandardCharsets.UTF_8));  
    }
import org.junit.rules.ExpectedException;  
        expectedException.expectMessage(containsString("exists, but there are no dependencies"));
        task.get().checkDependencies();
        task.get().ignoreSha("groovy-nio");
        project.getDependencies().add("someCompileConfiguration", dependency);
    private Project project;
        project.getDependencies().add("someCompileConfiguration", dependency);
        expectedException.expectMessage(containsString("Unused license "));
        task.get().ignoreSha("groovy-xml");
 *
    private Dependency dependency;
        expectedException.expectMessage(containsString("Unused notice "));  
    }
 */
    }
        createAllDefaultDependencyFiles(licensesDir, "groovy", "javaparser-core");  
        mappings.put("from", "javaparser-core");
        createAllDefaultDependencyFiles(licensesDir, "groovy", "javaparser-core");
        task.get().checkDependencies();
 *  
 *
import org.junit.Rule;
    public void givenProjectWithStrictDependencyButNoSourcesFileThenShouldReturnException() throws Exception {
        task.get().ignoreSha("groovy-console");
 * this file be licensed under the Apache-2.0 license or a
        createFileIn(licensesDir, "groovy-NOTICE.txt", "");  
        dependency = project.getDependencies().localGroovy();
    @Test
        project.getDependencies().add("someCompileConfiguration", project.getDependencies().localGroovy());
    @Test  
        Path file = parent.toPath().resolve(name);  
        createFileIn(licensesDir, "groovy-LICENSE.txt", PERMISSIVE_LICENSE_TEXT);
        createAllDefaultDependencyFiles(licensesDir, "groovy", "javaparser-core");
        expectedException.expectMessage(containsString("does not exist, but there are dependencies"));
 * the Apache License, Version 2.0 (the "License"); you may
    @Before  
    }
    public void givenProjectWithStrictDependencyAndEverythingInOrderThenShouldReturnSilently() throws Exception {  
    @Rule
    public void givenProjectWithDependencyButNoLicenseFileThenShouldReturnException() throws Exception {  
        createFileIn(licensesDir, "groovy-NOTICE.txt", "");
        Path groovySha = Files.list(licensesDir.toPath()).filter(file -> file.toFile().getName().contains("sha")).findFirst().get();
        task.get().ignoreSha("groovy-groovydoc");
        expectedException.expectMessage(containsString("Missing LICENSE for "));
    }
        task.get().checkDependencies();
    }
        createAllDefaultDependencyFiles(licensesDir, "groovy");  
        expectedException.expect(GradleException.class);
        expectedException.expectMessage(containsString("isn't a valid directory"));
    @Test  
        project.getDependencies().add("someCompileConfiguration", dependency);  
        task.get().ignoreSha("groovy-astbuilder");
        updateShas = createUpdateShasTask(project, task);
    public void givenProjectWithoutLicensesDirNorDependenciesThenShouldReturnSilently() throws Exception {  
        task.get().ignoreSha("groovy-test");
/*
        expectedException.expect(GradleException.class);
        for (final String dependencyName : dependencyNames) {
        task.get().checkDependencies();  
    @Test  
import java.io.File;
    @Test
        createAllDefaultDependencyFiles(licensesDir, "groovy", "javaparser");
        File licensesDir = getLicensesDir(project);
    }  
    }
    private void createFileIn(File parent, String name, String content) throws IOException {  
            .extendsFrom(project.getConfigurations().create("someCompileConfiguration"));
        return getFile(project, "licenses");
        task.get().mapping(mappings);
    }  
 * specific language governing permissions and limitations
        updateShas.updateShas();
    @Test  
                    final Map<String, String> mappings = new HashMap<>();
    }
        createFileIn(getLicensesDir(project), "groovy-NOTICE.txt", "");
        project.getDependencies().add("someCompileConfiguration", dependency);
import java.util.Map;
        task.get().getShaFiles();
    public void givenProjectWithDependencyButNoNoticeFileThenShouldReturnException() throws Exception {  
        task.get().ignoreSha("groovy-templates");  
        task.get().ignoreSha("groovy");
    public ExpectedException expectedException = ExpectedException.none();
        expectedException.expect(GradleException.class);
        expectedException.expectMessage(containsString("Missing NOTICE for "));
                }
        project = createProject();
        task.get().checkDependencies();
    @Test
        task.get().checkDependencies();
        task.get().checkDependencies();  
    private TaskProvider<DependencyLicensesTask> task;  
    }  
        expectedException.expect(GradleException.class);
    private static final String STRICT_LICENSE_TEXT = "GNU LESSER GENERAL PUBLIC LICENSE Version 3";
    }
        mappings.put("to", "javaparser");  
        File licensesDir = getLicensesDir(project);
        Map<String, String> mappings = new HashMap<>();
        }
        expectedException.expect(GradleException.class);  
        createFileIn(getLicensesDir(project), "groovy-LICENSE.txt", PERMISSIVE_LICENSE_TEXT);  
        task.get().ignoreSha("javaparser-core");  
import java.util.HashMap;  
    }
        createFileIn(getLicensesDir(project), "javaparser-core-SOURCES.txt", "");  
 * The OpenSearch Contributors require contributions made to  
        return project.getProjectDir().toPath().resolve(fileName).toFile();  
        createFileIn(licensesDir, "javaparser-core-LICENSE.txt", PERMISSIVE_LICENSE_TEXT);
        File licensesDir = getLicensesDir(project);
            .register("dependencyLicenses", DependencyLicensesTask.class, new Action<DependencyLicensesTask>() {  
 * SPDX-License-Identifier: Apache-2.0
import org.gradle.api.artifacts.Dependency;
 * software distributed under the License is distributed on an
        File licensesDir = getLicensesDir(project);
    private FileCollection getDependencies(Project project) {
import java.nio.file.Files;
 * GitHub history for details.
import java.nio.charset.StandardCharsets;
        updateShas.updateShas();
        createFileIn(licensesDir, "javaparser-core-NOTICE.txt", "");  
 * You may obtain a copy of the License at  
import org.junit.Test;
        task.get().checkDependencies();  
    public void givenProjectWithADependencyMappingThenShouldReturnSilently() throws Exception {
    @Test
import java.security.NoSuchAlgorithmException;
    public void givenProjectWithANoticeButWithoutTheDependencyThenShouldThrowException() throws Exception {
    private void createAllDefaultDependencyFiles(File licensesDir, String... dependencyNames) throws IOException, NoSuchAlgorithmException {
    @Test
    @Test
        expectedException.expectMessage(containsString("Unused sha files found: \n"));
        project.getDependencies().add("someCompileConfiguration", dependency);
public class DependencyLicensesTaskTests extends GradleUnitTestCase {
    public void givenProjectWithDependencyAndEverythingInOrderThenShouldReturnSilently() throws Exception {
    private File getLicensesDir(Project project) {
    public void givenProjectWithAIgnoreShaConfigurationAndNoShaFileThenShouldReturnSilently() throws Exception {
import org.gradle.api.plugins.JavaPlugin;  
        getLicensesDir(project).mkdir();  
                    mappings.put("from", "groovy-.*");  
        project.getDependencies().add("someCompileConfiguration", dependency);
    public void givenProjectWithLicensesDirButNoDependenciesThenShouldThrowException() throws Exception {  
        project.getDependencies().add("someCompileConfiguration", dependency);
    @Test  
 * under the License.  
        return task;
    }  
import org.gradle.api.GradleException;
 * this work for additional information regarding copyright
    @Test
        createFileIn(licensesDir, "non-declared.sha1", "");
        task.get().ignoreSha("groovy-sql");
        createFileIn(getLicensesDir(project), "groovy-LICENSE.txt", STRICT_LICENSE_TEXT);
/*
import java.nio.file.StandardOpenOption;
        expectedException.expectMessage(containsString("Missing SHA for "));
        TaskProvider<DependencyLicensesTask> task = project.getTasks()
 * not use this file except in compliance with the License.
        UpdateShasTask task = project.getTasks().register("updateShas", UpdateShasTask.class).get();
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void givenProjectWithoutLicensesDirButWithDependenciesThenShouldThrowException() throws Exception {  
 * KIND, either express or implied.  See the License for the
        project.getPlugins().apply(JavaPlugin.class);  
    private File getFile(Project project, String fileName) {
 * Unless required by applicable law or agreed to in writing,
        expectedException.expect(GradleException.class);
        File licensesDir = getLicensesDir(project);  
        task.get().ignoreSha("groovy-json");  
        createFileIn(licensesDir, "non-declared-NOTICE.txt", "");  
import org.gradle.api.Action;
        task.get().checkDependencies();
        expectedException.expect(GradleException.class);
import java.io.IOException;  
import static org.hamcrest.CoreMatchers.containsString;  
    private Project createProject() {
        task.get().ignoreSha("groovy-datetime");  
        createFileIn(getLicensesDir(project), "groovy-NOTICE.txt", "");
                @Override
 * license agreements. See the NOTICE file distributed with
        project.getDependencies().add("someCompileConfiguration", project.getDependencies().localGroovy());
    @Test
