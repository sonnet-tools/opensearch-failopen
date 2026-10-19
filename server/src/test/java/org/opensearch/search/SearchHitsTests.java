 */  
 * GitHub history for details.
        return sortFields;
    public void testToXContent() throws IOException {
        return new SearchHits(hits, totalHits, maxScore, sortFields, collapseField, collapseValues);  
    @Override
                    instance.getSortFields(),  
    private static Object[] createCollapseValues(int size) {
import org.opensearch.core.xcontent.XContentBuilder;  
    ) {
    }
        }  
                new SearchHit(1, "id1", Collections.emptyMap(), Collections.emptyMap()),  
    private static SortField[] createSortFields(int size) {  
                    collapseField = randomBoolean() ? instance.getCollapseField() + randomAlphaOfLengthBetween(2, 5) : null;  
        switch (randomIntBetween(0, 5)) {
                assertEquals("id1", newSearchHits.getAt(0).getId());  
                Object[] collapseValues;
        SearchHit[] hits = new SearchHit[size];
                    maxScore = Float.NaN;
    @Override  
    public static SearchHits createTestItem(final MediaType mediaType, boolean withOptionalInnerHits, boolean transportSerialization) {
                        assertNull(newSearchHits.getAt(i).getShard());
            "{\"hits\":{\"total\":{\"value\":1000,\"relation\":\"eq\"},\"max_score\":1.5,"
    }  
            collapseField = randomAlphaOfLengthBetween(5, 10);  
                final SearchShardTarget shardTarget = new SearchShardTarget(
        return createTestItem(randomFrom(XContentType.values()), true, true);  
                } else {
                    instance.getHits(),  
        // because the rest serialization does not render this information so the  
                    instance.getCollapseValues()
            || path.contains("fields")
        long totalHits = TestUtil.nextLong(random(), 0, Long.MAX_VALUE);
                            hits[i].getShard().getShardId().getIndexName(),
    }
        builder.endObject();  
            BytesReference bytes = toShuffledXContent(searchHits, xContentType, ToXContent.EMPTY_PARAMS, false);
            }
        );  
        }
                if (withExplanation) {
        SearchHit[] hits = createSearchHitArray(searchHits, mediaType, withOptionalInnerHits, transportSerialization);
        searchHits.toXContent(builder, ToXContent.EMPTY_PARAMS);
            SearchHits searchHits = new SearchHits(hits, new TotalHits(totalHits, TotalHits.Relation.EQUAL_TO), maxScore);  
    }  
                return new SearchHits(
    @Override  
                if (instance.getSortFields() == null) {  
                return new SearchHits(instance.getHits(), totalHits, instance.getMaxScore());
 * Licensed to Elasticsearch under one or more contributor  
    }  
    }
    }
        for (int i = 0; i < collapseValues.length; i++) {  
import org.apache.lucene.tests.util.TestUtil;  
    }
                    instance.getMaxScore(),
                        assertEquals(hits[i].getShard().getNodeId(), newSearchHits.getAt(i).getShard().getNodeId());
 */  
            || path.contains("_source"));  
                );  
            for (SearchHit hit : hits) {
                            hits[i].getShard().getShardId().getIndex().getUUID(),
    }
    private static SearchHits createTestItem(  
                String collapseField;
import org.opensearch.test.AbstractSerializingTestCase;
            }
    }
 * KIND, either express or implied.  See the License for the
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
/*  
                        // The index uuid is not serialized in the rest layer
    protected SearchHits doParseInstance(XContentParser parser) throws IOException {
            final SearchHit[] hits = new SearchHit[] {
                    new ShardId(new Index(index, randomAlphaOfLengthBetween(5, 10)), randomInt()),  
        boolean withOptionalInnerHits,
    @Override
        TotalHits.Relation totalHitsRelation
    protected String[] getShuffleFieldsExceptions() {
                        );  
                }
                } else {
                            newSearchHits.getAt(i).getShard().getShardId().getIndexName()
                    OriginalIndices.NONE
                    collapseValues = randomBoolean() ? createCollapseValues(instance.getCollapseValues().length + 1) : null;  
    protected Predicate<String> getRandomFieldsExcludeFilter() {
                    }  
                return new SearchHits(instance.getHits(), instance.getTotalHits(), maxScore);  
public class SearchHitsTests extends AbstractSerializingTestCase<SearchHits> {
    ) {
 *
/*  
import org.opensearch.core.index.Index;
    @Override  
        for (boolean withExplanation : new boolean[] { true, false }) {
                if (Float.isNaN(instance.getMaxScore())) {
 * under the License.  
        // in this layer.
                    sortFields = randomBoolean() ? createSortFields(instance.getSortFields().length + 1) : null;  
import java.util.function.Predicate;  
import org.opensearch.common.lucene.LuceneTests;
        }  
            long totalHits = 1000;
    }
        return path -> (path.isEmpty()
        // deserialized hit cannot be equal to the original instance.
                return new SearchHits(
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 * this work for additional information regarding copyright
import org.opensearch.common.xcontent.XContentType;
                );
        return searchHits;
    private static SearchHit[] createSearchHitArray(
                + "{\"_id\":\"id2\",\"_score\":null}]}}",
                return new SearchHits(
        SearchHits searchHits = new SearchHits(hits, new TotalHits(totalHits, TotalHits.Relation.EQUAL_TO), maxScore);
                }
        final MediaType mediaType,
import org.opensearch.core.xcontent.MediaType;
        assertEquals(SearchHits.Fields.HITS, parser.currentName());
                } else {
                );  
                } else {
 * compatible open source license.
    protected Writeable.Reader<SearchHits> instanceReader() {  
                    instance.getMaxScore(),
 * not use this file except in compliance with the License.
import org.apache.lucene.search.TotalHits;
                return new SearchHits(
            XContentType xContentType = randomFrom(XContentType.values());
        XContentBuilder builder = JsonXContent.contentBuilder();  
            // sort fields are simplified before serialization, we write directly the simplified version  
        long totalHits = 1000;  
 */
                new SearchHit(10, "id10", Collections.emptyMap(), Collections.emptyMap()) };
 *    http://www.apache.org/licenses/LICENSE-2.0
            // otherwise equality comparisons become complicated
    }
                new SearchHit(2, "id2", Collections.emptyMap(), Collections.emptyMap()),
import org.opensearch.action.OriginalIndices;
        return new TotalHits(totalHits, relation);
        // There is another test (#testFromXContentWithShards) that checks the
 * You may obtain a copy of the License at  
        }
                        assertNotEquals(  
    @Override
    }
 * software distributed under the License is distributed on an
    @Override  
                    collapseValues = createCollapseValues(randomIntBetween(1, 5));
            case 0:  
package org.opensearch.search;
        Object[] collapseValues = null;  
        Object[] collapseValues = new Object[size];
                }  
        for (int i = 0; i < hits.length; i++) {  
                SortField[] sortFields;
        float maxScore = frequently() ? randomFloat() : Float.NaN;  
        // rest serialization with shard targets.  
            case 4:
        return new String[] { "_source" };
    protected SearchHits mutateInstance(SearchHits instance) {
                    .createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, bytes.streamInput())
 * this file be licensed under the Apache-2.0 license or a
                        );  
            || path.contains("highlight")
            collapseValues[i] = LuceneTests.randomSortValue();
 * ownership. Elasticsearch licenses this file to you under  
        if (transportSerialization) {
                    sortFields,  
    public void testFromXContentWithShards() throws IOException {  
                    } else {
                    clusterAlias,
 * specific language governing permissions and limitations
                );  
                        assertEquals(hits[i].getShard().getShardId().getId(), newSearchHits.getAt(i).getShard().getShardId().getId());
import org.opensearch.core.xcontent.XContentParser;
                }
            new SearchHit(2, "id2", Collections.emptyMap(), Collections.emptyMap()) };
        return SearchHits::new;
                    instance.getTotalHits(),  
        return createTestItem(mediaType, withOptionalInnerHits, transportSerialization, randomFrom(TotalHits.Relation.values()));  
                    totalHits = null;
                            newSearchHits.getAt(i).getShard().getShardId().getIndex().getUUID()
                SearchHits newSearchHits = doParseInstance(parser);
import org.apache.lucene.search.SortField;
                if (instance.getCollapseValues() == null) {  
import org.opensearch.core.xcontent.ToXContent;
                final TotalHits totalHits;
                }
        return collapseValues;  
    }
    }
        SortField[] sortFields = new SortField[size];
                    hit.explanation(SearchHitTests.createExplanation(randomIntBetween(0, 5)));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());  
        // This instance is used to test the transport serialization so it's fine  
        final MediaType mediaType,
    protected SearchHits createXContextTestInstance(final MediaType mediaType) {
            default:
            new SearchHit(1, "id1", Collections.emptyMap(), Collections.emptyMap()),  
                } else {  
 * SPDX-License-Identifier: Apache-2.0
                + "\"hits\":[{\"_id\":\"id1\",\"_score\":null},"  
                assertEquals(3, newSearchHits.getHits().length);
                    instance.getCollapseValues()
                XContentParser parser = xContentType.xContent()
        }
        builder.startObject();
    private static TotalHits randomTotalHits(TotalHits.Relation relation) {  
 *  
        boolean transportSerialization  
            float maxScore = 1.5f;
                    instance.getCollapseField(),
        SortField[] sortFields = null;
                    instance.getTotalHits(),
        float maxScore = 1.5f;
        String collapseField = null;
                    collapseField = randomAlphaOfLengthBetween(5, 10);
        }
                    collapseValues
        int size,  
import org.opensearch.core.common.io.stream.Writeable;
}  
    protected SearchHits createTestInstance() {
            case 2:
        TotalHits totalHits = frequently() ? randomTotalHits(totalHitsRelation) : null;
                    instance.getMaxScore()
 * the Apache License, Version 2.0 (the "License"); you may
    public static SearchHits createTestItem(boolean withOptionalInnerHits, boolean withShardTarget) {
import org.opensearch.core.index.shard.ShardId;  
        // to produce shard targets (withShardTarget is true) since they are serialized
import org.opensearch.common.xcontent.LoggingDeprecationHandler;  
            sortFields = randomBoolean() ? createSortFields(randomIntBetween(1, 5)) : null;
                if (instance.getCollapseField() == null) {  
        for (int i = 0; i < sortFields.length; i++) {
                hit.shard(shardTarget);
                throw new UnsupportedOperationException();
                    instance.getHits(),  
    }
                final float maxScore;  
            ) {  
                String index = randomAlphaOfLengthBetween(5, 10);
                        assertEquals(  
                    totalHits = randomTotalHits(randomFrom(TotalHits.Relation.values()));  
            || path.contains("inner_hits")  
                if (instance.getTotalHits() == null) {
                    instance.getSortFields(),  
                    instance.getCollapseField(),
            case 3:
        return createTestItem(mediaType, true, false);
                for (int i = 0; i < hits.length; i++) {
                    if (withExplanation) {  
                }
 * Unless required by applicable law or agreed to in writing,
                    instance.getTotalHits(),
            try (  
import org.opensearch.common.xcontent.json.JsonXContent;
            collapseValues = randomBoolean() ? createCollapseValues(randomIntBetween(1, 10)) : null;
                String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);  
        // We don't set SearchHit#shard (withShardTarget is false) in this test
            hits[i] = SearchHitTests.createTestItem(mediaType, withOptionalInnerHits, transportSerialization);
        return createTestItem(randomFrom(XContentType.values()), withOptionalInnerHits, withShardTarget);
/*
import org.opensearch.core.common.bytes.BytesReference;  
                        assertEquals(hits[i].getShard().getIndex(), newSearchHits.getAt(i).getShard().getIndex());
            case 5:
                }  
import java.io.IOException;
        int searchHits = randomIntBetween(0, 5);  
                    instance.getMaxScore(),
                    maxScore = randomFloat();
                    instance.getHits(),  
                    instance.getTotalHits(),
        return hits;  
        boolean transportSerialization,  
                    createSearchHitArray(instance.getHits().length + 1, randomFrom(XContentType.values()), false, randomBoolean()),
        boolean withOptionalInnerHits,
                    sortFields = createSortFields(randomIntBetween(1, 5));
        SearchHits searchHits = SearchHits.fromXContent(parser);
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());  
 *
 * The OpenSearch Contributors require contributions made to  
            builder.toString()
        SearchHit[] hits = new SearchHit[] {
            sortFields[i] = LuceneTests.randomSortField().v2();
                );  
                    collapseField,
                    assertEquals(hits[i].getExplanation(), newSearchHits.getAt(i).getExplanation());
        assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
            case 1:  
                    randomAlphaOfLengthBetween(5, 10),
import java.util.Collections;
        assertEquals(
 * license agreements. See the NOTICE file distributed with
