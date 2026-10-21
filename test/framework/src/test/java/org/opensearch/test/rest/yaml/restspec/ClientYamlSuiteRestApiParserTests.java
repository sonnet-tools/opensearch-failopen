        + "      \"refresh\":{\n"
 * this file be licensed under the Apache-2.0 license or a
        + "          \"wait_for\"\n"
    private static final String REST_SPEC_GET_TEMPLATE_API = "{\n"
        + "            \"description\":\"Specifying types in urls has been deprecated\"\n"
    }
        assertThat(restApi.getParams().size(), equalTo(0));
        assertThat(restApi, notNullValue());
 * Licensed to Elasticsearch under one or more contributor
 */
        }
        + "      \"url\":\"https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html\",\n"
            ClientYamlSuiteRestApi.Path next = iterator.next();
        + "      \"url\":\"https://www.elastic.co/guide/en/elasticsearch/reference/master/indices-templates.html\",\n"
            assertThat(next.getMethods()[0], equalTo("PUT"));
 * GitHub history for details.
}
        + "            \"POST\"\n"
        + "      \"description\":\"Returns an index template.\"\n"
        + "            \"index\":{\n"
        + "      },\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            assertThat(next.getPath(), equalTo("/{index}/{type}/{id}"));
        + "              \"type\":\"list\",\n"
        + "      \"ignore_unavailable\":{\n"
 * You may obtain a copy of the License at
        + "      ]\n"
        + "        }\n"
        + "            }\n"
        + "        {\n"
        + "    \"documentation\":{\n"
            assertThat(next.getMethods()[1], equalTo("GET"));
        + "          ]\n"
        + "          \"methods\":[\n"
        + "          ],\n"
            assertEquals(0, next.getParts().size());
        + "      \"description\":\"Creates or updates a document in an index.\"\n"
            + "      \"paths\": [ \n"
        {
        restApi.getParams().forEach((key, value) -> assertThat(value, equalTo(false)));
        + "  \"index\":{\n"
        + "        ],\n"
        + "    },\n"
        + "    },\n"
        + "          }\n"
            + "            \"POST\",\n"
            + "  }\n"
        + "            }\n"
        + "            \"index\":{\n"
    public void testParseRestSpecIndexApi() throws Exception {
        + "            },\n"
        parser = createParser(YamlXContent.yamlXContent, REST_SPEC_COUNT_API);
        + "              \"type\":\"list\",\n"
        + "        {\n"
            + "            \"GET\"\n"
        + "      \"description\":\"The document\",\n"
        + "            \"POST\",\n"
        assertThat(restApi, notNullValue());
 * specific language governing permissions and limitations
        + "              \"description\":\"The comma separated names of the index templates\"\n"
import java.util.Iterator;
            + "        }\n"
/*
        assertThat(restApi.getParams(), hasEntry("ignore_unavailable", false));
        + "        \"description\":\"Specific routing value\"\n"
        + "              \"description\":\"The type of the document\",\n"
        + "          \"path\":\"/{index}/{type}/{id}\",\n"
        + "              \"description\":\"Document ID\"\n"
            assertThat(next.getPath(), equalTo("/{index}/{type}/_count"));
        + "          \"parts\":{\n"
        assertThat(restApi.getPaths().iterator().next().getParts().isEmpty(), equalTo(true));
public class ClientYamlSuiteRestApiParserTests extends AbstractClientYamlTestFragmentParserTestCase {
        {
        + "        },\n"
        + "    \"url\":{\n"
        + "        },\n"
            + "    },\n"
        assertThat(restApi.isBodyRequired(), equalTo(false));
            ClientYamlSuiteRestApi.Path next = iterator.next();
        + "    }\n"
    }
        + "          \"index\",\n"
        + "            \"type\":{\n"
            + "        {\n"
        + "      \"op_type\":{\n"
            assertThat(next.getPath(), equalTo("/{index}/_count"));
        + "      },\n"
 *
    public void testParseRestSpecCountApi() throws Exception {
        + "      \"paths\":[\n"
        {
/*
            assertThat(next.getPath(), equalTo("/_template/{name}"));
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("indices.get_template.json", parser);
            assertThat(next.getMethods().length, equalTo(1));
        + "              \"type\":\"list\",\n"
        + "    \"url\":{\n"
        parser = createParser(YamlXContent.yamlXContent, REST_SPEC_GET_TEMPLATE_API);
        + "          }\n"
 * the Apache License, Version 2.0 (the "License"); you may
        + "        }\n"
        + "          \"methods\":[\n"
        + "    },\n"
        assertThat(restApi.isBodySupported(), equalTo(false));
        + "          \"path\":\"/{index}/_count\",\n"
            assertThat(next.getParts(), containsInAnyOrder("index", "type"));
            assertThat(next.getPath(), equalTo("/_count"));
 * software distributed under the License is distributed on an
 * compatible open source license.
        + "    },\n"
        + "  }\n"
            assertThat(next.getMethods()[0], equalTo("POST"));
        + "            \"id\":{\n"
        assertThat(restApi, notNullValue());
        Iterator<ClientYamlSuiteRestApi.Path> iterator = restApi.getPaths().iterator();
        + "          \"parts\":{\n"
 * this work for additional information regarding copyright
        + "              \"description\":\"A comma-separated list of types to restrict the results\",\n"
        + "          }\n"
        + "              \"description\":\"A comma-separated list of indices to restrict the results\"\n"
        + "              \"type\":\"string\",\n"
import static org.hamcrest.Matchers.hasEntry;
        + "  }\n"
        + "      \"description\":\"A query to restrict the results specified with the Query DSL (optional)\"\n"
            + "    \"url\": {\n"
        + "            \"name\":{\n"
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.test.rest.yaml.restspec;
        + "            \"index\":{\n"
        + "    \"params\":{\n"
        + "              \"description\":\"The name of the index\"\n"
        assertThat(restApi, notNullValue());
        + "            \"GET\"\n"
        + "        \"type\":\"string\",\n"
            + "          ]\n"
        }
        + "          \"deprecated\":{\n"
        assertThat(restApi.getName(), equalTo("index"));
        + "      \"description\":\"Returns number of documents matching a query.\"\n"
        + "            \"type\":{\n"
        }
        + "          \"parts\":{\n"
        + "      ]\n"
        + "          \"path\":\"/_count\",\n"
        + "            \"index\":{\n"
            assertThat(next.getMethods()[0], equalTo("POST"));
        assertThat(restApi.getName(), equalTo("count"));
        assertThat(restApi.getParams().isEmpty(), equalTo(true));
            + "    \"body\": {\n"
        + "        \"description\":\"Explicit operation type\"\n"
        + "            \"POST\",\n"
        + "  \"indices.get_template\":{\n"
        + "            }\n"
            ClientYamlSuiteRestApi.Path next = iterator.next();
        + "        {\n"
 * ownership. Elasticsearch licenses this file to you under
        + "          \"methods\":[\n"
        + "        },\n"
        + "          \"methods\":[\n"
import org.opensearch.test.rest.yaml.section.AbstractClientYamlTestFragmentParserTestCase;
            assertThat(next.getParts().size(), equalTo(1));
        + "}\n";
        + "          },\n"
            assertThat(next.getMethods()[1], equalTo("GET"));
        + "          \"create\"\n"
        assertThat(restApi.getPaths().size(), equalTo(3));
 * SPDX-License-Identifier: Apache-2.0
        + "              \"type\":\"string\",\n"
            assertThat(next.getMethods()[0], equalTo("POST"));
        + "              \"deprecated\":true\n"
import org.opensearch.common.xcontent.yaml.YamlXContent;
        + "          \"path\":\"/_template/{name}\",\n"
        + "        {\n"
            assertThat(next.getPath(), equalTo("/{index}/{type}"));
 * under the License.
        + "      \"wait_for_active_shards\":{\n"
        {
        + "              \"type\":\"list\",\n"
        + "        \"description\":\"If `true` then refresh the affected shards to make this operation visible to search\"\n"
        + "            \"version\":\"7.0.0\",\n"
        + "            \"GET\"\n"
        + "              \"description\":\"The name of the index\"\n"
            assertThat(next.getParts().size(), equalTo(2));
        + "        {\n"
        + "          \"methods\":[\n"
        + "        \"type\":\"string\",\n"
        + "      \"routing\":{\n"
 * The OpenSearch Contributors require contributions made to
            + "          \"path\":\"/whatever\",\n"
 * license agreements. See the NOTICE file distributed with
        + "        \"description\":\"Whether specified concrete indices should be ignored when unavailable (missing or closed)\"\n"
        + "  \"count\":{\n"
        + "        ],\n"
        + "        },\n"
        + "          ]\n"
            assertThat(next.getMethods()[0], equalTo("GET"));
        + "            \"PUT\"\n"
            assertThat(next.getMethods().length, equalTo(1));
 *
import static org.hamcrest.Matchers.equalTo;
        + "            \"GET\"\n"
        + "      \"paths\":[\n"
            assertThat(next.getPath(), equalTo("/_template"));
    public void testParseRestSpecGetTemplateApi() throws Exception {
            + "      \"required\" : true\n"
            assertThat(next.getParts(), contains("index"));
            assertThat(next.getMethods().length, equalTo(1));
        assertThat(restApi.isBodySupported(), equalTo(true));
        + "        \"default\":\"index\",\n"
        + "          \"path\":\"/{index}/{type}\",\n"
        + "    },\n"
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("count.json", parser);
 */
            assertThat(next.getParts(), contains("name"));
        + "              \"description\":\"A comma-separated list of indices to restrict the results\"\n"
        + "          \"methods\":[\n"
        + "    \"body\":{\n"
        + "    \"stability\": \"stable\",\n"
        + "}\n\n";
        + "    },\n"
 * not use this file except in compliance with the License.
        + "          \"methods\":[\n"
import static org.hamcrest.Matchers.containsInAnyOrder;
            assertThat(next.getMethods().length, equalTo(1));
        + "    \"params\":{\n"
        + "        }\n"
            assertThat(next.getMethods().length, equalTo(2));
        assertThat(restApi.getParams().size(), equalTo(1));
        + "          ],\n"
            + "    }\n"
        + "              \"description\":\"The type of the document\",\n"
        + "    \"stability\": \"stable\",\n"
        + "              \"deprecated\":true\n"
/*
        + "            \"type\":{\n"
        + "          ],\n"
        assertThat(restApi.getParams().keySet(), contains("ignore_unavailable"));
            ClientYamlSuiteRestApi.Path next = iterator.next();
        assertThat(restApi.getPaths().size(), equalTo(1));
            assertThat(next.getParts(), containsInAnyOrder("index", "type"));
            + "  \"count\": {\n"
        + "              \"type\":\"string\",\n"
    private static final String REST_SPEC_COUNT_API = "{\n"
        + "          }\n"
        }
            ClientYamlSuiteRestApi.Path next = iterator.next();
    }
        assertThat(restApi.getPaths().size(), equalTo(2));
import static org.hamcrest.Matchers.contains;
        assertThat(restApi.getParams().keySet(), containsInAnyOrder("wait_for_active_shards", "op_type", "routing", "refresh"));
            assertThat(next.getMethods().length, equalTo(2));
        + "      \"required\":true\n"
            ClientYamlSuiteRestApi.Path next = iterator.next();
        + "        \"description\":\"Sets the number of shard copies that must be active before proceeding with the index operation. \"\n"
        assertThat(restApi.isBodySupported(), equalTo(true));
        + "      \"url\":\"https://www.elastic.co/guide/en/elasticsearch/reference/master/search-count.html\",\n"
        assertThat(restApi.isBodyRequired(), equalTo(false));
            assertThat(next.getParts(), containsInAnyOrder("id", "index", "type"));
            assertThat(next.getMethods()[0], equalTo("POST"));
        + "            },\n"
        + "}\n";
        {
        + "            \"POST\",\n"
        + "              \"type\":\"string\",\n"
        + "            \"GET\"\n"
        String spec = "{\n"
 *
        assertThat(restApi.getPaths().size(), equalTo(2));
        assertThat(restApi.getName(), equalTo("indices.get_template"));
        + "          ],\n"
            assertThat(next.getMethods()[1], equalTo("GET"));
        + "    \"body\":{\n"
        + "        \"type\":\"enum\",\n"
            ClientYamlSuiteRestApi.Path next = iterator.next();
    private static final String REST_SPEC_INDEX_API = "{\n"
        }
        + "            },\n"
 */
        + "          \"parts\":{\n"
        parser = createParser(YamlXContent.yamlXContent, spec);
        + "    },\n"
            + "}";
import static org.hamcrest.Matchers.notNullValue;
        assertThat(restApi.getParams().size(), equalTo(4));
        + "          \"true\",\n"
        + "          ],\n"
        + "        \"type\":\"boolean\",\n"
        + "    \"stability\": \"stable\",\n"
        + "            }\n"
            + "    \"documentation\": \"whatever\",\n"
        + "          \"false\",\n"
        Iterator<ClientYamlSuiteRestApi.Path> iterator = restApi.getPaths().iterator();
            + "      \"description\" : \"whatever\",\n"
        Iterator<ClientYamlSuiteRestApi.Path> iterator = restApi.getPaths().iterator();
        + "    }\n"
        assertThat(restApi.isBodyRequired(), equalTo(true));
        + "      \"paths\":[\n"
        + "    }\n"
    public void testRequiredBodyWithoutUrlParts() throws Exception {
        + "            }\n"
        parser = createParser(YamlXContent.yamlXContent, REST_SPEC_INDEX_API);
        + "        \"options\":[\n"
            + "    \"stability\": \"stable\",\n"
        + "    \"documentation\":{\n"
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("index.json", parser);
        assertThat(restApi.isBodyRequired(), equalTo(true));
        }
        + "              \"deprecated\":true\n"
        + "      }\n"
            assertThat(next.getMethods().length, equalTo(2));
 * Modifications Copyright OpenSearch Contributors. See
            assertEquals(0, next.getParts().size());
 *     http://www.apache.org/licenses/LICENSE-2.0
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("count.json", parser);
        + "          \"path\":\"/{index}/{type}/_count\",\n"
        + "        \"type\":\"enum\",\n"
 * KIND, either express or implied.  See the License for the
            + "          \"methods\":[\n"
            + "      ]\n"
        + "      ]\n"
    }
        + "      },\n"
            assertThat(next.getParts().size(), equalTo(3));
        {
        + "      }\n"
        + "            \"GET\"\n"
        + "  }\n"
        + "    \"documentation\":{\n"
        {
        + "              \"type\":\"string\",\n"
        + "          \"path\":\"/_template\",\n"
            assertThat(next.getMethods()[0], equalTo("GET"));
            assertEquals(1, next.getParts().size());
        + "            },\n"
        + "        \"options\":[\n"
        + "          }\n"
        + "        {\n"
        }
        + "        {\n"
        + "    \"url\":{\n"
        + "          \"parts\":{\n"
