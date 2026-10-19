 */  
 * You may obtain a copy of the License at  
 * not use this file except in compliance with the License.
    FlattenGraphTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * specific language governing permissions and limitations
    }  
 * SPDX-License-Identifier: Apache-2.0
 * Unless required by applicable law or agreed to in writing,
package org.opensearch.analysis.common;
import org.opensearch.env.Environment;
 * GitHub history for details.
public class FlattenGraphTokenFilterFactory extends AbstractTokenFilterFactory {
 */  
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
import org.opensearch.index.IndexSettings;
import org.apache.lucene.analysis.TokenStream;
 * compatible open source license.
        return new FlattenGraphFilter(tokenStream);
 *
 * the Apache License, Version 2.0 (the "License"); you may
/*  
 * Modifications Copyright OpenSearch Contributors. See
 * under the License.  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.analysis.core.FlattenGraphFilter;
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.common.settings.Settings;  
/*
 * ownership. Elasticsearch licenses this file to you under  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*  
 *  
 *
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
    public TokenStream create(TokenStream tokenStream) {  
 */
        super(indexSettings, name, settings);
    }
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
}  
    @Override
