        assertEquals(mapping2, mapper.mappingSource().toString());
        assertNotNull(doc);
            .toString();
        MapperService mapperService = createIndex("test").mapperService();
    }
            .toString();
                mapping.field("type", "text");
            .toString();
            .startObject("type")
 * GitHub history for details.
        ParsedDocument doc = mapper.parse(kwSource(existingField, "reused"));
            .field("match_mapping_type", "string")
                    mapping.field("type", "{dynamic_type}");
 * Modifications Copyright OpenSearch Contributors. See
            mapping.startArray("dynamic_templates");
        String mapping = XContentFactory.jsonBuilder()
            .endObject()
            .field("type", "keyword")
            .toString();
            .startObject("*_i")
            .toString();
            .field("type", "keyword")
        mapper = mapperService.merge("type", new CompressedXContent(mapping2), reason);
    }
        for (int i = 0; i < fieldCount; i++) {
            DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
/*
            .field("numeric_detection", true)
        MapperService mapperService = createIndex("test").mapperService();
            .startObject("type")
            .endObject()
public class RootObjectMapperTests extends OpenSearchSingleNodeTestCase {
            mapping.endObject();
        assertEquals(2, dynProps.length);
                mapping.endObject();
            .endObject()
        assertEquals(0, mapperService.documentMapper().root().dynamicProperties().length);
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), limit).build()
            .startObject("type")
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), limit).build()
        MapperParsingException e = expectThrows(
        String first = XContentFactory.jsonBuilder()
            .endObject()
        String mapping2 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
        MapperParsingException e = expectThrows(
        MapperService mapperService = createIndex("test").mapperService();
    public void testDynamicPropertiesPatternCountLimit() throws IOException {
            .endObject()
        assertNotNull(root.findDynamicProperty("foo_s"));
            new CompressedXContent(mapping),
            .toString();
 */
        assertEquals(mapping, mapper.mappingSource().toString());
                mapping.startObject("mapping");
    public void testDynamicPropertiesRequiresType() throws Exception {
        }
            .endObject()
        {
            .startObject("*_i")
            () -> mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE)
            .field("type", "integer")
        // update with a different explicit value
            IllegalArgumentException e = expectThrows(
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);
        String existingField = "already_kw";
            MapperParsingException.class,
    }
    /**
    }
            .startObject()
            .startObject("type")
    }
                    mapping.endObject();
    public void testDynamicTemplatesForIndexTemplate() throws IOException {
        assertThat(e.getMessage(), containsString("overlap"));
                }
                mapping.field("type", "keyword");
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
            .endObject()
            .endObject()
    public void testDynamicPropertiesLuceneFieldLimitRejectsNewField() throws Exception {
            .startObject("mapping")
            .endObject()
        assertThat(e.getMessage(), containsString("must have a mapping object"));
            .toString();
            .startObject("dynamic_properties")
        assertEquals("third", templates[2].pathMatch());
            MapperParsingException.class,
        }
            .startObject("type")
        MapperService mapperService = createIndex(
            .startObject("type")
            .field("type", "keyword")
        return new SourceToParse("index", "1", new BytesArray("{\"" + fieldName + "\": \"" + value + "\"}"), MediaTypeRegistry.JSON);
        assertEquals("first", templates[0].pathMatch());
        MapperService mapperService = createIndex("test").mapperService();
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);
            .startObject("*_kw")
            .startObject("type")
            .field("dynamic_templates", Arrays.asList())
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
                assertWarnings(
            }
import org.apache.lucene.index.FieldInfos;
            .toString();
            .startArray("dynamic_templates")
    /** Helper: pre-populate the tracker so it looks like N fields have been refreshed from the shard. */
            .toString();
        // update with an implicit value: no change
     */
            .endObject()
            .startObject("type")
            .startObject()
import java.io.IOException;
        String mapping3 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
        assertEquals(2, dps.length);
            .endObject()
            .startArray("dynamic_date_formats")
    public void testIllegalDynamicTemplateNoMappingType() throws Exception {
            .field("type", "long")
            .startObject()
            .endObject()
        mapperService.merge("type", new CompressedXContent(second), MergeReason.MAPPING_UPDATE);
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), reason);
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
    }
        mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
                mapping.startArray("dynamic_templates");
        for (String m : Arrays.asList(mapping, dynamicMapping)) {
            XContentBuilder mapping = XContentFactory.jsonBuilder();
        ).mapperService();
        MapperParsingException e = expectThrows(
            .field("date_detection", true)
            .field("date_detection", false)
        assertThat(e.getMessage(), containsString("must contain a wildcard"));
            .endObject()
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> parser.parse("type", new CompressedXContent(mapping)));
            .endObject()
            .endObject()
    }
import java.util.HashSet;
                mapping.endArray();
            .toString();
                        mapping.field("match", "string_*");
            boolean useMatchMappingType = randomBoolean();
                mapping.field("match_mapping_type", "string");
        long limit = 3L;
        }
     */
                mapping.startObject("mapping");
 */
    public void testDynamicPropertiesLuceneFieldLimitZeroDisablesCheck() throws Exception {
            .endArray()
        populateTracker(mapperService.getLuceneFieldTracker(), (int) limit - 1);
            .endArray()
        assertEquals(Set.of("*_i", "*_s"), patterns);
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
            .endObject()
            .startObject()
            .toString();
                    mapping.endObject();
        mapping = XContentFactory.jsonBuilder()
            .endObject()
            .toString();
    public void testIllegalDynamicTemplateInvalidAttribute() throws Exception {
        }
        String mapping = XContentFactory.jsonBuilder()
        String mapping3 = XContentFactory.jsonBuilder()
            .toString();
                mapping.endObject();
        );
            {
            .startObject("*_s")
            .endObject()
 *
            .startObject("dynamic_properties")
            .startObject("type")
            .endObject()
import org.apache.lucene.index.IndexOptions;
            .toString();
            .startArray("dynamic_templates")
        MapperService mapperService = createIndex("test").mapperService();
        return XContentFactory.jsonBuilder()
            .endObject()
            .field("type", "integer")
            .endObject()
                }
            .startObject("type")
            }
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals("second_template", templates[1].name());
            .endObject()
        }
            .field("type", "long")
                    } else {
            .startObject("*_i")
        MapperService mapperService = createIndex("test").mapperService();
            .field("type", "keyword")
            .startObject("dynamic_templates")
                    mapping.endObject();
    public void testNumericDetection() throws Exception {
        assertEquals(3, templates.length);
            .startObject("dynamic_properties")
            .field("type", "long")
            .endObject()
            .field("path_match", "third")
    }
            mapping.startArray("dynamic_templates");
 * compatible open source license.
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
        String mapping = XContentFactory.jsonBuilder()
    // Lucene field-count limit tests
            .endObject()
        );
            .startObject("type")
            .startObject("first_template")
            .startObject()
                mapping.endObject();
                + "caused by [unknown parameter [foo] on mapper [__dynamic__my_template2] of type [keyword]]"
            {
            .endObject()
    public void testDynamicPropertiesAllowsNonOverlappingPatterns() throws Exception {
     * When the tracker snapshot is below the limit, a new dynamic-property field is allowed.
                {
        assertThat(mapper.mappingSource().toString(), containsString("\"foo\":\"bar\""));
        MapperService mapperService = createIndex(
        String mapping2 = XContentFactory.jsonBuilder()
 */
                mapping.startObject();
        templates = mapper.root().dynamicTemplates();
        mapperService.merge("type", new CompressedXContent(first), MergeReason.MAPPING_UPDATE);
    /**
            .startObject()
    }
        ).mapperService();
            .endObject()
        assertThat(e.getMessage(), containsString("No handler for type"));
            .endObject()
        }
        MapperService mapperService = createIndex(
            .toString();
            .startArray()
    public void testDynamicPropertiesLuceneFieldLimitAllowsFieldBelowLimit() throws Exception {
import org.apache.lucene.index.DocValuesType;
        mapperService.getLuceneFieldTracker().setFieldInfos(new FieldInfos(infos));
        DynamicProperty[] dps = mapperService.documentMapper().root().dynamicProperties();
            .startObject("mapping")
                    "dynamic template [my_template4] has invalid content [{\"match_mapping_type\":\"*\",\"mapping\":{"
            .startArray("dynamic_templates")
        mapping.endObject().endObject().endObject();
        // no update if templates are not set explicitly
            mapping.startObject();
            .startObject("type")
    /** Registering more than {@link RootObjectMapper#MAX_DYNAMIC_PROPERTIES} patterns must be rejected. */
            .endObject()
        return false;
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);
            false,
            mapping.endArray();
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
                mapping.startObject("my_template2");
            .field("dynamic_date_formats", Arrays.asList())
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("type").startObject("dynamic_properties");
            .startObject("count_i")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertEquals(mapping, mapper.mappingSource().toString());
            .startObject("my_template")
    /**
    public void testDynamicPropertiesPatternRequiresWildcard() throws Exception {
        // There should be no update if templates are not set.
            .startObject("mapping")
            0,
                );
            .endObject()
        assertThat(e.getMessage(), containsString("overlap"));
            .endObject()
    /**
        assertEquals("second_updated", templates[1].pathMatch());
    public void testDynamicPropertiesTemplateMergeRejectsExplicitOverlap() throws Exception {
            .startObject()
                    if (useMatchMappingType) {
        // Tracker has limit-1 fields → one slot still available.
        assertWarnings(
    }
            mapping.endObject();
            .endObject()
     */
                mapping.endObject();
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
    }
            .field("type", "keyword")
            .endObject()
        RootObjectMapper root = mapperService.documentMapper().root();
    }
            .endObject()
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), reason);
            .startObject()
            .field("type", "long")
        RootObjectMapper root = mapperService.documentMapper().root();
            .toString();
            .startObject()
import org.opensearch.common.compress.CompressedXContent;
/*
        assertEquals(RootObjectMapper.MAX_DYNAMIC_PROPERTIES, mapper.root().dynamicProperties().length);
        // Simulate a refresh: tracker has exactly `limit` field names, none matching *_kw.
            .endObject()
            .startObject()
        MapperParsingException e = expectThrows(
            .field("type", "not_a_real_mapper_type_xyz")
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
    }
        mapperService.merge("type", new CompressedXContent(first), MergeReason.INDEX_TEMPLATE);
            .endObject()
        Set<String> patterns = new HashSet<>();
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), limit).build()
        populateTracker(mapperService.getLuceneFieldTracker(), 50_000);
            .startObject("mapping")
import java.util.Set;
            .startObject("type")
    }
        mapper = mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);
    }
            .endObject()
            DocValuesSkipIndexType.NONE,
            mapping.endObject();
            .startObject()
    public void testDynamicPropertiesRejectsBareStarPattern() throws Exception {
            .startObject("type")
            .startObject()
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
    }
        // Parsing a field already in the tracker must succeed (no new slot needed).
            .endObject()
        mapping.endObject();
                    mapping.startObject();
            mapping.endArray();
            if (useMatchMappingType) {
            "idx_at_limit",
            .startObject()
        infos[0] = makeFieldInfo(existingField, 0);
        );
            .endObject()
 *     http://www.apache.org/licenses/LICENSE-2.0
            .endObject()
            .startObject("dynamic_properties")
        // update with an implicit value: no change
    @Override
            .toString();
            .endObject()
            .startObject()
}
            "dynamic template [my_template1] has invalid content [{\"match_mapping_type\":\"string\",\"mapping\":{\"type\":"
            .field("type", "keyword")
                mapping.endObject();
            MapperParsingException.class,
            mapping.startObject("type");
            .endArray()
            .startObject("dynamic_properties")
        );
                mapping.startArray("dynamic_templates");
            .startObject("properties")
            .startObject()
        assertEquals(mapping, mapper.mappingSource().toString());
            "dynamic template [my_template3] has invalid content [{\"match_mapping_type\":\"string\",\"mapping\":{"
        DocumentMapper mapper = mapperService.merge(
 * license agreements. See the NOTICE file distributed with
            .endObject()
            .field("path_match", "first")
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
            .endObject()
import org.opensearch.core.xcontent.XContentBuilder;
            .startObject("*_i")
    /** Helper: build a SourceToParse with a single keyword field matching *_kw. */
        assertEquals(mapping, mapper.mappingSource().toString());
            .endObject()
        assertNotNull(doc);
            .endObject()
            .startObject()
            mapping.startArray("dynamic_templates");
                () -> parser.parse("type", new CompressedXContent(m))
            .field("type", "keyword")
            {
            false,
        DynamicProperty[] dps = mapperService.documentMapper().root().dynamicProperties();
        mapping.startObject();
        assertEquals("second", templates[1].pathMatch());
        XContentBuilder mapping = XContentFactory.jsonBuilder();
            .field("type", "keyword")
        );
            .endObject()
            .startObject()
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
        assertEquals("*_i", root.findDynamicProperty("count_i").getPattern());
            .startObject()
        assertEquals("*_i", dps[0].getPattern());
        // Should succeed: empty tracker means the limit check is skipped.
        return new FieldInfo(
package org.opensearch.index.mapper;
    public void testDynamicPropertiesEmptyObject() throws Exception {
            .startArray("date_formats")
            .value("test_format")
        MapperService mapperService = createIndex("test").mapperService();
 * this work for additional information regarding copyright
            .startObject("dynamic_properties")
            .startObject("type")
        // Cannot add explicit property "count_i" when dynamic_property "*_i" exists
            .endObject()
        MapperService mapperService = createIndex(
            .startObject("dynamic_properties")
            mapperService = createIndex("test").mapperService();
        FieldInfo[] infos = new FieldInfo[fieldCount];
     * Partial {@link MergeReason#MAPPING_UPDATE} must not drop prior {@code dynamic_properties}:
    }
        mapper = mapperService.merge("type", new CompressedXContent(mapping3), MergeReason.MAPPING_UPDATE);
        MapperService mapperService = createIndex("test").mapperService();
        DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping), reason);
        for (int i = 0; i <= RootObjectMapper.MAX_DYNAMIC_PROPERTIES; i++) {
    public void testDynamicPropertiesLuceneFieldLimitAllowsExistingTrackedField() throws Exception {
        );
            {
        // *_i and i_* both match "i_i" -> must be rejected
        assertEquals("integer", dps[0].getMapping().get("type"));
            mapping.startObject("type");
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
            .startObject("type")
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
                + "\"foo\":\"bar\",\"type\":\"keyword\"}}], "
        String mapping2 = XContentFactory.jsonBuilder()
                + "\"string\"}}], caused by [No mapper found for type [string]]"
        assertEquals(2, templates.length);
            infos[i] = makeFieldInfo("__lucene_field_" + i, i);
            .toString();
        ParsedDocument doc = mapper.parse(kwSource("ok_kw", "value"));
    }
            .toString();
            mapping.startObject("*_field" + i).field("type", "keyword").endObject();
            .startObject("type")
                );
            assertThat(mapper.mappingSource().toString(), containsString("\"foo\":\"bar\""));
import org.opensearch.test.OpenSearchSingleNodeTestCase;
        MapperParsingException e = expectThrows(
    }
                mapping.endObject();
            .toString();
            .endObject()
     * entries merge by pattern key (same behavior family as {@code dynamic_templates} name-based merge).
        String second = XContentFactory.jsonBuilder()
            .startObject()
            .field("type", "long")
    /** Empty {@code dynamic_properties: {}} is valid and exercises merge validation on an empty rule list. */
        assertWarnings(
    }
            -1,
            .startObject("a*")
            .toString();
     * When the tracker snapshot is at the limit but the field being parsed is already tracked
                    }
                mapping.startObject("type");
            .field("type", "long")
            MapperParsingException.class,
            .endObject()
            .startObject("type")
        MapperService mapperService = createIndex("test").mapperService();
        {
            .startArray()
                mapping.field("match_mapping_type", "string");
     */
                mapping.endObject();
            .field("type", "long")
            .endObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder().startObject().startObject("type").startObject("dynamic_properties");
 * not use this file except in compliance with the License.
        ParsedDocument doc = mapper.parse(kwSource("new_kw", "hello"));
    private static FieldInfo makeFieldInfo(String name, int number) {
        mapping.startObject();
        String mapping = XContentFactory.jsonBuilder()
    public void testDateDetection() throws Exception {
                    mapping.field("index_phrases", true);
            .endObject()
    /** Helper: create a minimal {@link FieldInfo} with the given name and field number. */
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
            .startObject("type")
        assertNotNull(doc);
        mapperService.merge("type", new CompressedXContent(second), MergeReason.INDEX_TEMPLATE);
 * this file be licensed under the Apache-2.0 license or a
        String mapping = XContentFactory.jsonBuilder()
        assertThat(e.getMessage(), containsString("count_i"));
            .endObject()
    public void testDynamicPropertiesExplicitFieldMatchesPatternRejected() throws Exception {
            .endObject()
            .endObject()
     * (i.e. it already exists in Lucene), it must not be rejected — existing fields reuse their slot.
            false,
        }
            .startObject("type")
            .startObject("*_i")
        ).mapperService();
            .endObject()
            );
            .endObject()
                mapping.endObject();
    public void testIllegalDynamicTemplateUnknownAttribute() throws Exception {
            .startObject("type")
        String mapping = XContentFactory.jsonBuilder()
    }
            XContentBuilder mapping = XContentFactory.jsonBuilder();
                mapping.startObject("my_template3");
                assertWarnings(
                mapping.field("analyzer", "foobar");
        );
        String mapping = XContentFactory.jsonBuilder()
        String mapping = XContentFactory.jsonBuilder()
                    mapping.startObject();
        assertEquals(mapping2, mapper.mappingSource().toString());
            .endObject()
            assertThat(mapper.mappingSource().toString(), containsString("\"index_phrases\":true"));
import org.apache.lucene.index.DocValuesSkipIndexType;
            .startObject("dynamic_properties")
            .startObject("type")
import org.opensearch.core.xcontent.MediaTypeRegistry;
        // Even with a large tracker snapshot, limit=0 means the check is disabled.
            .startObject("dynamic_properties")
    }
        }
        mapping.endObject().endObject().endObject();
            .endObject()
 * SPDX-License-Identifier: Apache-2.0
        // a* and b* have empty language intersection — distinct field name prefixes.
            .startObject("mapping")
        }
            .startObject()
        for (int i = 1; i < limit; i++) {
            .toString();
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
 * specific language governing permissions and limitations
                    mapping.startObject("mapping");
                    mapping.startObject("mapping");
        MapperService mapperService = createIndex("test").mapperService();
        }
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
        );
            false
            .endObject()
            .startObject("title")
            0,
            .startObject("*abchdi*")
            .startObject("dynamic_properties")
            .startObject("*_i")
                mapping.startObject("type");
        assertEquals(mapping3, mapper.mappingSource().toString());
 * The OpenSearch Contributors require contributions made to
                    mapping.endObject();
            .startObject("*_i")
            .startObject()
            .startObject("*_i")
     * When the tracker is empty (no refresh yet), the field-count limit is not applied and
            .startObject("dynamic_properties")
            .startObject()
            .startObject("dynamic_properties")
        String mapping = XContentFactory.jsonBuilder()
    }
            .endObject()
 * Licensed to Elasticsearch under one or more contributor
        mapperService.merge(MapperService.SINGLE_MAPPING_NAME, new CompressedXContent(mapping), MergeReason.INDEX_TEMPLATE);
    /** Same pattern key in a later update replaces the previous mapping for that pattern only. */
            mapping.endObject();
import java.util.Collections;
            .endObject()
            .endObject()
            .endObject()
    public void testDynamicPropertiesLuceneFieldLimitNotEnforcedWhenTrackerEmpty() throws Exception {
     * Setting the limit to 0 disables the check entirely; even a full tracker must not block parsing.
        long limit = 3L;
            .startObject("type")
    public void testDynamicPropertiesMustBeObject() throws Exception {
            .startObject("*_i*")
            .startObject("properties")
            .startObject()
        String mapping = XContentFactory.jsonBuilder()
        }
                    }
            .endObject()
            0,
            .endObject()
        for (DynamicProperty dp : root.dynamicProperties()) {
        }
    public void testDateFormatters() throws Exception {
            } else {
            {
        MapperService mapperService = createIndex("test").mapperService();
    }
                mapping.endObject();
                    if (randomBoolean()) {
    public void testIllegalDynamicTemplates() throws Exception {
        assertNotNull(doc);
            .startObject()
import org.apache.lucene.index.VectorSimilarityFunction;
    }
            .endObject()
 *
            .field("type", "long")
        mapping.startObject();
/*
            .field("type", "keyword")
        // Tracker starts with FieldInfos.EMPTY (no engine in unit-test context) → size is 0.
        String mapping = XContentFactory.jsonBuilder()
            .startObject()
            name,
            .endObject()
    /**
        mapping.endObject();
            .field("type", "keyword")
        assertThat(e.getMessage(), containsString("count_i"));
            VectorSimilarityFunction.EUCLIDEAN,
            .startObject()
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
        );
            MapperParsingException.class,
        XContentBuilder mapping = XContentFactory.jsonBuilder();
        ParsedDocument doc = mapper.parse(kwSource("any_kw", "no_limit"));
            .endObject()
            .startObject("type")
            .field("dynamic_date_formats", Arrays.asList("yyyy-MM-dd"))
 * under the License.
        assertThat(e.getMessage(), containsString("limit [" + limit + "]"));
                mapping.startObject();
            .endObject()
        XContentBuilder mapping = XContentFactory.jsonBuilder();
        MapperParsingException e = expectThrows(
            .endArray()
     * tracker), the parse must throw {@link MapperParsingException}.
    }
            .endObject()
                    mapping.startObject("my_template4");
    public void testDynamicPropertiesEntryMustBeMappingObject() throws Exception {
        String explicitFirst = XContentFactory.jsonBuilder()
        assertEquals("third_template", templates[2].name());
            .startObject("*_i")
    // -----------------------------------------------------------------------
            DocValuesType.NONE,
        MapperService mapperService = createIndex("test").mapperService();
    }
            .startObject("second_template")
    }
            .endObject()
        );
                    mapping.startObject("my_template4");
        assertThat(e.getMessage(), containsString(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey()));
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), 0L).build()
                + "\"analyzer\":\"foobar\",\"type\":\"text\"}}], caused by [analyzer [foobar] has not been configured in mappings]"
            .toString();
            }
            .startObject("properties")
            MergeReason.INDEX_TEMPLATE
            .field("index", true)
            .startObject("*")
        MapperService mapperService;
        ).mapperService();
            .endArray()
 * Unless required by applicable law or agreed to in writing,
    public void testIllegalFormatField() throws Exception {
        );
            IndexOptions.NONE,
            .startObject()
    public void testDynamicPropertiesAmbiguousPatternsRejected() throws Exception {
        mapperService.merge("type", new CompressedXContent(second), MergeReason.MAPPING_UPDATE);
                        + "caused by [unknown parameter [foo] on mapper [__dynamic__my_template4] of type [binary]]"
            .startObject("*_s")
            MapperParsingException.class,
        String mapping = XContentFactory.jsonBuilder()
            .field("type", "keyword")
        );
    public void testDynamicPropertiesMappingUpdateReplacesSamePattern() throws Exception {
        assertThat(e.getMessage(), containsString("pattern [*] is not allowed"));
        MapperParsingException e = expectThrows(
 * You may obtain a copy of the License at
    public void testDynamicPropertiesTemplateMergeMergesSecondPattern() throws Exception {
        assertEquals("second_template", templates[1].name());
            }
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);
    public void testDynamicPropertiesPatternCountAtLimit() throws IOException {
        String mapping3 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
                    mapping.field("type", "{dynamic_type}");
                mapping.field("foo", "bar");
        MapperService mapperService = createIndex("test").mapperService();
            .startObject("type")
        long limit = 5L;
        assertNotNull(root.findDynamicProperty("count_i"));
import org.opensearch.common.settings.Settings;
            .endObject()
            .toString();
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
            mapping.startObject("*_field" + i).field("type", "keyword").endObject();
            .endObject()
            .endObject()
        assertNotNull(root.findDynamicProperty("x_i"));
        assertEquals(2, root.dynamicProperties().length);
            MapperParsingException.class,
            "idx_below_limit",
        assertThat(mapper.mappingSource().toString(), containsString("\"analyzer\":\"foobar\""));
            .startObject("b*")
            .endObject()
                IllegalArgumentException.class,
            mapping.startObject("type");
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
        DocumentMapper mapper = mapperService.merge("_doc", new CompressedXContent(dynKwMapping()), MergeReason.MAPPING_UPDATE);
            .field("type", "double")
            .endObject()
            .endObject()
            .endObject()
            .startObject("dynamic_properties")
        assertEquals(2, root.dynamicProperties().length);
            infos[i] = makeFieldInfo("__lucene_field_" + i, i);
import org.opensearch.index.mapper.MapperService.MergeReason;
    }
                mapping.endArray();
            () -> mapperService.merge("type", new CompressedXContent(dynamicSecond), MergeReason.INDEX_TEMPLATE)
        MapperService mapperService = createIndex("test").mapperService();
        assertThat(e.getMessage(), containsString("Explicit fields cannot overlap"));
        MapperParsingException e = expectThrows(
        mapper = mapperService.merge("type", new CompressedXContent(mapping3), reason);
            .startObject("third_template")
        populateTracker(mapperService.getLuceneFieldTracker(), (int) limit);
    }
        // no update if formatters are not set explicitly
    }
        for (int i = 1; i <= RootObjectMapper.MAX_DYNAMIC_PROPERTIES; i++) {
            .endObject()
            mapping.endArray();
        // Tracker has exactly `limit` fields — but the field we are about to parse is among them.
        assertEquals(Set.of("*_i", "*_s"), patterns);
            .endObject()
            .toString();
        DynamicTemplate[] templates = mapper.root().dynamicTemplates();
        mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
            .field("numeric_detection", false)
                mapping.field("match_mapping_type", "string");
        tracker.setFieldInfos(new FieldInfos(infos));
        assertEquals(mapping, mapper.mappingSource().toString());
            "idx_empty",
import org.opensearch.common.xcontent.XContentFactory;
        long limit = 3L;
     */
            .startObject("count_i")
            MapperService.SINGLE_MAPPING_NAME,
            .startObject("field")
            .endObject()
        MapperService mapperService = createIndex("test").mapperService();
            MapperParsingException.class,
        );
            .endObject()
            .startObject()
            .field("path_match", "second")
        assertThat(mapper.mappingSource().toString(), containsString("\"type\":\"string\""));
 * ownership. Elasticsearch licenses this file to you under
    public void testDynamicTemplates() throws Exception {
            .endObject()
            .startObject("dynamic_properties")
            patterns.add(dp.getPattern());
            .endObject()
            .endObject()
            .startObject("properties")
        assertNotNull(root.findDynamicProperty("y_s"));
            .endObject()
        String mapping = XContentFactory.jsonBuilder()
        MapperService mapperService = createIndex("test").mapperService();
            .startObject()
        {
    public void testDynamicPropertiesRejectsOverlappingGlobPatterns() throws Exception {
        mapperService.merge("type", new CompressedXContent(first), MergeReason.MAPPING_UPDATE);
            .endObject()
        assertWarnings(
    }
            .toString();
                        + "\"foo\":\"bar\",\"type\":\"{dynamic_type}\"}}], "
import org.opensearch.core.common.bytes.BytesArray;
            .toString();
    }
        assertEquals("first", templates[0].pathMatch());
            assertEquals("Invalid format: [[test_format]]: expected string value", e.getMessage());
    public void testDynamicPropertiesRejectsUnknownType() throws Exception {
        String mapping = XContentFactory.jsonBuilder()
            .startObject()
            .startObject()
            VectorEncoding.FLOAT32,
        mapper = mapperService.merge("type", new CompressedXContent(mapping2), reason);
        String mapping3 = XContentFactory.jsonBuilder()
                    "dynamic template [my_template4] has invalid content [{\"match\":\"string_*\",\"mapping\":{"
            .startObject("dynamic_properties")
    protected boolean forbidPrivateIndexSettings() {
                mapping.startObject("my_template1");
     */
        String second = XContentFactory.jsonBuilder()
            .startObject("type")
            .field("type", "long")
    // -----------------------------------------------------------------------
        assertEquals(mapping2, mapper.mappingSource().toString());
            .endObject()
        String second = XContentFactory.jsonBuilder()
    private static String dynKwMapping() throws IOException {
                    } else {
    }
                        + "\"foo\":\"bar\",\"type\":\"{dynamic_type}\"}}], "
        assertEquals("*_i", dynProps[0].getPattern());
        assertThat(e.getMessage(), containsString("No type specified"));
        mapping.endObject();
            .endObject()
    public void testDynamicProperties() throws Exception {
        ).mapperService();
            .endObject()
            .field("type", "long")
                    mapping.endObject();
import org.apache.lucene.index.FieldInfo;
            .endObject()
    }
    public void testDynamicPropertiesMappingUpdateMergesByPattern() throws Exception {
        MapperService mapperService = createIndex(
                        mapping.field("match_mapping_type", "*");
        assertNull(root.findDynamicProperty("other"));
            .startObject()
            .toString();
    }
            .endObject()
            .endObject()
     * When the tracker snapshot is at the configured limit and the parsed field is new (not in the
            .endObject()
    /** Helper: build a dynamic_properties mapping for pattern {@code *_kw} → keyword. */
        assertEquals(mapping2, mapper.mappingSource().toString());
    }
            .endObject()
            .startObject("i_*")
        assertEquals("first_template", templates[0].name());
        MapperParsingException e = expectThrows(
            DocumentMapper mapper = mapperService.merge("type", new CompressedXContent(mapping.toString()), MergeReason.MAPPING_UPDATE);
            .startObject("second_template")
            .endObject()
        assertEquals("Dynamic template syntax error. An array of named objects is expected.", e.getMessage());
        // update with a different explicit value
            .endArray()
            .startObject()
    public void testIllegalDynamicTemplateUnknownFieldType() throws Exception {
        assertThat(e.getMessage(), containsString("*_i"));
        mapper = mapperService.merge("type", new CompressedXContent(mapping2), reason);
            .endObject()
        assertThat(e.getMessage(), containsString("must be an object"));
            .startObject("type")
            .field("type", "keyword")
            .startObject()
        assertEquals(mapping, mapper.mappingSource().toString());
        );
            MapperParsingException.class,
            .endObject()
        mapper = mapperService.merge("type", new CompressedXContent(mapping3), reason);
            number,
        assertEquals(0, mapperService.getLuceneFieldTracker().getFieldInfos().size());
            .startObject("type")
            mapping.startObject();
        FieldInfo[] infos = new FieldInfo[(int) limit];
        MapperParsingException e = expectThrows(
            .toString();
            .endObject()
            .endObject()
        {
            .startObject("type")
            .startObject()
            .startObject()
        MapperParsingException e = expectThrows(
            .endObject()
            .startObject("*_i")
            .endObject()
            .endObject()
        assertThat(e.getMessage(), containsString("i_*"));
                mapping.field("type", "string");
            .startObject()
            "idx_existing",
            .endObject()
        DocumentMapperParser parser = createIndex("test").mapperService().documentMapperParser();
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
            .endObject()
            .startObject()
            .startObject("dynamic_properties")
import static org.hamcrest.Matchers.containsString;
        );
        assertThat(e.getMessage(), containsString("exceeds the maximum allowed [" + RootObjectMapper.MAX_DYNAMIC_PROPERTIES + "]"));
            .endObject()
    /**
            mapping.endObject();
                        + "caused by [unknown parameter [foo] on mapper [__dynamic__my_template4] of type [binary]]"
        MapperService mapperService = createIndex("test").mapperService();
    private static void populateTracker(LuceneFieldTracker tracker, int fieldCount) {
            .startObject("type")
        MapperService mapperService = createIndex("test").mapperService();
            .toString();
    }
        assertEquals(1, dps.length);
            .startObject()
            .endObject()
            .endObject()
        assertThat(e.getMessage(), containsString("*_i"));
            .field("path_match", "second_updated")
import org.apache.lucene.index.VectorEncoding;
        MergeReason reason = randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.INDEX_TEMPLATE);
            .startObject("dynamic_properties")
            false,
            .endArray()
            .field("type", "keyword")
        );
            .field("*_i", "long")
            .endObject()
            MapperParsingException.class,
            .endObject()
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), limit).build()
    }
            .endObject()
        DynamicProperty[] dynProps = root.dynamicProperties();
            .toString();
        MapperService mapperService = createIndex("test").mapperService();
        mapper = mapperService.merge("type", new CompressedXContent(mapping2), MergeReason.MAPPING_UPDATE);
            .endObject()
        String mapping2 = XContentFactory.jsonBuilder().startObject().startObject("type").endObject().endObject().toString();
            .endObject()
            .startObject("_doc")
            .endObject()
 * KIND, either express or implied.  See the License for the
            .value("test_format")
        MapperService mapperService = createIndex("test").mapperService();
            .startObject("dynamic_properties")
 * software distributed under the License is distributed on an
            .endObject()
            .endObject()
                    mapping.endObject();
            .toString();
            .field("type", "keyword")
        assertEquals("first_template", templates[0].name());
            .toString();
        for (DynamicProperty dp : dps) {
            .endObject()
            .toString();
            .field("type", "integer")
            .startObject("*_s")
        {
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
        String dynamicMapping = XContentFactory.jsonBuilder()
        String mapping = XContentFactory.jsonBuilder()
                {
                mapping.endObject();
            .startObject("dynamic_properties")
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
        String first = XContentFactory.jsonBuilder()
        String mapping = XContentFactory.jsonBuilder()
        Set<String> patterns = new HashSet<>();
     * dynamic-property fields can be created freely.
            MapperParsingException.class,
        assertEquals("*_s", dynProps[1].getPattern());
        MapperParsingException e = expectThrows(MapperParsingException.class, () -> mapper.parse(kwSource("brand_new_kw", "value")));
            "dynamic template [my_template2] has invalid content [{\"match_mapping_type\":\"string\",\"mapping\":{"
import java.util.Arrays;
                    mapping.field("foo", "bar");
            .startObject("count_i")
        MapperService mapperService = createIndex("test").mapperService();
            .endObject()
            patterns.add(dp.getPattern());
            }
            .startArray("dynamic_properties")
            0,
                mapping.endObject();
        mapping = XContentFactory.jsonBuilder()
                mapping.startObject("mapping");
            .endObject()
            .endObject()
            .endObject()
            .toString();
    private static SourceToParse kwSource(String fieldName, String value) {
                mapping.startObject();
        String first = XContentFactory.jsonBuilder()
            .startObject()
            }
        mapperService.merge("type", new CompressedXContent(explicitFirst), MergeReason.INDEX_TEMPLATE);
            .endObject()
                        mapping.field("match", "string_*");
            () -> mapperService.merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE)
            .endArray()
        assertEquals(mapping3, mapper.mappingSource().toString());
        // Dynamic templates should be appended and deduplicated.
            .startObject("type")
            .endObject()
 *
            .endObject()
        mapper = mapperService.merge("type", new CompressedXContent(mapping3), reason);
            Collections.emptyMap(),
                        mapping.field("match_mapping_type", "*");
        RootObjectMapper root = mapper.root();
    /** Registering exactly {@link RootObjectMapper#MAX_DYNAMIC_PROPERTIES} patterns must succeed. */
            "idx_zero_limit",
        String dynamicSecond = XContentFactory.jsonBuilder()
