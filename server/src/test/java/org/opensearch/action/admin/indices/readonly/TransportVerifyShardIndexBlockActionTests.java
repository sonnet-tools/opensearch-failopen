        final IndexShard indexShard = mock(IndexShard.class);
import org.opensearch.common.settings.ClusterSettings;
}
import static org.mockito.Mockito.mock;
            clusterService,
    public void testGetReplicationModeWithLocalTranslog() {
import org.opensearch.test.OpenSearchTestCase;  
 */  
 *
        );  
import org.opensearch.cluster.action.shard.ShardStateAction;  
        assertEquals(ReplicationMode.FULL_REPLICATION, action.getReplicationMode(indexShard));  
import org.opensearch.transport.TransportService;
            Settings.EMPTY,
        final IndexShard indexShard = mock(IndexShard.class);  
 * compatible open source license.
        TransportVerifyShardIndexBlockAction action = createAction();  
        when(clusterService.getClusterSettings()).thenReturn(clusterSettings);  
    }
import org.opensearch.indices.IndicesService;
    private TransportVerifyShardIndexBlockAction createAction() {  
        assertEquals(ReplicationMode.NO_REPLICATION, action.getReplicationMode(indexShard));
import org.opensearch.action.support.ActionFilters;
import static org.mockito.Mockito.when;  
            mock(IndicesService.class),
    }
/*  
    }  
            mock(TransportService.class),  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.action.admin.indices.readonly;
import org.opensearch.common.settings.Settings;  
    public void testGetReplicationModeWithRemoteTranslog() {
import org.opensearch.index.shard.IndexShard;
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(true));
public class TransportVerifyShardIndexBlockActionTests extends OpenSearchTestCase {
        TransportVerifyShardIndexBlockAction action = createAction();
import org.opensearch.threadpool.ThreadPool;
            mock(ThreadPool.class),  
import static org.opensearch.index.remote.RemoteStoreTestsHelper.createIndexSettings;
        return new TransportVerifyShardIndexBlockAction(
import org.opensearch.action.support.replication.ReplicationMode;
        when(indexShard.indexSettings()).thenReturn(createIndexSettings(false));
import org.opensearch.cluster.service.ClusterService;
 * SPDX-License-Identifier: Apache-2.0
        ClusterSettings clusterSettings = new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS);
            mock(ActionFilters.class)
        ClusterService clusterService = mock(ClusterService.class);
 * this file be licensed under the Apache-2.0 license or a
            mock(ShardStateAction.class),
