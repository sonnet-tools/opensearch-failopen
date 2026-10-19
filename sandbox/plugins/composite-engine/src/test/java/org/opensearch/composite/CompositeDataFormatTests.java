 */
    }
        FieldTypeCapabilities cap2 = new FieldTypeCapabilities("integer", Set.of(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE));
        CompositeDataFormat format = new CompositeDataFormat(primary, List.of(primary));  
    }
    public void testPriorityReturnsMinValue() {
        DataFormat f2 = mockFormat("parquet", 2, Set.of());  
            @Override
        assertTrue(str.contains("CompositeDataFormat"));
    }
    }
        CompositeDataFormat composite = new CompositeDataFormat(primary, List.of(primary, secondary));
    public void testGetDataFormatsIsUnmodifiable() {
 * Tests for {@link CompositeDataFormat}.  
package org.opensearch.composite;
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
 *
    public void testNameReturnsComposite() {
        DataFormat primary = mockFormat("lucene", 1, Set.of());
            }
        assertEquals("composite", format.name());
    }
        assertEquals(Long.MIN_VALUE, format.priority());
 * this file be licensed under the Apache-2.0 license or a
    public void testToStringContainsClassName() {
    public void testGetPrimaryDataformatReturnsPrimary() {
        DataFormat f1 = mockFormat("lucene", 1, Set.of());
        FieldTypeCapabilities cap1 = new FieldTypeCapabilities("keyword", Set.of(FieldTypeCapabilities.Capability.FULL_TEXT_SEARCH));  
        expectThrows(NullPointerException.class, () -> new CompositeDataFormat(null, List.of()));
    }
        CompositeDataFormat composite = new CompositeDataFormat(primary, List.of(primary));  
    }
            @Override
    public void testConstructorRejectsNullPrimaryDataformat() {  
    public void testGetDataFormatsReturnsAllFormats() {
        String str = composite.toString();
        // supportedFields() returns the first format's fields  
        CompositeDataFormat format = new CompositeDataFormat(primary, List.of(primary));  
        DataFormat primary = mockFormat("lucene", 1, Set.of());
        DataFormat primary = mockFormat("lucene", 1, Set.of(cap1));
                return fields;
                return priority;  
    public void testConstructorRejectsNullDataFormats() {
public class CompositeDataFormatTests extends OpenSearchTestCase {
        };
    }  
import org.opensearch.test.OpenSearchTestCase;  
import org.opensearch.index.engine.dataformat.DataFormat;
        assertTrue(str.contains("dataFormats="));  
 * SPDX-License-Identifier: Apache-2.0
        assertSame(f2, composite.getDataFormats().get(1));
            public String name() {  
        DataFormat primary = mockFormat("lucene", 1, Set.of());
import java.util.List;
        expectThrows(UnsupportedOperationException.class, () -> composite.getDataFormats().add(mockFormat("x", 0, Set.of())));
        DataFormat primary = mockFormat("lucene", 1, Set.of());
        DataFormat secondary = mockFormat("parquet", 2, Set.of());  
    }
 * The OpenSearch Contributors require contributions made to  
    }
        DataFormat primary = mockFormat("lucene", 1, Set.of());
            @Override  
        CompositeDataFormat composite = new CompositeDataFormat(primary, List.of(primary, secondary));
            public Set<FieldTypeCapabilities> supportedFields() {
        assertSame(f1, composite.getDataFormats().get(0));  
        DataFormat secondary = mockFormat("parquet", 2, Set.of(cap2));  
        CompositeDataFormat composite = new CompositeDataFormat(f1, List.of(f1, f2));
        DataFormat primary = mockFormat("lucene", 1, Set.of());
            public long priority() {
        DataFormat primary = mockFormat("lucene", 1, Set.of());
        CompositeDataFormat composite = new CompositeDataFormat(primary, List.of(primary));  
        assertEquals(2, composite.getDataFormats().size());
                return name;
    }
    public void testSupportedFieldsDelegatesToFirstFormat() {
import java.util.Set;  
            }
/**
 * compatible open source license.
    public void testSupportedFieldsEmptyWhenNoFormats() {
        assertEquals(Set.of(cap1), composite.supportedFields());
        expectThrows(NullPointerException.class, () -> new CompositeDataFormat(primary, null));  
}  
        return new DataFormat() {
 */  
/*  
            }  
        assertSame(primary, composite.getPrimaryDataFormat());
        assertEquals(Set.of(), composite.supportedFields());
    private DataFormat mockFormat(String name, long priority, Set<FieldTypeCapabilities> fields) {  
        CompositeDataFormat composite = new CompositeDataFormat(primary, List.of());  
