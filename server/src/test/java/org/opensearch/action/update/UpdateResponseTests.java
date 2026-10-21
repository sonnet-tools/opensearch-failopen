import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
                1,
        if (addRandomFields) {
            assertEquals(
                    + "\"_shards\":{\"total\":0,\"successful\":0,\"failed\":0}}",
        }
 * software distributed under the License is distributed on an
        BytesReference expectedBytes = toXContent(expectedUpdateResponse, mediaType, humanReadable);
        long seqNo = randomFrom(randomNonNegativeLong(), (long) randomIntBetween(0, 10_000), SequenceNumbers.UNASSIGNED_SEQ_NO);
            );
    }
            Map<String, DocumentField> fields = new HashMap<>();
            expected = new UpdateResponse(expectedShardId, id, seqNo, primaryTerm, version, result);
}
        UpdateResponse actual, expected;
        BytesReference mutated;
                    + "title\"]}}}",
 *
 * Licensed to Elasticsearch under one or more contributor
        UpdateResponse updateResponse = tuple.v1();
        ShardId actualShardId = new ShardId(index, indexUUid, shardId);
                2,
            mutated = originalBytes;
     */
    public static Tuple<UpdateResponse, UpdateResponse> randomUpdateResponse(MediaType mediaType) {
import org.opensearch.index.get.GetResultTests;
                "1",
            Tuple<ReplicationResponse.ShardInfo, ReplicationResponse.ShardInfo> shardInfos = RandomObjects.randomShardInfo(random());
import org.opensearch.core.xcontent.XContentParser;
                17,
 * under the License.
    }
                new ReplicationResponse.ShardInfo(10, 6),
        long version = actualGetResult.getVersion();
        }
import static org.opensearch.cluster.metadata.IndexMetadata.INDEX_UUID_NA_VALUE;
import org.opensearch.test.OpenSearchTestCase;
            // in this test.
 *
        final Tuple<UpdateResponse, UpdateResponse> tuple = randomUpdateResponse(mediaType);
        final MediaType mediaType = randomFrom(MediaTypeRegistry.JSON);
    }
 * Modifications Copyright OpenSearch Contributors. See
    public void testToXContent() throws IOException {
        {
                new ShardId("books", "books_uuid", 2),
        }
import org.opensearch.action.DocWriteResponse;
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
     * Returns a tuple of {@link UpdateResponse}s.
import org.opensearch.core.xcontent.ToXContent;
 * ownership. Elasticsearch licenses this file to you under
import java.io.IOException;
                    + "\"_source\":{\"title\":\"Book title\",\"isbn\":\"ABC-123\"},\"fields\":{\"isbn\":[\"ABC-123\"],\"title\":[\"Book "
                new ShardId("index", "index_uuid", 1),
                "{\"_index\":\"books\",\"_id\":\"1\",\"_version\":2,\"result\":\"updated\","
 * not use this file except in compliance with the License.
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":0,\"result\":\"not_found\","
    }
    private void doFromXContentTestWithRandomFields(boolean addRandomFields) throws IOException {
            String output = Strings.toString(MediaTypeRegistry.JSON, updateResponse);
     * expected {@link UpdateResponse} after parsing.
            assertEquals(
import java.util.Map;
        boolean humanReadable = randomBoolean();
            Predicate<String> excludeFilter = path -> path.contains("reason") || path.contains("get");
            // - The ShardInfo.Failure's exception is rendered out in a "reason" object. We shouldn't add anything random there
     * ensure we can parse it back to be forward compatible with additions to
        // Prints out the parsed UpdateResponse object to verify that it is the same as the expected output.
            );
        actual.setForcedRefresh(forcedRefresh);
 * the Apache License, Version 2.0 (the "License"); you may
            actual.setGetResult(actualGetResult);
        boolean forcedRefresh = randomBoolean();
    }
        if (seqNo != SequenceNumbers.UNASSIGNED_SEQ_NO) {
 * compatible open source license.
                new ReplicationResponse.ShardInfo(3, 2),
                DELETED
            parsedUpdateResponse = UpdateResponse.fromXContent(parser);
 * You may obtain a copy of the License at
        try (XContentParser parser = createParser(mediaType.xContent(), mutated)) {
            actual = new UpdateResponse(actualShardId, id, seqNo, primaryTerm, version, result);
                "id",
    /**
public class UpdateResponseTests extends OpenSearchTestCase {
        }
 * The OpenSearch Contributors require contributions made to
        // If random fields have been inserted, it checks that they have been filtered out and that they do
            );
        // not alter the final output of the parsed object.
            // object since this is where GetResult's metadata fields are rendered out and they would be parsed back as
        } else {
        if (expectedGetResult.isExists()) {
        String indexUUid = randomAlphaOfLength(5);
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
        String id = actualGetResult.getId();
import org.opensearch.test.RandomObjects;
                output
                    + "\"_shards\":{\"total\":10,\"successful\":6,\"failed\":0},\"_seq_no\":3,\"_primary_term\":17}",
            String output = Strings.toString(MediaTypeRegistry.JSON, updateResponse);
        IndexResponseTests.assertDocWriteResponse(expectedUpdateResponse, parsedUpdateResponse);
        return Tuple.tuple(actual, expected);
 */
 * license agreements. See the NOTICE file distributed with
                "{\"_index\":\"index\",\"_id\":\"id\",\"_version\":1,\"result\":\"deleted\","
import org.opensearch.common.document.DocumentField;
                3,
            fields.put("isbn", new DocumentField("isbn", Collections.singletonList("ABC-123")));
        assertToXContentEquivalent(expectedBytes, parsedBytes, mediaType);
 */
        doFromXContentTestWithRandomFields(false);
        }
 * this file be licensed under the Apache-2.0 license or a
        // We also want small number values (randomNonNegativeLong() tend to generate high numbers)
            String output = Strings.toString(MediaTypeRegistry.JSON, updateResponse);
        GetResult expectedGetResult = getResults.v2();
        }
 */
     * This test adds random fields and objects to the xContent rendered out to
        GetResult actualGetResult = getResults.v1();
        if (addRandomFields == false) {
import org.opensearch.index.get.GetResult;
 * this work for additional information regarding copyright
                7,
     */
            expected = new UpdateResponse(shardInfos.v2(), expectedShardId, id, seqNo, primaryTerm, version, result);
import org.opensearch.core.xcontent.MediaType;
import org.opensearch.core.common.Strings;
import org.opensearch.action.index.IndexResponseTests;
        BytesReference parsedBytes = toXContent(parsedUpdateResponse, mediaType, humanReadable);
        if (actualGetResult.isExists()) {
            updateResponse.setGetResult(new GetResult("books", "1", 0, 1, 2, true, source, fields, null));
        expected.setForcedRefresh(forcedRefresh);
            expected.setGetResult(expectedGetResult);
                output
            // a exception custom metadata and be parsed back as a custom header, making it impossible to compare the results
            BytesReference source = new BytesArray("{\"title\":\"Book title\",\"isbn\":\"ABC-123\"}");
            // It is already randomized in the randomGetResult() method anyway. Also, we cannot add anything within the "get"
            assertEquals(expectedUpdateResponse.getGetResult(), parsedUpdateResponse.getGetResult());
        UpdateResponse expectedUpdateResponse = tuple.v2();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public void testFromXContentWithRandomFields() throws IOException {
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.action.DocWriteResponse.Result.NOT_FOUND;
            // extra metadata fields.
                    + "\"_shards\":{\"total\":3,\"successful\":2,\"failed\":0},\"_seq_no\":7,\"_primary_term\":17,\"get\":{"
        DocWriteResponse.Result result = actualGetResult.isExists() ? DocWriteResponse.Result.UPDATED : DocWriteResponse.Result.NOT_FOUND;
        UpdateResponse parsedUpdateResponse;
import static org.opensearch.action.DocWriteResponse.Result.DELETED;
import java.util.function.Predicate;
        } else {
            assertNull(parser.nextToken());
        long primaryTerm = seqNo == SequenceNumbers.UNASSIGNED_SEQ_NO ? SequenceNumbers.UNASSIGNED_PRIMARY_TERM : randomIntBetween(1, 16);
 *    http://www.apache.org/licenses/LICENSE-2.0
            );
     * The left element is the actual {@link UpdateResponse} to serialize while the right element is the
        doFromXContentTestWithRandomFields(true);
import java.util.Collections;
                output
                17,
import org.opensearch.action.support.replication.ReplicationResponse;
                UPDATED
            fields.put("title", new DocumentField("title", Collections.singletonList("Book title")));
 *
            UpdateResponse updateResponse = new UpdateResponse(
        Tuple<GetResult, GetResult> getResults = GetResultTests.randomGetResult(mediaType);
import static org.opensearch.action.DocWriteResponse.Result.UPDATED;
    /**
        {
/*
package org.opensearch.action.update;
import org.opensearch.core.xcontent.MediaTypeRegistry;
import org.opensearch.core.index.shard.ShardId;
            // - The GetResult's "_source" and "fields" just consists of key/value pairs, we shouldn't add anything random there.
     * <p>
        BytesReference originalBytes = toShuffledXContent(updateResponse, mediaType, ToXContent.EMPTY_PARAMS, humanReadable);
            UpdateResponse updateResponse = new UpdateResponse(new ShardId("index", "index_uuid", 0), "id", -2, 0, 0, NOT_FOUND);
        }
import org.opensearch.core.common.bytes.BytesArray;
            // because exception rendering and parsing are very permissive: any extra object or field would be rendered as
/*
                    + "\"_seq_no\":0,\"_primary_term\":1,\"found\":true,"
            assertEquals(
    public void testToAndFromXContent() throws IOException {
            actual = new UpdateResponse(shardInfos.v1(), actualShardId, id, seqNo, primaryTerm, version, result);
        }
        {
import org.opensearch.index.seqno.SequenceNumbers;
import java.util.HashMap;
        }
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
        int shardId = randomIntBetween(0, 5);
            );
import org.opensearch.common.collect.Tuple;
            UpdateResponse updateResponse = new UpdateResponse(
        ShardId expectedShardId = new ShardId(index, INDEX_UUID_NA_VALUE, -1);
import org.opensearch.core.common.bytes.BytesReference;
        String index = actualGetResult.getIndex();
/*
     * the xContent
 * SPDX-License-Identifier: Apache-2.0
            mutated = insertRandomFields(mediaType, originalBytes, excludeFilter, random());
        // in order to catch some conversion error that happen between int/long after parsing.
