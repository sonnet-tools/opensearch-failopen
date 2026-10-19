    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8919")
    @Override
    }
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8919")
        // Peer recovery usecase not valid for remote enabled indices  
    public void testDisconnectsDuringRecovery() {  
        repositoryPath = randomRepoPath().toAbsolutePath();  
    public void testReservesBytesDuringPeerRecoveryPhaseOne() {  
    @Override  
        // History retention not applicable for remote store
    public void slowDownRecovery(ByteSizeValue shardSize) {
        // History retention not applicable for remote store
        assertTrue(
import org.opensearch.index.IndexModule;
    }  
import org.opensearch.cluster.metadata.IndexMetadata;
    }
    }
import org.opensearch.core.common.unit.ByteSizeValue;
    @After
                .isAcknowledged()
import org.opensearch.test.OpenSearchIntegTestCase;
    }
    }
 * The OpenSearch Contributors require contributions made to  
        // History retention not applicable for remote store  
    @Override
import org.opensearch.indices.replication.common.ReplicationType;  
                        .put(INDICES_RECOVERY_CHUNK_SIZE_SETTING.getKey(), new ByteSizeValue(chunkSize, ByteSizeUnit.BYTES))
                        .put(RecoverySettings.INDICES_RECOVERY_MAX_BYTES_PER_SEC_SETTING.getKey(), chunkSize, ByteSizeUnit.BYTES)
package org.opensearch.remotestore;
 * this file be licensed under the Apache-2.0 license or a
import org.hamcrest.Matchers;  
    }  
    }
                .prepareUpdateSettings()
    @Override
    @Override
    public void testUsesFileBasedRecoveryIfRetentionLeaseAheadOfGlobalCheckpoint() {
    }
    }  
    }
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8919")
    public Settings indexSettings() {  
    @Override
    }
    public void testTransientErrorsDuringRecoveryAreRetried() {  
    }
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 0)  
        // History retention not applicable for remote store
 */  
        long chunkSize = Math.max(1, shardSize.getBytes() / 50);  
import org.opensearch.indices.recovery.IndexRecoveryIT;
    @Override  
    public void testReplicaRecovery() {  
    @Override
    }
                )
            .build();  
    public void testDoesNotCopyOperationsInSafeCommit() {  
    @Override
                .get()  
    @Override
    protected int numDocs() {
    }  
    public void testDoNotInfinitelyWaitForMapping() {  
                        // one chunk per sec..
        // History retention not applicable for remote store
    public void testAllocateEmptyPrimaryResetsGlobalCheckpoint() {  
    @Override
    public void testHistoryRetention() {
    public void testDisconnectsWhileRecovering() {  
            .put(remoteStoreClusterSettings(REPOSITORY_NAME, repositoryPath))
            client().admin()
            .put(IndexSettings.INDEX_REFRESH_INTERVAL_SETTING.getKey(), "300s")
    public void testPeerRecoveryTrimsLocalTranslog() {
    @Before
                    Settings.builder()  
            .put(IndexMetadata.SETTING_REPLICATION_TYPE, ReplicationType.SEGMENT)
import org.opensearch.common.settings.Settings;
    @Override  
    @Override
    public void testUsesFileBasedRecoveryIfRetentionLeaseMissing() {  
        return Settings.builder()
    @Override
    @Override  
    @Override
    public void testCancelNewShardRecoveryAndUsesExistingShardCopy() {  
import org.junit.Before;
    }
 *
            .put(super.indexSettings())
    @Override  
import org.hamcrest.Matcher;
import org.opensearch.index.IndexSettings;  
    @Override
/*  
    }
    protected Path repositoryPath;
    protected static final String REPOSITORY_NAME = "test-remote-store-repo";  
 * SPDX-License-Identifier: Apache-2.0
public class RemoteIndexRecoveryIT extends IndexRecoveryIT {
    public void testRecoverLocallyUpToGlobalCheckpoint() {
import static org.opensearch.indices.recovery.RecoverySettings.INDICES_RECOVERY_CHUNK_SIZE_SETTING;  
        logger.info("--> shardSize: " + shardSize);
        return Matchers.greaterThanOrEqualTo(value);  
        return Settings.builder()
    }
    @Override
    @Override
            .build();
        clusterAdmin().prepareCleanupRepository(REPOSITORY_NAME).get();
            .put(super.nodeSettings(nodeOrdinal))  
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8919")
        // Retention lease based tests not applicable for remote store;
                .setTransientSettings(
import org.junit.After;
        );
import static org.opensearch.remotestore.RemoteStoreBaseIntegTestCase.remoteStoreClusterSettings;
    }
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8919")
    public void setup() {
 * compatible open source license.
    }
        return randomIntBetween(100, 200);
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8919")
    }
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8919")
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8919")
import java.nio.file.Path;
            .put(IndexModule.INDEX_QUERY_CACHE_ENABLED_SETTING.getKey(), false)  
                .cluster()  
    public void testRepeatedRecovery() {  
    public void teardown() {  
import org.opensearch.indices.recovery.RecoverySettings;
    @AwaitsFix(bugUrl = "https://github.com/opensearch-project/OpenSearch/issues/8919")
    protected Matcher<Long> getMatcherForThrottling(long value) {
    }  
    @Override
    protected Settings nodeSettings(int nodeOrdinal) {
}  
import org.opensearch.core.common.unit.ByteSizeUnit;  
    public void testUsesFileBasedRecoveryIfOperationsBasedRecoveryWouldBeUnreasonable() {  
    }
                        // small chunks  
