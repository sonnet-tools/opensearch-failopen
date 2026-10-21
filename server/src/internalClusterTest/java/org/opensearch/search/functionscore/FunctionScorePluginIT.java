        CustomDistanceScoreBuilder(StreamInput in) throws IOException {
import static java.util.Collections.singletonList;
public class FunctionScorePluginIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
}
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 */
        public List<ScoreFunctionSpec<?>> getScoreFunctions() {
        return Arrays.asList(CustomDistanceScorePlugin.class);
                    .field("type", "text")
 * software distributed under the License is distributed on an
            );
 * GitHub history for details.
                    .startObject("num1")
import org.opensearch.index.query.functionscore.DecayFunctionBuilder;
        ActionFuture<SearchResponse> response = client().search(
        assertThat(sh.getAt(0).getId(), equalTo("1"));
import static org.opensearch.transport.client.Requests.searchRequest;
                return userGivenScale;
    }
import org.opensearch.common.action.ActionFuture;
        return Arrays.asList(
 * Modifications Copyright OpenSearch Contributors. See
            searchRequest().searchType(SearchType.QUERY_THEN_FETCH)
                    .field("type", "date")
import org.apache.lucene.search.Explanation;
                    .endObject()
 * KIND, either express or implied.  See the License for the
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        client().admin()
        @Override
 * The OpenSearch Contributors require contributions made to
            CustomDistanceScoreBuilder::new
            public double evaluate(double value, double scale) {
import org.opensearch.test.OpenSearchIntegTestCase.ClusterScope;
    public FunctionScorePluginIT(Settings staticSettings) {
                new ScoreFunctionSpec<>(CustomDistanceScoreBuilder.NAME, CustomDistanceScoreBuilder::new, CustomDistanceScoreBuilder.PARSER)
        SearchResponse sr = response.actionGet();
import org.opensearch.test.hamcrest.OpenSearchAssertions;
 *
import static org.opensearch.search.builder.SearchSourceBuilder.searchSource;
        public CustomDistanceScoreBuilder(String fieldName, Object origin, Object scale) {
    }
        ).actionGet();
 */
        ).actionGet();
        );
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
import java.io.IOException;
        client().index(
        }
            return NAME;
import org.opensearch.plugins.SearchPlugin;
 * Unless required by applicable law or agreed to in writing,
                return Explanation.match((float) distanceVal, "" + distanceVal);
    }
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    public static class CustomDistanceScoreBuilder extends DecayFunctionBuilder<CustomDistanceScoreBuilder> {
import static org.opensearch.transport.client.Requests.indexRequest;
    @ParametersFactory
        @Override
import org.opensearch.core.common.io.stream.StreamInput;
/*
import java.util.Collection;
                    .startObject("properties")
            LinearMultScoreFunction() {}
                    .endObject()
                    .endObject()
         * Read from a stream.
import org.opensearch.index.query.functionscore.ScoreFunctionParser;
        }
import org.opensearch.action.search.SearchResponse;
import org.opensearch.search.SearchHits;
        client().admin().indices().prepareRefresh().get();
 * this work for additional information regarding copyright
            indexRequest("test").id("2").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-27").endObject())
        );
        private static class LinearMultScoreFunction implements DecayFunction {
        public DecayFunction getDecayFunction() {
import org.opensearch.core.common.bytes.BytesReference;
 * You may obtain a copy of the License at
            super(fieldName, origin, scale, null);
    @Override
import org.opensearch.test.OpenSearchIntegTestCase.Scope;
                return value;
 * ownership. Elasticsearch licenses this file to you under
        public static final String NAME = "linear_mult";
import static org.opensearch.common.xcontent.XContentFactory.jsonBuilder;
    public static Collection<Object[]> parameters() {
        DecayFunctionBuilder<?> gfb = new CustomDistanceScoreBuilder("num1", "2013-05-28", "+1d");
            super(in);
        OpenSearchAssertions.assertNoFailures(sr);
 * Licensed to Elasticsearch under one or more contributor
/*
import static org.hamcrest.Matchers.equalTo;
            .setMapping(
            public Explanation explainFunction(String distanceString, double distanceVal, double scale, String functionName) {
import java.util.Arrays;
        CustomDistanceScoreBuilder(String fieldName, BytesReference functionBytes) {
import org.opensearch.common.settings.Settings;
        client().index(
            .prepareCreate("test")
import static org.opensearch.index.query.QueryBuilders.functionScoreQuery;
            @Override
            }
import org.opensearch.plugins.Plugin;
 * license agreements. See the NOTICE file distributed with
            return singletonList(
        public static final ScoreFunctionParser<CustomDistanceScoreBuilder> PARSER = new DecayFunctionParser<>(
import static org.opensearch.index.query.QueryBuilders.termQuery;
            .indices()
    }
            }
import org.opensearch.common.Priority;
        public String getName() {
            indexRequest("test").id("1").source(jsonBuilder().startObject().field("test", "value").field("num1", "2013-05-26").endObject())
            }
                jsonBuilder().startObject()
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
import org.opensearch.action.search.SearchType;
package org.opensearch.search.functionscore;
        /**
@ClusterScope(scope = Scope.SUITE, supportsDedicatedMasters = false, numDataNodes = 1)
 *
/*
                .source(searchSource().explain(false).query(functionScoreQuery(termQuery("test", "value"), gfb)))
            super(fieldName, functionBytes);
        assertThat(sh.getHits().length, equalTo(2));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
        }
        SearchHits sh = sr.getHits();
        }
 * compatible open source license.
import org.opensearch.index.query.functionscore.DecayFunction;
            return decayFunction;
 * specific language governing permissions and limitations
        private static final DecayFunction decayFunction = new LinearMultScoreFunction();
    protected Collection<Class<? extends Plugin>> nodePlugins() {
        assertThat(sh.getAt(1).getId(), equalTo("2"));
                    .startObject("test")
        }
        super(staticSettings);
 *
            @Override
         */
                    .endObject()
        }
import org.opensearch.index.query.functionscore.DecayFunctionParser;
    }
        client().admin().cluster().prepareHealth().setWaitForEvents(Priority.LANGUID).setWaitForYellowStatus().get();
    }
            @Override
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        @Override
 */
 * this file be licensed under the Apache-2.0 license or a
            public double processScale(double userGivenScale, double userGivenValue) {
 * under the License.
    public void testPlugin() throws Exception {
    public static class CustomDistanceScorePlugin extends Plugin implements SearchPlugin {
        );
        indexRandomForConcurrentSearch("test");
 * SPDX-License-Identifier: Apache-2.0
            .get();
import java.util.List;
            )
