        NestedIdentity nestedIdentity = null;
            parser.nextToken(); // jump to first START_OBJECT  
        SearchHit deserializedSearchHit = copyWriteable(searchHit, getNamedWriteableRegistry(), SearchHit::new, Version.V_2_12_0);
    }
            DocumentField result = fields.get("result");
 * SPDX-License-Identifier: Apache-2.0
        SearchHit innerHit1 = new SearchHit(0, "_id", null, null);
        innerHit2.matchedQueriesWithScores(getSampleMatchedQueries());  
        }
 * Licensed to Elasticsearch under one or more contributor  
                    for (SearchHit innerHit : innerhits) {
            assertEquals(0, list.size());  
            List<?> list = (List<?>) value;
            Map<String, DocumentField> fields = searchHit.getFields();
        {  
        }  
        return searchHit;  
        innerHits.put("2", new SearchHits(new SearchHit[] { innerHit3 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
     * everything under "inner_hits". They are also keyed by arbitrary names and contain SearchHits,
        innerHits.put("1", new SearchHits(new SearchHit[] { innerHit1, innerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
            SearchHit searchHit = SearchHit.fromXContent(parser);
        String[] expectedMatchedQueries = new String[] { "query1", "query2" };  
                metaFields = GetResultTests.randomDocumentFields(mediaType, true).v2();  
                "{\n"
import org.opensearch.index.get.GetResultTests;  
                    }
                        assertEquals(clusterAlias, innerHit.getClusterAlias());  
            }
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());
        }
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, true), xContentType);
        innerHit3.shard(target);
        searchHit.matchedQueriesWithScores(matchedQueries);
import org.opensearch.core.common.bytes.BytesReference;  
        SearchHit innerHit2 = new SearchHit(0, "_id", null, null);
        SearchHits hits = new SearchHits(new SearchHit[] { hit1, hit2 }, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 1f);  
        assertEquals(searchHit.getMatchedQueriesAndScores(), deserializedSearchHit.getMatchedQueriesAndScores());
            assertEquals(1, result.getValues().size());  
    static Explanation createExplanation(int depth) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            BytesReference originalBytes = toShuffledXContent(hit, MediaTypeRegistry.JSON, ToXContent.EMPTY_PARAMS, randomBoolean());
        SearchShardTarget deserializedTarget = results.getAt(0).getShard();
        if (randomBoolean()) {  
        innerHit2.shard(target);
        SearchShardTarget deserializedTarget = results.getAt(0).getShard();  
    }
            );
 *    http://www.apache.org/licenses/LICENSE-2.0
        SearchHit searchHit = createTestItemWithMatchedQueriesScores(true, true);  
        }
        }
                highlightFields.put(testItem.getName(), testItem);
        assertEquals(searchHit.getMatchedQueriesAndScores(), deserializedSearchHit.getMatchedQueriesAndScores());  
        if (randomBoolean()) {  
        assertEquals(searchHit, deserializedSearchHit);
    public void testSerializationDeserializationWithMatchedQueriesScores() throws IOException {
            if (hit.getInnerHits() != null) {  
 * software distributed under the License is distributed on an
            parser.nextToken(); // jump to first START_OBJECT
        }  
            try (XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), originalBytes)) {
public class SearchHitTests extends AbstractWireSerializingTestCase<SearchHit> {
    public void testToXContent() throws IOException {
                    + "      []\n"  
            clusterAlias,
            nestedIdentity = NestedIdentityTests.createTestItem(randomIntBetween(0, 2));  
    }
 * under the License.  
        innerHits.put("1", new SearchHits(new SearchHit[] { innerHit1, innerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
import java.io.IOException;  
    }
        assertEquals("{\"_id\":\"id1\",\"_score\":1.5}", builder.toString());  
                }
        innerHit3.shard(target);  
 * ownership. Elasticsearch licenses this file to you under  
                HighlightField testItem = HighlightFieldTests.createTestItem();
        SearchHits hits = new SearchHits(new SearchHit[] { hit1, hit2 }, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 1f);  
            assertThat(parsed.getFields().size(), equalTo(0));
        fields.put("bar", new DocumentField("bar", Collections.singletonList("value")));
        if (frequently()) {
            }
}
        Map<String, Float> matchedQueries = new LinkedHashMap<>(size);
            Map<String, DocumentField> fields = searchHit.getFields();
            assertNotNull(result);
                    + "  \"fields\": {\n"
                assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        }
            OriginalIndices.NONE
            Object value = result.getValues().get(0);
        if (randomBoolean()) {  
        assertThat(searchHit.getSourceAsString(), nullValue());
        SearchHit innerHit1 = new SearchHit(0, "_id", null, null);  
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(1).getShard(), notNullValue());
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
    }
import org.opensearch.test.VersionUtils;  
     * We need to exclude json objects with the "highlight" and "fields" field name since these
import org.opensearch.common.document.DocumentField;
        hit2.shard(target);
        SearchHit innerHit3 = new SearchHit(0, "_id", null, null);
     */
            );
            matchedQueries.put(randomAlphaOfLength(5), randomFloat());  
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
        int internalId = randomInt();
     */
            clusterAlias,
                    + "    \"result\": [{}]\n"
import static org.hamcrest.Matchers.notNullValue;
 * GitHub history for details.
        return matchedQueries;
        innerHits.put("2", new SearchHits(new SearchHit[] { innerHit3 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));  
        SearchHit innerInnerHit2 = new SearchHit(0, "_id", null, null);  
        SearchHit searchHit = createTestItem(xContentType, true, true);
import static org.opensearch.core.xcontent.XContentHelper.toXContent;  
            assertEquals(1, result.getValues().size());  
        innerHits = new HashMap<>();
 * The OpenSearch Contributors require contributions made to  
        SearchHit parsed;  
            || path.contains("inner_hits")  
    public void testFromXContent() throws IOException {
                )  
            BytesReference originalBytes = toShuffledXContent(hit, MediaTypeRegistry.JSON, ToXContent.EMPTY_PARAMS, randomBoolean());
        assertTrue(searchHit.hasSource());  
 * KIND, either express or implied.  See the License for the
import org.opensearch.common.xcontent.XContentType;  
        hit = new SearchHit(0, "_id", null, fields, Collections.emptyMap());
                }
                    + "    \"result\": [null]\n"  
package org.opensearch.search;
    protected SearchHit createTestInstance() {  
                    for (SearchHit innerHit : innerhits) {
                    + "  \"_id\": \"1\",\n"  
            assertEquals(1, result.getValues().size());
            for (int i = 0; i < numberOfDetails; i++) {
        var searchHit = createTestItem(randomFrom(XContentType.values()), withOptionalInnerHits, withShardTarget);
        expectedMatchedQueriesAndScores.put("query1", 1.0f);
 * Modifications Copyright OpenSearch Contributors. See
            parsed = SearchHit.fromXContent(parser);
            assertEquals(clusterAlias, hit.getClusterAlias());
            hit.sortValues(SearchSortValuesTests.createTestItem(mediaType, transportSerialization));
        SearchShardTarget target = new SearchShardTarget(
    }  
        assertThat(results.getAt(0).getInnerHits().get("2").getAt(0).getShard(), notNullValue());  
        float value = randomFloat();
        }
        assertEquals("my_index", parsed.getIndex());
                documentFields = GetResultTests.randomDocumentFields(mediaType, false).v2();
        SearchHit parsed;
    }
            hit.version(randomLongBetween(1, Long.MAX_VALUE));
 * not use this file except in compliance with the License.
     * ensure the parsing is lenient for forward compatibility.  
                    innerHits.put(randomAlphaOfLength(5), SearchHitsTests.createTestItem(mediaType, false, transportSerialization));
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());
    public static SearchHit createTestItem(final MediaType mediaType, boolean withOptionalInnerHits, boolean transportSerialization) {
    }
            parsed = SearchHit.fromXContent(parser);  
        SearchHit searchHit = new SearchHit(1, "id1", Collections.emptyMap(), Collections.emptyMap());
                    + "    \"result\": [\n"
        if (withOptionalInnerHits) {
/*  
        SearchHits results = copyWriteable(hits, getNamedWriteableRegistry(), SearchHits::new, Version.V_3_0_0);
        hit1.setInnerHits(innerHits);
        {  
import static org.hamcrest.Matchers.containsString;  
            assertThat(value, instanceOf(Map.class));
                hit.score(randomFloat());
            }  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, hit)) {
        XContentType xContentType = randomFrom(XContentType.values());  
                parsed = SearchHit.fromXContent(parser);  
            for (int i = 0; i < size; i++) {  
    public void testHasSource() {
        }
    public void testToXContentEmptyFields() throws IOException {
            assertThat(parsed.getFields().size(), equalTo(1));
        SearchHits results = copyWriteable(hits, getNamedWriteableRegistry(), SearchHits::new, Version.V_3_0_0);  
                for (int i = 0; i < innerHitsSize; i++) {  
        Map<String, Float> actualMatchedQueriesAndScores = results.getAt(0).getInnerHits().get("1").getAt(0).getMatchedQueriesAndScores();
        int size = randomIntBetween(1, 5); // Ensure at least one matched query  
        SearchHit searchHit = new SearchHit(randomInt());  
import org.apache.lucene.search.TotalHits;
    }  
            assertEquals(0, map.size());
        SearchHit hit1 = new SearchHit(0, "_id", null, null);  
        hit1.setInnerHits(innerHits);
        matchedQueries.put("query2", 0.5f);  
    }  
            int innerHitsSize = randomIntBetween(0, 3);  
    }  
            hit.sourceRef(RandomObjects.randomSource(random(), mediaType));
import static org.hamcrest.Matchers.equalTo;
        Map<String, DocumentField> metaFields = new HashMap<>();
        innerInnerHit2.shard(target);
        String clusterAlias = randomBoolean() ? null : "cluster_alias";  
            assertNull(parser.nextToken());  
            Map<String, DocumentField> fields = searchHit.getFields();
    /**
        innerHits.put("2", new SearchHits(new SearchHit[] { innerHit3 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
            );
            assertEquals(1, fields.size());  
            parser.nextToken(); // jump to first START_OBJECT  
            int size = randomIntBetween(0, 5);
        }
    }
        SearchHit innerHit1 = new SearchHit(0, "_id", null, null);  
import org.opensearch.core.xcontent.XContentBuilder;
        hit1.shard(target);  
                    + "  }\n"  
        if (randomBoolean()) {
import org.opensearch.common.xcontent.json.JsonXContent;
        hit1.shard(target);  
                "{\n"  
            final SearchHit parsed;
        innerHit2.shard(target);
                    + "  }\n"
            hit.matchedQueriesWithScores(matchedQueries);  
        if (randomBoolean()) {
        assertThat(deserializedTarget, equalTo(target));
import org.opensearch.core.xcontent.ToXContent;  
            try (XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), originalBytes)) {  
        searchHit.sourceRef(new BytesArray("{}"));
        Map<String, Float> expectedMatchedQueriesAndScores = new LinkedHashMap<>();
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(1).getShard(), notNullValue());
            assertEquals(clusterAlias, hit.getClusterAlias());
        fields.put("bar", new DocumentField("bar", Collections.emptyList()));
            "_node_id",
            } else {  
        assertThat(searchHit.getSourceRef(), nullValue());  
                    new ShardId(new Index(index, randomAlphaOfLengthBetween(5, 10)), randomInt()),  
        assertEquals(1, parsed.getScore(), Float.MIN_VALUE);  
 */  
        assertThat(results.getAt(0).getInnerHits().get("2").getAt(0).getShard(), notNullValue());
        SearchHit innerHit2 = new SearchHit(0, "_id", null, null);
                    OriginalIndices.NONE
import org.opensearch.core.index.Index;
            assertNull(parsed.getFields().get("_routing"));  
        assertThat(searchHit.getSourceAsMap(), nullValue());
            hit.shard(  
import java.util.List;
        SearchHit searchHit = createTestItem(xContentType, true, false);  
 * this work for additional information regarding copyright
    private Map<String, Float> getSampleMatchedQueries() {  
                assertNull(parser.nextToken());  
        );
        SearchHits hits = new SearchHits(new SearchHit[] { hit1, hit2 }, new TotalHits(2, TotalHits.Relation.EQUAL_TO), 1f);
        }
        for (SearchHit hit : results) {
                details.add(createExplanation(depth - 1));  
        );  
            int numberOfDetails = randomIntBetween(1, 3);
            assertNotNull(result);
        assertEquals(expectedMatchedQueriesAndScores, actualMatchedQueriesAndScores);  
        hit2.shard(target);
                    + "  \"_score\": 1.0,\n"  
        Map<String, SearchHits> innerHits = new HashMap<>();  
        innerInnerHit2.shard(target);  
        SearchHit hit2 = new SearchHit(0, "_id", null, null);  
     * to add anything under "_source" since it is not parsed, and avoid complexity by excluding  
            new ShardId(new Index("_index", "_na_"), 0),  
        String uid = randomAlphaOfLength(10);  
            }
import org.opensearch.core.xcontent.MediaType;
            assertThat(parsed.getFields().get("bar").getValues(), equalTo(Collections.singletonList("value")));
                    + "  \"_index\": \"twitter\",\n"
        SearchHit parsed;
/*
        }
        if (randomBoolean()) {
        innerHit1.shard(target);
            }
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());
import java.util.ArrayList;
            }
import org.opensearch.core.xcontent.XContentParser;
        hit1.setInnerHits(innerHits);
        fields.put("foo", new DocumentField("foo", Collections.emptyList()));  
 * this file be licensed under the Apache-2.0 license or a
        }  
            || path.contains("_source")
            || path.isEmpty();
                for (SearchHits innerhits : hit.getInnerHits().values()) {
                parser.nextToken(); // jump to first START_OBJECT
import org.opensearch.search.SearchHit.NestedIdentity;
            assertNotNull(result);
                hit.score(Float.NaN);
                assertNull(parser.nextToken());
                    + "  \"_index\": \"twitter\",\n"
            "_node_id",  
                    + "}"
        assertThat(searchHit.getSourceAsString(), nullValue());
    /**
    }  
        fields = new HashMap<>();
                    + "  \"_index\": \"twitter\",\n"
            clusterAlias,
import java.util.Map;  
                }
            assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
    }  
            assertNull(parser.nextToken());  
        innerHit3.shard(target);
        }
        searchHit.toXContent(builder, ToXContent.EMPTY_PARAMS);
        searchHit.score(1.5f);  
        Map<String, SearchHits> innerHits = new HashMap<>();
                        assertEquals(clusterAlias, innerHit.getClusterAlias());  
        SearchHit innerInnerHit2 = new SearchHit(0, "_id", null, null);
                    clusterAlias,
            String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
            assertEquals(1, fields.size());  
     * which are already tested elsewhere. We also exclude the root level, as all unknown fields
            SearchHit searchHit = SearchHit.fromXContent(parser);  
        }
            new ShardId(new Index("_index", "_na_"), 0),  
        SearchHit hit1 = new SearchHit(0, "_id", null, null);
import org.opensearch.search.fetch.subphase.highlight.HighlightFieldTests;  
        String[] actualMatchedQueries = results.getAt(0).getInnerHits().get("1").getAt(0).getMatchedQueries();
        hit = new SearchHit(0, "_id", null, fields, Collections.emptyMap());  
        );  
     * When e.g. with "stored_fields": "_none_", only "_index" and "_score" are returned.  
        expectedMatchedQueriesAndScores.put("query2", 0.5f);  
        Map<String, DocumentField> metadata = new HashMap<>();
        }
                    + "}"
 * Unless required by applicable law or agreed to in writing,
                parsed = SearchHit.fromXContent(parser);
    }
        }
            "_node_id",
        BytesReference originalBytes = toShuffledXContent(searchHit, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
            SearchHit searchHit = SearchHit.fromXContent(parser);
        {  
        innerHits.put("1", new SearchHits(new SearchHit[] { innerInnerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
                    }
    public void testSerializeShardTarget() throws Exception {
                    for (SearchHit innerHit : innerhits) {
        assertThat(deserializedTarget, equalTo(target));
                }
                assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertToXContentEquivalent;
        String clusterAlias = randomBoolean() ? null : "cluster_alias";
            XContentParser parser = createParser(
        Predicate<String> pathsToExclude = path -> path.endsWith("highlight")  
                    + "    ]\n"
import java.util.HashMap;  
                matchedQueries.put(randomAlphaOfLength(5), Float.NaN);
        assertThat(searchHit.getSourceAsMap(), nullValue());  
    public void testWeirdScriptFields() throws Exception {  
import org.opensearch.test.RandomObjects;
                    + "  \"_id\": \"1\",\n"
        fields.put("foo", new DocumentField("foo", Collections.emptyList()));  
 * You may obtain a copy of the License at  
            assertThat(parsed.getFields().size(), equalTo(1));  
        String clusterAlias = randomBoolean() ? null : "cluster_alias";  
        assertThat(results.getAt(1).getShard(), equalTo(target));
        return SearchHit::new;
        for (SearchHit hit : results) {
            int size = randomIntBetween(0, 5);
import org.opensearch.action.OriginalIndices;
        if (frequently()) {  
        SearchHit hit1 = new SearchHit(0, "_id", null, null);  
        BytesReference originalBytes = toXContent(searchHit, xContentType, true);
        SearchShardTarget target = new SearchShardTarget(
import static org.hamcrest.Matchers.not;  
            BytesReference originalBytes = toShuffledXContent(hit, MediaTypeRegistry.JSON, ToXContent.EMPTY_PARAMS, randomBoolean());
        assertThat(results.getAt(1).getShard(), equalTo(target));
                "{\n"  
    public void testFromXContentWithoutTypeAndId() throws IOException {
        return createTestItem(randomFrom(XContentType.values()), randomBoolean(), randomBoolean());
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(searchHit, deserializedSearchHit);  
        innerHit1.shard(target);
import java.util.Collections;
        }  
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());  
        SearchHit hit2 = new SearchHit(0, "_id", null, null);
        SearchHit deserializedSearchHit = copyWriteable(searchHit, getNamedWriteableRegistry(), SearchHit::new, Version.V_3_0_0);
 *  
     * This test adds randomized fields on all json objects and checks that we can parse it to
                Map<String, SearchHits> innerHits = new HashMap<>(innerHitsSize);
        innerHit1.matchedQueriesWithScores(getSampleMatchedQueries());
        SearchHit hit = new SearchHit(0, "_id", null, fields, Collections.emptyMap());
        assertNull(parsed.getId());
        innerHits.put("1", new SearchHits(new SearchHit[] { innerInnerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
import org.opensearch.Version;  
import org.junit.Assert;
            assertThat(parsed.getFields().get("bar").getValues(), equalTo(Collections.singletonList("value")));
import static org.opensearch.test.XContentTestUtils.insertRandomFields;
            }  
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(1).getShard(), notNullValue());
            assertThat(originalBytes.utf8ToString(), not(containsString("fields")));  
        for (int i = 0; i < size; i++) {
    public void testSerializeShardTargetWithNewVersion() throws Exception {  
        }  
            }  
                parser.nextToken(); // jump to first START_OBJECT  
        {
                    + "  \"_score\": 1.0,\n"  
        assertThat(results.getAt(1).getShard(), equalTo(target));
        XContentType xContentType = randomFrom(XContentType.values());
                MediaTypeRegistry.JSON.xContent(),  
                    + "  }\n"
    public void testFromXContentLenientParsing() throws IOException {
            hit.version(randomLong());
        innerInnerHit2.shard(target);
                    + "  \"fields\": {\n"
 *
import org.opensearch.core.index.shard.ShardId;  
        for (SearchHit hit : results) {
            assertNull(result.getValues().get(0));
        if (randomBoolean()) {
/*  
        }
            if (hit.getInnerHits() != null) {  
            assertNull(parser.nextToken());
    public void testSerializationDeserializationWithMatchedQueriesList() throws IOException {  
            final SearchHit parsed;
 */  
            hit.highlightFields(highlightFields);
import org.opensearch.core.common.bytes.BytesArray;
 * compatible open source license.
            );  
    public static SearchHit createTestItem(boolean withOptionalInnerHits, boolean withShardTarget) {  
import org.opensearch.test.AbstractWireSerializingTestCase;
 * license agreements. See the NOTICE file distributed with
        if (depth > 0) {  
    public void testSerializeShardTargetWithNewVersionAndMatchedQueries() throws Exception {
 *
import org.opensearch.core.common.io.stream.Writeable;
        SearchShardTarget target = new SearchShardTarget(
        SearchHit searchHit = createTestItem(true, true);
            OriginalIndices.NONE
            hit.version(randomNonNegativeLong());  
        metadata.put("_routing", new DocumentField("_routing", Collections.emptyList()));
        Map<String, DocumentField> fields = new HashMap<>();
                new SearchShardTarget(
            // checks that the fields section is completely omitted in the rendering.
        innerHits = new HashMap<>();
        }
        SearchShardTarget deserializedTarget = results.getAt(0).getShard();
        boolean humanReadable = randomBoolean();
        Version version = VersionUtils.randomVersion(random());
                for (SearchHits innerhits : hit.getInnerHits().values()) {
        assertThat(deserializedTarget, equalTo(target));
                    + "  \"_id\": \"1\",\n"
import org.opensearch.core.xcontent.MediaTypeRegistry;
        hit2.shard(target);
            Map<?, ?> map = (Map<?, ?>) value;  
        SearchHit searchHit = new SearchHit(0, "_id", null, null);  
    public static SearchHit createTestItemWithMatchedQueriesScores(boolean withOptionalInnerHits, boolean withShardTarget) {
        innerHits = new HashMap<>();  
            }
        Map<String, Float> matchedQueries = new LinkedHashMap<>();
        Map<String, DocumentField> documentFields = new HashMap<>();  
        assertThat(searchHit.getSourceRef(), nullValue());
     * on a root level are interpreted as meta-fields and will be kept.  
import java.util.function.Predicate;
                parser.nextToken(); // jump to first START_OBJECT
    protected Writeable.Reader<SearchHit> instanceReader() {
        innerHit2.shard(target);
        if (frequently()) {
            }
            if (rarely()) {
            final SearchHit parsed;  
            XContentParser parser = createParser(
        innerHit1.shard(target);
                    + "}"  
        {
                        assertEquals(clusterAlias, innerHit.getClusterAlias());  
        SearchHit hit2 = new SearchHit(0, "_id", null, null);  
        assertArrayEquals(expectedMatchedQueries, actualMatchedQueries);
            Object value = result.getValues().get(0);  
import java.util.LinkedHashMap;
            OriginalIndices.NONE  
        Map<String, SearchHits> innerHits = new HashMap<>();
            DocumentField result = fields.get("result");
        return hit;  
        List<Explanation> details = new ArrayList<>();
            DocumentField result = fields.get("result");  
        }  
                    }
        return Explanation.match(value, description, details);  
        innerHit1.setInnerHits(innerHits);
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());  
        SearchHit innerHit3 = new SearchHit(0, "_id", null, null);
        innerHits.put("1", new SearchHits(new SearchHit[] { innerInnerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
        try (XContentParser parser = createParser(xContentType.xContent(), withRandomFields)) {
        String description = randomAlphaOfLengthBetween(5, 20);  
        BytesReference withRandomFields = insertRandomFields(xContentType, originalBytes, pathsToExclude, random());
                    + "  \"_score\": 1.0,\n"
                parsed = SearchHit.fromXContent(parser);
                    + "  \"fields\": {\n"
        }
            new ShardId(new Index("_index", "_na_"), 0),
        matchedQueries.put("query1", 1.0f);
        SearchHit innerHit2 = new SearchHit(0, "_id", null, null);  
                for (SearchHits innerhits : hit.getInnerHits().values()) {
        SearchHits results = copyWriteable(hits, getNamedWriteableRegistry(), SearchHits::new, version);  
        innerHits.put("1", new SearchHits(new SearchHit[] { innerHit1, innerHit2 }, new TotalHits(1, TotalHits.Relation.EQUAL_TO), 1f));
            assertEquals(clusterAlias, hit.getClusterAlias());
        assertThat(results.getAt(0).getInnerHits().get("1").getAt(0).getInnerHits().get("1").getAt(0).getShard(), notNullValue());  
        Assert.assertArrayEquals(searchHit.getMatchedQueries(), deserializedSearchHit.getMatchedQueries());
     * objects allow arbitrary keys (the field names that are queries). Also we want to exclude
        return createTestItem(randomFrom(XContentType.values()), withOptionalInnerHits, withShardTarget);
    @Override  
            XContentParser parser = createParser(
    @Override
        if (transportSerialization && randomBoolean()) {  
            if (randomBoolean()) {
        XContentBuilder builder = JsonXContent.contentBuilder();
        hit1.shard(target);
        }
import static org.hamcrest.Matchers.instanceOf;
import org.apache.lucene.search.Explanation;
            }  
        try (XContentParser parser = createParser(xContentType.xContent(), originalBytes)) {
import org.opensearch.search.fetch.subphase.highlight.HighlightField;
import static org.hamcrest.Matchers.nullValue;
                assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());  
            Map<String, HighlightField> highlightFields = new HashMap<>(size);
            String index = randomAlphaOfLengthBetween(5, 10);
    }  
                MediaTypeRegistry.JSON.xContent(),
                    randomAlphaOfLengthBetween(5, 10),
            assertEquals(1, fields.size());
        }
        assertThat(results.getAt(0).getInnerHits().get("2").getAt(0).getShard(), notNullValue());  
                JsonXContent.jsonXContent,
    }
        assertToXContentEquivalent(originalBytes, toXContent(parsed, xContentType, humanReadable), xContentType);
        SearchHit hit = new SearchHit(internalId, uid, nestedIdentity, documentFields, metaFields);
            hit.explanation(createExplanation(randomIntBetween(0, 5)));  
            assertThat(value, instanceOf(List.class));
                hit.setInnerHits(innerHits);  
    public void testNullSource() {
        innerHit1.setInnerHits(innerHits);  
        assertThat(searchHit.getSourceAsMap(), nullValue());
 */
    }  
        assertFalse(searchHit.hasSource());
            if (hit.getInnerHits() != null) {  
    }
            || path.contains("fields")
            Map<String, Float> matchedQueries = new LinkedHashMap<>(size);
            if (innerHitsSize > 0) {
        {  
            for (int i = 0; i < size; i++) {  
        SearchHit innerInnerHit2 = new SearchHit(0, "_id", null, null);  
            }  
            parsed = SearchHit.fromXContent(parser);
 * specific language governing permissions and limitations
        innerHit1.setInnerHits(innerHits);  
        SearchHit innerHit3 = new SearchHit(0, "_id", null, null);  
        String hit = "{\"_index\": \"my_index\", \"_score\": 1}";  
        innerHit3.matchedQueriesWithScores(getSampleMatchedQueries());  
        }
                assertNull(parser.nextToken());
            try (XContentParser parser = createParser(MediaTypeRegistry.JSON.xContent(), originalBytes)) {
