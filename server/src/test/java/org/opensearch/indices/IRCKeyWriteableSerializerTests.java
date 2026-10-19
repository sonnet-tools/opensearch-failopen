import org.opensearch.test.OpenSearchSingleNodeTestCase;  
import java.util.UUID;  
        Random rand = Randomness.get();
import org.opensearch.index.shard.IndexShard;
import org.opensearch.core.common.bytes.BytesReference;
        IndexShard indexShard = indexService.getShardOrNull(0);  
import org.opensearch.index.IndexService;
        int[] valueLengths = new int[] { 1000, 6000 }; // test both branches in equals()
    public void testSerializer() throws Exception {
            for (int i = 0; i < NUM_KEYS; i++) {
 * The OpenSearch Contributors require contributions made to  
}
                assertTrue(ser.equals(key, serialized));
        }  
 *
 * this file be licensed under the Apache-2.0 license or a
        for (int i = 0; i < valueLength; i++) {
                assertTrue(key.equals(deserialized));  
    }  
        for (int valueLength : valueLengths) {  
    private IndicesRequestCache.Key getRandomIRCKey(int valueLength, Random random, ShardId shard, int indexShardHashCode) {
        }
public class IRCKeyWriteableSerializerTests extends OpenSearchSingleNodeTestCase {
        return new IndicesRequestCache.Key(shard, keyValue, UUID.randomUUID().toString(), indexShardHashCode); // same UUID
package org.opensearch.indices;
 * compatible open source license.
 * SPDX-License-Identifier: Apache-2.0
        IRCKeyWriteableSerializer ser = new IRCKeyWriteableSerializer();
    }
        IndexService indexService = createIndex("test");
            value[i] = (byte) (random.nextInt(126 - 32) + 32);
        int NUM_KEYS = 1000;  
        // source as used in real key  
                byte[] serialized = ser.serialize(key);  
        BytesReference keyValue = new BytesArray(value);
        byte[] value = new byte[valueLength];  
import org.opensearch.core.common.bytes.BytesArray;
import java.util.Random;
import org.opensearch.core.index.shard.ShardId;  
            }
                IndicesRequestCache.Key key = getRandomIRCKey(valueLength, rand, indexShard.shardId(), System.identityHashCode(indexShard));
import org.opensearch.common.Randomness;  
                IndicesRequestCache.Key deserialized = ser.deserialize(serialized);
/*  
 */  
