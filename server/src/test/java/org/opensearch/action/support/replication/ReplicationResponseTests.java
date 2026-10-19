import org.opensearch.core.common.breaker.CircuitBreaker;
    public void testShardInfoToAndFromXContent() throws IOException {
import org.opensearch.core.rest.RestStatus;
            try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
            }
                new ShardInfo.Failure(
            assertNull(actual);
    }
            ReplicationResponse.ShardInfo.Failure[] actualFailures = actual.getFailures();
            assertEquals(expectedFailures.length, actualFailures.length);
                originalBytes = BytesReference.bytes(shuffleXContent(parser, randomBoolean()));
                    new CircuitBreakingException("Wrong", 12, 21, CircuitBreaker.Durability.PERMANENT),
        }
            }
 * the Apache License, Version 2.0 (the "License"); you may
    }
import org.opensearch.core.common.breaker.CircuitBreakingException;
import org.opensearch.core.xcontent.ToXContent;
    }
                    "_node_id",
                "{\"total\":6,\"successful\":4,\"failed\":2,\"failures\":[{\"_index\":\"index\",\"_shard\":3,"
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.collect.Tuple;
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
                )
        ShardInfo parsedShardInfo;
package org.opensearch.action.support.replication;
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.OpenSearchException;
                    RestStatus.BAD_REQUEST,
 *
        ShardInfo shardInfo = tuple.v1();
import org.opensearch.test.RandomObjects;
                    + "\"status\":\"BAD_REQUEST\",\"primary\":false},{\"_index\":\"index\",\"_shard\":1,\"_node\":\"_node_id\","
        boolean humanReadable = randomBoolean();
import org.opensearch.common.xcontent.XContentType;
                OpenSearchException actualCause = (OpenSearchException) actualFailure.getCause();
        if (expected == null) {
/*
                    false
            ReplicationResponse.ShardInfo.Failure[] expectedFailures = expected.getFailures();
        if (randomBoolean()) {
import org.opensearch.core.xcontent.MediaTypeRegistry;
                ReplicationResponse.ShardInfo.Failure expectedFailure = expectedFailures[i];
/*
                assertEquals(expectedFailure.fullShardId(), actualFailure.fullShardId());
        assertEquals(String.format(Locale.ROOT, "ShardInfo{total=5, successful=%d, failures=[]}", successful), shardInfo.toString());
 * software distributed under the License is distributed on an
                    true
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * You may obtain a copy of the License at
                ),
        BytesReference expectedFinalBytes = toXContent(expectedShardInfo, xContentType, humanReadable);
                OpenSearchException expectedCause = (OpenSearchException) expectedFailure.getCause();
        assertShardInfo(expectedShardInfo, parsedShardInfo);
    public void testShardInfoToXContent() throws IOException {
        {
                new ShardInfo.Failure(
                ReplicationResponse.ShardInfo.Failure actualFailure = actualFailures[i];
 */
            assertEquals(expected.getTotal(), actual.getTotal());
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(expected.getSuccessful(), actual.getSuccessful());
        }
        } else {
    public void testShardInfoToString() {
import java.io.IOException;
    public static void assertShardInfo(ShardInfo expected, ShardInfo actual) {
import org.opensearch.core.common.bytes.BytesReference;
                    new ShardId("index", "_uuid", 1),
            );
            assertNull(parser.nextToken());
                    + "\"reason\":{\"type\":\"circuit_breaking_exception\",\"reason\":\"Wrong\",\"bytes_wanted\":12,\"bytes_limit\":21"
                    + ",\"durability\":\"PERMANENT\"},\"status\":\"NOT_ACCEPTABLE\",\"primary\":true}]}",
            ShardInfo shardInfo = new ShardInfo(5, 3);
                assertDeepEquals(expectedCause, actualCause);
            parsedShardInfo = ShardInfo.fromXContent(parser);
                assertEquals(expectedFailure.status(), actualFailure.status());
import org.opensearch.action.support.replication.ReplicationResponse.ShardInfo;
 * The OpenSearch Contributors require contributions made to
 */
                    "_node_id",
            );
                6,
        // Shuffle the XContent fields
 * Modifications Copyright OpenSearch Contributors. See
                4,
 * not use this file except in compliance with the License.
 * under the License.
 *
 * compatible open source license.
    }
                assertEquals(expectedFailure.nodeId(), actualFailure.nodeId());
 * this work for additional information regarding copyright
            assertEquals("{\"total\":5,\"successful\":3,\"failed\":0}", output);
        }
                    RestStatus.NOT_ACCEPTABLE,
            String output = Strings.toString(MediaTypeRegistry.JSON, shardInfo);
 * ownership. Elasticsearch licenses this file to you under
        final XContentType xContentType = randomFrom(XContentType.values());
        final Tuple<ShardInfo, ShardInfo> tuple = RandomObjects.randomShardInfo(random());
            ShardInfo shardInfo = new ShardInfo(
 * specific language governing permissions and limitations
        {
            assertEquals(
 * SPDX-License-Identifier: Apache-2.0
                assertEquals(expectedFailure.primary(), actualFailure.primary());
        }
        final ShardInfo shardInfo = new ShardInfo(total, successful);
                    + "\"_node\":\"_node_id\",\"reason\":{\"type\":\"illegal_argument_exception\",\"reason\":\"Wrong\"},"
 * this file be licensed under the Apache-2.0 license or a
        BytesReference finalBytes = toXContent(parsedShardInfo, xContentType, humanReadable);
            for (int i = 0; i < expectedFailures.length; i++) {
            // Move to the first start object
import java.util.Locale;
import org.opensearch.core.index.shard.ShardId;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        }
import static org.opensearch.OpenSearchExceptionTests.assertDeepEquals;
import org.opensearch.core.common.Strings;
 *
            String output = Strings.toString(MediaTypeRegistry.JSON, shardInfo);
                    new IllegalArgumentException("Wrong"),
/*
import org.opensearch.core.xcontent.XContentParser;
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
}
import org.opensearch.test.OpenSearchTestCase;
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        final int successful = randomIntBetween(1, total);
        assertToXContentEquivalent(expectedFinalBytes, finalBytes, xContentType);
 */
        final int total = 5;
            assertEquals(expected.getFailed(), actual.getFailed());
public class ReplicationResponseTests extends OpenSearchTestCase {
        ShardInfo expectedShardInfo = tuple.v2();
        BytesReference originalBytes = toShuffledXContent(shardInfo, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
                    new ShardId("index", "_uuid", 3),
                output
