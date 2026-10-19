                        shards[i] = new CloseIndexResponse.ShardResult(i, failures);  
    }
                            assertThat(actualFailure.shardId(), equalTo(expectedFailure.shardId()));
import org.opensearch.common.xcontent.XContentType;
 * the Apache License, Version 2.0 (the "License"); you may
        CloseIndexResponse.ShardResult[] shards = new CloseIndexResponse.ShardResult[1];
            new CloseIndexResponse.ShardResult.Failure[] {
        Index index = new Index("test", "uuid");
                    final int nbShards = randomIntBetween(1, 5);  
}  
 * specific language governing permissions and limitations
                        assertThat(actualShardResult.getFailures(), nullValue());  
import org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult;  
                        assertThat(actualShardResult.getFailures().length, equalTo(expectedShardResult.getFailures().length));
                    CloseIndexResponse.ShardResult expectedShardResult = expectedIndexResult.getShards()[j];
        for (int i = 0; i < expected.getIndices().size(); i++) {  
            } else {
                assertThat(actualIndexResult.getShards(), nullValue());
            } else {
import org.opensearch.core.index.Index;
            Strings.toString(MediaTypeRegistry.JSON, closeIndexResponse)
        for (String indexName : indicesNames) {  
                    CloseIndexResponse.ShardResult[] shards = new CloseIndexResponse.ShardResult[nbShards];
import java.util.Collections;
    @Override  
 * SPDX-License-Identifier: Apache-2.0
                                if (frequently()) {  
     * Also check some specific simple cases for output.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Modifications Copyright OpenSearch Contributors. See
                if (actualIndexResult.getShards() != null) {  
            new IndexNotFoundException(index),
            final Index index = new Index(indexName, randomAlphaOfLength(5));
                for (int j = 0; j < expectedIndexResult.getShards().length; j++) {  
import org.opensearch.core.xcontent.XContentBuilder;
                }
        assertEquals(
 * software distributed under the License is distributed on an
                            failures = new CloseIndexResponse.ShardResult.Failure[randomIntBetween(1, 3)];  
import org.opensearch.index.IndexNotFoundException;  
        return CloseIndexResponse::new;  
        IndexResult indexResult = new CloseIndexResponse.IndexResult(index);  
import static org.hamcrest.Matchers.nullValue;
            }
    }
                + "\"reason\":{\"type\":\"action_not_found_transport_exception\","
                            CloseIndexResponse.ShardResult.Failure actualFailure = actualShardResult.getFailures()[k];
    }
        }  
        indexResult = new CloseIndexResponse.IndexResult(index, shards);
import org.opensearch.action.NoShardAvailableActionException;
                        }
            CloseIndexResponse.IndexResult actualIndexResult = actual.getIndices().get(i);
        final List<CloseIndexResponse.IndexResult> indexResults = new ArrayList<>();
import org.opensearch.core.xcontent.ToXContent;
                            assertThat(actualFailure.getCause().getClass(), equalTo(expectedFailure.getCause().getClass()));
        );
        assertNotSame(expected, actual);
                            assertThat(actualFailure.getNodeId(), equalTo(expectedFailure.getNodeId()));  
        assertThat(actual.isShardsAcknowledged(), equalTo(expected.isShardsAcknowledged()));
import org.opensearch.test.AbstractWireSerializingTestCase;
    }
            Strings.toString(MediaTypeRegistry.JSON, closeIndexResponse)  
/*  
 * GitHub history for details.
            }
        final String[] indicesNames = generateRandomStringArray(10, 10, false, true);  
        closeIndexResponse = new CloseIndexResponse(true, true, Collections.singletonList(indexResult));
            }
import java.io.IOException;
                + "\"reason\":\"No handler for action [test]\"}}]}}}}}",
/*
            } else {  
    protected CloseIndexResponse createTestInstance() {  
                    acknowledged = false;  
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.index.shard.ShardId;
                            assertArrayEquals(actualFailure.getCause().getStackTrace(), expectedFailure.getCause().getStackTrace());  
                assertThat(actualIndexResult.getShards(), nullValue());  
 * Licensed to Elasticsearch under one or more contributor  
            if (expectedIndexResult.getException() != null) {
 *  
                new CloseIndexResponse.ShardResult.Failure("test", 0, new ActionNotFoundTransportException("test"), "nodeId") }
 * KIND, either express or implied.  See the License for the
                    indexResults.add(new CloseIndexResponse.IndexResult(index, shards));
        CloseIndexResponse closeIndexResponse = new CloseIndexResponse(true, true, Collections.singletonList(indexResult));
    public void testToXContent() throws IOException {
                assertThat(actualIndexResult.getException().getClass(), equalTo(expectedIndexResult.getException().getClass()));  
 * compatible open source license.
            assertThat(actualIndexResult.hasFailures(), equalTo(expectedIndexResult.hasFailures()));
                            CloseIndexResponse.ShardResult.Failure expectedFailure = expectedShardResult.getFailures()[k];
 * this work for additional information regarding copyright
import java.util.List;
 * under the License.  
        return randomResponse();
                    for (int i = 0; i < nbShards; i++) {
        assertEquals(  
                        CloseIndexResponse.ShardResult.Failure[] failures = null;  
                indexResults.add(new CloseIndexResponse.IndexResult(index));  
                + "\"indices\":{\"test\":{\"closed\":false,\"failedShards\":{\"0\":{"
     */  
    protected void assertEqualInstances(CloseIndexResponse expected, CloseIndexResponse actual) {
        assertThat(actual.isAcknowledged(), equalTo(expected.isAcknowledged()));  
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
 */
                assertArrayEquals(actualIndexResult.getException().getStackTrace(), expectedIndexResult.getException().getStackTrace());
                assertThat(actualIndexResult.getShards().length, equalTo(expectedIndexResult.getShards().length));
                        is(true)  
            assertThat(actualIndexResult.getIndex(), equalTo(expectedIndexResult.getIndex()));
                    assertThat(actualShardResult.hasFailures(), equalTo(expectedShardResult.hasFailures()));
import static org.hamcrest.Matchers.notNullValue;  
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Arrays;  
                            for (int j = 0; j < failures.length; j++) {
 *
                } else {
                            acknowledged = false;
            assertNotSame(expectedIndexResult, actualIndexResult);  
import org.opensearch.core.common.io.stream.Writeable;  
    @Override
            "{\"acknowledged\":true,\"shards_acknowledged\":true,\"indices\":{\"test\":{\"closed\":true}}}",  
                }
        XContentType xContentType = randomFrom(XContentType.values());  
        return randomFrom(  
                    }
            CloseIndexResponse.IndexResult expectedIndexResult = expected.getIndices().get(i);
public class CloseIndexResponseTests extends AbstractWireSerializingTestCase<CloseIndexResponse> {  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        );  
                assertThat(actualIndexResult.getException(), notNullValue());
                                failures[j] = new CloseIndexResponse.ShardResult.Failure(indexName, i, randomException(index, i), nodeId);  
 * not use this file except in compliance with the License.
                assertThat(actualIndexResult.getException(), nullValue());  
                    } else {
                    assertThat(
    @Override
            0,  
import static org.hamcrest.Matchers.equalTo;
                        for (int k = 0; k < expectedShardResult.getFailures().length; k++) {  
                            assertThat(actualFailure.getCause().getMessage(), equalTo(expectedFailure.getCause().getMessage()));
/*  
 *
 */  
                    assertThat(actualShardResult.getId(), equalTo(expectedShardResult.getId()));  
                            assertThat(actualFailure.reason(), equalTo(expectedFailure.reason()));  
    private CloseIndexResponse randomResponse() {
                    );
            new NoShardAvailableActionException(new ShardId(index, id))  
        CloseIndexResponse response = randomResponse();
                    CloseIndexResponse.ShardResult actualShardResult = actualIndexResult.getShards()[j];
                                    nodeId = randomAlphaOfLength(5);
                }  
            response.toXContent(builder, ToXContent.EMPTY_PARAMS);
            new ActionNotFoundTransportException("test"),
import java.util.ArrayList;
        }  
        boolean acknowledged = true;
        shards[0] = new CloseIndexResponse.ShardResult(
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
                        }
                assertThat(actualIndexResult.getException().getMessage(), equalTo(expectedIndexResult.getException().getMessage()));
 * Unless required by applicable law or agreed to in writing,
    }
 * You may obtain a copy of the License at  
        );
package org.opensearch.action.admin.indices.close;
                    indexResults.add(new CloseIndexResponse.IndexResult(index, randomException(index, 0)));
        }
                assertThat(actualIndexResult.getException(), nullValue());
                                String nodeId = null;
            }  
                + "\"failures\":[{\"node\":\"nodeId\",\"shard\":0,\"index\":\"test\",\"status\":\"INTERNAL_SERVER_ERROR\","  
import static org.hamcrest.Matchers.is;
import org.opensearch.core.common.Strings;
                                }
    protected Writeable.Reader<CloseIndexResponse> instanceReader() {
        );
                if (randomBoolean()) {
    }  
        return new CloseIndexResponse(acknowledged, shardsAcknowledged, indexResults);
                            assertThat(actualFailure.index(), equalTo(expectedFailure.index()));
            if (expectedIndexResult.hasFailures() == false) {
import org.opensearch.transport.ActionNotFoundTransportException;
     * Test that random responses can be written to xcontent without errors.
 */  
                    }
    private static OpenSearchException randomException(final Index index, final int id) {
                            }
    /**  
                    if (expectedShardResult.hasFailures()) {  
 * ownership. Elasticsearch licenses this file to you under  
            "{\"acknowledged\":true,\"shards_acknowledged\":true,"
            if (randomBoolean()) {
        final boolean shardsAcknowledged = acknowledged ? randomBoolean() : false;
                        if (randomBoolean()) {
            if (expectedIndexResult.getShards() != null) {  
                        Arrays.stream(actualIndexResult.getShards()).allMatch(shardResult -> shardResult.hasFailures() == false),
import org.opensearch.OpenSearchException;
