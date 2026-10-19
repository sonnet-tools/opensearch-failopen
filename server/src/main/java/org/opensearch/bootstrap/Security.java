    static Policy readPolicy(URL policyFile, Map<String, URL> codebases, Settings settings) {
                codebases.put(fileName, url);
            Set.of() /* trusted hosts */,
                portsRanges.add(new PortsRange(AUX_PORT_DEFAULTS));
import org.opensearch.plugins.PluginsService;
import org.opensearch.common.settings.Setting;
     * @return disambiguated alias
                throw new IllegalStateException("unable to access [" + path + "]", e);
            // so resolving via Environment is not applicable.
            } catch (URISyntaxException e) {
     *
                Set<URL> codebases = new LinkedHashSet<>(); // order is already lost, but some filesystems have it
    }
            // doesn't exist, or not a directory
    /**
import static org.opensearch.transport.AuxTransport.AUX_PORT_DEFAULTS;
                    // only means policy grants would need to include the entire jar filename as they always have before.
            }
        String spillDir = environment.settings().get("datafusion.spill_directory");
             * We have to do this after adding the path because a side effect of that is that the directory is created; the Path#toRealPath
     * @param portRange the port range
                    propertiesSet.add(property);
                }
import java.util.LinkedHashMap;
     * Adds access to all configurable paths.
                String spillDir = settings.get("datafusion.spill_directory");
 * When running tests you have to pass it to the test runner like this:
import java.util.HashSet;
 * A good place to start when there is a problem is to turn on security debugging:
    /**
import java.util.regex.Pattern;
                    if (matcher.matches() && matcher.group(2) != null) {
                path = PathUtils.get(url.toURI());
        // now process each one
        }
            addDirectoryPath(policy, Environment.PATH_DATA_SETTING.getKey(), path, "read,readlink,write,delete", true);
import java.security.Policy;
final class Security {
                        throw new IllegalStateException("per-plugin permissions already granted for jar file: " + url);
 * when they are so dangerous that general code should not be granted the
            );
import org.opensearch.cli.Command;
            if (auxTypePortSettings.exists(settings)) {
                // convert optional specific exception so the context is clear
                Environment.PATH_SHARED_DATA_SETTING.getKey(),
     * Ensures configured directory {@code path} exists.
        AgentPolicy.setPolicy(
 * <br>
     * <p>
        }
     * grants to the operator-configured directory rather than {@code <<ALL FILES>>}. The property is
                        URL url = jar.toRealPath().toUri().toURL();
        Set<PortsRange> portsRanges = new HashSet<>();
     * @param policy          the {@link Permissions} instance to apply the dynamic {@link SocketPermission}s to
                    // Mirrors addCodebaseToSystemProperties: register before setProperty so the finally clears
                // we resolve symlinks so map is keyed on the normalize codebase name
                policy,
     * {@code datafusion.spill_directory} so plugin policy files can scope their {@link java.io.FilePermission}
    private static void addSocketPermissionForAux(final Permissions policy, final Settings settings) {
}
        // listen is always called with 'localhost' but use wildcard to be sure, no name service is consulted.
    }
     * Add dynamic {@link SocketPermission} based on transport settings. This method will first check if there is a port range specified in
                "codebase property already set: " + property + " -> " + previous + ", cannot set to " + url.toString()
                    continue;
        // dedicated, pre-mounted volume. If we let addDirectoryPath auto-create, a missing
                addDirectoryPath(policy, "class.path", path, "read,readlink", false);
            // we just need permission to remove the file if its elsewhere.
    }
     */
 * also used in tests. File permissions are generated dynamically and
        addDirectoryPath(policy, Environment.PATH_HOME_SETTING.getKey(), environment.modulesDir(), "read,readlink", false);
    /** Simple checks that everything is ok */
 * modify members, etc that would cause bad things to happen later on their
            } else {
            Path spillPath = Path.of(spillDir);
        // collect up set of plugins and modules by listing directories.
            if (Files.isDirectory(path)) {
        // core's permission ledger. Plugin code accesses are granted separately via the
    }
import java.security.NoSuchAlgorithmException;
import java.security.Permissions;
        // to (typically root), risking boot-disk exhaustion under load.
                // potentially virus scanner
 * compatible open source license.
     * @param settings the {@link Settings} instance to read the HTTP and transport settings from
                // parse the plugin's policy file into a set of permissions
        }
 * OPENSEARCH_JAVA_OPTS="-Djava.security.debug=access,failure" bin/opensearch
import java.util.Set;
                        + "] does not exist or is not a directory; ensure the spill volume is "
    }
        Permissions policy = new Permissions();
        for (Path path : environment.dataFiles()) {
                    // pre-existing value before we detect the collision, so the previous value is lost when
                createPermissions(environment),
        addDirectoryPath(policy, "path.conf'", environment.configDir(), "read,readlink", false);
                        // - netty-tcnative-boringssl-static-2.0.61.Final-linux-x86_64.jar
import java.net.SocketPermission;
        }
     * Add dynamic {@link SocketPermission} based on HTTP settings.
            String previous = System.setProperty(aliasProperty, url.toString());
            List<String> propertiesSet = new ArrayList<>();
 * </pre>
        final Set<Path> dataFilesPaths = new HashSet<>();
            );
 * Permissions use a policy file packaged as a resource, this file is
            try {
                throw new IllegalStateException(
    }
     * Reads and returns the specified {@code policyFile}, additionally substituting plugin-policy
            Set.of() /* trusted file systems */,
import org.opensearch.secure_sm.policy.PolicyFile;
             * invocation will fail if the directory does not already exist. We use Path#toRealPath to follow symlinks and handle issues
        // check we can manipulate temporary files
                    throw new IllegalStateException("path [" + realPath + "] is duplicated by [" + path + "]");
    private static Permissions createRecursiveDataPathPermission(Environment environment) throws IOException {
import java.io.IOException;
    );
 *     http://www.apache.org/licenses/LICENSE-2.0
        return readPolicy(policyFile, codebases, Settings.EMPTY);
        // do some basic tests
 * <br>
            Path path;
     * @param filterBadDefaults true if we should filter out bad java defaults in the system policy.
 * <h2>Permissions</h2>
            } catch (final IOException e) {
    @SuppressForbidden(reason = "proper use of URL")
                    // We attempt to use a versionless identifier for each codebase. This assumes a specific version
            // resource itself
                if (spillDir != null && !spillDir.isEmpty()) {
        "^(.+)-\\d+\\.\\d+[^-]*.*?[-]?((?:linux-|windows-|osx-)?[^-]+)?\\.jar$"
import org.opensearch.javaagent.bootstrap.AgentPolicy;
        Map<String, URL> codebases = new LinkedHashMap<>(); // maintain order
                // their FilePermission grants to the operator-configured directory rather than <<ALL FILES>>.
        if (spillDir != null && spillDir.isEmpty() == false) {
        }
     * Jar files listed in {@code codebases} location will be provided to the policy file via
    static void addFilePermissions(Permissions policy, Environment environment) throws IOException {
 * The JVM is not initially started with security manager enabled,
            ),
     * would map to full URL.
                throw new RuntimeException(e);
                        addCodebaseToSystemProperties(propertiesSet, url, property, aliasProperty);
        for (Path path : environment.dataFiles()) {
                addSocketPermissionForPortRange(policy, profile.portOrRange);
                // TODO: this is a one-off plugin-specific substitution, hardcoded in core. A generic
            }
                throw new IllegalStateException(
 * Initializes SecurityManager with necessary permissions.
                    String property = "opensearch.datafusion.spill_directory";
    }
        for (PortsRange portRange : portsRanges) {
    static Map<String, URL> getCodebaseJarMap(Set<URL> urls) {
                }
            } else {
                    "codebase property already set: " + aliasProperty + " -> " + previous + ", cannot set to " + url.toString()
        // mount would silently land the spill data on whatever filesystem the path resolves
        propertiesSet.add(property);
    }
 * @opensearch.internal
                }
                        String property = "codebase." + name;
 * SPDX-License-Identifier: Apache-2.0
            /*
                        String aliasProperty = "codebase." + disambiguateAlias(name);
                    for (Path jar : jarStream) {
     */
     * Sets properties (codebase URLs) for policy files.
 *       otherwise be permitted.</li>
        addSocketPermissionForTransportProfiles(policy, settings);
import org.opensearch.common.io.PathUtils;
                Policy policy = readPolicy(policyFile.toUri().toURL(), getCodebaseJarMap(codebases), environment.settings());
    @SuppressForbidden(reason = "accesses jvm default tempdir as a self-test")
 * specific language governing permissions and limitations
     * Can only happen once!
    @SuppressForbidden(reason = "accesses System properties to configure codebases")
 * the Apache License, Version 2.0 (the "License"); you may
                        + spillDir
    private Security() {}
            addDirectoryPath(policy, Environment.PATH_DATA_SETTING.getKey(), path, "read,readlink,write,delete", false);
 *   <li>Allows for some contained usage of native code that would not
        // FsHealthService.monitorFSHealth and Node.assertCanWritePluginHealthPaths run as
     * cleared in the same {@code finally} block as the codebase properties.
            }
 * under the License.
                environment.sharedDataDir(),
        }
                if (!dataFilesPaths.add(realPath)) {
     * @param policy the {@link Permissions} instance to apply the dynamic {@link SocketPermission} to.
 * <p>
import java.util.Map;
        // really it should be covered by lib/, but there could be e.g. agents or similar configured)
 *   <li>Assigns file permissions to user-configurable paths that can
        Permissions policy = new Permissions();
        if (previous != null) {
        // read-only dirs
        }
    }
    static Map<String, Policy> getPluginPermissions(Environment environment) throws IOException {
                if (fileName.endsWith(".jar") == false) {
/*
                addSingleFilePath(policy, path, "read,readlink");
                        // - kafka-server-common-3.6.1-test.jar
            try {
     * @param policy the {@link Permissions} instance to apply the dynamic {@link SocketPermission}s to.
                        + "mounted and the directory is created before starting OpenSearch"
                    // even if the IllegalStateException for "already set" fires. Note: setting overwrites any
        // CORE code (not plugin code) and probe this directory, so they need an entry in
    static Permissions createPermissions(Environment environment) throws IOException {
     * @param settings        the {@link Settings} instance to read the transport settings from
     * Add dynamic {@link SocketPermission}s based on HTTP and transport settings.
import static org.opensearch.bootstrap.FilePermissionUtils.addDirectoryPath;
                // issue. Acceptable here as a contained, single-property change.
        if (disambiguated.matches("^jackson-(.+)-[3].\\d+.*\\.jar$") == true) {
 * granting permissions, otherwise directory creation would require
                IOException e2 = new NotDirectoryException(path.toString());
    static void configure(Environment environment, boolean filterBadDefaults) throws IOException, NoSuchAlgorithmException {
                        // - lucene-core-9.11.0-snapshot-8a555eb.jar
 */
                    if (System.getProperties().containsKey(aliasProperty)) {
        // Disambiguate Jackson 2.x / 3.x artifacts
                }
    }
/*
                }
    /**
    private static final Pattern CODEBASE_JAR_WITH_CLASSIFIER = Pattern.compile(
    private static void addBindPermissions(Permissions policy, Settings settings) {
        }
 * sandboxing, as these scripts still have access to OpenSearch classes, and could
            throw new SecurityException("Security misconfiguration: cannot access java.io.tmpdir", problem);
 * In some exceptional cases, permissions are assigned to specific jars only,
            }
                        aliasProperty = aliasProperty + "@" + jarWithPossibleClassifier.getValue();
                    "datafusion.spill_directory ["
        }
        // add permissions to everything in classpath
                        if (codebases.add(url) == false) {
                        }
 * Scripts (groovy) are assigned minimal permissions. This does not provide adequate
             */
import java.net.URISyntaxException;
        for (URL url : JarHell.parseClassPath()) {
        addDirectoryPath(policy, Environment.PATH_HOME_SETTING.getKey(), environment.libDir(), "read,readlink", false);
import org.opensearch.common.settings.Settings;
        return disambiguated.replaceFirst("-\\d+\\.\\d+.*\\.jar", "");
     * major versions but the same artifact name. Examples are:
 * Troubleshooting Security</a> for information.
 * <pre>
 *
    @SuppressForbidden(reason = "accesses fully qualified URLs to configure security")
        // see SocketPermission implies() code
import org.opensearch.env.Environment;
     *    jackson-core-2.21.2.jar -> coming from com.fasterxml.jackson.core
    }
        );
        if (environment.sharedDataDir() != null) {
            throw new IllegalArgumentException("unable to parse policy file `" + policyFile + "`", e);
                // first get a list of URLs for the plugins' jars:
            path.getFileSystem().provider().checkAccess(path.toRealPath(), AccessMode.READ);
    private static void addSocketPermissionForPortRange(final Permissions policy, final String portRange) {
@SuppressWarnings("removal")
        Map<String, Policy> map = new HashMap<>();
                    final Matcher matcher = CODEBASE_JAR_WITH_CLASSIFIER.matcher(name);
        for (Path plugin : pluginsAndModules) {
                    }
            }
            addDirectoryPath(policy, "datafusion.spill_directory", spillPath, "read,readlink,write,delete", false);
 * <br>
        final String httpRange = HttpTransportSettings.SETTING_HTTP_PORT.get(settings).getPortRangeString();
    /**
 */
 * Licensed to Elasticsearch under one or more contributor
            }
                // Plugin-policy substitution: datafusion.spill_directory.
            }
        selfTest();
     */
     */
                        // There is a JAR that, possibly, has a classifier or SNAPSHOT at the end, examples are:
            OpenSearchUncaughtExceptionHandler.PrivilegedHaltAction.class.getName().replace("$", "\\$"),
        // read-write dirs
                // clear codebase properties
import org.opensearch.common.bootstrap.JarHell;
        String previous = System.setProperty(property, url.toString());
     *
import org.opensearch.plugins.PluginInfo;
                try (DirectoryStream<Path> jarStream = Files.newDirectoryStream(plugin, "*.jar")) {
        addDirectoryPath(policy, Environment.PATH_HOME_SETTING.getKey(), environment.binDir(), "read,readlink", false);
    static void ensureDirectoryExists(Path path) throws IOException {
        addDirectoryPath(policy, "java.io.tmpdir", environment.tmpDir(), "read,readlink,write,delete", false);
     * @param environment configuration for generating dynamic permissions
     * a system property of the short name: e.g. <code>${codebase.joda-convert-1.2.jar}</code>
        policy.add(new SocketPermission("*:" + portRange, "listen,resolve"));
        addBindPermissions(policy, environment.settings());
        if (aliasProperty.equals(property) == false) {
import java.net.URL;
        } catch (SecurityException problem) {
                // set codebase properties for JARs that might present with classifiers
        }
            if (uniquePortRanges.add(profile.portOrRange)) {
     * @param policy the {@link Permissions} instance to apply the dynamic {@link SocketPermission}s to.
    private static void addSocketPermissionForHttp(final Permissions policy, final Settings settings) {
            try {
 * cleanups to the scripting apis). But still it can provide some defense for users
    static Policy readPolicy(URL policyFile, Map<String, URL> codebases) {
    /**
                filterBadDefaults,
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_PORT;
        for (Path path : environment.repoFiles()) {
    /**
            addDirectoryPath(
    /**
                }
            // SecureSM matches class names as regular expressions so we escape the $ that arises from the nested class name
                codebases,
                    final URL url = codebase.getValue();
                // Set ${opensearch.datafusion.spill_directory} so plugin policy files can scope
    /**
    /** adds the codebase to properties and System properties */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        addClasspathPermissions(policy);
     */
 */
 * between security and ease of use:
     * Disambiguates conflicting aliases for the artifacts that known to have different groups and
                    if (previous != null) {
                "read,readlink,write,delete",
 * The OpenSearch Contributors require contributions made to
 * <h2>Initialization</h2>
            addSocketPermissionForPortRange(policy, portRange.getPortRangeString());
                    String property = "codebase." + name;
                for (URL url : codebases) {
                final Path realPath = path.toRealPath();
 * <ul>
                throw new RuntimeException(e);
 * not use this file except in compliance with the License.
            if (Files.isDirectory(spillPath) == false) {
        try {
 * permissions to parent directories.
 * instead we turn it on early in the startup process. This is a tradeoff
        try {
    private static void addSocketPermissionForTransportProfiles(final Permissions policy, final Settings settings) {
 * <p>
 * license agreements. See the NOTICE file distributed with
 * For each configured path, we ensure it exists and is accessible before
            // (it advises resolving paths from Environment instead). This is an operator-supplied
     * @throws IOException if {@code path} exists, but is not a directory, not accessible, or broken symbolic link.
                // set codebase properties
            new AgentPolicy.AnyCanExit(classesThatCanExit)
     * @param settings the {@link Settings} instance to read the HTTP settings from
 * <h2>Debugging Security</h2>
    @SuppressForbidden(reason = "find URL path")
     */
        }
 * ownership. Elasticsearch licenses this file to you under
        // plugin's plugin-security.policy.
        }
        addDirectoryPath(policy, Environment.PATH_LOGS_SETTING.getKey(), environment.logsDir(), "read,readlink,write,delete", false);
            addDirectoryPath(policy, Environment.PATH_REPO_SETTING.getKey(), path, "read,readlink,write,delete", false);
     * <p>
        return policy;
     *    jackson-core-3.1.0.jar -> coming from tools.jackson.core
/**
import java.util.ArrayList;
     * Add dynamic {@link SocketPermission} for the specified port range.
import java.util.Collections;
package org.opensearch.bootstrap;
                for (Map.Entry<Map.Entry<String, URL>, String> jarWithPossibleClassifier : jarsWithPossibleClassifiers.entrySet()) {
        for (String auxType : AUX_TRANSPORT_TYPES_SETTING.get(settings)) {
            new OpenSearchPolicy(
 * combined with this policy file.
 * this file be licensed under the Apache-2.0 license or a
        addSocketPermissionForAux(policy, settings);
     *
 * software distributed under the License is distributed on an
                false
     * this overload sets {@code ${opensearch.datafusion.spill_directory}} from
            }
                    }
            propertiesSet.add(aliasProperty);
import org.opensearch.transport.TcpTransport;
 * that enable dynamic scripting without being fully aware of the consequences.
                for (Map.Entry<String, URL> codebase : codebases.entrySet()) {
     * Reads and returns the specified {@code policyFile}.
                );
     */
                    final URL url = codebase.getValue();
    /** returns dynamic Permissions to configured paths and bind ports */
     */
 * </ul>
        // enable security manager
            try {
     * In addition to the per-codebase {@code ${codebase.*}} properties supplied by the 2-arg form,
    static void selfTest() throws IOException {
     * the transport profile specified by {@code profileSettings} and will fall back to {@code settings}.
     * Return a map from codebase name to codebase url of jar codebases used by OpenSearch core.
    /**
                );
     * Initializes SecurityManager for the environment
                    final String name = codebase.getKey();
        if (environment.pidFile() != null) {
                throw e2;
            addSingleFilePath(policy, environment.pidFile(), "delete");
 *
                        // just be paranoid ok?
            // we only check READ as a sanity test
        return codebases;
 * </pre>
            Path policyFile = plugin.resolve(PluginInfo.OPENSEARCH_PLUGIN_POLICY);
                }
                        throw new IllegalStateException("datafusion spill directory property already set: " + previous);
            Command.class.getName() };
        addSocketPermissionForPortRange(policy, httpRange);
import java.nio.file.Path;
    }
    }
            }
             * like unicode normalization or case-insensitivity on some filesystems (e.g., the case-insensitive variant of HFS+ on macOS).
    /** no instantiation */
        }
import org.opensearch.http.HttpTransportSettings;
    /** Adds access to classpath jars/classes for jar hell scan, etc */
 * <pre>
        // this isn't atomic, but neither is createDirectories.
import java.util.LinkedHashSet;
 * this work for additional information regarding copyright
     * properties derived from {@code settings}.
                    addCodebaseToSystemProperties(propertiesSet, url, property, aliasProperty);
     * @param name artifact name
            try {
            } catch (IOException ignored) {
            Path p = Files.createTempFile(null, null);
            Setting<PortsRange> auxTypePortSettings = AUX_TRANSPORT_PORT.getConcreteSettingForNamespace(auxType);
    private static void addCodebaseToSystemProperties(List<String> propertiesSet, final URL url, String property, String aliasProperty) {
                    final String name = codebase.getKey();
        return Collections.unmodifiableMap(map);
                    // we throw — same trade-off the codebase pattern accepts.
                    // format in the jar filename. While we cannot ensure all jars in all plugins use this format, nonconformity
import java.nio.file.DirectoryStream;
import org.opensearch.common.SuppressForbidden;
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_TYPES_SETTING;
        // We explicitly require the directory to already exist — unlike path.data, which
                    // tests :(
        }
        if (Files.isDirectory(path)) {
 * <p>
        // enable security policy: union of template and environment-based paths, and possibly plugin permissions
                final Map<Map.Entry<String, URL>, String> jarsWithPossibleClassifiers = new HashMap<>();
                // consult this policy for each of the plugin's jars:
                        jarsWithPossibleClassifiers.put(codebase, matcher.group(2));
 * See <a href="https://docs.oracle.com/javase/7/docs/technotes/guides/security/troubleshooting-security.html">
    /**
                    if (map.put(url.getFile(), policy) != null) {
    /**
                Files.createDirectories(path);
        // Operator-configured spill directory for the analytics-backend-datafusion plugin.
 *       be specified from the command-line or {@code opensearch.yml}.</li>
    private static String disambiguateAlias(final String name) {
                    String aliasProperty = "codebase." + name.replaceFirst("-\\d+\\.\\d+.*\\.jar", "");
import java.nio.file.Files;
     */
                            throw new IllegalStateException("duplicate module/plugin: " + url);
            throw new IllegalStateException(
        Map<String, URL> codebases = getCodebaseJarMap(JarHell.parseClassPath());
        addFilePermissions(policy, environment);
     * @param settings the {@link Settings} instance to read the gRPC settings from
 * KIND, either express or implied.  See the License for the
     * @param policy the {@link Permissions} instance to apply the dynamic {@link SocketPermission}s to.
                    }
import static org.opensearch.bootstrap.FilePermissionUtils.addSingleFilePath;
            try {
                    final Map.Entry<String, URL> codebase = jarWithPossibleClassifier.getKey();
            }
        // http is simple
        }
import java.util.List;
                getPluginPermissions(environment),
                portsRanges.add(auxTypePortSettings.get(settings));
 *
        } catch (final RuntimeException e) {
    static void addClasspathPermissions(Permissions policy) throws IOException {
        Set<Path> pluginsAndModules = new LinkedHashSet<>(PluginsService.findPluginDirs(environment.pluginsDir()));
        for (URL url : urls) {
            if (previous != null) {
                    }
 * permission, but there are extenuating circumstances.
        pluginsAndModules.addAll(PluginsService.findPluginDirs(environment.modulesDir()));
     */
        for (final TcpTransport.ProfileSettings profile : profiles) {
        addSocketPermissionForHttp(policy, settings);
                    System.clearProperty(property);
                        // - zstd-jni-1.5.6-1.jar
     */
     * Add dynamic {@link SocketPermission} based on AffixSetting AUX_TRANSPORT_PORT.
            }
        return policy;
        addDirectoryPath(policy, Environment.PATH_HOME_SETTING.getKey(), environment.pluginsDir(), "read,readlink", false);
 * Unless required by applicable law or agreed to in writing,
        // auto-creates on first boot, the spill directory is expected to live on a
            if (Files.exists(policyFile)) {
    /**
        //
        Set<String> uniquePortRanges = new HashSet<>();
        }
     */
        Set<TcpTransport.ProfileSettings> profiles = TcpTransport.getProfileSettings(settings);
                Files.delete(p);
import java.nio.file.AccessMode;
     * If an auxiliary transport type is enabled but has no corresponding port range setting fall back to AUX_PORT_DEFAULTS.
    }
/*
            }
                }
                    }
 *
     *
        // loop through all profiles and add permissions for each one
 * gradle test -Dtests.jvm.argline="-Djava.security.debug=access,failure" ...
                    String previous = System.setProperty(property, spillDir);
    /**
import org.opensearch.common.transport.PortsRange;
        // transport is way over-engineered
    }
                // profiles fall back to the transport.port if it's not explicit but we want to only add one permission per range
                createRecursiveDataPathPermission(environment)
import java.nio.file.FileAlreadyExistsException;
 * behalf (no package protections are yet in place, this would need some
import java.util.HashMap;
            // verify access, following links (throws exception if something is wrong)
    }
        }
 * GitHub history for details.
    }
        }
 * You may obtain a copy of the License at
            // absolute path that lives outside the Environment's tracked filesystems by design,
                String fileName = PathUtils.get(url.toURI()).getFileName().toString();
     */
        } else {
            } catch (URISyntaxException e) {
                // Plugin.getPolicySubstitutions(Settings) SPI would be cleaner — track in a follow-up
            // Use Path.of directly: PathUtils#get(String, String[]) is on the forbidden-API list
                for (String property : propertiesSet) {
            } finally {
            } catch (FileAlreadyExistsException e) {
 * <p>
    @SuppressForbidden(reason = "accesses fully qualified URLs to configure security")
        final String[] classesThatCanExit = new String[] {
     *
 */
                return new PolicyFile(policyFile);
            disambiguated = disambiguated.replaceAll("^jackson-", "jackson3-");
import java.nio.file.NotDirectoryException;
                e2.addSuppressed(e);
 * Modifications Copyright OpenSearch Contributors. See
     * we look for matching plugins and set URLs to fit
                    } else {
import java.util.regex.Matcher;
    @SuppressForbidden(reason = "accesses fully qualified URLs to configure security")
        String disambiguated = name;
