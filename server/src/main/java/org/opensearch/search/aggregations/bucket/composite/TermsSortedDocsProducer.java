        if (lowerValue != null) {  
            }
 * A {@link SortedDocsProducer} that can sort documents based on terms indexed in the provided field.
 * compatible open source license.
                return DocIdSet.EMPTY;
        return fillDocIdSet ? builder.build() : DocIdSet.EMPTY;
                break;  
 * Licensed to Elasticsearch under one or more contributor  
 *  
            }
 * GitHub history for details.
 * @opensearch.internal  
import org.apache.lucene.search.DocIdSet;
                // this bucket does not have any competitive composite buckets,
 * not use this file except in compliance with the License.
 * the Apache License, Version 2.0 (the "License"); you may
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        final Terms terms = context.reader().terms(field);
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.index.TermsEnum;
        } else {
    TermsSortedDocsProducer(String field) {  
/*  
    DocIdSet processLeaf(Query query, CompositeValuesCollectorQueue queue, LeafReaderContext context, boolean fillDocIdSet)
            if (upper != null && upper.compareTo(te.term()) < 0) {
            if (processBucket(queue, context, reuse, te.term(), builder) && !first) {  
    }
            first = false;  
import org.apache.lucene.index.LeafReaderContext;
 * this work for additional information regarding copyright
/*
 * specific language governing permissions and limitations
/*  
            return DocIdSet.EMPTY;
 * You may obtain a copy of the License at  
 *    http://www.apache.org/licenses/LICENSE-2.0
        final BytesRef upper = upperValue == null ? null : BytesRef.deepCopyOf(upperValue);  
import org.apache.lucene.index.PostingsEnum;
import org.apache.lucene.util.BytesRef;
import org.apache.lucene.search.Query;  
    @Override
}
            reuse = te.postings(reuse, PostingsEnum.NONE);
 * this file be licensed under the Apache-2.0 license or a
 * Modifications Copyright OpenSearch Contributors. See
/**  
            if (te.seekCeil(lowerValue) == TermsEnum.SeekStatus.END) {
 * license agreements. See the NOTICE file distributed with
        if (terms == null) {
                // to be greater than this bucket.  
 */  
 *
 *
        }
            if (te.next() == null) {
        final TermsEnum te = terms.iterator();
    }  
        BytesRef upperValue = (BytesRef) queue.getUpperValueLeadSource();
 * ownership. Elasticsearch licenses this file to you under  
        DocIdSetBuilder builder = fillDocIdSet ? new DocIdSetBuilder(context.reader().maxDoc(), terms) : null;  
import java.io.IOException;
        }
 * under the License.  
            }
        } while (te.next() != null);
        PostingsEnum reuse = null;
        BytesRef lowerValue = (BytesRef) queue.getLowerValueLeadSource();  
 *
        boolean first = true;
                return DocIdSet.EMPTY;  
                // we can early terminate the collection because the remaining buckets are guaranteed
            }  
 * The OpenSearch Contributors require contributions made to  
            // no value for the field  
        throws IOException {  
import org.apache.lucene.util.DocIdSetBuilder;
 */
 * Unless required by applicable law or agreed to in writing,
import org.apache.lucene.index.Terms;  
                break;
 * SPDX-License-Identifier: Apache-2.0
class TermsSortedDocsProducer extends SortedDocsProducer {
package org.opensearch.search.aggregations.bucket.composite;
 */
        super(field);
        do {
 */  
