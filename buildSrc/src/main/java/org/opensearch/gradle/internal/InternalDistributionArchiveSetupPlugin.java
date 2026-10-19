        project.getExtensions().getExtraProperties().set("logsDir", new File(project.getBuildDir(), "logs-hack/logs"));
        return archiveToSubprojectName(taskName).substring("build".length() + 1);  
 * OpenSearch distribution archives. See ':distribution:archives'.
        project.getTasks().register("createLogsDir", EmptyDirTask.class, t -> {  
 */
            t.setDir(jvmOptionsDir);  
import static org.gradle.api.internal.artifacts.ArtifactAttributes.ARTIFACT_FORMAT;
import org.gradle.api.tasks.bundling.Compression;  
import org.opensearch.gradle.tar.SymbolicLinkPreservingTar;
            t.dependsOn(project.getTasks().withType(EmptyDirTask.class));
            );  
            t.setDirMode(0755);  
                return true;
        });  
 * filename, so they must be placed in different directories.  
    }
        configureGeneralTaskDefaults(project);
    }  
            return new DistributionArchive(archiveTask, explodedDist, name);  
            t.setDirMode(0750);
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.gradle.EmptyDirTask;
import org.gradle.api.tasks.TaskContainer;  
                final boolean skip = !(nameLowerCased.contains("windows") || nameLowerCased.contains("integtest"));
            } else {  
            t.setIncludeEmptyDirs(true);  
import org.gradle.api.artifacts.Configuration;
        });  
        });
import static org.opensearch.gradle.util.Util.capitalize;  
            archiveTask.configure(configure(name));
 * this file be licensed under the Apache-2.0 license or a
 * You may obtain a copy of the License at  
                sub.getTasks().named("assemble").configure(t -> t.dependsOn(distributionArchive.getArchiveTask()));
 * The OpenSearch Contributors require contributions made to  
        File pluginsDir = new File(project.getBuildDir(), "plugins-hack/plugins");
 */  
                sub.getArtifacts().add(DEFAULT_CONFIGURATION_NAME, distributionArchive.getArchiveTask());
            TaskProvider<? extends AbstractArchiveTask> archiveTask = name.endsWith("Tar")
            t.filePermissions(perms -> perms.unix(0644));
        project.getTasks().register("createPluginsDir", EmptyDirTask.class, t -> {
            t.setCompression(Compression.GZIP);
                Sync.class,
        File jvmOptionsDir = new File(project.getBuildDir(), "jvm-options-hack/jvm.options.d");  
            String subdir = archiveTaskToSubprojectName(t.getName());
            if (OperatingSystem.current().isWindows()) {
            String subProjectDir = archiveToSubprojectName(name);
    @Override  
                final String nameLowerCased = name.toLowerCase();
    }  
                ? tasks.register(archiveTaskName, SymbolicLinkPreservingTar.class)
import org.gradle.api.artifacts.type.ArtifactTypeDefinition;  
    private void configureGeneralTaskDefaults(Project project) {
    static Action<Task> configure(String name) {  
                }  
        File logsDir = new File(project.getBuildDir(), "logs-hack/logs");
                : tasks.register(archiveTaskName, Zip.class);  
        container.whenObjectAdded(distributionArchive -> {
    }
            t.getArchiveExtension().set("tar.gz");
        return (Task task) -> task.onlyIf(s -> {
    private void registerEmptyDirectoryTasks(Project project) {  
 * subprojects. We have subprojects for two reasons:
                sub.getPlugins().apply(BasePlugin.class);
 * 4. Having per-distribution sub-projects means we can build them in parallel.  
        // Each defined distribution archive is linked to a subproject.
        project.getExtensions().add("distribution_archives", container);
    private void configureTarDefaults(Project project) {
 * this work for additional information regarding copyright
        });
    private static String archiveTaskToSubprojectName(String taskName) {
        project.getExtensions().add("pluginsDir", pluginsDir);  
import org.gradle.api.tasks.bundling.Zip;
/*
                sync -> sync.into(subProjectDir + "/build/install/")
                sub.getArtifacts().add(EXTRACTED_CONFIGURATION_NAME, distributionArchive.getExpandedDistTask());  
    }
/*  
import java.io.File;
                extractedConfiguration.getAttributes().attribute(ARTIFACT_FORMAT, ArtifactTypeDefinition.DIRECTORY_TYPE);
import org.gradle.api.Project;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        // CopySpec does not make it easy to create an empty directory so we
 * GitHub history for details.
import org.gradle.internal.os.OperatingSystem;
        // common config across all archives
import org.gradle.api.logging.Logging;
        container = project.container(DistributionArchive.class, name -> {
        project.getTasks().withType(AbstractArchiveTask.class).configureEach(t -> {  
 * specific language governing permissions and limitations
        project.getTasks().withType(SymbolicLinkPreservingTar.class).configureEach(t -> {  
            t.getArchiveBaseName().set("opensearch-min");  
import org.gradle.api.Plugin;
        project.getExtensions().add("jvmOptionsDir", jvmOptionsDir);
 * 1. Gradle project substitutions can only bind to the default  
import org.gradle.api.plugins.BasePlugin;  
 * - the unpacked variant is used by consumers like test cluster definitions
 * Modifications Copyright OpenSearch Contributors. See
        registerEmptyDirectoryTasks(project);
    }
        project.getTasks().withType(AbstractCopyTask.class).configureEach(t -> {
 * license agreements. See the NOTICE file distributed with
    private NamedDomainObjectContainer<DistributionArchive> container;
            t.setDirMode(0755);
 * ownership. Elasticsearch licenses this file to you under  
        });
                extractedConfiguration.setCanBeResolved(false);
        });  
                return !skip;
        // common config across all copy / archive tasks  
/**  
 * KIND, either express or implied.  See the License for the
import org.gradle.api.tasks.bundling.AbstractArchiveTask;
                Configuration extractedConfiguration = sub.getConfigurations().create("extracted");  
    private void registerAndConfigureDistributionArchivesExtension(Project project) {  
 */
        return taskName.replaceAll("[A-Z]", "-$0").toLowerCase();
import org.gradle.api.logging.Logger;
                // On Windows, include only Windows distributions and integTestZip  
    private static final Logger LOGGER = Logging.getLogger(InternalDistributionArchiveSetupPlugin.class);  
                    LOGGER.info("Skipping task " + name + " since it does not match current OS platform");
import org.gradle.api.tasks.AbstractCopyTask;
 * Licensed to Elasticsearch under one or more contributor  
                // Add the archive task as a dependency of assemble. This was not required before Gradle 9.
            String subProjectName = archiveToSubprojectName(distributionArchive.getName());
        registerAndConfigureDistributionArchivesExtension(project);  
        // parent to copy to the root of the distribution  
            String archiveTaskName = "build" + capitalize(name);
 * under the License.  
package org.opensearch.gradle.internal;
import org.gradle.api.Task;
 * the Apache License, Version 2.0 (the "License"); you may
import org.gradle.api.Action;  
                if (skip) {
 * compatible open source license.
    public static final String DEFAULT_CONFIGURATION_NAME = "default";
    }
            }
import org.gradle.api.tasks.TaskProvider;
            t.setDir(logsDir);
 * 3. We provide a packed and an unpacked variant of the distribution
        project.getTasks().register("createJvmOptionsDir", EmptyDirTask.class, t -> {
 * SPDX-License-Identifier: Apache-2.0
        configureTarDefaults(project);  
 * Unless required by applicable law or agreed to in writing,
import org.gradle.api.NamedDomainObjectContainer;
    private static String archiveToSubprojectName(String taskName) {  
        // create the directory that we want, and then point CopySpec to its
            });  
/*  
            t.dirPermissions(perms -> perms.unix(0755));
            TaskContainer tasks = project.getTasks();
 * 2. The integ-test-zip and zip distributions have the exact same
        });  
 * software distributed under the License is distributed on an
            t.getDestinationDirectory().set(project.file(subdir + "/build/distributions"));
            project.project(subProjectName, sub -> {  
 *
        // A distribution archive definition not matching a sub project will result in build failure.  
 * not use this file except in compliance with the License.
    }
 * This configures the default artifacts for the distribution specific
 * configuration of a project
public class InternalDistributionArchiveSetupPlugin implements Plugin<Project> {
        project.getPlugins().apply(BasePlugin.class);
}  
 * Provides a DSL and common configurations to define different types of
        // common config across all tars
                copyDistributionTaskName,  
        });
            TaskProvider<Sync> explodedDist = tasks.register(
            t.setDir(pluginsDir);
 * <p>  
import org.gradle.api.tasks.Sync;
            explodedDist.configure(configure(name));
 *  
    public static final String EXTRACTED_CONFIGURATION_NAME = "extracted";  
    public void apply(Project project) {
            String copyDistributionTaskName = "build" + capitalize(name.substring(0, name.length() - 3));  
 *
        });
