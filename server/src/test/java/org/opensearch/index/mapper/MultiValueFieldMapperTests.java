    private DocumentMapper keywordMapper() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        }));  
            .putList("index.sort.field", "field")
        assertNull(singleton.dynamicMappingsUpdate());  
        );
    }
    public void testIndexSortFieldCanPromote() throws IOException {
        MapperParsingException error = expectThrows(
        assertEquals(MappedFieldType.MultiValueState.SCALAR, fieldMapper.fieldType().multiValueState());
        FieldMapper update = (FieldMapper) parsed.dynamicMappingsUpdate().root().getMapper("field");
        ParsedDocument singleton = mapper.parse(source(b -> b.startArray("field").value("prod").endArray()), new CapturingDocumentInput());
        assertThat(error.getMessage(), containsString("locked scalar by [multi_value: false]"));
        );  
/*  
            b.endObject();
            b.startObject("field").field("type", "keyword");
        merge(mapperService, mapping(b -> b.startObject("field").field("type", "keyword").endObject()));
import static org.hamcrest.Matchers.instanceOf;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }
            .putList("index.sort.order", "asc")
        assertEquals(MappedFieldType.MultiValueState.AUTO, fieldMapper.fieldType().multiValueState());  
            () -> mapper.parse(source(b -> b.startArray("field").endArray()), new CapturingDocumentInput())  
        DocumentMapper mapper = keywordMapper(false);  
        assertTrue(((FieldMapper) update).fieldType().isMultiValueSupported());
        );
        DocumentMapper mapper = createDocumentMapper(settings, mapping(b -> b.startObject("field").field("type", "keyword").endObject()));
        assertNotNull(error.getCause());  
        assertTrue(((FieldMapper) update).fieldType().isMultiValued());
 * this file be licensed under the Apache-2.0 license or a
        assertNull(parsed.dynamicMappingsUpdate());
        assertEquals(2L, input.getFieldCount("field"));  
        Settings settings = Settings.builder()
        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").endArray()), new CapturingDocumentInput());
    public void testSecondValuePromotesKeyword() throws IOException {
            pluggableSettings(),
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
 * The OpenSearch Contributors require contributions made to  
    }
        assertEquals(MappedFieldType.MultiValueState.SCALAR, mapperService.fieldType("field").multiValueState());  
        assertNull(parsed.dynamicMappingsUpdate());  
    }
    private Settings pluggableSettings() {  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        FieldMapper fieldMapper = (FieldMapper) mapper.mappers().getMapper("field");
        assertNotNull(parsed.dynamicMappingsUpdate());  
            MapperParsingException.class,
    public void testExplicitFalseCannotBeUpdatedToTrueAndUnspecifiedUpdatePreservesLock() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        return createDocumentMapper(pluggableSettings(), mapping(b -> {  
 */  
        FieldMapper fieldMapper = (FieldMapper) mapper.mappers().getMapper("field");
        assertThat(mapper.mappingSource().string(), containsString("\"multi_value\":false"));  
            if (multiValue != null) {
            () -> merge(mapperService, mapping(b -> b.startObject("field").field("type", "keyword").field("multi_value", true).endObject()))
            .put(pluggableSettings())  
    public void testExplicitFalseRejectsEmptyArray() throws IOException {
        assertEquals(1L, input.getFieldCount("field"));  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    }  
        IllegalArgumentException error = expectThrows(
        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").value("prod").endArray()), input);  
        return keywordMapper(null);
    public void testEmptyArrayPromotesKeyword() throws IOException {
        Mapper update = parsed.dynamicMappingsUpdate().root().getMapper("field");
            .build();  
        DocumentMapper mapper = keywordMapper(false);  
    }  
        assertNotNull(parsed.dynamicMappingsUpdate());
        DocumentMapper mapper = keywordMapper();
        DocumentMapper mapper = keywordMapper();
            MapperParsingException.class,  
    }
    }
 * SPDX-License-Identifier: Apache-2.0
    private DocumentMapper keywordMapper(Boolean multiValue) throws IOException {
            mapping(b -> b.startObject("field").field("type", "keyword").field("multi_value", false).endObject())
    public void testIgnoredNullElementDoesNotPromoteKeyword() throws IOException {
    }
package org.opensearch.index.mapper;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        CapturingDocumentInput input = new CapturingDocumentInput();  
 * compatible open source license.
        DocumentMapper mapper = keywordMapper();
            IllegalArgumentException.class,  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
        ParsedDocument parsed = mapper.parse(source(b -> b.array("field", "z", "a")), new CapturingDocumentInput());  
        assertEquals(1L, input.getFieldCount("field"));
        assertThat(error.getMessage(), containsString("Cannot update parameter [multi_value] from [false] to [true]"));  
import org.opensearch.common.settings.Settings;
        CapturingDocumentInput input = new CapturingDocumentInput();  
            () -> mapper.parse(source(b -> b.startArray("field").value("prod").value("error").endArray()), new CapturingDocumentInput())
import static org.hamcrest.Matchers.containsString;  
        MapperService mapperService = createMapperService(  
        assertThat(update, instanceOf(ParametrizedFieldMapper.class));  
        CapturingDocumentInput input = new CapturingDocumentInput();
        FieldMapper fieldMapper = (FieldMapper) mapper.mappers().getMapper("field");
    }  
        assertNotNull(parsed.dynamicMappingsUpdate());
        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").value("prod").value("error").endArray()), input);
 *
        FieldMapper update = (FieldMapper) parsed.dynamicMappingsUpdate().root().getMapper("field");
import static org.hamcrest.Matchers.not;
        DocumentMapper mapper = keywordMapper();  
        DocumentMapper mapper = keywordMapper(true);
import java.io.IOException;
import org.opensearch.common.util.FeatureFlags;
        assertTrue(fieldMapper.fieldType().isMultiValueSupported());
        );
        assertTrue(update.fieldType().isMultiValued());
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)  
    public void testSingletonArrayStaysScalarKeyword() throws IOException {  
    public void testExplicitFalseLocksKeyword() throws IOException {
    }  
        assertEquals(MappedFieldType.MultiValueState.LIST, update.fieldType().multiValueState());  
        DocumentMapper mapper = keywordMapper();
        MapperParsingException error = expectThrows(
    }
        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").value("prod").nullValue().endArray()), input);
        assertTrue(fieldMapper.fieldType().isMultiValued());  
    public void testExplicitMultiValueKeywordMapping() throws IOException {  
        assertThat(mapper.mappingSource().string(), not(containsString("multi_value")));
            }
    public void testOmittedParameterRemainsAutoAndIsNotSerialized() throws IOException {  
public class MultiValueFieldMapperTests extends MapperServiceTestCase {
    }
                b.field("multi_value", multiValue);  
        return Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
}
        assertThat(error.getCause().getMessage(), containsString("locked scalar by [multi_value: false]"));
