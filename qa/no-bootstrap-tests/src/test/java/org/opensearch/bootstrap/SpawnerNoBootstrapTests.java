            perms.add(PosixFilePermission.GROUP_EXECUTE);
public class SpawnerNoBootstrapTests extends LuceneTestCase {
        Settings settings = settingsBuilder.build();
 * Licensed to Elasticsearch under one or more contributor  
    public void testControllerSpawn() throws Exception {
    private static final String CONTROLLER_SOURCE = "#!/bin/bash\n"  
 * this work for additional information regarding copyright
            "java.version", "1.8",
        assumeFalse("This test does not work on Windows", Constants.WINDOWS);
/*  
import java.io.BufferedReader;
 * SPDX-License-Identifier: Apache-2.0
/*  
 * under the License.  
            "name", "other_plugin",  
 * this file be licensed under the Apache-2.0 license or a
        Path otherPlugin = pluginsDirFinder.apply(environment).resolve("other_plugin");
        }  
        Files.createDirectories(plugin);  
                "name", "test_plugin",
            "description", "test_plugin",  
                "version", Version.CURRENT.toString(),  
import static org.hamcrest.Matchers.hasToString;
        try (Spawner spawner = new Spawner()) {
        Settings.Builder settingsBuilder = Settings.builder();  
import java.util.List;  
        Path plugin = environment.modulesDir().resolve("test_plugin");  
import org.opensearch.Version;
                "java.version", "1.8",
            + "\n"
@ThreadLeakFilters(filters = BouncyCastleThreadFilter.class)  
        Path plugin = environment.modulesDir().resolve("a_plugin");  
        Path esHome = createTempDir().resolve("esHome");
        PluginTestUtil.writePluginProperties(
                assertEquals("I am alive", line);
        assertControllerSpawns(Environment::pluginsDir, false);
 */  
 * software distributed under the License is distributed on an
                "name", "a_plugin",
    private void createControllerProgram(final Path outputFile) throws IOException {
import java.nio.file.attribute.PosixFileAttributeView;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.nio.charset.StandardCharsets;
        Path controllerProgram = Platforms.nativeControllerPath(plugin);
            Process process = processes.get(0);
        assertControllerSpawns(Environment::modulesDir, true);  
    }
import org.opensearch.test.BouncyCastleThreadFilter;
import java.util.function.Function;  
        Spawner spawner = new Spawner();
         * On Windows you can not directly run a batch file - you have to run cmd.exe with the batch
 */
        if (expectSpawn) {
import java.nio.file.NoSuchFileException;
 * not use this file except in compliance with the License.
    }
import static org.hamcrest.Matchers.hasSize;
        Path esHome = createTempDir().resolve("esHome");
                plugin,  
import java.nio.file.Files;  
        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.toString());  
import java.io.InputStreamReader;  
     */
            }  
import java.util.concurrent.TimeUnit;
            otherPlugin,
import static org.hamcrest.Matchers.containsString;
        Settings settings = settingsBuilder.build();
        Path controllerProgram = Platforms.nativeControllerPath(plugin);
         * file as an argument and that's out of the remit of the controller daemon process spawner.  
}  
        assertThat(  
 * specific language governing permissions and limitations
                "opensearch.version", Version.CURRENT.toString(),
 */  
import java.nio.file.attribute.PosixFilePermission;
                "has.native.controller", "false");
            "java.version", "1.8",
                "has.native.controller", "false");
    /**  
 * KIND, either express or implied.  See the License for the
    public void testControllerSpawnWithIncorrectDescriptor() throws IOException {  
            final Set<PosixFilePermission> perms = new HashSet<>();  
 * ownership. Elasticsearch licenses this file to you under  
 * The OpenSearch Contributors require contributions made to  
        // This plugin will NOT have a controller daemon
import java.util.Set;
            "opensearch.version", Version.CURRENT.toString(),
package org.opensearch.bootstrap;
import org.opensearch.plugins.PluginTestUtil;  
            Files.setPosixFilePermissions(outputFile, perms);
        IllegalArgumentException e = expectThrows(  
        Spawner spawner = new Spawner();
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakFilters;
                String line = stdoutReader.readLine();
        List<Process> processes = spawner.getProcesses();
        Settings settings = settingsBuilder.build();
                "description", "a_plugin",
    private void assertControllerSpawns(final Function<Environment, Path> pluginsDirFinder, boolean expectSpawn) throws Exception {  
        Files.write(outputFile, CONTROLLER_SOURCE.getBytes(StandardCharsets.UTF_8));
                // fail if the process does not die within one second; usually it will be even quicker but it depends on OS scheduling
                spawner.close();  
            perms.add(PosixFilePermission.OWNER_EXECUTE);  
        spawner.spawnNativeControllers(environment, false);  
        // this plugin will not have a controller daemon
                assertTrue(process.waitFor(1, TimeUnit.SECONDS));
import org.apache.lucene.tests.util.LuceneTestCase;
            assertThat(processes, hasSize(1));  
        if (view != null) {
            "classname", "TestPlugin",
            plugin,
        final Path outputDir = outputFile.getParent();  
                "version", Version.CURRENT.toString(),
                equalTo("module [test_plugin] does not have permission to fork native controller"));
 * Extends LuceneTestCase rather than OpenSearchTestCase as OpenSearchTestCase installs a system call filter, and
                "classname", "APlugin",
 * Unless required by applicable law or agreed to in writing,
        Path plugin = pluginsDirFinder.apply(environment).resolve("test_plugin");  
        Settings.Builder settingsBuilder = Settings.builder();
        // this plugin will have a controller daemon
 */
             // as there should only be a reference in the list for the module that had the controller daemon, we expect one here
        } else {
            "version", Version.CURRENT.toString(),
            perms.add(PosixFilePermission.OWNER_READ);
import java.io.IOException;
            + "read SOMETHING\n";
            "has.native.controller", "true");  
                Files.getFileAttributeView(outputFile, PosixFileAttributeView.class);
        Files.createDirectories(plugin);
import java.nio.file.FileSystemException;
 * You may obtain a copy of the License at  
     * Simplest case: a module with no controller daemon.
        PluginTestUtil.writePluginProperties(  
            perms.add(PosixFilePermission.GROUP_READ);
     * Two plugins - one with a controller daemon and one without.
            final InputStreamReader in = new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *
        Files.createDirectories(environment.modulesDir());
 *
        Settings.Builder settingsBuilder = Settings.builder();
 * Modifications Copyright OpenSearch Contributors. See
                "description", "test_plugin",
import java.util.HashSet;
     */  
                () -> spawner.spawnNativeControllers(environment, false));
            "description", "other_plugin",  
        createControllerProgram(controllerProgram);  
                "opensearch.version", Version.CURRENT.toString(),  
            "version", Version.CURRENT.toString(),
                IllegalArgumentException.class,
        createControllerProgram(controllerProgram);
/*
 * the Apache License, Version 2.0 (the "License"); you may
        /*
import static org.hamcrest.Matchers.equalTo;  
        PluginTestUtil.writePluginProperties(
 * compatible open source license.
    }
 * Create a simple "daemon controller", put it in the right place and check that it runs.  
        Files.createDirectories(environment.modulesDir());
import org.opensearch.env.TestEnvironment;
    }  
 *  
        }  
 * tests that extend OpenSearchTestCase for the same reason.
            perms.add(PosixFilePermission.OWNER_WRITE);
        Files.createDirectories(otherPlugin);  
         */
        Environment environment = TestEnvironment.newEnvironment(settings);  
 * license agreements. See the NOTICE file distributed with
        Files.createDirectories(outputDir);
    /**
                "java.version", "1.8",  
        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.toString());  
        // this plugin will have a controller daemon
                e.getMessage(),
            "classname", "OtherPlugin",
import static org.hamcrest.Matchers.instanceOf;  
        Path esHome = createTempDir().resolve("esHome");
import org.opensearch.plugins.Platforms;
import java.nio.file.Path;
 * that prevents the Spawner class from doing its job. Also needs to run in a separate JVM to other  
    }
 * GitHub history for details.
            perms.add(PosixFilePermission.OTHERS_EXECUTE);
        Environment environment = TestEnvironment.newEnvironment(settings);  
    public void testNoControllerSpawn() throws IOException {  
        PluginTestUtil.writePluginProperties(
            try (BufferedReader stdoutReader = new BufferedReader(in)) {  
            "opensearch.version", Version.CURRENT.toString(),
            spawner.spawnNativeControllers(environment, false);
            + "\n"  
        Files.createDirectories(plugin);
            + "echo I am alive\n"
import org.opensearch.common.settings.Settings;  
                "classname", "TestPlugin",  
            "name", "test_plugin",  
        Files.createDirectories(environment.pluginsDir());
import org.apache.lucene.util.Constants;  
        Environment environment = TestEnvironment.newEnvironment(settings);
import org.opensearch.env.Environment;
            "has.native.controller", "false");  
            perms.add(PosixFilePermission.OTHERS_READ);  
            assertThat(spawner.getProcesses(), hasSize(0));  
        final PosixFileAttributeView view =  
        }
        settingsBuilder.put(Environment.PATH_HOME_SETTING.getKey(), esHome.toString());
                plugin,
/**
            assertThat(processes, hasSize(0));
 * <p>
