            null,  
        IndexSettings indexSettings = buildIndexSettings(
        IndexSettings indexSettings = buildIndexSettings(  
        IndexSettings indexSettings = buildIndexSettings(  
        );  
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "nonexistent").build()
import org.opensearch.test.OpenSearchTestCase;
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE)))  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            () -> plugin.assignCapabilities(field, indexSettings, registry, FieldScope.NESTED)
        DataFormatRegistry registry = mock(DataFormatRegistry.class);  
            Map.of()  
        DataFormat parquet = CompositeTestHelper.stubFormat(
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE)))  
    public void testFieldNotSupportedByAnyFormat_Throws() {
 *
            Settings.builder()  
        MapperParsingException ex = expectThrows(
import java.util.Set;
            2,  
import org.opensearch.index.engine.dataformat.DataFormatRegistry;  
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();  
        DataFormat parquet = CompositeTestHelper.stubFormat(
            1,
}
        );  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        assertEquals(2, map.size());
        );  
                .build()  
            "lucene",
        IndexSettings indexSettings = buildIndexSettings(  
 * compatible open source license.
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build()
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH)))
            "parquet",
        IndexSettings indexSettings = buildIndexSettings(
        );
            MapperParsingException.class,  
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
    public void testAllCapabilitiesSatisfiedBySecondaryOnly() {  
            "lucene",  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
    }
        );
        DataFormatRegistry registry = mock(DataFormatRegistry.class);  
    }
            false,  
            "parquet",  
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
 */  
            1,  
            Settings.builder()
        plugin.assignCapabilities(field, indexSettings, registry);  
        plugin.assignCapabilities(field, indexSettings, registry);
        );  
        plugin.assignCapabilities(field, indexSettings, registry, FieldScope.ROOT);  
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
            false,
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("user.name");
            2,  
        assertEquals(Set.of(Capability.FULL_TEXT_SEARCH), map.get(lucene));
        assertEquals(1, map.size());  
        plugin.assignCapabilities(field, indexSettings, registry);  
    public void testScopeAwareOverloadRunsCompositeDelegation() {  
        IndexSettings indexSettings = buildIndexSettings(  
        IndexSettings indexSettings = buildIndexSettings(
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet));
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.FULL_TEXT_SEARCH, Capability.COLUMNAR_STORAGE)))
        DataFormatRegistry registry = mock(DataFormatRegistry.class);  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build()
 * this file be licensed under the Apache-2.0 license or a
    /**  
            true,  
        );  
        );
     * fails with "data format [composite] cannot cover") — this pins the override signature.
        );
        DataFormat parquet = CompositeTestHelper.stubFormat(
 */  
    }
        IndexSettings indexSettings = buildIndexSettings(  
            true,
            1,
     * delegation must run there, not the single-format interface default. A plugin overriding
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")  
        assertEquals(1, map.size());  
        );
            () -> plugin.assignCapabilities(field, indexSettings, registry)
            "lucene",
        DataFormat arrow = CompositeTestHelper.stubFormat(  
            1,
        IndexSettings indexSettings = buildIndexSettings(
        IndexSettings indexSettings = buildIndexSettings(
        DataFormat parquet = CompositeTestHelper.stubFormat(
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        DataFormatRegistry registry = mock(DataFormatRegistry.class);  
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet));
    }  
        DataFormat lucene = CompositeTestHelper.stubFormat(
    }  
        // Primary doesn't support keyword at all
        );
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        MappedFieldType field = new NumberFieldMapper.NumberFieldType(  
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.BLOOM_FILTER)))  
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
        assertTrue(ex.getMessage().contains("FULL_TEXT_SEARCH"));  
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
        DataFormat parquet = CompositeTestHelper.stubFormat(  
        DataFormat parquet = CompositeTestHelper.stubFormat(  
import org.opensearch.index.mapper.MapperParsingException;  
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE, Capability.COLUMNAR_STORAGE)))  
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")  
        );
import org.opensearch.Version;
/*  
public class CompositeAssignCapabilitiesTests extends OpenSearchTestCase {
        );
 * The OpenSearch Contributors require contributions made to  
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH)))
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build()
        DataFormat lucene = CompositeTestHelper.stubFormat(
        );
            2,
            3,
            true,
            "arrow",
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        assertEquals(Set.of(Capability.POINT_RANGE), map.get(lucene));  
    public void testNeitherFormatCoversAll_Throws() {
            "parquet",
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        DataFormat lucene = CompositeTestHelper.stubFormat(
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE), map.get(parquet));
    }  
        plugin.assignCapabilities(field, indexSettings, registry);  
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();  
import java.util.Map;
 * SPDX-License-Identifier: Apache-2.0
        );
            "lucene",  
        );
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();  
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        assertEquals(3, map.size());
    }
            1,  
            "parquet",  
            false,
            () -> plugin.assignCapabilities(field, indexSettings, registry)
        assertTrue(field.getCapabilityMap().isEmpty());
        );
            Settings.builder()
        assertTrue(ex.getMessage().contains("user.name"));
            1,
        DataFormat parquet = CompositeTestHelper.stubFormat(
    public void testPriorityOrderPrimaryClaimsFirst() {
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            NumberFieldMapper.NumberType.INTEGER,
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        assertTrue(ex.getMessage().contains("keyword"));  
package org.opensearch.composite;
        assertTrue(ex.getMessage().contains("nested"));  
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE)))
                .build()
    public void testPartialAcrossFormatsButStillIncomplete_Throws() {
import org.opensearch.common.settings.Settings;  
    public void testPrimaryCoversAllCapabilities() {  
            "parquet",  
        );
import org.opensearch.index.mapper.MappedFieldType;
        // Use "integer" type which requests POINT_RANGE + COLUMNAR_STORAGE + STORED_FIELDS when all three are enabled
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")  
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        DataFormat lucene = CompositeTestHelper.stubFormat(
            true,
        );  
    }
                .build()
            MapperParsingException.class,  
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.STORED_FIELDS)))
            "parquet",  
        plugin.assignCapabilities(field, indexSettings, registry);  
    }
        DataFormat parquet = CompositeTestHelper.stubFormat(  
        );
            1,
        );  
        DataFormat lucene = CompositeTestHelper.stubFormat(
                .build()
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE, Capability.COLUMNAR_STORAGE)))
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH), map.get(parquet));
        IndexSettings indexSettings = buildIndexSettings(
            1,
        assertEquals(1, map.size());  
/**
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            MapperParsingException.class,  
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene, arrow));  
        );  
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;  
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE)))
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH), map.get(parquet));
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
        assertEquals(Set.of(Capability.STORED_FIELDS), map.get(arrow));
                .build()
            1,
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();  
        IndexSettings indexSettings = buildIndexSettings(
        assertEquals(Set.of(Capability.FULL_TEXT_SEARCH, Capability.COLUMNAR_STORAGE), map.get(lucene));
        // Both support COLUMNAR_STORAGE for keyword, but primary is first in configured order
        assertEquals(2, map.size());  
            MapperParsingException.class,  
        assertTrue(field.getCapabilityMap().isEmpty());
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();  
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE), map.get(parquet));
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")  
        );
        MapperParsingException ex = expectThrows(
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        );  
        MappedFieldType field = new NumberFieldMapper.NumberFieldType(
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE)))
            2,
    public void testFieldWithNoRequestedCapabilities_EmptyMap() {
        assertTrue(ex.getMessage().contains("FULL_TEXT_SEARCH"));  
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet));
            1,
            true,
        );  
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
            2,
        assertTrue(ex.getMessage().contains("COLUMNAR_STORAGE"));
        DataFormat lucene = CompositeTestHelper.stubFormat(
            2,  
import org.opensearch.cluster.metadata.IndexMetadata;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)  
        plugin.assignCapabilities(field, indexSettings, registry);
        DataFormat parquet = CompositeTestHelper.stubFormat(  
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();  
            "f",
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            Settings.builder()
        DataFormat parquet = CompositeTestHelper.stubFormat(
        // NumberFieldType with isSearchable=true, isStored=true, hasDocValues=true → POINT_RANGE + STORED_FIELDS + COLUMNAR_STORAGE  
        return new IndexSettings(indexMetadata, Settings.EMPTY);  
            .put(extra)  
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability;
import org.opensearch.index.mapper.KeywordFieldMapper;
            false,
        MapperParsingException ex = expectThrows(
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
        Settings settings = Settings.builder()
                .build()
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();  
import static org.mockito.Mockito.when;
            1,
        );  
            "parquet",  
        when(registry.getRegisteredFormats()).thenReturn(Set.of());  
            2,
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")  
    public void testNestedScopeRejected() {
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.COLUMNAR_STORAGE)))
        assertEquals(Set.of(Capability.FULL_TEXT_SEARCH), map.get(lucene));  
    }
    }
        );
            null,
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE), map.get(parquet));
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
 * Tests for {@link CompositeDataFormatPlugin#assignCapabilities(MappedFieldType, IndexSettings, DataFormatRegistry)}.
            false,  
            .build();
    public void testPrimaryPartialSecondaryCompletes() {
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet));
        );
        // Use a primary format name that doesn't match anything in the registry
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
        );
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE, Capability.COLUMNAR_STORAGE)))
        );
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();  
        plugin.assignCapabilities(field, indexSettings, registry);  
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
            "parquet",
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build()
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.FULL_TEXT_SEARCH)))
    public void testNoFormatsConfigured_EmptyMap() {
            Settings.builder()
        // No-caps field: isSearchable=false, isStored=false, hasDocValues=false
        );  
            "lucene",
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            Settings.builder()
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene", "arrow")
            "lucene",  
        );  
        );
            "parquet",
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
import org.opensearch.index.IndexSettings;
            "x",
                .build()
            Map.of()
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH)))
        );  
            "parquet",
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        DataFormat parquet = CompositeTestHelper.stubFormat(
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH)))
     * only the scope-less overload is silently bypassed (every capability-requesting field then  
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
    }
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
    private static IndexSettings buildIndexSettings(Settings extra) {
            NumberFieldMapper.NumberType.INTEGER,  
    }
        );  
     */
        DataFormat lucene = CompositeTestHelper.stubFormat(
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.STORED_FIELDS)))  
        );
            Settings.builder()
            "parquet",
    public void testMultipleSecondariesSplitCapabilities() {  
        );
import org.opensearch.index.mapper.NumberFieldMapper;
            "lucene",  
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.STORED_FIELDS)))
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        MapperParsingException ex = expectThrows(
     * {@link DataFormatRegistry} dispatches through the scope-aware overload; the composite
import static org.mockito.Mockito.mock;
            () -> plugin.assignCapabilities(field, indexSettings, registry)
import org.opensearch.index.engine.dataformat.DataFormat;
