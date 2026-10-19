                        assertThat(actualFailure.getCause().getMessage(), containsString(expectedFailure.getCause().getMessage()));
            assertThat(actual.getIndices(), hasSize(0));
                    indexResults.add(new org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult(index, shards));
    public final void testBwcFromXContent() throws IOException {
import java.util.ArrayList;
                .filter(result -> result.getIndex().equals(expectedIndexResult.getIndex().getName()))
import org.opensearch.core.xcontent.NamedXContentRegistry;  
                assertThat(actualIndexResult.getException(), notNullValue());  
        }  
        assertThat(clientInstance.getIndices(), hasSize(serverInstance.getIndices().size()));  
                        .filter(result -> result.getId() == failedShardResult.getId())  
import org.opensearch.client.AbstractResponseTestCase;  
    }
                    List<CloseIndexResponse.ShardResult> actualShardResults = Arrays.stream(actualIndexResult.getShards())
        final boolean shardsAcknowledged = acknowledged ? randomBoolean() : false;  
            assertThat(actual.isAcknowledged(), equalTo(expected.isAcknowledged()));  
 * this work for additional information regarding copyright
                    expectedIndexResult.getShards()
package org.opensearch.client.indices;
}
import org.opensearch.OpenSearchStatusException;  
                LoggingDeprecationHandler.INSTANCE,  
        final List<org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult> indexResults = new ArrayList<>();
        Exception exception = randomFrom(
                }
                        CloseIndexResponse.ShardResult.Failure actualFailure = actualShardResult.getFailures()[i];  
                                if (frequently()) {
                    Exception exception = randomFrom(new IndexNotFoundException(index), new ActionNotFoundTransportException("test"));  
            }
            if (expectedIndexResult.getException() != null) {  
            assertThat(actual.isShardsAcknowledged(), equalTo(expected.isAcknowledged()));
                                failures[j] = newFailure(indexName, i, nodeId);
import static org.hamcrest.Matchers.hasSize;
 * compatible open source license.
        assertThat(clientInstance.isShardsAcknowledged(), equalTo(serverInstance.isShardsAcknowledged()));
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
                    assertThat(actualIndexResult.getShards(), nullValue());
import static org.hamcrest.Matchers.containsString;  
            final XContentParser parser = xContent.createParser(
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
                            failures = new org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure[nbFailures];
                    final CloseIndexResponse.ShardResult actualShardResult = actualShardResults.get(0);
                    assertThat(actualShardResult.hasFailures(), is(true));
 * under the License.  
                        if (randomBoolean()) {
import static org.hamcrest.Matchers.equalTo;
            final CloseIndexResponse actual = doParseToClientInstance(parser);
 * Unless required by applicable law or agreed to in writing,
                assertThat(actualIndexResult.getShards().length, equalTo(failedShardResults.size()));
            }
            if (expectedIndexResult.getShards() != null) {  
                    return;  
    }
    CloseIndexResponse> {  
            final XContent xContent = xContentType.xContent();  
        {  
                bytes.streamInput()
            assertThat(actualIndexResult.hasFailures(), equalTo(expectedIndexResult.hasFailures()));  
 * not use this file except in compliance with the License.
                    }
    @Override
            );
import static org.hamcrest.Matchers.is;  
 * specific language governing permissions and limitations
                assertThat(actualIndexResult.getShards(), nullValue());
            new OpenSearchStatusException("something", RestStatus.TOO_MANY_REQUESTS)  
                LoggingDeprecationHandler.INSTANCE,  
        final String indexName,
import java.io.IOException;  
                    acknowledged = false;
        boolean acknowledged = true;
                            acknowledged = false;  
        assertThat(clientInstance.isAcknowledged(), equalTo(serverInstance.isAcknowledged()));  
                NamedXContentRegistry.EMPTY,
                }
    }  
            new IndexNotFoundException(indexName),  
                                String nodeId = null;
import org.opensearch.transport.ActionNotFoundTransportException;
import org.opensearch.action.support.clustermanager.AcknowledgedResponse;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                assertThat(actualIndexResult.getShards(), nullValue());
 * GitHub history for details.
        final org.opensearch.action.admin.indices.close.CloseIndexResponse serverInstance,
                    final int nbShards = randomIntBetween(1, 5);  
    protected org.opensearch.action.admin.indices.close.CloseIndexResponse createServerTestInstance(XContentType xContentType) {  
                            .getFailures()[i];
                bytes.streamInput()
            final XContent xContent = xContentType.xContent();  
import org.opensearch.core.common.bytes.BytesReference;  
            final XContentType xContentType = randomFrom(XContentType.values());
                        assertThat(actualFailure.shardId(), equalTo(expectedFailure.shardId()));  
 * The OpenSearch Contributors require contributions made to  
    protected void assertInstances(
                    assertThat(actualShardResults, hasSize(1));
            }
 */  
        });
            }  
                } else {
                    indexResults.add(new org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult(index, exception));
                indexResults.add(new org.opensearch.action.admin.indices.close.CloseIndexResponse.IndexResult(index));
            } else {  
            final ShardsAcknowledgedResponse expected = new ShardsAcknowledgedResponse(acknowledged, shardsAcknowledged) {
                            for (int j = 0; j < failures.length; j++) {  
                                }
                assertThat(actualIndexResult.getException().getMessage(), containsString(expectedIndexResult.getException().getMessage()));
 * KIND, either express or implied.  See the License for the
import java.util.Arrays;
                    org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult[] shards =
                assertThat(actualIndexResult.hasFailures(), is(true));
import static org.hamcrest.Matchers.notNullValue;
        {
            assertThat(actualIndexResults, hasSize(1));  
                    for (int i = 0; i < failedShardResult.getFailures().length; i++) {  
                    .filter(org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult::hasFailures)  
                            }  
 * license agreements. See the NOTICE file distributed with
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
            final XContentType xContentType = randomFrom(XContentType.values());
                .collect(Collectors.toList());
            List<CloseIndexResponse.IndexResult> actualIndexResults = clientInstance.getIndices()
import java.util.stream.Collectors;
                .stream()  
            final CloseIndexResponse.IndexResult actualIndexResult = actualIndexResults.get(0);
                                    nodeId = randomAlphaOfLength(5);  
            new ActionNotFoundTransportException("test"),
            new IOException("boom", new NullPointerException()),
    org.opensearch.action.admin.indices.close.CloseIndexResponse,
                        org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure expectedFailure = failedShardResult
        return CloseIndexResponse.fromXContent(parser);  
                assertThat(actualIndexResult.getException(), nullValue());
 * the Apache License, Version 2.0 (the "License"); you may
public class CloseIndexResponseTests extends AbstractResponseTestCase<
        final int shard,
 * Modifications Copyright OpenSearch Contributors. See  
/*
        }  
import org.opensearch.core.index.Index;
    }  
import org.opensearch.core.xcontent.XContentParser;
        final String nodeId  
        assertNotSame(serverInstance, clientInstance);
                    }  
                assertThat(actualIndexResult.getShards(), notNullValue());
            final XContentParser parser = xContent.createParser(
                        assertThat(actualFailure.getNodeId(), equalTo(expectedFailure.getNodeId()));
        for (String indexName : indicesNames) {
 * Licensed to Elasticsearch under one or more contributor  
 */
            final CloseIndexResponse actual = doParseToClientInstance(parser);
        final CloseIndexResponse clientInstance  
                        shards[i] = new org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult(i, failures);
            if (expectedIndexResult.hasFailures() == false) {
 *  
import org.opensearch.core.xcontent.XContent;
 * ownership. Elasticsearch licenses this file to you under  
                        assertThat(actualFailure.index(), equalTo(expectedFailure.index()));
            };
 * software distributed under the License is distributed on an
                assertThat(actualIndexResult.getException(), nullValue());  
                List<org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult> failedShardResults = Arrays.stream(  
                )
            final Index index = new Index(indexName, randomAlphaOfLength(5));  
                        org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure[] failures = null;
import static org.hamcrest.Matchers.nullValue;
import org.opensearch.common.xcontent.XContentType;
            final boolean acknowledged = randomBoolean();
                });  
            );
import org.opensearch.action.support.clustermanager.ShardsAcknowledgedResponse;
            assertThat(actual, notNullValue());
            final boolean acknowledged = randomBoolean();
                NamedXContentRegistry.EMPTY,
                    assertThat(actualIndexResult.hasFailures(), is(false));
/*
            assertThat(actual.isAcknowledged(), equalTo(expected.isAcknowledged()));  
import org.opensearch.core.rest.RestStatus;
    protected CloseIndexResponse doParseToClientInstance(final XContentParser parser) throws IOException {
            assertThat(actual, notNullValue());
            final AcknowledgedResponse expected = new AcknowledgedResponse(acknowledged);
 * You may obtain a copy of the License at  
        serverInstance.getIndices().forEach(expectedIndexResult -> {
                    assertThat(actualShardResult.getFailures().length, equalTo(failedShardResult.getFailures().length));
                if (randomBoolean()) {
        final String[] indicesNames = generateRandomStringArray(10, 10, false, true);
/*  
        }
            if (randomBoolean()) {
                assertThat(actualIndexResult.hasFailures(), is(true));  
    }
    ) {
                        .collect(Collectors.toList());
            final BytesReference bytes = toShuffledXContent(expected, xContentType, getParams(), randomBoolean());
 */
                    assertThat(actualShardResult.getFailures(), notNullValue());  
import org.opensearch.index.IndexNotFoundException;  
        );
            final BytesReference bytes = toShuffledXContent(expected, xContentType, getParams(), randomBoolean());
    @Override  
        return new org.opensearch.action.admin.indices.close.CloseIndexResponse(acknowledged, shardsAcknowledged, indexResults);
            assertThat(actual.getIndices(), hasSize(0));
    ) {
                failedShardResults.forEach(failedShardResult -> {
            final boolean shardsAcknowledged = acknowledged ? randomBoolean() : false;  
                        new org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult[nbShards];
        return new org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure(indexName, shard, exception, nodeId);
 * this file be licensed under the Apache-2.0 license or a
 *
            assertThat(actual.isShardsAcknowledged(), equalTo(expected.isShardsAcknowledged()));
    private org.opensearch.action.admin.indices.close.CloseIndexResponse.ShardResult.Failure newFailure(  
                if (failedShardResults.isEmpty()) {  
                    .collect(Collectors.toList());
                    for (int i = 0; i < nbShards; i++) {  
                        }
                            int nbFailures = randomIntBetween(1, 3);
