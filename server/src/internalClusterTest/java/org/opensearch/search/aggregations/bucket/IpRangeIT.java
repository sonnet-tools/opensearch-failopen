        return Arrays.asList(  
        assertNull(bucket3.getTo());
            )  
        assertSearchResponse(rsp);
        assertEquals(3, range.getBuckets().size());
        assertEquals("192.168.1.10", bucket3.getFrom());
    }
                    .field("ips")
 * You may obtain a copy of the License at  
        assertNull(bucket1.getFrom());
    public IpRangeIT(Settings staticSettings) {  
        assertEquals(0, bucket1.getDocCount());
                AggregationBuilders.ipRange("my_range")
            .get();
            client().prepareSearch("idx").addAggregation(AggregationBuilders.ipRange("my_range").field("ip")).get();  
                    .addRange("192.168.1.0", "192.168.1.10")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
        assertEquals(3, range.getBuckets().size());
        assertEquals("192.168.1.10-*", bucket3.getKey());  
    }
 * this file be licensed under the Apache-2.0 license or a
        waitForRelocation(ClusterHealthStatus.GREEN);  
 * ownership. Elasticsearch licenses this file to you under  
    @Override  
        assertEquals("192.168.1.0", bucket1.getTo());
                    .addUnboundedTo("192.168.1.0")  
        assertEquals("192.168.1.10", bucket2.getTo());
        assertNull(bucket1.getFrom());
 * Unless required by applicable law or agreed to in writing,
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        Range range = rsp.getAggregations().get("my_range");  
        assertAcked(prepareCreate("idx_unmapped"));
            .get();
        } catch (SearchPhaseExecutionException spee) {
        Range.Bucket bucket1 = range.getBuckets().get(0);  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;  
        Range range = rsp.getAggregations().get("my_range");  
                .addAggregation(  
            client().prepareIndex("idx").setId("1").setSource("ip", "192.168.1.7", "ips", Arrays.asList("192.168.0.13", "192.168.1.2")),
        assertEquals(1, bucket2.getDocCount());
    }
                .get()  
                    .addUnboundedTo("192.168.1.0")  
        assertEquals(1, bucket2.getDocCount());
import java.util.Arrays;  
import java.util.Map;  
            IllegalArgumentException.class,  
                    .addMaskRange("0.0.0.0/0")
        );  
            client().prepareIndex("idx")  
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
                    .addRange("192.168.1.0", "192.168.1.10")
        assertAcked(prepareCreate("idx").setMapping("ip", "type=ip", "ips", "type=ip"));
        assertEquals(1, bucket3.getDocCount());
            assertEquals(rootCause.getMessage(), "No [ranges] specified for the [my_range] aggregation");
                .setId("3")
        IllegalArgumentException e = expectThrows(  
        Range range = rsp.getAggregations().get("my_range");  
                        .field("ip")
        return Arrays.asList(DummyScriptPlugin.class);  
import org.opensearch.script.Script;
        assertEquals(0, bucket3.getDocCount());
        SearchResponse rsp = client().prepareSearch("idx_unmapped")
 * GitHub history for details.
        SearchResponse rsp = client().prepareSearch("idx")
    @Override
        assertEquals("*-192.168.1.0", bucket1.getKey());  
import java.util.Collections;
        assertEquals("192.168.1.0", bucket2.getFrom());
        assertEquals("192.168.1.10-*", bucket3.getKey());  
 * Licensed to Elasticsearch under one or more contributor  
    public void testNoRangesInQuery() {
                    .addMaskRange("2001:db8::/64")
 * Modifications Copyright OpenSearch Contributors. See  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.action.search.SearchResponse;  
        assertEquals("192.168.1.10", bucket3.getFrom());
/*  
            () -> client().prepareSearch("idx")
                AggregationBuilders.ipRange("my_range")
import static org.hamcrest.Matchers.containsString;  
                .setSource("ip", "2001:db8::ff00:42:8329", "ips", Arrays.asList("2001:db8::ff00:42:8329", "2001:db8::ff00:42:8380"))
        Range.Bucket bucket3 = range.getBuckets().get(2);  
        Range.Bucket bucket3 = range.getBuckets().get(2);  
        assertEquals(0, bucket2.getDocCount());
                AggregationBuilders.ipRange("my_range")
        Range.Bucket bucket3 = range.getBuckets().get(2);  
            IllegalArgumentException.class,
            Throwable rootCause = spee.getCause().getCause();  
    }
        assertNull(bucket1.getFrom());
        assertEquals(2, bucket3.getDocCount());
    }  
            .addAggregation(  
        );  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                    .addUnboundedFrom("192.168.1.10")
        Range range = rsp.getAggregations().get("my_range");  
    }
import static org.hamcrest.Matchers.instanceOf;
            )  
        assertEquals("192.168.1.10-*", bucket3.getKey());  
        assertSearchResponse(rsp);
        assertThat(e.getMessage(), containsString("[ip_range] does not support scripts"));
        Range.Bucket bucket1 = range.getBuckets().get(0);  
    }
        assertEquals("*-192.168.1.0", bucket1.getKey());  
        assertEquals(2, bucket3.getDocCount());
            assertThat(rootCause, instanceOf(IllegalArgumentException.class));
            .addAggregation(  
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
            .get();
        assertEquals("192.168.1.10", bucket3.getFrom());
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        );  
        Range range = rsp.getAggregations().get("my_range");  
        assertEquals(0, bucket1.getDocCount());
        }
        assertSearchResponse(rsp);
                )
            )  
        assertEquals("192.168.1.10", bucket2.getTo());
        indexRandom(
        assertEquals("192.168.1.0-192.168.1.10", bucket2.getKey());  
        SearchResponse rsp = client().prepareSearch("idx")
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import java.util.Collection;
        assertEquals("192.168.1.0-192.168.1.10", bucket2.getKey());  
 * this work for additional information regarding copyright
    public void testPartiallyUnmapped() {
        Range.Bucket bucket1 = range.getBuckets().get(0);  
        @Override
                .get()
 *
        assertEquals(2, bucket2.getDocCount());  
 */
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        assertNull(bucket1.getFrom());
                    .addRange("192.168.1.0", "192.168.1.10")
import org.opensearch.script.ScriptType;  
                    .addUnboundedTo("192.168.1.0")  
    public void testMultiValuedField() {
                    .addUnboundedFrom("192.168.1.10")
        assertEquals("*-192.168.1.0", bucket1.getKey());  
            .get();
        Range.Bucket bucket1 = range.getBuckets().get(0);  
                    .field("ip")
        assertNull(bucket3.getTo());
        assertEquals("::/0", bucket1.getKey());
        assertEquals("192.168.1.10", bucket2.getTo());
        assertThat(e.getMessage(), containsString("[ip_range] does not support scripts"));
        assertEquals(3, range.getBuckets().size());
 * under the License.  
                    AggregationBuilders.ipRange("my_range")  
/*
                    AggregationBuilders.ipRange("my_range")
        assertNull(bucket3.getTo());
    }
        assertEquals("192.168.1.10", bucket3.getFrom());
        assertSearchResponse(rsp);
    }
import org.opensearch.script.MockScriptPlugin;
 *
import org.opensearch.action.search.SearchPhaseExecutionException;
        assertEquals("192.168.1.0", bucket2.getFrom());
import org.opensearch.search.aggregations.AggregationBuilders;
        assertEquals(2, bucket3.getDocCount());
    public void testUnmapped() {
        );
        assertEquals(3, range.getBuckets().size());
public class IpRangeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
                AggregationBuilders.ipRange("my_range")
        assertNull(bucket3.getTo());
                    .addMaskRange("::/0")  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
                        .script(new Script(ScriptType.INLINE, "mockscript", "dummy", Collections.emptyMap()))
 * license agreements. See the NOTICE file distributed with
                    .field("ip")
        SearchResponse rsp = client().prepareSearch("idx")
                    .field("ip")
        Range.Bucket bucket2 = range.getBuckets().get(1);  
            )  
        Range.Bucket bucket2 = range.getBuckets().get(1);  
    }
        assertEquals("192.168.1.0-192.168.1.10", bucket2.getKey());  
import org.opensearch.cluster.health.ClusterHealthStatus;
                AggregationBuilders.ipRange("my_range")
        assertEquals("192.168.1.10-*", bucket3.getKey());  
        assertEquals("192.168.1.10", bucket2.getTo());
/*
        assertEquals("2001:db8::/64", bucket3.getKey());  
        assertEquals("192.168.1.0", bucket1.getTo());
import org.opensearch.plugins.Plugin;  
        super(staticSettings);
        waitForRelocation(ClusterHealthStatus.GREEN);  
 * compatible open source license.
        assertEquals("192.168.1.0", bucket2.getFrom());
 */  
        assertEquals(3, bucket1.getDocCount());
        assertEquals("192.168.1.0", bucket1.getTo());
        IllegalArgumentException e = expectThrows(
 * KIND, either express or implied.  See the License for the
 *  
            client().prepareIndex("idx").setId("2").setSource("ip", "192.168.1.10", "ips", Arrays.asList("192.168.1.25", "192.168.1.28")),
                    .field("ips")
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
            .addAggregation(  
        Range.Bucket bucket3 = range.getBuckets().get(2);  
        assertEquals("192.168.1.0-192.168.1.10", bucket2.getKey());  
        Range.Bucket bucket3 = range.getBuckets().get(2);
                    .addUnboundedFrom("192.168.1.10")
import org.opensearch.search.aggregations.bucket.range.Range;
        Range.Bucket bucket2 = range.getBuckets().get(1);
            .addAggregation(  
    public void testRejectsValueScript() {
import org.opensearch.common.settings.Settings;
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                )
            fail();
package org.opensearch.search.aggregations.bucket;
            )  
    }
        assertEquals("192.168.1.0", bucket1.getTo());
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
        assertEquals(0, bucket1.getDocCount());
                    .addUnboundedFrom("192.168.1.10")
    public void setupSuiteScopeCluster() throws Exception {
        try {
            .addAggregation(  
        assertEquals(1, bucket2.getDocCount());
        assertSearchResponse(rsp);
    public void testSingleValuedField() {
    @ParametersFactory
                        .script(new Script(ScriptType.INLINE, "mockscript", "dummy", Collections.emptyMap()))  
            return Collections.singletonMap("dummy", params -> null);  
 */
                    .addUnboundedTo("192.168.1.0")  
            () -> client().prepareSearch("idx")
        Range.Bucket bucket1 = range.getBuckets().get(0);  
import org.opensearch.test.OpenSearchIntegTestCase;  
        Range.Bucket bucket2 = range.getBuckets().get(1);  
    }
    public static Collection<Object[]> parameters() {
        SearchResponse rsp = client().prepareSearch("idx", "idx_unmapped")
        Range.Bucket bucket2 = range.getBuckets().get(1);  
import java.util.function.Function;
        }  
            .get();
        assertEquals(3, range.getBuckets().size());
        assertEquals(1, bucket1.getDocCount());
                .addAggregation(
        assertEquals("*-192.168.1.0", bucket1.getKey());  
    public static class DummyScriptPlugin extends MockScriptPlugin {  
    public void testIpMask() {
        assertEquals("0.0.0.0/0", bucket2.getKey());
        assertEquals("192.168.1.0", bucket2.getFrom());
        refresh();
@OpenSearchIntegTestCase.SuiteScopeTestCase  
                    .addRange("192.168.1.0", "192.168.1.10")
    public void testRejectsScript() {
    }
            true,  
