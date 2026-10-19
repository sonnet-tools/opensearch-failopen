import org.opensearch.common.settings.Settings;
/*
 * GitHub history for details.
    }
        return this.simpleAnalyzer;
 * this work for additional information regarding copyright
}  
/**  
 * Licensed to Elasticsearch under one or more contributor  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
package org.opensearch.index.analysis;
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
        this.simpleAnalyzer = new SimpleAnalyzer();
 * ownership. Elasticsearch licenses this file to you under  
 */  
/*  
 */
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
 *
 * Provider class for the simple analyzer
    }  
 * @opensearch.internal  
    public SimpleAnalyzer get() {  
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
        super(indexSettings, name, settings);
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.IndexSettings;
import org.apache.lucene.analysis.core.SimpleAnalyzer;
 *
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
public class SimpleAnalyzerProvider extends AbstractIndexAnalyzerProvider<SimpleAnalyzer> {
 */
 *
 * You may obtain a copy of the License at  
 *  
    private final SimpleAnalyzer simpleAnalyzer;
 * KIND, either express or implied.  See the License for the
    public SimpleAnalyzerProvider(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
import org.opensearch.env.Environment;  
/*  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
