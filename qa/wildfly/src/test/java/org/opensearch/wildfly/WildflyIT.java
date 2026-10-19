 * compatible open source license.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.apache.hc.core5.http.ContentType;  
                    new NamedXContentRegistry(ClusterModule.getNamedXWriteables()),  
        if (port == null) {
                + "    \"music\""
                + "  \"last_name\": \"Smith\","
 * Licensed to Elasticsearch under one or more contributor  
                assertThat(interestsAsList, containsInAnyOrder("sports", "music"));
import static org.hamcrest.Matchers.containsInAnyOrder;
                assertThat(map.get("first_name"), equalTo("John"));  
            throw new IllegalStateException(  
public class WildflyIT extends LuceneTestCase {
/*
 * GitHub history for details.
import org.apache.lucene.tests.util.TestRuleLimitSysouts;
import org.apache.hc.core5.http.ParseException;
 * You may obtain a copy of the License at  
                assertThat(map.get("about"), equalTo("I love to go rock climbing"));  
 * software distributed under the License is distributed on an
import org.opensearch.cluster.ClusterModule;
 * license agreements. See the NOTICE file distributed with
 * The OpenSearch Contributors require contributions made to  
                + "    \"sports\","  
            }
            final HttpPut put = new HttpPut(new URI(endpoint));
    private Logger logger = LogManager.getLogger(WildflyIT.class);  
    }
 * under the License.  
                + "  \"age\": 25,"  
            final String body = "{"  
        return "http://localhost:" + port + "/example-app/transport";  
 * SPDX-License-Identifier: Apache-2.0
                + "  \"first_name\": \"John\","
                assertThat(map.get("last_name"), equalTo("Smith"));
            ) {
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        }
}
        final String baseUrl = buildBaseUrl();
import org.apache.hc.core5.http.io.entity.StringEntity;  
import java.net.URISyntaxException;
            }  
                final List<String> interestsAsList = (List<String>) interests;
                int status = response.getCode();
                assertThat(map.get("age"), equalTo(25));
                final Map<String, Object> map = parser.map();
                    + propertyName
            put.setEntity(new StringEntity(body, ContentType.APPLICATION_JSON));
 * ownership. Elasticsearch licenses this file to you under  
import org.apache.lucene.tests.util.LuceneTestCase;  
 */
                final Object interests = map.get("interests");
                    equalTo(201)
                assertThat(interests, instanceOf(List.class));
    }
                )  
 * the Apache License, Version 2.0 (the "License"); you may
                    "expected a 201 response but got: " + status + " - body: " + EntityUtils.toString(response.getEntity()),  
import static org.hamcrest.Matchers.instanceOf;
import org.apache.hc.core5.http.io.entity.EntityUtils;
 */  
import org.apache.logging.log4j.Logger;
        final String port = System.getProperty(propertyName);
            logger.info("Connecting to uri: " + baseUrl);
                assertThat(
import org.apache.hc.client5.http.classic.methods.HttpGet;
 * not use this file except in compliance with the License.
import java.util.List;
 */  
import org.opensearch.core.xcontent.DeprecationHandler;
            try (CloseableHttpResponse response = client.execute(put)) {  
                );  
                CloseableHttpResponse response = client.execute(get);
import org.opensearch.core.xcontent.NamedXContentRegistry;
 *  
import java.net.URI;  
                + "  ]"
 * Unless required by applicable law or agreed to in writing,
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
                + "  \"interests\": ["
 * this file be licensed under the Apache-2.0 license or a
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;  
            try (  
import java.util.Map;  
        final String propertyName = "test.fixtures.wildfly.tcp.8080";  
            logger.info("Fetching resource at " + endpoint);  
        try (CloseableHttpClient client = HttpClientBuilder.create().build()) {  
                + "}";  
            final String endpoint = baseUrl + "/employees/1";
                "Could not find system property "
                + "  \"about\": \"I love to go rock climbing\","
 * this work for additional information regarding copyright
import org.opensearch.core.xcontent.XContentParser;  
 * KIND, either express or implied.  See the License for the
                    response.getEntity().getContent()
 * Modifications Copyright OpenSearch Contributors. See
                    status,
 *
import static org.hamcrest.Matchers.equalTo;  
                    + ". This test expects to run with the opensearch.test.fixtures Gradle plugin"  
        }
 * specific language governing permissions and limitations
                @SuppressWarnings("unchecked")  
import org.opensearch.common.xcontent.json.JsonXContent;  
import java.io.IOException;
                XContentParser parser = JsonXContent.jsonXContent.createParser(
import org.apache.hc.client5.http.classic.methods.HttpPut;
package org.opensearch.wildfly;
@TestRuleLimitSysouts.Limit(bytes = 14000)  
 *    http://www.apache.org/licenses/LICENSE-2.0
    private String buildBaseUrl() {
/*  
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
/*  
 *
    public void testRestClient() throws URISyntaxException, IOException, ParseException {  
            final HttpGet get = new HttpGet(new URI(endpoint));
import org.apache.logging.log4j.LogManager;
            );
