        assertEquals("doc-id-1", new String(result, StandardCharsets.UTF_8));
import org.apache.arrow.vector.types.pojo.ArrowType;
        vsr.moveToFrozen();
 */  
        byte[] result = ((VarCharVector) vsr.getVector("_routing")).get(0);
import static org.mockito.Mockito.mock;
 *
        assertTrue(new IdParquetField().getArrowType() instanceof ArrowType.Binary);  
        vsr.close();  
        ManagedVSR vsr = createVSR("routing-test", field, "_routing");
    private ManagedVSR createVSR(String id, ParquetField pf, String fieldName) {
        return new ManagedVSR(id, schema, child);
        MappedFieldType ft = mockFieldType("_id");
package org.opensearch.parquet.fields.core.metadata;
    }
import org.opensearch.parquet.vsr.ManagedVSR;
/*  
    private BufferAllocator allocator;  
        when(ft.name()).thenReturn(name);  
        assertEquals("shard-0", new String(result, StandardCharsets.UTF_8));
 * compatible open source license.
        cleanupVSR(vsr);  
        vsr.setRowCount(1);  
        ManagedVSR vsr = createVSR("id-test", field, "_id");  
        vsr.setRowCount(1);  
        IdParquetField field = new IdParquetField();
        cleanupVSR(vsr);  
import org.apache.arrow.vector.types.pojo.Schema;
 * The OpenSearch Contributors require contributions made to  
    }
 * SPDX-License-Identifier: Apache-2.0
import static org.mockito.Mockito.when;
    public void testRoutingFieldArrowType() {  
import java.nio.charset.StandardCharsets;
    public void testRoutingFieldAddToGroup() {
import org.apache.arrow.vector.types.pojo.Field;  
    }  
import org.apache.arrow.vector.VarBinaryVector;  
        allocator = new RootAllocator();
        super.setUp();
import java.util.List;
    }
        assertTrue(new IgnoredParquetField().getArrowType() instanceof ArrowType.Utf8);
        field.createField(ft, vsr, "shard-0");
        MappedFieldType ft = mock(MappedFieldType.class);
    public void testIdFieldAddToGroup() {  
        field.createField(ft, vsr, ref);
    @Override
import org.apache.arrow.memory.RootAllocator;
    public void testIdFieldArrowType() {
    }  
        return ft;
import org.opensearch.parquet.fields.ParquetField;  
    public void setUp() throws Exception {  
    }
    }
    @Override
        byte[] result = ((VarBinaryVector) vsr.getVector("_id")).get(0);
        byte[] ref = "doc-id-1".getBytes(StandardCharsets.UTF_8);
 * this file be licensed under the Apache-2.0 license or a
        RoutingParquetField field = new RoutingParquetField();
    public void tearDown() throws Exception {  
import org.apache.arrow.memory.BufferAllocator;
public class MetadataParquetFieldTests extends OpenSearchTestCase {
        MappedFieldType ft = mockFieldType("_routing");  
    public void testIgnoredFieldArrowType() {  
        Schema schema = new Schema(List.of(new Field(fieldName, pf.getFieldType(), null)));
        assertTrue(new RoutingParquetField().getArrowType() instanceof ArrowType.Utf8);
import org.opensearch.test.OpenSearchTestCase;
        super.tearDown();
    }
import org.apache.arrow.vector.VarCharVector;
}
    }
    private MappedFieldType mockFieldType(String name) {
        allocator.close();
    private void cleanupVSR(ManagedVSR vsr) {
        BufferAllocator child = allocator.newChildAllocator(id, 0, Long.MAX_VALUE);  
import org.opensearch.index.mapper.MappedFieldType;
    }
