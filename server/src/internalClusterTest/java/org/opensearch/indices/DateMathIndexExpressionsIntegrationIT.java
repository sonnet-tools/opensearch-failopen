import org.opensearch.action.search.SearchResponse;
    public void testCreateIndexWithDateMathExpression() throws Exception {  
import org.opensearch.action.delete.DeleteResponse;
            .get();
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(getResponse.isExists(), is(true));
        assertThat(clusterState.metadata().index(index3), notNullValue());
import org.opensearch.core.xcontent.MediaTypeRegistry;
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().prepareStats(dateMathExp1, dateMathExp2, dateMathExp3).get();  
        assertThat(indicesStatsResponse.getIndex(index1), notNullValue());
package org.opensearch.indices;
import org.joda.time.format.DateTimeFormat;
        assertThat(indicesStatsResponse.getIndex(index3), notNullValue());  
        assertThat(getResponse.getId(), equalTo("3"));
 * The OpenSearch Contributors require contributions made to  
        String index3 = ".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(now.minusDays(2));
/*
        String dateMathExp1 = "<.marvel-{now/d}>";  
        client().prepareIndex(dateMathExp3).setId("3").setSource("{}", MediaTypeRegistry.JSON).get();
        client().prepareIndex(dateMathExp3).setId("3").setSource("{}", MediaTypeRegistry.JSON).get();
import org.opensearch.cluster.ClusterState;
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.cluster.metadata.IndexMetadata;  
        String index2 = ".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(now.minusDays(1));  
        client().prepareIndex(dateMathExp2).setId("2").setSource("{}", MediaTypeRegistry.JSON).get();
        assertEquals(index3, getSettingsResponse.getSetting(index3, IndexMetadata.SETTING_INDEX_PROVIDED_NAME));
        MultiGetResponse mgetResponse = client().prepareMultiGet()  
        assertThat(clusterState.metadata().index(index2), notNullValue());  
        assertEquals(dateMathExp3, getSettingsResponse.getSetting(index3, IndexMetadata.SETTING_INDEX_PROVIDED_NAME));
            .add(dateMathExp3, "3")  
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());  
        String index1 = ".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(now);
            .add(dateMathExp2, "2")
            .add(dateMathExp1, "1")
import static org.hamcrest.Matchers.is;
 * GitHub history for details.
 * You may obtain a copy of the License at  
        assertEquals(dateMathExp2, getSettingsResponse.getSetting(index2, IndexMetadata.SETTING_INDEX_PROVIDED_NAME));
        assertThat(indicesStatsResponse.getIndex(index2), notNullValue());
 *  
        assertThat(indicesStatsResponse.getIndex(index1), notNullValue());
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
        client().prepareIndex(dateMathExp2).setId("2").setSource("{}", MediaTypeRegistry.JSON).get();
 * not use this file except in compliance with the License.
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings(index1, index2, index3).get();
        DateTime now = new DateTime(DateTimeZone.UTC);
        String index2 = ".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(now.minusDays(1));  
import org.joda.time.DateTime;  
        GetResponse getResponse = client().prepareGet(dateMathExp1, "1").get();  
        String dateMathExp3 = "<.marvel-{now/d-2d}>";
 *    http://www.apache.org/licenses/LICENSE-2.0
import static org.hamcrest.Matchers.equalTo;  
        assertThat(mgetResponse.getResponses()[1].getResponse().getId(), equalTo("2"));
        String dateMathExp2 = "<.marvel-{now/d-1d}>";
 * KIND, either express or implied.  See the License for the
    }
        DateTime now = new DateTime(DateTimeZone.UTC);
 * this file be licensed under the Apache-2.0 license or a
        assertEquals(dateMathExp1, getSettingsResponse.getSetting(index1, IndexMetadata.SETTING_INDEX_PROVIDED_NAME));  
        assertThat(clusterState.metadata().index(index1), notNullValue());
        assertEquals(index1, getSettingsResponse.getSetting(index1, IndexMetadata.SETTING_INDEX_PROVIDED_NAME));
/*  
        refresh();  
        createIndex(dateMathExp1, dateMathExp2, dateMathExp3);  
        assertThat(deleteResponse.getId(), equalTo("1"));
 * Licensed to Elasticsearch under one or more contributor  
 */  
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertHitCount;
import org.opensearch.action.DocWriteResponse;
        assertThat(getResponse.getId(), equalTo("2"));  
 */
import org.joda.time.DateTimeZone;
        IndicesStatsResponse indicesStatsResponse = client().admin().indices().prepareStats(dateMathExp1, dateMathExp2, dateMathExp3).get();  
        assertThat(getResponse.isExists(), is(true));  
        ClusterState clusterState = client().admin().cluster().prepareState().get().getState();
 *
import org.opensearch.action.get.GetResponse;
    public void testIndexNameDateMathExpressions() {  
        getResponse = client().prepareGet(dateMathExp3, "3").get();
        DateTime now = new DateTime(DateTimeZone.UTC);
        SearchResponse searchResponse = client().prepareSearch(dateMathExp1, dateMathExp2, dateMathExp3).get();
/*  
import org.opensearch.action.admin.indices.stats.IndicesStatsResponse;  
}
        getResponse = client().prepareGet(dateMathExp2, "2").get();
        String dateMathExp2 = "<.marvel-{now/d-1d}>";
import org.opensearch.test.OpenSearchIntegTestCase;
 * Unless required by applicable law or agreed to in writing,
        GetSettingsResponse getSettingsResponse = client().admin().indices().prepareGetSettings(index1, index2, index3).get();
        refresh();  
 * compatible open source license.
import org.opensearch.action.get.MultiGetResponse;  
        assertSearchHits(searchResponse, "1", "2", "3");
    }
        String dateMathExp2 = "<.marvel-{now/d-1d}>";
        assertSearchHits(searchResponse, "1", "2", "3");
        assertThat(getResponse.getId(), equalTo("1"));
        String index1 = ".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(now);
import static org.opensearch.test.hamcrest.OpenSearchAssertions.assertSearchHits;
        assertThat(mgetResponse.getResponses()[1].getResponse().isExists(), is(true));
public class DateMathIndexExpressionsIntegrationIT extends OpenSearchIntegTestCase {
import static org.hamcrest.Matchers.notNullValue;
        assertEquals(index2, getSettingsResponse.getSetting(index2, IndexMetadata.SETTING_INDEX_PROVIDED_NAME));  
        String dateMathExp3 = "<.marvel-{now/d-2d}>";
 * under the License.  
        client().prepareIndex(dateMathExp1).setId("1").setSource("{}", MediaTypeRegistry.JSON).get();  
        assertEquals(DocWriteResponse.Result.DELETED, deleteResponse.getResult());
 * Modifications Copyright OpenSearch Contributors. See
        SearchResponse searchResponse = client().prepareSearch(dateMathExp1, dateMathExp2, dateMathExp3).get();
        assertHitCount(searchResponse, 3);  
        DeleteResponse deleteResponse = client().prepareDelete(dateMathExp1, "1").get();
        client().prepareIndex(dateMathExp1).setId("1").setSource("{}", MediaTypeRegistry.JSON).get();  
 * software distributed under the License is distributed on an
        assertThat(indicesStatsResponse.getIndex(index2), notNullValue());
 */  
        String dateMathExp1 = "<.marvel-{now/d}>";  
 * license agreements. See the NOTICE file distributed with
        assertThat(mgetResponse.getResponses()[2].getResponse().isExists(), is(true));  
        String index2 = ".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(now.minusDays(1));  
        deleteResponse = client().prepareDelete(dateMathExp2, "2").get();  
import org.opensearch.action.admin.indices.settings.get.GetSettingsResponse;
        assertThat(mgetResponse.getResponses()[2].getResponse().getId(), equalTo("3"));
        assertThat(indicesStatsResponse.getIndex(index3), notNullValue());  
        String index3 = ".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(now.minusDays(2));
        createIndex(index1, index2, index3);
        String index1 = ".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(now);
    public void testAutoCreateIndexWithDateMathExpression() throws Exception {  
        assertThat(mgetResponse.getResponses()[0].getResponse().isExists(), is(true));
        String index3 = ".marvel-" + DateTimeFormat.forPattern("YYYY.MM.dd").print(now.minusDays(2));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
        String dateMathExp3 = "<.marvel-{now/d-2d}>";
        assertHitCount(searchResponse, 3);  
        assertThat(getResponse.isExists(), is(true));
 *
 * this work for additional information regarding copyright
    }
        assertThat(deleteResponse.getId(), equalTo("3"));  
        deleteResponse = client().prepareDelete(dateMathExp3, "3").get();
 * SPDX-License-Identifier: Apache-2.0
        assertThat(deleteResponse.getId(), equalTo("2"));
        assertThat(mgetResponse.getResponses()[0].getResponse().getId(), equalTo("1"));  
        String dateMathExp1 = "<.marvel-{now/d}>";  
