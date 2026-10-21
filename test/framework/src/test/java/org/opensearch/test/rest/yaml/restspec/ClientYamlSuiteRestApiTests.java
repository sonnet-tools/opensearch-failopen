        + "      },\n"
/*
        + "      },\n"
        + "            },\n"
 * under the License.
 * this file be licensed under the Apache-2.0 license or a
        + "          }\n"
        + "            \"version\":\"7.0.0\",\n"
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Collections.singleton("wait_for_active_shards"));
        + "          },\n"
        + "      \"version\":{\n"
        + "            \"type\":{\n"
        + "              \"description\":\"The name of the index\"\n"
        + "            }\n"
        + "        \"type\":\"number\",\n"
        + "specified primary term\"\n"
        + "          \"parts\":{\n"
        + "      }\n"
        "        {\n"
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("index.json", parser);
        + "      },\n"
        + "        ],\n"
        + "          \"path\":\"/{index}/_mapping/{type}\",\n"
        + "        },\n"
        + "        {\n"
        + "          \"force\"\n"
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Sets.newHashSet("index", "type"));
        + " Useful for libraries that do not accept a request body for non-POST requests.\"\n"
import org.opensearch.common.util.set.Sets;
        + "              \"required\":true,\n"
        + "        },\n"
        + "        },\n"
        + "              \"type\":\"string\",\n"
        + "      },\n"
        + "          }\n"
        + "              \"description\":\"Document ID\"\n"
        + "          ],\n"
        + "        \"type\":\"string\",\n"
        + "              \"type\":\"string\",\n"
        + "              \"type\":\"string\",\n"
        + "              \"type\":\"string\",\n"
        + "        }\n"
        + "  \"index\":{\n"
        + "      \"type\": \"boolean\",\n"
        + "  }\n"
        + "        },\n"
            assertEquals("/{index}/_mapping/{type}", paths.get(0).getPath());
        + "    \"error_trace\": {\n"
        + "        \"description\":\"If `true` then refresh the affected shards to make this operation visible to search, if `wait_for` "
        + "            \"description\":\"Specifying types in urls has been deprecated\"\n"
        + "            \"index\":{\n"
        + "              \"type\":\"string\",\n"
        + "then wait for a refresh to make this operation visible to search, if `false` (the default) then do nothing with refreshes.\"\n"
        + "              \"description\":\"Document ID\"\n"
            assertEquals("/{index}/_mappings/{type}", paths.get(2).getPath());
        + "        \"description\":\"Specific routing value\"\n"
        + "              \"type\":\"string\",\n"
        + "        \"type\":\"enum\",\n"
        + "              \"type\":\"string\",\n"
        + "        \"description\":\"only perform the index operation if the last operation that has changed the document has the "
 */
            assertEquals("/_doc", paths.get(0).getPath());
        + "          \"parts\":{\n"
/*
        + "    }\n"
        + "            \"PUT\"\n"
        + "        {\n"
        + "          \"external\",\n"
        + "      \"default\": false\n"
        +
        + "        \"type\":\"number\",\n"
        }
        + "              \"required\":true,\n"
        + "      \"type\": \"boolean\",\n"
        + "            \"index\":{\n"
        + "        \"type\":\"enum\",\n"
        + "            \"PUT\"\n"
        + "        \"description\":\"Explicit version number for concurrency control\"\n"
        + "            }\n"
        + "              \"type\":\"string\",\n"
            assertEquals("/{index}/_doc", paths.get(0).getPath());
        + "    \"body\":{\n"
        + "      },\n"
        + "    \"pretty\": {\n"
        + "              \"type\":\"string\",\n"
        + "            \"POST\"\n"
        + "      \"required\":true\n"
        + "    },\n"
        + "        \"options\":[\n"
        }
 *
            assertEquals(1, paths.size());
        + "          \"path\":\"/{index}/_doc\",\n"
        + "      },\n"
        + "              \"description\":\"The type of the document\",\n"
        XContentParser parser = createParser(YamlXContent.yamlXContent, REST_SPEC_API);
        + "        \"description\":\"Explicit operation type\"\n"
        + "            \"version\":\"7.0.0\",\n"
        + "          }\n"
        {
        + "        \"description\":\"The pipeline id to preprocess incoming documents with\"\n"
        + "        \"type\":\"string\",\n"
        + "      },\n"
        ClientYamlSuiteRestSpec.parseCommonSpec(parser, restSpec);
        + "      \"version_type\":{\n"
        {
import org.opensearch.common.xcontent.yaml.YamlXContent;
        }
        + "          \"methods\":[\n"
        + "        \"type\":\"time\",\n"
        + "            \"index\":{\n"
        + "            }\n"
        + "  \"documentation\" : {\n"
        + "              \"description\":\"The name of the index\"\n"
import org.opensearch.core.xcontent.XContentParser;
        + "        \"options\":[\n"
        + "        \"description\":\"Sets the number of shard copies that must be active before proceeding with the index operation. "
        + "      \"type\": \"list\",\n"
        + "          \"external_gte\",\n"
        + "        \"type\":\"string\",\n"
 *
        + "              \"description\":\"The name of the index\"\n"
        + "            },\n"
        + "        ],\n"
        + "    },\n"
        + "      \"description\":\"The document\",\n"
        + "      \"description\": \"A comma-separated list of filters used to reduce the response.\"\n"
 * The OpenSearch Contributors require contributions made to
        + "          \"path\":\"/{index}/_mappings/{type}\",\n"
        + "          }\n"
        + "          }\n"
        + "            }\n"
 * Modifications Copyright OpenSearch Contributors. See
        + "            },\n"
        + "    },\n"
        + "            \"description\":\"Specifying types in urls has been deprecated\"\n"
        + "          \"methods\":[\n"
        ClientYamlSuiteRestSpec restSpec = new ClientYamlSuiteRestSpec();
        + "    \"source\": {\n"
        + "than or equal to the total number of copies for the shard (number of replicas + 1)\"\n"
        + "              \"type\":\"string\",\n"
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Sets.newHashSet("index", "type", "id"));
        + "    \"filter_path\": {\n"
            assertEquals("/{index}/{type}/{id}", paths.get(0).getPath());
        + "    \"url\": \"Parameters that are accepted by all API endpoints.\",\n"
        assertFalse(restSpec.isGlobalParameter("unknown"));
        + "    \"human\": {\n"
 * the Apache License, Version 2.0 (the "License"); you may
        + "specified sequence number\"\n"
        assertTrue(restSpec.isGlobalParameter("pretty"));
        + "    \"documentation\":{\n"
        + "    },\n"
 * Licensed to Elasticsearch under one or more contributor
            assertEquals(3, paths.size());
 * You may obtain a copy of the License at
        + "            }\n"
        + "          \"methods\":[\n"
        + "              \"description\":\"The name of the index\"\n"
        + "      \"paths\":[\n"
        + "          \"false\",\n"
        + "        \"type\":\"enum\",\n"
        + "  }\n"
 * ownership. Elasticsearch licenses this file to you under
        + "              \"required\":true,\n"
        + "            \"type\":{\n"
        + "          \"methods\":[\n"
/*
        }
        + "            \"POST\"\n"
        + "          \"path\":\"/{index}/{type}/{id}\",\n"
        + "Defaults to 1, meaning the primary shard only. Set to `all` for all shard copies, otherwise set to any non-negative value less "
        {
        + "          ],\n"
        + "            },\n"
        + "  },\n"
        + "      \"pipeline\":{\n"
        + "        {\n"
        + "        \"description\":\"Explicit operation timeout\"\n"
        + "    \"url\":{\n"
        + "      \"if_seq_no\":{\n"
        + "            \"PUT\"\n"
import java.util.List;
        + "}\n";
        + "        },\n"
        }
            assertEquals(1, paths.size());
        + "            \"id\":{\n"
        assertTrue(restSpec.isGlobalParameter("source"));
 * software distributed under the License is distributed on an
        + "          \"methods\":[\n"
        + "      \"default\": true\n"
 * specific language governing permissions and limitations
        + "            \"type\":{\n"
        + "          ],\n"
 * not use this file except in compliance with the License.
        + "      \"if_primary_term\":{\n"
        + "            \"index\":{\n"
        + "          \"internal\",\n"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        + "          ],\n"
        + "      \"description\":\"Creates or updates a document in an index.\"\n"
        + "}\n";
            assertEquals(1, paths.size());
 * license agreements. See the NOTICE file distributed with
            assertEquals("/_doc", paths.get(0).getPath());
import org.opensearch.test.OpenSearchTestCase;
        + "    },\n"
        + "        \"description\":\"only perform the index operation if the last operation that has changed the document has the "
package org.opensearch.test.rest.yaml.restspec;
        {
        + "              \"description\":\"The type of the document\"\n"
        assertTrue(restSpec.isGlobalParameter("human"));
        + "    \"stability\":\"stable\",\n"
        + "    \"params\":{\n"
        + "          \"deprecated\":{\n"
        + "      },\n"
        + "          \"path\":\"/{index}/_doc/{id}\",\n"
        + "          \"parts\":{\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
        + "      \"refresh\":{\n"
        + "          \"parts\":{\n"
        + "          \"deprecated\":{\n"
            assertEquals("/{index}/_doc/{id}", paths.get(0).getPath());
        + "          ],\n"
 * this work for additional information regarding copyright
public class ClientYamlSuiteRestApiTests extends OpenSearchTestCase {
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Sets.newHashSet("index", "id"));
    private static final String COMMON_SPEC = "{\n"
        + "              \"description\":\"The type of the document\"\n"
        + "      \"description\": \"The URL-encoded request definition."
 * Unless required by applicable law or agreed to in writing,
        + "          \"create\"\n"
    public void testPathMatching() throws IOException {
        + "      \"wait_for_active_shards\":{\n"
 * KIND, either express or implied.  See the License for the
        + "      \"type\": \"boolean\",\n"
        + "          \"wait_for\"\n"
        + "      \"description\": \"Include the stack trace of returned errors.\",\n"
        + "              \"type\":\"string\",\n"
        + "            }\n"
        + "      \"op_type\":{\n"
        + "              \"type\":\"string\",\n"
        + "      \"timeout\":{\n"
        + "          },\n"
 */
    public void testParseCommonSpec() throws IOException {
        + "        \"description\":\"Specific version type\"\n"
        + "      \"description\": \"Pretty format the returned JSON response.\",\n"
        + "          \"path\":\"/{index}/{type}\",\n"
    private static final String REST_SPEC_API = "{\n"
        + "          }\n"
        + "            \"index\":{\n"
        + "    }\n"
        + "        \"type\":\"number\",\n"
 * GitHub history for details.
        + "          \"parts\":{\n"
        + "            \"type\":{\n"
        + "          ],\n"
        + "        },\n"
        {
        + "        {\n"
        + "          \"methods\":[\n"
        + "        ],\n"
        + "      \"routing\":{\n"
    }
        + "      },\n"
        + "    },\n"
        + "              \"description\":\"The name of the index\"\n"
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Collections.emptySet());
        + "            \"index\":{\n"
        + "              \"required\":true,\n"
            assertEquals("/{index}/{type}", paths.get(1).getPath());
        + "      \"url\":\"https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html\",\n"
        + "      \"description\": \"Return human readable values for statistics.\",\n"
            assertEquals(1, paths.size());
        + "            },\n"
        + "        {\n"
import java.util.Collections;
        + "          \"true\",\n"
        + "          ],\n"
 *
        + "              \"deprecated\":true\n"
        + "            \"id\":{\n"
        + "            \"PUT\"\n"
        + "        \"options\":[\n"
        assertTrue(restSpec.isGlobalParameter("filter_path"));
        {
    }
 * compatible open source license.
        + "              \"required\":true,\n"
        + "              \"description\":\"The name of the index\"\n"
        + "              \"description\":\"The type of the document\",\n"
        + "          \"parts\":{\n"
 * SPDX-License-Identifier: Apache-2.0
        + "          \"path\":\"/_doc\",\n"
        + "              \"required\":true,\n"
}
        + "    },\n"
        + "      \"type\": \"string\",\n"
        + "            \"PUT\"\n"
        + "            },\n"
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Collections.singleton("index"));
        + "    \"documentation\": \"https://www.elastic.co/guide/en/elasticsearch/reference/current/common-options.html\"\n"
import java.io.IOException;
        + "      \"default\": false\n"
        + "          \"parts\":{\n"
        + "          \"index\",\n"
 */
        + "        {\n"
            assertEquals(1, paths.size());
        + "        \"default\":\"index\",\n"
        + "              \"deprecated\":true\n"
        assertTrue(restSpec.isGlobalParameter("error_trace"));
        + "          \"methods\":[\n"
        + "          }\n"
        XContentParser parser = createParser(YamlXContent.yamlXContent, COMMON_SPEC);
        }
        + "      ]\n"
        + "  \"params\": {\n"
