        assertEquals(1, bucket2.getDocCount());
        assertEquals(1, bucket2.getDocCount());  
    }
                return doc.get("ip");
            .get();
        @Override
            });
    public void testScriptValues() throws Exception {
        protected Map<String, Function<Map<String, Object>, Object>> pluginScripts() {
            client().prepareIndex("index").setId("4").setSource("not_ip", "something")
        indexRandom(
            client().prepareIndex("index").setId("3").setSource("ip", "2001:db8::2:1")
 */
import org.opensearch.index.fielddata.ScriptDocValues;
import java.util.Map;  
 * license agreements. See the NOTICE file distributed with
    }
        assertEquals("192.168.1.7", bucket1.getKeyAsString());  
    }
        assertAcked(prepareCreate("index").setMapping("ip", "type=ip"));
}  
        assertEquals("192.168.1.7", bucket1.getKey());
 * ownership. Elasticsearch licenses this file to you under  
        assertEquals(2, terms.getBuckets().size());
        Terms.Bucket bucket2 = terms.getBuckets().get(1);
    public IpTermsIT(Settings staticSettings) {
            client().prepareIndex("index").setId("3").setSource("ip", "2001:db8::2:1")
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['ip'].value", Collections.emptyMap());
 * software distributed under the License is distributed on an
        assertAcked(prepareCreate("index").setMapping("ip", "type=ip"));
            client().prepareIndex("index").setId("2").setSource("ip", "192.168.1.7"),  
        assertSearchResponse(response);
        assertEquals("127.0.0.1", bucket1.getKeyAsString());
package org.opensearch.search.aggregations.bucket;
        assertEquals(2, bucket1.getDocCount());
        indexRandom(
        assertEquals("192.168.1.7", bucket2.getKey());  
        Terms.Bucket bucket1 = terms.getBuckets().get(0);
import java.util.Collection;
        );
 * this work for additional information regarding copyright
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            true,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertEquals("2001:db8::2:1", bucket2.getKeyAsString());  
        Terms terms = response.getAggregations().get("my_terms");
        indexRandom(  
 *
        assertEquals("127.0.0.1", bucket1.getKey());
            .addAggregation(AggregationBuilders.terms("my_terms").field("ip").missing("127.0.0.1").executionHint(randomExecutionHint()))
 * the Apache License, Version 2.0 (the "License"); you may
            Map<String, Function<Map<String, Object>, Object>> scripts = super.pluginScripts();  
                return ((ScriptDocValues<?>) doc.get("ip")).get(0);  
import java.util.Collections;
 * under the License.  
import org.opensearch.search.aggregations.AggregationTestScriptsPlugin;
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");  
import org.opensearch.script.ScriptType;
        return Collections.singleton(CustomScriptPlugin.class);
    public void testScriptValue() throws Exception {
 *
        assertSearchResponse(response);  
        );  
                Map<?, ?> doc = (Map<?, ?>) vars.get("doc");
 * You may obtain a copy of the License at  
        assertAcked(prepareCreate("index").setMapping("ip", "type=ip"));  
        assertEquals("2001:db8::2:1", bucket2.getKey());
 * not use this file except in compliance with the License.
    protected Collection<Class<? extends Plugin>> nodePlugins() {
import org.opensearch.search.aggregations.AggregationBuilders;  
 * GitHub history for details.
import org.opensearch.common.settings.Settings;
            client().prepareIndex("index").setId("1").setSource("ip", "192.168.1.7"),  
            .get();
        Script script = new Script(ScriptType.INLINE, CustomScriptPlugin.NAME, "doc['ip']", Collections.emptyMap());
    }  
        Terms.Bucket bucket1 = terms.getBuckets().get(0);  
import org.opensearch.action.search.SearchResponse;  
        assertSearchResponse(response);
 * Unless required by applicable law or agreed to in writing,
            });
            true,  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;  
 * KIND, either express or implied.  See the License for the
            client().prepareIndex("index").setId("1").setSource("ip", "192.168.1.7"),
 * SPDX-License-Identifier: Apache-2.0
        assertEquals(2, terms.getBuckets().size());  
        SearchResponse response = client().prepareSearch("index")
    public void testMissingValue() throws Exception {  
            client().prepareIndex("index").setId("3").setSource("ip", "127.0.0.1"),  
        assertEquals(2, terms.getBuckets().size());
        );
 * Licensed to Elasticsearch under one or more contributor  
        Terms terms = response.getAggregations().get("my_terms");  
        assertEquals("192.168.1.7", bucket1.getKeyAsString());
/*
        Terms.Bucket bucket2 = terms.getBuckets().get(1);  
    @Override  
        assertEquals("192.168.1.7", bucket1.getKey());  
            scripts.put("doc['ip']", vars -> {
 * The OpenSearch Contributors require contributions made to  
        assertEquals(2, bucket2.getDocCount());
/*  
            scripts.put("doc['ip'].value", vars -> {
            .addAggregation(AggregationBuilders.terms("my_terms").script(script).executionHint(randomExecutionHint()))  
        assertEquals(2, bucket1.getDocCount());
        SearchResponse response = client().prepareSearch("index")  
 * Modifications Copyright OpenSearch Contributors. See  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchResponse;
        }
        Terms.Bucket bucket1 = terms.getBuckets().get(0);
 */  
            return scripts;  
        assertEquals("2001:db8::2:1", bucket2.getKeyAsString());
        assertEquals("192.168.1.7", bucket2.getKeyAsString());
            client().prepareIndex("index").setId("2").setSource("ip", "192.168.1.7"),
            .get();
 */
            client().prepareIndex("index").setId("1").setSource("ip", "192.168.1.7"),
    public static class CustomScriptPlugin extends AggregationTestScriptsPlugin {
 * compatible open source license.
 * specific language governing permissions and limitations
        assertEquals(2, bucket1.getDocCount());  
import java.util.function.Function;
            client().prepareIndex("index").setId("2").setSource("ip", "192.168.1.7"),
    }
import org.opensearch.plugins.Plugin;  
import org.opensearch.search.aggregations.bucket.terms.Terms;
            true,
public class IpTermsIT extends AbstractTermsTestCase {  
        assertEquals("2001:db8::2:1", bucket2.getKey());
        super(staticSettings);  
/*
 *  
import org.opensearch.script.Script;
        Terms terms = response.getAggregations().get("my_terms");
            .addAggregation(AggregationBuilders.terms("my_terms").script(script).executionHint(randomExecutionHint()))
        SearchResponse response = client().prepareSearch("index")  
        Terms.Bucket bucket2 = terms.getBuckets().get(1);
 * this file be licensed under the Apache-2.0 license or a
