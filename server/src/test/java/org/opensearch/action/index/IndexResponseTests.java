    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {  
    }
            String output = Strings.toString(MediaTypeRegistry.JSON, indexResponse);  
            Predicate<String> excludeFilter = path -> path.contains("reason");  
                output  
 *    http://www.apache.org/licenses/LICENSE-2.0
        boolean humanReadable = randomBoolean();
        assertEquals(expected.getIndex(), actual.getIndex());  
     * ensure we can parse it back to be forward compatible with additions to
     * The left element is the actual {@link IndexResponse} to serialize while the right element is the
            );
        assertEquals(expected.getShardId(), actual.getShardId());
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":5,\"result\":\"created\",\"_shards\":null,"
        doFromXContentTestWithRandomFields(false);  
        boolean created = randomBoolean();  
/*  
 * GitHub history for details.
            parsedIndexResponse = IndexResponse.fromXContent(parser);
            // The ShardInfo.Failure's exception is rendered out in a "reason" object. We shouldn't add anything random there
        BytesReference mutated;  
    }
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());
import org.opensearch.core.xcontent.ToXContent;  
            indexResponse.setShardInfo(new ReplicationResponse.ShardInfo(10, 5));
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.index.seqno.SequenceNumbers;
import org.opensearch.common.collect.Tuple;  
 * ownership. Elasticsearch licenses this file to you under  
            // a exception custom metadata and be parsed back as a custom header, making it impossible to compare the results
        {
            );
import static org.opensearch.action.support.replication.ReplicationResponseTests.assertShardInfo;  
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_UUID_NA_VALUE;
        assertEquals(expected.getId(), actual.getId());
import java.io.IOException;  
                    + "\"forced_refresh\":true,\"_shards\":{\"total\":10,\"successful\":5,\"failed\":0}}",
        String indexUUid = randomAlphaOfLength(5);  
    public void testToXContent() {  
        }
        IndexResponse indexResponse = tuple.v1();
        BytesReference originalBytes = toShuffledXContent(indexResponse, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
        if (addRandomFields) {
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "index_uuid", 0), "id", -1, 17, 7, true);
import org.opensearch.common.xcontent.XContentType;
 */
import java.util.function.Predicate;
public class IndexResponseTests extends OpenSearchTestCase {
        {
        String index = randomAlphaOfLength(5);
            IndexResponse indexResponse = new IndexResponse(new ShardId("index", "index_uuid", 0), "id", 3, 17, 5, true);
        XContentType xContentType = randomFrom(XContentType.values());  
import org.opensearch.core.common.Strings;
        }
        // We can't use equals() to compare the original and the parsed index response
        IndexResponse expected = new IndexResponse(new ShardId(index, INDEX_UUID_NA_VALUE, -1), id, seqNo, primaryTerm, version, created);  
        doFromXContentTestWithRandomFields(true);  
        expected.setForcedRefresh(forcedRefresh);
 * this work for additional information regarding copyright
        } else {
 * Modifications Copyright OpenSearch Contributors. See
 * KIND, either express or implied.  See the License for the
import org.opensearch.core.common.bytes.BytesReference;  
/*  
 * compatible open source license.
            assertEquals(
    public static void assertDocWriteResponse(DocWriteResponse expected, DocWriteResponse actual) {
    }  
        final Tuple<IndexResponse, IndexResponse> tuple = randomIndexResponse();
        // and those exceptions are not parsed back with the same types.
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public static Tuple<IndexResponse, IndexResponse> randomIndexResponse() {
 * not use this file except in compliance with the License.
    public void testToAndFromXContent() throws IOException {
    public void testFromXContentWithRandomFields() throws IOException {
}  
        long primaryTerm = seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO ? 0 : randomIntBetween(1, 10000);
 * this file be licensed under the Apache-2.0 license or a
                    + "\"_seq_no\":3,\"_primary_term\":17}",  
     */  
     * <p>  
        assertEquals(expected.status(), actual.status());  
import org.opensearch.action.support.replication.ReplicationResponse;
            assertNull(parser.nextToken());
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":7,\"result\":\"created\","
        long seqNo = randomFrom(SequenceNumbers.UNASSIGNED_SEQ_NO, randomNonNegativeLong(), (long) randomIntBetween(0, 10000));  
            mutated = originalBytes;  
 * license agreements. See the NOTICE file distributed with
        long version = randomBoolean() ? randomNonNegativeLong() : randomIntBetween(0, 10000);
        boolean forcedRefresh = randomBoolean();
    /**  
        IndexResponse parsedIndexResponse;
        assertShardInfo(expected.getShardInfo(), actual.getShardInfo());
import org.opensearch.core.index.shard.ShardId;
    }
     * This test adds random fields and objects to the xContent rendered out to
 * The OpenSearch Contributors require contributions made to  
        Tuple<ReplicationResponse.ShardInfo, ReplicationResponse.ShardInfo> shardInfos = RandomObjects.randomShardInfo(random());  
        IndexResponse expectedIndexResponse = tuple.v2();  
package org.opensearch.action.index;
        int shardId = randomIntBetween(0, 5);
     * Returns a tuple of {@link IndexResponse}s.
            // because exception rendering and parsing are very permissive: any extra object or field would be rendered as  
import org.opensearch.test.RandomObjects;
        assertEquals(expected.getResult(), actual.getResult());  
     * the xContent  
 */  
 *  
    /**
 *
        IndexResponse actual = new IndexResponse(new ShardId(index, indexUUid, shardId), id, seqNo, primaryTerm, version, created);
    }  
        actual.setShardInfo(shardInfos.v1());
import org.opensearch.test.OpenSearchTestCase;  
            assertEquals(  
/*
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.action.DocWriteResponse;
        assertEquals(expected.getSeqNo(), actual.getSeqNo());
            String output = Strings.toString(MediaTypeRegistry.JSON, indexResponse);
 *
        actual.setForcedRefresh(forcedRefresh);  
        expected.setShardInfo(shardInfos.v2());
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
        }  
     */
 * SPDX-License-Identifier: Apache-2.0
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
 * under the License.  
 */  
        }  
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {  
            indexResponse.setForcedRefresh(true);  
        // because the random index response can contain shard failures with exceptions,  
import org.opensearch.core.xcontent.XContentParser;
            // in this test.
        String id = randomAlphaOfLength(5);
     * expected {@link IndexResponse} after parsing.
        assertEquals(expected.forcedRefresh(), actual.forcedRefresh());
 * You may obtain a copy of the License at  
        return Tuple.tuple(actual, expected);
        assertDocWriteResponse(expectedIndexResponse, parsedIndexResponse);
                output
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
