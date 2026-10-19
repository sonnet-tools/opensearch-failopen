 *    http://www.apache.org/licenses/LICENSE-2.0
        return name;
 * You may obtain a copy of the License at  
import org.opensearch.common.settings.Settings;
 * SPDX-License-Identifier: Apache-2.0
 * this work for additional information regarding copyright
    public AbstractTokenizerFactory(IndexSettings indexSettings, Settings settings, String name) {
 * Unless required by applicable law or agreed to in writing,
 * under the License.  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    @Override  
/*
/**
 */  
 * The OpenSearch Contributors require contributions made to  
 * Modifications Copyright OpenSearch Contributors. See
 * Base tokenizer factory used in analysis chain  
 */  
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.index.IndexSettings;  
 * GitHub history for details.
public abstract class AbstractTokenizerFactory extends AbstractIndexComponent implements TokenizerFactory {
    private final String name;
package org.opensearch.index.analysis;
 */
/*  
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
 * Licensed to Elasticsearch under one or more contributor  
    }  
 * not use this file except in compliance with the License.
    public String name() {
    }
 *  
 *
import org.opensearch.index.AbstractIndexComponent;
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
 *
        this.name = name;  
 * @opensearch.internal
 */  
        super(indexSettings);
}
 * specific language governing permissions and limitations
 *
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
/*  
