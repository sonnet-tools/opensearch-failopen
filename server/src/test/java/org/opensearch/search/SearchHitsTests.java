        searchHits.toXContent(builder, ToXContent.EMPTY_PARAMS);
 * not use this file except in compliance with the License.
                hit.shard(shardTarget);
    @Override
                    instance.getCollapseField(),
        String collapseField = null;
        // deserialized hit cannot be equal to the original instance.
import org.opensearch.action.OriginalIndices;
                    instance.getTotalHits(),
                        );
    }
package org.opensearch.search;
            // sort fields are simplified before serialization, we write directly the simplified version
                }
        switch (randomIntBetween(0, 5)) {
                } else {
        SearchHit[] hits = createSearchHitArray(searchHits, mediaType, withOptionalInnerHits, transportSerialization);
                        // The index uuid is not serialized in the rest layer
                    totalHits = null;
                + "{\"_id\":\"id2\",\"_score\":null}]}}",
    public void testFromXContentWithShards() throws IOException {
            final SearchHit[] hits = new SearchHit[] {
                final float maxScore;
        return createTestItem(mediaType, withOptionalInnerHits, transportSerialization, randomFrom(TotalHits.Relation.values()));
    protected String[] getShuffleFieldsExceptions() {
        for (int i = 0; i < hits.length; i++) {
                if (instance.getCollapseField() == null) {
            case 3:
                if (Float.isNaN(instance.getMaxScore())) {
        TotalHits.Relation totalHitsRelation
                String clusterAlias = randomBoolean() ? null : randomAlphaOfLengthBetween(5, 10);
                new SearchHit(10, "id10", Collections.emptyMap(), Collections.emptyMap()) };
    }
        Object[] collapseValues = null;
                XContentParser parser = xContentType.xContent()
    public static SearchHits createTestItem(final MediaType mediaType, boolean withOptionalInnerHits, boolean transportSerialization) {
        SortField[] sortFields = null;
                } else {
                );
 * compatible open source license.
            hits[i] = SearchHitTests.createTestItem(mediaType, withOptionalInnerHits, transportSerialization);
    }
                SortField[] sortFields;
                    totalHits = randomTotalHits(randomFrom(TotalHits.Relation.values()));
                    .createParser(xContentRegistry(), LoggingDeprecationHandler.INSTANCE, bytes.streamInput())
                    randomAlphaOfLengthBetween(5, 10),
                );
    }
 */
 */
import org.opensearch.core.index.Index;
            sortFields[i] = LuceneTests.randomSortField().v2();
            float maxScore = 1.5f;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        return collapseValues;
    }
import org.opensearch.common.xcontent.XContentType;
 * this file be licensed under the Apache-2.0 license or a
                            hits[i].getShard().getShardId().getIndexName(),
        // in this layer.
            collapseField = randomAlphaOfLengthBetween(5, 10);
        // to produce shard targets (withShardTarget is true) since they are serialized
                    maxScore = randomFloat();
                }
    public static SearchHits createTestItem(boolean withOptionalInnerHits, boolean withShardTarget) {
import java.io.IOException;
            collapseValues = randomBoolean() ? createCollapseValues(randomIntBetween(1, 10)) : null;
                    instance.getMaxScore(),
            default:
                    collapseValues = createCollapseValues(randomIntBetween(1, 5));
    }
        builder.endObject();
                    collapseField = randomBoolean() ? instance.getCollapseField() + randomAlphaOfLengthBetween(2, 5) : null;
    private static SearchHits createTestItem(
        TotalHits totalHits = frequently() ? randomTotalHits(totalHitsRelation) : null;
        // because the rest serialization does not render this information so the
 * under the License.
                );
        if (transportSerialization) {
                    instance.getCollapseField(),
import org.opensearch.core.xcontent.MediaType;
                    instance.getTotalHits(),
            BytesReference bytes = toShuffledXContent(searchHits, xContentType, ToXContent.EMPTY_PARAMS, false);
    }
        // rest serialization with shard targets.
        return createTestItem(mediaType, true, false);
import org.opensearch.test.AbstractSerializingTestCase;
                        assertEquals(hits[i].getShard().getShardId().getId(), newSearchHits.getAt(i).getShard().getShardId().getId());
                }
 * GitHub history for details.
    }
        // This instance is used to test the transport serialization so it's fine
        );
        }
        boolean withOptionalInnerHits,
                }
                );
        SortField[] sortFields = new SortField[size];
                    sortFields = createSortFields(randomIntBetween(1, 5));
                return new SearchHits(
            case 4:
        boolean transportSerialization,
                    instance.getHits(),
                    } else {
    @Override
    protected SearchHits doParseInstance(XContentParser parser) throws IOException {
                Object[] collapseValues;
                    instance.getCollapseValues()
 * Unless required by applicable law or agreed to in writing,
                        assertEquals(hits[i].getShard().getNodeId(), newSearchHits.getAt(i).getShard().getNodeId());
            // otherwise equality comparisons become complicated
                    }
        XContentBuilder builder = JsonXContent.contentBuilder();
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
                            newSearchHits.getAt(i).getShard().getShardId().getIndex().getUUID()
 * Modifications Copyright OpenSearch Contributors. See
        assertEquals(XContentParser.Token.START_OBJECT, parser.nextToken());
        return createTestItem(randomFrom(XContentType.values()), true, true);
                throw new UnsupportedOperationException();
                    if (withExplanation) {
    }
                    collapseValues = randomBoolean() ? createCollapseValues(instance.getCollapseValues().length + 1) : null;
                if (instance.getSortFields() == null) {
    private static TotalHits randomTotalHits(TotalHits.Relation relation) {
                new SearchHit(2, "id2", Collections.emptyMap(), Collections.emptyMap()),
            SearchHits searchHits = new SearchHits(hits, new TotalHits(totalHits, TotalHits.Relation.EQUAL_TO), maxScore);
                    instance.getCollapseValues()
        return new SearchHits(hits, totalHits, maxScore, sortFields, collapseField, collapseValues);
import org.apache.lucene.search.TotalHits;
import org.apache.lucene.search.SortField;
 * You may obtain a copy of the License at
 * the Apache License, Version 2.0 (the "License"); you may
        SearchHits searchHits = SearchHits.fromXContent(parser);
                } else {
        return hits;
            || path.contains("inner_hits")
            XContentType xContentType = randomFrom(XContentType.values());
                String collapseField;
 */
                    instance.getTotalHits(),
    }
    }
                } else {
/*
import java.util.function.Predicate;
import org.opensearch.core.common.bytes.BytesReference;
/*
                    new ShardId(new Index(index, randomAlphaOfLengthBetween(5, 10)), randomInt()),
            "{\"hits\":{\"total\":{\"value\":1000,\"relation\":\"eq\"},\"max_score\":1.5,"
                    collapseField,
 *
                    hit.explanation(SearchHitTests.createExplanation(randomIntBetween(0, 5)));
    }
                            newSearchHits.getAt(i).getShard().getShardId().getIndexName()
        long totalHits = TestUtil.nextLong(random(), 0, Long.MAX_VALUE);
        return sortFields;
    @Override
        }
            collapseValues[i] = LuceneTests.randomSortValue();
        int searchHits = randomIntBetween(0, 5);
import org.opensearch.core.xcontent.XContentParser;
                final TotalHits totalHits;
        boolean withOptionalInnerHits,
                    instance.getSortFields(),
    protected SearchHits createTestInstance() {
                if (instance.getTotalHits() == null) {
import org.opensearch.common.xcontent.LoggingDeprecationHandler;
    protected Writeable.Reader<SearchHits> instanceReader() {
import org.opensearch.core.common.io.stream.Writeable;
                    instance.getMaxScore(),
        final MediaType mediaType,
 * this work for additional information regarding copyright
        float maxScore = frequently() ? randomFloat() : Float.NaN;
                }
        assertEquals(XContentParser.Token.END_OBJECT, parser.currentToken());
            case 1:
 * license agreements. See the NOTICE file distributed with
                return new SearchHits(
        Object[] collapseValues = new Object[size];
                if (withExplanation) {
    }
            case 2:
        assertEquals(SearchHits.Fields.HITS, parser.currentName());
                return new SearchHits(instance.getHits(), totalHits, instance.getMaxScore());
    }
    ) {
                    assertEquals(hits[i].getExplanation(), newSearchHits.getAt(i).getExplanation());
        }
import org.opensearch.common.xcontent.json.JsonXContent;
        return searchHits;
            || path.contains("_source"));
}
        boolean transportSerialization
        return new TotalHits(totalHits, relation);
                return new SearchHits(instance.getHits(), instance.getTotalHits(), maxScore);
                + "\"hits\":[{\"_id\":\"id1\",\"_score\":null},"
                new SearchHit(1, "id1", Collections.emptyMap(), Collections.emptyMap()),
    protected SearchHits createXContextTestInstance(final MediaType mediaType) {
        SearchHit[] hits = new SearchHit[size];
    @Override
                }
        return createTestItem(randomFrom(XContentType.values()), withOptionalInnerHits, withShardTarget);
    @Override
                        assertEquals(hits[i].getShard().getIndex(), newSearchHits.getAt(i).getShard().getIndex());
    protected Predicate<String> getRandomFieldsExcludeFilter() {
public class SearchHitsTests extends AbstractSerializingTestCase<SearchHits> {
import org.opensearch.common.lucene.LuceneTests;
 * specific language governing permissions and limitations
    private static Object[] createCollapseValues(int size) {
 *
 * The OpenSearch Contributors require contributions made to
            ) {
                final SearchShardTarget shardTarget = new SearchShardTarget(
                    instance.getSortFields(),
                return new SearchHits(
        }
        float maxScore = 1.5f;
            try (
                    sortFields,
                    instance.getTotalHits(),
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.index.shard.ShardId;
    private static SortField[] createSortFields(int size) {
            }
                        assertNull(newSearchHits.getAt(i).getShard());
/*
            sortFields = randomBoolean() ? createSortFields(randomIntBetween(1, 5)) : null;
import org.apache.lucene.tests.util.TestUtil;
    }
            || path.contains("highlight")
    ) {
                    sortFields = randomBoolean() ? createSortFields(instance.getSortFields().length + 1) : null;
        long totalHits = 1000;
                    clusterAlias,
        int size,
                assertEquals("id1", newSearchHits.getAt(0).getId());
                return new SearchHits(
                if (instance.getCollapseValues() == null) {
    }
                    OriginalIndices.NONE
                    instance.getHits(),
            builder.toString()
        builder.startObject();
        return path -> (path.isEmpty()
            }
                            hits[i].getShard().getShardId().getIndex().getUUID(),
                SearchHits newSearchHits = doParseInstance(parser);
                    maxScore = Float.NaN;
                assertEquals(3, newSearchHits.getHits().length);
        // There is another test (#testFromXContentWithShards) that checks the
        return new String[] { "_source" };
            new SearchHit(1, "id1", Collections.emptyMap(), Collections.emptyMap()),
                        );
        SearchHit[] hits = new SearchHit[] {
        assertEquals(XContentParser.Token.FIELD_NAME, parser.nextToken());
 *
                        assertEquals(
        final MediaType mediaType,
import org.opensearch.core.xcontent.ToXContent;
            long totalHits = 1000;
 *    http://www.apache.org/licenses/LICENSE-2.0
                } else {
                        assertNotEquals(
import org.opensearch.core.xcontent.XContentBuilder;
                    instance.getMaxScore(),
        return SearchHits::new;
            || path.contains("fields")
            case 5:
        // We don't set SearchHit#shard (withShardTarget is false) in this test
    @Override
                    collapseValues
        }
        for (int i = 0; i < collapseValues.length; i++) {
    private static SearchHit[] createSearchHitArray(
                    instance.getHits(),
        SearchHits searchHits = new SearchHits(hits, new TotalHits(totalHits, TotalHits.Relation.EQUAL_TO), maxScore);
            for (SearchHit hit : hits) {
import java.util.Collections;
                    instance.getMaxScore()
            case 0:
                    createSearchHitArray(instance.getHits().length + 1, randomFrom(XContentType.values()), false, randomBoolean()),
                }
                    collapseField = randomAlphaOfLengthBetween(5, 10);
        for (boolean withExplanation : new boolean[] { true, false }) {
    public void testToXContent() throws IOException {
 * KIND, either express or implied.  See the License for the
    protected SearchHits mutateInstance(SearchHits instance) {
        assertEquals(
 * software distributed under the License is distributed on an
 * Licensed to Elasticsearch under one or more contributor
        for (int i = 0; i < sortFields.length; i++) {
            new SearchHit(2, "id2", Collections.emptyMap(), Collections.emptyMap()) };
    @Override
                String index = randomAlphaOfLengthBetween(5, 10);
        assertEquals(XContentParser.Token.END_OBJECT, parser.nextToken());
 * ownership. Elasticsearch licenses this file to you under
        }
                for (int i = 0; i < hits.length; i++) {
                );
