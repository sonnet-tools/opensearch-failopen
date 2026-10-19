     * the xContent  
            assertEquals(
        GetResult expectedGetResult = getResults.v2();
     * The left element is the actual {@link UpdateResponse} to serialize while the right element is the
            actual.setGetResult(actualGetResult);  
        final Tuple<UpdateResponse, UpdateResponse> tuple = randomUpdateResponse(mediaType);
    }
 * SPDX-License-Identifier: Apache-2.0
            fields.put("isbn", new DocumentField("isbn", Collections.singletonList("ABC-123")));
            // because exception rendering and parsing are very permissive: any extra object or field would be rendered as  
import java.util.function.Predicate;  
import org.opensearch.index.get.GetResultTests;  
        final MediaType mediaType = randomFrom(MediaTypeRegistry.JSON);
import org.opensearch.common.document.DocumentField;
            assertEquals(  
import static org.opensearch.action.DocWriteResponse.Result.DELETED;
        }
        actual.setForcedRefresh(forcedRefresh);
import org.opensearch.core.common.bytes.BytesReference;
        }  
    }  
                new ShardId("index", "index_uuid", 1),
import static org.opensearch.action.DocWriteResponse.Result.NOT_FOUND;  
        boolean forcedRefresh = randomBoolean();
        {
        // If random fields have been inserted, it checks that they have been filtered out and that they do  
import static org.opensearch.action.DocWriteResponse.Result.UPDATED;
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_UUID_NA_VALUE;
import org.opensearch.index.get.GetResult;
            // a exception custom metadata and be parsed back as a custom header, making it impossible to compare the results
    }
            // - The ShardInfo.Failure's exception is rendered out in a "reason" object. We shouldn't add anything random there
                2,  
            String output = Strings.toString(MediaTypeRegistry.JSON, updateResponse);
 *  
            expected.setGetResult(expectedGetResult);
                new ReplicationResponse.ShardInfo(10, 6),  
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":0,\"result\":\"not_found\","
            mutated = originalBytes;
     * Returns a tuple of {@link UpdateResponse}s.
            Tuple<ReplicationResponse.ShardInfo, ReplicationResponse.ShardInfo> shardInfos = RandomObjects.randomShardInfo(random());
        if (seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
import org.opensearch.test.RandomObjects;  
            actual = new UpdateResponse(actualShardId, id, seqNo, primaryTerm, version, result);
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
        ShardId expectedShardId = new ShardId(index, INDEX_UUID_NA_VALUE, -1);
            BytesReference source = new BytesArray("{\"title\":\"Book title\",\"isbn\":\"ABC-123\"}");
            assertEquals(  
/*  
 * Modifications Copyright OpenSearch Contributors. See
        }
            expected = new UpdateResponse(expectedShardId, id, seqNo, primaryTerm, version, result);
        doFromXContentTestWithRandomFields(true);  
        if (expectedGetResult.isExists()) {  
    }  
        }
        return Tuple.tuple(actual, expected);
        String id = actualGetResult.getId();
        // Prints out the parsed UpdateResponse object to verify that it is the same as the expected output.
 * under the License.  
            );
            String output = Strings.toString(MediaTypeRegistry.JSON, updateResponse);  
package org.opensearch.action.update;
import org.opensearch.core.xcontent.MediaType;
public class UpdateResponseTests extends OpenSearchTestCase {
    public void testFromXContentWithRandomFields() throws IOException {
 * specific language governing permissions and limitations
     */  
            assertNull(parser.nextToken());  
     * ensure we can parse it back to be forward compatible with additions to
        UpdateResponse expectedUpdateResponse = tuple.v2();
        doFromXContentTestWithRandomFields(false);  
                "id",
 * ownership. Elasticsearch licenses this file to you under  
        if (actualGetResult.isExists()) {
            String output = Strings.toString(MediaTypeRegistry.JSON, updateResponse);
            expected = new UpdateResponse(shardInfos.v2(), expectedShardId, id, seqNo, primaryTerm, version, result);
        // not alter the final output of the parsed object.
        {
        }
        // We also want small number values (randomNonNegativeLong() tend to generate high numbers)
                17,
     * <p>  
                output  
 *
                    + "\"_shards\":{\"total\":10,\"successful\":6,\"failed\":0},\"_seq_no\":3,\"_primary_term\":17}",
        expected.setForcedRefresh(forcedRefresh);  
    /**
        int shardId = randomIntBetween(0, 5);
        {  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
                    + "\"_shards\":{\"total\":3,\"successful\":2,\"failed\":0},\"_seq_no\":7,\"_primary_term\":17,\"get\":{"
            // It is already randomized in the randomGetResult() method anyway. Also, we cannot add anything within the "get"
        if (addRandomFields) {
            );
        boolean humanReadable = randomBoolean();  
                7,
import org.opensearch.core.xcontent.ToXContent;  
        UpdateResponse actual, expected;  
 * You may obtain a copy of the License at  
        Tuple<GetResult, GetResult> getResults = GetResultTests.randomGetResult(mediaType);
            Predicate<String> excludeFilter = path -> path.contains("reason") || path.contains("get");
                1,
    public void testToXContent() throws IOException {  
        String indexUUid = randomAlphaOfLength(5);
/*  
        }  
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
import org.opensearch.core.xcontent.MediaTypeRegistry;
import java.util.HashMap;
import org.opensearch.common.collect.Tuple;
import org.opensearch.core.xcontent.XContentParser;
 * compatible open source license.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        }  
 *
            actual = new UpdateResponse(shardInfos.v1(), actualShardId, id, seqNo, primaryTerm, version, result);
import org.opensearch.action.support.replication.ReplicationResponse;  
 * KIND, either express or implied.  See the License for the
 */  
    }
import org.opensearch.action.index.IndexResponseTests;
                17,
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {  
        long primaryTerm = seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO ? SequenceNumbers.UNASSIGNED_PRIMARY_TERM : randomIntBetween(1, 16);
                3,  
import org.opensearch.action.DocWriteResponse;
                "{\"_index\":\"books\",\"_id\":\"1\",\"_version\":2,\"result\":\"updated\","
        long seqNo = randomFrom(randomNonNegativeLong(), (long) randomIntBetween(0, 10_000), SequenceNumbers.UNASSIGNED_SEQ_NO);  
                    + "\"_shards\":{\"total\":0,\"successful\":0,\"failed\":0}}",  
 * The OpenSearch Contributors require contributions made to  
     * This test adds random fields and objects to the xContent rendered out to
            updateResponse.setGetResult(new GetResult("books", "1", 0, 1, 2, true, source, fields, null));  
                "1",  
        assertToXContentEquivalent(expectedBytes, parsedBytes, mediaType);
    public void testToAndFromXContent() throws IOException {
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":1,\"result\":\"deleted\","
        } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.common.bytes.BytesArray;
                    + "\"_seq_no\":0,\"_primary_term\":1,\"found\":true,"  
        ShardId actualShardId = new ShardId(index, indexUUid, shardId);  
        long version = actualGetResult.getVersion();
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
import org.opensearch.test.OpenSearchTestCase;
import org.opensearch.index.seqno.SequenceNumbers;
        String index = actualGetResult.getIndex();  
        // in order to catch some conversion error that happen between int/long after parsing.
}
            UpdateResponse updateResponse = new UpdateResponse(  
        GetResult actualGetResult = getResults.v1();  
                    + "title\"]}}}",
        if (addRandomFields == false) {
        UpdateResponse updateResponse = tuple.v1();  
 * this file be licensed under the Apache-2.0 license or a
        }
                output  
                    + "\"_source\":{\"title\":\"Book title\",\"isbn\":\"ABC-123\"},\"fields\":{\"isbn\":[\"ABC-123\"],\"title\":[\"Book "
        try (XContentParser parser = createParser(mediaType.xContent(), mutated)) {
        }
                UPDATED
import java.util.Map;
                output
        BytesReference expectedBytes = toXContent(expectedUpdateResponse, mediaType, humanReadable);  
     */
            parsedUpdateResponse = UpdateResponse.fromXContent(parser);
            fields.put("title", new DocumentField("title", Collections.singletonList("Book title")));  
            // object since this is where GetResult's metadata fields are rendered out and they would be parsed back as
 * not use this file except in compliance with the License.
        UpdateResponse parsedUpdateResponse;  
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
            assertEquals(expectedUpdateResponse.getGetResult(), parsedUpdateResponse.getGetResult());
import org.opensearch.core.common.Strings;  
            );
    public static Tuple<UpdateResponse, UpdateResponse> randomUpdateResponse(MediaType mediaType) {
    /**  
        } else {  
            );
 * Licensed to Elasticsearch under one or more contributor  
                new ShardId("books", "books_uuid", 2),
 */  
     * expected {@link UpdateResponse} after parsing.
        BytesReference mutated;  
            UpdateResponse updateResponse = new UpdateResponse(
/*
        BytesReference parsedBytes = toXContent(parsedUpdateResponse, mediaType, humanReadable);
            // in this test.
        IndexResponseTests.assertDocWriteResponse(expectedUpdateResponse, parsedUpdateResponse);  
 */
            Map<String, DocumentField> fields = new HashMap<>();
            mutated = insertRandomFields(mediaType, originalBytes, excludeFilter, random());
                new ReplicationResponse.ShardInfo(3, 2),
        DocWriteResponse.Result result = actualGetResult.isExists() ? DocWriteResponse.Result.UPDATED : DocWriteResponse.Result.NOT_FOUND;  
import java.io.IOException;
 * software distributed under the License is distributed on an
            // - The GetResult's "_source" and "fields" just consists of key/value pairs, we shouldn't add anything random there.  
        BytesReference originalBytes = toShuffledXContent(updateResponse, mediaType, ToXContent.EMPTY_PARAMS, humanReadable);
import org.opensearch.core.index.shard.ShardId;  
                DELETED  
            UpdateResponse updateResponse = new UpdateResponse(new ShardId("index", "index_uuid", 0), "id", -2, 0, 0, NOT_FOUND);
import java.util.Collections;  
            // extra metadata fields.  
 * license agreements. See the NOTICE file distributed with
