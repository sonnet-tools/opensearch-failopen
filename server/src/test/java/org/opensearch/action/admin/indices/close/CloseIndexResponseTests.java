            new ActionNotFoundTransportException("test"),
 *
 * ownership. Elasticsearch licenses this file to you under
            CloseIndexResponse.IndexResult actualIndexResult = actual.getIndices().get(i);
            } else {
                if (randomBoolean()) {
                            for (int j = 0; j < failures.length; j++) {
 * The OpenSearch Contributors require contributions made to
                    indexResults.add(new CloseIndexResponse.IndexResult(index, shards));
        }
 *
                    } else {
                                failures[j] = new CloseIndexResponse.ShardResult.Failure(indexName, i, randomException(index, i), nodeId);
                }
import org.opensearch.OpenSearchException;
        for (String indexName : indicesNames) {
            if (randomBoolean()) {
import org.opensearch.core.common.io.stream.Writeable;
            CloseIndexResponse.IndexResult expectedIndexResult = expected.getIndices().get(i);
    @Override
                            assertArrayEquals(actualFailure.getCause().getStackTrace(), expectedFailure.getCause().getStackTrace());
import java.util.Collections;
import org.opensearch.core.xcontent.XContentBuilder;
                            assertThat(actualFailure.shardId(), equalTo(expectedFailure.shardId()));
            new CloseIndexResponse.ShardResult.Failure[] {
 */
                assertThat(actualIndexResult.getShards(), nullValue());
import java.io.IOException;
        return CloseIndexResponse::new;
 */
    }
        }
                + "\"indices\":{\"test\":{\"closed\":false,\"failedShards\":{\"0\":{"
/*
}
            0,
            "{\"acknowledged\":true,\"shards_acknowledged\":true,"
        CloseIndexResponse response = randomResponse();
    /**
        }
import org.opensearch.core.xcontent.ToXContent;
            "{\"acknowledged\":true,\"shards_acknowledged\":true,\"indices\":{\"test\":{\"closed\":true}}}",
            }
                }
                assertThat(actualIndexResult.getException(), nullValue());
public class CloseIndexResponseTests extends AbstractWireSerializingTestCase<CloseIndexResponse> {
                        if (randomBoolean()) {
                if (actualIndexResult.getShards() != null) {
                    }
        );
                                    nodeId = randomAlphaOfLength(5);
 * compatible open source license.
        );
            response.toXContent(builder, ToXContent.EMPTY_PARAMS);
        CloseIndexResponse closeIndexResponse = new CloseIndexResponse(true, true, Collections.singletonList(indexResult));
                            CloseIndexResponse.ShardResult.Failure expectedFailure = expectedShardResult.getFailures()[k];
        final boolean shardsAcknowledged = acknowledged ? randomBoolean() : false;
                    acknowledged = false;
import org.opensearch.core.index.shard.ShardId;
        final List<CloseIndexResponse.IndexResult> indexResults = new ArrayList<>();
    private static OpenSearchException randomException(final Index index, final int id) {
            Strings.toString(MediaTypeRegistry.JSON, closeIndexResponse)
                            failures = new CloseIndexResponse.ShardResult.Failure[randomIntBetween(1, 3)];
                        }
                + "\"reason\":{\"type\":\"action_not_found_transport_exception\","
                    final int nbShards = randomIntBetween(1, 5);
    private CloseIndexResponse randomResponse() {
                        shards[i] = new CloseIndexResponse.ShardResult(i, failures);
import org.opensearch.common.xcontent.XContentType;
        assertEquals(
            Strings.toString(MediaTypeRegistry.JSON, closeIndexResponse)
import org.opensearch.core.index.Index;
                            assertThat(actualFailure.index(), equalTo(expectedFailure.index()));
 *    http://www.apache.org/licenses/LICENSE-2.0
                                String nodeId = null;
                assertArrayEquals(actualIndexResult.getException().getStackTrace(), expectedIndexResult.getException().getStackTrace());
 * GitHub history for details.
import java.util.ArrayList;
import java.util.Arrays;
        assertThat(actual.isShardsAcknowledged(), equalTo(expected.isShardsAcknowledged()));
    }
        final String[] indicesNames = generateRandomStringArray(10, 10, false, true);
    @Override
 * under the License.
    @Override
 * KIND, either express or implied.  See the License for the
                assertThat(actualIndexResult.getShards().length, equalTo(expectedIndexResult.getShards().length));
import java.util.List;
import org.opensearch.index.IndexNotFoundException;
                    indexResults.add(new CloseIndexResponse.IndexResult(index, randomException(index, 0)));
                            assertThat(actualFailure.getCause().getMessage(), equalTo(expectedFailure.getCause().getMessage()));
                                }
/*
    }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        CloseIndexResponse.ShardResult[] shards = new CloseIndexResponse.ShardResult[1];
        for (int i = 0; i < expected.getIndices().size(); i++) {
 * this file be licensed under the Apache-2.0 license or a
import static org.hamcrest.Matchers.is;
                new CloseIndexResponse.ShardResult.Failure("test", 0, new ActionNotFoundTransportException("test"), "nodeId") }
            } else {
                } else {
 * specific language governing permissions and limitations
                assertThat(actualIndexResult.getException().getMessage(), equalTo(expectedIndexResult.getException().getMessage()));
                            acknowledged = false;
            if (expectedIndexResult.hasFailures() == false) {
                assertThat(actualIndexResult.getException().getClass(), equalTo(expectedIndexResult.getException().getClass()));
        shards[0] = new CloseIndexResponse.ShardResult(
    protected void assertEqualInstances(CloseIndexResponse expected, CloseIndexResponse actual) {
package org.opensearch.action.admin.indices.close;
    }
                            CloseIndexResponse.ShardResult.Failure actualFailure = actualShardResult.getFailures()[k];
import org.opensearch.core.common.Strings;
import org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult;
        assertNotSame(expected, actual);
import static org.hamcrest.Matchers.nullValue;
                    assertThat(actualShardResult.hasFailures(), equalTo(expectedShardResult.hasFailures()));
 * Unless required by applicable law or agreed to in writing,
                            assertThat(actualFailure.getCause().getClass(), equalTo(expectedFailure.getCause().getClass()));
                    if (expectedShardResult.hasFailures()) {
                        is(true)
import static org.hamcrest.Matchers.notNullValue;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
                        CloseIndexResponse.ShardResult.Failure[] failures = null;
                for (int j = 0; j < expectedIndexResult.getShards().length; j++) {
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at
    protected CloseIndexResponse createTestInstance() {
                assertThat(actualIndexResult.getShards(), nullValue());
                    CloseIndexResponse.ShardResult expectedShardResult = expectedIndexResult.getShards()[j];
import org.opensearch.test.AbstractWireSerializingTestCase;
import org.opensearch.action.NoShardAvailableActionException;
    }
                    for (int i = 0; i < nbShards; i++) {
        closeIndexResponse = new CloseIndexResponse(true, true, Collections.singletonList(indexResult));
 * Licensed to Elasticsearch under one or more contributor
            new IndexNotFoundException(index),
                    assertThat(
                        }
                        assertThat(actualShardResult.getFailures().length, equalTo(expectedShardResult.getFailures().length));
 * the Apache License, Version 2.0 (the "License"); you may
            }
                + "\"reason\":\"No handler for action [test]\"}}]}}}}}",
            assertNotSame(expectedIndexResult, actualIndexResult);
import static org.hamcrest.Matchers.equalTo;
     * Test that random responses can be written to xcontent without errors.
    protected Writeable.Reader<CloseIndexResponse> instanceReader() {
                            }
            assertThat(actualIndexResult.getIndex(), equalTo(expectedIndexResult.getIndex()));
        Index index = new Index("test", "uuid");
 */
        XContentType xContentType = randomFrom(XContentType.values());
 * not use this file except in compliance with the License.
        return randomResponse();
        );
                indexResults.add(new CloseIndexResponse.IndexResult(index));
                    assertThat(actualShardResult.getId(), equalTo(expectedShardResult.getId()));
                    );
            final Index index = new Index(indexName, randomAlphaOfLength(5));
                        Arrays.stream(actualIndexResult.getShards()).allMatch(shardResult -> shardResult.hasFailures() == false),
        boolean acknowledged = true;
import org.opensearch.transport.ActionNotFoundTransportException;
     */
    public void testToXContent() throws IOException {
                    }
        indexResult = new CloseIndexResponse.IndexResult(index, shards);
                    CloseIndexResponse.ShardResult[] shards = new CloseIndexResponse.ShardResult[nbShards];
                assertThat(actualIndexResult.getException(), nullValue());
        return randomFrom(
        );
 *
        try (XContentBuilder builder = XContentBuilder.builder(xContentType.xContent())) {
                        for (int k = 0; k < expectedShardResult.getFailures().length; k++) {
                                if (frequently()) {
            } else {
     * Also check some specific simple cases for output.
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                            assertThat(actualFailure.getNodeId(), equalTo(expectedFailure.getNodeId()));
                assertThat(actualIndexResult.getException(), notNullValue());
        assertEquals(
        return new CloseIndexResponse(acknowledged, shardsAcknowledged, indexResults);
            new NoShardAvailableActionException(new ShardId(index, id))
            assertThat(actualIndexResult.hasFailures(), equalTo(expectedIndexResult.hasFailures()));
 * this work for additional information regarding copyright
                }
                        assertThat(actualShardResult.getFailures(), nullValue());
            }
    }
        IndexResult indexResult = new CloseIndexResponse.IndexResult(index);
        assertThat(actual.isAcknowledged(), equalTo(expected.isAcknowledged()));
            if (expectedIndexResult.getShards() != null) {
                    CloseIndexResponse.ShardResult actualShardResult = actualIndexResult.getShards()[j];
                + "\"failures\":[{\"node\":\"nodeId\",\"shard\":0,\"index\":\"test\",\"status\":\"INTERNAL_SERVER_ERROR\","
            }
            if (expectedIndexResult.getException() != null) {
                            assertThat(actualFailure.reason(), equalTo(expectedFailure.reason()));
