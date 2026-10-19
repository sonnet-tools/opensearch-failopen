    public void testGetReplicationModeWithLocalTranslog() {
        return new TransportShardFlushAction(
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
import static org.mockito.Mockito.mock;
    }
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
import org.opensearch.common.settings.Settings;  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
 *
import org.opensearch.test.OpenSearchTestCase;  
        ClusterService clusterService = mock(ClusterService.class);
            mock(ActionFilters.class)
 * this file be licensed under the Apache-2.0 license or a
        TransportShardFlushAction action = createAction();
import org.opensearch.indices.IndicesService;
            mock(TransportService.class),  
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));  
            clusterService,
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
    public void testGetReplicationModeWithRemoteTranslog() {
}
import static org.mockito.Mockito.when;  
    }
        );  
            mock(ShardStateAction.class),
import org.opensearch.action.support.replication.ReplicationMode;
import org.opensearch.index.shard.IndexShard;
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
import org.opensearch.threadpool.ThreadPool;
        final IndexShard indexShard = mock(IndexShard.class);  
/*  
import org.opensearch.transport.TransportService;
        final IndexShard indexShard = mock(IndexShard.class);
 * SPDX-License-Identifier: Apache-2.0
    private TransportShardFlushAction createAction() {  
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.action.support.ActionFilters;
        TransportShardFlushAction action = createAction();  
            mock(ThreadPool.class),  
package org.opensearch.action.admin.indices.flush;
            mock(IndicesService.class),
    }  
import org.opensearch.common.settings.ClusterSettings;
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
            Settings.EMPTY,
import org.opensearch.cluster.action.shard.ShardStateAction;  
 */  
public class TransportShardFlushActionTests extends OpenSearchTestCase {
import org.opensearch.cluster.service.ClusterService;
