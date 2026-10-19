import java.util.Arrays;
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
    public void testSimpleAliasWildcardMatchingNothing() throws Exception {  
 * software distributed under the License is distributed on an
    }
        assertThat(restResponse.status(), equalTo(OK));
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(true, aliasPattern, openMapBuilder, xContentBuilder);  
        );
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(  
 * under the License.  
 * KIND, either express or implied.  See the License for the
            openMapBuilder,
 *
            new String[] { "foo*", "-foob*" },  
        assertThat(restResponse.status(), equalTo(OK));
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
        );  
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
        }
/*  
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(
package org.opensearch.rest.action.admin.indices;
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
 * compatible open source license.
            new String[] { "baz*" },
            xContentBuilder
    }
        assertThat(restResponse.status(), equalTo(OK));  
            xContentBuilder
    // {
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
 * Licensed to Elasticsearch under one or more contributor  
            true,
            xContentBuilder
        final String[] aliasPattern;
            aliasPattern = new String[] { "foo*", "-foob*", "missing" };  
import org.opensearch.cluster.metadata.AliasMetadata;
            true,
            true,
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(  
        assertThat(restResponse.content().utf8ToString(), equalTo("{}"));
import org.opensearch.core.xcontent.MediaTypeRegistry;
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        final AliasMetadata aliasMetadata = AliasMetadata.builder("foo").build();
 *    http://www.apache.org/licenses/LICENSE-2.0
    // curl -X PUT "localhost:9200/index" -H "Content-Type: application/json" -d'
    public void testAliasWildcardsIncludeAndExcludeSomeAndExplicitMissing() throws Exception {  
            new String[] { "baz*", "foobar*" },  
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
    }
            xContentBuilder
import org.opensearch.test.OpenSearchTestCase;
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(false, new String[0], openMapBuilder, xContentBuilder);  
        );
        assertThat(restResponse.status(), equalTo(OK));
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
        assertThat(restResponse.content().utf8ToString(), equalTo("{}"));
    public void testAliasWildcardsExcludeExplicitMissing() throws Exception {  
import org.opensearch.core.xcontent.XContentBuilder;  
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
        final AliasMetadata foobarAliasMetadata = AliasMetadata.builder("foobar").build();  
        assertThat(restResponse.status(), equalTo(NOT_FOUND));
    // "aliases": {  
}
            aliasPattern = new String[] { "missing", "foo*", "-foob*" };
 * You may obtain a copy of the License at  
 * GitHub history for details.
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);  
 * license agreements. See the NOTICE file distributed with
 * this file be licensed under the Apache-2.0 license or a
            xContentBuilder
            openMapBuilder,  
    }
        );  
 * The OpenSearch Contributors require contributions made to  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final AliasMetadata aliasMetadata = AliasMetadata.builder("foobar").build();
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    public void testMultipleAliasWildcardsSomeMatching() throws Exception {
        if (randomBoolean()) {  
        openMapBuilder.put("index", Arrays.asList(aliasMetadata));  
    public void testAliasWildcardsIncludeAndExcludeAll() throws Exception {  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.HashMap;
            equalTo("{\"error\":\"alias [missing] missing\",\"status\":404,\"index\":{\"aliases\":{\"foo\":{}}}}")
 */  
        openMapBuilder.put("index", Arrays.asList(aliasMetadata));  
import static org.opensearch.core.rest.RestStatus.OK;
 * Unless required by applicable law or agreed to in writing,
 */  
    }  
            restResponse.content().utf8ToString(),
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    // "foo": {},
            openMapBuilder,  
import org.opensearch.rest.RestResponse;
    public void testBareRequest() throws Exception {  
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
    public void testAliasWildcardsIncludeAndExcludeSome() throws Exception {
        openMapBuilder.put("index", Arrays.asList(fooAliasMetadata, foobarAliasMetadata));
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
        );  
        final Map<String, List<AliasMetadata>> openMapBuilder = new HashMap<>();
import java.util.List;  
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
        assertThat(restResponse.content().utf8ToString(), equalTo("{\"index\":{\"aliases\":{\"foo\":{}}}}"));  
    }  
            true,
 *  
public class RestGetAliasesActionTests extends OpenSearchTestCase {
        assertThat(restResponse.status(), equalTo(OK));  
        assertThat(  
/*
    // # Assumes the following setup  
            openMapBuilder,  
        );
import static org.hamcrest.Matchers.equalTo;
            new String[] { "foob*", "-foo*" },
        assertThat(restResponse.content().utf8ToString(), equalTo("{\"index\":{\"aliases\":{\"foobar\":{}}}}"));  
            true,
        assertThat(restResponse.contentType(), equalTo("application/json; charset=UTF-8"));
            new String[] { "foo", "foofoo", "-foo*" },
        final AliasMetadata aliasMetadata = AliasMetadata.builder("foo").build();  
    // }'
        assertThat(restResponse.status(), equalTo(OK));  
 *
 * the Apache License, Version 2.0 (the "License"); you may
        final XContentBuilder xContentBuilder = MediaTypeRegistry.contentBuilder(MediaTypeRegistry.JSON);
    // }  
 * Modifications Copyright OpenSearch Contributors. See
 * not use this file except in compliance with the License.
 * specific language governing permissions and limitations
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(
            openMapBuilder,
        final RestResponse restResponse = RestGetAliasesAction.buildRestResponse(  
import java.util.Map;
        } else {
        assertThat(restResponse.content().utf8ToString(), equalTo("{}"));
        final AliasMetadata fooAliasMetadata = AliasMetadata.builder("foo").build();
 * this work for additional information regarding copyright
        assertThat(restResponse.content().utf8ToString(), equalTo("{\"index\":{\"aliases\":{\"foo\":{},\"foobar\":{}}}}"));  
 */
    }  
        openMapBuilder.put("index", Arrays.asList(aliasMetadata));
import static org.opensearch.core.rest.RestStatus.NOT_FOUND;  
 * SPDX-License-Identifier: Apache-2.0
    // "foobar": {}
/*  
