        }
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
/*
     * <p>  
        public LeafReaderContext readerContext() {
 * not use this file except in compliance with the License.
 * this file be licensed under the Apache-2.0 license or a
            return readerContext;
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
    FetchSubPhaseProcessor getProcessor(FetchContext fetchContext) throws IOException;
 * Sub phase within the fetch phase used to fetch things *about* the documents like highlighting or matched queries.
 * GitHub history for details.
        public LeafReader reader() {  
     * Returns a {@link FetchSubPhaseProcessor} for this sub phase.
            sourceLookup.setSegmentAndDocument(context, docId);
}
 * under the License.  
        public SearchHit hit() {
     */  
import org.apache.lucene.index.ReaderUtil;  
 * @opensearch.internal  
        }
         * that it should always be set to the correct doc ID and {@link LeafReaderContext}.
 */
 * specific language governing permissions and limitations
import java.io.IOException;
 *  
 * The OpenSearch Contributors require contributions made to  
        private final int docId;  
        }  
 *
        private final SearchHit hit;
import org.apache.lucene.index.IndexReader;  
 * this work for additional information regarding copyright
 * the Apache License, Version 2.0 (the "License"); you may
     * @opensearch.internal
        public IndexReader topLevelReader() {
import org.apache.lucene.index.LeafReaderContext;
         * In most cases, the hit document's source is loaded eagerly at the start of the
         * This lookup provides access to the source for the given hit document. Note
         * {@link FetchPhase}. This lookup will contain the preloaded source.
        public int docId() {
 */
import org.apache.lucene.index.LeafReader;
/*
        private final LeafReaderContext readerContext;
            return ReaderUtil.getTopLevelContext(readerContext).reader();  
 *
/*  
        }
            this.docId = docId;  
        private final SourceLookup sourceLookup;
            this.sourceLookup = sourceLookup;
     *  
     * If nothing should be executed for the provided {@code FetchContext}, then the
        /**  
     * The hit context for the fetch subphase
import org.opensearch.search.lookup.SourceLookup;
            return docId;  
 * software distributed under the License is distributed on an
         * <p>  
        /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.search.fetch;
 * license agreements. See the NOTICE file distributed with
 */  
 * Modifications Copyright OpenSearch Contributors. See  
     */
            this.readerContext = context;
            this.hit = hit;
public interface FetchSubPhase {
        public HitContext(SearchHit hit, LeafReaderContext context, int docId, SourceLookup sourceLookup) {  
    class HitContext {  
 * compatible open source license.
 * ownership. Elasticsearch licenses this file to you under  
            return readerContext.reader();
/**  
        }  
            return sourceLookup;
         */
            return hit;  
    }
 */
        public SourceLookup sourceLookup() {
         */  
    /**
 * KIND, either express or implied.  See the License for the
 *    http://www.apache.org/licenses/LICENSE-2.0
     * implementation should return {@code null}
    /**
 *
         * @return the docId of this hit relative to the leaf reader context  
        }  
        }
import org.opensearch.search.SearchHit;
