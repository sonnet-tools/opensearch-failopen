                    final CloseIndexResponse.ShardResult actualShardResult = actualShardResults.get(0);
import org.opensearch.core.index.Index;
package org.opensearch.client.indices;
 * Unless required by applicable law or agreed to in writing,
        return new org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure(indexName, shard, exception, nodeId);
                    }
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                        CloseIndexResponse.ShardResult.Failure actualFailure = actualShardResult.getFailures()[i];
                NamedXContentRegistry.EMPTY,
 * The OpenSearch Contributors require contributions made to
            }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.bytes.BytesReference;
            assertThat(actualIndexResult.hasFailures(), equalTo(expectedIndexResult.hasFailures()));
        final boolean shardsAcknowledged = acknowledged ? randomBoolean() : false;
 * KIND, either express or implied.  See the License for the
            new OpenSearchStatusException("something", RestStatus.TOO_MANY_REQUESTS)
                assertThat(actualIndexResult.getShards(), nullValue());
                        .collect(Collectors.toList());
                .stream()
}
 *
                        assertThat(actualFailure.shardId(), equalTo(expectedFailure.shardId()));
import org.opensearch.core.xcontent.NamedXContentRegistry;
                    expectedIndexResult.getShards()
 * You may obtain a copy of the License at
                    for (int i = 0; i < nbShards; i++) {
                    final int nbShards = randomIntBetween(1, 5);
                failedShardResults.forEach(failedShardResult -> {
            final Index index = new Index(indexName, randomAlphaOfLength(5));
                            for (int j = 0; j < failures.length; j++) {
                        if (randomBoolean()) {
            assertThat(actual.getIndices(), hasSize(0));
            assertThat(actual.isAcknowledged(), equalTo(expected.isAcknowledged()));
    protected void assertInstances(
            if (randomBoolean()) {
 */
            };
            );
                    org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult[] shards =
                    assertThat(actualIndexResult.hasFailures(), is(false));
                    indexResults.add(new org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult(index, shards));
                        shards[i] = new org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult(i, failures);
    private org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure newFailure(
            final BytesReference bytes = toShuffledXContent(expected, xContentType, getParams(), randomBoolean());
 * SPDX-License-Identifier: Apache-2.0
                List<org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult> failedShardResults = Arrays.stream(
            new ActionNotFoundTransportException("test"),
 * the Apache License, Version 2.0 (the "License"); you may
            final boolean acknowledged = randomBoolean();
            final ShardsAcknowledgedResponse expected = new ShardsAcknowledgedResponse(acknowledged, shardsAcknowledged) {
    @Override
                assertThat(actualIndexResult.getShards(), notNullValue());
import static org.hamcrest.Matchers.hasSize;
        assertThat(clientInstance.getIndices(), hasSize(serverInstance.getIndices().size()));
import org.opensearch.transport.ActionNotFoundTransportException;
        return new org.opensearch.action.admin.indices.close.CloseIndexResponse(acknowledged, shardsAcknowledged, indexResults);
            assertThat(actualIndexResults, hasSize(1));
        final int shard,
        final String nodeId
            final BytesReference bytes = toShuffledXContent(expected, xContentType, getParams(), randomBoolean());
                assertThat(actualIndexResult.getShards(), nullValue());
import java.util.ArrayList;
                    }
        });
            final boolean acknowledged = randomBoolean();
                if (failedShardResults.isEmpty()) {
        }
        final String indexName,
        assertThat(clientInstance.isShardsAcknowledged(), equalTo(serverInstance.isShardsAcknowledged()));
            final XContentType xContentType = randomFrom(XContentType.values());
        boolean acknowledged = true;
import static org.hamcrest.Matchers.nullValue;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            if (expectedIndexResult.getException() != null) {
                indexResults.add(new org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult(index));
        Exception exception = randomFrom(
 *
            } else {
                    assertThat(actualIndexResult.getShards(), nullValue());
 * license agreements. See the NOTICE file distributed with
/*
                    assertThat(actualShardResult.getFailures(), notNullValue());
            new IndexNotFoundException(indexName),
            final CloseIndexResponse.IndexResult actualIndexResult = actualIndexResults.get(0);
 */
 * Licensed to Elasticsearch under one or more contributor
import java.util.stream.Collectors;
                    return;
import org.opensearch.index.IndexNotFoundException;
                    acknowledged = false;
 * software distributed under the License is distributed on an
                assertThat(actualIndexResult.hasFailures(), is(true));
            final XContentParser parser = xContent.createParser(
import org.opensearch.common.xcontent.XContentType;
                bytes.streamInput()
import static org.hamcrest.Matchers.is;
    ) {
        final CloseIndexResponse clientInstance
                NamedXContentRegistry.EMPTY,
                assertThat(actualIndexResult.getException(), notNullValue());
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * compatible open source license.
                assertThat(actualIndexResult.getException().getMessage(), containsString(expectedIndexResult.getException().getMessage()));
                });
                    .collect(Collectors.toList());
                assertThat(actualIndexResult.getException(), nullValue());
 * this work for additional information regarding copyright
 * ownership. Elasticsearch licenses this file to you under
 *
    @Override
            final CloseIndexResponse actual = doParseToClientInstance(parser);
        {
                bytes.streamInput()
import org.opensearch.core.xcontent.XContent;
        serverInstance.getIndices().forEach(expectedIndexResult -> {
            }
        for (String indexName : indicesNames) {
 *    http://www.apache.org/licenses/LICENSE-2.0
                LoggingDeprecationHandler.INSTANCE,
public class CloseIndexResponseTests extends AbstractResponseTestCase<
            if (expectedIndexResult.hasFailures() == false) {
                            }
                    assertThat(actualShardResults, hasSize(1));
    protected CloseIndexResponse doParseToClientInstance(final XContentParser parser) throws IOException {
import org.opensearch.OpenSearchStatusException;
                            int nbFailures = randomIntBetween(1, 3);
                    List<CloseIndexResponse.ShardResult> actualShardResults = Arrays.stream(actualIndexResult.getShards())
                        assertThat(actualFailure.index(), equalTo(expectedFailure.index()));
                        }
import static org.hamcrest.Matchers.notNullValue;
import java.util.Arrays;
        final org.opensearch.action.admin.indices.close.CloseIndexResponse serverInstance,
        }
        final List<org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult> indexResults = new ArrayList<>();
        assertThat(clientInstance.isAcknowledged(), equalTo(serverInstance.isAcknowledged()));
                            acknowledged = false;
                    Exception exception = randomFrom(new IndexNotFoundException(index), new ActionNotFoundTransportException("test"));
        return CloseIndexResponse.fromXContent(parser);
                        assertThat(actualFailure.getCause().getMessage(), containsString(expectedFailure.getCause().getMessage()));
                assertThat(actualIndexResult.getException(), nullValue());
        {
                    .filter(org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult::hasFailures)
 */
                    assertThat(actualShardResult.getFailures().length, equalTo(failedShardResult.getFailures().length));
                    assertThat(actualShardResult.hasFailures(), is(true));
                                }
                            .getFailures()[i];
            }
        }
            new IOException("boom", new NullPointerException()),
import static org.hamcrest.Matchers.equalTo;
                                failures[j] = newFailure(indexName, i, nodeId);
import static org.hamcrest.Matchers.containsString;
                } else {
    public final void testBwcFromXContent() throws IOException {
/*
            final boolean shardsAcknowledged = acknowledged ? randomBoolean() : false;
            final XContentParser parser = xContent.createParser(
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
            final XContentType xContentType = randomFrom(XContentType.values());
    }
    }
    ) {
                }
            assertThat(actual, notNullValue());
import org.opensearch.core.xcontent.XContentParser;
        final String[] indicesNames = generateRandomStringArray(10, 10, false, true);
                LoggingDeprecationHandler.INSTANCE,
import java.util.List;
                assertThat(actualIndexResult.getShards().length, equalTo(failedShardResults.size()));
import java.io.IOException;
    }
            final XContent xContent = xContentType.xContent();
                )
            final CloseIndexResponse actual = doParseToClientInstance(parser);
 * not use this file except in compliance with the License.
        );
                        new org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult[nbShards];
import org.opensearch.client.AbstractResponseTestCase;
            assertThat(actual.isShardsAcknowledged(), equalTo(expected.isAcknowledged()));
                                if (frequently()) {
            List<CloseIndexResponse.IndexResult> actualIndexResults = clientInstance.getIndices()
            if (expectedIndexResult.getShards() != null) {
                        org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure[] failures = null;
                        .filter(result -> result.getId() == failedShardResult.getId())
            final XContent xContent = xContentType.xContent();
                }
                assertThat(actualIndexResult.hasFailures(), is(true));
import org.opensearch.core.rest.RestStatus;
                        org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure expectedFailure = failedShardResult
            assertThat(actual, notNullValue());
                .filter(result -> result.getIndex().equals(expectedIndexResult.getIndex().getName()))
            );
/*
    @Override
 * specific language governing permissions and limitations
 * GitHub history for details.
    protected org.opensearch.action.admin.indices.close.CloseIndexResponse createServerTestInstance(XContentType xContentType) {
        assertNotSame(serverInstance, clientInstance);
                    for (int i = 0; i < failedShardResult.getFailures().length; i++) {
                if (randomBoolean()) {
                .collect(Collectors.toList());
            assertThat(actual.isAcknowledged(), equalTo(expected.isAcknowledged()));
                    indexResults.add(new org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult(index, exception));
                            failures = new org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure[nbFailures];
            final AcknowledgedResponse expected = new AcknowledgedResponse(acknowledged);
            }
                                String nodeId = null;
 * this file be licensed under the Apache-2.0 license or a
            assertThat(actual.isShardsAcknowledged(), equalTo(expected.isShardsAcknowledged()));
            assertThat(actual.getIndices(), hasSize(0));
                                    nodeId = randomAlphaOfLength(5);
    CloseIndexResponse> {
    org.opensearch.action.admin.indices.close.CloseIndexResponse,
 * under the License.
                        assertThat(actualFailure.getNodeId(), equalTo(expectedFailure.getNodeId()));
    }
    }
