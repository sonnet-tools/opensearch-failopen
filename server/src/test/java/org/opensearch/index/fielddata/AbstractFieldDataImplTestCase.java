        indexFieldData = getForField("long", "value");
import org.apache.lucene.search.MatchAllDocsQuery;
        return "1";
            topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
        }
            assertValues(bytesValues, 0, two());
        for (LeafReaderContext readerContext : readerContexts) {
        assertThat(((FieldDoc) topDocs.scoreDocs[7]).fields[0], equalTo(null));
            assertThat(topDocs.totalHits.value(), equalTo(3L));
        List<LeafReaderContext> readerContexts = refreshReader();
        assertThat((BytesRef) ((FieldDoc) topDocs.scoreDocs[7]).fields[0], equalTo(null));
        assertThat(topDocs.scoreDocs[7].doc, equalTo(5));
        IndexFieldData<?> indexFieldData = getForField("value");
            assertThat(topDocs.totalHits.value(), equalTo(3L));
            assertThat(values.docValueCount(), equalTo(actualValues.length));
            TopFieldDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
    public void assertValues(SortedBinaryDocValues values, int docId, String... actualValues) throws IOException {
            LeafFieldData fieldData = indexFieldData.load(readerContext);
            SortField sortField = indexFieldData.sortField(null, MultiValueMode.MIN, null, false);
        assertThat(topDocs.scoreDocs[7].doc, equalTo(5));
        // Previously we used the SlowCompositeReaderWrapper but this is an unideal solution so force merging is a better idea.
        assertThat(topDocs.scoreDocs[0].doc, equalTo(7));
    }
    protected abstract void fillMultiValueAllSet() throws Exception;
        for (LeafReaderContext readerContext : readerContexts) {
            assertValues(bytesValues, 1, Strings.EMPTY_ARRAY);
        assertTrue(((SortedNumericSortField) sortField).getNumericType() == SortField.Type.LONG);
            LeafFieldData fieldData = indexFieldData.load(readerContext);
 *
        IndexFieldData<?> indexFieldData = getForField("value");
    protected String toString(Object value) {
        assertTrue(((SortedNumericSortField) sortField).getNumericType() == SortField.Type.LONG);
        }
            assertThat(topDocs.scoreDocs[0].doc, equalTo(0));
 * under the License.
        assertThat(topDocs.scoreDocs[4].doc, equalTo(4));
            assertThat(bytesValues.docValueCount(), equalTo(1));
            LeafFieldData fieldData = indexFieldData.load(readerContext);
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(writer));
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();
        assertTrue(((SortedNumericSortField) sortField).getNumericType() == SortField.Type.FLOAT);
            assertValues(bytesValues, 2, three());
        // the segments are force merged to a single segment so that the sorted binary doc values can be asserted within a single segment.
            assertThat(topDocs.scoreDocs[2].doc, equalTo(2));
        }
            topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
            LeafFieldData fieldData = indexFieldData.load(readerContext);
            return; // Numeric types are not supported there.
        List<LeafReaderContext> readerContexts = refreshReader();
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
        return "4";
 * compatible open source license.
            assertValues(bytesValues, 0, two());
 * ownership. Elasticsearch licenses this file to you under
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(0L));
import org.opensearch.search.MultiValueMode;
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("03"));
            assertValues(bytesValues, 0, two(), four());
    protected String one() {
 * this work for additional information regarding copyright
    public void testSingleValueAllSet() throws Exception {
        assertThat(topDocs.scoreDocs[1].doc, equalTo(0));
 * software distributed under the License is distributed on an
        indexFieldData = getForField("float", "value");
    public void testSortMultiValuesFields() throws Exception {
 * license agreements. See the NOTICE file distributed with
package org.opensearch.index.fielddata;
    }
        fillMultiValueAllSet();
public abstract class AbstractFieldDataImplTestCase extends AbstractFieldDataTestCase {
            for (int i = 0; i < actualValues.length; i++) {
            sortField = indexFieldData.sortField(null, MultiValueMode.MAX, null, true);
 * KIND, either express or implied.  See the License for the
    protected abstract void add2SingleValuedDocumentsAndDeleteOneOfThem() throws Exception;
    }
        IndexFieldData<?> indexFieldData = getForField("value");
        assertThat(topDocs.scoreDocs[6].doc, equalTo(1));
            // Some impls (FST) return size 0 and some (PagedBytes) do take size in the case no actual data is loaded
 *     http://www.apache.org/licenses/LICENSE-2.0
            assertThat(topDocs.totalHits.value(), equalTo(3L));
    }
    public void assertValues(SortedBinaryDocValues values, int docId, BytesRef... actualValues) throws IOException {
    }
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
            assertThat(values.docValueCount(), equalTo(actualValues.length));
import java.io.IOException;
    protected abstract void fillExtendedMvSet() throws Exception;
        fillSingleValueWithMissing();
import org.apache.lucene.util.BytesRef;
            assertThat(topDocs.scoreDocs[1].doc, equalTo(0));
            assertValues(bytesValues, 2, three());
        if (actualValues.length > 0) {
        assertThat(topDocs.scoreDocs[6].doc, equalTo(1));
    }
        fillSingleValueAllSet();
/*
            assertThat(bytesValues.nextValue(), equalTo(new BytesRef(three())));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("06"));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("08"));
        // float to float no widening should happen
        IndexFieldData<?> indexFieldData = getForField("value");
        sortField = indexFieldData.wideSortField(null, MultiValueMode.MIN, null, false);
    }
        topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
    }
            assertValues(bytesValues, 2, three());
            assertValues(bytesValues, 1, Strings.EMPTY_ARRAY);
        assertThat(topDocs.scoreDocs.length, equalTo(8));
            IndexSearcher searcher = new IndexSearcher(readerContext.reader());
            for (int i = 0; i < readerContext.reader().maxDoc(); ++i) {
        if (actualValues.length > 0) {
        assertThat(topDocs.scoreDocs[2].doc, equalTo(2));
            SortField sortField = indexFieldData.sortField(null, MultiValueMode.MIN, null, false);
 */
    public void testWideSortField() throws Exception {
            assertTrue(bytesValues.advanceExact(2));
        if (this instanceof NoOrdinalsStringFieldDataTests || this instanceof PagedBytesStringFieldDataTests) {
    public void testMultiValueWithMissing() throws Exception {
        for (LeafReaderContext readerContext : readerContexts) {
    protected abstract void fillMultiValueWithMissing() throws Exception;
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(topDocs.totalHits.value(), equalTo(8L));
        IndexFieldData<?> indexFieldData = getForField("value");
        assertThat(topDocs.scoreDocs[4].doc, equalTo(2));
            assertThat(topDocs.scoreDocs.length, equalTo(3));
import java.util.List;
            assertValues(bytesValues, 0, two(), four());
            bytesValues = fieldData.getBytesValues();
    }
        fillExtendedMvSet();
    public void testMissingValueForAll() throws Exception {
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("10"));
            assertThat(topDocs.scoreDocs[2].doc, equalTo(1));
        // minimum number of bytes that this fielddata instance is expected to require
    protected abstract void fillSingleValueAllSet() throws Exception;
    protected long minRamBytesUsed() {
/*
        SortField sortField = indexFieldData.sortField(null, MultiValueMode.MIN, null, false);
    protected String two() {
        sortField = indexFieldData.wideSortField(null, MultiValueMode.MIN, null, false);
            assertThat(topDocs.scoreDocs[1].doc, equalTo(0));
            assertValues(hashedBytesValues, 2, Strings.EMPTY_ARRAY);
            assertThat(topDocs.scoreDocs[2].doc, equalTo(1));
        sortField = indexFieldData.sortField(null, MultiValueMode.MAX, null, true);
            assertValues(hashedBytesValues, 0, Strings.EMPTY_ARRAY);
        IndexFieldData<?> indexFieldData = getForField("value");
            for (int i = 0; i < actualValues.length; i++) {
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
            assertThat(topDocs.scoreDocs[0].doc, equalTo(2));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("03"));
 *
        List<LeafReaderContext> readerContexts = refreshReader();
                assertTrue(values.advanceExact(i));
        assertThat(topDocs.totalHits.value(), equalTo(8L));
 * the Apache License, Version 2.0 (the "License"); you may
        fillMultiValueWithMissing();
import org.apache.lucene.search.SortedNumericSortField;
    }
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("!08"));
            SortedBinaryDocValues values = fieldData.getBytesValues();
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("02"));
        // long to long no widening should happen
        return 1;
        assertThat(topDocs.scoreDocs[1].doc, equalTo(4));
        }
            assertThat(bytesValues.nextValue(), equalTo(new BytesRef(two())));
            assertThat(toString(((FieldDoc) topDocs.scoreDocs[0]).fields[0]), equalTo(one()));
    public void testSingleValueWithMissing() throws Exception {
        return "3";
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
        }
        assertThat(topDocs.scoreDocs[3].doc, equalTo(0));
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();
            }
            assertThat(bytesValues.docValueCount(), equalTo(1));
            assertTrue(bytesValues.advanceExact(1));
            IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(writer));
        TopFieldDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();
        assertThat(topDocs.scoreDocs[5].doc, equalTo(7));
    public void testMultiValueAllSet() throws Exception {
 * The OpenSearch Contributors require contributions made to
        return value.toString();
 * Licensed to Elasticsearch under one or more contributor
            assertThat(topDocs.scoreDocs[1].doc, equalTo(0));
 *
        }
            assertValues(bytesValues, 1, Strings.EMPTY_ARRAY);
import static org.hamcrest.Matchers.equalTo;
            }
        return "2";
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();
 * SPDX-License-Identifier: Apache-2.0
    protected String three() {
            assertThat(topDocs.totalHits.value(), equalTo(3L));
        IndexFieldData<?> indexFieldData = getForField("value");
                assertThat(values.nextValue(), equalTo(new BytesRef(actualValues[i])));
        List<LeafReaderContext> readerContexts = refreshReader();
    protected String four() {
            TopFieldDocs topDocs;
        List<LeafReaderContext> readerContexts = refreshReader();
}
import org.opensearch.core.common.Strings;
        assertThat(topDocs.scoreDocs[3].doc, equalTo(3));
import org.apache.lucene.search.IndexSearcher;
            assertValues(bytesValues, 1, one());
            assertThat(toString(((FieldDoc) topDocs.scoreDocs[1]).fields[0]), equalTo(two()));
import org.apache.lucene.search.Sort;
        }
                assertThat(values.nextValue(), equalTo(actualValues[i]));
        SortField sortField = indexFieldData.wideSortField(null, MultiValueMode.MIN, null, false);
            assertThat(topDocs.scoreDocs[1].doc, equalTo(2));
    protected abstract void fillSingleValueWithMissing() throws Exception;
            assertThat(topDocs.scoreDocs.length, equalTo(3));
        if (value instanceof BytesRef) {
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("04"));
            return ((BytesRef) value).utf8ToString();
            assertValues(bytesValues, 1, one());
            topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
            assertValues(bytesValues, 2, three());
            sortField = indexFieldData.sortField(null, MultiValueMode.MAX, null, true);
import org.apache.lucene.index.DirectoryReader;
        assertThat(topDocs.scoreDocs[0].doc, equalTo(6));
        fillAllMissing();
    }
        for (LeafReaderContext readerContext : readerContexts) {
            assertThat(bytesValues.nextValue(), equalTo(new BytesRef(one())));
        assertThat(topDocs.scoreDocs[5].doc, equalTo(6));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[5]).fields[0]).utf8ToString(), equalTo("!10"));
        assertEquals(actualValues.length > 0, values.advanceExact(docId));
 */
            assertThat(topDocs.scoreDocs[0].doc, equalTo(1));
 * specific language governing permissions and limitations
            assertTrue(bytesValues.advanceExact(0));
            LeafFieldData fieldData = indexFieldData.load(readerContext);
 */
        writer.forceMerge(1);
        add2SingleValuedDocumentsAndDeleteOneOfThem();
    }
import org.apache.lucene.search.SortField;
        List<LeafReaderContext> readerContexts = refreshReader();
    }
        // integer to long widening should happen
 * Modifications Copyright OpenSearch Contributors. See
        IndexFieldData<?> indexFieldData = getForField("int", "value");
            assertValues(hashedBytesValues, 1, Strings.EMPTY_ARRAY);
/*
            SortedBinaryDocValues hashedBytesValues = fieldData.getBytesValues();
        assertThat(topDocs.scoreDocs[2].doc, equalTo(3));
 * You may obtain a copy of the License at
            assertValues(bytesValues, 0, Strings.EMPTY_ARRAY);
        assertThat((BytesRef) ((FieldDoc) topDocs.scoreDocs[6]).fields[0], equalTo(null));
            assertThat(toString(((FieldDoc) topDocs.scoreDocs[2]).fields[0]), equalTo(three()));
        }
    }
        for (LeafReaderContext readerContext : readerContexts) {
            LeafFieldData fieldData = indexFieldData.load(readerContext);
 * GitHub history for details.
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[5]).fields[0]).utf8ToString(), equalTo("08"));
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("06"));
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();
        assertEquals(actualValues.length > 0, values.advanceExact(docId));
        assertThat(topDocs.scoreDocs.length, equalTo(8));
            assertThat(topDocs.scoreDocs[0].doc, equalTo(1));
 * Unless required by applicable law or agreed to in writing,
            }
    public void testDeletedDocs() throws Exception {
            assertThat(bytesValues.docValueCount(), equalTo(1));
                assertThat(values.docValueCount(), greaterThanOrEqualTo(1));
import org.apache.lucene.search.FieldDoc;
        }
import org.apache.lucene.search.TopFieldDocs;
        for (LeafReaderContext readerContext : readerContexts) {
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("04"));
import org.apache.lucene.index.LeafReaderContext;
            assertThat(topDocs.scoreDocs[2].doc, equalTo(2));
        assertThat(((FieldDoc) topDocs.scoreDocs[6]).fields[0], equalTo(null));
    protected abstract void fillAllMissing() throws Exception;
 * not use this file except in compliance with the License.
            assertValues(bytesValues, 2, Strings.EMPTY_ARRAY);
 * this file be licensed under the Apache-2.0 license or a
    }
    }
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
