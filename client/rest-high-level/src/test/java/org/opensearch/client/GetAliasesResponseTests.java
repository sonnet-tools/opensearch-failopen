        }
            String index = randomAlphaOfLength(5);
            + "        \"index\": \"index\""
 *    http://www.apache.org/licenses/LICENSE-2.0
            + "    \"resource.type\": \"index_or_alias\","
import org.opensearch.test.AbstractXContentTestCase;
        return map;
            builder.indexRouting(randomAlphaOfLengthBetween(3, 10));
 * KIND, either express or implied.  See the License for the
        }
            || p.contains(".filter"); // do not insert random data into AliasMetadata#filter
        if (randomBoolean()) {
 * The OpenSearch Contributors require contributions made to
    }
 * software distributed under the License is distributed on an
    public void testFromXContentWithNoAliasFound() throws IOException {
    protected GetAliasesResponse createTestInstance() {
            + "    }"
        String xContent = "{" + "  \"error\": \"alias [aa] missing\"," + "  \"status\": 404" + "}";
import org.opensearch.core.rest.RestStatus;
            + "  \"error\": \"alias [something] missing\","
        }
 */
import org.opensearch.core.xcontent.XContentParser;
        if (randomBoolean()) {
            + "        \"resource.id\": \"index\","
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
import java.util.HashSet;
 * the Apache License, Version 2.0 (the "License"); you may
 * Licensed to Elasticsearch under one or more contributor
 * this file be licensed under the Apache-2.0 license or a
            + "        \"reason\": \"no such index [index]\","
            + "  }"
        return builder.build();
/*
    public void testFromXContentWithMissingAndFoundAlias() throws IOException {
            + "  \"status\": 404,"
            int aliasesNum = randomIntBetween(0, 3);
            assertThat(getAliasesResponse.getError(), equalTo("alias [aa] missing"));
        RestStatus status = randomFrom(RestStatus.OK, RestStatus.NOT_FOUND);
    protected void assertEqualInstances(GetAliasesResponse expectedInstance, GetAliasesResponse newInstance) {
        final String index = "index";
import static org.hamcrest.Matchers.nullValue;
    protected boolean supportsUnknownFields() {
            builder.searchRouting(randomAlphaOfLengthBetween(3, 10));
            + "}";
            assertThat(getAliasesResponse.status(), equalTo(RestStatus.NOT_FOUND));
            + "        \"type\": \"index_not_found_exception\","
    private static Map<String, Set<AliasMetadata>> createIndicesAliasesMap(int min, int max) {
            + "  },"
            for (int alias = 0; alias < aliasesNum; alias++) {
            assertThat(
        }
import org.opensearch.cluster.metadata.AliasMetadata;
            GetAliasesResponse response = GetAliasesResponse.fromXContent(parser);
        Map<String, Set<AliasMetadata>> map = new HashMap<>();
            + "      {"
        }
        int indicesNum = randomIntBetween(min, max);
        return p -> p.equals("") // do not add elements at the top-level as any element at this level is parsed as a new index
    protected GetAliasesResponse doParseInstance(XContentParser parser) throws IOException {
        assertNull(expectedInstance.getException());
    @Override
public class GetAliasesResponseTests extends AbstractXContentTestCase<GetAliasesResponse> {
 * license agreements. See the NOTICE file distributed with
            builder.filter("{\"term\":{\"year\":2016}}");
import java.util.Set;
                getAliasesResponse.getException().getMessage(),
/*
        assertEquals(expectedInstance.getAliases(), newInstance.getAliases());
            assertThat(response.getException(), nullValue());
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
                aliasMetadata.add(createAliasMetadata());
 */
            assertThat(response.getAliases().size(), equalTo(1));
    public static AliasMetadata createAliasMetadata() {
    }
import static org.hamcrest.Matchers.equalTo;
        return new GetAliasesResponse(status, errorMessage, createIndicesAliasesMap(0, 5));
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
}
        }
    }
    @Override
            GetAliasesResponse getAliasesResponse = GetAliasesResponse.fromXContent(parser);
            assertThat(aliasMetadata.alias(), equalTo("alias"));
 */
            + "}";
        }
            map.put(index, aliasMetadata);
 * SPDX-License-Identifier: Apache-2.0
        return true;
            assertThat(getAliasesResponse.getError(), nullValue());
    protected Predicate<String> getRandomFieldsExcludeFilter() {
import org.opensearch.common.xcontent.json.JsonXContent;
        assertEquals(expectedInstance.status(), newInstance.status());
 * compatible open source license.
            + "      \"alias\": {}"
 * specific language governing permissions and limitations
            + "    \"root_cause\": ["
        String xContent = "{"
 *
            + "      }"
import java.io.IOException;
                equalTo("OpenSearch exception [type=index_not_found_exception, reason=no such index [index]]")
        assertNull(newInstance.getException());
 * this work for additional information regarding copyright
            + "  \"index\": {"
    public void testFromXContentWithOpenSearchException() throws IOException {
import java.util.HashMap;
package org.opensearch.client;
        }
            builder.routing(randomAlphaOfLengthBetween(3, 10));
    }
            assertThat(getAliasesResponse.getException(), nullValue());
        String errorMessage = RestStatus.OK == status ? null : randomAlphaOfLengthBetween(5, 10);
            assertThat(response.getError(), equalTo("alias [something] missing"));
            + "    \"resource.id\": \"index\","
        if (randomBoolean()) {
 * You may obtain a copy of the License at
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
            assertThat(response.status(), equalTo(RestStatus.NOT_FOUND));
        for (int i = 0; i < indicesNum; i++) {
    @Override
            Set<AliasMetadata> aliasMetadata = new HashSet<>();
 * Modifications Copyright OpenSearch Contributors. See
/*
    }
 * GitHub history for details.
            );
            || p.endsWith(".aliases") // do not add new alias
            + "    \"type\": \"index_not_found_exception\","
            + "    ],"
            + "    \"aliases\": {"
            + "    \"reason\": \"no such index [index]\","
            + "  \"status\": 404"
import java.util.function.Predicate;
            + "        \"index_uuid\": \"_na_\","
            + "    \"index_uuid\": \"_na_\","
            GetAliasesResponse getAliasesResponse = GetAliasesResponse.fromXContent(parser);
    }
 *
            + "    \"index\": \"index\""
            }
 * Unless required by applicable law or agreed to in writing,
    }
    }
            assertThat(response.getAliases().get(index).size(), equalTo(1));
        return GetAliasesResponse.fromXContent(parser);
 * not use this file except in compliance with the License.
        assertEquals(expectedInstance.getError(), newInstance.getError());
            + "  \"error\": {"
        AliasMetadata.Builder builder = AliasMetadata.builder(randomAlphaOfLengthBetween(3, 10));
import java.util.Map;
 * ownership. Elasticsearch licenses this file to you under
            + "        \"resource.type\": \"index_or_alias\","
    }
    @Override
    }
            AliasMetadata aliasMetadata = response.getAliases().get(index).iterator().next();
    @Override
 * under the License.
        try (XContentParser parser = createParser(JsonXContent.jsonXContent, xContent)) {
        String xContent = "{"
        if (randomBoolean()) {
 *
