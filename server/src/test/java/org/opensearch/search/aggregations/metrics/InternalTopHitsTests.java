        if (expected == null) {  
        return new InternalTopHits(name, from, requestedSize, topDocsAndMaxScore, searchHits, metadata);
            return 0;
    protected void assertFromXContent(InternalTopHits aggregation, ParsedAggregation parsedAggregation) throws IOException {
            usedScores.add(score);  
            for (int i = 0; i < internalHits.getHits().length; i++) {
        if (Objects.equals(expected, actual)) {  
 * Modifications Copyright OpenSearch Contributors. See
        for (int i = 0; i < expectedHitsHits.length; i++) {
    private static Object randomOfType(SortField.Type type) {  
                    return c;  
        switch (between(0, 5)) {  
                }
    protected List<InternalTopHits> randomResultsToReduce(String name, int size) {
        Comparator<ScoreDoc> comparator  
            maxScore = max(maxScore, internalHits.getMaxScore());  
        }
import static java.util.stream.Collectors.toList;  
                throw new UnsupportedOperationException();  
                searchHits = new SearchHits(searchHits.getHits(), totalHits, searchHits.getMaxScore() + randomFloat());  
            searchHits[i] = hitScores.get(i).v1();
        Map<String, Object> metadata,
        Map<String, Object> metadata = instance.getMetadata();
    /**
                XContentHelper.convertToMap(BytesReference.bytes(actualJson), false).v2(),  
        }
        }  
        if (randomBoolean()) {
            case CUSTOM:
            case DOUBLE:  
        );  
                    ),  
                if (metadata == null) {  
 *    http://www.apache.org/licenses/LICENSE-2.0
            throw new AssertionError("Didn't match expected value:\n" + message);  
    @Override  
        long totalHits = 0;
            throw new AssertionError("Expected null be actual was [" + actual.toString() + "]");
 */  
        } catch (IOException e) {
        Comparator<ScoreDoc> comparator = comparing(d -> d.score);  
            float score = scoreSupplier.get();
            case SCORE:
            message.compareMaps(
                break;  
        Supplier<Float> scoreSupplier,  
            FieldDoc r = (FieldDoc) rhs;  
    ) {  
        for (int i = 0; i < expectedHits.size(); i++) {
            usedSortFields.add(sortField);
                        new TotalHits(topDocs.topDocs.totalHits.value() + between(1, 100), topDocs.topDocs.totalHits.relation()),
import org.opensearch.common.document.DocumentField;  
            throw new AssertionError("IOException while building failure message", e);
        String name,  
            }  
    }
            );
        return comparator.reversed();
        int from = instance.getFrom();
                    doc = new ScoreDoc(doc.doc, doc.score, input);  
            FieldDoc l = (FieldDoc) lhs;
 * license agreements. See the NOTICE file distributed with
                i++;
        TopDocs topDocs = topDocsBuilder.apply(new TotalHits(totalHits, TotalHits.Relation.EQUAL_TO), scoreDocs);  
                OpenSearchTestCase::randomFloat,
            while (i < l.fields.length) {
                Object value = randomValueOtherThanMany(usedSortFieldValues::contains, () -> randomOfType(t));  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.HashMap;
        Supplier<Float> scoreSupplier,
            int i = 0;
                XContentHelper.convertToMap(BytesReference.bytes(expectedJson), false).v2()
            case STRING:  
                break;  
            maxScore = max(maxScore, score);
            float score = randomValueOtherThanMany(usedScores::contains, OpenSearchTestCase::randomFloat);
                name,
        String name = instance.getName();  
                throw new UnsupportedOperationException();  
                break;  
                if (sortedByFields) {  
        List<SearchHit> expectedHits = Arrays.asList(expectedSearchHits.getHits());
import java.util.Arrays;
 *
        /*
                );
            case 4:
        SearchHits searchHits = instance.getHits();
            case 1:
                randomSortFields(),
        Comparator<ScoreDoc> dataNodeComparator;  
            comparators[i] = sortFields[i].getComparator(0, Pruning.NONE);
        }
        int size = instance.getSize();
            case FLOAT:
import org.opensearch.common.xcontent.json.JsonXContent;  
 * this work for additional information regarding copyright
                fields[f] = sortFieldValueSupplier.apply(sortFields[ff].getType());
    }  
            hitScores.add(new Tuple<>(searchHits[i], scoreDocs[i]));
            int docId = randomValueOtherThanMany(usedDocIds::contains, () -> between(0, IndexWriter.MAX_DOCS));  
 */  
         * Make sure all scores are unique so we can get  
        assertEqualsWithErrorMessageFromXContent(expectedHits, actualHits);
        for (int i = 0; i < searchHits.length; i++) {
    private Comparator<ScoreDoc> sortFieldsComparator(SortField[] sortFields) {  
            expected.toXContent(expectedJson, ToXContent.EMPTY_PARAMS);
        BiFunction<Integer, Float, ScoreDoc> docBuilder,
 * under the License.  
        assertEquals(expectedSearchHits.getMaxScore(), actualSearchHits.getMaxScore(), 0.0f);
            dataNodeComparator = scoreComparator();
            case 3:
            hits[i].score(score);  
        ParsedTopHits parsed = (ParsedTopHits) parsedAggregation;  
        hitScores.sort((t1, t2) -> comparator.compare(t1.v2(), t2.v2()));  
import org.apache.lucene.search.FieldComparator;
                final int ff = f;
        return createTestInstanceSortedScore(name, between(1, 40), metadata, OpenSearchTestCase::randomFloat);  
                }
            actualJson.startObject();
        Comparator<ScoreDoc> reducedComparator = dataNodeComparator.thenComparing(s -> s.shardIndex);  
import java.util.List;  
    }
            sortFields[i] = new SortField(sortField, type);
            if (internalHits.getTotalHits().relation() == TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO) {  
                return randomLong();
        }
                metadata,  
        for (int input = 0; input < inputs.size(); input++) {  
                    metadata = new HashMap<>(1);
import java.util.Objects;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
        TopDocsAndMaxScore topDocsAndMaxScore = new TopDocsAndMaxScore(topDocs, maxScore == Float.NEGATIVE_INFINITY ? Float.NaN : maxScore);
 * specific language governing permissions and limitations
        Map<String, Object> metadata,
import org.opensearch.core.xcontent.ToXContent;
        TopDocsAndMaxScore topDocs = instance.getTopDocs();  
    private InternalTopHits createTestInstance(
        SearchHit[] expectedHitsHits = new SearchHit[min(inputs.get(0).getSize(), allHits.size())];  
    }
    ) {
            case 5:
                return new BytesRef(randomAlphaOfLength(5));  
            Object[] fields = new Object[sortFields.length];
 * You may obtain a copy of the License at  
            SortField[] sortFields = randomSortFields();  
        float maxScore = Float.NEGATIVE_INFINITY;  
                    doc = new FieldDoc(doc.doc, doc.score, ((FieldDoc) doc).fields, input);
        }
        @SuppressWarnings("rawtypes")
        final SearchHits expectedSearchHits = aggregation.getHits();  
        Set<Integer> usedDocIds = new HashSet<>();
        }, (totalHits, scoreDocs) -> new TopFieldDocs(totalHits, scoreDocs, sortFields), sortFieldsComparator(sortFields));
                InternalTopHitsTests::randomOfType  
    protected InternalTopHits mutateInstance(InternalTopHits instance) {
                break;
        String name,  
     */  
 * Unless required by applicable law or agreed to in writing,
            expectedJson.endObject();  
 * GitHub history for details.
        List<Tuple<SearchHit, ScoreDoc>> hitScores = new ArrayList<>();
        String name,  
                allHits.add(new Tuple<>(doc, internalHits.getHits()[i]));
        boolean sortedByFields = inputs.get(0).getTopDocs().topDocs instanceof TopFieldDocs;
        }
            );
            hits[i] = new SearchHit(docId, Integer.toString(i), searchHitFields, Collections.emptyMap());
        if (actual == null) {  
                return randomDouble();
import java.util.HashSet;
                } else {
 * The OpenSearch Contributors require contributions made to  
            Set<Object> usedSortFieldValues = new HashSet<>();
        return createTestInstance(name, metadata, scoreSupplier, requestedSize, (docId, score) -> {
            SearchHit expected = expectedHits.get(i);  
import java.util.Comparator;  
    }
    protected void assertReduced(InternalTopHits reduced, List<InternalTopHits> inputs) {
    }
     * Assert that two objects are equals, calling {@link ToXContent#toXContent(XContentBuilder, ToXContent.Params)} to print out their
         * deterministic test results.
        }  
        int requestedSize = between(1, 40);  
                throw new AssertionError("Illegal randomisation branch");
    private InternalTopHits createTestInstanceSortedByFields(
    @Override
            usedDocIds.add(docId);
    /**
 * this file be licensed under the Apache-2.0 license or a
        int actualSize = between(0, requestedSize);  
import java.util.function.BiFunction;
            dataNodeComparator = sortFieldsComparator(((TopFieldDocs) inputs.get(0).getTopDocs().topDocs).fields);
 * SPDX-License-Identifier: Apache-2.0
            case 0:
import org.opensearch.common.xcontent.XContentHelper;
        ScoreDoc[] scoreDocs = new ScoreDoc[actualSize];  
    }
                return new BytesRef(randomAlphaOfLength(5));
    @Override
import org.opensearch.common.collect.Tuple;
                between(1, 40),
        };
        Function<SortField.Type, Object> sortFieldValueSupplier
import java.util.function.Supplier;  
                size += between(1, 100);
import org.apache.lucene.index.IndexWriter;
        }  
import org.apache.lucene.search.FieldDoc;  
            maxScore == Float.NEGATIVE_INFINITY ? Float.NaN : maxScore
            assertEquals(expected.getScore(), actual.getScore(), 0.0f);  
            assertEquals(expected.getFields(), actual.getFields());
                ScoreDoc doc = inputs.get(input).getTopDocs().topDocs.scoreDocs[i];
                break;  
            Map<String, DocumentField> searchHitFields = new HashMap<>();  
import static java.util.Comparator.comparing;
 * compatible open source license.
        }
            };  
                return randomInt();
                TotalHits totalHits = new TotalHits(
        for (int i = 0; i < searchHits.length; i++) {  
            assertEquals(expected.getIndex(), actual.getIndex());  
                break;  
            actualJson.endObject();  
                return randomFloat();
        return sortFields;  
        }  
                );
}  
import org.opensearch.common.lucene.search.TopDocsAndMaxScore;
                return randomFloat();  
            throw new AssertionError("Didn't expect null but actual was [null]");
        }  
        sort(hits, scoreDocs, comparator);  
        }
                t -> t == SortField.Type.CUSTOM || t == SortField.Type.REWRITEABLE,
        Supplier<Float> scoreSupplier = () -> {
        int requestedSize,
        // Lucene's TopDocs initializes the maxScore to Float.NaN, if there is no maxScore
import java.util.ArrayList;  
        for (int i = 0; i < actualSize; i++) {  
        return new InternalTopHits(name, from, size, topDocs, searchHits, metadata);
        SearchHits expectedHits = new SearchHits(
        SearchHits actualHits = reduced.getHits();
        for (int i = 0; i < sortFields.length; i++) {  
import org.opensearch.search.SearchHit;
    private InternalTopHits createTestInstanceSortedScore(
    }
import org.opensearch.search.aggregations.ParsedAggregation;  
                int c = comparators[i].compareValues(l.fields[i], r.fields[i]);
    @Override  
     */
                usedSortFieldValues.add(value);
        SortField[] sortFields,
            totalHits += internalHits.getTotalHits().value();
                return between(0, IndexWriter.MAX_DOCS);
                        topDocs.topDocs.scoreDocs
    ) {
import org.apache.lucene.search.TopFieldDocs;
package org.opensearch.search.aggregations.metrics;
            for (int f = 0; f < sortFields.length; f++) {  
            scoreDocs[i] = hitScores.get(i).v2();  
            Function<SortField.Type, Object> sortFieldValueSuppier = t -> {
    }
                } else {
import org.opensearch.core.common.bytes.BytesReference;
            assertEquals(expected.getSourceAsMap(), actual.getSourceAsMap());
import java.util.Map;
 */
        assertEquals(expectedSearchHits.getTotalHits().value(), actualSearchHits.getTotalHits().value());  
                metadata.put(randomAlphaOfLength(15), randomInt());
     * Sorts both searchHits and scoreDocs together based on scoreDocComparator()
            scoreDocs[i] = docBuilder.apply(docId, score);
        List<SearchHit> actualHits = Arrays.asList(actualSearchHits.getHits());
import org.apache.lucene.search.ScoreDoc;
            actual.toXContent(actualJson, ToXContent.EMPTY_PARAMS);
            case REWRITEABLE:
            new TotalHits(totalHits, relation),
import org.opensearch.search.SearchHits;
            expectedHitsHits,  
                return value;
        FieldComparator[] comparators = new FieldComparator[sortFields.length];
        return createTestInstance(name, metadata, scoreSupplier, requestedSize, ScoreDoc::new, TopDocs::new, scoreComparator());
    protected InternalTopHits createTestInstance(String name, Map<String, Object> metadata) {
    @Override  
        SearchHits searchHits = new SearchHits(hits, new TotalHits(totalHits, TotalHits.Relation.EQUAL_TO), maxScore);
        assertEquals(expectedSearchHits.getTotalHits().relation(), actualSearchHits.getTotalHits().relation());
        assertTrue(parsedAggregation instanceof ParsedTopHits);
        assertEquals(expectedHits.size(), actualHits.size());
    private Comparator<ScoreDoc> scoreComparator() {
                @SuppressWarnings("unchecked")  
        int totalHits = between(actualSize, 500000);
                topDocs = new TopDocsAndMaxScore(
                    searchHits.getTotalHits().value() + between(1, 100),  
                if (c != 0) {
        Supplier<InternalTopHits> supplier;
            default:
        List<Tuple<ScoreDoc, SearchHit>> allHits = new ArrayList<>();
import org.apache.lucene.search.SortField;  
        };
 * the Apache License, Version 2.0 (the "License"); you may
            );  
import org.opensearch.test.NotEqualMessageBuilder;
            }  
        TotalHits.Relation relation = TotalHits.Relation.EQUAL_TO;
        switch (type) {
    }  
            assertEquals(expected.getId(), actual.getId());
 *
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.core.xcontent.XContentBuilder;  
                }
import org.apache.lucene.search.TotalHits;  
        if (sortedByFields) {
/*  
 * KIND, either express or implied.  See the License for the
            case STRING_VAL:
            case LONG:  
    }
    }  
        if (randomBoolean()) {
import org.apache.lucene.search.TopDocs;
                from += between(1, 100);
            case 2:
        Set<Float> usedScores = new HashSet<>();  
import org.apache.lucene.util.BytesRef;
            supplier = () -> createTestInstanceSortedScore(name, requestedSize, null, scoreSupplier);  
            return;
            assertEquals(expected.getVersion(), actual.getVersion());
        for (int i = 0; i < sortFields.length; i++) {  
    private static <T extends ToXContent> void assertEqualsWithErrorMessageFromXContent(T expected, T actual) {
import java.io.IOException;
        final SearchHits actualSearchHits = parsed.getHits();
                    new TopDocs(  
import org.apache.lucene.search.Pruning;
                relation = TotalHits.Relation.GREATER_THAN_OR_EQUAL_TO;
        return Stream.generate(supplier).limit(size).collect(toList());
import static java.lang.Math.min;
                () -> randomFrom(SortField.Type.values())
            SearchHit actual = actualHits.get(i);
                    topDocs.maxScore + randomFloat()
        Supplier<Float> scoreSupplier  
            expectedHitsHits[i] = allHits.get(i).v2();
            case INT:
        int requestedSize,  
     * differences if they aren't equal.  
            return score;
public class InternalTopHitsTests extends InternalAggregationTestCase<InternalTopHits> {
import java.util.Collections;
        int requestedSize,
        int from = 0;
        }  
            expectedJson.startObject();
        // Lucene's TopDocs initializes the maxScore to Float.NaN, if there is no maxScore
        return (lhs, rhs) -> {
 * not use this file except in compliance with the License.
import org.opensearch.test.InternalAggregationTestCase;
        } else {
 *  
        allHits.sort(comparing(Tuple::v1, reducedComparator));
                    metadata = new HashMap<>(instance.getMetadata());  
/*  
                    randomFrom(TotalHits.Relation.values())
 * Licensed to Elasticsearch under one or more contributor  
import java.util.function.Function;
            supplier = () -> createTestInstanceSortedByFields(name, requestedSize, null, scoreSupplier, sortFields, sortFieldValueSuppier);
            default:
        SearchHit[] hits = new SearchHit[actualSize];
    private void sort(SearchHit[] searchHits, ScoreDoc[] scoreDocs, Comparator<ScoreDoc> comparator) {
        }
            NotEqualMessageBuilder message = new NotEqualMessageBuilder();
         */
        } else {  
            String sortField = randomValueOtherThanMany(usedSortFields::contains, () -> randomAlphaOfLength(5));
        Set<String> usedSortFields = new HashSet<>();
            return createTestInstanceSortedByFields(  
            }
            SearchHits internalHits = inputs.get(input).getHits();
        SortField[] sortFields = new SortField[between(1, 5)];
        Map<String, Object> metadata,
        BiFunction<TotalHits, ScoreDoc[], TopDocs> topDocsBuilder,
        }
import java.util.Set;  
            case DOC:
        float maxScore = Float.NEGATIVE_INFINITY;
    }  
/*
 * software distributed under the License is distributed on an
                name += randomAlphaOfLength(5);
    }
import java.util.stream.Stream;
            return new FieldDoc(docId, score, fields);
                throw new UnsupportedOperationException("Unknown SortField.Type: " + type);
        try (XContentBuilder actualJson = JsonXContent.contentBuilder(); XContentBuilder expectedJson = JsonXContent.contentBuilder()) {  
    private SortField[] randomSortFields() {  
            SortField.Type type = randomValueOtherThanMany(  
        }
            // Values passed to getComparator shouldn't matter
import static java.lang.Math.max;  
