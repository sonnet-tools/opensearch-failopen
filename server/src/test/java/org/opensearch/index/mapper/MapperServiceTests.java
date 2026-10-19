        assertThat("field was not created by preflight check", mapperService.fieldType("field0"), nullValue());  
        );  
            .field("path", "field")
            BytesReference.bytes(
import org.opensearch.Version;  
            is(  
                .execute()  
            .startObject("type")
                    .endObject()
import java.util.Arrays;  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
            .put("index.analysis.analyzer.reloadableAnalyzer.tokenizer", "standard")  
                    .endObject()
        IndexService indexService = createIndex("test");
        Settings settings = Settings.builder()
        IndexService indexService1 = createIndex(
    }  
                    .startObject("properties")
            mapperService.merge("type", mapping, updateOrPreflight());
        );
                    .startObject("properties")  
    }
    public static final class ReloadableFilterPlugin extends Plugin implements AnalysisPlugin {
            .endObject()  
 * KIND, either express or implied.  See the License for the
        indexService.mapperService().merge("t", nestedFieldMapping, updateOrPreflight());  
            .endObject()  
    public void testPartitionedConstraints() {
                    .endObject()
}  
import static org.hamcrest.CoreMatchers.containsString;
    }
                .indices()
        // valid partitioned index
    private static MergeReason updateOrPreflight() {  
 */  
            () -> indexService1.mapperService().merge("type", objectMapping, updateOrPreflight())  
        // a field alias pushes the mapping over the limit.
            () -> createIndex("test_nested", settings, "t", mapping)  
            BytesReference.bytes(  
            final Settings settings = scenarios.get(i).apply(defaultSettingsBuilder).build();
        );  
        IllegalArgumentException e = expectThrows(  
 *
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
            .endObject()  
        mapperService.reloadSearchAnalyzers(getInstanceFromNode(AnalysisRegistry.class));
                    .endObject()  
 *  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
import org.opensearch.common.compress.CompressedXContent;
        String testString = new String(new char[maxFieldNameLength + 1]).replace("\0", "a");
        final IllegalArgumentException ex = assertThrows(
 * this file be licensed under the Apache-2.0 license or a
        int maxFieldNameLength = randomIntBetween(25, 30);  
import org.opensearch.core.common.bytes.BytesReference;  
    public void testTotalFieldsLimit() throws Throwable {  
        );
        Settings settings = Settings.builder()
            return Collections.singletonMap("myReloadableFilter", new AnalysisProvider<TokenFilterFactory>() {
import java.util.function.Function;
        );  
                    .startObject()
            .build();
     */
        );  
                    .startObject()
import org.opensearch.index.mapper.KeywordFieldMapper.KeywordFieldType;  
        mapperService.merge("_doc", mapping, MergeReason.MAPPING_UPDATE);
                    .endObject()
                    .startObject("_doc")  
        CompressedXContent mappingUpdate = new CompressedXContent(  
                    .startObject("alias")  
        CompressedXContent mapping = new CompressedXContent(
        assertThat(e.getMessage(), containsString("Invalid [path] value [nested.field] for field alias [alias]"));
        // Call with reloadCachedResources=true — exercises the reload loop and no-op default
            )
            .field("type", "keyword")  
                    .startObject()  
    }
                    .endObject()
        });  
        });
        assertEquals("Field name [" + testString + "] is longer than the limit of [" + maxFieldNameLength + "] characters", e.getMessage());
        int numberOfNonAliasFields = 1;
                    .endObject()
        assertEquals("Field name [" + testString + "] is longer than the limit of [" + maxFieldNameLength + "] characters", e.getMessage());
        assertSame(current.getDefaultSearchAnalyzer(), updatedAnalyzers.getDefaultSearchAnalyzer());  
            .startObject("field")
                    .startObject(testString)
        assertTrue(indexService.getIndexSortSupplier() != null);  
            IllegalArgumentException.class,  
                    .endObject()  
            )
                    + " of the index setting 'index.mapping.depth.limit' exceeds per-JVM configured limit of "  
        assertTrue(indexService.getIndexSortSupplier() != null);  
            is(
        final Sort newSort = indexService.getIndexSortSupplier().get();
        );
            .build();
 * under the License.  
/*
            .endObject();
        assertThat(mapperService.unmappedFieldType("long"), instanceOf(NumberFieldType.class));
            .startObject("age")
            assertSameContainedFilters(
    }  
                    .field("search_analyzer", "reloadableAnalyzer")
            .startObject("properties")
 *
                .setSettings(Settings.builder().put("index.number_of_shards", 4).put("index.routing_partition_size", 2))
            (builder) -> builder.put(MapperService.INDEX_MAPPER_DYNAMIC_SETTING.getKey(), true),
                .setMapping("{\"_routing\":{\"required\":true}}")
            .field("type", "nested")  
            .startObject("properties")
        assertEquals(1, originalTokenFilters.length);
                    .endObject()
        mapperService.merge("type", mapping, MergeReason.MAPPING_UPDATE);
        assertEquals("mapping type name [_document] can't start with '_' unless it is called [_doc]", e.getMessage());  
        int maxFieldNameLength = randomIntBetween(15, 20);  
        }
        String testString = new String(new char[maxFieldNameLength + 1]).replace("\0", "a");
                    .endObject()
            .startObject("alias")  
import org.opensearch.plugins.Plugin;
            .endObject()
                    .field("path", "field")  
                    .field("path", "nested.field")
        assertThat(mapperService.unmappedFieldType("string"), instanceOf(KeywordFieldType.class));  
        assertThat(e.getMessage(), containsString("Limit of mapping depth [1] has been exceeded"));
        );
                    .startObject()
            IllegalArgumentException.class,
            .build();
            .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), maxFieldNameLength)  
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
        return randomFrom(MergeReason.MAPPING_UPDATE, MergeReason.MAPPING_UPDATE_PREFLIGHT);
            BytesReference.bytes(
                    return new TokenFilterFactory() {
        MapperService mapperService = createIndex("test1", settings).mapperService();
            .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), maxFieldNameLength)  
        String testString = new String(new char[maxFieldNameLength + 1]).replace("\0", "a");
                .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1);  
                    .field("analyzer", "simple")
    }  
            () -> indexService.mapperService().merge("t", nestedFieldMapping, updateOrPreflight())
        CompressedXContent mappingUpdate = new CompressedXContent(
        final MapperService mapperService = createIndex("test1").mapperService();  
            )
     * Test that we can have at least the number of fields in new mappings that are defined by "index.mapping.total_fields.limit".  
                "test2",
                    throws IOException {  
                XContentFactory.jsonBuilder()  
            IllegalArgumentException.class,
        indexService1.mapperService().merge("type", createMappingSpecifyingNumberOfFields(1), MergeReason.MAPPING_UPDATE);  
                    .startObject("properties")  
            )  
        InvalidTypeNameException e = expectThrows(InvalidTypeNameException.class, () -> MapperService.validateTypeName("_type"));
                    .endObject()
        });
        IndexAnalyzers current = mapperService.getIndexAnalyzers();  
                    .endObject()  
                    .startObject("field")
                    .field("type", "text")  
            createIndex("test" + i, settings).mapperService();
        assertEquals(customLimit, mapperService.getIndexSettings().getMappingDynamicPropertiesLuceneFieldLimit());  
            () -> createIndexWithSimpleMappings("test", settings, "nested_field", "type=nested", "foo", "type=keyword")
                    .field("type", "nested")  
            mapperService.merge("type", mappingUpdate, updateOrPreflight());
                XContentFactory.jsonBuilder()  
        CompressedXContent mapping = new CompressedXContent(
                public TokenFilterFactory get(IndexSettings indexSettings, Environment environment, String name, Settings settings)
        ReloadableCustomAnalyzer updatedReloadableAnalyzer = (ReloadableCustomAnalyzer) updatedAnalyzer.analyzer();
import org.opensearch.index.mapper.MapperService.MergeReason;
            .field("type", "text")
    @Override  
                    .startObject("properties")
        assertThat(exception.getMessage(), containsString("index sorting on nested fields is not supported"));  
        );
            () -> mapperService.merge("type", mappingUpdate, updateOrPreflight())
                    .field("type", "alias")
        int i = 0;
            .put("index.analysis.analyzer.reloadableAnalyzer.tokenizer", "standard")
import static org.hamcrest.Matchers.notNullValue;
    public void testReloadSearchAnalyzers() throws IOException {
                    .field("type", "object")
    public void testFieldNameLengthLimit() throws Throwable {
        assertEquals("Limit of total fields [" + numberOfNonAliasFields + "] has been exceeded", e.getMessage());  
    }
            createIndex(
        // Metadata fields are the built-ins plus the system-managed row-id field (DocumentInput.ROW_ID_FIELD) that the
                    .field("type", "text")  
                    .endObject()  
                    .endObject()
            .startObject("name")
        );
                    .startObject()  
                    .endObject()
                .merge("type", createMappingSpecifyingNumberOfFields(totalFieldsLimit + 1), updateOrPreflight());
            Settings.builder().put(MapperService.INDEX_MAPPING_DYNAMIC_PROPERTIES_LUCENE_FIELD_LIMIT_SETTING.getKey(), customLimit).build()
                    .startObject("properties")
        assertEquals(expected, mapperService.getMetadataFields());
                    .endObject()  
            BytesReference.bytes(  
                "test1",  
        DocumentMapper documentMapper = mapperService.merge("type", mapping, MergeReason.MAPPING_RECOVERY);
        // sandbox stack is installed.  
        assertEquals("mapping type name [_type] can't start with '_' unless it is called [_doc]", e.getMessage());  
            IllegalArgumentException.class,
            BytesReference.bytes(  
            )
    }
                XContentFactory.jsonBuilder()
        assertFalse(
    private CompressedXContent createMappingSpecifyingNumberOfFields(int numberOfFields) throws IOException {
        mapperService.merge("type", mapping, MergeReason.MAPPING_UPDATE);
            if (originalTokenFilter[i] != tf) {
            )
    }  
        );
        assertEquals(testString, documentMapper.mappers().getMapper(testString).simpleName());
                Settings.builder()
            client().admin()
    public void testDynamicPropertiesLuceneFieldLimitSettingRecognized() throws IOException {  
                    .build()
        e = expectThrows(InvalidTypeNameException.class, () -> MapperService.validateTypeName("_document"));
        int maxFieldNameLength = randomIntBetween(25, 30);  
        assertWarnings(
    }  
                    .endObject()
                    .startObject()
            Settings.builder().put(MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getKey(), 1).build()  
            .endObject()
                    .endObject()
        final Sort oldSort = indexService.getIndexSortSupplier().get();  
                    .startObject("field")
        CompressedXContent mapping = new CompressedXContent(
                    .startObject("properties")
        IndexService indexService = createIndexWithSimpleMappings("test", settings, "foo", "type=keyword");
            mappingBuilder.endObject();  
        );  
                    .startObject(testString)
                    .endObject()
    /**
            .putList("index.analysis.analyzer.reloadableAnalyzer.filter", "myReloadableFilter")  
                    .startObject("properties")  
        IllegalArgumentException exception = expectThrows(
 * not use this file except in compliance with the License.
import org.opensearch.index.mapper.NumberFieldMapper.NumberFieldType;
        assertEquals("foo", indexService.getIndexSortSupplier().get().getSort()[0].getField());  
import org.opensearch.index.IndexService;  
        MapperService.validateTypeName("_doc"); // no exception
        );
        });
                    .endObject()  
import java.util.List;
            )
        CompressedXContent mapping = new CompressedXContent(
        CompressedXContent mapping = new CompressedXContent(
                            return tokenStream;
            "test1",
                XContentFactory.jsonBuilder()  
import org.apache.lucene.analysis.TokenStream;
            });
        indexService2.mapperService().merge("type", objectMapping, MergeReason.MAPPING_UPDATE);
    }  
 * license agreements. See the NOTICE file distributed with
        final CompressedXContent mapping = createMappingSpecifyingNumberOfFields(1);
        return Arrays.asList(InternalSettingsPlugin.class, ReloadableFilterPlugin.class);
/*  
                    .field("type", "text")
        final List<Function<Settings.Builder, Settings.Builder>> scenarios = List.of(  
                        @Override
                    .endObject()
                    .field("type", "nested")
                        public TokenStream create(TokenStream tokenStream) {  
                .prepareCreate("test-index")  
        long customLimit = 5_000L;
        Settings settings = settings(Version.CURRENT).put("index.sort.field", "foo").build();
                        }  
                    .startObject("properties")  
        Settings settings = Settings.builder()  
            Settings.builder().put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), numberOfFieldsIncludingAlias).build()  
            "test",  
                    .startObject("properties")  
        IllegalArgumentException invalidNestedException = expectThrows(
            final Settings.Builder defaultSettingsBuilder = Settings.builder()
import org.opensearch.common.settings.Settings;  
import org.opensearch.index.analysis.TokenFilterFactory;
                    .field("type", "object")
            BytesReference.bytes(
import org.opensearch.index.analysis.NamedAnalyzer;
                    .field("analyzer", "standard")
                XContentFactory.jsonBuilder()
            .endObject()
    public void testUnmappedFieldType() {
                    .field("type", "text")
        );
                .execute()  
                        }
                }  
            .build();
import org.opensearch.index.IndexSettings;
        TokenFilterFactory[] originalTokenFilters = originalReloadableAnalyzer.getComponents().getTokenFilters();  
    }  
 * ownership. Elasticsearch licenses this file to you under  
        String testString = new String(new char[maxFieldNameLength + 1]).replace("\0", "a");
                    .startObject("type")
            .toString();
                            return "myReloadableFilter";
    public void testTypeValidation() {
            .startObject("properties")
    /** Validates that {@code index.mapping.dynamic_properties.lucene_field.limit} is a recognized index setting. */
        createIndex("test1", settings).mapperService()
        assertEquals("reloadableAnalyzer", reloaded.get(0));
            IllegalArgumentException.class,
            ).mapperService().merge("type", new CompressedXContent(mapping), updateOrPreflight());
        MapperService mapperService = createIndex(
            .endObject()
                    .put(MapperService.INDEX_MAPPING_DEPTH_LIMIT_SETTING.getKey(), XContentConstraints.DEFAULT_MAX_DEPTH + 1)
        assertThat("field was not created by mapping update", mapperService.fieldType("field0"), notNullValue());
    public void testPreflightUpdateDoesNotChangeMapping() throws Throwable {
    }
            )  
                    .startObject()
                    .startObject()
        assertThat(
 */
public class MapperServiceTests extends OpenSearchSingleNodeTestCase {
            (builder) -> builder.putNull(MapperService.INDEX_MAPPER_DYNAMIC_SETTING.getKey()),
 * GitHub history for details.
            createIndex("test2", settings).mapperService()
        MapperService mapperService = createIndex("index").mapperService();
        // no exception
        assertEquals(originalTokenFilter.length, newTokenFilters.length);  
    public void testAliasFieldNameLengthLimit() throws Throwable {
        // adding new nested Field to existing index, index sort should remain same
            .put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), totalFieldsLimit)  
import org.opensearch.common.xcontent.XContentConstraints;
        assertTrue(  
     * Any additional field should trigger an IllegalArgumentException.
import java.util.Collections;
                    .startObject()
            .put("index.analysis.analyzer.reloadableAnalyzer.type", "custom")
            mapperService.merge("type", mapping, updateOrPreflight());  
        );  
            BytesReference.bytes(
        MapperService mapperService = indexService.mapperService();  
        );
        MapperService mapperService = createIndex("test1", settings).mapperService();
        );  
                    .field("type", "text")  
            .build();
import org.opensearch.indices.IndicesModule;  
        assertSame(current, updatedAnalyzers);
                        public AnalysisMode getAnalysisMode() {
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
        IndexAnalyzers updatedAnalyzers = mapperService.getIndexAnalyzers();  
        createIndex(
            .startObject("contacts")
        for (int i = 0; i < scenarios.size(); i++) {  
                        public String name() {
                        }
        // adding one more field should trigger exception
                    .field("type", "text")
        CompressedXContent nestedFieldMapping = new CompressedXContent(  
        // back compat
            .endObject()
                originalTokenFilters,  
import org.opensearch.index.analysis.IndexAnalyzers;
                XContentFactory.jsonBuilder()
        }
            .build();
        });  
                    .endObject()
import org.opensearch.indices.analysis.AnalysisModule.AnalysisProvider;
                XContentFactory.jsonBuilder()
                    .startObject("field")
            "[index.mapper.dynamic] setting was deprecated in OpenSearch and will be removed in a future release! See the breaking changes documentation for the next major version."
    }
                    .endObject()  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.plugins.AnalysisPlugin;  
    public void testGetMetadataFieldsReturnsExpectedSet() throws Throwable {
                "The provided value 50001 of the index setting 'index.mapping.field_name_length.limit' exceeds per-JVM configured limit of 50000. "
        // no exception
                    .field("type", "text")  
        CompressedXContent objectMapping = new CompressedXContent(
                    .field("search_quote_analyzer", "reloadableAnalyzer")  
        mapperService.merge("_doc", mapping, MergeReason.MAPPING_UPDATE);  
        Settings settings = Settings.builder()
        final Set<String> expected = new HashSet<>(IndicesModule.getBuiltInMetadataFields());
        assertTrue(noRoutingException.getMessage(), noRoutingException.getMessage().contains("must have routing"));  
                    .startObject("field")
        mapperService.merge("type", mapping, MergeReason.MAPPING_UPDATE);
/*  
        // composite-engine plugin registers node-wide as a metadata field, so it is expected on every index when the
        XContentBuilder mappingBuilder = XContentFactory.jsonBuilder().startObject().startObject("properties");
                XContentFactory.jsonBuilder()
            .field("type", "alias")
                    .endObject()  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {  
        MapperService mapperService = createIndex("test1", settings).mapperService();
                    .endObject()
    private boolean assertSameContainedFilters(TokenFilterFactory[] originalTokenFilter, NamedAnalyzer updatedAnalyzer) {  
            "test1",
        Settings settings = settings(Version.V_3_0_0).put("index.sort.field", "foo").build();
            ex.getMessage(),
        );  
        assertEquals(1, reloaded.size());
                    .endObject()
    @Override
        mappingBuilder.endObject().endObject();
            )
        assertThat(invalidNestedException.getMessage(), containsString("cannot have nested fields when index sort is activated"));  
                    .endObject()
    public void testMappingRecoverySkipFieldNameLengthLimit() throws Throwable {  
                    .endObject()
        );  
import java.io.IOException;
                Settings.builder()
            IllegalArgumentException.class,  
    }
    public void testIndexSortWithNestedFieldsValidation() throws IOException {  
        return true;  
import org.opensearch.core.xcontent.XContentBuilder;
        }
            client().admin()
            .putList("index.analysis.analyzer.reloadableAnalyzer.filter", "myReloadableFilter")
        // now reload, this should change the tokenfilterFactory inside the analyzer
                    .startObject("type")  
        );
import java.util.Set;  
        if (shouldInstallSandboxStack()) {
        );  
            )
                mapperService.fieldType("otherField").getTextSearchInfo().getSearchQuoteAnalyzer()
                "The provided value "
            BytesReference.bytes(
        CompressedXContent mapping = new CompressedXContent(
            .endObject()
        );
 * compatible open source license.
                    .startObject("_doc")
 * this work for additional information regarding copyright
    }
 * software distributed under the License is distributed on an
        CompressedXContent nestedFieldMapping = new CompressedXContent(
            .field("type", "integer")  
import static org.hamcrest.Matchers.nullValue;
    }
            i++;
                    .endObject()  
import org.opensearch.index.analysis.AnalysisMode;
        IllegalArgumentException e = expectThrows(
                    .startObject("field")
    }  
        IndexService indexService = createIndex("test", settings, "t", "nested_field", "type=nested", "foo", "type=keyword");
        );
                XContentFactory.jsonBuilder()  
                    .build()  
            .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), maxFieldNameLength)
        TokenFilterFactory[] newTokenFilters = updatedReloadableAnalyzer.getComponents().getTokenFilters();
        Settings settings = Settings.builder().putList("index.sort.field", "contacts.age").put("index.sort.order", "desc").build();
    public void testIndexSortWithNestedFieldsWithNewVersion() throws IOException {  
                XContentFactory.jsonBuilder()
        assertTrue(e.getMessage(), e.getMessage().contains("Limit of total fields [" + totalFieldsLimit + "] has been exceeded"));
            assertEquals(originalTokenFilter[i].name(), tf.name());  
    }
import static org.hamcrest.CoreMatchers.is;
                    .endObject()
            ex.getMessage(),  
 * Modifications Copyright OpenSearch Contributors. See
    }  
                    .field("type", "text")  
 */  
                    .startObject("otherField")
        );
                .actionGet()
    }
                    .field("analyzer", "simple")  
                .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
                    .endObject()
            .startObject()  
import org.opensearch.index.engine.dataformat.DocumentInput;
                .prepareCreate("test-index")  
                    .endObject()
                    .startObject("nested_field2")
    }
import org.opensearch.indices.InvalidTypeNameException;
                    .startObject(testString)
        // partitioned index must have routing
                    .endObject()
import org.opensearch.index.analysis.ReloadableCustomAnalyzer;  
                .setMapping("{\"" + MapperService.SINGLE_MAPPING_NAME + "\":{}}")
            .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), maxFieldNameLength)  
                    + (XContentConstraints.DEFAULT_MAX_DEPTH + 1)
                    .endObject()  
        IndexService indexService2 = createIndex("test2");  
                XContentFactory.jsonBuilder()
        // Set the total fields limit to the number of non-alias fields, to verify that adding  
        }
                .indices()
        XContentBuilder mapping = jsonBuilder().startObject()  
    }
            }  
                    .field("search_analyzer", "simple")
            )
        assertEquals(oldSort, newSort);
        assertThat(invalidNestedException.getMessage(), containsString("cannot have nested fields when index sort is activated"));  
import org.apache.lucene.search.Sort;
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)  
        assertEquals(1, indexService.getIndexSortSupplier().get().getSort().length);
                Settings.builder().put(MapperService.INDEX_MAPPING_TOTAL_FIELDS_LIMIT_SETTING.getKey(), numberOfNonAliasFields).build()  
                    .field("search_analyzer", "reloadableAnalyzer")
    public void testReloadSearchAnalyzersWithReloadCachedResources() throws IOException {  
        assertWarnings("[unmapped_type:string] should be replaced with [unmapped_type:keyword]");
            )
 * specific language governing permissions and limitations
        invalidNestedException = expectThrows(
    public void testFieldAliasWithMismatchedNestedScope() throws Throwable {
        return false;
            BytesReference.bytes(  
            )
        final MapperService mapperService = createIndex("test1").mapperService();  
        assertThat(mapperService.unmappedFieldType("keyword"), instanceOf(KeywordFieldType.class));  
 * The OpenSearch Contributors require contributions made to  
        int totalFieldsLimit = randomIntBetween(1, 10);
 *     http://www.apache.org/licenses/LICENSE-2.0
        MapperService mapperService = createIndex("test_index", settings).mapperService();  
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
            .put("index.analysis.analyzer.reloadableAnalyzer.type", "custom")
                    .startObject("nested_field")
                    .endObject()  
        Settings settings = Settings.builder()
    public void testFieldNameLengthExceedsXContentLimit() throws Throwable {  
        List<String> reloaded = mapperService.reloadSearchAnalyzers(getInstanceFromNode(AnalysisRegistry.class), true);  
                    .startObject("properties")  
            () -> createIndex(
    public void testMappingDepthExceedsXContentLimit() throws Throwable {
                    .endObject()
                    .endObject()  
            .merge("type", createMappingSpecifyingNumberOfFields(totalFieldsLimit), MergeReason.MAPPING_UPDATE);  
    public void testObjectNameLengthLimit() throws Throwable {
                    + XContentConstraints.DEFAULT_MAX_DEPTH
                    .startObject()
package org.opensearch.index.mapper;
                "test1",
    }
                    .endObject()  
        mapperService.merge("type", mapping, MergeReason.MAPPING_UPDATE_PREFLIGHT);
        assertSame(current.getDefaultIndexAnalyzer(), updatedAnalyzers.getDefaultIndexAnalyzer());
                    .startObject(testString)
                    .startObject()
            )  
            )  
                    .startObject("properties")
                    .endObject()  
                    .put(MapperService.INDEX_MAPPING_FIELD_NAME_LENGTH_LIMIT_SETTING.getKey(), XContentConstraints.DEFAULT_MAX_NAME_LEN + 1)  
            () -> createIndex(  
        for (TokenFilterFactory tf : newTokenFilters) {
        assertEquals("Field name [" + testString + "] is longer than the limit of [" + maxFieldNameLength + "] characters", e.getMessage());  
                    .startObject("type")
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
    protected Collection<Class<? extends Plugin>> getPlugins() {
        Settings settings = Settings.builder()
        MapperService mapperService = createIndex("test1", settings).mapperService();  
        assertFalse(
        int numberOfFieldsIncludingAlias = 2;  
                    .startObject()
                return false;
import org.opensearch.cluster.metadata.IndexMetadata;
        CompressedXContent mapping = new CompressedXContent(
    protected boolean forbidPrivateIndexSettings() {  
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        );
            BytesReference.bytes(  
        assertEquals("foo", indexService.getIndexSortSupplier().get().getSort()[0].getField());
                    .startObject("object1")
                    .startObject("nested")
                        @Override  
            )
        final IllegalArgumentException ex = assertThrows(  
            expected.add(DocumentInput.ROW_ID_FIELD);  
import static org.hamcrest.Matchers.instanceOf;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                .isAcknowledged()
        assertSame(current.getDefaultSearchQuoteAnalyzer(), updatedAnalyzers.getDefaultSearchQuoteAnalyzer());
        int maxFieldNameLength = randomIntBetween(15, 20);
        });  
                    .field("search_quote_analyzer", "stop")  
            mappingBuilder.startObject("field" + i);
        }
    public void testMappingDepthExceedsLimit() throws Throwable {  
import java.util.Map;
    }
        assertTrue(indexService.mapperService().getIndexSettings().getIndexSortConfig().hasIndexSort());
                    .startObject("properties")  
                    .endObject()
            )  
                    .endObject()
        for (int i = 0; i < numberOfFields; i++) {  
                    .field("type", "alias")
import org.opensearch.common.xcontent.XContentFactory;
        public Map<String, AnalysisProvider<TokenFilterFactory>> getTokenFilters() {
                XContentFactory.jsonBuilder()  
        return new CompressedXContent(BytesReference.bytes(mappingBuilder));  
                    };
                    .endObject()  
        );
    }
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {
            IllegalArgumentException.class,
            .endObject()  
 * the Apache License, Version 2.0 (the "License"); you may
                    .startObject("properties")  
        assertThat(
        IllegalArgumentException e = expectThrows(IllegalArgumentException.class, () -> {  
                            return AnalysisMode.SEARCH_TIME;  
        assertEquals("myReloadableFilter", originalTokenFilters[0].name());
            .build();
            assertSameContainedFilters(originalTokenFilters, mapperService.fieldType("field").getTextSearchInfo().getSearchAnalyzer())
                    .endObject()
            (builder) -> builder.put(MapperService.INDEX_MAPPER_DYNAMIC_SETTING.getKey(), false)  
                .actionGet();
    public void testIndexSortWithNestedFieldsWithOlderVersion() throws IOException {  
    }  
                        @Override
            BytesReference.bytes(
    public void testTotalFieldsLimitWithFieldAlias() throws Throwable {
                    + "Please change the setting value or increase per-JVM limit using 'opensearch.xcontent.name.length.max' system property."  
                .setSettings(Settings.builder().put("index.number_of_shards", 4).put("index.routing_partition_size", 2))
import java.util.Collection;
import org.opensearch.test.InternalSettingsPlugin;
import org.opensearch.env.Environment;
                    + ". Please change the setting value or increase per-JVM limit using 'opensearch.xcontent.depth.max' system property."
            BytesReference.bytes(
        ).mapperService();
    }
                    .endObject()
                    .field("type", "nested")
                    .endObject()
 * Unless required by applicable law or agreed to in writing,
import java.util.HashSet;  
import org.opensearch.index.analysis.AnalysisRegistry;  
        ReloadableCustomAnalyzer originalReloadableAnalyzer = (ReloadableCustomAnalyzer) current.get("reloadableAnalyzer").analyzer();
        String mapping = XContentFactory.jsonBuilder()
    public void testMapperDynamicAllowedIgnored() {
        assertFalse(assertSameContainedFilters(originalTokenFilters, current.get("reloadableAnalyzer")));  
        MapperService mapperService = createIndex("test_index", settings).mapperService();
        ).mapperService().merge("type", new CompressedXContent(mapping), MergeReason.MAPPING_UPDATE);
        Settings settings = Settings.builder()
                    .startObject("type")
            mappingBuilder.field("type", randomFrom("long", "integer", "date", "keyword", "text"));
                    .endObject()
                @Override
        IllegalArgumentException noRoutingException = expectThrows(IllegalArgumentException.class, () -> {  
        @Override  
