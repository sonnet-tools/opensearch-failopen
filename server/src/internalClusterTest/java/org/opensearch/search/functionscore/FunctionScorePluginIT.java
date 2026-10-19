    }
            .get();
            super(fieldName, functionBytes);  
import org.opensearch.index.query.functionscore.DecayFunctionParser;
 */  
            LinearMultScoreFunction() {}
        }  
package org.opensearch.search.functionscore;
import org.opensearch.search.SearchHits;
 * not use this file except in compliance with the License.
                    .endObject()
        client().admin()
import org.opensearch.core.common.bytes.BytesReference;  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.action.search.SearchType;
        assertThat(sh.getAt(1).getId(), equalTo("2"));  
import org.opensearch.test.hamcrest.OpenSearchAssertions;  
            )
        );
    }
            }
        CustomDistanceScoreBuilder(String fieldName, BytesReference functionBytes) {
    public static Collection<Object[]> parameters() {
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.plugins.SearchPlugin;
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
            .prepareCreate("test")
        public CustomDistanceScoreBuilder(String fieldName, Object origin, Object scale) {
 * Modifications Copyright OpenSearch Contributors. See
        private static class LinearMultScoreFunction implements DecayFunction {
            );  
            .setMapping(
 */  
import org.opensearch.core.common.io.stream.StreamInput;
            super(fieldName, origin, scale, null);
        SearchHits sh = sr.getHits();
        public static final String NAME = "linear_mult";
 * GitHub history for details.
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        }
public class FunctionScorePluginIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
                    .endObject()
import org.opensearch.plugins.Plugin;  
 * Unless required by applicable law or agreed to in writing,
    public FunctionScorePluginIT(Settings staticSettings) {
                return Explanation.match((float) distanceVal, "" + distanceVal);  
    public void testPlugin() throws Exception {
import java.util.List;
/*
 *  
        super(staticSettings);  
        ).actionGet();
                    .field("type", "date")  
                    .startObject("test")
import org.opensearch.common.action.ActionFuture;
import java.util.Collection;
        ).actionGet();
import java.io.IOException;
            }  
import static java.util.Collections.singletonList;
        }
         */
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;  
 * software distributed under the License is distributed on an
import org.opensearch.index.query.functionscore.ScoreFunctionParser;
        public List<ScoreFunctionSpec<?>> getScoreFunctions() {  
        );
            public double processScale(double userGivenScale, double userGivenValue) {
import org.opensearch.index.query.functionscore.DecayFunction;
 * compatible open source license.
        OpenSearchAssertions.assertNoFailures(sr);
        public DecayFunction getDecayFunction() {
                    .field("type", "text")  
        );
 * SPDX-License-Identifier: Apache-2.0
            public double evaluate(double value, double scale) {
                    .startObject("properties")
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
        client().admin().indices().prepareRefresh().get();  
import org.opensearch.common.Priority;  
            return singletonList(
        SearchResponse sr = response.actionGet();  
    }
            @Override
    @ParametersFactory  
        @Override  
        indexRandomForConcurrentSearch("test");
    public static class CustomDistanceScoreBuilder extends DecayFunctionBuilder<CustomDistanceScoreBuilder> {
        public static final ScoreFunctionParser<CustomDistanceScoreBuilder> PARSER = new DecayFunctionParser<>(  
                return userGivenScale;
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Settings;
            indexRequest("test").id("1").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-26").endObject())  
        @Override
            .indices()  
            CustomDistanceScoreBuilder::new
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        }  
        DecayFunctionBuilder<?> gfb = new CustomDistanceScoreBuilder("num1", "2013-05-28", "+1d");
            return decayFunction;
 * KIND, either express or implied.  See the License for the
                return value;
            public Explanation explainFunction(String distanceString, double distanceVal, double scale, String functionName) {
    }
 * specific language governing permissions and limitations
 *
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.opensearch.index.query.QueryBuilders.termQuery;
    }  
                    .endObject()
                    .endObject()  
        private static final DecayFunction decayFunction = new LinearMultScoreFunction();
 *    http://www.apache.org/licenses/LICENSE-2.0
        assertThat(sh.getAt(0).getId(), equalTo("1"));
import static org.hamcrest.Matchers.equalTo;  
 * this file be licensed under the Apache-2.0 license or a
        public String getName() {
                    .startObject("num1")
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;  
 * You may obtain a copy of the License at  
import org.opensearch.action.search.SearchResponse;
import static org.opensearch.transport.client.Requests.indexRequest;
 * The OpenSearch Contributors require contributions made to  
            super(in);
import org.apache.lucene.search.Explanation;  
            }
 */
        }
        return Arrays.asList(CustomDistanceScorePlugin.class);
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;  
import static org.opensearch.transport.client.Requests.searchRequest;
    public static class CustomDistanceScorePlugin extends Plugin implements SearchPlugin {
        ActionFuture<SearchResponse> response = client().search(
        CustomDistanceScoreBuilder(StreamInput in) throws IOException {  
        }
        assertThat(sh.getHits().length, equalTo(2));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-27").endObject())  
 *
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1)
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForYellowStatus().get();  
            @Override  
/*  
         * Read from a stream.
    protected Collection<Class<? extends Plugin>> nodePlugins() {  
        }
                jsonBuilder().startObject()  
        client().index(
 * under the License.  
import org.opensearch.index.query.functionscore.DecayFunctionBuilder;  
    @Override
            @Override
        return Arrays.asList(
        client().index(
                .source(searchSource().explain(false).query(functionScoreQuery(termQuery("test", "value"), gfb)))  
}  
        /**  
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
        @Override
/*  
            return NAME;  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.Arrays;  
 * ownership. Elasticsearch licenses this file to you under  
                new ScoreFunctionSpec<>(CustomDistanceScoreBuilder.NAME, CustomDistanceScoreBuilder::new, CustomDistanceScoreBuilder.PARSER)
