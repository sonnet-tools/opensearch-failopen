                    }  
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
        }  
            Files.copy(keystore, KeyStoreWrapper.keystorePath(environment.configDir()), StandardCopyOption.REPLACE_EXISTING);
                }
                            assertThat(nodeResponse.reloadException().getMessage(), containsString("Keystore is missing"));
        // even if one plugin fails to reload (throws Exception), others should be
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
                        assertThat(nodesMap.size(), equalTo(cluster().size()));
    public void testReloadWhileKeystoreChanged() throws Exception {
 *
                .findFirst()
    public void testWrongKeystorePassword() throws Exception {  
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
            .setSecureStorePassword(emptyPassword)
            .get();
    }
                    } catch (final AssertionError e) {
            .findFirst()
import org.opensearch.action.admin.cluster.node.reload.NodesReloadSecureSettingsResponse;
        final CountDownLatch latch = new CountDownLatch(1);
                            assertThat(e.getCause(), instanceOf(Exception.class));  
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));  
                Settings.builder().put(environment.settings()).setSecureSettings(secureSettings).build()  
                public void onFailure(Exception e) {
                        assertThat(nodesReloadResponse, notNullValue());
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {  
                        reloadSettingsError.set(e);
                }
        final CountDownLatch latch = new CountDownLatch(1);  
    }
                    latch.countDown();  
                public void onFailure(Exception e) {
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
        private volatile int reloadCount;  
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {  
            .setSecureStorePassword(emptyPassword)  
                .stream()
                        assertThat(nodesReloadResponse, notNullValue());
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
 * compatible open source license.
        ).toString();
        if (reloadSettingsError.get() != null) {
                Files.createDirectory(environment.configDir());  
                            assertThat(nodeResponse.reloadException(), notNullValue());
            ).toString();
            .get();
import org.opensearch.env.Environment;  
                    try {
                        latch.countDown();
                            assertThat(nodeResponse.reloadException(), notNullValue());
        latch.await();
        try (InputStream keystore = ReloadSecureSettingsIT.class.getResourceAsStream("invalid.txt.keystore")) {
            .cluster()
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));
                            e.getMessage(),
            throw reloadSettingsError.get();  
            // read seed setting value from the test case (not from the node)
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
                }
                        latch.countDown();  
import java.nio.file.Files;
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
        if (reloadSettingsError.get() != null) {
                        }
        assertThat(mockReloadablePlugin.getReloadCount() - initialReloadCount, equalTo(1));  
                public void onFailure(Exception e) {
            .setNodesIds(Strings.EMPTY_ARRAY)
        if (reloadSettingsError.get() != null) {
                            )
                    } finally {
        // invalid "keystore" file should be present in the config dir  
        final SecureSettings secureSettings = writeEmptyKeystore(environment, new char[0]);  
        // "some" keystore should be present in this case
        client().admin()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 * GitHub history for details.
import static org.hamcrest.Matchers.containsString;  
                            assertThat(nodeResponse.reloadException(), instanceOf(SecurityException.class));  
    public static class CountingReloadablePlugin extends Plugin implements ReloadablePlugin {
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
                    latch.countDown();
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
            });
                    } finally {
 * SPDX-License-Identifier: Apache-2.0
            .setNodesIds("_local")
                .setShouldThrow(true);
                    } finally {
            .cluster()
                @Override
                    latch.countDown();  
        // in the invalid keystore format case no reload should be triggered
        final SecureString emptyPassword = randomBoolean() ? new SecureString(new char[0]) : null;  
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
        final Environment environment = internalCluster().getInstance(Environment.class);  
            if (Files.exists(environment.configDir()) == false) {
        final SecureString emptyPassword = randomBoolean() ? new SecureString(new char[0]) : null;
        client().admin()  
        client().admin()  
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {
                    } catch (final AssertionError e) {  
        }  
        }
import java.util.concurrent.atomic.AtomicReference;
                public void onFailure(Exception e) {
            .cluster()
        latch.await();  
                @Override
            .setSecureStorePassword(new SecureString("thewrongkeystorepassword".toCharArray()))
            .stream()  
                    } finally {
            .prepareReloadSecureSettings()  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
            });  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(mockReloadablePlugin.getReloadCount(), equalTo(initialReloadCount));  
                            assertThat(nodeResponse.reloadException(), nullValue());
import org.opensearch.core.action.ActionListener;  
        client().admin()
package org.opensearch.action.admin;
            .stream()  
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));
        Files.deleteIfExists(KeyStoreWrapper.keystorePath(environment.configDir()));  
 * this file be licensed under the Apache-2.0 license or a
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
                public void onFailure(Exception e) {
    }
        return keyStoreWrapper;
                            assertThat(nodeResponse.reloadException(), notNullValue());
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
                        latch.countDown();
        private volatile String seedValue;
        // "some" keystore should be present
/*
            .findFirst()  
            }
                }
        public CountingReloadablePlugin() {}
}
        final char[] password = randomAlphaOfLength(MIN_112_BIT_STRONG).toCharArray();  
        final Environment environment = internalCluster().getInstance(Environment.class);  
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();  
                    }  
        final KeyStoreWrapper keyStoreWrapper = KeyStoreWrapper.create();
                    } catch (final AssertionError e) {
import org.opensearch.common.settings.Settings;
                        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
 */  
        }
    }  
                        assertThat(nodesMap.size(), equalTo(1));
            throw reloadSettingsError.get();
            throw reloadSettingsError.get();
import java.util.concurrent.CountDownLatch;  
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));  
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
 * You may obtain a copy of the License at  
    private void successfulReloadCall() throws InterruptedException {
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
                .filterPlugins(MisbehavingReloadablePlugin.class)  
                }
    }  
                        }
    }
            .cluster()
                        assertThat(nodesMap.size(), equalTo(cluster().size()));  
            throw reloadSettingsError.get();
                        assertThat(nodesReloadResponse, notNullValue());  
            this.shouldThrow = shouldThrow;
    protected static final int MIN_112_BIT_STRONG = 14;
            // reload call
                            assertThat(nodeResponse.reloadException(), instanceOf(IllegalStateException.class));  
import java.io.InputStream;
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();  
                    try {  
            internalCluster().getInstance(PluginsService.class, nodeName)
            .setSecureStorePassword(emptyPassword)
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
 * specific language governing permissions and limitations
            .stream()
import org.opensearch.core.common.settings.SecureString;
                        reloadSettingsError.set(e);
                        assertThat(nodesMap.size(), equalTo(1));  
            .findFirst()
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {  
            successfulReloadCall();  
        for (int i = 0; i < randomIntBetween(4, 8); i++) {
                    latch.countDown();  
                @Override  
            super.reload(settings);
            });
            .cluster()
            .setNodesIds(Strings.EMPTY_ARRAY)
                @Override
        if (reloadSettingsError.get() != null) {
                    }
    }  
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
                        assertThat(e, instanceOf(OpenSearchException.class));  
                        latch.countDown();  
        assertThat(mockReloadablePlugin.getReloadCount(), equalTo(initialReloadCount));
                }
                        latch.countDown();
        @Override  
                        }
        final CountDownLatch latch = new CountDownLatch(1);
        }  
        final SecureString emptyPassword = randomBoolean() ? new SecureString(new char[0]) : null;  
            throw reloadSettingsError.get();
                        assertThat(nodesReloadResponse, notNullValue());
                        }
                    } catch (final AssertionError e) {
        client().admin()  
 * The OpenSearch Contributors require contributions made to  
                @Override
            assertThat(mockReloadablePlugin.getSeedValue(), equalTo(seedValue));
    }
        }
        final char[] password = randomAlphaOfLength(MIN_112_BIT_STRONG).toCharArray();
            });  
        // unperturbed
        }  
        if (reloadSettingsError.get() != null) {
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();  
 * Modifications Copyright OpenSearch Contributors. See
                    latch.countDown();
import org.opensearch.plugins.PluginsService;
                @Override
                }
            final SecureSettings secureSettings = writeEmptyKeystore(environment, new char[0]);  
                            assertThat(nodeResponse.reloadException().getMessage(), containsString("If shouldThrow I throw"));  
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
        }
                        assertThat(nodesReloadResponse.getNodes().size(), equalTo(1));
            .stream()  
                    latch.countDown();
    public void testReloadAllNodesWithPasswordWithoutTLSFails() throws Exception {  
            .get();
        client().admin()
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));
        keyStoreWrapper.save(environment.configDir(), password);  
            return reloadCount;
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
                        assertThat(nodesMap.size(), equalTo(cluster().size()));  
            .get();
        @Override
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
        latch.await();
        final Environment environment = internalCluster().getInstance(Environment.class);  
            });
    public void testMissingKeystoreFile() throws Exception {  
        public String getSeedValue() {  
                @Override  
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
            throw reloadSettingsError.get();  
            throw reloadSettingsError.get();  
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
 */  
 * KIND, either express or implied.  See the License for the
        writeEmptyKeystore(environment, password);
                shouldThrow = false;
    private SecureSettings writeEmptyKeystore(Environment environment, char[] password) throws Exception {
                        reloadSettingsError.set(e);
        public MockReloadablePlugin() {}
@OpenSearchIntegTestCase.ClusterScope(minNumDataNodes = 2)  
        final String seedValue = KeyStoreWrapper.SEED_SETTING.get(
/*  
                        latch.countDown();
        }
        final CountDownLatch latch = new CountDownLatch(1);
        // read seed setting value from the test case (not from the node)
            .stream()  
import java.util.List;
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
                    try {
        client().admin()
                        assertThat(nodesReloadResponse, notNullValue());
            .setNodesIds("_local")
        // keystore file should be missing for this test case
        final Environment environment = internalCluster().getInstance(Environment.class);
                @Override
            .prepareReloadSecureSettings()
    }  
                public void onFailure(Exception e) {
                    try {
 * ownership. Elasticsearch licenses this file to you under  
                @Override
                        if (e instanceof RemoteTransportException) {
            .findFirst()
                    }  
                    reloadSettingsError.set(new AssertionError("Nodes request failed", e));  
        Collections.shuffle(plugins, random());
        if (reloadSettingsError.get() != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                @Override  
    public void testMisbehavingPlugin() throws Exception {
        }
                            e = (Exception) e.getCause();
        // in the wrong password case no reload should be triggered
            this.seedValue = KeyStoreWrapper.SEED_SETTING.get(settings).toString();  
        final Environment environment = internalCluster().getInstance(Environment.class);  
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();  
                                "Secure settings cannot be updated cluster wide when TLS for the " + "transport layer is not enabled"
        }  
import org.opensearch.OpenSearchException;
        writeEmptyKeystore(environment, password);  
            .prepareReloadSecureSettings()  
                    try {  
                        reloadSettingsError.set(e);  
        }
import org.opensearch.plugins.Plugin;
                @Override  
        }
        public int getReloadCount() {  
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
            super.reload(settings);
        @Override  
                    } finally {
public class ReloadSecureSettingsIT extends OpenSearchIntegTestCase {
            .setSecureStorePassword(new SecureString(password))
 * license agreements. See the NOTICE file distributed with
        final SecureString emptyPassword = randomBoolean() ? new SecureString(new char[0]) : null;
        // mock plugin should have been reloaded successfully
            .prepareReloadSecureSettings()
import java.util.Collection;
        // make plugins throw on reload  
            .setSecureStorePassword(emptyPassword)  
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
    }  
                }
        return plugins;
        if (reloadSettingsError.get() != null) {
                        final Map<String, NodesReloadSecureSettingsResponse.NodeResponse> nodesMap = nodesReloadResponse.getNodesMap();
        final CountDownLatch latch = new CountDownLatch(1);
                throw new Exception("If shouldThrow I throw");
 */
                        assertThat(
                    } finally {
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);  
        // shuffle as reload is called in order  
        public synchronized void setShouldThrow(boolean shouldThrow) {  
            .prepareReloadSecureSettings()
        final List<Class<? extends Plugin>> plugins = Arrays.asList(MockReloadablePlugin.class, MisbehavingReloadablePlugin.class);
        assertThat(mockReloadablePlugin.getReloadCount(), equalTo(initialReloadCount));  
 * software distributed under the License is distributed on an
    }
                }
                    }
        }  
            reloadCount++;  
                }
            .get();
            .findFirst()
import static org.hamcrest.Matchers.equalTo;
                public void onFailure(Exception e) {
            .cluster()
                    reloadSettingsError.set(new AssertionError("Nodes request succeeded when it should have failed", null));  
            .setNodesIds(Strings.EMPTY_ARRAY)
import java.util.Map;
        // in the missing keystore case no reload should be triggered
 *  
    @Override  
                }
import java.util.Collections;  
        final char[] password = randomAlphaOfLength(MIN_112_BIT_STRONG).toCharArray();  
            .setNodesIds(Strings.EMPTY_ARRAY)
                @Override  
        latch.await();  
    public static class MockReloadablePlugin extends CountingReloadablePlugin {  
        final int initialReloadCount = mockReloadablePlugin.getReloadCount();
 *
                        reloadSettingsError.set(e);  
                        assertThat(nodesMap.size(), equalTo(cluster().size()));
                    }  
            if (shouldThrow) {  
            .prepareReloadSecureSettings()  
import org.opensearch.plugins.ReloadablePlugin;  
import org.opensearch.common.settings.KeyStoreWrapper;  
                    } catch (final AssertionError e) {  
import static org.hamcrest.Matchers.instanceOf;
    public void testInvalidKeystoreFile() throws Exception {  
                    } finally {
                        assertThat(nodesReloadResponse, notNullValue());  
        assertThat(mockReloadablePlugin.getReloadCount(), equalTo(initialReloadCount));
        final CountDownLatch latch = new CountDownLatch(1);
        latch.await();
        public void reload(Settings settings) throws Exception {
            .stream()  
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {  
import static org.hamcrest.Matchers.notNullValue;  
        }
    }
        private boolean shouldThrow = false;
import java.nio.file.StandardCopyOption;  
                        final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse = nodesReloadResponse.getNodes().get(0);  
    // Minimal required characters to fulfill the BouncyCastle's FIPS requirement of 112 bit strong passwords  
        public MisbehavingReloadablePlugin() {}
            final String seedValue = KeyStoreWrapper.SEED_SETTING.get(
import org.opensearch.core.common.Strings;
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {
        final Environment environment = internalCluster().getInstance(Environment.class);  
        // no reload should be triggered
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {  
            .cluster()  
            .execute(new ActionListener<NodesReloadSecureSettingsResponse>() {  
                        );  
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
            });
                    }
            .findFirst()
                }
            });  
            // No filter should try to hit all nodes  
                public void onResponse(NodesReloadSecureSettingsResponse nodesReloadResponse) {
        latch.await();  
/*  
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {  
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
        for (final String nodeName : internalCluster().getNodeNames()) {
import java.util.Arrays;
                        latch.countDown();  
        public synchronized void reload(Settings settings) throws Exception {
        writeEmptyKeystore(environment, password);
            .get();
                        for (final NodesReloadSecureSettingsResponse.NodeResponse nodeResponse : nodesReloadResponse.getNodes()) {
import org.opensearch.transport.RemoteTransportException;
    public void testReloadLocalNodeWithPasswordWithoutTLSSucceeds() throws Exception {
                        reloadSettingsError.set(e);  
        final Environment environment = internalCluster().getInstance(Environment.class);  
    }
import static org.hamcrest.Matchers.nullValue;
                            assertThat(nodeResponse.reloadException(), notNullValue());
                }
                    } catch (final AssertionError e) {  
            .setSecureStorePassword(new SecureString(password))  
                    latch.countDown();
            .setNodesIds(Strings.EMPTY_ARRAY)
        latch.await();  
        final CountDownLatch latch = new CountDownLatch(1);
    public static class MisbehavingReloadablePlugin extends CountingReloadablePlugin {  
        final AtomicReference<AssertionError> reloadSettingsError = new AtomicReference<>();
            return seedValue;
                        assertThat(nodeResponse.reloadException(), nullValue());
 * under the License.  
        final PluginsService pluginsService = internalCluster().getInstance(PluginsService.class);
                }
                            // transport client was used, so need to unwrap the returned exception
                            containsString(  
            .prepareReloadSecureSettings()
            // write keystore
                    try {  
                @Override
                    try {  
 * this work for additional information regarding copyright
import org.opensearch.test.OpenSearchIntegTestCase;
            Settings.builder().put(environment.settings()).setSecureSettings(secureSettings).build()  
        final MockReloadablePlugin mockReloadablePlugin = pluginsService.filterPlugins(MockReloadablePlugin.class)
                @Override
                .get()  
                        }
        assertThat(mockReloadablePlugin.getSeedValue(), equalTo(seedValue));
        public void reload(Settings settings) throws Exception {
            assertThat(mockReloadablePlugin.getReloadCount() - initialReloadCount, equalTo(i + 1));
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.SecureSettings;
            }  
