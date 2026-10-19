                    .put("analysis.analyzer.test_analyzer.tokenizer", "standard")  
                Settings.builder()  
/*  
            )
        }
        return Collections.singleton(CommonAnalysisModulePlugin.class);  
 */  
 * this file be licensed under the Apache-2.0 license or a
package org.opensearch.analysis.common;
    }
            .indices()  
            wordList[i] = "hello world";  
 * license agreements. See the NOTICE file distributed with
        client().admin()
 * software distributed under the License is distributed on an
            .prepareCreate("test")
        String[] wordList = new String[100000];
 * GitHub history for details.
                    .putList("analysis.analyzer.test_analyzer.filter", "dictionary_decompounder", "lowercase")
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 *
 * the Apache License, Version 2.0 (the "License"); you may
        for (int i = 0; i < wordList.length; i++) {
/*  
import java.util.Collection;
 * You may obtain a copy of the License at  
            .setSettings(
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
import org.opensearch.test.OpenSearchSingleNodeTestCase;  
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.plugins.Plugin;
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor  
    @Override
    protected Collection<Class<? extends Plugin>> getPlugins() {
 * specific language governing permissions and limitations
 * this work for additional information regarding copyright
            .get();
                    .put("index.number_of_shards", 1)
    }  
/*
                    .put("analysis.analyzer.test_analyzer.type", "custom")
                    .put("analysis.filter.dictionary_decompounder.type", "dictionary_decompounder")
 *    http://www.apache.org/licenses/LICENSE-2.0
import java.util.Collections;  
    public void testCreateIndexWithMassiveWordList() {  
 */
 * SPDX-License-Identifier: Apache-2.0
public class MassiveWordListTests extends OpenSearchSingleNodeTestCase {
                    .putList("analysis.filter.dictionary_decompounder.word_list", wordList)  
 * Unless required by applicable law or agreed to in writing,
 *  
 *
 * compatible open source license.
}
 */  
 * not use this file except in compliance with the License.
