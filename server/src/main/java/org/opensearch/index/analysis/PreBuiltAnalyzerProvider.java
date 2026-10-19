        return analyzer.name();  
 * software distributed under the License is distributed on an
    @Override  
/*  
        // to not be shared...  
    }
 * You may obtain a copy of the License at  
    @Override
 * Provider for all prebuilt analyzers
        this.analyzer = new NamedAnalyzer(name, scope, analyzer);
        return analyzer;
 * the Apache License, Version 2.0 (the "License"); you may
    }  
    }
        return analyzer.scope();
        // we create the named analyzer here so the resources associated with it will be shared
 * KIND, either express or implied.  See the License for the
        // and we won't wrap a shared analyzer with named analyzer each time causing the resources
}  
 * license agreements. See the NOTICE file distributed with
    @Override
 * Unless required by applicable law or agreed to in writing,
    public String name() {
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.analysis.Analyzer;
 * specific language governing permissions and limitations
 */  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.index.analysis;
    public AnalyzerScope scope() {
 *
public class PreBuiltAnalyzerProvider implements AnalyzerProvider<NamedAnalyzer> {
 * compatible open source license.
 */  
 */
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
    private final NamedAnalyzer analyzer;
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
/*  
 * not use this file except in compliance with the License.
    public PreBuiltAnalyzerProvider(String name, AnalyzerScope scope, Analyzer analyzer) {  
 * GitHub history for details.
    }
 *  
    public NamedAnalyzer get() {  
 *
 * The OpenSearch Contributors require contributions made to  
 * @opensearch.internal  
 *
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
 */
 * under the License.  
 * this file be licensed under the Apache-2.0 license or a
