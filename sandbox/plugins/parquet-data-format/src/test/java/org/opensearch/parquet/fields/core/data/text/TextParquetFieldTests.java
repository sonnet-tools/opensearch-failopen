 * compatible open source license.
    private ManagedVSR createVSR(String id, ParquetField pf, String fieldName) {  
        KeywordParquetField field = new KeywordParquetField();  
import org.opensearch.index.mapper.IpFieldMapper;
import org.apache.arrow.vector.VarBinaryVector;  
        allocator = new RootAllocator();  
import org.opensearch.index.mapper.KeywordFieldMapper;  
    @Override  
        byte[] bytes = ((VarBinaryVector) vsr.getVector("val")).get(0);  
    }  
        field.createField(ft, vsr, "hello world");  
    }
        cleanupVSR(vsr);
        MappedFieldType ft = new IpFieldMapper.IpFieldType("val");
 * this file be licensed under the Apache-2.0 license or a
    public void testIpFieldAddToGroup() throws Exception {
    }
    private void cleanupVSR(ManagedVSR vsr) {  
        vsr.setRowCount(1);
    public void testKeywordFieldArrowType() {
        assertTrue(new TextParquetField().getFieldType().isNullable());
        BufferAllocator child = allocator.newChildAllocator(id, 0, Long.MAX_VALUE);
        TextParquetField field = new TextParquetField();  
import org.apache.arrow.vector.types.pojo.Field;  
 *
import org.opensearch.index.mapper.MappedFieldType;
    public void testTextFieldArrowType() {  
        ManagedVSR vsr = createVSR("text-test", field, "val");
import org.apache.arrow.vector.types.pojo.ArrowType;
        vsr.close();
import org.opensearch.parquet.fields.ParquetField;  
    public void testKeywordFieldAddToGroup() {
        MappedFieldType ft = new KeywordFieldMapper.KeywordFieldType("val");
    public void testTextFieldAddToGroup() {
    }
        assertNotNull(bytes);
        return new ManagedVSR(id, schema, child);  
    }  
 */  
import org.opensearch.parquet.vsr.ManagedVSR;
        Schema schema = new Schema(List.of(new Field(fieldName, pf.getFieldType(), null)));
    public void tearDown() throws Exception {
package org.opensearch.parquet.fields.core.data.text;
        allocator.close();
import org.opensearch.index.mapper.TextFieldMapper;
        cleanupVSR(vsr);  
        cleanupVSR(vsr);
    private BufferAllocator allocator;
        IpParquetField field = new IpParquetField();  
    }
        ManagedVSR vsr = createVSR("kw-test", field, "val");
    }
        byte[] bytes = ((VarCharVector) vsr.getVector("val")).get(0);
    }  
        field.createField(ft, vsr, "my_keyword");  
        vsr.setRowCount(1);
        assertTrue(new IpParquetField().getArrowType() instanceof ArrowType.Binary);
        assertTrue(new KeywordParquetField().getArrowType() instanceof ArrowType.Utf8);
        field.createField(ft, vsr, addr);
 * The OpenSearch Contributors require contributions made to  
        assertEquals("my_keyword", new String(bytes, StandardCharsets.UTF_8));  
/*  
    }  
import org.apache.arrow.vector.types.pojo.Schema;
        super.tearDown();  
import org.opensearch.test.OpenSearchTestCase;
import java.nio.charset.StandardCharsets;
    }
import org.apache.arrow.memory.BufferAllocator;
import java.net.InetAddress;
    public void testIpFieldArrowType() {
        MappedFieldType ft = new TextFieldMapper.TextFieldType("val");
    @Override  
        ManagedVSR vsr = createVSR("ip-test", field, "val");
        assertTrue(new TextParquetField().getArrowType() instanceof ArrowType.Utf8);
}
        assertEquals("hello world", new String(bytes, StandardCharsets.UTF_8));  
import org.apache.arrow.vector.VarCharVector;
        assertTrue(bytes.length > 0);
        InetAddress addr = InetAddress.getByName("127.0.0.1");  
        super.setUp();
    public void setUp() throws Exception {
        vsr.setRowCount(1);
        byte[] bytes = ((VarCharVector) vsr.getVector("val")).get(0);
        vsr.moveToFrozen();
import java.util.List;  
 * SPDX-License-Identifier: Apache-2.0
import org.apache.arrow.memory.RootAllocator;
public class TextParquetFieldTests extends OpenSearchTestCase {
