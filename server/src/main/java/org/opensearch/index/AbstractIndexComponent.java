 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
 * under the License.  
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
 *
 * not use this file except in compliance with the License.
        this.indexSettings = indexSettings;
 * the Apache License, Version 2.0 (the "License"); you may
        return indexSettings;
    protected final DeprecationLogger deprecationLogger;
 * specific language governing permissions and limitations
import org.opensearch.common.logging.DeprecationLogger;
package org.opensearch.index;
     * Constructs a new index component, with the index name and its settings.  
 * A base class for new index components
 * Licensed to Elasticsearch under one or more contributor  
/*
 *
 */
import org.opensearch.common.logging.Loggers;  
    public IndexSettings getIndexSettings() {
 */  
    }
/**  
 * You may obtain a copy of the License at  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
 *
 *  
 * @opensearch.internal  
    public Index index() {  
     */
    /**
    protected final IndexSettings indexSettings;  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.core.index.Index;
    @Override
 */
 * SPDX-License-Identifier: Apache-2.0
    protected AbstractIndexComponent(IndexSettings indexSettings) {
 */  
import org.apache.logging.log4j.Logger;
public abstract class AbstractIndexComponent implements IndexComponent {
/*  
    }  
 * Modifications Copyright OpenSearch Contributors. See
    protected final Logger logger;
        this.deprecationLogger = DeprecationLogger.getLogger(getClass());
 * compatible open source license.
 * this work for additional information regarding copyright
 * Unless required by applicable law or agreed to in writing,
 * GitHub history for details.
/*  
        return indexSettings.getIndex();
        this.logger = Loggers.getLogger(getClass(), indexSettings.getIndex());  
}
