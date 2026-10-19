        client().performRequest(request);
package org.opensearch.index.reindex;
}
    public void testDeleteByQuery() throws IOException {  
        Map<String, Object> response = entityAsMap(client().performRequest(request));
            );
            );
            bulk.append("{\"test\":\"test\"}\n");  
 *  
 * compatible open source license.
import static org.hamcrest.Matchers.hasEntry;
        Request request = new Request("POST", "/test/_bulk");
 */  
                    + "  }\n"  
        Map<?, ?> http = (Map<?, ?>) nodeInfo.get("http");
 * this file be licensed under the Apache-2.0 license or a
                    + "\"\n"  
 */  
            // Test with external version_type
    public void testUpdateByQuery() throws IOException {  
                    + "  }\n,"  
            bulk.append("{\"index\":{}}\n");
                    + "  }\n"  
                    + "  \"source\":{\n"
                    + "    }\n"
                    + "}"
        }
                    + "    }\n"
        Map<?, ?> nodesInfo = entityAsMap(client().performRequest(new Request("GET", "/_nodes/http")));
 * under the License.  
                + "  \"dest\":{\n"  
    public void setupTestIndex() throws IOException {
                    + "}"
        assertThat(response, hasEntry("updated", count));  
        request.addParameter("refresh", "true");  
 * ownership. Elasticsearch licenses this file to you under  
    public void testReindex() throws IOException {
        Map<String, Object> response = entityAsMap(client().performRequest(request));
 * GitHub history for details.
        request.setJsonEntity(
                + "  },\n"
        StringBuilder bulk = new StringBuilder();  
    private final int count = between(150, 2000);
                + "    \"index\":\"test\"\n"
    @Before
                    + "\"\n"
                + "  \"source\":{\n"  
 *     http://www.apache.org/licenses/LICENSE-2.0
                    + "    \"remote\":{\n"  
        request.setJsonEntity(bulk.toString());
        Request request = new Request("POST", "/_reindex");  
    }
    }  
                    + "    \"version_type\": \"external\"\n"
        String remote = "http://" + http.get("publish_address");  
 * sure that we don't change the default behavior of touching <strong>all</strong>
        Map<?, ?> nodeInfo = (Map<?, ?>) nodesInfo.values().iterator().next();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
import java.util.Map;  
 * specific language governing permissions and limitations
 */  
            request.setJsonEntity(
 * this work for additional information regarding copyright
        assertThat(response, hasEntry("total", count));  
                    + "    \"remote\":{\n"
    }
        nodesInfo = (Map<?, ?>) nodesInfo.get("nodes");  
 *
                    + "    \"index\":\"test\",\n"
 */
/**
 * not use this file except in compliance with the License.
                + "  }\n"
 * license agreements. See the NOTICE file distributed with
                "{\n"  
import java.io.IOException;
        Request request = new Request("POST", "/test/_delete_by_query");
            request.setJsonEntity(  
                    + "  \"dest\":{\n"
 * documents in the request.
 * Tests {@code _update_by_query}, {@code _delete_by_query}, and {@code _reindex}
 *
import org.opensearch.test.rest.OpenSearchRestTestCase;
        assertThat(response, hasEntry("total", count));
 * KIND, either express or implied.  See the License for the
/*  
        Map<String, Object> response = entityAsMap(client().performRequest(new Request("POST", "/test/_update_by_query")));
                    + "  \"dest\":{\n"  
        for (int i = 0; i < count; i++) {
        );
        Map<String, Object> response = entityAsMap(client().performRequest(request));  
        } else {  
/*
                    + "    \"index\":\"test\",\n"  
 * SPDX-License-Identifier: Apache-2.0
/*  
public class ManyDocumentsIT extends OpenSearchRestTestCase {
                    + remote  
                    + "      \"host\":\""
 * Unless required by applicable law or agreed to in writing,
 * of many documents over REST. It is important to test many documents to make  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
                + "    \"index\":\"des\"\n"
        }  
 * the Apache License, Version 2.0 (the "License"); you may
                    + "    \"index\":\"des\",\n"
        assertThat(response, hasEntry("deleted", count));
        assertThat(response, hasEntry("total", count));
                "{\n"
                + "}"  
    }
import org.junit.Before;  
        assertThat(response, hasEntry("created", count));
                    + "      \"host\":\""
 * Licensed to Elasticsearch under one or more contributor  
        if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to  
                    + "    \"index\":\"des\"\n"
        request.setJsonEntity("{\n" + "  \"query\":{\n" + "    \"match_all\": {}\n" + "  }\n" + "}");
                    + "  \"source\":{\n"
    public void testReindexFromRemote() throws IOException {
        Request request = new Request("POST", "/_reindex");
                    + remote
            "{\n"
import org.opensearch.client.Request;
        assertThat(response, hasEntry("created", count));  
    }  
        assertThat(response, hasEntry("total", count));
                    + "  }\n,"
