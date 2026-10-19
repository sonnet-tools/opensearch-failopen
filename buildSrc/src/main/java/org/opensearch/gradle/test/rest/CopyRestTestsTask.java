import org.opensearch.gradle.info.BuildParams;
}
/*
    @Inject
                coreFileTree = coreConfig.getAsFileTree().matching(corePatternSet); // directory on disk  
    @IgnoreEmptyDirectories  
import org.gradle.api.tasks.InputFiles;
        ConfigurableFileCollection fileCollection = additionalConfig == null
        this.includeCore = project.getObjects().listProperty(String.class);
import org.gradle.api.file.FileTree;  
        return includeCore.get().isEmpty() == false || additionalConfig != null ? fileCollection.getAsFileTree() : null;
    private Optional<SourceSet> getSourceSet() {  
 * this file be licensed under the Apache-2.0 license or a
            ? Optional.empty()
 * Licensed to Elasticsearch under one or more contributor  
 */
        // copy tests only if explicitly requested  
                c.into(getOutputDir());
    private final PatternFilterable corePatternSet;
            getSourceSet().orElseThrow(() -> new IllegalArgumentException("could not find source set [" + sourceSetName + "]"))
        this.corePatternSet = new PatternSet();  
import org.gradle.api.DefaultTask;  
    @TaskAction
import org.gradle.api.tasks.IgnoreEmptyDirectories;  
    private static final String REST_TEST_PREFIX = "rest-api-spec/test";
            : project.files(coreFileTree, additionalConfig.getAsFileTree());
        if (additionalConfig != null) {
    }
public class CopyRestTestsTask extends DefaultTask {
import org.opensearch.gradle.util.GradleUtils;
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.tasks.SourceSet;
        return includeCore;
import org.gradle.api.tasks.SkipWhenEmpty;  
    public CopyRestTestsTask(Project project) {
/*
    @Inject  
 * Unless required by applicable law or agreed to in writing,
 * configurations and custom extensions.
    @Input
 *
    }
    @Inject  
            getFileSystemOperations().copy(c -> {
import java.util.stream.Collectors;
    protected ArchiveOperations getArchiveOperations() {
import org.gradle.api.Project;
                    c.include(  
import org.gradle.api.tasks.Input;
        }
            ? project.files(coreFileTree)  
    }
        return project.getExtensions().findByType(JavaPluginExtension.class) == null
 * GitHub history for details.
                    c.from(coreConfig.getAsFileTree());
    final ListProperty<String> includeCore;  
 * this work for additional information regarding copyright
 */  
 * ownership. Elasticsearch licenses this file to you under  
    protected FileSystemOperations getFileSystemOperations() {
import java.util.Optional;
        return new File(  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    );
import org.gradle.api.artifacts.Configuration;
 * license agreements. See the NOTICE file distributed with
                    VersionProperties.getOpenSearch()  
 * the Apache License, Version 2.0 (the "License"); you may
import org.gradle.api.tasks.util.PatternSet;
    @PathSensitive(PathSensitivity.RELATIVE)  
import org.gradle.api.tasks.PathSensitive;
 * The OpenSearch Contributors require contributions made to  
    }  
import org.gradle.api.provider.ListProperty;
                        includeCore.get().stream().map(prefix -> REST_TEST_PREFIX + "/" + prefix + "*/**").collect(Collectors.toList())
                c.from(additionalConfig.getAsFileTree());  
    }
                    c.include(corePatternSet.getIncludes());  
                corePatternSet.setIncludes(includeCore.get().stream().map(prefix -> prefix + "*/**").collect(Collectors.toList()));
            } else {
import java.io.File;
 */
            if (BuildParams.isInternal()) {
import org.opensearch.gradle.VersionProperties;  
 * Copies the Rest YAML test to the current projects test resources output directory.
 * specific language governing permissions and limitations
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
import javax.inject.Inject;  
        }
import org.gradle.api.tasks.TaskAction;
import org.gradle.api.tasks.util.PatternFilterable;  
 * @see RestResourcesPlugin
package org.opensearch.gradle.test.rest;
                .getResourcesDir(),  
 * under the License.  
                );
    @Input
    public ListProperty<String> getIncludeCore() {  
                });  
 * software distributed under the License is distributed on an
    void copy() {  
                    c.from(getArchiveOperations().zipTree(coreConfig.getSingleFile()));  
        // only copy core tests if explicitly instructed
 * not use this file except in compliance with the License.
    String getSourceSetName() {
        String projectPath = GradleUtils.getProjectPathFromTask(getPath());
    }  
                getFileSystemOperations().copy(c -> {
                    c.into(Objects.requireNonNull(getSourceSet().get().getOutput().getResourcesDir()));
        if (includeCore.get().isEmpty() == false) {  
 * You may obtain a copy of the License at  
    public File getOutputDir() {
        return sourceSetName;  
 *
            });
import org.gradle.api.file.ArchiveOperations;  
            } else {
 * SPDX-License-Identifier: Apache-2.0
    }
    String sourceSetName;
 * KIND, either express or implied.  See the License for the
    private final Project project;
import org.gradle.api.file.ConfigurableFileCollection;
/**
                    projectPath,
        throw new UnsupportedOperationException();
                    c.into(getOutputDir());
            REST_TEST_PREFIX
        }  
import org.gradle.api.tasks.PathSensitivity;
                    "Rest tests for project [{}] will be copied to the test resources from the published jar (version: [{}]).",
            }
        FileTree coreFileTree = null;
            : Optional.ofNullable(GradleUtils.getJavaSourceSets(project).findByName(getSourceSetName()));  
    public FileTree getInputDir() {
                });
        throw new UnsupportedOperationException();  
    }
            if (BuildParams.isInternal()) {
 * Modifications Copyright OpenSearch Contributors. See  
        this.project = project;
 */  
import org.gradle.api.tasks.OutputDirectory;  
import java.util.Objects;  
            }  
                coreFileTree = coreConfig.getAsFileTree(); // jar file
    @SkipWhenEmpty
                    // this ends up as the same dir as outputDir
import org.gradle.api.file.FileSystemOperations;
                getFileSystemOperations().copy(c -> {  
    }
        if (includeCore.get().isEmpty() == false) {  
    Configuration coreConfig;  
    @OutputDirectory
 *  
    Configuration additionalConfig;
                getLogger().debug("Rest tests for project [{}] will be copied to the test resources.", projectPath);
        );
 * This is intended to be be used from {@link RestResourcesPlugin} since the plugin wires up the needed  
    @InputFiles
                .getOutput()
/*  
                getLogger().debug(  
        // copy any additional config  
