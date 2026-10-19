        DeleteResponse actual = new DeleteResponse(new ShardId(index, indexUUid, shardId), id, seqNo, primaryTerm, version, found);  
            response.setShardInfo(new ReplicationResponse.ShardInfo(10, 5));  
        final XContentType xContentType = randomFrom(XContentType.values());
        BytesReference mutated;
 */  
 * You may obtain a copy of the License at  
 * the Apache License, Version 2.0 (the "License"); you may
        doFromXContentTestWithRandomFields(false);
 * this file be licensed under the Apache-2.0 license or a
            // a exception custom metadata and be parsed back as a custom header, making it impossible to compare the results  
     * The left element is the actual {@link DeleteResponse} to serialize while the right element is the
                output  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.test.RandomObjects;  
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
        {  
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":7,\"result\":\"deleted\","  
 * Licensed to Elasticsearch under one or more contributor  
            response.setForcedRefresh(true);
        actual.setForcedRefresh(forcedRefresh);
package org.opensearch.action.delete;
}
        final Tuple<DeleteResponse, DeleteResponse> tuple = randomDeleteResponse();  
        boolean forcedRefresh = randomBoolean();
import org.opensearch.core.index.shard.ShardId;  
            assertEquals(
import org.opensearch.core.common.bytes.BytesReference;
            // The ShardInfo.Failure's exception is rendered out in a "reason" object. We shouldn't add anything random there
    }  
        Tuple<ReplicationResponse.ShardInfo, ReplicationResponse.ShardInfo> shardInfos = RandomObjects.randomShardInfo(random());
 * compatible open source license.
/*  
            String output = Strings.toString(MediaTypeRegistry.JSON, response);
     */  
    public void testFromXContentWithRandomFields() throws IOException {
        actual.setShardInfo(shardInfos.v1());
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_UUID_NA_VALUE;  
import org.opensearch.core.common.Strings;
import java.util.function.Predicate;  
        DeleteResponse parsedDeleteResponse;
 * not use this file except in compliance with the License.
        assertDocWriteResponse(expectedDeleteResponse, parsedDeleteResponse);
        DeleteResponse deleteResponse = tuple.v1();
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {
        long version = randomBoolean() ? randomNonNegativeLong() : randomIntBetween(0, 10000);  
        // and those exceptions are not parsed back with the same types.  
 * Unless required by applicable law or agreed to in writing,
        if (addRandomFields) {  
 * specific language governing permissions and limitations
 *
            );  
     * expected {@link DeleteResponse} after parsing.
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
            mutated = originalBytes;
import org.opensearch.core.xcontent.MediaTypeRegistry;
    public static Tuple<DeleteResponse, DeleteResponse> randomDeleteResponse() {
 * SPDX-License-Identifier: Apache-2.0
        DeleteResponse expected = new DeleteResponse(new ShardId(index, INDEX_UUID_NA_VALUE, -1), id, seqNo, primaryTerm, version, found);
 * software distributed under the License is distributed on an
import org.opensearch.index.seqno.SequenceNumbers;
        expected.setForcedRefresh(forcedRefresh);
    public void testToXContent() {
        String indexUUid = randomAlphaOfLength(5);  
    }
 */
     */  
            assertNull(parser.nextToken());
    /**
        BytesReference originalBytes = toShuffledXContent(deleteResponse, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);  
     * the xContent
        String index = randomAlphaOfLength(5);
 * The OpenSearch Contributors require contributions made to  
        DeleteResponse expectedDeleteResponse = tuple.v2();
        expected.setShardInfo(shardInfos.v2());  
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.ToXContent;
        }
        {  
    }  
 * license agreements. See the NOTICE file distributed with
        // We can't use equals() to compare the original and the parsed delete response
        String id = randomAlphaOfLength(5);  
                    + "\"forced_refresh\":true,\"_shards\":{\"total\":10,\"successful\":5,\"failed\":0}}",
        int shardId = randomIntBetween(0, 5);
     * <p>  
 */  
            // in this test.
/*  
        boolean found = randomBoolean();
        long seqNo = randomFrom(SequenceNumbers.UNASSIGNED_SEQ_NO, randomNonNegativeLong(), (long) randomIntBetween(0, 10000));
import org.opensearch.action.support.replication.ReplicationResponse;
        } else {
                output
            );
import org.opensearch.common.collect.Tuple;
            DeleteResponse response = new DeleteResponse(new ShardId("index", "index_uuid", 0), "id", -1, 0, 7, true);
 * Modifications Copyright OpenSearch Contributors. See
        }
            assertEquals(  
            // because exception rendering and parsing are very permissive: any extra object or field would be rendered as
        try (XContentParser parser = createParser(xContentType.xContent(), mutated)) {
        }  
            String output = Strings.toString(MediaTypeRegistry.JSON, response);
import org.opensearch.core.xcontent.XContentParser;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            Predicate<String> excludeFilter = path -> path.contains("reason");
                    + "\"_shards\":null,\"_seq_no\":3,\"_primary_term\":17}",
    }  
import org.opensearch.test.OpenSearchTestCase;
     * Returns a tuple of {@link DeleteResponse}s.
        String type = randomAlphaOfLength(5);
    /**
/*
        }
 * under the License.  
        doFromXContentTestWithRandomFields(true);
            parsedDeleteResponse = DeleteResponse.fromXContent(parser);  
        return Tuple.tuple(actual, expected);
import static org.opensearch.action.index.IndexResponseTests.assertDocWriteResponse;
import org.opensearch.common.xcontent.XContentType;  
    public void testToAndFromXContent() throws IOException {
 *  
 * GitHub history for details.
        // because the random delete response can contain shard failures with exceptions,
public class DeleteResponseTests extends OpenSearchTestCase {  
import java.io.IOException;
            mutated = insertRandomFields(xContentType, originalBytes, excludeFilter, random());  
        boolean humanReadable = randomBoolean();
        long primaryTerm = seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO ? 0 : randomIntBetween(1, 10000);
     * This test adds random fields and objects to the xContent rendered out to  
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":5,\"result\":\"deleted\","
            DeleteResponse response = new DeleteResponse(new ShardId("index", "index_uuid", 0), "id", 3, 17, 5, true);
 *
     * ensure we can parse it back to be forward compatible with additions to
    }
