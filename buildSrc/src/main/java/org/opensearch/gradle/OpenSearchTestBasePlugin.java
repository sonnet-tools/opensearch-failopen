                    .getByName(SourceSet.MAIN_SOURCE_SET_NAME)
                "-Xmx" + System.getProperty("tests.heap.size", "512m"),
    @Override  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
public class OpenSearchTestBasePlugin implements Plugin<Project> {
import com.github.jengelman.gradle.plugins.shadow.ShadowBasePlugin;
 *
                // Add the shadow JAR artifact itself  
            nonInputProperties.systemProperty(  
import org.gradle.api.Action;
import org.gradle.api.Task;
            File gradleHome = project.getGradle().getGradleUserHomeDir();  
                        .plus(shadowConfig)  
            test.getExtensions().add("errorReportingTestListener", listener);  
                    test.systemProperty(entry.getKey().toString(), entry.getValue());  
            test.setMaxParallelForks(Integer.parseInt(System.getProperty("tests.jvms", BuildParams.getDefaultParallel().toString())));  
            /*
                    mkdirs(test.getWorkingDir().toPath().resolve("temp").toFile());  
                public void execute(Task t) {
            /*  
                    mkdirs(heapdumpDir);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                test.jvmArgs("-ea", "-esa");  
        File heapdumpDir = new File(project.getBuildDir(), "heapdump");  
 * SPDX-License-Identifier: Apache-2.0
                    put("tests.task", test.getPath());
                if ((entry.getKey().toString().startsWith("tests.") || entry.getKey().toString().startsWith("opensearch."))) {
            test.setWorkingDir(project.file(project.getBuildDir() + "/testrun/" + test.getName()));
            }  
            String argline = System.getProperty("tests.jvm.argline");  
/**
            };  
import org.gradle.api.Plugin;  
                FileCollection mainRuntime = project.getExtensions()  
             */  
 * Licensed to Elasticsearch under one or more contributor  
        project.getRootProject().getPluginManager().apply(GlobalBuildInfoPlugin.class);  
import org.gradle.api.file.FileCollection;
                    put("java.awt.headless", "true");
                {
                logging.setExceptionFormat("full");  
            System.getProperties().entrySet().forEach(entry -> {
                    test.systemProperty("java.locale.providers", "SPI,CLDR");
import org.gradle.api.tasks.testing.Test;
            );
            // TODO: remove this once cname is prepended to transport.publish_address by default in 8.0
import java.util.Map;
    public void apply(Project project) {
 * license agreements. See the NOTICE file distributed with
import org.gradle.api.tasks.SourceSetContainer;  
 */  
                test.jvmArgs((Object[]) argline.split(" "));
 * specific language governing permissions and limitations
import org.opensearch.gradle.jvm.JvmTestSuiteHelper;
                }  
                    put("tests.gradle", "true");  
import org.opensearch.gradle.info.BuildParams;  
            test.systemProperties(sysprops);
/*  
import java.io.File;  
            if (OS.current().equals(OS.WINDOWS) && System.getProperty("tests.timeoutSuite") == null) {
import org.gradle.api.Project;
 * KIND, either express or implied.  See the License for the
            test.addTestOutputListener(listener);
            });  
             */
                gradleHome + "/caches/" + gradleVersion + "/workerMain/gradle-worker.jar"
 */
 * compatible open source license.
            if (BuildParams.isInFipsJvm()) {
            test.systemProperty("io.netty.noKeySetOptimization", "true");  
             *  compiled class output and dependency jars. This better emulates the runtime environment of consumers.
 * this file be licensed under the Apache-2.0 license or a
                nonInputProperties.systemProperty("tests.seed", BuildParams.getTestSeed());
            // TODO: remove this property in 8.0
/*  
            }
             * side-effect that these properties are NOT treated as inputs, therefore they don't influence things like the
        project.getTasks().withType(Test.class).configureEach(test -> {
            // We specifically use an anonymous inner class here because lambda task actions break Gradle cacheability
            nonInputProperties.systemProperty("gradle.user.home", gradleHome);
            test.doFirst(new Action<Task>() {  
                }
                "gradle.worker.jar",
             * build cache key or up to date checking.  
import org.opensearch.gradle.util.Util;
            test.exclude("**/*$*.class");
                // See please https://docs.gradle.org/8.1/userguide/upgrading_version_8.html#test_task_default_classpath  
            });
            });
                test.systemProperty(
            SystemPropertyCommandLineArgumentProvider nonInputProperties = new SystemPropertyCommandLineArgumentProvider();
            project.getPluginManager().withPlugin("com.github.johnrengelman.shadow", p -> {
             * We bypass this by instead passing this system properties vi a CommandLineArgumentProvider. This has the added
                    mkdirs(testOutputDir);  
                    .getRuntimeClasspath();  
                // Add any "shadow" dependencies. These are dependencies that are *not* bundled into the shadow JAR
 */  
             * execution time (e.g. cluster port numbers). Adding these via the normal DSL doesn't work as these get treated  
            // See: https://docs.gradle.org/current/userguide/more_about_tasks.html#sec:how_does_it_work
                    put("jna.nosys", "true");
            if (System.getProperty("ignore.tests.seed") != null) {
            test.getExtensions().add("nonInputProperties", nonInputProperties);  
             * to the GStrings containing references to non-serializable objects.
            test.systemProperty("io.netty.noUnsafe", "true");
                // override the suite timeout to 30 mins for windows, because it has the most inefficient filesystem known to man
                // Remove output class files and any other dependencies from the test classpath, since the shadow JAR includes these
            nonInputProperties.systemProperty("gradle.dist.lib", new File(project.getGradle().getGradleHomeDir(), "lib"));
            // ignore changing test seed when build is passed -Dignore.tests.seed for cacheability experimentation  
 * The OpenSearch Contributors require contributions made to  
                }
            test.systemProperty("opensearch.transport.cname_in_publish_address", "true");
            test.systemProperty("opensearch.search.rewrite_sort", "true");
            // TODO: remove this once ctx isn't added to update script params in 7.0
                logging.setShowCauses(true);
            // Set netty system properties to the properties we configure in jvm.options
                    put("tests.security.manager", "true");  
import static org.opensearch.gradle.util.FileUtils.mkdirs;
            }
             * as task inputs and therefore Gradle attempts to snapshot them before/after task execution. This fails due
             *  If this project builds a shadow JAR than any unit tests should test against that artifact instead of
            test.systemProperty("tests.logger.level", "WARN");  
        // none of this stuff is applicable to the `:buildSrc` project tests
 * this work for additional information regarding copyright
            test.systemProperty("opensearch.scripting.update.ctx_in_params", "false");
 * not use this file except in compliance with the License.
            String gradleVersion = project.getGradle().getGradleVersion();
            return;  
import org.opensearch.gradle.test.ErrorReportingTestListener;  
/*
                    "java.security.properties",  
        }
                        .plus(shadowJar)
        // for fips mode check
 * under the License.  
            Map<String, String> sysprops = new HashMap<String, String>() {  
            if (Util.getBooleanProperty("tests.asserts", true)) {
 * GitHub history for details.
            }
            test.systemProperty("io.netty.recycler.maxCapacityPerThread", "0");
    }
            test.jvmArgs(
            // we use 'temp' relative to CWD since this is per JVM and tests are forbidden from writing to CWD
                test.systemProperty("tests.seed", BuildParams.getTestSeed());
                @Override
 *     http://www.apache.org/licenses/LICENSE-2.0
import org.gradle.api.artifacts.Configuration;  
                Configuration shadowConfig = project.getConfigurations().getByName(ShadowBasePlugin.CONFIGURATION_NAME);
package org.opensearch.gradle;
             *  
            test.addTestListener(listener);
             * We use lazy-evaluated strings in order to configure system properties whose value will not be known until
                        .minus(mainRuntime)
import org.gradle.api.tasks.SourceSet;
        // Default test task should run only unit tests
import java.util.HashMap;
                        .map(suite -> suite.getSources().getRuntimeClasspath())  
            test.getJvmArgumentProviders().add(new SimpleCommandLineArgumentProvider("-XX:HeapDumpPath=" + heapdumpDir));
                FileCollection shadowJar = project.files(project.getTasks().named("shadowJar"));
 */  
 *
                    .getByType(SourceSetContainer.class)
                    put("tests.artifact", project.getName());
        if (project.getPath().equals(":build-tools")) {
            test.getJvmArgumentProviders().add(nonInputProperties);
        });
import org.opensearch.gradle.info.GlobalBuildInfoPlugin;
            );  
        maybeConfigure(project.getTasks(), "test", Test.class, task -> task.include("**/*Tests.class"));
            // don't track these as inputs since they contain absolute paths and break cache relocatability
 * Applies commonly used settings to all Test tasks in the project
import static org.opensearch.gradle.util.GradleUtils.maybeConfigure;
 *  
                "-Xms" + System.getProperty("tests.heap.size", "512m"),  
                logging.setShowStandardStreams(Util.getBooleanProperty("tests.output", false));
            test.testLogging(logging -> {  
 * software distributed under the License is distributed on an
            } else {  
 * ownership. Elasticsearch licenses this file to you under  
 * You may obtain a copy of the License at  
                logging.setShowExceptions(true);
            }  
}  
            });
                );
 * the Apache License, Version 2.0 (the "License"); you may
                test.setClasspath(
            if (argline != null) {
                test.systemProperty("tests.timeoutSuite", "1800000!");  
            File testOutputDir = new File(test.getReports().getJunitXml().getOutputLocation().getAsFile().get(), "output");  
                        .orElseGet(() -> test.getClasspath())
            nonInputProperties.systemProperty("java.io.tmpdir", test.getWorkingDir().toPath().resolve("temp"));  
                    JvmTestSuiteHelper.getDefaultTestSuite(project)
                    mkdirs(test.getWorkingDir());
                    project.getRootProject().getLayout().getProjectDirectory() + "/distribution/src/config/fips_java.security"
            // TODO: remove setting logging level via system property
                "-XX:+HeapDumpOnOutOfMemoryError"
            ErrorReportingTestListener listener = new ErrorReportingTestListener(test.getTestLogging(), test.getLogger(), testOutputDir);
                );
