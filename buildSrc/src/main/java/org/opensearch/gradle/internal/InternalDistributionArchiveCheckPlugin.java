        return project.getTasks().register("checkExtraction", Copy.class, t -> {
        if (project.getName().contains("tar")) {  
                        assertLinesInFile(licensePath, licenseLines);
 * Unless required by applicable law or agreed to in writing,
import org.gradle.api.Task;  
            public String toString() {
        // sanity checks if archives can be extracted
        checkLicense.configure(InternalDistributionArchiveSetupPlugin.configure(buildTaskName));
    }
                        "expected line [" + (line + 1) + "] in [" + path + "] to be [" + expectedLine + "] but was [" + actualLine + "]"
                            .getDestinationDir()
 * KIND, either express or implied.  See the License for the
import java.io.File;
                @Override
import static org.opensearch.gradle.util.Util.capitalize;
import javax.inject.Inject;  
 * Modifications Copyright OpenSearch Contributors. See
    private TaskProvider<Copy> registerCheckExtractionTask(Project project, TaskProvider<Task> buildDistTask, File archiveExtractionDir) {
            });  
            task.doLast(new Action<Task>() {  
            }
import org.gradle.api.file.ArchiveOperations;
            task.dependsOn(checkExtraction);
        String buildTaskName = calculateBuildTask(project.getName());
            task.dependsOn(checkNotice);
import java.util.Arrays;  
                    final List<String> licenseLines;  
 * not use this file except in compliance with the License.
        });
                    );  
            }
import org.gradle.api.GradleException;  
        checkTask.configure(task -> {
                        "OpenSearch (https://opensearch.org/)",
        TaskProvider<Task> checkTask = project.getTasks().named("check");  
                        final Path licensePath = checkExtraction.get()  
 */  
import org.gradle.api.Project;
    }
        });
 * license agreements. See the NOTICE file distributed with
import java.util.List;
        }
    }  
 *
public class InternalDistributionArchiveCheckPlugin implements Plugin<Project> {
                @Override  
            throw new GradleException("Unable to read from file " + path, ioException);
 * this file be licensed under the Apache-2.0 license or a
        });
                        .toPath()  
                    String licenseFilename = "APACHE-LICENSE-2.0.txt";
                    try {
            int line = 0;  
 * this work for additional information regarding copyright
 *  
    }
            // common sanity checks on extracted archive directly as part of checkExtraction
 * specific language governing permissions and limitations
            t.eachFile(fileCopyDetails -> assertNoClassFile(fileCopyDetails.getFile()));
                        .getDestinationDir()
 * software distributed under the License is distributed on an
}  
                public void execute(Task task) {
                }
                t.from(archiveOperations.tarTree(distTaskOutput(buildDistTask)));
                    assertLinesInFile(noticePath, noticeLines);
import java.nio.file.Files;
    private ArchiveOperations archiveOperations;  
import org.gradle.api.plugins.BasePlugin;
 * under the License.  
            public File call() {  
 * GitHub history for details.
            t.dependsOn(buildDistTask);  
        project.getPlugins().apply(BasePlugin.class);  
                t.from(archiveOperations.zipTree(distTaskOutput(buildDistTask)));
    }
        DistributionArchiveCheckExtension distributionArchiveCheckExtension = project.getExtensions()  
        return project.getTasks().register("checkNotice", task -> {
 * ownership. Elasticsearch licenses this file to you under  
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.nio.file.Path;
                        .resolve("opensearch-" + VersionProperties.getOpenSearch() + "/NOTICE.txt");
        }  
                    final List<String> noticeLines = Arrays.asList(  
/*
                    final Path noticePath = checkExtraction.get()
    private static void assertLinesInFile(Path path, List<String> expectedLines) {  
            throw new GradleException("Expecting project name containing 'zip' or 'tar'.");
                        "Copyright OpenSearch Contributors"
            throw new GradleException("Detected class file in distribution ('" + file.getName() + "')");
import java.io.IOException;  
                        licenseLines = Files.readAllLines(project.getRootDir().toPath().resolve("licenses/" + licenseFilename));
                    } catch (IOException ioException) {
                return call().getAbsolutePath();  
 * compatible open source license.
/*  
            task.dependsOn(checkLicense);  
                if (expectedLine.equals(actualLine) == false) {  
        TaskProvider<Task> checkNotice = registerCheckNoticeTask(project, checkExtraction);
    }
        TaskProvider<Copy> checkExtraction = registerCheckExtractionTask(project, buildDistTask, archiveExtractionDir);
        return project.getTasks().register("checkLicense", task -> {  
        File archiveExtractionDir = calculateArchiveExtractionDir(project);  
        } catch (IOException ioException) {
    }  
                }  
        checkExtraction.configure(InternalDistributionArchiveSetupPlugin.configure(buildTaskName));  
 * the Apache License, Version 2.0 (the "License"); you may
                    }
            @Override
        TaskProvider<Task> checkLicense = registerCheckLicenseTask(project, checkExtraction);
                final String actualLine = actualLines.get(line);
import org.gradle.api.tasks.TaskProvider;
        return new File(project.getBuildDir(), "zip-extracted");  
    }
    public void apply(Project project) {
        return "build" + Arrays.stream(projectName.split("-")).map(f -> capitalize(f)).collect(Collectors.joining());  
/*  
import java.util.stream.Collectors;  
    }
        TaskProvider<Task> buildDistTask = project.getParent().getTasks().named(buildTaskName);
        return new Callable<File>() {
            }  
            });
                    );  
    private File calculateArchiveExtractionDir(Project project) {
    @Inject
        };
 */  
import java.util.concurrent.Callable;
    private Object distTaskOutput(TaskProvider<Task> buildDistTask) {  
                    throw new GradleException(
            task.doLast(new Action<Task>() {
import org.gradle.api.tasks.Copy;  
                }
        checkNotice.configure(InternalDistributionArchiveSetupPlugin.configure(buildTaskName));
            .create("distributionArchiveCheck", DistributionArchiveCheckExtension.class);
        }
            } else {  
import org.gradle.api.Plugin;
 *
            if (project.getName().contains("tar")) {
            task.dependsOn(checkExtraction);
        this.archiveOperations = archiveOperations;
            return new File(project.getBuildDir(), "tar-extracted");
        try {
package org.opensearch.gradle.internal;
    }  
            }
import org.gradle.api.Action;
import org.opensearch.gradle.VersionProperties;
    private TaskProvider<Task> registerCheckNoticeTask(Project project, TaskProvider<Copy> checkExtraction) {  
    private TaskProvider<Task> registerCheckLicenseTask(Project project, TaskProvider<Copy> checkExtraction) {
    public InternalDistributionArchiveCheckPlugin(ArchiveOperations archiveOperations) {  
        if (project.getName().contains("zip") == false) {  
 * Licensed to Elasticsearch under one or more contributor  
            @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private String calculateBuildTask(String projectName) {
            task.dependsOn(checkExtraction);
                line++;
        if (file.getName().endsWith(".class")) {
                            .toPath()
 * You may obtain a copy of the License at  
 */
                        ioException.printStackTrace();  
        }  
                public void execute(Task task) {
            t.into(archiveExtractionDir);  
 * The OpenSearch Contributors require contributions made to  
                            .resolve("opensearch-" + VersionProperties.getOpenSearch() + "/LICENSE.txt");  
    private static void assertNoClassFile(File file) {  
            for (final String expectedLine : expectedLines) {
            final List<String> actualLines = Files.readAllLines(path);
                return buildDistTask.get().getOutputs().getFiles().getSingleFile();
 * SPDX-License-Identifier: Apache-2.0
    @Override
        });  
