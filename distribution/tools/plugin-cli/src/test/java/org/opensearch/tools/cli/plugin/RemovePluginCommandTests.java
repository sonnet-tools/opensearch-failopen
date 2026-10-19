        assertThat(terminal.getOutput(), containsString(expectedConfigDirPreservedMessage(configDir)));  
            assertNull(errorReader.readLine());
    public void testBinNotDir() throws Exception {
@LuceneTestCase.SuppressFileSystems("*")
 * GitHub history for details.
        }
    public void testMissingPluginName() throws Exception {  
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(env.pluginsDir())) {
        createPlugin("other");
        createPlugin("fake");
        if (randomBoolean()) {
        removePlugin("fake", home, randomBoolean());
        }  
        UserException e = expectThrows(UserException.class, () -> removePlugin("fake", home, randomBoolean()));
            assertEquals(  
 *
            assertEquals("-> removing [fake]...", reader.readLine());
        ).toArray(String[]::new);  
}
/*  
        MockTerminal terminal = new MockTerminal();
    public void testPurgePluginDoesNotExist() throws Exception {
import org.opensearch.env.TestEnvironment;
                "description",
        assertFalse(Files.exists(env.pluginsDir().resolve("fake")));
        assertFalse(Files.exists(removing));
 * Unless required by applicable law or agreed to in writing,
        removePlugin("fake", home, randomBoolean());  
                if (file.getFileName().toString().startsWith(".removing")) {  
            "fake",
    static class MockRemovePluginCommand extends RemovePluginCommand {
 */  
        Files.createFile(env.pluginsDir().resolve("fake").resolve("plugin.jar"));
        assertTrue(Files.exists(env.binDir().resolve("opensearch")));
    }
    public void testRemoveUninstalledPluginErrors() throws Exception {  
 * the Apache License, Version 2.0 (the "License"); you may
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));
            assertEquals("searching in other folders to find if plugin exists with custom folder name", reader.readLine());
        return "-> preserving plugin config files [" + configDir + "] in case of upgrade; use --purge if not needed";
import org.opensearch.cli.ExitCodes;  
    }  
        Files.createFile(env.pluginsDir().resolve("custom-folder").resolve("plugin.jar"));
                "SomeClass"  
        removePlugin("fake", home, randomBoolean());
        assertThat(Files.exists(env.pluginsDir().resolve("fake")), equalTo(false));  
import org.opensearch.Version;
    }
 * compatible open source license.
import org.apache.lucene.tests.util.LuceneTestCase;
 * Licensed to Elasticsearch under one or more contributor  
        final Path configDir = env.configDir().resolve("fake");  
            VersionUtils.randomVersionBetween(
    void createPlugin(String name, Version version) throws IOException {  
 * not use this file except in compliance with the License.
        Environment env = TestEnvironment.newEnvironment(Settings.builder().put("path.home", home).build());  
    }  
import static org.hamcrest.CoreMatchers.containsString;  
    }
        Files.createFile(configDir.resolve("fake.yml"));
        Files.createDirectories(configDir);
        assertEquals("plugin [fake] not found; run 'opensearch-plugin list' to get list of installed plugins", e.getMessage());  
                "name",  
                "opensearch.version",
        assertRemoveCleaned(env);
            ),
    void createPlugin(Path path, String name, Version version, String... additionalProps) throws IOException {
        home = createTempDir();  
        final Environment env;
        final MockTerminal terminal = removePlugin("fake", home, randomBoolean());
        UserException e = expectThrows(UserException.class, () -> removePlugin("dne", home, randomBoolean()));
        new MockRemovePluginCommand(env).execute(terminal, env, name, purge);
                errorReader.readLine()
        String pluginFolderName = additionalProps.length == 0 ? name : additionalProps[1];
 * this file be licensed under the Apache-2.0 license or a
        Files.createFile(env.binDir().resolve("fake"));  
    }  
                VersionUtils.getPreviousVersion()
import org.opensearch.common.settings.Settings;  
 * specific language governing permissions and limitations
                version.toString(),
        Files.createFile(libDir.resolve("dep.jar"));  
        assertRemoveCleaned(env);
        assertFalse(Files.exists(env.pluginsDir().resolve("fake")));
        final UserException e = expectThrows(UserException.class, () -> removePlugin("fake", home, true));
package org.opensearch.tools.cli.plugin;
        removePlugin("fake", home, randomBoolean());
import java.nio.file.Path;
        assertThat(terminal.getOutput(), not(containsString(expectedConfigDirPreservedMessage(configDir))));
    void createPlugin(String name, String... additionalProps) throws IOException {
            Files.createFile(configDir.resolve("fake.yml"));  
                "java.version",  
    }
        Path binDir = env.binDir().resolve("fake");  
        env = TestEnvironment.newEnvironment(settings);
    public void testNoConfigDirPreserved() throws Exception {
    public void testLibNotDir() throws Exception {
 * under the License.  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        assertRemoveCleaned(env);  
        Files.createFile(env.pluginsDir().resolve(".removing-fake"));  
        assertRemoveCleaned(env);
    public void setUp() throws Exception {
        assertRemoveCleaned(env);
        assertTrue(Files.exists(env.pluginsDir().resolve("fake"))); // did not remove
            BufferedReader errorReader = new BufferedReader(new StringReader(terminal.getErrorOutput()))
        final Path configDir = env.configDir().resolve("fake");
        assertFalse(Files.exists(env.configDir().resolve("fake")));  
            Arrays.stream(additionalProps)
    }
        createPlugin(env.pluginsDir(), name, version);
import java.io.IOException;  
    @Before  
public class RemovePluginCommandTests extends OpenSearchTestCase {  
        @Override
    private Path home;
        final MockTerminal terminal = removePlugin("fake", home, true);
        Files.createFile(env.pluginsDir().resolve("fake").resolve("plugin.jar"));  
        assertFalse(Files.exists(env.pluginsDir().resolve("fake")));
import java.io.BufferedReader;
        super.setUp();
        UserException e = expectThrows(UserException.class, () -> removePlugin("fake", home, randomBoolean()));
        assertFalse(Files.exists(env.pluginsDir().resolve("custom-folder")));  
            assertNull(reader.readLine());
        assertRemoveCleaned(env);
    }
    }
    public void testLib() throws Exception {
        final MockTerminal terminal = removePlugin("fake", home, true);  
        assertEquals(ExitCodes.USAGE, e.exitCode);
        Path libDir = env.pluginsDir().resolve("lib").resolve("fake");
        assertFalse(Files.exists(binDir));  
        assertThat(e, hasToString(containsString("plugin [fake] not found")));
 * KIND, either express or implied.  See the License for the
        assertEquals(ExitCodes.CONFIG, e.exitCode);
    public void testBasic() throws Exception {
    public void testRemovePluginWithCustomFolderName() throws Exception {  
            BufferedReader reader = new BufferedReader(new StringReader(terminal.getOutput()));
    }
            Stream.of(  
            protected boolean addShutdownHook() {
        Files.createDirectories(binDir);
/*  
            return env;  
        final Path configDir = env.configDir().resolve("fake");
import org.opensearch.plugins.PluginTestUtil;  
                "ERROR: plugin [fake] not found; run 'opensearch-plugin list' to get list of installed plugins",
        assertTrue(Files.exists(env.pluginsDir().resolve("other")));
        assertThat(terminal.getOutput(), not(containsString(expectedConfigDirPreservedMessage(configDir))));  
        final Path configDir = env.configDir().resolve("fake");  
        Files.createDirectories(home.resolve("bin"));
    public void testRemoveOldVersion() throws Exception {
    }  
        assertTrue(Files.exists(env.configDir().resolve("fake")));
 * ownership. Elasticsearch licenses this file to you under  
                }
        createPlugin("fake");
        Files.createDirectories(libDir);
        Files.createDirectory(env.pluginsDir().resolve("custom-folder").resolve("subdir"));  
        PluginTestUtil.writePluginProperties(path.resolve(pluginFolderName), properties);
 *
        }
        final MockTerminal terminal = removePlugin("fake", home, false);
        Files.createFile(removing);
    }  
        createPlugin(env.pluginsDir(), name, Version.CURRENT, additionalProps);  
import org.opensearch.cli.MockTerminal;
        assertTrue(Files.exists(env.pluginsDir().resolve("other")));
        assertTrue(Files.exists(env.binDir().resolve("fake")));
        removePlugin("fake", home, randomBoolean());  
                "version",
 */
import java.io.StringReader;
            this.env = env;
        assertRemoveCleaned(env);
                Version.CURRENT.minimumIndexCompatibilityVersion(),
                "dummy",
        assertFalse(Files.exists(env.configDir().resolve("fake")));
            for (Path file : stream) {
    private String expectedConfigDirPreservedMessage(final Path configDir) {
        }
import org.junit.Before;  
    }  
        Files.createFile(configDir.resolve("fake.yml"));  
                "classname",
        createPlugin("fake");
    }
    }  
import java.nio.file.Files;  
            }  
import org.opensearch.env.Environment;
    }
        removePlugin("fake", home, randomBoolean());
        UserException e = expectThrows(UserException.class, () -> removePlugin("fake", home, randomBoolean()));
                "1.0",  
    }  
        createPlugin("fake");
        new MockRemovePluginCommand(env) {
            }
        }.main(new String[] { "-Epath.home=" + home, "fake" }, terminal);
        assertTrue(e.getMessage(), e.getMessage().contains("plugin [dne] not found"));  
import org.opensearch.test.OpenSearchTestCase;
import java.util.Map;  
        assertThat(terminal.getOutput(), not(containsString(expectedConfigDirPreservedMessage(configDir))));
    }
        Files.createDirectories(configDir);
        assertRemoveCleaned(env);
    }  
    }
        private MockRemovePluginCommand(final Environment env) {  
        createPlugin("fake");  
        String[] properties = Stream.concat(
 * Modifications Copyright OpenSearch Contributors. See
    }
        assertThat(terminal.getOutput(), not(containsString(expectedConfigDirPreservedMessage(configDir))));
        MockTerminal terminal = new MockTerminal();
        protected Environment createEnv(Map<String, String> settings) throws UserException {
        assertRemoveCleaned(env);
import java.util.stream.Stream;
import java.nio.file.DirectoryStream;
                return false;  
        ) {  
        Files.createFile(binDir.resolve("somescript"));
        final Path configDir = env.configDir().resolve("fake");  
    private Environment env;  
                name,
import static org.hamcrest.Matchers.equalTo;
        Settings settings = Settings.builder().put("path.home", home).build();
        final Path removing = env.pluginsDir().resolve(".removing-fake");
        createPlugin("other");
        Files.createFile(env.pluginsDir().resolve("lib").resolve("fake"));
        Files.createDirectories(home.resolve("plugins"));  
                    fail("Removal dir still exists, " + file);
import static org.hamcrest.Matchers.hasToString;  
        Files.createFile(home.resolve("bin").resolve("opensearch"));
        createPlugin("fake");  
        assertTrue(e.getMessage(), e.getMessage().contains("not a directory"));  
    public void testPurgePluginExists() throws Exception {
import java.util.Arrays;
        createPlugin("fake");
    public void testPurgeNothingExists() throws Exception {  
    public void testMissing() throws Exception {
import org.opensearch.cli.UserException;
 * SPDX-License-Identifier: Apache-2.0
        createPlugin("fake");
                System.getProperty("java.specification.version"),
        );
        assertRemoveCleaned(env);
        assertEquals("plugin name is required", e.getMessage());  
                random(),  
 */  
    @Override
        assertTrue(Files.exists(env.pluginsDir().resolve("fake"))); // did not remove  
        UserException e = expectThrows(UserException.class, () -> removePlugin(null, home, randomBoolean()));
            )  
 * this work for additional information regarding copyright
import static org.hamcrest.CoreMatchers.not;
        assertFalse(Files.exists(libDir));  
    static void assertRemoveCleaned(Environment env) throws IOException {  
/*
        final MockTerminal terminal = removePlugin("fake", home, randomBoolean());  
    static MockTerminal removePlugin(String name, Path home, boolean purge) throws Exception {
    public void testRemoveWhenRemovingMarker() throws Exception {  
            );  
        createPlugin("fake", "custom.foldername", "custom-folder");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        createPlugin("fake");  
    }  
        return terminal;  
        try (  
 * You may obtain a copy of the License at  
    }
        createPlugin(  
        assertRemoveCleaned(env);  
import org.opensearch.test.VersionUtils;
    public void testPurgeOnlyMarkerFileExists() throws Exception {
    public void testBin() throws Exception {
    public void testConfigDirPreserved() throws Exception {
        }
        Files.createDirectory(env.pluginsDir().resolve("fake").resolve("subdir"));
 *  
 * license agreements. See the NOTICE file distributed with
        Files.createDirectories(env.pluginsDir().resolve("lib"));  
            Files.createDirectories(configDir);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
