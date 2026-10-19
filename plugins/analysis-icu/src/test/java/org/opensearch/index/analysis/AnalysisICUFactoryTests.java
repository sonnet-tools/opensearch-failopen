 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * The OpenSearch Contributors require contributions made to  
        return tokenizers;
package org.opensearch.index.analysis;
 * GitHub history for details.
    protected Map<String, Class<?>> getTokenFilters() {
 * software distributed under the License is distributed on an
    public AnalysisICUFactoryTests() {
 * ownership. Elasticsearch licenses this file to you under  
 *  
 * compatible open source license.
    @Override  
        return filters;
 * Modifications Copyright OpenSearch Contributors. See
        Map<String, Class<?>> filters = new HashMap<>(super.getCharFilters());  
 * this work for additional information regarding copyright
public class AnalysisICUFactoryTests extends AnalysisFactoryTestCase {
/*  
/*  
    @Override
        filters.put("icunormalizer2", IcuNormalizerCharFilterFactory.class);
        return filters;
 *
 * the Apache License, Version 2.0 (the "License"); you may
 */  
    }
    }
 * specific language governing permissions and limitations
        super(new AnalysisICUPlugin());  
        tokenizers.put("icu", IcuTokenizerFactory.class);  
 */  
        filters.put("icunormalizer2", IcuNormalizerTokenFilterFactory.class);
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    }  
 * not use this file except in compliance with the License.
    }
import org.opensearch.indices.analysis.AnalysisFactoryTestCase;
        filters.put("icufolding", IcuFoldingTokenFilterFactory.class);
 * Licensed to Elasticsearch under one or more contributor  
 * KIND, either express or implied.  See the License for the
        Map<String, Class<?>> tokenizers = new HashMap<>(super.getTokenizers());
 * under the License.  
import java.util.HashMap;
 *
}
    @Override
        Map<String, Class<?>> filters = new HashMap<>(super.getTokenFilters());  
import org.opensearch.plugin.analysis.icu.AnalysisICUPlugin;
 * this file be licensed under the Apache-2.0 license or a
 * Unless required by applicable law or agreed to in writing,
    protected Map<String, Class<?>> getTokenizers() {
import java.util.Map;
    protected Map<String, Class<?>> getCharFilters() {
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
        filters.put("icutransform", IcuTransformTokenFilterFactory.class);  
 */
