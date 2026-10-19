            .setTimeout("30s")
        }
        e = expectThrows(
            }
            if (indexService != null) {
            .actionGet();  
            .get()
                .get()
        // delete is still in cache this should fail
                assertEquals(indexService.getIndexSettings().getFlushThresholdSize().getBytes(), 1024);  
            + "    }\n"
    @Override  
 */
     * The setting {@link IndexMetadata#SETTING_NUMBER_OF_REPLICAS} is special due to handling in  
            internalCluster().clusterManagerClient(),  
            if (i == 1) {
        assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());
import org.opensearch.cluster.metadata.IndexMetadata;  
            .prepareHealth()
            .prepareState()
        Settings.Builder builder = Settings.builder().put("index.refresh_interval", -1);  
                .cluster()
     */
        getSettingsResponse = client().admin().indices().prepareGetSettings("test").get();
                .contains("Cannot apply context template as user provide settings have overlap with the included context template")  
        );
        assertEquals("1", numberOfReplicas);  
        }
        }  
                .metadata()
        }
                .setSettings(
        }
                    .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, randomIntBetween(1, 8)))
            final long newSettingsVersion = client().admin()  
        }
            client().admin()
                        .put("index.final", "no")
        }  
        client().admin()
                .get()
                .prepareState()
        assertThat(getSettingsResponse.getSetting("test", "index.refresh_interval"), equalTo("1s"));
                    .indices()
                .setTransientSettings(Settings.builder().put("cluster.acc.test.pw", "asdf").put("cluster.acc.test.user", "asdf"))
                        .get()
                    .indices()  
            .indices()
            () -> client().admin()
                .execute()  
                .setPersistentSettings(Settings.builder().putNull("cluster.acc.test.pw").putNull("cluster.acc.test.user"))
import java.nio.charset.StandardCharsets;
                .setPersistentSettings(Settings.builder().putNull("cluster.default_number_of_replicas"))
                .get();  
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        assertSame(clusterService.state(), currentState);
                .prepareState()
        // Wait for the index to turn green before attempting to close it
            long startTime = threadPool.relativeTimeInMillis();  
                        .indices()
        );
     * respect to settings version when applying a settings change that does not change the number of replicas.
                .indices()  
            client().admin().indices().prepareGetSettings("test").get().getSetting("test", "index.number_of_replicas")  
                .prepareUpdateSettings()  
        );
            + "  },\n"
/*
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
            .cluster()
            final boolean block = randomBoolean();
            () -> client().admin()
            .getState()
                .setTransientSettings(Settings.builder().putNull("cluster.acc.test.pw").putNull("cluster.acc.test.user"))
                .setPersistentSettings(Settings.builder().put("cluster.acc.test.pw", "asdf"))
            IllegalArgumentException.class,
        {
            validationException.getMessage()
            try {
            client().admin()
                    .prepareUpdateSettings("test")  
            .getSetting("test", IndexMetadata.SETTING_NUMBER_OF_REPLICAS);
    public void testNumberOfReplicasSettingsVersionUnchanged() {  
 * The OpenSearch Contributors require contributions made to  
        client().prepareDelete("test", "1").setVersionType(VersionType.EXTERNAL).setVersion(4).get();
     * Needed by {@link UpdateSettingsIT#testEngineGCDeletesSetting()}
                ) // this one can't
            .execute()  
    public void testUpdateSettingsWithBlocks() {
        }  
        assertAcked(  
    }  
 *    http://www.apache.org/licenses/LICENSE-2.0
                .execute()
                .setTransientSettings(Settings.builder().put("cluster.acc.test.pw", "asdf"))
            // if the read-only block is present, remove it  
            // now put the same block again
            .cluster()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertRequestBuilderThrows;
 * compatible open source license.
            .actionGet();
            .metadata()  
                    .setSettings(Settings.builder().putNull("index.acc.test.user"))
        );
        assertThat(getSettingsResponse.getSetting("test", "index.fielddata.cache"), nullValue());
        client().admin()
     */
            .getSettingsVersion();
            SettingsException.class,
            () -> client().admin()  
                .actionGet()  
                    .prepareCreate("test")
                .indices()  
            } finally {
            assertAcked(client().admin().indices().prepareCreate("test"));
        numberOfReplicas = client().admin()
    }  
        assertAcked(client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put("index.gc_deletes", 0)));  
            IllegalArgumentException.class,
        );
        assertThat(indexMetadata.getSettings().get("index.refresh_interval"), equalTo("1s"));  
            .getState()
            final long settingsVersion = client().admin()  
public class UpdateSettingsIT extends OpenSearchIntegTestCase {
            );
            )  
        assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());
        createIndex("test");
        assertAcked(  
                .prepareState()
    }
        /*  
            IndexService indexService = service.indexService(resolveIndex("test"));
import org.opensearch.common.Priority;
 * license agreements. See the NOTICE file distributed with
        );
import org.opensearch.test.OpenSearchIntegTestCase;
 * this work for additional information regarding copyright
                        .put("index.refresh_interval", -1) // this one can change
 * GitHub history for details.
    public void testNoopUpdate() {  
            client().admin()
            client().admin()
                assertEquals(indexService.getIndexSettings().getGenerationThresholdSize().getBytes(), 4096);
            .get()  
            .indices()  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_READ_ONLY;
        internalCluster().ensureAtLeastNumDataNodes(2);
            .index("test")
        assertNotSame(currentState, clusterService.state());
                .get()
                .getSettingsVersion();
     */
        if (closeIndex) {
                ) // this one can't  
                .prepareUpdateSettings()
        final long newSettingsVersion = client().admin()
                .getState()  
        for (String blockSetting : Arrays.asList(SETTING_READ_ONLY, SETTING_BLOCKS_METADATA)) {  
            .execute()
            ) // this one can't
                .get()
            IndexService indexService = service.indexService(resolveIndex("test"));
        final ClusterService clusterService = internalCluster().getClusterManagerNodeInstance(ClusterService.class);
        for (IndicesService service : internalCluster().getInstances(IndicesService.class)) {  
            () -> DUMMY_ACCOUNT_USER_CLUSTER
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                .prepareState()
            .prepareUpdateSettings("test")
            + "      \"index.merge.policy\": \"log_byte_size\"\n"
        assertNull(indexMetadata.getSettings().get("index.refresh_interval"));
    public void testResetDefaultWithWildcard() {
    /**
        );  
                .getSettingsVersion();  
            .get()  
        e = expectThrows(
                client().admin()
        }
        assertEquals(indexMetadata.getSettings().get("index.refresh_interval"), "-1");
            .metadata()  
        );  
            assertAcked(client().admin().indices().prepareClose("test"));  
    public static class DummySettingPlugin extends Plugin {  
            .execute()
            () -> client().admin()
                .index("test")
        assertAcked(client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().putNull(SETTING_BLOCKS_READ)));  
                .prepareUpdateSettings("test")  
 * software distributed under the License is distributed on an
            "cluster.acc.",
        final GetSettingsResponse response = client().admin().indices().prepareGetSettings("test").get();
            client().admin()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .getSettingsVersion();
            final long settingsVersion = client().admin()
                .setSettings(Settings.builder().put(SETTING_BLOCKS_READ, true).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
                    .get()  
                .prepareUpdateSettings()
                SystemTemplateMetadata.fromComponentTemplateInfo("testcontext", 1L),  
        assertAcked(  
        assertAcked(
    }
            // now we are consistent
            .prepareGetSettings("test")  
        // Clean up cluster setting, then update setting with null replica should pick up default value of 1
        assertThat(getSettingsResponse.getSetting("test", "index.refresh_interval"), nullValue());  
        SettingsException ex = expectThrows(  
                client().admin()  
            client().admin()  
                .setSettings(Settings.builder().put("index.analysis.char_filter.invalid_char.type", "invalid"))
                .get()
        numberOfReplicas = client().admin()
        );
        public List<Setting<?>> getSettings() {  
    public void testUpdateDependentClusterSettings() {
            .getSetting("test", IndexMetadata.SETTING_NUMBER_OF_REPLICAS);
        );
 * KIND, either express or implied.  See the License for the
                .setPersistentSettings(Settings.builder().put("cluster.default_number_of_replicas", defaultNumberOfReplica))  
 * ownership. Elasticsearch licenses this file to you under  
        createIndex("test");
                .get()
        assertEquals("2", numberOfReplicas);
            client().admin()  
        );
            .prepareState()  
        {
        public List<Setting<?>> getSettings() {
        expectThrows(
            client().admin()
        client().prepareIndex("test").setId("1").setSource("f", 2).setVersionType(VersionType.EXTERNAL).setVersion(1);
            () -> DUMMY_ACCOUNT_USER
                ) // this one really can't  
    }
        assertThat(getSettingsResponse.getSetting("test", "index.final"), nullValue());
                .get()
        assertEquals("missing required setting [index.acc.test.user] for setting [index.acc.test.pw]", e.getMessage());
        }  
            .setTimeout(TimeValue.MAX_VALUE)  
import org.opensearch.cluster.applicationtemplates.ClusterStateSystemTemplateLoader;
        assertAcked(
            .setSettings(Settings.builder().putNull("index.refresh_interval"))
        getSettingsResponse = client().admin().indices().prepareGetSettings("test").get();
         * null. In the update settings logic, we ensure this by providing an explicit default value if the setting is set to null.
                    .put("index.refresh_interval", "1s") // this one can change
                    .setSettings(Settings.builder().put("index.blocks.read_only", block))
 * Modifications Copyright OpenSearch Contributors. See
        @Override  
                .cluster()
        );
         */  
    }
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0))
 *
            .indices()  
}
                .execute()
        createIndex("test");
        public static final Setting<String> DUMMY_ACCOUNT_PW_CLUSTER = Setting.affixKeySetting(  
            }
                .setSettings(Settings.builder().put("index.number_of_replicas", numberOfReplicas))  
            client().admin()
                        .setSettings(Settings.builder().put("index.blocks.read_only", false))  
                .prepareUpdateSettings("test")  
 */  
        createIndex("test");  
            assertAcked(
                .prepareGetSettings("test")
                assertEquals(indexService.getIndexSettings().getFlushThresholdSize().getBytes(), 1024);
        }
        createIndex("test");
        runTestDefaultNumberOfReplicasTest(false);
            SettingsException.class,  
            });
        );  
            assertEquals("missing required setting [index.acc.test.user] for setting [index.acc.test.pw]", e.getMessage());
                    .put("index.translog.generation_threshold_size", "4096b")
                .indices()
                if (s.equals("boom")) throw new IllegalArgumentException("this setting goes boom");
            .metadata()
                .execute()
                .cluster()  
                .actionGet();  
 * You may obtain a copy of the License at  
        expectThrows(  
            );  
            .prepareUpdateSettings("test")
            .cluster()
        createIndex("test");  
            final long newSettingsVersion = client().admin()
            client().prepareIndex("test").setId("1").setSource("f", 3).setVersionType(VersionType.EXTERNAL).setVersion(1),  
            .prepareUpdateSettings("test")  
        assertAcked(  
                    .get()  
                .getSettingsVersion();  
    }
                    .prepareUpdateSettings("test")  
        assertThat(indexMetadata.getSettings().get("index.fielddata.cache"), nullValue());
        String templateContent = "{\n"
        // Now verify via dedicated get settings api:
                        .put("index.refresh_interval", -1) // this one can change
import static org.hamcrest.Matchers.nullValue;  
                .execute()
        ensureGreen("test");  
     */  
                    .indices()
        }
            );
 * not use this file except in compliance with the License.
        // Now verify via dedicated get settings api:  
        );  
import java.util.Collections;
                .prepareUpdateSettings("test")
    }  
                .cluster()  
        IllegalArgumentException exception = expectThrows(
                .get()  
            client().admin()
                        .prepareUpdateSettings("test")
        for (IndicesService service : internalCluster().getInstances(IndicesService.class)) {  
            "index.acc.",
        assertAcked(
    }  
                .prepareUpdateSettings()
            .execute()
                    .indices()  
            final boolean block = randomBoolean();  
        // cluster setting  
        final int numberOfReplicas = Integer.valueOf(
        // Closing an index is blocked
        public static final Setting.AffixSetting<String> DUMMY_ACCOUNT_USER = Setting.affixKeySetting(
        createIndex("test");  
            client().admin()
        );
    public void testSettingsVersionUnchanged() {
                    .get()  
                .actionGet();
    /**  
import org.opensearch.common.settings.Settings;
                    client().admin()  
                    Settings.builder()  
            client().admin()  
        ensureGreen("test");
                .actionGet()
import org.opensearch.cluster.applicationtemplates.SystemTemplate;
            .prepareUpdateSettings("test")  
            .setSettings(  
            final long newSettingsVersion = client().admin()
                .setSettings(Settings.builder().putNull(IndexMetadata.SETTING_NUMBER_OF_REPLICAS))
                .cluster()
                .prepareUpdateSettings("test")  
        client().admin()  
        createIndex("test", new Context("testcontext"));
import org.opensearch.core.common.bytes.BytesReference;
            client().admin()
                .setSettings(Settings.builder().put("index.merge.policy", "tiered"))  
        );  
        }
        assertThat(indexMetadata.getSettings().get("index.fielddata.cache"), equalTo("none"));
        assertAcked(
            indexModule.addSettingsUpdateConsumer(DUMMY_SETTING, (s) -> {}, (s) -> {  
            + "  \"_meta\": {\n"
/*  
                    .setSettings(Settings.builder().put("index.blocks.read_only", block))
                .getState()
            final long settingsVersion = client().admin()
                .get();
                .prepareUpdateSettings("test")
        ClusterState currentState = clusterService.state();
                .indices()
 * SPDX-License-Identifier: Apache-2.0
                    .prepareUpdateSettings()
        }  
            );
        assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());  
        assertThat(newSettingsVersion, equalTo(settingsVersion));
        assertNotSame(currentState, clusterService.state());
            );
                .metadata()
            assertThat(newSettingsVersion, equalTo(settingsVersion));
                    .setSettings(Settings.builder().put("index.refresh_interval", refreshInterval))
import org.opensearch.cluster.ClusterState;  
        assertAcked(  
            client().admin()  
                client().admin()
            SettingsException.class,
                .getState()  
            .indices()
        public static final Setting<String> DUMMY_SETTING = Setting.simpleString(
        IllegalArgumentException validationException = expectThrows(
                .get()  
                .setSettings(
            .setWaitForEvents(Priority.LANGUID)  
        // create index with number of replicas will ignore default value  
        client().admin()
        client().admin().indices().prepareClose("test").execute().actionGet();  
                    .get()
        return Settings.builder().put(super.nodeSettings(nodeOrdinal)).put("thread_pool.estimated_time_interval", 0).build();
import java.io.IOException;
import org.opensearch.index.VersionType;
            final long newSettingsVersion = client().admin()
        );
        assertEquals(defaultNumberOfReplica, numberOfReplicas);  
            .metadata()
    @Override
                .index("test")  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_READ;  
        assertTrue(
                    .indices()  
        assertAcked(
                assertEquals(indexService.getIndexSettings().getRefreshInterval().millis(), -1);
                .prepareUpdateSettings("test")
                .prepareState()
                .indices()
                .actionGet()  
                .setSettings(  
        client().prepareDelete("test", "1").setVersionType(VersionType.EXTERNAL).setVersion(2).get();  
                .prepareUpdateSettings("test")
                assertAcked(client().admin().indices().prepareUpdateSettings("test").setSettings(builder));
            .setSettings(
            IllegalArgumentException.class,
import org.opensearch.index.IndexService;  
            .getSetting("test", IndexMetadata.SETTING_NUMBER_OF_REPLICAS);  
                .prepareState()
            );
        );
                .cluster()  
            "user",  
            "index.final",
            + "  },\n"  
                assertEquals(indexService.getIndexSettings().getRefreshInterval().millis(), 1000);  
        {
            .getState()
    }  
                .prepareUpdateSettings()  
            client().admin()
        );
        );
            }  
            e = expectThrows(
            // now try to remove it and make sure it fails
                .prepareUpdateSettings("test")
    private void runTestDefaultNumberOfReplicasTest(final boolean closeIndex) {
            .setWaitForEvents(Priority.LANGUID)
            .index("test")
        assertThat(ex.getMessage(), containsString("final test setting [index.final], not updateable"));
 * the Apache License, Version 2.0 (the "License"); you may
                    .put("index.fielddata.cache", "none")  
                    .prepareUpdateSettings("test")
                client().admin().indices().prepareClose("test").get();
/*  
                .indices()  
                enableIndexBlock("test", blockSetting);
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
        @Override
            assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());  
        );
            e = expectThrows(
    public void testSettingsVersion() {
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
    }
                .getSettingsVersion();
    public void testDefaultNumberOfReplicasOnOpenIndices() {  
                    .prepareUpdateSettings("test")
                .get()
        assertEquals(exception.getCause().getMessage(), "this setting goes boom");
            .actionGet();  
        );
                new TemplateRepositoryMetadata(UUID.randomUUID().toString(), 1L)
import org.opensearch.common.unit.TimeValue;  
        assertThat(indexMetadata.getSettings().get("index.refresh_interval"), equalTo("-1"));  
            .execute()
            .prepareUpdateSettings("test")  
                    .put("index.refresh_interval", -1)  
                .prepareUpdateSettings("test")
                .indices()
            .actionGet();  
            SettingsException.class,
            assertThat(newSettingsVersion, equalTo(1 + settingsVersion));
                .index("test")
                .metadata()
        ClusterStateSystemTemplateLoader loader = new ClusterStateSystemTemplateLoader(
            e = expectThrows(
            "pw",
                .getSetting("test", "index.refresh_interval");  
                .getState()  
                .indices()
    public static class FinalSettingPlugin extends Plugin {
        );
                    .setTransientSettings(Settings.builder().putNull("cluster.acc.test.user"))  
            .actionGet();  
                .setSettings(Settings.builder().putNull(IndexMetadata.SETTING_NUMBER_OF_REPLICAS))
import org.opensearch.cluster.service.ClusterService;
        for (String blockSetting : Arrays.asList(SETTING_BLOCKS_READ, SETTING_BLOCKS_WRITE)) {
                .setSettings(Settings.builder().putNull(SETTING_BLOCKS_READ).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
                .actionGet()
        assertAcked(
        );  
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
        // we removed the setting but it should still have an explicit value since index metadata requires this
                        .indices()
                () -> client().admin()  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_WRITE;
        );
            .indices()
            .indices()  
                .indices()
import java.util.Arrays;
    /**
                .cluster()  
            client().admin()
        // Now verify via dedicated get settings api:
                    .indices()
 * specific language governing permissions and limitations
        assertRequestBuilderThrows(
                .cluster()  
        for (IndicesService service : internalCluster().getInstances(IndicesService.class)) {
            assertAcked(
            .get()
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
                .setSettings(Settings.builder().put("index.refresh_interval", "60s"))
            .actionGet();
            k -> Setting.simpleString(k, Setting.Property.NodeScope, Setting.Property.Dynamic),  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
            .get()
            if (block == false) {
        public static final Setting<String> FINAL_SETTING = Setting.simpleString(  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            .setWaitForGreenStatus()  
                    .get()
                );
                assertAcked(
            .get()
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
            e = expectThrows(
                SettingsException.class,  
        assertEquals(exception.getMessage(), "Unknown char_filter type [invalid] for [invalid_char]");
            .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))
                .setSettings(Settings.builder().put("index.dummy", "boom"))  
            if (indexService != null) {  
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");  
            .prepareUpdateSettings("test")
        if (randomBoolean()) {
                .getState()
                .prepareCreate("test")  
                .prepareState()
        @Override
            );
        assertEquals(indexMetadata.getSettings().get("index.refresh_interval"), "-1");  
                .metadata()
                .prepareUpdateSettings()  
            assertThat(newSettingsVersion, equalTo(1 + settingsVersion));
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings("test").get();
                .get()  
import org.opensearch.cluster.applicationtemplates.TemplateRepositoryMetadata;
                .indices()  
        );  
        return Arrays.asList(DummySettingPlugin.class, FinalSettingPlugin.class);  
                assertEquals(indexService.getIndexSettings().getRefreshInterval().millis(), 1000);  
                    .setPersistentSettings(Settings.builder().putNull("cluster.acc.test.user"))  
        assertSame(clusterService.state(), currentState);  
                () -> client().admin()
            "index.dummy",
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, "2"))
            client().admin()
                .prepareUpdateSettings("test")
        );
    }
    public void testDynamicUpdateWithContextSettingOverlap() throws IOException {  
                        .put("index.refresh_interval", -1) // this one can change
        }  
                // now do it on a closed index  
            assertAcked(
            assertAcked(  
                Settings.builder()
                .prepareCreate("test")
            .setWaitForGreenStatus()
                        .prepareUpdateSettings("test")
                SettingsException.class,
                    .actionGet()
            client().admin().indices().prepareUpdateSettings("test").setSettings(Settings.builder().put(SETTING_BLOCKS_READ, true))
                .indices()
        assertAcked(client().admin().indices().prepareClose("test").get());
            assertAcked(
                .prepareUpdateSettings("test")  
import org.opensearch.common.settings.Setting;  
                    .setSettings(Settings.builder().put("index.refresh_interval", "500ms"))  
        );
                .prepareUpdateSettings("test")
                .cluster()  
        public void onIndexModule(IndexModule indexModule) {
package org.opensearch.indices.settings;
        assertNull(indexMetadata.getSettings().get("index.refresh_interval"));
        assertThat(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.get(response.getIndexToSettings().get("test")), equalTo(1));  
                assertBlocked(client().admin().indices().prepareUpdateSettings("test").setSettings(builder));  
    public void testEngineGCDeletesSetting() throws Exception {  
            assertEquals("missing required setting [index.acc.test.user] for setting [index.acc.test.pw]", e.getMessage());
        );
            .getSettingsVersion();
        currentState = clusterService.state();
                .metadata()
        for (ThreadPool threadPool : internalCluster().getInstances(ThreadPool.class)) {
                client().admin()
        client().prepareIndex("test").setId("1").setSource("f", 1).setVersionType(VersionType.EXTERNAL).setVersion(1).get();
import org.opensearch.cluster.metadata.Context;
            client().admin().indices().prepareGetSettings("test").get().getSetting("test", "index.number_of_replicas")
                .metadata()
                .execute()
        for (int i = 0; i < 2; i++) {
            }  
        loader.loadTemplate(  
    public void testNumberOfReplicasSettingsVersion() {
                assertEquals(indexService.getIndexSettings().getGenerationThresholdSize().getBytes(), 4096);
import org.opensearch.indices.IndicesService;  
        }
                .setPersistentSettings(Settings.builder().put("cluster.acc.test.user", "asdf"))
 * Licensed to Elasticsearch under one or more contributor  
                    .execute()
        runTestDefaultNumberOfReplicasTest(true);
                .getSettingsVersion();  
                .getSettingsVersion();
            .index("test")  
            IndexService indexService = service.indexService(resolveIndex("test"));  
        IllegalArgumentException exception = expectThrows(  
        assertNotEquals(indexMetadata.getSettings().get("index.dummy"), "invalid dynamic value");  
                .get()  
            () -> client().admin()
    public void testInvalidDynamicUpdate() {
            assertThat(newSettingsVersion, equalTo(settingsVersion));
            .getState()
import static org.hamcrest.Matchers.equalTo;
                .setTransientSettings(Settings.builder().put("cluster.acc.test.pw", "asdf"))  
                .metadata()
        assertNotSame(currentState, clusterService.state());
                    .prepareUpdateSettings("test")
    }
            IllegalArgumentException.class,
            k -> Setting.simpleString(k, Setting.Property.NodeScope, Setting.Property.Dynamic)
            IllegalArgumentException.class,
        assertThat(health.isTimedOut(), equalTo(false));
            final String refreshInterval = client().admin()
                .setSettings(Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1))  
                .prepareUpdateSettings()
            if (indexService != null) {
        assertSame(currentState, clusterService.state());
 * Unless required by applicable law or agreed to in writing,
            return Collections.singletonList(FINAL_SETTING);
            Setting.Property.Dynamic
            .execute()
                    .cluster()
        } else {  
            }
            .indices()
            + "    \"_type\": \"@abc_template\",\n"
                .getSettingsVersion();  
        }  
                .indices()  
                .execute()
            SettingsException.class,
            .setSettings(Settings.builder().putNull("index.ref*"))
                .indices()  
        }
                    .prepareUpdateSettings("test")
        public static final Setting<String> DUMMY_ACCOUNT_PW = Setting.affixKeySetting(  
            assertAcked(
            // now we are consistent
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
                .cluster()
                .actionGet();
        assertAcked(
                .cluster()  
                    .execute()
                );
                .execute()
            client().admin()
            Setting.Property.IndexScope,  
                        .setSettings(Settings.builder().put("index.blocks.read_only", false))  
                BytesReference.fromByteBuffer(ByteBuffer.wrap(templateContent.getBytes(StandardCharsets.UTF_8))),
    public void testInvalidUpdateOnClosedIndex() {  
     * {@link IndexMetadata.Builder#numberOfReplicas(int)}. Therefore we have a dedicated test that this setting is handled properly with  
            k -> Setting.simpleString(k, Setting.Property.IndexScope, Setting.Property.Dynamic),  
    }
                .actionGet()
                .indices()
    public void testUpdateDependentIndexSettings() {
                .prepareUpdateSettings("test")
        assertThat(getSettingsResponse.getSetting("test", "index.refresh_interval"), equalTo("-1"));  
        );  
            "index.acc.",
            "user",  
        );
            if (indexService != null) {
 * under the License.  
                () -> client().admin()  
                .prepareUpdateSettings("test")
                .indices()
import org.opensearch.cluster.applicationtemplates.SystemTemplateMetadata;  
                .getState()  
                    Settings.builder()
            Setting.Property.Final  
        client().admin()  
        );  
    }
        client().admin()
import java.nio.ByteBuffer;  
import org.opensearch.index.IndexModule;
            k -> Setting.simpleString(k, Setting.Property.IndexScope, Setting.Property.Dynamic)
                .indices()
                .prepareUpdateSettings("test")  
        // now close the index, change the non dynamic setting, and see that it applies
     * The setting {@link IndexMetadata#SETTING_NUMBER_OF_REPLICAS} is special due to handling in
                .prepareState()
            .index("test")  
                .indices()  
                enableIndexBlock("test", blockSetting);
                    .prepareUpdateSettings()
    }  
                .get()  
            () -> client().admin()  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
                assertEquals(indexService.getIndexSettings().getRefreshInterval().millis(), -1);
            + "}\n";  
            .actionGet();
            )
                .getSettingsVersion();  
            try {  
        {
                .index("test")
                .setSettings(Settings.builder().putNull(IndexMetadata.SETTING_NUMBER_OF_REPLICAS))
                disableIndexBlock("test", blockSetting);
        public static final Setting.AffixSetting<String> DUMMY_ACCOUNT_USER_CLUSTER = Setting.affixKeySetting(
            .cluster()  
                    .get()
                .getState()  
import java.util.UUID;  
    protected Settings nodeSettings(int nodeOrdinal) {
        public void onIndexModule(IndexModule indexModule) {}
            Setting.Property.IndexScope,
    }
        ClusterHealthResponse health = client().admin()
        if (randomBoolean()) {  
            .get();
            .execute()
import java.util.List;
 */  
            "cluster.acc.",
import static org.hamcrest.Matchers.containsString;  
                .index("test")
                .prepareUpdateSettings("test")
            + "  \"version\": 1\n"
        createIndex("test");
        assertThat(indexMetadata.getSettings().get("index.refresh_interval"), nullValue());  
                client().admin()
        );  
        currentState = clusterService.state();
            + "  \"template\": {\n"
        final long newSettingsVersion = client().admin()  
                    .prepareUpdateSettings("test")
                .execute()
        String defaultNumberOfReplica = "3";
            + "    \"_version\": 1\n"  
                    .prepareUpdateSettings("test")
    }  
            .prepareUpdateSettings("test")  
        assertThat(indexMetadata.getNumberOfReplicas(), equalTo(1));
                .indices()  
            client().admin()
                () -> client().admin()  
     * Test that we are able to set the setting index.number_of_replicas to the default.
                .cluster()
        createIndex("test");
            .cluster()
        } else {
                .get()  
 *
        // delete should not be in cache
        @Override  
import org.opensearch.index.engine.VersionConflictEngineException;
            assertAcked(
                    .setSettings(Settings.builder().put("index.blocks.read_only", block))
import org.opensearch.action.admin.cluster.health.ClusterHealthResponse;
            .indices()
            client().admin()
                client().admin()
                    .indices()
                .get();
            .setSettings(Settings.builder().put("index.refresh_interval", -1)) // this one can change
    public void testOpenCloseUpdateSettings() throws Exception {
                        .put("index.final", "no")  
        assertThat(indexMetadata.getSettings().get("index.final"), nullValue());
        assertThat(getSettingsResponse.getSetting("test", "index.final"), nullValue());  
        assertThat(indexMetadata.getSettings().get("index.refresh_interval"), equalTo("1s"));  
                .setSettings(Settings.builder().put("index.acc.test.pw", "test"))  
            }  
import static org.hamcrest.Matchers.greaterThan;
            return Arrays.asList(DUMMY_SETTING, DUMMY_ACCOUNT_PW, DUMMY_ACCOUNT_USER, DUMMY_ACCOUNT_PW_CLUSTER, DUMMY_ACCOUNT_USER_CLUSTER);
import org.opensearch.common.settings.SettingsException;
            .execute()  
            // if the read-only block is present, remove it  
        assertAcked(
        IndexMetadata indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");
            VersionConflictEngineException.class
            } finally {  
    }
        createIndex("test");  
         * Previous versions of Elasticsearch would throw an exception that the number of replicas had to have a value, and could not be
        SettingsException e = expectThrows(  
            .prepareGetSettings("test")
 * this file be licensed under the Apache-2.0 license or a
                        .get()
                    .cluster()
                .actionGet()
    }  
        // update setting with null replica will use cluster setting of replica number
                .get()
import java.util.Collection;  
                .cluster()
        assertSame(currentState, clusterService.state());
    }
        assertThat(indexMetadata.getSettings().get("index.final"), nullValue());
            .prepareState()
            assertBusy(() -> assertThat(threadPool.relativeTimeInMillis(), greaterThan(startTime)));
                    .actionGet()  
            () -> client().admin()  
        assertTrue(IndexMetadata.INDEX_NUMBER_OF_REPLICAS_SETTING.exists(response.getIndexToSettings().get("test")));
                .index("test")  
            final long settingsVersion = client().admin()  
            .indices()
        // Make sure the time has advanced for InternalEngine#resolveDocVersion()
                    .put("index.translog.flush_threshold_size", "1024b")
                .setSettings(Settings.builder().putNull("index.acc.test.pw").putNull("index.acc.test.user"))
                .setSettings(Settings.builder().put("index.number_of_replicas", 1 + numberOfReplicas))
import org.opensearch.threadpool.ThreadPool;  
                .getState()
            + "    \"settings\": {\n"  
                        .put("index.fielddata.cache", "none")
            .get()
    /*  
                .metadata()
                .get();  
                    .setSettings(Settings.builder().put("index.acc.test.pw", "asdf"))  
                .prepareUpdateSettings()
            // user has no dependency  
            }
            );
                .get()
                .prepareUpdateSettings("test")
        internalCluster().ensureAtLeastNumDataNodes(2);
                .setPersistentSettings(Settings.builder().put("cluster.acc.test.pw", "asdf").put("cluster.acc.test.user", "asdf"))
        SettingsException e = expectThrows(  
            );
                .prepareUpdateSettings("test")
            .getSettingsVersion();
        );  
                    .get()
        );  
import org.opensearch.plugins.Plugin;
        client().admin()
        assertAcked(  
                .cluster()
            );  
            () -> client().admin()  
     * respect to settings version when changing the number of replicas.
                .prepareUpdateSettings("test")  
                .index("test")
                .indices()
                disableIndexBlock("test", blockSetting);
        assertAcked(
                SettingsException.class,
            new SystemTemplate(
            .prepareGetSettings("test")  
                    .indices()  
    }
            assertEquals("missing required setting [cluster.acc.test.user] for setting [cluster.acc.test.pw]", e.getMessage());  
                .setSettings(Settings.builder().put("index.acc.test.user", "asdf"))
        );
                .cluster()  
        client().admin()
            () -> internalCluster().getInstance(ClusterService.class).state()
        assertThat(newSettingsVersion, equalTo(1 + settingsVersion));  
        ensureGreen("test");  
            client().admin()
                SettingsException.class,
            .prepareState()  
        final long settingsVersion = client().admin()
                .indices()  
                .cluster()
            }  
        );
            if (block) {
            () -> prepareCreate("test", Settings.builder().put("index.acc.test.pw", "asdf")).get()
        createIndex("test");
        indexMetadata = client().admin().cluster().prepareState().execute().actionGet().getState().metadata().index("test");  
                .setSettings(Settings.builder().putNull(IndexMetadata.SETTING_NUMBER_OF_REPLICAS))
    public void testResetDefault() {
            }
            "pw",
                .indices()
        final long settingsVersion = client().admin()  
import static org.opensearch.cluster.metadata.IndexMetadata.SETTING_BLOCKS_METADATA;
    public void testNullReplicaUpdate() {  
            .cluster()
    public void testDefaultNumberOfReplicasOnClosedIndices() {
                .index("test")  
        String numberOfReplicas = client().admin()
            .setWaitForNoInitializingShards(true)
                .indices()
            () -> client().admin()
        );
                .prepareUpdateSettings("test")
            client().admin()
                client().admin()
                .prepareUpdateSettings()  
                Settings.builder()
        assertAcked(  
            .prepareHealth()
        final int numberOfReplicas = Integer.valueOf(  
                    .setSettings(Settings.builder().put("index.blocks.read_only", block == false))
                    .get()  
 *  
     * {@link IndexMetadata.Builder#numberOfReplicas(int)}. Therefore we have a dedicated test that this setting is handled properly with
            IndexService indexService = service.indexService(resolveIndex("test"));
                assertAcked(
                    .indices()  
            .indices()
            );  
                    Settings.builder()  
            .setSettings(Settings.builder().put("index.refresh_interval", -1))
                    client().admin()  
        for (IndicesService service : internalCluster().getInstances(IndicesService.class)) {
    }  
                .indices()
                .cluster()
            .actionGet();  
        createIndex("test");  
