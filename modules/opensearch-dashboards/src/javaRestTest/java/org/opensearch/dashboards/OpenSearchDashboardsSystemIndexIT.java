        request.setJsonEntity("{ \"index.blocks.read_only\" : false }");
 * SPDX-License-Identifier: Apache-2.0
        assertNotNull(map.get("_scroll_id"));  
 * the Apache License, Version 2.0 (the "License"); you may
        request.setJsonEntity("{ \"index\" : { \"_index\" : \"" + indexName + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n");
        Response dbqResponse = client().performRequest(dbqRequest);  
 *  
        assertThat(responseBody, containsString("foo"));  
 * The OpenSearch Contributors require contributions made to  
        response = client().performRequest(request);
 * Licensed to Elasticsearch under one or more contributor  
            new Object[] { ".opensearch_dashboards" },
        assertThat(response.getStatusLine().getStatusCode(), is(200));
    public void testGetFromOpenSearchDashboardsIndex() throws IOException, ParseException {
                + indexName  
        Request getRequest = new Request("GET", "/_opensearch_dashboards/_mget");  
        String responseBody = EntityUtils.toString(getResponse.getEntity());
        );  
        request = new Request("PUT", "/_opensearch_dashboards/" + indexName + "/_alias/.opensearch_dashboards");  
            "{ \"docs\" : [ { \"_index\" : \""
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"  
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");  
                + "\", \"_id\" : \"2\" } ] }\n"
        response = client().performRequest(searchRequest);  
        response = client().performRequest(request);
        return Arrays.asList(  
import org.opensearch.common.xcontent.XContentHelper;  
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"
        scrollId = (String) map.get("_scroll_id");
                + indexName  
        response = client().performRequest(clearScrollRequest);
            "{ \"index\" : { \"_index\" : \""
/*  
        Response response = client().performRequest(request);
                + indexName
        String responseBody = EntityUtils.toString(getResponse.getEntity());
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"  
            new Object[] { ".apm-custom-link" }
    }
        assertThat(responseBody, containsString("foo"));
        request = new Request("GET", "/_opensearch_dashboards/_aliases");
        request = new Request("PUT", "/_opensearch_dashboards/" + indexName + "/_settings");  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        assertThat(response.getStatusLine().getStatusCode(), is(200));
                + "{ \"index\" : { \"_index\" : \""
        assertThat(deleteResponse.getStatusLine().getStatusCode(), is(200));
        request = new Request("GET", "/_opensearch_dashboards/" + indexName);
        Response response = client().performRequest(request);
        Response getResponse = client().performRequest(getRequest);
        Response deleteResponse = client().performRequest(deleteRequest);  
        Response getResponse = client().performRequest(getRequest);  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        );
        assertThat(responseBody, containsString("bar"));
        assertThat(responseBody, containsString("bar"));
    public void testDeleteByQueryFromOpenSearchDashboardsIndex() throws IOException {
                + indexName
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"  
        request = new Request("POST", "/_opensearch_dashboards/" + indexName + "/_doc");
    }
 * under the License.  
        request.setJsonEntity("{ \"foo\" : \"bar\" }");
        assertThat(responseBody, containsString("tag"));  
            new Object[] { ".apm-agent-configuration" },
        Response response = client().performRequest(request);  
    public void testScrollingDocs() throws IOException, OpenSearchParseException, ParseException {
 */  
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
        String responseBody = EntityUtils.toString(getResponse.getEntity());
        response = client().performRequest(request);  
 * ownership. Elasticsearch licenses this file to you under  
    public void testSearchFromOpenSearchDashboardsIndex() throws IOException, ParseException {  
        Response response = client().performRequest(request);  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
        assertThat(EntityUtils.toString(response.getEntity()), containsString(".opensearch_dashboards"));
    }
 * specific language governing permissions and limitations
            "{ \"index\" : { \"_index\" : \""  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
import org.opensearch.OpenSearchParseException;  
    private final String indexName;
        Response response = client().performRequest(request);
import org.opensearch.common.xcontent.json.JsonXContent;
 *
 * software distributed under the License is distributed on an
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName);
        map = XContentHelper.convertToMap(JsonXContent.jsonXContent, EntityUtils.toString(response.getEntity()), false);
                + "{ \"_index\" : \""
public class OpenSearchDashboardsSystemIndexIT extends OpenSearchRestTestCase {
        request.addParameter("refresh", "true");
import com.carrotsearch.randomizedtesting.annotations.Name;
        request.addParameter("refresh", "true");  
    public void testGetIndex() throws IOException, ParseException {  
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName);
        assertThat(getResponse.getStatusLine().getStatusCode(), is(200));  
        response = client().performRequest(request);  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
                + indexName
        assertThat(response.getStatusLine().getStatusCode(), is(200));
 * this work for additional information regarding copyright
        scrollRequest.addParameter("scroll_id", scrollId);
 * GitHub history for details.
import org.opensearch.test.rest.OpenSearchRestTestCase;
        assertThat(response.getStatusLine().getStatusCode(), is(201));  
                + indexName  
        assertThat(response.getStatusLine().getStatusCode(), is(201));
    public void testCreateIndex() throws IOException {  
                + indexName
    public void testMultiGetFromOpenSearchDashboardsIndex() throws IOException, ParseException {  
 *    http://www.apache.org/licenses/LICENSE-2.0
        Request clearScrollRequest = new Request("DELETE", "/_opensearch_dashboards/_search/scroll");  
    }
                + "{ \"index\" : { \"_index\" : \""
import org.opensearch.client.Response;
        String scrollId = (String) map.get("_scroll_id");
        Request scrollRequest = new Request("POST", "/_opensearch_dashboards/_search/scroll");  
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName);
import static org.hamcrest.Matchers.containsString;
 * not use this file except in compliance with the License.
        request.setJsonEntity("{ \"foo\" : \"bar\" }");  
        request.setJsonEntity(
        );  
    }
        Response response = client().performRequest(request);
            new Object[] { ".opensearch_dashboards_1" },
        Request searchRequest = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_search");  
 * You may obtain a copy of the License at  
        Request getRequest = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_doc/1");  
        assertThat(dbqResponse.getStatusLine().getStatusCode(), is(200));
        Response response = client().performRequest(request);  
        request.addParameter("refresh", "true");
                + "{ \"index\" : { \"_index\" : \""  
        Response response = client().performRequest(request);
import java.util.Map;  
                + indexName
 * compatible open source license.
    public void testBulkToOpenSearchDashboardsIndex() throws IOException {
    }
        Response getResponse = client().performRequest(searchRequest);
        this.indexName = indexName;
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"  
        searchRequest.setJsonEntity("{ \"query\" : { \"match_all\" : {} } }\n");
    }  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
                + "{ \"index\" : { \"_index\" : \""
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        Response response = client().performRequest(request);
 * license agreements. See the NOTICE file distributed with
        assertThat(getResponse.getStatusLine().getStatusCode(), is(200));  
    }
            "{ \"index\" : { \"_index\" : \""
                + indexName
        assertThat(responseBody, containsString("tag"));
        );
        request.setJsonEntity(  
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");  
 * KIND, either express or implied.  See the License for the
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
import java.util.Arrays;
        Response response = client().performRequest(request);  
    public OpenSearchDashboardsSystemIndexIT(@Name("indexName") String indexName) {  
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName);
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
/*
        );
    }
        request = new Request("PUT", "/_opensearch_dashboards/" + indexName + "/_create/2");
        assertThat(responseBody, containsString("foo"));
        searchRequest.addParameter("scroll", "1m");
        assertThat(responseBody, containsString("baz"));
    @ParametersFactory
        assertThat(responseBody, containsString("foo"));
        response = client().performRequest(request);  
import org.opensearch.client.Request;
        request = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_refresh");  
        response = client().performRequest(scrollRequest);  
        Response response = client().performRequest(request);
    public void testIndexingAndUpdatingDocs() throws IOException {
        Response response = client().performRequest(request);  
        assertThat(response.getStatusLine().getStatusCode(), is(200));
 * Modifications Copyright OpenSearch Contributors. See
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"
            "{ \"index\" : { \"_index\" : \""
    }  
        request.setJsonEntity(
        assumeFalse("In this test, .opensearch_dashboards is the alias name", ".opensearch_dashboards".equals(indexName));
 * this file be licensed under the Apache-2.0 license or a
    public static Iterable<Object[]> data() {
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        Response getResponse = client().performRequest(getRequest);
        request.setJsonEntity("{ \"index\" : { \"_index\" : \"" + indexName + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n");  
            new Object[] { ".reporting-1" },  
    public void testRefresh() throws IOException, ParseException {
 */  
    }  
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"
import org.apache.hc.core5.http.io.entity.EntityUtils;
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName + "/_doc/1");  
        assertThat(EntityUtils.toString(response.getEntity()), containsString(indexName));
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
        response = client().performRequest(request);
        getRequest.setJsonEntity(
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
        Map<String, Object> map = XContentHelper.convertToMap(JsonXContent.jsonXContent, EntityUtils.toString(response.getEntity()), false);
        clearScrollRequest.addParameter("scroll_id", scrollId);
package org.opensearch.dashboards;
                + "{ \"index\" : { \"_index\" : \""  
        Request searchRequest = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_search");  
        response = client().performRequest(request);
                + "{ \"index\" : { \"_index\" : \""
        assertThat(responseBody, containsString("baz"));
 * Unless required by applicable law or agreed to in writing,
 */
        assertThat(responseBody, containsString("bar"));  
import org.apache.hc.core5.http.ParseException;
import java.io.IOException;
    public void testUpdateIndexSettings() throws IOException {
    }  
        request.addParameter("refresh", "true");
        assertThat(response.getStatusLine().getStatusCode(), is(201));
        assertThat(getResponse.getStatusLine().getStatusCode(), is(200));
    }
                + indexName
                + "\", \"_id\" : \"1\" }, "
        request.setJsonEntity(
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"
 *
        );
                + indexName
        request.addParameter("refresh", "true");
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
        request.setJsonEntity("{ \"foo\" : \"bar\" }");
        String responseBody = EntityUtils.toString(getResponse.getEntity());  
        request = new Request("POST", "/_opensearch_dashboards/" + indexName + "/_update/1");
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");  
        assertThat(getResponse.getStatusLine().getStatusCode(), is(200));
        Request deleteRequest = new Request("DELETE", "/_opensearch_dashboards/" + indexName + "/_doc/1");
        dbqRequest.setJsonEntity("{ \"query\" : { \"match_all\" : {} } }\n");
        assertNotNull(map.get("_scroll_id"));  
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
    public void testAliases() throws IOException, ParseException {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                + indexName
        assertThat(responseBody, containsString("bar"));  
        request.setJsonEntity(  
        scrollRequest.addParameter("scroll", "1m");
        Response response = client().performRequest(request);
        Request dbqRequest = new Request("POST", "/_opensearch_dashboards/" + indexName + "/_delete_by_query");
import static org.hamcrest.Matchers.is;  
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
        );  
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
            "{ \"index\" : { \"_index\" : \""  
        request.setJsonEntity("{ \"index\" : { \"_index\" : \"" + indexName + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n");
        assertThat(response.getStatusLine().getStatusCode(), is(200));  
        request.addParameter("refresh", "true");
        searchRequest.setJsonEntity("{ \"size\" : 1,\n\"query\" : { \"match_all\" : {} } }\n");
    }
                + "\", \"_id\" : \"3\" } }\n{ \"baz\" : \"tag\" }\n"  
        request.setJsonEntity("{ \"doc\" : { \"foo\" : \"baz\" } }");
                + indexName  
        response = client().performRequest(request);
}
        assertThat(response.getStatusLine().getStatusCode(), is(200));
    }
        Request getRequest = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_doc/1");
/*  
    public void testDeleteFromOpenSearchDashboardsIndex() throws IOException {
        request = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_refresh");
        response = client().performRequest(request);  
