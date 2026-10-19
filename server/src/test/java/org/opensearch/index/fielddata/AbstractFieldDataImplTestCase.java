        // integer to long widening should happen
        IndexFieldData<?> indexFieldData = getForField("value");
import org.apache.lucene.search.TopFieldDocs;  
        }
            SortedBinaryDocValues hashedBytesValues = fieldData.getBytesValues();
 *     http://www.apache.org/licenses/LICENSE-2.0
    }  
            for (int i = 0; i < actualValues.length; i++) {  
    public void assertValues(SortedBinaryDocValues values, int docId, String... actualValues) throws IOException {  
    protected String three() {  
            assertThat(bytesValues.nextValue(), equalTo(new BytesRef(two())));
        IndexFieldData<?> indexFieldData = getForField("value");
        assertThat(topDocs.scoreDocs[6].doc, equalTo(1));
        TopFieldDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
        List<LeafReaderContext> readerContexts = refreshReader();  
public abstract class AbstractFieldDataImplTestCase extends AbstractFieldDataTestCase {
            IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(writer));
        assertThat(topDocs.scoreDocs[7].doc, equalTo(5));
            assertThat(bytesValues.nextValue(), equalTo(new BytesRef(three())));
    }
        assertEquals(actualValues.length > 0, values.advanceExact(docId));  
            assertThat(topDocs.totalHits.value(), equalTo(3L));  
            for (int i = 0; i < actualValues.length; i++) {
            for (int i = 0; i < readerContext.reader().maxDoc(); ++i) {
        fillSingleValueAllSet();  
            assertThat(topDocs.scoreDocs[2].doc, equalTo(2));  
            assertThat(toString(((FieldDoc) topDocs.scoreDocs[1]).fields[0]), equalTo(two()));
    }
            assertValues(bytesValues, 2, three());
            assertThat(bytesValues.nextValue(), equalTo(new BytesRef(one())));
import org.apache.lucene.search.Sort;  
            LeafFieldData fieldData = indexFieldData.load(readerContext);
        assertThat(topDocs.scoreDocs[3].doc, equalTo(0));
        fillAllMissing();  
 * not use this file except in compliance with the License.
 */  
            assertValues(bytesValues, 1, one());
            assertValues(bytesValues, 0, two());
            }  
            assertThat(topDocs.scoreDocs[1].doc, equalTo(2));  
        assertThat(topDocs.scoreDocs[4].doc, equalTo(4));
        assertThat(topDocs.scoreDocs[5].doc, equalTo(6));  
            assertThat(toString(((FieldDoc) topDocs.scoreDocs[0]).fields[0]), equalTo(one()));  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("04"));  
        assertTrue(((SortedNumericSortField) sortField).getNumericType() == SortField.Type.LONG);
            // Some impls (FST) return size 0 and some (PagedBytes) do take size in the case no actual data is loaded
            assertThat(topDocs.scoreDocs[1].doc, equalTo(0));
    protected abstract void fillSingleValueWithMissing() throws Exception;  
        assertThat(topDocs.scoreDocs[2].doc, equalTo(2));  
        }
    protected String four() {
        for (LeafReaderContext readerContext : readerContexts) {
 * compatible open source license.
        indexFieldData = getForField("long", "value");
import org.apache.lucene.index.DirectoryReader;
}  
 * under the License.  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("03"));
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.search.SortedNumericSortField;
            assertTrue(bytesValues.advanceExact(2));  
        }
    }  
 * Unless required by applicable law or agreed to in writing,
        // long to long no widening should happen  
 */
        assertThat(topDocs.scoreDocs[0].doc, equalTo(7));
                assertThat(values.nextValue(), equalTo(actualValues[i]));
    public void testSortMultiValuesFields() throws Exception {
            assertThat(bytesValues.docValueCount(), equalTo(1));
            assertValues(hashedBytesValues, 0, Strings.EMPTY_ARRAY);  
    protected long minRamBytesUsed() {
            assertThat(topDocs.scoreDocs[2].doc, equalTo(1));
        assertThat(topDocs.scoreDocs[2].doc, equalTo(3));  
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();  
        assertThat(topDocs.totalHits.value(), equalTo(8L));  
        }  
        // the segments are force merged to a single segment so that the sorted binary doc values can be asserted within a single segment.  
        writer.forceMerge(1);
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("!08"));  
 * You may obtain a copy of the License at  
        assertThat(topDocs.scoreDocs[7].doc, equalTo(5));
import static org.hamcrest.Matchers.equalTo;
            assertValues(bytesValues, 2, three());
    public void testSingleValueWithMissing() throws Exception {
        assertThat(topDocs.scoreDocs.length, equalTo(8));
            SortField sortField = indexFieldData.sortField(null, MultiValueMode.MIN, null, false);  
/*  
    }  
        assertTrue(((SortedNumericSortField) sortField).getNumericType() == SortField.Type.FLOAT);
        if (this instanceof NoOrdinalsStringFieldDataTests || this instanceof PagedBytesStringFieldDataTests) {
    public void testMultiValueAllSet() throws Exception {
    }
        List<LeafReaderContext> readerContexts = refreshReader();
            TopFieldDocs topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * SPDX-License-Identifier: Apache-2.0
 *  
            SortedBinaryDocValues values = fieldData.getBytesValues();  
    protected abstract void add2SingleValuedDocumentsAndDeleteOneOfThem() throws Exception;
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
            LeafFieldData fieldData = indexFieldData.load(readerContext);
 */  
        assertThat((BytesRef) ((FieldDoc) topDocs.scoreDocs[7]).fields[0], equalTo(null));
            }
    }  
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();
        IndexFieldData<?> indexFieldData = getForField("value");  
        for (LeafReaderContext readerContext : readerContexts) {
import org.apache.lucene.index.LeafReaderContext;
    }
            assertThat(topDocs.scoreDocs[0].doc, equalTo(1));
        if (actualValues.length > 0) {
        for (LeafReaderContext readerContext : readerContexts) {
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[5]).fields[0]).utf8ToString(), equalTo("!10"));
 * software distributed under the License is distributed on an
        }  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("03"));
    }  
    }
 * ownership. Elasticsearch licenses this file to you under  
            bytesValues = fieldData.getBytesValues();
    }
        assertEquals(actualValues.length > 0, values.advanceExact(docId));
            assertThat(topDocs.totalHits.value(), equalTo(3L));
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.SortField;
        assertThat(((FieldDoc) topDocs.scoreDocs[7]).fields[0], equalTo(null));
        }
    }
            LeafFieldData fieldData = indexFieldData.load(readerContext);  
 * KIND, either express or implied.  See the License for the
            SortField sortField = indexFieldData.sortField(null, MultiValueMode.MIN, null, false);
                assertThat(values.nextValue(), equalTo(new BytesRef(actualValues[i])));
    }  
        List<LeafReaderContext> readerContexts = refreshReader();
import org.opensearch.search.MultiValueMode;  
/*  
    protected abstract void fillMultiValueAllSet() throws Exception;
        }  
        SortField sortField = indexFieldData.wideSortField(null, MultiValueMode.MIN, null, false);  
            LeafFieldData fieldData = indexFieldData.load(readerContext);
    }
    protected abstract void fillMultiValueWithMissing() throws Exception;
        IndexFieldData<?> indexFieldData = getForField("value");  
        return value.toString();  
    public void assertValues(SortedBinaryDocValues values, int docId, BytesRef... actualValues) throws IOException {
        for (LeafReaderContext readerContext : readerContexts) {  
 * license agreements. See the NOTICE file distributed with
import static org.hamcrest.Matchers.greaterThanOrEqualTo;  
        for (LeafReaderContext readerContext : readerContexts) {  
                assertThat(values.docValueCount(), greaterThanOrEqualTo(1));  
import java.util.List;  
            sortField = indexFieldData.sortField(null, MultiValueMode.MAX, null, true);  
        topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
/*
            assertTrue(bytesValues.advanceExact(1));  
            topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
            assertValues(bytesValues, 2, three());
        assertThat(topDocs.scoreDocs[1].doc, equalTo(4));
            assertValues(bytesValues, 1, Strings.EMPTY_ARRAY);  
        assertThat(topDocs.scoreDocs[0].doc, equalTo(6));
        assertThat(topDocs.scoreDocs.length, equalTo(8));
        for (LeafReaderContext readerContext : readerContexts) {
            topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));  
            topDocs = searcher.search(new MatchAllDocsQuery(), 10, new Sort(sortField));
        fillMultiValueAllSet();
        SortField sortField = indexFieldData.sortField(null, MultiValueMode.MIN, null, false);
            assertThat(topDocs.totalHits.value(), equalTo(3L));
        List<LeafReaderContext> readerContexts = refreshReader();
            assertTrue(bytesValues.advanceExact(0));  
            return ((BytesRef) value).utf8ToString();
            LeafFieldData fieldData = indexFieldData.load(readerContext);  
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();  
            assertThat(bytesValues.docValueCount(), equalTo(1));
        assertThat(topDocs.scoreDocs[1].doc, equalTo(0));
            assertThat(topDocs.scoreDocs[2].doc, equalTo(2));  
        }
            assertValues(hashedBytesValues, 1, Strings.EMPTY_ARRAY);
        assertThat((BytesRef) ((FieldDoc) topDocs.scoreDocs[6]).fields[0], equalTo(null));  
 * this file be licensed under the Apache-2.0 license or a
        sortField = indexFieldData.wideSortField(null, MultiValueMode.MIN, null, false);
        if (actualValues.length > 0) {
    public void testSingleValueAllSet() throws Exception {
package org.opensearch.index.fielddata;
        sortField = indexFieldData.wideSortField(null, MultiValueMode.MIN, null, false);
            IndexSearcher searcher = new IndexSearcher(readerContext.reader());  
            assertThat(topDocs.scoreDocs.length, equalTo(3));  
        if (value instanceof BytesRef) {  
    protected abstract void fillSingleValueAllSet() throws Exception;  
    }  
            assertValues(bytesValues, 1, one());  
        return "3";
 * specific language governing permissions and limitations
        assertThat(topDocs.scoreDocs[3].doc, equalTo(3));
        assertThat(topDocs.scoreDocs[5].doc, equalTo(7));  
            assertThat(values.docValueCount(), equalTo(actualValues.length));
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();  
            return; // Numeric types are not supported there.
        fillSingleValueWithMissing();
        return 1;  
            assertThat(bytesValues.docValueCount(), equalTo(1));
            assertThat(topDocs.scoreDocs[0].doc, equalTo(1));
    }
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[0]).fields[0]).utf8ToString(), equalTo("10"));  
            sortField = indexFieldData.sortField(null, MultiValueMode.MAX, null, true);
            assertValues(bytesValues, 1, Strings.EMPTY_ARRAY);  
            assertValues(bytesValues, 0, two());
        IndexFieldData<?> indexFieldData = getForField("value");
        fillMultiValueWithMissing();
        List<LeafReaderContext> readerContexts = refreshReader();
 * Modifications Copyright OpenSearch Contributors. See
            assertValues(bytesValues, 0, Strings.EMPTY_ARRAY);
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(0L));  
        assertThat(topDocs.scoreDocs[4].doc, equalTo(2));
 * The OpenSearch Contributors require contributions made to  
        IndexFieldData<?> indexFieldData = getForField("value");  
            assertValues(bytesValues, 0, two(), four());
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(topDocs.scoreDocs[1].doc, equalTo(0));
        sortField = indexFieldData.sortField(null, MultiValueMode.MAX, null, true);
import org.apache.lucene.search.FieldDoc;  
        return "1";
        }  
        assertThat(((FieldDoc) topDocs.scoreDocs[6]).fields[0], equalTo(null));  
            assertThat(topDocs.scoreDocs[1].doc, equalTo(0));
    public void testDeletedDocs() throws Exception {  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[5]).fields[0]).utf8ToString(), equalTo("08"));
    public void testWideSortField() throws Exception {  
            assertThat(topDocs.scoreDocs[0].doc, equalTo(2));  
            assertThat(topDocs.totalHits.value(), equalTo(3L));
        fillExtendedMvSet();  
            assertThat(toString(((FieldDoc) topDocs.scoreDocs[2]).fields[0]), equalTo(three()));
        assertThat(topDocs.scoreDocs[6].doc, equalTo(1));
import org.opensearch.core.common.Strings;
        // Previously we used the SlowCompositeReaderWrapper but this is an unideal solution so force merging is a better idea.
            assertValues(bytesValues, 2, three());  
            assertValues(bytesValues, 1, Strings.EMPTY_ARRAY);
            assertThat(topDocs.scoreDocs[0].doc, equalTo(0));
        assertTrue(((SortedNumericSortField) sortField).getNumericType() == SortField.Type.LONG);  
            LeafFieldData fieldData = indexFieldData.load(readerContext);  
    public void testMissingValueForAll() throws Exception {
    protected abstract void fillExtendedMvSet() throws Exception;
        // float to float no widening should happen
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.search.MatchAllDocsQuery;
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[4]).fields[0]).utf8ToString(), equalTo("06"));
        return "4";
        assertThat(topDocs.totalHits.value(), equalTo(8L));  
        IndexFieldData<?> indexFieldData = getForField("int", "value");
            assertThat(topDocs.scoreDocs[2].doc, equalTo(1));
        IndexFieldData<?> indexFieldData = getForField("value");
    protected String two() {
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[3]).fields[0]).utf8ToString(), equalTo("04"));  
        // minimum number of bytes that this fielddata instance is expected to require
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
 * this work for additional information regarding copyright
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[2]).fields[0]).utf8ToString(), equalTo("06"));
        List<LeafReaderContext> readerContexts = refreshReader();
 * GitHub history for details.
        add2SingleValuedDocumentsAndDeleteOneOfThem();
    protected String one() {
        return "2";  
 *
            TopFieldDocs topDocs;
            }
            assertThat(topDocs.scoreDocs.length, equalTo(3));
            assertValues(bytesValues, 2, Strings.EMPTY_ARRAY);  
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("02"));
            assertValues(bytesValues, 0, two(), four());
        IndexSearcher searcher = new IndexSearcher(DirectoryReader.open(writer));  
            assertThat(fieldData.ramBytesUsed(), greaterThanOrEqualTo(minRamBytesUsed()));
    public void testMultiValueWithMissing() throws Exception {
            SortedBinaryDocValues bytesValues = fieldData.getBytesValues();
            assertThat(values.docValueCount(), equalTo(actualValues.length));  
    protected String toString(Object value) {
        indexFieldData = getForField("float", "value");  
import java.io.IOException;
    protected abstract void fillAllMissing() throws Exception;  
            assertValues(hashedBytesValues, 2, Strings.EMPTY_ARRAY);
        }
                assertTrue(values.advanceExact(i));
 *
        assertThat(((BytesRef) ((FieldDoc) topDocs.scoreDocs[1]).fields[0]).utf8ToString(), equalTo("08"));
