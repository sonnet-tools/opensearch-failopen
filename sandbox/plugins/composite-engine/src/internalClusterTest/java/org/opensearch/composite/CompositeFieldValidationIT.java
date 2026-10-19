            .put(super.nodeSettings(nodeOrdinal))
 * SPDX-License-Identifier: Apache-2.0
        return Settings.builder()
        client().admin()
 */
    public void testRowIdFieldRejectedInDocument() throws Exception {  
            .putList("index.composite.secondary_data_formats", "lucene")
 *
            .get();
            .get();
 * this file be licensed under the Apache-2.0 license or a
        assertTrue("Expected rejection for multi-value field", bulkResponse.hasFailures());
 * compatible open source license.
            .build();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
            .put("index.number_of_shards", 1)  
        BulkItemResponse item = bulkResponse.getItems()[0];
    @Override
        ensureGreen(INDEX_NAME);
            ParquetDataFormatPlugin.class,
        client().admin()
import org.opensearch.common.settings.Settings;  
        assertTrue(item.getFailureMessage().contains("metadata field and cannot be added inside a document"));
    }  
        return Settings.builder()
        BulkResponse bulkResponse = client().prepareBulk()  
            .put("index.pluggable.dataformat.enabled", true)
        assertTrue(item.getFailureMessage().contains("multiple values"));
import org.opensearch.common.util.FeatureFlags;
import org.opensearch.plugins.Plugin;
        BulkItemResponse item = bulkResponse.getItems()[0];  
 */  
public class CompositeFieldValidationIT extends OpenSearchIntegTestCase {
            .setMapping("name", "type=keyword", "age", "type=integer")  
 * The OpenSearch Contributors require contributions made to  
            .put(FeatureFlags.PLUGGABLE_DATAFORMAT_EXPERIMENTAL_FLAG, true)  
        );
import org.opensearch.arrow.allocator.ArrowBasePlugin;  
            .prepareCreate(INDEX_NAME)  
            .build();  
/*  
@ThreadLeakScope(ThreadLeakScope.Scope.NONE)  
import com.carrotsearch.randomizedtesting.annotations.ThreadLeakScope;
            .put("index.pluggable.dataformat", "composite")  
    }
import org.opensearch.action.index.IndexRequest;
            .get();  
 * Validates that system-managed metadata fields reject external input and that  
            .add(new IndexRequest(INDEX_NAME).source(XContentType.JSON, "__row_id__", 999, "name", "test", "age", 25))
            .indices()
 * Integration tests for field validation in the composite data format engine.
import java.util.Collection;
            .put("index.number_of_replicas", 0)
            .setMapping("name", "type=keyword", "age", "type=integer")
import org.opensearch.parquet.ParquetDataFormatPlugin;  
            ArrowBasePlugin.class,  
            .get();  
import org.opensearch.action.bulk.BulkResponse;
    public void testMultipleValuesForSameFieldRejected() throws Exception {
}
            .prepareCreate(INDEX_NAME)
    }
 * multi-value fields are rejected for columnar formats.
import org.opensearch.common.xcontent.XContentType;
package org.opensearch.composite;
    private Settings compositeIndexSettings() {
        BulkResponse bulkResponse = client().prepareBulk()
    }
        ensureGreen(INDEX_NAME);
@OpenSearchIntegTestCase.ClusterScope(scope = OpenSearchIntegTestCase.Scope.TEST, numDataNodes = 1)
    private static final String INDEX_NAME = "test-field-validation";
            .indices()  
            LucenePlugin.class,  
import org.opensearch.action.bulk.BulkItemResponse;  
/**
            .setSettings(compositeIndexSettings())
            .setSettings(compositeIndexSettings())
import org.opensearch.be.lucene.LucenePlugin;
    }  
            .put("index.composite.primary_data_format", "parquet")
import org.opensearch.be.datafusion.DataFusionPlugin;
            .add(new IndexRequest(INDEX_NAME).source("{\"age\": [10, 20], \"name\": \"test\"}", XContentType.JSON))
        assertTrue(item.isFailed());  
import java.util.Arrays;
            CompositeDataFormatPlugin.class,
        assertTrue(item.isFailed());
        return Arrays.asList(
    @Override  
            DataFusionPlugin.class
        assertTrue("Expected bulk to have failures for __row_id__ field", bulkResponse.hasFailures());
import org.opensearch.test.OpenSearchIntegTestCase;
    protected Settings nodeSettings(int nodeOrdinal) {  
