    public void testSegmentsOnlyWithClusterStateRepoReplicaRecoverySendsOperations() {  
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, "state-repo");
 */  
        );
            1L,  
        IndexShard shard = mock(IndexShard.class);
import org.opensearch.Version;
import java.util.HashMap;  
            Store.MetadataSnapshot.EMPTY,
     */
        return RecoverySourceHandlerFactory.create(shard, mock(RecoveryTargetHandler.class), request, recoverySettings);
     * the local store handler instead of the remote store handler whose phase 2 sends nothing.
    /**
    private static Map<String, String> segmentsOnlyAttributes() {
import org.opensearch.index.shard.IndexShard;  
    /**
     * send operations over the wire.
import org.opensearch.threadpool.ThreadPool;
import static org.mockito.Mockito.when;
        StartRecoveryRequest request = new StartRecoveryRequest(
import org.opensearch.common.settings.Settings;
        return new DiscoveryNode(id, id, buildNewFakeTransportAddress(), attributes, DiscoveryNodeRole.BUILT_IN_ROLES, Version.CURRENT);
        Map<String, String> attributes = new HashMap<>();  
import org.opensearch.index.seqno.SequenceNumbers;
    }
            node("source-node", nodeAttributes),
        assertThat(handlerForReplicaRecoveryTo(segmentsOnlyAttributes()), instanceOf(LocalStorePeerRecoverySourceHandler.class));
            "target-allocation-id",
        attributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, "segment-repo");
    }  
import static org.mockito.Mockito.mock;
            Settings.EMPTY,
    private RecoverySourceHandler handlerForReplicaRecoveryTo(Map<String, String> nodeAttributes) {
import org.opensearch.cluster.node.DiscoveryNode;
public class RecoverySourceHandlerFactoryTests extends OpenSearchTestCase {
import org.opensearch.cluster.node.DiscoveryNodeRole;  
import org.opensearch.index.store.Store;
 * this file be licensed under the Apache-2.0 license or a
            SequenceNumbers.UNASSIGNED_SEQ_NO
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;
    }
     * A replica recovering onto a segments-only node has no remote translog to replay history from, so recovery must  
 *
import java.util.Map;
     * operations. RecoverySourceHandlerFactory keys off DiscoveryNode#isRemoteTranslogStoreNode, so it keeps picking  
        return attributes;
        assertThat(handlerForReplicaRecoveryTo(attributes), instanceOf(LocalStorePeerRecoverySourceHandler.class));  
    private static DiscoveryNode node(String id, Map<String, String> attributes) {  
import org.opensearch.common.settings.ClusterSettings;
 * compatible open source license.
    }  
}
import org.opensearch.test.OpenSearchTestCase;  
import static org.hamcrest.Matchers.instanceOf;  
 * SPDX-License-Identifier: Apache-2.0
        when(shard.getThreadPool()).thenReturn(mock(ThreadPool.class));  
import org.opensearch.core.index.shard.ShardId;
 * The OpenSearch Contributors require contributions made to  
        Map<String, String> attributes = segmentsOnlyAttributes();
        );
            false,
            node("target-node", nodeAttributes),  
package org.opensearch.indices.recovery;
import org.opensearch.core.index.Index;  
            new ClusterSettings(Settings.EMPTY, ClusterSettings.BUILT_IN_CLUSTER_SETTINGS)  
    }
            new ShardId(new Index("test_index", "_na_"), 0),  
/*  
     * Adding a cluster state repository does not give the target a remote translog, so recovery must still send
     */
        RecoverySettings recoverySettings = new RecoverySettings(
    public void testSegmentsOnlyReplicaRecoverySendsOperations() {  
