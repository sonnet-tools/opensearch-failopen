        tmpDir = Objects.requireNonNull(tmpPath);
            finalSettings.put(Environment.PIDFILE_SETTING.getKey(), pidFile.toString());
        if (PATH_DATA_SETTING.exists(settings)) {
    }
            repoFiles = EMPTY_PATH_ARRAY;
        assertEquals(actual.modulesDir(), expected.modulesDir(), "modulesDir");
// TODO: move PathUtils to be package-private here instead of
                String filePath = file.substring(0, pos);
                int pos = file.indexOf("!/");
 * the Apache License, Version 2.0 (the "License"); you may
        }
 *
        }
        binDir = homeFile.resolve("bin");
            assert pidFile != null;
import java.util.Arrays;
     */
    public Environment(final Settings settings, final Path configPath, final boolean nodeLocalStorage) {
            if ("file".equalsIgnoreCase(url.getProtocol())) {
                throw new IllegalStateException("node does not require local storage yet path.data is set to [" + paths + "]");
    }
        return sharedDataDir;
        assertEquals(actual.pidFile(), expected.pidFile(), "pidFile");
            configDir = homeFile.resolve("config");
     * The shared data location
        if (PATH_SHARED_DATA_SETTING.exists(settings)) {
    /**
            assert sharedDataDir != null;
 * software distributed under the License is distributed on an
                    return null;
    private final Path logsDir;
        modulesDir = homeFile.resolve("modules");
                String jarTail = file.substring(pos);
    }
        assertEquals(actual.repoFiles(), expected.repoFiles(), "repoFiles");
                }
                return new URL("jar", "", normalizedUrl.toExternalForm() + jarTail);
            configDir = configPath.toAbsolutePath().normalize();
        final Path homeFile;
    }
 * KIND, either express or implied.  See the License for the
    /** Path to the PID file (can be null if no PID file is configured) **/
        return binDir;
    }
                    // Normalize URL
            }
 * GitHub history for details.
        }
            }
 * not use this file except in compliance with the License.
        } else {
        Collections.emptyList(),
        }
        if (PATH_SHARED_DATA_SETTING.exists(settings)) {
 */
        return this.settings;
            throw new IOException("Configured temporary file directory [" + tmpDir + "] is not a directory");
    /** Path to the default temp directory used by the JDK */
     */
    /** location of bin/, used by plugin manager */
        List<String> dataPaths = PATH_DATA_SETTING.get(settings);
    );
    public static final Setting<List<String>> PATH_REPO_SETTING = Setting.listSetting(
import org.opensearch.common.SuppressForbidden;
    /**
import java.nio.file.FileStore;
 * specific language governing permissions and limitations
                    // only local file urls are supported
        return modulesDir;
 * @opensearch.api
        libDir = homeFile.resolve("lib");
    /**
     */
    }
            } else {
    private final Path tmpDir;
        }
    public Settings settings() {
    }
        List<String> repoPaths = PATH_REPO_SETTING.get(settings);
    }
                final String paths = String.join(",", dataPaths);
import java.net.MalformedURLException;
 * this file be licensed under the Apache-2.0 license or a
import java.nio.file.Path;
import java.util.Collections;
 */
     */
 * Unless required by applicable law or agreed to in writing,
        } else {
    private final Path libDir;
        Function.identity(),
            );
     * <p>
 * ownership. Elasticsearch licenses this file to you under
        if (PATH_LOGS_SETTING.exists(settings)) {
                    }
                if (pos < 0) {
    public Path libDir() {
                dataFiles = new Path[] { homeFile.resolve("data") };
        Function.identity(),
 */
    public Path modulesDir() {
                Environment.PATH_REPO_SETTING.getKey(),
     */
            logsDir = PathUtils.get(PATH_LOGS_SETTING.get(settings)).toAbsolutePath().normalize();
        assertEquals(actual.libDir(), expected.libDir(), "libDir");
/**
        }
                URL normalizedUrl = resolveRepoURL(internalUrl);
            if (dataPaths.isEmpty()) {
     * Resolves the specified location against the list of configured repository roots
        assertEquals(actual.logsDir(), expected.logsDir(), "logsDir");
     * <p>
     * The config directory.
                        return null;
 * under the License.
import org.opensearch.common.settings.Setting;
        return repoFiles;
        }
        if (PATH_REPO_SETTING.exists(settings)) {
    public Path binDir() {
 *
    public static final Setting<String> PATH_LOGS_SETTING = new Setting<>("path.logs", "", Function.identity(), Property.NodeScope);
    private final Settings settings;
     */
 * Modifications Copyright OpenSearch Contributors. See
    }
     * asserts that the two environments are equivalent for all things the environment cares about (i.e., all but the setting
        return pidFile;
        try {
    public Path pluginsDir() {
        assertEquals(actual.configDir(), expected.configDir(), "configDir");
        }
    }
        } else {
            return null;
        } else {
     */
    public Environment(final Settings settings, final Path configPath) {
    public static final Setting<List<String>> PATH_DATA_SETTING = Setting.listSetting(
     * The settings used to build this environment.
            } else {
import java.util.List;
    public Path tmpDir() {
        extensionsDir = homeFile.resolve("extensions");
import java.nio.file.Files;
     * The shared filesystem repo locations.
import java.net.URL;
        return dataFiles;
package org.opensearch.env;
                    dataFiles[i] = PathUtils.get(dataPaths.get(i)).toAbsolutePath().normalize();
                Arrays.stream(repoFiles).map(Path::toString).collect(Collectors.toList())
    }
        // this is trappy, Setting#get(Settings) will get a fallback setting yet return false for Settings#exists(Settings)
     */
            pidFile = null;
    }
            repoFiles = new Path[repoPaths.size()];
        Property.NodeScope
    private final Path[] dataFiles;
    public Path sharedDataDir() {
    private static void assertEquals(Object actual, Object expected, String name) {
        Collections.emptyList(),
                return null;
        return tmpDir;
    }
            finalSettings.putList(
import java.io.IOException;
    Environment(final Settings settings, final Path configPath, final boolean nodeLocalStorage, final Path tmpPath) {
    }
 *
        }
import org.opensearch.common.annotation.PublicApi;
    public static final Setting<String> PATH_HOME_SETTING = Setting.simpleString("path.home", Property.NodeScope);
    // Should only be called directly by this class's unit tests
        return new OpenSearchFileStore(Files.getFileStore(path));
    /** Path to the temporary file directory used by the JDK */
        }
     * If the specified url doesn't match any of the roots, returns null.
            logsDir = homeFile.resolve("logs");
    private final Path modulesDir;
            finalSettings.put(Environment.PATH_SHARED_DATA_SETTING.getKey(), sharedDataDir.toString());
// public+forbidden api!
     * against the list of configured repository roots
                URL internalUrl = new URL(filePath);
            assert pidFile != null;
     */
        assertEquals(actual.dataFiles(), expected.dataFiles(), "dataFiles");
    public void validateTmpDir() throws IOException {
 * The OpenSearch Contributors require contributions made to
        this(settings, configPath, true);
                dataFiles = EMPTY_PATH_ARRAY;
    private final Path pluginsDir;
    /**
                }
        Property.NodeScope
    }
    public static final Setting<String> PATH_SHARED_DATA_SETTING = Setting.simpleString("path.shared_data", Property.NodeScope);
 * SPDX-License-Identifier: Apache-2.0
/*
public class Environment {
        assertEquals(actual.tmpDir(), expected.tmpDir(), "tmpDir");
        "path.data",
        if (nodeLocalStorage) {
                if (normalizedUrl == null) {
        } catch (MalformedURLException ex) {
    }
            throw new FileNotFoundException("Temporary file directory [" + tmpDir + "] does not exist or is not accessible");
    /**
        return PathUtils.get(repoFiles, location);
}
    public Path[] dataFiles() {
                    return null;
 * The environment of where things exists.
    /**
        final Settings.Builder finalSettings = Settings.builder().put(settings);
            }
 * compatible open source license.
import java.io.FileNotFoundException;
                return null;
                if (url.getHost() == null || "".equals(url.getHost())) {
        assertEquals(actual.binDir(), expected.binDir(), "binDir");
    public URL resolveRepoURL(URL url) {
                    if (path == null) {
            if (dataPaths.isEmpty() == false) {
    public static void assertEquivalent(Environment actual, Environment expected) {
            } else {
    private final Path[] repoFiles;
    private final Path extensionsDir;
    /** location of lib/, */
                String file = url.getFile();
        } else if (PIDFILE_SETTING.exists(settings)) {
    public Path logsDir() {
            for (int i = 0; i < repoPaths.size(); i++) {
                dataFiles = new Path[dataPaths.size()];
    public Path pidFile() {
    public static final Setting<String> PIDFILE_SETTING = Setting.simpleString("pidfile", Property.Deprecated, Property.NodeScope);
import java.net.URISyntaxException;
    /**
        } else {
        finalSettings.put(PATH_HOME_SETTING.getKey(), homeFile);
@SuppressForbidden(reason = "configures paths for the system")
    }
            finalSettings.putList(PATH_DATA_SETTING.getKey(), Arrays.stream(dataFiles).map(Path::toString).collect(Collectors.toList()));
    /**
        return logsDir;
     * The PID file location (can be null if no PID file is configured)
        this.settings = finalSettings.build();
                }
    public static FileStore getFileStore(final Path path) throws IOException {
    }
        } else {
                    Path path = PathUtils.get(repoFiles, url.toURI());
                }
     * Checks if the specified URL is pointing to the local file system and if it does, resolves the specified url
    public Path[] repoFiles() {
                for (int i = 0; i < dataPaths.size(); i++) {
    );
        if (NODE_PIDFILE_SETTING.exists(settings)) {
    private final Path sharedDataDir;
        if (configPath != null) {
     * object which may contain different setting)
 */
 * You may obtain a copy of the License at
    private final Path pidFile;
        } else {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * The data location.
@PublicApi(since = "1.0.0")
        return configDir;
 * Licensed to Elasticsearch under one or more contributor
        assert Objects.deepEquals(actual, expected) : "actual " + name + " [" + actual + "] is different than [ " + expected + "]";
        if (repoPaths.isEmpty()) {
    }
    }
        assertEquals(actual.pluginsDir(), expected.pluginsDir(), "pluginsDir");
            return null;
        this(settings, configPath, nodeLocalStorage, PathUtils.get(System.getProperty("java.io.tmpdir")));
 *
        pluginsDir = homeFile.resolve("plugins");
            sharedDataDir = null;
        if (Files.isDirectory(tmpDir) == false) {
            }
    public static final Setting<String> NODE_PIDFILE_SETTING = Setting.simpleString("node.pidfile", PIDFILE_SETTING, Property.NodeScope);
            // cannot make sense of this file url
            finalSettings.put(Environment.NODE_PIDFILE_SETTING.getKey(), pidFile.toString());
        if (Files.exists(tmpDir) == false) {
        return libDir;
/*
    /** Ensure the configured temp directory is a valid directory */
        } catch (URISyntaxException ex) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                repoFiles[i] = PathUtils.get(repoPaths.get(i)).toAbsolutePath().normalize();
            } else if ("jar".equals(url.getProtocol())) {
 * this work for additional information regarding copyright
import java.util.function.Function;
import org.opensearch.common.io.PathUtils;
    public Path configDir() {
        if (NODE_PIDFILE_SETTING.exists(settings) || PIDFILE_SETTING.exists(settings)) {
    private static final Path[] EMPTY_PATH_ARRAY = new Path[0];
        }
    /**
     * If the specified location doesn't match any of the roots, returns null.
            pidFile = PathUtils.get(NODE_PIDFILE_SETTING.get(settings)).toAbsolutePath().normalize();
    }
            throw new IllegalStateException(PATH_HOME_SETTING.getKey() + " is not configured");
        return pluginsDir;
        "path.repo",
        }
                // It's not file or jar url and it didn't match the white list - reject
    private final Path configDir;
    public Path resolveRepoFile(String location) {
        if (PATH_HOME_SETTING.exists(settings)) {
import java.util.stream.Collectors;
                    return path.toUri().toURL();
        }
            sharedDataDir = PathUtils.get(PATH_SHARED_DATA_SETTING.get(settings)).toAbsolutePath().normalize();
            homeFile = PathUtils.get(PATH_HOME_SETTING.get(settings)).toAbsolutePath().normalize();
/*
import java.util.Objects;
        }
import org.opensearch.common.settings.Setting.Property;
                        // Couldn't resolve against known repo locations
import org.opensearch.common.settings.Settings;
        finalSettings.put(PATH_LOGS_SETTING.getKey(), logsDir.toString());
    private final Path binDir;
 * license agreements. See the NOTICE file distributed with
