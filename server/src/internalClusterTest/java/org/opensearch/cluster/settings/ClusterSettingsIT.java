import org.opensearch.common.settings.ClusterSettings;
            )
                final Settings.Builder defaultSettings = Settings.builder().putNull("logger.*");
        try {
            assertThat(e.getMessage(), containsString("[index.refresh_interval] with value [10]"));
            .setPersistentSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 9).build())
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(8));
                Settings.builder().putList("transport.tracer.include", "internal:index/shard/recovery/*", "internal:gateway/local*")
 * this file be licensed under the Apache-2.0 license or a
        assertThat(response3.getPersistentSettings().get(key1), notNullValue());
        assertThat(REROUTE_INTERVAL.get(response.getTransientSettings()), equalTo(TimeValue.timeValueSeconds(42)));
import org.apache.logging.log4j.Level;
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(8));
        } catch (IllegalArgumentException ex) {
        }
        try {
        String updatedValue = randomRealisticUnicodeOfCodepointLengthBetween(5, 50);
            .prepareUpdateSettings()
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.snapshot.wrong", "-1").build())
            .setTransientSettings(Settings.builder().put("cluster.thread_pool.get.size", "1").build())
            fail("bogus value");
 * not use this file except in compliance with the License.
            if (randomBoolean()) {
            client().admin()
            }
        } catch (IllegalArgumentException ex) {
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(updatedSettings).execute().actionGet();
            .put(IndicesQueryCache.INDICES_QUERIES_CACHE_ALL_SEGMENTS_SETTING.getKey(), false)
        // wrong threadpool
                .prepareUpdateSettings()
        assertAcked(response1);
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(42));
        Settings transientSettings1 = Settings.builder().put(key1, value1, ByteSizeUnit.BYTES).build();
            .prepareUpdateSettings()
        assertThat(response1.getTransientSettings().get(key1), notNullValue());
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
        final Settings settings = Settings.builder().put(key, value).build();
        assertAcked(response);
        String value2 = EnableAllocationDecider.Allocation.NONE.name();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertThat(response.getPersistentSettings().get(key2), notNullValue());
                .get();
        String key2 = "cluster.routing.allocation.node_concurrent_recoveries";
            fail("bogus value");
import org.opensearch.cluster.routing.allocation.decider.EnableAllocationDecider;
                .get();
        // Cluster settings updates are blocked when the cluster is read only
            assertBlocked(client().admin().indices().prepareGetSettings(indexName), IndexMetadata.INDEX_METADATA_BLOCK);
                .get();
    public void testMissingUnits() {
        }
 * Licensed to Elasticsearch under one or more contributor
        try {
            .setTransientSettings(Settings.builder().putNull(INITIAL_RECOVERIES.getKey()))
            .prepareUpdateSettings()
 * SPDX-License-Identifier: Apache-2.0
    }
            client().admin()
        response = client().admin()
            fail("bogus value");
            .setTransientSettings(transientSettings)
            setClusterReadOnly(false);
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(7));
            ClusterStateResponse state = client().admin().cluster().prepareState().execute().actionGet();
    @Override
            assertEquals(ex.getMessage(), "Failed to parse value [-1] for setting [" + INITIAL_RECOVERIES.getKey() + "] must be >= 0");
            .cluster()
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
                .indices()
    public void testDeleteIsAppliedFirst() {
                .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), "whatever").build())
        Settings persistentSettings = Settings.builder().put(key2, "5").build();
        assertThat(response1.getPersistentSettings().get(key2), notNullValue());
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(REROUTE_INTERVAL.get(Settings.EMPTY)));
        assertAcked(response);
                )
            disableIndexBlock(indexName, IndexMetadata.SETTING_BLOCKS_METADATA);
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
                .cluster()
            assertEquals(level, LogManager.getLogger("test").getLevel());
        // Scaling threadpool - negative value
            .prepareUpdateSettings()
            fail("bogus value");
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(7));
                .get();
                .prepareUpdateSettings()
        }
        ClusterUpdateSettingsResponse response3 = client().admin()
            .cluster()
        Settings persistentSettings2 = Settings.EMPTY;
            .prepareUpdateSettings()
            }
            clusterUpdateSettingsResponse.getTransientSettings().getAsList("transport.tracer.include"),
            client().admin()
            .get();
        try {
        assertThat(response.getTransientSettings().get(key2), nullValue());
        assertAcked(response2);
    }
        // Cluster settings updates are blocked when the cluster is read only
            Settings settings = Settings.builder().putNull(Metadata.SETTING_READ_ONLY_SETTING.getKey()).build();
        assertAcked(response);
    protected Settings nodeSettings(int nodeOrdinal) {
            if (settingToVerify.containsKey(key) && !settingToVerify.get(key)) {
        assertAcked(response);
            .build();
            .get();
            .execute()
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(TimeValue.timeValueSeconds(43)));
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(10));
            client().admin()
                .prepareUpdateSettings()
        assertThat(REROUTE_INTERVAL.get(response.getTransientSettings()), equalTo(TimeValue.timeValueSeconds(43)));
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(TimeValue.timeValueSeconds(44)));
            .prepareUpdateSettings()
        try {
 * Modifications Copyright OpenSearch Contributors. See
        assertAcked(prepareCreate("test"));
            ClusterStateResponse updatedState = client().admin().cluster().prepareState().execute().actionGet();
        assertThat(INITIAL_RECOVERIES.get(response.getPersistentSettings()), equalTo(10));
        assertNull(response.getTransientSettings().get(INITIAL_RECOVERIES.getKey()));
 * under the License.
 * KIND, either express or implied.  See the License for the
            .setPersistentSettings(Settings.builder().putNull((randomBoolean() ? "cluster.routing.*" : "*")))
                settingToVerify.put(key, true);
            .get();
        int value1 = 10;
 * this work for additional information regarding copyright
        } catch (IllegalArgumentException ex) {
        }
            .setPersistentSettings(persistentSettings1)
import org.opensearch.cluster.metadata.Metadata;
            .prepareUpdateSettings()
            fail("bogus value");
import java.util.Map;
        String key1 = RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey();
            Settings settings = Settings.builder().put(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey(), true).build();
        } catch (IllegalArgumentException ex) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Fixed threadpool - 0 value
        } catch (IllegalArgumentException e) {
 *
    public void testUserMetadata() {
            assertEquals(Level.TRACE, LogManager.getLogger("test").getLevel());
            client().admin()
        assertThat(REROUTE_INTERVAL.get(response.getTransientSettings()), equalTo(TimeValue.timeValueSeconds(43)));
            .get();
                .cluster()
    }
            .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 7).build())
            .get();
            assertEquals(updatedValue, updatedState.getState().getMetadata().transientSettings().get(key));
    }
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
        final Setting<Integer> INITIAL_RECOVERIES = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
                .prepareUpdateSettings()
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(42));
            client().admin()
            )
            () -> client().admin()
        } catch (SettingsException ex) {
import org.opensearch.cluster.metadata.IndexMetadata;
        ClusterUpdateSettingsResponse response = client().admin()
            .get();
            final Settings.Builder testSettings = Settings.builder().put("logger.test", "TRACE").put("logger._root", "trace");
 * the Apache License, Version 2.0 (the "License"); you may
            .put(super.nodeSettings(nodeOrdinal))
import static org.hamcrest.Matchers.nullValue;
        Settings transientSettings2 = Settings.builder().put(key1, value1, ByteSizeUnit.BYTES).put(key2, value2).build();
        assertThat(response3.getPersistentSettings().get(key2), notNullValue());
            .setPersistentSettings(Settings.builder().put("cluster.thread_pool.snapshot.max", "1").build())
        if (randomBoolean()) {
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
            IllegalArgumentException.class,
            .actionGet();
}
import static org.hamcrest.Matchers.containsString;
                .cluster()
            assertEquals(ex.getCause().getMessage(), "core threadpool size cannot be greater than max");
            String input = settingUpgrader.toString();
    public void testThreadPoolSettings() {
        } else {
            .cluster()
        Settings persistentSettings3 = Settings.builder().put(key1, value1, ByteSizeUnit.BYTES).put(key2, value2).build();
        for (int i = 0; i < 3; i++) {
        try {
            assertAcked(prepareCreate(indexName).setSettings(Settings.builder().put(IndexMetadata.SETTING_BLOCKS_METADATA, true)));
            assertEquals(ex.getCause().getMessage(), "core threadpool size cannot be greater than max");
import static org.opensearch.cluster.routing.allocation.decider.ThrottlingAllocationDecider.CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
/*
        ClusterSettings clusterSettings = clusterService().getClusterSettings();
                .get();
            // Trying to fetch key value as there is no other way
            .actionGet();
        assertThat(INITIAL_RECOVERIES.get(response.getPersistentSettings()), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
 * You may obtain a copy of the License at
import java.util.Arrays;
                .get();
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).execute().actionGet();
import java.util.List;
        Settings transientSettings3 = Settings.EMPTY;
            .prepareUpdateSettings()
                .actionGet()
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(settings).execute().actionGet();
            .prepareUpdateSettings()
            .get();
                .setSettings(Settings.builder().put("index.refresh_interval", "10"))
import org.opensearch.common.settings.SettingsException;
            Pattern p = Pattern.compile("\"key\"\\s*:\\s*\"([^\"]+)\"");
            .setTransientSettings(
            }
        assertThat(response.getPersistentSettings().get(key1), nullValue());
import static org.hamcrest.Matchers.equalTo;
    public void testUpdateSettings() {
 * GitHub history for details.
            logger.info("Using transient settings");
    }
        response = client().admin()
        assertTrue(clusterUpdateSettingsResponse.isAcknowledged());
 * ownership. Elasticsearch licenses this file to you under
            client().admin()
        clusterUpdateSettingsResponse = client().admin()
        response = client().admin()
            .get();
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
            .prepareUpdateSettings()
            .setTransientSettings(transientSettings1)
            .actionGet();
                .get();
            .cluster()
            .prepareUpdateSettings()
                .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), -1).build())
        try {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    Settings.builder().put("cluster.thread_pool.snapshot.core", "2").put("cluster.thread_pool.snapshot.max", "1").build()
                .prepareUpdateSettings()
        try {
    public void testResetClusterSetting() {
            assertBlocked(request, Metadata.CLUSTER_READ_ONLY_ALLOW_DELETE_BLOCK);
        final Setting<TimeValue> REROUTE_INTERVAL = CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
    }
            .prepareUpdateSettings()
 */
        String key2 = EnableAllocationDecider.CLUSTER_ROUTING_ALLOCATION_ENABLE_SETTING.getKey();
            .cluster()
            .setTransientSettings(
            assertTrue(ex.getCause().getMessage().contains("illegal thread_pool name : "));
            .prepareUpdateSettings()
        assertThat(response3.getTransientSettings().get(key1), nullValue());
import org.opensearch.common.settings.Setting;
        assertThat(response2.getTransientSettings().get(key1), notNullValue());
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(updatedSettings).execute().actionGet();
        // Scaling threadpool - core > max
            client().admin()
        }
            fail("bogus value");
                .cluster()
        final Level level = LogManager.getRootLogger().getLevel();
        }
public class ClusterSettingsIT extends OpenSearchIntegTestCase {
            fail("bogus value");
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.common.settings.Settings;
        try {
            assertEquals(value, state.getState().getMetadata().persistentSettings().get(key));
            .get();
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
            // But it's possible to update the settings to update the "cluster.blocks.read_only" setting
            .cluster()
                final Settings.Builder defaultSettings = Settings.builder().putNull("logger.test").putNull("logger._root");
            if (m.find()) {
            .cluster()
        final IllegalArgumentException e = expectThrows(
                .actionGet();
        assertThat(response3.getTransientSettings().get(key2), nullValue());
                .cluster()
            fail("Expected IllegalArgumentException");
            .cluster()
                .setTransientSettings(Settings.builder().put("logger._root", "BOOM"))
        } catch (IllegalArgumentException ex) {
import org.opensearch.core.common.unit.ByteSizeUnit;
        assertThat(REROUTE_INTERVAL.get(response.getPersistentSettings()), equalTo(REROUTE_INTERVAL.get(Settings.EMPTY)));
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(7));
            .cluster()
 *
        for (Map.Entry<String, Boolean> entry : settingToVerify.entrySet()) {
    }
    public void testCanUpdateTracerSettings() {
        }
            .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 8).put(REROUTE_INTERVAL.getKey(), "43s").build())
            assertEquals(value, state.getState().getMetadata().transientSettings().get(key));
        for (AbstractScopedSettings.SettingUpdater<?> settingUpgrader : settingUpgraders) {
            .setPersistentSettings(persistentSettings);
import static org.opensearch.cluster.routing.allocation.DiskThresholdSettings.CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(s).get());
import org.opensearch.indices.IndicesQueryCache;
        ClusterUpdateSettingsResponse response = request.execute().actionGet();
        final Setting<TimeValue> REROUTE_INTERVAL = CLUSTER_ROUTING_ALLOCATION_REROUTE_INTERVAL_SETTING;
            assertEquals(level, LogManager.getRootLogger().getLevel());
                .prepareUpdateSettings()
    }
            assertEquals(updatedValue, updatedState.getState().getMetadata().persistentSettings().get(key));
        } finally {
            .setPersistentSettings(persistentSettings3)
            assertEquals(ex.getCause().getMessage(), "illegal value for [cluster.thread_pool.get], has to be positive value");
 * specific language governing permissions and limitations
        assertThat(INITIAL_RECOVERIES.get(response.getPersistentSettings()), equalTo(9));
            client().admin()
            assertEquals(ex.getCause().getMessage(), "illegal thread_pool config : [wrong] should only have [size]");
            .prepareUpdateSettings()
                .execute()
        assertThat(response2.getPersistentSettings().get(key1), nullValue());
    }
        assertThat(response1.getTransientSettings().get(key2), nullValue());
            } else {
        response = client().admin()
        List<AbstractScopedSettings.SettingUpdater<?>> settingUpgraders = clusterSettings.getSettingUpdaters();
/*
        try {
        }
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsRequestBuilder;
                Settings.builder().put("cluster.thread_pool.snapshot.core", "2").put("cluster.thread_pool.snapshot.max", "2").build()
        assertThat(response.getTransientSettings().get(key1), notNullValue());
                fail("Setting registered multiple times");
    }
            assertThat(e.getMessage(), containsString("unit is missing or unrecognized"));
            .cluster()
import java.util.regex.Pattern;
            fail("bogus value");
                .setTransientSettings(Settings.builder().putNull("*"))
        assertThat(INITIAL_RECOVERIES.get(response.getPersistentSettings()), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
        assertAcked(response);
        Settings persistentSettings1 = Settings.builder().put(key2, value2).build();
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(42));
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
                .prepareUpdateSettings()
        // Fixed threadpool - Other than size
    public void testLoggerLevelUpdate() {
            .setPersistentSettings(persistentSettings2)
        settingToVerify.put("indices.fielddata.cache.size", false);
        assertThat(response2.getPersistentSettings().get(key2), nullValue());
            .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 42).build())
            Matcher m = p.matcher(input);
 * The OpenSearch Contributors require contributions made to
 * Unless required by applicable law or agreed to in writing,
import java.util.HashMap;
            client().admin()
        assertAcked(response);
            .cluster()
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.wrong.max", "-1").build())
    public void testClusterSettingsUpdateResponse() {
        // Fixed threadpool - happy case
            setClusterReadOnly(true);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertBlocked;
                .execute()
    @After
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(INITIAL_RECOVERIES.get(Settings.EMPTY)));
        String key = "cluster.metadata." + randomAlphaOfLengthBetween(5, 20);
            assertBlocked(request, Metadata.CLUSTER_READ_ONLY_BLOCK);
            .prepareUpdateSettings()
            assertEquals(ex.getMessage(), "Failed to parse value [whatever] for setting [" + INITIAL_RECOVERIES.getKey() + "]");
        response = client().admin()
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(TimeValue.timeValueSeconds(42)));
        }
        }
                client().admin().cluster().prepareUpdateSettings().setTransientSettings(defaultSettings).execute().actionGet();
        } catch (IllegalArgumentException ex) {
                .setPersistentSettings(Settings.builder().putNull("*"))
            client().admin()
            .setPersistentSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 10).put(REROUTE_INTERVAL.getKey(), "44s").build())
                fail("Was not able to read this setting: " + entry.getKey());
import org.opensearch.indices.recovery.RecoverySettings;
            // But it's possible to update the settings to update the "cluster.blocks.read_only" setting
        assertAcked(prepareCreate("test"));
        }
        // It should work now
    public void testWithMultipleIndexCreationAndVerifySettingRegisteredOnce() {
        ClusterUpdateSettingsResponse response2 = client().admin()
        }
    }
        }
                .cluster()
                .cluster()
            .get();
        assertThat(REROUTE_INTERVAL.get(response.getTransientSettings()), equalTo(REROUTE_INTERVAL.get(Settings.EMPTY)));
        try {
                Settings.builder().putNull((randomBoolean() ? "cluster.routing.*" : "*")).put(REROUTE_INTERVAL.getKey(), "43s")
        assertAcked(response);
        String key1 = "cluster.routing.allocation.enable";
        String value = randomRealisticUnicodeOfCodepointLengthBetween(5, 50);
            .execute()
            .prepareUpdateSettings()
            .cluster()
        }
            .setTransientSettings(Settings.builder().putNull((randomBoolean() ? "cluster.routing.*" : "*")))
        }
            fail("bogus value");
        settingToVerify.put("indices.queries.cache.skip_cache_factor", false);
            .setTransientSettings(
        }
                .prepareUpdateSettings()
        }
            .get();
            assertEquals(ex.getCause().getMessage(), "illegal thread_pool config : [wrong] should only have [core, max]");
        assertAcked(response);
            .get();
        return Settings.builder()
            ClusterStateResponse state = client().admin().cluster().prepareState().execute().actionGet();
            .execute()
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.generic.max", "1").build())
        ClusterUpdateSettingsResponse clusterUpdateSettingsResponse = client().admin()
        assertTrue(clusterUpdateSettingsResponse.isAcknowledged());
            .setTransientSettings(transientSettings3)
            assertEquals("transient setting [no_idea_what_you_are_talking_about], not recognized", ex.getMessage());
 */
            .setPersistentSettings(Settings.builder().putNull(INITIAL_RECOVERIES.getKey()))
        } catch (IllegalArgumentException ex) {
            .get();
 *
        );
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.get.wrong", "-1").build())
            .cluster()
        final Setting<Integer> INITIAL_RECOVERIES = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
import org.opensearch.common.settings.AbstractScopedSettings;
        final Settings updatedSettings = Settings.builder().put(key, updatedValue).build();
        final Setting<Integer> INITIAL_RECOVERIES = CLUSTER_ROUTING_ALLOCATION_NODE_INITIAL_PRIMARIES_RECOVERIES_SETTING;
        // Scaling threadpool - Other than max and core
            .setTransientSettings(transientSettings2)
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(7));
        logger.info("Attempting to store [{}]: [{}], then update to [{}]", key, value, updatedValue);
        ClusterUpdateSettingsResponse response = client().admin()
        ClusterUpdateSettingsRequestBuilder request = client().admin()
        } catch (IllegalArgumentException ex) {
            if (!entry.getValue()) {
        int value1 = 10;
            .cluster()
package org.opensearch.cluster.settings;
        } catch (IllegalArgumentException ex) {
            String key = "";
            // But it's possible to update the settings to update the "cluster.blocks.read_only" setting
        String key1 = "no_idea_what_you_are_talking_about";
            .prepareUpdateSettings()
            Settings s = Settings.builder().putNull(Metadata.SETTING_READ_ONLY_ALLOW_DELETE_SETTING.getKey()).build();
        assertAcked(response);
            .cluster()
            }
            .prepareUpdateSettings()
                .cluster()
                .setTransientSettings(
        response = client().admin()
 * compatible open source license.
import org.apache.logging.log4j.LogManager;
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
            assertAcked(client().admin().cluster().prepareUpdateSettings().setTransientSettings(settings).get());
    public void testClusterUpdateSettingsWithBlocks() {
        response = client().admin()
            fail("bogus value");
                key = m.group(1);
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(TimeValue.timeValueSeconds(43)));
        // now persistent
            String indexName = "test" + i;
    }
                .get();
        }
        Settings transientSettings = Settings.builder().put(key1, EnableAllocationDecider.Allocation.NONE.name()).build();
                .cluster()
                .prepareUpdateSettings()
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.get.size", "0").build())
import org.junit.After;
            assertEquals(ex.getCause().getMessage(), "illegal value for [cluster.thread_pool.snapshot], has to be positive value");
    }
            .cluster()
        ClusterUpdateSettingsResponse response = client().admin()
            .cluster()
                .cluster()
        assertEquals("Unknown level constant [BOOM].", e.getMessage());
        ClusterUpdateSettingsResponse response1 = client().admin()
                .cluster()
            .setTransientSettings(Settings.builder().put(INITIAL_RECOVERIES.getKey(), 7).put(REROUTE_INTERVAL.getKey(), "42s").build())
            logger.info("Using persistent settings");
        assertAcked(
/*
        try {
        );
        // Scaling threadpool - happy case - transient overrides persistent
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(Settings.builder().put(key1, value1).build()).get();
                client().admin().cluster().prepareUpdateSettings().setTransientSettings(defaultSettings).execute().actionGet();
        assertThat(INITIAL_RECOVERIES.get(response.getTransientSettings()), equalTo(42));
        try {
        } finally {
                .get();
        assertAcked(response3);
    public void cleanup() throws Exception {
import org.opensearch.test.OpenSearchIntegTestCase;
        // Scaling threadpool - Max value lesser than default value of 4
            .get();
        response = client().admin()
        assertThat(REROUTE_INTERVAL.get(response.getPersistentSettings()), equalTo(TimeValue.timeValueSeconds(44)));
        Map<String, Boolean> settingToVerify = new HashMap<>();
            assertEquals(Level.TRACE, LogManager.getRootLogger().getLevel());
        assertThat(response1.getPersistentSettings().get(key1), nullValue());
    public void testClusterNonExistingSettingsUpdate() {
            Arrays.asList("internal:index/shard/recovery/*", "internal:gateway/local*")
        } finally {
import org.opensearch.common.unit.TimeValue;
                .prepareUpdateSettings()
 */
                .prepareUpdateSettings()
            } else if (settingToVerify.containsKey(key) && settingToVerify.get(key)) {
        assertThat(clusterService().getClusterSettings().get(REROUTE_INTERVAL), equalTo(REROUTE_INTERVAL.get(Settings.EMPTY)));
            .setPersistentSettings(Settings.builder().put("cluster.thread_pool.get.size", "1").build())
            client().admin().cluster().prepareUpdateSettings().setTransientSettings(testSettings).execute().actionGet();
        ClusterUpdateSettingsResponse clusterUpdateSettingsResponse = client().admin()
 * software distributed under the License is distributed on an
            )
        assertThat(clusterService().getClusterSettings().get(INITIAL_RECOVERIES), equalTo(9));
                .setTransientSettings(Settings.builder().put("cluster.thread_pool.snapshot.max", "-1").build())
            .cluster()
        );
    }
        assertThat(response2.getTransientSettings().get(key2), notNullValue());
        try {
import java.util.regex.Matcher;
                .prepareUpdateSettings("test")
            ClusterStateResponse updatedState = client().admin().cluster().prepareState().execute().actionGet();
        assertEquals(
