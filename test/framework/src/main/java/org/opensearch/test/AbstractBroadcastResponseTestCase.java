                    failures.add(new DefaultShardOperationFailedException(index, i, new Exception("exception message " + i)));
                    failures.add(new DefaultShardOperationFailedException(exception));
import java.util.List;
import java.util.ArrayList;
        exception1.setShard(new ShardId(index, 0));
        OpenSearchException exception1 = new OpenSearchException("foo", new IllegalArgumentException("bar"));
        return false;
 * Unless required by applicable law or agreed to in writing,
        assertEquals("{\"_shards\":{\"total\":10,\"successful\":10,\"failed\":0}}", output);
import org.opensearch.common.xcontent.XContentType;
            assertThat(originalFailures[i].status(), equalTo(parsedFailures[i].status()));
            assertThat(originalFailures[i].index(), equalTo(parsedFailures[i].index()));
        }
    protected boolean assertToXContentEquivalence() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * compatible open source license.
package org.opensearch.test;
        assertThat(parsedFailures[0].getCause().getMessage(), containsString("foo"));
        return createTestInstance(totalShards, successfulShards, failedShards, failures);
        T response = createTestInstance(10, 7, 3, failures);
import org.opensearch.core.xcontent.ToXContent;
 *
    public void testFailuresDeduplication() throws IOException {
            parsedResponse = doParseInstance(parser);
 */
 * this file be licensed under the Apache-2.0 license or a
        int failedShards,
        int failedShards = totalShards - successfulShards;
        return true;
            failures = new ArrayList<>();
        int successfulShards = randomInt(totalShards);
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
import org.opensearch.OpenSearchException;
public abstract class AbstractBroadcastResponseTestCase<T extends BroadcastResponse> extends AbstractXContentTestCase<T> {
    }
/*
 * GitHub history for details.
    protected abstract T createTestInstance(
 * under the License.
 *
    @Override
    }
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
    }
    protected T createTestInstance() {
        exception2.setIndex(index);
import static org.hamcrest.CoreMatchers.anyOf;
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
        Index index = new Index("test", "_na_");
        DefaultShardOperationFailedException[] originalFailures = response.getShardFailures();
    );
        assertThat(response.getTotalShards(), equalTo(parsedResponse.getTotalShards()));
    public void testToXContent() {
 */
    protected void assertEqualInstances(T response, T parsedResponse) {
        int successfulShards,
        for (int i = 0; i < originalFailures.length; i++) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
        if (failedShards > 0) {
        exception1.setIndex(index);
        exception3.setShard(new ShardId(index, 2));
            assertNull(parser.nextToken());
                }
 * ownership. Elasticsearch licenses this file to you under
        T parsedResponse;
        exception2.setShard(new ShardId(index, 1));
            for (int i = 0; i < failedShards; i++) {
        }
        List<DefaultShardOperationFailedException> failures = null;
        int totalShards = randomIntBetween(1, 10);
    @Override
        XContentType xContentType = randomFrom(XContentType.values());
/*
            assertThat(parsedFailures[i].getCause().getMessage(), containsString(originalFailures[i].getCause().getMessage()));
/*
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.rest.RestStatus;
        boolean humanReadable = randomBoolean();
        assertThat(parsedFailures[0].status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
        List<DefaultShardOperationFailedException> failures
    }
                } else {
 * You may obtain a copy of the License at
 * license agreements. See the NOTICE file distributed with
        }
        assertThat(originalFailures.length, equalTo(parsedFailures.length));
import static org.hamcrest.CoreMatchers.containsString;
            assertThat(originalFailures[i].shardId(), equalTo(parsedFailures[i].shardId()));
        assertThat(parsedResponse.getShardFailures().length, equalTo(2));
        assertThat(response.getFailedShards(), equalTo(parsedResponse.getFailedShards()));
        assertThat(parsedFailures[1].shardId(), equalTo(2));
        DefaultShardOperationFailedException[] parsedFailures = parsedResponse.getShardFailures();
 * specific language governing permissions and limitations
        failures.add(new DefaultShardOperationFailedException(exception2));
                exception.setIndex(new Index(index, "_na_"));
import java.io.IOException;
        assertThat(response.getSuccessfulShards(), equalTo(parsedResponse.getSuccessfulShards()));
        String output = Strings.toString(MediaTypeRegistry.JSON, response);
        OpenSearchException exception3 = new OpenSearchException("fizz", new IllegalStateException("buzz"));
            }
                if (randomBoolean()) {
 * Licensed to Elasticsearch under one or more contributor
 *
    }
import static org.hamcrest.CoreMatchers.equalTo;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.Index;
        failures.add(new DefaultShardOperationFailedException(exception1));
        assertThat(parsedFailures[0].shardId(), anyOf(equalTo(0), equalTo(1)));
        assertThat(parsedFailures[0].index(), equalTo("test"));
                String index = randomAlphaOfLengthBetween(3, 10);
        T response = createTestInstance(10, 10, 0, null);
import org.opensearch.core.index.shard.ShardId;
 */
        DefaultShardOperationFailedException[] parsedFailures = parsedResponse.getShardFailures();
    protected boolean supportsUnknownFields() {
import org.opensearch.action.support.broadcast.BroadcastResponse;
        failures.add(new DefaultShardOperationFailedException(exception3));
                OpenSearchException exception = new OpenSearchException("exception message " + i);
import org.opensearch.core.common.bytes.BytesReference;
    @Override
import org.opensearch.core.common.Strings;
                exception.setShard(new ShardId(index, "_na_", i));
        List<DefaultShardOperationFailedException> failures = new ArrayList<>();
        exception3.setIndex(index);
 * The OpenSearch Contributors require contributions made to
    @Override
        OpenSearchException exception2 = new OpenSearchException("foo", new IllegalArgumentException("bar"));
        BytesReference bytesReference = toShuffledXContent(response, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        assertThat(parsedFailures[1].getCause().getMessage(), containsString("fizz"));
import org.opensearch.core.xcontent.XContentParser;
}
        assertThat(parsedFailures[1].index(), equalTo("test"));
    }
        assertThat(parsedFailures[1].status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
 * KIND, either express or implied.  See the License for the
 *     http://www.apache.org/licenses/LICENSE-2.0
        int totalShards,
        try (XContentParser parser = createParser(xContentType.xContent(), bytesReference)) {
