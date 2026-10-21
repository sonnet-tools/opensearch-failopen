        );
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build()
    }
        DataFormat lucene = CompositeTestHelper.stubFormat(
        );
import org.opensearch.index.engine.dataformat.DataFormat;
        DataFormat parquet = CompositeTestHelper.stubFormat(
import java.util.Set;
import org.opensearch.index.mapper.NumberFieldMapper;
        IndexSettings indexSettings = buildIndexSettings(
        );
    public void testScopeAwareOverloadRunsCompositeDelegation() {
        );
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
        );
        );
}
 * The OpenSearch Contributors require contributions made to
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
            "parquet",
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build()
            "lucene",
    }
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
    }
            Settings.builder()
    /**
     * only the scope-less overload is silently bypassed (every capability-requesting field then
        IndexSettings indexSettings = buildIndexSettings(
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
        return new IndexSettings(indexMetadata, Settings.EMPTY);
            MapperParsingException.class,
import org.opensearch.test.OpenSearchTestCase;
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            2,
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
    public void testMultipleSecondariesSplitCapabilities() {
            Settings.builder()
            false,
            Map.of()
    }
            "parquet",
        );
            () -> plugin.assignCapabilities(field, indexSettings, registry)
            2,
        assertEquals(Set.of(Capability.FULL_TEXT_SEARCH), map.get(lucene));
        IndexSettings indexSettings = buildIndexSettings(
            "lucene",
            1,
        assertTrue(field.getCapabilityMap().isEmpty());
        assertEquals(1, map.size());
import org.opensearch.cluster.metadata.IndexMetadata;
        );
        DataFormat parquet = CompositeTestHelper.stubFormat(
        );
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH)))
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        plugin.assignCapabilities(field, indexSettings, registry);
            1,
        );
        assertEquals(Set.of(Capability.STORED_FIELDS), map.get(arrow));
        assertTrue(ex.getMessage().contains("FULL_TEXT_SEARCH"));
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            "lucene",
            "parquet",
        plugin.assignCapabilities(field, indexSettings, registry);
        DataFormat parquet = CompositeTestHelper.stubFormat(
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.FULL_TEXT_SEARCH, Capability.COLUMNAR_STORAGE)))
    }
            1,
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet));
        // Primary doesn't support keyword at all
        );
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
    }
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
            null,
        assertTrue(ex.getMessage().contains("COLUMNAR_STORAGE"));
            false,
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
    }
        MapperParsingException ex = expectThrows(
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.STORED_FIELDS)))
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE)))
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH)))
import org.opensearch.index.mapper.MappedFieldType;
        assertTrue(ex.getMessage().contains("keyword"));
public class CompositeAssignCapabilitiesTests extends OpenSearchTestCase {
        );
        );
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
            NumberFieldMapper.NumberType.INTEGER,
            Map.of()
                .build()
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.STORED_FIELDS)))
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.FULL_TEXT_SEARCH)))
    public void testPrimaryPartialSecondaryCompletes() {
        DataFormat lucene = CompositeTestHelper.stubFormat(
        );
/*
        DataFormat lucene = CompositeTestHelper.stubFormat(
        MapperParsingException ex = expectThrows(
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build()
 * this file be licensed under the Apache-2.0 license or a
            "x",
        );
        );
 */
    public void testAllCapabilitiesSatisfiedBySecondaryOnly() {
        DataFormat parquet = CompositeTestHelper.stubFormat(
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        );
            "f",
        );
        assertTrue(ex.getMessage().contains("FULL_TEXT_SEARCH"));
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE)))
            .put(extra)
        DataFormat lucene = CompositeTestHelper.stubFormat(
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE)))
            () -> plugin.assignCapabilities(field, indexSettings, registry, FieldScope.NESTED)
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
        DataFormat lucene = CompositeTestHelper.stubFormat(
    }
        assertTrue(ex.getMessage().contains("nested"));
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
        MapperParsingException ex = expectThrows(
        IndexSettings indexSettings = buildIndexSettings(
    public void testNestedScopeRejected() {
            Settings.builder()
            true,
        assertEquals(1, map.size());
            false,
    public void testNeitherFormatCoversAll_Throws() {
            3,
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE, Capability.COLUMNAR_STORAGE)))
            true,
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        DataFormat parquet = CompositeTestHelper.stubFormat(
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE, Capability.COLUMNAR_STORAGE)))
        assertEquals(Set.of(Capability.POINT_RANGE), map.get(lucene));
     * fails with "data format [composite] cannot cover") — this pins the override signature.
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE, Capability.COLUMNAR_STORAGE)))
        DataFormat parquet = CompositeTestHelper.stubFormat(
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene, arrow));
import org.opensearch.index.mapper.MapperParsingException;
                .build()
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
 * compatible open source license.
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.BLOOM_FILTER)))
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.STORED_FIELDS)))
        MapperParsingException ex = expectThrows(
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet));
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE)))
            2,
            1,
import java.util.Map;
            1,
    }
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
            "parquet",
        // Use "integer" type which requests POINT_RANGE + COLUMNAR_STORAGE + STORED_FIELDS when all three are enabled
        DataFormat parquet = CompositeTestHelper.stubFormat(
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
            "parquet",
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet));
            1,
        assertEquals(3, map.size());
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.POINT_RANGE)))
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE), map.get(parquet));
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
        plugin.assignCapabilities(field, indexSettings, registry);
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet, lucene));
            true,
        DataFormat parquet = CompositeTestHelper.stubFormat(
 */
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene", "arrow")
                .putList(CompositeDataFormatPlugin.SECONDARY_DATA_FORMATS.getKey(), "lucene")
        IndexSettings indexSettings = buildIndexSettings(
        );
        IndexSettings indexSettings = buildIndexSettings(
        // Use a primary format name that doesn't match anything in the registry
        // No-caps field: isSearchable=false, isStored=false, hasDocValues=false
        MappedFieldType field = new NumberFieldMapper.NumberFieldType(
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
                .build()
package org.opensearch.composite;
    }
        );
        );
        );
        assertEquals(1, map.size());
        IndexSettings indexSettings = buildIndexSettings(
        );
            2,
        MappedFieldType field = new NumberFieldMapper.NumberFieldType(
    public void testFieldNotSupportedByAnyFormat_Throws() {
import org.opensearch.index.IndexSettings;
            "parquet",
        IndexSettings indexSettings = buildIndexSettings(
        DataFormat parquet = CompositeTestHelper.stubFormat(
        assertTrue(field.getCapabilityMap().isEmpty());
            NumberFieldMapper.NumberType.INTEGER,
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet").build()
        assertTrue(ex.getMessage().contains("user.name"));
        Settings settings = Settings.builder()
            false,
        when(registry.getRegisteredFormats()).thenReturn(Set.of());
        );
        plugin.assignCapabilities(field, indexSettings, registry);
        );
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        );
            null,
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities;
import org.opensearch.index.mapper.KeywordFieldMapper;
        DataFormat lucene = CompositeTestHelper.stubFormat(
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH), map.get(parquet));
    public void testFieldWithNoRequestedCapabilities_EmptyMap() {
 * Tests for {@link CompositeDataFormatPlugin#assignCapabilities(MappedFieldType, IndexSettings, DataFormatRegistry)}.
            1,
    public void testPartialAcrossFormatsButStillIncomplete_Throws() {
    }
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)
        );
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        DataFormat parquet = CompositeTestHelper.stubFormat(
                .build()
            MapperParsingException.class,
        // NumberFieldType with isSearchable=true, isStored=true, hasDocValues=true → POINT_RANGE + STORED_FIELDS + COLUMNAR_STORAGE
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.Capability;
        );
        );
            MapperParsingException.class,
        );
     */
    public void testNoFormatsConfigured_EmptyMap() {
                .build()
        DataFormat parquet = CompositeTestHelper.stubFormat(
            "lucene",
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        );
            () -> plugin.assignCapabilities(field, indexSettings, registry)
        assertEquals(2, map.size());
            Settings.builder()
 * SPDX-License-Identifier: Apache-2.0
/**
            2,
            Settings.builder()
        IndexSettings indexSettings = buildIndexSettings(
            () -> plugin.assignCapabilities(field, indexSettings, registry)
        IndexSettings indexSettings = buildIndexSettings(
            1,
            2,
            true,
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            "parquet",
            "lucene",
        // Both support COLUMNAR_STORAGE for keyword, but primary is first in configured order
import org.opensearch.Version;
        );
        plugin.assignCapabilities(field, indexSettings, registry);
    public void testPrimaryCoversAllCapabilities() {
            "lucene",
            "arrow",
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH)))
            Settings.builder().put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "nonexistent").build()
        plugin.assignCapabilities(field, indexSettings, registry);
    }
import org.opensearch.common.settings.Settings;
        );
     * delegation must run there, not the single-format interface default. A plugin overriding
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        plugin.assignCapabilities(field, indexSettings, registry, FieldScope.ROOT);
            MapperParsingException.class,
            true,
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE), map.get(parquet));
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals(Set.of(Capability.FULL_TEXT_SEARCH), map.get(lucene));
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
        when(registry.getRegisteredFormats()).thenReturn(Set.of(parquet));
        Map<DataFormat, Set<Capability>> map = field.getCapabilityMap();
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("user.name");
            "parquet",
                .build()
import static org.mockito.Mockito.mock;
        IndexSettings indexSettings = buildIndexSettings(
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
import org.opensearch.index.engine.dataformat.DataFormatRegistry;
                .build()
        DataFormat lucene = CompositeTestHelper.stubFormat(
            "parquet",
            Settings.builder()
            false,
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE), map.get(parquet));
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
            Set.of(new FieldTypeCapabilities("keyword", Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH)))
            2,
            "lucene",
        assertEquals(Set.of(Capability.COLUMNAR_STORAGE, Capability.FULL_TEXT_SEARCH), map.get(parquet));
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
     * {@link DataFormatRegistry} dispatches through the scope-aware overload; the composite
            "parquet",
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        );
            1,
            1,
    }
    private static IndexSettings buildIndexSettings(Settings extra) {
import static org.mockito.Mockito.when;
            Settings.builder()
        );
        IndexSettings indexSettings = buildIndexSettings(
        MappedFieldType field = new KeywordFieldMapper.KeywordFieldType("name");
        );
            .build();
        plugin.assignCapabilities(field, indexSettings, registry);
        assertEquals(2, map.size());
        DataFormat arrow = CompositeTestHelper.stubFormat(
            "parquet",
    public void testPriorityOrderPrimaryClaimsFirst() {
        DataFormatRegistry registry = mock(DataFormatRegistry.class);
 *
                .put(CompositeDataFormatPlugin.PRIMARY_DATA_FORMAT.getKey(), "parquet")
        CompositeDataFormatPlugin plugin = new CompositeDataFormatPlugin();
            Set.of(new FieldTypeCapabilities("integer", Set.of(Capability.COLUMNAR_STORAGE)))
        );
            1,
import org.opensearch.index.engine.dataformat.FieldTypeCapabilities.FieldScope;
        IndexMetadata indexMetadata = IndexMetadata.builder("test-index").settings(settings).build();
        assertEquals(Set.of(Capability.FULL_TEXT_SEARCH, Capability.COLUMNAR_STORAGE), map.get(lucene));
