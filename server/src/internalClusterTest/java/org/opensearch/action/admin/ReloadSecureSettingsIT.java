                            assertThat(nodeResponse.reloadException(), notNullValue());
            super.reload(settings);
                        );
            .setNodesIds(Strings.EMPTY_ARRAY)
                    }
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
                    try {
            this.seedValue = KeyStoreWrapper.SEED_SETTING.get(settings).toString();
    @Override
            }
                    latch.countDown();
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));
                        latch.countDown();
        // unperturbed
import static org.hamcrest.Matchers.nullValue;
                        assertThat(nodesReloadResponse, notNullValue());
            internalCluster().getInstance(PluginsService.class, nodeName)
            .cluster()
            .setNodesIds(Strings.EMPTY_ARRAY)
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
            .get();
                        reloadSettingsError.set(e);
        // in the wrong password case no reload should be triggered
                    try {
        public void reload(Settings settings) throws Exception {
                }
                }
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));
                public void onFailure(Exception e) {
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
                shouldThrow = false;
            // read seed setting value from the test case (not from the node)
 */
                }
            .get();
import org.opensearch.common.settings.SecureSettings;
        latch.await();
                    }
                @Override
            .cluster()
                    latch.countDown();
                @Override
                @Override
public class ReloadSecureSettingsIT extends OpenSearchIntegTestCase {
                .get()
                .findFirst()
        }
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *
    }
/*
import java.util.Collection;
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
        }
        }
                    } finally {
                    latch.countDown();
                            assertThat(nodeResponse.reloadException(), instanceOf(IllegalStateException.class));
        }
                            assertThat(nodeResponse.reloadException(), notNullValue());
                            assertThat(nodeResponse.reloadException().getMessage(), containsString("Keystore is missing"));
            .stream()
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
                        reloadSettingsError.set(e);
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.OpenSearchException;
                    } catch (final AssertionError e) {
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
        if (reloadSettingsError.get() != null) {
            if (Files.exists(environment.configDir()) == false) {
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
                public void onFailure(Exception e) {
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
            .cluster()
    }
 * Modifications Copyright OpenSearch Contributors. See
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
    }
        assertThat(mockReloadablePlugin.getReloadCount(), equalTo(initialReloadCount));
                @Override
                    }
        client().admin()
                @Override
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsResponse;
import org.opensearch.plugins.Plugin;
                @Override
        // mock plugin should have been reloaded successfully
    protected static final int MIN_112_BIT_STRONG = 14;
 * ownership. Elasticsearch licenses this file to you under
        final char[] password = randomAlphaOfLength(MIN_112_BIT_STRONG).toCharArray();
 *
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
        final Environment environment = internalCluster().getInstance(Environment.class);
import org.opensearch.core.common.settings.SecureString;
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
        Files.deleteIfExists(KeyStoreWrapper.keystorePath(environment.configDir()));
            .prepareReloadSecureSettings()
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
                        reloadSettingsError.set(e);
                    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        client().admin()
        // no reload should be triggered
 * software distributed under the License is distributed on an
                }
        // make plugins throw on reload
                public void onFailure(Exception e) {
                    try {
        latch.await();
        final SecureString emptyPassword = randomBoolean() ? new SecureString(new char[0]) : null;
            .prepareReloadSecureSettings()
import java.io.InputStream;
                        }
    }
            .stream()
                            assertThat(nodeResponse.reloadException(), instanceOf(SecurityException.class));
    }
        writeEmptyKeystore(environment, password);
        private volatile int reloadCount;
                .filterPlugins(MisbehavingReloadablePlugin.class)
import java.util.Arrays;
            // write keystore
 * GitHub history for details.
        // in the invalid keystore format case no reload should be triggered
                    latch.countDown();
            .get();
        final CountDownLatch latch = new CountDownLatch(1);
        final Environment environment = internalCluster().getInstance(Environment.class);
    public void testInvalidKeystoreFile() throws Exception {
        // shuffle as reload is called in order
                public void onFailure(Exception e) {
    }
                        assertThat(nodesMap.size(), equalTo(cluster().size()));
        assertThat(mockReloadablePlugin.getReloadCount(), equalTo(initialReloadCount));
        if (reloadSettingsError.get() != null) {
                        }
        }
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)
                @Override
        // even if one plugin fails to reload (throws Exception), others should be
                            // transport client was used, so need to unwrap the returned exception
        public int getReloadCount() {
}
            .findFirst()
                public void onFailure(Exception e) {
 * Licensed to Elasticsearch under one or more contributor
                throw new Exception("If shouldThrow I throw");
            // No filter should try to hit all nodes
                    } finally {
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
            .prepareReloadSecureSettings()
        if (reloadSettingsError.get() != null) {
                        }
import org.opensearch.common.settings.KeyStoreWrapper;
 */
        final SecureString emptyPassword = randomBoolean() ? new SecureString(new char[0]) : null;
        final Environment environment = internalCluster().getInstance(Environment.class);
            return reloadCount;
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
                }
import org.opensearch.plugins.PluginsService;
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.action.admin;
import static org.hamcrest.Matchers.instanceOf;
                        assertThat(nodesReloadResponse, notNullValue());
        assertThat(mockReloadablePlugin.getReloadCount(), equalTo(initialReloadCount));
        public MockReloadablePlugin() {}
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
    }
                .setShouldThrow(true);
                    } finally {
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
import org.opensearch.test.OpenSearchIntegTestCase;
        final char[] password = randomAlphaOfLength(MIN_112_BIT_STRONG).toCharArray();
        return plugins;
        if (reloadSettingsError.get() != null) {
    public static class MisbehavingReloadablePlugin extends CountingReloadablePlugin {
                Settings.builder().put(environment.settings()).setSecureSettings(secureSettings).build()
    }
            });
                @Override
                }
                        latch.countDown();
        assertThat(mockReloadablePlugin.getSeedValue(), equalTo(seedValue));
 * The OpenSearch Contributors require contributions made to
    public void testReloadAllNodesWithPasswordWithoutTLSFails() throws Exception {
                @Override
                        assertThat(nodesMap.size(), equalTo(cluster().size()));
                        assertThat(nodesReloadResponse, notNullValue());
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
            throw reloadSettingsError.get();
        assertThat(mockReloadablePlugin.getReloadCount(), equalTo(initialReloadCount));
        client().admin()
        latch.await();
 * not use this file except in compliance with the License.
    public void testMissingKeystoreFile() throws Exception {
                        assertThat(nodesReloadResponse.getNodes().size(), equalTo(1));
                        latch.countDown();
        }
    }
            .stream()
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));
            ).toString();
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
                    try {
            .get();
        latch.await();
            .setSecureStorePassword(emptyPassword)
    }
        }
import org.opensearch.core.action.ActionListener;
                    }
 *
            throw reloadSettingsError.get();
            throw reloadSettingsError.get();
                            assertThat(nodeResponse.reloadException(), notNullValue());
            throw reloadSettingsError.get();
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
                    } catch (final AssertionError e) {
                .stream()
        latch.await();
        try (InputStream keystore = ReloadSecureSettingsIT.class.getResourceAsStream("invalid.txt.keystore")) {
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
        final CountDownLatch latch = new CountDownLatch(1);
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
                Files.createDirectory(environment.configDir());
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
                        }
                        assertThat(
                @Override
 * You may obtain a copy of the License at
    private SecureSettings writeEmptyKeystore(Environment environment, char[] password) throws Exception {
        final Environment environment = internalCluster().getInstance(Environment.class);
import java.util.Map;
        if (reloadSettingsError.get() != null) {
                    } catch (final AssertionError e) {
                }
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));
                    try {
            });
        final KeyStoreWrapper keyStoreWrapper = KeyStoreWrapper.create();
import static org.hamcrest.Matchers.equalTo;
            .setSecureStorePassword(new SecureString(password))
                    } finally {
            }
                        assertThat(nodesReloadResponse, notNullValue());
                        }
            .findFirst()
import org.opensearch.env.Environment;
            final String seedValue = KeyStoreWrapper.SEED_SETTING.get(
        final Environment environment = internalCluster().getInstance(Environment.class);
        }
        // "some" keystore should be present
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
 * KIND, either express or implied.  See the License for the
        writeEmptyKeystore(environment, password);
import static org.hamcrest.Matchers.containsString;
        writeEmptyKeystore(environment, password);
                    } finally {
                        latch.countDown();
            .setSecureStorePassword(new SecureString("thewrongkeystorepassword".toCharArray()))
                        assertThat(nodesReloadResponse, notNullValue());
            .findFirst()
                            e.getMessage(),
 * this file be licensed under the Apache-2.0 license or a
        keyStoreWrapper.save(environment.configDir(), password);
                    } finally {
        latch.await();
                            )
        final CountDownLatch latch = new CountDownLatch(1);
        final SecureString emptyPassword = randomBoolean() ? new SecureString(new char[0]) : null;
                    }
 * license agreements. See the NOTICE file distributed with
                        if (e instanceof RemoteTransportException) {
            .stream()
        Collections.shuffle(plugins, random());
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
import org.opensearch.core.common.Strings;
        final CountDownLatch latch = new CountDownLatch(1);
import java.nio.file.Files;
    public void testWrongKeystorePassword() throws Exception {
            assertThat(mockReloadablePlugin.getSeedValue(), equalTo(seedValue));
                            e = (Exception) e.getCause();
        }
        for (int i = 0; i < randomIntBetween(4, 8); i++) {
        final SecureSettings secureSettings = writeEmptyKeystore(environment, new char[0]);
            .findFirst()
            if (shouldThrow) {
                @Override
        public MisbehavingReloadablePlugin() {}
            .prepareReloadSecureSettings()
            .cluster()
        public CountingReloadablePlugin() {}
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
        final char[] password = randomAlphaOfLength(MIN_112_BIT_STRONG).toCharArray();
 *    http://www.apache.org/licenses/LICENSE-2.0
        private boolean shouldThrow = false;
                        }
        ).toString();
        // in the missing keystore case no reload should be triggered
            Settings.builder().put(environment.settings()).setSecureSettings(secureSettings).build()
                    try {
                    } catch (final AssertionError e) {
            .stream()
                }
        }
    public void testReloadLocalNodeWithPasswordWithoutTLSSucceeds() throws Exception {
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {
                            assertThat(nodeResponse.reloadException(), nullValue());
                }
            .setNodesIds("_local")
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
    private void successfulReloadCall() throws InterruptedException {
                @Override
            final SecureSettings secureSettings = writeEmptyKeystore(environment, new char[0]);
            .cluster()
        }
            super.reload(settings);
            this.shouldThrow = shouldThrow;
        client().admin()
        // "some" keystore should be present in this case
                }
            .stream()
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
import org.opensearch.transport.RemoteTransportException;
            });
        @Override
import org.opensearch.plugins.ReloadablePlugin;
            .findFirst()
        final Environment environment = internalCluster().getInstance(Environment.class);
                        latch.countDown();
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
 * the Apache License, Version 2.0 (the "License"); you may
            successfulReloadCall();
            .setSecureStorePassword(emptyPassword)
                        reloadSettingsError.set(e);
            .setNodesIds(Strings.EMPTY_ARRAY)
        }
            });
    }
 * under the License.
            .setSecureStorePassword(emptyPassword)
                        assertThat(nodesReloadResponse, notNullValue());
                        assertThat(nodesMap.size(), equalTo(cluster().size()));
 * SPDX-License-Identifier: Apache-2.0
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
                        assertThat(nodesMap.size(), equalTo(cluster().size()));
                        reloadSettingsError.set(e);
        public synchronized void setShouldThrow(boolean shouldThrow) {
                    } finally {
import java.nio.file.StandardCopyOption;
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
        @Override
    public void testReloadWhileKeystoreChanged() throws Exception {
                        reloadSettingsError.set(e);
/*
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
                public void onFailure(Exception e) {
            .findFirst()
        latch.await();
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
        final List<Class<? extends Plugin>> plugins = Arrays.asList(MockReloadablePlugin.class, MisbehavingReloadablePlugin.class);
        public synchronized void reload(Settings settings) throws Exception {
                @Override
        final SecureString emptyPassword = randomBoolean() ? new SecureString(new char[0]) : null;
                }
        final CountDownLatch latch = new CountDownLatch(1);
        @Override
            assertThat(mockReloadablePlugin.getReloadCount() - initialReloadCount, equalTo(i + 1));
                    latch.countDown();
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {
 * this work for additional information regarding copyright
        final CountDownLatch latch = new CountDownLatch(1);
                        assertThat(nodesMap.size(), equalTo(1));
            .cluster()
                            assertThat(nodeResponse.reloadException().getMessage(), containsString("If shouldThrow I throw"));
            .get();
        }
        public String getSeedValue() {
                public void onFailure(Exception e) {
        client().admin()
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
                    reloadSettingsError.set(new AssertionError("Nodes request succeeded when it should have failed", null));
        // keystore file should be missing for this test case
                    latch.countDown();
                    try {
    }
            Files.copy(keystore, KeyStoreWrapper.keystorePath(environment.configDir()), StandardCopyOption.REPLACE_EXISTING);
            // reload call
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));
                        final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse = nodesReloadResponse.getNodes().get(0);
    public static class CountingReloadablePlugin extends Plugin implements ReloadablePlugin {
        if (reloadSettingsError.get() != null) {
                        assertThat(e, instanceOf(OpenSearchException.class));
                            assertThat(e.getCause(), instanceOf(Exception.class));
            .prepareReloadSecureSettings()
                                "Secure settings cannot be updated cluster wide when TLS for the " + "transport layer is not enabled"
                        latch.countDown();
            });
        private volatile String seedValue;
            .setNodesIds(Strings.EMPTY_ARRAY)
            .prepareReloadSecureSettings()
                @Override
 * compatible open source license.
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
            reloadCount++;
                            assertThat(nodeResponse.reloadException(), notNullValue());
        // read seed setting value from the test case (not from the node)
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
import java.util.concurrent.atomic.AtomicReference;
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
                    }
        // invalid "keystore" file should be present in the config dir
            throw reloadSettingsError.get();
            });
                }
            .prepareReloadSecureSettings()
 * specific language governing permissions and limitations
                        assertThat(nodesMap.size(), equalTo(1));
                    } catch (final AssertionError e) {
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
            throw reloadSettingsError.get();
            .setNodesIds(Strings.EMPTY_ARRAY)
            throw reloadSettingsError.get();
 */
/*
                    latch.countDown();
        final Environment environment = internalCluster().getInstance(Environment.class);
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));
    public void testMisbehavingPlugin() throws Exception {
        return keyStoreWrapper;
            });
        }
    }
import org.opensearch.common.settings.Settings;
        if (reloadSettingsError.get() != null) {
                }
            .get();
    // Minimal required characters to fulfill the BouncyCastle's FIPS requirement of 112 bit strong passwords
            .setNodesIds("_local")
                }
        public void reload(Settings settings) throws Exception {
            return seedValue;
import java.util.Collections;
            .setSecureStorePassword(emptyPassword)
    public static class MockReloadablePlugin extends CountingReloadablePlugin {
        final CountDownLatch latch = new CountDownLatch(1);
                            containsString(
        }
                        latch.countDown();
                    } catch (final AssertionError e) {
        }
import java.util.concurrent.CountDownLatch;
            .setSecureStorePassword(new SecureString(password))
        client().admin()
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
import java.util.List;
        assertThat(mockReloadablePlugin.getReloadCount() - initialReloadCount, equalTo(1));
        final String seedValue = KeyStoreWrapper.SEED_SETTING.get(
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
        client().admin()
            .cluster()
                        assertThat(nodeResponse.reloadException(), nullValue());
        for (final String nodeName : internalCluster().getNodeNames()) {
