 *
 */  
/*  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Licensed to Elasticsearch under one or more contributor  
        super(indexSettings);
 * compatible open source license.
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.index.IndexSettings;
 *
 * license agreements. See the NOTICE file distributed with
    }  
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
 *  
    public AbstractCharFilterFactory(IndexSettings indexSettings, String name) {
/*  
}
 * not use this file except in compliance with the License.
 * GitHub history for details.
 * You may obtain a copy of the License at  
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under  
    public String name() {
 * @opensearch.internal
 * KIND, either express or implied.  See the License for the
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
public abstract class AbstractCharFilterFactory extends AbstractIndexComponent implements CharFilterFactory {  
    private final String name;
 */  
import org.opensearch.index.AbstractIndexComponent;
        return this.name;
 * Base character filter factory used in analysis chain
    @Override  
 */
 * the Apache License, Version 2.0 (the "License"); you may
        this.name = name;  
package org.opensearch.index.analysis;
 */
 * under the License.  
 *  
 * this work for additional information regarding copyright
 * this file be licensed under the Apache-2.0 license or a
/**
