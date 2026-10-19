            .put(Environment.PATH_LOGS_SETTING.getKey(), "./home/../home/logs")
/*  
    }  
    }
 * compatible open source license.
        assertThat(environment.configDir(), equalTo(configPath));
        return newEnvironment(Settings.EMPTY);
    }
            assertSettingDeprecationsAndWarnings(new Setting<?>[] { pidFileSetting });
        assertIsAbsolute(actual);
        Environment environment = newEnvironment();  
        if (randomBoolean()) {
    }
        assertThat(environment.resolveRepoFile("/another/repos/repo1"), notNullValue());
        final Environment environment = new Environment(settings, null, true, createTempDir());
            .put(Environment.PATH_DATA_SETTING.getKey(), "./home/../home/data")
        assertThat(environment.resolveRepoURL(URI.create("file://test/repos/repo1").toURL()), nullValue());  
        final Settings settings = Settings.builder()
        final String homePath = Environment.PATH_HOME_SETTING.get(environment.settings());  
        assertThat(e.getMessage(), endsWith("this_does_not_exist] does not exist or is not accessible"));  
        final Environment environment = new Environment(settings, null);
        assertThat(repoPaths, hasSize(1));
            Settings.builder()
    public void testNonExistentTempPathValidation() {
        Settings build = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(environment.resolveRepoFile("/test/repos/repo1"), nullValue());
 * not use this file except in compliance with the License.
        assertFalse(Environment.PATH_DATA_SETTING.exists(settings));
        assertPath(homePath, workingDirectory.resolve("home"));
        final Path pathHome = createTempDir().toAbsolutePath();
    }  
 * Unless required by applicable law or agreed to in writing,
        final String sharedDataPath = Environment.PATH_SHARED_DATA_SETTING.get(environment.settings());
        assertThat(environment.configDir(), equalTo(path.resolve("config")));  
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
        final Environment environment = new Environment(settings, null);  
            .put("path.data", pathData)
        final Settings settings = Settings.builder().put("path.home", pathHome).put("node.master", false).put("node.data", false).build();
        final Settings settings = Settings.builder().put("path.home", pathHome).build();  
        assertPath(sharedDataPath, home.resolve("shared_data"));
import org.opensearch.common.io.PathUtils;  
        assertThat(  
        Environment environment = new Environment(build, null, true, createTempFile("something", ".test"));
        assertThat(environment.resolveRepoURL(URI.create("jar:file:///test/repos/../repo1!/repo/").toURL()), nullValue());
    public void testNodeDoesNotRequireLocalStorage() {
    public void testPathDataWhenNotSet() {
        assertThat("path [" + path + "] is not normalized", PathUtils.get(path), equalTo(PathUtils.get(path).normalize()));
 * Licensed to Elasticsearch under one or more contributor  
        assertThat(dataPaths, hasSize(1));  
        final Setting<String> pidFileSetting;
        final Settings settings = Settings.builder().put("path.home", pathHome).build();
    }
        final List<String> dataPaths = Environment.PATH_DATA_SETTING.get(environment.settings());
    }  
    public void testPathLogsWhenNotSet() {
        final IllegalStateException e = expectThrows(IllegalStateException.class, () -> new Environment(settings, null, false));  
            pidFileSetting = Environment.PIDFILE_SETTING;
        return new Environment(build, null);
        assertThat(environment.configDir(), equalTo(pathHome.resolve("config")));
        if (pidFileSetting.isDeprecated()) {
    public void testPathDataNotSetInEnvironmentIfNotSet() {  
        Settings build = Settings.builder()  
        final Path workingDirectory = PathUtils.get(System.getProperty("user.dir"));  
        assertPath(dataPaths.get(0), home.resolve("data"));
import java.net.URI;
        assertThat(environment.logsDir(), equalTo(pathHome.resolve("logs")));
import static org.hamcrest.Matchers.hasToString;
        final Settings settings = Settings.builder().put("path.home", path).build();
    }
        assertPath(logPath, home.resolve("logs"));
        environment = newEnvironment(  
import java.io.FileNotFoundException;
        assertThat(environment.resolveRepoFile("test/repos/repo1"), nullValue());
            endsWith("repo1!/repo/")
        final Environment environment = new Environment(settings, null, false);
        assertThat(e, hasToString(containsString("node does not require local storage yet path.data is set to [" + pathData + "]")));
 *
        assertThat(environment.resolveRepoURL(URI.create("jar:http://localhost/test/../repo1?blah!/repo/").toURL()), nullValue());
        assertThat(environment.resolveRepoFile("test/repos/repo1"), notNullValue());  
    public void testConfigPath() {  
 * under the License.  
        assertThat(environment.resolveRepoURL(URI.create("jar:file:///test/repos/repo1!/repo/").toURL()), notNullValue());
        final Path pathHome = createTempDir().toAbsolutePath();
        final Path home = PathUtils.get(homePath);  
 * GitHub history for details.
/*
                .putList(Environment.PATH_REPO_SETTING.getKey(), "/test/repos", "/another/repos", "/test/repos/../other")
 * this work for additional information regarding copyright
import java.io.IOException;  
    }
        assertThat(PathUtils.get(actual), equalTo(expected));  
            .build();
 * Modifications Copyright OpenSearch Contributors. See  
    private void assertIsNormalized(final String path) {
        final Environment environment = new Environment(settings, configPath);  
        final String pidFile = pidFileSetting.get(environment.settings());
 */
        }  
        assertThat(e.getMessage(), startsWith("Temporary file directory ["));
 *  
import java.nio.file.Path;
            pidFileSetting = Environment.NODE_PIDFILE_SETTING;  
 * license agreements. See the NOTICE file distributed with
        final Path pathData = pathHome.resolve("data");
            .put("path.home", pathHome)
import java.util.List;  
    public void testDefaultConfigPath() {
 *
        assertFalse(Environment.PATH_DATA_SETTING.exists(environment.settings()));
/*
        final Settings settings = Settings.builder().put("path.home", pathHome).build();  
 */  
        Settings build = Settings.builder().put(Environment.PATH_HOME_SETTING.getKey(), createTempDir()).build();
import org.opensearch.test.OpenSearchTestCase;  
    }  
    private void assertIsAbsolute(final String path) {  
 * SPDX-License-Identifier: Apache-2.0
    public void testConfigPathWhenNotSet() {
        assertThat(environment.dataFiles(), arrayWithSize(0));  
        final Path configPath = createTempDir().toAbsolutePath();
        assertThat(environment.resolveRepoURL(URI.create("file:///test/repos/../repo1").toURL()), nullValue());
        final Path pathHome = createTempDir().toAbsolutePath();
        final Environment environment = new Environment(settings, null);
 * You may obtain a copy of the License at  
        // the above paths will be treated as relative to the working directory
            .put(Environment.PATH_HOME_SETTING.getKey(), "home")  
import static org.hamcrest.CoreMatchers.endsWith;
import static org.hamcrest.CoreMatchers.nullValue;
            .put(Environment.PATH_HOME_SETTING.getKey(), createTempDir().toAbsolutePath())
import org.opensearch.common.settings.Setting;
    }  
import org.opensearch.common.settings.Settings;
        final Environment environment = new Environment(settings, null);
        );  
            environment.resolveRepoURL(URI.create("jar:file:///test/repos/repo1!/repo/").toURL()).toString(),
        assertThat(environment.resolveRepoURL(URI.create("jar:file:/test/repos/repo1!/repo/").toURL()), notNullValue());
        assertThat(e.getMessage(), endsWith(".test] is not a directory"));
        assertThat(environment.resolveRepoFile("/somethingeles/repos/repo1"), nullValue());
    }  
        Environment environment = new Environment(build, null, true, createTempDir().resolve("this_does_not_exist"));  
            .build();
        assertThat(environment.resolveRepoFile("/test/repos/../repos/repo1"), notNullValue());  
}
 * Simple unit-tests for Environment.java
        final Path path = createTempDir().toAbsolutePath();  
/**  
    }
        final List<String> repoPaths = Environment.PATH_REPO_SETTING.get(environment.settings());  
    }
        assertPath(repoPaths.get(0), home.resolve("repo"));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.env;
        final Settings settings = Settings.builder().put("path.home", createTempDir().toAbsolutePath()).build();
        assertThat(environment.resolveRepoFile("/test/repos/../repo1"), nullValue());
import static org.hamcrest.CoreMatchers.notNullValue;  
    }
        assertThat(e.getMessage(), startsWith("Configured temporary file directory ["));
import static org.hamcrest.Matchers.hasSize;  
        final Settings settings = Settings.builder().put("path.home", createTempDir().toAbsolutePath()).build();
 */
        } else {
        final String logPath = Environment.PATH_LOGS_SETTING.get(environment.settings());  
    public void testPathNormalization() throws IOException {  
        FileNotFoundException e = expectThrows(FileNotFoundException.class, environment::validateTmpDir);
import static org.hamcrest.Matchers.equalTo;
    }
            .put(Environment.PATH_SHARED_DATA_SETTING.getKey(), "./home/../home/shared_data")
            .put(pidFileSetting.getKey(), "./home/../home/pidfile")
    public Environment newEnvironment(Settings settings) {
        final Path pathHome = createTempDir().toAbsolutePath();  
        assertThat(environment.resolveRepoURL(URI.create("file:///test/repos/repo1").toURL()), notNullValue());
            .put("node.data", false)
        final Path pathHome = createTempDir().toAbsolutePath();  
 * KIND, either express or implied.  See the License for the
        final Environment environment = new Environment(settings, null);
import static org.hamcrest.Matchers.arrayWithSize;  
        assertThat(environment.resolveRepoFile("/test/other/repo"), notNullValue());
        assertTrue("path [" + path + "] is not absolute", PathUtils.get(path).isAbsolute());
 * software distributed under the License is distributed on an
public class EnvironmentTests extends OpenSearchTestCase {  
 */
            .put(settings)
    }  
        assertThat(environment.dataFiles(), equalTo(new Path[] { pathHome.resolve("data") }));  
    // test that environment paths are absolute and normalized
        assertIsNormalized(actual);
 * the Apache License, Version 2.0 (the "License"); you may
            .putList(Environment.PATH_DATA_SETTING.getKey(), tmpPaths())  
    public Environment newEnvironment() {
    private void assertPath(final String actual, final Path expected) {  
        assertThat(environment.resolveRepoURL(URI.create("file:/test/repos/repo1").toURL()), notNullValue());
        }  
            .put(Environment.PATH_REPO_SETTING.getKey(), "./home/../home/repo")  
        final Settings settings = Settings.builder()  
    public void testNodeDoesNotRequireLocalStorageButHasPathData() {  
    public void testRepositoryResolution() throws IOException {
        assertPath(pidFile, home.resolve("pidfile"));
        );
            .put("node.master", false)  
        assertThat(environment.resolveRepoURL(URI.create("http://localhost/test/").toURL()), nullValue());
        assertThat(environment.resolveRepoFile("/test/repos/repo1"), notNullValue());
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
import static org.hamcrest.CoreMatchers.startsWith;
                .build()  
import static org.hamcrest.Matchers.containsString;
        IOException e = expectThrows(IOException.class, environment::validateTmpDir);  
            .build();  
    public void testTempPathValidationWhenRegularFile() throws IOException {  
