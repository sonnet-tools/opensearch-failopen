                client().prepareIndex("high_card_idx")
        bucketProps.put("avg_l", 3d);
        bucketProps.put("sum_d", 6d);
            builders.add(
        bucketProps.put("_term", "val5");
            client().prepareIndex("sort_idx")
            );
    private void getMultiSortDocs(List<IndexRequestBuilder> builders) throws IOException {
        for (int i = 1; i <= 3; i++) {
    protected static final String SINGLE_VALUED_FIELD_NAME = "s_value";
    }
        bucketProps.put("_term", "val6");
        bucketProps = new HashMap<>();
        bucketProps.put("_term", "val2");
        prepareCreate("empty_bucket_idx").setMapping(SINGLE_VALUED_FIELD_NAME, "type=integer").get();
        );
                            .endArray()
        );
            );
                return value.getValue();
                .get()
    protected Collection<Class<? extends Plugin>> nodePlugins() {
                            .startArray(MULTI_VALUED_FIELD_NAME)
        @Override
import java.io.IOException;
            client().prepareIndex("sort_idx")
import java.util.HashMap;
        assertAcked(
    @Before
            client().admin()
        TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = null;
        bucketProps.put("avg_l", 2d);
    @After
        @Override
    }
            scripts.put("doc['" + MULTI_VALUED_FIELD_NAME + "']", vars -> {
    protected String key(Terms.Bucket bucket) {
        bucketProps.put("avg_l", 3d);
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val1").field("l", 1).field("d", i).endObject())
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val5").field("l", 5).field("d", 1).endObject())
        }
        bucketProps.put("sum_d", 3d);
                client().prepareIndex("idx")
        }
                .get()
            client().prepareIndex("sort_idx")
        builders.add(
                .prepareCreate("idx")
        );
                            .field("i", i)
        bucketProps.put("avg_l", 5d);
        builders.add(
        super(staticSettings);
        bucketProps.put("avg_l", 1d);
            );
    }
        bucketProps.put("avg_l", 5d);
        assertAcked(
                            .value("val" + Strings.padStart((i + 1) + "", 3, '0'))
        }
        );
import java.util.Collections;
import java.util.ArrayList;
            scripts.put("_value.substring(0,3)", vars -> ((String) vars.get("_value")).substring(0, 3));
public class BaseStringTermsTestCase extends AbstractTermsTestCase {
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val3").field("l", 3).field("d", 2).endObject())
import org.opensearch.index.fielddata.ScriptDocValues;
                .get()
                client().prepareIndex("sort_idx")
            return scripts;
        indexRandom(true, builders);
        );
        assertAcked(
                            .value("val" + (i + 1))
        );
                Map<?, ?> doc = (Map) vars.get("doc");
        bucketProps.put("_term", "val7");
package org.opensearch.search.aggregations.bucket.terms;
        bucketProps.put("avg_l", 5d);
                            .endObject()
                            .field("tag", i < 5 / 2 + 1 ? "more" : "less")
        );
        TermsAggregatorFactory.REMAP_GLOBAL_ORDS = randomBoolean();
        builders.add(
                    .setSource(
                        jsonBuilder().startObject()
        bucketProps.put("sum_d", 1d);
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);
            );
        getMultiSortDocs(builders);
    }
        bucketProps = new HashMap<>();
        TermsAggregatorFactory.REMAP_GLOBAL_ORDS = null;
import org.opensearch.plugins.Plugin;
            client().prepareIndex("sort_idx")
        builders.add(
        bucketProps.put("sum_d", 4d);
import org.junit.After;
            client().prepareIndex("sort_idx")
                    .setId("" + i)
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);
                client().prepareIndex("sort_idx")
    public void resetOptimizations() {
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);
        return Collections.singleton(CustomScriptPlugin.class);
        builders.add(
        bucketProps.put("sum_d", 6d);
                .indices()
 * SPDX-License-Identifier: Apache-2.0
        for (int i = 0; i < 2; i++) {
import java.util.List;
            scripts.put("doc['" + SINGLE_VALUED_FIELD_NAME + "'].value", vars -> {
            builders.add(
 * this file be licensed under the Apache-2.0 license or a
            });
        bucketProps.put("_count", 3L);
 */
                    .setSource(
        bucketProps.put("_count", 2L);
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val3").field("l", 3).field("d", 1).endObject())
@OpenSearchIntegTestCase.SuiteScopeTestCase
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val7").field("l", 5).field("d", 1).endObject())
                            .endArray()
                    )
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val6").field("l", 5).field("d", 1).endObject())
            Map<String, Function<Map<String, Object>, Object>> scripts = super.pluginScripts();
                            .field(SINGLE_VALUED_FIELD_NAME, "val" + Strings.padStart(i + "", 3, '0'))
        bucketProps.put("_term", "val1");
        }
    }
        protected Map<String, Function<Map<String, Object>, Object>> nonDeterministicPluginScripts() {
                .setMapping(SINGLE_VALUED_FIELD_NAME, "type=keyword", MULTI_VALUED_FIELD_NAME, "type=keyword", "tag", "type=keyword")
                ScriptDocValues.Strings value = (ScriptDocValues.Strings) doc.get(SINGLE_VALUED_FIELD_NAME);
        bucketProps.put("_term", "val3");
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
import org.opensearch.action.index.IndexRequestBuilder;
                .indices()
        }
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);
import java.util.Map;
                return doc.get(MULTI_VALUED_FIELD_NAME);
            );
import org.opensearch.core.common.Strings;
                .prepareCreate("high_card_idx")
        expectedMultiSortBuckets = new HashMap<>();
            builders.add(
            builders.add(
 * compatible open source license.
            scripts.put("Math.random()", vars -> randomDouble());
                client().prepareIndex("empty_bucket_idx")
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);
        builders.add(
        bucketProps.put("_count", 2L);
    }
            client().prepareIndex("sort_idx")
        bucketProps.put("sum_d", 1d);
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val2").field("l", 2).field("d", i).endObject())
            client().prepareIndex("sort_idx")
        builders.add(
        );
                        jsonBuilder().startObject()
        bucketProps.put("_count", 1L);
        );
                .setMapping(SINGLE_VALUED_FIELD_NAME, "type=keyword", MULTI_VALUED_FIELD_NAME, "type=keyword", "tag", "type=keyword")
            return scripts;
        return bucket.getKeyAsString();
        bucketProps = new HashMap<>();
            scripts.put("'foo_' + _value", vars -> "foo_" + (String) vars.get("_value"));
            client().prepareIndex("sort_idx")
        for (int i = 0; i < 100; i++) {
                            .endObject()
        ensureSearchable();
        bucketProps.put("_term", "val4");
        bucketProps.put("_count", 3L);
            });
                    )
        TermsAggregatorFactory.COLLECT_SEGMENT_ORDS = randomBoolean();
                            .startArray(MULTI_VALUED_FIELD_NAME)
            client().admin()
    protected static final String MULTI_VALUED_FIELD_NAME = "s_values";
                            .field(SINGLE_VALUED_FIELD_NAME, "val" + i)
                            .field("constant", 1)
import org.opensearch.common.settings.Settings;
    public BaseStringTermsTestCase(Settings staticSettings) {
                    .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, i * 2).endObject())
        bucketProps = new HashMap<>();
 *
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val4").field("l", 3).field("d", 1).endObject())
}
    protected static Map<String, Map<String, Object>> expectedMultiSortBuckets;
import java.util.function.Function;
                            .value("val" + i)
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val4").field("l", 3).field("d", 3).endObject())
                .prepareCreate("sort_idx")
    }
    @Override
 * The OpenSearch Contributors require contributions made to
    public void randomizeOptimizations() {
        }
            client().admin()
        );
            builders.add(
        bucketProps.put("_count", 1L);
                .indices()
        Map<String, Object> bucketProps = new HashMap<>();
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
                Map<?, ?> doc = (Map) vars.get("doc");
    @Override
        List<IndexRequestBuilder> builders = new ArrayList<>();
        bucketProps.put("sum_d", 3d);
                .setMapping(SINGLE_VALUED_FIELD_NAME, "type=keyword", MULTI_VALUED_FIELD_NAME, "type=keyword", "tag", "type=keyword")
        createIndex("idx_unmapped");
        bucketProps = new HashMap<>();
                            .value("val" + Strings.padStart(i + "", 3, '0'))
            Map<String, Function<Map<String, Object>, Object>> scripts = new HashMap<>();
import org.opensearch.search.aggregations.bucket.AbstractTermsTestCase;
        );
/*
                .setSource(jsonBuilder().startObject().field(SINGLE_VALUED_FIELD_NAME, "val5").field("l", 5).field("d", 2).endObject())
import java.util.Collection;
        expectedMultiSortBuckets.put((String) bucketProps.get("_term"), bucketProps);
        for (int i = 0; i < 5; i++) {
        bucketProps = new HashMap<>();
            scripts.put("42", vars -> 42);
        bucketProps.put("_count", 2L);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import org.opensearch.test.OpenSearchIntegTestCase;
        builders.add(
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
import org.junit.Before;
    }
    public void setupSuiteScopeCluster() throws Exception {
