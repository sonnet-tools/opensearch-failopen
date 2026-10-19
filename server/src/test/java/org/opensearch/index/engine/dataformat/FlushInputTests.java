/**  
 */  
 * Tests for {@link FlushInput}.
    }
        assertEquals(0L, input.rowIdMapping().getNewRowId(1, RowIdMapping.SINGLE_GEN));
        assertTrue(input.hasRowIdMapping());
    public void testNullMappingHasNoRowIdMapping() {
import org.opensearch.test.OpenSearchTestCase;
        long[] oldToNew = { 2, 0, 1 };
}
    public void testValidMappingHasRowIdMapping() {  
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.index.engine.dataformat;
        assertNull(FlushInput.EMPTY.rowIdMapping());
        assertEquals(3, input.rowIdMapping().size());  
        assertFalse(FlushInput.EMPTY.hasRowIdMapping());  
 */
/*  
        FlushInput input = new FlushInput((RowIdMapping) null);
        assertFalse(input.hasRowIdMapping());  
        FlushInput input = new FlushInput(mapping);  
        assertEquals(2L, input.rowIdMapping().getNewRowId(0, RowIdMapping.SINGLE_GEN));
 * SPDX-License-Identifier: Apache-2.0
    }
 * this file be licensed under the Apache-2.0 license or a
        RowIdMapping mapping = new PackedRowIdMapping(oldToNew, true);
    public void testEmptyHasNoRowIdMapping() {
public class FlushInputTests extends OpenSearchTestCase {  
        assertNotNull(input.rowIdMapping());
    }
 * compatible open source license.
 *
        assertEquals(1L, input.rowIdMapping().getNewRowId(2, RowIdMapping.SINGLE_GEN));  
