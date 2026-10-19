    private final Rescorer rescorer;
 * not use this file except in compliance with the License.
 */  
    public void setRescoredDocs(Set<Integer> docIds) {  
    private final int windowSize;  
        return rescoredDocs;  
        rescoredDocs = docIds;
 * the Apache License, Version 2.0 (the "License"); you may
        return Collections.emptyList();
import java.util.Collections;
/**  
     */
    }
 * this file be licensed under the Apache-2.0 license or a
    /**
 */  
    public RescoreContext(int windowSize, Rescorer rescorer) {
    /**
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
     * The rescorer to actually apply.
 * Modifications Copyright OpenSearch Contributors. See
    /**  
 * The OpenSearch Contributors require contributions made to  
 * software distributed under the License is distributed on an
        return windowSize;  
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.rescorer = rescorer;
    public boolean isRescored(int docId) {
        return rescoredDocs != null && rescoredDocs.contains(docId);
    private Set<Integer> rescoredDocs; // doc Ids for which rescoring was applied
 * they will need while rescoring.  
    public Set<Integer> getRescoredDocs() {
     * Returns queries associated with the rescorer
    }
     */  
     */
        return rescorer;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
 * SPDX-License-Identifier: Apache-2.0
    }
import java.util.List;  
    public Rescorer rescorer() {
    }  
     * Returns parsed queries associated with the rescorer
     */  
    public List<ParsedQuery> getParsedQueries() {
 * Context available to the rescore while it is running. Rescore
@PublicApi(since = "1.0.0")
    }
 * compatible open source license.
    /**
     * @param rescorer the rescorer actually performing the rescore.  
        return Collections.emptyList();
 * this work for additional information regarding copyright
import org.apache.lucene.search.Query;
 * @opensearch.api
 * ownership. Elasticsearch licenses this file to you under  
 * Licensed to Elasticsearch under one or more contributor  
     */
import java.util.Set;
 * You may obtain a copy of the License at  
import org.opensearch.common.annotation.PublicApi;
 * GitHub history for details.
    public int getWindowSize() {
     * Build the context.
    public List<Query> getQueries() {  
    }  
 */  
 * implementations should extend this with any additional resources that
package org.opensearch.search.rescore;
}
        this.windowSize = windowSize;  
public class RescoreContext {
     * Size of the window to rescore.  
 */
 *
    /**
 * Unless required by applicable law or agreed to in writing,
 *
/*
/*  
/*  
 *
import org.opensearch.index.query.ParsedQuery;  
 *  
 * under the License.  
    }
 * specific language governing permissions and limitations
