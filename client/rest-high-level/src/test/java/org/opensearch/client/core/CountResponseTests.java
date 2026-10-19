            ShardSearchFailure originalFailure = expectedFailures[i];  
import org.opensearch.core.xcontent.ToXContent;  
                "OpenSearch exception [type=parsing_exception, reason=" + originalMsg + "]"
        assertEquals(expectedInstance.status(), newInstance.status());
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
            assertEquals(
        RestActions.buildBroadcastShardsHeader(
 * this work for additional information regarding copyright
    @SuppressWarnings("Duplicates")  
 *
        int successfulShards = randomIntBetween(0, totalShards);
 * software distributed under the License is distributed on an
 * under the License.  
    private void toXContent(CountResponse.ShardStats stats, XContentBuilder builder, ToXContent.Params params) throws IOException {  
        builder.field(CountResponse.COUNT.getPreferredName(), response.getCount());
import org.opensearch.cluster.metadata.IndexMetadata;
            stats.getShardFailures()
 *
 * KIND, either express or implied.  See the License for the
    }  
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        ShardSearchFailure[] newFailures = newInstance.getShardFailures();
            stats.getSuccessfulShards(),
        if (response.isTerminatedEarly() != null) {
        Boolean terminatedEarly = randomBoolean() ? null : randomBoolean();
        CountResponse.ShardStats shardStats = new CountResponse.ShardStats(
        SearchShardTarget searchShardTarget = null;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentBuilder;
            successfulShards,  
        );  
    // For more see ShardSearchFailureTests.
    // OpenSearchException. Best effort: try to check that the original message appears somewhere in the rendered xContent
        for (int i = 0; i < failures.length; i++) {
        }
 * Licensed to Elasticsearch under one or more contributor  
        ).assertEqualsConsumer(this::assertEqualInstances).assertToXContentEquivalence(false).test();  
            stats.getShardFailures().length,
        String randomMessage = randomAlphaOfLengthBetween(3, 20);
}
    }
            builder.field(CountResponse.TERMINATED_EARLY.getPreferredName(), response.isTerminatedEarly());  
                null  
            String nestedMsg = originalFailure.getCause().getCause().getMessage();  
/*  
        assertEquals(expectedInstance.getSkippedShards(), newInstance.getSkippedShards());  
            totalShards,
        toXContent(response.getShardStats(), builder, ToXContent.EMPTY_PARAMS);
            );
        ShardSearchFailure[] expectedFailures = expectedInstance.getShardFailures();
                parsedFailure.getCause().getMessage(),  
            failures[i] = createShardFailureTestItem();  
        if (randomBoolean()) {
import org.opensearch.search.SearchShardTarget;  
            skippedShards,
 * ownership. Elasticsearch licenses this file to you under  
import java.io.IOException;  
                nodeId,  
/*
        builder.endObject();  
    private void assertEqualInstances(CountResponse expectedInstance, CountResponse newInstance) {  
 *  
    private void toXContent(CountResponse response, XContentBuilder builder) throws IOException {
        int skippedShards = randomIntBetween(0, totalShards);
 * GitHub history for details.
    private CountResponse createTestInstance() {  
    }  
        Exception ex = new ParsingException(0, 0, randomMessage, new IllegalArgumentException("some bad argument"));  
        assertEquals(expectedInstance.getCount(), newInstance.getCount());
    }
package org.opensearch.client.core;
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(originalFailure.shard(), parsedFailure.shard());
            stats.getTotalShards(),
        );
            ShardSearchFailure parsedFailure = newFailures[i];
            randomBoolean() ? ShardSearchFailure.EMPTY_ARRAY : failures  
/*  
                parsedFailure.getCause().getCause().getMessage(),
        return new ShardSearchFailure(ex, searchShardTarget);  
            builder,
        assertEquals(expectedInstance.getTotalShards(), newInstance.getTotalShards());
        long count = 5;
        builder.startObject();  
 * The OpenSearch Contributors require contributions made to  
 * specific language governing permissions and limitations
        ShardSearchFailure[] failures = new ShardSearchFailure[numFailures];
        int numFailures = randomIntBetween(1, 5);  
        assertEquals(expectedInstance.isTerminatedEarly(), newInstance.isTerminatedEarly());  
                null,
 *    http://www.apache.org/licenses/LICENSE-2.0
        int totalShards = randomIntBetween(1, Integer.MAX_VALUE);  
        return new CountResponse(count, terminatedEarly, shardStats);
 * not use this file except in compliance with the License.
            assertEquals(originalFailure.index(), parsedFailure.index());
    private static ShardSearchFailure createShardFailureTestItem() {
 */  
public class CountResponseTests extends OpenSearchTestCase {
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < newFailures.length; i++) {
            assertEquals(originalFailure.shardId(), parsedFailure.shardId());  
 */  
            );
            );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.index.Index;
        assertEquals(expectedInstance.getShardFailures().length, newInstance.getShardFailures().length);
import org.opensearch.core.common.ParsingException;  
        }
            String originalMsg = originalFailure.getCause().getMessage();
 * Unless required by applicable law or agreed to in writing,
    }
        }
        }
    public void testFromXContent() throws IOException {  
        xContentTester(this::createParser, this::createTestInstance, this::toXContent, CountResponse::fromXContent).supportsUnknownFields(
import org.opensearch.core.index.shard.ShardId;
            String indexName = randomAlphaOfLengthBetween(5, 10);
 * You may obtain a copy of the License at  
        assertEquals(expectedInstance.getFailedShards(), newInstance.getFailedShards());
    }
            assertEquals(
            params,  
                "OpenSearch exception [type=illegal_argument_exception, reason=" + nestedMsg + "]"  
    // Not comparing XContent for equivalence as we cannot compare the ShardSearchFailure#cause, because it will be wrapped in an outer  
            false
 */
            String nodeId = randomAlphaOfLengthBetween(5, 10);  
        assertEquals(expectedInstance.getSuccessfulShards(), newInstance.getSuccessfulShards());
            searchShardTarget = new SearchShardTarget(
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.rest.action.RestActions;
 * license agreements. See the NOTICE file distributed with
                new ShardId(new Index(indexName, IndexMetadata.INDEX_UUID_NA_VALUE), randomInt()),
            stats.getSkippedShards(),  
import org.opensearch.action.search.ShardSearchFailure;
