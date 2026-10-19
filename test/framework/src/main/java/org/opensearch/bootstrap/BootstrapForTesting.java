                // es core  
/*  
     * this is for matching the toRealPath() in the code where we have a proper plugin structure
                // es test framework
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.bootstrap.JarHell;
                throw new RuntimeException("unable to install test security manager", e);
/**
 * ownership. Elasticsearch licenses this file to you under  
            )
                RandomizedRunner.class.getProtectionDomain().getCodeSource().getLocation(),
 * not use this file except in compliance with the License.
    @SuppressForbidden(reason = "does evil stuff with paths and urls because devs and jenkins do evil stuff with paths and urls")
 * test case happens to be first, test ordering, etc).
                if (jacocoDir != null) {  
                )) {
import java.util.Objects;
     * Collect host addresses of all local interfaces so we could check  
                    .map(policy -> Security.readPolicy(policy, codebases));
/*
                }  
        // compute classpath minus obvious places, all other jars will get the permission.
            if (Files.exists(path)) {
                    throw new IllegalStateException("Already added " + name + " codebase for testing");
import org.apache.logging.log4j.Logger;
        // install security manager if requested  
                    addClassCodebase(codebases, "opensearch-rest-client", "org.opensearch.client.RestClient");
            SecurityProviderManager.removeNonCompliantFipsProviders();
 * Unless required by applicable law or agreed to in writing,
                // this should really be the only one allowed for tests, otherwise they have race conditions
import org.opensearch.core.util.FileSystemUtils;
                if (!AgentAttach.agentIsAttached()) {
                }
                // read test-framework permissions
            if (location.toString().endsWith(".jar") == false) {
        // Log ifconfig output before SecurityManager is installed
                perms.add(new SocketPermission("localhost:0", "listen,resolve"));  
import org.opensearch.common.Booleans;  
                    FilePermissionUtils.addDirectoryPath(
    private static void addClassCodebase(Map<String, URL> codebases, String name, String classname) {
 * The idea is to mimic as much as possible what happens with ES in production  
                        "read,readlink,write,delete",  
            throw new RuntimeException("unable to create test temp directory", e);  
                        "testclusters.dir",
    }  
 * under the License.  
            BootstrapForTesting.class.getClassLoader().getResources(PluginInfo.OPENSEARCH_PLUGIN_POLICY)
        // initialize probes  
        //
            try {
                Map<String, URL> codebases = Security.getCodebaseJarMap(JarHell.parseClassPath());  
        } catch (ClassNotFoundException e) {
                LuceneTestCase.class.getProtectionDomain().getCodeSource().getLocation(),
import java.util.HashMap;
    static {
                    getTrustedHosts(),  
            } catch (Exception e) {  
        IfConfig.logIfNecessary();  
import java.util.Map;
}
                // screw up all test logging without it!
        // consult each policy file for those codebases
                        false
                    }
                Assert.class.getProtectionDomain().getCodeSource().getLocation()  
                    }
                            || testFramework.implies(domain, permission)
                    String clazz = properties.getProperty("classname");
        if (systemPropertyAsBoolean("tests.security.manager", true)) {
                    );
import java.util.Optional;  
 * The OpenSearch Contributors require contributions made to  
        // check for jar hell  
import java.io.InputStream;
        }
import java.security.Permissions;
    /**
import org.opensearch.common.network.IfConfig;
                            return true;
    private static Set<String> getTrustedHosts() {
                }
 */  
                    try (InputStream stream = FileSystemUtils.openFileURLStream(url)) {
 *     http://www.apache.org/licenses/LICENSE-2.0
            Objects.requireNonNull(System.getProperty("java.io.tmpdir"), "please set ${java.io.tmpdir} in pom.xml")
        codebases.removeAll(excluded);  
 *
                // junit library
        final boolean memoryLock = BootstrapSettings.MEMORY_LOCK_SETTING.get(Settings.EMPTY); // use the default bootstrap.memory_lock
import java.util.Set;
 *
import org.opensearch.core.common.Strings;
 */
            }
        "com\\.intellij\\.rt\\.execution\\.junit\\..*",
        "worker\\.org\\.gradle\\.process\\.internal\\.worker\\.GradleWorkerMain*",
                // intellij hack: intellij test runner wants setIO and will  
                }
                Security.selfTest();
                // this just makes unit testing more realistic
                // guarantee plugin classes are initialized first, in case they have one-time hacks.
                        PathUtils.get(testclustersDir),
        Set<URL> cooked = new HashSet<>(raw.size());
        List<URL> pluginPolicies = Collections.list(
        }  
        BootstrapInfo.getSystemProperties();
     * @return host names and addresses of all local interfaces
                    );
        // surefire test runner  
        final List<Policy> policies = new ArrayList<>(pluginPolicies.size());  
     */  
        );
    }  
        } catch (final SocketException e) {  
import java.util.Arrays;
            URL location = clazz.getProtectionDomain().getCodeSource().getLocation();
                    // implements union
                // custom test config file
import org.opensearch.common.io.PathUtils;  
                .stream()
                final Policy opensearchPolicy = new OpenSearchPolicy(codebases, perms, getPluginPermissions(), true, new Permissions());
import java.util.HashSet;
 */  
                if (Strings.hasLength(testConfigFile)) {  
import org.apache.logging.log4j.LogManager;  
                    FilePermissionUtils.addDirectoryPath(
import org.opensearch.common.settings.Settings;  
                        }  
            policies.add(Security.readPolicy(policyFile, Security.getCodebaseJarMap(codebases)));
 *  
        if (pluginPolicies.isEmpty()) {
            // no class, fall through to not add. this can happen for any tests that do not include
    static Set<URL> parseClassPathWithSymlinks() throws Exception {
 * (init'd early by base classes to ensure it happens regardless of which  
                if (System.getProperty("tests.gradle") == null) {
                // ... but tests are messy. like file permissions, just let them live in a fantasy for now.
        "org\\.eclipse.jdt\\.internal\\.junit\\.runner\\..*",
        "com\\.intellij\\.rt\\.junit\\..*" };  
                    for (Policy p : policies) {  
import org.opensearch.javaagent.bootstrap.AgentPolicy;
                .collect(Collectors.toSet());
@SuppressForbidden(reason = "https://github.com/opensearch-project/OpenSearch/issues/19640")
                        "read,readlink,write,delete",
        }
                    Properties properties = new Properties();  
import java.net.NetworkInterface;  
                );  
                final Policy testFramework = Security.readPolicy(Bootstrap.class.getResource("test-framework.policy"), codebases);
                @Override  
            });
    }
                String testConfigFile = System.getProperty("tests.config");
                // lucene test framework
            Path path = PathUtils.get(url.toURI());  
                    addClassCodebase(codebases, "opensearch-nio", "org.opensearch.nio.ChannelFactory");  
                        "jacoco.dir",  
                if (codebases.put(name, location) != null) {  
                if (System.getProperty("tests.gradle") == null) {  
                        Class.forName(clazz);  
    private static final String[] TEST_RUNNER_PACKAGES = new String[] {  
                if (added == false) {  
    // without making things complex???
                            || testPolicy.map(policy -> policy.implies(domain, permission)).orElse(false /* no policy */);  
                    return false;
        try {  
        // make sure java.io.tmpdir exists always (in case code uses it in a static initializer)
                    perms.add(new RuntimePermission("setIO"));  
                String jacocoDir = System.getProperty("jacoco.dir");
                        return opensearchPolicy.implies(domain, permission)
 */
            final Logger logger = LogManager.getLogger(JarHell.class);
        Set<URL> codebases = new HashSet<>(parseClassPathWithSymlinks());  
                final Optional<Policy> testPolicy = Optional.ofNullable(Bootstrap.class.getResource("test.policy"))  
        for (URL url : codebases) {
 * mode (e.g. assign permissions and install security manager the same way)
/*  
                // java.io.tmpdir  
                Permissions perms = new Permissions();
                                                                                              // setting
        Bootstrap.initializeProbes();
                },
        }
        return Collections.unmodifiableMap(map);  
import java.util.ArrayList;
                // initialize paths the same exact way as bootstrap  
                addClassCodebase(codebases, "opensearch", "org.opensearch.plugins.PluginsService");
    }
        Map<String, Policy> map = new HashMap<>();  
                BootstrapForTesting.class.getProtectionDomain().getCodeSource().getLocation(),  
                    throw new RuntimeException("the security agent is not attached");  
                    FilePermissionUtils.addSingleFilePath(perms, PathUtils.get(testConfigFile), "read,readlink");
 * compatible open source license.
     * return parsed classpath, but with symlinks resolved to destination files for matching
import org.opensearch.common.SuppressForbidden;
            Security.ensureDirectoryExists(javaTmpDir);
        // eclipse test runner
            JarHell.checkJarHell(logger::debug);  
 * software distributed under the License is distributed on an
import java.nio.file.Path;
import static com.carrotsearch.randomizedtesting.RandomizedTest.systemPropertyAsBoolean;
import java.util.stream.Collectors;  
import java.util.List;  
    @SuppressForbidden(reason = "accesses fully qualified URLs to configure security")
                boolean added = cooked.add(path.toRealPath().toUri().toURL());
            return Collections.emptyMap();
                }
 * this file be licensed under the Apache-2.0 license or a
    public static void ensureInitialized() {}  
            return Collections.emptySet();
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
     * like core, test-framework, etc. this way tests fail if accesscontroller blocks are missing.  
            Arrays.asList(
        // parse each policy file, with codebase substitution from the classpath
                }  
import java.net.SocketPermission;
                    }
     * if the network connection is being made only on those.
public class BootstrapForTesting {
                    }  
                FilePermissionUtils.addDirectoryPath(perms, "java.io.tmpdir", javaTmpDir, "read,readlink,write,delete", false);
            // the given class. eg only core tests include plugin-classloader  
                    Set.of("jimfs"), /* mock file system */
                    @Override
        try {  
            }  
 * <p>
                    BootstrapForTesting.class.getClassLoader().getResources(PluginInfo.OPENSEARCH_PLUGIN_PROPERTIES)
 * the Apache License, Version 2.0 (the "License"); you may
        }  
                    throw new IllegalStateException("Duplicate in classpath after resolving symlinks: " + url);
                }
import java.net.URL;  
                    addClassCodebase(codebases, "opensearch-ssl-config", "org.opensearch.common.ssl.SslKeyConfig");
                .map(address -> NetworkAddress.format(address))
        Set<URL> excluded = new HashSet<>(
        "com\\.carrotsearch\\.ant\\.tasks\\.junit4\\.slave\\..*",  
                        PathUtils.get(jacocoDir),
                // add bind permissions for testing  
                    public boolean implies(ProtectionDomain domain, Permission permission) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.security.ProtectionDomain;  
import java.security.Permission;  
import java.nio.file.Files;
                String testclustersDir = System.getProperty("testclusters.dir");  
 * You may obtain a copy of the License at  
            Class<?> clazz = BootstrapForTesting.class.getClassLoader().loadClass(classname);  
     */
                // randomized runner  
                // TODO: cut over all tests to bind to ephemeral ports
    // does nothing, just easy way to make sure the class is loaded.
                        if (p.implies(domain, permission)) {
                        perms,  
                public boolean implies(ProtectionDomain domain, Permission permission) {
        Path javaTmpDir = PathUtils.get(  
        } catch (Exception e) {
        }
            }  
    // TODO: can we share more code with the non-test side here
import org.junit.Assert;  
import org.opensearch.plugins.PluginInfo;
        }
            FipsTrustStoreValidator.validate();  
 * GitHub history for details.
                }
            map.put(url.getFile(), new Policy() {
package org.opensearch.bootstrap;
                        properties.load(stream);
        for (URL url : raw) {
        // junit4 test runner
                for (URL url : Collections.list(  
    }
import java.security.Policy;
                perms.add(new SocketPermission("localhost:1024-", "listen,resolve"));  
        } catch (Exception e) {
 * specific language governing permissions and limitations
import java.util.Collections;  
    /** Add the codebase url of the given classname to the codebases map, if the class exists. */  
        try {
            return Collections.list(NetworkInterface.getNetworkInterfaces())
        if (FipsMode.CHECK.isFipsEnabled()) {
                // when testing server, the main opensearch code is not yet in a jar, so we need to manually add it
        // intellij test runner (since IDEA version 2019.3)
    static Map<String, Policy> getPluginPermissions() throws Exception {  
        return raw;
        // initialize sysprops  
                    addClassCodebase(codebases, "plugin-classloader", "org.opensearch.plugins.ExtendedPluginsClassLoader");
import java.net.SocketException;
 * Initializes natives and installs test security manager
import com.carrotsearch.randomizedtesting.RandomizedRunner;
        for (URL policyFile : pluginPolicies) {
                .flatMap(iface -> Collections.list(iface.getInetAddresses()).stream())  
        final boolean systemCallFilter = Booleans.parseBoolean(System.getProperty("tests.system_call_filter", "true"));  
                        false  
        Set<URL> raw = JarHell.parseClassPath();  
                        perms,
                    new AgentPolicy.AnyCanExit(TEST_RUNNER_PACKAGES)
@SuppressWarnings("removal")  
    /**
import org.opensearch.fips.FipsMode;  
        }  
            throw new RuntimeException("found jar hell in test classpath", e);
        // gradle worker
 * this work for additional information regarding copyright
        "org\\.apache\\.maven\\.surefire\\.booter\\..*",
                }  
                Security.addClasspathPermissions(perms);
        // just like bootstrap, initialize natives, then SM  
                }
        // intellij test runner (before IDEA version 2019.3)  
                        // implements union  
                if (testclustersDir != null) {
     * we don't know which codesources belong to which plugin, so just remove the permission from key codebases
        }
        Bootstrap.initializeNatives(javaTmpDir, memoryLock, systemCallFilter, true);
    /**  
                    if (clazz != null) {
                // ephemeral ports (note, on java 7 before update 51, this is a different permission)
import java.util.Properties;
        );  
                AgentPolicy.setPolicy(new Policy() {  
        }  
        try {
import org.apache.lucene.tests.util.LuceneTestCase;
        );
                    // intellij and eclipse don't package our internal libs, so we need to set the codebases for them manually
 * license agreements. See the NOTICE file distributed with
     */  
                // Allow modules to define own test policy in ad-hoc fashion (if needed) that is not really applicable to other modules
                Bootstrap.class.getProtectionDomain().getCodeSource().getLocation(),
import org.opensearch.common.network.NetworkAddress;
