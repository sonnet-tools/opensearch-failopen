 * Builds an analyzer for normalization that lowercases terms.  
 * Unless required by applicable law or agreed to in writing,
 * KIND, either express or implied.  See the License for the
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
 * Licensed to Elasticsearch under one or more contributor  
        this.analyzer = new LowercaseNormalizer();
import org.opensearch.common.settings.Settings;
 * not use this file except in compliance with the License.
 * license agreements. See the NOTICE file distributed with
 *  
    public LowercaseNormalizerProvider(IndexSettings indexSettings, Environment env, String name, Settings settings) {
 * compatible open source license.
 * @opensearch.internal
 * ownership. Elasticsearch licenses this file to you under  
    public LowercaseNormalizer get() {
    }
 *
 * You may obtain a copy of the License at  
package org.opensearch.index.analysis;
/**
 * specific language governing permissions and limitations
 * this file be licensed under the Apache-2.0 license or a
}
import org.opensearch.env.Environment;
 * the Apache License, Version 2.0 (the "License"); you may
 * this work for additional information regarding copyright
public class LowercaseNormalizerProvider extends AbstractIndexAnalyzerProvider<LowercaseNormalizer> {
 *
 * software distributed under the License is distributed on an
 */  
 * GitHub history for details.
    private final LowercaseNormalizer analyzer;  
    }
/*  
 * under the License.  
import org.opensearch.index.IndexSettings;  
 *
        super(indexSettings, name, settings);  
        return analyzer;  
/*  
    @Override
 *    http://www.apache.org/licenses/LICENSE-2.0
 */  
 */
