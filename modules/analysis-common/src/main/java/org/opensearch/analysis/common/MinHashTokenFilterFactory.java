            settingMap.put("hashCount", settings.get("hash_count"));
import org.apache.lucene.analysis.TokenStream;
 * GitHub history for details.
import org.opensearch.index.analysis.AbstractTokenFilterFactory;  
 * this file be licensed under the Apache-2.0 license or a
 * ownership. Elasticsearch licenses this file to you under  
 * software distributed under the License is distributed on an
import org.opensearch.common.settings.Settings;  
    public TokenStream create(TokenStream tokenStream) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */  
        }  
        minHashFilterFactory = new MinHashFilterFactory(convertSettings(settings));  
/*  
    MinHashTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
    @Override  
 * the Apache License, Version 2.0 (the "License"); you may
    }
            settingMap.put("withRotation", settings.get("with_rotation"));
 * not use this file except in compliance with the License.
 */  
import org.opensearch.index.IndexSettings;
        }  
 * KIND, either express or implied.  See the License for the
        return minHashFilterFactory.create(tokenStream);
 *  
 * compatible open source license.
import org.opensearch.env.Environment;
 * license agreements. See the NOTICE file distributed with
 *
        return settingMap;
 */
    }
 * Licensed to Elasticsearch under one or more contributor  
 * under the License.  
 * You may obtain a copy of the License at  
    private final MinHashFilterFactory minHashFilterFactory;
 *
        }  
        if (settings.hasValue("with_rotation")) {
 * Modifications Copyright OpenSearch Contributors. See
            settingMap.put("bucketCount", settings.get("bucket_count"));
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
import java.util.Map;  
 * Unless required by applicable law or agreed to in writing,
        if (settings.hasValue("hash_set_size")) {
        }  
public class MinHashTokenFilterFactory extends AbstractTokenFilterFactory {  
    private Map<String, String> convertSettings(Settings settings) {
/*
        Map<String, String> settingMap = new HashMap<>();  
import org.apache.lucene.analysis.minhash.MinHashFilterFactory;
 */
            settingMap.put("hashSetSize", settings.get("hash_set_size"));
/**
 * The OpenSearch Contributors require contributions made to  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * specific language governing permissions and limitations
 * TokenFilterFactoryAdapter for {@link MinHashFilterFactory}  
        if (settings.hasValue("bucket_count")) {
        if (settings.hasValue("hash_count")) {
        super(indexSettings, name, settings);
package org.opensearch.analysis.common;
 *
import java.util.HashMap;
}  
    }  
