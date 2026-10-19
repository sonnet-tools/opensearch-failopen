            "field-2",
        SearchResponse response = client().search(searchRequest).actionGet();
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        bucket = aggResponse.getBuckets().get(2);
    @Override
import org.opensearch.index.query.TermsQueryBuilder;
            .endObject();
        client().prepareIndex("test-df")
import org.opensearch.script.ScriptType;
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
    public void setupSuiteScopeCluster() throws Exception {
        client().prepareIndex("test")
            .setId("c")
                        ScriptType.INLINE,
            .setSource(
    }
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() }
            .field("type", "nested")
        );
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .setId("d")
        Terms.Bucket bucket = aggResponse.getBuckets().get(0);
            SearchSourceBuilder.searchSource()
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
import java.util.Arrays;
                "{\"entity\":[{\"name\":\"ip-field\",\"value\":\"1.6.3.8\"},{\"name\":\"keyword-field\",\"value\":\"field-2\"}]}",
import java.util.List;
            )
            .field("schema_version", 5)
        );
        client().prepareIndex("test")
            .get();
            .get();
        Terms aggResponse = response.getAggregations().get("derived-agg");
        SearchResponse response = client().prepareSearch("test").setQuery(matchAllQuery()).addAggregation(agg).get();
        SearchResponse response = client().search(searchRequest).actionGet();
                )
            .put(CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING.getKey(), "4")
                .setSettings(
        AggregationBuilder agg = AggregationBuilders.composite(
            .setSource(
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
                        "painless",
            .startObject("properties")
        assertEquals(
                .query(new TermsQueryBuilder("result", "value1"))
        );
        client().prepareIndex("test-df")
        );
        SearchRequest searchRequest = new SearchRequest("test-df").source(
 * compatible open source license.
            .setSource(
import org.opensearch.action.search.SearchResponse;
 * SPDX-License-Identifier: Apache-2.0
                .fetchField("result")
import org.opensearch.core.xcontent.MediaTypeRegistry;
                    Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
        assertEquals("value2", bucket.getKey());
                .aggregation(new TermsAggregationBuilder("derived-agg").field("result"))
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
 *
    public void testSimpleDerivedFieldsAgg() {
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .build();
            SearchSourceBuilder.searchSource()
            .setSource("{\"field\":\"value3\"}", MediaTypeRegistry.JSON)
        assertSearchResponse(response);
    }
    public SimplePainlessIT(Settings nodeSettings) {
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            prepareCreate("test").setMapping(xContentBuilder)
            .setSource("{\"field\":\"value1\"}", MediaTypeRegistry.JSON)
        return Settings.builder()
import org.opensearch.action.search.SearchRequest;
            ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().get(0).getKey().get("keyword-field")
            .setSource(
import org.opensearch.search.aggregations.bucket.terms.TermsAggregationBuilder;
                        Collections.emptyMap()
import org.opensearch.common.xcontent.XContentFactory;
import static org.opensearch.search.SearchService.CONCURRENT_SEGMENT_SEARCH_TARGET_MAX_SLICE_COUNT_SETTING;
import org.opensearch.common.settings.Settings;
/*
        assertAcked(
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 */
        assertEquals("value3", bucket.getKey());
            Collections.singletonList(
            .setSource("{\"field\":\"value1\"}", MediaTypeRegistry.JSON)
import java.util.Objects;
        assertEquals(
            )
        assertEquals(1, ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().get(0).getDocCount());
                Settings.builder().put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1).put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 0)
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .get();
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(3, ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().get(1).getDocCount());
            .startObject("entity")
                    )
        bucket = aggResponse.getBuckets().get(1);
                "{\"entity\":[{\"name\":\"ip-field\",\"value\":\"1.2.3.4\"},{\"name\":\"keyword-field\",\"value\":\"field-1\"}]}",
        assertSearchResponse(response);
        XContentBuilder xContentBuilder = XContentFactory.jsonBuilder()
package org.opensearch.painless;
            .endObject()
                MediaTypeRegistry.JSON
    public static Collection<Object[]> parameters() {
            .startObject("_meta")
        return List.of(PainlessModulePlugin.class);
        assertEquals("value1", bucket.getKey());
        client().prepareIndex("test-df")
                .fetchField("result")
                .derivedField("result", "keyword", new Script("emit(params._source[\"field\"])"))
            .setSource("{\"field\":\"value2\"}", MediaTypeRegistry.JSON)
import static org.opensearch.index.query.QueryBuilders.matchAllQuery;
            .get();
        assertEquals(2, ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().size());
                )
                .derivedField("result", "keyword", new Script("emit(params._source[\"field\"])"))
            .get();
        );
    }
 * The OpenSearch Contributors require contributions made to
        client().prepareIndex("test")
        assertEquals(3, aggResponse.getBuckets().size());
            .setId("c")
public class SimplePainlessIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
import org.opensearch.search.aggregations.AggregationBuilder;
        assertEquals(2, Objects.requireNonNull(response.getHits().getTotalHits()).value());
                "{\"entity\":[{\"name\":\"ip-field\",\"value\":\"5.6.7.8\"},{\"name\":\"keyword-field\",\"value\":\"field-2\"}]}",
            "multi_buckets",
import org.opensearch.test.OpenSearchIntegTestCase;
                MediaTypeRegistry.JSON
            .field("dynamic", "false")
        assertEquals(1, bucket.getDocCount());
import org.opensearch.search.aggregations.bucket.terms.Terms;
            .startObject()
    }
import java.util.Collection;
                        "String value = null; if (params == null || params._source == null || params._source.entity == null) { return \"\"; } for (item in params._source.entity) { if (item[\"name\"] == \"keyword-field\") { value = item['value']; break; } } return value;",
        );
    @ParametersFactory
            .setId("b")
    @Override
            .get();
            .get();
    public void testSimpleDerivedFieldsQuery() {
    }
import org.opensearch.cluster.metadata.IndexMetadata;
        super(nodeSettings);
        ensureSearchable("test");
        assertEquals(2, bucket.getDocCount());
            .put(super.nodeSettings(nodeOrdinal))
            .setId("a")
            )
@OpenSearchIntegTestCase.SuiteScopeTestCase
                    new Script(
    public void testTermsValuesSource() throws Exception {
        client().prepareIndex("test")
import org.opensearch.action.support.WriteRequest;
            .setId("d")
import org.opensearch.search.builder.SearchSourceBuilder;
    protected Settings nodeSettings(int nodeOrdinal) {
            .endObject()
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            ((InternalComposite) response.getAggregations().get("multi_buckets")).getBuckets().get(1).getKey().get("keyword-field")
import org.opensearch.search.aggregations.bucket.composite.InternalComposite;
                "{\"entity\":[{\"name\":\"ip-field\",\"value\":\"2.6.4.8\"},{\"name\":\"keyword-field\",\"value\":\"field-2\"}]}",
        ensureSearchable("test");
            "field-1",
        client().prepareIndex("test-df")
            prepareCreate("test-df").setSettings(
    }
        return Arrays.asList(
import java.util.Collections;
        assertSearchResponse(response);
    protected Collection<Class<? extends Plugin>> nodePlugins() {
}
import org.opensearch.search.aggregations.AggregationBuilders;
import org.opensearch.script.Script;
            )
                MediaTypeRegistry.JSON
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() },
                MediaTypeRegistry.JSON
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            .endObject()
        );
            )
            )
                new TermsValuesSourceBuilder("keyword-field").script(
        SearchRequest searchRequest = new SearchRequest("test-df").source(
    @Override
            .setRefreshPolicy(WriteRequest.RefreshPolicy.IMMEDIATE)
            .setId("a")
    }
import org.opensearch.plugins.Plugin;
        assertAcked(
        );
import org.opensearch.search.aggregations.bucket.composite.TermsValuesSourceBuilder;
    }
            .setId("b")
        assertEquals(1, bucket.getDocCount());
            .get();
import org.opensearch.core.xcontent.XContentBuilder;
