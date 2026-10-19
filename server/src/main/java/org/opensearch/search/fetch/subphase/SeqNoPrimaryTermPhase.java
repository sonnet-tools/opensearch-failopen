 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
                    boolean found = seqNoField.advanceExact(docId);
/**
            return null;
                long seqNo = SequenceNumbers.UNASSIGNED_SEQ_NO;  
 * Unless required by applicable law or agreed to in writing,
        };  
 *
                seqNoField = readerContext.reader().getNumericDocValues(SeqNoFieldMapper.NAME);
 */
    }
import org.opensearch.search.fetch.FetchContext;
 * this work for additional information regarding copyright
                int docId = hitContext.docId();
import org.opensearch.index.mapper.SeqNoFieldMapper;
                hitContext.hit().setPrimaryTerm(primaryTerm);
 * not use this file except in compliance with the License.
/*
 */
        return new FetchSubPhaseProcessor() {
 * compatible open source license.
 * specific language governing permissions and limitations
            public void process(HitContext hitContext) throws IOException {
import java.io.IOException;
 *  
 * under the License.  
 * You may obtain a copy of the License at  
            @Override  
                    primaryTerm = primaryTermField.longValue();
                hitContext.hit().setSeqNo(seqNo);  
 */  
 * GitHub history for details.
 * KIND, either express or implied.  See the License for the
            }
 * software distributed under the License is distributed on an
        if (context.seqNoAndPrimaryTerm() == false) {
 * Modifications Copyright OpenSearch Contributors. See  
            NumericDocValues primaryTermField = null;
 * Licensed to Elasticsearch under one or more contributor  
            @Override  
 * license agreements. See the NOTICE file distributed with
            NumericDocValues seqNoField = null;  
                    seqNo = seqNoField.longValue();  
 * the Apache License, Version 2.0 (the "License"); you may
/*  
            }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.index.seqno.SequenceNumbers;  
 * Fetches the sequence number of the primary term during search phase
                // we have to check the primary term field as it is only assigned for non-nested documents
    @Override
/*
 *  
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.apache.lucene.index.NumericDocValues;
            public void setNextReader(LeafReaderContext readerContext) throws IOException {
        }  
                primaryTermField = readerContext.reader().getNumericDocValues(SeqNoFieldMapper.PRIMARY_TERM_NAME);  
public final class SeqNoPrimaryTermPhase implements FetchSubPhase {  
import org.apache.lucene.index.LeafReaderContext;  
}
import org.opensearch.search.fetch.FetchSubPhaseProcessor;  
                long primaryTerm = SequenceNumbers.UNASSIGNED_PRIMARY_TERM;
    public FetchSubPhaseProcessor getProcessor(FetchContext context) {  
 */
                    assert found : "found seq no for " + docId + " but not a primary term";
import org.opensearch.search.fetch.FetchSubPhase;
                if (primaryTermField != null && primaryTermField.advanceExact(docId)) {  
                }
 * ownership. Elasticsearch licenses this file to you under  
 * @opensearch.internal
 *
 * SPDX-License-Identifier: Apache-2.0
package org.opensearch.search.fetch.subphase;
