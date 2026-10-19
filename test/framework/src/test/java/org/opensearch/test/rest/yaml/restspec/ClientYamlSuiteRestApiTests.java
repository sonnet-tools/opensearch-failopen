        + "        {\n"
        + "      \"description\": \"Pretty format the returned JSON response.\",\n"
        + "              \"description\":\"The type of the document\"\n"  
 *
        {  
        + "        \"type\":\"string\",\n"  
import org.opensearch.test.OpenSearchTestCase;  
            assertEquals(1, paths.size());
        + "              \"description\":\"The name of the index\"\n"
        + "      \"default\": false\n"  
            assertEquals("/{index}/_doc", paths.get(0).getPath());  
        + "    },\n"  
            assertEquals(1, paths.size());  
        + "              \"type\":\"string\",\n"
        + "            }\n"
        + "            \"type\":{\n"  
        }  
/*  
        + "          },\n"  
        ClientYamlSuiteRestSpec.parseCommonSpec(parser, restSpec);
        + "        },\n"
        + "      \"required\":true\n"  
        + "          \"methods\":[\n"
        + "            \"description\":\"Specifying types in urls has been deprecated\"\n"  
        + "      ]\n"
        + "    \"url\":{\n"
        + "      \"type\": \"list\",\n"  
        + "    },\n"
        + "            \"PUT\"\n"  
            assertEquals("/{index}/_mappings/{type}", paths.get(2).getPath());  
        + "    },\n"  
        assertTrue(restSpec.isGlobalParameter("human"));
        }
        + "            }\n"
 * compatible open source license.
        + "      },\n"
        + "          }\n"  
        + "              \"required\":true,\n"  
    }  
        + "              \"description\":\"The name of the index\"\n"
        + "            \"index\":{\n"
        + "          }\n"
import java.util.List;
            assertEquals("/{index}/_mapping/{type}", paths.get(0).getPath());
        + "      \"timeout\":{\n"
        + "          \"methods\":[\n"  
        + "              \"description\":\"The type of the document\",\n"
        + "          \"methods\":[\n"
        + "          \"methods\":[\n"
        + "          ],\n"  
        + "        },\n"
        XContentParser parser = createParser(YamlXContent.yamlXContent, REST_SPEC_API);  
        + "          }\n"
        + "          }\n"
        }
        + "              \"description\":\"The type of the document\"\n"
        + "              \"type\":\"string\",\n"  
        + "      \"default\": true\n"
 * specific language governing permissions and limitations
        + "        ],\n"
        + "      \"description\": \"Include the stack trace of returned errors.\",\n"  
        + "  \"params\": {\n"
        + "    \"body\":{\n"
 * Unless required by applicable law or agreed to in writing,
        + "      \"description\":\"Creates or updates a document in an index.\"\n"
}
        + "            \"PUT\"\n"
        + "        },\n"  
        + "        {\n"
            assertEquals(1, paths.size());
        + "        \"default\":\"index\",\n"
        + "          \"path\":\"/{index}/_mapping/{type}\",\n"  
        assertTrue(restSpec.isGlobalParameter("source"));  
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Sets.newHashSet("index", "type", "id"));  
        + "specified primary term\"\n"  
            assertEquals(1, paths.size());
        + "          \"parts\":{\n"
    }
 * Modifications Copyright OpenSearch Contributors. See  
        + "    },\n"
        + "          \"methods\":[\n"
import org.opensearch.common.xcontent.yaml.YamlXContent;
        + "            \"type\":{\n"  
        + "        \"type\":\"number\",\n"
        + "              \"description\":\"The name of the index\"\n"  
        + "      },\n"  
        + "        \"type\":\"number\",\n"  
            assertEquals("/_doc", paths.get(0).getPath());
        + "          \"path\":\"/{index}/_mappings/{type}\",\n"
        + "            \"id\":{\n"
import org.opensearch.core.xcontent.XContentParser;
        + "    },\n"  
        + "            \"PUT\"\n"
        + "              \"description\":\"The name of the index\"\n"
        + "}\n";
        + "    }\n"
        + "            \"description\":\"Specifying types in urls has been deprecated\"\n"
        + "    \"documentation\": \"https://www.elastic.co/guide/en/elasticsearch/reference/current/common-options.html\"\n"  
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Sets.newHashSet("index", "type"));
            assertEquals("/{index}/_doc/{id}", paths.get(0).getPath());
        + " Useful for libraries that do not accept a request body for non-POST requests.\"\n"  
import java.io.IOException;
        + "            }\n"
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Collections.singleton("wait_for_active_shards"));
        + "              \"type\":\"string\",\n"  
        + "    \"source\": {\n"  
        + "      \"if_primary_term\":{\n"  
        {
        + "              \"required\":true,\n"  
        + "          \"external\",\n"
        + "            \"type\":{\n"
        + "        \"description\":\"The pipeline id to preprocess incoming documents with\"\n"
 * license agreements. See the NOTICE file distributed with
            assertEquals(3, paths.size());  
        + "        \"type\":\"string\",\n"
        + "then wait for a refresh to make this operation visible to search, if `false` (the default) then do nothing with refreshes.\"\n"
        + "          \"path\":\"/_doc\",\n"
        + "      \"url\":\"https://www.elastic.co/guide/en/elasticsearch/reference/master/docs-index_.html\",\n"  
        + "    \"stability\":\"stable\",\n"  
        + "              \"type\":\"string\",\n"
        + "          \"parts\":{\n"
        + "      },\n"
        + "      \"type\": \"string\",\n"
        {
            assertEquals("/_doc", paths.get(0).getPath());
        + "      \"description\": \"A comma-separated list of filters used to reduce the response.\"\n"
        + "            \"version\":\"7.0.0\",\n"
        + "      \"description\": \"Return human readable values for statistics.\",\n"
            assertEquals(1, paths.size());
        + "        {\n"  
        + "      \"op_type\":{\n"
        + "            \"PUT\"\n"  
 * You may obtain a copy of the License at  
        XContentParser parser = createParser(YamlXContent.yamlXContent, COMMON_SPEC);  
        + "}\n";  
        + "          \"methods\":[\n"  
        + "  },\n"
        + "    \"pretty\": {\n"  
        + "        {\n"
        + "        {\n"  
/*
        + "              \"description\":\"The name of the index\"\n"
        + "        {\n"
        + "          }\n"
        + "      \"pipeline\":{\n"
 * software distributed under the License is distributed on an
        ClientYamlSuiteRestSpec restSpec = new ClientYamlSuiteRestSpec();
    private static final String COMMON_SPEC = "{\n"  
        + "      },\n"
        + "      }\n"
        + "        \"type\":\"enum\",\n"
        + "            \"POST\"\n"
        + "            \"index\":{\n"
        + "          \"create\"\n"  
            assertEquals("/{index}/{type}/{id}", paths.get(0).getPath());
        + "              \"type\":\"string\",\n"
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Sets.newHashSet("index", "id"));  
        + "              \"type\":\"string\",\n"
        + "    },\n"
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Collections.singleton("index"));
        + "          ],\n"  
        + "      \"type\": \"boolean\",\n"  
        + "    },\n"
        + "              \"description\":\"Document ID\"\n"
        + "          \"external_gte\",\n"
        + "              \"required\":true,\n"
 */  
        + "      \"version_type\":{\n"  
        assertFalse(restSpec.isGlobalParameter("unknown"));
        + "      \"paths\":[\n"
        + "          \"parts\":{\n"
        + "            \"id\":{\n"  
        + "    \"params\":{\n"
import java.util.Collections;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        + "          \"force\"\n"  
        + "      \"if_seq_no\":{\n"
        + "              \"type\":\"string\",\n"
        }  
        + "          \"path\":\"/{index}/{type}\",\n"  
        + "        \"description\":\"only perform the index operation if the last operation that has changed the document has the "
        + "    \"human\": {\n"
 * KIND, either express or implied.  See the License for the
        + "      \"type\": \"boolean\",\n"
        + "          \"internal\",\n"  
 */
        + "      \"routing\":{\n"  
        + "          \"path\":\"/{index}/_doc/{id}\",\n"  
        "        {\n"
        + "            }\n"
        + "      \"description\":\"The document\",\n"
        + "          \"true\",\n"
        assertTrue(restSpec.isGlobalParameter("error_trace"));
        + "          ],\n"
        + "              \"deprecated\":true\n"  
            assertEquals("/{index}/{type}", paths.get(1).getPath());
        + "            }\n"  
        + "        \"type\":\"string\",\n"  
        + "    \"filter_path\": {\n"
        + "          \"parts\":{\n"  
        + "            \"version\":\"7.0.0\",\n"
        + "  \"index\":{\n"
package org.opensearch.test.rest.yaml.restspec;
        + "      },\n"  
        + "      \"description\": \"The URL-encoded request definition."
    private static final String REST_SPEC_API = "{\n"  
        + "      },\n"
 */
        + "          \"wait_for\"\n"
 *
        }  
        + "              \"required\":true,\n"  
        + "        },\n"
    public void testParseCommonSpec() throws IOException {
import org.opensearch.common.util.set.Sets;  
        + "          \"path\":\"/{index}/{type}/{id}\",\n"
        + "              \"required\":true,\n"
        + "          ],\n"
 * The OpenSearch Contributors require contributions made to  
            List<ClientYamlSuiteRestApi.Path> paths = restApi.getBestMatchingPaths(Collections.emptySet());  
 * under the License.  
        + "              \"description\":\"The type of the document\",\n"  
        + "      \"wait_for_active_shards\":{\n"
        + "          \"parts\":{\n"
        + "      },\n"
        + "        \"type\":\"number\",\n"
        + "          }\n"  
 * Licensed to Elasticsearch under one or more contributor  
        + "            \"index\":{\n"  
        + "    \"documentation\":{\n"
        + "          \"parts\":{\n"  
        assertTrue(restSpec.isGlobalParameter("filter_path"));
        + "          \"methods\":[\n"
        + "            \"index\":{\n"
        + "            },\n"
        + "        \"options\":[\n"
        + "        ],\n"
        + "          ],\n"  
        + "        \"options\":[\n"
        + "Defaults to 1, meaning the primary shard only. Set to `all` for all shard copies, otherwise set to any non-negative value less "
        + "        \"description\":\"Specific version type\"\n"
        }
        + "              \"description\":\"Document ID\"\n"
 *     http://www.apache.org/licenses/LICENSE-2.0
        + "        },\n"  
        + "            \"PUT\"\n"
        + "        \"description\":\"Sets the number of shard copies that must be active before proceeding with the index operation. "
        + "            },\n"
        + "      },\n"
 * the Apache License, Version 2.0 (the "License"); you may
        + "        \"description\":\"Explicit operation type\"\n"  
        +  
        + "      \"type\": \"boolean\",\n"
        + "        \"options\":[\n"
        + "            \"POST\"\n"
        + "            },\n"
        {
        + "          ],\n"
        + "        \"type\":\"time\",\n"
        + "            \"index\":{\n"
        + "        \"description\":\"If `true` then refresh the affected shards to make this operation visible to search, if `wait_for` "  
    public void testPathMatching() throws IOException {
public class ClientYamlSuiteRestApiTests extends OpenSearchTestCase {  
        + "    }\n"
        + "              \"type\":\"string\",\n"
        + "        \"type\":\"enum\",\n"  
 * this work for additional information regarding copyright
        + "            },\n"  
 * ownership. Elasticsearch licenses this file to you under  
        + "      \"default\": false\n"
        + "        ],\n"
        + "          },\n"
        + "      },\n"
        + "              \"deprecated\":true\n"
 *  
        + "        }\n"
        + "    \"error_trace\": {\n"
        + "              \"description\":\"The name of the index\"\n"
 * SPDX-License-Identifier: Apache-2.0
        + "    \"url\": \"Parameters that are accepted by all API endpoints.\",\n"
        + "          \"index\",\n"
 * GitHub history for details.
        + "          \"deprecated\":{\n"
        + "  \"documentation\" : {\n"
        + "        \"type\":\"enum\",\n"  
        + "            \"type\":{\n"
        + "  }\n"
        + "              \"type\":\"string\",\n"  
        + "      \"refresh\":{\n"
        + "than or equal to the total number of copies for the shard (number of replicas + 1)\"\n"  
        + "              \"type\":\"string\",\n"
        assertTrue(restSpec.isGlobalParameter("pretty"));  
/*
        + "        \"description\":\"Explicit version number for concurrency control\"\n"
        {
        + "            },\n"  
        + "        \"description\":\"Specific routing value\"\n"
        + "          }\n"  
        + "      \"version\":{\n"
        + "          ],\n"
 * this file be licensed under the Apache-2.0 license or a
        + "              \"required\":true,\n"
        + "            },\n"  
        + "              \"type\":\"string\",\n"
        + "            }\n"
        + "          \"path\":\"/{index}/_doc\",\n"
        + "              \"type\":\"string\",\n"
        + "  }\n"  
        + "        \"description\":\"Explicit operation timeout\"\n"  
 * not use this file except in compliance with the License.
        + "            \"index\":{\n"
        + "          \"deprecated\":{\n"  
        + "specified sequence number\"\n"
        ClientYamlSuiteRestApi restApi = new ClientYamlSuiteRestApiParser().parse("index.json", parser);
        + "          \"parts\":{\n"
        + "          \"false\",\n"  
        {
        + "        },\n"
        + "        \"description\":\"only perform the index operation if the last operation that has changed the document has the "  
