 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("some]weird[0]Name", id.getIndex().getName());
    }
 * license agreements. See the NOTICE file distributed with
 * You may obtain a copy of the License at  
    public void testShardIdFromString() {
 * software distributed under the License is distributed on an
        assertEquals("some]weird[0]Name", id.getIndexName());  
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> ShardId.fromString(badId));  
}
        String badId2 = indexName + "][" + shardId + "]"; // missing opening bracket  
        assertEquals("Unexpected shardId string format, expected [indexName][shardId] but got " + badId, ex.getMessage());
        String s = "Some random other object";
        Index index2 = new Index("a", "b");  
public class ShardIdTests extends OpenSearchTestCase {  
        String badId = indexName + "," + shardId; // missing separator
 * SPDX-License-Identifier: Apache-2.0
        int shardId = randomInt();
import org.opensearch.core.index.Index;
        ex = expectThrows(IllegalArgumentException.class, () -> ShardId.fromString(badId3));
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 */  
        assertEquals(indexName, id.getIndexName());  
        String indexName = randomAlphaOfLengthBetween(3, 50);  
 * this work for additional information regarding copyright
 */  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
        assertEquals(-125, id.getId());
 * not use this file except in compliance with the License.
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
 */
 *
    }  
        assertEquals(IndexMetadata.INDEX_UUID_NA_VALUE, id.getIndex().getUUID());  
package org.opensearch.index.shard;
        ShardId shardId4 = new ShardId(index1, 1);
        ShardId shardId2 = new ShardId(index1, 0);
 * under the License.  
/*  
        Index index1 = new Index("a", "a");
        assertEquals(shardId1, shardId1);  
 * specific language governing permissions and limitations
        ex = expectThrows(IllegalArgumentException.class, () -> ShardId.fromString(badId2));
import org.opensearch.core.index.shard.ShardId;  
/*
        assertEquals(indexName, id.getIndex().getName());
        ShardId id = ShardId.fromString("[" + indexName + "][" + shardId + "]");
import org.opensearch.cluster.metadata.IndexMetadata;
        id = ShardId.fromString("[some]weird[0]Name][-125]");
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(shardId1, shardId2);
        String badId3 = "[" + indexName + "][" + shardId; // missing closing bracket  
        ShardId shardId1 = new ShardId(index1, 0);
        assertEquals(IndexMetadata.INDEX_UUID_NA_VALUE, id.getIndex().getUUID());  
 * KIND, either express or implied.  See the License for the
        assertNotEquals(shardId1, shardId4);
        assertNotEquals(shardId1, s);  
        ShardId shardId3 = new ShardId(index2, 0);  
 *
        assertNotEquals(shardId1, null);
    public void testEquals() {
import org.opensearch.test.OpenSearchTestCase;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 *  
        assertNotEquals(shardId1, shardId3);
 * GitHub history for details.
        assertEquals(shardId, id.getId());
