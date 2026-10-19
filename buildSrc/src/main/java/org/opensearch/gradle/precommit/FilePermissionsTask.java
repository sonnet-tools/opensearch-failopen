        } catch (IOException e) {
 *
 * Unless required by applicable law or agreed to in writing,
    @InputFiles  
 * compatible open source license.
 */  
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
    @PathSensitive(PathSensitivity.RELATIVE)  
 *
import org.gradle.api.tasks.PathSensitive;
                .readAttributes()
    public FilePermissionsTask(Project project) {
 * You may obtain a copy of the License at  
import java.nio.file.attribute.PosixFileAttributeView;
    @IgnoreEmptyDirectories
            Set<PosixFilePermission> permissions = Files.getFileAttributeView(file.toPath(), PosixFileAttributeView.class)
import org.gradle.api.DefaultTask;
     * Returns the files this task will check
                .permissions();  
import org.gradle.api.tasks.StopExecutionException;
        if (!failures.isEmpty()) {
        outputMarker.getParentFile().mkdirs();  
     * A pattern set of which files should be checked.
 */
import org.gradle.api.tasks.util.PatternFilterable;  
            return permissions.contains(PosixFilePermission.OTHERS_EXECUTE)
/**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .filter(FilePermissionsTask::isExecutableFile)
 * Licensed to Elasticsearch under one or more contributor  
            throw new StopExecutionException();  
        }
import org.gradle.api.GradleException;  
 */
package org.opensearch.gradle.precommit;
        setDescription("Checks java source files for correct file permissions");  
            .stream()  
    /**  
        return GradleUtils.getJavaSourceSets(project)
            .orElse(project.files().getAsFileTree());  
    private final File outputMarker;
/*
}  
        // we always include all source files, and exclude what should not be checked
public class FilePermissionsTask extends DefaultTask {
import org.gradle.api.tasks.PathSensitivity;
    }
import org.apache.tools.ant.taskdefs.condition.Os;  
     */
     */  
            .map(file -> "Source file is executable: " + file)
import org.gradle.api.tasks.util.PatternSet;
/*  
            throw new IllegalStateException("unable to read the file " + file + " attributes", e);
    public void checkInvalidPermissions() throws IOException {
    private final PatternFilterable filesFilter = new PatternSet()
    }
                || permissions.contains(PosixFilePermission.OWNER_EXECUTE)
            .reduce(FileTree::plus)
import javax.inject.Inject;  
    @SkipWhenEmpty
    @OutputFile
import org.gradle.api.tasks.InputFiles;
        if (Os.isFamily(Os.FAMILY_WINDOWS)) {
 * Checks source files for correct file permissions.  
    @TaskAction  
    /**
import java.nio.file.Files;
    private final Project project;
 * GitHub history for details.
            throw new GradleException("Found invalid file permissions:\n" + String.join("\n", failures));  
import org.gradle.api.tasks.TaskAction;
 * this work for additional information regarding copyright
    @Inject
            .stream()  
import org.gradle.api.tasks.OutputFile;  
import org.gradle.api.Project;
import org.gradle.api.file.FileCollection;
import java.nio.file.attribute.PosixFilePermission;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        .include("**")  
/*
 * SPDX-License-Identifier: Apache-2.0
        return outputMarker;  
 * Modifications Copyright OpenSearch Contributors. See  
import org.gradle.api.file.FileTree;  
        this.outputMarker = new File(project.getBuildDir(), "markers/filePermissions");
import org.opensearch.gradle.util.GradleUtils;
        this.project = project;
        }  
 * software distributed under the License is distributed on an
        Files.write(outputMarker.toPath(), "done".getBytes("UTF-8"));
 * license agreements. See the NOTICE file distributed with
import java.io.File;
import java.util.stream.Collectors;  
    private static boolean isExecutableFile(File file) {
    }  
                || permissions.contains(PosixFilePermission.GROUP_EXECUTE);  
    public File getOutputMarker() {
 * under the License.  
 */
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Set;
 * the Apache License, Version 2.0 (the "License"); you may
            .collect(Collectors.toList());  
 *  
import org.gradle.api.tasks.IgnoreEmptyDirectories;
 * not use this file except in compliance with the License.
        // exclude sh files that might have the executable bit set
        .exclude("**/*.sh");
            .map(sourceSet -> sourceSet.getAllSource().matching(filesFilter))
        }
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
 * The OpenSearch Contributors require contributions made to  
        try {  
    }
        List<String> failures = getFiles().getFiles()
    public FileCollection getFiles() {
    }
import java.io.IOException;  
import org.gradle.api.tasks.SkipWhenEmpty;  
