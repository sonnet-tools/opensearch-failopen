        assertEquals(1, indexService.getIndexSortSupplier().get().getSort().length);
            () -> createIndex(
        IllegalArgumentException invalidNestedException = expectThrows(
        MapperService mapperService = createIndex("test1", settings).mapperService();
                    .endObject()
            .startObject("properties")
                "test1",
            .startObject("age")
            .endObject()
                    + ". Please change the setting value or increase per-JVM limit using 'opensearch.xcontent.depth.max' system property."
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
                    .field("type", "text")
        CompressedXContent mapping = new CompressedXContent(
                    .field("type", "text")
            IllegalArgumentException.class,
        mapperService.merge("type", mapping, MergeReason.MAPPING_UPDATE);
        IndexService indexService = createIndex("test", settings, "t", "nested_field", "type=nested", "foo", "type=keyword");
    public void testDynamicPropertiesLuceneFieldLimitSettingRecognized() throws IOException {
                        @Override
                    .endObject()
        TokenFilterFactory[] originalTokenFilters = originalReloadableAnalyzer.getComponents().getTokenFilters();
            )
    }
            .field("type", "keyword")
            expected.add(DocumentInput.ROW_ID_FIELD);
                    .startObject()
    public void testPreflightUpdateDoesNotChangeMapping() throws Throwable {
            )
        assertThat(e.getMessage(), containsString("Limit of mapping depth [1] has been exceeded"));
            .put("index.analysis.analyzer.reloadableAnalyzer.type", "custom")
                XContentFactory.jsonBuilder()
            BytesReference.bytes(
                    .startObject("field")
        return false;
                    .startObject(testString)
        );
 * KIND, either express or implied.  See the License for the
                    .startObject("_doc")
            "test1",
    }
        assertTrue(indexService.mapperService().getIndexSettings().getIndexSortConfig().hasIndexSort());
        int maxFieldNameLength = randomIntBetween(25, 30);
        return true;
            .build();
        int numberOfFieldsIncludingAlias = 2;
    public void testGetMetadataFieldsReturnsExpectedSet() throws Throwable {
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
        MapperService mapperService = createIndex("test1", settings).mapperService();
import org.opensearch.common.xcontent.XContentFactory;
                    .endObject()
        final IllegalArgumentException ex = assertThrows(
    protected boolean forbidPrivateIndexSettings() {
        assertWarnings(
        Settings settings = Settings.builder()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
        Settings settings = Settings.builder().putList("index.sort.field", "contacts.age").put("index.sort.order", "desc").build();
        CompressedXContent mappingUpdate = new CompressedXContent(
import org.opensearch.index.analysis.IndexAnalyzers;
                .execute()
                @Override
import org.opensearch.test.OpenSearchSingleNodeTestCase;
    public void testAliasFieldNameLengthLimit() throws Throwable {
        IndexService indexService = createIndexWithSimpleMappings("test", settings, "foo", "type=keyword");
    public void testTypeValidation() {
                XContentFactory.jsonBuilder()
        // a field alias pushes the mapping over the limit.
        assertEquals("Field name [" + testString + "] is longer than the limit of [" + maxFieldNameLength + "] characters", e.getMessage());
 * this file be licensed under the Apache-2.0 license or a
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
import static org.hamcrest.Matchers.notNullValue;
        return Arrays.asList(InternalSettingsPlugin.class, ReloadableFilterPlugin.class);
        String testString = new String(new char[maxFieldNameLength + 1]).replace("\0", "a");
import org.opensearch.index.analysis.AnalysisMode;
public class MapperServiceTests extends OpenSearchSingleNodeTestCase {
            .build();
                    .startObject()
            .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), maxFieldNameLength)
            .startObject("properties")
import org.opensearch.index.mapper.MapperService.MergeReason;
            createIndex("test" + i, settings).mapperService();
                    .field("search_analyzer", "reloadableAnalyzer")
                    .endObject()
        int maxFieldNameLength = randomIntBetween(15, 20);
            "test1",
            });
    }
        MapperService mapperService = createIndex("test_index", settings).mapperService();
        IndexAnalyzers updatedAnalyzers = mapperService.getIndexAnalyzers();
        mappingBuilder.endObject().endObject();
    private boolean assertSameContainedFilters(TokenFilterFactory[] originalTokenFilter, NamedAnalyzer updatedAnalyzer) {
                    .startObject("properties")
        // back compat
        assertFalse(assertSameContainedFilters(originalTokenFilters, current.get("reloadableAnalyzer")));
            "test",
        Settings settings = Settings.builder()
    public void testIndexSortWithNestedFieldsValidation() throws IOException {
                    + (XContentConstraints.DEFAULT_MAX_DEPTH + 1)
        ReloadableCustomAnalyzer originalReloadableAnalyzer = (ReloadableCustomAnalyzer) current.get("reloadableAnalyzer").analyzer();
                    };
        assertEquals("mapping type name [_type] can't start with '_' unless it is called [_doc]", e.getMessage());
        });
 * the Apache License, Version 2.0 (the "License"); you may
        indexService1.mapperService().merge("type", createMappingSpecifyingNumberOfFields(1), MergeReason.MAPPING_UPDATE);
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                    .startObject("properties")
            )
            .startObject("field")
        for (TokenFilterFactory tf : newTokenFilters) {
        IllegalArgumentException e = expectThrows(
            Settings.builder().put(MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getKey(), 1).build()
                    .build()
    }
                    .startObject()
        int numberOfNonAliasFields = 1;
    }
                .isAcknowledged()
                    .field("type", "text")
                    .startObject("properties")
            IllegalArgumentException.class,
            assertEquals(originalTokenFilter[i].name(), tf.name());
    }
            )
            mapperService.merge("type", mappingUpdate, updateOrPreflight());
        );
    public void testIndexSortWithNestedFieldsWithOlderVersion() throws IOException {
 */
        final List<Function<Settings.Builder, Settings.Builder>> scenarios = List.of(
            IllegalArgumentException.class,
        XContentBuilder mapping = jsonBuilder().startObject()
            )
    public void testObjectNameLengthLimit() throws Throwable {
            () -> createIndexWithSimpleMappings("test", settings, "nested_field", "type=nested", "foo", "type=keyword")
        int maxFieldNameLength = randomIntBetween(15, 20);
        IndexAnalyzers current = mapperService.getIndexAnalyzers();
            .field("type", "integer")
        );
        assertThat(mapperService.unmappedFieldType("long"), instanceOf(NumberFieldType.class));
    }
import java.util.List;
        assertEquals(originalTokenFilter.length, newTokenFilters.length);
                    .endObject()
        // sandbox stack is installed.
        assertTrue(
                    .field("search_quote_analyzer", "reloadableAnalyzer")
        );
                    .startObject("alias")
        // Set the total fields limit to the number of non-alias fields, to verify that adding
        MapperService.validateTypeName("_doc"); // no exception
        });
                        public TokenStream create(TokenStream tokenStream) {
        CompressedXContent mapping = new CompressedXContent(
                    .endObject()
        );
                    .field("type", "text")
        assertEquals("mapping type name [_document] can't start with '_' unless it is called [_doc]", e.getMessage());
                    .endObject()
        assertWarnings("[unmapped_type:string] should be replaced with [unmapped_type:keyword]");
                "The provided value "
                    .endObject()
                XContentFactory.jsonBuilder()
        assertSame(current, updatedAnalyzers);
        XContentBuilder mappingBuilder = XContentFactory.jsonBuilder().startObject().startObject("properties");
                        @Override
        );
        );
                    .field("path", "field")
            (builder) -> builder.putNull(MapperService.INDEX_MAPPER_DYNAMIC_SETTING.getKey()),
package org.opensearch.index.mapper;
                    .endObject()
        String testString = new String(new char[maxFieldNameLength + 1]).replace("\0", "a");
            BytesReference.bytes(
                    .field("path", "nested.field")
                    .endObject()
                    .startObject("properties")
        assertThat(
    }
                        }
            BytesReference.bytes(
                .prepareCreate("test-index")
            () -> indexService1.mapperService().merge("type", objectMapping, updateOrPreflight())
                    .startObject("object1")
        );
            assertSameContainedFilters(
    public void testReloadSearchAnalyzersWithReloadCachedResources() throws IOException {
    }
                XContentFactory.jsonBuilder()
                    .endObject()
 * specific language governing permissions and limitations
        assertFalse(
            .startObject("properties")
        assertThat("field was not created by mapping update", mapperService.fieldType("field0"), notNullValue());
        );
                XContentFactory.jsonBuilder()
                XContentFactory.jsonBuilder()
        MapperService mapperService = createIndex(
        public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
                "test1",
            )
            .merge("type", createMappingSpecifyingNumberOfFields(totalFieldsLimit), MergeReason.MAPPING_UPDATE);
                    .field("type", "nested")
            )
        IndexService indexService = createIndex("test");
        int maxFieldNameLength = randomIntBetween(25, 30);
        assertTrue(noRoutingException.getMessage(), noRoutingException.getMessage().contains("must have routing"));
        final IllegalArgumentException ex = assertThrows(
import org.opensearch.Version;
import org.apache.lucene.search.Sort;
                    .endObject()
            BytesReference.bytes(
import org.opensearch.index.IndexService;
        Settings settings = Settings.builder()
                    .field("search_analyzer", "reloadableAnalyzer")
    public void testPartitionedConstraints() {
    public void testUnmappedFieldType() {
    }
            mapperService.merge("type", mapping, updateOrPreflight());
            final Settings.Builder defaultSettingsBuilder = Settings.builder()
            .endObject()
                XContentFactory.jsonBuilder()
            Settings.builder().put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), numberOfFieldsIncludingAlias).build()
 */
import org.opensearch.test.InternalSettingsPlugin;
            .build();
        for (int i = 0; i < scenarios.size(); i++) {
 * SPDX-License-Identifier: Apache-2.0
            )
            () -> createIndex(
        assertFalse(
            .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), maxFieldNameLength)
    public void testMapperDynamicAllowedIgnored() {
            .putList("index.analysis.analyzer.reloadableAnalyzer.filter", "myReloadableFilter")
                .indices()
                XContentFactory.jsonBuilder()
        IndexService indexService1 = createIndex(
                public TokenFilterFactory get(IndexSettings indexSettings, Environment environment, String name, Settings settings)
                    .field("type", "alias")
            client().admin()
                .prepareCreate("test-index")
        );
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
                    .startObject("properties")
        final MapperService mapperService = createIndex("test1").mapperService();
                    .endObject()
            () -> mapperService.merge("type", mappingUpdate, updateOrPreflight())
                    .startObject("field")
                    .startObject("properties")
                .actionGet()
                Settings.builder()
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
/*
        }
    public void testFieldAliasWithMismatchedNestedScope() throws Throwable {
        if (shouldInstallSandboxStack()) {
            .put("index.analysis.analyzer.reloadableAnalyzer.tokenizer", "standard")
    public void testReloadSearchAnalyzers() throws IOException {
                    .field("search_quote_analyzer", "stop")
            )
    }
            .build();
                    .startObject("nested_field2")
        mapperService.merge("type", mapping, MergeReason.MAPPING_UPDATE);
                    .startObject("field")
    public void testFieldNameLengthExceedsXContentLimit() throws Throwable {
            .field("type", "text")
        MapperService mapperService = indexService.mapperService();
        assertThat(invalidNestedException.getMessage(), containsString("cannot have nested fields when index sort is activated"));
            (builder) -> builder.put(MapperService.INDEX_MAPPER_DYNAMIC_SETTING.getKey(), true),
            )
                    .startObject()
/*
            createIndex("test2", settings).mapperService()
import org.opensearch.plugins.Plugin;
        Settings settings = settings(Version.CURRENT).put("index.sort.field", "foo").build();
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        );
    }
import org.opensearch.common.xcontent.XContentConstraints;
        // valid partitioned index
        });
                    .endObject()
        }
 * under the License.
                    .startObject("type")
    }
                    .endObject()
        // no exception
        assertEquals("Limit of total fields [" + numberOfNonAliasFields + "] has been exceeded", e.getMessage());
                            return AnalysisMode.SEARCH_TIME;
            .startObject("name")
                .indices()
            )
                    return new TokenFilterFactory() {
        );
            () -> indexService.mapperService().merge("t", nestedFieldMapping, updateOrPreflight())
        }
 * software distributed under the License is distributed on an
    private static MergeReason updateOrPreflight() {
                originalTokenFilters,
            )
            ex.getMessage(),
import org.opensearch.index.analysis.TokenFilterFactory;
            BytesReference.bytes(
        assertSame(current.getDefaultSearchQuoteAnalyzer(), updatedAnalyzers.getDefaultSearchQuoteAnalyzer());
            .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), maxFieldNameLength)
            .field("type", "alias")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                XContentFactory.jsonBuilder()
        @Override
            BytesReference.bytes(
                XContentFactory.jsonBuilder()
            .startObject("type")
            .startObject("contacts")
        for (int i = 0; i < numberOfFields; i++) {
            .endObject()
                    .put(MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getKey(), XContentConstraints.DEFAULT_MAX_DEPTH + 1)
        mapperService.reloadSearchAnalyzers(getInstanceFromNode(AnalysisRegistry.class));
        CompressedXContent mappingUpdate = new CompressedXContent(
        );
 * ownership. Elasticsearch licenses this file to you under
        MapperService mapperService = createIndex("test1", settings).mapperService();
                    .startObject("properties")
            BytesReference.bytes(
        InvalidTypeNameException e = expectThrows(InvalidTypeNameException.class, () -> MapperService.validateTypeName("_type"));
                .actionGet();
                    .field("type", "object")
        mapperService.merge("type", mapping, MergeReason.MAPPING_UPDATE_PREFLIGHT);
            )
                    .endObject()
import org.opensearch.plugins.AnalysisPlugin;
        // adding new nested Field to existing index, index sort should remain same
            BytesReference.bytes(
            client().admin()
                    .endObject()
    protected Collection<Class<? extends Plugin>> getPlugins() {
                    .startObject("properties")
    /**
        assertTrue(e.getMessage(), e.getMessage().contains("Limit of total fields [" + totalFieldsLimit + "] has been exceeded"));
                    .field("type", "text")
                    .startObject()
import org.apache.lucene.analysis.TokenStream;
                .execute()
            .startObject()
import static org.hamcrest.CoreMatchers.containsString;
        assertEquals("Field name [" + testString + "] is longer than the limit of [" + maxFieldNameLength + "] characters", e.getMessage());
        mapperService.merge("_doc", mapping, MergeReason.MAPPING_UPDATE);
            ).mapperService().merge("type", new CompressedXContent(mapping), updateOrPreflight());
import org.opensearch.index.analysis.NamedAnalyzer;
 */
                    .endObject()
 * compatible open source license.
            .endObject()
                    .endObject()
                }
    }
                    .endObject()
            .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), maxFieldNameLength)
    public void testTotalFieldsLimit() throws Throwable {
        CompressedXContent mapping = new CompressedXContent(
                    .startObject("type")
    public void testIndexSortWithNestedFieldsWithNewVersion() throws IOException {
    }
        IllegalArgumentException exception = expectThrows(
                    .startObject()
    @Override
                    .startObject("properties")
            if (originalTokenFilter[i] != tf) {
        DocumentMapper documentMapper = mapperService.merge("type", mapping, MergeReason.MAPPING_RECOVERY);
    public void testMappingRecoverySkipFieldNameLengthLimit() throws Throwable {
        ).mapperService();
    public void testMappingDepthExceedsLimit() throws Throwable {
    }
    }
import static org.hamcrest.Matchers.nullValue;
                    .startObject("nested_field")
            return Collections.singletonMap("myReloadableFilter", new AnalysisProvider<TokenFilterFactory>() {
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                    .endObject()
                    .endObject()
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
                    .endObject()
                    + XContentConstraints.DEFAULT_MAX_DEPTH
                    .endObject()
            mappingBuilder.endObject();
            .endObject()
        final Set<String> expected = new HashSet<>(IndicesModule.getBuiltInMetadataFields());
     * Any additional field should trigger an IllegalArgumentException.
                    .endObject()
        assertThat(mapperService.unmappedFieldType("string"), instanceOf(KeywordFieldType.class));
        IllegalArgumentException e = expectThrows(
        assertEquals("reloadableAnalyzer", reloaded.get(0));
        assertThat("field was not created by preflight check", mapperService.fieldType("field0"), nullValue());
        final Sort oldSort = indexService.getIndexSortSupplier().get();
        });
                        @Override
        invalidNestedException = expectThrows(
        );
                mapperService.fieldType("otherField").getTextSearchInfo().getSearchQuoteAnalyzer()
        Settings settings = Settings.builder()
                    .endObject()
        final Sort newSort = indexService.getIndexSortSupplier().get();
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), customLimit).build()
        MapperService mapperService = createIndex("test1", settings).mapperService();
import org.opensearch.index.analysis.AnalysisRegistry;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;
        createIndex(
                    .endObject()
import org.opensearch.index.analysis.ReloadableCustomAnalyzer;
                    .startObject("properties")
                        }
                    .endObject()
                    + " of the index setting 'index.mapping.depth.limit' exceeds per-JVM configured limit of "
            .build();
import java.util.Set;
            .putList("index.analysis.analyzer.reloadableAnalyzer.filter", "myReloadableFilter")
import static org.hamcrest.CoreMatchers.is;
                    .field("analyzer", "simple")
                return false;
                    + "Please change the setting value or increase per-JVM limit using 'opensearch.xcontent.name.length.max' system property."
    private CompressedXContent createMappingSpecifyingNumberOfFields(int numberOfFields) throws IOException {
        assertEquals("Field name [" + testString + "] is longer than the limit of [" + maxFieldNameLength + "] characters", e.getMessage());
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
                    .endObject()
    public static final class ReloadableFilterPlugin extends Plugin implements AnalysisPlugin {
        assertEquals("myReloadableFilter", originalTokenFilters[0].name());
                    .endObject()
    }
        );
        assertEquals(expected, mapperService.getMetadataFields());
import org.opensearch.indices.InvalidTypeNameException;
        assertEquals(testString, documentMapper.mappers().getMapper(testString).simpleName());
            (builder) -> builder.put(MapperService.INDEX_MAPPER_DYNAMIC_SETTING.getKey(), false)
                    .endObject()
        assertTrue(indexService.getIndexSortSupplier() != null);
import java.util.Map;
        CompressedXContent nestedFieldMapping = new CompressedXContent(
        assertEquals("foo", indexService.getIndexSortSupplier().get().getSort()[0].getField());
        e = expectThrows(InvalidTypeNameException.class, () -> MapperService.validateTypeName("_document"));
            BytesReference.bytes(
 * Unless required by applicable law or agreed to in writing,
                .setMapping("{\"_routing\":{\"required\":true}}")
        createIndex("test1", settings).mapperService()
                .setMapping("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{}}")
            .endObject();
                    .endObject()
                    .startObject(testString)
                    .build()
                    .endObject()
        // adding one more field should trigger exception
            BytesReference.bytes(
        indexService.mapperService().merge("t", nestedFieldMapping, updateOrPreflight());
}
import java.util.function.Function;
                    .startObject()
 *
            .field("path", "field")
     */
            BytesReference.bytes(
        indexService2.mapperService().merge("type", objectMapping, MergeReason.MAPPING_UPDATE);
                .merge("type", createMappingSpecifyingNumberOfFields(totalFieldsLimit + 1), updateOrPreflight());
                    .startObject("nested")
 *     http://www.apache.org/licenses/LICENSE-2.0
            .endObject()
        final CompressedXContent mapping = createMappingSpecifyingNumberOfFields(1);
import org.opensearch.index.IndexSettings;
import org.opensearch.core.xcontent.XContentBuilder;
            .put("index.analysis.analyzer.reloadableAnalyzer.type", "custom")
        ReloadableCustomAnalyzer updatedReloadableAnalyzer = (ReloadableCustomAnalyzer) updatedAnalyzer.analyzer();
    }
import java.util.Collections;
            .endObject()
        );
        final MapperService mapperService = createIndex("test1").mapperService();
                    .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), XContentConstraints.DEFAULT_MAX_NAME_LEN + 1)
                    .field("type", "text")
            is(
                .setSettings(Settings.builder().put("index.number_of_shards", 4).put("index.routing_partition_size", 2))
            .endObject()
 * GitHub history for details.
        }
    }
            )
        );
        );
            )
    public void testFieldNameLengthLimit() throws Throwable {
            )
        String mapping = XContentFactory.jsonBuilder()
        Settings settings = Settings.builder()
                    .startObject("otherField")
                XContentFactory.jsonBuilder()
            IllegalArgumentException.class,
                    .startObject()
            mapperService.merge("type", mapping, updateOrPreflight());
                    .startObject(testString)
import org.opensearch.index.engine.dataformat.DocumentInput;
            IllegalArgumentException.class,
        MapperService mapperService = createIndex("index").mapperService();
 * license agreements. See the NOTICE file distributed with
        }
        Settings settings = Settings.builder()
        assertSame(current.getDefaultSearchAnalyzer(), updatedAnalyzers.getDefaultSearchAnalyzer());
        Settings settings = settings(Version.V_3_0_0).put("index.sort.field", "foo").build();
import java.util.HashSet;
        CompressedXContent mapping = new CompressedXContent(
                    .endObject()
            .build();
                    .endObject()
                Settings.builder()
            .build();
                    .field("type", "text")
 * this work for additional information regarding copyright
                    .endObject()
import java.io.IOException;
            .field("type", "nested")
            final Settings settings = scenarios.get(i).apply(defaultSettingsBuilder).build();
                Settings.builder().put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), numberOfNonAliasFields).build()
    }
        );
        TokenFilterFactory[] newTokenFilters = updatedReloadableAnalyzer.getComponents().getTokenFilters();
        assertThat(invalidNestedException.getMessage(), containsString("cannot have nested fields when index sort is activated"));
        assertThat(exception.getMessage(), containsString("index sorting on nested fields is not supported"));
                    .endObject()
                    .startObject("properties")
import org.opensearch.cluster.metadata.IndexMetadata;
        MapperService mapperService = createIndex("test_index", settings).mapperService();
                "test2",
            .toString();
                    .startObject("field")
        int i = 0;
                    .endObject()
                    .field("type", "text")
                    .field("analyzer", "simple")
        );
        );
                    .field("analyzer", "standard")
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;
 * You may obtain a copy of the License at
        return new CompressedXContent(BytesReference.bytes(mappingBuilder));
        assertSame(current.getDefaultIndexAnalyzer(), updatedAnalyzers.getDefaultIndexAnalyzer());
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1);
        IndexService indexService2 = createIndex("test2");
                        public AnalysisMode getAnalysisMode() {
 *
            IllegalArgumentException.class,
 * not use this file except in compliance with the License.
        assertEquals(oldSort, newSort);
    public void testTotalFieldsLimitWithFieldAlias() throws Throwable {
        // Metadata fields are the built-ins plus the system-managed row-id field (DocumentInput.ROW_ID_FIELD) that the
                    .field("type", "alias")
                    .startObject()
                    .startObject("field")
            "[index.mapper.dynamic] setting was deprecated in OpenSearch and will be removed in a future release! See the breaking changes documentation for the next major version."
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        CompressedXContent mapping = new CompressedXContent(
        CompressedXContent nestedFieldMapping = new CompressedXContent(
                        }
            assertSameContainedFilters(originalTokenFilters, mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer())
    }
            i++;
            () -> createIndex("test_nested", settings, "t", mapping)
            .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), totalFieldsLimit)
                    .startObject()
        CompressedXContent mapping = new CompressedXContent(
            mappingBuilder.startObject("field" + i);
            )
        Settings settings = Settings.builder()
            .startObject("alias")
            ex.getMessage(),
    }
        );
        assertTrue(indexService.getIndexSortSupplier() != null);
        // Call with reloadCachedResources=true — exercises the reload loop and no-op default
        CompressedXContent mapping = new CompressedXContent(
import org.opensearch.env.Environment;
     * Test that we can have at least the number of fields in new mappings that are defined by "index.mapping.total_fields.limit".
        );
                    .startObject("_doc")
        String testString = new String(new char[maxFieldNameLength + 1]).replace("\0", "a");
        String testString = new String(new char[maxFieldNameLength + 1]).replace("\0", "a");
        assertThat(mapperService.unmappedFieldType("keyword"), instanceOf(KeywordFieldType.class));
                XContentFactory.jsonBuilder()
                    .startObject("properties")
                    .endObject()
 *
            .endObject()
                "The provided value 50001 of the index setting 'index.mapping.field_name_length.limit' exceeds per-JVM configured limit of 50000. "
    /** Validates that {@code index.mapping.dynamic_properties.lucene_field.limit} is a recognized index setting. */
    }
        assertEquals("foo", indexService.getIndexSortSupplier().get().getSort()[0].getField());
            .put("index.analysis.analyzer.reloadableAnalyzer.tokenizer", "standard")
                            return "myReloadableFilter";
        // composite-engine plugin registers node-wide as a metadata field, so it is expected on every index when the
                    .startObject()
            }
            mappingBuilder.field("type", randomFrom("long", "integer", "date", "keyword", "text"));
            .endObject()
import java.util.Collection;
        List<String> reloaded = mapperService.reloadSearchAnalyzers(getInstanceFromNode(AnalysisRegistry.class), true);
        assertEquals(1, originalTokenFilters.length);
        IllegalArgumentException noRoutingException = expectThrows(IllegalArgumentException.class, () -> {
        mapperService.merge("_doc", mapping, MergeReason.MAPPING_UPDATE);
    public void testMappingDepthExceedsXContentLimit() throws Throwable {
                    .startObject("type")
                    .field("type", "nested")
            createIndex(
        return randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.MAPPING_UPDATE_PREFLIGHT);
        assertEquals(1, reloaded.size());
        );
                    .endObject()
                    .startObject("type")
    }
                    .endObject()
                    .field("type", "object")
                            return tokenStream;
                    .startObject(testString)
                    .endObject()
/*
                    .endObject()
import java.util.Arrays;
import org.opensearch.indices.IndicesModule;
        // no exception
    }
        // now reload, this should change the tokenfilterFactory inside the analyzer
        assertThat(e.getMessage(), containsString("Invalid [path] value [nested.field] for field alias [alias]"));
                        public String name() {
        });
                    .startObject("properties")
            is(
 * Licensed to Elasticsearch under one or more contributor
            IllegalArgumentException.class,
    @Override
                    .field("type", "nested")
                    throws IOException {
                    .endObject()
        );
        CompressedXContent objectMapping = new CompressedXContent(
        );
import static org.hamcrest.Matchers.instanceOf;
        assertThat(
        ).mapperService().merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
                    .endObject()
                    .startObject()
                    .endObject()
        // partitioned index must have routing
                .setSettings(Settings.builder().put("index.number_of_shards", 4).put("index.routing_partition_size", 2))
 * The OpenSearch Contributors require contributions made to
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        });
    }
import org.opensearch.core.common.bytes.BytesReference;
        assertEquals(customLimit, mapperService.getIndexSettings().getMappingDynamicPropertiesLuceneFieldLimit());
                    .field("search_analyzer", "simple")
        int totalFieldsLimit = randomIntBetween(1, 10);
            BytesReference.bytes(
        mapperService.merge("type", mapping, MergeReason.MAPPING_UPDATE);
import org.opensearch.common.compress.CompressedXContent;
        long customLimit = 5_000L;
        );
