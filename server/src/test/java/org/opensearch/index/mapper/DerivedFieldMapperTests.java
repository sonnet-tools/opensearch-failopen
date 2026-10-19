    }  
            b.field("type", "keyword");
    protected void writeFieldValue(XContentBuilder builder) throws IOException {}
        mapper.toXContent(builder, ToXContent.EMPTY_PARAMS);
        // TODO Any conflicts or updates to check for here? Parameters index, store, doc_values and boost are not  
    @Override  
            b.endObject();  
 * The OpenSearch Contributors require contributions made to  
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();
        return fieldMapping(buildField, true);
        mapper.toXContent(builder, ToXContent.EMPTY_PARAMS);
    // during the next index rollover (so even in this case, the field is only defined in one or the other).  
            b.field("type", "keyword");  
    }
    }  
    protected boolean supportsOrIgnoresBoost() {
            "{\"field\":{\"type\":\"keyword\",\"script\":{\"source\":\"doc['test'].value\",\"lang\":\"painless\"}}}",
    // This is also being left blank because the super assertExistsQuery is trying to parse
 * SPDX-License-Identifier: Apache-2.0
    }
 * compatible open source license.
    // This way, the parent tests are checking the right behavior for this Mapper.
            b.startObject("properties");
    public void testPluggableDataFormatDerivedFieldThrows() throws IOException {
        DocumentMapper mapper = createDocumentMapper(topMapping(b -> {  
    // Overriding this to do nothing since derived fields are not written in the documents
        // when MappingLookup is initialized
    // TODO: Is there a case where we want to allow the field to be defined in both 'derived' and 'properties'?  
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(b -> {
 */  
        assertEquals(  
        DerivedFieldMapper derivedMapper = (DerivedFieldMapper) mapper.mappers().getMapper("derived_field");
        );  
        assertEquals(Script.parse(scriptString), derivedFieldMapper.getScript());
            b.startObject("script").field("source", "emit(params._source.field)").field("lang", "painless").endObject();
        assertEquals("Failed to parse mapping [_doc]: mapper [field] cannot be changed from type [derived] to [keyword]", ex.getMessage());
    protected void registerParameters(ParameterChecker checker) throws IOException {
            b.field("type", "keyword");
    // an empty source and fails.  
    // If the user wants to move a field they were testing as derived to be indexed, they should be able to update
        Mapper mapper = defaultMapper.mappers().getMapper("field");
        // supported for DerivedFieldMapper (we explicitly set these values on initialization)
    // This is more checking search behavior so may need to revisit this after query implementation  
        assertTrue(mapper instanceof DerivedFieldMapper);
        String scriptString = "doc['test'].value";  
        Mapper mapper = defaultMapper.mappers().getMapper("field");
        assertTrue(mapper instanceof DerivedFieldMapper);
    protected void assertExistsQuery(MapperService mapperService) {}
            b.startObject("derived");  
    @Override  
/*  
    public void testParsesScript() throws IOException {
    }
    protected final XContentBuilder fieldMapping(CheckedConsumer<XContentBuilder, IOException> buildField) throws IOException {
        }));
    public void testFieldInDerivedAndProperties() throws IOException {
import java.io.IOException;
    // Overriding fieldMapping to make it create derived mappings by default.
    }
    // the mappings in index template to move the field from 'derived' to 'properties' and it should take affect
    }  
        })));
        return false;
            builder.toString()
public class DerivedFieldMapperTests extends MapperTestCase {  
            b.endObject();
            b.startObject("derived_field");
 * this file be licensed under the Apache-2.0 license or a
    // TODO TESTCASE: testWithFieldInSource() (derived field with that field present in source)
        assertNotNull(derivedMapper);  
            b.endObject();
            b.field("source", scriptString);
        expectThrows(UnsupportedOperationException.class, () -> derivedMapper.parseCreateFieldForPluggableFormat(null));
import org.opensearch.script.Script;
            b.startObject("derived");
 *
            b.endObject();  
            b.startObject("field");
package org.opensearch.index.mapper;
            b.startObject("field");  
        MapperParsingException ex = expectThrows(MapperParsingException.class, () -> createDocumentMapper(topMapping(b -> {
            b.startObject("script");  
        // TODO: Do we want to handle this as a different error? As it stands, it fails as a merge conflict which makes sense.
        // If it didn't fail here, it would hit the MapperParsingException for the field being defined more than once  
        }));  
    @Override  
}  
        assertEquals("{\"field\":{\"type\":\"keyword\"}}", builder.toString());
    public void testSerialization() throws IOException {
    protected void minimalMapping(XContentBuilder b) throws IOException {
        DerivedFieldMapper derivedFieldMapper = (DerivedFieldMapper) mapper;  
import org.opensearch.common.xcontent.XContentFactory;
    }
        XContentBuilder builder = XContentFactory.jsonBuilder().startObject();  
        builder.endObject();
        b.field("type", "keyword");
import org.opensearch.core.xcontent.XContentBuilder;
            b.endObject();
import org.opensearch.core.xcontent.ToXContent;  
import org.opensearch.common.CheckedConsumer;
            b.field("type", "keyword");
    protected boolean supportsMeta() {  
    @Override
            b.endObject();  
        DocumentMapper defaultMapper = createDocumentMapper(fieldMapping(this::minimalMapping));  
            b.endObject();
        return false;  
    // TODO: Can update this once the query implementation is completed
        builder.endObject();  
    }
