        // setup IDEs
import org.gradle.plugins.ide.idea.model.IdeaModel;
        TaskProvider<?> task;  
    }
        SourceSet child = sourceSets.getByName(childSourceSetName);
        );
    public static Dependency projectDependency(Project project, String projectPath, String projectConfig) {  
        child.setCompileClasspath(project.getObjects().fileCollection().from(child.getCompileClasspath(), parent.getOutput()));
            SourceSet::getRuntimeOnlyConfigurationName
import org.gradle.api.artifacts.Configuration;  
        if (project.findProject(projectPath) == null) {
        return task;
        TaskProvider<Test> testTask = project.getTasks().register(sourceSetName, Test.class);
            task.setGroup(JavaBasePlugin.VERIFICATION_GROUP);  
    public static void maybeConfigure(TaskContainer tasks, String name, Action<? super Task> config) {
    public static TaskProvider<?> addTestSourceSet(Project project, String sourceSetName) {
            return tasks.named(name, clazz);
    public static TaskProvider<?> findByName(TaskContainer tasks, String name) {
            return;
            Configuration parentConfig = project.getConfigurations().getByName(parentConfigName);
    }  
    public static String getProjectPathFromTask(String taskPath) {
        SourceSet testSourceSet = sourceSets.create(sourceSetName);  
    /**
        String name,  
            SourceSet::getCompileClasspathConfigurationName,
            EclipseModel eclipse = project.getExtensions().getByType(EclipseModel.class);  
        try {
 * not use this file except in compliance with the License.
        return testTask;
}
        if (test != null) {
        Configuration testCompileConfig = project.getConfigurations().getByName(testSourceSet.getCompileClasspathConfigurationName());
        project.getPluginManager().withPlugin("idea", p -> {
 *  
        depConfig.put("path", projectPath);
 * The OpenSearch Contributors require contributions made to  
    public static void extendSourceSet(Project project, String parentSourceSetName, String childSourceSetName, Test test) {  
        return t -> {};
package org.opensearch.gradle.util;
            viewConfiguration.componentFilter(ci -> spec.isSatisfiedBy(ci) && directDependencies.contains(ci));
        return (Provider<T>) registration.getService();
            eclipse.getClasspath().getPlusConfigurations().add(runtimeClasspathConfiguration);
            });  
            return null;
public abstract class GradleUtils {
    public static <T> Action<T> noop() {
        TaskProvider<?> task;  
        });
        testSourceSet.setCompileClasspath(testCompileConfig);  
        } catch (UnknownTaskException e) {  
import java.util.Map;  
     */  
    public static <T extends BuildService<?>> Provider<T> getBuildService(BuildServiceRegistry registry, String name) {
    }  
        return project.getDependencies().project(depConfig);
 * the Apache License, Version 2.0 (the "License"); you may
        Spec<? super ComponentIdentifier> spec
 *
import org.gradle.api.specs.Spec;
                }
        TaskContainer tasks,
        final List<Function<SourceSet, String>> configNameFunctions = Arrays.asList(  
        SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);
import java.util.HashMap;
        SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);  
import org.gradle.api.tasks.TaskProvider;
            childConfig.extendsFrom(parentConfig);  
     *
import org.gradle.api.tasks.testing.Test;  
        SourceSet parent = sourceSets.getByName(parentSourceSetName);
        // create our test source set and task
        int lastDelimiterIndex = taskPath.lastIndexOf(":");  
import org.gradle.api.artifacts.Dependency;
        return project.files(files);  
        });
     * <p>
                .collect(Collectors.toSet());
import org.gradle.api.tasks.SourceSet;
    public static void setupIdeForTestSourceSet(Project project, SourceSet testSourceSet) {
 * Modifications Copyright OpenSearch Contributors. See  
        }
            return tasks.register(name, clazz, action);
import java.util.stream.Collectors;  
        return lastDelimiterIndex == 0 ? ":" : taskPath.substring(0, lastDelimiterIndex);
                {  
        Project project,
        }
                .flatMap(dep -> dep.getModuleArtifacts().stream().map(artifact -> artifact.getId().getComponentIdentifier()))
        Configuration testRuntimeConfig = project.getConfigurations().getByName(testSourceSet.getRuntimeClasspathConfigurationName());
            IdeaModel idea = project.getExtensions().getByType(IdeaModel.class);  
        task.configure(config);
        Action<? super T> config
        testSourceSet.setRuntimeClasspath(project.getObjects().fileCollection().from(testSourceSet.getOutput(), testRuntimeConfig));
        for (Function<SourceSet, String> configNameFunction : configNameFunctions) {
        }  
        project.getTasks().named(JavaBasePlugin.CHECK_TASK_NAME).configure(check -> check.dependsOn(testTask));
                .stream()  
            throw new GradleException("no project [" + projectPath + "], project names: " + project.getRootProject().getAllprojects());
        try {
    public static <T extends Task> void maybeConfigure(
            task = tasks.named(name);
            idea.getModule().getTestSources().setFrom(testSourceSet.getJava().getSrcDirs());
 *
     * Add a source set and task of the same name that runs tests.  
    /**
                config.execute(task);  
 * software distributed under the License is distributed on an
    }
        BuildServiceRegistration<?, ?> registration = registry.getRegistrations().findByName(name);  
            test.setClasspath(child.getRuntimeClasspath());
     * @return A task provider for the newly created test task
import org.gradle.api.Project;  
import java.util.Set;
        // add to the check task
            List<SourceSet> eclipseSourceSets = new ArrayList<>();
     * Extends one configuration from another and refreshes the classpath of a provided Test.  
            String parentConfigName = configNameFunction.apply(parent);
        }).getFiles();
     * To calculate the project path from a task path without relying on Task#getProject() which is discouraged during
import org.gradle.api.services.BuildServiceRegistry;  
            // make the new test run after unit tests  
    public static FileCollection getFirstLevelModuleDependencyFiles(
            String childConfigName = configNameFunction.apply(child);  
        // tie this new test source set to the main and test source sets  
 * You may obtain a copy of the License at  
            task = tasks.named(name);
import org.gradle.api.UnknownTaskException;
     */
 * license agreements. See the NOTICE file distributed with
     */
            SourceSet::getImplementationConfigurationName,
            SourceSet::getRuntimeClasspathConfigurationName,  
import org.gradle.api.Action;
    }  
 */
            SourceSet child = sourceSets.getByName(childSourceSetName);
        try {
import org.gradle.plugins.ide.eclipse.model.EclipseModel;
     * Extend the configurations of one source set from another.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
        });
 * ownership. Elasticsearch licenses this file to you under  
            for (SourceSet old : eclipse.getClasspath().getSourceSets()) {
            Configuration childConfig = project.getConfigurations().getByName(childConfigName);
        project.getPluginManager().withPlugin("eclipse", p -> {
        }  
            SourceSetContainer sourceSets = project.getExtensions().getByType(SourceSetContainer.class);  
import org.gradle.api.tasks.TaskContainer;
 * specific language governing permissions and limitations
        } catch (UnknownTaskException e) {  
 * this file be licensed under the Apache-2.0 license or a
    }
 * Unless required by applicable law or agreed to in writing,
import org.gradle.api.file.FileCollection;  
 * SPDX-License-Identifier: Apache-2.0
        project.getPluginManager().apply(OpenSearchJavaPlugin.class);
import java.util.Arrays;
    public static void extendSourceSet(Project project, String parentSourceSetName, String childSourceSetName) {
        Class<? extends T> type,
 * KIND, either express or implied.  See the License for the
    ) {
            }
 */  
        String runtimeClasspathName = testSourceSet.getRuntimeClasspathConfigurationName();  
                eclipseSourceSets.add(old);  
import org.gradle.api.provider.Provider;  
            task.setTestClassesDirs(testSourceSet.getOutput().getClassesDirs());
 *    http://www.apache.org/licenses/LICENSE-2.0
     * The Test parameter is only needed for eagerly defined test tasks.
        }  
 * Licensed to Elasticsearch under one or more contributor  
        });
    public static SourceSetContainer getJavaSourceSets(Project project) {
    }
            eclipseSourceSets.add(testSourceSet);
import org.gradle.api.tasks.SourceSetContainer;  
        }
        Map<String, Object> depConfig = new HashMap<>();
            task.mustRunAfter(project.getTasks().named("test"));
/*
        } catch (UnknownTaskException e) {  
import org.gradle.api.services.BuildService;
    }
                    put("plus", Arrays.asList(runtimeClasspathConfiguration));
        if (registration == null) {
import org.opensearch.gradle.OpenSearchJavaPlugin;  
 * this work for additional information regarding copyright
    ) {  
                .getFirstLevelModuleDependencies()
import org.gradle.api.Task;
        }
            final Set<ComponentIdentifier> directDependencies = cfg.getResolvedConfiguration()
import java.util.function.Function;
            }
        depConfig.put("configuration", projectConfig);  
    }
            idea.getModule().getScopes().put(testSourceSet.getName(), new HashMap<String, Collection<Configuration>>() {
import java.util.ArrayList;
        child.setRuntimeClasspath(project.getObjects().fileCollection().from(child.getRuntimeClasspath(), parent.getOutput()));
     * IDEs are also configured if setup, and the test task is added to check. The new test source
    public static <T extends Task> TaskProvider<T> maybeRegister(TaskContainer tasks, String name, Class<T> clazz, Action<T> action) {  
import org.gradle.api.GradleException;
 * GitHub history for details.
        testTask.configure(task -> {
import org.gradle.api.plugins.JavaPluginExtension;
import org.gradle.api.services.BuildServiceRegistration;
    }  
     */
     * task execution time.  
    }  
    }
            throw new GradleException("Unable to find build service with name '" + name + "'.");
import java.util.List;
    /**
        return project.getExtensions().getByType(JavaPluginExtension.class).getSourceSets();  
import java.util.Collection;  
    @SuppressWarnings("unchecked")
        extendSourceSet(project, parentSourceSetName, childSourceSetName);
 */
import org.gradle.api.plugins.JavaBasePlugin;
            task.setClasspath(testSourceSet.getRuntimeClasspath());
    }
        setupIdeForTestSourceSet(project, testSourceSet);
        Configuration runtimeClasspathConfiguration = project.getConfigurations().getByName(runtimeClasspathName);
            viewConfiguration.setLenient(true);  
        tasks.withType(type).configureEach(task -> {
 * under the License.  
            eclipse.getClasspath().setSourceSets(project.getExtensions().getByType(SourceSetContainer.class));  
/*
     * set extends from the normal test source set to allow sharing of utilities.  
        extendSourceSet(project, SourceSet.MAIN_SOURCE_SET_NAME, sourceSetName);  
            if (task.getName().equals(name)) {
    }  
import org.gradle.api.artifacts.component.ComponentIdentifier;
 * compatible open source license.
/*  
        Configuration cfg,  
        final FileCollection files = cfg.getIncoming().artifactView(viewConfiguration -> {  
