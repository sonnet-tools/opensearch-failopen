        FieldStorageResolver merged = FieldStorageResolver.merged(List.of(a, b));
        assertEquals("name", infos.get(0).getFieldName());
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.cluster.metadata.IndexMetadata;
        );  
    }
 *
    public void testKeywordFieldHasNullSubfield() {
        assertEquals(List.of("lucene"), info.getIndexFormats());
        FieldStorageResolver resolver = newResolver("parquet", Map.of("name", Map.of("type", "text")));
        IllegalArgumentException ex = expectThrows(IllegalArgumentException.class, () -> resolver.resolve(List.of("name")));  
    public void testTextFieldWithoutKeywordSubfieldHasNullSubfield() {
        // index A = {name, age}, index B = {name, alias}. The union scan row type references all
 * Unit tests for {@link FieldStorageResolver} field storage resolution.  
        FieldStorageResolver resolver = newResolver(  
    }
import java.util.List;
        assertNull(resolver.resolve(List.of("name")).get(0).getExactMatchSubfield());
    }  
import static org.mockito.Mockito.when;  
        // Mirrors an index pattern (test*) whose backing indices declare different field sets:
        when(indexMetadata.mapping()).thenReturn(null);  
        // any field against it alone fails with the standard "not found" error.
        // An index created empty (no mapping, no data) declares no fields. It must construct
        FieldStorageResolver empty = newMappinglessResolver();
        assertEquals(List.of("lucene"), info.getIndexFormats());
        FieldStorageInfo info = resolver.resolve(List.of("gender")).get(0);
        MappingMetadata mappingMetadata = mock(MappingMetadata.class);
            Settings.builder()
        assertEquals("alias", infos.get(2).getFieldName());
        // cleanly — aliases legitimately span such indices next to populated ones — and resolving  
        when(indexMetadata.getIndex()).thenReturn(new Index("test_index", "uuid"));
 * compatible open source license.
        FieldStorageResolver resolver = newResolver("parquet", Map.of("name", Map.of("type", "text")));  
    }
        );
        FieldStorageResolver b = newResolver("parquet", Map.of("name", Map.of("type", "text"), "alias", Map.of("type", "keyword")));
import org.opensearch.common.settings.Settings;
    }
        // Alias over {empty index, populated index}: the union must equal the populated index's
        assertEquals("age", infos.get(1).getFieldName());  
        when(indexMetadata.getIndex()).thenReturn(new Index("empty_index", "uuid"));
        // three; a single-index resolver would throw on the field its index lacks.  
                .put("index.composite.primary_data_format", "parquet")
 */  
        FieldStorageResolver resolver = newMappinglessResolver();
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
        assertNull(resolver.resolve(List.of("tag")).get(0).getExactMatchSubfield());  
    private static FieldStorageResolver newMappinglessResolver() {  
    }
/*  
        assertEquals("keyword", info.getExactMatchSubfield());
        assertTrue("expected 'no storage' error, got: " + ex.getMessage(), ex.getMessage().contains("has no storage in any format"));  
        assertEquals("age", infos.get(1).getFieldName());  
        when(indexMetadata.getSettings()).thenReturn(  
        when(indexMetadata.getSettings()).thenReturn(  
        assertEquals("name", infos.get(0).getFieldName());
        FieldStorageInfo info = resolver.resolve(List.of("age")).get(0);  
        List<FieldStorageInfo> infos = merged.resolve(List.of("name", "age"));
        when(indexMetadata.mapping()).thenReturn(mappingMetadata);  
        );
        IndexMetadata indexMetadata = mock(IndexMetadata.class);
        assertEquals("age", info.getFieldName());
        assertEquals(List.of("parquet"), info.getDocValueFormats());  
import org.opensearch.cluster.metadata.MappingMetadata;  
        assertEquals(2, infos.size());
        );
    private static FieldStorageResolver newResolver(String primaryFormat, Map<String, Map<String, Object>> fieldMappings) {
    }  
                .putList("index.composite.secondary_data_formats", "lucene")  
            Settings.builder()
        FieldStorageResolver resolver = newResolver("parquet", Map.of("age", Map.of("type", "long")));
    public void testMergedResolverSkipsMappinglessIndex() {
        return new FieldStorageResolver(indexMetadata);
import org.opensearch.test.OpenSearchTestCase;  
            IllegalStateException.class,  
/**
        assertEquals("name", info.getFieldName());  
import org.opensearch.analytics.spi.FieldStorageInfo;
 * this file be licensed under the Apache-2.0 license or a
        FieldStorageResolver resolver = newResolver("parquet", Map.of("tag", Map.of("type", "keyword")));
        FieldStorageInfo info = resolver.resolve(List.of("name")).get(0);
public class FieldStorageResolverTests extends OpenSearchTestCase {
package org.opensearch.analytics.planner;
    }  
                .putList("index.composite.secondary_data_formats", "lucene")  
        FieldStorageResolver a = newResolver("parquet", Map.of("name", Map.of("type", "text"), "age", Map.of("type", "long")));
        Map<String, Object> mappingSource = Map.of("properties", fieldMappings);
                .build()
    }
    public void testLongFieldGetsDocValuesInPrimaryFormat() {  
        FieldStorageResolver populated = newResolver("parquet", Map.of("name", Map.of("type", "text"), "age", Map.of("type", "long")));
                .put("index.composite.primary_data_format", primaryFormat)
        when(mappingMetadata.sourceAsMap()).thenReturn(mappingSource);
 * SPDX-License-Identifier: Apache-2.0
        List<FieldStorageInfo> infos = merged.resolve(List.of("name", "age", "alias"));
    public void testMergedResolverUnionsFieldsAcrossIndices() {  
        assertEquals(3, infos.size());
                .build()
    public void testFieldWithAllStorageDisabledHasNoStorage() {
import static org.mockito.Mockito.mock;
            "parquet",
            Map.of("gender", Map.of("type", "text", "fields", Map.of("keyword", Map.of("type", "keyword"))))
        FieldStorageResolver merged = FieldStorageResolver.merged(List.of(empty, populated));
}
    public void testIndexWithoutMappingContributesNoFields() {
        return new FieldStorageResolver(indexMetadata);
        assertEquals(List.of("parquet"), info.getDocValueFormats());
        assertTrue("expected 'not found' error, got: " + ex.getMessage(), ex.getMessage().contains("not found in field storage"));
        IllegalStateException ex = expectThrows(
import java.util.Map;  
import org.opensearch.core.index.Index;
        // field set — the empty member contributes nothing and must not fail the merge.  
    public void testTextFieldGetsDocValuesInPrimaryFormat() {
    public void testTextFieldWithKeywordSubfieldCapturesSubfieldName() {
    }
            () -> newResolver("parquet", Map.of("name", Map.of("type", "text", "doc_values", false, "index", false)))
 */
    }
