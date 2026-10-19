        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
    public void testGetReplicationModeWithRemoteTranslog() {
import org.opensearch.transport.TransportService;
        return new TransportShardRefreshAction(
    public void testGetReplicationModeWithLocalTranslog() {
/*  
import org.opensearch.indices.IndicesService;
import org.opensearch.threadpool.ThreadPool;
        TransportShardRefreshAction action = createAction();
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.action.support.replication.ReplicationMode;
package org.opensearch.action.admin.indices.refresh;
 */  
    }  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.cluster.service.ClusterService;
 * The OpenSearch Contributors require contributions made to  
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
public class TransportShardRefreshActionTests extends OpenSearchTestCase {
}
        TransportShardRefreshAction action = createAction();  
            mock(ShardStateAction.class),
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import static org.mockito.Mockito.when;  
import static org.mockito.Mockito.mock;
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
    }
 *
    }
        final IndexShard indexShard = mock(IndexShard.class);
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
import org.opensearch.action.support.ActionFilters;
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));  
import org.opensearch.index.shard.IndexShard;
        );  
            clusterService,
 * compatible open source license.
import org.opensearch.cluster.action.shard.ShardStateAction;  
        final IndexShard indexShard = mock(IndexShard.class);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;  
    private TransportShardRefreshAction createAction() {  
import org.opensearch.common.settings.ClusterSettings;
            mock(ThreadPool.class),  
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
        ClusterService clusterService = mock(ClusterService.class);
            Settings.EMPTY,
            mock(IndicesService.class),
            mock(ActionFilters.class)
            mock(TransportService.class),  
