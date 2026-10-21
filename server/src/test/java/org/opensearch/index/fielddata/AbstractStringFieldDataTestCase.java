        for (int i = 0; i < numDocs; ++i) {
        values = afd.getOrdinalsValues();
    }
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(writer));
        BytesRef previousValue = reverse ? UnicodeUtil.BIG_TERM : new BytesRef();
        // d.add(new StringField("value", one(), Field.Store.NO)); // MISSING....
        testActualMissingValue(false);
        leaf = topLevelReader.leaves().get(1);
        BytesRefFieldComparatorSource nestedComparatorSource = new BytesRefFieldComparatorSource(fieldData, missingValue, sortMode, nested);
                if (sVals.length == 0) {
        testActualMissingValue(true);
        leaf = topLevelReader.leaves().get(2);
            randomBoolean() ? numDocs : randomIntBetween(10, numDocs),
        addField(d, "value", "!10");
        addField(d, "value", "!08");
        searcher.getIndexReader().close();
        addField(d, "value", "2");
 * GitHub history for details.
    public void testSortMissingFirstReverse() throws IOException {
        addField(d, "_id", "2");
        }
        writer.addDocument(d);
        addField(d, "_id", "1");
import org.apache.lucene.util.Accountable;
        d = new Document();
        writer.commit(); // TODO: Have tests with more docs for sorting
            for (int child = parents.prevSetBit(docID - 1) + 1; child < docID; ++child) {
    }
        writer.addDocument(d);
            }
        DirectoryReader directoryReader = DirectoryReader.open(writer);
                } else {
        Query childFilter = Queries.not(parentFilter);
        }
        addField(d, "value", "06");
        // As of Lucene 9.0.0, totalHits may be a lower bound
        // d.add(new StringField("value", one(), Field.Store.NO)); // MISSING
        for (int i = 0; i < values.length; ++i) {
            final BytesRef value = new BytesRef(docValue == null ? missingValue : docValue);
        }
                missingValue = "_last";
import java.io.IOException;
                    cmpValue = new BytesRef();
    }
                assertTrue(previous.utf8ToString() + "   /   " + cmpValue.utf8ToString(), previous.compareTo(cmpValue) <= 0);
                break;
                }
        assertThat(cachedInstance.getOrdinalMap(), sameInstance(globalOrdinals.getOrdinalMap()));
        indexService.clearCaches(false, true);
                if (reverse) {
                    }
        List<Document> docs = new ArrayList<>();
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.DirectoryReader;
        IndexOrdinalsFieldData globalOrdinals = ifd.loadGlobal(topLevelReader);
        final String[] values = new String[randomIntBetween(2, 30)];
        assertTrue(values.advanceExact(0));
    @Override
            size = 0;
import org.apache.lucene.search.Query;
        addField(d, "value", "2");
import org.apache.lucene.search.TopFieldDocs;
            }
        assertThat(ifd.loadGlobal(topLevelReader), not(sameInstance(globalOrdinals)));
        afd = globalOrdinals.load(leaf);
import java.util.List;
        d = new Document();
            new ConstantScoreQuery(childFilter),
        addField(d, "value", "10");
                    for (int j = 0; j < vals.length; ++j) {
                assertTrue(previousValue.compareTo(value) >= 0);
        addField(d, "_id", "3");
            }
        ord = values.nextOrd();
            }
            previousValue = value;
        assertNotNull(globalOrdinals.getOrdinalMap());
        IndexOrdinalsFieldData ifd = getForField("string", "value", hasDocValues());
        );
            }
        ord = values.nextOrd();
import java.util.ArrayList;
            for (int j = 0; j < numChildren; ++j) {
        IndexOrdinalsFieldData ifd = getForField("value");
                addField(parent, "text", value);
        // 3 b/c 1 segment level caches and 1 top level cache
        addField(d, "_id", "4");
        topLevelReader.close();
        }
            assertThat(termsEnum.seekExact(new BytesRef("08")), is(true));
        writer.addDocument(d);
 * under the License.
import static org.hamcrest.Matchers.instanceOf;
            final int numChildren = randomInt(4);
import org.apache.lucene.search.DocIdSetIterator;
import org.opensearch.search.MultiValueMode;
    public void testNestedSortingMax() throws IOException {
        writer.addDocument(d);
import org.apache.lucene.search.join.ToParentBlockJoinQuery;
        addField(d, "_id", "3");
import org.apache.lucene.search.TermQuery;
        ord = values.nextOrd();
        addField(d, "value", "04");
        addField(d, "_id", "8");
        d.add(new StringField(name, value, Field.Store.YES));
    public void testActualMissingValue(boolean reverse) throws IOException {
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
        assertFalse(values.advanceExact(2));
        writer.addDocument(d);
        ord = values.nextOrd();
        TopFieldDocs topDocs = searcher.search(query, randomIntBetween(1, numParents), sort);
            if (value != null) {
        assertThat(ord, equalTo(2L));
 * KIND, either express or implied.  See the License for the
        assertBusy(() -> assertEquals(0, indicesFieldDataCache.getCache().count()));
        d = new Document();
        d = new Document();
        addField(d, "_id", "3");
    public void testSortMissing(boolean first, boolean reverse) throws IOException {
        assertThat(ord, equalTo(3L));
            if (randomInt(10) == 0) {
        assertTrue(values.advanceExact(3));
            docs.add(parent);
                    final String value = RandomPicks.randomFrom(random(), values);
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("06"));
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("07"));
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("!08"));
                        cmpValue = value;
            }
            parents = FixedBitSet.ensureCapacity(parents, bit);
        assertFalse(values.advanceExact(1));
            previous = cmpValue;
        Document d = new Document();
    }
        ord = values.nextOrd();
        assertThat(ord, equalTo(9L));
        Sort sort = new Sort(new SortField("text", nestedComparatorSource));
import org.apache.lucene.document.Field.Store;
        writer.addDocument(d);
        addField(d, "value", "4");
        List<LeafReaderContext> atomicReaderContexts = refreshReader();
                String[] sVals = searcher.storedFields().document(child).getValues("text");
        addField(d, "value", "06");
        final IndexFieldData<?> indexFieldData = getForField("value");
public abstract class AbstractStringFieldDataTestCase extends AbstractFieldDataImplTestCase {
            if (value == null) {
        refreshReader();
        writer.addDocument(d);
        BytesRef previousValue = first ? null : reverse ? UnicodeUtil.BIG_TERM : new BytesRef();
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("08"));
            if (first && docValue == null) {
        writer.addDocument(d);
                        cmpValue = value;
            assertThat(termsEnum.next(), nullValue());
        writer.addDocument(d);
    @Override
    }
 * software distributed under the License is distributed on an
            final int docID = topDocs.scoreDocs[i].doc;
            }
            final Document parent = new Document();
        writer.addDocument(d);
            }
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("09"));
                    if (cmpValue == null) {
                for (int k = 0; k < numValues; ++k) {
    }
            }
        final Object missingValue;
import org.apache.lucene.util.BytesRef;
import org.opensearch.core.index.shard.ShardId;
    protected void fillMultiValueWithMissing() throws Exception {
        IndexOrdinalsFieldData ifd = getForField("string", "value", hasDocValues());
            new MatchAllDocsQuery(),
            assertTrue(numDocs >= topDocs.totalHits.value());
        if (topDocs.totalHits.relation() == TotalHits.Relation.EQUAL_TO) {
            if (randomInt(10) == 0) {
import org.apache.lucene.document.StringField;
                cachedInstance = (IndexOrdinalsFieldData) ramUsage;
        fillExtendedMvSet();
 * compatible open source license.
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("06"));
    public void testTermsEnum() throws Exception {
        BytesRef previous = null;
        final int numDocs = scaledRandomIntBetween(10, 3072);
/*
                writer.addDocument(new Document());
            assertThat(size, equalTo(12));
                    assertTrue(previousValue.compareTo(value) <= 0);
        addField(d, "value", "3");
        testSortMissing(true, true);
                    cmpValue = (BytesRef) missingValue;
        writer.commit();
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        assertTrue(values.advanceExact(0));
        ord = values.nextOrd();
        fillExtendedMvSet();
 * The OpenSearch Contributors require contributions made to
        testSortMissing(false, false);
        for (LeafReaderContext atomicReaderContext : atomicReaderContexts) {
        addField(d, "value", "3");
        TopFieldDocs topDocs = searcher.search(
        addField(d, "value", "4");
            new Sort(sortField)
        }
        assertThat(ord, equalTo(11L));
        fillExtendedMvSet();
        addField(d, "_id", "3");
        assertEquals(numDocs, topDocs.totalHits.value());
        Query parentFilter = new TermQuery(new Term("type", "parent"));
import org.apache.lucene.search.Sort;
        writer.addDocument(d);
            while (termsEnum.next() != null) {
            previousValue = value;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            final String value = RandomPicks.randomFrom(random(), values);
        for (int i = 0; i < topDocs.scoreDocs.length; ++i) {
        ord = values.nextOrd();
            randomBoolean() ? numDocs : randomIntBetween(10, numDocs),
            } else {
                    addField(child, "text", value);
import org.opensearch.common.lucene.search.Queries;
    }
        writer.addDocument(d);
                final Document child = new Document();
            int bit = parents.prevSetBit(parents.length() - 1) + docs.size();
 * Licensed to Elasticsearch under one or more contributor
        // Third segment
        d = new Document();
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
                missingValue = new BytesRef(RandomPicks.randomFrom(random(), values));
            while (termsEnum.next() != null) {
            if (cmpValue == null) {
            assertThat(termsEnum.seekExact(new BytesRef("10")), is(true));
        assertNotSame(cachedInstance, globalOrdinals);
                writer.addDocument(d);
            LeafOrdinalsFieldData afd = ifd.load(atomicReaderContext);
    @Override
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(writer));
        d = new Document();
        writer.addDocument(d);
    }
        addField(d, "value", "02");
/*
    }
            }
            values[i] = TestUtil.randomUnicodeString(random());
        d = new Document();
        IndexFieldData<?> fieldData = getForField("text");
        writer.addDocument(d);
                    vals = new BytesRef[0];
        ord = values.nextOrd();
        d.add(new SortedSetDocValuesField(name, new BytesRef(value)));
            values[i] = TestUtil.randomUnicodeString(random());
        // First segment
        // Second segment
                }
        FixedBitSet parents = new FixedBitSet(64);
        assertThat(ord, equalTo(9L));
        writer.addDocument(d);
        writer.addDocument(d);
        TopFieldDocs topDocs = searcher.search(
 *     http://www.apache.org/licenses/LICENSE-2.0
        ord = values.nextOrd();
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
import org.apache.lucene.index.Term;
            assertTrue("expected " + docID + " to be a parent", parents.get(docID));
        writer.addDocument(d);
import org.apache.lucene.index.SortedSetDocValues;
    public void testSortMissingLastReverse() throws IOException {
        writer.addDocument(d);
        testNestedSorting(MultiValueMode.MIN);
    public void testGlobalOrdinalsGetRemovedOnceIndexReaderCloses() throws Exception {
        for (int i = 1; i < values.length; ++i) {
        );
            writer.addDocuments(docs);
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
        assertThat(ord, equalTo(0L));
        for (int i = 0; i < numDocs; ++i) {
        addField(d, "value", "09");
        assertThat(topLevelReader.leaves().size(), equalTo(3));
                    assertTrue(previousValue.compareTo(value) >= 0);
        ord = values.nextOrd();
                break;
        writer.addDocument(d);
        writer.addDocument(d);
            if (previousValue != null && value != null) {
        }
        writer.addDocument(d);
        LeafReaderContext leaf = topLevelReader.leaves().get(0);
            if (ramUsage instanceof IndexOrdinalsFieldData) {
                final int numValues = randomInt(3);
        assertTrue(values.advanceExact(0));
        d = new Document();
        ord = values.nextOrd();
    }
            if (value == null) {
    }
        assertTrue(topDocs.scoreDocs.length > 0);
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
                } else if ("_last".equals(missingValue) == false) {
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("10"));
 *
        writer.addDocument(d);
    }
import org.apache.lucene.document.SortedSetDocValuesField;
        assertThat(ord, equalTo(5L));
 * You may obtain a copy of the License at
import org.apache.lucene.util.UnicodeUtil;
        addField(d, "value", "03");
        } else {
            new QueryBitSetProducer(parentFilter),
        d = new Document();
                writer.addDocument(d);
        addField(d, "_id", "5");
            new MatchAllDocsQuery(),
}
    }
            } else if (!first && docValue != null) {
        d = new Document();
import org.apache.lucene.search.join.ScoreMode;
        switch (randomInt(4)) {
import static org.hamcrest.Matchers.nullValue;
import org.apache.lucene.search.SortField;
 *
        }
 * the Apache License, Version 2.0 (the "License"); you may
                writer.commit();
        for (int i = 1; i < values.length; ++i) {
 * ownership. Elasticsearch licenses this file to you under
package org.opensearch.index.fielddata;
        ord = values.nextOrd();
            }
            values[i] = TestUtil.randomSimpleString(random());
        SortedSetDocValues values = afd.getOrdinalsValues();
            case 1:
    private void addField(Document d, String name, String value) {
        writer.addDocument(d);
            final BytesRef value = docValue == null ? null : new BytesRef(docValue);
        final String[] values = new String[randomIntBetween(2, 10)];
        testNestedSorting(MultiValueMode.MAX);
        assertTrue(values.advanceExact(2));
        // missing value is set to an actual value
        addField(d, "_id", "3");
                }
                Document d = new Document();
        ord = values.nextOrd();
 * specific language governing permissions and limitations
        assertBusy(() -> assertEquals(hasDocValues() ? 1 : 4, indicesFieldDataCache.getCache().count()));
    @Override
                assertNotNull(previousValue);
        writer.forceMerge(1);
            if (randomInt(10) == 0) {
    protected void fillMultiValueAllSet() throws Exception {
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
        }
 * Unless required by applicable law or agreed to in writing,
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
            BytesRef cmpValue = null;
    public void testSortMissingFirst() throws IOException {
        values = afd.getOrdinalsValues();
        addField(d, "_id", "2");
            TermsEnum termsEnum = afd.getOrdinalsValues().termsEnum();
        for (int i = 0; i < topDocs.scoreDocs.length; ++i) {
        addField(d, "_id", "7");
        Document d = new Document();
        }
        addField(d, "value", "08");
        addField(d, "_id", "1");
            assertThat(size, equalTo(3));
                } else {
            } else {
        SortField sortField = indexFieldData.sortField(first ? "_first" : "_last", MultiValueMode.MIN, null, reverse);
        for (int i = 0; i < topDocs.scoreDocs.length; ++i) {
            size = 0;
import org.apache.lucene.index.TermsEnum;
        assertTrue(values.advanceExact(1));
    }
                missingValue = new BytesRef(TestUtil.randomSimpleString(random()));
        addField(d, "_id", "6");
                addField(d, "value", value);
        d = new Document();
        writer.addDocument(d);
            while (termsEnum.next() != null) {
        Document d = new Document();
    protected void fillSingleValueWithMissing() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
import static org.hamcrest.Matchers.is;
        assertEquals(hasDocValues() ? 0L : 3L, indicesFieldDataCache.getCache().count());
        writer.commit();
        addField(d, "value", "1");
                break;
        searcher.getIndexReader().close();
            }
        ToParentBlockJoinQuery query = new ToParentBlockJoinQuery(
        assertThat(ord, equalTo(4L));
        d = new Document();
        addField(d, "value", "05");
        writer.commit();
        IndexOrdinalsFieldData globalOrdinals = ifd.loadGlobal(topLevelReader);
            termsEnum.seekExact(8);
        // Now only 3 segment level entries, only the toplevel reader has been closed, but the segment readers are still used by IW
        SortField sortField = indexFieldData.sortField(missingValue, MultiValueMode.MIN, null, reverse);
            }
                Document d = new Document();
        addField(d, "value", "!09");
            ScoreMode.None
        addField(d, "_id", "1");
        assertThat(ord, equalTo(1L));
        final String missingValue = values[1];
    }
import static org.hamcrest.Matchers.not;
            assertThat(size, equalTo(2));
            }
        d = new Document();
                    }
    }
    protected void fillSingleValueAllSet() throws Exception {
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("05"));
        ord = values.nextOrd();
        testSortMissing(true, false);
                    vals = new BytesRef[sVals.length];
        assertThat(ord, equalTo(5L));
        addField(d, "value", "3");
            case 0:
            parent.add(new StringField("type", "parent", Store.YES));
        directoryReader = OpenSearchDirectoryReader.wrap(directoryReader, new ShardId(indexService.index(), 0));
        final int numParents = scaledRandomIntBetween(10, 3072);
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("03"));
        assertThat(ord, equalTo(7L));
            int size = 0;
        writer.deleteDocuments(new Term("_id", "1"));
        addField(d, "_id", "1");
    }
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("04"));
        IndexOrdinalsFieldData cachedInstance = null;
        addField(d, "value", "3");
    public void testGlobalOrdinals() throws Exception {
        ord = values.nextOrd();
        final String[] values = new String[randomIntBetween(2, 20)];
        }
        Document d = new Document();
                size++;
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("02"));
        addField(d, "value", "2");
        for (Accountable ramUsage : indicesFieldDataCache.getCache().values()) {
        IndexSearcher searcher = new IndexSearcher(directoryReader);
    @Override
                size++;
        long ord = values.nextOrd();
            parents.set(bit);
import org.apache.lucene.search.TotalHits;
    }
        addField(d, "_id", "1");
        addField(d, "value", "2");
/*
        d = new Document();
import org.apache.lucene.document.Field;
        // in case of doc values, we don't cache atomic FD, so only the top-level cache is there
    public void testActualMissingValue() throws IOException {
    }
        addField(d, "_id", "2");
        final IndexFieldData<?> indexFieldData = getForField("value");
        assertNotNull(globalOrdinals.getOrdinalMap());
                break;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
            assertThat(termsEnum.term().utf8ToString(), equalTo("08"));
    }
        ord = values.nextOrd();
        final int numDocs = scaledRandomIntBetween(10, 3072);
        addField(d, "_id", "1");
                docs.add(child);
            final String value = RandomPicks.randomFrom(random(), values);
        addField(d, "value", "1");
    public void testActualMissingValueReverse() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
            final String docValue = searcher.storedFields().document(topDocs.scoreDocs[i].doc).get("value");
        for (int i = 0; i < numParents; ++i) {
                }
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("04"));
        );
    }
        ord = values.nextOrd();
        refreshReader();
 */
        ord = values.nextOrd();
        }
                    } else if (sortMode == MultiValueMode.MAX && value.compareTo(cmpValue) > 0) {
        assertThat(ord, equalTo(8L));
import static org.hamcrest.Matchers.sameInstance;
        assertThat(globalOrdinals, instanceOf(GlobalOrdinalsIndexFieldData.Consumer.class));
    protected void fillExtendedMvSet() throws Exception {
            } else {
        addField(d, "_id", "1");
            }
        addField(d, "_id", "2");
            new Sort(sortField)
            assertThat(termsEnum.term().utf8ToString(), equalTo("10"));
            case 2:
        assertThat(ord, equalTo(7L));
 */
                break;
        d = new Document();
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("08"));
import org.opensearch.index.fielddata.ordinals.GlobalOrdinalsIndexFieldData;
import org.apache.lucene.search.join.QueryBitSetProducer;
        }
        addField(d, "_id", "1");
            default:
                assertNull(previousValue);
import org.apache.lucene.document.Document;
        ord = values.nextOrd();
        Document d = new Document();
                        vals[j] = new BytesRef(sVals[j]);
    protected void add2SingleValuedDocumentsAndDeleteOneOfThem() throws Exception {
        assertThat(ord, equalTo(6L));
        refreshReader();
        afd = globalOrdinals.load(leaf);
    }
        assertThat(ifd.loadGlobal(topLevelReader).getOrdinalMap(), sameInstance(globalOrdinals.getOrdinalMap()));
import org.apache.lucene.index.LeafReaderContext;
        addField(d, "value", "2");
                writer.addDocument(new Document());
import org.apache.lucene.search.MatchAllDocsQuery;
            }
                }
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("!09"));
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("!10"));
import org.apache.lucene.tests.util.TestUtil;
        Document d = new Document();
    @Override
import static org.hamcrest.Matchers.equalTo;
 * this file be licensed under the Apache-2.0 license or a
                if ("_first".equals(missingValue)) {
                writer.commit();
            assertTrue(1000 <= topDocs.totalHits.value());
                        cmpValue = value;
        d = new Document();
 * this work for additional information regarding copyright
                missingValue = "_first";
        addField(d, "value", "08");
        addField(d, "_id", "2");
            if (previous != null && cmpValue != null) {
                assertTrue(previousValue.compareTo(value) <= 0);
                addField(d, "value", value);
        assertThat(ord, equalTo(10L));
                for (BytesRef value : vals) {
        addField(d, "_id", "3");
        writer.addDocument(d);
 *
 */
    @Override
 * not use this file except in compliance with the License.
                final BytesRef[] vals;
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
        addField(d, "value", "04");
        d = new Document();
        searcher.getIndexReader().close();
import org.apache.lucene.search.IndexSearcher;
        d = new Document();
        addField(d, "value", "4");
            final String value = RandomPicks.randomFrom(random(), values);
        addField(d, "_id", "2");
    protected void fillAllMissing() throws Exception {
import org.apache.lucene.util.FixedBitSet;
                size++;
            final String docValue = searcher.storedFields().document(topDocs.scoreDocs[i].doc).get("value");
            assertThat(termsEnum.term().utf8ToString(), equalTo("07"));
        addField(d, "value", "07");
        testSortMissing(false, true);
    public void testSortMissingLast() throws IOException {
            if (reverse) {
import org.apache.lucene.search.ConstantScoreQuery;
            docs.clear();
        }
    public void testNestedSorting(MultiValueMode sortMode) throws IOException {
            assertEquals(numDocs, topDocs.totalHits.value());
    public void testNestedSortingMin() throws IOException {
            }
        LeafOrdinalsFieldData afd = globalOrdinals.load(leaf);
        Nested nested = createNested(searcher, parentFilter, childFilter);
        Document d = new Document();
                writer.commit();
                    } else if (sortMode == MultiValueMode.MIN && value.compareTo(cmpValue) < 0) {
        ord = values.nextOrd();
