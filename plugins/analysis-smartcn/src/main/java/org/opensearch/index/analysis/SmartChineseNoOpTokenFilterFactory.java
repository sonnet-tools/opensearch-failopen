import org.opensearch.index.IndexSettings;
import org.apache.lucene.analysis.TokenStream;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * You may obtain a copy of the License at  
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
 * compatible open source license.
    }
 */  
import org.opensearch.common.settings.Settings;
 * ownership. Elasticsearch licenses this file to you under  
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * under the License.  
/*  
    }  
 * The OpenSearch Contributors require contributions made to  
    @Override  
    public TokenStream create(TokenStream tokenStream) {
public class SmartChineseNoOpTokenFilterFactory extends AbstractTokenFilterFactory {  
 * software distributed under the License is distributed on an
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
 * Licensed to Elasticsearch under one or more contributor  
        return tokenStream;
 * Unless required by applicable law or agreed to in writing,
 * license agreements. See the NOTICE file distributed with
 */
    public SmartChineseNoOpTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 *
/*  
import org.opensearch.env.Environment;  
 */  
}
        super(indexSettings, name, settings);  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
 *
package org.opensearch.index.analysis;
 *  
 * SPDX-License-Identifier: Apache-2.0
