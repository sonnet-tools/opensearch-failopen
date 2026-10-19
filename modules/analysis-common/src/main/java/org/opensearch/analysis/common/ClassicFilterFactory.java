 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    ClassicFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
/**
 */  
 *
 * not use this file except in compliance with the License.
 */
    }
/*
 * this file be licensed under the Apache-2.0 license or a
 *
import org.opensearch.env.Environment;  
        return new ClassicFilter(tokenStream);  
 * You may obtain a copy of the License at  
import org.apache.lucene.analysis.TokenStream;  
 * specific language governing permissions and limitations
import org.opensearch.index.IndexSettings;
 * Modifications Copyright OpenSearch Contributors. See  
 * under the License.  
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
    @Override
    }
import org.apache.lucene.analysis.classic.ClassicFilter;
}  
 * ownership. Elasticsearch licenses this file to you under  
    public TokenStream create(TokenStream tokenStream) {
 */
 * license agreements. See the NOTICE file distributed with
/*  
 * GitHub history for details.
 *  
        super(indexSettings, name, settings);
public class ClassicFilterFactory extends AbstractTokenFilterFactory {
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.analysis.common;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
 * compatible open source license.
 * this work for additional information regarding copyright
import org.opensearch.common.settings.Settings;
/*
 * Factory for {@link ClassicFilter}
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
