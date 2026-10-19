import java.io.IOException;
    private BulkItemRequest[] generateBulkItemRequests(final int count) {
    public void testSetPrimaryResponses() {
        final BulkItemResponse[] primaryResponses = new BulkItemResponse[count];
            };
                );
 *    http://www.apache.org/licenses/LICENSE-2.0
                    items[i].request().opType(),
        }
        expected.writeTo(out);
 */
            assertEquals(expectedItem.id(), actualItem.id());
        final int nullIdx = randomIntBetween(0, count - 1);
            }
    }
            if (items[i] != null) {
                case INDEX -> new IndexRequest("index").id("id_" + i);
import org.opensearch.action.index.IndexRequest;
        assertEquals(expected.getParentTask().getId(), actual.getParentTask().getId());
 * this file be licensed under the Apache-2.0 license or a
        final String index = randomSimpleString(random(), 1, 10);
 * Modifications Copyright OpenSearch Contributors. See
        final BulkItemRequest[] items = new BulkItemRequest[count];
public class BulkShardRequestTests extends OpenSearchTestCase {
                case CREATE -> new IndexRequest("index").id("id_" + i).create(true);
    public void testBulkShardRequestSerialization() throws IOException {
        assertEquals("BulkShardRequest [" + shardId + "] containing [" + count + "] requests", r.toString());
 */
        final ShardId shardId = new ShardId(index, "ignored", 0);
        original.setParentTask(new TaskId(randomAlphaOfLength(10), randomNonNegativeLong()));
        final RefreshPolicy refreshPolicy = randomFrom(RefreshPolicy.values());
 * specific language governing permissions and limitations
 *
        final BulkShardRequest original = new BulkShardRequest(shardId, refreshPolicy, items);
 *
            assertEquals(expectedItem.request().index(), actualItem.request().index());
        original.routedBasedOnClusterVersion(randomNonNegativeLong());
            }
import org.opensearch.core.index.shard.ShardId;
                primaryResponses[i] = new BulkItemResponse(
        // Build primary responses for each item
                assertNull(cloned.items()[i]);
}
        for (int i = 0; i < count; i++) {
 * license agreements. See the NOTICE file distributed with
        assertEquals(expected.shardId(), actual.shardId());
            final BulkItemRequest actualItem = actual.items()[i];
/*
        assertEquals(expected.getParentTask().getNodeId(), actual.getParentTask().getNodeId());
                    new IndexResponse(shardId, "id_" + i, 1, 1, 1, true)
                items[i] = null;
                assertSame(primaryResponses[i], cloned.items()[i].primaryResponse());
        final BulkItemRequest[] items = generateBulkItemRequests(count);
        BulkShardRequest r = new BulkShardRequest(shardId, RefreshPolicy.NONE, new BulkItemRequest[count]);
/*
        assertEquals(count, cloned.items().length);
import org.opensearch.action.delete.DeleteRequest;
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(original.getRefreshPolicy(), cloned.getRefreshPolicy());
        assertEquals("BulkShardRequest [" + shardId + "] containing [" + count + "] requests and a refresh", r.toString());
                continue;
        for (int i = 0; i < count; i++) {
        // Verify items have primary responses attached
        original.waitForActiveShards(ActiveShardCount.from(randomIntBetween(0, 10)));
 * not use this file except in compliance with the License.
/*
            }
        final BulkShardRequest expected = new BulkShardRequest(shardId, refreshPolicy, generateBulkItemRequests(count));
            final BulkItemRequest expectedItem = expected.items()[i];
        int count = between(2, 100);
        final String index = randomSimpleString(random(), 10);
                assertEquals(items[i].id(), cloned.items()[i].id());
import org.opensearch.common.io.stream.BytesStreamOutput;
    }
        final ShardId shardId = new ShardId(index, randomAlphaOfLength(10), randomIntBetween(0, 5));
        // Set random mutable properties from ReplicationRequest
        assertEquals(expected.items().length, actual.items().length);
        assertEquals("requests[" + count + "], index[" + index + "][0]", r.getDescription());
        r = new BulkShardRequest(shardId, RefreshPolicy.WAIT_UNTIL, new BulkItemRequest[count]);
    }
import org.opensearch.core.tasks.TaskId;
import org.opensearch.action.update.UpdateRequest;
package org.opensearch.action.bulk;
            items[i] = new BulkItemRequest(i, request);
        assertEquals(expected.index(), actual.index());
import org.opensearch.action.support.ActiveShardCount;
        final BulkShardRequest cloned = original.setPrimaryResponses(primaryResponses);
        r = new BulkShardRequest(shardId, RefreshPolicy.IMMEDIATE, new BulkItemRequest[count]);
        }
        }
 * software distributed under the License is distributed on an
 * GitHub history for details.
import static org.apache.lucene.tests.util.TestUtil.randomSimpleString;
        assertEquals("requests[" + count + "], index[" + index + "][0], refresh[IMMEDIATE]", r.getDescription());
 * under the License.
 * compatible open source license.
            assertEquals(expectedItem.request().opType(), actualItem.request().opType());
 * You may obtain a copy of the License at
 * KIND, either express or implied.  See the License for the
                assertNull(actualItem);
        assertEquals(expected.timeout(), actual.timeout());
        final int count = between(2, 100);
        assertEquals(original.getParentTask(), cloned.getParentTask());
import org.opensearch.action.index.IndexResponse;
 * SPDX-License-Identifier: Apache-2.0
            }
        assertEquals(expected.routedBasedOnClusterVersion(), actual.routedBasedOnClusterVersion());
        for (int i = 0; i < count; ++i) {
 * Licensed to Elasticsearch under one or more contributor
        String index = randomSimpleString(random(), 10);
 *
                case DELETE -> new DeleteRequest("index", "id_" + i);
        final BytesStreamOutput out = new BytesStreamOutput();
 */
            } else {
        final RefreshPolicy refreshPolicy = randomFrom(RefreshPolicy.values());
        original.timeout(TimeValue.timeValueMillis(randomLongBetween(1, 60000)));
        assertEquals("requests[" + count + "], index[" + index + "][0], refresh[WAIT_UNTIL]", r.getDescription());
 * Unless required by applicable law or agreed to in writing,
                case UPDATE -> new UpdateRequest("index", "id_" + i);
        assertEquals("BulkShardRequest [" + shardId + "] containing [" + count + "] requests blocking until refresh", r.toString());
    }
            assertEquals(expectedItem.request().id(), actualItem.request().id());
        assertEquals(original.shardId(), cloned.shardId());
            if (items[i] == null) {
import org.opensearch.action.support.WriteRequest.RefreshPolicy;
        final BulkShardRequest actual = new BulkShardRequest(out.bytes().streamInput());
        assertEquals(expected.getRefreshPolicy(), actual.getRefreshPolicy());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        final int count = between(2, 100);
        for (int i = 0; i < count; i++) {
import org.opensearch.common.unit.TimeValue;
        assertEquals(original.routedBasedOnClusterVersion(), cloned.routedBasedOnClusterVersion());
import org.opensearch.action.DocWriteRequest;
        assertEquals(expected.waitForActiveShards(), actual.waitForActiveShards());
        final ShardId shardId = new ShardId(index, "ignored", 0);
            if (i == nullIdx) {
        assertEquals(original.timeout(), cloned.timeout());
                continue;
import org.opensearch.test.OpenSearchTestCase;
 * this work for additional information regarding copyright
            if (null == expectedItem) {
 * ownership. Elasticsearch licenses this file to you under
                assertEquals(items[i].request().opType(), cloned.items()[i].request().opType());
        }
                    i,
        // Verify all cloned properties match
        return items;
        assertEquals(original.waitForActiveShards(), cloned.waitForActiveShards());
    public void testToString() {
            final DocWriteRequest<?> request = switch (randomFrom(DocWriteRequest.OpType.values())) {
 * The OpenSearch Contributors require contributions made to
