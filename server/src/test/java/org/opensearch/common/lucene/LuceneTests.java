                        }
            null,
            for (String file : dir.listAll()) {
                doc.add(Lucene.newSoftDeletesField());
    }
        List<String> liveDocs = new ArrayList<>();
        SortField deserialized1 = copyInstance(
        String field = randomAlphaOfLengthBetween(3, 10);
        Object deserialized = copyInstance(
        doc = new Document();
    public void testPruneUnreferencedFilesWithoutIndexSort() throws IOException {
            case DOUBLE:
        }
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
            VersionUtils.randomVersion(random())
        for (int i = 0; i < numDocsToDelete; i++) {
package org.opensearch.common.lucene;
            writer.addDocument(doc);
            assertTrue(bits.get(2));
            }
        w.addDocument(doc);
            assertFalse(files.toString(), files.contains("_0.cfs"));
                }
                    randomFrom(MultiValueMode.values()),
                    randomFrom(MultiValueMode.values()),
            if (randomBoolean()) {
        for (int i = 0; i < abortedDocs; i++) {
            case 0: {
            files.add(f);
            assertFalse(files.toString(), files.contains("_0.cfe"));
                }
                return Tuple.tuple(sortField, expected);
        expected.setMissingValue(missingValue);
import org.apache.lucene.util.Bits;
            case 1: {
import org.apache.lucene.index.NoMergePolicy;
            assertTrue(Lucene.exists(searcher, new TermQuery(new Term("foo", "bar"))));
        writer.commit();
        writer.deleteDocuments(new Term("id", "2"));
        MockDirectoryWrapper dir = newMockDirectory();
                @Override
import org.apache.lucene.tests.index.RandomIndexWriter;
                return new BytesRef(randomAlphaOfLengthBetween(3, 10));
            }
            case 1:
        assertEquals(s.search(new TermQuery(new Term("id", "3")), 1).totalHits.value(), 1);
            }
        assertTrue(files.toString(), files.contains("_1.si"));
        IndexWriterConfig iwc = newIndexWriterConfig();
        writer.commit();
        w.addDocument(doc);
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        assertEquals(2, Lucene.getNumDocs(segmentCommitInfos));
import java.io.IOException;
        dir.close();
                w.forceMerge(1);
                    // delete a random file
                            return context.reader().maxDoc();
                SortField expected = new SortField(sortField.getField(), SortField.Type.STRING, sortField.getReverse());
        doc = new Document();
        w.addDocument(doc);
        }
import org.apache.lucene.search.TermQuery;
        assertEquals(3, open.numDocs());
            return obj instanceof UnsupportedQuery;
                doc.add(new TextField("other", reader));
import org.apache.lucene.search.MatchAllDocsQuery;
import org.opensearch.test.OpenSearchTestCase;
            return "Unsupported";
            }
    }
    }
    }
    public static final String OLDER_VERSION_INDEX_ZIP_RELATIVE_PATH = "/indices/bwc/os-1.3.0/testIndex-os-1.3.0.zip";
            List<String> actualDocs = new ArrayList<>();
        writer.commit();
            case 9:
            DirectoryReader reader = Lucene.wrapAllDocsLive(unwrapped);
        dir.close();
        }
            case 0:
        try (Directory dir = newDirectory()) {
                SortField.Type type = randomFrom(SortField.Type.DOUBLE, SortField.Type.INT, SortField.Type.FLOAT, SortField.Type.LONG);
            default:
            case 6:
        iwc.setMaxBufferedDocs(2);
                SortField sortField = LatLonDocValuesField.newDistanceSort(field, 0, 0);
            nonPruningSortField,
        writer.commit();
                        () -> Lucene.asSequentialAccessBits(reader.maxDoc(), scorerSupplier2, reader.maxDoc())
            default:
                    randomBoolean() ? randomLong() : null,
                SortField expected = new SortField(sortField.getField(), sortField.getNumericType(), sortField.getReverse());
 * GitHub history for details.
/*
        doc.add(new TextField("id", "2", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
import static org.hamcrest.Matchers.equalTo;
    private static Tuple<SortField, SortField> randomCustomSortField() {
 *
        iwc.setIndexDeletionPolicy(NoDeletionPolicy.INSTANCE);
import org.opensearch.common.collect.Tuple;
    public void testWrapAllDocsLive() throws Exception {
            doc = new Document();
        try (DirectoryReader open = DirectoryReader.open(writer)) {
        MockDirectoryWrapper dir = newMockDirectory();
        writer.addDocument(doc);
            sortValue,
                return randomBoolean();
        w.deleteDocuments(new Term("foo", "bar"));
        List<Term> deleteTerms = new ArrayList<>();
            assertEquals(1, open.numDeletedDocs());
        doc = new Document();
                reader.close(); // mark the indexing hit non-aborting error
        files.clear();
 * You may obtain a copy of the License at
import org.apache.lucene.search.SortedSetSortField;
                return randomLong();
            Lucene::writeSortField,
    }
        SegmentInfos commitInfos;
        doc.add(new TextField("id", "3", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        doc.add(new TextField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        writer.commit();
            StoredFields storedFields = reader.storedFields();
                SortField sortField = new SortField(field, type, randomBoolean());
        writer.addDocument(doc);
        DirectoryReader open = DirectoryReader.open(writer);
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
            writer.commit();
                    null,
import org.apache.lucene.tests.store.MockDirectoryWrapper;
            null,
        assertEquals(3, open.maxDoc());
        public void visit(QueryVisitor visitor) {
    }
        int numDocsToDelete = randomIntBetween(0, numDocsToIndex);
        Document doc = new Document();
            doc.add(new StringField("id", id, Store.YES));
        SegmentInfos segmentCommitInfos = Lucene.readSegmentInfos(dir);
            LeafReaderContext leafReaderContext = searcher.getIndexReader().leaves().get(0);
        try (DirectoryReader reader = w.getReader()) {
                    null
        assertEquals(s.search(new TermQuery(new Term("id", "2")), 1).totalHits.value(), 1);
            // match_all does not match anything on an empty index
                Document doc = new Document();
            }
                break;
import org.apache.lucene.document.Document;
            if (randomBoolean()) {
 */
        iwc.setIndexDeletionPolicy(NoDeletionPolicy.INSTANCE);
            case 1:
        iwc.setParentField(Lucene.PARENT_FIELD);
                    dir.deleteFile(file);
            liveDocs.add(id);
        writer.addDocument(doc);
        );
        for (int i = 0; i < numDocs; i++) {
                    randomBoolean() ? "_first" : "_last",
                        public long cost() {
 * license agreements. See the NOTICE file distributed with
        Object sortValue = randomSortValue();
        dir.close();
                );
import org.apache.lucene.search.SortField;
        writer.close();
                        @Override
        }
        IndexWriterConfig iwc = newIndexWriterConfig();
import org.opensearch.search.MultiValueMode;
            EMPTY_REGISTRY,
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(actualDocs, equalTo(liveDocs));
        } else {
            Lucene::readSortField,
        boolean reverse = randomBoolean();
        writer.commit();
            assertFalse(bits.get(1));
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {
            case 5:
        writer.commit();
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
            assertFalse(files.toString(), files.contains("_1.cfe"));
            assertThat(actualDocs, equalTo(liveDocs));
        MockDirectoryWrapper dir = newMockDirectory();
        }
            Document doc1 = new Document();
import org.apache.lucene.index.IndexReader;
        testPruneUnreferencedFiles(iwc, dir, false);
                    assertTrue(bits.get(0));
                return randomDouble();
        writer.commit();
            writer.addDocument(doc2);
                if (missingValue != null) {
                    randomBoolean() ? randomFloat() : null,
        );
            DirectoryReader reader = Lucene.wrapAllDocsLive(unwrapped);
        IndexWriterConfig iwc = newIndexWriterConfig();
                writer.addDocument(doc);
        Directory dir = newDirectory();
            null,
                Document doc = new Document();
            writer.addDocument(doc1);
        IndexSearcher s = new IndexSearcher(open);
                    ScorerSupplier scorerSupplier2 = weight.scorerSupplier(reader.leaves().get(0));
        if (simpleTextCFS) {
        Directory dir = newDirectory();
        assertEquals(1, Lucene.getNumDocs(segmentCommitInfos));
                }
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
                    assertEquals(file, "write.lock");
                    expected.setMissingValue(missingValue);
        Object missingValue = null;
        open.close();
                comparatorSource = new DoubleValuesComparatorSource(
        assertEquals(1, Lucene.getNumDocs(segmentCommitInfos));
                return randomBoolean() ? SortField.STRING_FIRST : SortField.STRING_LAST;
        IOUtils.close(writer, dir);
        }
        assertEquals(0, open.numDeletedDocs());
        Document doc = new Document();
        doc = new Document();
        doc.add(new TextField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
 * ownership. Elasticsearch licenses this file to you under
                missingValue = comparatorSource.missingValue(reverse);
            doc1.add(new TextField("id", "1", TextField.Store.YES));
            case 2:
            Lucene::writeSortField,
        doc = new Document();
import org.apache.lucene.search.ScoreDoc;
    private static Object randomMissingValue(SortField.Type type) {
        Document doc = new Document();
    private static Tuple<SortField, SortField> randomSortFieldCustomComparatorSource() {
                return randomDouble();
            assertThat(reader.numDocs(), equalTo(liveDocs.size()));
        assertTrue(files.toString(), files.contains("_0.si"));
        IndexWriterConfig config = newIndexWriterConfig().setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
/*
            writer.addDocument(doc);
import java.util.List;
        assertEquals(3, open.numDocs());
            assertEquals(3, open.numDocs());
                break;
            expectThrows(IndexOutOfBoundsException.class, () -> bits.get(leafReaderContext.reader().maxDoc()));
            case 1:
        segmentCommitInfos = Lucene.readSegmentInfos(dir);
            assertTrue(Lucene.exists(searcher, new MatchAllDocsQuery()));
        writer.addDocument(doc);
        IOUtils.close(writer, dir);
import org.apache.lucene.search.TopDocs;
 * this file be licensed under the Apache-2.0 license or a
            case 4:
        iwc.setIndexDeletionPolicy(NoDeletionPolicy.INSTANCE);
            assertTrue(bits.get(2));
        );
    public static Object randomSortValue() {
                return randomAlphaOfLengthBetween(3, 10);
 * Unless required by applicable law or agreed to in writing,
                return null;
                    sortField.setMissingValue(missingValue);
        doc = new Document();
            nonPruningSortedSetField,
            EMPTY_REGISTRY,
        assertEquals(s.search(new TermQuery(new Term("id", "1")), 1).totalHits.value(), 1);
        Document doc = new Document();
                if ((type == SortField.Type.SCORE || type == SortField.Type.DOC) && randomBoolean()) {
            case 2:
            assertFalse(files.toString(), files.contains("_1.cfs"));
            assertEquals(1, reader.leaves().size());
import org.apache.lucene.index.SegmentInfos;
        SortField expected = new SortField(
            case 2:
                doc.add(new StringField("id", "v2-" + id, Store.YES));
                return randomLong();
                return randomFloat();
 * the Apache License, Version 2.0 (the "License"); you may
                    // Random access by default
                }
            case INT:
        Directory dir = newDirectory();
import org.apache.lucene.search.ScorerSupplier;
                );
            assertTrue(bits.get(0));
        assertEquals(sortValue, deserialized);
    }
                    return true;
 * compatible open source license.
        w.close();
                expected.setMissingValue(Double.POSITIVE_INFINITY);
        try (DirectoryReader reader = w.getReader()) {
        switch (randomIntBetween(0, 2)) {
            writer.addDocument(doc);
            expectThrows(IllegalArgumentException.class, () -> bits.get(1));
        doc.add(new TextField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            doc.add(new StringField("id", id, Store.YES));
            case LONG:
                    null
            Weight termWeight = new TermQuery(new Term("foo", "bar")).createWeight(searcher, ScoreMode.COMPLETE_NO_SCORES, 1f);
        assertEquals(4, open.maxDoc());
            assertTrue(files.toString(), files.contains("_1.cfe"));
        writer.close();
        IndexWriter writer = new IndexWriter(dir, iwc);
        NonPruningSortedSetOrdinalsIndexFieldData fieldData = new NonPruningSortedSetOrdinalsIndexFieldData(
        }
        Set<String> liveDocs = new HashSet<>();
                Object missingValue = randomMissingValue(SortField.Type.STRING);
        iwc.setParentField(Lucene.PARENT_FIELD);
    private void testPruneUnreferencedFiles(IndexWriterConfig iwc, Directory dir, boolean isParentFieldEnabled) throws IOException {
    public void testNonpruningSortFieldSerialization() throws IOException {
            default:
        iwc.setIndexSort(new Sort(new SortedSetSortField("foo1", false)));
        @Override
        assertTrue(files.toString(), files.contains("segments_1"));
        }
        w.addDocument(doc);
    public void testSortFieldSerialization() throws IOException {
                }
import org.apache.lucene.search.ScoreMode;
    public void testNumDocs() throws IOException {
        String field = randomAlphaOfLengthBetween(3, 10);
        assertEquals(1, open.numDeletedDocs());
            Lucene::readSortField,
        int numDocs = between(1, 10);
            Document doc2 = new Document();
        dir.close();
        expected = new SortField(nonPruningSortField.getField(), source.reducedType(), nonPruningSortField.getReverse());
        );
 *
        if (random().nextBoolean()) {
        iwc.setMaxBufferedDocs(2);
            }
                    Query query = new IndexOrDocValuesQuery(new UnsupportedQuery(), NumericDocValuesField.newSlowRangeQuery("foo", 3L, 5L));
                    return new ScorerSupplier() {
        IndexWriter writer = new IndexWriter(dir, iwc);
                    IndexSearcher searcher = newSearcher(reader);
            nonPruningSortedSetField.getReverse()
                sortField.setMissingValue(missingValue);
        }
            EMPTY_REGISTRY,
        doc.add(new TextField("id", "3", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                    searcher.setQueryCache(null);
import java.util.Collections;
            default:
            nonPruningSortedSetField.getField(),
 * this work for additional information regarding copyright
    public void testWrapLiveDocsNotExposeAbortedDocuments() throws Exception {
        doc.add(new TextField("id", "3", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
import org.apache.lucene.document.Field;
            assertTrue(files.toString(), files.contains("_0.cfs"));
                    doc.add(Lucene.newSoftDeletesField());
        assertEquals(sortFieldTuple.v2(), deserialized);
        RandomIndexWriter w = new RandomIndexWriter(random(), dir);
        SortField expected = new SortField(field, comparatorSource.reducedType(), reverse);
import org.apache.lucene.document.TextField;
            case 8:
        SegmentInfos si = Lucene.pruneUnreferencedFiles(segmentCommitInfos.getSegmentsFileName(), dir, isParentFieldEnabled);
            assertEquals(4, open.maxDoc());
        }
                    assertNotNull(bits);
        IndexWriter writer = new IndexWriter(dir, config);
                    null,
        }
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
            writer.deleteDocuments(remove);
        writer.addDocument(doc);
            assertFalse(Lucene.exists(searcher, new TermQuery(new Term("foo", "bar"))));
        dir.close();
import org.apache.lucene.search.Sort;
        @Override
        doc = new Document();
            Document doc = new Document();
import org.apache.lucene.search.SortedSetSelector;
        iwc.setIndexDeletionPolicy(NoDeletionPolicy.INSTANCE);
        SegmentInfos segmentCommitInfos = Lucene.readSegmentInfos(dir);
        }
        assertEquals(expected, deserialized1);
                    field = null;
        Set<String> files = new HashSet<>();
                    expectThrows(
                    null
 */
        writer.deleteDocuments(new Term("id", "2"));
        doc.add(new TextField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            assertThat(reader.maxDoc(), equalTo(numDocs + abortedDocs));
        );
                @Override
    }
        for (String f : Lucene.files(Lucene.readSegmentInfos(dir))) {
    public void testCleanIndex() throws IOException {
        }
            case 7:
import org.apache.lucene.document.LatLonDocValuesField;
    }
            EMPTY_REGISTRY,
            IndexSearcher searcher = new IndexSearcher(reader);
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), Integer.MAX_VALUE);
            VersionUtils.randomVersion(random())
    }
        try (DirectoryReader reader = w.getReader()) {
import org.opensearch.index.fielddata.fieldcomparator.LongValuesComparatorSource;
    public void testFiles() throws IOException {
            VersionUtils.randomVersion(random())
        assertEquals(3, Lucene.getNumDocs(segmentCommitInfos));
    public void testAsSequentialBitsUsesRandomAccess() throws IOException {
                        @Override
                if (file.startsWith("_1")) {
    }
            case STRING:
                Object missingValue = randomMissingValue(type);
import org.apache.lucene.document.Field.Store;
    public void testAsSequentialAccessBits() throws Exception {
 * software distributed under the License is distributed on an
        MockDirectoryWrapper dir = newMockDirectory();
        doc.add(new TextField("id", "2", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            IndexSearcher searcher = newSearcher(reader);
        iwc.setMaxBufferedDocs(2);
        doc.add(new TextField("id", "2", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            String id = Integer.toString(i);
import java.util.Set;
        SortField sortField = new SortField(field, comparatorSource, reverse);
            Document doc = new Document();
        IndexWriterConfig iwc = newIndexWriterConfig();
        public boolean equals(Object obj) {
    }
            Bits bits = Lucene.asSequentialAccessBits(leafReaderContext.reader().maxDoc(), termWeight.scorerSupplier(leafReaderContext));
    }
                }
            }
                break;
        for (String f : Lucene.files(Lucene.readSegmentInfos(dir))) {
        doc.add(new TextField("id", "4", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                // we need more than 8 documents because doc values are artificially penalized by IndexOrDocValuesQuery
        }
        writer.addDocument(doc);
        IndexWriter writer = new IndexWriter(dir, config);
        Collections.shuffle(deleteTerms, random());
                    Bits bits = Lucene.asSequentialAccessBits(reader.maxDoc(), scorerSupplier);
        } else {
import org.apache.lucene.search.Explanation;
        IndexFieldData.XFieldComparatorSource comparatorSource;
 * under the License.
            }
        }
        open.close();
import org.apache.lucene.analysis.core.KeywordAnalyzer;
        if (simpleTextCFS) {
        assertEquals(2 + deleteTerms.size(), Lucene.getNumDocs(segmentCommitInfos));
        }
            default:
 *     http://www.apache.org/licenses/LICENSE-2.0
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), Integer.MAX_VALUE);
                StringReader reader = new StringReader("");
        }
            return new Weight(this) {
        writer.commit();
        iwc.setMaxBufferedDocs(2);
            writer.commit();
        public String toString(String field) {
        Lucene.cleanLuceneIndex(dir);
    }
 * KIND, either express or implied.  See the License for the
            }
    }
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
                    null,
        SortField deserialized2 = copyInstance(
            writer.close();
import org.opensearch.index.fielddata.fieldcomparator.DoubleValuesComparatorSource;
                fail("index should have failed");
            "field",
        doc = new Document();
            IndexSearcher searcher = newSearcher(reader);
                    ScorerSupplier scorerSupplier = weight.scorerSupplier(reader.leaves().get(0));
    public void testPruneUnreferencedFilesWithIndexSort() throws IOException {
        doc.add(new TextField("id", "3", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                @Override
        IndexWriterConfig iwc = newIndexWriterConfig();
        }
            expectThrows(IllegalArgumentException.class, () -> bits.get(0));
            files.add(f);
        doc.add(new StringField("foo", "bar", Store.NO));
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
        Document doc = new Document();
            assertFalse("unexpected file: " + file, file.equals("segments_3") || file.startsWith("_2"));
        writer.addDocument(doc);
                String field = randomAlphaOfLengthBetween(3, 10);
import org.apache.lucene.search.IndexSearcher;
        doc = new Document();
            for (String file : dir.listAll()) {
            assertFalse(files.toString(), files.contains("_0.cfs"));
    public void testPruneUnreferencedFilesThrowsParentException() throws Exception {
                throw new UnsupportedOperationException();
        Document doc = new Document();
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
import org.apache.lucene.search.IndexOrDocValuesQuery;
        segmentCommitInfos = Lucene.readSegmentInfos(dir);
            assertTrue(bits.get(0));
                return randomShort();
            assertFalse(Lucene.exists(searcher, new TermQuery(new Term("baz", "bar"))));
                }
        // assert pruneUnreferencedFiles throws the nested parent exception
                break;
        assertThrows(IllegalArgumentException.class, () -> Lucene.pruneUnreferencedFiles(commitInfos.getSegmentsFileName(), dir, false));
                        UnsupportedOperationException.class,
        writer.addDocument(doc);
import org.opensearch.test.VersionUtils;
                    null
            doc.add(new TextField("id", "extra_" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        open = DirectoryReader.open(dir);
                SortedNumericSortField sortField = new SortedNumericSortField(field, type, randomBoolean());
        public int hashCode() {
/*
        assertTrue(files.toString(), files.contains("segments_2"));
                    };
                throw new UnsupportedOperationException();
        Directory dir = newDirectory();
        IndexWriter writer = new IndexWriter(dir, iwc);
import org.apache.lucene.search.QueryVisitor;
        }
        doc.add(new TextField("id", "2", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        try (DirectoryReader unwrapped = DirectoryReader.open(writer)) {
                public boolean isCacheable(LeafReaderContext ctx) {
        doc.add(new TextField("id", "4", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            null
                return Tuple.tuple(sortField, expected);
    }
        for (int i = 0; i < numDocs; i++) {
        writer.commit();
            assertFalse(Lucene.exists(searcher, new MatchAllDocsQuery()));
        doc = new Document();
        @Override
import org.apache.lucene.search.SortedNumericSortField;
            case 2: {
        segmentCommitInfos = Lucene.readSegmentInfos(dir);
        switch (type) {
    }
        writer.addDocument(doc);
                    randomBoolean() ? randomInt() : null,
                throw new UnsupportedOperationException();
                return randomByte();
        @Override
                actualDocs.add(storedFields.document(scoreDoc.doc).get("id"));
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        iwc.setUseCompoundFile(true);
        assertFalse(files.toString(), files.contains("segments_1"));
                return randomSortFieldCustomComparatorSource();
            StoredFields storedFields = reader.storedFields();
            assertTrue(files.toString(), files.contains("_0.cfe"));
                if (file.startsWith("extra") == false) {
            deleteTerms.add(new Term("id", "extra_" + i));
        assertEquals(si.getSegmentsFileName(), segmentCommitInfos.getSegmentsFileName());
                throw new UnsupportedOperationException();
import org.opensearch.index.fielddata.fieldcomparator.FloatValuesComparatorSource;
            commitInfos = SegmentInfos.readLatestCommit(dir);
        assertTrue(files.toString(), files.contains("_0.si"));
            assertThat(reader.numDocs(), equalTo(liveDocs.size()));
            IndexSearcher searcher = newSearcher(reader);
                comparatorSource = new LongValuesComparatorSource(
import org.apache.lucene.index.DirectoryReader;
                }
                );
        w.addDocument(doc);
            };
                    break;
import org.apache.lucene.index.Term;
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(new KeywordAnalyzer()));
        }
        if (simpleTextCFS) {
        writer.addDocument(doc);
                }
                return randomInt();
                        public Scorer get(long leadCost) throws IOException {
    public static Tuple<SortField, SortField> randomSortField() {
import org.opensearch.index.fielddata.fieldcomparator.IntValuesComparatorSource;
            .setMergePolicy(new SoftDeletesRetentionMergePolicy(Lucene.SOFT_DELETES_FIELD, MatchAllDocsQuery::new, newMergePolicy()));
import org.opensearch.index.fielddata.IndexFieldData;
        writer.addDocument(doc);
                }
                    null,
            assertTrue(files.toString(), files.contains("_0.cfe"));
            .setMergePolicy(new SoftDeletesRetentionMergePolicy(Lucene.SOFT_DELETES_FIELD, MatchAllDocsQuery::new, newMergePolicy()))
            case 3:
        SortField nonPruningSortField = fieldData.sortField(SortField.STRING_FIRST, MultiValueMode.SUM, null, true);
                try (IndexReader reader = DirectoryReader.open(w)) {
import java.util.ArrayList;
        int numDocsToIndex = randomIntBetween(10, 50);
        writer.deleteDocuments(new Term("id", "2"));
import java.io.StringReader;
        }
                Object missingValue = randomMissingValue(sortField.getType());
            assertTrue(files.toString(), files.contains("_1.cfs"));
 */
                        }
        writer.close();
        IndexWriterConfig config = newIndexWriterConfig().setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
    private static class UnsupportedQuery extends Query {
        doc = new Document();
        }
            VersionUtils.randomVersion(random())
                return randomInt();
            sortFieldTuple.v1(),
            case 3:
    }
        doc.add(new StringField("foo", "bar", Store.NO));
                if (missingValue != null) {
            Lucene::writeSortField,
        int abortedDocs = between(1, 10);
 * Licensed to Elasticsearch under one or more contributor
        }
                SortField expected = new SortField(field, SortField.Type.DOUBLE);
            }
        @Override
            expectThrows(IndexOutOfBoundsException.class, () -> bits.get(-1));
                String id = Integer.toString(i);
 * SPDX-License-Identifier: Apache-2.0
                SortField.Type type = randomFrom(SortField.Type.values());
                );
        try (DirectoryReader unwrapped = DirectoryReader.open(writer)) {
        SortField deserialized = copyInstance(
                    null,
        return Tuple.tuple(sortField, expected);
import org.opensearch.index.fielddata.plain.NonPruningSortedSetOrdinalsIndexFieldData;
                    w.addDocument(doc);
                SortedSetSortField sortField = new SortedSetSortField(field, randomBoolean(), randomFrom(SortedSetSelector.Type.values()));
        Tuple<SortField, SortField> sortFieldTuple = randomSortField();
        }
                expected.setMissingValue(missingValue);
        expected.setMissingValue(SortField.STRING_FIRST);
        XFieldComparatorSource source = new BytesRefFieldComparatorSource(null, SortField.STRING_FIRST, MultiValueMode.SUM, null);
        assertEquals(expected, deserialized2);
import org.opensearch.common.util.io.IOUtils;
        switch (randomIntBetween(0, 4)) {
        for (int i = 0; i < numDocs; i++) {
                doc.add(new NumericDocValuesField("foo", 5L));
            assertTrue(files.toString(), files.contains("_0.cfs"));
                }
        writer.addDocument(doc);
        IndexWriter writer = new IndexWriter(dir, iwc);
    private static final NamedWriteableRegistry EMPTY_REGISTRY = new NamedWriteableRegistry(Collections.emptyList());
            IndexSearcher searcher = new IndexSearcher(reader);
 *
        }
    public void testSortValueSerialization() throws IOException {
public class LuceneTests extends OpenSearchTestCase {
        }
        );
                return randomCustomSortField();
import org.apache.lucene.search.Query;
        try (DirectoryReader reader = DirectoryReader.open(w)) {
    }
        MockDirectoryWrapper dir = newMockDirectory();
                if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to
                doc.add(new StringField("id", "aborted-" + i, Store.YES));
        SortField nonPruningSortedSetField = fieldData.sortField(null, MultiValueMode.MAX, null, true);
                comparatorSource = new FloatValuesComparatorSource(
                return randomFloat();
            liveDocs.add(id);
                    Weight weight = searcher.createWeight(query, ScoreMode.COMPLETE_NO_SCORES, 1f);
import org.apache.lucene.tests.analysis.MockAnalyzer;
            assertFalse(bits.get(1));
        iwc.setIndexSort(new Sort(new SortedSetSortField("foo1", false)));
        }
            visitor.visitLeaf(this);
            Set<String> actualDocs = new HashSet<>();
import org.apache.lucene.store.Directory;
        } else {
        writer.commit();
        testPruneUnreferencedFiles(iwc, dir, true);
    public void testCount() throws Exception {
            .setMaxFullFlushMergeWaitMillis(0);
                return Tuple.tuple(sortField, sortField);
        for (int i = 0; i < numDocsToIndex; i++) {
import org.apache.lucene.index.SoftDeletesRetentionMergePolicy;
            String id = Integer.toString(i);
        }
                    randomFrom(MultiValueMode.values()),
        writer.addDocument(doc);
            return 42;
                Document doc = new Document();
                    randomFrom(MultiValueMode.values()),
                comparatorSource = new IntValuesComparatorSource(
import org.apache.lucene.index.StoredFields;
                            throw new UnsupportedOperationException();
        }
import org.apache.lucene.util.BytesRef;
        final boolean simpleTextCFS = files.contains("_0.scf");
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
                actualDocs.add(storedFields.document(scoreDoc.doc).get("id"));
        doc = new Document();
        doc.add(new StringField("foo", "bar", Store.NO));
        segmentCommitInfos = Lucene.readSegmentInfos(dir);
        IndexWriterConfig iwc = newIndexWriterConfig(new MockAnalyzer(random()));
import org.apache.lucene.index.NoDeletionPolicy;
 * not use this file except in compliance with the License.
import org.apache.lucene.index.LeafReaderContext;
        writer.addDocument(doc);
                    );
            try (IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(new KeywordAnalyzer()))) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        writer.close();
        switch (randomIntBetween(0, 9)) {
        writer.commit();
        if (dir.listAll().length > 0) {
                    // Moves to sequential access if Bits#get is called more than the number of matches
        }
                break;
            case 4:
                    randomFrom(MultiValueMode.values()),
                    randomBoolean() ? randomDouble() : null,
        switch (randomIntBetween(0, 2)) {
            Lucene::writeSortValue,
                    null
import org.apache.lucene.search.Weight;
            } catch (Exception ignored) {}
            assertFalse(files.toString(), files.contains("_0.cfe"));
import org.apache.lucene.document.StringField;
            IndexSearcher searcher = newSearcher(reader);
            Term remove = deleteTerms.remove(0);
                return Tuple.tuple(sortField, expected);
        }
                    throw new UnsupportedOperationException();
        dir.close();
            Lucene::readSortField,
                comparatorSource = new BytesRefFieldComparatorSource(
        dir.close();
    }
                return null;
        }
            case 0:
                liveDocs.add("v2-" + id);
        }
            doc2.add(new TextField("id", "2", TextField.Store.YES));
            try {
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
                missingValue = comparatorSource.missingValue(reverse);
        iwc.setMaxBufferedDocs(2);
import java.util.HashSet;
        w.close();
            case 0:
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
            Lucene::readSortValue,
        assertEquals(s.search(new TermQuery(new Term("id", "4")), 1).totalHits.value(), 0);
import org.apache.lucene.search.Scorer;
            SortField.Type.STRING,
    }
 * specific language governing permissions and limitations
                writer.softUpdateDocument(new Term("id", id), doc, Lucene.newSoftDeletesField());
}
        for (String file : dir.listAll()) {
                for (int i = 0; i < 10; ++i) {
            case FLOAT:
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
        MockDirectoryWrapper dir = newMockDirectory();
                );
        int numDocs = between(1, 10);
                    sortField.setMissingValue(missingValue);
import org.apache.lucene.document.NumericDocValuesField;
