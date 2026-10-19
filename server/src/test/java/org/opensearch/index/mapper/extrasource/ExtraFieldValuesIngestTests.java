            b.endObject();
        );
                }
        assertThat(doc.rootDoc().getField("double_field_dim").numericValue().intValue(), is(2));  
            "1",  
            }
                {  
            source.source(),
                "double_field",
                {
            }  
                }  
                LongArrayValue.fromLongArray(new long[] { 100L, 200L }),
            source.source(),
        }));
import static org.hamcrest.Matchers.is;
            b.startObject("int_field");
        assertThat(doc.rootDoc().getField("long_field_dim").numericValue().intValue(), is(2));
        SourceToParse stp = new SourceToParse(
import static org.hamcrest.Matchers.notNullValue;
        assertThat(doc.rootDoc().getField("obj.vec_f0").numericValue().floatValue(), is(10.5f));
        );  
            }  
            source.source(),
    }
                    }
                    b.endObject();
 *
                "long_field",  
            MediaType.fromMediaType(source.getMediaType().mediaType()),
            null,  
import org.opensearch.core.common.bytes.BytesArray;
        );
import java.util.Map;
                b.field("type", ExtraFieldValuesMapperPlugin.EXTRA_FIELDS_TEST);
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("obj.vec", FloatArrayValue.fromFloatArray(new float[] { 10.5f, 20.25f })));
        assertThat(doc.rootDoc().getField("long_field_type").binaryValue().utf8ToString(), is("LONG_ARRAY"));
        SourceToParse stp = new SourceToParse(
        IndexableField f = doc.rootDoc().getField("field");
            null,  
            b.endObject();  
            {
            b.startObject("obj");
        );
 * The OpenSearch Contributors require contributions made to  
            {  
        // _source does NOT contain "field"
            "1",
                    }
import static org.hamcrest.Matchers.containsString;  
    }  
                "int_field",
    public void testExtraFieldValues_numericArrayTypes() throws Exception {
 * this file be licensed under the Apache-2.0 license or a
                b.field("type", ExtraFieldValuesMapperPlugin.EXTRA_FIELDS_TEST);
        var source = source(b -> b.field("other", "x"));
    public void testExtraFieldValues_bytes_rootField() throws Exception {
                b.startObject("properties");
        ExtraFieldValues efv = new ExtraFieldValues(
        assertThat(doc.rootDoc().getField("long_field_l0").numericValue().longValue(), is(100L));  
 * SPDX-License-Identifier: Apache-2.0
            }
package org.opensearch.index.mapper.extrasource;
                b.endObject();
        DocumentMapper dm = createDocumentMapper(mapping(b -> {  
            b.endObject();
import org.opensearch.index.mapper.MapperParsingException;
            MediaType.fromMediaType(source.getMediaType().mediaType()),
            b.endObject();
            efv
 */  
            {
        assertThat(doc.rootDoc().getField("obj.vec_dim").numericValue().intValue(), is(2));
        ParsedDocument doc = dm.parse(stp);
    }
        ParsedDocument doc = dm.parse(stp);
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("wrong_field", new BytesValue(new BytesArray(new byte[] { 1 }))));  
        SourceToParse stp = new SourceToParse(
                b.field("type", "object");
                    {  
            "test",  
        DocumentMapper dm = createDocumentMapper(mapping(b -> {
            null,
                IntArrayValue.fromIntArray(new int[] { 10, 20 }),
        var source = source(b -> b.field("other", "x"));  
                b.field("type", "object");
            "1",  
        DocumentMapper dm = createDocumentMapper(mapping(b -> {
            {
                    b.startObject("vec");
        var source = source(b -> b.field("other", "x"));  
                    b.endObject();  
        ParsedDocument doc = dm.parse(stp);
            "test",
                    b.startObject("x");
        var source = source(b -> b.field("other", "x"));  
import org.opensearch.index.mapper.MapperServiceTestCase;  
        SourceToParse stp = new SourceToParse(
                b.field("type", ExtraFieldValuesMapperPlugin.EXTRA_FIELDS_TEST);  
            efv
            }
            null,  
    }  
        assertThat(doc.rootDoc().getField("field_type").binaryValue().utf8ToString(), is("BYTES"));  
public class ExtraFieldValuesIngestTests extends MapperServiceTestCase {
            b.startObject("long_field");  
        assertThat(f, notNullValue());  
            "test",
        assertThat(f.binaryValue().length, is(4));
import org.opensearch.index.mapper.SourceToParse;
            b.startObject("double_field");
        );
            source.source(),
    public void testExtraFieldValues_floatArray_nestedObjectPath() throws Exception {  
        assertThat(doc.rootDoc().getField("double_field_type").binaryValue().utf8ToString(), is("DOUBLE_ARRAY"));
        DocumentMapper dm = createDocumentMapper(fieldMapping(b -> b.field("type", ExtraFieldValuesMapperPlugin.EXTRA_FIELDS_TEST)));  
            "1",  
            Map.of(  
            efv
        assertThat(doc.rootDoc().getField("double_field_d0").numericValue().doubleValue(), is(1.5d));
        ExtraFieldValues efv = new ExtraFieldValues(Map.of("field", new BytesValue(new BytesArray(new byte[] { 1, 2, 3, 4 }))));
        }));
        assertThat(e.getMessage(), containsString("No mapper found for extra field [wrong_field]"));  
                    {
    @Override  
            )
        assertThat(doc.rootDoc().getField("int_field_i0").numericValue().intValue(), is(10));
                b.startObject("properties");  
                b.endObject();
import java.util.Collection;
 * compatible open source license.
    public void testExtraFieldValues_throwsIfNoMapper() throws Exception {
                        b.field("type", ExtraFieldValuesMapperPlugin.EXTRA_FIELDS_TEST);  
    protected Collection<? extends Plugin> getPlugins() {
        assertThat(doc.rootDoc().getField("int_field_type").binaryValue().utf8ToString(), is("INT_ARRAY"));  
import org.opensearch.index.mapper.DocumentMapper;
            MediaType.fromMediaType(source.getMediaType().mediaType()),
import org.opensearch.index.mapper.ParsedDocument;
        assertThat(doc.rootDoc().getField("obj.vec_type").binaryValue().utf8ToString(), is("FLOAT_ARRAY"));  
import java.util.Collections;  
        }));
        assertThat(doc.rootDoc().getField("field_len").numericValue().intValue(), is(4));  
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> dm.parse(stp));
            MediaType.fromMediaType(source.getMediaType().mediaType()),  
            "test",
import org.opensearch.plugins.Plugin;  
        return Collections.singletonList(new ExtraFieldValuesMapperPlugin());
        assertThat(doc.rootDoc().getField("int_field_dim").numericValue().intValue(), is(2));
            b.startObject("obj");  
    }
            b.endObject();  
import org.apache.lucene.index.IndexableField;
                DoubleArrayValue.fromDoubleArray(new double[] { 1.5d, 2.5d })  
}
import org.opensearch.core.xcontent.MediaType;  
/*  
            efv
            {  
                        b.field("type", "keyword");
