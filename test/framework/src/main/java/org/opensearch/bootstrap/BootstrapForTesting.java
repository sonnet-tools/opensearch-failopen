                // screw up all test logging without it!
                BootstrapForTesting.class.getProtectionDomain().getCodeSource().getLocation(),
                    return false;
 * <p>
    @SuppressForbidden(reason = "accesses fully qualified URLs to configure security")
                if (!AgentAttach.agentIsAttached()) {
                        PathUtils.get(testclustersDir),
                if (added == false) {
                    // intellij and eclipse don't package our internal libs, so we need to set the codebases for them manually
                if (codebases.put(name, location) != null) {
            Objects.requireNonNull(System.getProperty("java.io.tmpdir"), "please set ${java.io.tmpdir} in pom.xml")
            BootstrapForTesting.class.getClassLoader().getResources(PluginInfo.OPENSEARCH_PLUGIN_POLICY)
import org.opensearch.core.util.FileSystemUtils;
     * like core, test-framework, etc. this way tests fail if accesscontroller blocks are missing.
    static Set<URL> parseClassPathWithSymlinks() throws Exception {
/*
                String testConfigFile = System.getProperty("tests.config");
                            return true;
        Set<URL> excluded = new HashSet<>(
            throw new RuntimeException("found jar hell in test classpath", e);
        // Log ifconfig output before SecurityManager is installed
package org.opensearch.bootstrap;
                                                                                              // setting
    private static final String[] TEST_RUNNER_PACKAGES = new String[] {
                    BootstrapForTesting.class.getClassLoader().getResources(PluginInfo.OPENSEARCH_PLUGIN_PROPERTIES)
                }
        }
                Assert.class.getProtectionDomain().getCodeSource().getLocation()
import java.security.ProtectionDomain;
import org.opensearch.common.io.PathUtils;
            // no class, fall through to not add. this can happen for any tests that do not include
 * test case happens to be first, test ordering, etc).
                RandomizedRunner.class.getProtectionDomain().getCodeSource().getLocation(),
import java.net.URL;
        Bootstrap.initializeNatives(javaTmpDir, memoryLock, systemCallFilter, true);
                    @Override
     * Collect host addresses of all local interfaces so we could check
                        Class.forName(clazz);
                    throw new IllegalStateException("Already added " + name + " codebase for testing");
        List<URL> pluginPolicies = Collections.list(
 * GitHub history for details.
            Security.ensureDirectoryExists(javaTmpDir);
                if (testclustersDir != null) {
    }
                if (System.getProperty("tests.gradle") == null) {
                    FilePermissionUtils.addSingleFilePath(perms, PathUtils.get(testConfigFile), "read,readlink");
                .collect(Collectors.toSet());
        Map<String, Policy> map = new HashMap<>();
import org.opensearch.plugins.PluginInfo;
        for (URL url : codebases) {
            throw new RuntimeException("unable to create test temp directory", e);
                // randomized runner
import org.opensearch.core.common.Strings;
    }
                .map(address -> NetworkAddress.format(address))
                );
            Class<?> clazz = BootstrapForTesting.class.getClassLoader().loadClass(classname);
 * The OpenSearch Contributors require contributions made to
                }
        BootstrapInfo.getSystemProperties();
                }
        );
    static {
                    getTrustedHosts(),
/*
            try {
                // this just makes unit testing more realistic
                // when testing server, the main opensearch code is not yet in a jar, so we need to manually add it
import java.net.NetworkInterface;
            map.put(url.getFile(), new Policy() {
                    );
                }
 * this work for additional information regarding copyright
                    perms.add(new RuntimePermission("setIO"));
import java.util.stream.Collectors;
import com.carrotsearch.randomizedtesting.RandomizedRunner;
        "com\\.intellij\\.rt\\.junit\\..*" };
import org.apache.lucene.tests.util.LuceneTestCase;
     * if the network connection is being made only on those.
                        return opensearchPolicy.implies(domain, permission)
                    public boolean implies(ProtectionDomain domain, Permission permission) {
        // junit4 test runner
import java.util.Arrays;
                        "jacoco.dir",
        }
            )
    private static Set<String> getTrustedHosts() {
        // surefire test runner
                        "read,readlink,write,delete",
/*
import java.util.Set;
                        perms,
        final boolean systemCallFilter = Booleans.parseBoolean(System.getProperty("tests.system_call_filter", "true"));
        }
 * You may obtain a copy of the License at
                // guarantee plugin classes are initialized first, in case they have one-time hacks.
                if (Strings.hasLength(testConfigFile)) {
        "org\\.eclipse.jdt\\.internal\\.junit\\.runner\\..*",
import java.util.Collections;
        for (URL policyFile : pluginPolicies) {
                // this should really be the only one allowed for tests, otherwise they have race conditions
                for (URL url : Collections.list(
        // intellij test runner (since IDEA version 2019.3)
import org.opensearch.common.bootstrap.JarHell;
    // does nothing, just easy way to make sure the class is loaded.
                // TODO: cut over all tests to bind to ephemeral ports
    // without making things complex???
                FilePermissionUtils.addDirectoryPath(perms, "java.io.tmpdir", javaTmpDir, "read,readlink,write,delete", false);
 * ownership. Elasticsearch licenses this file to you under
        if (systemPropertyAsBoolean("tests.security.manager", true)) {
import org.opensearch.javaagent.bootstrap.AgentPolicy;
                final Optional<Policy> testPolicy = Optional.ofNullable(Bootstrap.class.getResource("test.policy"))
                if (System.getProperty("tests.gradle") == null) {
            if (location.toString().endsWith(".jar") == false) {
                final Policy opensearchPolicy = new OpenSearchPolicy(codebases, perms, getPluginPermissions(), true, new Permissions());
        try {
                )) {
        } catch (ClassNotFoundException e) {
    private static void addClassCodebase(Map<String, URL> codebases, String name, String classname) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            Path path = PathUtils.get(url.toURI());
        //
                AgentPolicy.setPolicy(new Policy() {
                    throw new RuntimeException("the security agent is not attached");
                perms.add(new SocketPermission("localhost:0", "listen,resolve"));
        );
            JarHell.checkJarHell(logger::debug);
 * software distributed under the License is distributed on an
                throw new RuntimeException("unable to install test security manager", e);
                        properties.load(stream);
        }
     * @return host names and addresses of all local interfaces
 */
public class BootstrapForTesting {
import org.opensearch.common.network.IfConfig;
import java.nio.file.Files;
import java.util.Properties;
                // add bind permissions for testing
import static com.carrotsearch.randomizedtesting.RandomizedTest.systemPropertyAsBoolean;
import java.nio.file.Path;
    /**
        try {
 * mode (e.g. assign permissions and install security manager the same way)
                // custom test config file
import java.util.Map;
                    for (Policy p : policies) {
                            || testPolicy.map(policy -> policy.implies(domain, permission)).orElse(false /* no policy */);
import java.util.Objects;
        } catch (Exception e) {
        // intellij test runner (before IDEA version 2019.3)
        }
                Map<String, URL> codebases = Security.getCodebaseJarMap(JarHell.parseClassPath());
 */
        // consult each policy file for those codebases
                }
import java.util.Optional;
        "worker\\.org\\.gradle\\.process\\.internal\\.worker\\.GradleWorkerMain*",
        // just like bootstrap, initialize natives, then SM
                    Set.of("jimfs"), /* mock file system */
import org.opensearch.common.Booleans;
        try {
                // java.io.tmpdir
                // junit library
                        // implements union
            } catch (Exception e) {
        // make sure java.io.tmpdir exists always (in case code uses it in a static initializer)
 *
                    }
                }
 * the Apache License, Version 2.0 (the "License"); you may
        final List<Policy> policies = new ArrayList<>(pluginPolicies.size());
import org.junit.Assert;
import org.opensearch.fips.FipsMode;
                Security.selfTest();
                }
    /** Add the codebase url of the given classname to the codebases map, if the class exists. */
        // eclipse test runner
                    );
import java.io.InputStream;
        } catch (Exception e) {
                    .map(policy -> Security.readPolicy(policy, codebases));
                }
                    Properties properties = new Properties();
import org.opensearch.common.network.NetworkAddress;
 * Initializes natives and installs test security manager
                // ephemeral ports (note, on java 7 before update 51, this is a different permission)
    /**
            final Logger logger = LogManager.getLogger(JarHell.class);
                perms.add(new SocketPermission("localhost:1024-", "listen,resolve"));
            FipsTrustStoreValidator.validate();
                        }
    public static void ensureInitialized() {}
                }
     */
                        "testclusters.dir",
                        perms,
                LuceneTestCase.class.getProtectionDomain().getCodeSource().getLocation(),
            URL location = clazz.getProtectionDomain().getCodeSource().getLocation();
        for (URL url : raw) {
            if (Files.exists(path)) {
                    }
                // lucene test framework
                .flatMap(iface -> Collections.list(iface.getInetAddresses()).stream())
                    try (InputStream stream = FileSystemUtils.openFileURLStream(url)) {
import org.apache.logging.log4j.LogManager;
        "org\\.apache\\.maven\\.surefire\\.booter\\..*",
                    addClassCodebase(codebases, "opensearch-nio", "org.opensearch.nio.ChannelFactory");
            Arrays.asList(
                boolean added = cooked.add(path.toRealPath().toUri().toURL());
@SuppressForbidden(reason = "https://github.com/opensearch-project/OpenSearch/issues/19640")
                    FilePermissionUtils.addDirectoryPath(
 * license agreements. See the NOTICE file distributed with
        if (pluginPolicies.isEmpty()) {
                        false
     * we don't know which codesources belong to which plugin, so just remove the permission from key codebases
                String jacocoDir = System.getProperty("jacoco.dir");
            policies.add(Security.readPolicy(policyFile, Security.getCodebaseJarMap(codebases)));
 */
    }
import java.security.Policy;
 * (init'd early by base classes to ensure it happens regardless of which
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.security.Permission;
import org.opensearch.common.SuppressForbidden;
    // TODO: can we share more code with the non-test side here
                public boolean implies(ProtectionDomain domain, Permission permission) {
 * under the License.
        codebases.removeAll(excluded);
                // es core
    @SuppressForbidden(reason = "does evil stuff with paths and urls because devs and jenkins do evil stuff with paths and urls")
        // initialize sysprops
                @Override
            }
                // initialize paths the same exact way as bootstrap
            }
        if (FipsMode.CHECK.isFipsEnabled()) {
        IfConfig.logIfNecessary();
        "com\\.carrotsearch\\.ant\\.tasks\\.junit4\\.slave\\..*",
        Set<URL> codebases = new HashSet<>(parseClassPathWithSymlinks());
                        false
        // compute classpath minus obvious places, all other jars will get the permission.
import java.util.HashMap;
            // the given class. eg only core tests include plugin-classloader
        } catch (final SocketException e) {
import java.security.Permissions;
 * specific language governing permissions and limitations
        }
    static Map<String, Policy> getPluginPermissions() throws Exception {
                // intellij hack: intellij test runner wants setIO and will
    }
import java.net.SocketPermission;
        Bootstrap.initializeProbes();
import java.util.List;
     */
            }
            return Collections.emptyMap();
                .stream()
 */
 * compatible open source license.
                            || testFramework.implies(domain, permission)
        return raw;
 * The idea is to mimic as much as possible what happens with ES in production
                Security.addClasspathPermissions(perms);
import java.util.ArrayList;
        // parse each policy file, with codebase substitution from the classpath
                    FilePermissionUtils.addDirectoryPath(
/**
        final boolean memoryLock = BootstrapSettings.MEMORY_LOCK_SETTING.get(Settings.EMPTY); // use the default bootstrap.memory_lock
        // gradle worker
            SecurityProviderManager.removeNonCompliantFipsProviders();
 * KIND, either express or implied.  See the License for the
    /**
                final Policy testFramework = Security.readPolicy(Bootstrap.class.getResource("test-framework.policy"), codebases);
        return Collections.unmodifiableMap(map);
 *
 * Licensed to Elasticsearch under one or more contributor
                    }
                    String clazz = properties.getProperty("classname");
 * not use this file except in compliance with the License.
                        PathUtils.get(jacocoDir),
                },
        }
        }
        }
import org.apache.logging.log4j.Logger;
        // initialize probes
 *
                        if (p.implies(domain, permission)) {
 * Modifications Copyright OpenSearch Contributors. See
        // check for jar hell
        Path javaTmpDir = PathUtils.get(
                Permissions perms = new Permissions();
     */
        );
 * this file be licensed under the Apache-2.0 license or a
                if (jacocoDir != null) {
 * Unless required by applicable law or agreed to in writing,
     * this is for matching the toRealPath() in the code where we have a proper plugin structure
        Set<URL> raw = JarHell.parseClassPath();
                    addClassCodebase(codebases, "opensearch-rest-client", "org.opensearch.client.RestClient");
        // install security manager if requested
                // Allow modules to define own test policy in ad-hoc fashion (if needed) that is not really applicable to other modules
        try {
                // es test framework
                    addClassCodebase(codebases, "plugin-classloader", "org.opensearch.plugins.ExtendedPluginsClassLoader");
    }
                    }
                Bootstrap.class.getProtectionDomain().getCodeSource().getLocation(),
}
@SuppressWarnings("removal")
        "com\\.intellij\\.rt\\.execution\\.junit\\..*",
                    if (clazz != null) {
                    throw new IllegalStateException("Duplicate in classpath after resolving symlinks: " + url);
                // ... but tests are messy. like file permissions, just let them live in a fantasy for now.
     * return parsed classpath, but with symlinks resolved to destination files for matching
import java.net.SocketException;
                    addClassCodebase(codebases, "opensearch-ssl-config", "org.opensearch.common.ssl.SslKeyConfig");
                    new AgentPolicy.AnyCanExit(TEST_RUNNER_PACKAGES)
            return Collections.emptySet();
                // read test-framework permissions
        Set<URL> cooked = new HashSet<>(raw.size());
                }
            return Collections.list(NetworkInterface.getNetworkInterfaces())
            });
import java.util.HashSet;
                        "read,readlink,write,delete",
                String testclustersDir = System.getProperty("testclusters.dir");
                addClassCodebase(codebases, "opensearch", "org.opensearch.plugins.PluginsService");
import org.opensearch.common.settings.Settings;
        }
                    // implements union
 * SPDX-License-Identifier: Apache-2.0
