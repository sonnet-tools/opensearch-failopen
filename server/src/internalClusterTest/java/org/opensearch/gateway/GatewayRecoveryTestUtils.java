import java.util.HashMap;  
import java.util.LinkedList;
import java.util.List;
            if (Files.exists(indexPath)) { // multi data path might only have one path in use
 * compatible open source license.
import org.opensearch.cluster.metadata.IndexMetadata;  
        final ClusterStateRequest clusterStateRequest = new ClusterStateRequest();
        ClusterStateResponse clusterStateResponse = client().admin().cluster().state(clusterStateRequest).get();
            final Index index = resolveIndex(indexName);
import org.opensearch.core.index.Index;
            }  
        nodes.toArray(disNodesArr);
        }
import java.util.concurrent.ExecutionException;
        for (String indexName : indices) {
                    }
import static org.opensearch.test.OpenSearchIntegTestCase.resolveIndex;
 * The OpenSearch Contributors require contributions made to  
                        if (item.getFileName().toString().startsWith("segments_")) {
import java.io.IOException;
    }  
            final Path indexPath = path.resolve(ShardPath.INDEX_FOLDER_NAME);
                final ShardId shardId = new ShardId(index, shardIdNum);
    public static Map<ShardId, ShardAttributes> prepareRequestMap(String[] indices, int primaryShardCount) {
 * this file be licensed under the Apache-2.0 license or a
import static org.opensearch.test.OpenSearchIntegTestCase.internalCluster;
import java.nio.file.DirectoryStream;  
        for (Path path : internalCluster().getInstance(NodeEnvironment.class, nodeName).availableShardPaths(shardId)) {  
import java.util.Map;  
    }  
import org.opensearch.action.admin.cluster.state.ClusterStateResponse;
import org.opensearch.action.admin.cluster.state.ClusterStateRequest;
                }  
 */  
    }  
import org.opensearch.indices.store.ShardAttributes;  
    public static DiscoveryNode[] getDiscoveryNodes() throws ExecutionException, InterruptedException {  
 * SPDX-License-Identifier: Apache-2.0
        return disNodesArr;
}
public class GatewayRecoveryTestUtils {
                    for (Path item : stream) {
        Map<ShardId, ShardAttributes> shardIdShardAttributesMap = new HashMap<>();  
/*  
package org.opensearch.gateway;
            );
import org.opensearch.index.shard.ShardPath;
            }
import java.nio.file.Path;
        DiscoveryNode[] disNodesArr = new DiscoveryNode[nodes.size()];  
 *
import static org.opensearch.test.OpenSearchIntegTestCase.client;  
        clusterStateRequest.clear().nodes(true).routingTable(true).indices("*");  
import org.opensearch.cluster.node.DiscoveryNode;
                try (DirectoryStream<Path> stream = Files.newDirectoryStream(indexPath)) {  
        return shardIdShardAttributesMap;
                            Files.delete(item);  
            final String customDataPath = IndexMetadata.INDEX_DATA_PATH_SETTING.get(  
            for (int shardIdNum = 0; shardIdNum < primaryShardCount; shardIdNum++) {  
        final List<DiscoveryNode> nodes = new LinkedList<>(clusterStateResponse.getState().nodes().getDataNodes().values());
import org.opensearch.core.index.shard.ShardId;  
                        }
                client().admin().indices().prepareGetSettings(indexName).get().getIndexToSettings().get(indexName)
        }
import java.nio.file.Files;
    public static void corruptShard(String nodeName, ShardId shardId) throws IOException, InterruptedException {
import org.opensearch.env.NodeEnvironment;
        clusterStateRequest.local(false);
                shardIdShardAttributesMap.put(shardId, new ShardAttributes(customDataPath));
