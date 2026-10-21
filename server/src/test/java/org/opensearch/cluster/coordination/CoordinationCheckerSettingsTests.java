            // cleanup
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_TIMEOUT_SETTING;
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
    }
            assertAcked(response);
package org.opensearch.cluster.coordination;
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
            // cleanup
            timeSettings1 = Settings.builder().putNull(setting1.getKey()).build();
            assertEquals(timeValueSeconds(30), setting1.get(response.getPersistentSettings()));
            IllegalArgumentException.class,
        try {
            () -> {
            }
        );
                client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
                .cluster()
        }
        try {
 */
            assertEquals(timeValueSeconds(10), setting1.get(response.getPersistentSettings()));
            "failed to parse value [151s] for setting [" + setting1.getKey() + "], must be <= [150000ms]",
            ClusterUpdateSettingsResponse response = client().admin()
import static org.opensearch.cluster.coordination.FollowersChecker.FOLLOWER_CHECK_INTERVAL_SETTING;
    public void testFollowerCheckIntervalMinValue() {
import static org.opensearch.cluster.coordination.Coordinator.PUBLISH_TIMEOUT_SETTING;
        assertThrows(
    public void testLagDetectorTimeoutUpdate() {
            timeSettings1 = Settings.builder().putNull(setting1.getKey()).build();
                .actionGet();
        assertThrows(
                .execute()
            () -> {
    }
                client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
    }
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "10ms").build();
            "failed to parse value [0s] for setting [" + setting1.getKey() + "], must be >= [1ms]",
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "60s").build();
            assertAcked(response);
        } finally {
}
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    }
            IllegalArgumentException.class,
import static org.opensearch.common.unit.TimeValue.timeValueSeconds;
            IllegalArgumentException.class,
/*
            // cleanup
        assertThrows(
    public void testLeaderCheckTimeoutMaxValue() {
        Setting<TimeValue> setting1 = PUBLISH_TIMEOUT_SETTING;
        );
            () -> {
                .prepareUpdateSettings()
            "failed to parse value [10ms] for setting [" + setting1.getKey() + "], must be >= [100ms]",
import org.opensearch.common.unit.TimeValue;
                client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
                .execute()
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "0s").build();
        Setting<TimeValue> setting1 = FOLLOWER_CHECK_INTERVAL_SETTING;
        assertThrows(
            assertEquals(timeValueSeconds(60), setting1.get(response.getPersistentSettings()));
                .cluster()
        Setting<TimeValue> setting1 = CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING;
            assertAcked(response);
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "61s").build();
import org.opensearch.action.admin.cluster.settings.ClusterUpdateSettingsResponse;
    }
    public void testFollowerCheckTimeoutValueUpdate() {
        Setting<TimeValue> setting1 = PUBLISH_TIMEOUT_SETTING;
        Settings lagDetectorTimeout = Settings.builder().put(setting1.getKey(), "0s").build();
                .execute()
    }
import org.opensearch.common.settings.Setting;
            IllegalArgumentException.class,
            ClusterUpdateSettingsResponse response = client().admin()
                .setPersistentSettings(timeSettings1)
            }
        Setting<TimeValue> setting1 = CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING;
                .setPersistentSettings(timeSettings1)
            ClusterUpdateSettingsResponse response = client().admin()
                .cluster()
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "0s").build();
    public void testLeaderCheckTimeoutValueUpdate() {
    }
            "failed to parse value [0s] for setting [" + setting1.getKey() + "], must be >= [1ms]",
    public void testClusterPublishTimeoutMinValue() {
        } finally {
                .cluster()
        Settings lagDetectorTimeout = Settings.builder().put(setting1.getKey(), "30s").build();
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
            timeSettings1 = Settings.builder().putNull(setting1.getKey()).build();
            () -> {
                .execute()
            }
                client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
    public void testFollowerCheckIntervalValueUpdate() {
 * The OpenSearch Contributors require contributions made to
    }
        }
    }
                client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
        }
    }
    public void testLeaderCheckTimeoutMinValue() {
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
import org.opensearch.common.settings.Settings;
 * this file be licensed under the Apache-2.0 license or a
        assertThrows(
            IllegalArgumentException.class,
            () -> {
                client().admin().cluster().prepareUpdateSettings().setPersistentSettings(lagDetectorTimeout).execute().actionGet();
        } finally {
        try {
        assertThrows(
            () -> {
        }
                .prepareUpdateSettings()
            lagDetectorTimeout = Settings.builder().putNull(setting1.getKey()).build();
        Setting<TimeValue> setting1 = LEADER_CHECK_TIMEOUT_SETTING;
        );
public class CoordinationCheckerSettingsTests extends OpenSearchSingleNodeTestCase {
        Setting<TimeValue> setting1 = FOLLOWER_CHECK_TIMEOUT_SETTING;
        assertThrows(
            assertEquals(timeValueSeconds(60), setting1.get(response.getPersistentSettings()));
            // cleanup
        Setting<TimeValue> setting1 = LEADER_CHECK_TIMEOUT_SETTING;
            IllegalArgumentException.class,
    }
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "60s").build();
            assertAcked(response);
    }
            assertEquals(timeValueSeconds(60), setting1.get(response.getPersistentSettings()));
            // cleanup
                .actionGet();
        Setting<TimeValue> setting1 = LEADER_CHECK_TIMEOUT_SETTING;
            "failed to parse value [0s] for setting [" + setting1.getKey() + "], must be >= [1ms]",
    public void testFollowerCheckTimeoutMaxValue() {
        } finally {
            ClusterUpdateSettingsResponse response = client().admin()
                .prepareUpdateSettings()
                .cluster()
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "0s").build();
        try {
                .setPersistentSettings(lagDetectorTimeout)
                .setPersistentSettings(timeSettings1)
import org.opensearch.test.OpenSearchSingleNodeTestCase;
            IllegalArgumentException.class,
        try {
            }
        }
            }
                .prepareUpdateSettings()
                .setPersistentSettings(timeSettings1)
            assertAcked(response);
        );
    public void testClusterPublishTimeoutValueUpdate() {
                .prepareUpdateSettings()
            client().admin().cluster().prepareUpdateSettings().setPersistentSettings(lagDetectorTimeout).execute().actionGet();
                .actionGet();
    public void testFollowerCheckTimeoutMinValue() {
import static org.opensearch.cluster.coordination.LagDetector.CLUSTER_FOLLOWER_LAG_TIMEOUT_SETTING;
                .actionGet();
    public void testLagDetectorTimeoutMinValue() {
        Setting<TimeValue> setting1 = FOLLOWER_CHECK_TIMEOUT_SETTING;
            () -> {
 *
            }
                .actionGet();
        );
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "60s").build();
            ClusterUpdateSettingsResponse response = client().admin()
        Setting<TimeValue> setting1 = FOLLOWER_CHECK_TIMEOUT_SETTING;
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "10s").build();
            "failed to parse value [0s] for setting [" + setting1.getKey() + "], must be >= [1ms]",
                .execute()
            }
import static org.opensearch.cluster.coordination.LeaderChecker.LEADER_CHECK_TIMEOUT_SETTING;
            timeSettings1 = Settings.builder().putNull(setting1.getKey()).build();
        );
        Settings timeSettings1 = Settings.builder().put(setting1.getKey(), "151s").build();
            "failed to parse value [61s] for setting [" + setting1.getKey() + "], must be <= [60000ms]",
        } finally {
        );
        Setting<TimeValue> setting1 = FOLLOWER_CHECK_INTERVAL_SETTING;
                client().admin().cluster().prepareUpdateSettings().setPersistentSettings(timeSettings1).execute().actionGet();
