            () -> mapper.parse(source(b -> b.startArray("field").endArray()), new CapturingDocumentInput())
    }
import org.opensearch.common.settings.Settings;
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    private Settings pluggableSettings() {
/*
    }
        FieldMapper update = (FieldMapper) parsed.dynamicMappingsUpdate().root().getMapper("field");
        );
        assertTrue(fieldMapper.fieldType().isMultiValued());
        assertThat(update, instanceOf(ParametrizedFieldMapper.class));
    }
        return Settings.builder().put(getIndexSettings()).put("index.pluggable.dataformat.enabled", true).build();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testExplicitMultiValueKeywordMapping() throws IOException {
        MapperService mapperService = createMapperService(
        DocumentMapper mapper = keywordMapper(false);
    public void testOmittedParameterRemainsAutoAndIsNotSerialized() throws IOException {
        CapturingDocumentInput input = new CapturingDocumentInput();
            .putList("index.sort.order", "asc")
            b.startObject("field").field("type", "keyword");
import static org.hamcrest.Matchers.not;
    public void testIndexSortFieldCanPromote() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
import org.opensearch.common.util.FeatureFlags;
        assertNotNull(parsed.dynamicMappingsUpdate());
}
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
            .put(pluggableSettings())
        DocumentMapper mapper = keywordMapper();
        }));
    }
    public void testSingletonArrayStaysScalarKeyword() throws IOException {
    public void testIgnoredNullElementDoesNotPromoteKeyword() throws IOException {
            }
    public void testExplicitFalseLocksKeyword() throws IOException {
        assertTrue(((FieldMapper) update).fieldType().isMultiValued());
            .build();
        assertThat(error.getMessage(), containsString("Cannot update parameter [multi_value] from [false] to [true]"));
        assertTrue(fieldMapper.fieldType().isMultiValueSupported());
        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").value("prod").nullValue().endArray()), input);
        return keywordMapper(null);
    public void testExplicitFalseCannotBeUpdatedToTrueAndUnspecifiedUpdatePreservesLock() throws IOException {
        DocumentMapper mapper = keywordMapper();
    }
package org.opensearch.index.mapper;
        IllegalArgumentException error = expectThrows(
        assertEquals(2L, input.getFieldCount("field"));
    }
        assertNull(parsed.dynamicMappingsUpdate());
        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").endArray()), new CapturingDocumentInput());
        FieldMapper fieldMapper = (FieldMapper) mapper.mappers().getMapper("field");
        assertNotNull(error.getCause());
        Settings settings = Settings.builder()
        assertNull(singleton.dynamicMappingsUpdate());
            b.endObject();
        ParsedDocument singleton = mapper.parse(source(b -> b.startArray("field").value("prod").endArray()), new CapturingDocumentInput());
        DocumentMapper mapper = keywordMapper();
        assertThat(mapper.mappingSource().string(), containsString("\"multi_value\":false"));
 *
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.instanceOf;
 * this file be licensed under the Apache-2.0 license or a
    }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        FieldMapper fieldMapper = (FieldMapper) mapper.mappers().getMapper("field");
        FieldMapper update = (FieldMapper) parsed.dynamicMappingsUpdate().root().getMapper("field");
        Mapper update = parsed.dynamicMappingsUpdate().root().getMapper("field");
 * The OpenSearch Contributors require contributions made to
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        DocumentMapper mapper = keywordMapper();
            MapperParsingException.class,
    public void testExplicitFalseRejectsEmptyArray() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
public class MultiValueFieldMapperTests extends MapperServiceTestCase {
    }
        assertEquals(MappedFieldType.MultiValueState.LIST, update.fieldType().multiValueState());
    }
        assertEquals(MappedFieldType.MultiValueState.SCALAR, fieldMapper.fieldType().multiValueState());
        assertThat(error.getMessage(), containsString("locked scalar by [multi_value: false]"));
    }
    }
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        assertTrue(update.fieldType().isMultiValued());
        DocumentMapper mapper = keywordMapper(false);
 * compatible open source license.
    private DocumentMapper keywordMapper() throws IOException {
        DocumentMapper mapper = keywordMapper(true);
        assertNotNull(parsed.dynamicMappingsUpdate());
        );
        );
    }
        return createDocumentMapper(pluggableSettings(), mapping(b -> {
        MapperParsingException error = expectThrows(
            () -> merge(mapperService, mapping(b -> b.startObject("field").field("type", "keyword").field("multi_value", true).endObject()))
        ParsedDocument parsed = mapper.parse(source(b -> b.array("field", "z", "a")), new CapturingDocumentInput());
            .putList("index.sort.field", "field")
            if (multiValue != null) {
                b.field("multi_value", multiValue);
        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").value("prod").value("error").endArray()), input);
    }
        assertEquals(1L, input.getFieldCount("field"));
        assertEquals(MappedFieldType.MultiValueState.AUTO, fieldMapper.fieldType().multiValueState());
    private DocumentMapper keywordMapper(Boolean multiValue) throws IOException {
            IllegalArgumentException.class,
        DocumentMapper mapper = createDocumentMapper(settings, mapping(b -> b.startObject("field").field("type", "keyword").endObject()));
        MapperParsingException error = expectThrows(
            mapping(b -> b.startObject("field").field("type", "keyword").field("multi_value", false).endObject())
            () -> mapper.parse(source(b -> b.startArray("field").value("prod").value("error").endArray()), new CapturingDocumentInput())
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
        merge(mapperService, mapping(b -> b.startObject("field").field("type", "keyword").endObject()));
            pluggableSettings(),
        ParsedDocument parsed = mapper.parse(source(b -> b.startArray("field").value("prod").endArray()), input);
        assertThat(mapper.mappingSource().string(), not(containsString("multi_value")));
            MapperParsingException.class,
        assertNotNull(parsed.dynamicMappingsUpdate());
import java.io.IOException;
        assertTrue(((FieldMapper) update).fieldType().isMultiValueSupported());
        CapturingDocumentInput input = new CapturingDocumentInput();
        assertThat(error.getCause().getMessage(), containsString("locked scalar by [multi_value: false]"));
        assertEquals(MappedFieldType.MultiValueState.SCALAR, mapperService.fieldType("field").multiValueState());
        DocumentMapper mapper = keywordMapper();
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
 */
        assertNull(parsed.dynamicMappingsUpdate());
        CapturingDocumentInput input = new CapturingDocumentInput();
        assertEquals(1L, input.getFieldCount("field"));
        );
    public void testSecondValuePromotesKeyword() throws IOException {
    @LockFeatureFlag(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG)
    public void testEmptyArrayPromotesKeyword() throws IOException {
        FieldMapper fieldMapper = (FieldMapper) mapper.mappers().getMapper("field");
