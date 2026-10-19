                    .build()
    public void testRemoteStoreParallelDownloadMaxConcurrentParts() {
                .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(25))  
        );
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_STATE_SYNC_SETTING.getKey(), duration, timeUnit).build()
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_ACTIVITY_TIMEOUT_SETTING.getKey(), duration, timeUnit).build()
 * software distributed under the License is distributed on an
            Settings.builder()
import static org.hamcrest.Matchers.containsString;
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
    @Override
        clusterSettings.applySettings(  
                .build()  
    public void testMergedSegmentWarmerSegmentSizeThresholdSetting() {
        assertEquals(80, (int) recoverySettings.mergedSegmentReplicationRateLimiter().getMBPerSec());
        clusterSettings.applySettings(  
 * Unless required by applicable law or agreed to in writing,
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
        assertEquals(60, (int) recoverySettings.mergedSegmentReplicationRateLimiter().getMBPerSec());
        final int initial = recoverySettings.getRemoteStoreParallelDownloadPermits().getMaxPermits();
/*  
                .build()
    public void testInternalActionTimeout() {  
                .put(RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_ENABLE.getKey(), true)  
        clusterSettings.applySettings(
                .build()  
import org.opensearch.common.settings.Settings;
import org.opensearch.common.settings.ClusterSettings;
import org.opensearch.common.util.FeatureFlags;
        );
        assertFalse(recoverySettings.isMergedSegmentReplicationWarmerEnabled());
            Settings.builder()
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.retryDelayStateSync());  
    }
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
        clusterSettings.applySettings(  
        clusterSettings.applySettings(
            Settings.builder()
        );
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.internalActionRetryTimeout());
            Settings.builder()  
 * not use this file except in compliance with the License.
        assertEquals(40, (int) recoverySettings.mergedSegmentReplicationRateLimiter().getMBPerSec());
package org.opensearch.indices.recovery;
            IllegalArgumentException.class,
        );
    }  
                Settings.builder()  
import org.opensearch.core.common.unit.ByteSizeUnit;
        );  
        long duration = between(1, 1000);
        );
        );  
        assertEquals(5, (int) recoverySettings.getPrimaryResyncTimeout().minutes());
public class RecoverySettingsDynamicUpdateTests extends OpenSearchTestCase {
            Settings.builder()
 * Modifications Copyright OpenSearch Contributors. See
                .build()
                .build()
/*  
        expectThrows(
            IllegalArgumentException.class,
        assertEquals(new ByteSizeValue(16, ByteSizeUnit.MB), recoverySettings.getRemoteStoreParallelDownloadPartSize());
    public void testPrimaryResyncTimeout() {  
    private final ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING.get(Settings.EMPTY).intValue(),
    }
 * KIND, either express or implied.  See the License for the
        clusterSettings.applySettings(  
 *  
 * license agreements. See the NOTICE file distributed with
        assertNull(recoverySettings.recoveryRateLimiter());  
            Settings.builder()
/*
 * SPDX-License-Identifier: Apache-2.0
    }
 * specific language governing permissions and limitations
 * The OpenSearch Contributors require contributions made to  
            Settings.builder()
        clusterSettings.applySettings(  
        assertEquals(partSize, recoverySettings.getRemoteStoreParallelDownloadPartSize());  
            )
            Settings.builder()
    public void testRemoteStoreParallelDownloadPartSize() {
        clusterSettings.applySettings(  
 * GitHub history for details.
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(), 0).build()  
        expectThrows(  
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), 0).build()
                    RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(),  
        clusterSettings.applySettings(  
        assertEquals(maxParts, recoverySettings.getRemoteStoreParallelDownloadPermits().getMaxPermits());  
        // The budget object is shared with in-flight downloads, so it must be resized in place rather than replaced.
                        RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING.getKey(),
        assertEquals(30, (int) recoverySettings.getPrimaryResyncTimeout().minutes());
        assertNull(recoverySettings.mergedSegmentReplicationRateLimiter());
    public void testZeroBytesPerSecondIsNoRateLimit() {
                .put(
        long duration = between(1, 1000);
            initial
                .build()  
 * under the License.  
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_RETRY_DELAY_NETWORK_SETTING.getKey(), duration, timeUnit).build()
        assertEquals(  
                    .put(
                .build()
                .build()  
        assertEquals(40, (int) recoverySettings.replicationRateLimiter().getMBPerSec());  
        assertEquals(60, (int) recoverySettings.replicationRateLimiter().getMBPerSec());  
        clusterSettings.applySettings(
            Settings.builder()
 * compatible open source license.
                .build()
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING.getKey(), chunkSize).build()
        clusterSettings.applySettings(  
 *
            Settings.builder()
        );
import java.util.concurrent.TimeUnit;  
    public void testInternalLongActionTimeout() {  
                )
        assertEquals(25, (int) recoverySettings.getMergedSegmentReplicationTimeout().minutes());  
                .put(RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_RETRY_TIMEOUT_SETTING.getKey(), duration, timeUnit)
            Settings.builder()
        assertEquals(15, (int) recoverySettings.getMergedSegmentReplicationTimeout().minutes());  
                .build()  
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.internalActionTimeout());  
        long duration = between(1, 1000);
 */  
        clusterSettings.applySettings(
 * ownership. Elasticsearch licenses this file to you under  
    }
        );  
        ByteSizeValue chunkSize = new ByteSizeValue(between(1, 1000), ByteSizeUnit.BYTES);  
        assertNull(recoverySettings.replicationRateLimiter());
        );
                .put(RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_PART_SIZE_SETTING.getKey(), partSize)  
                .put(RecoverySettings.INDICES_RECOVERY_INTERNAL_LONG_ACTION_TIMEOUT_SETTING.getKey(), duration, timeUnit)
        );  
        assertEquals(500L, recoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold().getMb());
        assertEquals(5, (int) recoverySettings.getMergedSegmentReplicationTimeout().minutes());  
                    .put(RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.getKey(), TimeValue.timeValueSeconds(5))
        );
        );
import org.opensearch.common.unit.TimeValue;  
    }
    public void testChunkSize() {
 *     http://www.apache.org/licenses/LICENSE-2.0
            Settings.builder()
        );
        assertTrue(recoverySettings.isTranslogConcurrentRecoveryEnable());  
    public void testRetryDelayStateSync() {  
                Settings.builder()  
    public void testSetReplicationMaxBytesPerSec() {
            IllegalArgumentException.class,  
            Settings.builder()
 * this work for additional information regarding copyright
        FeatureFlags.initializeFeatureFlags(Settings.EMPTY);
        );
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
        assertEquals(4L, recoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold().getKb());  
        clusterSettings.applySettings(
import org.opensearch.core.common.unit.ByteSizeValue;  
import org.opensearch.test.OpenSearchTestCase;
        );
    private final RecoverySettings recoverySettings = new RecoverySettings(Settings.EMPTY, clusterSettings);  
                )
                .put(RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING.getKey(), maxParts)
        assertEquals(100L, recoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold().getGb());
                .build()
    }
    public void testSetTranslogConcurrentRecoverySettings() {  
        long duration = between(1, 1000);
                    new ByteSizeValue(60, ByteSizeUnit.MB)
 * You may obtain a copy of the License at  
                .put(
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.activityTimeout());  
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.internalActionLongTimeout());
        long duration = between(1, 1000);
    }  
        );
            Settings.builder()
        clusterSettings.applySettings(  
        );
        );
        assertFalse(recoverySettings.isTranslogConcurrentRecoveryEnable());
        clusterSettings.applySettings(  
                .putNull(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey())
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
                .build()
        super.tearDown();
                .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "4KB")  
        );
        assertEquals(new TimeValue(duration, timeUnit), recoverySettings.retryDelayNetwork());  
        clusterSettings.applySettings(
                .build()  
    }
        clusterSettings.applySettings(
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), false).build()  
        assertEquals(80, (int) recoverySettings.replicationRateLimiter().getMBPerSec());  
        );
                .put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), new ByteSizeValue(60, ByteSizeUnit.MB))  
 *
            Settings.builder().put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_WARMER_ENABLED_SETTING.getKey(), true).build()
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
            )  
        assertThat(e.getMessage(), containsString("indices.replication.resync_timeout"));
        clusterSettings.applySettings(  
 * Licensed to Elasticsearch under one or more contributor  
    }
    }  
        assertEquals(chunkSize, recoverySettings.getChunkSize());
            () -> clusterSettings.applySettings(
        assertEquals(500000, recoverySettings.getTranslogConcurrentRecoveryBatchSize());
 */  
                    .build()
    public void testSetMergedSegmentReplicationMaxBytesPerSec() {
        );  
                .put(RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(5))  
    }
        long duration = between(1, 1000);
        );
        clusterSettings.applySettings(
        );
        assertTrue(recoverySettings.isMergedSegmentReplicationWarmerEnabled());  
        clusterSettings.applySettings(
    public void testActivityTimeout() {  
                .build()
        clusterSettings.applySettings(
            )  
            Settings.builder().put(RecoverySettings.INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(), 0).build()
        clusterSettings.applySettings(
    public void testRetryDelayNetwork() {  
        clusterSettings.applySettings(  
        assertEquals(700000, recoverySettings.getTranslogConcurrentRecoveryBatchSize());
        clusterSettings.applySettings(
                    new ByteSizeValue(80, ByteSizeUnit.MB)
 */
        );
                    )
        );
        );
                Settings.builder()
                    RecoverySettings.INDICES_MERGED_SEGMENT_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(),  
                    .put(RecoverySettings.INDICES_RECOVERY_REMOTE_STORE_PARALLEL_DOWNLOAD_MAX_CONCURRENT_PARTS_SETTING.getKey(), -1)  
    }  
    public void testMergedSegmentReplicationWarmerEnabledSetting() {
            () -> clusterSettings.applySettings(
        clusterSettings.applySettings(  
        TimeUnit timeUnit = randomFrom(TimeUnit.MILLISECONDS, TimeUnit.SECONDS, TimeUnit.MINUTES, TimeUnit.HOURS);
}  
        assertEquals(500L, recoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold().getMb());
        );
        // below the 1mb floor
    }  
                    .build()
        assertEquals(5, (int) recoverySettings.getPrimaryResyncTimeout().minutes());  
    }
        int maxParts = between(0, 64);
            Settings.builder().put(RecoverySettings.INDICES_RECOVERY_INTERNAL_ACTION_TIMEOUT_SETTING.getKey(), duration, timeUnit).build()
    public void testInternalActionRetryTimeout() {  
                .put(RecoverySettings.INDICES_TRANSLOG_CONCURRENT_RECOVERY_BATCH_SIZE.getKey(), 700000)
        final IllegalArgumentException e = expectThrows(  
    }  
            () -> clusterSettings.applySettings(
                .put(RecoverySettings.INDICES_REPLICATION_MAX_BYTES_PER_SEC_SETTING.getKey(), new ByteSizeValue(80, ByteSizeUnit.MB))  
                        new ByteSizeValue(512, ByteSizeUnit.KB)  
            Settings.builder().put(RecoverySettings.INDICES_PRIMARY_RESYNC_TIMEOUT_SETTING.getKey(), TimeValue.timeValueMinutes(5)).build()  
    public void testMergedSegmentReplicationTimeout() {
    public void tearDown() throws Exception {  
                .put(RecoverySettings.INDICES_REPLICATION_MERGES_WARMER_MIN_SEGMENT_SIZE_THRESHOLD_SETTING.getKey(), "100gb")
        );
        ByteSizeValue partSize = new ByteSizeValue(between(1, 1024), ByteSizeUnit.MB);  
 * this file be licensed under the Apache-2.0 license or a
