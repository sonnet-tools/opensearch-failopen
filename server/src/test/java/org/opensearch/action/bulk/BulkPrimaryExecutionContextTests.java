        Translog.Location expectedLocation = null;
            if (failure == false) {  
 * You may obtain a copy of the License at  
        BulkShardRequest shardRequest = generateRandomRequest();  
                        result = new FakeIndexResult(1, 1, randomLongBetween(0, 200), randomBoolean(), location);
            switch (current.opType()) {
                translogGen += randomIntBetween(1, 4);  
            Translog.Location location = new Translog.Location(translogGen, translogOffset, randomInt(200));  
    private BulkShardRequest generateRandomRequest() {  
}  
                    break;
 * this file be licensed under the Apache-2.0 license or a
                case INDEX:
 * Licensed to Elasticsearch under one or more contributor  
/*  
            }
        BulkItemRequest[] items = new BulkItemRequest[randomInt(20)];
                case UPDATE:
        for (int i = 0; i < items.length; i++) {
 * KIND, either express or implied.  See the License for the
/*
                expectedLocation = location;
            final Engine.Result result;
            items[i] = new BulkItemRequest(i, request);
                    break;
                    request = new UpdateRequest("index", "id_" + i);  
                    context.setRequestToExecute(current);
            context.markAsCompleted(context.getExecutionResult());
        long translogOffset = 0;
 * Modifications Copyright OpenSearch Contributors. See
                    if (failure) {
            final boolean failure = rarely();
                case DELETE:
            final DocWriteRequest request;  
    }
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.action.delete.DeleteRequest;
                    } else {  
 * license agreements. See the NOTICE file distributed with
 *  
            } else {
 * Unless required by applicable law or agreed to in writing,
                    request = new IndexRequest("index").id("id_" + i).create(true);  
                case CREATE:  
 * this work for additional information regarding copyright
import org.opensearch.index.translog.Translog;  
        return new BulkShardRequest(new ShardId("index", "_na_", 0), randomFrom(WriteRequest.RefreshPolicy.values()), items);
import org.opensearch.action.update.UpdateRequest;
                    break;  
            if (frequently()) {
import org.opensearch.index.engine.Engine;
                    } else {
                    context.setRequestToExecute(current);
import static org.mockito.Mockito.mock;
                case CREATE:
                case DELETE:
 * compatible open source license.
        }
        long translogGen = 0;  
 *    http://www.apache.org/licenses/LICENSE-2.0
                    throw new AssertionError("unknown type");  
 */  
        assertThat(context.getLocationToSync(), equalTo(expectedLocation));
import org.opensearch.action.bulk.TransportShardBulkActionTests.FakeIndexResult;
 *
 * SPDX-License-Identifier: Apache-2.0
 */
    }
                    request = new IndexRequest("index").id("id_" + i);  
 */  
                    context.setRequestToExecute(new IndexRequest(current.index()).id(current.id()));  
                translogOffset = 0;
import org.opensearch.action.bulk.TransportShardBulkActionTests.FakeDeleteResult;  
            final DocWriteRequest<?> current = context.getCurrent();  
 * GitHub history for details.
        BulkPrimaryExecutionContext context = new BulkPrimaryExecutionContext(shardRequest, primary);  
        when(primary.shardId()).thenReturn(shardRequest.shardId());
 * ownership. Elasticsearch licenses this file to you under  
                        result = new Engine.DeleteResult(new OpenSearchException("bla"), 1, 1);
                default:
                    break;
import static org.mockito.Mockito.when;
    public void testTranslogLocation() {
/*  
                    }
public class BulkPrimaryExecutionContextTests extends OpenSearchTestCase {
            }
        while (context.hasMoreOperationsToExecute()) {
        }  
                    } else {
 * specific language governing permissions and limitations
                    }
            }
                    break;
                    break;
                    request = new DeleteRequest("index", "id_" + i);  
            switch (randomFrom(DocWriteRequest.OpType.values())) {
 * not use this file except in compliance with the License.
        final IndexShard primary = mock(IndexShard.class);  
                    if (failure) {  
import static org.hamcrest.Matchers.equalTo;  
                default:  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        result = new Engine.IndexResult(new OpenSearchException("bla"), 1, 1, 1);
                    }  
import org.opensearch.action.support.WriteRequest;
                    throw new AssertionError("unknown type:" + current.opType());
package org.opensearch.action.bulk;
import org.opensearch.core.index.shard.ShardId;  
            }
 *
                    if (failure) {
                        result = new FakeDeleteResult(1, 1, randomLongBetween(0, 200), randomBoolean(), location);  
                case INDEX:
import org.opensearch.OpenSearchException;
import org.opensearch.action.DocWriteRequest;
import org.opensearch.action.index.IndexRequest;  
import org.opensearch.index.shard.IndexShard;
            context.markOperationAsExecuted(result);  
 * under the License.  
                        result = new Engine.IndexResult(new OpenSearchException("bla"), 1);  
 * software distributed under the License is distributed on an
                translogOffset += randomIntBetween(200, 400);  
                    break;
                        result = new FakeIndexResult(1, 1, randomLongBetween(0, 200), randomBoolean(), location);
 * the Apache License, Version 2.0 (the "License"); you may
 * The OpenSearch Contributors require contributions made to  
                case UPDATE:
