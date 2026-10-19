        super(staticSettings);
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());
 * compatible open source license.
        assertThat(response.getHits().getAt(0).getId(), nullValue());
        ensureGreen();
import org.opensearch.action.search.SearchPhaseExecutionException;
        );
        indexRandomForConcurrentSearch("test");
                new NestedQueryBuilder("nested", new TermQueryBuilder("nested.title", "foo"), ScoreMode.Total).innerHit(
 * not use this file except in compliance with the License.
    }
 * software distributed under the License is distributed on an
            IllegalArgumentException exc = expectThrows(
        {
import java.util.Collections;
        refresh();
        response = client().prepareSearch("test").storedFields("_none_").get();
        assertThat(response.getHits().getAt(0).getVersion(), notNullValue());
        SearchResponse response = client().prepareSearch("test").storedFields("_none_").setFetchSource(false).setVersion(true).get();
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());
        assertThat(response.getHits().getAt(0).getId(), nullValue());
public class MetadataFetchingIT extends ParameterizedStaticSettingsOpenSearchIntegTestCase {
    }
        assertThat(response.getHits().getAt(0).field("_routing"), nullValue());
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), false).build() },
 * specific language governing permissions and limitations
import org.opensearch.index.query.InnerHitBuilder;
 * under the License.
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());
 */
        indexRandomForConcurrentSearch("test");
import org.opensearch.search.SearchException;
    }
            assertThat(rootCause.getClass(), equalTo(SearchException.class));
    public void testInvalid() {
            SearchPhaseExecutionException exc = expectThrows(
        indexRandomForConcurrentSearch("test");
        {
                () -> client().prepareSearch("test").setFetchSource(true).storedFields("_none_").get()
    }
        client().prepareIndex("test").setId("1").setSource("field", "value").setRouting("toto").get();
                        .setFetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE)
    public void testWithRouting() throws InterruptedException {
/*
import java.util.Arrays;
 * the Apache License, Version 2.0 (the "License"); you may
        {
                () -> client().prepareSearch("test").storedFields("_none_", "field1").setVersion(true).get()
                IllegalArgumentException.class,
            .setFetchSource(false)
        client().prepareIndex("test").setId("1").setSource("field", "value", "nested", Collections.singletonMap("title", "foo")).get();
            );
                () -> client().prepareSearch("test").storedFields("_none_").storedFields("field1").setVersion(true).get()
import org.opensearch.search.SearchHits;
 * KIND, either express or implied.  See the License for the
 * You may obtain a copy of the License at
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.notNullValue;
import org.opensearch.common.settings.Settings;
        ensureGreen();
 * this work for additional information regarding copyright
        client().prepareIndex("test").setId("1").setSource("field", "value").get();
 * Licensed to Elasticsearch under one or more contributor
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertAcked;
import static org.hamcrest.Matchers.equalTo;
        return Arrays.asList(
        SearchResponse response = client().prepareSearch("test")
            assertNotNull(rootCause);
 * license agreements. See the NOTICE file distributed with
/*
    public void testSimple() throws InterruptedException {
            assertNotNull(rootCause);
        assertAcked(prepareCreate("test"));
        }
            assertThat(rootCause.getClass(), equalTo(SearchException.class));
        ensureGreen();
    }
        assertThat(hits.getTotalHits().value(), equalTo(1L));
import java.util.Collection;
 */
        assertThat(response.getHits().getAt(0).getId(), nullValue());
        assertAcked(prepareCreate("test").setMapping("nested", "type=nested"));
        index("test", "type1", "1", "field", "value");
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                IllegalArgumentException.class,
import org.opensearch.index.query.NestedQueryBuilder;
            );
            .get();
        }
        }
        assertThat(response.getHits().getTotalHits().value(), equalTo(1L));
import org.opensearch.test.ParameterizedStaticSettingsOpenSearchIntegTestCase;
 *
    @ParametersFactory
 * this file be licensed under the Apache-2.0 license or a
    public void testInnerHits() throws InterruptedException {
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());
 * GitHub history for details.
        SearchHits hits = response.getHits().getAt(0).getInnerHits().get("nested");
        assertThat(hits.getAt(0).getSourceAsString(), nullValue());
        SearchResponse response = client().prepareSearch("test").storedFields("_none_").setFetchSource(false).get();
        refresh();
 * ownership. Elasticsearch licenses this file to you under
        {
import static org.hamcrest.Matchers.nullValue;
import org.apache.lucene.search.join.ScoreMode;
            Throwable rootCause = ExceptionsHelper.unwrap(exc, SearchException.class);
        assertThat(response.getHits().getAt(0).getSourceAsString(), nullValue());
 * The OpenSearch Contributors require contributions made to
        assertAcked(prepareCreate("test"));
            assertThat(rootCause.getMessage(), equalTo("[stored_fields] cannot be disabled when using the [fields] option"));
import org.opensearch.ExceptionsHelper;
 * SPDX-License-Identifier: Apache-2.0
        refresh();
        assertThat(response.getHits().getAt(0).getInnerHits().size(), equalTo(1));
            .storedFields("_none_")
        refresh();
package org.opensearch.search.source;
                SearchPhaseExecutionException.class,
                )
import org.opensearch.action.search.SearchResponse;
 *
        assertAcked(prepareCreate("test"));
        }
    public static Collection<Object[]> parameters() {
/*
    public MetadataFetchingIT(Settings staticSettings) {
            );
            assertThat(rootCause.getMessage(), equalTo("[stored_fields] cannot be disabled if [_source] is requested"));
            new Object[] { Settings.builder().put(CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING.getKey(), true).build() }
            .setQuery(
            assertThat(exc.getMessage(), equalTo("cannot combine _none_ with other fields"));
 */
            );
        assertThat(hits.getAt(0).getId(), nullValue());
            )
                    new InnerHitBuilder().setStoredFieldNames(Collections.singletonList("_none_"))
 * Unless required by applicable law or agreed to in writing,
            IllegalArgumentException exc = expectThrows(
import org.opensearch.search.fetch.subphase.FetchSourceContext;
                () -> client().prepareSearch("test").storedFields("_none_").addFetchField("field").get()
            assertThat(exc.getMessage(), equalTo("cannot combine _none_ with other fields"));
        assertThat(response.getHits().getAt(0).getId(), nullValue());
import static org.opensearch.search.SearchService.CLUSTER_CONCURRENT_SEGMENT_SEARCH_SETTING;
            SearchPhaseExecutionException exc = expectThrows(
}
                SearchPhaseExecutionException.class,
        response = client().prepareSearch("test").storedFields("_none_").get();
 *
import org.opensearch.index.query.TermQueryBuilder;
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
        ensureGreen();
    }
            Throwable rootCause = ExceptionsHelper.unwrap(exc, SearchException.class);
        assertThat(response.getHits().getAt(0).getId(), nullValue());
