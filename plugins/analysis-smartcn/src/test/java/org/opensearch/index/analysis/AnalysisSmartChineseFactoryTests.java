 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 *  
 *
/*
}
 * Modifications Copyright OpenSearch Contributors. See
import java.util.HashMap;
 */
        Map<String, Class<?>> tokenizers = new HashMap<>(super.getTokenizers());
public class AnalysisSmartChineseFactoryTests extends AnalysisFactoryTestCase {
        super(new AnalysisSmartChinesePlugin());  
/*  
    @Override  
 * this file be licensed under the Apache-2.0 license or a
 * not use this file except in compliance with the License.
 * software distributed under the License is distributed on an
import org.opensearch.indices.analysis.AnalysisFactoryTestCase;
 */  
 * specific language governing permissions and limitations
    }
 * GitHub history for details.
        tokenizers.put("hmmchinese", SmartChineseTokenizerTokenizerFactory.class);  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.index.analysis;
/*  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Map;
 * the Apache License, Version 2.0 (the "License"); you may
 */  
 * under the License.  
 * compatible open source license.
        return tokenizers;
 * SPDX-License-Identifier: Apache-2.0
    protected Map<String, Class<?>> getTokenizers() {
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
import org.opensearch.plugin.analysis.smartcn.AnalysisSmartChinesePlugin;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    public AnalysisSmartChineseFactoryTests() {
 * this work for additional information regarding copyright
    }
