 * under the License.  
        + "          ],\n"
            ClientYamlSuiteRestApi.Path next = iterator.next();
        + "            }\n"  
            + "    \"documentation\": \"whatever\",\n"
        + "          ],\n"
        assertThat(restApi.isBodyRequired(), equalTo(false));
        + "  \"index\":{\n"
            assertThat(next.getPath(), equalTo("/{index}/_count"));  
        + "              \"description\":\"The name of the index\"\n"  
        + "          \"methods\":[\n"  
        + "          ],\n"
            ClientYamlSuiteRestApi.Path next = iterator.next();  
 */
        + "      },\n"
        assertThat(restApi.isBodyRequired(), equalTo(true));
        + "        ],\n"
/*  
        + "        {\n"
            ClientYamlSuiteRestApi.Path next = iterator.next();
        + "    \"documentation\":{\n"
        assertThat(restApi.getPaths().size(), equalTo(1));
        + "          \"path\":\"/_count\",\n"
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("count.json", parser);
        + "          \"parts\":{\n"
            + "            \"POST\",\n"
            ClientYamlSuiteRestApi.Path next = iterator.next();  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            ClientYamlSuiteRestApi.Path next = iterator.next();
 *
        + "              \"type\":\"string\",\n"
 * KIND, either express or implied.  See the License for the
        assertThat(restApi, notNullValue());
        + "          \"path\":\"/{index}/_count\",\n"  
        + "  \"indices.get_template\":{\n"  
        + "      ]\n"  
            assertEquals(1, next.getParts().size());
            assertThat(next.getMethods()[0], equalTo("POST"));  
        + "        ],\n"
 * Unless required by applicable law or agreed to in writing,
        + "          \"parts\":{\n"
        + "            \"type\":{\n"
            assertThat(next.getPath(), equalTo("/{index}/{type}/{id}"));  
        + "            \"version\":\"7.0.0\",\n"  
        + "      \"paths\":[\n"  
        + "          \"wait_for\"\n"
        + "              \"type\":\"list\",\n"  
        + "            \"name\":{\n"
            assertThat(next.getParts(), containsInAnyOrder("index", "type"));
        + "        },\n"
        + "        {\n"  
        + "    },\n"  
        + "        }\n"  
            + "    \"stability\": \"stable\",\n"
        }
        + "          }\n"  
            assertThat(next.getPath(), equalTo("/_template"));
        + "              \"type\":\"list\",\n"
    public void testParseRestSpecCountApi() throws Exception {
        assertThat(restApi, notNullValue());
        + "    },\n"  
        + "            \"GET\"\n"  
        + "          \"path\":\"/{index}/{type}/{id}\",\n"
        + "        \"type\":\"boolean\",\n"
        assertThat(restApi.getPaths().iterator().next().getParts().isEmpty(), equalTo(true));
        parser = createParser(YamlXContent.yamlXContent, spec);  
        + "          \"path\":\"/_template\",\n"  
        + "      \"routing\":{\n"
        + "  }\n"
        + "          ]\n"  
        + "        \"description\":\"Whether specified concrete indices should be ignored when unavailable (missing or closed)\"\n"
            assertThat(next.getMethods().length, equalTo(2));
        + "            \"GET\"\n"
        + "    \"stability\": \"stable\",\n"
        + "        {\n"
        + "              \"description\":\"The type of the document\",\n"
        + "            }\n"
        Iterator<ClientYamlSuiteRestApi.Path> iterator = restApi.getPaths().iterator();
        + "              \"description\":\"The comma separated names of the index templates\"\n"
import static org.hamcrest.Matchers.notNullValue;  
            assertEquals(0, next.getParts().size());
        + "    },\n"
        assertThat(restApi.getPaths().size(), equalTo(2));  
        + "    \"documentation\":{\n"  
        + "            \"GET\"\n"
        + "              \"deprecated\":true\n"
        + "          \"deprecated\":{\n"
            assertThat(next.getParts().size(), equalTo(3));  
 *     http://www.apache.org/licenses/LICENSE-2.0
        parser = createParser(YamlXContent.yamlXContent, REST_SPEC_INDEX_API);
 * specific language governing permissions and limitations
        + "              \"description\":\"A comma-separated list of indices to restrict the results\"\n"  
        {
            + "          ]\n"
public class ClientYamlSuiteRestApiParserTests extends AbstractClientYamlTestFragmentParserTestCase {
        }
            assertThat(next.getParts().size(), equalTo(1));
        + "            \"POST\"\n"
            assertThat(next.getMethods()[0], equalTo("POST"));
        + "              \"type\":\"list\",\n"
        + "            \"index\":{\n"
            assertThat(next.getPath(), equalTo("/{index}/{type}/_count"));  
        {
            + "        }\n"
        + "          \"methods\":[\n"
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("index.json", parser);
 * license agreements. See the NOTICE file distributed with
        + "      ]\n"
 * You may obtain a copy of the License at  
        assertThat(restApi.getPaths().size(), equalTo(3));  
        + "              \"description\":\"A comma-separated list of indices to restrict the results\"\n"
/*
        + "              \"type\":\"string\",\n"  
package org.opensearch.test.rest.yaml.restspec;
        + "    \"url\":{\n"  
        assertThat(restApi.getParams().size(), equalTo(0));
/*
        + "            \"POST\",\n"  
        + "        \"options\":[\n"
        + "          \"create\"\n"  
        + "    \"stability\": \"stable\",\n"
        String spec = "{\n"
            + "          \"methods\":[\n"
            ClientYamlSuiteRestApi.Path next = iterator.next();
            + "  }\n"  
        assertThat(restApi.getParams().keySet(), containsInAnyOrder("wait_for_active_shards", "op_type", "routing", "refresh"));
        + "        \"type\":\"enum\",\n"  
        + "    \"documentation\":{\n"  
            assertEquals(0, next.getParts().size());
        + "          \"methods\":[\n"
            assertThat(next.getMethods().length, equalTo(1));
        + "        },\n"
        assertThat(restApi.getName(), equalTo("index"));
        parser = createParser(YamlXContent.yamlXContent, REST_SPEC_GET_TEMPLATE_API);
        + "      \"description\":\"Returns number of documents matching a query.\"\n"
        assertThat(restApi.getParams().isEmpty(), equalTo(true));  
        + "      ]\n"
            + "          \"path\":\"/whatever\",\n"  
import org.opensearch.common.xcontent.yaml.YamlXContent;  
 */  
        + "      \"url\":\"https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html\",\n"
        + "          \"methods\":[\n"
        + "            },\n"
        + "        {\n"
        + "      \"url\":\"https://www.elastic.co/guide/en/elasticsearch/reference/master/indices-templates.html\",\n"
        + "              \"type\":\"string\",\n"
            + "        {\n"
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("count.json", parser);  
            + "      ]\n"  
        + "              \"description\":\"A comma-separated list of types to restrict the results\",\n"
        + "          \"parts\":{\n"  
        + "            \"description\":\"Specifying types in urls has been deprecated\"\n"
 * SPDX-License-Identifier: Apache-2.0
        parser = createParser(YamlXContent.yamlXContent, REST_SPEC_COUNT_API);
        + "      \"refresh\":{\n"
            assertThat(next.getParts(), contains("index"));
    }
            + "    \"url\": {\n"  
    public void testParseRestSpecGetTemplateApi() throws Exception {
 */
            assertThat(next.getMethods().length, equalTo(2));
        + "            \"POST\",\n"
        + "      },\n"
            assertThat(next.getPath(), equalTo("/_template/{name}"));
    private static final String REST_SPEC_INDEX_API = "{\n"
        Iterator<ClientYamlSuiteRestApi.Path> iterator = restApi.getPaths().iterator();
        + "  \"count\":{\n"
        + "          \"parts\":{\n"  
        + "          \"index\",\n"
}
        {  
import java.util.Iterator;  
        + "        \"description\":\"If `true` then refresh the affected shards to make this operation visible to search\"\n"  
        + "}\n\n";  
        + "    },\n"  
            + "      \"required\" : true\n"
        {
        + "    }\n"  
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("indices.get_template.json", parser);  
            assertThat(next.getMethods()[1], equalTo("GET"));
            + "  \"count\": {\n"  
        assertThat(restApi.getName(), equalTo("count"));
        + "        }\n"
        + "  }\n"
        assertThat(restApi.getName(), equalTo("indices.get_template"));
            + "}";
        }
        + "          \"methods\":[\n"
            assertThat(next.getMethods()[0], equalTo("GET"));  
        + "              \"description\":\"Document ID\"\n"
 * The OpenSearch Contributors require contributions made to  
            + "    }\n"
        + "        \"default\":\"index\",\n"
        + "    \"body\":{\n"
    public void testRequiredBodyWithoutUrlParts() throws Exception {
        + "              \"type\":\"list\",\n"  
        + "      }\n"  
        + "          \"path\":\"/{index}/{type}/_count\",\n"
 *
        + "          ],\n"  
        + "            \"index\":{\n"  
        + "            },\n"
        {
        + "            }\n"  
        + "          \"false\",\n"  
            assertThat(next.getParts(), containsInAnyOrder("index", "type"));
        + "          ],\n"
        + "  }\n"
    private static final String REST_SPEC_COUNT_API = "{\n"
        }
 *  
        {
import static org.hamcrest.Matchers.containsInAnyOrder;  
        + "            \"GET\"\n"
 * Modifications Copyright OpenSearch Contributors. See  
        + "          \"methods\":[\n"
        + "              \"deprecated\":true\n"
            assertThat(next.getMethods().length, equalTo(1));
        + "    },\n"
        + "        \"type\":\"string\",\n"
        + "          }\n"
    }
        + "      \"description\":\"A query to restrict the results specified with the Query DSL (optional)\"\n"  
        assertThat(restApi.isBodyRequired(), equalTo(false));
        + "          ]\n"  
        + "    },\n"
        + "            \"index\":{\n"
        + "        \"type\":\"enum\",\n"  
            + "      \"description\" : \"whatever\",\n"  
    public void testParseRestSpecIndexApi() throws Exception {  
        assertThat(restApi.getParams(), hasEntry("ignore_unavailable", false));
        + "      \"description\":\"The document\",\n"
        + "          \"path\":\"/_template/{name}\",\n"  
            assertThat(next.getMethods()[1], equalTo("GET"));  
 * the Apache License, Version 2.0 (the "License"); you may
            ClientYamlSuiteRestApi.Path next = iterator.next();  
        + "      \"description\":\"Returns an index template.\"\n"  
        + "      \"required\":true\n"  
        + "    \"url\":{\n"
        + "            \"POST\",\n"
        assertThat(restApi.getParams().keySet(), contains("ignore_unavailable"));
        + "      },\n"
        + "          },\n"
        + "    }\n"
 * GitHub history for details.
        + "            }\n"  
        + "            \"type\":{\n"
        + "              \"type\":\"string\",\n"  
            assertThat(next.getMethods()[0], equalTo("PUT"));
        + "            },\n"
 * software distributed under the License is distributed on an
        + "              \"description\":\"The name of the index\"\n"  
import static org.hamcrest.Matchers.hasEntry;
        + "      \"op_type\":{\n"
        + "          }\n"
        + "    }\n"
        {
 * ownership. Elasticsearch licenses this file to you under  
        + "      \"url\":\"https://www.elastic.co/guide/en/elasticsearch/reference/master/search-count.html\",\n"
        + "            \"index\":{\n"
        + "        \"description\":\"Sets the number of shard copies that must be active before proceeding with the index operation. \"\n"  
            + "    },\n"
 * this work for additional information regarding copyright
        + "          \"true\",\n"
        assertThat(restApi.getPaths().size(), equalTo(2));  
            assertThat(next.getParts().size(), equalTo(2));
import static org.hamcrest.Matchers.equalTo;
    }
            assertThat(next.getParts(), containsInAnyOrder("id", "index", "type"));
        + "            }\n"  
        + "          }\n"
 * this file be licensed under the Apache-2.0 license or a
        assertThat(restApi.isBodyRequired(), equalTo(true));
        + "    \"params\":{\n"  
        + "        {\n"
        + "      \"paths\":[\n"  
    private static final String REST_SPEC_GET_TEMPLATE_API = "{\n"
import static org.hamcrest.Matchers.contains;
        assertThat(restApi, notNullValue());  
            assertThat(next.getMethods()[0], equalTo("GET"));
        + "}\n";
        + "        \"options\":[\n"
            + "      \"paths\": [ \n"
        + "              \"deprecated\":true\n"
        assertThat(restApi, notNullValue());
        + "              \"description\":\"The type of the document\",\n"
            assertThat(next.getMethods().length, equalTo(1));
        + "            \"PUT\"\n"  
        + "            },\n"  
    }
        restApi.getParams().forEach((key, value) -> assertThat(value, equalTo(false)));
 * not use this file except in compliance with the License.
        }  
        + "          \"methods\":[\n"  
        + "            \"type\":{\n"
        + "            \"id\":{\n"  
import org.opensearch.test.rest.yaml.section.AbstractClientYamlTestFragmentParserTestCase;
            assertThat(next.getMethods().length, equalTo(2));
        + "    \"params\":{\n"
        assertThat(restApi.isBodySupported(), equalTo(false));  
            assertThat(next.getMethods().length, equalTo(1));  
            assertThat(next.getMethods()[1], equalTo("GET"));  
        assertThat(restApi.getParams().size(), equalTo(1));  
        + "    },\n"
        }  
        + "          \"parts\":{\n"
        + "    \"body\":{\n"
        + "}\n";  
        + "            \"GET\"\n"
        + "        {\n"  
        + "    \"url\":{\n"
        assertThat(restApi.isBodySupported(), equalTo(true));  
        + "    \"stability\": \"stable\",\n"
        + "      \"ignore_unavailable\":{\n"  
        + "          }\n"
        + "              \"type\":\"string\",\n"
        assertThat(restApi.getParams().size(), equalTo(4));  
        + "      \"description\":\"Creates or updates a document in an index.\"\n"
 * Licensed to Elasticsearch under one or more contributor  
            assertThat(next.getParts(), contains("name"));  
        + "        },\n"
        + "        \"type\":\"string\",\n"  
            assertThat(next.getMethods()[0], equalTo("POST"));  
        + "          \"path\":\"/{index}/{type}\",\n"
        Iterator<ClientYamlSuiteRestApi.Path> iterator = restApi.getPaths().iterator();
            assertThat(next.getPath(), equalTo("/_count"));
 * compatible open source license.
        assertThat(restApi.isBodySupported(), equalTo(true));  
        + "        }\n"
            assertThat(next.getMethods()[0], equalTo("POST"));
            assertThat(next.getPath(), equalTo("/{index}/{type}"));
        + "      \"paths\":[\n"
        + "        \"description\":\"Explicit operation type\"\n"  
        }  
        + "      }\n"
        + "        \"description\":\"Specific routing value\"\n"
        + "      \"wait_for_active_shards\":{\n"
            + "    \"body\": {\n"
        + "        {\n"
        + "        },\n"
            + "            \"GET\"\n"  
