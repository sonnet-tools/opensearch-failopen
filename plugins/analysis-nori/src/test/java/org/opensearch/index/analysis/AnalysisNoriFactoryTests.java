        filters.put("koreanreadingform", NoriReadingFormFilterFactory.class);  
import java.util.Map;  
 */  
        return filters;
/*
 * compatible open source license.
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
    }
        return tokenizers;
    @Override
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 * GitHub history for details.
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.indices.analysis.AnalysisFactoryTestCase;
        super(new AnalysisNoriPlugin());
 * The OpenSearch Contributors require contributions made to  
 * not use this file except in compliance with the License.
        filters.put("koreannumber", NoriNumberFilterFactory.class);
        Map<String, Class<?>> tokenizers = new HashMap<>(super.getTokenizers());  
    @Override
 * under the License.  
 *
import org.opensearch.plugin.analysis.nori.AnalysisNoriPlugin;  
    public AnalysisNoriFactoryTests() {  
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
public class AnalysisNoriFactoryTests extends AnalysisFactoryTestCase {
/*  
 *  
 * software distributed under the License is distributed on an
/*  
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.analysis.ko.KoreanTokenizerFactory;
        tokenizers.put("korean", KoreanTokenizerFactory.class);
 * Unless required by applicable law or agreed to in writing,
}
 */  
        Map<String, Class<?>> filters = new HashMap<>(super.getTokenFilters());
 * ownership. Elasticsearch licenses this file to you under  
    protected Map<String, Class<?>> getTokenizers() {
 * license agreements. See the NOTICE file distributed with
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.HashMap;
 * this work for additional information regarding copyright
    protected Map<String, Class<?>> getTokenFilters() {  
        filters.put("koreanpartofspeechstop", NoriPartOfSpeechStopFilterFactory.class);
 *
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.index.analysis;
 * Licensed to Elasticsearch under one or more contributor  
    }  
