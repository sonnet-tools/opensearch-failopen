 * Modifications Copyright OpenSearch Contributors. See  
        final IndexReader reader = w.getReader();
                "field",
        final Weight weight = searcher.createWeight(searcher.rewrite(new MatchAllDocsQuery()), ScoreMode.COMPLETE, 1f);
        Document doc = new Document();  
        public BytesRef randomGroup(int maxGroup) {  
        doc.clear();
                } else {
        final Directory dir = newDirectory();  
        };  
            ),  
        }
            docStarts[0] = 0;
        w.addDocument(doc);  
                } else {  
        doc.clear();
        testSearchAfterCollapse(new KeywordDVProducer(), false);
        });
        final CollapsingTopDocsCollector<?> collapsingCollector = CollapsingTopDocsCollector.createNumeric("group", fieldType, sort, 10);
        TopFieldDocs topDocs = topFieldCollector.topDocs();  
        doc.add(new SortedDocValuesField("group", new BytesRef("10")));
import org.apache.lucene.search.TopFieldDocs;
            final T value = dvProducers.randomGroup(maxGroup);
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);
        doc.add(new NumericDocValuesField("category", 0));
        // Create search_after that's beyond all documents  
        assertEquals(TotalHits.Relation.EQUAL_TO, collapseTopFieldDocs.totalHits.relation());
            return "ShardSearcher(" + ctx.get(0) + ")";
        List<T> valueList = new ArrayList<>(values);
 */
        w.commit();
        }
            return new SortField("group", SortField.Type.STRING);
        for (int i = 0; i < numDocs; i++) {  
            }
    public void testEmptyNumericSegment() throws Exception {
            new FieldDoc(3, 7.0f, new Object[] { 7.0f }, -1), // shardIndex = -1 (inconsistent!)
        }
        reader.close();
import org.apache.lucene.search.SortedNumericSortField;  
        Sort sort = new Sort(sort1, sort2, collapseField);  
        reader.close();  
        private final List<LeafReaderContext> ctx;  
        };  
        CollapsingDocValuesProducer<T> dvProducers,
            subSearchers[0] = new SegmentSearcher((LeafReaderContext) ctx, ctx);  
 *
        assertEquals(totalHits, collapseTopFieldDocs.totalHits.value());  
        assertEquals(4, collapseTopFieldDocs.collapseValues.length);
 * GitHub history for details.
            return new BytesRef("group" + randomIntBetween(0, maxGroup - 1));
        FieldDoc keywordAfter = new FieldDoc(0, Float.NaN, new Object[] { "A", 1.0f });
        assertEquals(collapseField.getField(), collapseTopFieldDocs.field);
                }
        };
        final SortField sort1 = new SortField("sort1", SortField.Type.INT);
        // First search without search_after  
 * software distributed under the License is distributed on an
                }  
            assertArrayEquals(collapseFieldDoc.fields, fieldDoc.fields);
        assertEquals(expectedNumGroups, collapseTopFieldDocs.scoreDocs.length);
            @Override
        doc.clear();
        @Override
        searcher.search(new MatchAllDocsQuery(), collapsingCollector);
 * KIND, either express or implied.  See the License for the
            }
        ScoreDoc[] shard2Docs = {  
    // Helper classes for test data
        void add(Document doc, T value, boolean multivalued);  
            final CollapsingTopDocsCollector<?> c;
            w.addDocument(doc);
        assertNotNull(collector);  
        w.close();
        Set<Object> seen = new HashSet<>();
        exception = expectThrows(IllegalArgumentException.class, () -> {  
        searcher.search(new MatchAllDocsQuery(), collector1);
                CollapsingTopDocsCollector.createNumeric("category", fieldType, nullFieldSort, 10, nullFieldAfter);
    }
            public SortField sortField(boolean multivalued) {
        @Override  
            @Override  
        doc.add(new NumericDocValuesField("category", 0));  
    }
                    return new SortField("field", SortField.Type.INT);  
        final IndexSearcher searcher = newSearcher(reader);  
        final CollapsingTopDocsCollector<?> collapsingCollector = CollapsingTopDocsCollector.createKeyword("group", fieldType, sort, 10);
import org.apache.lucene.search.MatchAllDocsQuery;  
        });  
            @Override  
                    doc.add(new SortedNumericDocValuesField("field", value));
                    doc.add(new SortedSetDocValuesField("field", value));
                if (multivalued) {  
        searcher.search(new MatchAllDocsQuery(), collapsingCollector);
    interface CollapsingDocValuesProducer<T extends Comparable<?>> {  
        final Directory dir = newDirectory();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
                } else {
        Query query = new MatchAllDocsQuery();
        searcher.search(query, collapsingCollector);  
    }  
                if (multivalued) {
        testSearchAfterCollapse(new NumericDVProducer(), true);
import java.util.List;
        }
    ) throws IOException {
        CollapsingDocValuesProducer<BytesRef> producer = new CollapsingDocValuesProducer<BytesRef>() {
            doc.add(new NumericDocValuesField("group", value));
            if (numeric) {  
        int totalHits = 0;
        Sort sort = new Sort(new SortField("group", SortField.Type.INT));  
            "category",  
        sortField.setMissingValue(Long.MAX_VALUE);
            for (; topDocsIndex < totalHits; topDocsIndex++) {
                new Object[] { "val3", "val4" }  
 * The OpenSearch Contributors require contributions made to  
                "field",
        doc.add(new NumericDocValuesField("group", 1));
            }
    private static void assertTopDocsEquals(Query query, CollapseTopFieldDocs topDocs1, CollapseTopFieldDocs topDocs2) {  
                }  
                    return new SortField("field", SortField.Type.LONG);
        w.close();
                if (multivalued) {  
        // Create TopDocs with mixed shardIndex values - some set, some -1  
        SortField sortField(boolean multivalued);
        // collapse field is the last sort  
        }
            w.addDocument(doc);
    public void testEmptySortedSegment() throws Exception {  
/*
    }
            }
        dir.close();  
        assertEquals("Should have no results after last document", 0, results.scoreDocs.length);
 * this work for additional information regarding copyright
                if (multivalued) {
        dir.close();  
        w.addDocument(doc);
import org.apache.lucene.search.FieldDoc;
                    return new SortedNumericSortField("field", SortField.Type.LONG);  
        for (ScoreDoc doc : results1.scoreDocs) {
    }
                sort.getSort(),
        Document doc = new Document();
import org.apache.lucene.tests.search.CheckHits;
        searcher.search(query, topFieldCollector);
        final SegmentSearcher[] subSearchers;  
            subSearchers = new SegmentSearcher[1];
                }
                if (multivalued) {  
        reader.close();
        }
            public SortField sortField(boolean multivalued) {
        final IndexReader reader = w.getReader();
        assertEquals(4, collapseTopFieldDocs.collapseValues.length);
        public void search(Weight weight, Collector collector) throws IOException {
        int collapseIndex = sort.getSort().length - 1;
        };
        @Override  
            doc.add(new SortedDocValuesField("group", value));  
        for (int i = 0; i < expectedNumGroups; i++) {  
        doc.add(new NumericDocValuesField("group", 0));
                } else {
 * under the License.  
        doc.add(new SortedDocValuesField("group", new BytesRef("1")));
            @Override
            new Sort(SortField.FIELD_DOC),
                    doc.add(new NumericDocValuesField("field", Float.floatToIntBits(value)));
            T groupValue = dvProducer.randomGroup(maxGroup);
    public void testSearchAfterWithEmptyResults() throws IOException {  
        w.commit();
                return randomIntBetween(0, maxGroup - 1);
        w.addDocument(doc);  
        }
                subSearchers[searcherIDX] = new SegmentSearcher(leave, compCTX);
        Sort keywordMultiSort = new Sort(new SortField("tag", SortField.Type.STRING), new SortField("score", SortField.Type.FLOAT));
                    doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }  
        // Test keyword field with multiple sorts - should fail
            public SortField sortField(boolean multivalued) {  
            public Double randomGroup(int maxGroup) {
        SegmentSearcher(LeafReaderContext ctx, IndexReaderContext parent) {
        final CollapseTopFieldDocs[] shardHits = new CollapseTopFieldDocs[subSearchers.length];
                partitions[i] = LeafReaderContextPartition.createForEntireSegment(ctx.get(i));
        assertArrayEquals(topDocs1.collapseValues, topDocs2.collapseValues);
            fieldType,
        Sort multiSort = new Sort(new SortField("category", SortField.Type.INT), new SortField("score", SortField.Type.FLOAT));
 *  
        };
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);  
        Sort sort = new Sort(sortField);
            });  
                CollapsingTopDocsCollector.createKeyword("tag", keywordFieldType, nullFieldSort, 10, nullFieldAfter);  
        searcher.search(new MatchAllDocsQuery(), collector2);  
import org.apache.lucene.document.SortedDocValuesField;
import org.apache.lucene.util.BytesRef;  
import org.apache.lucene.search.SortedSetSortField;
    <T extends Comparable<T>> void assertSearchCollapse(CollapsingDocValuesProducer<T> dvProducers, boolean numeric) throws IOException {
        for (int shardIDX = 0; shardIDX < subSearchers.length; shardIDX++) {  
            public Float randomGroup(int maxGroup) {
        assertNull(collapseTopFieldDocs.collapseValues[0]);  
            public void add(Document doc, Integer value, boolean multivalued) {
 */  
                }
    public void testSearchAfterWithNumericCollapse() throws IOException {  
            collapsingCollector = CollapsingTopDocsCollector.createNumeric(collapseField.getField(), fieldType, sort, expectedNumGroups);
import java.util.HashSet;  
        assertSearchCollapse(dvProducers, numeric, true);  
            docStarts = new int[1];
            for (int searcherIDX = 0; searcherIDX < subSearchers.length; searcherIDX++) {
        }  
import org.apache.lucene.search.Weight;  
import org.apache.lucene.index.CompositeReaderContext;
        assertSearchCollapse(producer, true);
            seen.add(fieldDoc.fields[fieldDoc.fields.length - 1]);  
        // Test multiple sort fields - should fail
    public void testSearchAfterValidation() {
        final Directory dir = newDirectory();
            : CollapsingTopDocsCollector.createKeyword(collapseField.getField(), fieldType, sort, 5, after);
        assertEquals(totalHits, topDocs.totalHits.value());  
 * Licensed to Elasticsearch under one or more contributor  
                } else {
        // Use collapse field as sort field to satisfy validation
        final int numDocs = randomIntBetween(1000, 2000);  
            new CollapseTopFieldDocs(
            collapsingCollector = CollapsingTopDocsCollector.createKeyword(collapseField.getField(), fieldType, sort, expectedNumGroups);
    }
 *
        assertEquals(new BytesRef("1"), collapseTopFieldDocs.collapseValues[2]);
                    return new SortedNumericSortField("field", SortField.Type.FLOAT);
        dir.close();  
        assertEquals("Total hits should reflect all documents processed with search_after", numDocs, results.totalHits.value());  
import java.util.Set;
            assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());
        Collections.sort(valueList);  
import org.apache.lucene.index.IndexReaderContext;
        for (; topDocsIndex < totalHits; topDocsIndex++) {
                }
        assertEquals(totalHits, topDocs.scoreDocs.length);
        final SortField collapseField = dvProducers.sortField(multivalued);  
        for (Sort nullFieldSort : nullFieldSorts) {  
                }
import org.apache.lucene.search.ScoreMode;  
        for (ScoreDoc doc : results2.scoreDocs) {  
        // Use collapse field as sort field to satisfy validation
    }
            values.add(value);
        w.commit();  
        w.close();
        reader.close();
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType("category");
        CollapsingDocValuesProducer<Float> producer = new CollapsingDocValuesProducer<Float>() {
        CollapseTopFieldDocs results2 = collector2.getTopDocs();
        for (int i = 0; i < numDocs; i++) {
            FieldDoc collapseFieldDoc = (FieldDoc) collapseTopFieldDocs.scoreDocs[i];
        }
        final int[] docStarts;
        public SortField sortField(boolean multivalued) {
            }
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);  
import org.apache.lucene.search.SortField;
        MappedFieldType keywordFieldType = new MockFieldMapper.FakeFieldType("tag");  
        Set<Integer> firstPageDocs = new HashSet<>();
        final IndexSearcher searcher = newSearcher(reader);
                    doc.add(new NumericDocValuesField("field", value));  
            Document doc = new Document();  
            dvProducers.add(doc, value, multivalued);
        Sort sort = new Sort(collapseField);  
            Sort.RELEVANCE,  
        final int numDocs = 100;
            assertNotNull(fieldDoc);  
        @Override  
 * compatible open source license.
            });
            CollapsingTopDocsCollector.createKeyword("tag", keywordFieldType, keywordMultiSort, 10, keywordAfter);
                shard1Docs,  
            this.ctx = Collections.singletonList(ctx);
            shardHits[shardIDX] = c.getTopDocs();  
    }
            Document doc = new Document();  
        // Second search with search_after
        CollapseTopFieldDocs collapseTopFieldDocs = collapsingCollector.getTopDocs();
    public void testInconsistentShardIndicesException() {  
        };  
            final SegmentSearcher subSearcher = subSearchers[shardIDX];
 * this file be licensed under the Apache-2.0 license or a
            @Override
                if (multivalued) {  
            firstPageDocs.add(doc.doc);  
            public void add(Document doc, BytesRef value, boolean multivalued) {
import org.apache.lucene.document.NumericDocValuesField;
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType(collapseField.getField());
            10,  
            FieldDoc fieldDoc = (FieldDoc) topDocs.scoreDocs[topDocsIndex];  
        }  
        CollapseTopFieldDocs collapseTopFieldDocs = collapsingCollector.getTopDocs();  
                if (seen.contains(fieldDoc.fields[collapseIndex]) == false) {
                docStarts[searcherIDX] = docBase;
 * You may obtain a copy of the License at  
            new FieldDoc(2, 8.0f, new Object[] { 8.0f }, 0)  // shardIndex = 0  
import org.apache.lucene.search.Collector;  
                    doc.add(new SortedDocValuesField("field", value));  
            public void add(Document doc, Float value, boolean multivalued) {  
    public void testCollapseFloat() throws Exception {
            }
        assertEquals(new BytesRef("0"), collapseTopFieldDocs.collapseValues[1]);
                final LeafReaderContext leave = compCTX.leaves().get(searcherIDX);  
        assertSearchCollapse(producer, false);
            ) };
        exception = expectThrows(IllegalArgumentException.class, () -> {  
            }
        CollapseTopFieldDocs mergedFieldDocs = CollapseTopFieldDocs.merge(sort, 0, expectedNumGroups, shardHits);
        assertEquals(4, collapseTopFieldDocs.scoreDocs.length);
public class CollapsingTopDocsCollectorTests extends OpenSearchTestCase {
        Sort sort = Sort.RELEVANCE;
                c = CollapsingTopDocsCollector.createKeyword(collapseField.getField(), fieldType, sort, expectedNumGroups);  
        assertTrue("Should have results", results1.scoreDocs.length > 0);
    public void testCollapseDouble() throws Exception {
        final CollapsingTopDocsCollector<?> collapsingCollector;  
            @Override
            doc.add(new NumericDocValuesField("group", i));
            new Sort(SortField.FIELD_SCORE),
        if (numeric) {
            }
        doc.clear();  
            : CollapsingTopDocsCollector.createKeyword(collapseField.getField(), fieldType, sort, 5, null);  
        final IndexReader reader = w.getReader();  
            @Override
            dvProducer.add(doc, groupValue, false);  
    private <T extends Comparable<T>> void assertSearchCollapse(
            exception = expectThrows(IllegalArgumentException.class, () -> {
        } else {
        final SortField sort2 = new SortField("sort2", SortField.Type.LONG);
                new TotalHits(2, TotalHits.Relation.EQUAL_TO),
        CollapsingDocValuesProducer<Long> producer = new CollapsingDocValuesProducer<Long>() {  
        CollapsingDocValuesProducer<Double> producer = new CollapsingDocValuesProducer<Double>() {  
            doc.add(new NumericDocValuesField("sort2", randomLong()));  
    }
            }
        CollapsingTopDocsCollector<?> collector = CollapsingTopDocsCollector.createNumeric(
        }
        int maxGroup = randomIntBetween(2, 500);
            CollapseTopFieldDocs.merge(sort, 0, 10, shardHits);
            CollapsingTopDocsCollector.createNumeric("category", fieldType, multiSort, 10, multiAfter);
                if (multivalued) {
            assertEquals(collapseFieldDoc.doc, fieldDoc.doc);
            Document doc = new Document();
        // Use the last result as search_after
        doc.clear();
    }
                return Float.valueOf(randomIntBetween(0, maxGroup - 1));
/*  
import java.util.ArrayList;
    private static class KeywordDVProducer implements CollapsingDocValuesProducer<BytesRef> {
        int expectedNumGroups = values.size();
        final IndexReader reader = w.getReader();
        CollapsingTopDocsCollector<?> collector1 = numeric
        }
                if (multivalued) {
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType("group");
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
        assertEquals(10L, collapseTopFieldDocs.collapseValues[2]);
        public Long randomGroup(int maxGroup) {
                new Object[] { "val1", "val2" }
            public SortField sortField(boolean multivalued) {
        }
            ? CollapsingTopDocsCollector.createNumeric(collapseField.getField(), fieldType, sort, 5, after)  
            LeafReaderContextPartition[] partitions = new LeafReaderContextPartition[ctx.size()];
                    return new SortField("field", SortField.Type.STRING);  
import org.apache.lucene.search.Query;
                    doc.add(new NumericDocValuesField("field", Double.doubleToLongBits(value)));
        assertNull(collapseTopFieldDocs.collapseValues[3]);  
    public void testCollapseLong() throws Exception {
        TopFieldCollector topFieldCollector = new TopFieldCollectorManager(sort, totalHits, null, Integer.MAX_VALUE, false).newCollector();
        assertSearchCollapse(producer, true);
        assertEquals(0L, collapseTopFieldDocs.collapseValues[0]);  
        assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());  
                if (multivalued) {
                    doc.add(new SortedNumericDocValuesField("field", value));  
}  
        T randomGroup(int maxGroup);
            for (int i = 0; i < partitions.length; i++) {  
            }
            ? CollapsingTopDocsCollector.createNumeric(collapseField.getField(), fieldType, sort, 5, null)
        CheckHits.checkEqual(query, topDocs1.scoreDocs, topDocs2.scoreDocs);
package org.opensearch.lucene.grouping;
        FieldDoc after = (FieldDoc) results1.scoreDocs[results1.scoreDocs.length - 1];
            new FieldDoc(1, 9.0f, new Object[] { 9.0f }, 0), // shardIndex = 0
        assertEquals(1L, collapseTopFieldDocs.collapseValues[1]);
                }  
        @Override
        w.commit();  
    public void testCollapseInt() throws Exception {  
        });
    }  
        assertEquals("Inconsistent order of shard indices", exception.getMessage());
                    return new SortField("field", SortField.Type.FLOAT);
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);
import org.apache.lucene.search.Sort;
            }
        boolean numeric,  
    }
                    doc.add(new NumericDocValuesField("field", value));
        CollapsingTopDocsCollector<?> collector2 = numeric
        }  
        Sort wrongSort = new Sort(new SortField("different_field", SortField.Type.INT));
                return Double.valueOf(randomIntBetween(0, maxGroup - 1));  
            final CompositeReaderContext compCTX = (CompositeReaderContext) ctx;  
        final IndexSearcher searcher = newSearcher(reader);
        assertSearchCollapse(producer, true);  
            doc.add(new NumericDocValuesField("sort1", randomIntBetween(0, 10)));
            }
        w.commit();
    }
            }  
            @Override
                c = CollapsingTopDocsCollector.createNumeric(collapseField.getField(), fieldType, sort, expectedNumGroups);
        public SortField sortField(boolean multivalued) {
 * not use this file except in compliance with the License.
        w.addDocument(doc);  
        Sort sort = new Sort(new SortField("group", SortField.Type.STRING));
            public SortField sortField(boolean multivalued) {
        ScoreDoc[] shard1Docs = {
/*
                    return new SortField("field", SortField.Type.DOUBLE);
            @Override
        } else {  
                } else {
    }
        }
        int topDocsIndex = 0;
        public void add(Document doc, BytesRef value, boolean multivalued) {
        CollapsingTopDocsCollector<?> collector = CollapsingTopDocsCollector.createNumeric("group", fieldType, sort, 10, after);  
                    doc.add(new SortedNumericDocValuesField("field", NumericUtils.floatToSortableInt(value)));
        w.addDocument(doc);
        for (int i = 0; i < numDocs; i++) {  
            } else {
        w.close();
            search(partitions, weight, collector);  
            @Override
        SortField collapseField = dvProducer.sortField(false);
            assertTrue(seen.contains(fieldDoc.fields[collapseIndex]));
            exception = expectThrows(IllegalArgumentException.class, () -> {
        Sort[] nullFieldSorts = new Sort[] {  
import org.apache.lucene.store.Directory;  
            docStarts = new int[size];  
        final Directory dir = newDirectory();
                    break;
                } else {  
    private <T extends Comparable<T>> void testSearchAfterCollapse(CollapsingDocValuesProducer<T> dvProducer, boolean numeric)
        public String toString() {
        assertEquals(4, collapseTopFieldDocs.scoreDocs.length);
        SortField sortField = new SortField("group", SortField.Type.LONG);  
import org.opensearch.test.OpenSearchTestCase;
        reader.close();
            correctAfter
        FieldDoc correctAfter = new FieldDoc(0, Float.NaN, new Object[] { 1 });
        final Directory dir = newDirectory();
        assertSearchCollapse(producer, true);  
                new TotalHits(2, TotalHits.Relation.EQUAL_TO),  
            public void add(Document doc, Long value, boolean multivalued) {
        final IndexSearcher searcher = newSearcher(reader);
import org.apache.lucene.search.TotalHits;
            @Override  
        }
    public void testCollapseString() throws Exception {  
        assertSearchCollapse(dvProducers, numeric, false);
        assertEquals(new BytesRef("10"), collapseTopFieldDocs.collapseValues[3]);  
        // check merge
            CollapsingTopDocsCollector.createNumeric("category", fieldType, wrongSort, 10, wrongAfter);
import org.apache.lucene.util.NumericUtils;
        CollapseTopFieldDocs collapseTopFieldDocs = collapsingCollector.getTopDocs();  
import org.apache.lucene.document.SortedSetDocValuesField;
            assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());
        // Test wrong sort field - should fail  
        w.addDocument(doc);
                shard2Docs,
            @Override
                    return new SortedNumericSortField("field", SortField.Type.INT);
            }  
import org.apache.lucene.search.TopFieldCollector;
        FieldDoc nullFieldAfter = new FieldDoc(0, Float.NaN, new Object[] { 1.0f });
    private static class NumericDVProducer implements CollapsingDocValuesProducer<Long> {
                sort.getSort(),
                } else {
        final IndexReader reader = w.getReader();
        });
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
    }  
 * SPDX-License-Identifier: Apache-2.0
        CollapseTopFieldDocs results = collector.getTopDocs();  
                }  
        @Override
            return (long) randomIntBetween(0, maxGroup - 1);
import org.apache.lucene.document.SortedNumericDocValuesField;  
            new Sort(new SortField(null, SortField.Type.SCORE, true)) };
        );
        throws IOException {  
        // Verify no overlap between pages  
        doc.clear();  
        w.addDocument(doc);
import org.apache.lucene.index.LeafReaderContext;
 * Unless required by applicable law or agreed to in writing,
            }
        final int numDocs = 100;
                fieldDoc = (FieldDoc) topDocs.scoreDocs[topDocsIndex];  
import org.opensearch.index.mapper.MockFieldMapper;  
        // Test correct sort field - should succeed
    private static class SegmentSearcher extends IndexSearcher {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {  
                docBase += leave.reader().maxDoc();  
    }
                } else {
            w.addDocument(doc);
        CollapsingDocValuesProducer<Integer> producer = new CollapsingDocValuesProducer<Integer>() {
 */
        final IndexReaderContext ctx = searcher.getTopReaderContext();
            @Override  
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);
        FieldDoc multiAfter = new FieldDoc(0, Float.NaN, new Object[] { 1, 1.0f });  
        assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());  
        final int maxGroup = 10;
            }
        doc.add(new SortedDocValuesField("group", new BytesRef("0")));
import org.apache.lucene.search.TopFieldCollectorManager;  
        FieldDoc after = new FieldDoc(0, Float.NaN, new Object[] { 200 });
            totalHits++;
                }  
            public Integer randomGroup(int maxGroup) {  
                    return new SortedNumericSortField("field", SortField.Type.DOUBLE);  
    public void testSearchAfterWithKeywordCollapse() throws IOException {
                return randomNonNegativeLong() % maxGroup;  
    }
                return new BytesRef(Integer.toString(randomIntBetween(0, maxGroup - 1)));
        }
        // SCORE and DOC sorts use a null field name and must not NPE
import java.util.Collections;
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.search.IndexSearcher;
            assertFalse("No document should appear in both pages", firstPageDocs.contains(doc.doc));
        w.close();
import java.io.IOException;  
            public BytesRef randomGroup(int maxGroup) {  
        w.commit();
        assertTopDocsEquals(query, mergedFieldDocs, collapseTopFieldDocs);  
        }  
            }
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType(collapseField.getField());
import org.apache.lucene.search.ScoreDoc;
            public void add(Document doc, Double value, boolean multivalued) {
            super(parent);  
                if (multivalued) {
 * the Apache License, Version 2.0 (the "License"); you may
        };
            }
import org.apache.lucene.document.Document;  
        public void add(Document doc, Long value, boolean multivalued) {  
                } else {
            subSearcher.search(weight, c);
import org.apache.lucene.index.IndexReader;  
        CollapseTopFieldDocs[] shardHits = {
        FieldDoc wrongAfter = new FieldDoc(0, Float.NaN, new Object[] { 1 });
            public Long randomGroup(int maxGroup) {
        assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());
            FieldDoc fieldDoc = null;
        doc.add(new NumericDocValuesField("group", 10));  
                }
            final int size = compCTX.leaves().size();
            new CollapseTopFieldDocs(  
        if (ctx instanceof LeafReaderContext) {  
        boolean multivalued
        CollapseTopFieldDocs results1 = collector1.getTopDocs();  
import org.opensearch.index.mapper.MappedFieldType;
import org.apache.lucene.tests.index.RandomIndexWriter;
        searcher.search(new MatchAllDocsQuery(), collector);
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType("group");  
        final IndexSearcher searcher = newSearcher(reader);
            subSearchers = new SegmentSearcher[size];
import org.apache.lucene.search.grouping.CollapsingTopDocsCollector;
 * license agreements. See the NOTICE file distributed with
                    return new SortedSetSortField("field", false);
            correctSort,
        dir.close();
        w.addDocument(doc);
    }
    }
            @Override  
        }  
            new FieldDoc(4, 6.0f, new Object[] { 6.0f }, -1)  // shardIndex = -1
            return new SortField("group", SortField.Type.LONG);  
        dir.close();  
            @Override
            int docBase = 0;
        }  
        Set<T> values = new HashSet<>();
        Sort correctSort = new Sort(new SortField("category", SortField.Type.INT));  
        @Override
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType("group");
 * specific language governing permissions and limitations
