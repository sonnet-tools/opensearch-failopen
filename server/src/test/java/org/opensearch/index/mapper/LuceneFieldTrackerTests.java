    // -----------------------------------------------------------------------
        tracker.setFieldInfos(fieldInfos);
                false,
        LuceneFieldTracker tracker = new LuceneFieldTracker();
        tracker.setFieldInfos(FieldInfos.EMPTY);
    public void testMultipleSetCallsPreservesLastValue() {
import org.apache.lucene.index.FieldInfo;  
    public void testSetEmptyFieldInfosClearsFields() {
    }
                -1,
    // Tests
 * this file be licensed under the Apache-2.0 license or a
        tracker.setFieldInfos(makeFieldInfos("second"));
        assertEquals(3, tracker.getFieldInfos().size());  
                DocValuesType.NONE,
    // -----------------------------------------------------------------------  
 * SPDX-License-Identifier: Apache-2.0
    }
        for (int i = 0; i < names.length; i++) {  
import java.util.Collections;
        tracker.setFieldInfos(makeFieldInfos("first"));  
        assertNull("old field must no longer be present", tracker.getFieldInfos().fieldInfo("old"));
 * compatible open source license.
        assertSame(newInfos, tracker.getFieldInfos());  
package org.opensearch.index.mapper;
    private static FieldInfos makeFieldInfos(String... names) {
        tracker.setFieldInfos(makeFieldInfos("a", "b", "c"));
        assertNotNull(tracker.getFieldInfos().fieldInfo("only_field"));
    }
        tracker.setFieldInfos(makeFieldInfos("only_field"));
    }
import org.apache.lucene.index.DocValuesType;
        LuceneFieldTracker tracker = new LuceneFieldTracker();
    // -----------------------------------------------------------------------
        LuceneFieldTracker tracker = new LuceneFieldTracker();
        assertNull(tracker.getFieldInfos().fieldInfo("unknown_field"));
        LuceneFieldTracker tracker = new LuceneFieldTracker();  
public class LuceneFieldTrackerTests extends OpenSearchTestCase {  
    }  
        assertNull(tracker.getFieldInfos().fieldInfo("second"));  
        tracker.setFieldInfos(newInfos);
    /** Creates a {@link FieldInfos} containing the given field names. */  
        assertEquals(1, tracker.getFieldInfos().size());  
        LuceneFieldTracker tracker = new LuceneFieldTracker();
                0,
        assertEquals("known_field", tracker.getFieldInfos().fieldInfo("known_field").name);
 */  
        tracker.setFieldInfos(makeFieldInfos("old"));  
import org.apache.lucene.index.VectorSimilarityFunction;
import org.apache.lucene.index.VectorEncoding;  
 *
    // Helper  
        assertNotNull(tracker.getFieldInfos().fieldInfo("third"));
        }  
                VectorSimilarityFunction.EUCLIDEAN,
    public void testInitialStateIsEmpty() {
    public void testFieldInfoLookupReturnsFiForKnownField() {  
        tracker.setFieldInfos(makeFieldInfos("a", "b"));
        assertEquals(0, tracker.getFieldInfos().size());
                0,  
                VectorEncoding.FLOAT32,
                false,  
        tracker.setFieldInfos(makeFieldInfos("third"));
import org.apache.lucene.index.IndexOptions;
 * The OpenSearch Contributors require contributions made to  
        assertNotNull(tracker.getFieldInfos().fieldInfo("known_field"));  
                names[i],
                DocValuesSkipIndexType.NONE,  
        FieldInfos newInfos = makeFieldInfos("new_a", "new_b");
    }
        tracker.setFieldInfos(makeFieldInfos("known_field"));
        LuceneFieldTracker tracker = new LuceneFieldTracker();
import org.apache.lucene.index.FieldInfos;
    // -----------------------------------------------------------------------
        assertSame("initial FieldInfos must be EMPTY", FieldInfos.EMPTY, tracker.getFieldInfos());
    }
        FieldInfos fieldInfos = makeFieldInfos("alpha", "beta", "gamma");
        return new FieldInfos(infos);
    }  
                false,
}
            );
    }
    public void testSetFieldInfosReplacesOldValue() {
                Collections.emptyMap(),
    public void testFieldInfosSizeReflectsFieldCount() {  
        assertNull(tracker.getFieldInfos().fieldInfo("first"));
import org.opensearch.test.OpenSearchTestCase;
                0,  
                false,  
        LuceneFieldTracker tracker = new LuceneFieldTracker();  
        tracker.setFieldInfos(makeFieldInfos("known_field"));  
        assertEquals(1, tracker.getFieldInfos().size());  
    public void testFieldInfoLookupReturnsNullForUnknownField() {
                IndexOptions.NONE,
                0,
        assertEquals(2, tracker.getFieldInfos().size());
    public void testSetAndGetFieldInfosRoundTrip() {
        assertEquals(0, tracker.getFieldInfos().size());  
/*  
                false
                i,  
        assertSame(fieldInfos, tracker.getFieldInfos());  
            infos[i] = new FieldInfo(
    public void testSetFieldInfosWithSingleField() {  
        LuceneFieldTracker tracker = new LuceneFieldTracker();  
    }
        FieldInfo[] infos = new FieldInfo[names.length];
import org.apache.lucene.index.DocValuesSkipIndexType;
        LuceneFieldTracker tracker = new LuceneFieldTracker();
