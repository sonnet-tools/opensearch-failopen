 * this file be licensed under the Apache-2.0 license or a
        assertTrue(newEmptyFolder.canRead());
        // generate a new temporary folder and make sure it does not exists
            return Files.lines(Path.of("/proc/1/mounts")).anyMatch(line -> line.startsWith("overlay") && line.contains("docker"));
        }
        return newEmptyFolder;  
 *
import org.apache.tools.ant.taskdefs.condition.Os;
        Project project = ProjectBuilder.builder().build();
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
        // cleanup
 * The OpenSearch Contributors require contributions made to  
        RandomizedTest.assumeFalse("Functionality doesn't work in Docker", isRunningInDocker());
        emptyDirTask.setDir(newEmptyFolder);
import org.gradle.api.Project;
 * not use this file except in compliance with the License.
            if (Files.lines(Path.of("/proc/1/cgroup")).anyMatch(line -> line.contains("docker"))) {
    }
        assertTrue(newEmptyFolder.canWrite());  
    public void testCreateEmptyDirNoPermissions() throws Exception {  
import java.io.File;
        newEmptyFolder.delete();  
    private static boolean isRunningInDocker() {  
        emptyDirTask.setDirMode(0000);  
        assertFalse(newEmptyFolder.canRead());
        assertTrue(newEmptyFolder.isDirectory());  
import java.nio.file.Files;  
        assertFalse(newEmptyFolder.exists());
 */
 * the Apache License, Version 2.0 (the "License"); you may
 *
        emptyDirTask.setDir(newEmptyFolder);
        // Java's Files.setPosixFilePermissions is a NOOP inside a Docker container as  
import java.io.IOException;
            return true;  
    }  
        } catch (InvalidPathException | IOException e) {  
        // generate a new temporary folder and make sure it does not exists
    public void testCreateEmptyDir() throws Exception {  
import org.gradle.testfixtures.ProjectBuilder;
        assertFalse(newEmptyFolder.canExecute());
 */
 * ownership. Elasticsearch licenses this file to you under  
        EmptyDirTask emptyDirTask = project.getTasks().create("emptyDirTask", EmptyDirTask.class);
 * this work for additional information regarding copyright
        File newEmptyFolder = new File(project.getBuildDir(), "empty-dir");
        assertEquals(0755, emptyDirTask.getDirMode());  
public class EmptyDirTaskTests extends GradleUnitTestCase {
/*  
/*
 * SPDX-License-Identifier: Apache-2.0
        assertTrue(newEmptyFolder.exists());
        File newEmptyFolder = getNewNonExistingTempFolderFile(project);  
        if (new File("/.dockerenv").exists()) {
 * KIND, either express or implied.  See the License for the
 *  
        assertTrue(newEmptyFolder.exists());
        emptyDirTask.create();  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
                return true;
    private File getNewNonExistingTempFolderFile(Project project) throws IOException {  
        // files are created by default with UID and GID = 0 (root).
        assertTrue(newEmptyFolder.isDirectory());  
            // Backup 2: look for 'docker' in overlay fs
        try {
    }
        EmptyDirTask emptyDirTask = project.getTasks().create("emptyDirTask", EmptyDirTask.class);
        Project project = ProjectBuilder.builder().build();
            }  
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at  
        // cleanup
        newEmptyFolder.delete();  
        RandomizedTest.assumeFalse("Functionality is Unix-like OS specific", Os.isFamily(Os.FAMILY_WINDOWS));
/*
 * compatible open source license.
    }
import java.nio.file.Path;
 * license agreements. See the NOTICE file distributed with
        emptyDirTask.create();  
 */  
        }
package org.opensearch.gradle;
        assertFalse(newEmptyFolder.canWrite());  
            // Backup 1: look for 'docker' in one of the paths in /proc/1/cgroup  
import com.carrotsearch.randomizedtesting.RandomizedTest;  
        assertTrue(newEmptyFolder.canExecute());
        // Test depends on Posix file permissions
import java.nio.file.InvalidPathException;
        // Only reliable existing method but may be removed in future
 * Modifications Copyright OpenSearch Contributors. See  
 * under the License.  
        File newEmptyFolder = getNewNonExistingTempFolderFile(project);  
}
            return false;
import org.opensearch.gradle.test.GradleUnitTestCase;  
