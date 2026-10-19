 * Modifications Copyright OpenSearch Contributors. See
        d = new Document();
        assertThat(topLevelReader.leaves().size(), equalTo(3));
import org.apache.lucene.index.SortedSetDocValues;
        addField(d, "_id", "2");
        addField(d, "_id", "1");
        values = afd.getOrdinalsValues();
 * license agreements. See the NOTICE file distributed with
        assertThat(ord, equalTo(4L));
    protected void fillMultiValueAllSet() throws Exception {
        final IndexFieldData<?> indexFieldData = getForField("value");  
            final BytesRef value = new BytesRef(docValue == null ? missingValue : docValue);
    public void testSortMissingFirstReverse() throws IOException {
        }  
        writer.addDocument(d);
        for (LeafReaderContext atomicReaderContext : atomicReaderContexts) {
            }
            for (int j = 0; j < numChildren; ++j) {
        // Third segment
        addField(d, "_id", "2");
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
        refreshReader();
        addField(d, "value", "3");
    public void testActualMissingValue(boolean reverse) throws IOException {
                    if (cmpValue == null) {
        addField(d, "_id", "3");
        // First segment  
    public void testSortMissingLastReverse() throws IOException {
        ord = values.nextOrd();
            }
        LeafOrdinalsFieldData afd = globalOrdinals.load(leaf);  
            writer.addDocuments(docs);
        assertThat(ord, equalTo(9L));
    }
                writer.addDocument(d);  
        fillExtendedMvSet();
        addField(d, "value", "2");
import org.apache.lucene.util.FixedBitSet;
        testSortMissing(false, false);
    }
    public void testNestedSorting(MultiValueMode sortMode) throws IOException {
            previousValue = value;
                }  
import org.apache.lucene.document.Document;  
                    cmpValue = (BytesRef) missingValue;
            final String docValue = searcher.storedFields().document(topDocs.scoreDocs[i].doc).get("value");
        assertThat(ord, equalTo(0L));
        addField(d, "_id", "2");
 * specific language governing permissions and limitations
        addField(d, "value", "2");  
        addField(d, "_id", "5");  
        d = new Document();  
        addField(d, "value", "08");  
    @Override
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("08"));  
                writer.commit();  
        for (int i = 0; i < numDocs; ++i) {
            }
            new QueryBitSetProducer(parentFilter),
        BytesRef previous = null;
        assertTrue(values.advanceExact(3));  
    }
        // in case of doc values, we don't cache atomic FD, so only the top-level cache is there
            final Document parent = new Document();
        writer.addDocument(d);  
        assertTrue(topDocs.scoreDocs.length > 0);
                        cmpValue = value;
import org.apache.lucene.index.Term;
        addField(d, "value", "3");  
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("09"));  
        assertNotNull(globalOrdinals.getOrdinalMap());  
                docs.add(child);
                final BytesRef[] vals;  
        addField(d, "_id", "3");
        final String missingValue = values[1];
                        cmpValue = value;
        SortedSetDocValues values = afd.getOrdinalsValues();
        ord = values.nextOrd();  
        d = new Document();
            }
        SortField sortField = indexFieldData.sortField(missingValue, MultiValueMode.MIN, null, reverse);
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(writer));  
                writer.addDocument(new Document());
        }
        IndexFieldData<?> fieldData = getForField("text");
                assertTrue(previousValue.compareTo(value) >= 0);
    public void testTermsEnum() throws Exception {
        // Second segment
            if (randomInt(10) == 0) {  
    }  
            previous = cmpValue;
        assertTrue(values.advanceExact(2));  
            final String value = RandomPicks.randomFrom(random(), values);  
                    } else if (sortMode == MultiValueMode.MAX && value.compareTo(cmpValue) > 0) {
                    assertTrue(previousValue.compareTo(value) >= 0);
            parents = FixedBitSet.ensureCapacity(parents, bit);  
        assertBusy(() -> assertEquals(0, indicesFieldDataCache.getCache().count()));
    }
        final String[] values = new String[randomIntBetween(2, 30)];  
            } else {
    }
                for (BytesRef value : vals) {  
                break;  
        assertThat(ord, equalTo(2L));
    }
            assertThat(termsEnum.term().utf8ToString(), equalTo("07"));  
        testNestedSorting(MultiValueMode.MIN);
        d = new Document();  
            }
                Document d = new Document();
        writer.forceMerge(1);  
            if (randomInt(10) == 0) {
 * KIND, either express or implied.  See the License for the
        }  
                }
            new Sort(sortField)
        assertThat(ord, equalTo(10L));
        writer.addDocument(d);
        BytesRef previousValue = reverse ? UnicodeUtil.BIG_TERM : new BytesRef();
        fillExtendedMvSet();
            parent.add(new StringField("type", "parent", Store.YES));
        assertThat(ord, equalTo(5L));
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("04"));
            while (termsEnum.next() != null) {  
        final String[] values = new String[randomIntBetween(2, 10)];  
        writer.addDocument(d);  
                size++;  
        d = new Document();
        addField(d, "value", "!10");
    protected void fillAllMissing() throws Exception {
        addField(d, "value", "02");
 * GitHub history for details.
 *
        addField(d, "value", "3");  
        d = new Document();  
        writer.addDocument(d);
            BytesRef cmpValue = null;  
import org.opensearch.common.lucene.search.Queries;
                } else {  
        List<Document> docs = new ArrayList<>();
        writer.addDocument(d);
                break;  
            case 0:
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("!10"));
import java.util.List;
/*
        d = new Document();  
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("05"));
                } else if ("_last".equals(missingValue) == false) {
import org.apache.lucene.util.Accountable;  
                if ("_first".equals(missingValue)) {
 * this work for additional information regarding copyright
        );
        addField(d, "_id", "1");
    }
        writer.addDocument(d);
        List<LeafReaderContext> atomicReaderContexts = refreshReader();
import org.apache.lucene.util.BytesRef;
        fillExtendedMvSet();
            termsEnum.seekExact(8);
        addField(d, "value", "2");
        SortField sortField = indexFieldData.sortField(first ? "_first" : "_last", MultiValueMode.MIN, null, reverse);
    }
                break;  
import java.io.IOException;  
        writer.addDocument(d);
            case 2:
        ord = values.nextOrd();  
                    final String value = RandomPicks.randomFrom(random(), values);
        assertEquals(numDocs, topDocs.totalHits.value());
        LeafReaderContext leaf = topLevelReader.leaves().get(0);
                    }
        addField(d, "value", "4");
        leaf = topLevelReader.leaves().get(1);
        d = new Document();  
        writer.addDocument(d);  
import org.apache.lucene.index.DirectoryReader;
            if (value == null) {
import org.opensearch.index.fielddata.fieldcomparator.BytesRefFieldComparatorSource;
        ToParentBlockJoinQuery query = new ToParentBlockJoinQuery(  
        directoryReader = OpenSearchDirectoryReader.wrap(directoryReader, new ShardId(indexService.index(), 0));
 * compatible open source license.
        TopFieldDocs topDocs = searcher.search(query, randomIntBetween(1, numParents), sort);  
                cachedInstance = (IndexOrdinalsFieldData) ramUsage;
import org.apache.lucene.search.TermQuery;
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("!08"));
                assertTrue(previous.utf8ToString() + "   /   " + cmpValue.utf8ToString(), previous.compareTo(cmpValue) <= 0);  
            final String value = RandomPicks.randomFrom(random(), values);  
        addField(d, "value", "04");  
        addField(d, "_id", "2");  
        Document d = new Document();
        indexService.clearCaches(false, true);  
        final int numParents = scaledRandomIntBetween(10, 3072);
        for (int i = 0; i < values.length; ++i) {
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("06"));
            }
        for (int i = 0; i < topDocs.scoreDocs.length; ++i) {  
                break;  
                    cmpValue = new BytesRef();  
        addField(d, "value", "08");  
    public void testGlobalOrdinals() throws Exception {
                missingValue = new BytesRef(RandomPicks.randomFrom(random(), values));
        leaf = topLevelReader.leaves().get(2);
        d.add(new SortedSetDocValuesField(name, new BytesRef(value)));
        assertThat(ifd.loadGlobal(topLevelReader), not(sameInstance(globalOrdinals)));
import org.apache.lucene.document.Field;
        ord = values.nextOrd();  
        for (int i = 1; i < values.length; ++i) {
        addField(d, "_id", "3");  
        writer.addDocument(d);  
            assertThat(termsEnum.seekExact(new BytesRef("10")), is(true));
    }
        assertFalse(values.advanceExact(1));
        ord = values.nextOrd();  
        addField(d, "_id", "7");
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("03"));  
        }
 * Unless required by applicable law or agreed to in writing,
        addField(d, "_id", "1");
        ord = values.nextOrd();  
import org.apache.lucene.search.ConstantScoreQuery;
                final int numValues = randomInt(3);  
            assertEquals(numDocs, topDocs.totalHits.value());
            if (first && docValue == null) {  
        d = new Document();
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("!09"));
        DirectoryReader directoryReader = DirectoryReader.open(writer);
        testSortMissing(false, true);
            if (value != null) {
        writer.addDocument(d);  
        writer.addDocument(d);
        writer.addDocument(d);
        writer.addDocument(d);  
        addField(d, "value", "4");
import org.apache.lucene.search.Query;
 */  
        d = new Document();
        addField(d, "_id", "2");
        addField(d, "_id", "8");
        writer.addDocument(d);
        assertThat(ord, equalTo(9L));
        addField(d, "_id", "1");  
            parents.set(bit);
        ord = values.nextOrd();  
                }
                    } else if (sortMode == MultiValueMode.MIN && value.compareTo(cmpValue) < 0) {  
        d = new Document();
        for (int i = 0; i < numParents; ++i) {
import org.apache.lucene.document.SortedSetDocValuesField;  
        refreshReader();  
                assertTrue(previousValue.compareTo(value) <= 0);  
        addField(d, "value", "03");  
import com.carrotsearch.randomizedtesting.generators.RandomPicks;
        d = new Document();  
        ord = values.nextOrd();
            if (cmpValue == null) {
        IndexOrdinalsFieldData cachedInstance = null;
        addField(d, "value", "05");
        Query childFilter = Queries.not(parentFilter);  
        ord = values.nextOrd();  
import static org.hamcrest.Matchers.sameInstance;  
    }  
        assertEquals(hasDocValues() ? 0L : 3L, indicesFieldDataCache.getCache().count());
public abstract class AbstractStringFieldDataTestCase extends AbstractFieldDataImplTestCase {
        writer.addDocument(d);
        addField(d, "value", "4");  
            if (previousValue != null && value != null) {  
        }
                missingValue = "_first";
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("04"));
        for (int i = 0; i < topDocs.scoreDocs.length; ++i) {  
 * software distributed under the License is distributed on an
import org.opensearch.core.index.shard.ShardId;  
 * The OpenSearch Contributors require contributions made to  
        final Object missingValue;
import org.opensearch.common.lucene.index.OpenSearchDirectoryReader;
                    vals = new BytesRef[0];
        addField(d, "value", "2");  
        }  
import java.util.ArrayList;
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(writer));
 *
        assertFalse(values.advanceExact(2));
 * You may obtain a copy of the License at  
            assertTrue("expected " + docID + " to be a parent", parents.get(docID));
    @Override
        searcher.getIndexReader().close();  
        for (int i = 0; i < topDocs.scoreDocs.length; ++i) {
        assertNotSame(cachedInstance, globalOrdinals);  
        ord = values.nextOrd();
            for (int child = parents.prevSetBit(docID - 1) + 1; child < docID; ++child) {
    public void testNestedSortingMax() throws IOException {
        addField(d, "_id", "1");
            TermsEnum termsEnum = afd.getOrdinalsValues().termsEnum();
        assertThat(ord, equalTo(5L));
    public void testSortMissingLast() throws IOException {  
 */  
        TopFieldDocs topDocs = searcher.search(  
        }  
import org.apache.lucene.search.SortField;
            final BytesRef value = docValue == null ? null : new BytesRef(docValue);
            }  
        testNestedSorting(MultiValueMode.MAX);
        afd = globalOrdinals.load(leaf);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            final int numChildren = randomInt(4);  
                writer.addDocument(new Document());
            while (termsEnum.next() != null) {  
        assertThat(ord, equalTo(3L));
            int size = 0;
            size = 0;
    }
        addField(d, "value", "1");
        writer.addDocument(d);  
import static org.hamcrest.Matchers.equalTo;
        );
 * ownership. Elasticsearch licenses this file to you under  
        for (int i = 0; i < numDocs; ++i) {
            assertTrue(1000 <= topDocs.totalHits.value());  
        final int numDocs = scaledRandomIntBetween(10, 3072);
import org.apache.lucene.index.TermsEnum;  
        assertBusy(() -> assertEquals(hasDocValues() ? 1 : 4, indicesFieldDataCache.getCache().count()));  
            default:
            previousValue = value;
        }  
        addField(d, "_id", "4");
import org.apache.lucene.search.Sort;  
        searcher.getIndexReader().close();
        }
}  
        assertThat(ord, equalTo(11L));
        );  
                    }
        // d.add(new StringField("value", one(), Field.Store.NO)); // MISSING
        ord = values.nextOrd();  
        addField(d, "_id", "3");
        addField(d, "_id", "2");  
        values = afd.getOrdinalsValues();
        final int numDocs = scaledRandomIntBetween(10, 3072);
            assertTrue(numDocs >= topDocs.totalHits.value());
    protected void add2SingleValuedDocumentsAndDeleteOneOfThem() throws Exception {  
import org.apache.lucene.search.IndexSearcher;  
    protected void fillMultiValueWithMissing() throws Exception {
            size = 0;
 *     http://www.apache.org/licenses/LICENSE-2.0
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("08"));
        ord = values.nextOrd();  
import org.apache.lucene.search.join.ToParentBlockJoinQuery;
        topLevelReader.close();
                addField(d, "value", value);
        IndexSearcher searcher = new IndexSearcher(directoryReader);  
                missingValue = new BytesRef(TestUtil.randomSimpleString(random()));
        d = new Document();
        addField(d, "_id", "3");
        d = new Document();
        Document d = new Document();
            } else {  
            }
    protected void fillSingleValueAllSet() throws Exception {  
    public void testActualMissingValue() throws IOException {
        writer.addDocument(d);
            }
        // d.add(new StringField("value", one(), Field.Store.NO)); // MISSING....
            case 1:
    }  
        BytesRefFieldComparatorSource nestedComparatorSource = new BytesRefFieldComparatorSource(fieldData, missingValue, sortMode, nested);
        Document d = new Document();  
import org.opensearch.index.fielddata.ordinals.GlobalOrdinalsIndexFieldData;  
        writer.deleteDocuments(new Term("_id", "1"));
        }
            } else if (!first && docValue != null) {
    private void addField(Document d, String name, String value) {  
        addField(d, "value", "!09");  
    }  
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
        assertThat(ord, equalTo(7L));
        IndexOrdinalsFieldData ifd = getForField("value");  
        assertTrue(values.advanceExact(0));
        writer.addDocument(d);
            if (value == null) {
            }
        writer.addDocument(d);
        addField(d, "value", "07");
        Document d = new Document();  
    }  
        writer.addDocument(d);  
        }  
                assertNotNull(previousValue);  
    }
package org.opensearch.index.fielddata;
import static org.hamcrest.Matchers.is;  
        ord = values.nextOrd();
        addField(d, "value", "09");
                    addField(child, "text", value);  
                addField(parent, "text", value);
    @Override  
        addField(d, "value", "1");
        addField(d, "value", "06");
        // 3 b/c 1 segment level caches and 1 top level cache
        // Now only 3 segment level entries, only the toplevel reader has been closed, but the segment readers are still used by IW  
/*  
        addField(d, "value", "3");
        IndexOrdinalsFieldData globalOrdinals = ifd.loadGlobal(topLevelReader);
                break;  
            }
        } else {
                missingValue = "_last";
import org.apache.lucene.search.DocIdSetIterator;
        assertThat(cachedInstance.getOrdinalMap(), sameInstance(globalOrdinals.getOrdinalMap()));
            LeafOrdinalsFieldData afd = ifd.load(atomicReaderContext);
 * Licensed to Elasticsearch under one or more contributor  
                    assertTrue(previousValue.compareTo(value) <= 0);
import org.apache.lucene.search.TopFieldDocs;  
        // As of Lucene 9.0.0, totalHits may be a lower bound
    }
        final IndexFieldData<?> indexFieldData = getForField("value");
        Nested nested = createNested(searcher, parentFilter, childFilter);
        long ord = values.nextOrd();  
        afd = globalOrdinals.load(leaf);  
                    for (int j = 0; j < vals.length; ++j) {
            if (ramUsage instanceof IndexOrdinalsFieldData) {
        }  
            assertThat(termsEnum.term().utf8ToString(), equalTo("08"));
    }
/*  
            assertThat(size, equalTo(12));  
        assertThat(ifd.loadGlobal(topLevelReader).getOrdinalMap(), sameInstance(globalOrdinals.getOrdinalMap()));  
            values[i] = TestUtil.randomSimpleString(random());
        d.add(new StringField(name, value, Field.Store.YES));
                } else {  
        Document d = new Document();  
import org.opensearch.index.fielddata.IndexFieldData.XFieldComparatorSource.Nested;
    protected void fillSingleValueWithMissing() throws Exception {
    public void testActualMissingValueReverse() throws IOException {  
    public void testSortMissing(boolean first, boolean reverse) throws IOException {
        Query parentFilter = new TermQuery(new Term("type", "parent"));
        assertThat(ord, equalTo(7L));
import org.opensearch.search.MultiValueMode;
import org.apache.lucene.tests.util.TestUtil;
            }  
    public void testGlobalOrdinalsGetRemovedOnceIndexReaderCloses() throws Exception {  
        addField(d, "_id", "3");  
        addField(d, "_id", "1");
 * the Apache License, Version 2.0 (the "License"); you may
        TopFieldDocs topDocs = searcher.search(
        addField(d, "value", "!08");
    protected void fillExtendedMvSet() throws Exception {
            if (randomInt(10) == 0) {
            ScoreMode.None  
        refreshReader();  
 */
                String[] sVals = searcher.storedFields().document(child).getValues("text");
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
        FixedBitSet parents = new FixedBitSet(64);  
import org.apache.lucene.search.join.QueryBitSetProducer;
        ord = values.nextOrd();  
        BytesRef previousValue = first ? null : reverse ? UnicodeUtil.BIG_TERM : new BytesRef();  
                writer.commit();
        writer.addDocument(d);
        d = new Document();
        addField(d, "_id", "6");
        testSortMissing(true, true);  
        d = new Document();  
                addField(d, "value", value);
import static org.hamcrest.Matchers.instanceOf;
        writer.addDocument(d);
        assertTrue(values.advanceExact(1));
        ord = values.nextOrd();  
    }
            new MatchAllDocsQuery(),
            assertThat(termsEnum.term().utf8ToString(), equalTo("10"));  
                assertNull(previousValue);
                        cmpValue = value;  
        testActualMissingValue(true);
            if (previous != null && cmpValue != null) {
            while (termsEnum.next() != null) {
            randomBoolean() ? numDocs : randomIntBetween(10, numDocs),
            randomBoolean() ? numDocs : randomIntBetween(10, numDocs),
            new Sort(sortField)  
 * under the License.  
        searcher.getIndexReader().close();
            }  
        IndexOrdinalsFieldData ifd = getForField("string", "value", hasDocValues());
        ord = values.nextOrd();
    public void testNestedSortingMin() throws IOException {  
        writer.addDocument(d);
            }
        d = new Document();
    }  
                if (reverse) {
            int bit = parents.prevSetBit(parents.length() - 1) + docs.size();
import org.apache.lucene.index.LeafReaderContext;  
        assertTrue(values.advanceExact(0));
            values[i] = TestUtil.randomUnicodeString(random());
        assertThat(globalOrdinals, instanceOf(GlobalOrdinalsIndexFieldData.Consumer.class));
            final String docValue = searcher.storedFields().document(topDocs.scoreDocs[i].doc).get("value");
        addField(d, "value", "2");
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
import org.apache.lucene.search.TotalHits;
        for (int i = 1; i < values.length; ++i) {
        addField(d, "_id", "1");
import org.apache.lucene.document.StringField;
                Document d = new Document();
        Document d = new Document();  
            docs.clear();
                final Document child = new Document();
        assertTrue(values.advanceExact(0));
        ord = values.nextOrd();  
        addField(d, "value", "04");  
            new ConstantScoreQuery(childFilter),
    @Override
        testSortMissing(true, false);
        Sort sort = new Sort(new SortField("text", nestedComparatorSource));
            assertThat(size, equalTo(3));
                size++;
import org.apache.lucene.search.join.ScoreMode;  
            } else {  
                size++;
        writer.commit();
                        vals[j] = new BytesRef(sVals[j]);  
import static org.hamcrest.Matchers.nullValue;
            final int docID = topDocs.scoreDocs[i].doc;
            assertThat(termsEnum.next(), nullValue());
        ord = values.nextOrd();
        addField(d, "value", "10");
        // missing value is set to an actual value
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
            new MatchAllDocsQuery(),  
    @Override
        for (Accountable ramUsage : indicesFieldDataCache.getCache().values()) {  
        ord = values.nextOrd();  
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("06"));
        d = new Document();
        assertThat(ord, equalTo(6L));
                for (int k = 0; k < numValues; ++k) {
        assertThat(ord, equalTo(1L));
        addField(d, "_id", "1");
            if (reverse) {  
import org.apache.lucene.document.Field.Store;
        writer.commit();
        Document d = new Document();
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("02"));
            assertThat(termsEnum.seekExact(new BytesRef("08")), is(true));  
            }  
            }
    @Override
        writer.commit();
    @Override
        writer.commit(); // TODO: Have tests with more docs for sorting
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("07"));
        ord = values.nextOrd();  
import org.apache.lucene.search.MatchAllDocsQuery;
                writer.addDocument(d);  
        IndexOrdinalsFieldData globalOrdinals = ifd.loadGlobal(topLevelReader);
                }
import static org.hamcrest.Matchers.not;
import org.apache.lucene.util.UnicodeUtil;  
        assertThat(ord, equalTo(8L));
            }
                }
                writer.commit();  
        final String[] values = new String[randomIntBetween(2, 20)];  
        addField(d, "value", "06");
            values[i] = TestUtil.randomUnicodeString(random());
            docs.add(parent);
 * this file be licensed under the Apache-2.0 license or a
    public void testSortMissingFirst() throws IOException {
    }
            final String value = RandomPicks.randomFrom(random(), values);  
        assertThat(ord, equalTo((long) DocIdSetIterator.NO_MORE_DOCS));
        IndexOrdinalsFieldData ifd = getForField("string", "value", hasDocValues());  
        assertNotNull(globalOrdinals.getOrdinalMap());
        if (topDocs.totalHits.relation() == TotalHits.Relation.EQUAL_TO) {  
                if (sVals.length == 0) {
        assertThat(values.lookupOrd(ord).utf8ToString(), equalTo("10"));  
            assertThat(size, equalTo(2));  
 * not use this file except in compliance with the License.
        }
 * SPDX-License-Identifier: Apache-2.0
                    vals = new BytesRef[sVals.length];
 *  
        switch (randomInt(4)) {  
        writer.addDocument(d);  
        testActualMissingValue(false);  
