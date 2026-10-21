import org.apache.lucene.search.TopFieldDocs;
            default:
import org.opensearch.common.document.DocumentField;
                t -> t == SortField.Type.CUSTOM || t == SortField.Type.REWRITEABLE,
import org.apache.lucene.search.FieldDoc;
import org.opensearch.test.OpenSearchTestCase;
    }
import org.opensearch.test.InternalAggregationTestCase;
import java.util.Comparator;
            }
                } else {
        Comparator<ScoreDoc> dataNodeComparator;
    }
        for (int i = 0; i < actualSize; i++) {
        for (int i = 0; i < sortFields.length; i++) {
        Comparator<ScoreDoc> reducedComparator = dataNodeComparator.thenComparing(s -> s.shardIndex);
        allHits.sort(comparing(Tuple::v1, reducedComparator));
        return comparator.reversed();
        Set<Float> usedScores = new HashSet<>();
    }
            String sortField = randomValueOtherThanMany(usedSortFields::contains, () -> randomAlphaOfLength(5));
                return randomLong();
 * ownership. Elasticsearch licenses this file to you under
    protected void assertReduced(InternalTopHits reduced, List<InternalTopHits> inputs) {
                return new BytesRef(randomAlphaOfLength(5));
            case INT:
                    metadata = new HashMap<>(instance.getMetadata());
            for (int f = 0; f < sortFields.length; f++) {
            Object[] fields = new Object[sortFields.length];
                topDocs = new TopDocsAndMaxScore(
            actual.toXContent(actualJson, ToXContent.EMPTY_PARAMS);
            assertEquals(expected.getScore(), actual.getScore(), 0.0f);
import java.util.HashSet;
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
    @Override
 * SPDX-License-Identifier: Apache-2.0
    private Comparator<ScoreDoc> scoreComparator() {
     */
        TopDocs topDocs = topDocsBuilder.apply(new TotalHits(totalHits, TotalHits.Relation.EQUAL_TO), scoreDocs);
 * under the License.
        Map<String, Object> metadata,
                    doc = new FieldDoc(doc.doc, doc.score, ((FieldDoc) doc).fields, input);
            dataNodeComparator = scoreComparator();
        long totalHits = 0;
 * not use this file except in compliance with the License.
import static java.util.Comparator.comparing;
    protected InternalTopHits createTestInstance(String name, Map<String, Object> metadata) {
            case STRING:
        }
                    doc = new ScoreDoc(doc.doc, doc.score, input);
            totalHits += internalHits.getTotalHits().value();
        Map<String, Object> metadata,
        }
                name += randomAlphaOfLength(5);
            expectedJson.endObject();
            for (int i = 0; i < internalHits.getHits().length; i++) {
        Supplier<Float> scoreSupplier
        List<SearchHit> actualHits = Arrays.asList(actualSearchHits.getHits());
import java.util.function.BiFunction;
        List<Tuple<SearchHit, ScoreDoc>> hitScores = new ArrayList<>();
            case REWRITEABLE:
                if (metadata == null) {
        Supplier<Float> scoreSupplier,
import org.opensearch.common.xcontent.json.JsonXContent;
        for (int i = 0; i < expectedHits.size(); i++) {
        assertEquals(expectedSearchHits.getMaxScore(), actualSearchHits.getMaxScore(), 0.0f);
    @Override
        ParsedTopHits parsed = (ParsedTopHits) parsedAggregation;
        float maxScore = Float.NEGATIVE_INFINITY;
            Function<SortField.Type, Object> sortFieldValueSuppier = t -> {
import java.util.Collections;
                ScoreDoc doc = inputs.get(input).getTopDocs().topDocs.scoreDocs[i];
            scoreDocs[i] = docBuilder.apply(docId, score);
            return 0;
    protected InternalTopHits mutateInstance(InternalTopHits instance) {
                usedSortFieldValues.add(value);
        }
import java.io.IOException;
    private static <T extends ToXContent> void assertEqualsWithErrorMessageFromXContent(T expected, T actual) {
        ScoreDoc[] scoreDocs = new ScoreDoc[actualSize];
 * GitHub history for details.
        TopDocsAndMaxScore topDocsAndMaxScore = new TopDocsAndMaxScore(topDocs, maxScore == Float.NEGATIVE_INFINITY ? Float.NaN : maxScore);
    ) {
        }
        TopDocsAndMaxScore topDocs = instance.getTopDocs();
                size += between(1, 100);
 * the Apache License, Version 2.0 (the "License"); you may
package org.opensearch.search.aggregations.metrics;
 * Modifications Copyright OpenSearch Contributors. See
                metadata.put(randomAlphaOfLength(15), randomInt());
            hitScores.add(new Tuple<>(searchHits[i], scoreDocs[i]));
        SortField[] sortFields,
 * KIND, either express or implied.  See the License for the
        SearchHits actualHits = reduced.getHits();
    }
        int requestedSize,
import org.opensearch.test.NotEqualMessageBuilder;
        } catch (IOException e) {
        }
        String name,
import java.util.stream.Stream;
import org.opensearch.common.xcontent.XContentHelper;
                break;
            scoreDocs[i] = hitScores.get(i).v2();
 * You may obtain a copy of the License at
        }
            new TotalHits(totalHits, relation),
            );
                return randomFloat();
import org.apache.lucene.search.Pruning;
        return (lhs, rhs) -> {
                name,
            SortField[] sortFields = randomSortFields();
                XContentHelper.convertToMap(BytesReference.bytes(actualJson), false).v2(),
        for (int i = 0; i < expectedHitsHits.length; i++) {
        FieldComparator[] comparators = new FieldComparator[sortFields.length];
import org.opensearch.core.xcontent.XContentBuilder;
        switch (between(0, 5)) {
        int requestedSize,
            return;
public class InternalTopHitsTests extends InternalAggregationTestCase<InternalTopHits> {
                    searchHits.getTotalHits().value() + between(1, 100),
            case 5:
    }
                    ),
            FieldDoc r = (FieldDoc) rhs;
        if (Objects.equals(expected, actual)) {
                throw new UnsupportedOperationException();
        assertEquals(expectedHits.size(), actualHits.size());
            if (internalHits.getTotalHits().relation() == TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO) {
import org.apache.lucene.search.TopDocs;
        Comparator<ScoreDoc> comparator = comparing(d -> d.score);
import org.apache.lucene.search.TotalHits;
            Set<Object> usedSortFieldValues = new HashSet<>();
import org.opensearch.common.collect.Tuple;
                        topDocs.topDocs.scoreDocs
     * Sorts both searchHits and scoreDocs together based on scoreDocComparator()
            );
    private SortField[] randomSortFields() {
    }
                return new BytesRef(randomAlphaOfLength(5));
            float score = randomValueOtherThanMany(usedScores::contains, OpenSearchTestCase::randomFloat);
            maxScore == Float.NEGATIVE_INFINITY ? Float.NaN : maxScore
            assertEquals(expected.getVersion(), actual.getVersion());
        // Lucene's TopDocs initializes the maxScore to Float.NaN, if there is no maxScore
    ) {
        String name,
                return value;
        int totalHits = between(actualSize, 500000);
            expectedHitsHits,
                Object value = randomValueOtherThanMany(usedSortFieldValues::contains, () -> randomOfType(t));
        }
            maxScore = max(maxScore, internalHits.getMaxScore());
            comparators[i] = sortFields[i].getComparator(0, Pruning.NONE);
        if (expected == null) {
            maxScore = max(maxScore, score);
 *
    }
        @SuppressWarnings("rawtypes")
                relation = TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;
import static java.lang.Math.max;
        };
 */
import static java.lang.Math.min;
                return randomInt();
        assertEquals(expectedSearchHits.getTotalHits().value(), actualSearchHits.getTotalHits().value());
        List<Tuple<ScoreDoc, SearchHit>> allHits = new ArrayList<>();
        }
 *
                return between(0, IndexWriter.MAX_DOCS);
                from += between(1, 100);
     * differences if they aren't equal.
                int c = comparators[i].compareValues(l.fields[i], r.fields[i]);
            actualJson.startObject();
        }
                    topDocs.maxScore + randomFloat()
        return createTestInstance(name, metadata, scoreSupplier, requestedSize, ScoreDoc::new, TopDocs::new, scoreComparator());
import org.apache.lucene.util.BytesRef;
     */
            expected.toXContent(expectedJson, ToXContent.EMPTY_PARAMS);
            throw new AssertionError("IOException while building failure message", e);
            assertEquals(expected.getId(), actual.getId());
            case FLOAT:
            int i = 0;
        }
    private static Object randomOfType(SortField.Type type) {
 * The OpenSearch Contributors require contributions made to
            return new FieldDoc(docId, score, fields);
import java.util.ArrayList;
        for (int i = 0; i < sortFields.length; i++) {
            default:
     * Assert that two objects are equals, calling {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)} to print out their
    private InternalTopHits createTestInstanceSortedScore(
        hitScores.sort((t1, t2) -> comparator.compare(t1.v2(), t2.v2()));
        int size = instance.getSize();
            Map<String, DocumentField> searchHitFields = new HashMap<>();
        }
        }, (totalHits, scoreDocs) -> new TopFieldDocs(totalHits, scoreDocs, sortFields), sortFieldsComparator(sortFields));
        sort(hits, scoreDocs, comparator);
import org.opensearch.search.SearchHit;
/*
import org.apache.lucene.search.FieldComparator;
        SearchHits expectedHits = new SearchHits(
    /**
                return randomFloat();
            FieldDoc l = (FieldDoc) lhs;
 *
/*
        Supplier<InternalTopHits> supplier;
import java.util.List;
            hits[i] = new SearchHit(docId, Integer.toString(i), searchHitFields, Collections.emptyMap());
                TotalHits totalHits = new TotalHits(
        final SearchHits expectedSearchHits = aggregation.getHits();
        float maxScore = Float.NEGATIVE_INFINITY;
                () -> randomFrom(SortField.Type.values())
    }
            throw new AssertionError("Didn't expect null but actual was [null]");
            usedDocIds.add(docId);
            supplier = () -> createTestInstanceSortedByFields(name, requestedSize, null, scoreSupplier, sortFields, sortFieldValueSuppier);
            }
            case 0:
            dataNodeComparator = sortFieldsComparator(((TopFieldDocs) inputs.get(0).getTopDocs().topDocs).fields);
                break;
            actualJson.endObject();
        }
                break;
import org.opensearch.core.xcontent.ToXContent;
        List<SearchHit> expectedHits = Arrays.asList(expectedSearchHits.getHits());
                fields[f] = sortFieldValueSupplier.apply(sortFields[ff].getType());
        Map<String, Object> metadata = instance.getMetadata();
import static java.util.stream.Collectors.toList;
        );
 * this work for additional information regarding copyright
                    metadata = new HashMap<>(1);
        assertTrue(parsedAggregation instanceof ParsedTopHits);
            case LONG:
            NotEqualMessageBuilder message = new NotEqualMessageBuilder();
            supplier = () -> createTestInstanceSortedScore(name, requestedSize, null, scoreSupplier);
    @Override
        Supplier<Float> scoreSupplier = () -> {
         * deterministic test results.
            );
                );
        assertEquals(expectedSearchHits.getTotalHits().relation(), actualSearchHits.getTotalHits().relation());
                OpenSearchTestCase::randomFloat,
            float score = scoreSupplier.get();
 * this file be licensed under the Apache-2.0 license or a
                between(1, 40),
            SearchHits internalHits = inputs.get(input).getHits();
        };
        SearchHits searchHits = instance.getHits();
            searchHits[i] = hitScores.get(i).v1();
            case 3:
                XContentHelper.convertToMap(BytesReference.bytes(expectedJson), false).v2()
                throw new UnsupportedOperationException();
        return sortFields;
    }
            hits[i].score(score);
        } else {
        switch (type) {
            return createTestInstanceSortedByFields(
 */
    }
    protected void assertFromXContent(InternalTopHits aggregation, ParsedAggregation parsedAggregation) throws IOException {
        SearchHit[] hits = new SearchHit[actualSize];
    protected List<InternalTopHits> randomResultsToReduce(String name, int size) {
        TotalHits.Relation relation = TotalHits.Relation.EQUAL_TO;
                break;
        SearchHit[] expectedHitsHits = new SearchHit[min(inputs.get(0).getSize(), allHits.size())];
                throw new AssertionError("Illegal randomisation branch");
    @Override
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            throw new AssertionError("Expected null be actual was [" + actual.toString() + "]");
            throw new AssertionError("Didn't match expected value:\n" + message);
import java.util.function.Function;
                @SuppressWarnings("unchecked")
                searchHits = new SearchHits(searchHits.getHits(), totalHits, searchHits.getMaxScore() + randomFloat());
        if (sortedByFields) {
            SearchHit expected = expectedHits.get(i);
import org.apache.lucene.index.IndexWriter;
import org.opensearch.core.common.bytes.BytesReference;
            case SCORE:
import org.opensearch.search.aggregations.ParsedAggregation;
import org.apache.lucene.search.SortField;
            expectedJson.startObject();
            assertEquals(expected.getFields(), actual.getFields());
        if (randomBoolean()) {
        return new InternalTopHits(name, from, size, topDocs, searchHits, metadata);
        BiFunction<TotalHits, ScoreDoc[], TopDocs> topDocsBuilder,
            assertEquals(expected.getIndex(), actual.getIndex());
    private Comparator<ScoreDoc> sortFieldsComparator(SortField[] sortFields) {
import java.util.Arrays;
 * compatible open source license.
                    return c;
        BiFunction<Integer, Float, ScoreDoc> docBuilder,
        Comparator<ScoreDoc> comparator
            case STRING_VAL:
        }
            case DOC:
                }
                }
            message.compareMaps(
                break;
    /**
        String name = instance.getName();
        }
        if (randomBoolean()) {
        } else {
        int actualSize = between(0, requestedSize);
import java.util.function.Supplier;
        boolean sortedByFields = inputs.get(0).getTopDocs().topDocs instanceof TopFieldDocs;
        return createTestInstanceSortedScore(name, between(1, 40), metadata, OpenSearchTestCase::randomFloat);
import java.util.Set;
        for (int i = 0; i < searchHits.length; i++) {
        Function<SortField.Type, Object> sortFieldValueSupplier
                InternalTopHitsTests::randomOfType
        if (actual == null) {
    }
            SortField.Type type = randomValueOtherThanMany(
        Set<String> usedSortFields = new HashSet<>();
    }
    private InternalTopHits createTestInstanceSortedByFields(
        }
         * Make sure all scores are unique so we can get
        assertEqualsWithErrorMessageFromXContent(expectedHits, actualHits);
        SearchHits searchHits = new SearchHits(hits, new TotalHits(totalHits, TotalHits.Relation.EQUAL_TO), maxScore);
import java.util.Objects;
                }
        String name,
                final int ff = f;
                break;
            case 2:
    private InternalTopHits createTestInstance(
            }
                return randomDouble();
                        new TotalHits(topDocs.topDocs.totalHits.value() + between(1, 100), topDocs.topDocs.totalHits.relation()),
            SearchHit actual = actualHits.get(i);
            };
        return createTestInstance(name, metadata, scoreSupplier, requestedSize, (docId, score) -> {
                if (sortedByFields) {
import java.util.HashMap;
    }
            usedSortFields.add(sortField);
            int docId = randomValueOtherThanMany(usedDocIds::contains, () -> between(0, IndexWriter.MAX_DOCS));
        int requestedSize = between(1, 40);
                    randomFrom(TotalHits.Relation.values())
            }
}
            case DOUBLE:
    @Override
            while (i < l.fields.length) {
        for (int i = 0; i < searchHits.length; i++) {
                    new TopDocs(
            case 4:
        try (XContentBuilder actualJson = JsonXContent.contentBuilder(); XContentBuilder expectedJson = JsonXContent.contentBuilder()) {
            return score;
        // Lucene's TopDocs initializes the maxScore to Float.NaN, if there is no maxScore
        SortField[] sortFields = new SortField[between(1, 5)];
import org.opensearch.search.SearchHits;
         */
        Map<String, Object> metadata,
 * Licensed to Elasticsearch under one or more contributor
 */
        Supplier<Float> scoreSupplier,
            assertEquals(expected.getSourceAsMap(), actual.getSourceAsMap());
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
                allHits.add(new Tuple<>(doc, internalHits.getHits()[i]));
 * Unless required by applicable law or agreed to in writing,
        return new InternalTopHits(name, from, requestedSize, topDocsAndMaxScore, searchHits, metadata);
            usedScores.add(score);
/*
            // Values passed to getComparator shouldn't matter
            sortFields[i] = new SortField(sortField, type);
                metadata,
                );
        int from = 0;
            expectedHitsHits[i] = allHits.get(i).v2();
        final SearchHits actualSearchHits = parsed.getHits();
    ) {
    private void sort(SearchHit[] searchHits, ScoreDoc[] scoreDocs, Comparator<ScoreDoc> comparator) {
        int from = instance.getFrom();
        }
        /*
                throw new UnsupportedOperationException("Unknown SortField.Type: " + type);
        Set<Integer> usedDocIds = new HashSet<>();
                i++;
            case 1:
import org.apache.lucene.search.ScoreDoc;
                randomSortFields(),
            case CUSTOM:
import java.util.Map;
                if (c != 0) {
        for (int input = 0; input < inputs.size(); input++) {
    }
 * specific language governing permissions and limitations
                } else {
        return Stream.generate(supplier).limit(size).collect(toList());
        int requestedSize,
 * license agreements. See the NOTICE file distributed with
