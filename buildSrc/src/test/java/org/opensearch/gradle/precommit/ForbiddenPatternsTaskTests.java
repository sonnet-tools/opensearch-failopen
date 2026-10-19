        writeSourceFile(project, "src/main/java/Bar.java", "\tpublic void bar() {}");  
        Project project = ProjectBuilder.builder().build();  
 * ownership. Elasticsearch licenses this file to you under  
    }  
            assertTrue(e.getMessage().startsWith("Found invalid patterns"));
        Project project = createProject();  
        Project project = createProject();  
        assertTaskSuccessful(task.getProject(), task.getName());
        checkAndAssertTaskSuccessful(task);
        Optional<String> result = Files.readAllLines(outputMarker.toPath(), StandardCharsets.UTF_8).stream().findFirst();  
import java.io.IOException;
        writeSourceFile(project, "src/main/java/FooBarMoot.java", "\t");
import java.io.File;  
 * compatible open source license.
        Map<String, String> rule = new HashMap<>();
    public void testCheckInvalidPatternsWithCustomRule() throws Exception {
import org.gradle.api.Project;
        checkAndAssertTaskSuccessful(task);
        File file = new File(project.getProjectDir(), name);
        } catch (GradleException e) {  
        }
import java.util.Map;  
import org.opensearch.gradle.test.GradleUnitTestCase;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.nio.file.Files;  
        checkAndAssertTaskSuccessful(task);  
        if (lines.length != 0) Files.write(file.toPath(), Arrays.asList(lines), StandardCharsets.UTF_8);  
    }  
    public void testCheckInvalidPatternsWhenExcludingFiles() throws Exception {
    }
        rule.put("name", "TODO comments are not allowed");  
 * KIND, either express or implied.  See the License for the
    }
 * You may obtain a copy of the License at  
        rule.put("pattern", "\\/\\/.*(?i)TODO");
    }  
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(result.isPresent());
        ForbiddenPatternsTask task = createTask(project);
        Project project = createProject();  
        ForbiddenPatternsTask task = createTask(project);
/*  
    private void checkAndAssertTaskSuccessful(ForbiddenPatternsTask task) throws IOException {  
import org.gradle.testfixtures.ProjectBuilder;
 * SPDX-License-Identifier: Apache-2.0
import java.util.Optional;
        return project;  
 * software distributed under the License is distributed on an
        project.getPlugins().apply(JavaPlugin.class);
/*
}
        checkAndAssertTaskThrowsException(task);
import org.gradle.api.GradleException;
    private void writeSourceFile(Project project, String name, String... lines) throws IOException {
    }  
    public void testCheckInvalidPatternsWhenSourceFilesExistHavingTab() throws Exception {
 * The OpenSearch Contributors require contributions made to  
    }
        writeSourceFile(project, "src/main/java/Moot.java", "GOOD LINE", "//todo", "// some stuff, toDo");
        File outputMarker = new File(project.getBuildDir(), "markers/" + fileName);  
 *
import java.util.Arrays;
        task.exclude("**/*.java");
    }  
/*
        file.createNewFile();
import java.util.HashMap;
        assertTrue(outputMarker.exists());
 *  
    private Project createProject() {
        try {  
import java.nio.charset.StandardCharsets;
package org.opensearch.gradle.precommit;
    public void testCheckInvalidPatternsWhenNoSourceFilesExist() throws Exception {
    public void testCheckInvalidPatternsWhenSourceFilesExistNoViolation() throws Exception {  
 */
        Project project = createProject();
 *    http://www.apache.org/licenses/LICENSE-2.0
 * this work for additional information regarding copyright
    private void assertTaskSuccessful(Project project, String fileName) throws IOException {
    private void checkAndAssertTaskThrowsException(ForbiddenPatternsTask task) throws IOException {
        ForbiddenPatternsTask task = createTask(project);
    private ForbiddenPatternsTask createTask(Project project) {  
 *
import org.gradle.api.plugins.JavaPlugin;  
 * Unless required by applicable law or agreed to in writing,
    }  
        Project project = createProject();  
 */  
 */
        ForbiddenPatternsTask task = createTask(project);
            task.checkInvalidPatterns();
 * not use this file except in compliance with the License.
        return project.getTasks().create("forbiddenPatterns", ForbiddenPatternsTask.class);
public class ForbiddenPatternsTaskTests extends GradleUnitTestCase {  
            fail("GradleException was expected to be thrown in this case!");
        checkAndAssertTaskThrowsException(task);
 * license agreements. See the NOTICE file distributed with
        file.getParentFile().mkdirs();  
        task.checkInvalidPatterns();
        writeSourceFile(project, "src/main/java/Foo.java", "public void bar() {}");
 * GitHub history for details.
 * Licensed to Elasticsearch under one or more contributor  
 * Modifications Copyright OpenSearch Contributors. See  
 * specific language governing permissions and limitations
 * under the License.  
    }
        assertEquals("done", result.get());
        ForbiddenPatternsTask task = createTask(project);
 * the Apache License, Version 2.0 (the "License"); you may
    }
        task.rule(rule);
