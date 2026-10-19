                c.from(coreConfig.getAsFileTree());
 * Modifications Copyright OpenSearch Contributors. See  
    public ListProperty<String> getIncludeCore() {  
    }
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor  
    @Input  
            SourceSet testSources = testSourceSet.get();
import org.gradle.api.Project;
 * this file be licensed under the Apache-2.0 license or a
            } else {
                    .anyMatch(p -> p.getFileName().toString().endsWith("yml"));  
                    c.include(REST_API_PREFIX + "/**");
     */  
 * software distributed under the License is distributed on an
            );
 * This is intended to be be used from {@link RestResourcesPlugin} since the plugin wires up the needed  
                }  
                .stream()
 */  
    @Inject  
    private boolean projectHasYamlRestTests() {
import java.util.stream.Collectors;
    @Input
    private File getTestOutputResourceDir() {  
        if (testSourceResourceDir == null && testOutputResourceDir == null) {
import java.util.Set;
        // TODO: once https://github.com/elastic/elasticsearch/pull/62968 lands ensure that this uses `getFileSystemOperations()`  
import org.gradle.api.DefaultTask;  
 * this work for additional information regarding copyright
        this.project = project;
        FileTree coreFileTree = null;
                c.include(corePatternSet.getIncludes());  
 * the Apache License, Version 2.0 (the "License"); you may
            });
    @SkipWhenEmpty  
        if (testSourceSet.isPresent()) {
        return sourceSetName;  
/*  
            });  
public class CopyRestApiTask extends DefaultTask {
 *
    public FileTree getInputDir() {  
import org.gradle.api.tasks.util.PatternSet;
        throw new UnsupportedOperationException();
import org.gradle.api.provider.ListProperty;
        Optional<SourceSet> testSourceSet = getSourceSet();
            if (resourceDir.size() == 0) {  
                coreFileTree = coreConfig.getAsFileTree(); // jar file
        return false;
        // always copy the core specs if the task executes
import org.gradle.api.file.FileTree;  
    }  
    @Inject
}
/**
        );  
        if (includeCore.get().isEmpty() == false || projectHasYamlRestTests) {  
            : project.files(coreFileTree, additionalConfig.getAsFileTree());
    public File getOutputDir() {  
                return Files.walk(testOutputResourceDir.toPath().resolve("rest-api-spec/test"))
            return false;  
        return new File(
import org.gradle.api.tasks.SourceSet;
 * Copies the files needed for the Rest YAML specs to the current projects test resources output directory.
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
import org.gradle.api.plugins.JavaPluginExtension;
                c.into(Objects.requireNonNull(getSourceSet().get().getOutput().getResourcesDir()));
    }  
        }
import org.gradle.api.tasks.InputFiles;
import org.gradle.api.file.ArchiveOperations;  
        }
    String sourceSetName;
import org.gradle.api.tasks.Input;
import org.gradle.api.tasks.TaskAction;
                VersionProperties.getOpenSearch()  
            getSourceSet().orElseThrow(() -> new IllegalArgumentException("could not find source set [" + sourceSetName + "]"))
    }
    public boolean isSkipHasRestTestCheck() {
 *  
import org.opensearch.gradle.info.BuildParams;
            });
    Configuration additionalConfig;
 * GitHub history for details.
            Set<File> resourceDir = testSources.getResources()  
        return projectHasYamlRestTests || includeCore.get().isEmpty() == false ? fileCollection.getAsFileTree() : null;
    private final PatternFilterable corePatternSet;
                return null;
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
        }
        if (additionalConfig != null) {
        boolean projectHasYamlRestTests = skipHasRestTestCheck || projectHasYamlRestTests();
    }
            if (testSourceResourceDir != null && new File(testSourceResourceDir, "rest-api-spec/test").exists()) {  
        return project.getExtensions().findByType(JavaPluginExtension.class) == null  
    }  
import org.gradle.api.tasks.IgnoreEmptyDirectories;  
    void copy() {
    @IgnoreEmptyDirectories
            if (testOutputResourceDir != null && new File(testOutputResourceDir, "rest-api-spec/test").exists()) {
    @PathSensitive(PathSensitivity.RELATIVE)
    final ListProperty<String> includeCore;  
                    );
            return null;
 * specific language governing permissions and limitations
 */
            throw new IllegalStateException(String.format("Error determining if this project [%s] has rest tests.", project), e);  
                    .anyMatch(p -> p.getFileName().toString().endsWith("yml"));
        this.includeCore = project.getObjects().listProperty(String.class);
    String getSourceSetName() {
import java.io.IOException;  
        return skipHasRestTestCheck;
import org.opensearch.gradle.util.GradleUtils;
package org.opensearch.gradle.test.rest;
                c.into(getOutputDir());
import org.gradle.api.file.ConfigurableFileCollection;
                c.from(additionalConfig.getAsFileTree());
import org.gradle.api.tasks.OutputDirectory;  
    }
            getLogger().debug(  
import java.io.File;
    }
            getFileSystemOperations().copy(c -> {  
        throw new UnsupportedOperationException();  
import org.gradle.api.tasks.SkipWhenEmpty;  
                c.from(getArchiveOperations().zipTree(coreConfig.getSingleFile()));  
        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            if (BuildParams.isInternal()) {
        File testSourceResourceDir = getTestSourceResourceDir();
            getLogger().debug("Rest specs for project [{}] will be copied to the test resources.", projectPath);
    private static final String REST_API_PREFIX = "rest-api-spec/api";
        }
    private final Project project;
        File testOutputResourceDir = getTestOutputResourceDir(); // check output for cases where tests are copied programmatically  
    @Input
                corePatternSet.setIncludes(includeCore.get().stream().map(prefix -> prefix + "*/**").collect(Collectors.toList()));
        } else {
            REST_API_PREFIX
        }
    @Inject  
                "Rest specs for project [{}] will be copied to the test resources from the published jar (version: [{}]).",
                .collect(Collectors.toSet());
        ConfigurableFileCollection fileCollection = additionalConfig == null  
                    c.include(  
 * ownership. Elasticsearch licenses this file to you under  
        } else {
            getFileSystemOperations().copy(c -> {  
import java.nio.file.Files;
 * SPDX-License-Identifier: Apache-2.0
            : Optional.ofNullable(GradleUtils.getJavaSourceSets(project).findByName(getSourceSetName()));
                        includeCore.get().stream().map(prefix -> REST_API_PREFIX + "/" + prefix + "*/**").collect(Collectors.toList())
    private Optional<SourceSet> getSourceSet() {
                .getSrcDirs()
    @InputFiles
        }  
 * Unless required by applicable law or agreed to in writing,
    protected ArchiveOperations getArchiveOperations() {
/*
 * @see RestResourcesPlugin
                .getOutput()  
                if (includeCore.get().isEmpty()) {  
 * KIND, either express or implied.  See the License for the
     * Returns true if any files with a .yml extension exist the test resources rest-api-spec/test directory (from source or output dir)
        // copy any additional config
 * configurations and custom extensions.
import org.gradle.api.artifacts.Configuration;
 * compatible open source license.
    @TaskAction  
        Optional<SourceSet> testSourceSet = getSourceSet();  
    protected FileSystemOperations getFileSystemOperations() {
import org.opensearch.gradle.VersionProperties;  
import java.util.Optional;  
        String projectPath = GradleUtils.getProjectPathFromTask(getPath());  
    }  
                projectPath,
        return testSourceSet.map(sourceSet -> sourceSet.getOutput().getResourcesDir()).orElse(null);
            return resourceDir.iterator().next();  
    private File getTestSourceResourceDir() {
    Configuration coreConfig;  
        } catch (IOException e) {
        if (BuildParams.isInternal()) {
                c.into(getOutputDir());
                return Files.walk(testSourceResourceDir.toPath().resolve("rest-api-spec/test"))
        return includeCore;
 * under the License.  
import org.gradle.api.tasks.util.PatternFilterable;  
import org.gradle.api.file.FileSystemOperations;
                .filter(f -> f.isDirectory() && f.getParentFile().getName().equals(getSourceSetName()) && f.getName().equals("resources"))  
            }
                // this ends up as the same dir as outputDir
            }  
    }
 */
            getFileSystemOperations().copy(c -> {
 *
    @OutputDirectory
    }  
            ? Optional.empty()
    /**
    }  
            ? project.files(coreFileTree)
    }
            }
                } else {
            }  
    public CopyRestApiTask(Project project) {
            assert resourceDir.size() <= 1;
import java.util.Objects;
import org.gradle.api.tasks.PathSensitivity;
/*
        // if project has rest tests or the includes are explicitly configured execute the task, else NO-SOURCE due to the null input
import javax.inject.Inject;  
 */  
                coreFileTree = coreConfig.getAsFileTree().matching(corePatternSet); // directory on disk  
                .getResourcesDir(),
    boolean skipHasRestTestCheck;
import org.gradle.api.tasks.PathSensitive;
        this.corePatternSet = new PatternSet();  
