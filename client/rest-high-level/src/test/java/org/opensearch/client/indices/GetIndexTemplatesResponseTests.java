        }
                org.opensearch.cluster.metadata.IndexTemplateMetadata.builder(clientITMD.name());
        return alias.build();
                templateBuilder.settings(Settings.builder().put("index.setting-1", randomLong()));
        for (IndexTemplateMetadata template : newInstance.getIndexTemplates()) {
        return builder;  
        int numTemplates = between(0, 10);
import org.opensearch.common.xcontent.XContentType;  
                    assertThat(result.version(), equalTo(esIMD.version()));
            serverTemplateBuilder.order(clientITMD.order());  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
            }
                    List<AliasMetadata> expectedAliases = Arrays.stream(esIMD.aliases().values().toArray(new AliasMetadata[0]))
        List<org.opensearch.cluster.metadata.IndexTemplateMetadata> serverIndexTemplates = new ArrayList<>();  
import java.util.stream.IntStream;
 * this work for additional information regarding copyright
        return (field) -> field.isEmpty()
            Iterator<AliasMetadata> aliases = clientITMD.aliases().values().iterator();
                MappingMetadata mapping = new MappingMetadata(MapperService.SINGLE_MAPPING_NAME, map);
                response.getIndexTemplates().sort(Comparator.comparing(IndexTemplateMetadata::name));  
        if (randomBoolean()) {
        ).assertEqualsConsumer(GetIndexTemplatesResponseTests::assertEqualInstances)  
                    alias.searchRouting(randomAlphaOfLength(5));
            MappingMetadata mappingMD = template.mappings();  
    }
            }
                alias.routing(randomAlphaOfLength(5));
import org.opensearch.core.common.bytes.BytesArray;
            }
        }
            GetIndexTemplatesResponse::fromXContent
                    BytesReference.bytes(xContentBuilder),
import org.opensearch.core.xcontent.DeprecationHandler;  
            aliases.forEachRemaining((a) -> serverTemplateBuilder.putAlias(a));  
                    assertThat(result.patterns(), equalTo(esIMD.patterns()));
        for (IndexTemplateMetadata clientITMD : clientIndexTemplates) {
                String mappings = "{\"" + MapperService.SINGLE_MAPPING_NAME + "\": " + clientITMD.mappings().source().string() + "}";
    }
                templateBuilder.putAlias(AliasMetadata.builder(randomAlphaOfLengthBetween(1, 10)));
        }
        ;
            if (randomBoolean()) {  
 *
 * You may obtain a copy of the License at  
                esIMD.version(randomIntBetween(0, Integer.MAX_VALUE));  
                assertThat(response.getIndexTemplates().size(), equalTo(numTemplates));
                    xContentType  
            ) {
package org.opensearch.client.indices;
        }  
                        .collect(Collectors.toList());  
            || field.endsWith("settings")  
                    assertThat(result.settings(), equalTo(esIMD.settings()));  
        builder.startObject().startObject(type);
/*
        // Create a server-side counterpart for the client-side class and call toXContent on it
            for (int i = 0; i < numTemplates; i++) {
        }  
/*  
 */  
                        .v2();  
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.core.xcontent.ToXContent;  
import org.opensearch.core.common.bytes.BytesReference;
            }
            try (
                    alias.indexRouting(randomAlphaOfLength(5));
/*  
            .test();
            || field.contains("mappings.properties") // cannot have extra properties  
            || field.endsWith("mappings") // uses parser.map()
            GetIndexTemplatesResponseTests::createTestInstance,  
import org.opensearch.cluster.metadata.AliasMetadata;
    private Predicate<String> randomFieldsExcludeFilter() {  
                }  
 * not use this file except in compliance with the License.
 * GitHub history for details.
import java.util.Iterator;
 * software distributed under the License is distributed on an
                    assertThat(result.order(), equalTo(esIMD.order()));
 * the Apache License, Version 2.0 (the "License"); you may
            serverTemplateBuilder.version(clientITMD.version());
                )
                if (randomBoolean()) {
import static org.opensearch.test.AbstractXContentTestCase.xContentTester;
            } else {  
                new org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse(new ArrayList<>());
import org.opensearch.core.xcontent.MediaTypeRegistry;
}
 * Modifications Copyright OpenSearch Contributors. See
                    org.opensearch.cluster.metadata.IndexTemplateMetadata esIMD = esResponse.getIndexTemplates().get(i);
            IndexTemplateMetadata.Builder templateBuilder = IndexTemplateMetadata.builder("template-" + t);  
                GetIndexTemplatesResponse response = GetIndexTemplatesResponse.fromXContent(parser);  
                }
                    BytesReference mappingSource = esIMD.mappings().uncompressed();
 *
                for (int i = 0; i < numTemplates; i++) {
import java.util.stream.Collectors;  
public class GetIndexTemplatesResponseTests extends OpenSearchTestCase {
 * under the License.  
        Map<String, Object> expectedMap = XContentHelper.convertToMap(new BytesArray(mappingString), true, MediaTypeRegistry.JSON).v2();
            }
    }
import org.opensearch.common.xcontent.XContentHelper;
    private static void assertEqualInstances(GetIndexTemplatesResponse expectedInstance, GetIndexTemplatesResponse newInstance) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
            }
                if (randomBoolean()) {
            XContentBuilder xContentBuilder = XContentBuilder.builder(xContentType.xContent());
            org.opensearch.cluster.metadata.IndexTemplateMetadata.Builder serverTemplateBuilder =  
                        .collect(Collectors.toList());  
        xContentTester(
 * ownership. Elasticsearch licenses this file to you under  
    }
                int numAliases = randomIntBetween(0, 8);
            templates.add(templateBuilder.build());
            if (randomBoolean()) {
        }
    }  
            if (randomBoolean()) {  
            XContentType xContentType = randomFrom(XContentType.values());  
    public void testParsingFromOpenSearchResponse() throws IOException {
                    esIMD.putAlias(randomAliasMetadata(String.format(Locale.ROOT, "%02d ", j) + randomAlphaOfLength(4)));  
                }
import static org.opensearch.index.RandomCreateIndexGenerator.randomMappingFields;
                        assertThat(actualAliases.get(j), equalTo(expectedAliases.get(j)));
import static org.opensearch.index.RandomCreateIndexGenerator.randomIndexSettings;  
import java.util.Arrays;
    private static AliasMetadata randomAliasMetadata(String name) {
            || field.endsWith("aliases")
import org.opensearch.core.xcontent.XContentBuilder;
    }
            GetIndexTemplatesResponseTests::toXContent,
                templateBuilder.version(between(0, 100));
            }
                        .sorted(Comparator.comparing(AliasMetadata::alias))
            .shuffleFieldsExceptions(new String[] { "aliases", "mappings", "patterns", "settings" })  
 * SPDX-License-Identifier: Apache-2.0
                XContentParser parser = XContentHelper.createParser(
import org.opensearch.common.compress.CompressedXContent;  
                    );  
                templateBuilder.mapping(mapping);  
        for (int runs = 0; runs < 20; runs++) {
            }
        if (randomBoolean()) {
                esIMD.putMapping("_doc", new CompressedXContent(BytesReference.bytes(randomMapping("_doc", xContentType))));  
        randomMappingFields(builder, true);  
import org.opensearch.cluster.metadata.MappingMetadata;
        List<IndexTemplateMetadata> templates = new ArrayList<>();  
import java.util.List;
            if (clientITMD.mappings() != null) {
                    }  
            if (randomBoolean()) {  
    static void toXContent(GetIndexTemplatesResponse response, XContentBuilder builder) throws IOException {
                Map<String, Object> mappingAsMap = mappingMD.sourceAsMap();
            templateBuilder.patterns(IntStream.range(0, between(1, 5)).mapToObj(i -> "pattern-" + i).collect(Collectors.toList()));
import org.opensearch.index.mapper.MapperService;  
            .randomFieldsExcludeFilter(randomFieldsExcludeFilter())
import java.io.IOException;  
import java.util.ArrayList;
            .supportsUnknownFields(true)
                    List<AliasMetadata> actualAliases = Arrays.stream(result.aliases().values().toArray(new AliasMetadata[0]))
            alias.writeIndex(randomBoolean());  
import static org.hamcrest.Matchers.equalTo;  
import java.util.Comparator;  
    }  
                // for index templates still do so we need to wrap things here
                Map<String, Object> map = XContentHelper.convertToMap(new BytesArray(mappingString), true, MediaTypeRegistry.JSON).v2();
            }
 * compatible open source license.
            || field.endsWith("settings.index")
                esIMD.order(randomIntBetween(0, Integer.MAX_VALUE));
        if (randomBoolean()) {  
                assertEquals(expectedMap, mappingAsMap);  
                serverTemplateBuilder.putMapping(MapperService.SINGLE_MAPPING_NAME, mappings);  
            int numTemplates = randomIntBetween(0, 32);
        serverResponse.toXContent(builder, ToXContent.EMPTY_PARAMS);
                    for (int j = 0; j < result.aliases().size(); j++) {
import org.opensearch.core.xcontent.NamedXContentRegistry;
        assertEquals(expectedInstance, newInstance);
            for (int i = 0; i < numAlias; i++) {  
 */
                // The client-side mappings never include a wrapping type, but server-side mappings  
            alias.filter("{\"term\":{\"year\":2016}}");
                for (int j = 0; j < numAliases; j++) {
            }
import org.opensearch.common.settings.Settings;
                        .sorted(Comparator.comparing(AliasMetadata::alias))
 * license agreements. See the NOTICE file distributed with
        XContentBuilder builder = MediaTypeRegistry.contentBuilder(xContentType);  
                esIMD.settings(randomIndexSettings());
                org.opensearch.cluster.metadata.IndexTemplateMetadata.Builder esIMD =  
    // As the client class GetIndexTemplatesResponse doesn't have toXContent method, adding this method here only for the test
            int numAlias = between(0, 5);
                    IndexTemplateMetadata result = response.getIndexTemplates().get(i);  
 * KIND, either express or implied.  See the License for the
                esResponse.getIndexTemplates().add(esIMD.build());
    static final String mappingString = "{\"properties\":{\"f1\": {\"type\":\"text\"},\"f2\": {\"type\":\"keyword\"}}}";
                    Map<String, Object> expectedMapping = XContentHelper.convertToMap(mappingSource, true, xContentBuilder.contentType())
import java.util.Map;
    static GetIndexTemplatesResponse createTestInstance() {
        org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse serverResponse =
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.core.xcontent.XContentParser;
                    NamedXContentRegistry.EMPTY,  
    public void testFromXContent() throws IOException {  
            this::createParser,
 * Licensed to Elasticsearch under one or more contributor  
                    assertThat(result.aliases().size(), equalTo(esIMD.aliases().size()));  
            esResponse.toXContent(xContentBuilder, ToXContent.EMPTY_PARAMS);
        for (int t = 0; t < numTemplates; t++) {
import org.opensearch.test.OpenSearchTestCase;
                        String.format(Locale.ROOT, "%02d ", i) + randomAlphaOfLength(4)
 * The OpenSearch Contributors require contributions made to  
                    new org.opensearch.cluster.metadata.IndexTemplateMetadata.Builder(
            if (mappingMD != null) {
import java.util.function.Predicate;
                    assertThat(result.mappings().sourceAsMap(), equalTo(expectedMapping.get("_doc")));
            serverTemplateBuilder.settings(clientITMD.settings());
        List<IndexTemplateMetadata> clientIndexTemplates = response.getIndexTemplates();
        }  
                templateBuilder.order(randomInt());
            serverTemplateBuilder.patterns(clientITMD.patterns());  
            org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse esResponse =  
        builder.endObject().endObject();
 *  
                esIMD.patterns(Arrays.asList(generateRandomStringArray(32, 4, false, false)));
        return new GetIndexTemplatesResponse(templates);
            new org.opensearch.action.admin.indices.template.get.GetIndexTemplatesResponse(serverIndexTemplates);  
import java.util.Locale;  
            serverIndexTemplates.add(serverTemplateBuilder.build());
                }  
            if (randomBoolean()) {  
 * specific language governing permissions and limitations
                    DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        // Check there's no doc types at the root of the mapping  
        AliasMetadata.Builder alias = AliasMetadata.builder(name);
    static XContentBuilder randomMapping(String type, XContentType xContentType) throws IOException {
