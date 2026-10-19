        IndexFieldData<?> valueFieldData = getForField("field._value");  
            .startArray("fooooooooooo")
            .startObject("test")
        final DocumentMapper mapper = mapperService.documentMapperParser().parse("test", new CompressedXContent(mapping));
/*  
import org.opensearch.core.common.bytes.BytesReference;  
    }
public class FlatObjectFieldDataTests extends AbstractFieldDataTestCase {
            .endArray()  
            .startObject("test")
import org.apache.lucene.index.LeafReaderContext;  
        writer.addDocument(d.rootDoc());
            .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
import org.opensearch.common.compress.CompressedXContent;
        writer.addDocument(d.rootDoc());  
import org.opensearch.index.fielddata.AbstractFieldDataTestCase;  
    public void testLongFieldNameWithHashArray() throws Exception {
            .startObject()  
            .endObject()
            .startObject("field")  
import org.opensearch.index.fielddata.IndexFieldData;
 * this file be licensed under the Apache-2.0 license or a
 */  
            .field("name", "baz")
 * compatible open source license.
}
    protected String getFieldDataType() {
            .field("type", FIELD_TYPE)
    private String FIELD_TYPE = "flat_object";  
        assertEquals(1, readers.size());
        XContentBuilder json = XContentFactory.jsonBuilder()
            .startObject("properties")
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
            .startObject()  
            .endObject()
    }  
        assertEquals(1, valueReaders.size());  
        ParsedDocument d = mapper.parse(new SourceToParse("test", "1", BytesReference.bytes(json), MediaTypeRegistry.JSON));
        IndexFieldData<?> fieldData = getForField("field");
import org.opensearch.core.xcontent.MediaTypeRegistry;
            .endObject()  
    }
 *
        List<LeafReaderContext> readers = refreshReader();
        IndexFieldData<?> fieldData = getForField("field");  
        return true;
        XContentBuilder json = XContentFactory.jsonBuilder().startObject().startObject("field").field("foo", "bar").endObject().endObject();  
            .endObject()  
            .endObject()
            .toString();
 * The OpenSearch Contributors require contributions made to  
            .startObject()
    public void testDocValue() throws Exception {
        assertEquals(1, readers.size());
        writer.commit();  
        List<LeafReaderContext> valueReaders = refreshReader();
            .startObject("field")
            .toString();  
            .field("type", FIELD_TYPE)
            .endObject()
    protected boolean hasDocValues() {  
        final DocumentMapper mapper = mapperService.documentMapperParser().parse("test", new CompressedXContent(mapping));
    @Override
            .startObject()
            .startObject()  
        writer.commit();
            .endObject()  
        String mapping = XContentFactory.jsonBuilder()  
            .endObject()
            .endObject()
import org.opensearch.common.xcontent.XContentFactory;
            .endObject()
            .endObject()
    @Override  
        IndexFieldData<?> valueFieldData = getForField("field._value");
            .startObject("properties")  
        assertEquals(1, valueReaders.size());
            .startObject("field")  
        ParsedDocument d = mapper.parse(new SourceToParse("test", "1", BytesReference.bytes(json), MediaTypeRegistry.JSON));
        List<LeafReaderContext> valueReaders = refreshReader();
            .endObject();  
        return FIELD_TYPE;
        String mapping = XContentFactory.jsonBuilder()
package org.opensearch.index.mapper;
            .field("name", "baz")
    }  
            .startObject("detail")
        List<LeafReaderContext> readers = refreshReader();  
