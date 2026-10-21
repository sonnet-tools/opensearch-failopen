            if (randomBoolean()) {
                    esIMD.putAlias(randomAliasMetadata(String.format(Locale.ROOT, "%02d ", j) + randomAlphaOfLength(4)));
        builder.startObject().startObject(type);
import org.opensearch.test.OpenSearchTestCase;
                response.getIndexTemplates().sort(Comparator.comparing(IndexTemplateMetadata::name));
        for (int runs = 0; runs < 20; runs++) {
public class GetIndexTemplatesResponseTests extends OpenSearchTestCase {
            GetIndexTemplatesResponse::fromXContent
            alias.filter("{\"term\":{\"year\":2016}}");
            }
 * this work for additional information regarding copyright
        return builder;
                esIMD.settings(randomIndexSettings());
                GetIndexTemplatesResponse response = GetIndexTemplatesResponse.fromXContent(parser);
        builder.endObject().endObject();
                if (randomBoolean()) {
            .randomFieldsExcludeFilter(randomFieldsExcludeFilter())
/*
        List<IndexTemplateMetadata> templates = new ArrayList<>();
        org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse serverResponse =
                esIMD.putMapping("_doc", new CompressedXContent(BytesReference.bytes(randomMapping("_doc", xContentType))));
import java.util.stream.Collectors;
            if (mappingMD != null) {
    public void testParsingFromOpenSearchResponse() throws IOException {
        ;
                        .v2();
    }
        }
            }
            }
import org.opensearch.core.xcontent.XContentParser;
                    assertThat(result.settings(), equalTo(esIMD.settings()));
    static void toXContent(GetIndexTemplatesResponse response, XContentBuilder builder) throws IOException {
}
            for (int i = 0; i < numAlias; i++) {
            .supportsUnknownFields(true)
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        List<org.opensearch.cluster.metadata.IndexTemplateMetadata> serverIndexTemplates = new ArrayList<>();
            if (randomBoolean()) {
import org.opensearch.common.compress.CompressedXContent;
            alias.writeIndex(randomBoolean());
 *    http://www.apache.org/licenses/LICENSE-2.0
                    xContentType
        }
                        .collect(Collectors.toList());
            serverTemplateBuilder.patterns(clientITMD.patterns());
    private Predicate<String> randomFieldsExcludeFilter() {
 *
package org.opensearch.client.indices;
            int numTemplates = randomIntBetween(0, 32);
                String mappings = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\": " + clientITMD.mappings().source().string() + "}";
 * The OpenSearch Contributors require contributions made to
        List<IndexTemplateMetadata> clientIndexTemplates = response.getIndexTemplates();
    static final String mappingString = "{\"properties\":{\"f1\": {\"type\":\"text\"},\"f2\": {\"type\":\"keyword\"}}}";
    }
 * Licensed to Elasticsearch under one or more contributor
        }
            serverIndexTemplates.add(serverTemplateBuilder.build());
    }
            esResponse.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
                    assertThat(result.aliases().size(), equalTo(esIMD.aliases().size()));
            templateBuilder.patterns(IntStream.range(0, between(1, 5)).mapToObj(i -> "pattern-" + i).collect(Collectors.toList()));
                if (randomBoolean()) {
            }
import org.opensearch.core.xcontent.MediaTypeRegistry;
            MappingMetadata mappingMD = template.mappings();
                    Map<String, Object> expectedMapping = XContentHelper.convertToMap(mappingSource, true, xContentBuilder.contentType())
        assertEquals(expectedInstance, newInstance);
        }
import java.util.function.Predicate;
            || field.endsWith("settings")
            if (randomBoolean()) {
    }
import java.util.List;
 * SPDX-License-Identifier: Apache-2.0
                }
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.core.common.bytes.BytesArray;
import org.opensearch.common.settings.Settings;
                for (int j = 0; j < numAliases; j++) {
                        assertThat(actualAliases.get(j), equalTo(expectedAliases.get(j)));
            || field.endsWith("mappings") // uses parser.map()
        return (field) -> field.isEmpty()
        // Create a server-side counterpart for the client-side class and call toXContent on it
        serverResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    alias.indexRouting(randomAlphaOfLength(5));
                XContentParser parser = XContentHelper.createParser(
                templateBuilder.version(between(0, 100));
                templateBuilder.order(randomInt());
            for (int i = 0; i < numTemplates; i++) {
            || field.contains("mappings.properties") // cannot have extra properties
            || field.endsWith("settings.index")
                org.opensearch.cluster.metadata.IndexTemplateMetadata.Builder esIMD =
                assertThat(response.getIndexTemplates().size(), equalTo(numTemplates));
            .shuffleFieldsExceptions(new String[] { "aliases", "mappings", "patterns", "settings" })
            XContentBuilder xContentBuilder = XContentBuilder.builder(xContentType.xContent());
        if (randomBoolean()) {
            .test();
    }
                esResponse.getIndexTemplates().add(esIMD.build());
                esIMD.patterns(Arrays.asList(generateRandomStringArray(32, 4, false, false)));
    }
                assertEquals(expectedMap, mappingAsMap);
/*
import org.opensearch.core.xcontent.XContentBuilder;
            }
    static GetIndexTemplatesResponse createTestInstance() {
            }
 * ownership. Elasticsearch licenses this file to you under
import java.util.Iterator;
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
        // Check there's no doc types at the root of the mapping
                esIMD.version(randomIntBetween(0, Integer.MAX_VALUE));
 *
/*
            GetIndexTemplatesResponseTests::createTestInstance,
                alias.routing(randomAlphaOfLength(5));
        ).assertEqualsConsumer(GetIndexTemplatesResponseTests::assertEqualInstances)
            || field.endsWith("aliases")
 * Unless required by applicable law or agreed to in writing,
                int numAliases = randomIntBetween(0, 8);
            if (randomBoolean()) {
                org.opensearch.cluster.metadata.IndexTemplateMetadata.builder(clientITMD.name());
                templateBuilder.mapping(mapping);
 */
 */
import org.opensearch.core.common.bytes.BytesReference;
import static org.opensearch.index.RandomCreateIndexGenerator.randomIndexSettings;
            new org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse(serverIndexTemplates);
                    assertThat(result.patterns(), equalTo(esIMD.patterns()));
import java.io.IOException;
    static XContentBuilder randomMapping(String type, XContentType xContentType) throws IOException {
            ) {
    // As the client class GetIndexTemplatesResponse doesn't have toXContent method, adding this method here only for the test
            serverTemplateBuilder.version(clientITMD.version());
                        .sorted(Comparator.comparing(AliasMetadata::alias))
                        .collect(Collectors.toList());
        if (randomBoolean()) {
 * this file be licensed under the Apache-2.0 license or a
            org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse esResponse =
        if (randomBoolean()) {
        randomMappingFields(builder, true);
    private static void assertEqualInstances(GetIndexTemplatesResponse expectedInstance, GetIndexTemplatesResponse newInstance) {
                }
                Map<String, Object> mappingAsMap = mappingMD.sourceAsMap();
                templateBuilder.putAlias(AliasMetadata.builder(randomAlphaOfLengthBetween(1, 10)));
 * GitHub history for details.
                serverTemplateBuilder.putMapping(MapperService.SINGLE_MAPPING_NAME, mappings);
    }
            }
import java.util.Map;
                    List<AliasMetadata> expectedAliases = Arrays.stream(esIMD.aliases().values().toArray(new AliasMetadata[0]))
            XContentType xContentType = randomFrom(XContentType.values());
                    BytesReference mappingSource = esIMD.mappings().uncompressed();
                    }
                }
 * under the License.
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType);
 * license agreements. See the NOTICE file distributed with
                    new org.opensearch.cluster.metadata.IndexTemplateMetadata.Builder(
import org.opensearch.common.xcontent.XContentHelper;
                // for index templates still do so we need to wrap things here
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
            serverTemplateBuilder.settings(clientITMD.settings());
            }
import java.util.ArrayList;
                        .sorted(Comparator.comparing(AliasMetadata::alias))
                    org.opensearch.cluster.metadata.IndexTemplateMetadata esIMD = esResponse.getIndexTemplates().get(i);
                    List<AliasMetadata> actualAliases = Arrays.stream(result.aliases().values().toArray(new AliasMetadata[0]))
    }
                    assertThat(result.mappings().sourceAsMap(), equalTo(expectedMapping.get("_doc")));
                esIMD.order(randomIntBetween(0, Integer.MAX_VALUE));
        for (int t = 0; t < numTemplates; t++) {
        return new GetIndexTemplatesResponse(templates);
import java.util.stream.IntStream;
        Map<String, Object> expectedMap = XContentHelper.convertToMap(new BytesArray(mappingString), true, MediaTypeRegistry.JSON).v2();
            GetIndexTemplatesResponseTests::toXContent,
        for (IndexTemplateMetadata template : newInstance.getIndexTemplates()) {
import java.util.Comparator;
                )
            Iterator<AliasMetadata> aliases = clientITMD.aliases().values().iterator();
                    NamedXContentRegistry.EMPTY,
                    IndexTemplateMetadata result = response.getIndexTemplates().get(i);
import org.opensearch.core.xcontent.NamedXContentRegistry;
        }
        AliasMetadata.Builder alias = AliasMetadata.builder(name);
                MappingMetadata mapping = new MappingMetadata(MapperService.SINGLE_MAPPING_NAME, map);
                    );
            aliases.forEachRemaining((a) -> serverTemplateBuilder.putAlias(a));
            org.opensearch.cluster.metadata.IndexTemplateMetadata.Builder serverTemplateBuilder =
import java.util.Locale;
            } else {
import org.opensearch.core.xcontent.DeprecationHandler;
                for (int i = 0; i < numTemplates; i++) {
 *
                    assertThat(result.order(), equalTo(esIMD.order()));
            if (clientITMD.mappings() != null) {
    public void testFromXContent() throws IOException {
                    for (int j = 0; j < result.aliases().size(); j++) {
        xContentTester(
import static org.hamcrest.Matchers.equalTo;
        int numTemplates = between(0, 10);
import org.opensearch.index.mapper.MapperService;
import org.opensearch.common.xcontent.XContentType;
 * not use this file except in compliance with the License.
 * KIND, either express or implied.  See the License for the
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
                    BytesReference.bytes(xContentBuilder),
                    alias.searchRouting(randomAlphaOfLength(5));
        }
                }
 * compatible open source license.
                        String.format(Locale.ROOT, "%02d ", i) + randomAlphaOfLength(4)
            try (
            IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder("template-" + t);
            int numAlias = between(0, 5);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.core.xcontent.ToXContent;
                    assertThat(result.version(), equalTo(esIMD.version()));
import static org.opensearch.index.RandomCreateIndexGenerator.randomMappingFields;
 * specific language governing permissions and limitations
import org.opensearch.cluster.metadata.AliasMetadata;
        }
import org.opensearch.cluster.metadata.MappingMetadata;
            templates.add(templateBuilder.build());
                Map<String, Object> map = XContentHelper.convertToMap(new BytesArray(mappingString), true, MediaTypeRegistry.JSON).v2();
            }
            serverTemplateBuilder.order(clientITMD.order());
            if (randomBoolean()) {
                // The client-side mappings never include a wrapping type, but server-side mappings
            }
                new org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse(new ArrayList<>());
    private static AliasMetadata randomAliasMetadata(String name) {
import java.util.Arrays;
 */
                templateBuilder.settings(Settings.builder().put("index.setting-1", randomLong()));
        return alias.build();
            this::createParser,
        for (IndexTemplateMetadata clientITMD : clientIndexTemplates) {
