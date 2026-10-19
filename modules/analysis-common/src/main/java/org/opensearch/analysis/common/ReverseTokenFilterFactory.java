 * under the License.  
import org.apache.lucene.analysis.TokenStream;
        return new ReverseStringFilter(tokenStream);
 *  
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
}  
 * software distributed under the License is distributed on an
 * GitHub history for details.
package org.opensearch.analysis.common;
 * specific language governing permissions and limitations
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.env.Environment;
 * this file be licensed under the Apache-2.0 license or a
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * You may obtain a copy of the License at  
 * compatible open source license.
 *
    }  
 * the Apache License, Version 2.0 (the "License"); you may
 */  
        super(indexSettings, name, settings);
 * this work for additional information regarding copyright
 *
    }
/*  
import org.apache.lucene.analysis.reverse.ReverseStringFilter;
public class ReverseTokenFilterFactory extends AbstractTokenFilterFactory {
import org.opensearch.index.IndexSettings;
 * ownership. Elasticsearch licenses this file to you under  
 */  
 * license agreements. See the NOTICE file distributed with
 * SPDX-License-Identifier: Apache-2.0
    @Override
/*
 * not use this file except in compliance with the License.
import org.opensearch.common.settings.Settings;  
 * The OpenSearch Contributors require contributions made to  
/*  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * Licensed to Elasticsearch under one or more contributor  
    public TokenStream create(TokenStream tokenStream) {  
 */
    ReverseTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
 * KIND, either express or implied.  See the License for the
