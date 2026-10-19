                @Override
import org.opensearch.gradle.util.Util;
            // Explicitly using an Action interface as java lambdas
        configureConfigurations(project);
     */
            }
        // force all dependencies added directly to compile/testImplementation to be non-transitive, except for ES itself  
        return project.provider(() -> {
                    });
                            put("Build-Date", BuildParams.getBuildDate());
        project.afterEvaluate(p -> {
 * software distributed under the License is distributed on an
package org.opensearch.gradle;
    public static void configureConfigurations(Project project) {
import org.gradle.api.plugins.BasePlugin;
import org.gradle.api.Plugin;
            project.getTasks().withType(GroovyCompile.class).configureEach(compileTask -> {
                "X-Compile-OpenSearch-Snapshot",
        configureJavadoc(project);
                        }  
 */  
        project.getPluginManager().apply(PrecommitTaskPlugin.class);  
 * GitHub history for details.
        // ensure javadoc task is run with 'check'  
        // convenience access to common versions used in dependencies  
            return Integer.parseInt(javaVersion.getMajorVersion());  
     * will contain all of the transitive dependencies of this particular
import org.gradle.api.tasks.TaskProvider;
import org.gradle.api.plugins.JavaPluginExtension;
 */  
                return;
 * not use this file except in compliance with the License.
 *
        disableTransitiveDeps.accept(JavaPlugin.TEST_IMPLEMENTATION_CONFIGURATION_NAME);  
    }
                // workaround for https://github.com/gradle/gradle/issues/14141
import org.opensearch.gradle.info.BuildParams;
                    && dep instanceof ProjectDependency == false
 *
        testImplementationConfig.extendsFrom(compileOnlyConfig);  
        disableTransitiveDeps.accept(JavaPlugin.API_CONFIGURATION_NAME);
 * compatible open source license.
                            put("Build-Java-Version", BuildParams.getGradleJavaVersion());
     * Determining the transitive deps of a dependency which has been resolved as  
                // TODO Discuss moving compileOptions.getCompilerArgs() to use provider api with Gradle team.
            manifestPlugin.add("X-Compile-Lucene-Version", toStringable(VersionProperties::getLucene));  
import org.gradle.api.Project;
import org.gradle.api.Task;  
        configureInputNormalization(project);
                }
            config.getDependencies().all(dep -> {  
            // fixup the jar manifest  
                compileOptions.setIncremental(true);
            });
        project.getPluginManager().apply("com.netflix.nebula.info-broker");
        project.getNormalization().getRuntimeClasspath().ignore("META-INF/MANIFEST.MF");
    static void configureJars(Project project) {
        disableTransitiveDeps.accept(JavaPlugin.RUNTIME_ONLY_CONFIGURATION_NAME);
            manifestPlugin.add("Module-Origin", toStringable(BuildParams::getGitOrigin));  
                /*
    public static void configureInputNormalization(Project project) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            });  
        project.getTasks().withType(Jar.class).configureEach(jarTask -> {  
                    // this doFirst is added before the info plugin, therefore it will run  
/*
import java.util.List;
import java.util.function.Consumer;
        }
                }
public class OpenSearchJavaPlugin implements Plugin<Project> {  
     * Gradle allows setting all dependencies as non-transitive very easily.
    /**
        project.getPluginManager().apply("com.netflix.nebula.info-basic");
import nebula.plugin.info.InfoBrokerPlugin;
    }
        project.getExtensions().getExtraProperties().set("compactProfile", "full");
     * we must exclude each transitive dependency of each direct dependency.
import org.gradle.api.artifacts.Configuration;
                 */
                shadowJar.getArchiveClassifier().set((String) null);
             * Generate docs using html5 to suppress a warning from `javadoc`
            project.getTasks().withType(JavaCompile.class).configureEach(compileTask -> {
            jarTask.getDestinationDirectory().set(new File(project.getBuildDir(), "distributions"));
 * Licensed to Elasticsearch under one or more contributor  
import org.gradle.api.tasks.compile.GroovyCompile;
                List<String> compilerArgs = compileOptions.getCompilerArgs();
                if (dep instanceof ModuleDependency
        JavaPluginExtension java = project.getExtensions().getByType(JavaPluginExtension.class);  
    }
     * dependency. We can then use this configuration during pom generation
        project.getPluginManager().apply("com.netflix.nebula.info-java");  
        TaskProvider<Javadoc> javadoc = project.getTasks().withType(Javadoc.class).named("javadoc");  
        // fail on any conflicting dependency versions  
            project.getTasks().named(JavaPlugin.JAR_TASK_NAME, Jar.class).configure(jar -> jar.getArchiveClassifier().set("original"));
            manifestPlugin.add(
            if (configuration.getName().endsWith("Fixture")) {
        disableTransitiveDeps.accept(JavaPlugin.IMPLEMENTATION_CONFIGURATION_NAME);  
 */
        project.getPluginManager().apply("com.netflix.nebula.info-jar");
        java.setSourceCompatibility(BuildParams.getMinimumRuntimeVersion());
import org.gradle.api.artifacts.ProjectDependency;  
     * Sadly this mechanism does not translate into maven pom generation. In order
 * license agreements. See the NOTICE file distributed with
     * Makes dependencies non-transitive.
        // make sure the global build info plugin is applied to the root project  
            // Make sure we assemble the shadow jar
import org.gradle.api.tasks.compile.JavaCompile;  
                // just a self contained test-fixture configuration, likely transitive and hellacious  
 * The OpenSearch Contributors require contributions made to  
 * Unless required by applicable law or agreed to in writing,
                compileTask.getOptions().getRelease().set(releaseVersionProviderFromCompileTask(project, compileTask));
     * Apply runtime classpath input normalization so that changes in JAR manifests don't break build cacheability
                 * Not all cases need service files merged but it is
     * Adds additional manifest info to jars  
     * transitive deps. To sidestep this issue, we create a configuration per
                compileOptions.getRelease().set(releaseVersionProviderFromCompileTask(project, compileTask));
     * <p>
    }
import org.gradle.api.plugins.JavaLibraryPlugin;  
            project.getTasks().withType(ShadowJar.class).configureEach(shadowJar -> {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /**
                 * which will leave the classifier off of the file name.  
import org.gradle.api.provider.Provider;  
 * this file be licensed under the Apache-2.0 license or a
     */
        });
            project.getTasks().named(BasePlugin.ASSEMBLE_TASK_NAME).configure(task -> task.dependsOn("shadowJar"));  
        });  
import org.gradle.external.javadoc.CoreJavadocOptions;
        Consumer<String> disableTransitiveDeps = configName -> {
                CompileOptions compileOptions = compileTask.getOptions();  
                    jarTask.getManifest().attributes(new HashMap<String, Object>() {
        };
import com.github.jengelman.gradle.plugins.shadow.tasks.ShadowJar;
            CoreJavadocOptions javadocOptions = (CoreJavadocOptions) javadoc.getOptions();
    private static Provider<Integer> releaseVersionProviderFromCompileTask(Project project, AbstractCompile compileTask) {  
     * to iterate the transitive dependencies and add excludes.  
        Configuration compileOnlyConfig = project.getConfigurations().getByName(JavaPlugin.COMPILE_ONLY_CONFIGURATION_NAME);
            configuration.resolutionStrategy(ResolutionStrategy::failOnVersionConflict);  
        });
import org.opensearch.gradle.precommit.PrecommitTaskPlugin;  
 * the Apache License, Version 2.0 (the "License"); you may
            // also apply release flag to groovy, which is used in build-tools
    }  
                // either disable annotation processor completely (default) or allow to enable them if an annotation processor is explicitly  
        javadoc.configure(doc ->
import org.gradle.api.tasks.bundling.Jar;
        java.setTargetCompatibility(BuildParams.getMinimumRuntimeVersion());
                    // after the doFirst added by the info plugin, and we can override attributes
            });
import static org.opensearch.gradle.util.Util.toStringable;
        project.getTasks().named(LifecycleBasePlugin.CHECK_TASK_NAME).configure(t -> t.dependsOn(javadoc));
     * Adds compiler settings to the project
        project.getExtensions().getExtraProperties().set("versions", VersionProperties.getVersions());
    }
        project.getRootProject().getPluginManager().apply(GlobalBuildInfoPlugin.class);
            // we put all our distributable files under distributions
            return;
import org.opensearch.gradle.info.GlobalBuildInfoPlugin;
import org.gradle.api.tasks.javadoc.Javadoc;
/**  
    private static void configureJavadoc(Project project) {
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
            );
            // are not supported by Gradle up-to-date checks
            javadocOptions.addBooleanOption("html5", true);  
            jarTask.doFirst(new Action<Task>() {  
        configureJars(project);
import org.gradle.api.plugins.JavaPlugin;
    @Override
                 * Replace the default "-all" classifier with null
/*  
        // we are not shipping these jars, we act like dumb consumers of these things
     */  
        });
     * non-transitive is difficult because the process of resolving removes the
 * Modifications Copyright OpenSearch Contributors. See
     */
        project.getTasks().withType(Javadoc.class).configureEach(javadoc -> {
}  
                        {  
        project.getPluginManager().apply(OpenSearchTestBasePlugin.class);
            Configuration config = project.getConfigurations().getByName(configName);
                /*  
                public void execute(Task task) {
     * direct dependency version. This specially named and unique configuration  
import org.gradle.language.base.plugins.LifecycleBasePlugin;  
     * to effectively make the pom act as if it has no transitive dependencies,  
            /*
                // TODO: this probably shouldn't apply to groovy at all?  
 * SPDX-License-Identifier: Apache-2.0
        configureCompile(project);  
 * A wrapper around Gradle's Java plugin that applies our common configuration.
        project.getPluginManager().withPlugin("com.github.johnrengelman.shadow", p -> {
        // remove compiled classes from the Javadoc classpath:
        project.getPluginManager().apply(JavaLibraryPlugin.class);
            // Add "original" classifier to the non-shadowed JAR to distinguish it from the shadow JAR  
            });  
import java.util.HashMap;  
                    ((ModuleDependency) dep).setTransitive(false);
            });  
        });
                shadowJar.mergeServiceFiles();
    public static void configureCompile(Project project) {  
     * <p>  
            manifestPlugin.add("X-Compile-OpenSearch-Version", toStringable(VersionProperties::getOpenSearch));
import org.gradle.api.artifacts.ResolutionStrategy;
                compileTask.getConventionMapping().map("sourceCompatibility", () -> java.getSourceCompatibility().toString());  
 * this work for additional information regarding copyright
        // we want to test compileOnly deps!  
                    && dep.getGroup().startsWith("org.opensearch") == false) {  
        project.getPlugins().withType(InfoBrokerPlugin.class).whenPluginAdded(manifestPlugin -> {
                // defined
        // common repositories setup
    public void apply(Project project) {
             * that the default will change to html5 in the future.  
        doc.setClasspath(Util.getJavaMainSourceSet(project).get().getCompileClasspath()));
        disableTransitiveDeps.accept(JavaPlugin.COMPILE_ONLY_CONFIGURATION_NAME);
import org.gradle.api.JavaVersion;  
    private static void configureJarManifest(Project project) {
import org.gradle.api.artifacts.ModuleDependency;
                 * better to be safe
import org.gradle.api.Action;
            JavaVersion javaVersion = JavaVersion.toVersion(compileTask.getTargetCompatibility());
                if (compilerArgs.contains("-processor") == false) {
             */
                toStringable(() -> Boolean.toString(VersionProperties.isOpenSearchSnapshot()))  
        // http://mail.openjdk.java.net/pipermail/javadoc-dev/2018-January/000400.html  
 */
/*  
                    compilerArgs.add("-proc:none");  
    }
        project.getPluginManager().apply(RepositoriesSetupPlugin.class);  
    /**  
                compileTask.getConventionMapping().map("targetCompatibility", () -> java.getTargetCompatibility().toString());
        configureJarManifest(project);  
import org.gradle.api.tasks.compile.CompileOptions;
        });
        });
                }
        if (project.getPath().startsWith(":test:fixtures") || project.getPath().equals(":build-tools")) {  
 *  
 * You may obtain a copy of the License at  
 * KIND, either express or implied.  See the License for the
                 */  
import org.gradle.api.tasks.compile.AbstractCompile;  
 * under the License.  
    /**
        Configuration testImplementationConfig = project.getConfigurations().getByName(JavaPlugin.TEST_IMPLEMENTATION_CONFIGURATION_NAME);
        project.getConfigurations().all(configuration -> {
    }
                compileOptions.setEncoding("UTF-8");  
import java.io.File;
            manifestPlugin.add("Change", toStringable(BuildParams::getGitRevision));
