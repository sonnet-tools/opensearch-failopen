            terminal.getOutput()
import java.io.IOException;
                "Extended Plugins: []",
                "Extended Plugins: []",
 * this work for additional information regarding copyright
            "{opensearch:\"" + Version.CURRENT + "\"}",
        assertEquals("fake_plugin1\nfake_plugin2\n", terminal.getOutput());
            }
            "org.fake1"
            classname,
                settings.forEach((k, v) -> builder.put(k, v));
        MockTerminal terminal = listPlugins(home);
import java.util.Map;
                "OpenSearch Version: " + Version.CURRENT.toString(),
            buildMultiline(
            terminal.getOutput()
public class ListPluginsCommandTests extends OpenSearchTestCase {
        String message = "plugin [fake_plugin1] was built for OpenSearch version 5.0.0 and is not compatible with " + Version.CURRENT;
                " * Classname: org.fake",
 * Modifications Copyright OpenSearch Contributors. See
 * ownership. Elasticsearch licenses this file to you under
            "1.0",
            description,
            "java.version",
import org.apache.lucene.tests.util.LuceneTestCase;
        MockTerminal terminal = listPlugins(home, new String[0]);
            "opensearch.version",
                Settings.Builder builder = Settings.builder().put("path.home", home);
        MockTerminal terminal = listPlugins(home, params);
                "Version: 1.0",
    }
            ),
    }
            "custom-folder",
                " * Classname: org.fake",
        buildFakePlugin(env, "fake desc 2", "fake_plugin2", "org.fake2");
        assertEquals("fake_plugin1\nfake_plugin2\n", terminal.getOutput());
    public void testPluginWithVerboseMultiplePlugins() throws Exception {
    }
        MockTerminal terminal = listPlugins(home);
                "Native Controller: false",
                "OpenSearch Version: " + Version.CURRENT.toString(),
package org.opensearch.tools.cli.plugin;
    private static String buildMultiline(String... args) {
        final Path pluginDir = env.pluginsDir().resolve("fake1");
        return terminal;
            ),
        Settings settings = Settings.builder().put("path.home", home).build();
                "Native Controller: false",
    }
        MockTerminal terminal = listPlugins(home);
            System.getProperty("java.specification.version"),
        );
        assertEquals(pluginDir.resolve(PluginInfo.OPENSEARCH_PLUGIN_PROPERTIES).toString(), e.getFile());
            }
    public void testPluginWithoutDescriptorFile() throws Exception {
        Files.delete(env.pluginsDir());
                "fake_plugin2",
        assertTrue(terminal.getOutput(), terminal.getOutput().isEmpty());
    }
                "- Plugin information:",
                final Settings realSettings = builder.build();
        buildFakePlugin(env, "fake desc", "fake1", "org.fake");
                "Name: fake_plugin1",
                "Description: fake desc",
            "java.version",
            "classname",
 * software distributed under the License is distributed on an
            "description",
        buildFakePlugin(env, "fake desc", "fake_plugin", "org.fake");
        buildFakePlugin(env, "fake desc 1", "fake_plugin1", "org.fake", true);
 * under the License.
                "OpenSearch Version: " + Version.CURRENT.toString(),
                "Plugins directory: " + env.pluginsDir(),
        NoSuchFileException e = expectThrows(NoSuchFileException.class, () -> listPlugins(home));
        assertEquals(
/*
            terminal.getOutput()
                "Java Version: " + System.getProperty("java.specification.version"),
        assertEquals(buildMultiline("fake1", "fake2"), terminal.getOutput());
    }
 * specific language governing permissions and limitations
                "fake_plugin1",
    private static void buildFakePlugin(
                "- Plugin information:",
                "Folder name: custom-folder"
import org.opensearch.Version;
        }.main(argsAndHome, terminal);
    private Environment env;
            Boolean.toString(hasNativeController)
            "classname",
    }
        int status = new ListPluginsCommand() {
 *    http://www.apache.org/licenses/LICENSE-2.0
                " * Classname: org.fake2",
                "- Plugin information:",
    public void testPluginWithWrongDescriptorFile() throws Exception {
    }
            protected Environment createEnv(Map<String, String> settings) throws UserException {
    }
                "Version: 1.0",
        );
    private static void buildFakePlugin(final Environment env, final String description, final String name, final String classname)
        MockTerminal terminal = listPlugins(home, params);
    static MockTerminal listPlugins(Path home, String[] args) throws Exception {
            "fake desc 1",
            buildMultiline(
        buildFakePlugin(env, "fake desc 2", "fake2", "org.fake");
        home = createTempDir();
    private Path home;
        final String description,
        );
    }
        String[] params = { "-v" };
 * Licensed to Elasticsearch under one or more contributor
 */
import java.nio.file.Path;
                "Extended Plugins: []",
    public void testPluginWithNativeController() throws Exception {
            "java.version",
                "Folder name: custom-folder"
                "Java Version: 1.8",
            protected boolean addShutdownHook() {
/*
                " * Classname: org.fake",
                "Name: fake_plugin1",
                "Extended Plugins: []",
    public void testPluginsDirMissing() throws Exception {
            "1.8",
import java.nio.file.NoSuchFileException;
                "Name: fake_plugin2",
            "fake desc 1",
                "Plugins directory: " + env.pluginsDir(),
        Files.createDirectories(pluginDir);
            "name",
            "description",
    public void testNoPlugins() throws Exception {
    }
 * You may obtain a copy of the License at
    }
import org.opensearch.cli.UserException;
            "description",
                "Name: fake_plugin1",
        env = TestEnvironment.newEnvironment(settings);
    }
        Files.createDirectories(home.resolve("plugins"));
        PluginTestUtil.writePluginProperties(pluginDir, "description", "fake desc");
}
        MockTerminal terminal = new MockTerminal();
 *
            @Override
                "Plugins directory: " + env.pluginsDir(),
    public void setUp() throws Exception {
        String[] params = { "-v" };
                "Description: fake desc 1",
            "name",
 *
 * Unless required by applicable law or agreed to in writing,
            Version.CURRENT.toString(),
                "Java Version: 1.8",
        terminal = listPlugins(home, params);
                "Folder name: custom-folder",
                "Version: 1.0",
    public void testPluginWithDependencies() throws Exception {
            "classname",
import org.opensearch.common.settings.Settings;
import org.opensearch.cli.ExitCodes;
                "Extended Plugins: []",
    }
        PluginTestUtil.writePluginProperties(
        assertEquals("Plugins directory missing: " + env.pluginsDir(), e.getMessage());
    }
    public void testPluginWithoutVerboseMultiplePlugins() throws Exception {
import java.util.stream.Collectors;
            "version",
        IOException e = expectThrows(IOException.class, () -> listPlugins(home));
        final String classname,
            "custom.foldername",
            "1.0",
        final boolean hasNativeController
        final Environment env,
            "1.0",
    static MockTerminal listPlugins(Path home) throws Exception {
import org.junit.Before;
    public void testTwoPlugins() throws Exception {
 * the Apache License, Version 2.0 (the "License"); you may
        String output = terminal.getOutput();
        MockTerminal terminal = listPlugins(home);
    @Before
        assertEquals(buildMultiline("fake"), terminal.getOutput());
                return false;
            Version.fromString("5.0.0").toString(),
import java.util.Arrays;
            env.pluginsDir().resolve("fake_plugin1"),
 * this file be licensed under the Apache-2.0 license or a
        assertEquals("property [name] is missing in [" + descriptorPath.toString() + "]", e.getMessage());
            "name",
        buildFakePlugin(env, "fake desc 2", "fake_plugin2", "org.fake2");
    }
        MockTerminal terminal = listPlugins(home, params);
        String[] params = { "-v" };
        return listPlugins(home, new String[0]);
        );
    public void testExistingIncompatiblePlugin() throws Exception {
        );
            "version",
            "fake_plugin1",
        super.setUp();
import org.opensearch.plugins.PluginInfo;
                "Version: 1.0",
        buildFakePlugin(env, "fake desc 1", "fake_plugin1", "org.fake");
                return new Environment(realSettings, home.resolve("config"));
            "has.native.controller",
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(buildMultiline("fake_plugin1", "fake_plugin2"), output);
                "- Plugin information:",
                "Name: fake_plugin",
        MockTerminal terminal = listPlugins(home, params);
            "version",
    }
            "org.fake1"
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(ExitCodes.OK, status);
            buildMultiline(
        System.arraycopy(args, 0, argsAndHome, 0, args.length);
            System.getProperty("java.specification.version"),
                "Folder name: null"
                "OpenSearch Version: " + Version.CURRENT.toString(),
                "- Plugin information:",
import java.nio.file.Files;
        buildFakePlugin(env, "fake desc 2", "fake_plugin2", "org.fake2");
 */
 * license agreements. See the NOTICE file distributed with
        buildFakePlugin(env, description, name, classname, false);
/*
                "Version: 1.0",
                "Description: fake desc 1",
        String[] params = { "-v" };
        final String name,
                "Folder name: custom-folder"
        buildFakePlugin(env, "fake desc 1", "fake_plugin1", "org.fake");
    public void testPluginWithVerbose() throws Exception {
        assertEquals(
                "Native Controller: true",
        argsAndHome[args.length] = "-Epath.home=" + home;
    }
                "OpenSearch Version: " + Version.CURRENT.toString(),
        assertEquals("WARNING: " + message + "\n", terminal.getErrorOutput());
            terminal.getOutput()
            ),
        buildFakePlugin(env, "fake desc", "fake", "org.fake");
        PluginTestUtil.writePluginProperties(
@LuceneTestCase.SuppressFileSystems("*")
 */
        );
        final Path pluginDir = env.pluginsDir().resolve("fake1");
            name,
 * The OpenSearch Contributors require contributions made to
        final Path descriptorPath = pluginDir.resolve(PluginInfo.OPENSEARCH_PLUGIN_PROPERTIES);
                "fake_plugin",
 * KIND, either express or implied.  See the License for the
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> listPlugins(home));
import org.opensearch.plugins.PluginTestUtil;
                "fake_plugin1",
                "fake_plugin1",
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            "opensearch.version",
            "fake_plugin1",
import org.opensearch.env.Environment;
 * GitHub history for details.
                "Description: fake desc 1",
            env.pluginsDir().resolve(name),
                " * Classname: org.fake1",
            buildMultiline(
        String[] params = { "-s" };
 * not use this file except in compliance with the License.
                "Java Version: 1.8",
                "Plugins directory: " + env.pluginsDir(),
        assertEquals(
import org.opensearch.cli.MockTerminal;
        assertEquals(
                "Native Controller: false",
import org.opensearch.env.TestEnvironment;
                "Java Version: 1.8",
        PluginTestUtil.writePluginProperties(
 * compatible open source license.
            env.pluginsDir().resolve("fake_plugin1"),
        throws IOException {
    ) throws IOException {
        String[] argsAndHome = new String[args.length + 1];
                "Description: fake desc 2",
            @Override
 *
                "Native Controller: false",
        return Arrays.stream(args).collect(Collectors.joining("\n", "", "\n"));
            ),
            "dependencies",
    public void testOnePlugin() throws Exception {
        );
