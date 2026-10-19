            @Override
 * KIND, either express or implied.  See the License for the
     */
            public int docValueCount() throws IOException {  
 * specific language governing permissions and limitations
     * Return a value fetcher for this leaf implementation.
            }  
     */
@PublicApi(since = "1.0.0")
    }  
import org.opensearch.common.lease.Releasable;  
 * ownership. Elasticsearch licenses this file to you under  
/**  
                return format.format(values.nextValue());  
        SortedBinaryDocValues values = getBytesValues();
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.index.mapper.DocValueFetcher;
 * this work for additional information regarding copyright
 * You may obtain a copy of the License at  
 *
            public Object nextValue() throws IOException {
     * Returns field values for use in scripting.  
package org.opensearch.index.fielddata;
                return values.docValueCount();
 * GitHub history for details.
 * this file be licensed under the Apache-2.0 license or a
     */  
 */
 * Licensed to Elasticsearch under one or more contributor  
import org.opensearch.search.DocValueFormat;
    /**
    /**  
 *    http://www.apache.org/licenses/LICENSE-2.0
    /**
 * license agreements. See the NOTICE file distributed with
/*  
        return new DocValueFetcher.Leaf() {
 * The OpenSearch Contributors require contributions made to  
 *
 *  
 * not use this file except in compliance with the License.
import org.opensearch.common.annotation.PublicApi;
 */  
 *
    ScriptDocValues<?> getScriptValues();
                return values.advanceExact(docId);
     * Return a String representation of the values.
            }
 */
            @Override  
}
            public boolean advanceExact(int docId) throws IOException {
 * SPDX-License-Identifier: Apache-2.0
 * software distributed under the License is distributed on an
 * @opensearch.api  
public interface LeafFieldData extends Accountable, Releasable {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    SortedBinaryDocValues getBytesValues();
/*
    default DocValueFetcher.Leaf getLeafValueFetcher(DocValueFormat format) {  
        };
            }
 * The thread safe {@link org.apache.lucene.index.LeafReader} level cache of the data.
            @Override
import java.io.IOException;
import org.apache.lucene.util.Accountable;
 */  
 * the Apache License, Version 2.0 (the "License"); you may
 * Unless required by applicable law or agreed to in writing,
/*  
 * compatible open source license.
 * under the License.  
