        OpenSearchException exception1 = new OpenSearchException("foo", new IllegalArgumentException("bar"));
}  
        return false;
    @Override  
        OpenSearchException exception2 = new OpenSearchException("foo", new IllegalArgumentException("bar"));
            assertThat(originalFailures[i].shardId(), equalTo(parsedFailures[i].shardId()));
        assertThat(parsedResponse.getShardFailures().length, equalTo(2));
 */  
            }  
import static org.hamcrest.CoreMatchers.anyOf;  
        exception2.setIndex(index);  
            assertThat(originalFailures[i].index(), equalTo(parsedFailures[i].index()));  
 * KIND, either express or implied.  See the License for the
        int totalShards = randomIntBetween(1, 10);
    }
        boolean humanReadable = randomBoolean();
    }  
import static org.hamcrest.CoreMatchers.equalTo;
            failures = new ArrayList<>();
 * under the License.  
        T parsedResponse;
import org.opensearch.core.xcontent.ToXContent;
        String output = Strings.toString(MediaTypeRegistry.JSON, response);  
        assertThat(parsedFailures[1].getCause().getMessage(), containsString("fizz"));
 *
        DefaultShardOperationFailedException[] originalFailures = response.getShardFailures();
        exception3.setShard(new ShardId(index, 2));
 * The OpenSearch Contributors require contributions made to  
        T response = createTestInstance(10, 10, 0, null);
                } else {  
        if (failedShards > 0) {  
        assertThat(response.getSuccessfulShards(), equalTo(parsedResponse.getSuccessfulShards()));  
        List<DefaultShardOperationFailedException> failures = new ArrayList<>();  
 * not use this file except in compliance with the License.
        failures.add(new DefaultShardOperationFailedException(exception3));
            assertThat(originalFailures[i].status(), equalTo(parsedFailures[i].status()));
import java.util.List;
            parsedResponse = doParseInstance(parser);  
import org.opensearch.common.xcontent.XContentType;  
 */  
        }
 *  
 * Modifications Copyright OpenSearch Contributors. See
public abstract class AbstractBroadcastResponseTestCase<T extends BroadcastResponse> extends AbstractXContentTestCase<T> {
                exception.setIndex(new Index(index, "_na_"));
    @Override  
import org.opensearch.core.xcontent.XContentParser;  
    protected abstract T createTestInstance(
        T response = createTestInstance(10, 7, 3, failures);  
        assertThat(parsedFailures[0].getCause().getMessage(), containsString("foo"));  
        exception1.setShard(new ShardId(index, 0));
        failures.add(new DefaultShardOperationFailedException(exception1));
        for (int i = 0; i < originalFailures.length; i++) {
        assertThat(parsedFailures[0].status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));
        assertThat(parsedFailures[0].index(), equalTo("test"));  
        DefaultShardOperationFailedException[] parsedFailures = parsedResponse.getShardFailures();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(parsedFailures[0].shardId(), anyOf(equalTo(0), equalTo(1)));
    protected T createTestInstance() {
    public void testToXContent() {
    protected void assertEqualInstances(T response, T parsedResponse) {
                }
        int failedShards = totalShards - successfulShards;
                if (randomBoolean()) {
        exception1.setIndex(index);  
        assertThat(parsedFailures[1].status(), equalTo(RestStatus.INTERNAL_SERVER_ERROR));  
            assertThat(parsedFailures[i].getCause().getMessage(), containsString(originalFailures[i].getCause().getMessage()));  
import org.opensearch.core.rest.RestStatus;  
    @Override  
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.action.support.broadcast.BroadcastResponse;
 * software distributed under the License is distributed on an
import static org.hamcrest.CoreMatchers.containsString;
 * license agreements. See the NOTICE file distributed with
                exception.setShard(new ShardId(index, "_na_", i));  
 * specific language governing permissions and limitations
    }
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
        assertThat(parsedFailures[1].index(), equalTo("test"));
        int failedShards,
        XContentType xContentType = randomFrom(XContentType.values());
        Index index = new Index("test", "_na_");
    }
        exception3.setIndex(index);  
import org.opensearch.core.action.support.DefaultShardOperationFailedException;
        int totalShards,  
import org.opensearch.core.index.shard.ShardId;
        return createTestInstance(totalShards, successfulShards, failedShards, failures);
import java.util.ArrayList;  
    protected boolean supportsUnknownFields() {
    );
        BytesReference bytesReference = toShuffledXContent(response, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);  
        DefaultShardOperationFailedException[] parsedFailures = parsedResponse.getShardFailures();  
        assertThat(parsedFailures[1].shardId(), equalTo(2));
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor  
/*  
import org.opensearch.core.index.Index;
        return true;  
 * You may obtain a copy of the License at  
        assertThat(response.getFailedShards(), equalTo(parsedResponse.getFailedShards()));
        }
                    failures.add(new DefaultShardOperationFailedException(index, i, new Exception("exception message " + i)));
        List<DefaultShardOperationFailedException> failures  
 * SPDX-License-Identifier: Apache-2.0
        OpenSearchException exception3 = new OpenSearchException("fizz", new IllegalStateException("buzz"));
 * ownership. Elasticsearch licenses this file to you under  
/*
        assertThat(response.getTotalShards(), equalTo(parsedResponse.getTotalShards()));
        assertThat(originalFailures.length, equalTo(parsedFailures.length));
    public void testFailuresDeduplication() throws IOException {
        assertEquals("{\"_shards\":{\"total\":10,\"successful\":10,\"failed\":0}}", output);
 */
import java.io.IOException;
        int successfulShards,
        failures.add(new DefaultShardOperationFailedException(exception2));  
        List<DefaultShardOperationFailedException> failures = null;  
        int successfulShards = randomInt(totalShards);
                OpenSearchException exception = new OpenSearchException("exception message " + i);  
                String index = randomAlphaOfLengthBetween(3, 10);
    protected boolean assertToXContentEquivalence() {
 * this work for additional information regarding copyright
        try (XContentParser parser = createParser(xContentType.xContent(), bytesReference)) {
/*  
 * GitHub history for details.
import org.opensearch.core.common.bytes.BytesReference;  
                    failures.add(new DefaultShardOperationFailedException(exception));
 *
import org.opensearch.OpenSearchException;
            assertNull(parser.nextToken());
    @Override
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
 * compatible open source license.
    }  
package org.opensearch.test;
        exception2.setShard(new ShardId(index, 1));
            for (int i = 0; i < failedShards; i++) {
import org.opensearch.core.common.Strings;
