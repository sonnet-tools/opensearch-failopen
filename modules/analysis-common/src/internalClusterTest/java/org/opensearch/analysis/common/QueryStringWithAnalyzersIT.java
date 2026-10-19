        SearchResponse response = client().prepareSearch("test")
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
public class QueryStringWithAnalyzersIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        refresh();
    @Override
 * not use this file except in compliance with the License.
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collection;
 * software distributed under the License is distributed on an
                        .put("analysis.filter.custom_word_delimiter.catenate_numbers", "true")
    protected Collection<Class<? extends Plugin>> nodePlugins() {
    /**  
        );
 * the Apache License, Version 2.0 (the "License"); you may
 *  
        assertHitCount(response, 1L);
        assertAcked(
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 */  
                        .put("analysis.analyzer.my_analyzer.type", "custom")
                    Settings.builder()  
                        .put("analysis.filter.custom_word_delimiter.stem_english_possessive", "false")
        super(staticSettings);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
}  
 * You may obtain a copy of the License at  
 */  
    public static Collection<Object[]> parameters() {  
 * Modifications Copyright OpenSearch Contributors. See
        client().prepareIndex("test").setId("1").setSource("field1", "foo bar baz", "field2", "not needed").get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.plugins.Plugin;  
            .get();  
        );
                .setSettings(
/*
import org.opensearch.common.settings.Settings;
 *
                        .put("analysis.filter.custom_word_delimiter.type", "word_delimiter")
                        .put("analysis.analyzer.my_analyzer.tokenizer", "whitespace")
import static org.opensearch.index.query.QueryBuilders.queryStringQuery;  
    @ParametersFactory
package org.opensearch.analysis.common;
import java.util.Arrays;  
    }
 * GitHub history for details.
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;  
            .setQuery(queryStringQuery("foo.baz").defaultOperator(Operator.AND).field("field1").field("field2"))
        return Arrays.asList(CommonAnalysisModulePlugin.class);  
                )  
                        .put("analysis.filter.custom_word_delimiter.catenate_words", "false")
import org.opensearch.action.search.SearchResponse;  
                        .put("analysis.filter.custom_word_delimiter.split_on_case_change", "false")  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * KIND, either express or implied.  See the License for the
 *
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
                .setMapping("field1", "type=text,analyzer=my_analyzer", "field2", "type=text,analyzer=my_analyzer")
/*  
 * under the License.  
import org.opensearch.index.query.Operator;
    }  
                .prepareCreate("test")
    public void testCustomWordDelimiterQueryString() {  
            client().admin()
                        .put("analysis.filter.custom_word_delimiter.generate_number_parts", "false")  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }  
    }
 * compatible open source license.
 * this work for additional information regarding copyright
                .indices()  
 */
    public QueryStringWithAnalyzersIT(Settings staticSettings) {
/*  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
     */
        return Arrays.asList(
                        .put("analysis.filter.custom_word_delimiter.generate_word_parts", "true")
    }
     * Validates that we properly split fields using the word delimiter filter in query_string.
                        .put("analysis.analyzer.my_analyzer.filter", "custom_word_delimiter")  
                        .put("analysis.filter.custom_word_delimiter.split_on_numerics", "false")
