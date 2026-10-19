        List<IndexRequestBuilder> builders = new ArrayList<>();  
        }  
        return Collections.singleton(CustomScriptPlugin.class);
package org.opensearch.search.aggregations.bucket.terms;
        builders.add(
                        jsonBuilder().startObject()
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val5").field("l", 5).field("d", 2).endObject())
                            .endArray()
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())  
    public void randomizeOptimizations() {
        );  
                .indices()
import java.util.Map;  
            client().prepareIndex("sort_idx")
        bucketProps.put("_term", "val7");
    @Override
                client().prepareIndex("empty_bucket_idx")
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);  
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);  
    }  
            client().admin()
        builders.add(  
                            .value("val" + (i + 1))  
        bucketProps.put("_term", "val5");
        bucketProps.put("_term", "val2");
            client().admin()  
        bucketProps.put("_count", 2L);  
        bucketProps.put("_term", "val1");
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val3").field("l", 3).field("d", 1).endObject())  
        createIndex("idx_unmapped");
            client().prepareIndex("sort_idx")
import org.opensearch.common.settings.Settings;
        );  
        );
import java.util.Collections;  
import org.opensearch.search.aggregations.bucket.AbstractTermsTestCase;
        bucketProps = new HashMap<>();
/*  
        builders.add(
        builders.add(
            });
                            .field("constant", 1)
 * SPDX-License-Identifier: Apache-2.0
@OpenSearchIntegTestCase.SuiteScopeTestCase  
        );
        bucketProps.put("sum_d", 6d);
import java.util.function.Function;
            scripts.put("Math.random()", vars -> randomDouble());  
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val4").field("l", 3).field("d", 1).endObject())
                            .startArray(MULTI_VALUED_FIELD_NAME)
import org.junit.Before;
                            .endObject()
        bucketProps.put("sum_d", 3d);
            client().prepareIndex("sort_idx")  
        for (int i = 1; i <= 3; i++) {  
        bucketProps = new HashMap<>();
            return scripts;
        }
        bucketProps.put("sum_d", 1d);
            client().prepareIndex("sort_idx")
    @Before
                            .endObject()
        bucketProps.put("sum_d", 3d);
        bucketProps.put("avg_l", 2d);
        indexRandom(true, builders);  
            builders.add(  
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "']", vars -> {
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val4").field("l", 3).field("d", 3).endObject())  
                .setMapping(SINGLE_VALUED_FIELD_NAME, "type=keyword", MULTI_VALUED_FIELD_NAME, "type=keyword", "tag", "type=keyword")  
                client().prepareIndex("high_card_idx")  
                .get()
import org.junit.After;  
        bucketProps.put("avg_l", 5d);
    @Override  
        );
            client().prepareIndex("sort_idx")
                client().prepareIndex("sort_idx")  
                .indices()
        );
            });
                            .startArray(MULTI_VALUED_FIELD_NAME)
                    .setId("" + i)
                .prepareCreate("sort_idx")
                            .field(SINGLE_VALUED_FIELD_NAME, "val" + Strings.padStart(i + "", 3, '0'))  
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.test.OpenSearchIntegTestCase;
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {
                Map<?, ?> doc = (Map) vars.get("doc");
        bucketProps = new HashMap<>();
        super(staticSettings);
    protected static final String MULTI_VALUED_FIELD_NAME = "s_values";
        TermsAggregatorFactory.REMAP_GLOBAL_ORDS = null;
        @Override
    }
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val3").field("l", 3).field("d", 2).endObject())
    protected String key(Terms.Bucket bucket) {
        bucketProps.put("sum_d", 1d);
                return value.getValue();  
import org.opensearch.core.common.Strings;  
        bucketProps.put("_count", 1L);  
            );
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
                client().prepareIndex("idx")  
        builders.add(  
    }
            builders.add(
            client().prepareIndex("sort_idx")
    public void resetOptimizations() {
        TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = null;  
        return bucket.getKeyAsString();  
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
import java.util.HashMap;
                .prepareCreate("idx")
        for (int i = 0; i < 5; i++) {
    }
        builders.add(
            );
import java.io.IOException;  
        );
    }  
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);  
 */  
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);  
import org.opensearch.action.index.IndexRequestBuilder;
            scripts.put("doc['" + SINGLE_VALUED_FIELD_NAME + "'].value", vars -> {  
        bucketProps.put("sum_d", 4d);
        assertAcked(
        }  
        bucketProps.put("_term", "val4");
        bucketProps = new HashMap<>();
                return doc.get(MULTI_VALUED_FIELD_NAME);  
        );
                .get()
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val2").field("l", 2).field("d", i).endObject())
        getMultiSortDocs(builders);
            scripts.put("'foo_' + _value", vars -> "foo_" + (String) vars.get("_value"));
                .get()
        );
            );
import java.util.ArrayList;
            builders.add(
        bucketProps.put("_count", 2L);  
            builders.add(
        bucketProps.put("avg_l", 5d);
        prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer").get();  
        }
        bucketProps.put("avg_l", 1d);
            client().prepareIndex("sort_idx")  
            );
import java.util.List;
    public BaseStringTermsTestCase(Settings staticSettings) {
import java.util.Collection;
                .setMapping(SINGLE_VALUED_FIELD_NAME, "type=keyword", MULTI_VALUED_FIELD_NAME, "type=keyword", "tag", "type=keyword")
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);  
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val1").field("l", 1).field("d", i).endObject())  
            );
        bucketProps.put("avg_l", 5d);
        bucketProps = new HashMap<>();
        bucketProps.put("avg_l", 3d);
            client().admin()  
import org.opensearch.index.fielddata.ScriptDocValues;
 * compatible open source license.
            return scripts;
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;  
        builders.add(
            client().prepareIndex("sort_idx")  
                            .field("i", i)
}
                            .value("val" + Strings.padStart(i + "", 3, '0'))
        bucketProps.put("_term", "val3");
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;  
        Map<String, Object> bucketProps = new HashMap<>();
    }
        bucketProps.put("_count", 1L);  
        bucketProps = new HashMap<>();
        TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = randomBoolean();  
                    )  
        bucketProps.put("_count", 3L);  
    public void setupSuiteScopeCluster() throws Exception {
import org.opensearch.plugins.Plugin;
    protected static Map<String, Map<String, Object>> expectedMultiSortBuckets;
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                            .endArray()
        TermsAggregatorFactory.REMAP_GLOBAL_ORDS = randomBoolean();
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val6").field("l", 5).field("d", 1).endObject())  
                .indices()
        assertAcked(  
        bucketProps.put("avg_l", 3d);
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val7").field("l", 5).field("d", 1).endObject())
            builders.add(
                            .value("val" + i)
        bucketProps.put("_count", 3L);  
        bucketProps.put("_term", "val6");
                client().prepareIndex("sort_idx")
                            .field("tag", i < 5 / 2 + 1 ? "more" : "less")  
        for (int i = 0; i < 100; i++) {
    }
            Map<String, Function<Map<String, Object>, Object>> scripts = super.pluginScripts();
        }  
                    .setSource(
            scripts.put("42", vars -> 42);  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
 * The OpenSearch Contributors require contributions made to  
    @After
            scripts.put("_value.substring(0,3)", vars -> ((String) vars.get("_value")).substring(0, 3));
                            .field(SINGLE_VALUED_FIELD_NAME, "val" + i)  
                ScriptDocValues.Strings value = (ScriptDocValues.Strings) doc.get(SINGLE_VALUED_FIELD_NAME);
        ensureSearchable();
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val5").field("l", 5).field("d", 1).endObject())
        for (int i = 0; i < 2; i++) {
        bucketProps.put("sum_d", 6d);
    protected static final String SINGLE_VALUED_FIELD_NAME = "s_value";  
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);  
public class BaseStringTermsTestCase extends AbstractTermsTestCase {
                        jsonBuilder().startObject()
        @Override  
        expectedMultiSortBuckets = new HashMap<>();  
    }  
 *
        bucketProps.put("_count", 2L);  
                .prepareCreate("high_card_idx")  
        );
                Map<?, ?> doc = (Map) vars.get("doc");
                .setMapping(SINGLE_VALUED_FIELD_NAME, "type=keyword", MULTI_VALUED_FIELD_NAME, "type=keyword", "tag", "type=keyword")  
        assertAcked(
        builders.add(
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {  
        );  
        }
                    .setSource(
                    )  
                            .value("val" + Strings.padStart((i + 1) + "", 3, '0'))  
