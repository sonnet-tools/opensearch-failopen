        List<ShardId> shards = new ArrayList<>();
 * this file be licensed under the Apache-2.0 license or a
            ShardId shardId = new ShardId("test", "_na_", shardNumber);
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        return shards;
import org.opensearch.core.index.shard.ShardId;
    }
            shards.add(shardId);
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.gateway;
    public static List<ShardId> setUpShards(int numberOfShards) {
import java.util.List;
 */  
public class BatchTestUtil {  
        }  
 *
        for (int shardNumber = 0; shardNumber < numberOfShards; shardNumber++) {  
import java.util.ArrayList;  
}  
/*  
