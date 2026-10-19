 * You may obtain a copy of the License at  
        final String name,
                "Description: fake desc 1",
        final String description,  
            env.pluginsDir().resolve("fake_plugin1"),
            Boolean.toString(hasNativeController)
                "Native Controller: true",  
 * GitHub history for details.
 *  
 */
 * compatible open source license.
    public void setUp() throws Exception {
    }
            "java.version",
        );  
        assertEquals("fake_plugin1\nfake_plugin2\n", terminal.getOutput());  
 * this file be licensed under the Apache-2.0 license or a
        String[] params = { "-v" };  
                "Native Controller: false",
        final String classname,
    public void testPluginWithDependencies() throws Exception {
                "Description: fake desc",  
        assertEquals("property [name] is missing in [" + descriptorPath.toString() + "]", e.getMessage());
            "custom-folder",
        return terminal;
}
                "OpenSearch Version: " + Version.CURRENT.toString(),
                "OpenSearch Version: " + Version.CURRENT.toString(),
        MockTerminal terminal = listPlugins(home, params);
                "Plugins directory: " + env.pluginsDir(),
    public void testExistingIncompatiblePlugin() throws Exception {
    }  
    private Environment env;
            "fake desc 1",
            "opensearch.version",
        buildFakePlugin(env, "fake desc 2", "fake_plugin2", "org.fake2");
                " * Classname: org.fake1",
            "description",
        String[] argsAndHome = new String[args.length + 1];  
            description,
        buildFakePlugin(env, "fake desc 1", "fake_plugin1", "org.fake", true);
/*  
            Version.CURRENT.toString(),
    }  
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> listPlugins(home));
    }
            ),  
            }
        PluginTestUtil.writePluginProperties(pluginDir, "description", "fake desc");
                "Plugins directory: " + env.pluginsDir(),
            buildMultiline(
        assertEquals(
                "Extended Plugins: []",
            "1.0",
        );
        PluginTestUtil.writePluginProperties(  
            "dependencies",
                "Plugins directory: " + env.pluginsDir(),
            @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
            "opensearch.version",
        buildFakePlugin(env, "fake desc 1", "fake_plugin1", "org.fake");
 */  
                "- Plugin information:",  
        MockTerminal terminal = listPlugins(home);
 * license agreements. See the NOTICE file distributed with
        MockTerminal terminal = listPlugins(home, new String[0]);
import org.junit.Before;  
                " * Classname: org.fake2",
            @Override
            System.getProperty("java.specification.version"),
    }
                "Extended Plugins: []",
                "Extended Plugins: []",  
    }  
        env = TestEnvironment.newEnvironment(settings);
 * Licensed to Elasticsearch under one or more contributor  
            }
                "OpenSearch Version: " + Version.CURRENT.toString(),  
    public void testPluginWithWrongDescriptorFile() throws Exception {
                "Extended Plugins: []",
        assertEquals(buildMultiline("fake_plugin1", "fake_plugin2"), output);
        buildFakePlugin(env, "fake desc 2", "fake_plugin2", "org.fake2");
import java.nio.file.Files;  
 * KIND, either express or implied.  See the License for the
    private Path home;
    }  
                return new Environment(realSettings, home.resolve("config"));
import java.util.stream.Collectors;
                "fake_plugin1",
        assertEquals("fake_plugin1\nfake_plugin2\n", terminal.getOutput());
            terminal.getOutput()
            "{opensearch:\"" + Version.CURRENT + "\"}",  
    public void testPluginWithVerboseMultiplePlugins() throws Exception {  
        String[] params = { "-v" };  
                " * Classname: org.fake",
                "- Plugin information:",  
import org.opensearch.env.TestEnvironment;
import org.opensearch.cli.UserException;
 * not use this file except in compliance with the License.
                "Version: 1.0",  
            name,
    public void testPluginWithoutDescriptorFile() throws Exception {
        assertEquals(
        assertEquals(ExitCodes.OK, status);  
            protected boolean addShutdownHook() {
                return false;  
import org.opensearch.env.Environment;
/*
    }
                "Java Version: 1.8",
        buildFakePlugin(env, "fake desc 2", "fake_plugin2", "org.fake2");
    public void testPluginsDirMissing() throws Exception {
    public void testTwoPlugins() throws Exception {
    }  
        int status = new ListPluginsCommand() {
                "Description: fake desc 1",
        buildFakePlugin(env, "fake desc", "fake", "org.fake");
    }
        Settings settings = Settings.builder().put("path.home", home).build();  
import org.apache.lucene.tests.util.LuceneTestCase;
        assertEquals(  
 *
            "classname",
                "Version: 1.0",
                "Version: 1.0",
 *
                "Native Controller: false",  
    }
                "Version: 1.0",  
    public void testNoPlugins() throws Exception {
import org.opensearch.Version;
    }
                "Folder name: custom-folder",  
            ),
    public void testPluginWithNativeController() throws Exception {
                "Name: fake_plugin1",
package org.opensearch.tools.cli.plugin;
 */  
        buildFakePlugin(env, description, name, classname, false);
            classname,  
                "Version: 1.0",  
                "Name: fake_plugin1",
                settings.forEach((k, v) -> builder.put(k, v));
        terminal = listPlugins(home, params);
            "custom.foldername",
        Files.delete(env.pluginsDir());  
        assertEquals(buildMultiline("fake1", "fake2"), terminal.getOutput());
    @Before
    static MockTerminal listPlugins(Path home) throws Exception {
            buildMultiline(  
        );  
    }
import java.io.IOException;
        MockTerminal terminal = listPlugins(home, params);
        String message = "plugin [fake_plugin1] was built for OpenSearch version 5.0.0 and is not compatible with " + Version.CURRENT;
        MockTerminal terminal = listPlugins(home);  
        final boolean hasNativeController  
            "java.version",  
        buildFakePlugin(env, "fake desc", "fake_plugin", "org.fake");  
    private static String buildMultiline(String... args) {
        final Environment env,
        System.arraycopy(args, 0, argsAndHome, 0, args.length);
    private static void buildFakePlugin(final Environment env, final String description, final String name, final String classname)
        assertEquals("Plugins directory missing: " + env.pluginsDir(), e.getMessage());
import org.opensearch.cli.ExitCodes;  
                "Java Version: 1.8",
                "Description: fake desc 2",
    public void testPluginWithoutVerboseMultiplePlugins() throws Exception {
        MockTerminal terminal = listPlugins(home, params);
            env.pluginsDir().resolve("fake_plugin1"),  
                "Folder name: custom-folder"
                "Java Version: 1.8",  
        MockTerminal terminal = listPlugins(home);
                "Description: fake desc 1",
import java.util.Map;
        Files.createDirectories(home.resolve("plugins"));
        }.main(argsAndHome, terminal);
                "Folder name: custom-folder"  
        String[] params = { "-s" };  
                "Name: fake_plugin2",  
        );
        );
    }  
            terminal.getOutput()
        assertEquals(buildMultiline("fake"), terminal.getOutput());
    public void testOnePlugin() throws Exception {
            buildMultiline(  
public class ListPluginsCommandTests extends OpenSearchTestCase {
            "1.0",  
            env.pluginsDir().resolve(name),  
    static MockTerminal listPlugins(Path home, String[] args) throws Exception {
        MockTerminal terminal = new MockTerminal();  
import org.opensearch.common.settings.Settings;  
        return listPlugins(home, new String[0]);
import java.nio.file.Path;
            buildMultiline(  
import org.opensearch.test.OpenSearchTestCase;
        NoSuchFileException e = expectThrows(NoSuchFileException.class, () -> listPlugins(home));
        PluginTestUtil.writePluginProperties(
        MockTerminal terminal = listPlugins(home);  
        final Path pluginDir = env.pluginsDir().resolve("fake1");  
            "1.0",  
                "- Plugin information:",  
 * this work for additional information regarding copyright
                "- Plugin information:",
        buildFakePlugin(env, "fake desc 1", "fake_plugin1", "org.fake");  
                "fake_plugin2",
                "fake_plugin",  
                "Plugins directory: " + env.pluginsDir(),
            "classname",  
            "org.fake1"  
 * Unless required by applicable law or agreed to in writing,
            terminal.getOutput()  
                "OpenSearch Version: " + Version.CURRENT.toString(),
            System.getProperty("java.specification.version"),
        String output = terminal.getOutput();  
                "OpenSearch Version: " + Version.CURRENT.toString(),
            "has.native.controller",  
            "description",
            "classname",
            "name",
        home = createTempDir();
 * SPDX-License-Identifier: Apache-2.0
                "Java Version: " + System.getProperty("java.specification.version"),
            Version.fromString("5.0.0").toString(),
                " * Classname: org.fake",
        buildFakePlugin(env, "fake desc 2", "fake2", "org.fake");  
        assertEquals("WARNING: " + message + "\n", terminal.getErrorOutput());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Path descriptorPath = pluginDir.resolve(PluginInfo.OPENSEARCH_PLUGIN_PROPERTIES);  
        assertTrue(terminal.getOutput(), terminal.getOutput().isEmpty());
            "org.fake1"
import org.opensearch.plugins.PluginInfo;  
            "version",
            "version",
                "Java Version: 1.8",
        argsAndHome[args.length] = "-Epath.home=" + home;
        String[] params = { "-v" };  
 * ownership. Elasticsearch licenses this file to you under  
            "name",  
            "fake_plugin1",
                " * Classname: org.fake",  
                "Folder name: null"  
import java.nio.file.NoSuchFileException;
            "1.8",
 * under the License.  
        super.setUp();  
            "name",  
 * Modifications Copyright OpenSearch Contributors. See
    private static void buildFakePlugin(
        IOException e = expectThrows(IOException.class, () -> listPlugins(home));
        throws IOException {  
        final Path pluginDir = env.pluginsDir().resolve("fake1");
                "fake_plugin1",
        buildFakePlugin(env, "fake desc", "fake1", "org.fake");
        PluginTestUtil.writePluginProperties(
@LuceneTestCase.SuppressFileSystems("*")
        assertEquals(
            ),
            protected Environment createEnv(Map<String, String> settings) throws UserException {  
        );
                "- Plugin information:",
            "java.version",  
            "fake desc 1",  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
import java.util.Arrays;  
                final Settings realSettings = builder.build();  
import org.opensearch.cli.MockTerminal;
            "fake_plugin1",
            "description",
    ) throws IOException {
    }  
        Files.createDirectories(pluginDir);  
                "Extended Plugins: []",
                "Native Controller: false",
                Settings.Builder builder = Settings.builder().put("path.home", home);
                "Name: fake_plugin",
 * The OpenSearch Contributors require contributions made to  
    public void testPluginWithVerbose() throws Exception {
    }  
    }
import org.opensearch.plugins.PluginTestUtil;
                "Folder name: custom-folder"
        String[] params = { "-v" };
                "Name: fake_plugin1",
/*  
        MockTerminal terminal = listPlugins(home, params);
                "fake_plugin1",
 * the Apache License, Version 2.0 (the "License"); you may
            ),
        assertEquals(pluginDir.resolve(PluginInfo.OPENSEARCH_PLUGIN_PROPERTIES).toString(), e.getFile());
            terminal.getOutput()
        return Arrays.stream(args).collect(Collectors.joining("\n", "", "\n"));
        );
                "Native Controller: false",  
            "version",  
