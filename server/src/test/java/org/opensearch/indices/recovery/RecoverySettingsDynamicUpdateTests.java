                .build()
    public void tearDown() throws Exception {
        assertEquals(maxParts, recoverySettings.getRemoteStoreParallelDownloadPermits().getMaxPermits());
import org.opensearch.core.common.unit.ByteSizeValue;
        assertFalse(recoverySettings.isMergedSegmentReplicationWarmerEnabled());
        clusterSettings.applySettings(
            Settings.builder()
    public void testMergedSegmentReplicationWarmerEnabledSetting() {
        );
        assertEquals(partSize, recoverySettings.getRemoteStoreParallelDownloadPartSize());
import org.opensearch.common.unit.TimeValue;
        clusterSettings.applySettings(
 * Unless required by applicable law or agreed to in writing,
            Settings.builder()
        assertEquals(700000, recoverySettings.getTranslogConcurrentRecoveryBatchSize());
                .build()
    public void testSetMergedSegmentReplicationMaxBytesPerSec() {
    private final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, clusterSettings);
    public void testRemoteStoreParallelDownloadPartSize() {
                .build()
        );
                .put(RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING.getKey(), maxParts)
        assertEquals(100L, recoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold().getGb());
                .put(
    public void testSetTranslogConcurrentRecoverySettings() {
    public void testInternalLongActionTimeout() {
        ByteSizeValue partSize = new ByteSizeValue(between(1, 1024), ByteSizeUnit.MB);
                .build()
                .build()
 * GitHub history for details.
            Settings.builder()
                .build()
        );
 * Modifications Copyright OpenSearch Contributors. See
    }
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.getKey(), duration, timeUnit).build()
        );
        assertEquals(chunkSize, recoverySettings.getChunkSize());
                    .put(
        );
                .put(RecoverySettings.INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING.getKey(), duration, timeUnit)
 */
        );
        );
/*
                )
 * this work for additional information regarding copyright
            Settings.builder()
        clusterSettings.applySettings(
            RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING.get(Settings.EMPTY).intValue(),
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
                .build()
        clusterSettings.applySettings(
        );
        clusterSettings.applySettings(
        clusterSettings.applySettings(
                    RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(),
 * compatible open source license.
                Settings.builder()
            )
        );
        );
        clusterSettings.applySettings(
        );
                    new ByteSizeValue(80, ByteSizeUnit.MB)
 * under the License.
        assertNull(recoverySettings.mergedSegmentReplicationRateLimiter());
 * KIND, either express or implied.  See the License for the
            )
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
    public void testRemoteStoreParallelDownloadMaxConcurrentParts() {
            Settings.builder()
    private final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
    }
        clusterSettings.applySettings(
import java.util.concurrent.TimeUnit;
        long duration = between(1, 1000);
    public void testMergedSegmentReplicationTimeout() {
            () -> clusterSettings.applySettings(
    }
        assertEquals(5, (int) recoverySettings.getPrimaryResyncTimeout().minutes());
        assertEquals(500L, recoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold().getMb());
 * license agreements. See the NOTICE file distributed with
        expectThrows(
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.internalActionLongTimeout());
        assertEquals(60, (int) recoverySettings.replicationRateLimiter().getMBPerSec());
        // below the 1mb floor
        ByteSizeValue chunkSize = new ByteSizeValue(between(1, 1000), ByteSizeUnit.BYTES);
    }
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(), 0).build()
                    .build()
                    .put(RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING.getKey(), -1)
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.retryDelayStateSync());
/*
        clusterSettings.applySettings(
            () -> clusterSettings.applySettings(
                .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "4KB")
        assertEquals(
        assertNull(recoverySettings.replicationRateLimiter());
        );
        assertEquals(80, (int) recoverySettings.mergedSegmentReplicationRateLimiter().getMBPerSec());
            Settings.builder().put(RecoverySettings.INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(), 0).build()
    }
        expectThrows(
 * software distributed under the License is distributed on an
            initial
                .build()
        );
        assertTrue(recoverySettings.isMergedSegmentReplicationWarmerEnabled());
 * not use this file except in compliance with the License.
                .build()
            Settings.builder()
        );
 */
        assertEquals(15, (int) recoverySettings.getMergedSegmentReplicationTimeout().minutes());
        final int initial = recoverySettings.getRemoteStoreParallelDownloadPermits().getMaxPermits();
        assertEquals(500000, recoverySettings.getTranslogConcurrentRecoveryBatchSize());
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
        clusterSettings.applySettings(
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING.getKey(), chunkSize).build()
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), 0).build()
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING.getKey(), duration, timeUnit).build()
                .put(RecoverySettings.INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(), new ByteSizeValue(80, ByteSizeUnit.MB))
    public void testRetryDelayStateSync() {
            IllegalArgumentException.class,
        assertEquals(80, (int) recoverySettings.replicationRateLimiter().getMBPerSec());
    public void testActivityTimeout() {
            Settings.builder()
    }
        assertNull(recoverySettings.recoveryRateLimiter());
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build()
import org.opensearch.common.settings.ClusterSettings;
        clusterSettings.applySettings(
        assertEquals(60, (int) recoverySettings.mergedSegmentReplicationRateLimiter().getMBPerSec());
            Settings.builder()
        clusterSettings.applySettings(
 */
                )
                        RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING.getKey(),
                .putNull(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey())
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING.getKey(), duration, timeUnit).build()
                .build()
    }
        );
 *
 * Licensed to Elasticsearch under one or more contributor
        clusterSettings.applySettings(
                .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(5))
                .put(RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING.getKey(), duration, timeUnit)
    public void testInternalActionTimeout() {
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.retryDelayNetwork());
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
        clusterSettings.applySettings(
        clusterSettings.applySettings(
        clusterSettings.applySettings(
        assertEquals(4L, recoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold().getKb());
 *
    }
            Settings.builder()
        assertEquals(25, (int) recoverySettings.getMergedSegmentReplicationTimeout().minutes());
            )
        assertEquals(new ByteSizeValue(16, ByteSizeUnit.MB), recoverySettings.getRemoteStoreParallelDownloadPartSize());
                    .build()
        clusterSettings.applySettings(
        );
 * You may obtain a copy of the License at
                    .build()
        );
                Settings.builder()
        long duration = between(1, 1000);
                .build()
        clusterSettings.applySettings(
        );
            Settings.builder()
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.activityTimeout());
        clusterSettings.applySettings(
    }
    }
                .put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), new ByteSizeValue(60, ByteSizeUnit.MB))
 * the Apache License, Version 2.0 (the "License"); you may
    }
    public void testSetReplicationMaxBytesPerSec() {
        );
        );
 * this file be licensed under the Apache-2.0 license or a
                Settings.builder()
    public void testRetryDelayNetwork() {
                .put(
    }
            Settings.builder()
        long duration = between(1, 1000);
    }
        clusterSettings.applySettings(
        clusterSettings.applySettings(
                    )
import static org.hamcrest.Matchers.containsString;
            Settings.builder()
        long duration = between(1, 1000);
    public void testPrimaryResyncTimeout() {
        FeatureFlags.initializeFeatureFlags(Settings.EMPTY);
        assertEquals(5, (int) recoverySettings.getMergedSegmentReplicationTimeout().minutes());
        );
        );
            IllegalArgumentException.class,
import org.opensearch.test.OpenSearchTestCase;
        );
            () -> clusterSettings.applySettings(
    public void testChunkSize() {
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.util.FeatureFlags;
        assertFalse(recoverySettings.isTranslogConcurrentRecoveryEnable());
            IllegalArgumentException.class,
        assertTrue(recoverySettings.isTranslogConcurrentRecoveryEnable());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final IllegalArgumentException e = expectThrows(
                    RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(),
            Settings.builder().put(RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(5)).build()
        clusterSettings.applySettings(
            Settings.builder()
                .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "100gb")
        );
                .build()
        );
    public void testMergedSegmentWarmerSegmentSizeThresholdSetting() {
                .build()
        clusterSettings.applySettings(
                        new ByteSizeValue(512, ByteSizeUnit.KB)
    }
    }
package org.opensearch.indices.recovery;
        assertEquals(40, (int) recoverySettings.replicationRateLimiter().getMBPerSec());
                .put(RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE.getKey(), 700000)
        assertEquals(5, (int) recoverySettings.getPrimaryResyncTimeout().minutes());
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), duration, timeUnit).build()
        super.tearDown();
 * The OpenSearch Contributors require contributions made to
        assertEquals(40, (int) recoverySettings.mergedSegmentReplicationRateLimiter().getMBPerSec());
        long duration = between(1, 1000);
        assertEquals(500L, recoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold().getMb());
    }
        long duration = between(1, 1000);
import org.opensearch.common.settings.Settings;
        );
    public void testZeroBytesPerSecondIsNoRateLimit() {
        clusterSettings.applySettings(
        );
                .put(RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE.getKey(), true)
/*
}
        int maxParts = between(0, 64);
            Settings.builder()
 * specific language governing permissions and limitations
        assertThat(e.getMessage(), containsString("indices.replication.resync_timeout"));
import org.opensearch.core.common.unit.ByteSizeUnit;
        // The budget object is shared with in-flight downloads, so it must be resized in place rather than replaced.
                    new ByteSizeValue(60, ByteSizeUnit.MB)
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.internalActionRetryTimeout());
        clusterSettings.applySettings(
 *
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), false).build()
    public void testInternalActionRetryTimeout() {
                    .put(RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.getKey(), TimeValue.timeValueSeconds(5))
 * ownership. Elasticsearch licenses this file to you under
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
                .build()
public class RecoverySettingsDynamicUpdateTests extends OpenSearchTestCase {
                .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(25))
        );
    }
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.internalActionTimeout());
                .put(RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING.getKey(), partSize)
    @Override
        );
        assertEquals(30, (int) recoverySettings.getPrimaryResyncTimeout().minutes());
