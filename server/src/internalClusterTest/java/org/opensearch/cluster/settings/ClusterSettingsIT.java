            assertEquals(ex.getCause().getMessage(), "illegal value for [cluster.thread_pool.snapshot], has to be positive value");
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(8));  
            logger.info("Using transient settings");
        }
        assertThat(REROUTE_INTERVAL.get(response.getPersistentSettings()), equalTo(TimeValue.timeValueSeconds(44)));  
        ClusterUpdateSettingsResponse response = client().admin()  
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), false)  
        }
        assertAcked(response);  
            assertEquals(ex.getCause().getMessage(), "core threadpool size cannot be greater than max");  
        } catch (IllegalArgumentException ex) {  
                .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), -1).build())  
        final Level level = LogManager.getRootLogger().getLevel();  
        );
            .actionGet();
            client().admin()  
import org.opensearch.common.settings.AbstractScopedSettings;  
        assertThat(response3.getPersistentSettings().get(key1), notNullValue());  
        }
            )  
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(7));
            assertAcked(prepareCreate(indexName).setSettings(Settings.builder().put(IndexMetadata.SETTING_BLOCKS_METADATA, true)));
            .prepareUpdateSettings()  
    }
        }
        assertThat(response.getTransientSettings().get(key2), nullValue());
                .cluster()
            .cluster()
            .setTransientSettings(transientSettings3)
            client().admin()  
        } catch (IllegalArgumentException ex) {  
 * You may obtain a copy of the License at  
            assertEquals(ex.getCause().getMessage(), "core threadpool size cannot be greater than max");  
            ClusterStateResponse state = client().admin().cluster().prepareState().execute().actionGet();
            assertEquals(ex.getCause().getMessage(), "illegal thread_pool config : [wrong] should only have [core, max]");
                .prepareUpdateSettings()
 * The OpenSearch Contributors require contributions made to  
                    Settings.builder().put("cluster.thread_pool.snapshot.core", "2").put("cluster.thread_pool.snapshot.max", "1").build()
            } else {
                .setSettings(Settings.builder().put("index.refresh_interval", "10"))
            .cluster()
 *
            .prepareUpdateSettings()
            IllegalArgumentException.class,  
        ClusterUpdateSettingsResponse response1 = client().admin()  
            assertTrue(ex.getCause().getMessage().contains("illegal thread_pool name : "));
        assertThat(INITIAL_RECOVERIES.get(response.getPersistentSettings()), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));  
                .cluster()
        ClusterUpdateSettingsResponse response = client().admin()
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(10));
    protected Settings nodeSettings(int nodeOrdinal) {  
                .prepareUpdateSettings()  
        assertThat(response.getPersistentSettings().get(key1), nullValue());  
        }  
        } catch (IllegalArgumentException ex) {
        assertThat(REROUTE_INTERVAL.get(response.getPersistentSettings()), equalTo(REROUTE_INTERVAL.get(Settings.EMPTY)));
            .cluster()  
import org.opensearch.common.settings.ClusterSettings;
        assertThat(response2.getTransientSettings().get(key2), notNullValue());  
import java.util.Arrays;  
import java.util.HashMap;
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
        // Scaling threadpool - Other than max and core
        assertThat(response3.getTransientSettings().get(key1), nullValue());
        assertThat(response.getPersistentSettings().get(key2), notNullValue());
            .prepareUpdateSettings()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .execute()
                .get();
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(42));
        response = client().admin()
        assertThat(response1.getPersistentSettings().get(key2), notNullValue());  
            .cluster()
            client().admin()
        try {
                Settings.builder().putNull((randomBoolean() ? "cluster.routing.*" : "*")).put(REROUTE_INTERVAL.getKey(), "43s")
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
            )
        // It should work now  
            }
            .setPersistentSettings(persistentSettings);  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(updatedSettings).execute().actionGet();
        } finally {
    }
        Settings transientSettings2 = Settings.builder().put(key1, value1, ByteSizeUnit.BYTES).put(key2, value2).build();
    public void testCanUpdateTracerSettings() {
 * ownership. Elasticsearch licenses this file to you under  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).execute().actionGet();  
 * Unless required by applicable law or agreed to in writing,
        // Scaling threadpool - happy case - transient overrides persistent  
                .get();  
                settingToVerify.put(key, true);
import org.opensearch.indices.IndicesQueryCache;
                key = m.group(1);
        assertThat(response3.getTransientSettings().get(key2), nullValue());
                .setTransientSettings(  
        try {
        try {
            assertBlocked(request, Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
        assertThat(REROUTE_INTERVAL.get(response.getTransientSettings()), equalTo(TimeValue.timeValueSeconds(43)));
        ClusterUpdateSettingsResponse clusterUpdateSettingsResponse = client().admin()
            .setPersistentSettings(persistentSettings2)  
        response = client().admin()
            .setPersistentSettings(persistentSettings1)
        String key = "cluster.metadata." + randomAlphaOfLengthBetween(5, 20);
                .get();  
            assertEquals(value, state.getState().getMetadata().transientSettings().get(key));
        Settings transientSettings = Settings.builder().put(key1, EnableAllocationDecider.Allocation.NONE.name()).build();  
        // Cluster settings updates are blocked when the cluster is read only
        Settings transientSettings1 = Settings.builder().put(key1, value1, ByteSizeUnit.BYTES).build();  
        return Settings.builder()
        String key1 = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();  
        final Setting<Integer> INITIAL_RECOVERIES = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
            assertEquals(ex.getCause().getMessage(), "illegal thread_pool config : [wrong] should only have [size]");
            .prepareUpdateSettings()  
            if (settingToVerify.containsKey(key) && !settingToVerify.get(key)) {
                .prepareUpdateSettings()
import org.opensearch.test.OpenSearchIntegTestCase;  
            assertBlocked(client().admin().indices().prepareGetSettings(indexName), IndexMetadata.INDEX_METADATA_BLOCK);
                .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), "whatever").build())
import java.util.Map;  
        response = client().admin()
                .prepareUpdateSettings()
        assertThat(INITIAL_RECOVERIES.get(response.getPersistentSettings()), equalTo(10));
        final Settings settings = Settings.builder().put(key, value).build();
        // Scaling threadpool - core > max
            .setTransientSettings(
            .get();
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.generic.max", "1").build())
        ClusterUpdateSettingsRequestBuilder request = client().admin()
            if (m.find()) {
            )  
            fail("bogus value");  
        // Scaling threadpool - negative value
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(TimeValue.timeValueSeconds(43)));  
            assertEquals(level, LogManager.getRootLogger().getLevel());  
        // Scaling threadpool - Max value lesser than default value of 4  
            assertEquals(ex.getMessage(), "Failed to parse value [whatever] for setting [" + INITIAL_RECOVERIES.getKey() + "]");  
    public void testThreadPoolSettings() {  
            fail("bogus value");
 *
            String input = settingUpgrader.toString();
        assertAcked(response);  
        Settings transientSettings3 = Settings.EMPTY;
            client().admin()
            assertEquals(level, LogManager.getLogger("test").getLevel());
            fail("bogus value");
        String value2 = EnableAllocationDecider.Allocation.NONE.name();
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(Settings.builder().put(key1, value1).build()).get();
            .get();
            .setTransientSettings(
            assertEquals(value, state.getState().getMetadata().persistentSettings().get(key));
            .cluster()
import java.util.regex.Matcher;
 * Licensed to Elasticsearch under one or more contributor  
            final Settings.Builder testSettings = Settings.builder().put("logger.test", "TRACE").put("logger._root", "trace");
        for (int i = 0; i < 3; i++) {
            // But it's possible to update the settings to update the "cluster.blocks.read_only" setting
                .get();
        response = client().admin()
            .prepareUpdateSettings()
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(42));  
            fail("bogus value");
            fail("bogus value");
        clusterUpdateSettingsResponse = client().admin()  
                .get();  
        }
        } finally {  
    }  
            // But it's possible to update the settings to update the "cluster.blocks.read_only" setting
            client().admin()  
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
        }
            if (randomBoolean()) {
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).execute().actionGet();  
                .setTransientSettings(Settings.builder().put("logger._root", "BOOM"))
        } catch (IllegalArgumentException ex) {
        ClusterUpdateSettingsResponse response = request.execute().actionGet();
            .get();
        assertAcked(prepareCreate("test"));
        } catch (IllegalArgumentException e) {  
        }  
            Matcher m = p.matcher(input);
    }
        settingToVerify.put("indices.fielddata.cache.size", false);  
            client().admin()  
        assertThat(response2.getTransientSettings().get(key1), notNullValue());
            fail("bogus value");
            assertEquals(updatedValue, updatedState.getState().getMetadata().transientSettings().get(key));  
            .cluster()
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void testMissingUnits() {
            fail("bogus value");
        // Cluster settings updates are blocked when the cluster is read only  
                client().admin().cluster().prepareUpdateSettings().setTransientSettings(defaultSettings).execute().actionGet();  
/*  
        ClusterUpdateSettingsResponse response = client().admin()  
        assertEquals(  
    public void testClusterNonExistingSettingsUpdate() {
                .cluster()
            setClusterReadOnly(false);  
            () -> client().admin()
import org.opensearch.common.unit.TimeValue;
        }
            .get();  
    public void testLoggerLevelUpdate() {  
        assertThat(REROUTE_INTERVAL.get(response.getTransientSettings()), equalTo(TimeValue.timeValueSeconds(42)));
        assertAcked(response);
        assertAcked(response);
            .setTransientSettings(
 *  
import org.opensearch.common.settings.Setting;
        } else {
import org.opensearch.core.common.unit.ByteSizeUnit;  
            .setTransientSettings(transientSettings1)  
        try {
        // Fixed threadpool - Other than size
            disableIndexBlock(indexName, IndexMetadata.SETTING_BLOCKS_METADATA);  
            .prepareUpdateSettings()  
            .actionGet();
        try {
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(8));
            .setTransientSettings(transientSettings)
        assertAcked(response);
            .get();  
 * not use this file except in compliance with the License.
        String key1 = "no_idea_what_you_are_talking_about";
            assertEquals(ex.getCause().getMessage(), "illegal value for [cluster.thread_pool.get], has to be positive value");
 * specific language governing permissions and limitations
        }
            .get();
                .prepareUpdateSettings()  
        }  
        // Fixed threadpool - happy case
            .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 8).put(REROUTE_INTERVAL.getKey(), "43s").build())
        final Settings updatedSettings = Settings.builder().put(key, updatedValue).build();
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
            Arrays.asList("internal:index/shard/recovery/*", "internal:gateway/local*")
        } catch (IllegalArgumentException ex) {
            Pattern p = Pattern.compile("\"key\"\\s*:\\s*\"([^\"]+)\"");
            client().admin()
        String key2 = "cluster.routing.allocation.node_concurrent_recoveries";
            .setPersistentSettings(Settings.builder().putNull(INITIAL_RECOVERIES.getKey()))
            .prepareUpdateSettings()
        assertThat(response.getTransientSettings().get(key1), notNullValue());
    public void cleanup() throws Exception {
        }
            .setPersistentSettings(Settings.builder().putNull((randomBoolean() ? "cluster.routing.*" : "*")))
            .execute()
import org.junit.After;
            .prepareUpdateSettings()
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.get.size", "0").build())
    }
        Settings persistentSettings3 = Settings.builder().put(key1, value1, ByteSizeUnit.BYTES).put(key2, value2).build();
            .get();
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
 * compatible open source license.
import java.util.regex.Pattern;
        assertThat(response3.getPersistentSettings().get(key2), notNullValue());
    @Override
 */  
            fail("bogus value");
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
        try {
        for (AbstractScopedSettings.SettingUpdater<?> settingUpgrader : settingUpgraders) {
 * GitHub history for details.
            .cluster()
            .get();
        Settings persistentSettings = Settings.builder().put(key2, "5").build();  
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.snapshot.max", "-1").build())  
    }  
    }
                .get();
import static org.hamcrest.Matchers.equalTo;  
                .cluster()
            assertThat(e.getMessage(), containsString("unit is missing or unrecognized"));
        Settings persistentSettings2 = Settings.EMPTY;  
                fail("Was not able to read this setting: " + entry.getKey());  
        final Setting<Integer> INITIAL_RECOVERIES = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
            .prepareUpdateSettings()
        ClusterUpdateSettingsResponse clusterUpdateSettingsResponse = client().admin()
 */  
            .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 42).build())  
        // Fixed threadpool - 0 value
            .cluster()  
            .setTransientSettings(Settings.builder().put("cluster.thread_pool.get.size", "1").build())  
                fail("Setting registered multiple times");
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(TimeValue.timeValueSeconds(44)));
            ClusterStateResponse updatedState = client().admin().cluster().prepareState().execute().actionGet();
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.wrong.max", "-1").build())  
        assertAcked(response);  
        try {
            .get();
        try {
        assertNull(response.getTransientSettings().get(INITIAL_RECOVERIES.getKey()));
            clusterUpdateSettingsResponse.getTransientSettings().getAsList("transport.tracer.include"),
                final Settings.Builder defaultSettings = Settings.builder().putNull("logger.*");
            .cluster()  
                .prepareUpdateSettings()
        final Setting<Integer> INITIAL_RECOVERIES = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;  
        try {
            .prepareUpdateSettings()
                .cluster()
        assertThat(response1.getTransientSettings().get(key1), notNullValue());  
import org.opensearch.indices.recovery.RecoverySettings;
        assertThat(REROUTE_INTERVAL.get(response.getTransientSettings()), equalTo(REROUTE_INTERVAL.get(Settings.EMPTY)));  
                .prepareUpdateSettings()  
    }
import org.opensearch.common.settings.SettingsException;
                .cluster()  
 * SPDX-License-Identifier: Apache-2.0
        List<AbstractScopedSettings.SettingUpdater<?>> settingUpgraders = clusterSettings.getSettingUpdaters();  
                .actionGet()  
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.snapshot.wrong", "-1").build())  
        Settings persistentSettings1 = Settings.builder().put(key2, value2).build();
        assertTrue(clusterUpdateSettingsResponse.isAcknowledged());  
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
            client().admin()
        } catch (IllegalArgumentException ex) {  
            .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 7).put(REROUTE_INTERVAL.getKey(), "42s").build())
            fail("bogus value");  
            .get();
        ClusterUpdateSettingsResponse response3 = client().admin()
            .build();
        assertAcked(response);  
            .prepareUpdateSettings()  
                Settings.builder().putList("transport.tracer.include", "internal:index/shard/recovery/*", "internal:gateway/local*")  
 * Modifications Copyright OpenSearch Contributors. See
            fail("bogus value");  
        String key1 = "cluster.routing.allocation.enable";
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(7));
            .setPersistentSettings(persistentSettings3)
            .setPersistentSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 10).put(REROUTE_INTERVAL.getKey(), "44s").build())  
        assertAcked(response);
    public void testResetClusterSetting() {
                .setTransientSettings(Settings.builder().putNull("*"))
            .get();  
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(updatedSettings).execute().actionGet();
        } catch (IllegalArgumentException ex) {
                .cluster()
 * license agreements. See the NOTICE file distributed with
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(TimeValue.timeValueSeconds(42)));
import org.apache.logging.log4j.LogManager;
        assertThat(REROUTE_INTERVAL.get(response.getTransientSettings()), equalTo(TimeValue.timeValueSeconds(43)));
import org.opensearch.cluster.metadata.IndexMetadata;  
            .setTransientSettings(transientSettings2)
                .cluster()
            }
        final Setting<TimeValue> REROUTE_INTERVAL = CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
            client().admin()  
            .setPersistentSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 9).build())
        logger.info("Attempting to store [{}]: [{}], then update to [{}]", key, value, updatedValue);
            assertBlocked(request, Metadata.CLUSTER_READ_ONLY_BLOCK);
        final IllegalArgumentException e = expectThrows(
            client().admin()  
            .setPersistentSettings(Settings.builder().put("cluster.thread_pool.snapshot.max", "1").build())
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());  
            .setPersistentSettings(Settings.builder().put("cluster.thread_pool.get.size", "1").build())
            .setTransientSettings(Settings.builder().putNull((randomBoolean() ? "cluster.routing.*" : "*")))
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(7));  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
            Settings s = Settings.builder().putNull(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey()).build();
        try {  
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));  
package org.opensearch.cluster.settings;
        assertThat(response1.getPersistentSettings().get(key1), nullValue());
        assertThat(response1.getTransientSettings().get(key2), nullValue());
            setClusterReadOnly(true);
        String value = randomRealisticUnicodeOfCodepointLengthBetween(5, 50);  
            .prepareUpdateSettings()
        String updatedValue = randomRealisticUnicodeOfCodepointLengthBetween(5, 50);
        assertAcked(response2);
import org.opensearch.common.settings.Settings;  
        assertTrue(clusterUpdateSettingsResponse.isAcknowledged());  
            .cluster()
            assertEquals(Level.TRACE, LogManager.getLogger("test").getLevel());
        assertAcked(prepareCreate("test"));
                .cluster()
                )
}
                .prepareUpdateSettings()
    public void testClusterUpdateSettingsWithBlocks() {
 * KIND, either express or implied.  See the License for the
    public void testUserMetadata() {
        assertAcked(response1);
    }
        // wrong threadpool
import org.opensearch.cluster.metadata.Metadata;
            .prepareUpdateSettings()  
            .get();
        ClusterUpdateSettingsResponse response2 = client().admin()
        try {
 * under the License.  
        );
            .setTransientSettings(Settings.builder().putNull(INITIAL_RECOVERIES.getKey()))
        } catch (IllegalArgumentException ex) {  
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(testSettings).execute().actionGet();  
        // now persistent  
        int value1 = 10;  
                .cluster()
/*  
        assertThat(response2.getPersistentSettings().get(key2), nullValue());
    }
                .cluster()  
                .prepareUpdateSettings()
 */
        }
        response = client().admin()
            .get();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
        }
            .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 7).build())  
    public void testUpdateSettings() {  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
            assertEquals(updatedValue, updatedState.getState().getMetadata().persistentSettings().get(key));  
        int value1 = 10;
            assertEquals(Level.TRACE, LogManager.getRootLogger().getLevel());
        } catch (IllegalArgumentException ex) {
            .get();
        assertThat(INITIAL_RECOVERIES.get(response.getPersistentSettings()), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
            .prepareUpdateSettings()  
        assertThat(response2.getPersistentSettings().get(key1), nullValue());
        ClusterSettings clusterSettings = clusterService().getClusterSettings();
import org.apache.logging.log4j.Level;
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));  
            if (!entry.getValue()) {
            .execute()
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(TimeValue.timeValueSeconds(43)));
            String indexName = "test" + i;  
                .indices()  
                .setPersistentSettings(Settings.builder().putNull("*"))  
import static org.hamcrest.Matchers.containsString;
        }
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.get.wrong", "-1").build())
        assertAcked(response);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequestBuilder;  
        } catch (SettingsException ex) {
        final Setting<TimeValue> REROUTE_INTERVAL = CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
        assertAcked(
            Settings settings = Settings.builder().put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true).build();  
            .prepareUpdateSettings()
        assertEquals("Unknown level constant [BOOM].", e.getMessage());
            .cluster()  
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(7));
    public void testClusterSettingsUpdateResponse() {
                .actionGet();
                .execute()  
    @After  
            // But it's possible to update the settings to update the "cluster.blocks.read_only" setting
            .cluster()
        } finally {  
        response = client().admin()
    public void testWithMultipleIndexCreationAndVerifySettingRegisteredOnce() {
 * this file be licensed under the Apache-2.0 license or a
            fail("Expected IllegalArgumentException");
 * the Apache License, Version 2.0 (the "License"); you may
                client().admin().cluster().prepareUpdateSettings().setTransientSettings(defaultSettings).execute().actionGet();  
            } else if (settingToVerify.containsKey(key) && settingToVerify.get(key)) {  
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(REROUTE_INTERVAL.get(Settings.EMPTY)));
            assertEquals(ex.getMessage(), "Failed to parse value [-1] for setting [" + INITIAL_RECOVERIES.getKey() + "] must be >= 0");
public class ClusterSettingsIT extends OpenSearchIntegTestCase {
    }  
        response = client().admin()  
    }
            assertThat(e.getMessage(), containsString("[index.refresh_interval] with value [10]"));
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
            String key = "";  
        settingToVerify.put("indices.queries.cache.skip_cache_factor", false);
    }
            .put(super.nodeSettings(nodeOrdinal))
        if (randomBoolean()) {  
            }
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));  
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(s).get());  
            client().admin()
            .cluster()
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
        response = client().admin()
                .prepareUpdateSettings()
            assertEquals("transient setting [no_idea_what_you_are_talking_about], not recognized", ex.getMessage());
            ClusterStateResponse state = client().admin().cluster().prepareState().execute().actionGet();
            Settings settings = Settings.builder().putNull(Metadata.SETTING_READ_ONLY_SETTING.getKey()).build();
        try {  
                .get();
            .actionGet();  
import static org.hamcrest.Matchers.notNullValue;
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(9));  
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(42));
                final Settings.Builder defaultSettings = Settings.builder().putNull("logger.test").putNull("logger._root");
            // Trying to fetch key value as there is no other way  
                Settings.builder().put("cluster.thread_pool.snapshot.core", "2").put("cluster.thread_pool.snapshot.max", "2").build()
        }  
            logger.info("Using persistent settings");
                .get();
        );  
import static org.hamcrest.Matchers.nullValue;
        assertThat(INITIAL_RECOVERIES.get(response.getPersistentSettings()), equalTo(9));
            .prepareUpdateSettings()  
            .cluster()
    public void testDeleteIsAppliedFirst() {  
        try {
 * software distributed under the License is distributed on an
            .cluster()  
import java.util.List;
        String key2 = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();  
            }  
        }
                .prepareUpdateSettings()
            .cluster()
 * this work for additional information regarding copyright
        try {  
        for (Map.Entry<String, Boolean> entry : settingToVerify.entrySet()) {
        assertAcked(response3);  
            ClusterStateResponse updatedState = client().admin().cluster().prepareState().execute().actionGet();
/*
            .cluster()  
        }  
            .execute()  
        Map<String, Boolean> settingToVerify = new HashMap<>();
                .prepareUpdateSettings("test")
                .get();
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(REROUTE_INTERVAL.get(Settings.EMPTY)));
    }  
            .prepareUpdateSettings()
            .prepareUpdateSettings()
            .cluster()
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(42));
