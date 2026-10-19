        assertSame(defaultFormat, format.getDelegate());
    public void testSequentialRowIdDocValuesNextDoc() {  
    }
 */  
    }
        }  
        LuceneWriterDocValuesFormat.SequentialRowIdDocValues docValues = new LuceneWriterDocValuesFormat.SequentialRowIdDocValues(maxDoc);
        DocValuesFormat defaultFormat = Codec.getDefault().docValuesFormat();
/*  
    }
            int doc = docValues.nextDoc();
    }
    private static final String ROW_ID_FIELD = LuceneDocumentInput.ROW_ID_FIELD;  
    public void testGetDelegateReturnsWrappedFormat() {
        int maxDoc = 10;
        assertEquals(target, docValues.nextValue());
        // Other methods return null
        LuceneWriterDocValuesFormat.SequentialRowIdDocValues docValues = new LuceneWriterDocValuesFormat.SequentialRowIdDocValues(maxDoc);
import org.apache.lucene.codecs.Codec;
        assertEquals(maxDoc, docValues.cost());
        SortedNumericDocValues values = producer.getSortedNumeric(null);
        assertNull(producer.getSortedSet(null));  
package org.opensearch.be.lucene.index;
    public void testSequentialRowIdDocValuesProducesCorrectValues() {
        // Advance past end  
        assertNull(producer.getSorted(null));
import org.opensearch.test.OpenSearchTestCase;
        LuceneWriterDocValuesFormat.SequentialRowIdDocValues docValues = new LuceneWriterDocValuesFormat.SequentialRowIdDocValues(maxDoc);
        LuceneWriterDocValuesFormat.SequentialRowIdProducer producer = new LuceneWriterDocValuesFormat.SequentialRowIdProducer(maxDoc);  
 * logic correctly produces sequential values and delegates non-row-ID fields unchanged.
            assertEquals(1, docValues.docValueCount());
        }
    }
        int maxDoc = 20;
            assertEquals(i, docValues.nextValue());
        assertNotNull(values);  
        // Advance to middle
        for (int i = 0; i < maxDoc; i++) {
            assertEquals(i, docValues.docID());  
            assertEquals(i, docValues.nextValue());
    public void testSequentialRowIdDocValuesCost() {
            assertTrue(docValues.advanceExact(i));
    public void testSequentialRowIdProducerReturnsSortedNumeric() {
            assertEquals(i, doc);  
        LuceneWriterDocValuesFormat.SequentialRowIdDocValues docValues = new LuceneWriterDocValuesFormat.SequentialRowIdDocValues(maxDoc);  
 * The OpenSearch Contributors require contributions made to  
        int maxDoc = randomIntBetween(5, 50);
    public void testSequentialRowIdDocValuesAdvance() {  
        // Test advanceExact  
        LuceneWriterDocValuesFormat format = new LuceneWriterDocValuesFormat(defaultFormat);  
        assertNull(producer.getSkipper(null));
 * compatible open source license.
        assertEquals(SortedNumericDocValues.NO_MORE_DOCS, docValues.nextDoc());  
    }
 *
        assertEquals(target, docValues.advance(target));  
import org.apache.lucene.codecs.DocValuesFormat;
 */  
        assertNull(producer.getNumeric(null));  
 * SPDX-License-Identifier: Apache-2.0
public class LuceneWriterDocValuesFormatTests extends OpenSearchTestCase {
        for (int i = 0; i < maxDoc; i++) {
import org.apache.lucene.index.SortedNumericDocValues;  
 * this file be licensed under the Apache-2.0 license or a
        int maxDoc = randomIntBetween(1, 1000);
}  
/**  
        assertNull(producer.getBinary(null));
        int target = 10;
 * Tests for {@link LuceneWriterDocValuesFormat} — verifies that the row ID rewriting
        int maxDoc = randomIntBetween(5, 100);  
        assertEquals(SortedNumericDocValues.NO_MORE_DOCS, docValues.advance(maxDoc));
