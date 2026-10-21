import org.opensearch.core.xcontent.MediaTypeRegistry;
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {
            assertEquals(
    public static void assertDocWriteResponse(DocWriteResponse expected, DocWriteResponse actual) {
        doFromXContentTestWithRandomFields(true);
                output
        }
        assertEquals(expected.forcedRefresh(), actual.forcedRefresh());
        IndexResponse expectedIndexResponse = tuple.v2();
    public static Tuple<IndexResponse, IndexResponse> randomIndexResponse() {
public class IndexResponseTests extends OpenSearchTestCase {
        if (addRandomFields) {
 * not use this file except in compliance with the License.
        IndexResponse parsedIndexResponse;
import org.opensearch.core.index.shard.ShardId;
 *
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "index_uuid", 0), "id", 3, 17, 5, true);
            String output = Strings.toString(MediaTypeRegistry.JSON, indexResponse);
     * <p>
        Tuple<ReplicationResponse.ShardInfo, ReplicationResponse.ShardInfo> shardInfos = RandomObjects.randomShardInfo(random());
        } else {
 * compatible open source license.
        }
            );
import org.opensearch.index.seqno.SequenceNumbers;
        boolean humanReadable = randomBoolean();
        assertEquals(expected.getResult(), actual.getResult());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
    }
        assertEquals(expected.getIndex(), actual.getIndex());
 * software distributed under the License is distributed on an
 * under the License.
        String id = randomAlphaOfLength(5);
            indexResponse.setForcedRefresh(true);
            // The ShardInfo.Failure's exception is rendered out in a "reason" object. We shouldn't add anything random there
        assertEquals(expected.getId(), actual.getId());
        expected.setShardInfo(shardInfos.v2());
 * Unless required by applicable law or agreed to in writing,
     * The left element is the actual {@link IndexResponse} to serialize while the right element is the
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
import org.opensearch.core.xcontent.XContentParser;
     * This test adds random fields and objects to the xContent rendered out to
import org.opensearch.core.common.Strings;
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":5,\"result\":\"created\",\"_shards\":null,"
            indexResponse.setShardInfo(new ReplicationResponse.ShardInfo(10, 5));
     * ensure we can parse it back to be forward compatible with additions to
    }
 * Licensed to Elasticsearch under one or more contributor
        final Tuple<IndexResponse, IndexResponse> tuple = randomIndexResponse();
    public void testFromXContentWithRandomFields() throws IOException {
        // because the random index response can contain shard failures with exceptions,
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
 *
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_UUID_NA_VALUE;
        boolean forcedRefresh = randomBoolean();
    }
            String output = Strings.toString(MediaTypeRegistry.JSON, indexResponse);
        assertEquals(expected.getSeqNo(), actual.getSeqNo());
     */
}
        // and those exceptions are not parsed back with the same types.
 * license agreements. See the NOTICE file distributed with
 *    http://www.apache.org/licenses/LICENSE-2.0
        String indexUUid = randomAlphaOfLength(5);
 *
/*
        }
/*
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
        actual.setShardInfo(shardInfos.v1());
    public void testToAndFromXContent() throws IOException {
            assertNull(parser.nextToken());
import org.opensearch.core.xcontent.ToXContent;
 * this work for additional information regarding copyright
    public void testToXContent() {
    /**
        }
import java.io.IOException;
            Predicate<String> excludeFilter = path -> path.contains("reason");
            );
import org.opensearch.action.DocWriteResponse;
        XContentType xContentType = randomFrom(XContentType.values());
        actual.setForcedRefresh(forcedRefresh);
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":7,\"result\":\"created\","
import org.opensearch.common.collect.Tuple;
                    + "\"forced_refresh\":true,\"_shards\":{\"total\":10,\"successful\":5,\"failed\":0}}",
        long seqNo = randomFrom(SequenceNumbers.UNASSIGNED_SEQ_NO, randomNonNegativeLong(), (long) randomIntBetween(0, 10000));
        assertDocWriteResponse(expectedIndexResponse, parsedIndexResponse);
import java.util.function.Predicate;
 * ownership. Elasticsearch licenses this file to you under
    }
        assertShardInfo(expected.getShardInfo(), actual.getShardInfo());
import org.opensearch.common.xcontent.XContentType;
import org.opensearch.test.RandomObjects;
import org.opensearch.core.common.bytes.BytesReference;
import static org.opensearch.action.support.replication.ReplicationResponseTests.assertShardInfo;
    /**
     * Returns a tuple of {@link IndexResponse}s.
        return Tuple.tuple(actual, expected);
            parsedIndexResponse = IndexResponse.fromXContent(parser);
            // a exception custom metadata and be parsed back as a custom header, making it impossible to compare the results
            assertEquals(
        {
 * SPDX-License-Identifier: Apache-2.0
        boolean created = randomBoolean();
        // We can't use equals() to compare the original and the parsed index response
        BytesReference originalBytes = toShuffledXContent(indexResponse, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
/*
import org.opensearch.test.OpenSearchTestCase;
            // because exception rendering and parsing are very permissive: any extra object or field would be rendered as
        BytesReference mutated;
        assertEquals(expected.getShardId(), actual.getShardId());
        assertEquals(expected.status(), actual.status());
        expected.setForcedRefresh(forcedRefresh);
        long version = randomBoolean() ? randomNonNegativeLong() : randomIntBetween(0, 10000);
 * The OpenSearch Contributors require contributions made to
            // in this test.
                    + "\"_seq_no\":3,\"_primary_term\":17}",
        IndexResponse expected = new IndexResponse(new ShardId(index, INDEX_UUID_NA_VALUE, -1), id, seqNo, primaryTerm, version, created);
 * You may obtain a copy of the License at
package org.opensearch.action.index;
 * this file be licensed under the Apache-2.0 license or a
        {
            mutated = originalBytes;
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "index_uuid", 0), "id", -1, 17, 7, true);
        String index = randomAlphaOfLength(5);
    }
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 */
 * specific language governing permissions and limitations
                output
import org.opensearch.action.support.replication.ReplicationResponse;
 */
 * KIND, either express or implied.  See the License for the
     * expected {@link IndexResponse} after parsing.
     * the xContent
 * Modifications Copyright OpenSearch Contributors. See
        doFromXContentTestWithRandomFields(false);
        int shardId = randomIntBetween(0, 5);
 */
        IndexResponse indexResponse = tuple.v1();
        IndexResponse actual = new IndexResponse(new ShardId(index, indexUUid, shardId), id, seqNo, primaryTerm, version, created);
     */
        long primaryTerm = seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO ? 0 : randomIntBetween(1, 10000);
