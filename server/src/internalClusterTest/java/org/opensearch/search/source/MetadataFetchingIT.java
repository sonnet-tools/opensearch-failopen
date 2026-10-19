import org.opensearch.search.SearchHits;
        }
                    new InnerHitBuilder().setStoredFieldNames(Collections.singletonList("_none_"))
    public void testInnerHits() throws InterruptedException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                IllegalArgumentException.class,
import org.opensearch.common.settings.Settings;  
        response = client().prepareSearch("test").storedFields("_none_").get();
            assertNotNull(rootCause);  
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());
        }  
        assertThat(hits.getAt(0).getSourceAsString(), nullValue());
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
        {  
        indexRandomForConcurrentSearch("test");  
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
            .setQuery(  
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());  
 *  
        response = client().prepareSearch("test").storedFields("_none_").get();  
        SearchResponse response = client().prepareSearch("test").storedFields("_none_").setFetchSource(false).setVersion(true).get();
        {
        client().prepareIndex("test").setId("1").setSource("field", "value").get();
        client().prepareIndex("test").setId("1").setSource("field", "value").setRouting("toto").get();  
        {  
            SearchPhaseExecutionException exc = expectThrows(
        super(staticSettings);
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());
                () -> client().prepareSearch("test").storedFields("_none_", "field1").setVersion(true).get()
 *
    public void testInvalid() {
import org.opensearch.search.fetch.subphase.FetchSourceContext;  
import static org.hamcrest.Matchers.notNullValue;
    }
            assertThat(rootCause.getClass(), equalTo(SearchException.class));
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
import org.opensearch.action.search.SearchResponse;
/*
import java.util.Collections;
            Throwable rootCause = ExceptionsHelper.unwrap(exc, SearchException.class);
import org.opensearch.ExceptionsHelper;  
        assertThat(response.getHits().getAt(0).getVersion(), notNullValue());
                SearchPhaseExecutionException.class,  
    }
import org.opensearch.action.search.SearchPhaseExecutionException;
            );  
 * Licensed to Elasticsearch under one or more contributor  
            assertNotNull(rootCause);
 * The OpenSearch Contributors require contributions made to  
        indexRandomForConcurrentSearch("test");
 * You may obtain a copy of the License at  
        assertAcked(prepareCreate("test"));  
        assertThat(response.getHits().getAt(0).field("_routing"), nullValue());  
        assertThat(response.getHits().getAt(0).getId(), nullValue());
 */  
    }
        assertThat(response.getHits().getAt(0).getId(), nullValue());  
                SearchPhaseExecutionException.class,
        assertAcked(prepareCreate("test"));  
        assertThat(hits.getAt(0).getId(), nullValue());
import static org.hamcrest.Matchers.nullValue;
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
        refresh();
 */
import static org.hamcrest.Matchers.equalTo;  
        assertThat(hits.getTotalHits().value(), equalTo(1L));  
        ensureGreen();
import org.opensearch.index.query.InnerHitBuilder;
package org.opensearch.search.source;
                () -> client().prepareSearch("test").storedFields("_none_").storedFields("field1").setVersion(true).get()  
            Throwable rootCause = ExceptionsHelper.unwrap(exc, SearchException.class);  
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());  
        ensureGreen();
    }  
/*
            .storedFields("_none_")
            assertThat(rootCause.getMessage(), equalTo("[stored_fields] cannot be disabled when using the [fields] option"));  
        assertThat(response.getHits().getAt(0).getId(), nullValue());
            );
        assertAcked(prepareCreate("test"));
                )
 * specific language governing permissions and limitations
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
 * SPDX-License-Identifier: Apache-2.0
    public void testSimple() throws InterruptedException {  
        SearchResponse response = client().prepareSearch("test")  
            IllegalArgumentException exc = expectThrows(
import java.util.Collection;
            assertThat(rootCause.getMessage(), equalTo("[stored_fields] cannot be disabled if [_source] is requested"));
                () -> client().prepareSearch("test").setFetchSource(true).storedFields("_none_").get()  
    }
}
            );
    public MetadataFetchingIT(Settings staticSettings) {  
 * this file be licensed under the Apache-2.0 license or a
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 *
            );
        }  
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.search.join.ScoreMode;
                new NestedQueryBuilder("nested", new TermQueryBuilder("nested.title", "foo"), ScoreMode.Total).innerHit(
            assertThat(exc.getMessage(), equalTo("cannot combine _none_ with other fields"));
        refresh();
 * Modifications Copyright OpenSearch Contributors. See  
            .get();  
import org.opensearch.search.SearchException;
            .setFetchSource(false)
            IllegalArgumentException exc = expectThrows(  
        );  
        }
            assertThat(rootCause.getClass(), equalTo(SearchException.class));
        assertThat(response.getHits().getAt(0).getId(), nullValue());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
        return Arrays.asList(  
public class MetadataFetchingIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
        ensureGreen();
/*  
                IllegalArgumentException.class,
        ensureGreen();
        refresh();
        {
 */
            assertThat(exc.getMessage(), equalTo("cannot combine _none_ with other fields"));
            SearchPhaseExecutionException exc = expectThrows(
        refresh();
    public void testWithRouting() throws InterruptedException {
        SearchResponse response = client().prepareSearch("test").storedFields("_none_").setFetchSource(false).get();
            )
    @ParametersFactory
 * compatible open source license.
        SearchHits hits = response.getHits().getAt(0).getInnerHits().get("nested");
        assertThat(response.getHits().getAt(0).getId(), nullValue());
        index("test", "type1", "1", "field", "value");  
 * software distributed under the License is distributed on an
    }  
                () -> client().prepareSearch("test").storedFields("_none_").addFetchField("field").get()
        assertAcked(prepareCreate("test").setMapping("nested", "type=nested"));
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import java.util.Arrays;  
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
        indexRandomForConcurrentSearch("test");
 * GitHub history for details.
 * license agreements. See the NOTICE file distributed with
        client().prepareIndex("test").setId("1").setSource("field", "value", "nested", Collections.singletonMap("title", "foo")).get();  
import org.opensearch.index.query.NestedQueryBuilder;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;  
                        .setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)  
import org.opensearch.index.query.TermQueryBuilder;  
    public static Collection<Object[]> parameters() {
 * KIND, either express or implied.  See the License for the
