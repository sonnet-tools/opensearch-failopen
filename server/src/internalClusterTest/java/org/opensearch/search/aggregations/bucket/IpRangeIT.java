            .addAggregation(
        assertEquals("192.168.1.0-192.168.1.10", bucket2.getKey());
        super(staticSettings);
 * KIND, either express or implied.  See the License for the
                    .addUnboundedTo("192.168.1.0")
import org.opensearch.search.aggregations.AggregationBuilders;
            .get();
            client().prepareIndex("idx").setId("1").setSource("ip", "192.168.1.7", "ips", Arrays.asList("192.168.0.13", "192.168.1.2")),
        assertEquals("*-192.168.1.0", bucket1.getKey());
    public void testSingleValuedField() {
 * GitHub history for details.
        return Arrays.asList(DummyScriptPlugin.class);
            Throwable rootCause = spee.getCause().getCause();
        assertEquals(3, range.getBuckets().size());
import org.opensearch.script.MockScriptPlugin;
        assertNull(bucket1.getFrom());
import org.opensearch.cluster.health.ClusterHealthStatus;
    }
 * software distributed under the License is distributed on an
                    .addMaskRange("2001:db8::/64")
    @Override
        assertEquals("192.168.1.0", bucket1.getTo());
            )
        Range.Bucket bucket1 = range.getBuckets().get(0);
        assertEquals(1, bucket3.getDocCount());
        waitForRelocation(ClusterHealthStatus.GREEN);
        assertEquals("192.168.1.10", bucket2.getTo());
            )
        );
        SearchResponse rsp = client().prepareSearch("idx")
    public void testMultiValuedField() {
            () -> client().prepareSearch("idx")
        Range.Bucket bucket3 = range.getBuckets().get(2);
        Range.Bucket bucket3 = range.getBuckets().get(2);
}
    }
        assertEquals("*-192.168.1.0", bucket1.getKey());
        assertEquals("*-192.168.1.0", bucket1.getKey());
        assertEquals(2, bucket2.getDocCount());
        Range.Bucket bucket2 = range.getBuckets().get(1);
        assertNull(bucket1.getFrom());
        assertEquals(0, bucket2.getDocCount());
        assertEquals("192.168.1.0-192.168.1.10", bucket2.getKey());
            )
    @Override
        assertEquals("192.168.1.10", bucket3.getFrom());
    }
import org.opensearch.search.aggregations.bucket.range.Range;
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
                    AggregationBuilders.ipRange("my_range")
            )
package org.opensearch.search.aggregations.bucket;
        IllegalArgumentException e = expectThrows(
        @Override
        );
            .get();
        }
            client().prepareIndex("idx").setId("2").setSource("ip", "192.168.1.10", "ips", Arrays.asList("192.168.1.25", "192.168.1.28")),
        Range.Bucket bucket1 = range.getBuckets().get(0);
 * The OpenSearch Contributors require contributions made to
        assertEquals("192.168.1.10-*", bucket3.getKey());
    }
 *
    }
        Range range = rsp.getAggregations().get("my_range");
                    .field("ips")
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
                AggregationBuilders.ipRange("my_range")
    @ParametersFactory
        assertEquals("192.168.1.10-*", bucket3.getKey());
        assertEquals("192.168.1.0-192.168.1.10", bucket2.getKey());
public class IpRangeIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        assertEquals("192.168.1.0", bucket2.getFrom());
        assertEquals("192.168.1.10", bucket2.getTo());
        assertEquals("192.168.1.10", bucket3.getFrom());
        assertSearchResponse(rsp);
import org.opensearch.common.settings.Settings;
            assertEquals(rootCause.getMessage(), "No [ranges] specified for the [my_range] aggregation");
            assertThat(rootCause, instanceOf(IllegalArgumentException.class));
                AggregationBuilders.ipRange("my_range")
                    .addMaskRange("::/0")
        public Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
        SearchResponse rsp = client().prepareSearch("idx", "idx_unmapped")
                    .addUnboundedFrom("192.168.1.10")
        assertEquals("192.168.1.0", bucket1.getTo());
        );
        assertEquals(3, range.getBuckets().size());
        assertEquals("192.168.1.0-192.168.1.10", bucket2.getKey());
            return Collections.singletonMap("dummy", params -> null);
        return Arrays.asList(
                )
 * license agreements. See the NOTICE file distributed with
/*
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
import org.opensearch.action.search.SearchResponse;
            )
 */
        assertThat(e.getMessage(), containsString("[ip_range] does not support scripts"));
        assertEquals("192.168.1.10", bucket3.getFrom());
                .setId("3")
        Range.Bucket bucket2 = range.getBuckets().get(1);
 * Unless required by applicable law or agreed to in writing,
        Range.Bucket bucket2 = range.getBuckets().get(1);
                AggregationBuilders.ipRange("my_range")
 *
        Range.Bucket bucket1 = range.getBuckets().get(0);
        assertSearchResponse(rsp);
            .get();
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor
                .setSource("ip", "2001:db8::ff00:42:8329", "ips", Arrays.asList("2001:db8::ff00:42:8329", "2001:db8::ff00:42:8380"))
        SearchResponse rsp = client().prepareSearch("idx")
                )
        assertNull(bucket1.getFrom());
    public void testIpMask() {
    }
        waitForRelocation(ClusterHealthStatus.GREEN);
        Range range = rsp.getAggregations().get("my_range");
            .addAggregation(
        assertThat(e.getMessage(), containsString("[ip_range] does not support scripts"));
    }
    public static class DummyScriptPlugin extends MockScriptPlugin {
                    .field("ip")
import org.opensearch.test.OpenSearchIntegTestCase;
@OpenSearchIntegTestCase.SuiteScopeTestCase
        assertEquals(0, bucket1.getDocCount());
    public void setupSuiteScopeCluster() throws Exception {
        assertEquals("192.168.1.10-*", bucket3.getKey());
        assertEquals(1, bucket1.getDocCount());
        assertEquals(3, range.getBuckets().size());
        assertEquals("192.168.1.10", bucket2.getTo());
        assertEquals("192.168.1.10", bucket2.getTo());
        assertEquals(0, bucket1.getDocCount());
                    .addUnboundedTo("192.168.1.0")
        assertEquals(2, bucket3.getDocCount());
        assertEquals("0.0.0.0/0", bucket2.getKey());
                .addAggregation(
/*
        assertNull(bucket3.getTo());
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Range range = rsp.getAggregations().get("my_range");
                        .script(new Script(ScriptType.INLINE, "mockscript", "dummy", Collections.emptyMap()))
                    .addRange("192.168.1.0", "192.168.1.10")
import java.util.Map;
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under
                    .field("ip")
                    .addRange("192.168.1.0", "192.168.1.10")
            client().prepareIndex("idx")
        assertEquals("192.168.1.0", bucket1.getTo());
        } catch (SearchPhaseExecutionException spee) {
import org.opensearch.script.Script;
                    .addUnboundedTo("192.168.1.0")
                    .addUnboundedFrom("192.168.1.10")
    public IpRangeIT(Settings staticSettings) {
                    .field("ip")
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertNull(bucket1.getFrom());
    public void testUnmapped() {
                    .addRange("192.168.1.0", "192.168.1.10")
    public void testRejectsValueScript() {
import static org.hamcrest.Matchers.containsString;
            IllegalArgumentException.class,
import org.opensearch.script.ScriptType;
    public void testPartiallyUnmapped() {
    }
import java.util.Collection;
        assertEquals("*-192.168.1.0", bucket1.getKey());
                    .addUnboundedTo("192.168.1.0")
        try {
        assertSearchResponse(rsp);
            fail();
                    .addRange("192.168.1.0", "192.168.1.10")
        assertSearchResponse(rsp);
        assertEquals("2001:db8::/64", bucket3.getKey());
            .addAggregation(
            .addAggregation(
 * the Apache License, Version 2.0 (the "License"); you may
            .addAggregation(
                    .field("ips")
        Range range = rsp.getAggregations().get("my_range");
        Range.Bucket bucket3 = range.getBuckets().get(2);
import org.opensearch.plugins.Plugin;
        Range.Bucket bucket1 = range.getBuckets().get(0);
        assertEquals(0, bucket3.getDocCount());
        assertEquals(1, bucket2.getDocCount());
                        .field("ip")
        assertNull(bucket3.getTo());
    protected Collection<Class<? extends Plugin>> nodePlugins() {
 *    http://www.apache.org/licenses/LICENSE-2.0
        Range.Bucket bucket3 = range.getBuckets().get(2);
 * this work for additional information regarding copyright
        Range.Bucket bucket1 = range.getBuckets().get(0);
        SearchResponse rsp = client().prepareSearch("idx")
 * compatible open source license.
        assertEquals(3, range.getBuckets().size());
        Range.Bucket bucket2 = range.getBuckets().get(1);
            true,
 * You may obtain a copy of the License at
        assertEquals(1, bucket2.getDocCount());
    }
                AggregationBuilders.ipRange("my_range")
 *
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        assertAcked(prepareCreate("idx").setMapping("ip", "type=ip", "ips", "type=ip"));
        assertNull(bucket3.getTo());
            IllegalArgumentException.class,
                .get()
        assertEquals(3, bucket1.getDocCount());
        SearchResponse rsp = client().prepareSearch("idx_unmapped")
        Range.Bucket bucket2 = range.getBuckets().get(1);
 */
    }
import java.util.function.Function;
        Range range = rsp.getAggregations().get("my_range");
                    .addUnboundedFrom("192.168.1.10")
                AggregationBuilders.ipRange("my_range")
        assertEquals("::/0", bucket1.getKey());
 * Modifications Copyright OpenSearch Contributors. See
        assertSearchResponse(rsp);
                .get()
    }
            .get();
    public void testRejectsScript() {
        assertAcked(prepareCreate("idx_unmapped"));
import static org.hamcrest.Matchers.instanceOf;
import java.util.Arrays;
        assertEquals("192.168.1.0", bucket2.getFrom());
        indexRandom(
 * not use this file except in compliance with the License.
 */
        assertEquals("192.168.1.10-*", bucket3.getKey());
        refresh();
            () -> client().prepareSearch("idx")
    }
        assertEquals(2, bucket3.getDocCount());
        IllegalArgumentException e = expectThrows(
        );
        assertEquals(3, range.getBuckets().size());
                        .script(new Script(ScriptType.INLINE, "mockscript", "dummy", Collections.emptyMap()))
        assertEquals(0, bucket1.getDocCount());
        assertEquals("192.168.1.10", bucket3.getFrom());
                .addAggregation(
 * under the License.
                    AggregationBuilders.ipRange("my_range")
    public static Collection<Object[]> parameters() {
        assertEquals("192.168.1.0", bucket2.getFrom());
        assertEquals(1, bucket2.getDocCount());
            .get();
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        }
                    .addUnboundedFrom("192.168.1.10")
            client().prepareSearch("idx").addAggregation(AggregationBuilders.ipRange("my_range").field("ip")).get();
 * SPDX-License-Identifier: Apache-2.0
    }
        assertNull(bucket3.getTo());
import org.opensearch.action.search.SearchPhaseExecutionException;
        assertEquals("192.168.1.0", bucket2.getFrom());
        assertEquals(2, bucket3.getDocCount());
import java.util.Collections;
                    .addMaskRange("0.0.0.0/0")
        Range.Bucket bucket3 = range.getBuckets().get(2);
/*
    public void testNoRangesInQuery() {
        assertEquals("192.168.1.0", bucket1.getTo());
