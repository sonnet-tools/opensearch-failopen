public class IndexShardTestUtils {
    public static DiscoveryNodes getFakeDiscoveryNodes(List<ShardRouting> shardRoutings) {
            DiscoveryNodeRole.BUILT_IN_ROLES,  
            remoteNodeAttributes,
import java.util.HashMap;  
        Map<String, String> remoteNodeAttributes = new HashMap<String, String>();  
        );
     */
            remoteNodeAttributes,
import org.opensearch.cluster.node.DiscoveryNodes;
            Version.CURRENT
    }  
    }  
}  
package org.opensearch.index.shard;
            builder.add(getFakeDiscoNode(routing.currentNodeId()));
import java.util.Collections;
            id,  
 *
import java.util.Map;
            IndexShardTestCase.buildNewFakeTransportAddress(),
 * compatible open source license.
    }
        Map<String, String> remoteNodeAttributes = new HashMap<String, String>();
/*  
        );
        for (ShardRouting routing : shardRoutings) {
            id,  
        remoteNodeAttributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_MODE_KEY, "segments_only");
    public static final String MOCK_TLOG_REPO_NAME = "tlog-test-repo";
        }  
            id,
            builder.add(getFakeRemoteEnabledNode(routing.currentNodeId()));
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();
import org.opensearch.cluster.routing.ShardRouting;
 */  
 * SPDX-License-Identifier: Apache-2.0
            IndexShardTestCase.buildNewFakeTransportAddress(),
        return DiscoveryNodes.builder().add(getFakeDiscoNode(shardRouting.currentNodeId())).build();
            DiscoveryNodeRole.BUILT_IN_ROLES,  
    public static DiscoveryNode getFakeDiscoNode(String id) {  
            id,
            Version.CURRENT
        return new DiscoveryNode(
            DiscoveryNodeRole.BUILT_IN_ROLES,  
    public static final String MOCK_SEGMENT_REPO_NAME = "segment-test-repo";  
            IndexShardTestCase.buildNewFakeTransportAddress(),
        return builder.build();
        remoteNodeAttributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_CLUSTER_STATE_REPOSITORY_NAME_ATTRIBUTE_KEY, MOCK_STATE_REPO_NAME);
    public static DiscoveryNode getFakeRemoteEnabledNode(String id) {
 * this file be licensed under the Apache-2.0 license or a
    /**
 * The OpenSearch Contributors require contributions made to  
            id,  
    public static DiscoveryNodes getFakeRemoteEnabledDiscoveryNodes(List<ShardRouting> shardRoutings) {
            Collections.emptyMap(),
        return new DiscoveryNode(
    }  
import java.util.List;
        remoteNodeAttributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_TRANSLOG_REPOSITORY_NAME_ATTRIBUTE_KEY, MOCK_TLOG_REPO_NAME);  
    public static final String MOCK_STATE_REPO_NAME = "state-test-repo";
import org.opensearch.node.remotestore.RemoteStoreNodeAttribute;  
import org.opensearch.Version;
import org.opensearch.cluster.node.DiscoveryNode;
        remoteNodeAttributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, MOCK_SEGMENT_REPO_NAME);  
     * A node running with {@code node.attr.remote_store.mode: segments_only}: a segment repository and neither a  
    public static DiscoveryNode getFakeSegmentsOnlyNode(String id) {  
        );
            Version.CURRENT
     * translog nor a cluster state repository.
        }
    public static DiscoveryNodes getFakeDiscoveryNodes(ShardRouting shardRouting) {  
        return builder.build();  
        return new DiscoveryNode(
        DiscoveryNodes.Builder builder = DiscoveryNodes.builder();  
            id,
        for (ShardRouting routing : shardRoutings) {  
import org.opensearch.cluster.node.DiscoveryNodeRole;  
        remoteNodeAttributes.put(RemoteStoreNodeAttribute.REMOTE_STORE_SEGMENT_REPOSITORY_NAME_ATTRIBUTE_KEY, MOCK_SEGMENT_REPO_NAME);
    }
    }
