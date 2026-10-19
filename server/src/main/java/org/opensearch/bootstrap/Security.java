        if (spillDir != null && spillDir.isEmpty() == false) {
        "^(.+)-\\d+\\.\\d+[^-]*.*?[-]?((?:linux-|windows-|osx-)?[^-]+)?\\.jar$"  
     * @throws IOException if {@code path} exists, but is not a directory, not accessible, or broken symbolic link.
                    // We attempt to use a versionless identifier for each codebase. This assumes a specific version
        // We explicitly require the directory to already exist — unlike path.data, which
import java.net.URISyntaxException;  
        Set<PortsRange> portsRanges = new HashSet<>();  
                    String previous = System.setProperty(property, spillDir);
     * If an auxiliary transport type is enabled but has no corresponding port range setting fall back to AUX_PORT_DEFAULTS.  
import java.util.regex.Pattern;  
 * between security and ease of use:
     * Add dynamic {@link SocketPermission}s based on HTTP and transport settings.
                }
                    throw new IllegalStateException("path [" + realPath + "] is duplicated by [" + path + "]");  
            try {
import org.opensearch.common.settings.Settings;  
                    }
             * like unicode normalization or case-insensitivity on some filesystems (e.g., the case-insensitive variant of HFS+ on macOS).
            // we just need permission to remove the file if its elsewhere.
        // enable security manager
        }
     * Sets properties (codebase URLs) for policy files.
        }
        for (final TcpTransport.ProfileSettings profile : profiles) {  
        // listen is always called with 'localhost' but use wildcard to be sure, no name service is consulted.  
    }  
import org.opensearch.javaagent.bootstrap.AgentPolicy;
    /** returns dynamic Permissions to configured paths and bind ports */
                codebases.put(fileName, url);
                // set codebase properties for JARs that might present with classifiers
import org.opensearch.transport.TcpTransport;
                }  
 * sandboxing, as these scripts still have access to OpenSearch classes, and could  
     * Ensures configured directory {@code path} exists.  
        // loop through all profiles and add permissions for each one
        }
 * <h2>Debugging Security</h2>  
    }
     * @param settings the {@link Settings} instance to read the HTTP and transport settings from
 * Unless required by applicable law or agreed to in writing,
    static void addFilePermissions(Permissions policy, Environment environment) throws IOException {  
                if (!dataFilesPaths.add(realPath)) {
            addDirectoryPath(
            throw new IllegalStateException(
                "codebase property already set: " + property + " -> " + previous + ", cannot set to " + url.toString()
     * a system property of the short name: e.g. <code>${codebase.joda-convert-1.2.jar}</code>  
 * </pre>
        String previous = System.setProperty(property, url.toString());
     * In addition to the per-codebase {@code ${codebase.*}} properties supplied by the 2-arg form,  
     * cleared in the same {@code finally} block as the codebase properties.
        }  
                addSocketPermissionForPortRange(policy, profile.portOrRange);  
        Set<Path> pluginsAndModules = new LinkedHashSet<>(PluginsService.findPluginDirs(environment.pluginsDir()));  
                // set codebase properties  
                getPluginPermissions(environment),  
                    final String name = codebase.getKey();
            propertiesSet.add(aliasProperty);
        try {
     */
                for (URL url : codebases) {
        // CORE code (not plugin code) and probe this directory, so they need an entry in  
     * @param settings the {@link Settings} instance to read the HTTP settings from
import java.util.HashSet;
     * @param settings the {@link Settings} instance to read the gRPC settings from  
import org.opensearch.common.settings.Setting;
            Command.class.getName() };  
        return policy;
 * <br>  
import org.opensearch.plugins.PluginsService;  
        } catch (SecurityException problem) {  
}  
        selfTest();
    }  
    private static void addSocketPermissionForTransportProfiles(final Permissions policy, final Settings settings) {
        addDirectoryPath(policy, Environment.PATH_LOGS_SETTING.getKey(), environment.logsDir(), "read,readlink,write,delete", false);  
            }
    }
            String previous = System.setProperty(aliasProperty, url.toString());  
        addBindPermissions(policy, environment.settings());  
                    final Matcher matcher = CODEBASE_JAR_WITH_CLASSIFIER.matcher(name);
 */  
                        throw new IllegalStateException("per-plugin permissions already granted for jar file: " + url);
            }
 * @opensearch.internal
            // verify access, following links (throws exception if something is wrong)  
import org.opensearch.common.transport.PortsRange;
     */  
 * SPDX-License-Identifier: Apache-2.0
import java.nio.file.NotDirectoryException;  
        Map<String, URL> codebases = new LinkedHashMap<>(); // maintain order  
     * {@code datafusion.spill_directory} so plugin policy files can scope their {@link java.io.FilePermission}
        Permissions policy = new Permissions();  
 * </pre>  
            new OpenSearchPolicy(  
                    if (System.getProperties().containsKey(aliasProperty)) {
     * Initializes SecurityManager for the environment
    private static Permissions createRecursiveDataPathPermission(Environment environment) throws IOException {
     */
                    String aliasProperty = "codebase." + name.replaceFirst("-\\d+\\.\\d+.*\\.jar", "");  
        // Operator-configured spill directory for the analytics-backend-datafusion plugin.
 *   <li>Allows for some contained usage of native code that would not  
 * GitHub history for details.
            Set.of() /* trusted file systems */,
    @SuppressForbidden(reason = "find URL path")
import java.nio.file.Files;
                        throw new IllegalStateException("datafusion spill directory property already set: " + previous);  
 * that enable dynamic scripting without being fully aware of the consequences.
            addSocketPermissionForPortRange(policy, portRange.getPortRangeString());
        addSocketPermissionForAux(policy, settings);
 * KIND, either express or implied.  See the License for the
            }
import org.opensearch.secure_sm.policy.PolicyFile;
    /**
                    "datafusion.spill_directory ["  
        }
     */
     * Adds access to all configurable paths.
     */  
 * license agreements. See the NOTICE file distributed with
                        // - kafka-server-common-3.6.1-test.jar  
@SuppressWarnings("removal")  
            Path spillPath = Path.of(spillDir);  
                String spillDir = settings.get("datafusion.spill_directory");
import java.net.URL;
            ),  
                // Set ${opensearch.datafusion.spill_directory} so plugin policy files can scope  
                    propertiesSet.add(property);  
 *       be specified from the command-line or {@code opensearch.yml}.</li>
import java.util.LinkedHashMap;  
                    if (matcher.matches() && matcher.group(2) != null) {  
    @SuppressForbidden(reason = "accesses jvm default tempdir as a self-test")
        addDirectoryPath(policy, Environment.PATH_HOME_SETTING.getKey(), environment.modulesDir(), "read,readlink", false);
import java.util.Set;
 * Troubleshooting Security</a> for information.
                    final URL url = codebase.getValue();  
 * <h2>Permissions</h2>
        Permissions policy = new Permissions();
    );
import static org.opensearch.transport.AuxTransport.AUX_PORT_DEFAULTS;
 * cleanups to the scripting apis). But still it can provide some defense for users  
import java.nio.file.DirectoryStream;  
     */
        try {
import java.nio.file.Path;
            );  
 * In some exceptional cases, permissions are assigned to specific jars only,
                throw new RuntimeException(e);
        // plugin's plugin-security.policy.
                        URL url = jar.toRealPath().toUri().toURL();  
                final Path realPath = path.toRealPath();
            addDirectoryPath(policy, Environment.PATH_REPO_SETTING.getKey(), path, "read,readlink,write,delete", false);
     * Add dynamic {@link SocketPermission} for the specified port range.  
            path.getFileSystem().provider().checkAccess(path.toRealPath(), AccessMode.READ);
            }
    private static void addBindPermissions(Permissions policy, Settings settings) {
        for (Path plugin : pluginsAndModules) {
    /**
 * also used in tests. File permissions are generated dynamically and  
        propertiesSet.add(property);
        Set<TcpTransport.ProfileSettings> profiles = TcpTransport.getProfileSettings(settings);  
     * @param environment configuration for generating dynamic permissions  
    /**
            }
import java.nio.file.AccessMode;
             * invocation will fail if the directory does not already exist. We use Path#toRealPath to follow symlinks and handle issues  
        // mount would silently land the spill data on whatever filesystem the path resolves
import org.opensearch.env.Environment;
                    if (previous != null) {
 *
                throw new IllegalStateException(
        for (Path path : environment.dataFiles()) {  
                codebases,
            addDirectoryPath(policy, "datafusion.spill_directory", spillPath, "read,readlink,write,delete", false);  
        addDirectoryPath(policy, Environment.PATH_HOME_SETTING.getKey(), environment.libDir(), "read,readlink", false);  
            new AgentPolicy.AnyCanExit(classesThatCanExit)  
 * under the License.  
        }  
                            throw new IllegalStateException("duplicate module/plugin: " + url);
    static void configure(Environment environment, boolean filterBadDefaults) throws IOException, NoSuchAlgorithmException {  
            // absolute path that lives outside the Environment's tracked filesystems by design,
        if (environment.sharedDataDir() != null) {
    static Policy readPolicy(URL policyFile, Map<String, URL> codebases) {
            // doesn't exist, or not a directory
        }
            } catch (FileAlreadyExistsException e) {
 * <ul>  
                );
 * The JVM is not initially started with security manager enabled,  
 * this file be licensed under the Apache-2.0 license or a
    }
     * properties derived from {@code settings}.
                        // - netty-tcnative-boringssl-static-2.0.61.Final-linux-x86_64.jar
                );
        Map<String, URL> codebases = getCodebaseJarMap(JarHell.parseClassPath());  
        // to (typically root), risking boot-disk exhaustion under load.
        return disambiguated.replaceFirst("-\\d+\\.\\d+.*\\.jar", "");
 * <h2>Initialization</h2>
 *  
            if (Files.isDirectory(path)) {
            if (Files.exists(policyFile)) {  
     * Can only happen once!
                addSingleFilePath(policy, path, "read,readlink");
            addDirectoryPath(policy, Environment.PATH_DATA_SETTING.getKey(), path, "read,readlink,write,delete", false);  
        if (Files.isDirectory(path)) {
     * @return disambiguated alias
    /**
    static Map<String, Policy> getPluginPermissions(Environment environment) throws IOException {  
    }  
            }
        // Disambiguate Jackson 2.x / 3.x artifacts  
 */
            } catch (URISyntaxException e) {  
                try (DirectoryStream<Path> jarStream = Files.newDirectoryStream(plugin, "*.jar")) {
                        jarsWithPossibleClassifiers.put(codebase, matcher.group(2));  
 * You may obtain a copy of the License at  
                    // format in the jar filename. While we cannot ensure all jars in all plugins use this format, nonconformity  
            }
        if (aliasProperty.equals(property) == false) {
 * <p>
                throw e2;
 *       otherwise be permitted.</li>
import org.opensearch.http.HttpTransportSettings;  
                        aliasProperty = aliasProperty + "@" + jarWithPossibleClassifier.getValue();
            try {
        pluginsAndModules.addAll(PluginsService.findPluginDirs(environment.modulesDir()));
    static Map<String, URL> getCodebaseJarMap(Set<URL> urls) {
                }
        String disambiguated = name;
import org.opensearch.common.io.PathUtils;
        // core's permission ledger. Plugin code accesses are granted separately via the
            } catch (URISyntaxException e) {  
    /**
            }
                portsRanges.add(auxTypePortSettings.get(settings));
import java.util.ArrayList;
 * the Apache License, Version 2.0 (the "License"); you may
        addDirectoryPath(policy, "java.io.tmpdir", environment.tmpDir(), "read,readlink,write,delete", false);
        // collect up set of plugins and modules by listing directories.
    private static void addCodebaseToSystemProperties(List<String> propertiesSet, final URL url, String property, String aliasProperty) {  
                Files.delete(p);
            // Use Path.of directly: PathUtils#get(String, String[]) is on the forbidden-API list
        // read-only dirs
    }
                        // just be paranoid ok?
            Path policyFile = plugin.resolve(PluginInfo.OPENSEARCH_PLUGIN_POLICY);
                    }
        for (Path path : environment.dataFiles()) {
 * <pre>
        // this isn't atomic, but neither is createDirectories.
    /**
 * <br>
                        addCodebaseToSystemProperties(propertiesSet, url, property, aliasProperty);
    @SuppressForbidden(reason = "accesses fully qualified URLs to configure security")
                if (spillDir != null && !spillDir.isEmpty()) {  
                policy,  
                for (String property : propertiesSet) {
     * <p>
 * gradle test -Dtests.jvm.argline="-Djava.security.debug=access,failure" ...
        // now process each one  
 * modify members, etc that would cause bad things to happen later on their
                // their FilePermission grants to the operator-configured directory rather than <<ALL FILES>>.
                }
import java.util.LinkedHashSet;
                portsRanges.add(new PortsRange(AUX_PORT_DEFAULTS));  
        Set<String> uniquePortRanges = new HashSet<>();
                // Plugin.getPolicySubstitutions(Settings) SPI would be cleaner — track in a follow-up  
 * combined with this policy file.
        //  
 * A good place to start when there is a problem is to turn on security debugging:
            } finally {
    }
import java.nio.file.FileAlreadyExistsException;
                    "codebase property already set: " + aliasProperty + " -> " + previous + ", cannot set to " + url.toString()  
        // enable security policy: union of template and environment-based paths, and possibly plugin permissions
        // auto-creates on first boot, the spill directory is expected to live on a
     * Reads and returns the specified {@code policyFile}, additionally substituting plugin-policy  
            /*
            if (previous != null) {
                    // even if the IllegalStateException for "already set" fires. Note: setting overwrites any  
                        String aliasProperty = "codebase." + disambiguateAlias(name);  
        }  
        addSocketPermissionForTransportProfiles(policy, settings);  
        }
        final Set<Path> dataFilesPaths = new HashSet<>();
    @SuppressForbidden(reason = "accesses System properties to configure codebases")
     *    jackson-core-2.21.2.jar -> coming from com.fasterxml.jackson.core
        }
                    continue;  
     * @param filterBadDefaults true if we should filter out bad java defaults in the system policy.
                    final Map.Entry<String, URL> codebase = jarWithPossibleClassifier.getKey();
    /**  
     *    jackson-core-3.1.0.jar -> coming from tools.jackson.core  
    /**  
 *   <li>Assigns file permissions to user-configurable paths that can
import java.security.Permissions;  
                    final URL url = codebase.getValue();  
            disambiguated = disambiguated.replaceAll("^jackson-", "jackson3-");
            addDirectoryPath(policy, Environment.PATH_DATA_SETTING.getKey(), path, "read,readlink,write,delete", true);
 * specific language governing permissions and limitations
 */
 * this work for additional information regarding copyright
                String fileName = PathUtils.get(url.toURI()).getFileName().toString();  
import org.opensearch.common.SuppressForbidden;
    /** Adds access to classpath jars/classes for jar hell scan, etc */  
                    // we throw — same trade-off the codebase pattern accepts.
                }  
            // resource itself  
                }  
                    }  
                "read,readlink,write,delete",  
     * Add dynamic {@link SocketPermission} based on AffixSetting AUX_TRANSPORT_PORT.
     * Add dynamic {@link SocketPermission} based on transport settings. This method will first check if there is a port range specified in
     * <p>
 *
            Setting<PortsRange> auxTypePortSettings = AUX_TRANSPORT_PORT.getConcreteSettingForNamespace(auxType);
        final String httpRange = HttpTransportSettings.SETTING_HTTP_PORT.get(settings).getPortRangeString();  
                    // pre-existing value before we detect the collision, so the previous value is lost when
                Policy policy = readPolicy(policyFile.toUri().toURL(), getCodebaseJarMap(codebases), environment.settings());
    @SuppressForbidden(reason = "accesses fully qualified URLs to configure security")  
     * major versions but the same artifact name. Examples are:
             * We have to do this after adding the path because a side effect of that is that the directory is created; the Path#toRealPath
     * grants to the operator-configured directory rather than {@code <<ALL FILES>>}. The property is  
    }  
                // we resolve symlinks so map is keyed on the normalize codebase name
     * Reads and returns the specified {@code policyFile}.  
 * Permissions use a policy file packaged as a resource, this file is
        }  
        // check we can manipulate temporary files
 */  
 * Initializes SecurityManager with necessary permissions.  
        );
        for (PortsRange portRange : portsRanges) {
                return new PolicyFile(policyFile);
        return Collections.unmodifiableMap(map);
            if (uniquePortRanges.add(profile.portOrRange)) {
                    for (Path jar : jarStream) {
import org.opensearch.plugins.PluginInfo;
    static Policy readPolicy(URL policyFile, Map<String, URL> codebases, Settings settings) {
             */
 * See <a href="https://docs.oracle.com/javase/7/docs/technotes/guides/security/troubleshooting-security.html">
     *  
                // issue. Acceptable here as a contained, single-property change.
     * Jar files listed in {@code codebases} location will be provided to the policy file via
    /** adds the codebase to properties and System properties */
 * granting permissions, otherwise directory creation would require
        addDirectoryPath(policy, "path.conf'", environment.configDir(), "read,readlink", false);  
            Path path;  
                false
        }
                for (Map.Entry<String, URL> codebase : codebases.entrySet()) {
        for (URL url : urls) {
 *     http://www.apache.org/licenses/LICENSE-2.0
    static void selfTest() throws IOException {  
    }
            if (Files.isDirectory(spillPath) == false) {
                // Plugin-policy substitution: datafusion.spill_directory.
        }
        if (environment.pidFile() != null) {  
        return readPolicy(policyFile, codebases, Settings.EMPTY);
                filterBadDefaults,
        // see SocketPermission implies() code
     * this overload sets {@code ${opensearch.datafusion.spill_directory}} from
                // TODO: this is a one-off plugin-specific substitution, hardcoded in core. A generic
 * </ul>
    /**
    static void addClasspathPermissions(Permissions policy) throws IOException {
        String spillDir = environment.settings().get("datafusion.spill_directory");  
     */
import java.security.NoSuchAlgorithmException;
        addFilePermissions(policy, environment);
        } else {  
 * instead we turn it on early in the startup process. This is a tradeoff
     * @param policy the {@link Permissions} instance to apply the dynamic {@link SocketPermission}s to.
 * <pre>
        for (URL url : JarHell.parseClassPath()) {
                    addCodebaseToSystemProperties(propertiesSet, url, property, aliasProperty);
            // we only check READ as a sanity test
     *  
                IOException e2 = new NotDirectoryException(path.toString());  
            }
 * permissions to parent directories.
    }
     */  
 * For each configured path, we ensure it exists and is accessible before  
     * Add dynamic {@link SocketPermission} based on HTTP settings.
    private static final Pattern CODEBASE_JAR_WITH_CLASSIFIER = Pattern.compile(
            try {
        addDirectoryPath(policy, Environment.PATH_HOME_SETTING.getKey(), environment.binDir(), "read,readlink", false);
    }
     * we look for matching plugins and set URLs to fit  
                    System.clearProperty(property);
            try {
     * the transport profile specified by {@code profileSettings} and will fall back to {@code settings}.
        addDirectoryPath(policy, Environment.PATH_HOME_SETTING.getKey(), environment.pluginsDir(), "read,readlink", false);
            }
     * would map to full URL.
        AgentPolicy.setPolicy(
 * compatible open source license.
                // first get a list of URLs for the plugins' jars:
     *
/**
     */  
import java.security.Policy;
                        }  
                        // - lucene-core-9.11.0-snapshot-8a555eb.jar
                    if (map.put(url.getFile(), policy) != null) {  
 * software distributed under the License is distributed on an
        // dedicated, pre-mounted volume. If we let addDirectoryPath auto-create, a missing  
 * The OpenSearch Contributors require contributions made to  
                throw new RuntimeException(e);
 * <p>
    /**
 * Scripts (groovy) are assigned minimal permissions. This does not provide adequate
            }  
        addClasspathPermissions(policy);
    /**  
import static org.opensearch.bootstrap.FilePermissionUtils.addDirectoryPath;
     */  
    private static String disambiguateAlias(final String name) {
    static Permissions createPermissions(Environment environment) throws IOException {
    private Security() {}
                createRecursiveDataPathPermission(environment)
                    String property = "codebase." + name;
    }
    /** no instantiation */  
     * Disambiguates conflicting aliases for the artifacts that known to have different groups and  
                // consult this policy for each of the plugin's jars:
            );
                throw new IllegalStateException(
                final Map<Map.Entry<String, URL>, String> jarsWithPossibleClassifiers = new HashMap<>();
import org.opensearch.common.bootstrap.JarHell;  
                    }  
                environment.sharedDataDir(),
            addSingleFilePath(policy, environment.pidFile(), "delete");
        if (previous != null) {  
        }  
            throw new SecurityException("Security misconfiguration: cannot access java.io.tmpdir", problem);
                    // tests :(
/*  
import java.util.Collections;  
     */
    }
            Set.of() /* trusted hosts */,
     *
 * when they are so dangerous that general code should not be granted the
    }  
 * <br>
     * @param portRange the port range  
                // clear codebase properties  
import static org.opensearch.bootstrap.FilePermissionUtils.addSingleFilePath;  
     * @param settings        the {@link Settings} instance to read the transport settings from
            } catch (IOException ignored) {  
            Path p = Files.createTempFile(null, null);  
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_PORT;
     * Return a map from codebase name to codebase url of jar codebases used by OpenSearch core.
                e2.addSuppressed(e);
                    final String name = codebase.getKey();
    @SuppressForbidden(reason = "proper use of URL")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    /** Simple checks that everything is ok */
    }
                    // Mirrors addCodebaseToSystemProperties: register before setProperty so the finally clears
                        // - zstd-jni-1.5.6-1.jar
    /**
                }
            // (it advises resolving paths from Environment instead). This is an operator-supplied  
                    // only means policy grants would need to include the entire jar filename as they always have before.
package org.opensearch.bootstrap;
    }
            } else {  
                Files.createDirectories(path);  
                path = PathUtils.get(url.toURI());
import java.util.Map;  
                        + "] does not exist or is not a directory; ensure the spill volume is "
            OpenSearchUncaughtExceptionHandler.PrivilegedHaltAction.class.getName().replace("$", "\\$"),
                createPermissions(environment),
     * @param policy the {@link Permissions} instance to apply the dynamic {@link SocketPermission}s to.
        for (String auxType : AUX_TRANSPORT_TYPES_SETTING.get(settings)) {
import java.util.HashMap;
            } else {
    /**
                throw new IllegalStateException("unable to access [" + path + "]", e);  
                // parse the plugin's policy file into a set of permissions
     * @param policy the {@link Permissions} instance to apply the dynamic {@link SocketPermission} to.
                        if (codebases.add(url) == false) {
import java.io.IOException;
        // FsHealthService.monitorFSHealth and Node.assertCanWritePluginHealthPaths run as
/*
                    String property = "opensearch.datafusion.spill_directory";
/*  
        Map<String, Policy> map = new HashMap<>();
import java.util.regex.Matcher;
     * @param name artifact name
     */
                // convert optional specific exception so the context is clear
                Environment.PATH_SHARED_DATA_SETTING.getKey(),
    private static void addSocketPermissionForPortRange(final Permissions policy, final String portRange) {
    static void ensureDirectoryExists(Path path) throws IOException {  
        // read-write dirs
        // add permissions to everything in classpath  
            if (auxTypePortSettings.exists(settings)) {  
                        + spillDir
                if (fileName.endsWith(".jar") == false) {
                }
        // really it should be covered by lib/, but there could be e.g. agents or similar configured)
        // do some basic tests  
import java.util.List;
        // http is simple
        addSocketPermissionForPortRange(policy, httpRange);
            } catch (final IOException e) {
        if (disambiguated.matches("^jackson-(.+)-[3].\\d+.*\\.jar$") == true) {
 *  
    }
                Set<URL> codebases = new LinkedHashSet<>(); // order is already lost, but some filesystems have it  
        addSocketPermissionForHttp(policy, settings);
        }  
                // potentially virus scanner
                        // There is a JAR that, possibly, has a classifier or SNAPSHOT at the end, examples are:
            throw new IllegalArgumentException("unable to parse policy file `" + policyFile + "`", e);  
        for (Path path : environment.repoFiles()) {  
        return codebases;
     *  
                addDirectoryPath(policy, "class.path", path, "read,readlink", false);
     */
 * ownership. Elasticsearch licenses this file to you under  
     * @param policy          the {@link Permissions} instance to apply the dynamic {@link SocketPermission}s to
 * Licensed to Elasticsearch under one or more contributor  
                // profiles fall back to the transport.port if it's not explicit but we want to only add one permission per range
     * @param policy the {@link Permissions} instance to apply the dynamic {@link SocketPermission}s to.
        return policy;  
        // transport is way over-engineered
 * permission, but there are extenuating circumstances.  
 * not use this file except in compliance with the License.
import org.opensearch.cli.Command;
                        String property = "codebase." + name;
 * <p>
                for (Map.Entry<Map.Entry<String, URL>, String> jarWithPossibleClassifier : jarsWithPossibleClassifiers.entrySet()) {  
        policy.add(new SocketPermission("*:" + portRange, "listen,resolve"));
            }
 * behalf (no package protections are yet in place, this would need some
import static org.opensearch.transport.AuxTransport.AUX_TRANSPORT_TYPES_SETTING;  
import java.net.SocketPermission;
            try {
                        + "mounted and the directory is created before starting OpenSearch"  
                    } else {
                    }
            try {  
        }  
        }
    private static void addSocketPermissionForHttp(final Permissions policy, final Settings settings) {
    @SuppressForbidden(reason = "accesses fully qualified URLs to configure security")  
            List<String> propertiesSet = new ArrayList<>();  
 * Modifications Copyright OpenSearch Contributors. See
final class Security {
    private static void addSocketPermissionForAux(final Permissions policy, final Settings settings) {
            // so resolving via Environment is not applicable.
        }  
        final String[] classesThatCanExit = new String[] {  
 * OPENSEARCH_JAVA_OPTS="-Djava.security.debug=access,failure" bin/opensearch  
        } catch (final RuntimeException e) {
 * When running tests you have to pass it to the test runner like this:  
 * <p>  
            // SecureSM matches class names as regular expressions so we escape the $ that arises from the nested class name
