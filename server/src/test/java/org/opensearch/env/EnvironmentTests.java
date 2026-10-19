 * license agreements. See the NOTICE file distributed with
    }
        assertThat(PathUtils.get(actual), equalTo(expected));
 * under the License.
        final Path pathHome = createTempDir().toAbsolutePath();
 */
        final Settings settings = Settings.builder()
    }
        assertThat(environment.resolveRepoFile("/test/other/repo"), notNullValue());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final Path pathHome = createTempDir().toAbsolutePath();
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), "./home/../home/shared_data")
import org.opensearch.test.OpenSearchTestCase;
    }
        assertPath(repoPaths.get(0), home.resolve("repo"));
            .put(pidFileSetting.getKey(), "./home/../home/pidfile")
        Settings build = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(environment.dataFiles(), arrayWithSize(0));
        assertThat(environment.logsDir(), equalTo(pathHome.resolve("logs")));
        FileNotFoundException e = expectThrows(FileNotFoundException.class, environment::validateTmpDir);
        Environment environment = new Environment(build, null, true, createTempFile("something", ".test"));
        assertThat(environment.resolveRepoFile("test/repos/repo1"), notNullValue());
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Setting;
        final String sharedDataPath = Environment.PATH_SHARED_DATA_SETTING.get(environment.settings());
    public void testDefaultConfigPath() {
import org.opensearch.common.settings.Settings;
        assertThat(
    public void testNonExistentTempPathValidation() {
        final Environment environment = new Environment(settings, null);
        assertThat(environment.resolveRepoURL(URI.create("jar:file:///test/repos/repo1!/repo/").toURL()), notNullValue());
        assertThat(e.getMessage(), endsWith(".test] is not a directory"));
                .build()
import static org.hamcrest.Matchers.containsString;
        Settings build = Settings.builder()
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.CoreMatchers.nullValue;
    public void testRepositoryResolution() throws IOException {
        assertThat(environment.configDir(), equalTo(path.resolve("config")));
        }
        assertThat(environment.resolveRepoFile("test/repos/repo1"), nullValue());
        );
        assertThat(environment.resolveRepoURL(URI.create("jar:file:///test/repos/../repo1!/repo/").toURL()), nullValue());
        assertThat(e.getMessage(), startsWith("Temporary file directory ["));
            Settings.builder()
        final Path path = createTempDir().toAbsolutePath();
 * not use this file except in compliance with the License.
}
        return newEnvironment(Settings.EMPTY);
 * KIND, either express or implied.  See the License for the
public class EnvironmentTests extends OpenSearchTestCase {
        final String logPath = Environment.PATH_LOGS_SETTING.get(environment.settings());
        final Path pathHome = createTempDir().toAbsolutePath();
import org.opensearch.common.io.PathUtils;
        assertThat(environment.resolveRepoURL(URI.create("file:///test/repos/../repo1").toURL()), nullValue());
    }
        Environment environment = new Environment(build, null, true, createTempDir().resolve("this_does_not_exist"));
            .put("path.data", pathData)
        assertThat(environment.dataFiles(), equalTo(new Path[] { pathHome.resolve("data") }));
/*
import static org.hamcrest.CoreMatchers.endsWith;
            .put(Environment.PATH_LOGS_SETTING.getKey(), "./home/../home/logs")
 * compatible open source license.
        assertThat(repoPaths, hasSize(1));
        assertIsNormalized(actual);
        environment = newEnvironment(
 * Unless required by applicable law or agreed to in writing,
    }
            pidFileSetting = Environment.PIDFILE_SETTING;
        assertThat(environment.resolveRepoFile("/test/repos/repo1"), nullValue());
    }
    public void testNodeDoesNotRequireLocalStorage() {
        if (pidFileSetting.isDeprecated()) {
 *
            .put(Environment.PATH_DATA_SETTING.getKey(), "./home/../home/data")
        assertThat("path [" + path + "] is not normalized", PathUtils.get(path), equalTo(PathUtils.get(path).normalize()));
        assertThat(environment.resolveRepoFile("/test/repos/../repos/repo1"), notNullValue());
 *    http://www.apache.org/licenses/LICENSE-2.0
    private void assertPath(final String actual, final Path expected) {
        assertPath(pidFile, home.resolve("pidfile"));
        final Environment environment = new Environment(settings, null);
import static org.hamcrest.CoreMatchers.notNullValue;
 */
        final Environment environment = new Environment(settings, null);
            assertSettingDeprecationsAndWarnings(new Setting<?>[] { pidFileSetting });
            .build();
        assertFalse(Environment.PATH_DATA_SETTING.exists(environment.settings()));
import java.io.IOException;
import java.io.FileNotFoundException;
            environment.resolveRepoURL(URI.create("jar:file:///test/repos/repo1!/repo/").toURL()).toString(),
 * specific language governing permissions and limitations
import java.nio.file.Path;
            pidFileSetting = Environment.NODE_PIDFILE_SETTING;
        assertThat(environment.configDir(), equalTo(pathHome.resolve("config")));
        final Path workingDirectory = PathUtils.get(System.getProperty("user.dir"));
        final Settings settings = Settings.builder().put("path.home", createTempDir().toAbsolutePath()).build();
        final Path pathHome = createTempDir().toAbsolutePath();
        assertIsAbsolute(actual);
        final Path configPath = createTempDir().toAbsolutePath();
    }
    }
    public void testConfigPath() {
    public void testPathDataWhenNotSet() {
 * software distributed under the License is distributed on an
        assertThat(e.getMessage(), endsWith("this_does_not_exist] does not exist or is not accessible"));
    public void testConfigPathWhenNotSet() {
            endsWith("repo1!/repo/")
    }
            .put(Environment.PATH_HOME_SETTING.getKey(), "home")
    public void testTempPathValidationWhenRegularFile() throws IOException {
        assertPath(homePath, workingDirectory.resolve("home"));
        Settings build = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
        final Environment environment = new Environment(settings, null);
        assertThat(environment.resolveRepoFile("/somethingeles/repos/repo1"), nullValue());
        final Settings settings = Settings.builder().put("path.home", pathHome).build();
        assertPath(dataPaths.get(0), home.resolve("data"));
import java.util.List;
        assertThat(environment.resolveRepoURL(URI.create("jar:file:/test/repos/repo1!/repo/").toURL()), notNullValue());
    private void assertIsAbsolute(final String path) {
        assertPath(sharedDataPath, home.resolve("shared_data"));
        assertThat(environment.resolveRepoURL(URI.create("file:///test/repos/repo1").toURL()), notNullValue());
 * GitHub history for details.
/*
 */
    }
        assertFalse(Environment.PATH_DATA_SETTING.exists(settings));
import static org.hamcrest.Matchers.hasToString;
    }
        final Environment environment = new Environment(settings, null, true, createTempDir());
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.arrayWithSize;
    }
 * ownership. Elasticsearch licenses this file to you under
        final List<String> repoPaths = Environment.PATH_REPO_SETTING.get(environment.settings());
        assertThat(environment.resolveRepoFile("/test/repos/../repo1"), nullValue());
        final String pidFile = pidFileSetting.get(environment.settings());
 * The OpenSearch Contributors require contributions made to
            .put(Environment.PATH_REPO_SETTING.getKey(), "./home/../home/repo")
        Environment environment = newEnvironment();
        assertThat(environment.resolveRepoURL(URI.create("file:/test/repos/repo1").toURL()), notNullValue());
        assertThat(environment.configDir(), equalTo(configPath));
        final Setting<String> pidFileSetting;
    public void testNodeDoesNotRequireLocalStorageButHasPathData() {
        assertPath(logPath, home.resolve("logs"));
        }
/*
        final Path pathData = pathHome.resolve("data");
/**
        final Settings settings = Settings.builder().put("path.home", createTempDir().toAbsolutePath()).build();
import static org.hamcrest.Matchers.equalTo;
 * You may obtain a copy of the License at
        assertThat(environment.resolveRepoURL(URI.create("file://test/repos/repo1").toURL()), nullValue());
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
        IOException e = expectThrows(IOException.class, environment::validateTmpDir);
    public Environment newEnvironment(Settings settings) {
        return new Environment(build, null);
        );
        final Settings settings = Settings.builder().put("path.home", path).build();
        final Settings settings = Settings.builder().put("path.home", pathHome).build();
    }
        assertThat(environment.resolveRepoURL(URI.create("http://localhost/test/").toURL()), nullValue());
    public void testPathLogsWhenNotSet() {
        final Environment environment = new Environment(settings, null, false);
            .put("node.data", false)
        assertThat(e, hasToString(containsString("node does not require local storage yet path.data is set to [" + pathData + "]")));
        final Path pathHome = createTempDir().toAbsolutePath();
        final Settings settings = Settings.builder()
        final Environment environment = new Environment(settings, null);
    }
        } else {
        assertThat(environment.resolveRepoURL(URI.create("jar:http://localhost/test/../repo1?blah!/repo/").toURL()), nullValue());
        final Environment environment = new Environment(settings, configPath);
    }
        final Settings settings = Settings.builder().put("path.home", pathHome).build();
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> new Environment(settings, null, false));
    public void testPathDataNotSetInEnvironmentIfNotSet() {
        assertThat(e.getMessage(), startsWith("Configured temporary file directory ["));
        if (randomBoolean()) {
 * this work for additional information regarding copyright
            .put("node.master", false)
    }
 *
            .put(settings)
        final String homePath = Environment.PATH_HOME_SETTING.get(environment.settings());
    // test that environment paths are absolute and normalized
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())
        assertThat(dataPaths, hasSize(1));
import java.net.URI;
                .putList(Environment.PATH_REPO_SETTING.getKey(), "/test/repos", "/another/repos", "/test/repos/../other")
 */
        assertThat(environment.resolveRepoFile("/another/repos/repo1"), notNullValue());
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.CoreMatchers.startsWith;
        assertThat(environment.resolveRepoFile("/test/repos/repo1"), notNullValue());
 * Licensed to Elasticsearch under one or more contributor
    public void testPathNormalization() throws IOException {
        assertTrue("path [" + path + "] is not absolute", PathUtils.get(path).isAbsolute());
        // the above paths will be treated as relative to the working directory
 *
        final List<String> dataPaths = Environment.PATH_DATA_SETTING.get(environment.settings());
        final Path home = PathUtils.get(homePath);
 * Simple unit-tests for Environment.java
        final Settings settings = Settings.builder().put("path.home", pathHome).put("node.master", false).put("node.data", false).build();
    public Environment newEnvironment() {
            .build();
    }
            .put("path.home", pathHome)
package org.opensearch.env;
    private void assertIsNormalized(final String path) {
            .build();
