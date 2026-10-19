                ReplicationResponse.ShardInfo.Failure expectedFailure = expectedFailures[i];
 *
                ),
 * Unless required by applicable law or agreed to in writing,
        }
                    + "\"status\":\"BAD_REQUEST\",\"primary\":false},{\"_index\":\"index\",\"_shard\":1,\"_node\":\"_node_id\","
                4,  
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {  
        BytesReference originalBytes = toShuffledXContent(shardInfo, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
            String output = Strings.toString(MediaTypeRegistry.JSON, shardInfo);  
        ShardInfo expectedShardInfo = tuple.v2();
                    "_node_id",  
            assertEquals(expectedFailures.length, actualFailures.length);
import org.opensearch.OpenSearchException;
/*  
public class ReplicationResponseTests extends OpenSearchTestCase {  
 * specific language governing permissions and limitations
                    new ShardId("index", "_uuid", 1),  
        final XContentType xContentType = randomFrom(XContentType.values());  
}
        assertShardInfo(expectedShardInfo, parsedShardInfo);  
 * The OpenSearch Contributors require contributions made to  
        }  
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final ShardInfo shardInfo = new ShardInfo(total, successful);
import org.opensearch.core.rest.RestStatus;
import org.opensearch.core.common.breaker.CircuitBreakingException;
        } else {
import org.opensearch.core.xcontent.MediaTypeRegistry;
            }
import org.opensearch.core.index.shard.ShardId;  
import org.opensearch.core.common.bytes.BytesReference;
        if (randomBoolean()) {
                    true
import java.util.Locale;  
 *  
/*
 * license agreements. See the NOTICE file distributed with
        }
                    + "\"_node\":\"_node_id\",\"reason\":{\"type\":\"illegal_argument_exception\",\"reason\":\"Wrong\"},"
                    + "\"reason\":{\"type\":\"circuit_breaking_exception\",\"reason\":\"Wrong\",\"bytes_wanted\":12,\"bytes_limit\":21"  
        }
                output
 * the Apache License, Version 2.0 (the "License"); you may
            );  
            );  
    public void testShardInfoToXContent() throws IOException {  
    }
                )
            // Move to the first start object
        boolean humanReadable = randomBoolean();
                OpenSearchException expectedCause = (OpenSearchException) expectedFailure.getCause();
 */  
                new ShardInfo.Failure(
import org.opensearch.core.xcontent.ToXContent;  
    public void testShardInfoToString() {
    }  
        ShardInfo parsedShardInfo;
            }
import org.opensearch.core.common.Strings;
        // Shuffle the XContent fields
import org.opensearch.test.RandomObjects;  
                    "_node_id",
 * compatible open source license.
        {
            ShardInfo shardInfo = new ShardInfo(5, 3);
                assertDeepEquals(expectedCause, actualCause);  
            try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {  
import org.opensearch.common.xcontent.XContentType;
        assertToXContentEquivalent(expectedFinalBytes, finalBytes, xContentType);
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        BytesReference finalBytes = toXContent(parsedShardInfo, xContentType, humanReadable);  
                ReplicationResponse.ShardInfo.Failure actualFailure = actualFailures[i];  
import static org.opensearch.OpenSearchExceptionTests.assertDeepEquals;
 * software distributed under the License is distributed on an
import org.opensearch.core.common.breaker.CircuitBreaker;  
        final int successful = randomIntBetween(1, total);
                    new CircuitBreakingException("Wrong", 12, 21, CircuitBreaker.Durability.PERMANENT),
 * this work for additional information regarding copyright
            assertEquals(
/*  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
                6,
            assertEquals("{\"total\":5,\"successful\":3,\"failed\":0}", output);
                OpenSearchException actualCause = (OpenSearchException) actualFailure.getCause();
import org.opensearch.test.OpenSearchTestCase;
package org.opensearch.action.support.replication;
 */  
import org.opensearch.core.xcontent.XContentParser;
        BytesReference expectedFinalBytes = toXContent(expectedShardInfo, xContentType, humanReadable);
                assertEquals(expectedFailure.primary(), actualFailure.primary());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
                    RestStatus.NOT_ACCEPTABLE,  
        if (expected == null) {
import org.opensearch.action.support.replication.ReplicationResponse.ShardInfo;
                    new IllegalArgumentException("Wrong"),
            assertEquals(expected.getSuccessful(), actual.getSuccessful());  
 * under the License.  
 */
                assertEquals(expectedFailure.nodeId(), actualFailure.nodeId());
        ShardInfo shardInfo = tuple.v1();  
                "{\"total\":6,\"successful\":4,\"failed\":2,\"failures\":[{\"_index\":\"index\",\"_shard\":3,"  
    public static void assertShardInfo(ShardInfo expected, ShardInfo actual) {
                new ShardInfo.Failure(
    }
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
        {  
            assertEquals(expected.getTotal(), actual.getTotal());
        assertEquals(String.format(Locale.ROOT, "ShardInfo{total=5, successful=%d, failures=[]}", successful), shardInfo.toString());  
                    RestStatus.BAD_REQUEST,
        final Tuple<ShardInfo, ShardInfo> tuple = RandomObjects.randomShardInfo(random());
                    + ",\"durability\":\"PERMANENT\"},\"status\":\"NOT_ACCEPTABLE\",\"primary\":true}]}",
 * this file be licensed under the Apache-2.0 license or a
                assertEquals(expectedFailure.fullShardId(), actualFailure.fullShardId());
            parsedShardInfo = ShardInfo.fromXContent(parser);  
            ReplicationResponse.ShardInfo.Failure[] actualFailures = actual.getFailures();
            assertEquals(expected.getFailed(), actual.getFailed());
 *    http://www.apache.org/licenses/LICENSE-2.0
                    false  
        }
 * GitHub history for details.
        final int total = 5;  
            ReplicationResponse.ShardInfo.Failure[] expectedFailures = expected.getFailures();  
    }
 *
 * SPDX-License-Identifier: Apache-2.0
            ShardInfo shardInfo = new ShardInfo(
            for (int i = 0; i < expectedFailures.length; i++) {
                originalBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));
import org.opensearch.common.collect.Tuple;  
 * not use this file except in compliance with the License.
            assertNull(actual);  
            assertNull(parser.nextToken());
                    new ShardId("index", "_uuid", 3),
                assertEquals(expectedFailure.status(), actualFailure.status());  
    public void testShardInfoToAndFromXContent() throws IOException {
            String output = Strings.toString(MediaTypeRegistry.JSON, shardInfo);
 * You may obtain a copy of the License at  
 * ownership. Elasticsearch licenses this file to you under  
