/*  
        Map<String, Settings> settings = new HashMap<>();  
 * KIND, either express or implied.  See the License for the
import org.opensearch.cluster.metadata.MappingMetadata;  
            Settings.Builder builder = Settings.builder();
 *
        final Map<String, MappingMetadata> mappings = new HashMap<>();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        Map<String, Context> contexts = new HashMap<>();  
 *
 * Licensed to Elasticsearch under one or more contributor  
 * this file be licensed under the Apache-2.0 license or a
        return new GetIndexResponse(indices, mappings, aliases, settings, defaultSettings, dataStreams, contexts);
import org.apache.lucene.util.CollectionUtil;
import org.opensearch.common.settings.Settings;
        }
import java.util.HashMap;
import org.opensearch.action.admin.indices.alias.get.GetAliasesResponseTests;
 * this work for additional information regarding copyright
        Map<String, String> dataStreams = new HashMap<>();
            }
import org.opensearch.index.RandomCreateIndexGenerator;
public class GetIndexResponseTests extends AbstractWireSerializingTestCase<GetIndexResponse> {  
 * software distributed under the License is distributed on an
import java.util.List;
    }  
import org.opensearch.action.admin.indices.mapping.get.GetMappingsResponseTests;  
/*  
 * GitHub history for details.
            }
 * SPDX-License-Identifier: Apache-2.0
        final Map<String, List<AliasMetadata>> aliases = new HashMap<>();
        boolean includeDefaults = randomBoolean();
        Map<String, Settings> defaultSettings = new HashMap<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.ArrayList;
 */  
    @Override
import java.util.Map;
 * compatible open source license.
            for (int i = 0; i < aliasesNum; i++) {
        return GetIndexResponse::new;
                dataStreams.put(index, randomAlphaOfLength(5).toLowerCase(Locale.ROOT));
 * Modifications Copyright OpenSearch Contributors. See
package org.opensearch.action.admin.indices.get;
/*
            if (includeDefaults) {  
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * under the License.  
            if (randomBoolean()) {
import org.opensearch.cluster.metadata.Context;
            builder.put(RandomCreateIndexGenerator.randomIndexSettings());  
        IndexScopedSettings indexScopedSettings = IndexScopedSettings.DEFAULT_SCOPED_SETTINGS;
            }  
import org.opensearch.core.common.io.stream.Writeable;  
            }  
            mappings.put(index, GetMappingsResponseTests.createMappingsForIndex());
                contexts.put(index, new Context(randomAlphaOfLength(5).toLowerCase(Locale.ROOT)));
 * specific language governing permissions and limitations
                defaultSettings.put(index, indexScopedSettings.diff(settings.get(index), Settings.EMPTY));
import org.opensearch.test.AbstractWireSerializingTestCase;
 *  
    protected Writeable.Reader<GetIndexResponse> instanceReader() {  
    protected GetIndexResponse createTestInstance() {
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.metadata.AliasMetadata;
            int aliasesNum = randomIntBetween(0, 3);
            List<AliasMetadata> aliasMetadataList = new ArrayList<>();  
 * ownership. Elasticsearch licenses this file to you under  
            if (randomBoolean()) {
 */
        for (String index : indices) {  
            aliases.put(index, Collections.unmodifiableList(aliasMetadataList));  
        String[] indices = generateRandomStringArray(5, 5, false, false);  
            settings.put(index, builder.build());
 * Unless required by applicable law or agreed to in writing,
}
import java.util.Comparator;  
                aliasMetadataList.add(GetAliasesResponseTests.createAliasMetadata());  
import java.util.Collections;
    @Override
 * You may obtain a copy of the License at  
import java.util.Locale;  
import org.opensearch.common.settings.IndexScopedSettings;
            CollectionUtil.timSort(aliasMetadataList, Comparator.comparing(AliasMetadata::alias));
 * The OpenSearch Contributors require contributions made to  
