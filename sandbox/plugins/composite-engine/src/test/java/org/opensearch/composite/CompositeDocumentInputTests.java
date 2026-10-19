    private MappedFieldType mockFieldType(String typeName) {
        CompositeDocumentInput composite = new CompositeDocumentInput(primaryFormat, new RecordingDocumentInput(), Map.of());  
     * Simple recording implementation of DocumentInput for test assertions.  
        );  
    }
        CompositeDocumentInput composite = new CompositeDocumentInput(
        final List<Object> addedFields = new ArrayList<>();  
        @Override
        CompositeDocumentInput composite = new CompositeDocumentInput(primaryFormat, primaryInput, Map.of(secondaryFormat, secondaryInput));  
    public void testGetSecondaryInputsReturnsUnmodifiableMap() {
        Map<DataFormat, DocumentInput<?>> secondaries = new HashMap<>();  
import org.apache.lucene.search.Query;
    public void testConstructorRejectsNullPrimaryInput() {
            public Query termQuery(Object value, QueryShardContext context) {
            @Override
                return fields;
            }
        expectThrows(NullPointerException.class, () -> new CompositeDocumentInput(mockFormat("lucene", 1, Set.of()), null, Map.of()));  
    }
        DataFormat secondaryFormat2 = mockFormat("arrow", 3, Set.of());
        CompositeDocumentInput composite = new CompositeDocumentInput(primaryFormat, primaryInput, secondaries);
            @Override  
        RecordingDocumentInput primaryInput = new RecordingDocumentInput();  
    public void testAddFieldBroadcastsToAllFormats() {
        expectThrows(
            public String name() {  
            addedFields.add(value);
        public long getFieldCount(String fieldName) {
            return 0;
import java.util.Set;
import org.opensearch.test.OpenSearchTestCase;
    }
            Map.of()
    static class RecordingDocumentInput implements DocumentInput<Object> {
        RecordingDocumentInput secondary1 = new RecordingDocumentInput();
    public void testConstructorRejectsNullPrimaryFormat() {
        DataFormat primaryFormat = mockFormat("lucene", 1, Set.of());  
            NullPointerException.class,
        }
        assertSame(primaryFormat, composite.getPrimaryFormat());
    public void testSetRowIdBroadcastsToAllInputs() {  
        composite.addField(keywordField, "value1");  
        final List<Long> rowIds = new ArrayList<>();
        @Override  
        @Override
        assertEquals(1, secondary2.rowIds.size());  
import java.util.HashMap;
        assertEquals(1, primaryInput.addedFields.size());
 * this file be licensed under the Apache-2.0 license or a
        DataFormat primaryFormat = mockFormat("lucene", 1, Set.of());
            @Override
import org.opensearch.index.engine.dataformat.DocumentInput;  
import org.opensearch.search.lookup.SearchLookup;  
        composite.setRowId("__row_id__", 42L);  
            () -> secondaries.put(mockFormat("x", 0, Set.of()), new RecordingDocumentInput())  
        RecordingDocumentInput secondaryInput = new RecordingDocumentInput();  
            }
            return null;  
        RecordingDocumentInput primaryInput = new RecordingDocumentInput();
        assertEquals(1, secondaries.size());  
import org.opensearch.index.mapper.MappedFieldType;
        DataFormat secondaryFormat1 = mockFormat("parquet", 2, Set.of());  
            }  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        };
            public String typeName() {
        MappedFieldType keywordField = mockFieldType("keyword");
    }
import java.util.ArrayList;  
        assertNull(composite.getFinalInput());
        DataFormat secondaryFormat = mockFormat("parquet", 2, Set.of());
        CompositeDocumentInput composite = new CompositeDocumentInput(
import org.opensearch.index.mapper.ValueFetcher;
        assertSame(primaryInput, composite.getPrimaryInput());
        public void setRowId(String rowIdFieldName, long rowId) {  
    public void testConstructorRejectsNullSecondaryInputs() {  
        RecordingDocumentInput secondary2 = new RecordingDocumentInput();  
            public long priority() {
                return null;  
            new RecordingDocumentInput(),
        @Override  
            }
    /**
            mockFormat("lucene", 1, Set.of()),  
 */  
        assertEquals(42L, (long) primaryInput.rowIds.get(0));  
    }
            @Override  
    }  
        }  
        }
import org.opensearch.index.query.QueryShardContext;
        return new MappedFieldType(typeName, true, false, true, TextSearchInfo.NONE, Map.of()) {
        assertEquals(1, primaryInput.rowIds.size());
            public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {  
            UnsupportedOperationException.class,
        secondaries.put(secondaryFormat2, secondary2);
        public void addField(MappedFieldType fieldType, Object value) {
                return priority;  
            @Override
 * Tests for {@link CompositeDocumentInput}.
     */
 *
    // --- helpers ---
 */
        );  
        assertEquals(42L, (long) secondary2.rowIds.get(0));
import org.opensearch.index.engine.dataformat.DataFormat;
    }
        assertEquals(42L, (long) secondary1.rowIds.get(0));
        expectThrows(
                return name;
            }
/**  
    public void testGetFinalInputReturnsNull() {
import java.util.List;
        };
 * The OpenSearch Contributors require contributions made to  
                return typeName;
        RecordingDocumentInput primaryInput = new RecordingDocumentInput();
            mockFormat("lucene", 1, Set.of()),  
public class CompositeDocumentInputTests extends OpenSearchTestCase {  
        assertEquals(1, secondaryInput.addedFields.size());  
        expectThrows(NullPointerException.class, () -> new CompositeDocumentInput(null, new RecordingDocumentInput(), Map.of()));
    }
        @Override
        }  
        return new DataFormat() {
            () -> new CompositeDocumentInput(mockFormat("lucene", 1, Set.of()), new RecordingDocumentInput(), null)  
    }
        assertEquals(1, secondary1.rowIds.size());
            new RecordingDocumentInput(),
import java.util.Map;  
        RecordingDocumentInput secondaryInput = new RecordingDocumentInput();
        );
package org.opensearch.composite;
            rowIds.add(rowId);
            public Set<FieldTypeCapabilities> supportedFields() {
    }
 * SPDX-License-Identifier: Apache-2.0
    private DataFormat mockFormat(String name, long priority, Set<FieldTypeCapabilities> fields) {  
            Map.of(secondaryFormat, secondaryInput)
    public void testGetPrimaryFormatReturnsPrimaryDataFormat() {
/*  
        Map<DataFormat, DocumentInput<?>> secondaries = composite.getSecondaryInputs();
        CompositeDocumentInput composite = new CompositeDocumentInput(mockFormat("lucene", 1, Set.of()), primaryInput, Map.of());  
                return null;
        public void close() {}  
        secondaries.put(secondaryFormat1, secondary1);
import org.opensearch.index.mapper.TextSearchInfo;  
            @Override
}
            }  
 * compatible open source license.
        public Object getFinalInput() {
    }
        DataFormat secondaryFormat = mockFormat("parquet", 2, Set.of());
    }  
        DataFormat primaryFormat = mockFormat("lucene", 1, Set.of());
        );
    public void testGetPrimaryInputReturnsPrimaryDocumentInput() {
