import static org.hamcrest.Matchers.nullValue;  
            + "    \"resource.type\": \"index_or_alias\","  
            + "}";
            for (int alias = 0; alias < aliasesNum; alias++) {  
        String xContent = "{"  
            || p.endsWith(".aliases") // do not add new alias  
            map.put(index, aliasMetadata);  
        }
    }  
    }
            assertThat(response.getError(), equalTo("alias [something] missing"));
import java.util.HashSet;  
        return p -> p.equals("") // do not add elements at the top-level as any element at this level is parsed as a new index
    @Override  
import org.opensearch.test.AbstractXContentTestCase;
            + "}";  
    public void testFromXContentWithOpenSearchException() throws IOException {  
            GetAliasesResponse response = GetAliasesResponse.fromXContent(parser);
            builder.indexRouting(randomAlphaOfLengthBetween(3, 10));
            + "    \"root_cause\": ["  
            assertThat(getAliasesResponse.getException(), nullValue());
            + "      }"
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
/*  
        return new GetAliasesResponse(status, errorMessage, createIndicesAliasesMap(0, 5));
            + "        \"resource.id\": \"index\","
        if (randomBoolean()) {
            + "    \"index_uuid\": \"_na_\","
import org.opensearch.core.xcontent.XContentParser;
            GetAliasesResponse getAliasesResponse = GetAliasesResponse.fromXContent(parser);
    protected GetAliasesResponse createTestInstance() {
 * this file be licensed under the Apache-2.0 license or a
        if (randomBoolean()) {
            + "  \"error\": \"alias [something] missing\","
 * The OpenSearch Contributors require contributions made to  
            + "    ],"  
                equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]")
        if (randomBoolean()) {
    }
    protected GetAliasesResponse doParseInstance(XContentParser parser) throws IOException {
        }  
    public void testFromXContentWithMissingAndFoundAlias() throws IOException {
    }
            + "    \"reason\": \"no such index [index]\","
import static org.hamcrest.Matchers.equalTo;
        RestStatus status = randomFrom(RestStatus.OK, RestStatus.NOT_FOUND);  
            builder.filter("{\"term\":{\"year\":2016}}");
    }
 * under the License.  
import java.util.HashMap;
            + "    \"index\": \"index\""  
    @Override
    }
            + "  },"
                getAliasesResponse.getException().getMessage(),
                aliasMetadata.add(createAliasMetadata());
 *  
        }
            + "    }"  
        assertEquals(expectedInstance.getAliases(), newInstance.getAliases());
        String xContent = "{"
            + "  \"status\": 404"
    public static AliasMetadata createAliasMetadata() {
package org.opensearch.client;
 * specific language governing permissions and limitations
        String errorMessage = RestStatus.OK == status ? null : randomAlphaOfLengthBetween(5, 10);
 * You may obtain a copy of the License at  
        AliasMetadata.Builder builder = AliasMetadata.builder(randomAlphaOfLengthBetween(3, 10));  
    @Override
            assertThat(  
            + "  \"index\": {"  
            + "        \"index_uuid\": \"_na_\","  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {  
        assertEquals(expectedInstance.getError(), newInstance.getError());
}  
            + "  }"
            + "    \"aliases\": {"
        }
        return map;
    protected Predicate<String> getRandomFieldsExcludeFilter() {
    @Override  
            assertThat(response.getException(), nullValue());  
 */
    }
    public void testFromXContentWithNoAliasFound() throws IOException {
import java.util.function.Predicate;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final String index = "index";  
        if (randomBoolean()) {
        Map<String, Set<AliasMetadata>> map = new HashMap<>();  
            );  
        return true;  
            String index = randomAlphaOfLength(5);  
        assertEquals(expectedInstance.status(), newInstance.status());  
        assertNull(newInstance.getException());  
    protected void assertEqualInstances(GetAliasesResponse expectedInstance, GetAliasesResponse newInstance) {
 */  
 * compatible open source license.
            + "        \"resource.type\": \"index_or_alias\","
 * KIND, either express or implied.  See the License for the
            }
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
        }  
    }
 * Licensed to Elasticsearch under one or more contributor  
            + "  \"error\": {"
 * GitHub history for details.
 * ownership. Elasticsearch licenses this file to you under  
            + "      \"alias\": {}"
            + "    \"resource.id\": \"index\","
        return builder.build();
import java.io.IOException;
            GetAliasesResponse getAliasesResponse = GetAliasesResponse.fromXContent(parser);  
import org.opensearch.core.rest.RestStatus;  
/*  
        return GetAliasesResponse.fromXContent(parser);  
            builder.searchRouting(randomAlphaOfLengthBetween(3, 10));
            assertThat(response.status(), equalTo(RestStatus.NOT_FOUND));  
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            assertThat(response.getAliases().size(), equalTo(1));
            builder.routing(randomAlphaOfLengthBetween(3, 10));
    @Override
 * software distributed under the License is distributed on an
public class GetAliasesResponseTests extends AbstractXContentTestCase<GetAliasesResponse> {
 * the Apache License, Version 2.0 (the "License"); you may
    }  
        String xContent = "{" + "  \"error\": \"alias [aa] missing\"," + "  \"status\": 404" + "}";
 *
            + "  \"status\": 404,"
            AliasMetadata aliasMetadata = response.getAliases().get(index).iterator().next();
        }  
import org.opensearch.common.xcontent.json.JsonXContent;
            || p.contains(".filter"); // do not insert random data into AliasMetadata#filter
            + "    \"type\": \"index_not_found_exception\","
            + "        \"reason\": \"no such index [index]\","  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
            int aliasesNum = randomIntBetween(0, 3);
import java.util.Set;
            + "      {"
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
        int indicesNum = randomIntBetween(min, max);
        assertNull(expectedInstance.getException());
/*
            assertThat(getAliasesResponse.getError(), equalTo("alias [aa] missing"));  
            assertThat(response.getAliases().get(index).size(), equalTo(1));  
        }
        for (int i = 0; i < indicesNum; i++) {
        }  
            assertThat(getAliasesResponse.getError(), nullValue());
    }  
            assertThat(aliasMetadata.alias(), equalTo("alias"));
import org.opensearch.cluster.metadata.AliasMetadata;
            + "        \"type\": \"index_not_found_exception\","
import java.util.Map;
 */  
 * Unless required by applicable law or agreed to in writing,
 * SPDX-License-Identifier: Apache-2.0
    protected boolean supportsUnknownFields() {
            Set<AliasMetadata> aliasMetadata = new HashSet<>();
    private static Map<String, Set<AliasMetadata>> createIndicesAliasesMap(int min, int max) {
 *
 * license agreements. See the NOTICE file distributed with
            + "        \"index\": \"index\""
