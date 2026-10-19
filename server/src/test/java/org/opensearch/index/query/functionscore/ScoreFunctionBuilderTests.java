 * KIND, either express or implied.  See the License for the
        MappedFieldType ft = new NumberFieldMapper.NumberFieldType("foo", NumberType.LONG);
        expectThrows(IllegalArgumentException.class, () -> new ExponentialDecayFunctionBuilder("", "", null, "", randomDouble()));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            .put(IndexMetadata.SETTING_NUMBER_OF_REPLICAS, 1)
import org.opensearch.index.mapper.NumberFieldMapper;
        Mockito.when(context.getShardId()).thenReturn(0);
 * You may obtain a copy of the License at  
        expectThrows(IllegalArgumentException.class, () -> new LinearDecayFunctionBuilder("", "", null, ""));
import org.opensearch.index.IndexSettings;
}
 * SPDX-License-Identifier: Apache-2.0
        Mockito.when(context.getIndexSettings()).thenReturn(settings);  
 * Licensed to Elasticsearch under one or more contributor  
import org.mockito.Mockito;
package org.opensearch.index.query.functionscore;
            .put(IndexMetadata.SETTING_VERSION_CREATED, Version.CURRENT)
 * the Apache License, Version 2.0 (the "License"); you may
        expectThrows(IllegalArgumentException.class, () -> new FieldValueFactorFunctionBuilder("").modifier(null));  
/*  
        builder.seed(42);
 *
        MapperService mapperService = Mockito.mock(MapperService.class);
    }
        expectThrows(IllegalArgumentException.class, () -> new LinearDecayFunctionBuilder(null, "", "", ""));
import org.opensearch.script.Script;
        expectThrows(IllegalArgumentException.class, () -> new GaussDecayFunctionBuilder(null, "", "", ""));
 * GitHub history for details.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.common.settings.Settings;  
 *  
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.mapper.NumberFieldMapper.NumberType;
        Mockito.when(context.index()).thenReturn(settings.getIndex());
        expectThrows(IllegalArgumentException.class, () -> new LinearDecayFunctionBuilder("", "", null, "", randomDouble()));  
    public void testIllegalArguments() {
 */  
 * ownership. Elasticsearch licenses this file to you under  
        Mockito.when(context.getMapperService()).thenReturn(mapperService);
import org.opensearch.test.OpenSearchTestCase;
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
public class ScoreFunctionBuilderTests extends OpenSearchTestCase {  
        IndexSettings settings = new IndexSettings(IndexMetadata.builder("index").settings(indexSettings).build(), Settings.EMPTY);  
            .build();
    }
import org.opensearch.cluster.metadata.IndexMetadata;
    public void testRandomScoreFunctionWithSeed() throws Exception {  
        RandomScoreFunctionBuilder builder = new RandomScoreFunctionBuilder();
        expectThrows(IllegalArgumentException.class, () -> new ExponentialDecayFunctionBuilder(null, "", "", ""));
import org.opensearch.index.mapper.MapperService;  
import org.opensearch.index.query.QueryShardContext;  
/*  
            .put(IndexMetadata.SETTING_NUMBER_OF_SHARDS, 1)  
        expectThrows(IllegalArgumentException.class, () -> new ExponentialDecayFunctionBuilder("", "", null, ""));
 * not use this file except in compliance with the License.
        Settings indexSettings = Settings.builder()
        expectThrows(IllegalArgumentException.class, () -> new GaussDecayFunctionBuilder("", "", null, "", randomDouble()));  
 *
import org.opensearch.index.mapper.MappedFieldType;
 * this file be licensed under the Apache-2.0 license or a
        expectThrows(IllegalArgumentException.class, () -> new RandomScoreFunctionBuilder().seed(null));  
 * under the License.  
        assertWarnings("OpenSearch requires that a [field] parameter is provided when a [seed] is set");  
        Mockito.when(mapperService.fieldType(Mockito.anyString())).thenReturn(ft);  
        expectThrows(IllegalArgumentException.class, () -> new GaussDecayFunctionBuilder("", "", null, ""));
        expectThrows(IllegalArgumentException.class, () -> new ScriptScoreFunctionBuilder((Script) null));
        builder.toFunction(context);
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
        QueryShardContext context = Mockito.mock(QueryShardContext.class);  
 */  
/*
 */
 * compatible open source license.
        expectThrows(IllegalArgumentException.class, () -> new FieldValueFactorFunctionBuilder((String) null));
import org.opensearch.Version;
