import org.opensearch.index.analysis.NormalizingTokenFilterFactory;
public class UpperCaseTokenFilterFactory extends AbstractTokenFilterFactory implements NormalizingTokenFilterFactory {  
    public TokenStream create(TokenStream tokenStream) {
 * specific language governing permissions and limitations
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.settings.Settings;  
 * KIND, either express or implied.  See the License for the
    public UpperCaseTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
import org.opensearch.index.IndexSettings;
 * this work for additional information regarding copyright
    @Override  
/*
 * Licensed to Elasticsearch under one or more contributor  
}
 * The OpenSearch Contributors require contributions made to  
 * You may obtain a copy of the License at  
    }
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
        return new UpperCaseFilter(tokenStream);
import org.apache.lucene.analysis.core.UpperCaseFilter;
        super(indexSettings, name, settings);  
/*  
package org.opensearch.analysis.common;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
 *
 * under the License.  
/*  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
 *
    }  
 * compatible open source license.
 * Unless required by applicable law or agreed to in writing,
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.env.Environment;
 * GitHub history for details.
 */  
 *  
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
import org.apache.lucene.analysis.TokenStream;
 */
 * ownership. Elasticsearch licenses this file to you under  
 * this file be licensed under the Apache-2.0 license or a
 * license agreements. See the NOTICE file distributed with
