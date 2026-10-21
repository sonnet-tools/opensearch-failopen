        DataFormat secondaryFormat = mockFormat("parquet", 2, Set.of());
            }
            new RecordingDocumentInput(),
            }
    public void testGetSecondaryInputsReturnsUnmodifiableMap() {
    }
     */
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        expectThrows(NullPointerException.class, () -> new CompositeDocumentInput(null, new RecordingDocumentInput(), Map.of()));
        @Override
        DataFormat secondaryFormat1 = mockFormat("parquet", 2, Set.of());
        secondaries.put(secondaryFormat1, secondary1);
/**
    public void testConstructorRejectsNullSecondaryInputs() {
        Map<DataFormat, DocumentInput<?>> secondaries = composite.getSecondaryInputs();
        assertEquals(1, primaryInput.rowIds.size());
                return null;
 *
    public void testSetRowIdBroadcastsToAllInputs() {
            Map.of(secondaryFormat, secondaryInput)
        }
        composite.setRowId("__row_id__", 42L);
import java.util.Map;
    public void testAddFieldBroadcastsToAllFormats() {
import org.apache.lucene.search.Query;
        }
        CompositeDocumentInput composite = new CompositeDocumentInput(
        @Override
        DataFormat primaryFormat = mockFormat("lucene", 1, Set.of());
 */
import java.util.HashMap;
        assertSame(primaryFormat, composite.getPrimaryFormat());
            @Override
public class CompositeDocumentInputTests extends OpenSearchTestCase {
        CompositeDocumentInput composite = new CompositeDocumentInput(primaryFormat, primaryInput, Map.of(secondaryFormat, secondaryInput));
    }
import org.opensearch.search.lookup.SearchLookup;
        assertNull(composite.getFinalInput());
        DataFormat secondaryFormat = mockFormat("parquet", 2, Set.of());
import org.opensearch.index.mapper.MappedFieldType;
                return typeName;
        assertEquals(42L, (long) secondary2.rowIds.get(0));
    }
import org.opensearch.index.engine.dataformat.DataFormat;
 * The OpenSearch Contributors require contributions made to
        secondaries.put(secondaryFormat2, secondary2);
        public void close() {}
    }
            rowIds.add(rowId);
        };
import java.util.List;
    public void testGetFinalInputReturnsNull() {
        expectThrows(
        @Override
        return new DataFormat() {
        );
                return name;
        CompositeDocumentInput composite = new CompositeDocumentInput(
        assertEquals(1, secondary2.rowIds.size());
    }
            @Override
        RecordingDocumentInput primaryInput = new RecordingDocumentInput();
        public long getFieldCount(String fieldName) {
    private DataFormat mockFormat(String name, long priority, Set<FieldTypeCapabilities> fields) {
 * compatible open source license.
            addedFields.add(value);
        final List<Object> addedFields = new ArrayList<>();
                return priority;
        );
    }
        RecordingDocumentInput secondaryInput = new RecordingDocumentInput();
        assertEquals(1, secondary1.rowIds.size());
        RecordingDocumentInput secondary1 = new RecordingDocumentInput();
import org.opensearch.index.query.QueryShardContext;
import java.util.ArrayList;
    }
        DataFormat secondaryFormat2 = mockFormat("arrow", 3, Set.of());
        public Object getFinalInput() {
 */
            () -> secondaries.put(mockFormat("x", 0, Set.of()), new RecordingDocumentInput())
    public void testConstructorRejectsNullPrimaryFormat() {
        };
        final List<Long> rowIds = new ArrayList<>();
    }
        );
                return null;
        Map<DataFormat, DocumentInput<?>> secondaries = new HashMap<>();
        RecordingDocumentInput secondary2 = new RecordingDocumentInput();
        return new MappedFieldType(typeName, true, false, true, TextSearchInfo.NONE, Map.of()) {
     * Simple recording implementation of DocumentInput for test assertions.
            @Override
            }
            mockFormat("lucene", 1, Set.of()),
        assertEquals(1, secondaryInput.addedFields.size());
        }
    // --- helpers ---
            @Override
    public void testGetPrimaryFormatReturnsPrimaryDataFormat() {
        RecordingDocumentInput primaryInput = new RecordingDocumentInput();
        MappedFieldType keywordField = mockFieldType("keyword");
        assertEquals(42L, (long) secondary1.rowIds.get(0));
            return null;
/*
import java.util.Set;
 * this file be licensed under the Apache-2.0 license or a
            return 0;
        composite.addField(keywordField, "value1");
import org.opensearch.index.mapper.ValueFetcher;
        RecordingDocumentInput secondaryInput = new RecordingDocumentInput();
            @Override
        CompositeDocumentInput composite = new CompositeDocumentInput(mockFormat("lucene", 1, Set.of()), primaryInput, Map.of());
                return fields;
    public void testConstructorRejectsNullPrimaryInput() {
            public long priority() {
            public String name() {
            mockFormat("lucene", 1, Set.of()),
            }
}
        }
    /**
        @Override
        CompositeDocumentInput composite = new CompositeDocumentInput(primaryFormat, primaryInput, secondaries);
            public String typeName() {
import org.opensearch.index.mapper.TextSearchInfo;
    }
    private MappedFieldType mockFieldType(String typeName) {
            }
            public ValueFetcher valueFetcher(QueryShardContext context, SearchLookup searchLookup, String format) {
            @Override
    }
        expectThrows(NullPointerException.class, () -> new CompositeDocumentInput(mockFormat("lucene", 1, Set.of()), null, Map.of()));
        assertEquals(1, secondaries.size());
        );
import org.opensearch.index.engine.dataformat.DocumentInput;
        public void setRowId(String rowIdFieldName, long rowId) {
        CompositeDocumentInput composite = new CompositeDocumentInput(primaryFormat, new RecordingDocumentInput(), Map.of());
        expectThrows(
        public void addField(MappedFieldType fieldType, Object value) {
            Map.of()
    }
    static class RecordingDocumentInput implements DocumentInput<Object> {
            public Query termQuery(Object value, QueryShardContext context) {
            }
 * Tests for {@link CompositeDocumentInput}.
            () -> new CompositeDocumentInput(mockFormat("lucene", 1, Set.of()), new RecordingDocumentInput(), null)
        DataFormat primaryFormat = mockFormat("lucene", 1, Set.of());
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(1, primaryInput.addedFields.size());
    public void testGetPrimaryInputReturnsPrimaryDocumentInput() {
            NullPointerException.class,
            UnsupportedOperationException.class,
            public Set<FieldTypeCapabilities> supportedFields() {
        DataFormat primaryFormat = mockFormat("lucene", 1, Set.of());
        assertEquals(42L, (long) primaryInput.rowIds.get(0));
    }
        RecordingDocumentInput primaryInput = new RecordingDocumentInput();
            new RecordingDocumentInput(),
        assertSame(primaryInput, composite.getPrimaryInput());
package org.opensearch.composite;
        @Override
