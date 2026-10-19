            Settings.Builder builder = Settings.builder();
            null
            mappings.put("type", "keyword");  
                mappings.put("field-" + i, randomFieldMapping());
package org.opensearch.client.indices;
            Map<String, Object> prop2properties = new HashMap<>();
    @Override
    protected void assertInstances(
        Map<String, Object> mappings = new HashMap<>();
import org.apache.lucene.util.CollectionUtil;
    }  
            mappings.put("type", randomBoolean() ? "text" : "keyword");  
            }  
    private static MappingMetadata createMappingsForIndex() {
import org.opensearch.cluster.metadata.Context;
 *
            }
            dataStreams,  
            mappings.put("analyzer", "english");
    }  
import org.opensearch.client.GetAliasesResponseTests;  
                    mappings.put("field2-" + i, randomFieldMapping());
 */  
            Map<String, Object> props1 = new HashMap<>();
            Map<String, Object> props3 = new HashMap<>();
            props2.put("properties", prop2properties);  
        } else if (randomBoolean()) {  
            mappings.put("index", Objects.toString(randomBoolean()));
            aliases,  
import java.util.HashMap;  
    }  
        final Map<String, MappingMetadata> mappings = new HashMap<>();
        for (String index : indices) {  
        assertEquals(serverTestInstance.defaultSettings(), clientInstance.getDefaultSettings());  
    protected GetIndexResponse doParseToClientInstance(XContentParser parser) throws IOException {  
        int typeCount = rarely() ? 0 : 1;  
 * You may obtain a copy of the License at  
import org.opensearch.core.xcontent.XContentParser;
            props1.put("analyzer", "keyword");  
 * not use this file except in compliance with the License.
import org.opensearch.index.mapper.MapperService;  
            Map<String, Object> props2 = new HashMap<>();
        String[] indices = generateRandomStringArray(5, 5, false, false);  
 *    http://www.apache.org/licenses/LICENSE-2.0
                dataStreams.put(index, randomAlphaOfLength(5).toLowerCase(Locale.ROOT));
            mappings.put("properties", properties);
        assertArrayEquals(serverTestInstance.getIndices(), clientInstance.getIndices());  
 * this work for additional information regarding copyright
            if (rarely() == false) { // rarely have no fields  
import java.util.Collections;
 * the Apache License, Version 2.0 (the "License"); you may
            int aliasesNum = randomIntBetween(0, 3);
    ) {
        final Map<String, Context> contexts = new HashMap<>();  
 * under the License.  
            }  
/*  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
import java.util.ArrayList;  
        IndexScopedSettings indexScopedSettings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS;
    @Override
public class GetIndexResponseTests extends AbstractResponseTestCase<  
            mappings.put("type", randomFrom("integer", "float", "long", "double"));
        MappingMetadata mmd = new MappingMetadata(MapperService.SINGLE_MAPPING_NAME, Collections.emptyMap());
import java.util.Objects;
 * Modifications Copyright OpenSearch Contributors. See
 *  
        assertEquals(serverTestInstance.getAliases(), clientInstance.getAliases());
            indices,
            props1.put("type", randomFrom("text", "keyword"));
        for (int i = 0; i < typeCount; i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;
 * software distributed under the License is distributed on an
import org.opensearch.client.AbstractResponseTestCase;
import org.opensearch.common.xcontent.XContentType;  
    }  
            if (includeDefaults) {  
        final Map<String, Settings> settings = new HashMap<>();  
 */  
        return mmd;
                mmd = new MappingMetadata(typeName, mappings);
                contexts.put(index, new Context(randomAlphaOfLength(5).toLowerCase(Locale.ROOT)));  
import org.opensearch.common.settings.Settings;
    }
                defaultSettings.put(index, indexScopedSettings.diff(settings.get(index), Settings.EMPTY));
            builder.put(RandomCreateIndexGenerator.randomIndexSettings());  
            settings.put(index, builder.build());
            mappings.put("type", "object");
            prop2properties.put("subsubfield", props3);
/*  
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
            for (int i = 0; i < aliasesNum; i++) {
 * compatible open source license.
    protected org.opensearch.action.admin.indices.get.GetIndexResponse createServerTestInstance(XContentType xContentType) {
            settings,
    @Override
        }
    org.opensearch.action.admin.indices.get.GetIndexResponse,
 * GitHub history for details.
                aliasMetadataList.add(GetAliasesResponseTests.createAliasMetadata());  
    private static Map<String, Object> randomFieldMapping() {  
import java.util.List;
        assertEquals(serverTestInstance.contexts(), clientInstance.contexts());
            properties.put("subtext", props1);
            mappings,
            props3.put("index", "false");
        if (randomBoolean()) {
import org.opensearch.cluster.metadata.AliasMetadata;
        assertEquals(serverTestInstance.getSettings(), clientInstance.getSettings());
        } else if (randomBoolean()) {  
        final Map<String, Settings> defaultSettings = new HashMap<>();
        }
                }
            CollectionUtil.timSort(aliasMetadataList, Comparator.comparing(AliasMetadata::alias));
 * license agreements. See the NOTICE file distributed with
                if (randomBoolean()) {  
        } else {
import org.opensearch.index.RandomCreateIndexGenerator;
        GetIndexResponse clientInstance
import java.util.Map;  
            mappings.put("dynamic", "strict");
            Map<String, Object> properties = new HashMap<>();  
            mappings.put(index, createMappingsForIndex());
            if (randomBoolean()) {
    // Not meant to be exhaustive
        assertEquals(serverTestInstance.getMappings(), clientInstance.getMappings());
import org.opensearch.cluster.metadata.MappingMetadata;  
 */
import java.util.Comparator;
}
            if (randomBoolean()) {
        return mappings;
import org.opensearch.common.settings.IndexScopedSettings;
 *
        );
import java.util.Locale;
        return GetIndexResponse.fromXContent(parser);
            defaultSettings,
            }
                String typeName = MapperService.SINGLE_MAPPING_NAME;
    GetIndexResponse> {
        }
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
        return new org.opensearch.action.admin.indices.get.GetIndexResponse(  
        final Map<String, List<AliasMetadata>> aliases = new HashMap<>();
            props3.put("type", "integer");  
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
/*
            aliases.put(index, Collections.unmodifiableList(aliasMetadataList));  
        org.opensearch.action.admin.indices.get.GetIndexResponse serverTestInstance,  
            mappings.put("index", "analyzed");
        boolean includeDefaults = randomBoolean();
        final Map<String, String> dataStreams = new HashMap<>();
                Map<String, Object> mappings = new HashMap<>();
            List<AliasMetadata> aliasMetadataList = new ArrayList<>();  
            props2.put("type", "object");  
            }
