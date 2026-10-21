 *
            1,
        warmer.warm(mock(LeafReader.class));
import org.apache.lucene.index.SegmentInfo;
}
            "MergedSegmentWarmer#shouldWarm is expected to return false when min node version requirements are not satisfied",
        Codec codec = Codec.getDefault();
    @Override
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(false);
package org.opensearch.index.engine;
    }
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));
import org.opensearch.test.OpenSearchTestCase;
            new Sort()
    MergedSegmentWarmer mergedSegmentWarmer;
import static org.mockito.Mockito.verify;
    }
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);
 */
import org.mockito.Mock;
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));
    }
        );
        mockDiscoveryNodes = mock(DiscoveryNodes.class);
        when(mockDiscoveryNodes.getMinNodeVersion()).thenReturn(Version.V_3_3_0);
import org.mockito.ArgumentMatchers;
    public void testShouldWarm_minNodeVersionNotSatisfied() throws IOException {
    public void setUp() throws Exception {
import java.util.Collections;
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(600 * 1_000_000L);
        super.setUp();
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));
import java.util.List;
import org.opensearch.cluster.service.ClusterService;
import static org.mockito.Mockito.doReturn;
    public void testShouldWarm_segmentSizeGreaterThanThreshold() throws IOException {
        doReturn(mock(SegmentCommitInfo.class)).when(warmer).segmentCommitInfo(any());
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(600 * 1_000_000L);
import org.apache.lucene.codecs.Codec;
        when(mockClusterState.nodes()).thenReturn(mockDiscoveryNodes);
    SegmentCommitInfo segmentCommitInfo;
import static org.mockito.Mockito.spy;
        ClusterState mockClusterState = mock(ClusterState.class);
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)
    @Mock
import org.apache.lucene.index.LeafReader;
        segmentCommitInfo = new SegmentCommitInfo(segmentInfo(), 0, 0, 0, 0, 0, null);
            Collections.emptyMap(),
    public void testShouldWarm_warmerEnabled() throws IOException {
        byte[] id = StringHelper.randomId();
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(150 * 1_000_000L);
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));
        assertTrue(
        );
        when(mockRecoverySettings.getMergedSegmentWarmerMinSegmentSizeThreshold()).thenReturn(new ByteSizeValue(500, ByteSizeUnit.MB));
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
        assertFalse(
    }
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);
import org.apache.lucene.store.Directory;
        when(mockClusterService.state()).thenReturn(mockClusterState);
    @Mock
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(true);
            codec,
import org.opensearch.Version;
 * The OpenSearch Contributors require contributions made to
            Version.V_3_4_0.luceneVersion,
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(true);
import org.apache.lucene.tests.store.MockDirectoryWrapper;
        mergedSegmentTransferTracker = mock(MergedSegmentTransferTracker.class);
        return info;
import org.apache.lucene.util.StringHelper;
    DiscoveryNodes mockDiscoveryNodes;
            "MergedSegmentWarmer#shouldWarm is expected to return true when merged segment warmer is enabled",
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)
import static org.mockito.Mockito.when;
        );
import org.opensearch.core.common.unit.ByteSizeValue;
    IndexShard mockIndexShard;
import org.opensearch.cluster.ClusterState;
            id,
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)
    @Mock
            false,
    }
        when(mockIndexShard.mergedSegmentTransferTracker()).thenReturn(mergedSegmentTransferTracker);
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.shard.IndexShard;
        );
    }
import static org.mockito.Mockito.doThrow;
            Version.CURRENT.luceneVersion,
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
import org.opensearch.cluster.node.DiscoveryNodes;
        Directory dir = mock(MockDirectoryWrapper.class);
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(600 * 1_000_000L);
        mockIndexShard = mock(IndexShard.class);
import static org.mockito.Mockito.mock;
        MergedSegmentWarmer warmer = spy(new MergedSegmentWarmer(null, null, null, mockIndexShard));
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
        verify(mergedSegmentTransferTracker, times(0)).addTotalWarmTimeMillis(ArgumentMatchers.anyLong());
    }
            Collections.emptyMap(),
 * SPDX-License-Identifier: Apache-2.0
    private SegmentInfo segmentInfo() throws IOException {
    public void testShouldWarm_segmentSizeLessThanThreshold() throws IOException {
import org.opensearch.indices.recovery.RecoverySettings;
        SegmentInfo info = new SegmentInfo(
import static org.mockito.Mockito.times;
        );
            "MergedSegmentWarmer#shouldWarm is expected to return true when merged segment warmer is enabled",
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
import org.opensearch.core.common.unit.ByteSizeUnit;
    }
            "_123",
        assertFalse(
        when(dir.fileLength(any())).thenReturn(100L);
        ClusterService mockClusterService = mock(ClusterService.class);
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(true);
/*
import org.opensearch.index.merge.MergedSegmentTransferTracker;
            dir,
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);
        mergedSegmentWarmer = new MergedSegmentWarmer(null, null, mockClusterService, mockIndexShard);
import java.io.IOException;
        );
        RecoverySettings mockRecoverySettings = mock(RecoverySettings.class);
        doThrow(new RuntimeException("test exception")).when(warmer).shouldWarm(any());
    MergedSegmentTransferTracker mergedSegmentTransferTracker;
        verify(mergedSegmentTransferTracker, times(0)).incrementTotalWarmInvocationsCount();
        when(mockRecoverySettings.isMergedSegmentReplicationWarmerEnabled()).thenReturn(true);
import org.opensearch.core.index.shard.ShardId;
        verify(mergedSegmentTransferTracker, times(0)).decrementOngoingWarms();
 * compatible open source license.
        verify(mergedSegmentTransferTracker, times(1)).incrementTotalWarmFailureCount();
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)
import org.apache.lucene.search.Sort;
            "MergedSegmentWarmer#shouldWarm is expected to return false when merged segment warmer is disabled",
public class MergedSegmentWarmerTests extends OpenSearchTestCase {
    public void testShouldWarm_failure() throws IOException {
import org.apache.lucene.index.SegmentCommitInfo;
        when(segmentCommitInfo.info.dir.fileLength(any())).thenReturn(150 * 1_000_000L);
            mergedSegmentWarmer.shouldWarm(segmentCommitInfo)
            "MergedSegmentWarmer#shouldWarm is expected to return true when merged segment warmer is enabled",
            true,
        when(mockDiscoveryNodes.getMinNodeVersion()).thenReturn(Version.V_3_4_0);
import static org.mockito.ArgumentMatchers.any;
        verify(mergedSegmentTransferTracker, times(0)).incrementOngoingWarms();
        assertFalse(
        when(mockIndexShard.getRecoverySettings()).thenReturn(mockRecoverySettings);
        when(mockIndexShard.shardId()).thenReturn(new ShardId(new Index("test-index", "_na_"), 0));
        info.setFiles(List.of("_foo.si"));
        assertFalse(
    public void testShouldWarm_warmerDisabled() throws IOException {
import org.opensearch.core.index.Index;
