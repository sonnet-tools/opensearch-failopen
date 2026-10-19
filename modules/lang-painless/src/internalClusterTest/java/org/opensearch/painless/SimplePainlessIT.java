            .get();
            .setSource("{\"field\":\"value1\"}", MediaTypeRegistry.JSON)  
public class SimplePainlessIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertEquals(1, bucket.getDocCount());
        assertEquals(3, ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().get(1).getDocCount());  
        );  
                .fetchField("result")
    public void testSimpleDerivedFieldsAgg() {  
        assertSearchResponse(response);
                    Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        bucket = aggResponse.getBuckets().get(1);
            .startObject()
            )  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() },
                        "painless",
            ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().get(0).getKey().get("keyword-field")
            .field("dynamic", "false")  
            .setId("d")
    @ParametersFactory
        assertEquals(
                )  
            .endObject()
        assertSearchResponse(response);
import org.opensearch.action.search.SearchResponse;
    public void setupSuiteScopeCluster() throws Exception {  
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
import org.opensearch.index.query.TermsQueryBuilder;
        client().prepareIndex("test")
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
    }
            .field("type", "nested")  
        assertEquals(1, ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().get(0).getDocCount());
        assertEquals("value2", bucket.getKey());  
import org.opensearch.common.settings.Settings;
        );  
            .setSource(  
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
    public SimplePainlessIT(Settings nodeSettings) {
    @Override
        assertEquals(2, ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().size());
                "{\"entity\":[{\"name\":\"ip-field\",\"value\":\"1.6.3.8\"},{\"name\":\"keyword-field\",\"value\":\"field-2\"}]}",
    }  
                .derivedField("result", "keyword", new Script("emit(params._source[\"field\"])"))  
        assertEquals(2, bucket.getDocCount());
            .setId("b")
    @Override
            )
        client().prepareIndex("test")
            )
import org.opensearch.search.aggregations.bucket.terms.Terms;
                "{\"entity\":[{\"name\":\"ip-field\",\"value\":\"1.2.3.4\"},{\"name\":\"keyword-field\",\"value\":\"field-1\"}]}",  
            .startObject("entity")
    }  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
            .get();
        SearchResponse response = client().search(searchRequest).actionGet();
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            SearchSourceBuilder.searchSource()
        assertEquals(2, Objects.requireNonNull(response.getHits().getTotalHits()).value());  
                    new Script(
        SearchResponse response = client().prepareSearch("test").setQuery(matchAllQuery()).addAggregation(agg).get();
import org.opensearch.script.ScriptType;
    }
            .get();
import java.util.List;
            .get();  
        );
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import java.util.Collections;  
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.action.search.SearchRequest;  
                MediaTypeRegistry.JSON
    public void testSimpleDerivedFieldsQuery() {  
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() }  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
        ensureSearchable("test");
            .setId("c")  
        client().prepareIndex("test-df")
import org.opensearch.core.xcontent.XContentBuilder;
        assertEquals("value3", bucket.getKey());  
        assertSearchResponse(response);
import org.opensearch.search.aggregations.bucket.composite.TermsValuesSourceBuilder;  
            .get();
 * The OpenSearch Contributors require contributions made to  
            "multi_buckets",
            .setSource("{\"field\":\"value3\"}", MediaTypeRegistry.JSON)
import java.util.Objects;
            "field-2",  
                .derivedField("result", "keyword", new Script("emit(params._source[\"field\"])"))  
        super(nodeSettings);
                        "String value = null; if (params == null || params._source == null || params._source.entity == null) { return \"\"; } for (item in params._source.entity) { if (item[\"name\"] == \"keyword-field\") { value = item['value']; break; } } return value;",
        );
            .get();
            .setSource(
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .setId("a")
        SearchRequest searchRequest = new SearchRequest("test-df").source(
                        ScriptType.INLINE,  
            "field-1",
                MediaTypeRegistry.JSON  
                .aggregation(new TermsAggregationBuilder("derived-agg").field("result"))
            .setId("d")
    public static Collection<Object[]> parameters() {  
            .get();
        return Settings.builder()
        SearchRequest searchRequest = new SearchRequest("test-df").source(
            .setId("a")
import org.opensearch.action.support.WriteRequest;
            .startObject("_meta")
                .fetchField("result")
                .query(new TermsQueryBuilder("result", "value1"))
            .put(super.nodeSettings(nodeOrdinal))  
            .get();  
        AggregationBuilder agg = AggregationBuilders.composite(
}  
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertEquals(1, bucket.getDocCount());
        );
import org.opensearch.plugins.Plugin;  
            .setId("b")  
import java.util.Collection;
            .build();
    }
import org.opensearch.script.Script;
            .field("schema_version", 5)
import org.opensearch.search.aggregations.bucket.composite.InternalComposite;
    }
            ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().get(1).getKey().get("keyword-field")
        return Arrays.asList(
        );
            prepareCreate("test").setMapping(xContentBuilder)  
                        Collections.emptyMap()  
            .setSource(
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        client().prepareIndex("test-df")
        client().prepareIndex("test")  
        assertEquals("value1", bucket.getKey());  
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)  
import java.util.Arrays;
            .endObject();  
            .setId("c")
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .setSource("{\"field\":\"value2\"}", MediaTypeRegistry.JSON)
        Terms aggResponse = response.getAggregations().get("derived-agg");  
            prepareCreate("test-df").setSettings(
        assertAcked(
            .endObject()  
        );
                "{\"entity\":[{\"name\":\"ip-field\",\"value\":\"5.6.7.8\"},{\"name\":\"keyword-field\",\"value\":\"field-2\"}]}",
        assertEquals(3, aggResponse.getBuckets().size());
            .startObject("properties")
            Collections.singletonList(  
import org.opensearch.search.builder.SearchSourceBuilder;  
                MediaTypeRegistry.JSON
        client().prepareIndex("test")  
                .setSettings(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.cluster.metadata.IndexMetadata;  
            .setSource("{\"field\":\"value1\"}", MediaTypeRegistry.JSON)  
 * compatible open source license.
        client().prepareIndex("test-df")
            )  
        ensureSearchable("test");  
            .endObject()
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING;  
@OpenSearchIntegTestCase.SuiteScopeTestCase
import org.opensearch.core.xcontent.MediaTypeRegistry;  
        client().prepareIndex("test-df")  
        assertAcked(  
import org.opensearch.test.OpenSearchIntegTestCase;
import org.opensearch.common.xcontent.XContentFactory;
                )
    }
            .put(CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), "4")
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
        SearchResponse response = client().search(searchRequest).actionGet();
 * this file be licensed under the Apache-2.0 license or a
 */  
            )
        return List.of(PainlessModulePlugin.class);  
                new TermsValuesSourceBuilder("keyword-field").script(
                    )
    protected Settings nodeSettings(int nodeOrdinal) {
package org.opensearch.painless;
import org.opensearch.search.aggregations.AggregationBuilders;
    @Override  
        assertEquals(  
 *
/*  
        Terms.Bucket bucket = aggResponse.getBuckets().get(0);
            .setSource(
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
    public void testTermsValuesSource() throws Exception {  
import org.opensearch.search.aggregations.AggregationBuilder;  
                MediaTypeRegistry.JSON
            )  
            SearchSourceBuilder.searchSource()
                "{\"entity\":[{\"name\":\"ip-field\",\"value\":\"2.6.4.8\"},{\"name\":\"keyword-field\",\"value\":\"field-2\"}]}",  
        );  
        bucket = aggResponse.getBuckets().get(2);
