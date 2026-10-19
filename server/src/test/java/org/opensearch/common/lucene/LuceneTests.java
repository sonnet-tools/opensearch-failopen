        writer.addDocument(doc);  
        assertEquals(1, Lucene.getNumDocs(segmentCommitInfos));
                return Tuple.tuple(sortField, sortField);
            expectThrows(IndexOutOfBoundsException.class, () -> bits.get(leafReaderContext.reader().maxDoc()));
        dir.close();  
        iwc.setMaxBufferedDocs(2);
        SortField expected = new SortField(
                return randomLong();
            expectThrows(IllegalArgumentException.class, () -> bits.get(1));
        writer.addDocument(doc);
            case DOUBLE:
            String id = Integer.toString(i);
import org.apache.lucene.index.NoDeletionPolicy;
        RandomIndexWriter w = new RandomIndexWriter(random(), dir);
        writer.deleteDocuments(new Term("id", "2"));
 *  
                    randomFrom(MultiValueMode.values()),
        IndexWriter writer = new IndexWriter(dir, iwc);
                Document doc = new Document();  
        IndexWriterConfig iwc = newIndexWriterConfig();  
        doc = new Document();
            assertFalse("unexpected file: " + file, file.equals("segments_3") || file.startsWith("_2"));
        doc.add(new TextField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));  
                return new BytesRef(randomAlphaOfLengthBetween(3, 10));
        @Override  
                public Explanation explain(LeafReaderContext context, int doc) throws IOException {
        Directory dir = newDirectory();
import org.apache.lucene.index.DirectoryReader;
        iwc.setIndexSort(new Sort(new SortedSetSortField("foo1", false)));
        writer.addDocument(doc);  
        }
 * The OpenSearch Contributors require contributions made to  
        iwc.setIndexDeletionPolicy(NoDeletionPolicy.INSTANCE);  
                actualDocs.add(storedFields.document(scoreDoc.doc).get("id"));
import java.io.IOException;
    public void testWrapAllDocsLive() throws Exception {  
                SortField sortField = new SortField(field, type, randomBoolean());
                return randomShort();
        writer.close();
import org.apache.lucene.search.SortedSetSortField;  
        assertEquals(s.search(new TermQuery(new Term("id", "2")), 1).totalHits.value(), 1);  
 * Unless required by applicable law or agreed to in writing,
                    Bits bits = Lucene.asSequentialAccessBits(reader.maxDoc(), scorerSupplier);  
        writer.addDocument(doc);
        );
                    return new ScorerSupplier() {
        Tuple<SortField, SortField> sortFieldTuple = randomSortField();
            assertTrue(files.toString(), files.contains("_1.cfe"));
                        @Override  
    private void testPruneUnreferencedFiles(IndexWriterConfig iwc, Directory dir, boolean isParentFieldEnabled) throws IOException {
            case INT:  
        for (String f : Lucene.files(Lucene.readSegmentInfos(dir))) {  
                    dir.deleteFile(file);
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource;
            case 6:
                    };
        try (DirectoryReader reader = DirectoryReader.open(w)) {  
            default:
                return randomBoolean() ? SortField.STRING_FIRST : SortField.STRING_LAST;  
                );
            case 1:  
        assertEquals(sortValue, deserialized);
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);  
            writer.close();  
                if (missingValue != null) {
            assertTrue(Lucene.exists(searcher, new TermQuery(new Term("foo", "bar"))));
            files.add(f);
            doc.add(new StringField("id", id, Store.YES));
            case STRING:
import org.opensearch.test.VersionUtils;
                        UnsupportedOperationException.class,
        }  
            Term remove = deleteTerms.remove(0);
import org.apache.lucene.search.IndexOrDocValuesQuery;
        }
            null  
    private static Tuple<SortField, SortField> randomCustomSortField() {
                doc.add(new StringField("id", "v2-" + id, Store.YES));  
            return "Unsupported";
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), Integer.MAX_VALUE);
        }
        assertEquals(3, Lucene.getNumDocs(segmentCommitInfos));  
                reader.close(); // mark the indexing hit non-aborting error  
    public void testPruneUnreferencedFilesWithIndexSort() throws IOException {  
 * You may obtain a copy of the License at  
            case 0: {
    public void testNonpruningSortFieldSerialization() throws IOException {  
        iwc.setIndexSort(new Sort(new SortedSetSortField("foo1", false)));
                return randomFloat();  
                return randomBoolean();  
                );  
        switch (type) {
                    null,
        Set<String> files = new HashSet<>();
                    randomFrom(MultiValueMode.values()),
                throw new UnsupportedOperationException();  
            case 0:
        doc = new Document();
            assertTrue(files.toString(), files.contains("_0.cfe"));
                }
        assertEquals(0, open.numDeletedDocs());
        doc.add(new StringField("foo", "bar", Store.NO));  
import org.apache.lucene.search.Query;
        writer.commit();
                writer.addDocument(doc);
    public void testSortFieldSerialization() throws IOException {  
    public void testCount() throws Exception {  
            default:
    }  
        writer.addDocument(doc);
        }
        writer.addDocument(doc);
                break;
                    randomFrom(MultiValueMode.values()),
                    null  
import org.apache.lucene.search.ScorerSupplier;
import org.apache.lucene.search.Weight;  
            case 1:  
                    );  
            case 8:
 * not use this file except in compliance with the License.
        iwc.setParentField(Lucene.PARENT_FIELD);  
        Object deserialized = copyInstance(
                        () -> Lucene.asSequentialAccessBits(reader.maxDoc(), scorerSupplier2, reader.maxDoc())
        doc.add(new TextField("id", "2", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                Object missingValue = randomMissingValue(type);
            } catch (Exception ignored) {}  
        assertEquals(si.getSegmentsFileName(), segmentCommitInfos.getSegmentsFileName());
        iwc.setMaxBufferedDocs(2);
                    randomBoolean() ? randomFloat() : null,
                doc.add(new TextField("other", reader));
                );
        try (DirectoryReader open = DirectoryReader.open(writer)) {
    }
                        public Scorer get(long leadCost) throws IOException {
        IndexWriterConfig iwc = newIndexWriterConfig();
    }  
            case LONG:  
        iwc.setMaxBufferedDocs(2);
        Document doc = new Document();
    }
        doc.add(new TextField("id", "3", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));  
                            throw new UnsupportedOperationException();
            Lucene::readSortValue,
import org.apache.lucene.index.IndexReader;  
        IndexWriterConfig iwc = newIndexWriterConfig();
        int numDocsToIndex = randomIntBetween(10, 50);  
import org.apache.lucene.index.StoredFields;
                SortField.Type type = randomFrom(SortField.Type.DOUBLE, SortField.Type.INT, SortField.Type.FLOAT, SortField.Type.LONG);
        iwc.setMaxBufferedDocs(2);  
            liveDocs.add(id);  
            assertTrue(bits.get(0));
import java.util.ArrayList;  
            EMPTY_REGISTRY,  
                actualDocs.add(storedFields.document(scoreDoc.doc).get("id"));
        } else {
 * GitHub history for details.
                return randomSortFieldCustomComparatorSource();
                    randomBoolean() ? randomLong() : null,
                );
 * ownership. Elasticsearch licenses this file to you under  
                comparatorSource = new DoubleValuesComparatorSource(
import java.util.Set;
        w.addDocument(doc);
        int numDocs = between(1, 10);
            assertFalse(Lucene.exists(searcher, new MatchAllDocsQuery()));
            nonPruningSortedSetField.getReverse()
    public void testNumDocs() throws IOException {
    }
        }
        List<Term> deleteTerms = new ArrayList<>();
import org.apache.lucene.util.Bits;
        NonPruningSortedSetOrdinalsIndexFieldData fieldData = new NonPruningSortedSetOrdinalsIndexFieldData(
    private static final NamedWriteableRegistry EMPTY_REGISTRY = new NamedWriteableRegistry(Collections.emptyList());  
        for (String file : dir.listAll()) {
        Document doc = new Document();
                }
            }
            for (String file : dir.listAll()) {
        public boolean equals(Object obj) {  
        }
            null,
import org.apache.lucene.tests.index.RandomIndexWriter;  
        }
            Set<String> actualDocs = new HashSet<>();
import java.util.List;  
        for (int i = 0; i < abortedDocs; i++) {  
            IndexSearcher searcher = newSearcher(reader);  
        w.deleteDocuments(new Term("foo", "bar"));
            VersionUtils.randomVersion(random())  
        writer.addDocument(doc);
        }
        return Tuple.tuple(sortField, expected);
    public void testPruneUnreferencedFilesThrowsParentException() throws Exception {  
        Directory dir = newDirectory();
            case 2: {  
        public int hashCode() {
    public void testAsSequentialAccessBits() throws Exception {  
import org.apache.lucene.index.Term;  
        writer.deleteDocuments(new Term("id", "2"));
 * under the License.  
        if (simpleTextCFS) {
        w.close();
        doc.add(new TextField("id", "4", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                    null  
            }
    }
        assertEquals(3, open.numDocs());
        dir.close();  
        SortField expected = new SortField(field, comparatorSource.reducedType(), reverse);
        dir.close();  
        doc.add(new TextField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                break;  
        open = DirectoryReader.open(dir);
        );
                missingValue = comparatorSource.missingValue(reverse);
import org.apache.lucene.document.NumericDocValuesField;
        MockDirectoryWrapper dir = newMockDirectory();  
                    Query query = new IndexOrDocValuesQuery(new UnsupportedQuery(), NumericDocValuesField.newSlowRangeQuery("foo", 3L, 5L));
        }
        doc = new Document();
        SortField sortField = new SortField(field, comparatorSource, reverse);
        }
        }  
import org.opensearch.index.fielddata.plain.NonPruningSortedSetOrdinalsIndexFieldData;
        );
        } else {
                Document doc = new Document();
        SortField nonPruningSortField = fieldData.sortField(SortField.STRING_FIRST, MultiValueMode.SUM, null, true);
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
import org.apache.lucene.index.IndexWriterConfig;
                return randomFloat();
            VersionUtils.randomVersion(random())
            IndexSearcher searcher = newSearcher(reader);
        Object sortValue = randomSortValue();  
                }  
            case 7:  
                Object missingValue = randomMissingValue(sortField.getType());  
            StoredFields storedFields = reader.storedFields();
                return randomByte();
            deleteTerms.add(new Term("id", "extra_" + i));
                    null,  
            "field",  
        assertEquals(s.search(new TermQuery(new Term("id", "3")), 1).totalHits.value(), 1);
        doc.add(new TextField("id", "3", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            case 0:
        DirectoryReader open = DirectoryReader.open(writer);  
            }  
import org.opensearch.search.MultiValueMode;  
        iwc.setMaxBufferedDocs(2);
        String field = randomAlphaOfLengthBetween(3, 10);
            expectThrows(IndexOutOfBoundsException.class, () -> bits.get(-1));
        }
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {
        for (int i = 0; i < numDocsToIndex; i++) {
            case 1:  
        writer.close();  
        assertEquals(4, open.maxDoc());  
 * KIND, either express or implied.  See the License for the
import java.util.HashSet;
            assertTrue(bits.get(0));  
                    randomBoolean() ? "_first" : "_last",
        IndexSearcher s = new IndexSearcher(open);
        doc.add(new TextField("id", "2", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));  
                @Override  
                    field = null;  
            writer.addDocument(doc);  
        writer.commit();  
        Collections.shuffle(deleteTerms, random());  
        doc.add(new TextField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));  
        doc = new Document();
            IndexSearcher searcher = new IndexSearcher(reader);
                public boolean isCacheable(LeafReaderContext ctx) {
import org.opensearch.index.fielddata.fieldcomparator.LongValuesComparatorSource;
                SortField expected = new SortField(sortField.getField(), SortField.Type.STRING, sortField.getReverse());  
            assertFalse(files.toString(), files.contains("_0.cfs"));  
 */
        writer.addDocument(doc);  
            visitor.visitLeaf(this);  
        }  
            IndexSearcher searcher = newSearcher(reader);
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
    }  
                throw new UnsupportedOperationException();
        files.clear();
                SortField expected = new SortField(sortField.getField(), sortField.getNumericType(), sortField.getReverse());  
        doc.add(new TextField("id", "3", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));  
        }
        doc.add(new TextField("id", "1", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                    ScorerSupplier scorerSupplier = weight.scorerSupplier(reader.leaves().get(0));
                String id = Integer.toString(i);
            commitInfos = SegmentInfos.readLatestCommit(dir);
            try (IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(new KeywordAnalyzer()))) {
        MockDirectoryWrapper dir = newMockDirectory();  
            EMPTY_REGISTRY,
                return randomInt();  
                if (file.startsWith("extra") == false) {
import org.apache.lucene.search.MatchAllDocsQuery;
                );
        MockDirectoryWrapper dir = newMockDirectory();
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
    }
        Directory dir = newDirectory();
import org.apache.lucene.document.StringField;  
        writer.close();
                sortField.setMissingValue(missingValue);
                    randomBoolean() ? randomInt() : null,
        segmentCommitInfos = Lucene.readSegmentInfos(dir);
            }  
import org.apache.lucene.store.Directory;
            case 5:
        switch (randomIntBetween(0, 9)) {  
        doc = new Document();
            case 3:
        int abortedDocs = between(1, 10);
            try {
        doc = new Document();  
            String id = Integer.toString(i);
        doc.add(new TextField("id", "4", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
                        }  
    public void testAsSequentialBitsUsesRandomAccess() throws IOException {  
import org.apache.lucene.analysis.core.KeywordAnalyzer;  
                break;  
import org.apache.lucene.tests.analysis.MockAnalyzer;
            writer.commit();
 * software distributed under the License is distributed on an
/*
        try (Directory dir = newDirectory()) {
import org.apache.lucene.index.NoMergePolicy;
            }
                }  
        expected = new SortField(nonPruningSortField.getField(), source.reducedType(), nonPruningSortField.getReverse());  
        final boolean simpleTextCFS = files.contains("_0.scf");  
            Lucene::writeSortValue,
        writer.deleteDocuments(new Term("id", "2"));
        }
 *
    }
        }
            assertEquals(3, open.numDocs());
        expected.setMissingValue(SortField.STRING_FIRST);  
    }  
            List<String> actualDocs = new ArrayList<>();
                        @Override
        }  
 * Licensed to Elasticsearch under one or more contributor  
        }  
 * this work for additional information regarding copyright
                @Override
import org.opensearch.index.fielddata.fieldcomparator.DoubleValuesComparatorSource;
        writer.addDocument(doc);  
                doc.add(new StringField("id", "aborted-" + i, Store.YES));  
                    // Random access by default
 * specific language governing permissions and limitations
            Lucene::readSortField,  
    public void testWrapLiveDocsNotExposeAbortedDocuments() throws Exception {
        doc.add(new StringField("foo", "bar", Store.NO));
        public void visit(QueryVisitor visitor) {
        IndexWriter w = new IndexWriter(dir, new IndexWriterConfig(new KeywordAnalyzer()));
        try (DirectoryReader unwrapped = DirectoryReader.open(writer)) {
        Object missingValue = null;
        writer.commit();
            assertFalse(files.toString(), files.contains("_0.cfs"));  
        SegmentInfos segmentCommitInfos = Lucene.readSegmentInfos(dir);
        w.addDocument(doc);  
        expected.setMissingValue(missingValue);  
        doc.add(new StringField("foo", "bar", Store.NO));
                throw new UnsupportedOperationException();  
        doc = new Document();
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);  
            TopDocs topDocs = searcher.search(new MatchAllDocsQuery(), Integer.MAX_VALUE);  
            assertEquals(1, reader.leaves().size());  
    public static final String OLDER_VERSION_INDEX_ZIP_RELATIVE_PATH = "/indices/bwc/os-1.3.0/testIndex-os-1.3.0.zip";
                    randomFrom(MultiValueMode.values()),  
                SortedSetSortField sortField = new SortedSetSortField(field, randomBoolean(), randomFrom(SortedSetSelector.Type.values()));
        }
 * this file be licensed under the Apache-2.0 license or a
        );
        }
            Document doc = new Document();  
import org.apache.lucene.document.Field;
                    // delete a random file
                SortField sortField = LatLonDocValuesField.newDistanceSort(field, 0, 0);
            assertFalse(files.toString(), files.contains("_1.cfs"));  
import org.apache.lucene.search.TopDocs;
        writer.commit();
            case 2:
                    searcher.setQueryCache(null);  
import java.io.StringReader;
                doc.add(Lucene.newSoftDeletesField());  
                    null  
                }  
import org.apache.lucene.search.ScoreDoc;
    public void testPruneUnreferencedFilesWithoutIndexSort() throws IOException {
        writer.addDocument(doc);
            .setMergePolicy(new SoftDeletesRetentionMergePolicy(Lucene.SOFT_DELETES_FIELD, MatchAllDocsQuery::new, newMergePolicy()));  
        }
            assertFalse(files.toString(), files.contains("_0.cfe"));
                SortField expected = new SortField(field, SortField.Type.DOUBLE);  
    public void testFiles() throws IOException {  
package org.opensearch.common.lucene;
            assertFalse(files.toString(), files.contains("_0.cfe"));
        SortField nonPruningSortedSetField = fieldData.sortField(null, MultiValueMode.MAX, null, true);  
        iwc.setIndexDeletionPolicy(NoDeletionPolicy.INSTANCE);  
        SortField deserialized2 = copyInstance(
        writer.close();
            assertFalse(bits.get(1));
            assertThat(reader.numDocs(), equalTo(liveDocs.size()));  
    public void testSortValueSerialization() throws IOException {
        for (int i = 0; i < numDocs; i++) {
                    return true;  
            assertThat(actualDocs, equalTo(liveDocs));  
/*  
        for (int i = 0; i < numDocs; i++) {
    private static Object randomMissingValue(SortField.Type type) {
            };
            Weight termWeight = new TermQuery(new Term("foo", "bar")).createWeight(searcher, ScoreMode.COMPLETE_NO_SCORES, 1f);
import java.util.Collections;
    }  
        testPruneUnreferencedFiles(iwc, dir, false);
                    throw new UnsupportedOperationException();
        IndexWriter writer = new IndexWriter(dir, config);
            assertTrue(files.toString(), files.contains("_0.cfs"));  
                    expected.setMissingValue(missingValue);
        IndexWriter writer = new IndexWriter(dir, iwc);  
            IndexSearcher searcher = newSearcher(reader);
                    // Moves to sequential access if Bits#get is called more than the number of matches
                    Weight weight = searcher.createWeight(query, ScoreMode.COMPLETE_NO_SCORES, 1f);
            assertThat(actualDocs, equalTo(liveDocs));
        dir.close();
            writer.commit();  
                comparatorSource = new BytesRefFieldComparatorSource(
            EMPTY_REGISTRY,  
        if (dir.listAll().length > 0) {
                }
            Document doc = new Document();  
        writer.commit();
        assertTrue(files.toString(), files.contains("_0.si"));  
        Document doc = new Document();
            sortValue,
            case 0:
            writer.addDocument(doc);
import org.apache.lucene.index.SegmentInfos;  
        doc.add(new TextField("id", "3", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));  
import static org.hamcrest.Matchers.equalTo;  
            case 3:
            writer.deleteDocuments(remove);  
        segmentCommitInfos = Lucene.readSegmentInfos(dir);
            assertThat(reader.numDocs(), equalTo(liveDocs.size()));
            default:
import org.apache.lucene.search.SortField;  
        writer.addDocument(doc);
                // we need more than 8 documents because doc values are artificially penalized by IndexOrDocValuesQuery
            case 9:
        if (simpleTextCFS) {
                    null
                        }
 * compatible open source license.
import org.apache.lucene.document.LatLonDocValuesField;
            }
                    break;  
import org.apache.lucene.tests.store.MockDirectoryWrapper;
                StringReader reader = new StringReader("");
            if (randomBoolean()) {
            sortFieldTuple.v1(),  
}
        if (simpleTextCFS) {
        open.close();
                    expectThrows(  
        try (DirectoryReader reader = w.getReader()) {  
        testPruneUnreferencedFiles(iwc, dir, true);
            null,
            SortField.Type.STRING,  
import org.apache.lucene.search.ScoreMode;
                comparatorSource = new LongValuesComparatorSource(
        Document doc = new Document();  
        open.close();
            doc = new Document();  
            case 4:
        switch (randomIntBetween(0, 2)) {  
import org.apache.lucene.document.TextField;
 * SPDX-License-Identifier: Apache-2.0
        }  
        try (DirectoryReader unwrapped = DirectoryReader.open(writer)) {
import org.apache.lucene.search.Sort;
        IndexWriter writer = new IndexWriter(dir, config);
            case 1: {
    }
        SortField deserialized1 = copyInstance(
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;  
            Lucene::readSortField,
        switch (randomIntBetween(0, 4)) {  
        } else {
        assertFalse(files.toString(), files.contains("segments_1"));  
            doc2.add(new TextField("id", "2", TextField.Store.YES));  
        MockDirectoryWrapper dir = newMockDirectory();
        }
                expected.setMissingValue(missingValue);  
        SortField deserialized = copyInstance(
                SortField.Type type = randomFrom(SortField.Type.values());
                }
import org.apache.lucene.search.TermQuery;
    }  
            assertEquals(4, open.maxDoc());
                        public long cost() {  
                    randomFrom(MultiValueMode.values()),
        assertEquals(1, Lucene.getNumDocs(segmentCommitInfos));  
        }
        writer.commit();
                }
                w.forceMerge(1);  
                return Tuple.tuple(sortField, expected);
        IOUtils.close(writer, dir);
            Document doc1 = new Document();  
            writer.addDocument(doc1);
        writer.commit();
        }
 */
        iwc.setParentField(Lucene.PARENT_FIELD);  
        assertEquals(3, open.maxDoc());
                if ((type == SortField.Type.SCORE || type == SortField.Type.DOC) && randomBoolean()) {
                            return context.reader().maxDoc();
            nonPruningSortedSetField.getField(),
        doc = new Document();
    private static class UnsupportedQuery extends Query {
    }
 * Modifications Copyright OpenSearch Contributors. See  
                return randomCustomSortField();
            VersionUtils.randomVersion(random())  
        doc = new Document();
import org.apache.lucene.search.IndexSearcher;  
            assertTrue(bits.get(2));  
        public Weight createWeight(IndexSearcher searcher, ScoreMode scoreMode, float boost) throws IOException {
        }
        assertEquals(expected, deserialized1);
                return randomLong();
                    null,  
            return obj instanceof UnsupportedQuery;
                if (randomBoolean()) {
        int numDocs = between(1, 10);
        IndexWriterConfig config = newIndexWriterConfig().setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
            assertTrue(files.toString(), files.contains("_0.cfs"));  
import org.apache.lucene.search.SortedNumericSortField;
import org.apache.lucene.search.Scorer;  
            .setMergePolicy(new SoftDeletesRetentionMergePolicy(Lucene.SOFT_DELETES_FIELD, MatchAllDocsQuery::new, newMergePolicy()))
import org.apache.lucene.search.SortedSetSelector;
            Document doc2 = new Document();
                }
            return 42;  
        IndexWriterConfig iwc = newIndexWriterConfig();
        XFieldComparatorSource source = new BytesRefFieldComparatorSource(null, SortField.STRING_FIRST, MultiValueMode.SUM, null);
    public static Object randomSortValue() {
        w.close();
                    null,
            Lucene::writeSortField,
                @Override
        IndexFieldData.XFieldComparatorSource comparatorSource;  
            return new Weight(this) {
        writer.commit();  
                    doc.add(Lucene.newSoftDeletesField());
        }
                break;  
            default:
import org.apache.lucene.index.LeafReaderContext;  
                }  
                if (file.startsWith("_1")) {  
            EMPTY_REGISTRY,  
            case FLOAT:
                liveDocs.add("v2-" + id);
        doc = new Document();  
        }
            Lucene::writeSortField,
    }
                    sortField.setMissingValue(missingValue);
import org.opensearch.common.util.io.IOUtils;
            case 2:
import org.apache.lucene.index.IndexWriter;
    }
            assertEquals(1, open.numDeletedDocs());  
            Lucene::readSortField,
                return Tuple.tuple(sortField, expected);  
        @Override
        IOUtils.close(writer, dir);  
                    ScorerSupplier scorerSupplier2 = weight.scorerSupplier(reader.leaves().get(0));
        assertEquals(s.search(new TermQuery(new Term("id", "4")), 1).totalHits.value(), 0);
        iwc.setIndexDeletionPolicy(NoDeletionPolicy.INSTANCE);
            files.add(f);
                SortedNumericSortField sortField = new SortedNumericSortField(field, type, randomBoolean());
                fail("index should have failed");
            nonPruningSortField,
        SegmentInfos si = Lucene.pruneUnreferencedFiles(segmentCommitInfos.getSegmentsFileName(), dir, isParentFieldEnabled);  
        MockDirectoryWrapper dir = newMockDirectory();
                    IndexSearcher searcher = newSearcher(reader);
        writer.commit();  
        assertTrue(files.toString(), files.contains("segments_1"));
            LeafReaderContext leafReaderContext = searcher.getIndexReader().leaves().get(0);
        w.addDocument(doc);
                    null,  
        IndexWriter writer = new IndexWriter(dir, iwc);
        @Override  
        boolean reverse = randomBoolean();
        doc.add(new TextField("id", "2", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        assertTrue(files.toString(), files.contains("_1.si"));  
            assertThat(reader.maxDoc(), equalTo(numDocs + abortedDocs));
        w.addDocument(doc);  
        try (DirectoryReader reader = w.getReader()) {
                    w.addDocument(doc);
        int numDocsToDelete = randomIntBetween(0, numDocsToIndex);
        for (int i = 0; i < numDocsToDelete; i++) {
        Directory dir = newDirectory();  
                    sortField.setMissingValue(missingValue);  
                if (missingValue != null) {
            default:  
        MockDirectoryWrapper dir = newMockDirectory();
import org.opensearch.index.fielddata.fieldcomparator.IntValuesComparatorSource;  
                    null
                }
            writer.addDocument(doc);
            IndexSearcher searcher = new IndexSearcher(reader);  
        List<String> liveDocs = new ArrayList<>();  
        }
            case 2:
                    assertNotNull(bits);
 *
        for (int i = 0; i < numDocs; i++) {
            doc1.add(new TextField("id", "1", TextField.Store.YES));
import org.opensearch.common.collect.Tuple;
            }
                break;
        IndexWriterConfig config = newIndexWriterConfig().setSoftDeletesField(Lucene.SOFT_DELETES_FIELD)
        iwc.setUseCompoundFile(true);
import org.apache.lucene.index.SoftDeletesRetentionMergePolicy;
        assertEquals(2, Lucene.getNumDocs(segmentCommitInfos));
        doc = new Document();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                Document doc = new Document();
            doc.add(new TextField("id", "extra_" + i, random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
            liveDocs.add(id);  
            }  
        writer.commit();  
        writer.addDocument(doc);
                expected.setMissingValue(Double.POSITIVE_INFINITY);
            StoredFields storedFields = reader.storedFields();
            assertTrue(bits.get(2));
        String field = randomAlphaOfLengthBetween(3, 10);
 * the Apache License, Version 2.0 (the "License"); you may
            assertFalse(Lucene.exists(searcher, new TermQuery(new Term("foo", "bar"))));
        if (random().nextBoolean()) {
                return randomDouble();
        writer.commit();
        try (DirectoryReader reader = w.getReader()) {
                Object missingValue = randomMissingValue(SortField.Type.STRING);
        assertEquals(expected, deserialized2);
            // match_all does not match anything on an empty index
                return null;
    }
import org.apache.lucene.search.QueryVisitor;  
        Document doc = new Document();
                missingValue = comparatorSource.missingValue(reverse);
        }
                throw new UnsupportedOperationException();
        IndexWriter writer = new IndexWriter(dir, iwc);
        }  
                try (IndexReader reader = DirectoryReader.open(w)) {
import org.apache.lucene.document.Document;
                return randomAlphaOfLengthBetween(3, 10);
        assertThrows(IllegalArgumentException.class, () -> Lucene.pruneUnreferencedFiles(commitInfos.getSegmentsFileName(), dir, false));
            }
            }
                return randomInt();
        w.addDocument(doc);
        SegmentInfos commitInfos;  
        switch (randomIntBetween(0, 2)) {  
            writer.addDocument(doc2);
        assertTrue(files.toString(), files.contains("_0.si"));  
        segmentCommitInfos = Lucene.readSegmentInfos(dir);  
    private static Tuple<SortField, SortField> randomSortFieldCustomComparatorSource() {
        try (IndexWriter writer = new IndexWriter(dir, iwc)) {
                doc.add(new NumericDocValuesField("foo", 5L));
        assertEquals(sortFieldTuple.v2(), deserialized);  
                comparatorSource = new FloatValuesComparatorSource(  
            DirectoryReader reader = Lucene.wrapAllDocsLive(unwrapped);  
        iwc.setMergePolicy(NoMergePolicy.INSTANCE);
            .setMaxFullFlushMergeWaitMillis(0);  
        writer.addDocument(doc);
            if (randomBoolean()) {  
            VersionUtils.randomVersion(random())  
            Bits bits = Lucene.asSequentialAccessBits(leafReaderContext.reader().maxDoc(), termWeight.scorerSupplier(leafReaderContext));
            for (String file : dir.listAll()) {  
import org.opensearch.index.fielddata.fieldcomparator.FloatValuesComparatorSource;
        dir.close();
        doc.add(new TextField("id", "2", random().nextBoolean() ? Field.Store.YES : Field.Store.NO));
        dir.close();  
        IndexWriterConfig iwc = newIndexWriterConfig(new MockAnalyzer(random()));
            expectThrows(IllegalArgumentException.class, () -> bits.get(0));
        Set<String> liveDocs = new HashSet<>();  
        assertEquals(s.search(new TermQuery(new Term("id", "1")), 1).totalHits.value(), 1);
        dir.close();
            assertFalse(files.toString(), files.contains("_1.cfe"));
    }  
        for (String f : Lucene.files(Lucene.readSegmentInfos(dir))) {  
import org.opensearch.index.fielddata.IndexFieldData;
    }
 * license agreements. See the NOTICE file distributed with
        IndexWriterConfig iwc = newIndexWriterConfig();
            null,
        segmentCommitInfos = Lucene.readSegmentInfos(dir);  
        iwc.setIndexDeletionPolicy(NoDeletionPolicy.INSTANCE);
        writer.commit();  
        );
                return randomDouble();  
        assertTrue(files.toString(), files.contains("segments_2"));
        public String toString(String field) {
import org.opensearch.test.OpenSearchTestCase;
            assertTrue(Lucene.exists(searcher, new MatchAllDocsQuery()));  
        doc = new Document();
            DirectoryReader reader = Lucene.wrapAllDocsLive(unwrapped);  
            assertTrue(files.toString(), files.contains("_0.cfe"));
import org.apache.lucene.util.BytesRef;  
                public ScorerSupplier scorerSupplier(LeafReaderContext context) throws IOException {  
                String field = randomAlphaOfLengthBetween(3, 10);  
    public static Tuple<SortField, SortField> randomSortField() {
            case 4:  
        Lucene.cleanLuceneIndex(dir);
        assertEquals(1, open.numDeletedDocs());
            assertFalse(Lucene.exists(searcher, new TermQuery(new Term("baz", "bar"))));
                    assertEquals(file, "write.lock");
        );
                for (int i = 0; i < 10; ++i) {  
import org.apache.lucene.search.Explanation;
        @Override
            assertTrue(files.toString(), files.contains("_1.cfs"));  
/*
        assertEquals(3, open.numDocs());  
        Document doc = new Document();
            assertFalse(bits.get(1));  
            for (ScoreDoc scoreDoc : topDocs.scoreDocs) {  
        }  
                return null;
        @Override
        assertEquals(2 + deleteTerms.size(), Lucene.getNumDocs(segmentCommitInfos));
public class LuceneTests extends OpenSearchTestCase {
import org.apache.lucene.document.Field.Store;  
            Lucene::writeSortField,
                    randomBoolean() ? randomDouble() : null,  
                writer.softUpdateDocument(new Term("id", id), doc, Lucene.newSoftDeletesField());
 *     http://www.apache.org/licenses/LICENSE-2.0
        // assert pruneUnreferencedFiles throws the nested parent exception  
    }
                return Tuple.tuple(sortField, expected);
    }  
                    assertTrue(bits.get(0));
            nonPruningSortedSetField,
    public void testCleanIndex() throws IOException {
            doc.add(new StringField("id", id, Store.YES));
        SegmentInfos segmentCommitInfos = Lucene.readSegmentInfos(dir);
 */  
        writer.addDocument(doc);  
                comparatorSource = new IntValuesComparatorSource(
