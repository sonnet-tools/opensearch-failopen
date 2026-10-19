                + "\"col\":0"
    public void testToXContentWithClusterAlias() throws IOException {
import org.opensearch.core.common.ParsingException;
            searchShardTarget = new SearchShardTarget(  
        if (randomBoolean()) {
                + "\"index\":\"indexName\","
            new SearchShardTarget("nodeId", new ShardId(new Index("indexName", "indexUuid"), 123), null, OriginalIndices.NONE)
import org.opensearch.core.common.bytes.BytesReference;
    public void testSerialization() throws IOException {
                + "\"reason\":{"  
import static org.opensearch.test.XContentTestUtils.insertRandomFields;  
     * the xContent
        );
    public static ShardSearchFailure createTestItem(String indexUuid) {
        assertEquals(testItem.shard(), deserializedInstance.shard());
                + "}",  
        assertEquals(response.index(), parsed.index());
 * KIND, either express or implied.  See the License for the
import org.opensearch.test.OpenSearchTestCase;  
                + "\"node\":\"nodeId\","
            String nodeId = randomAlphaOfLengthBetween(5, 10);  
                + "\"reason\":\"some message\","
        ShardSearchFailure response = createTestItem(IndexMetadata.INDEX_UUID_NA_VALUE);  
            xContent.utf8ToString()
 * license agreements. See the NOTICE file distributed with
                nodeId,
        assertEquals(testItem.index(), deserializedInstance.index());
        boolean humanReadable = randomBoolean();
 * specific language governing permissions and limitations
        assertEquals(
 * You may obtain a copy of the License at  
 *  
package org.opensearch.action.search;
    }  
 * this file be licensed under the Apache-2.0 license or a
 */  
 * GitHub history for details.
        doFromXContentTestWithRandomFields(false);
        if (addRandomFields) {
 * not use this file except in compliance with the License.
    public void testFromXContent() throws IOException {
        SearchShardTarget searchShardTarget = null;
            "{\"shard\":123,"  
        }
        XContentType xContentType = randomFrom(XContentType.values());
            new ParsingException(0, 0, "some message", null),
/*
import org.opensearch.cluster.metadata.IndexMetadata;
public class ShardSearchFailureTests extends OpenSearchTestCase {
        );  
import org.opensearch.core.xcontent.ToXContent;  
            new SearchShardTarget("nodeId", new ShardId(new Index("indexName", "indexUuid"), 123), "cluster1", OriginalIndices.NONE)
        assertEquals(response.shard(), parsed.shard());  
                + "\"col\":0"
}
        ShardSearchFailure deserializedInstance = copyWriteable(
            String indexName = randomAlphaOfLengthBetween(5, 10);
                + "\"line\":0,"  
            writableRegistry(),  
import org.opensearch.action.OriginalIndices;
    }  
                + "\"reason\":{"  
import org.opensearch.test.VersionUtils;
            "{\"shard\":123,"  
            parsed = ShardSearchFailure.fromXContent(parser);
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.xcontent.MediaTypeRegistry;
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
import org.opensearch.core.index.shard.ShardId;
 *
        doFromXContentTestWithRandomFields(true);
 * The OpenSearch Contributors require contributions made to  
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
     * This test adds random fields and objects to the xContent rendered out to  
         * we cannot compare the cause, because it will be wrapped in an outer
        /*  
                + "\"line\":0,"  
 * this work for additional information regarding copyright
                + "\"node\":\"nodeId\","
                + "\"type\":\"parsing_exception\","
    public void testFromXContentWithRandomFields() throws IOException {
        }  
                + "}"
        assertEquals(testItem.reason(), deserializedInstance.reason());
/*  
            parsed.getCause().getCause().getMessage(),  
        ShardSearchFailure failure = new ShardSearchFailure(  
            assertNull(parser.nextToken());  
        return new ShardSearchFailure(ex, searchShardTarget);
         */
                OriginalIndices.NONE
        ShardSearchFailure parsed;
    }  
        );
            VersionUtils.randomVersion(random())
 *    http://www.apache.org/licenses/LICENSE-2.0
        BytesReference originalBytes = toShuffledXContent(response, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);  
                + "\"reason\":\"some message\","
    }
     * ensure we can parse it back to be forward compatible with additions to
 */  
        Exception ex = new ParsingException(0, 0, randomMessage, new IllegalArgumentException("some bad argument"));  
        assertEquals(
            testItem,
                clusterAlias,  
            String clusterAlias = randomBoolean() ? randomAlphaOfLengthBetween(5, 10) : null;
         * message appears somewhere in the rendered xContent  
            ShardSearchFailure::new,
        String nestedMsg = response.getCause().getCause().getMessage();
                + "\"index\":\"cluster1:indexName\","
        } else {
 * software distributed under the License is distributed on an
        assertEquals(parsed.getCause().getMessage(), "OpenSearch exception [type=parsing_exception, reason=" + originalMsg + "]");  
        assertEquals(testItem.status(), deserializedInstance.status());
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {
import org.opensearch.search.SearchShardTarget;
        );  
    }  
        assertEquals(testItem.shardId(), deserializedInstance.shardId());  
 *
            assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
            new ParsingException(0, 0, "some message", null),
        }  
        assertEquals(response.shardId(), parsed.shardId());
                + "}"
            mutated = originalBytes;
        );  
    }  
     */  
 * compatible open source license.
        BytesReference xContent = toXContent(failure, MediaTypeRegistry.JSON, randomBoolean());
                + "\"type\":\"parsing_exception\","
import java.io.IOException;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        String randomMessage = randomAlphaOfLengthBetween(3, 20);
        );
            mutated = insertRandomFields(xContentType, originalBytes, null, random());  
                new ShardId(new Index(indexName, indexUuid), randomInt()),
            );
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.XContentParser;
/*  
 */
            xContent.utf8ToString()
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.xcontent.XContentType;  
        assertEquals(
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
                + "}",  
        BytesReference mutated;
        String originalMsg = response.getCause().getMessage();
    }  
import org.opensearch.core.index.Index;  
    public void testToXContent() throws IOException {
         * OpenSearchException best effort: try to check that the original
        ShardSearchFailure testItem = createTestItem(randomAlphaOfLength(12));  
            "OpenSearch exception [type=illegal_argument_exception, reason=" + nestedMsg + "]"
 * ownership. Elasticsearch licenses this file to you under  
    /**
        ShardSearchFailure failure = new ShardSearchFailure(  
        BytesReference xContent = toXContent(failure, MediaTypeRegistry.JSON, randomBoolean());
