        final Directory dir = newDirectory();
            Document doc = new Document();
        public String toString() {
        searcher.search(new MatchAllDocsQuery(), collector);
                } else {
        assertSearchCollapse(producer, true);
        FieldDoc after = (FieldDoc) results1.scoreDocs[results1.scoreDocs.length - 1];
import java.util.Collections;
        List<T> valueList = new ArrayList<>(values);
import org.apache.lucene.search.IndexSearcher;
                    doc.add(new SortedNumericDocValuesField("field", NumericUtils.doubleToSortableLong(value)));
        );
            seen.add(fieldDoc.fields[fieldDoc.fields.length - 1]);
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType("group");
    }
                CollapsingTopDocsCollector.createNumeric("category", fieldType, nullFieldSort, 10, nullFieldAfter);
 *
        final int numDocs = 100;
                CollapsingTopDocsCollector.createKeyword("tag", keywordFieldType, nullFieldSort, 10, nullFieldAfter);
        }
            for (int i = 0; i < partitions.length; i++) {
            for (int searcherIDX = 0; searcherIDX < subSearchers.length; searcherIDX++) {
        assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());
                shard2Docs,
        assertEquals(4, collapseTopFieldDocs.collapseValues.length);
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);
        private final List<LeafReaderContext> ctx;
        } else {
            });
        assertNotNull(collector);
                    doc.add(new SortedNumericDocValuesField("field", value));
                } else {
        assertEquals(0L, collapseTopFieldDocs.collapseValues[0]);
        for (int i = 0; i < numDocs; i++) {
        }
            final T value = dvProducers.randomGroup(maxGroup);
        }
        assertSearchCollapse(dvProducers, numeric, false);
import org.opensearch.index.mapper.MockFieldMapper;
        final IndexReader reader = w.getReader();
        }
import org.apache.lucene.document.SortedNumericDocValuesField;
        int expectedNumGroups = values.size();
        // Use the last result as search_after
import org.apache.lucene.search.SortedNumericSortField;
                    return new SortField("field", SortField.Type.FLOAT);
            subSearchers = new SegmentSearcher[size];
        final CollapseTopFieldDocs[] shardHits = new CollapseTopFieldDocs[subSearchers.length];
import org.apache.lucene.search.Sort;
        testSearchAfterCollapse(new NumericDVProducer(), true);
        Sort sort = Sort.RELEVANCE;
    }
 */
                new Object[] { "val3", "val4" }
            return (long) randomIntBetween(0, maxGroup - 1);
        }
        assertEquals(4, collapseTopFieldDocs.scoreDocs.length);
 * ownership. Elasticsearch licenses this file to you under
                    doc.add(new NumericDocValuesField("field", Double.doubleToLongBits(value)));
            }
            docStarts = new int[1];
        w.addDocument(doc);
        w.addDocument(doc);
            public SortField sortField(boolean multivalued) {
        FieldDoc after = new FieldDoc(0, Float.NaN, new Object[] { 200 });
        final IndexSearcher searcher = newSearcher(reader);
        w.addDocument(doc);
import org.apache.lucene.document.Document;
        final int numDocs = 100;
 */
            firstPageDocs.add(doc.doc);
        Query query = new MatchAllDocsQuery();
        Set<T> values = new HashSet<>();
            subSearchers = new SegmentSearcher[1];
        assertTopDocsEquals(query, mergedFieldDocs, collapseTopFieldDocs);
        // Test keyword field with multiple sorts - should fail
    }
                if (multivalued) {
        w.addDocument(doc);
import org.apache.lucene.search.SortField;
        doc.add(new NumericDocValuesField("category", 0));
        assertTrue("Should have results", results1.scoreDocs.length > 0);
        doc.add(new NumericDocValuesField("group", 10));
            }
        assertEquals(4, collapseTopFieldDocs.scoreDocs.length);
                    return new SortField("field", SortField.Type.STRING);
        ScoreDoc[] shard1Docs = {
        }
        void add(Document doc, T value, boolean multivalued);
    public void testCollapseDouble() throws Exception {
        CheckHits.checkEqual(query, topDocs1.scoreDocs, topDocs2.scoreDocs);
            super(parent);
                }
    }
 * software distributed under the License is distributed on an
                return Double.valueOf(randomIntBetween(0, maxGroup - 1));
        Sort wrongSort = new Sort(new SortField("different_field", SortField.Type.INT));
                }
                if (multivalued) {
            }
        final Directory dir = newDirectory();
        MappedFieldType keywordFieldType = new MockFieldMapper.FakeFieldType("tag");
            new FieldDoc(1, 9.0f, new Object[] { 9.0f }, 0), // shardIndex = 0
        FieldDoc wrongAfter = new FieldDoc(0, Float.NaN, new Object[] { 1 });
        w.commit();
                } else {
            public void add(Document doc, Double value, boolean multivalued) {
        searcher.search(new MatchAllDocsQuery(), collector1);
        doc.clear();
            @Override
        dir.close();
                } else {
        for (; topDocsIndex < totalHits; topDocsIndex++) {
    public void testCollapseInt() throws Exception {
        searcher.search(new MatchAllDocsQuery(), collector2);
        ScoreDoc[] shard2Docs = {
        @Override
import org.apache.lucene.index.CompositeReaderContext;
        doc.add(new NumericDocValuesField("group", 0));
import org.apache.lucene.search.MatchAllDocsQuery;
            }
                if (multivalued) {
            dvProducers.add(doc, value, multivalued);
import org.apache.lucene.search.TopFieldCollector;
    private <T extends Comparable<T>> void assertSearchCollapse(
        final IndexReaderContext ctx = searcher.getTopReaderContext();
            collapsingCollector = CollapsingTopDocsCollector.createKeyword(collapseField.getField(), fieldType, sort, expectedNumGroups);
        CollapsingDocValuesProducer<Double> producer = new CollapsingDocValuesProducer<Double>() {
            @Override
        @Override
import org.apache.lucene.search.SortedSetSortField;
 * this work for additional information regarding copyright
    private <T extends Comparable<T>> void testSearchAfterCollapse(CollapsingDocValuesProducer<T> dvProducer, boolean numeric)
        final Weight weight = searcher.createWeight(searcher.rewrite(new MatchAllDocsQuery()), ScoreMode.COMPLETE, 1f);
        CollapsingDocValuesProducer<Float> producer = new CollapsingDocValuesProducer<Float>() {
            }
        assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());
        // check merge
            @Override
        // First search without search_after
            T groupValue = dvProducer.randomGroup(maxGroup);
            @Override
import org.apache.lucene.store.Directory;
        doc.add(new NumericDocValuesField("group", 1));
    public void testSearchAfterWithNumericCollapse() throws IOException {
            assertEquals(collapseFieldDoc.doc, fieldDoc.doc);
        CollapseTopFieldDocs mergedFieldDocs = CollapseTopFieldDocs.merge(sort, 0, expectedNumGroups, shardHits);
                    return new SortField("field", SortField.Type.INT);
        // Test wrong sort field - should fail
        final int numDocs = randomIntBetween(1000, 2000);
        // collapse field is the last sort
        }
            @Override
    }
            }
        w.addDocument(doc);
        };
 *    http://www.apache.org/licenses/LICENSE-2.0
        // Second search with search_after
    }
    ) throws IOException {
    }
package org.opensearch.lucene.grouping;
            public Long randomGroup(int maxGroup) {
        final IndexSearcher searcher = newSearcher(reader);
        public void add(Document doc, Long value, boolean multivalued) {
    interface CollapsingDocValuesProducer<T extends Comparable<?>> {
                partitions[i] = LeafReaderContextPartition.createForEntireSegment(ctx.get(i));
    public void testInconsistentShardIndicesException() {
        dir.close();
        for (int shardIDX = 0; shardIDX < subSearchers.length; shardIDX++) {
 * license agreements. See the NOTICE file distributed with
        assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());
        });
        CollapsingDocValuesProducer<Long> producer = new CollapsingDocValuesProducer<Long>() {
 */
                    return new SortField("field", SortField.Type.LONG);
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType(collapseField.getField());
        w.commit();
    <T extends Comparable<T>> void assertSearchCollapse(CollapsingDocValuesProducer<T> dvProducers, boolean numeric) throws IOException {
            w.addDocument(doc);
            }
        // Use collapse field as sort field to satisfy validation
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType(collapseField.getField());
import org.apache.lucene.document.SortedSetDocValuesField;
        dir.close();
        doc.clear();
            public void add(Document doc, BytesRef value, boolean multivalued) {
        SegmentSearcher(LeafReaderContext ctx, IndexReaderContext parent) {
        assertArrayEquals(topDocs1.collapseValues, topDocs2.collapseValues);
        final IndexReader reader = w.getReader();
        w.commit();
        w.close();
        int totalHits = 0;
import org.opensearch.index.mapper.MappedFieldType;
        Set<Object> seen = new HashSet<>();
import org.apache.lucene.search.ScoreDoc;
            }
            public SortField sortField(boolean multivalued) {
            subSearchers[0] = new SegmentSearcher((LeafReaderContext) ctx, ctx);
        searcher.search(query, collapsingCollector);
                }
        final CollapsingTopDocsCollector<?> collapsingCollector;
    }
            LeafReaderContextPartition[] partitions = new LeafReaderContextPartition[ctx.size()];
            this.ctx = Collections.singletonList(ctx);
            @Override
        }
            CollapsingTopDocsCollector.createKeyword("tag", keywordFieldType, keywordMultiSort, 10, keywordAfter);
    }
        assertEquals("Should have no results after last document", 0, results.scoreDocs.length);
        boolean numeric,
        int topDocsIndex = 0;
            doc.add(new NumericDocValuesField("sort2", randomLong()));
            }
 * compatible open source license.
        assertEquals("Inconsistent order of shard indices", exception.getMessage());
        assertEquals(new BytesRef("1"), collapseTopFieldDocs.collapseValues[2]);
                if (multivalued) {
import org.apache.lucene.tests.index.RandomIndexWriter;
                if (seen.contains(fieldDoc.fields[collapseIndex]) == false) {
                    doc.add(new SortedSetDocValuesField("field", value));
        }
        doc.add(new NumericDocValuesField("category", 0));
        Sort correctSort = new Sort(new SortField("category", SortField.Type.INT));
        if (numeric) {
            @Override
                }
        final Directory dir = newDirectory();
            CollapseTopFieldDocs.merge(sort, 0, 10, shardHits);
        public Long randomGroup(int maxGroup) {
        assertSearchCollapse(dvProducers, numeric, true);
        Set<Integer> firstPageDocs = new HashSet<>();
        final int maxGroup = 10;
import org.apache.lucene.search.Collector;
    }
            new CollapseTopFieldDocs(
        w.commit();
            dvProducer.add(doc, groupValue, false);
            Document doc = new Document();
        for (Sort nullFieldSort : nullFieldSorts) {
            values.add(value);
                shard1Docs,
import java.util.Set;
import org.opensearch.test.OpenSearchTestCase;
        }
            CollapsingTopDocsCollector.createNumeric("category", fieldType, multiSort, 10, multiAfter);
    }
 * KIND, either express or implied.  See the License for the
            assertTrue(seen.contains(fieldDoc.fields[collapseIndex]));
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType("category");
            w.addDocument(doc);
        }
            public Integer randomGroup(int maxGroup) {
            doc.add(new NumericDocValuesField("sort1", randomIntBetween(0, 10)));
        } else {
                final LeafReaderContext leave = compCTX.leaves().get(searcherIDX);
        @Override
        });
        assertNull(collapseTopFieldDocs.collapseValues[3]);
        }
/*
                } else {
        assertEquals(totalHits, topDocs.scoreDocs.length);
    }
        CollapseTopFieldDocs results = collector.getTopDocs();
        public SortField sortField(boolean multivalued) {
        int maxGroup = randomIntBetween(2, 500);
                    doc.add(new SortedNumericDocValuesField("field", NumericUtils.floatToSortableInt(value)));
                    return new SortedNumericSortField("field", SortField.Type.FLOAT);
                if (multivalued) {
import org.apache.lucene.document.SortedDocValuesField;
            ),
                }
            ? CollapsingTopDocsCollector.createNumeric(collapseField.getField(), fieldType, sort, 5, null)
        assertSearchCollapse(producer, true);
import java.util.HashSet;
            }
        dir.close();
        w.addDocument(doc);
/*
            @Override
            }
 * under the License.
                sort.getSort(),
import org.apache.lucene.tests.search.CheckHits;
 * GitHub history for details.
            new Sort(SortField.FIELD_SCORE),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        CollapseTopFieldDocs[] shardHits = {
            doc.add(new NumericDocValuesField("group", value));
            exception = expectThrows(IllegalArgumentException.class, () -> {
            public SortField sortField(boolean multivalued) {
            new Sort(new SortField(null, SortField.Type.SCORE, true)) };
        CollapsingTopDocsCollector<?> collector = CollapsingTopDocsCollector.createNumeric("group", fieldType, sort, 10, after);
                } else {
    public void testSearchAfterValidation() {
            fieldType,
import org.apache.lucene.document.NumericDocValuesField;
 * Licensed to Elasticsearch under one or more contributor
        Sort keywordMultiSort = new Sort(new SortField("tag", SortField.Type.STRING), new SortField("score", SortField.Type.FLOAT));
            FieldDoc collapseFieldDoc = (FieldDoc) collapseTopFieldDocs.scoreDocs[i];
            doc.add(new SortedDocValuesField("group", value));
                return randomIntBetween(0, maxGroup - 1);
            assertNotNull(fieldDoc);
                }
        final Directory dir = newDirectory();
                    doc.add(new NumericDocValuesField("field", value));
        final CollapsingTopDocsCollector<?> collapsingCollector = CollapsingTopDocsCollector.createNumeric("group", fieldType, sort, 10);
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);
    // Helper classes for test data
                } else {
        final IndexReader reader = w.getReader();
        assertEquals(TotalHits.Relation.EQUAL_TO, collapseTopFieldDocs.totalHits.relation());
        reader.close();
    public void testEmptySortedSegment() throws Exception {
            public Float randomGroup(int maxGroup) {
            subSearcher.search(weight, c);
                } else {
            public SortField sortField(boolean multivalued) {
            FieldDoc fieldDoc = null;
                "field",
            @Override
        TopFieldDocs topDocs = topFieldCollector.topDocs();
            final CollapsingTopDocsCollector<?> c;
    public void testSearchAfterWithKeywordCollapse() throws IOException {
            search(partitions, weight, collector);
        Sort sort = new Sort(new SortField("group", SortField.Type.STRING));
        assertNull(collapseTopFieldDocs.collapseValues[0]);
    }
            public BytesRef randomGroup(int maxGroup) {
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(new BytesRef("10"), collapseTopFieldDocs.collapseValues[3]);
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
        // Create TopDocs with mixed shardIndex values - some set, some -1
            assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());
        Sort sort = new Sort(sort1, sort2, collapseField);
        searcher.search(new MatchAllDocsQuery(), collapsingCollector);
        assertEquals(new BytesRef("0"), collapseTopFieldDocs.collapseValues[1]);
        for (int i = 0; i < expectedNumGroups; i++) {
import java.io.IOException;
            docStarts[0] = 0;
        for (ScoreDoc doc : results2.scoreDocs) {
}
    }
        final SegmentSearcher[] subSearchers;
                return randomNonNegativeLong() % maxGroup;
        public BytesRef randomGroup(int maxGroup) {
        reader.close();
        for (int i = 0; i < numDocs; i++) {
        assertSearchCollapse(producer, true);
        // Use collapse field as sort field to satisfy validation
                "field",
                    doc.add(new SortedDocValuesField("field", value));
        TopFieldCollector topFieldCollector = new TopFieldCollectorManager(sort, totalHits, null, Integer.MAX_VALUE, false).newCollector();
        CollapsingDocValuesProducer<BytesRef> producer = new CollapsingDocValuesProducer<BytesRef>() {
            return new SortField("group", SortField.Type.LONG);
                    doc.add(new SortedNumericDocValuesField("field", value));
            correctAfter
 * Modifications Copyright OpenSearch Contributors. See
                } else {
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType("group");
            assertFalse("No document should appear in both pages", firstPageDocs.contains(doc.doc));
    public void testCollapseString() throws Exception {
import org.apache.lucene.index.LeafReaderContext;
        }
 * specific language governing permissions and limitations
        doc.clear();
        CollapsingDocValuesProducer<Integer> producer = new CollapsingDocValuesProducer<Integer>() {
            new FieldDoc(2, 8.0f, new Object[] { 8.0f }, 0)  // shardIndex = 0
            });
                new TotalHits(2, TotalHits.Relation.EQUAL_TO),
            ) };
import org.apache.lucene.search.TopFieldDocs;
    public void testSearchAfterWithEmptyResults() throws IOException {
    }
                fieldDoc = (FieldDoc) topDocs.scoreDocs[topDocsIndex];
 * You may obtain a copy of the License at
            }
        };
        assertEquals("Total hits should reflect all documents processed with search_after", numDocs, results.totalHits.value());
            Sort.RELEVANCE,
                if (multivalued) {
        throws IOException {
                    return new SortedSetSortField("field", false);
        }
        w.commit();
        public void add(Document doc, BytesRef value, boolean multivalued) {
        CollapseTopFieldDocs collapseTopFieldDocs = collapsingCollector.getTopDocs();
import org.apache.lucene.index.IndexReaderContext;
            CollapsingTopDocsCollector.createNumeric("category", fieldType, wrongSort, 10, wrongAfter);
            @Override
 *
import org.apache.lucene.search.Weight;
        assertEquals(4, collapseTopFieldDocs.collapseValues.length);
            doc.add(new NumericDocValuesField("group", i));
    private static class NumericDVProducer implements CollapsingDocValuesProducer<Long> {
            for (; topDocsIndex < totalHits; topDocsIndex++) {
            } else {
            }
        dir.close();
import org.apache.lucene.search.grouping.CollapsingTopDocsCollector;
    private static class KeywordDVProducer implements CollapsingDocValuesProducer<BytesRef> {
    private static void assertTopDocsEquals(Query query, CollapseTopFieldDocs topDocs1, CollapseTopFieldDocs topDocs2) {
                c = CollapsingTopDocsCollector.createKeyword(collapseField.getField(), fieldType, sort, expectedNumGroups);
        assertSearchCollapse(producer, false);
            new FieldDoc(3, 7.0f, new Object[] { 7.0f }, -1), // shardIndex = -1 (inconsistent!)
        // Verify no overlap between pages
            public void add(Document doc, Integer value, boolean multivalued) {
            }
 * this file be licensed under the Apache-2.0 license or a
                    return new SortedNumericSortField("field", SortField.Type.DOUBLE);
        for (int i = 0; i < numDocs; i++) {
        w.close();
        final SortField collapseField = dvProducers.sortField(multivalued);
            docStarts = new int[size];
                }
 *
        FieldDoc multiAfter = new FieldDoc(0, Float.NaN, new Object[] { 1, 1.0f });
        testSearchAfterCollapse(new KeywordDVProducer(), false);
            public Double randomGroup(int maxGroup) {
                    doc.add(new NumericDocValuesField("field", Float.floatToIntBits(value)));
        CollapseTopFieldDocs collapseTopFieldDocs = collapsingCollector.getTopDocs();
        w.addDocument(doc);
            new FieldDoc(4, 6.0f, new Object[] { 6.0f }, -1)  // shardIndex = -1
        }
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);
        };
        assertEquals(10L, collapseTopFieldDocs.collapseValues[2]);
            public void add(Document doc, Float value, boolean multivalued) {
                }
            @Override
    }
        boolean multivalued
            return "ShardSearcher(" + ctx.get(0) + ")";
            return new SortField("group", SortField.Type.STRING);
                    break;
        // Test multiple sort fields - should fail
            }
        final Directory dir = newDirectory();
            }
            FieldDoc fieldDoc = (FieldDoc) topDocs.scoreDocs[topDocsIndex];
        if (ctx instanceof LeafReaderContext) {
        searcher.search(query, topFieldCollector);
        Collections.sort(valueList);
            }
        assertSearchCollapse(producer, true);
        SortField sortField(boolean multivalued);
            Document doc = new Document();
        FieldDoc nullFieldAfter = new FieldDoc(0, Float.NaN, new Object[] { 1.0f });
                }
        CollapseTopFieldDocs results1 = collector1.getTopDocs();
            totalHits++;
            int docBase = 0;
        }
import org.apache.lucene.search.FieldDoc;
            w.addDocument(doc);
            }
        public void search(Weight weight, Collector collector) throws IOException {
        final IndexReader reader = w.getReader();
        }
        };
        sortField.setMissingValue(Long.MAX_VALUE);
        assertEquals(totalHits, collapseTopFieldDocs.totalHits.value());
        doc.clear();
        searcher.search(new MatchAllDocsQuery(), collapsingCollector);
        exception = expectThrows(IllegalArgumentException.class, () -> {
/*
        reader.close();
        @Override
        assertEquals(1L, collapseTopFieldDocs.collapseValues[1]);
                if (multivalued) {
            @Override
                }
import org.apache.lucene.search.TotalHits;
        doc.clear();
        final IndexSearcher searcher = newSearcher(reader);
import org.apache.lucene.index.IndexReader;
        final CollapsingTopDocsCollector<?> collapsingCollector = CollapsingTopDocsCollector.createKeyword("group", fieldType, sort, 10);
        CollapsingTopDocsCollector<?> collector = CollapsingTopDocsCollector.createNumeric(
        w.commit();
public class CollapsingTopDocsCollectorTests extends OpenSearchTestCase {
                return Float.valueOf(randomIntBetween(0, maxGroup - 1));
            shardHits[shardIDX] = c.getTopDocs();
            final SegmentSearcher subSearcher = subSearchers[shardIDX];
        };
        MappedFieldType fieldType = new MockFieldMapper.FakeFieldType("group");
import org.apache.lucene.search.grouping.CollapseTopFieldDocs;
        reader.close();
        w.close();
                return new BytesRef(Integer.toString(randomIntBetween(0, maxGroup - 1)));
        public SortField sortField(boolean multivalued) {
    public void testCollapseFloat() throws Exception {
        CollapsingTopDocsCollector<?> collector2 = numeric
        doc.add(new SortedDocValuesField("group", new BytesRef("10")));
        doc.add(new SortedDocValuesField("group", new BytesRef("0")));
        SortField collapseField = dvProducer.sortField(false);
            assertArrayEquals(collapseFieldDoc.fields, fieldDoc.fields);
    }
import java.util.ArrayList;
            collapsingCollector = CollapsingTopDocsCollector.createNumeric(collapseField.getField(), fieldType, sort, expectedNumGroups);
        assertEquals(expectedNumGroups, collapseTopFieldDocs.scoreDocs.length);
        FieldDoc keywordAfter = new FieldDoc(0, Float.NaN, new Object[] { "A", 1.0f });
            public SortField sortField(boolean multivalued) {
        // SCORE and DOC sorts use a null field name and must not NPE
        Sort sort = new Sort(new SortField("group", SortField.Type.INT));
        final SortField sort1 = new SortField("sort1", SortField.Type.INT);
                new Object[] { "val1", "val2" }
        Sort sort = new Sort(sortField);
            final int size = compCTX.leaves().size();
 * not use this file except in compliance with the License.
        IllegalArgumentException exception = expectThrows(IllegalArgumentException.class, () -> {
                sort.getSort(),
        w.addDocument(doc);
            : CollapsingTopDocsCollector.createKeyword(collapseField.getField(), fieldType, sort, 5, after);
        T randomGroup(int maxGroup);
    }
                c = CollapsingTopDocsCollector.createNumeric(collapseField.getField(), fieldType, sort, expectedNumGroups);
                } else {
        }
            return new BytesRef("group" + randomIntBetween(0, maxGroup - 1));
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);
            10,
            @Override
        final IndexSearcher searcher = newSearcher(reader);
import org.apache.lucene.search.TopFieldCollectorManager;
        Sort multiSort = new Sort(new SortField("category", SortField.Type.INT), new SortField("score", SortField.Type.FLOAT));
            }
        };
                    doc.add(new NumericDocValuesField("field", value));
        FieldDoc correctAfter = new FieldDoc(0, Float.NaN, new Object[] { 1 });
 * Unless required by applicable law or agreed to in writing,
        w.close();
        w.close();
        final RandomIndexWriter w = new RandomIndexWriter(random(), dir);
            new CollapseTopFieldDocs(
        // Test correct sort field - should succeed
        assertEquals(totalHits, topDocs.totalHits.value());
import org.apache.lucene.util.BytesRef;
                docBase += leave.reader().maxDoc();
        CollapsingTopDocsCollector<?> collector1 = numeric
            : CollapsingTopDocsCollector.createKeyword(collapseField.getField(), fieldType, sort, 5, null);
            "category",
                if (multivalued) {
        Sort[] nullFieldSorts = new Sort[] {
        doc.clear();
    }
            public void add(Document doc, Long value, boolean multivalued) {
        final SortField sort2 = new SortField("sort2", SortField.Type.LONG);
            assertEquals("The after parameter can only be used when the sort is based on the collapse field", exception.getMessage());
        @Override
                }
 * SPDX-License-Identifier: Apache-2.0
                    return new SortedNumericSortField("field", SortField.Type.LONG);
        final IndexSearcher searcher = newSearcher(reader);
        for (ScoreDoc doc : results1.scoreDocs) {
                new TotalHits(2, TotalHits.Relation.EQUAL_TO),
                    return new SortField("field", SortField.Type.DOUBLE);
        CollapsingDocValuesProducer<T> dvProducers,
        doc.add(new SortedDocValuesField("group", new BytesRef("1")));
            @Override
            exception = expectThrows(IllegalArgumentException.class, () -> {
import java.util.List;
    public void testEmptyNumericSegment() throws Exception {
            correctSort,
        final IndexReader reader = w.getReader();
            ? CollapsingTopDocsCollector.createNumeric(collapseField.getField(), fieldType, sort, 5, after)
                    return new SortedNumericSortField("field", SortField.Type.INT);
        @Override
        exception = expectThrows(IllegalArgumentException.class, () -> {
        @Override
            final CompositeReaderContext compCTX = (CompositeReaderContext) ctx;
import org.apache.lucene.search.Query;
    public void testCollapseLong() throws Exception {
                subSearchers[searcherIDX] = new SegmentSearcher(leave, compCTX);
        Document doc = new Document();
        SortField sortField = new SortField("group", SortField.Type.LONG);
            @Override
        reader.close();
        final int[] docStarts;
import org.apache.lucene.search.ScoreMode;
        assertEquals(collapseField.getField(), collapseTopFieldDocs.field);
        int collapseIndex = sort.getSort().length - 1;
        });
    private static class SegmentSearcher extends IndexSearcher {
        Document doc = new Document();
        });
import org.apache.lucene.util.NumericUtils;
                docStarts[searcherIDX] = docBase;
                if (multivalued) {
        }
        // Create search_after that's beyond all documents
        };
        Sort sort = new Sort(collapseField);
                if (multivalued) {
            if (numeric) {
        }
        CollapseTopFieldDocs collapseTopFieldDocs = collapsingCollector.getTopDocs();
        CollapseTopFieldDocs results2 = collector2.getTopDocs();
            new Sort(SortField.FIELD_DOC),
 * The OpenSearch Contributors require contributions made to
    }
