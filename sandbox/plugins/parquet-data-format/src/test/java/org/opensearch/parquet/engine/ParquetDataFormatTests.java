package org.opensearch.parquet.engine;
}  
 * this file be licensed under the Apache-2.0 license or a
        for (var ftc : fields) {
    public void testSupportedFieldsContainsColumnarStorage() {
 * SPDX-License-Identifier: Apache-2.0
        var fields = new ParquetDataFormat().supportedFields();  
    public void testName() {  
        assertEquals("parquet", new ParquetDataFormat().name());
 *
    }  
        }
public class ParquetDataFormatTests extends OpenSearchTestCase {
import org.opensearch.test.OpenSearchTestCase;
        assertEquals(0L, new ParquetDataFormat().priority());
    }
/*  
    public void testPriority() {
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
        assertFalse(fields.isEmpty());
    }
                ftc.capabilities().contains(FieldTypeCapabilities.Capability.COLUMNAR_STORAGE)
                "filed: " + ftc + " should have columnar support",
            assertTrue(  
 */  
 * The OpenSearch Contributors require contributions made to  
            );  
 * compatible open source license.
