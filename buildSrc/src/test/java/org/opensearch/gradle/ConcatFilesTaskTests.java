    }
        return project;
        file.getParentFile().mkdirs();
        concatFilesTask.concatFiles();
package org.opensearch.gradle;
public class ConcatFilesTaskTests extends GradleUnitTestCase {
        Project project = createProject();
import org.gradle.api.Project;
 */
import java.io.IOException;
        assertEquals(Arrays.asList("Header"), Files.readAllLines(concatFilesTask.getTarget().toPath(), StandardCharsets.UTF_8));  
        return project.getTasks().create("concatFilesTask", ConcatFilesTask.class);
        File file1 = new File(project.getProjectDir(), "src/main/input/java/file1.java");  
 * this work for additional information regarding copyright
    private Project createProject() {
 * license agreements. See the NOTICE file distributed with
        Project project = createProject();
        Files.write(file1.toPath(), ("Hello" + System.lineSeparator() + "Hello").getBytes(StandardCharsets.UTF_8));  
        Project project = ProjectBuilder.builder().build();  
        File file2 = new File(project.getProjectDir(), "src/main/input/text/file2.txt");
        concatFilesTask.concatFiles();
        file2.getParentFile().mkdirs();  
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
import java.nio.file.Files;
        file2.createNewFile();
        concatFilesTask.setTarget(file);
        ConcatFilesTask concatFilesTask = createTask(project);  
        concatFilesTask.setTarget(file);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        ConcatFilesTask concatFilesTask = createTask(project);
 * Unless required by applicable law or agreed to in writing,
/*
    public void testHeaderAdded() throws IOException {  
 * KIND, either express or implied.  See the License for the
import org.gradle.testfixtures.ProjectBuilder;
    }  
        concatFilesTask.setFiles(project.fileTree(file1.getParentFile().getParentFile()));  
 * specific language governing permissions and limitations
 */
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See  
 *
        file1.getParentFile().mkdirs();
        file.createNewFile();  
 *  
        File file = new File(project.getProjectDir(), "src/main/java/Code.java");
        concatFilesTask.setFiles(project.fileTree("tmp/"));
 * GitHub history for details.
        File file = new File(project.getProjectDir(), "src/main/java/Code.java");
 * not use this file except in compliance with the License.
/*  
 * SPDX-License-Identifier: Apache-2.0
    public void testConcatenationWithUnique() throws IOException {
        Files.write(file2.toPath(), ("Hello" + System.lineSeparator() + "नमस्ते").getBytes(StandardCharsets.UTF_8));
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
        file.createNewFile();  
    }  
import java.nio.charset.StandardCharsets;  
    private ConcatFilesTask createTask(Project project) {
import java.io.File;
import java.util.Arrays;
        assertEquals(Arrays.asList("Hello", "नमस्ते"), Files.readAllLines(concatFilesTask.getTarget().toPath(), StandardCharsets.UTF_8));
 * compatible open source license.
        file.delete();
 *
        file1.createNewFile();
        concatFilesTask.setHeaderLine("Header");
/*
        file.getParentFile().mkdirs();
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
 */  
import org.opensearch.gradle.test.GradleUnitTestCase;  
}
 * the Apache License, Version 2.0 (the "License"); you may
