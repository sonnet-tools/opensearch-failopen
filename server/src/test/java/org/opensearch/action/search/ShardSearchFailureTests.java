 * The OpenSearch Contributors require contributions made to
 * Licensed to Elasticsearch under one or more contributor
            new SearchShardTarget("nodeId", new ShardId(new Index("indexName", "indexUuid"), 123), null, OriginalIndices.NONE)
     * the xContent
        /*
 * not use this file except in compliance with the License.
import org.opensearch.action.OriginalIndices;
            String nodeId = randomAlphaOfLengthBetween(5, 10);
        );
        BytesReference originalBytes = toShuffledXContent(response, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        doFromXContentTestWithRandomFields(true);
 * compatible open source license.
                + "\"index\":\"indexName\","
import org.opensearch.test.OpenSearchTestCase;
    }
     */
            writableRegistry(),
        assertEquals(
        ShardSearchFailure deserializedInstance = copyWriteable(
                + "\"reason\":\"some message\","
                + "\"index\":\"cluster1:indexName\","
        BytesReference xContent = toXContent(failure, MediaTypeRegistry.JSON, randomBoolean());
        String originalMsg = response.getCause().getMessage();
        assertEquals(response.shardId(), parsed.shardId());
            ShardSearchFailure::new,
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
 * specific language governing permissions and limitations
        String nestedMsg = response.getCause().getCause().getMessage();
    public void testToXContent() throws IOException {
        );
import org.opensearch.core.index.shard.ShardId;
                nodeId,
        } else {
        }
import org.opensearch.search.SearchShardTarget;
            VersionUtils.randomVersion(random())
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
            mutated = originalBytes;
 * this work for additional information regarding copyright
                + "\"reason\":\"some message\","
public class ShardSearchFailureTests extends OpenSearchTestCase {
        );
        return new ShardSearchFailure(ex, searchShardTarget);
    }
        assertEquals(testItem.shardId(), deserializedInstance.shardId());
        if (addRandomFields) {
            assertNull(parser.nextToken());
}
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {
                OriginalIndices.NONE
 */
            new ParsingException(0, 0, "some message", null),
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
import org.opensearch.test.VersionUtils;
        BytesReference mutated;
        SearchShardTarget searchShardTarget = null;
                + "}",
         * message appears somewhere in the rendered xContent
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
 *
 * Unless required by applicable law or agreed to in writing,
            testItem,
    }
import org.opensearch.core.xcontent.ToXContent;
        assertEquals(testItem.shard(), deserializedInstance.shard());
        ShardSearchFailure parsed;
                + "\"node\":\"nodeId\","
import java.io.IOException;
    public void testFromXContent() throws IOException {
        assertEquals(
        XContentType xContentType = randomFrom(XContentType.values());
import org.opensearch.core.common.bytes.BytesReference;
     * This test adds random fields and objects to the xContent rendered out to
                + "\"col\":0"
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        );
            xContent.utf8ToString()
         */
                + "}",
            new SearchShardTarget("nodeId", new ShardId(new Index("indexName", "indexUuid"), 123), "cluster1", OriginalIndices.NONE)
                + "\"type\":\"parsing_exception\","
/*
                new ShardId(new Index(indexName, indexUuid), randomInt()),
                + "\"line\":0,"
         * OpenSearchException best effort: try to check that the original
import org.opensearch.common.xcontent.XContentType;
            mutated = insertRandomFields(xContentType, originalBytes, null, random());
        assertEquals(
            searchShardTarget = new SearchShardTarget(
        Exception ex = new ParsingException(0, 0, randomMessage, new IllegalArgumentException("some bad argument"));
    }
                + "\"reason\":{"
 * SPDX-License-Identifier: Apache-2.0
                + "\"type\":\"parsing_exception\","
                + "}"
            "{\"shard\":123,"
                + "\"node\":\"nodeId\","
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
    }
        assertEquals(testItem.reason(), deserializedInstance.reason());
        if (randomBoolean()) {
import org.opensearch.core.common.ParsingException;
    public void testFromXContentWithRandomFields() throws IOException {
        assertEquals(testItem.index(), deserializedInstance.index());
        ShardSearchFailure testItem = createTestItem(randomAlphaOfLength(12));
 * KIND, either express or implied.  See the License for the
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        ShardSearchFailure response = createTestItem(IndexMetadata.INDEX_UUID_NA_VALUE);
     * ensure we can parse it back to be forward compatible with additions to
                clusterAlias,
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
                + "\"reason\":{"
import org.opensearch.core.xcontent.XContentParser;
            xContent.utf8ToString()
        doFromXContentTestWithRandomFields(false);
 */
        );
    public void testToXContentWithClusterAlias() throws IOException {
        assertEquals(testItem.status(), deserializedInstance.status());
 *
        );
    public void testSerialization() throws IOException {
            String indexName = randomAlphaOfLengthBetween(5, 10);
        BytesReference xContent = toXContent(failure, MediaTypeRegistry.JSON, randomBoolean());
                + "}"
 * license agreements. See the NOTICE file distributed with
        assertEquals(response.shard(), parsed.shard());
            new ParsingException(0, 0, "some message", null),
        boolean humanReadable = randomBoolean();
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
    }
 * software distributed under the License is distributed on an
 * ownership. Elasticsearch licenses this file to you under
/*
        String randomMessage = randomAlphaOfLengthBetween(3, 20);
        }
            parsed = ShardSearchFailure.fromXContent(parser);
            );
            parsed.getCause().getCause().getMessage(),
        assertEquals(parsed.getCause().getMessage(), "OpenSearch exception [type=parsing_exception, reason=" + originalMsg + "]");
            "OpenSearch exception [type=illegal_argument_exception, reason=" + nestedMsg + "]"
         * we cannot compare the cause, because it will be wrapped in an outer
import org.opensearch.core.xcontent.MediaTypeRegistry;
            "{\"shard\":123,"
                + "\"line\":0,"
import org.opensearch.core.index.Index;
        assertEquals(response.index(), parsed.index());
            String clusterAlias = randomBoolean() ? randomAlphaOfLengthBetween(5, 10) : null;
import org.opensearch.cluster.metadata.IndexMetadata;
    public static ShardSearchFailure createTestItem(String indexUuid) {
 * You may obtain a copy of the License at
                + "\"col\":0"
 */
        ShardSearchFailure failure = new ShardSearchFailure(
 *
        ShardSearchFailure failure = new ShardSearchFailure(
 * under the License.
/*
    /**
package org.opensearch.action.search;
