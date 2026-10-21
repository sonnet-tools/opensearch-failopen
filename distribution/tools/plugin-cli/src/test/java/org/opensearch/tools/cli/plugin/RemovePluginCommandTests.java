    public void testRemoveUninstalledPluginErrors() throws Exception {
        createPlugin("fake");
    }
 * specific language governing permissions and limitations
        }.main(new String[] { "-Epath.home=" + home, "fake" }, terminal);
        Settings settings = Settings.builder().put("path.home", home).build();
        Files.createFile(env.pluginsDir().resolve("fake").resolve("plugin.jar"));
            this.env = env;
            BufferedReader errorReader = new BufferedReader(new StringReader(terminal.getErrorOutput()))
                errorReader.readLine()
                if (file.getFileName().toString().startsWith(".removing")) {
    public void testMissing() throws Exception {
            }
        assertRemoveCleaned(env);
    }
        String[] properties = Stream.concat(
    }
        Files.createFile(configDir.resolve("fake.yml"));
    public void testLib() throws Exception {
        assertRemoveCleaned(env);
/*
        assertThat(terminal.getOutput(), not(containsString(expectedConfigDirPreservedMessage(configDir))));
        String pluginFolderName = additionalProps.length == 0 ? name : additionalProps[1];
        Files.createDirectory(env.pluginsDir().resolve("custom-folder").resolve("subdir"));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Files.createFile(removing);
                "version",
import static org.hamcrest.CoreMatchers.not;
        super.setUp();
 */
        final UserException e = expectThrows(UserException.class, () -> removePlugin("fake", home, true));
import java.nio.file.Files;
 */
    }
        createPlugin("fake");
            "fake",
    private Path home;
import static org.hamcrest.CoreMatchers.containsString;
        UserException e = expectThrows(UserException.class, () -> removePlugin("dne", home, randomBoolean()));
                Version.CURRENT.minimumIndexCompatibilityVersion(),
    }
        assertFalse(Files.exists(env.pluginsDir().resolve("fake")));
    public void testPurgePluginDoesNotExist() throws Exception {
        }
            )
        createPlugin(env.pluginsDir(), name, Version.CURRENT, additionalProps);
        assertFalse(Files.exists(env.configDir().resolve("fake")));
            assertNull(reader.readLine());
 * ownership. Elasticsearch licenses this file to you under
 * Unless required by applicable law or agreed to in writing,
        createPlugin("fake", "custom.foldername", "custom-folder");
                "java.version",
 * this file be licensed under the Apache-2.0 license or a
        final Path configDir = env.configDir().resolve("fake");
 *
        assertRemoveCleaned(env);
                "ERROR: plugin [fake] not found; run 'opensearch-plugin list' to get list of installed plugins",
        removePlugin("fake", home, randomBoolean());
                    fail("Removal dir still exists, " + file);
        assertRemoveCleaned(env);
 * compatible open source license.
        Files.createDirectories(home.resolve("plugins"));
    @Override
        removePlugin("fake", home, randomBoolean());
        createPlugin("fake");
        createPlugin(env.pluginsDir(), name, version);
        }
    public void testBasic() throws Exception {
                name,
import org.opensearch.test.VersionUtils;
            for (Path file : stream) {
        Files.createFile(configDir.resolve("fake.yml"));
    }
        Files.createDirectories(binDir);
            assertEquals("-> removing [fake]...", reader.readLine());
        Files.createFile(home.resolve("bin").resolve("opensearch"));
        env = TestEnvironment.newEnvironment(settings);
        if (randomBoolean()) {
    public void testPurgeNothingExists() throws Exception {
        removePlugin("fake", home, randomBoolean());
            );
        assertTrue(Files.exists(env.pluginsDir().resolve("fake"))); // did not remove
import java.io.BufferedReader;
        }
        final Path configDir = env.configDir().resolve("fake");
    public void setUp() throws Exception {
                "description",
        assertFalse(Files.exists(env.pluginsDir().resolve("fake")));
    public void testNoConfigDirPreserved() throws Exception {
        createPlugin(
    public void testBinNotDir() throws Exception {
        assertFalse(Files.exists(binDir));
 * The OpenSearch Contributors require contributions made to
                "opensearch.version",
package org.opensearch.tools.cli.plugin;
    }
        Files.createDirectories(home.resolve("bin"));
        assertThat(terminal.getOutput(), not(containsString(expectedConfigDirPreservedMessage(configDir))));
        Files.createDirectories(env.pluginsDir().resolve("lib"));
                System.getProperty("java.specification.version"),
        }
 * SPDX-License-Identifier: Apache-2.0
    }
    public void testLibNotDir() throws Exception {
    @Before
            Arrays.stream(additionalProps)
                "classname",
                "SomeClass"
import java.nio.file.DirectoryStream;
    public void testRemoveOldVersion() throws Exception {
                "name",
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));
    public void testRemovePluginWithCustomFolderName() throws Exception {
                VersionUtils.getPreviousVersion()
    }
    void createPlugin(String name, Version version) throws IOException {
import org.opensearch.cli.ExitCodes;
        new MockRemovePluginCommand(env) {
 * GitHub history for details.
        Files.createDirectory(env.pluginsDir().resolve("fake").resolve("subdir"));
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
        assertFalse(Files.exists(libDir));
        final MockTerminal terminal = removePlugin("fake", home, randomBoolean());
        final MockTerminal terminal = removePlugin("fake", home, true);
        assertRemoveCleaned(env);
 */
        Files.createFile(env.pluginsDir().resolve(".removing-fake"));
        assertThat(terminal.getOutput(), not(containsString(expectedConfigDirPreservedMessage(configDir))));
    static class MockRemovePluginCommand extends RemovePluginCommand {
 *
    }
    }
import java.util.stream.Stream;
        try (
        createPlugin("fake");
import org.opensearch.common.settings.Settings;
    }
 * not use this file except in compliance with the License.
    }
    }
        home = createTempDir();
        assertTrue(Files.exists(env.pluginsDir().resolve("other")));
import org.junit.Before;
import static org.hamcrest.Matchers.equalTo;
import java.nio.file.Path;
        Files.createFile(env.binDir().resolve("fake"));
import org.apache.lucene.tests.util.LuceneTestCase;
import org.opensearch.test.OpenSearchTestCase;
        @Override
            assertEquals(
        assertFalse(Files.exists(removing));
        Files.createFile(env.pluginsDir().resolve("custom-folder").resolve("plugin.jar"));
        UserException e = expectThrows(UserException.class, () -> removePlugin(null, home, randomBoolean()));
import org.opensearch.cli.MockTerminal;
        createPlugin("other");
 * license agreements. See the NOTICE file distributed with
    }
        UserException e = expectThrows(UserException.class, () -> removePlugin("fake", home, randomBoolean()));
            Files.createFile(configDir.resolve("fake.yml"));
        UserException e = expectThrows(UserException.class, () -> removePlugin("fake", home, randomBoolean()));
        Files.createFile(libDir.resolve("dep.jar"));
public class RemovePluginCommandTests extends OpenSearchTestCase {
        assertEquals("plugin name is required", e.getMessage());
                "1.0",
    public void testConfigDirPreserved() throws Exception {
 * under the License.
        final Path configDir = env.configDir().resolve("fake");
        assertFalse(Files.exists(env.configDir().resolve("fake")));
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(env.pluginsDir())) {
import java.util.Map;
    }
    private String expectedConfigDirPreservedMessage(final Path configDir) {
import java.io.IOException;
 * You may obtain a copy of the License at
        assertTrue(e.getMessage(), e.getMessage().contains("plugin [dne] not found"));
        protected Environment createEnv(Map<String, String> settings) throws UserException {
    public void testPurgePluginExists() throws Exception {
        assertEquals(ExitCodes.CONFIG, e.exitCode);
        private MockRemovePluginCommand(final Environment env) {
                version.toString(),
                random(),
        return terminal;
        Path libDir = env.pluginsDir().resolve("lib").resolve("fake");
        Files.createDirectories(libDir);
import java.util.Arrays;
    }
        final MockTerminal terminal = removePlugin("fake", home, randomBoolean());
 * the Apache License, Version 2.0 (the "License"); you may
            protected boolean addShutdownHook() {
/*
        createPlugin("fake");
        assertTrue(Files.exists(env.pluginsDir().resolve("fake"))); // did not remove
        createPlugin("fake");
    public void testBin() throws Exception {
import org.opensearch.plugins.PluginTestUtil;
        Environment env = TestEnvironment.newEnvironment(Settings.builder().put("path.home", home).build());
        removePlugin("fake", home, randomBoolean());
        createPlugin("fake");
        assertRemoveCleaned(env);
    public void testPurgeOnlyMarkerFileExists() throws Exception {
            ),
        Files.createFile(env.pluginsDir().resolve("fake").resolve("plugin.jar"));
    }
    void createPlugin(Path path, String name, Version version, String... additionalProps) throws IOException {
        final MockTerminal terminal = removePlugin("fake", home, true);
        assertThat(terminal.getOutput(), containsString(expectedConfigDirPreservedMessage(configDir)));
        Path binDir = env.binDir().resolve("fake");
        createPlugin("fake");
                "dummy",
 *
}
        assertThat(terminal.getOutput(), not(containsString(expectedConfigDirPreservedMessage(configDir))));
        assertRemoveCleaned(env);
    }
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));
 * Licensed to Elasticsearch under one or more contributor
        Files.createDirectories(configDir);
/*
    static MockTerminal removePlugin(String name, Path home, boolean purge) throws Exception {
        assertFalse(Files.exists(env.pluginsDir().resolve("custom-folder")));
        final Path configDir = env.configDir().resolve("fake");
    private Environment env;
import org.opensearch.Version;
        ).toArray(String[]::new);
    }
        final Environment env;
    public void testMissingPluginName() throws Exception {
        final Path removing = env.pluginsDir().resolve(".removing-fake");
import java.io.StringReader;
        return "-> preserving plugin config files [" + configDir + "] in case of upgrade; use --purge if not needed";
@LuceneTestCase.SuppressFileSystems("*")
            BufferedReader reader = new BufferedReader(new StringReader(terminal.getOutput()));
        assertTrue(Files.exists(env.pluginsDir().resolve("other")));
import org.opensearch.env.Environment;
    public void testRemoveWhenRemovingMarker() throws Exception {
        final MockTerminal terminal = removePlugin("fake", home, false);
        assertRemoveCleaned(env);
    }
        );
        assertThat(e, hasToString(containsString("plugin [fake] not found")));
        removePlugin("fake", home, randomBoolean());
            return env;
            VersionUtils.randomVersionBetween(
        assertEquals(ExitCodes.USAGE, e.exitCode);
        assertThat(Files.exists(env.pluginsDir().resolve("fake")), equalTo(false));
        MockTerminal terminal = new MockTerminal();
        assertTrue(Files.exists(env.binDir().resolve("fake")));
            Stream.of(
        PluginTestUtil.writePluginProperties(path.resolve(pluginFolderName), properties);
                return false;
        assertRemoveCleaned(env);
import org.opensearch.cli.UserException;
    static void assertRemoveCleaned(Environment env) throws IOException {
        createPlugin("fake");
            assertEquals("searching in other folders to find if plugin exists with custom folder name", reader.readLine());
            Files.createDirectories(configDir);
import static org.hamcrest.Matchers.hasToString;
        removePlugin("fake", home, randomBoolean());
import org.opensearch.env.TestEnvironment;
        assertRemoveCleaned(env);
        assertEquals("plugin [fake] not found; run 'opensearch-plugin list' to get list of installed plugins", e.getMessage());
        Files.createFile(env.pluginsDir().resolve("lib").resolve("fake"));
        new MockRemovePluginCommand(env).execute(terminal, env, name, purge);
        assertTrue(Files.exists(env.binDir().resolve("opensearch")));
        }
    }
    }
        assertFalse(Files.exists(env.pluginsDir().resolve("fake")));
        createPlugin("other");
            }
    void createPlugin(String name, String... additionalProps) throws IOException {
        Files.createDirectories(configDir);
 * this work for additional information regarding copyright
        Files.createFile(binDir.resolve("somescript"));
        MockTerminal terminal = new MockTerminal();
        assertTrue(Files.exists(env.configDir().resolve("fake")));
        UserException e = expectThrows(UserException.class, () -> removePlugin("fake", home, randomBoolean()));
    }
        assertRemoveCleaned(env);
    }
 * Modifications Copyright OpenSearch Contributors. See
        final Path configDir = env.configDir().resolve("fake");
                }
        ) {
            assertNull(errorReader.readLine());
