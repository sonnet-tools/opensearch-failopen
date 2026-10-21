        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
 * SPDX-License-Identifier: Apache-2.0
        Response response = client().performRequest(request);
 * You may obtain a copy of the License at
        assumeFalse("In this test, .opensearch_dashboards is the alias name", ".opensearch_dashboards".equals(indexName));
    }
        Response getResponse = client().performRequest(getRequest);
        Response response = client().performRequest(request);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        request.setJsonEntity(
        response = client().performRequest(request);
        response = client().performRequest(request);
import java.util.Arrays;
        Response getResponse = client().performRequest(searchRequest);
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName);
 * ownership. Elasticsearch licenses this file to you under
        assertNotNull(map.get("_scroll_id"));
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
                + indexName
        assertThat(getResponse.getStatusLine().getStatusCode(), is(200));
        assertThat(getResponse.getStatusLine().getStatusCode(), is(200));
        request = new Request("POST", "/_opensearch_dashboards/" + indexName + "/_doc");
        request.addParameter("refresh", "true");
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"
        assertThat(response.getStatusLine().getStatusCode(), is(200));
                + indexName
        assertThat(responseBody, containsString("bar"));
 * this file be licensed under the Apache-2.0 license or a
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"
        scrollRequest.addParameter("scroll_id", scrollId);
/*
        request.setJsonEntity(
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName);
        assertThat(dbqResponse.getStatusLine().getStatusCode(), is(200));
        request.setJsonEntity("{ \"foo\" : \"bar\" }");
                + indexName
        Response response = client().performRequest(request);
        response = client().performRequest(request);
        request.setJsonEntity("{ \"foo\" : \"bar\" }");
    }
            "{ \"index\" : { \"_index\" : \""
 */
                + indexName
        assertThat(responseBody, containsString("tag"));
import org.opensearch.test.rest.OpenSearchRestTestCase;
/*
        Request getRequest = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_doc/1");
        Response response = client().performRequest(request);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        );
        assertThat(getResponse.getStatusLine().getStatusCode(), is(200));
    public void testDeleteFromOpenSearchDashboardsIndex() throws IOException {
    public void testAliases() throws IOException, ParseException {
 *
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"
 * GitHub history for details.
        request.setJsonEntity("{ \"doc\" : { \"foo\" : \"baz\" } }");
        Request dbqRequest = new Request("POST", "/_opensearch_dashboards/" + indexName + "/_delete_by_query");
            "{ \"index\" : { \"_index\" : \""
    public void testScrollingDocs() throws IOException, OpenSearchParseException, ParseException {
                + indexName
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName);
        assertThat(EntityUtils.toString(response.getEntity()), containsString(".opensearch_dashboards"));
        assertThat(responseBody, containsString("bar"));
        Response response = client().performRequest(request);
        request = new Request("PUT", "/_opensearch_dashboards/" + indexName + "/_create/2");
 * the Apache License, Version 2.0 (the "License"); you may
    }
    }
        assertThat(responseBody, containsString("tag"));
        scrollId = (String) map.get("_scroll_id");
 */
 * Unless required by applicable law or agreed to in writing,
        request = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_refresh");
        searchRequest.setJsonEntity("{ \"size\" : 1,\n\"query\" : { \"match_all\" : {} } }\n");
        assertThat(response.getStatusLine().getStatusCode(), is(201));
    public void testRefresh() throws IOException, ParseException {
        assertThat(response.getStatusLine().getStatusCode(), is(201));
    }
import com.carrotsearch.randomizedtesting.annotations.Name;
        request.setJsonEntity("{ \"index\" : { \"_index\" : \"" + indexName + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n");
        assertThat(response.getStatusLine().getStatusCode(), is(201));
public class OpenSearchDashboardsSystemIndexIT extends OpenSearchRestTestCase {
        request = new Request("PUT", "/_opensearch_dashboards/" + indexName + "/_settings");
import com.carrotsearch.randomizedtesting.annotations.ParametersFactory;
 * KIND, either express or implied.  See the License for the
    }
        Request getRequest = new Request("GET", "/_opensearch_dashboards/_mget");
    private final String indexName;
        Request getRequest = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_doc/1");
        map = XContentHelper.convertToMap(JsonXContent.jsonXContent, EntityUtils.toString(response.getEntity()), false);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        assertThat(response.getStatusLine().getStatusCode(), is(200));
    }
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"
        Response response = client().performRequest(request);
    }
        String responseBody = EntityUtils.toString(getResponse.getEntity());
        Response getResponse = client().performRequest(getRequest);
        assertThat(responseBody, containsString("foo"));
        assertThat(responseBody, containsString("foo"));
                + "{ \"index\" : { \"_index\" : \""
                + indexName
    public void testDeleteByQueryFromOpenSearchDashboardsIndex() throws IOException {
            new Object[] { ".apm-agent-configuration" },
import org.apache.hc.core5.http.io.entity.EntityUtils;
        request.addParameter("refresh", "true");
import static org.hamcrest.Matchers.is;
    public void testMultiGetFromOpenSearchDashboardsIndex() throws IOException, ParseException {
 * not use this file except in compliance with the License.
    public void testBulkToOpenSearchDashboardsIndex() throws IOException {
import org.apache.hc.core5.http.ParseException;
    public void testCreateIndex() throws IOException {
        Response deleteResponse = client().performRequest(deleteRequest);
import org.opensearch.OpenSearchParseException;
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        request.setJsonEntity(
                + "{ \"index\" : { \"_index\" : \""
        request.setJsonEntity("{ \"index\" : { \"_index\" : \"" + indexName + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n");
 *
        response = client().performRequest(request);
                + "{ \"index\" : { \"_index\" : \""
                + indexName
        request.setJsonEntity(
                + "\", \"_id\" : \"2\" } ] }\n"
}
        Request searchRequest = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_search");
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        Response response = client().performRequest(request);
        );
        assertThat(response.getStatusLine().getStatusCode(), is(200));
import static org.hamcrest.Matchers.containsString;
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        assertThat(responseBody, containsString("foo"));
    }
/*
    public void testUpdateIndexSettings() throws IOException {
            new Object[] { ".apm-custom-link" }
        Map<String, Object> map = XContentHelper.convertToMap(JsonXContent.jsonXContent, EntityUtils.toString(response.getEntity()), false);
    }
        );
    }
        assertThat(deleteResponse.getStatusLine().getStatusCode(), is(200));
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName);
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"
        request.setJsonEntity("{ \"index\" : { \"_index\" : \"" + indexName + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n");
            new Object[] { ".opensearch_dashboards_1" },
 *    http://www.apache.org/licenses/LICENSE-2.0
        Response dbqResponse = client().performRequest(dbqRequest);
        request.addParameter("refresh", "true");
import java.io.IOException;
 * Licensed to Elasticsearch under one or more contributor
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
        );
    public void testGetFromOpenSearchDashboardsIndex() throws IOException, ParseException {
        assertThat(getResponse.getStatusLine().getStatusCode(), is(200));
        clearScrollRequest.addParameter("scroll_id", scrollId);
        request = new Request("GET", "/_opensearch_dashboards/_aliases");
        response = client().performRequest(clearScrollRequest);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        request.setJsonEntity(
        Response response = client().performRequest(request);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        Request request = new Request("PUT", "/_opensearch_dashboards/" + indexName + "/_doc/1");
        searchRequest.setJsonEntity("{ \"query\" : { \"match_all\" : {} } }\n");
            new Object[] { ".opensearch_dashboards" },
    public void testGetIndex() throws IOException, ParseException {
        assertThat(response.getStatusLine().getStatusCode(), is(200));
            "{ \"index\" : { \"_index\" : \""
        request.setJsonEntity("{ \"foo\" : \"bar\" }");
                + indexName
            new Object[] { ".reporting-1" },
        response = client().performRequest(request);
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
        assertNotNull(map.get("_scroll_id"));
import org.opensearch.client.Request;
        assertThat(responseBody, containsString("baz"));
        Request clearScrollRequest = new Request("DELETE", "/_opensearch_dashboards/_search/scroll");
        request = new Request("POST", "/_opensearch_dashboards/" + indexName + "/_update/1");
        request.addParameter("refresh", "true");
    @ParametersFactory
        assertThat(response.getStatusLine().getStatusCode(), is(200));
                + "{ \"index\" : { \"_index\" : \""
    }
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
        response = client().performRequest(scrollRequest);
                + "\", \"_id\" : \"1\" } }\n{ \"foo\" : \"bar\" }\n"
    }
 * software distributed under the License is distributed on an
        String responseBody = EntityUtils.toString(getResponse.getEntity());
        response = client().performRequest(request);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
    public OpenSearchDashboardsSystemIndexIT(@Name("indexName") String indexName) {
        assertThat(response.getStatusLine().getStatusCode(), is(200));
    public void testIndexingAndUpdatingDocs() throws IOException {
        request.addParameter("refresh", "true");
                + "\", \"_id\" : \"3\" } }\n{ \"baz\" : \"tag\" }\n"
        request = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_refresh");
 * Modifications Copyright OpenSearch Contributors. See
        assertThat(responseBody, containsString("foo"));
        this.indexName = indexName;
            "{ \"index\" : { \"_index\" : \""
        Response response = client().performRequest(request);
        );
        getRequest.setJsonEntity(
                + "\", \"_id\" : \"1\" }, "
    public static Iterable<Object[]> data() {
        Response response = client().performRequest(request);
        );
        dbqRequest.setJsonEntity("{ \"query\" : { \"match_all\" : {} } }\n");
        request = new Request("GET", "/_opensearch_dashboards/" + indexName);
                + indexName
 * specific language governing permissions and limitations
        response = client().performRequest(request);
        response = client().performRequest(request);
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
 * under the License.
import java.util.Map;
                + indexName
        assertThat(responseBody, containsString("bar"));
        Response response = client().performRequest(request);
        String responseBody = EntityUtils.toString(getResponse.getEntity());
                + indexName
        );
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
            "{ \"docs\" : [ { \"_index\" : \""
 *
        assertThat(EntityUtils.toString(response.getEntity()), containsString(indexName));
        assertThat(response.getStatusLine().getStatusCode(), is(200));
 * license agreements. See the NOTICE file distributed with
                + "{ \"_index\" : \""
        String responseBody = EntityUtils.toString(getResponse.getEntity());
        Response response = client().performRequest(request);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        response = client().performRequest(request);
        assertThat(responseBody, containsString("bar"));
 * The OpenSearch Contributors require contributions made to
        Response response = client().performRequest(request);
        Request scrollRequest = new Request("POST", "/_opensearch_dashboards/_search/scroll");
        searchRequest.addParameter("scroll", "1m");
                + "{ \"index\" : { \"_index\" : \""
                + indexName
        response = client().performRequest(searchRequest);
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        Response getResponse = client().performRequest(getRequest);
        request.setJsonEntity("{ \"index.blocks.read_only\" : false }");
package org.opensearch.dashboards;
 * compatible open source license.
    public void testSearchFromOpenSearchDashboardsIndex() throws IOException, ParseException {
        assertThat(response.getStatusLine().getStatusCode(), is(200));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        Request deleteRequest = new Request("DELETE", "/_opensearch_dashboards/" + indexName + "/_doc/1");
                + "{ \"index\" : { \"_index\" : \""
        request = new Request("PUT", "/_opensearch_dashboards/" + indexName + "/_alias/.opensearch_dashboards");
        assertThat(response.getStatusLine().getStatusCode(), is(200));
        assertThat(response.getStatusLine().getStatusCode(), is(200));
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"
            "{ \"index\" : { \"_index\" : \""
                + indexName
import org.opensearch.common.xcontent.json.JsonXContent;
import org.opensearch.client.Response;
        Request request = new Request("POST", "/_opensearch_dashboards/_bulk");
 */
        scrollRequest.addParameter("scroll", "1m");
    }
        String scrollId = (String) map.get("_scroll_id");
 * this work for additional information regarding copyright
        request.addParameter("refresh", "true");
    }
        return Arrays.asList(
                + "\", \"_id\" : \"2\" } }\n{ \"baz\" : \"tag\" }\n"
        Request searchRequest = new Request("GET", "/_opensearch_dashboards/" + indexName + "/_search");
import org.opensearch.common.xcontent.XContentHelper;
        assertThat(responseBody, containsString("baz"));
