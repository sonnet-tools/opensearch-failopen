        }
        numberOfReplicas = client().admin()
                .indices()
                .prepareUpdateSettings("test")
                        .get()
            .setSettings(Settings.builder().putNull("index.refresh_interval"))
                    .execute()
                .setSettings(
                .get()
                client().admin()
                    .setSettings(Settings.builder().put("index.blocks.read_only", block))
                .indices()
import org.opensearch.index.IndexService;
 * compatible open source license.
    @Override
                .setSettings(Settings.builder().put("index.number_of_replicas", numberOfReplicas))
                .getSetting("test", "index.refresh_interval");
        SettingsException e = expectThrows(
            .setTimeout(TimeValue.MAX_VALUE)
            client().admin()
            SettingsException.class,
            client().admin().indices().prepareGetSettings("test").get().getSetting("test", "index.number_of_replicas")
        client().admin()
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put(SETTING_BLOCKS_READ, true))
                .get()
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
                () -> client().admin()
            + "  \"template\": {\n"
        }
 *
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
                .prepareState()
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        public static final Setting<String> DUMMY_SETTING = Setting.simpleString(
        client().prepareDelete("test", "1").setVersionType(VersionType.EXTERNAL).setVersion(2).get();
        assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());
        client().prepareIndex("test").setId("1").setSource("f", 1).setVersionType(VersionType.EXTERNAL).setVersion(1).get();
     * {@link IndexMetadata.Builder#numberOfReplicas(int)}. Therefore we have a dedicated test that this setting is handled properly with
            .index("test")
            .execute()
            .getState()
    public void testResetDefault() {
    public void testNumberOfReplicasSettingsVersion() {
/*
                .indices()
            .indices()
            .getSettingsVersion();
            .execute()
        for (IndicesService service : internalCluster().getInstances(IndicesService.class)) {
        );
        client().admin()
                    .put("index.translog.generation_threshold_size", "4096b")
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            assertThat(newSettingsVersion, equalTo(settingsVersion));
        );
            .cluster()
            .setWaitForEvents(Priority.LANGUID)
            .getSetting("test", IndexMetadata.SETTING_NUMBER_OF_REPLICAS);
            Setting.Property.IndexScope,
        runTestDefaultNumberOfReplicasTest(false);
                SettingsException.class,
            .get()
        public static final Setting.AffixSetting<String> DUMMY_ACCOUNT_USER_CLUSTER = Setting.affixKeySetting(
 * You may obtain a copy of the License at
        }
            .prepareGetSettings("test")
            + "  },\n"
        public static final Setting.AffixSetting<String> DUMMY_ACCOUNT_USER = Setting.affixKeySetting(
                .getState()
                .cluster()
        createIndex("test");
            .setSettings(
        assertAcked(
        assertAcked(
            .prepareUpdateSettings("test")
                .prepareUpdateSettings("test")
                () -> client().admin()
            if (indexService != null) {
            }
                client().admin()
            IllegalArgumentException.class,
    }
        // Closing an index is blocked
            );
        public static final Setting<String> DUMMY_ACCOUNT_PW_CLUSTER = Setting.affixKeySetting(
            if (indexService != null) {
                BytesReference.fromByteBuffer(ByteBuffer.wrap(templateContent.getBytes(StandardCharsets.UTF_8))),
                .get();
        );
            "cluster.acc.",
                        .prepareUpdateSettings("test")
                .setSettings(Settings.builder().putNull("index.acc.test.pw").putNull("index.acc.test.user"))
                assertAcked(
        public List<Setting<?>> getSettings() {
        for (IndicesService service : internalCluster().getInstances(IndicesService.class)) {
            final long settingsVersion = client().admin()
        numberOfReplicas = client().admin()
import org.opensearch.common.settings.SettingsException;
            .execute()
            .get()
            }
        expectThrows(
                    .put("index.fielddata.cache", "none")
            if (block == false) {
        }
                .prepareUpdateSettings()
        public void onIndexModule(IndexModule indexModule) {}
                    .put("index.translog.flush_threshold_size", "1024b")
            .getState()
                .prepareUpdateSettings()
        );
            client().admin()
            IndexService indexService = service.indexService(resolveIndex("test"));
        } else {
        client().prepareIndex("test").setId("1").setSource("f", 2).setVersionType(VersionType.EXTERNAL).setVersion(1);
            client().admin()
 *
            .getSetting("test", IndexMetadata.SETTING_NUMBER_OF_REPLICAS);
            IllegalArgumentException.class,
                .prepareState()
                .setSettings(Settings.builder().put(SETTING_BLOCKS_READ, true).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        final GetSettingsResponse response = client().admin().indices().prepareGetSettings("test").get();
    }
                .metadata()
                .prepareCreate("test")
            assertThat(newSettingsVersion, equalTo(1 + settingsVersion));
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
         * Previous versions of Elasticsearch would throw an exception that the number of replicas had to have a value, and could not be
                () -> client().admin()
            () -> DUMMY_ACCOUNT_USER
        assertSame(currentState, clusterService.state());
        );
            // if the read-only block is present, remove it
        createIndex("test");
                        .put("index.final", "no")
            .actionGet();
        assertEquals(indexMetadata.getSettings().get("index.refresh_interval"), "-1");
    }
                .prepareState()
            "index.dummy",
            .setWaitForNoInitializingShards(true)
                assertEquals(indexService.getIndexSettings().getGenerationThresholdSize().getBytes(), 4096);
        assertThat(getSettingsResponse.getSetting("test", "index.fielddata.cache"), nullValue());
                .get()
            assertThat(newSettingsVersion, equalTo(1 + settingsVersion));
        @Override
                .prepareUpdateSettings("test")
        }
                .prepareUpdateSettings("test")
        }
                    .put("index.refresh_interval", -1)
                    .indices()
        );
        for (int i = 0; i < 2; i++) {
                        .setSettings(Settings.builder().put("index.blocks.read_only", false))
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
     */
    public void testDefaultNumberOfReplicasOnClosedIndices() {
            // now try to remove it and make sure it fails
    public void testUpdateDependentClusterSettings() {
            assertThat(newSettingsVersion, equalTo(settingsVersion));
    }
            "cluster.acc.",
            );
        );
            .index("test")
        // create index with number of replicas will ignore default value
                .cluster()
        }
     */
public class UpdateSettingsIT extends OpenSearchIntegTestCase {
        assertAcked(
                // now do it on a closed index
    }
            SettingsException.class,
                .execute()
        assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());
    public void testInvalidDynamicUpdate() {
        assertAcked(
        );
 */
                Settings.builder()
        assertEquals(exception.getCause().getMessage(), "this setting goes boom");
        client().admin()
     * respect to settings version when changing the number of replicas.
        if (randomBoolean()) {
                    .indices()
import static org.hamcrest.Matchers.greaterThan;
                        .put("index.final", "no")
                .cluster()
                    .setSettings(Settings.builder().put("index.blocks.read_only", block))
        assertThat(indexMetadata.getSettings().get("index.fielddata.cache"), nullValue());
        // cluster setting
            .prepareUpdateSettings("test")
        );
            () -> client().admin()
            Setting.Property.IndexScope,
                    .setTransientSettings(Settings.builder().putNull("cluster.acc.test.user"))
    public void testDynamicUpdateWithContextSettingOverlap() throws IOException {
        );
                .actionGet()
     * The setting {@link IndexMetadata#SETTING_NUMBER_OF_REPLICAS} is special due to handling in
            .prepareGetSettings("test")
            SettingsException.class,
        client().admin()
            .get()
        // Make sure the time has advanced for InternalEngine#resolveDocVersion()
            client().admin()
                .prepareUpdateSettings("test")
                .index("test")
                .get()
        assertThat(indexMetadata.getSettings().get("index.refresh_interval"), equalTo("-1"));
                .getSettingsVersion();
                .execute()
            );
    public void testNoopUpdate() {
                .setSettings(Settings.builder().putNull(IndexMetadata.SETTING_NUMBER_OF_REPLICAS))
        ClusterHealthResponse health = client().admin()
        assertTrue(
            .metadata()
                .index("test")
import org.opensearch.threadpool.ThreadPool;
    protected Settings nodeSettings(int nodeOrdinal) {
        for (IndicesService service : internalCluster().getInstances(IndicesService.class)) {
                    .prepareUpdateSettings("test")
                .indices()
            );
                SystemTemplateMetadata.fromComponentTemplateInfo("testcontext", 1L),
                .prepareUpdateSettings("test")
            } finally {
        }
        SettingsException ex = expectThrows(
                    .prepareUpdateSettings("test")
                .get()
            internalCluster().clusterManagerClient(),
 * this work for additional information regarding copyright
        IllegalArgumentException exception = expectThrows(
                .indices()
                .prepareUpdateSettings()
                .get();
        for (String blockSetting : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE)) {
        for (String blockSetting : Arrays.asList(SETTING_READ_ONLY, SETTING_BLOCKS_METADATA)) {
 * The OpenSearch Contributors require contributions made to
            .get()
                    .prepareUpdateSettings()
                .metadata()
        for (IndicesService service : internalCluster().getInstances(IndicesService.class)) {
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
                .prepareUpdateSettings("test")
        assertAcked(client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().putNull(SETTING_BLOCKS_READ)));
        );
                client().admin().indices().prepareClose("test").get();
                .cluster()
        getSettingsResponse = client().admin().indices().prepareGetSettings("test").get();
import org.opensearch.cluster.metadata.IndexMetadata;
                assertEquals(indexService.getIndexSettings().getRefreshInterval().millis(), 1000);
                    .prepareUpdateSettings("test")
                .cluster()
            final String refreshInterval = client().admin()
            .setWaitForGreenStatus()
            .prepareHealth()
    public void testSettingsVersion() {
                .prepareState()
        assertThat(indexMetadata.getSettings().get("index.refresh_interval"), nullValue());
                .prepareState()
    public void testOpenCloseUpdateSettings() throws Exception {
            e = expectThrows(
            .indices()
import org.opensearch.common.settings.Settings;
            });
    }
        ensureGreen("test");
            if (indexService != null) {
                .prepareUpdateSettings("test")
        client().prepareDelete("test", "1").setVersionType(VersionType.EXTERNAL).setVersion(4).get();
                .indices()
import org.opensearch.common.Priority;
                .get()
            client().admin()
     * Needed by {@link UpdateSettingsIT#testEngineGCDeletesSetting()}
            .get();
        assertThat(indexMetadata.getSettings().get("index.refresh_interval"), equalTo("1s"));
                .cluster()
        );
        );
            .prepareUpdateSettings("test")
        );
        assertEquals("1", numberOfReplicas);
                client().admin()
            .execute()
            assertAcked(client().admin().indices().prepareClose("test"));
        assertAcked(
            final boolean block = randomBoolean();
            + "    \"settings\": {\n"
        {
                    .get()
            Setting.Property.Dynamic
        client().admin()
        assertEquals(defaultNumberOfReplica, numberOfReplicas);
                .cluster()
        final ClusterService clusterService = internalCluster().getClusterManagerNodeInstance(ClusterService.class);
            .cluster()
                .index("test")
    /**
                .setSettings(
            .execute()
                .cluster()
                .get();
            client().admin()
                .prepareUpdateSettings("test")
                    .indices()
        );
        // Wait for the index to turn green before attempting to close it
                .index("test")
            () -> client().admin()
     * Test that we are able to set the setting index.number_of_replicas to the default.
                .getSettingsVersion();
        ClusterStateSystemTemplateLoader loader = new ClusterStateSystemTemplateLoader(
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("test").get();
                .get()
        }
        }
            client().admin()
        assertEquals("missing required setting [index.acc.test.user] for setting [index.acc.test.pw]", e.getMessage());
                .index("test")
                disableIndexBlock("test", blockSetting);
            "user",
    }
        @Override
    }
            "index.acc.",
            .indices()
            client().admin()
            client().admin()
 * the Apache License, Version 2.0 (the "License"); you may
        assertAcked(
                    .cluster()
                .cluster()
        client().admin()
                .prepareUpdateSettings("test")
        );
import org.opensearch.indices.IndicesService;
                .getSettingsVersion();
        );
            ) // this one can't
        }
                .execute()
    }
            );
        public void onIndexModule(IndexModule indexModule) {
            assertAcked(
            }
            .getState()
                    .get()
                    .indices()
                if (s.equals("boom")) throw new IllegalArgumentException("this setting goes boom");
        public static final Setting<String> DUMMY_ACCOUNT_PW = Setting.affixKeySetting(
                .cluster()
         * null. In the update settings logic, we ensure this by providing an explicit default value if the setting is set to null.
            .prepareUpdateSettings("test")
        assertThat(getSettingsResponse.getSetting("test", "index.final"), nullValue());
    public void testEngineGCDeletesSetting() throws Exception {
        }
import org.opensearch.cluster.applicationtemplates.TemplateRepositoryMetadata;
                .prepareUpdateSettings("test")
            // user has no dependency
        );
                enableIndexBlock("test", blockSetting);
        return Arrays.asList(DummySettingPlugin.class, FinalSettingPlugin.class);
            .indices()
        );
            client().admin()
        String numberOfReplicas = client().admin()
        }
        IllegalArgumentException exception = expectThrows(
        );
        assertThat(health.isTimedOut(), equalTo(false));
                        .get()
            .prepareState()
        );
                        .indices()
            client().admin()
            client().prepareIndex("test").setId("1").setSource("f", 3).setVersionType(VersionType.EXTERNAL).setVersion(1),
            .metadata()
        );
                .indices()
        @Override
                    .setSettings(Settings.builder().put("index.refresh_interval", "500ms"))
import org.opensearch.index.IndexModule;
import org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader;
                .metadata()
            client().admin()
 * specific language governing permissions and limitations
     * respect to settings version when applying a settings change that does not change the number of replicas.
                .actionGet();
            );
                .getState()
        assertThat(getSettingsResponse.getSetting("test", "index.refresh_interval"), equalTo("-1"));
}
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("thread_pool.estimated_time_interval", 0).build();
            k -> Setting.simpleString(k, Setting.Property.IndexScope, Setting.Property.Dynamic),
                .prepareUpdateSettings("test")
                    .prepareUpdateSettings("test")
                    .indices()
    /**
                        .put("index.refresh_interval", -1) // this one can change
            assertEquals("missing required setting [index.acc.test.user] for setting [index.acc.test.pw]", e.getMessage());
            () -> internalCluster().getInstance(ClusterService.class).state()
                assertAcked(
 * this file be licensed under the Apache-2.0 license or a
            )
                .index("test")
                assertAcked(client().admin().indices().prepareUpdateSettings("test").setSettings(builder));
            .indices()
            assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());
            return Collections.singletonList(FINAL_SETTING);
                .prepareUpdateSettings("test")
                .indices()
                .prepareUpdateSettings()
                .setTransientSettings(Settings.builder().put("cluster.acc.test.pw", "asdf").put("cluster.acc.test.user", "asdf"))
                .getSettingsVersion();
            assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());
        public static final Setting<String> FINAL_SETTING = Setting.simpleString(
            "pw",
                .setSettings(Settings.builder().put("index.merge.policy", "tiered"))
    public void testNumberOfReplicasSettingsVersionUnchanged() {
            SettingsException.class,
    public void testDefaultNumberOfReplicasOnOpenIndices() {
            + "  },\n"
                .execute()
            "index.acc.",
                .get()
            .actionGet();
        );
                .actionGet()
                .getState()
            .actionGet();
    public void testUpdateDependentIndexSettings() {
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
            .prepareUpdateSettings("test")
            + "  \"_meta\": {\n"
            .actionGet();
 *    http://www.apache.org/licenses/LICENSE-2.0
                .cluster()
import static org.hamcrest.Matchers.containsString;
 * GitHub history for details.
                .indices()
                .execute()
            e = expectThrows(
            IndexService indexService = service.indexService(resolveIndex("test"));
                .prepareState()
                client().admin()
            );
                .get()
            .getState()
        assertSame(clusterService.state(), currentState);
        createIndex("test");
            client().admin()
                .setPersistentSettings(Settings.builder().put("cluster.acc.test.pw", "asdf").put("cluster.acc.test.user", "asdf"))
    }
                .cluster()
/*
 *
            "user",
    }
                assertBlocked(client().admin().indices().prepareUpdateSettings("test").setSettings(builder));
                    .cluster()
            client().admin()
            .get()
            client().admin()
 * Modifications Copyright OpenSearch Contributors. See
                .metadata()
                    .prepareUpdateSettings("test")
            IllegalArgumentException.class,
                assertEquals(indexService.getIndexSettings().getRefreshInterval().millis(), -1);
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        assertAcked(
            assertAcked(
        );
        createIndex("test");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        currentState = clusterService.state();
        assertThat(ex.getMessage(), containsString("final test setting [index.final], not updateable"));
                .setSettings(Settings.builder().put("index.dummy", "boom"))
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;
        );
                disableIndexBlock("test", blockSetting);
        assertThat(newSettingsVersion, equalTo(1 + settingsVersion));
        }
    public void testUpdateSettingsWithBlocks() {
import org.opensearch.test.OpenSearchIntegTestCase;
            }
import org.opensearch.index.VersionType;
            .actionGet();
            client().admin()
    /*
                .get()
        assertAcked(
            .actionGet();
     * The setting {@link IndexMetadata#SETTING_NUMBER_OF_REPLICAS} is special due to handling in
                .indices()
                .prepareUpdateSettings("test")
            .setSettings(Settings.builder().put("index.refresh_interval", -1)) // this one can change
    protected Collection<Class<? extends Plugin>> nodePlugins() {
package org.opensearch.indices.settings;
        assertThat(newSettingsVersion, equalTo(settingsVersion));
        ensureGreen("test");
                .setSettings(Settings.builder().put("index.analysis.char_filter.invalid_char.type", "invalid"))
    public static class DummySettingPlugin extends Plugin {
                .setTransientSettings(Settings.builder().put("cluster.acc.test.pw", "asdf"))
import java.util.Arrays;
        assertAcked(
            new SystemTemplate(
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        IllegalArgumentException validationException = expectThrows(
                Settings.builder()
    }
            .prepareState()
            + "    }\n"
        );
                .get()
    }
                .get()
                .indices()
        );
                .setPersistentSettings(Settings.builder().putNull("cluster.default_number_of_replicas"))
                () -> client().admin()
            k -> Setting.simpleString(k, Setting.Property.NodeScope, Setting.Property.Dynamic)
                    .get()
        assertNull(indexMetadata.getSettings().get("index.refresh_interval"));
                    .get()
     */
     */
            }
        internalCluster().ensureAtLeastNumDataNodes(2);
import org.opensearch.cluster.applicationtemplates.SystemTemplate;
            client().admin()
            () -> client().admin()
import org.opensearch.cluster.metadata.Context;
/*
            .prepareHealth()
            .prepareUpdateSettings("test")
        final long settingsVersion = client().admin()
 * Unless required by applicable law or agreed to in writing,
                .setTransientSettings(Settings.builder().put("cluster.acc.test.pw", "asdf"))
        assertEquals("2", numberOfReplicas);
        client().admin()
                .metadata()
        assertAcked(
                assertEquals(indexService.getIndexSettings().getGenerationThresholdSize().getBytes(), 4096);
            .indices()
                .execute()
        assertAcked(
                        .put("index.refresh_interval", -1) // this one can change
            .cluster()
        // Now verify via dedicated get settings api:
    }
        assertEquals(indexMetadata.getSettings().get("index.refresh_interval"), "-1");
        assertAcked(
        assertThat(indexMetadata.getSettings().get("index.fielddata.cache"), equalTo("none"));
                    .setPersistentSettings(Settings.builder().putNull("cluster.acc.test.user"))
            + "}\n";
        // update setting with null replica will use cluster setting of replica number
                    .indices()
    public void testResetDefaultWithWildcard() {
                );
import java.io.IOException;
            assertAcked(client().admin().indices().prepareCreate("test"));
                .cluster()
            .cluster()
    public void testInvalidUpdateOnClosedIndex() {
            validationException.getMessage()
            assertBusy(() -> assertThat(threadPool.relativeTimeInMillis(), greaterThan(startTime)));
            .getSetting("test", IndexMetadata.SETTING_NUMBER_OF_REPLICAS);
import java.util.Collections;
            try {
            assertAcked(
        assertAcked(
                .prepareUpdateSettings("test")
        );
            try {
            e = expectThrows(
            IndexService indexService = service.indexService(resolveIndex("test"));
        if (randomBoolean()) {
                        .setSettings(Settings.builder().put("index.blocks.read_only", false))
                .indices()
         */
        // delete should not be in cache
                .indices()
                .getState()
        getSettingsResponse = client().admin().indices().prepareGetSettings("test").get();
            client().admin()
                    .get()
            .indices()
        assertThat(getSettingsResponse.getSetting("test", "index.refresh_interval"), equalTo("1s"));
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(1, 8)))
        final long settingsVersion = client().admin()
        createIndex("test");
 * Licensed to Elasticsearch under one or more contributor
                assertEquals(indexService.getIndexSettings().getRefreshInterval().millis(), -1);
        assertNotSame(currentState, clusterService.state());
                .actionGet();
                    .setSettings(Settings.builder().put("index.refresh_interval", refreshInterval))
                    .actionGet()
            e = expectThrows(
    }
import static org.hamcrest.Matchers.equalTo;
                    client().admin()
            "index.final",
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            .setSettings(Settings.builder().put("index.refresh_interval", -1))
            }
            .get()
        // delete is still in cache this should fail
                .indices()
        final long newSettingsVersion = client().admin()
    }
                );
            final long newSettingsVersion = client().admin()
        );
                .prepareUpdateSettings()
                .execute()
            if (i == 1) {
            .index("test")
    private void runTestDefaultNumberOfReplicasTest(final boolean closeIndex) {
            if (indexService != null) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
            // now we are consistent
                .prepareUpdateSettings("test")
                .prepareUpdateSettings("test")
        assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(response.getIndexToSettings().get("test")), equalTo(1));
        @Override
        /*
            client().admin()
        loader.loadTemplate(
            () -> client().admin()
    }
            // if the read-only block is present, remove it
                .cluster()
            .prepareState()
            );
    /**
        SettingsException e = expectThrows(
    public void testSettingsVersionUnchanged() {
                .getSettingsVersion();
        assertNotSame(currentState, clusterService.state());
                    .prepareCreate("test")
                .getState()
            () -> client().admin()
import java.util.Collection;
        assertAcked(client().admin().indices().prepareClose("test").get());
        );
                .index("test")
                        .put("index.fielddata.cache", "none")
            () -> prepareCreate("test", Settings.builder().put("index.acc.test.pw", "asdf")).get()
            final long newSettingsVersion = client().admin()
            () -> client().admin()
import org.opensearch.index.engine.VersionConflictEngineException;
        }
import java.util.UUID;
                new TemplateRepositoryMetadata(UUID.randomUUID().toString(), 1L)
                .prepareState()
            assertAcked(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
                .prepareState()
                    .setSettings(Settings.builder().putNull("index.acc.test.user"))
        // Clean up cluster setting, then update setting with null replica should pick up default value of 1
        internalCluster().ensureAtLeastNumDataNodes(2);
        assertThat(getSettingsResponse.getSetting("test", "index.refresh_interval"), nullValue());
        );
        createIndex("test");
                .get()
                    .indices()
                .actionGet()
        assertThat(indexMetadata.getNumberOfReplicas(), equalTo(1));
                SettingsException.class,
                .prepareUpdateSettings("test")
                .getState()
            SettingsException.class,
        final int numberOfReplicas = Integer.valueOf(
            );
            .index("test")
                .indices()
                .setSettings(Settings.builder().put("index.acc.test.pw", "test"))
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
            assertAcked(
                .actionGet()
        assertThat(indexMetadata.getSettings().get("index.final"), nullValue());
import org.opensearch.cluster.service.ClusterService;
                    .prepareUpdateSettings("test")
            .indices()
                .getSettingsVersion();
                .actionGet();
        );
        String templateContent = "{\n"
import java.nio.ByteBuffer;
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
                ) // this one can't
            .actionGet();
            .setTimeout("30s")
                .contains("Cannot apply context template as user provide settings have overlap with the included context template")
            .setWaitForGreenStatus()
            Setting.Property.Final
            .actionGet();
                assertEquals(indexService.getIndexSettings().getFlushThresholdSize().getBytes(), 1024);
        public List<Setting<?>> getSettings() {
        assertSame(clusterService.state(), currentState);
        createIndex("test");
            IllegalArgumentException.class,
                .metadata()
        Settings.Builder builder = Settings.builder().put("index.refresh_interval", -1);
            .setSettings(Settings.builder().putNull("index.ref*"))
        createIndex("test");
    @Override
            + "  \"version\": 1\n"
                .get();
            final long newSettingsVersion = client().admin()
        createIndex("test", new Context("testcontext"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                    .indices()
 * under the License.
                .actionGet()
                SettingsException.class,
                .prepareUpdateSettings()
            .cluster()
        assertThat(indexMetadata.getSettings().get("index.final"), nullValue());
 * KIND, either express or implied.  See the License for the
                .metadata()
            final boolean block = randomBoolean();
                .setPersistentSettings(Settings.builder().put("cluster.default_number_of_replicas", defaultNumberOfReplica))
                .setSettings(Settings.builder().putNull(SETTING_BLOCKS_READ).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
            () -> client().admin()
        expectThrows(
        e = expectThrows(
        createIndex("test");
                .indices()
            .get()
            client().admin()
            .indices()
                .execute()
                .cluster()
    }
import org.opensearch.common.unit.TimeValue;
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
                .indices()
        assertTrue(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.exists(response.getIndexToSettings().get("test")));
                .getState()
            .cluster()
        } else {
        // Now verify via dedicated get settings api:
            .setSettings(
                        .prepareUpdateSettings("test")
            .execute()
                    Settings.builder()
        ClusterState currentState = clusterService.state();
                .prepareUpdateSettings()
            .prepareUpdateSettings("test")
 * license agreements. See the NOTICE file distributed with
                client().admin()
            .indices()
        // Now verify via dedicated get settings api:
            + "      \"index.merge.policy\": \"log_byte_size\"\n"
            .metadata()
    }
            return Arrays.asList(DUMMY_SETTING, DUMMY_ACCOUNT_PW, DUMMY_ACCOUNT_USER, DUMMY_ACCOUNT_PW_CLUSTER, DUMMY_ACCOUNT_USER_CLUSTER);
import java.util.List;
            .setWaitForEvents(Priority.LANGUID)
            + "    \"_type\": \"@abc_template\",\n"
            () -> client().admin()
 */
        }
            )
            indexModule.addSettingsUpdateConsumer(DUMMY_SETTING, (s) -> {}, (s) -> {
        );
                    .execute()
                .prepareUpdateSettings("test")
import org.opensearch.plugins.Plugin;
                .indices()
        }
                    Settings.builder()
        );
                .setPersistentSettings(Settings.builder().put("cluster.acc.test.pw", "asdf"))
            final long settingsVersion = client().admin()
        assertNull(indexMetadata.getSettings().get("index.refresh_interval"));
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        {
        String defaultNumberOfReplica = "3";
        {
                    Settings.builder()
                assertEquals(indexService.getIndexSettings().getRefreshInterval().millis(), 1000);
            assertEquals("missing required setting [index.acc.test.user] for setting [index.acc.test.pw]", e.getMessage());
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
import org.opensearch.cluster.ClusterState;
        assertThat(indexMetadata.getSettings().get("index.refresh_interval"), equalTo("1s"));
                .metadata()
                .setSettings(Settings.builder().put("index.refresh_interval", "60s"))
                .prepareUpdateSettings()
        );
            assertAcked(
            // now put the same block again
            if (block) {
                .prepareUpdateSettings("test")
    }
        runTestDefaultNumberOfReplicasTest(true);
        assertNotEquals(indexMetadata.getSettings().get("index.dummy"), "invalid dynamic value");
            }
                .setPersistentSettings(Settings.builder().put("cluster.acc.test.user", "asdf"))
    public static class FinalSettingPlugin extends Plugin {
                .prepareCreate("test")
                .getState()
                .cluster()
        assertNotSame(currentState, clusterService.state());
            "pw",
                .indices()
            long startTime = threadPool.relativeTimeInMillis();
                    .prepareUpdateSettings("test")
    public void testNullReplicaUpdate() {
                client().admin()
import java.nio.charset.StandardCharsets;
        final int numberOfReplicas = Integer.valueOf(
            } finally {
                    client().admin()
                .cluster()
                        .put("index.refresh_interval", -1) // this one can change
        assertSame(currentState, clusterService.state());
                    .prepareUpdateSettings("test")
                .prepareGetSettings("test")
            .execute()
        final long newSettingsVersion = client().admin()
                .setSettings(
            k -> Setting.simpleString(k, Setting.Property.NodeScope, Setting.Property.Dynamic),
            // now we are consistent
            + "    \"_version\": 1\n"
                    .prepareUpdateSettings()
                .get()
            .getSettingsVersion();
    }
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());
                .setTransientSettings(Settings.builder().putNull("cluster.acc.test.pw").putNull("cluster.acc.test.user"))
                .setSettings(Settings.builder().putNull(IndexMetadata.SETTING_NUMBER_OF_REPLICAS))
        currentState = clusterService.state();
        // we removed the setting but it should still have an explicit value since index metadata requires this
            final long settingsVersion = client().admin()
 * ownership. Elasticsearch licenses this file to you under
        assertAcked(
                .setSettings(Settings.builder().put("index.acc.test.user", "asdf"))
            client().admin()
        e = expectThrows(
                    .actionGet()
            client().admin().indices().prepareGetSettings("test").get().getSetting("test", "index.number_of_replicas")
            IndexService indexService = service.indexService(resolveIndex("test"));
            .getSettingsVersion();
        assertAcked(
                .get()
                .setSettings(Settings.builder().putNull(IndexMetadata.SETTING_NUMBER_OF_REPLICAS))
            );
            assertAcked(
                enableIndexBlock("test", blockSetting);
                    .get()
            final long settingsVersion = client().admin()
                .index("test")
            .prepareState()
            client().admin()
                .getSettingsVersion();
                client().admin()
        );
                .actionGet()
                .getSettingsVersion();
            VersionConflictEngineException.class
                    .setSettings(Settings.builder().put("index.blocks.read_only", block == false))
                SettingsException.class,
                    .setSettings(Settings.builder().put("index.blocks.read_only", block))
                .execute()
     * {@link IndexMetadata.Builder#numberOfReplicas(int)}. Therefore we have a dedicated test that this setting is handled properly with
                .get()
        for (ThreadPool threadPool : internalCluster().getInstances(ThreadPool.class)) {
            .metadata()
        createIndex("test");
                .indices()
        createIndex("test");
            }
                assertEquals(indexService.getIndexSettings().getFlushThresholdSize().getBytes(), 1024);
        createIndex("test");
import static org.hamcrest.Matchers.nullValue;
                    .put("index.refresh_interval", "1s") // this one can change
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;
                .indices()
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        assertAcked(client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.gc_deletes", 0)));
            () -> DUMMY_ACCOUNT_USER_CLUSTER
                .indices()
                .setSettings(Settings.builder().putNull(IndexMetadata.SETTING_NUMBER_OF_REPLICAS))
        {
            final long newSettingsVersion = client().admin()
        assertThat(getSettingsResponse.getSetting("test", "index.final"), nullValue());
        assertAcked(
        }
                .setPersistentSettings(Settings.builder().putNull("cluster.acc.test.pw").putNull("cluster.acc.test.user"))
import org.opensearch.core.common.bytes.BytesReference;
        client().admin().indices().prepareClose("test").execute().actionGet();
 * not use this file except in compliance with the License.
            }
        if (closeIndex) {
        client().admin()
        assertEquals(exception.getMessage(), "Unknown char_filter type [invalid] for [invalid_char]");
                ) // this one really can't
            .getSettingsVersion();
                    .setSettings(Settings.builder().put("index.acc.test.pw", "asdf"))
    }
                    .get()
                ) // this one can't
                .indices()
import org.opensearch.common.settings.Setting;
                .setSettings(Settings.builder().put("index.number_of_replicas", 1 + numberOfReplicas))
                    .get()
            .prepareGetSettings("test")
                        .indices()
        );
        );
            () -> client().admin()
 * software distributed under the License is distributed on an
                    .indices()
 */
                .prepareUpdateSettings()
            );
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        ensureGreen("test");
            k -> Setting.simpleString(k, Setting.Property.IndexScope, Setting.Property.Dynamic)
            .execute()
            IllegalArgumentException.class,
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "2"))
        assertRequestBuilderThrows(
        // now close the index, change the non dynamic setting, and see that it applies
    }
