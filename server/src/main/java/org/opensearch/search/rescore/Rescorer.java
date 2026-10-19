    TopDocs rescore(TopDocs topDocs, IndexSearcher searcher, RescoreContext rescoreContext) throws IOException;
 * Modifications Copyright OpenSearch Contributors. See
 */
     * @throws IOException if an {@link IOException} occurs  
    Explanation explain(int topLevelDocId, IndexSearcher searcher, RescoreContext rescoreContext, Explanation sourceExplanation)
 */  
 * not use this file except in compliance with the License.
     * @param searcher       the searcher used for this search. This will never be <code>null</code>.
     * @return the explain for the given top level document ID.
 * A query rescorer interface used to re-rank the Top-K results of a previously  
     * @param topLevelDocId the global / top-level document ID to explain
 * SPDX-License-Identifier: Apache-2.0
 * executed search.
    /**
 */  
 *
 *  
import org.apache.lucene.search.Explanation;
/**
}
public interface Rescorer {
     * @param rescoreContext context for this rescorer  
     * in place based on the given {@link RescoreContext}.
     * @param searcher the searcher used for this search. This will never be <code>null</code>.
import org.apache.lucene.search.TopDocs;  
 * compatible open source license.
 */
     *
 * You may obtain a copy of the License at  
/*  
 *  
 * GitHub history for details.
     * Executes an {@link Explanation} phase on the rescorer.
     * @param sourceExplanation explanation of the source of the documents being fed into this rescore
     *  
 * <p>
 * this work for additional information regarding copyright
     * @param rescoreContext the {@link RescoreContext}. This will never be <code>null</code>
import org.opensearch.common.annotation.PublicApi;
     * @throws IOException if an {@link IOException} occurs during rescoring  
     * @param topDocs        the result of the previously executed search  
 *
     */
 * fairly well behaved and documents that tradeoffs that it is making. There
 * this file be licensed under the Apache-2.0 license or a
 * specific language governing permissions and limitations
/*
 * under the License.  
@PublicApi(since = "1.0.0")  
package org.opensearch.search.rescore;
     */
import org.apache.lucene.search.IndexSearcher;
 * Licensed to Elasticsearch under one or more contributor  
 * Subclasses should borrow heavily from {@link QueryRescorer} because it is  
 * software distributed under the License is distributed on an
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * is also an {@code ExampleRescorer} that is worth looking at.
    /**
 * @opensearch.api
 * The OpenSearch Contributors require contributions made to  
 * ownership. Elasticsearch licenses this file to you under  
/*  
     * Modifies the result of the previously executed search ({@link TopDocs})  
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.io.IOException;  
 * the Apache License, Version 2.0 (the "License"); you may
 * KIND, either express or implied.  See the License for the
        throws IOException;  
