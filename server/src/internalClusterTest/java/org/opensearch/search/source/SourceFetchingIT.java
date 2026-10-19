    public void testSourceFiltering() throws InterruptedException {  
        indexRandomForConcurrentSearch("test");  
 * under the License.  
        response = client().prepareSearch("test").setFetchSource(new String[] { "*" }, new String[] { "field2" }).get();
 * The OpenSearch Contributors require contributions made to  
    /**  
 * Licensed to Elasticsearch under one or more contributor  
    public void testSourceWithWildcardFiltering() throws InterruptedException {
        ensureGreen();
 * specific language governing permissions and limitations
        index("test", "type1", "1", "field", "value");  
        ensureGreen();
        createIndex("test");
        client().prepareIndex("test").setId("1").setSource("field1", "value", "field2", "value2").get();
        assertThat(response.getHits().getAt(0).getSourceAsString(), notNullValue());  
     */  
        createIndex("test");  
        response = client().prepareSearch("test").addStoredField("_source").get();
    @ParametersFactory  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },  
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());  
        super(staticSettings);  
        assertThat(response.getHits().getAt(0).getSourceAsMap().size(), equalTo(1));
    public static Collection<Object[]> parameters() {
        assertThat((String) response.getHits().getAt(0).getSourceAsMap().get("field1"), equalTo("value"));
 * compatible open source license.
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
        createIndex("test");
     * Test Case for #5132: Source filtering with wildcards broken when given multiple patterns
        client().prepareIndex("test").setId("1").setSource("field", "value").get();
import java.util.Arrays;
 * software distributed under the License is distributed on an
        response = client().prepareSearch("test").setFetchSource("field1", null).get();
 * SPDX-License-Identifier: Apache-2.0
    }
        response = client().prepareSearch("test").setFetchSource("hello", null).get();
    public void testSourceDefaultBehavior() throws InterruptedException {
        assertThat(response.getHits().getAt(0).getSourceAsMap().size(), equalTo(0));  
 * not use this file except in compliance with the License.
        assertThat(response.getHits().getAt(0).getSourceAsString(), notNullValue());  
        assertThat((String) response.getHits().getAt(0).getSourceAsMap().get("field1"), equalTo("value"));
 * the Apache License, Version 2.0 (the "License"); you may
 * You may obtain a copy of the License at  
        SearchResponse response = client().prepareSearch("test").setFetchSource(false).get();
        assertThat(response.getHits().getAt(0).getSourceAsMap().size(), equalTo(1));
import static org.hamcrest.Matchers.nullValue;  
    }  
        assertThat(response.getHits().getAt(0).getSourceAsString(), notNullValue());
        ensureGreen();  
 *
 * KIND, either express or implied.  See the License for the
 */  
        assertThat((String) response.getHits().getAt(0).getSourceAsMap().get("field"), equalTo("value"));  
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
import org.opensearch.action.search.SearchResponse;  
        SearchResponse response = client().prepareSearch("test").get();
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());
     * https://github.com/elastic/elasticsearch/issues/5132
        assertThat(response.getHits().getAt(0).getSourceAsMap().size(), equalTo(1));
        return Arrays.asList(
        assertThat(response.getHits().getAt(0).getSourceAsString(), notNullValue());
import org.opensearch.common.settings.Settings;
/*
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
        refresh();
        refresh();  
/*  
}
        SearchResponse response = client().prepareSearch("test").setFetchSource(new String[] { "*.notexisting", "field" }, null).get();  
/*  
        assertThat(response.getHits().getAt(0).getSourceAsString(), notNullValue());  
import static org.hamcrest.Matchers.notNullValue;
 * Unless required by applicable law or agreed to in writing,
public class SourceFetchingIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {  
        response = client().prepareSearch("test").setFetchSource(new String[] { "field.notexisting.*", "field" }, null).get();
 * this work for additional information regarding copyright
import java.util.Collection;
package org.opensearch.search.source;
    public SourceFetchingIT(Settings staticSettings) {
        assertThat(response.getHits().getAt(0).getSourceAsString(), notNullValue());  
        assertThat(response.getHits().getAt(0).getSourceAsString(), notNullValue());
import static org.hamcrest.core.IsEqual.equalTo;
 *  
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
 * this file be licensed under the Apache-2.0 license or a
        response = client().prepareSearch("test").setFetchSource(true).get();
    }
        );
 */
        assertThat(response.getHits().getAt(0).getSourceAsString(), notNullValue());
        response = client().prepareSearch("test").addStoredField("bla").get();
 * GitHub history for details.
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 * license agreements. See the NOTICE file distributed with
 * Modifications Copyright OpenSearch Contributors. See
        assertThat((String) response.getHits().getAt(0).getSourceAsMap().get("field"), equalTo("value"));
    }
        indexRandomForConcurrentSearch("test");
        refresh();
        indexRandomForConcurrentSearch("test");
 */  
        assertThat(response.getHits().getAt(0).getSourceAsMap().size(), equalTo(1));
