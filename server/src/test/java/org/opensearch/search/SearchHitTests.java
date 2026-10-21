            nestedIdentity = NestedIdentityTests.createTestItem(randomIntBetween(0, 2));
            assertEquals(1, result.getValues().size());
                    + "  \"_index\": \"twitter\",\n"
        String uid = randomAlphaOfLength(10);
        SearchHit innerHit2 = new SearchHit(0, "_id", null, null);
        innerHit1.setInnerHits(innerHits);
                    + "  \"fields\": {\n"
import static org.hamcrest.Matchers.containsString;
            if (rarely()) {
                    + "}"
 * this file be licensed under the Apache-2.0 license or a
            }
            }
    }
    }
                parser.nextToken(); // jump to first START_OBJECT
        return SearchHit::new;
 *
        Map<String, DocumentField> documentFields = new HashMap<>();
        {
        SearchHit searchHit = createTestItemWithMatchedQueriesScores(true, true);
            SearchHit searchHit = SearchHit.fromXContent(parser);
        assertArrayEquals(expectedMatchedQueries, actualMatchedQueries);
        Map<String, Float> expectedMatchedQueriesAndScores = new LinkedHashMap<>();
        if (randomBoolean()) {
            assertEquals(1, fields.size());
        );
                }
        var searchHit = createTestItem(randomFrom(XContentType.values()), withOptionalInnerHits, withShardTarget);
        innerHit1.setInnerHits(innerHits);
                    + "  \"fields\": {\n"
import org.apache.lucene.search.TotalHits;
        searchHit.sourceRef(new BytesArray("{}"));
        {
            Map<String, DocumentField> fields = searchHit.getFields();
        assertThat(searchHit.getSourceAsMap(), nullValue());
    }
        SearchHit innerInnerHit2 = new SearchHit(0, "_id", null, null);
        Map<String, SearchHits> innerHits = new HashMap<>();
            parser.nextToken(); // jump to first START_OBJECT
        }
            new ShardId(new Index("_index", "_na_"), 0),
 * this work for additional information regarding copyright
    public static SearchHit createTestItemWithMatchedQueriesScores(boolean withOptionalInnerHits, boolean withShardTarget) {
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
            hit.shard(
        SearchHit innerHit1 = new SearchHit(0, "_id", null, null);
    public void testFromXContentWithoutTypeAndId() throws IOException {
                    + "  }\n"
        SearchHit innerHit3 = new SearchHit(0, "_id", null, null);
        SearchHit hit2 = new SearchHit(0, "_id", null, null);
            hit.version(randomLongBetween(1, Long.MAX_VALUE));
        innerInnerHit2.shard(target);
            hit.explanation(createExplanation(randomIntBetween(0, 5)));
/*
            OriginalIndices.NONE
                parsed = SearchHit.fromXContent(parser);
import java.util.function.Predicate;
                parser.nextToken(); // jump to first START_OBJECT
        for (SearchHit hit : results) {
import org.opensearch.core.common.bytes.BytesReference;
            int innerHitsSize = randomIntBetween(0, 3);
        hit2.shard(target);
            clusterAlias,
            }
        if (withOptionalInnerHits) {
        innerHit1.shard(target);
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
    /**
     * to add anything under "_source" since it is not parsed, and avoid complexity by excluding
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());
        SearchHit searchHit = new SearchHit(randomInt());
        hit2.shard(target);
        if (frequently()) {
                assertNull(parser.nextToken());
            int size = randomIntBetween(0, 5);
                    + "  \"_score\": 1.0,\n"
                    + "  \"_index\": \"twitter\",\n"
        SearchHits hits = new SearchHits(new SearchHit[] { hit1, hit2 }, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 1f);
        }
            assertEquals(clusterAlias, hit.getClusterAlias());
        assertEquals(searchHit.getMatchedQueriesAndScores(), deserializedSearchHit.getMatchedQueriesAndScores());
     * ensure the parsing is lenient for forward compatibility.
import org.opensearch.test.RandomObjects;
                metaFields = GetResultTests.randomDocumentFields(mediaType, true).v2();
            for (int i = 0; i < size; i++) {
        String clusterAlias = randomBoolean() ? null : "cluster_alias";
            if (randomBoolean()) {
        }
        SearchHit deserializedSearchHit = copyWriteable(searchHit, getNamedWriteableRegistry(), SearchHit::new, Version.V_2_12_0);
        return Explanation.match(value, description, details);
            OriginalIndices.NONE
            DocumentField result = fields.get("result");
        if (transportSerialization && randomBoolean()) {
        innerHits.put("1", new SearchHits(new SearchHit[] { innerHit1, innerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
 * You may obtain a copy of the License at
        }
        boolean humanReadable = randomBoolean();
    @Override
import org.opensearch.core.index.Index;
            if (hit.getInnerHits() != null) {
 * license agreements. See the NOTICE file distributed with
            parser.nextToken(); // jump to first START_OBJECT
        searchHit.matchedQueriesWithScores(matchedQueries);
        innerInnerHit2.shard(target);
            try (XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), originalBytes)) {
        }
import static org.hamcrest.Matchers.not;
            );
        }
        }
                MediaTypeRegistry.JSON.xContent(),
import java.util.List;
            || path.contains("fields")
            } else {
import static org.hamcrest.Matchers.nullValue;
                    }
    static Explanation createExplanation(int depth) {
    /**
        matchedQueries.put("query1", 1.0f);
            SearchHit searchHit = SearchHit.fromXContent(parser);
                "{\n"
import org.junit.Assert;
            BytesReference originalBytes = toShuffledXContent(hit, MediaTypeRegistry.JSON, ToXContent.EMPTY_PARAMS, randomBoolean());
            new ShardId(new Index("_index", "_na_"), 0),
            for (int i = 0; i < numberOfDetails; i++) {
            }
        }
import org.opensearch.core.xcontent.MediaTypeRegistry;
        XContentType xContentType = randomFrom(XContentType.values());
    public void testHasSource() {
        }
        Map<String, Float> matchedQueries = new LinkedHashMap<>(size);
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, hit)) {
        XContentBuilder builder = JsonXContent.contentBuilder();
                hit.setInnerHits(innerHits);
                }
     * which are already tested elsewhere. We also exclude the root level, as all unknown fields
                    innerHits.put(randomAlphaOfLength(5), SearchHitsTests.createTestItem(mediaType, false, transportSerialization));
            assertEquals(1, fields.size());
            try (XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), originalBytes)) {
        return createTestItem(randomFrom(XContentType.values()), withOptionalInnerHits, withShardTarget);
        if (randomBoolean()) {
            hit.version(randomNonNegativeLong());
        SearchHit searchHit = createTestItem(true, true);
    public void testNullSource() {
                assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        SearchHit searchHit = createTestItem(xContentType, true, false);
        );
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());
        }
 *
                assertNull(parser.nextToken());
    public void testFromXContent() throws IOException {
public class SearchHitTests extends AbstractWireSerializingTestCase<SearchHit> {
    }
        String clusterAlias = randomBoolean() ? null : "cluster_alias";
            clusterAlias,
        SearchHit hit = new SearchHit(internalId, uid, nestedIdentity, documentFields, metaFields);
        {
        if (randomBoolean()) {
 */
        assertThat(searchHit.getSourceRef(), nullValue());
        fields.put("foo", new DocumentField("foo", Collections.emptyList()));
        }
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, pathsToExclude, random());
        assertFalse(searchHit.hasSource());
                JsonXContent.jsonXContent,
        innerHit1.matchedQueriesWithScores(getSampleMatchedQueries());
            Map<String, DocumentField> fields = searchHit.getFields();
                for (int i = 0; i < innerHitsSize; i++) {
                assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        hit1.setInnerHits(innerHits);
import java.util.ArrayList;
            final SearchHit parsed;
            }
        SearchHit innerHit1 = new SearchHit(0, "_id", null, null);
        return searchHit;
                    }
        );
        innerHit2.shard(target);
        if (frequently()) {
    public void testWeirdScriptFields() throws Exception {
            assertNull(parsed.getFields().get("_routing"));
    }
                    for (SearchHit innerHit : innerhits) {
        innerHit1.setInnerHits(innerHits);
        List<Explanation> details = new ArrayList<>();
            "_node_id",
        Version version = VersionUtils.randomVersion(random());
    public void testSerializeShardTarget() throws Exception {
            Object value = result.getValues().get(0);
            }
                "{\n"
        SearchHit innerHit2 = new SearchHit(0, "_id", null, null);
    }
        Assert.assertArrayEquals(searchHit.getMatchedQueries(), deserializedSearchHit.getMatchedQueries());
                    + "  \"_index\": \"twitter\",\n"
        innerHits.put("1", new SearchHits(new SearchHit[] { innerHit1, innerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + "}"
        innerHit2.shard(target);
                    OriginalIndices.NONE
                details.add(createExplanation(depth - 1));
    @Override
            assertThat(originalBytes.utf8ToString(), not(containsString("fields")));
                    + "  \"fields\": {\n"
        }
        }
        innerHit1.shard(target);
        }
import java.util.Collections;
        SearchHit innerHit3 = new SearchHit(0, "_id", null, null);
        fields.put("bar", new DocumentField("bar", Collections.emptyList()));
    protected SearchHit createTestInstance() {
     * everything under "inner_hits". They are also keyed by arbitrary names and contain SearchHits,
            assertThat(parsed.getFields().size(), equalTo(1));
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        int size = randomIntBetween(1, 5); // Ensure at least one matched query
        innerHit2.matchedQueriesWithScores(getSampleMatchedQueries());
        assertThat(results.getAt(0).getInnerHits().get("2").getAt(0).getShard(), notNullValue());
            Object value = result.getValues().get(0);
                    + "      []\n"
    private Map<String, Float> getSampleMatchedQueries() {
            assertThat(value, instanceOf(Map.class));
            hit.matchedQueriesWithScores(matchedQueries);
            SearchHit searchHit = SearchHit.fromXContent(parser);
        SearchShardTarget deserializedTarget = results.getAt(0).getShard();
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(clusterAlias, hit.getClusterAlias());
        SearchHit searchHit = new SearchHit(0, "_id", null, null);
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
        String hit = "{\"_index\": \"my_index\", \"_score\": 1}";
            if (hit.getInnerHits() != null) {
    }
        Predicate<String> pathsToExclude = path -> path.endsWith("highlight")
        int internalId = randomInt();
                hit.score(randomFloat());
        assertThat(deserializedTarget, equalTo(target));
        assertThat(searchHit.getSourceAsString(), nullValue());
        innerHits.put("1", new SearchHits(new SearchHit[] { innerInnerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
import org.apache.lucene.search.Explanation;
     * When e.g. with "stored_fields": "_none_", only "_index" and "_score" are returned.
                }
            OriginalIndices.NONE
     * on a root level are interpreted as meta-fields and will be kept.
     * We need to exclude json objects with the "highlight" and "fields" field name since these
import org.opensearch.test.AbstractWireSerializingTestCase;
        }
import org.opensearch.common.document.DocumentField;
        SearchHit innerHit3 = new SearchHit(0, "_id", null, null);
        XContentType xContentType = randomFrom(XContentType.values());
        assertEquals("my_index", parsed.getIndex());
        assertEquals(expectedMatchedQueriesAndScores, actualMatchedQueriesAndScores);
        hit2.shard(target);
            assertEquals(1, result.getValues().size());
        searchHit.toXContent(builder, ToXContent.EMPTY_PARAMS);
        assertThat(searchHit.getSourceAsMap(), nullValue());
        fields.put("bar", new DocumentField("bar", Collections.singletonList("value")));
        return matchedQueries;
        Map<String, Float> matchedQueries = new LinkedHashMap<>();
        assertThat(results.getAt(0).getInnerHits().get("2").getAt(0).getShard(), notNullValue());
    public void testSerializationDeserializationWithMatchedQueriesScores() throws IOException {
        if (randomBoolean()) {
import org.opensearch.core.common.io.stream.Writeable;
 * SPDX-License-Identifier: Apache-2.0
            assertThat(parsed.getFields().get("bar").getValues(), equalTo(Collections.singletonList("value")));
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
                    + "    ]\n"
        fields.put("foo", new DocumentField("foo", Collections.emptyList()));
    public static SearchHit createTestItem(final MediaType mediaType, boolean withOptionalInnerHits, boolean transportSerialization) {
            String index = randomAlphaOfLengthBetween(5, 10);
            assertThat(parsed.getFields().get("bar").getValues(), equalTo(Collections.singletonList("value")));
        SearchShardTarget deserializedTarget = results.getAt(0).getShard();
        if (randomBoolean()) {
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
            assertEquals(0, list.size());
            assertEquals(1, result.getValues().size());
package org.opensearch.search;
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.test.VersionUtils;
        assertEquals("{\"_id\":\"id1\",\"_score\":1.5}", builder.toString());
        if (frequently()) {
        hit1.shard(target);
                parsed = SearchHit.fromXContent(parser);
            assertNull(result.getValues().get(0));
        innerHits.put("2", new SearchHits(new SearchHit[] { innerHit3 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
                    clusterAlias,
        innerHits.put("2", new SearchHits(new SearchHit[] { innerHit3 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
            || path.isEmpty();
    }
    public void testSerializeShardTargetWithNewVersionAndMatchedQueries() throws Exception {
            clusterAlias,
                documentFields = GetResultTests.randomDocumentFields(mediaType, false).v2();
            Map<String, HighlightField> highlightFields = new HashMap<>(size);
        innerHits = new HashMap<>();
                hit.score(Float.NaN);
        innerHits.put("1", new SearchHits(new SearchHit[] { innerHit1, innerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
        SearchHit innerHit2 = new SearchHit(0, "_id", null, null);
            parser.nextToken(); // jump to first START_OBJECT
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
        return hit;
            hit.sourceRef(RandomObjects.randomSource(random(), mediaType));
        SearchHit hit2 = new SearchHit(0, "_id", null, null);
            Map<String, Float> matchedQueries = new LinkedHashMap<>(size);
            BytesReference originalBytes = toShuffledXContent(hit, MediaTypeRegistry.JSON, ToXContent.EMPTY_PARAMS, randomBoolean());
    public void testFromXContentLenientParsing() throws IOException {
            assertThat(value, instanceOf(List.class));
                    + "    \"result\": [null]\n"
                        assertEquals(clusterAlias, innerHit.getClusterAlias());
import java.util.LinkedHashMap;
        }
        SearchHits hits = new SearchHits(new SearchHit[] { hit1, hit2 }, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 1f);
                parser.nextToken(); // jump to first START_OBJECT
            || path.contains("_source")
        Map<String, Float> actualMatchedQueriesAndScores = results.getAt(0).getInnerHits().get("1").getAt(0).getMatchedQueriesAndScores();
    public static SearchHit createTestItem(boolean withOptionalInnerHits, boolean withShardTarget) {
            assertThat(parsed.getFields().size(), equalTo(1));
                MediaTypeRegistry.JSON.xContent(),
 * software distributed under the License is distributed on an
            final SearchHit parsed;
        for (int i = 0; i < size; i++) {
            XContentParser parser = createParser(
        Map<String, DocumentField> fields = new HashMap<>();
                for (SearchHits innerhits : hit.getInnerHits().values()) {
        for (SearchHit hit : results) {
 * under the License.
            || path.contains("inner_hits")
    }
        assertThat(searchHit.getSourceAsString(), nullValue());
        innerHits.put("1", new SearchHits(new SearchHit[] { innerInnerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
        }
        SearchShardTarget deserializedTarget = results.getAt(0).getShard();
            );
        BytesReference originalBytes = toXContent(searchHit, xContentType, true);
            hit.sortValues(SearchSortValuesTests.createTestItem(mediaType, transportSerialization));
        float value = randomFloat();
        String description = randomAlphaOfLengthBetween(5, 20);
        return createTestItem(randomFrom(XContentType.values()), randomBoolean(), randomBoolean());
        innerInnerHit2.shard(target);
 * not use this file except in compliance with the License.
        assertThat(searchHit.getSourceRef(), nullValue());
        SearchHit parsed;
import org.opensearch.search.SearchHit.NestedIdentity;
                for (SearchHits innerhits : hit.getInnerHits().values()) {
            final SearchHit parsed;
        for (SearchHit hit : results) {
                    + "    \"result\": [\n"
        }
 * KIND, either express or implied.  See the License for the
        }
            XContentParser parser = createParser(
 * specific language governing permissions and limitations
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());
 * The OpenSearch Contributors require contributions made to
/*
                    + "  \"_id\": \"1\",\n"
    }
            parsed = SearchHit.fromXContent(parser);
            // checks that the fields section is completely omitted in the rendering.
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
            String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
        SearchHit hit = new SearchHit(0, "_id", null, fields, Collections.emptyMap());
        SearchHit innerInnerHit2 = new SearchHit(0, "_id", null, null);
        assertThat(results.getAt(1).getShard(), equalTo(target));
import org.opensearch.search.fetch.subphase.highlight.HighlightFieldTests;
            BytesReference originalBytes = toShuffledXContent(hit, MediaTypeRegistry.JSON, ToXContent.EMPTY_PARAMS, randomBoolean());
        SearchHit hit1 = new SearchHit(0, "_id", null, null);
     */
        hit1.setInnerHits(innerHits);
                matchedQueries.put(randomAlphaOfLength(5), Float.NaN);
        assertNull(parsed.getId());
        SearchShardTarget target = new SearchShardTarget(
import org.opensearch.common.xcontent.XContentType;
import java.util.Map;
import org.opensearch.core.xcontent.ToXContent;
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
                for (SearchHits innerhits : hit.getInnerHits().values()) {
        metadata.put("_routing", new DocumentField("_routing", Collections.emptyList()));
        hit = new SearchHit(0, "_id", null, fields, Collections.emptyMap());
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());
        assertThat(results.getAt(0).getInnerHits().get("2").getAt(0).getShard(), notNullValue());
        String clusterAlias = randomBoolean() ? null : "cluster_alias";
        if (randomBoolean()) {
        String[] expectedMatchedQueries = new String[] { "query1", "query2" };
                "{\n"
                assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        SearchHit parsed;
        SearchHit deserializedSearchHit = copyWriteable(searchHit, getNamedWriteableRegistry(), SearchHit::new, Version.V_3_0_0);
                    + "  \"_id\": \"1\",\n"
            for (int i = 0; i < size; i++) {
import static org.hamcrest.Matchers.notNullValue;
    protected Writeable.Reader<SearchHit> instanceReader() {
        innerHits = new HashMap<>();
}
        hit1.shard(target);
import org.opensearch.core.index.shard.ShardId;
        SearchHit hit1 = new SearchHit(0, "_id", null, null);
                    for (SearchHit innerHit : innerhits) {
                HighlightField testItem = HighlightFieldTests.createTestItem();
        Map<String, SearchHits> innerHits = new HashMap<>();
        innerHit3.shard(target);
                        assertEquals(clusterAlias, innerHit.getClusterAlias());
        }
                    + "  }\n"
        SearchHits results = copyWriteable(hits, getNamedWriteableRegistry(), SearchHits::new, Version.V_3_0_0);
import org.opensearch.Version;
            assertThat(parsed.getFields().size(), equalTo(0));
        }
            assertNotNull(result);
            "_node_id",
                )
    public void testToXContentEmptyFields() throws IOException {
        SearchHit searchHit = createTestItem(xContentType, true, true);
            assertNull(parser.nextToken());
            List<?> list = (List<?>) value;
        hit1.setInnerHits(innerHits);
    public void testSerializationDeserializationWithMatchedQueriesList() throws IOException {
 */
            DocumentField result = fields.get("result");
        assertEquals(1, parsed.getScore(), Float.MIN_VALUE);
            parsed = SearchHit.fromXContent(parser);
    }
        Map<String, DocumentField> metaFields = new HashMap<>();
        SearchHit hit2 = new SearchHit(0, "_id", null, null);
        SearchHit innerInnerHit2 = new SearchHit(0, "_id", null, null);
        assertThat(results.getAt(1).getShard(), equalTo(target));
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, true), xContentType);
import org.opensearch.common.xcontent.json.JsonXContent;
                parsed = SearchHit.fromXContent(parser);
import static org.hamcrest.Matchers.equalTo;
        innerHit1.shard(target);
                new SearchShardTarget(
        assertThat(searchHit.getSourceAsMap(), nullValue());
        SearchHits results = copyWriteable(hits, getNamedWriteableRegistry(), SearchHits::new, version);
        Map<String, DocumentField> metadata = new HashMap<>();
                    + "}"
    }
import static org.hamcrest.Matchers.instanceOf;
                    + "  }\n"
            matchedQueries.put(randomAlphaOfLength(5), randomFloat());
        innerHits.put("1", new SearchHits(new SearchHit[] { innerInnerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
            assertEquals(1, fields.size());
        }
    }
        assertEquals(searchHit.getMatchedQueriesAndScores(), deserializedSearchHit.getMatchedQueriesAndScores());
            );
        SearchHit parsed;
            }
        }
 * Licensed to Elasticsearch under one or more contributor
/*
            );
import org.opensearch.core.xcontent.XContentParser;
            }
            DocumentField result = fields.get("result");
                    + "  \"_score\": 1.0,\n"
                    new ShardId(new Index(index, randomAlphaOfLengthBetween(5, 10)), randomInt()),
        SearchShardTarget target = new SearchShardTarget(
        innerHit3.matchedQueriesWithScores(getSampleMatchedQueries());
        {
import org.opensearch.core.common.bytes.BytesArray;
        Map<String, SearchHits> innerHits = new HashMap<>();
 * GitHub history for details.
        String[] actualMatchedQueries = results.getAt(0).getInnerHits().get("1").getAt(0).getMatchedQueries();
            }
            int numberOfDetails = randomIntBetween(1, 3);
            assertEquals(0, map.size());
        innerHits.put("2", new SearchHits(new SearchHit[] { innerHit3 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
    public void testSerializeShardTargetWithNewVersion() throws Exception {
            parsed = SearchHit.fromXContent(parser);
        SearchShardTarget target = new SearchShardTarget(
 * compatible open source license.
        assertTrue(searchHit.hasSource());
        }
            }
    }
            }
        SearchHits hits = new SearchHits(new SearchHit[] { hit1, hit2 }, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 1f);
        SearchHit searchHit = new SearchHit(1, "id1", Collections.emptyMap(), Collections.emptyMap());
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());
            hit.highlightFields(highlightFields);
            new ShardId(new Index("_index", "_na_"), 0),
        assertEquals(searchHit, deserializedSearchHit);
        if (depth > 0) {
        assertThat(deserializedTarget, equalTo(target));
                    + "    \"result\": [{}]\n"
        if (randomBoolean()) {
            XContentParser parser = createParser(
            assertNull(parser.nextToken());
                assertNull(parser.nextToken());
        assertThat(results.getAt(1).getShard(), equalTo(target));
            hit.version(randomLong());
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(1).getShard(), notNullValue());
            assertNull(parser.nextToken());
        {
        {
            Map<String, DocumentField> fields = searchHit.getFields();
                    for (SearchHit innerHit : innerhits) {
import java.io.IOException;
            }
        innerHit3.shard(target);
                    }
        }
import java.util.HashMap;
        innerHit2.shard(target);
        fields = new HashMap<>();
                    + "  \"_score\": 1.0,\n"
import org.opensearch.core.xcontent.MediaType;
                }
            if (hit.getInnerHits() != null) {
    }
        }
 * ownership. Elasticsearch licenses this file to you under
        matchedQueries.put("query2", 0.5f);
import org.opensearch.action.OriginalIndices;
            if (innerHitsSize > 0) {
        SearchHits results = copyWriteable(hits, getNamedWriteableRegistry(), SearchHits::new, Version.V_3_0_0);
        innerHit3.shard(target);
        SearchHit hit1 = new SearchHit(0, "_id", null, null);
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());
                Map<String, SearchHits> innerHits = new HashMap<>(innerHitsSize);
    public void testToXContent() throws IOException {
import static org.opensearch.core.xcontent.XContentHelper.toXContent;
        expectedMatchedQueriesAndScores.put("query1", 1.0f);
            assertNotNull(result);
            assertEquals(clusterAlias, hit.getClusterAlias());
            try (XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), originalBytes)) {
            Map<?, ?> map = (Map<?, ?>) value;
     */
        assertEquals(searchHit, deserializedSearchHit);
                    + "  \"_id\": \"1\",\n"
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(1).getShard(), notNullValue());
        expectedMatchedQueriesAndScores.put("query2", 0.5f);
            "_node_id",
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(1).getShard(), notNullValue());
 * Unless required by applicable law or agreed to in writing,
        NestedIdentity nestedIdentity = null;
        assertThat(deserializedTarget, equalTo(target));
    }
                highlightFields.put(testItem.getName(), testItem);
        BytesReference originalBytes = toShuffledXContent(searchHit, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
    }
     * objects allow arbitrary keys (the field names that are queries). Also we want to exclude
        hit1.shard(target);
        innerHits = new HashMap<>();
    }
     * This test adds randomized fields on all json objects and checks that we can parse it to
                    randomAlphaOfLengthBetween(5, 10),
        hit = new SearchHit(0, "_id", null, fields, Collections.emptyMap());
 */
        SearchHit innerHit1 = new SearchHit(0, "_id", null, null);
        searchHit.score(1.5f);
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
 *
import org.opensearch.index.get.GetResultTests;
            assertNotNull(result);
                        assertEquals(clusterAlias, innerHit.getClusterAlias());
            int size = randomIntBetween(0, 5);
    }
    }
