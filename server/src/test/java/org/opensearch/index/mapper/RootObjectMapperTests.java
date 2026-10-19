            .startArray()
        assertNotNull(doc);
        // Parsing a field already in the tracker must succeed (no new slot needed).
        assertEquals("first_template", templates[0].name());
            .endObject()  
        mapping.endObject();
            .endObject()
            .startObject()
        String mapping = XContentFactory.jsonBuilder()
        // There should be no update if templates are not set.
 * this work for additional information regarding copyright
            mapping.endArray();
        assertThat(e.getMessage(), containsString("must be an object"));
            .endObject()  
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("type").startObject("dynamic_properties");  
                mapping.startObject("mapping");
        MapperService mapperService = createIndex("test").mapperService();
        MapperService mapperService = createIndex("test").mapperService();
    public void testDynamicPropertiesMappingUpdateReplacesSamePattern() throws Exception {  
import org.opensearch.core.xcontent.XContentBuilder;
            .endObject()  
                assertWarnings(  
        return new FieldInfo(
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
import org.apache.lucene.index.IndexOptions;
     * When the tracker snapshot is at the limit but the field being parsed is already tracked
            .startObject()
        MapperService mapperService = createIndex(  
    }
        assertEquals(mapping2, mapper.mappingSource().toString());
    /**
        mapperService.merge("type", new CompressedXContent(second), MergeReason.MAPPING_UPDATE);
            number,
    }
        mapper = mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);  
            patterns.add(dp.getPattern());  
        Set<String> patterns = new HashSet<>();  
                    mapping.endObject();
        assertNotNull(root.findDynamicProperty("count_i"));  
            .endObject()
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), limit).build()
            .endObject()
            VectorEncoding.FLOAT32,
        assertThat(e.getMessage(), containsString("overlap"));  
        // update with an implicit value: no change  
            .endObject()
            VectorSimilarityFunction.EUCLIDEAN,  
                + "caused by [unknown parameter [foo] on mapper [__dynamic__my_template2] of type [keyword]]"  
            .endObject()
            }  
        mapping = XContentFactory.jsonBuilder()
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)  
        assertThat(e.getMessage(), containsString("exceeds the maximum allowed [" + RootObjectMapper.MAX_DYNAMIC_PROPERTIES + "]"));  
/*  
            .startObject("mapping")
            .endObject()  
            .startObject()
        // Should succeed: empty tracker means the limit check is skipped.  
            .field("dynamic_date_formats", Arrays.asList())  
            .startObject("type")
                    mapping.startObject();
            .endArray()
        infos[0] = makeFieldInfo(existingField, 0);
        String mapping3 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
            .startObject("dynamic_properties")  
            0,
        assertEquals(Set.of("*_i", "*_s"), patterns);
            .startObject("type")
        MapperService mapperService = createIndex("test").mapperService();  
        assertEquals(2, root.dynamicProperties().length);
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
                    } else {  
            .startObject()
                mapping.endObject();
        );
            MapperParsingException.class,
            .endObject()
                {
            .startObject("type")
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), limit).build()  
                    }
            .startObject()  
        MapperService mapperService = createIndex("test").mapperService();
            .startObject("*_i")
            .startObject("properties")  
     * When the tracker is empty (no refresh yet), the field-count limit is not applied and
                mapping.field("analyzer", "foobar");
            .endObject()
        assertEquals(0, mapperService.getLuceneFieldTracker().getFieldInfos().size());
            .startObject("type")  
            .startObject("type")
            {
            .endObject()
}  
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
        String mapping = XContentFactory.jsonBuilder()
    }
            .endObject()
    }
            boolean useMatchMappingType = randomBoolean();
    }
        mapperService.merge("type", new CompressedXContent(first), MergeReason.INDEX_TEMPLATE);
        String first = XContentFactory.jsonBuilder()  
    }
    /**  
        assertThat(e.getMessage(), containsString("limit [" + limit + "]"));  
            .endObject()  
    public void testIllegalFormatField() throws Exception {  
                mapping.endObject();  
    public void testDynamicPropertiesRejectsBareStarPattern() throws Exception {
            .startObject("dynamic_properties")  
            MergeReason.INDEX_TEMPLATE  
            .field("type", "integer")
            patterns.add(dp.getPattern());
            .startObject("mapping")
     */
            DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);  
            .startObject("type")  
            .startObject()  
            new CompressedXContent(mapping),
        MapperService mapperService = createIndex("test").mapperService();  
            .toString();  
        DynamicProperty[] dps = mapperService.documentMapper().root().dynamicProperties();
            .startObject("type")
        ParsedDocument doc = mapper.parse(kwSource("any_kw", "no_limit"));
 * license agreements. See the NOTICE file distributed with
    public void testDynamicTemplatesForIndexTemplate() throws IOException {  
            .endObject()
            .startObject("dynamic_properties")
            .startObject("type")
        mapper = mapperService.merge("type", new CompressedXContent(mapping2), reason);  
        );  
        String first = XContentFactory.jsonBuilder()
    // -----------------------------------------------------------------------
            MapperParsingException.class,  
                        mapping.field("match", "string_*");
            .toString();
            .toString();
                    mapping.endObject();
        DynamicTemplate[] templates = mapper.root().dynamicTemplates();  
        mapping.startObject();
                mapping.endObject();
    public void testNumericDetection() throws Exception {  
        String mapping2 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();  
            .field("type", "keyword")
            .field("type", "keyword")
            {
            .startObject("dynamic_templates")
            mapping.startObject("*_field" + i).field("type", "keyword").endObject();
    public void testDynamicPropertiesTemplateMergeMergesSecondPattern() throws Exception {
        String mapping = XContentFactory.jsonBuilder()  
 *
            .endObject()
            .startObject("type")  
                mapping.endObject();
            XContentBuilder mapping = XContentFactory.jsonBuilder();
            .startObject()
        String mapping = XContentFactory.jsonBuilder()
        assertEquals(RootObjectMapper.MAX_DYNAMIC_PROPERTIES, mapper.root().dynamicProperties().length);  
            .value("test_format")  
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
        );  
            MapperParsingException.class,  
        tracker.setFieldInfos(new FieldInfos(infos));  
            .endObject()
        assertEquals("third", templates[2].pathMatch());  
    // Lucene field-count limit tests
            .field("type", "integer")  
            .endObject()  
    public void testDateDetection() throws Exception {  
        String mapping = XContentFactory.jsonBuilder()  
            .endObject()  
            .endObject()
            .endObject()  
            DocValuesType.NONE,  
            .endObject()
    /** Helper: build a SourceToParse with a single keyword field matching *_kw. */
    }  
            .startObject()  
        assertThat(mapper.mappingSource().toString(), containsString("\"type\":\"string\""));
            .toString();
            .startObject("dynamic_properties")
            .toString();
            .endObject()  
    private static SourceToParse kwSource(String fieldName, String value) {
        MapperService mapperService = createIndex("test").mapperService();  
     * tracker), the parse must throw {@link MapperParsingException}.
            .endObject()
            .startObject("b*")
                    mapping.field("type", "{dynamic_type}");
            .endObject()  
        long limit = 3L;  
            mapping.endObject();
            .endObject()  
            .field("type", "keyword")
            .value("test_format")
        RootObjectMapper root = mapperService.documentMapper().root();
        assertNotNull(doc);
    }
                mapping.startObject("mapping");
        assertThat(e.getMessage(), containsString("*_i"));
package org.opensearch.index.mapper;
                mapping.endObject();
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)  
            .startObject("properties")
            .endObject()
                assertWarnings(  
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("type").startObject("dynamic_properties");  
                    "dynamic template [my_template4] has invalid content [{\"match_mapping_type\":\"*\",\"mapping\":{"
        assertEquals("Dynamic template syntax error. An array of named objects is expected.", e.getMessage());
    public void testDynamicPropertiesLuceneFieldLimitNotEnforcedWhenTrackerEmpty() throws Exception {
        assertEquals("*_i", dynProps[0].getPattern());  
            MapperParsingException.class,  
                mapping.field("type", "keyword");
        ParsedDocument doc = mapper.parse(kwSource("new_kw", "hello"));
        assertEquals(mapping2, mapper.mappingSource().toString());
            .endObject()
            .field("date_detection", true)
            .endObject()
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), limit).build()
            name,  
        XContentBuilder mapping = XContentFactory.jsonBuilder();
            .endObject()
            false,  
            .field("path_match", "second_updated")  
                    mapping.field("index_phrases", true);
            false,
            .field("type", "keyword")
    public void testDynamicPropertiesLuceneFieldLimitRejectsNewField() throws Exception {  
            .startObject("*_i")  
        MapperParsingException e = expectThrows(
            MapperParsingException.class,
import org.apache.lucene.index.VectorEncoding;  
            .endObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder();
        assertEquals("*_i", dps[0].getPattern());
        );
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
    public void testDynamicPropertiesTemplateMergeRejectsExplicitOverlap() throws Exception {
        mapper = mapperService.merge("type", new CompressedXContent(mapping3), reason);
                );
            "dynamic template [my_template3] has invalid content [{\"match_mapping_type\":\"string\",\"mapping\":{"
        RootObjectMapper root = mapper.root();  
        MapperService mapperService = createIndex("test").mapperService();
        assertEquals("first", templates[0].pathMatch());  
            .field("type", "integer")
        for (int i = 0; i <= RootObjectMapper.MAX_DYNAMIC_PROPERTIES; i++) {
        MapperParsingException e = expectThrows(
        {
            .startObject("type")
import java.util.Arrays;  
            {
    }
            .endObject()  
            .toString();
        MapperService mapperService = createIndex("test").mapperService();  
    }
                {
            .endObject()  
            .toString();
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);
    public void testDynamicTemplates() throws Exception {
            .endObject()
            .startObject("dynamic_properties")
        String second = XContentFactory.jsonBuilder()
        assertEquals("second_updated", templates[1].pathMatch());
 * Licensed to Elasticsearch under one or more contributor  
                    mapping.startObject("my_template4");  
    public void testDynamicPropertiesPatternRequiresWildcard() throws Exception {
    }  
    public void testDynamicPropertiesAmbiguousPatternsRejected() throws Exception {  
            .startObject("properties")  
            .endObject()  
            .endObject()
                    }
            .toString();
        }
            .startObject()
            .field("date_detection", false)
            .endObject()  
        String explicitFirst = XContentFactory.jsonBuilder()
            .field("type", "keyword")  
        // Tracker has exactly `limit` fields — but the field we are about to parse is among them.
            infos[i] = makeFieldInfo("__lucene_field_" + i, i);
        MapperParsingException e = expectThrows(
            .endObject()  
            .startObject("mapping")
            .toString();
            mapping.startArray("dynamic_templates");
    }
            .startObject("dynamic_properties")
     */  
        String mapping = XContentFactory.jsonBuilder()  
        String mapping = XContentFactory.jsonBuilder()
        String first = XContentFactory.jsonBuilder()
            .startObject()  
    /** Registering exactly {@link RootObjectMapper#MAX_DYNAMIC_PROPERTIES} patterns must succeed. */  
            .startObject("type")
            DocValuesSkipIndexType.NONE,
/*
        MapperService mapperService = createIndex(  
            .endObject()
    }
        assertEquals("*_i", root.findDynamicProperty("count_i").getPattern());  
        // update with a different explicit value
            .endObject()
        assertThat(e.getMessage(), containsString("pattern [*] is not allowed"));  
            .startObject("*_i")
        );  
    /** Helper: pre-populate the tracker so it looks like N fields have been refreshed from the shard. */  
                mapping.startObject();
    public void testDynamicProperties() throws Exception {  
    /**  
            .endObject()
     * entries merge by pattern key (same behavior family as {@code dynamic_templates} name-based merge).
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);
            .startObject("type")  
        for (int i = 1; i <= RootObjectMapper.MAX_DYNAMIC_PROPERTIES; i++) {
        }
        assertEquals(mapping2, mapper.mappingSource().toString());  
    public void testDynamicPropertiesLuceneFieldLimitAllowsFieldBelowLimit() throws Exception {
        }
            .endObject()
                        + "caused by [unknown parameter [foo] on mapper [__dynamic__my_template4] of type [binary]]"  
            mapping.startObject();  
            .endObject()  
        MapperParsingException e = expectThrows(  
            }
            .startObject("dynamic_properties")  
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
            .toString();
            .endObject()
            .field("type", "long")
            "idx_below_limit",
        assertEquals(3, templates.length);  
            "idx_at_limit",  
        );
            .endObject()
                        + "\"foo\":\"bar\",\"type\":\"{dynamic_type}\"}}], "
                () -> parser.parse("type", new CompressedXContent(m))
            .startArray("dynamic_templates")  
        Set<String> patterns = new HashSet<>();
    /** Registering more than {@link RootObjectMapper#MAX_DYNAMIC_PROPERTIES} patterns must be rejected. */  
import java.util.HashSet;
        String mapping = XContentFactory.jsonBuilder()
            .startObject("type")
        }
            .endObject()
        }  
            .startObject("type")
        MapperParsingException e = expectThrows(  
            .endObject()  
            .endObject()
import static org.hamcrest.Matchers.containsString;
            .endArray()
                    mapping.startObject("mapping");  
import org.apache.lucene.index.DocValuesType;
        assertEquals(mapping, mapper.mappingSource().toString());
            .endObject()
        assertWarnings(
            .endObject()
            MapperParsingException.class,
        MapperService mapperService = createIndex(
        assertEquals(Set.of("*_i", "*_s"), patterns);
            .startObject("dynamic_properties")
    }
        {
            .startObject("*_i")
                mapping.endObject();
    public void testDynamicPropertiesRejectsUnknownType() throws Exception {  
                mapping.endObject();  
            .startArray("dynamic_date_formats")
            .startObject("*_i")
public class RootObjectMapperTests extends OpenSearchSingleNodeTestCase {
            .endObject()
    public void testIllegalDynamicTemplates() throws Exception {
        assertNull(root.findDynamicProperty("other"));
    }
        String mapping2 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
            .startObject()
                + "\"analyzer\":\"foobar\",\"type\":\"text\"}}], caused by [analyzer [foobar] has not been configured in mappings]"  
        FieldInfo[] infos = new FieldInfo[fieldCount];
            false,
    }
            mapperService = createIndex("test").mapperService();
            .endObject()  
            .endObject()
            .startObject("third_template")  
        assertThat(e.getMessage(), containsString("must have a mapping object"));
        assertEquals(mapping3, mapper.mappingSource().toString());  
import org.opensearch.common.settings.Settings;  
            .endObject()
            .startObject()
/*  
        MapperService mapperService = createIndex("test").mapperService();  
        assertEquals("integer", dps[0].getMapping().get("type"));
            .endObject()  
            .startObject("*_i")  
            .startObject("*")  
            .field("type", "long")  
            .startObject("*_i")
            .endObject()
            .startObject()
                    "dynamic template [my_template4] has invalid content [{\"match\":\"string_*\",\"mapping\":{"
            .endObject()
        assertThat(e.getMessage(), containsString("*_i"));
    private static void populateTracker(LuceneFieldTracker tracker, int fieldCount) {
        assertEquals(2, templates.length);
            .endObject()
    /** Same pattern key in a later update replaces the previous mapping for that pattern only. */
            .endObject()
            .startObject("type")
    public void testDateFormatters() throws Exception {  
            .startObject("type")  
            .toString();
 * ownership. Elasticsearch licenses this file to you under  
            mapping.startObject("type");
        assertEquals(1, dps.length);  
            .startObject("dynamic_properties")
                        + "caused by [unknown parameter [foo] on mapper [__dynamic__my_template4] of type [binary]]"  
            .startObject("dynamic_properties")
            .startObject("type")  
                    } else {  
        populateTracker(mapperService.getLuceneFieldTracker(), (int) limit);  
        assertEquals(mapping, mapper.mappingSource().toString());
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), limit).build()
 * the Apache License, Version 2.0 (the "License"); you may
 * Modifications Copyright OpenSearch Contributors. See
        assertNotNull(root.findDynamicProperty("foo_s"));
            .endObject()
                }  
        MapperParsingException e = expectThrows(  
import org.opensearch.common.compress.CompressedXContent;
        ).mapperService();
                mapping.field("foo", "bar");  
            mapping.endObject();  
 *  
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
            .startObject("type")
        mapper = mapperService.merge("type", new CompressedXContent(mapping2), reason);  
                mapping.endObject();
        MapperService mapperService = createIndex("test").mapperService();
            .startObject()  
        MapperParsingException e = expectThrows(
                mapping.startObject("my_template1");  
            .startObject("type")
        assertNotNull(doc);
        {  
                mapping.endArray();
        String mapping = XContentFactory.jsonBuilder()
        String mapping = XContentFactory.jsonBuilder()
        }
            .field("type", "keyword")
            mapping.startArray("dynamic_templates");  
        // update with an implicit value: no change  
            .startObject()
            .startObject("dynamic_properties")
            .endObject()
        // Tracker starts with FieldInfos.EMPTY (no engine in unit-test context) → size is 0.  
            .startObject("type")  
                mapping.endObject();
        );
    public void testDynamicPropertiesRequiresType() throws Exception {
        String second = XContentFactory.jsonBuilder()  
    public void testDynamicPropertiesLuceneFieldLimitAllowsExistingTrackedField() throws Exception {
            .endObject()  
            .startArray("dynamic_templates")  
    }  
        assertEquals(2, root.dynamicProperties().length);
        mapperService.merge("type", new CompressedXContent(first), MergeReason.MAPPING_UPDATE);  
            .endObject()  
            .startObject()
     * When the tracker snapshot is below the limit, a new dynamic-property field is allowed.
            .endObject()
        long limit = 5L;
            .toString();
        FieldInfo[] infos = new FieldInfo[(int) limit];  
     */
        MapperService mapperService;
            .startObject("second_template")
        MapperService mapperService = createIndex("test").mapperService();
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> parser.parse("type", new CompressedXContent(mapping)));  
            .field("path_match", "third")
            .startObject()
        assertThat(e.getMessage(), containsString("i_*"));
            DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);  
        mapping.startObject();  
            .startObject("dynamic_properties")  
            .startObject("dynamic_properties")  
        assertThat(e.getMessage(), containsString("count_i"));
            .startObject("dynamic_properties")
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
            () -> mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE)
    }  
        // Simulate a refresh: tracker has exactly `limit` field names, none matching *_kw.
            MapperParsingException.class,
            .endObject()
            .startObject("*abchdi*")
            .startObject()
        MapperParsingException e = expectThrows(
 * The OpenSearch Contributors require contributions made to  
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
        assertEquals("second_template", templates[1].name());
        ).mapperService();
            IndexOptions.NONE,
        String second = XContentFactory.jsonBuilder()
        String mapping = XContentFactory.jsonBuilder()
            .field("dynamic_date_formats", Arrays.asList("yyyy-MM-dd"))
            .toString();
            .endObject()
            .startObject("*_i")  
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);  
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), reason);
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), reason);
            .endObject()
            .startObject()  
import java.util.Set;  
    }  
 * GitHub history for details.
            .endObject()  
            .startObject("field")  
    public void testIllegalDynamicTemplateInvalidAttribute() throws Exception {
            .startArray("dynamic_templates")
        assertWarnings(  
        // a* and b* have empty language intersection — distinct field name prefixes.
        assertEquals(0, mapperService.documentMapper().root().dynamicProperties().length);
    }
            mapping.endArray();  
                        mapping.field("match_mapping_type", "*");
            MapperParsingException.class,
            .startObject()
            .field("type", "double")
        mapping.endObject().endObject().endObject();
            .toString();
        assertThat(e.getMessage(), containsString("No handler for type"));
            .startObject()  
 * under the License.  
            .startObject()
        return XContentFactory.jsonBuilder()  
import java.util.Collections;
            .startObject()  
                IllegalArgumentException.class,  
            .startObject("*_i*")
            .startObject("title")
            .startObject()  
        }  
        assertThat(e.getMessage(), containsString("overlap"));
            .startObject()
            "idx_zero_limit",
                mapping.field("type", "string");  
 * this file be licensed under the Apache-2.0 license or a
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
        assertThat(mapper.mappingSource().toString(), containsString("\"foo\":\"bar\""));
            .endObject()  
        mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);  
    /** Helper: build a dynamic_properties mapping for pattern {@code *_kw} → keyword. */
        String mapping2 = XContentFactory.jsonBuilder()
        MapperParsingException e = expectThrows(
            .field("type", "long")
            .endObject()
        }  
        assertNotNull(root.findDynamicProperty("x_i"));
            .field("type", "keyword")
            .startObject("dynamic_properties")
            }
            "idx_empty",
            .toString();  
        RootObjectMapper root = mapperService.documentMapper().root();  
            .field("type", "long")  
            .endObject()
        mapperService.merge("type", new CompressedXContent(second), MergeReason.MAPPING_UPDATE);
            .startObject()
        }
            .endObject()  
                    if (useMatchMappingType) {
    /** Empty {@code dynamic_properties: {}} is valid and exercises merge validation on an empty rule list. */
    public void testDynamicPropertiesMustBeObject() throws Exception {  
            .endArray()  
            .startArray("date_formats")  
            if (useMatchMappingType) {
            mapping.startArray("dynamic_templates");  
            assertThat(mapper.mappingSource().toString(), containsString("\"foo\":\"bar\""));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.lucene.index.FieldInfo;  
            .endObject()  
        assertEquals(2, dynProps.length);
                        mapping.field("match", "string_*");
            .startArray("dynamic_properties")
        MapperService mapperService = createIndex(
            .toString();
    public void testDynamicPropertiesRejectsOverlappingGlobPatterns() throws Exception {
            .endObject()
        );
            .field("*_i", "long")  
            .endObject()
 */
    public void testIllegalDynamicTemplateUnknownAttribute() throws Exception {  
            .field("type", "keyword")
        MapperService mapperService = createIndex("test").mapperService();  
    }
            mapping.endObject();
        return false;
            .toString();
            .toString();  
            .field("numeric_detection", true)
import org.opensearch.core.xcontent.MediaTypeRegistry;  
            .endObject()
        {  
            .toString();
            .toString();
        for (DynamicProperty dp : dps) {
    public void testDynamicPropertiesEmptyObject() throws Exception {  
            {  
            .startObject("*_kw")
        mapper = mapperService.merge("type", new CompressedXContent(mapping2), MergeReason.MAPPING_UPDATE);
 */  
            0,  
            () -> mapperService.merge("type", new CompressedXContent(dynamicSecond), MergeReason.INDEX_TEMPLATE)
            .endObject()  
        MapperParsingException e = expectThrows(
        assertEquals(mapping, mapper.mappingSource().toString());
        // Even with a large tracker snapshot, limit=0 means the check is disabled.
            0,
        assertThat(e.getMessage(), containsString("must contain a wildcard"));
        return new SourceToParse("index", "1", new BytesArray("{\"" + fieldName + "\": \"" + value + "\"}"), MediaTypeRegistry.JSON);  
                    mapping.endObject();  
            .endObject()  
        mapping.startObject();  
            false
            .startObject("dynamic_properties")
                mapping.startArray("dynamic_templates");  
        assertEquals(mapping2, mapper.mappingSource().toString());  
                mapping.startObject("my_template2");
            .toString();
            .startObject("second_template")
 *     http://www.apache.org/licenses/LICENSE-2.0
            .startObject("*_s")
            mapping.startObject("*_field" + i).field("type", "keyword").endObject();
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
 * compatible open source license.
                    mapping.endObject();  
        ParsedDocument doc = mapper.parse(kwSource("ok_kw", "value"));  
        );
            .toString();
        mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);  
        ).mapperService();  
            mapping.startObject();  
            .toString();
                mapping.startArray("dynamic_templates");  
            .endObject()
            .endObject()  
            .endObject()  
        mapperService.merge("type", new CompressedXContent(explicitFirst), MergeReason.INDEX_TEMPLATE);
        ParsedDocument doc = mapper.parse(kwSource(existingField, "reused"));
        mapping.endObject().endObject().endObject();
        MapperService mapperService = createIndex("test").mapperService();  
            "idx_existing",
                mapping.startObject();
    private static String dynKwMapping() throws IOException {
    public void testDynamicPropertiesMappingUpdateMergesByPattern() throws Exception {
                mapping.startObject("my_template3");  
            .endObject()  
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
        MapperService mapperService = createIndex("test").mapperService();  
    public void testDynamicPropertiesLuceneFieldLimitZeroDisablesCheck() throws Exception {  
            .toString();  
            .field("type", "keyword")
        assertEquals("second", templates[1].pathMatch());
            MapperParsingException.class,
            .endObject()  
 * SPDX-License-Identifier: Apache-2.0
    }
            .toString();
                + "\"foo\":\"bar\",\"type\":\"keyword\"}}], "
    }
            }  
        MapperService mapperService = createIndex("test").mapperService();
                    mapping.endObject();
        assertEquals(mapping, mapper.mappingSource().toString());  
    public void testDynamicPropertiesPatternCountAtLimit() throws IOException {
            .field("type", "keyword")
    private static FieldInfo makeFieldInfo(String name, int number) {
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
    public void testDynamicPropertiesEntryMustBeMappingObject() throws Exception {
            .endObject()  
            .toString();  
                mapping.startObject();
                mapping.endObject();
        String mapping3 = XContentFactory.jsonBuilder()
            .endObject()
            .field("numeric_detection", false)
            .startObject()  
            .startObject("type")
        );  
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
        MapperService mapperService = createIndex("test").mapperService();
    /**
 *
            .startObject()
     */
            .startObject("count_i")
            .endObject()
    @Override
        // Cannot add explicit property "count_i" when dynamic_property "*_i" exists  
    protected boolean forbidPrivateIndexSettings() {  
            mapping.endObject();  
        for (String m : Arrays.asList(mapping, dynamicMapping)) {
        assertThat(e.getMessage(), containsString("Explicit fields cannot overlap"));  
            .startObject("_doc")
            .toString();
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), 0L).build()  
                mapping.field("match_mapping_type", "string");  
            .endObject()  
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
        assertWarnings(  
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
            .endObject()  
            .startObject("first_template")
import org.opensearch.common.xcontent.XContentFactory;
            .endObject()
            .endObject()
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(kwSource("brand_new_kw", "value")));
            .startObject()  
            mapping.startObject("type");
            }
     * (i.e. it already exists in Lucene), it must not be rejected — existing fields reuse their slot.  
            .field("type", "long")  
            false,
    }  
     * dynamic-property fields can be created freely.
        assertEquals("*_s", dynProps[1].getPattern());
 * You may obtain a copy of the License at  
            .startObject("type")  
                        + "\"foo\":\"bar\",\"type\":\"{dynamic_type}\"}}], "
        assertNotNull(root.findDynamicProperty("y_s"));  
    }  
        assertEquals(mapping3, mapper.mappingSource().toString());
            .endObject()  
        String mapping = XContentFactory.jsonBuilder()  
            .startObject("a*")
            .endObject()
    }
            .endObject()
import org.apache.lucene.index.VectorSimilarityFunction;
        MapperService mapperService = createIndex("test").mapperService();  
                mapping.field("type", "text");  
            .endObject()
            .endObject()  
 * KIND, either express or implied.  See the License for the
            .startObject("type")
            .startObject()
        // no update if formatters are not set explicitly
            .startObject()  
            .startObject()
        for (int i = 0; i < fieldCount; i++) {  
        String mapping = XContentFactory.jsonBuilder()
                mapping.field("match_mapping_type", "string");
            .startObject("*_i")
    }
            .endObject()
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), reason);
        // Dynamic templates should be appended and deduplicated.
        // update with a different explicit value
            .startObject("type")
 * specific language governing permissions and limitations
            .endObject()
            .startObject("my_template")
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
                    mapping.field("type", "{dynamic_type}");
        String mapping = XContentFactory.jsonBuilder()
        mapper = mapperService.merge("type", new CompressedXContent(mapping3), MergeReason.MAPPING_UPDATE);
        XContentBuilder mapping = XContentFactory.jsonBuilder();
 * software distributed under the License is distributed on an
                    mapping.startObject();
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);  
    }
        {
            .endObject()
            .endObject()  
            .startObject()
            .endObject()  
    /**  
            .field("type", "long")  
            .toString();  
            .field("type", "long")
            .toString();  
                );
            .toString();  
        String dynamicMapping = XContentFactory.jsonBuilder()
        String mapping2 = XContentFactory.jsonBuilder()
            .field("type", "not_a_real_mapper_type_xyz")  
        for (int i = 1; i < limit; i++) {
        MapperService mapperService = createIndex(
    /** Helper: create a minimal {@link FieldInfo} with the given name and field number. */  
            .endObject()
            .startObject()
                }  
        String dynamicSecond = XContentFactory.jsonBuilder()
    }
        MapperService mapperService = createIndex("test").mapperService();
            .endArray()  
            Collections.emptyMap(),  
    }
        assertEquals("third_template", templates[2].name());
        MapperParsingException e = expectThrows(  
     */  
    public void testDynamicPropertiesAllowsNonOverlappingPatterns() throws Exception {
    }
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);
    public void testDynamicPropertiesExplicitFieldMatchesPatternRejected() throws Exception {
            .endObject()
            .startObject("*_s")
        String mapping = XContentFactory.jsonBuilder()  
                mapping.startObject("type");
                + "\"string\"}}], caused by [No mapper found for type [string]]"
            MapperParsingException.class,  
            .startObject("dynamic_properties")  
                    mapping.startObject("my_template4");  
import org.apache.lucene.index.DocValuesSkipIndexType;
        MapperService mapperService = createIndex("test").mapperService();  
            .startObject()
            .endObject()
            .startObject()  
    }  
            mapping.startObject("type");
            .startObject()
                        mapping.field("match_mapping_type", "*");
        MapperService mapperService = createIndex("test").mapperService();
            MapperService.SINGLE_MAPPING_NAME,
            .field("path_match", "first")  
            .endObject()  
            .endObject()  
        MapperService mapperService = createIndex("test").mapperService();
                mapping.startObject("type");
        mapping = XContentFactory.jsonBuilder()  
            assertThat(mapper.mappingSource().toString(), containsString("\"index_phrases\":true"));
            .endObject()  
        mapper = mapperService.merge("type", new CompressedXContent(mapping3), reason);
            .endObject()
            .startObject("dynamic_properties")
        );
            .endObject()  
        MapperService mapperService = createIndex("test").mapperService();
        assertThat(e.getMessage(), containsString(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey()));
            .toString();
    /**
            assertEquals("Invalid format: [[test_format]]: expected string value", e.getMessage());  
        mapperService.getLuceneFieldTracker().setFieldInfos(new FieldInfos(infos));
        );  
            .endObject()
        assertEquals("first_template", templates[0].name());
        mapperService.merge("type", new CompressedXContent(first), MergeReason.MAPPING_UPDATE);
                mapping.endArray();
        DynamicProperty[] dynProps = root.dynamicProperties();
        assertThat(e.getMessage(), containsString("No type specified"));  
 * not use this file except in compliance with the License.
            .endObject()
            .field("type", "keyword")
import org.apache.lucene.index.FieldInfos;
            .field("match_mapping_type", "string")  
        for (DynamicProperty dp : root.dynamicProperties()) {
            .endObject()
            .endObject()
    }
            );
            .endObject()
            .endObject()
        }  
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
        assertThat(e.getMessage(), containsString("count_i"));  
            .endObject()
            .field("type", "long")
        long limit = 3L;
        mapper = mapperService.merge("type", new CompressedXContent(mapping3), reason);
            .endArray()
            .startObject("type")  
        ).mapperService();
            .startObject("dynamic_properties")
        assertEquals(mapping, mapper.mappingSource().toString());
        populateTracker(mapperService.getLuceneFieldTracker(), (int) limit - 1);
            .field("index", true)
            .startArray()
        assertEquals(mapping, mapper.mappingSource().toString());
        // Tracker has limit-1 fields → one slot still available.  
                    mapping.field("foo", "bar");
            .startObject("type")
    }
        String mapping = XContentFactory.jsonBuilder()
     */  
            .toString();  
            .startObject("type")
        MapperService mapperService = createIndex("test").mapperService();
            .field("type", "keyword")  
            .endObject()
        MapperService mapperService = createIndex("test").mapperService();
            {
        String existingField = "already_kw";
            .startObject("count_i")  
            .field("type", "long")
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);
            .startObject("count_i")
    public void testIllegalDynamicTemplateNoMappingType() throws Exception {
    }
        populateTracker(mapperService.getLuceneFieldTracker(), 50_000);
                mapping.endObject();  
            MapperParsingException.class,  
            .endObject()
            .startObject("i_*")  
            .endArray()  
                    if (randomBoolean()) {
            .toString();
        String mapping3 = XContentFactory.jsonBuilder()  
            .field("type", "keyword")
            .field("type", "long")
                    mapping.startObject("mapping");  
                mapping.field("match_mapping_type", "string");
            .endObject()
 * Unless required by applicable law or agreed to in writing,
            .startObject()  
        mapper = mapperService.merge("type", new CompressedXContent(mapping2), reason);  
import java.io.IOException;
            .toString();
            .startObject("type")
            "dynamic template [my_template1] has invalid content [{\"match_mapping_type\":\"string\",\"mapping\":{\"type\":"
            .endObject()
                mapping.startObject("mapping");
        assertNotNull(doc);  
            mapping.endArray();
     * Setting the limit to 0 disables the check entirely; even a full tracker must not block parsing.
            .endObject()  
        // *_i and i_* both match "i_i" -> must be rejected
            .endObject()  
     * Partial {@link MergeReason#MAPPING_UPDATE} must not drop prior {@code dynamic_properties}:
        assertEquals("second_template", templates[1].name());  
    }
            IllegalArgumentException e = expectThrows(
            .startObject("type")
            .endObject()
            "dynamic template [my_template2] has invalid content [{\"match_mapping_type\":\"string\",\"mapping\":{"
    // -----------------------------------------------------------------------  
        ).mapperService();  
            .endArray()
            mapping.endObject();
            .startObject()
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
            0,
            .startObject("*_s")  
            -1,
        DynamicProperty[] dps = mapperService.documentMapper().root().dynamicProperties();
            }
            .startObject("type")  
            .startObject("properties")
            .endObject()
            .startObject("mapping")  
        // no update if templates are not set explicitly
            } else {
            .field("dynamic_templates", Arrays.asList())
            .endObject()
        assertEquals(2, dps.length);
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();  
            .field("type", "keyword")
import org.opensearch.core.common.bytes.BytesArray;
            .field("path_match", "second")
        mapping.endObject();  
            infos[i] = makeFieldInfo("__lucene_field_" + i, i);  
        }
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
        String mapping3 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
 */  
        );
            .endObject()
            .startObject()  
    }  
    }
        mapping.endObject();
        );
        templates = mapper.root().dynamicTemplates();
        DocumentMapper mapper = mapperService.merge(  
import org.opensearch.index.mapper.MapperService.MergeReason;
        }
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
            XContentBuilder mapping = XContentFactory.jsonBuilder();
        String mapping = XContentFactory.jsonBuilder()
            .toString();
                    mapping.endObject();
    public void testIllegalDynamicTemplateUnknownFieldType() throws Exception {
        );
            .endObject()
    public void testDynamicPropertiesPatternCountLimit() throws IOException {
            .startObject("mapping")
            .endObject()  
        assertThat(mapper.mappingSource().toString(), containsString("\"analyzer\":\"foobar\""));  
            .startObject("*_i")
            .startObject("type")
            .endObject()  
        assertEquals("first", templates[0].pathMatch());
        long limit = 3L;
            .endArray()
        mapperService.merge("type", new CompressedXContent(second), MergeReason.INDEX_TEMPLATE);  
     * When the tracker snapshot is at the configured limit and the parsed field is new (not in the  
        MapperService mapperService = createIndex("test").mapperService();
        );  
    }
