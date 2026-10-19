}  
    }
 * this work for additional information regarding copyright
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.IndexSettings;
 * SPDX-License-Identifier: Apache-2.0
 * You may obtain a copy of the License at  
 * Factory for {@link ApostropheFilter}
 * software distributed under the License is distributed on an
public class ApostropheFilterFactory extends AbstractTokenFilterFactory {
/**
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Modifications Copyright OpenSearch Contributors. See  
 *  
import org.opensearch.index.analysis.AbstractTokenFilterFactory;
import org.apache.lucene.analysis.tr.ApostropheFilter;
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.analysis.TokenStream;  
 * Unless required by applicable law or agreed to in writing,
 * Licensed to Elasticsearch under one or more contributor  
        return new ApostropheFilter(tokenStream);  
    }
 *
 * the Apache License, Version 2.0 (the "License"); you may
 * this file be licensed under the Apache-2.0 license or a
 */
 * ownership. Elasticsearch licenses this file to you under  
 */  
        super(indexSettings, name, settings);
 * KIND, either express or implied.  See the License for the
 */
 */  
 *
/*  
    public TokenStream create(TokenStream tokenStream) {
import org.opensearch.env.Environment;  
 * not use this file except in compliance with the License.
package org.opensearch.analysis.common;
 * compatible open source license.
 * GitHub history for details.
 * specific language governing permissions and limitations
    ApostropheFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {  
/*
    @Override
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
/*
import org.opensearch.common.settings.Settings;
