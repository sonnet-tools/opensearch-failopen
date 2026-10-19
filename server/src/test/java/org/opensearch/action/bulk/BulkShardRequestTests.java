            if (null == expectedItem) {
        assertEquals(expected.getRefreshPolicy(), actual.getRefreshPolicy());
        assertEquals(original.getParentTask(), cloned.getParentTask());
        final RefreshPolicy refreshPolicy = randomFrom(RefreshPolicy.values());
        assertEquals(expected.shardId(), actual.shardId());
        original.timeout(TimeValue.timeValueMillis(randomLongBetween(1, 60000)));  
import org.opensearch.action.index.IndexResponse;
        }  
        original.setParentTask(new TaskId(randomAlphaOfLength(10), randomNonNegativeLong()));  
import org.opensearch.core.tasks.TaskId;
        // Set random mutable properties from ReplicationRequest
        BulkShardRequest r = new BulkShardRequest(shardId, RefreshPolicy.NONE, new BulkItemRequest[count]);
 */  
                    new IndexResponse(shardId, "id_" + i, 1, 1, 1, true)  
        for (int i = 0; i < count; ++i) {
        assertEquals(expected.waitForActiveShards(), actual.waitForActiveShards());
 * not use this file except in compliance with the License.
 *  
import org.opensearch.action.index.IndexRequest;  
        // Verify all cloned properties match
        final String index = randomSimpleString(random(), 1, 10);
 * license agreements. See the NOTICE file distributed with
    }
        assertEquals(original.getRefreshPolicy(), cloned.getRefreshPolicy());  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.support.WriteRequest.RefreshPolicy;  
                assertEquals(items[i].request().opType(), cloned.items()[i].request().opType());
        final BytesStreamOutput out = new BytesStreamOutput();
        for (int i = 0; i < count; i++) {
        original.waitForActiveShards(ActiveShardCount.from(randomIntBetween(0, 10)));
                continue;  
        // Build primary responses for each item
        final int count = between(2, 100);
                );
            assertEquals(expectedItem.request().opType(), actualItem.request().opType());
        assertEquals(original.waitForActiveShards(), cloned.waitForActiveShards());
    private BulkItemRequest[] generateBulkItemRequests(final int count) {  
        assertEquals("requests[" + count + "], index[" + index + "][0]", r.getDescription());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;  
    }
    }
            final BulkItemRequest actualItem = actual.items()[i];  
 * KIND, either express or implied.  See the License for the
            };
                primaryResponses[i] = new BulkItemResponse(  
        for (int i = 0; i < count; i++) {
                case DELETE -> new DeleteRequest("index", "id_" + i);  
 * Licensed to Elasticsearch under one or more contributor  
        assertEquals("BulkShardRequest [" + shardId + "] containing [" + count + "] requests and a refresh", r.toString());
 * software distributed under the License is distributed on an
import org.opensearch.common.io.stream.BytesStreamOutput;
        expected.writeTo(out);  
                assertNull(actualItem);
        final BulkItemRequest[] items = generateBulkItemRequests(count);
                case CREATE -> new IndexRequest("index").id("id_" + i).create(true);
        assertEquals(expected.items().length, actual.items().length);  
        assertEquals(expected.getParentTask().getId(), actual.getParentTask().getId());
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertEquals(items[i].id(), cloned.items()[i].id());  
            final BulkItemRequest expectedItem = expected.items()[i];
 * The OpenSearch Contributors require contributions made to  
 * compatible open source license.
        final ShardId shardId = new ShardId(index, "ignored", 0);  
        return items;
                items[i] = null;
            }
 * Unless required by applicable law or agreed to in writing,
            items[i] = new BulkItemRequest(i, request);
        final RefreshPolicy refreshPolicy = randomFrom(RefreshPolicy.values());
        assertEquals(expected.getParentTask().getNodeId(), actual.getParentTask().getNodeId());
        assertEquals(expected.index(), actual.index());
            assertEquals(expectedItem.request().index(), actualItem.request().index());
 *
                    items[i].request().opType(),
        final ShardId shardId = new ShardId(index, "ignored", 0);
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
            if (items[i] == null) {  
    public void testBulkShardRequestSerialization() throws IOException {  
            if (i == nullIdx) {
 * You may obtain a copy of the License at  
        assertEquals("requests[" + count + "], index[" + index + "][0], refresh[IMMEDIATE]", r.getDescription());
        for (int i = 0; i < count; i++) {  
/*  
        final String index = randomSimpleString(random(), 10);
import org.opensearch.common.unit.TimeValue;  
        final ShardId shardId = new ShardId(index, randomAlphaOfLength(10), randomIntBetween(0, 5));
 * this file be licensed under the Apache-2.0 license or a
            }
        int count = between(2, 100);  
                case UPDATE -> new UpdateRequest("index", "id_" + i);
        final int count = between(2, 100);  
                assertSame(primaryResponses[i], cloned.items()[i].primaryResponse());
 * ownership. Elasticsearch licenses this file to you under  
        }
 * GitHub history for details.
        assertEquals(original.shardId(), cloned.shardId());
 *
import org.opensearch.action.DocWriteRequest;
public class BulkShardRequestTests extends OpenSearchTestCase {  
        final BulkItemRequest[] items = new BulkItemRequest[count];
    }
        assertEquals("BulkShardRequest [" + shardId + "] containing [" + count + "] requests blocking until refresh", r.toString());
        r = new BulkShardRequest(shardId, RefreshPolicy.WAIT_UNTIL, new BulkItemRequest[count]);
        r = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, new BulkItemRequest[count]);  
        final BulkItemResponse[] primaryResponses = new BulkItemResponse[count];  
package org.opensearch.action.bulk;
            if (items[i] != null) {
 * Modifications Copyright OpenSearch Contributors. See
        final BulkShardRequest cloned = original.setPrimaryResponses(primaryResponses);
/*
import org.opensearch.action.support.ActiveShardCount;
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(original.timeout(), cloned.timeout());
import org.opensearch.action.update.UpdateRequest;
        final BulkShardRequest original = new BulkShardRequest(shardId, refreshPolicy, items);  
        assertEquals("BulkShardRequest [" + shardId + "] containing [" + count + "] requests", r.toString());  
        }  
            }  
        original.routedBasedOnClusterVersion(randomNonNegativeLong());
 * this work for additional information regarding copyright
        final BulkShardRequest actual = new BulkShardRequest(out.bytes().streamInput());
                case INDEX -> new IndexRequest("index").id("id_" + i);  
        assertEquals(expected.timeout(), actual.timeout());  
        assertEquals(expected.routedBasedOnClusterVersion(), actual.routedBasedOnClusterVersion());
                    i,
            final DocWriteRequest<?> request = switch (randomFrom(DocWriteRequest.OpType.values())) {
        String index = randomSimpleString(random(), 10);
import org.opensearch.core.index.shard.ShardId;
    public void testSetPrimaryResponses() {
        final BulkShardRequest expected = new BulkShardRequest(shardId, refreshPolicy, generateBulkItemRequests(count));
                assertNull(cloned.items()[i]);
        assertEquals(count, cloned.items().length);
                continue;  
            } else {
 */  
 */
 * under the License.  
            assertEquals(expectedItem.id(), actualItem.id());
 * specific language governing permissions and limitations
import org.opensearch.action.delete.DeleteRequest;
        // Verify items have primary responses attached  
    public void testToString() {
import java.io.IOException;
        final int nullIdx = randomIntBetween(0, count - 1);
        assertEquals("requests[" + count + "], index[" + index + "][0], refresh[WAIT_UNTIL]", r.getDescription());  
/*  
        assertEquals(original.routedBasedOnClusterVersion(), cloned.routedBasedOnClusterVersion());  
            assertEquals(expectedItem.request().id(), actualItem.request().id());  
        }  
}  
