        return this.settings;  
        if (PATH_SHARED_DATA_SETTING.exists(settings)) {  
import org.opensearch.common.SuppressForbidden;
        }  
                return null;  
 * license agreements. See the NOTICE file distributed with
        }  
     * The data location.
        }  
     * object which may contain different setting)
        Collections.emptyList(),
    }  
        return dataFiles;
    public Path modulesDir() {
        return libDir;
        final Path homeFile;
    }  
        List<String> dataPaths = PATH_DATA_SETTING.get(settings);
        }
    public static final Setting<String> PIDFILE_SETTING = Setting.simpleString("pidfile", Property.Deprecated, Property.NodeScope);  
     */
    }
                final String paths = String.join(",", dataPaths);  
 *
                return null;
    public static FileStore getFileStore(final Path path) throws IOException {
        return pluginsDir;  
    /**
    private final Path extensionsDir;
        final Settings.Builder finalSettings = Settings.builder().put(settings);  
@PublicApi(since = "1.0.0")
        } catch (URISyntaxException ex) {
    /** Path to the PID file (can be null if no PID file is configured) **/  
        finalSettings.put(PATH_HOME_SETTING.getKey(), homeFile);
                }
        } else {
     * against the list of configured repository roots
    }
            pidFile = null;
        assertEquals(actual.pluginsDir(), expected.pluginsDir(), "pluginsDir");
    public Path binDir() {  
 * this file be licensed under the Apache-2.0 license or a
    public Path pidFile() {
import java.io.IOException;  
    public Path[] repoFiles() {
        modulesDir = homeFile.resolve("modules");
    /** Path to the default temp directory used by the JDK */
    Environment(final Settings settings, final Path configPath, final boolean nodeLocalStorage, final Path tmpPath) {  
     */
     * asserts that the two environments are equivalent for all things the environment cares about (i.e., all but the setting
        if (repoPaths.isEmpty()) {
 * compatible open source license.
 * software distributed under the License is distributed on an
                if (pos < 0) {
     */  
        assertEquals(actual.repoFiles(), expected.repoFiles(), "repoFiles");  
    private final Path sharedDataDir;
/*  
import java.util.function.Function;
        assertEquals(actual.modulesDir(), expected.modulesDir(), "modulesDir");
 * ownership. Elasticsearch licenses this file to you under  
 */  
        extensionsDir = homeFile.resolve("extensions");
    }
     * Checks if the specified URL is pointing to the local file system and if it does, resolves the specified url
 * The environment of where things exists.  
                throw new IllegalStateException("node does not require local storage yet path.data is set to [" + paths + "]");
import org.opensearch.common.io.PathUtils;  
                int pos = file.indexOf("!/");
import java.nio.file.Files;
     */
}
import org.opensearch.common.settings.Settings;  
                    dataFiles[i] = PathUtils.get(dataPaths.get(i)).toAbsolutePath().normalize();  
        assertEquals(actual.binDir(), expected.binDir(), "binDir");  
    private static final Path[] EMPTY_PATH_ARRAY = new Path[0];
        this.settings = finalSettings.build();
        }  
    public Path libDir() {
        }
    }  
                String jarTail = file.substring(pos);
        if (PATH_LOGS_SETTING.exists(settings)) {
 *  
import java.util.stream.Collectors;  
import java.net.URL;  
     * <p>
        binDir = homeFile.resolve("bin");
                        // Couldn't resolve against known repo locations
            );
     * <p>  
     * The config directory.
            pidFile = PathUtils.get(NODE_PIDFILE_SETTING.get(settings)).toAbsolutePath().normalize();  
 * specific language governing permissions and limitations
 *
        if (PATH_SHARED_DATA_SETTING.exists(settings)) {
        "path.data",
                return new URL("jar", "", normalizedUrl.toExternalForm() + jarTail);  
    }
    }  
        try {
                Arrays.stream(repoFiles).map(Path::toString).collect(Collectors.toList())  
                    // Normalize URL
import org.opensearch.common.settings.Setting;
            assert sharedDataDir != null;
        }  
        }
import java.nio.file.FileStore;
            configDir = homeFile.resolve("config");
     * The settings used to build this environment.  
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new FileNotFoundException("Temporary file directory [" + tmpDir + "] does not exist or is not accessible");
        finalSettings.put(PATH_LOGS_SETTING.getKey(), logsDir.toString());
                }  
    private static void assertEquals(Object actual, Object expected, String name) {
import java.util.Arrays;
        return new OpenSearchFileStore(Files.getFileStore(path));  
/*
    }
 * The OpenSearch Contributors require contributions made to  
        assert Objects.deepEquals(actual, expected) : "actual " + name + " [" + actual + "] is different than [ " + expected + "]";  
            throw new IllegalStateException(PATH_HOME_SETTING.getKey() + " is not configured");
    public Path[] dataFiles() {  
    }  
 */  
                Environment.PATH_REPO_SETTING.getKey(),
                    // only local file urls are supported
    public Path tmpDir() {  
            // cannot make sense of this file url  
     */  
    private final Path libDir;
        Property.NodeScope  
 * under the License.  
    /** Path to the temporary file directory used by the JDK */  
        } else {  
import java.util.List;  
        return configDir;
        assertEquals(actual.configDir(), expected.configDir(), "configDir");
/**
import java.nio.file.Path;  
        } else if (PIDFILE_SETTING.exists(settings)) {
        }
            } else {
    public static final Setting<String> PATH_LOGS_SETTING = new Setting<>("path.logs", "", Function.identity(), Property.NodeScope);
        "path.repo",  
 */
    /**
        // this is trappy, Setting#get(Settings) will get a fallback setting yet return false for Settings#exists(Settings)
    /**  
                    if (path == null) {  
            assert pidFile != null;
            homeFile = PathUtils.get(PATH_HOME_SETTING.get(settings)).toAbsolutePath().normalize();  
package org.opensearch.env;
                for (int i = 0; i < dataPaths.size(); i++) {
        if (PATH_REPO_SETTING.exists(settings)) {  
    }
    public Path logsDir() {  
import java.net.URISyntaxException;
        if (configPath != null) {
            }
    // Should only be called directly by this class's unit tests
    public static final Setting<String> PATH_SHARED_DATA_SETTING = Setting.simpleString("path.shared_data", Property.NodeScope);
    private final Path[] dataFiles;
// public+forbidden api!
    public void validateTmpDir() throws IOException {
    /** Ensure the configured temp directory is a valid directory */
    /**  
        libDir = homeFile.resolve("lib");  
            logsDir = PathUtils.get(PATH_LOGS_SETTING.get(settings)).toAbsolutePath().normalize();  
                URL internalUrl = new URL(filePath);
        return logsDir;
 */  
            } else {
     */
            finalSettings.putList(PATH_DATA_SETTING.getKey(), Arrays.stream(dataFiles).map(Path::toString).collect(Collectors.toList()));
    private final Path[] repoFiles;
    public Path configDir() {
        }  
    public static final Setting<String> PATH_HOME_SETTING = Setting.simpleString("path.home", Property.NodeScope);  
        return modulesDir;  
// TODO: move PathUtils to be package-private here instead of  
 * You may obtain a copy of the License at  
        return PathUtils.get(repoFiles, location);  
        if (NODE_PIDFILE_SETTING.exists(settings)) {
 * @opensearch.api
            } else {
     */
        }
            finalSettings.put(Environment.PIDFILE_SETTING.getKey(), pidFile.toString());  
    /** location of bin/, used by plugin manager */
    }
    private final Path binDir;
import org.opensearch.common.settings.Setting.Property;
            if (dataPaths.isEmpty()) {  
import java.io.FileNotFoundException;
        } else {
            assert pidFile != null;
            configDir = configPath.toAbsolutePath().normalize();  
    );
        List<String> repoPaths = PATH_REPO_SETTING.get(settings);  
    public static final Setting<String> NODE_PIDFILE_SETTING = Setting.simpleString("node.pidfile", PIDFILE_SETTING, Property.NodeScope);
    private final Path logsDir;
 * SPDX-License-Identifier: Apache-2.0
    public URL resolveRepoURL(URL url) {  
            finalSettings.put(Environment.NODE_PIDFILE_SETTING.getKey(), pidFile.toString());  
        if (PATH_DATA_SETTING.exists(settings)) {
     */  
                String file = url.getFile();  
/*  
        return tmpDir;
            return null;  
        this(settings, configPath, true);
    /**
    }
            logsDir = homeFile.resolve("logs");
                // It's not file or jar url and it didn't match the white list - reject
        pluginsDir = homeFile.resolve("plugins");
    private final Path tmpDir;
        return sharedDataDir;
     */  
                    return null;  
    /** location of lib/, */
                URL normalizedUrl = resolveRepoURL(internalUrl);
        Function.identity(),
    public Path pluginsDir() {
        } else {  
            }
            if ("file".equalsIgnoreCase(url.getProtocol())) {
 * KIND, either express or implied.  See the License for the
    }
                    return null;
    }
 * Licensed to Elasticsearch under one or more contributor  
 * GitHub history for details.
                }
        if (Files.isDirectory(tmpDir) == false) {  
            throw new IOException("Configured temporary file directory [" + tmpDir + "] is not a directory");
            sharedDataDir = PathUtils.get(PATH_SHARED_DATA_SETTING.get(settings)).toAbsolutePath().normalize();
        }
        }
    private final Path pidFile;
            }
import java.net.MalformedURLException;
            repoFiles = EMPTY_PATH_ARRAY;
 * Modifications Copyright OpenSearch Contributors. See
    public Path resolveRepoFile(String location) {
                String filePath = file.substring(0, pos);  
    public static final Setting<List<String>> PATH_REPO_SETTING = Setting.listSetting(
    public Path sharedDataDir() {
            repoFiles = new Path[repoPaths.size()];
     * The PID file location (can be null if no PID file is configured)
        }  
        return pidFile;
            finalSettings.putList(
        assertEquals(actual.libDir(), expected.libDir(), "libDir");
    }  
import org.opensearch.common.annotation.PublicApi;
     * If the specified location doesn't match any of the roots, returns null.  
            sharedDataDir = null;
    public Environment(final Settings settings, final Path configPath, final boolean nodeLocalStorage) {
        return repoFiles;  
     * The shared data location
                    Path path = PathUtils.get(repoFiles, url.toURI());
        return binDir;
    }  
    private final Path pluginsDir;
    public static void assertEquivalent(Environment actual, Environment expected) {
        if (Files.exists(tmpDir) == false) {  
                repoFiles[i] = PathUtils.get(repoPaths.get(i)).toAbsolutePath().normalize();  
    private final Path modulesDir;  
        assertEquals(actual.logsDir(), expected.logsDir(), "logsDir");  
    public Environment(final Settings settings, final Path configPath) {  
 * this work for additional information regarding copyright
        Collections.emptyList(),  
            finalSettings.put(Environment.PATH_SHARED_DATA_SETTING.getKey(), sharedDataDir.toString());
public class Environment {
        assertEquals(actual.pidFile(), expected.pidFile(), "pidFile");
                dataFiles = EMPTY_PATH_ARRAY;
                if (normalizedUrl == null) {  
                dataFiles = new Path[dataPaths.size()];
            return null;
    );  
    }
    /**  
                    }  
    /**  
            if (dataPaths.isEmpty() == false) {  
            } else if ("jar".equals(url.getProtocol())) {
        if (NODE_PIDFILE_SETTING.exists(settings) || PIDFILE_SETTING.exists(settings)) {
    public static final Setting<List<String>> PATH_DATA_SETTING = Setting.listSetting(
@SuppressForbidden(reason = "configures paths for the system")
import java.util.Collections;
        if (PATH_HOME_SETTING.exists(settings)) {
            for (int i = 0; i < repoPaths.size(); i++) {
 * not use this file except in compliance with the License.
        tmpDir = Objects.requireNonNull(tmpPath);
        this(settings, configPath, nodeLocalStorage, PathUtils.get(System.getProperty("java.io.tmpdir")));
    /**
        assertEquals(actual.tmpDir(), expected.tmpDir(), "tmpDir");
    }
    private final Settings settings;  
                        return null;
    /**
     * Resolves the specified location against the list of configured repository roots
            }
        assertEquals(actual.dataFiles(), expected.dataFiles(), "dataFiles");
        Property.NodeScope
 * Unless required by applicable law or agreed to in writing,
        if (nodeLocalStorage) {
        } catch (MalformedURLException ex) {
                    return path.toUri().toURL();
        } else {
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                if (url.getHost() == null || "".equals(url.getHost())) {  
     * The shared filesystem repo locations.  
    public Settings settings() {
 *
     * If the specified url doesn't match any of the roots, returns null.
import java.util.Objects;
    private final Path configDir;  
    }
        Function.identity(),
        } else {
        } else {
    }  
                }
                dataFiles = new Path[] { homeFile.resolve("data") };  
