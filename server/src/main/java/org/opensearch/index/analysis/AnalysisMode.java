        this.readableName = name;
 *  
            }  
 * this file be licensed under the Apache-2.0 license or a
    /**
 * ownership. Elasticsearch licenses this file to you under  
                throw new IllegalStateException("Cannot merge SEARCH_TIME and INDEX_TIME analysis mode.");
     * Returns a mode that is compatible with both this mode and the other mode, that is:
 *
        @Override
 * You may obtain a copy of the License at  
    public abstract AnalysisMode merge(AnalysisMode other);
/*
    /**
 *    http://www.apache.org/licenses/LICENSE-2.0
     * AnalysisMode representing analysis components that can be used only at index time
            }  
    };  
import org.opensearch.common.annotation.PublicApi;
                throw new IllegalStateException("Cannot merge SEARCH_TIME and INDEX_TIME analysis mode.");
     * AnalysisMode representing analysis components that can be used only at search time
 * under the License.  
     */  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public String getReadableName() {
 * The OpenSearch Contributors require contributions made to  
        public AnalysisMode merge(AnalysisMode other) {  
     * </ul>  
    },  
    },  
    }  
        @Override
     * AnalysisMode representing analysis components that can be used both at index and search time
     */  
     * <ul>
     * <li>ALL.merge(SEARCH_TIME) == SEARCH_TIME</li>
    /**  
        public AnalysisMode merge(AnalysisMode other) {  
 * this work for additional information regarding copyright
 * not use this file except in compliance with the License.
}  
 * KIND, either express or implied.  See the License for the
        public AnalysisMode merge(AnalysisMode other) {  
/*  
 * Unless required by applicable law or agreed to in writing,
 * Enum representing the mode in which token filters and analyzers are allowed to operate.
 *
    /**
            return AnalysisMode.SEARCH_TIME;
        }
        }
 * Modifications Copyright OpenSearch Contributors. See
 * compatible open source license.
public enum AnalysisMode {
    SEARCH_TIME("search time") {
 * While most token filters are allowed both in index and search time analyzers, some are
    ALL("all") {
 *
    }
 * specific language governing permissions and limitations
     * <li>ALL.merge(INDEX_TIME) == INDEX_TIME</li>  
 * restricted to be used only at index time, others at search time.  
 * @opensearch.api
/**  
 * the Apache License, Version 2.0 (the "License"); you may
        @Override
 */  
@PublicApi(since = "1.0.0")
            return AnalysisMode.INDEX_TIME;
 * software distributed under the License is distributed on an
package org.opensearch.index.analysis;
 * GitHub history for details.
            if (other == AnalysisMode.SEARCH_TIME) {
    private String readableName;
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
/*  
     */
 */  
     */  
    AnalysisMode(String name) {
            return other;
     * <li>INDEX_TIME.merge(SEARCH_TIME) throws an {@link IllegalStateException}</li>
    INDEX_TIME("index time") {
        return this.readableName;  
 * license agreements. See the NOTICE file distributed with
 */
 */  
            if (other == AnalysisMode.INDEX_TIME) {
        }
