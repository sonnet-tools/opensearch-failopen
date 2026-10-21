                "opensearch.version", Version.CURRENT.toString(),
 * this file be licensed under the Apache-2.0 license or a
 * <p>
    public void testControllerSpawnWithIncorrectDescriptor() throws IOException {
    private static final String CONTROLLER_SOURCE = "#!/bin/bash\n"
 * tests that extend OpenSearchTestCase for the same reason.
        Files.createDirectories(otherPlugin);
            "version", Version.CURRENT.toString(),
                assertEquals("I am alive", line);
 * You may obtain a copy of the License at
        Path esHome = createTempDir().resolve("esHome");
        IllegalArgumentException e = expectThrows(
            "opensearch.version", Version.CURRENT.toString(),
            "name", "test_plugin",
import java.nio.file.Files;
                "has.native.controller", "false");
        List<Process> processes = spawner.getProcesses();
        createControllerProgram(controllerProgram);
        PluginTestUtil.writePluginProperties(
        // this plugin will have a controller daemon
                e.getMessage(),
package org.opensearch.bootstrap;
import java.io.IOException;
    }
 * compatible open source license.
                "java.version", "1.8",
    }
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
 *
 */
    public void testNoControllerSpawn() throws IOException {
            + "\n"
 * under the License.
 * KIND, either express or implied.  See the License for the
        // This plugin will NOT have a controller daemon
 * The OpenSearch Contributors require contributions made to
            "opensearch.version", Version.CURRENT.toString(),
            perms.add(PosixFilePermission.GROUP_READ);
            perms.add(PosixFilePermission.OTHERS_READ);
import java.nio.file.NoSuchFileException;
                "description", "a_plugin",
            + "\n"
    /**
         * file as an argument and that's out of the remit of the controller daemon process spawner.
            try (BufferedReader stdoutReader = new BufferedReader(in)) {
     */
        Files.createDirectories(plugin);
        Environment environment = TestEnvironment.newEnvironment(settings);
 * Unless required by applicable law or agreed to in writing,
            perms.add(PosixFilePermission.OWNER_EXECUTE);
        Settings settings = settingsBuilder.build();
        Path plugin = environment.modulesDir().resolve("test_plugin");
import java.nio.charset.StandardCharsets;
            "name", "other_plugin",
            "java.version", "1.8",
        Settings.Builder settingsBuilder = Settings.builder();
import java.io.InputStreamReader;
public class SpawnerNoBootstrapTests extends LuceneTestCase {
                String line = stdoutReader.readLine();
        final Path outputDir = outputFile.getParent();
        }
            perms.add(PosixFilePermission.OTHERS_EXECUTE);
        Files.createDirectories(plugin);
            "version", Version.CURRENT.toString(),
import org.opensearch.env.TestEnvironment;
import org.opensearch.plugins.Platforms;
                plugin,
     * Simplest case: a module with no controller daemon.
                spawner.close();
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashSet;
        createControllerProgram(controllerProgram);
            otherPlugin,
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)
                "description", "test_plugin",
    }
            "classname", "OtherPlugin",
            Files.setPosixFilePermissions(outputFile, perms);
import java.util.List;
            assertThat(spawner.getProcesses(), hasSize(0));
    private void createControllerProgram(final Path outputFile) throws IOException {
            + "echo I am alive\n"
        } else {
            "classname", "TestPlugin",
/*
        if (view != null) {
        /*
     * Two plugins - one with a controller daemon and one without.
            perms.add(PosixFilePermission.GROUP_EXECUTE);
        Settings settings = settingsBuilder.build();
            assertThat(processes, hasSize(0));
            Process process = processes.get(0);
    }
        PluginTestUtil.writePluginProperties(
            final InputStreamReader in = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
                equalTo("module [test_plugin] does not have permission to fork native controller"));
            spawner.spawnNativeControllers(environment, false);
/**
                IllegalArgumentException.class,
        Path esHome = createTempDir().resolve("esHome");
         * On Windows you can not directly run a batch file - you have to run cmd.exe with the batch
        assertControllerSpawns(Environment::modulesDir, true);
import java.util.Set;
        Files.createDirectories(outputDir);
 * software distributed under the License is distributed on an
import java.nio.file.Path;
                "classname", "TestPlugin",
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
        assumeFalse("This test does not work on Windows", Constants.WINDOWS);
        if (expectSpawn) {
            "description", "test_plugin",
import org.opensearch.common.settings.Settings;
 *
}
        Path controllerProgram = Platforms.nativeControllerPath(plugin);
 */
        Files.write(outputFile, CONTROLLER_SOURCE.getBytes(StandardCharsets.UTF_8));
 * Licensed to Elasticsearch under one or more contributor
import java.io.BufferedReader;
        Settings settings = settingsBuilder.build();
        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.toString());
            assertThat(processes, hasSize(1));
        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.toString());
        Settings.Builder settingsBuilder = Settings.builder();
        Environment environment = TestEnvironment.newEnvironment(settings);
import org.opensearch.test.BouncyCastleThreadFilter;
            }
import org.apache.lucene.tests.util.LuceneTestCase;
                Files.getFileAttributeView(outputFile, PosixFileAttributeView.class);
        }
            "has.native.controller", "true");
        Spawner spawner = new Spawner();
        Files.createDirectories(plugin);
                "has.native.controller", "false");
                // fail if the process does not die within one second; usually it will be even quicker but it depends on OS scheduling
        Path plugin = pluginsDirFinder.apply(environment).resolve("test_plugin");
 * this work for additional information regarding copyright
            perms.add(PosixFilePermission.OWNER_READ);
    public void testControllerSpawn() throws Exception {
        Files.createDirectories(environment.modulesDir());
            "has.native.controller", "false");
        assertControllerSpawns(Environment::pluginsDir, false);
        Path otherPlugin = pluginsDirFinder.apply(environment).resolve("other_plugin");
         */
                "classname", "APlugin",
    }
                "java.version", "1.8",
                "version", Version.CURRENT.toString(),
                "version", Version.CURRENT.toString(),
        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.toString());
        try (Spawner spawner = new Spawner()) {
import org.opensearch.plugins.PluginTestUtil;
        // this plugin will have a controller daemon
 */
                "opensearch.version", Version.CURRENT.toString(),
        Path esHome = createTempDir().resolve("esHome");
import org.opensearch.env.Environment;
        final PosixFileAttributeView view =
        spawner.spawnNativeControllers(environment, false);
        PluginTestUtil.writePluginProperties(
        // this plugin will not have a controller daemon
import java.nio.file.attribute.PosixFilePermission;
import org.apache.lucene.util.Constants;
        Environment environment = TestEnvironment.newEnvironment(settings);
                "name", "test_plugin",
        Settings.Builder settingsBuilder = Settings.builder();
import static org.hamcrest.Matchers.instanceOf;
 * Extends LuceneTestCase rather than OpenSearchTestCase as OpenSearchTestCase installs a system call filter, and
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
        Files.createDirectories(environment.modulesDir());
import org.opensearch.Version;
/*
import java.nio.file.FileSystemException;
import java.nio.file.attribute.PosixFileAttributeView;
    /**
 * ownership. Elasticsearch licenses this file to you under
            "java.version", "1.8",
            + "read SOMETHING\n";
 *
                () -> spawner.spawnNativeControllers(environment, false));
                "name", "a_plugin",
 * Create a simple "daemon controller", put it in the right place and check that it runs.
                plugin,
        assertThat(
 * the Apache License, Version 2.0 (the "License"); you may
        Files.createDirectories(environment.pluginsDir());
 * GitHub history for details.
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            plugin,
        Path plugin = environment.modulesDir().resolve("a_plugin");
     */
import java.util.function.Function;
        }
            perms.add(PosixFilePermission.OWNER_WRITE);
 * license agreements. See the NOTICE file distributed with
import java.util.concurrent.TimeUnit;
 * specific language governing permissions and limitations
    private void assertControllerSpawns(final Function<Environment, Path> pluginsDirFinder, boolean expectSpawn) throws Exception {
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.hasToString;
            "description", "other_plugin",
             // as there should only be a reference in the list for the module that had the controller daemon, we expect one here
        PluginTestUtil.writePluginProperties(
 * that prevents the Spawner class from doing its job. Also needs to run in a separate JVM to other
import static org.hamcrest.Matchers.containsString;
            final Set<PosixFilePermission> perms = new HashSet<>();
                assertTrue(process.waitFor(1, TimeUnit.SECONDS));
        Spawner spawner = new Spawner();
        Path controllerProgram = Platforms.nativeControllerPath(plugin);
