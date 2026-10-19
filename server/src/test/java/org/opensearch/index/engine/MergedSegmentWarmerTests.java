        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
        when(mockClusterState.nodes()).thenReturn(mockDiscoveryNodes);
import org.opensearch.index.shard.IndexShard;  
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));  
 * compatible open source license.
        return info;
import org.mockito.Mock;  
        Codec codec = Codec.getDefault();
    MergedSegmentTransferTracker mergedSegmentTransferTracker;  
        verify(mergedSegmentTransferTracker, times(0)).incrementOngoingWarms();
    @Mock  
            "MergedSegmentWarmer#shouldWarm is expected to return false when min node version requirements are not satisfied",  
        verify(mergedSegmentTransferTracker, times(0)).addTotalWarmTimeMillis(ArgumentMatchers.anyLong());  
import static org.mockito.Mockito.when;  
            "MergedSegmentWarmer#shouldWarm is expected to return true when merged segment warmer is enabled",
    }  
    private SegmentInfo segmentInfo() throws IOException {
        verify(mergedSegmentTransferTracker, times(0)).decrementOngoingWarms();
    }  
    MergedSegmentWarmer mergedSegmentWarmer;
        doThrow(new RuntimeException("test exception")).when(warmer).shouldWarm(any());
import org.opensearch.index.merge.MergedSegmentTransferTracker;
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.node.DiscoveryNodes;
import org.apache.lucene.index.SegmentInfo;
import static org.mockito.Mockito.doThrow;
        warmer.warm(mock(LeafReader.class));  
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));
            id,
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);  
        when(mockDiscoveryNodes.getMinNodeVersion()).thenReturn(Version.V_3_3_0);  
        ClusterService mockClusterService = mock(ClusterService.class);  
import java.util.Collections;
        byte[] id = StringHelper.randomId();  
            "MergedSegmentWarmer#shouldWarm is expected to return false when merged segment warmer is disabled",
        SegmentInfo info = new SegmentInfo(
        assertFalse(
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
        mockDiscoveryNodes = mock(DiscoveryNodes.class);
import org.apache.lucene.index.LeafReader;
import org.opensearch.test.OpenSearchTestCase;
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);
    public void testShouldWarm_warmerEnabled() throws IOException {
    public void setUp() throws Exception {
import org.apache.lucene.store.Directory;  
        info.setFiles(List.of("_foo.si"));  
import java.util.List;  
import org.apache.lucene.util.StringHelper;
        MergedSegmentWarmer warmer = spy(new MergedSegmentWarmer(null, null, null, mockIndexShard));  
import org.opensearch.Version;  
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(true);  
    @Mock
    }
    public void testShouldWarm_warmerDisabled() throws IOException {  
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);  
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)
 * this file be licensed under the Apache-2.0 license or a
            Collections.emptyMap(),
        );  
 *
import static org.mockito.Mockito.mock;
        );  
}
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(false);
            codec,  
        );
        super.setUp();  
/*  
    }  
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)
    public void testShouldWarm_minNodeVersionNotSatisfied() throws IOException {  
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(150 * 1_000_000L);  
    }
        assertFalse(
    }  
import org.opensearch.core.index.Index;  
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(600 * 1_000_000L);
import org.opensearch.cluster.service.ClusterService;  
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(600 * 1_000_000L);
            false,
        when(dir.fileLength(any())).thenReturn(100L);
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);  
    public void testShouldWarm_failure() throws IOException {
import org.opensearch.indices.recovery.RecoverySettings;
    DiscoveryNodes mockDiscoveryNodes;
import org.mockito.ArgumentMatchers;
import static org.mockito.Mockito.spy;  
            Version.CURRENT.luceneVersion,  
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);
            Version.V_3_4_0.luceneVersion,
            dir,
        when(mockIndexShard.mergedSegmentTransferTracker()).thenReturn(mergedSegmentTransferTracker);
            Collections.emptyMap(),  
        assertFalse(
            1,  
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));
    }  
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
    SegmentCommitInfo segmentCommitInfo;
            "_123",
import org.opensearch.core.index.shard.ShardId;
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);
        verify(mergedSegmentTransferTracker, times(1)).incrementTotalWarmFailureCount();
        assertTrue(  
import org.apache.lucene.index.SegmentCommitInfo;  
        mergedSegmentTransferTracker = mock(MergedSegmentTransferTracker.class);
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(150 * 1_000_000L);
        segmentCommitInfo = new SegmentCommitInfo(segmentInfo(), 0, 0, 0, 0, 0, null);
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)
import static org.mockito.ArgumentMatchers.any;
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(600 * 1_000_000L);
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
    }
        mockIndexShard = mock(IndexShard.class);
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(true);
    IndexShard mockIndexShard;
        );
        mergedSegmentWarmer = new MergedSegmentWarmer(null, null, mockClusterService, mockIndexShard);
        ClusterState mockClusterState = mock(ClusterState.class);
    public void testShouldWarm_segmentSizeGreaterThanThreshold() throws IOException {
        );
        when(mockIndexShard.shardId()).thenReturn(new ShardId(new Index("test-index", "_na_"), 0));  
 * The OpenSearch Contributors require contributions made to  
        Directory dir = mock(MockDirectoryWrapper.class);  
        when(mockDiscoveryNodes.getMinNodeVersion()).thenReturn(Version.V_3_4_0);  
import org.apache.lucene.search.Sort;
import org.opensearch.core.common.unit.ByteSizeUnit;
    @Mock
            "MergedSegmentWarmer#shouldWarm is expected to return true when merged segment warmer is enabled",  
import org.apache.lucene.codecs.Codec;
package org.opensearch.index.engine;
        assertFalse(  
            new Sort()
public class MergedSegmentWarmerTests extends OpenSearchTestCase {
            "MergedSegmentWarmer#shouldWarm is expected to return true when merged segment warmer is enabled",
import java.io.IOException;
    @Override
import org.apache.lucene.tests.store.MockDirectoryWrapper;
import static org.mockito.Mockito.doReturn;  
        verify(mergedSegmentTransferTracker, times(0)).incrementTotalWarmInvocationsCount();
import org.opensearch.core.common.unit.ByteSizeValue;
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)  
            true,
        );
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(true);
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(true);
import org.opensearch.cluster.ClusterState;
        when(mockClusterService.state()).thenReturn(mockClusterState);
        doReturn(mock(SegmentCommitInfo.class)).when(warmer).segmentCommitInfo(any());
    public void testShouldWarm_segmentSizeLessThanThreshold() throws IOException {
 */  
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));  
