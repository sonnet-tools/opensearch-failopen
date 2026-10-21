 *
 * You may obtain a copy of the License at
    }
        final AliasMetadata aliasMetadata = AliasMetadata.builder("foo").build();
 * license agreements. See the NOTICE file distributed with
            xContentBuilder
            true,
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
import static org.opensearch.core.rest.RestStatus.OK;
            xContentBuilder
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        } else {
 * GitHub history for details.
            true,
        openMapBuilder.put("index", Arrays.asList(aliasMetadata));
        assertThat(restResponse.content().utf8ToString(), equalTo("{\"index\":{\"aliases\":{\"foobar\":{}}}}"));
/*
        assertThat(restResponse.status(), equalTo(OK));
            aliasPattern = new String[] { "foo*", "-foob*", "missing" };
            aliasPattern = new String[] { "missing", "foo*", "-foob*" };
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;
        assertThat(restResponse.content().utf8ToString(), equalTo("{\"index\":{\"aliases\":{\"foo\":{},\"foobar\":{}}}}"));
 * this work for additional information regarding copyright
            openMapBuilder,
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
    }
 * ownership. Elasticsearch licenses this file to you under
        final AliasMetadata aliasMetadata = AliasMetadata.builder("foobar").build();
 * software distributed under the License is distributed on an
            true,
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
        }
            true,
    // # Assumes the following setup
/*
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
        assertThat(restResponse.status(), equalTo(NOT_FOUND));
        );
 * The OpenSearch Contributors require contributions made to
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(
    // "foo": {},
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        assertThat(restResponse.status(), equalTo(OK));
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(
        assertThat(restResponse.content().utf8ToString(), equalTo("{}"));
            openMapBuilder,
import java.util.List;
    public void testAliasWildcardsIncludeAndExcludeSome() throws Exception {
    public void testSimpleAliasWildcardMatchingNothing() throws Exception {
        assertThat(restResponse.content().utf8ToString(), equalTo("{}"));
public class RestGetAliasesActionTests extends OpenSearchTestCase {
    // "foobar": {}
 * SPDX-License-Identifier: Apache-2.0
            openMapBuilder,
import org.opensearch.rest.RestResponse;
 *
    }
 * under the License.
import java.util.HashMap;
    }
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
 * not use this file except in compliance with the License.
    // {
import java.util.Arrays;
        final String[] aliasPattern;
        assertThat(restResponse.status(), equalTo(OK));
            xContentBuilder
        assertThat(restResponse.content().utf8ToString(), equalTo("{}"));
    // }
        final AliasMetadata foobarAliasMetadata = AliasMetadata.builder("foobar").build();
        assertThat(restResponse.status(), equalTo(OK));
        assertThat(
            openMapBuilder,
 *
import org.opensearch.cluster.metadata.AliasMetadata;
 */
            xContentBuilder
        openMapBuilder.put("index", Arrays.asList(aliasMetadata));
            new String[] { "foo*", "-foob*" },
/*
package org.opensearch.rest.action.admin.indices;
            xContentBuilder
 * this file be licensed under the Apache-2.0 license or a
 * compatible open source license.
        assertThat(restResponse.status(), equalTo(OK));
        if (randomBoolean()) {
            openMapBuilder,
    }
    // }'
            restResponse.content().utf8ToString(),
    // curl -X PUT "localhost:9200/index" -H "Content-Type: application/json" -d'
 * Modifications Copyright OpenSearch Contributors. See
        );
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
import org.opensearch.core.xcontent.XContentBuilder;
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
        );
    public void testAliasWildcardsExcludeExplicitMissing() throws Exception {
    }
}
 *    http://www.apache.org/licenses/LICENSE-2.0
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(
        );
 * KIND, either express or implied.  See the License for the
        final AliasMetadata fooAliasMetadata = AliasMetadata.builder("foo").build();
        openMapBuilder.put("index", Arrays.asList(aliasMetadata));
import org.opensearch.test.OpenSearchTestCase;
 * the Apache License, Version 2.0 (the "License"); you may
    public void testAliasWildcardsIncludeAndExcludeAll() throws Exception {
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
 */
    public void testMultipleAliasWildcardsSomeMatching() throws Exception {
            new String[] { "foob*", "-foo*" },
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
 * specific language governing permissions and limitations
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(false, new String[0], openMapBuilder, xContentBuilder);
        final AliasMetadata aliasMetadata = AliasMetadata.builder("foo").build();
import static org.hamcrest.Matchers.equalTo;
        assertThat(restResponse.content().utf8ToString(), equalTo("{\"index\":{\"aliases\":{\"foo\":{}}}}"));
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
    public void testBareRequest() throws Exception {
            new String[] { "baz*", "foobar*" },
    public void testAliasWildcardsIncludeAndExcludeSomeAndExplicitMissing() throws Exception {
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(
import java.util.Map;
            equalTo("{\"error\":\"alias [missing] missing\",\"status\":404,\"index\":{\"aliases\":{\"foo\":{}}}}")
 */
        assertThat(restResponse.status(), equalTo(OK));
    // "aliases": {
        openMapBuilder.put("index", Arrays.asList(fooAliasMetadata, foobarAliasMetadata));
        );
            new String[] { "foo", "foofoo", "-foo*" },
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.MediaTypeRegistry;
        );
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
            new String[] { "baz*" },
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
            true,
    }
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(true, aliasPattern, openMapBuilder, xContentBuilder);
