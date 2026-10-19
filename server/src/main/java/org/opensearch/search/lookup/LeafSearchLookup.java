    }
 * specific language governing permissions and limitations
    final Map<String, Object> asMap;  
        return this.fieldsLookup;
    }
import java.util.HashMap;
        Map<String, Object> asMap = new HashMap<>(4);
    }  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
    public Map<String, Object> asMap() {
 * KIND, either express or implied.  See the License for the
 */
 * this file be licensed under the Apache-2.0 license or a
 *
 * Modifications Copyright OpenSearch Contributors. See
 *    http://www.apache.org/licenses/LICENSE-2.0
    final LeafDocLookup docMap;  
        return this.sourceLookup;  
        this.ctx = ctx;  
 * ownership. Elasticsearch licenses this file to you under  
 * license agreements. See the NOTICE file distributed with
import org.apache.lucene.index.LeafReaderContext;
 * this work for additional information regarding copyright
    }
    public void setDocument(int docId) {
 * You may obtain a copy of the License at  
 *
 * Per-segment version of {@link SearchLookup}.
 *
}
        docMap.setDocument(docId);  
    public SourceLookup source() {
import java.util.Map;
    }  
    final SourceLookup sourceLookup;
    public LeafSearchLookup(LeafReaderContext ctx, LeafDocLookup docMap, SourceLookup sourceLookup, LeafFieldsLookup fieldsLookup) {
 * @opensearch.api  
        fieldsLookup.setDocument(docId);
        this.asMap = unmodifiableMap(asMap);
    public LeafDocLookup doc() {
/*  
/*  
        return this.docMap;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * GitHub history for details.
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
@PublicApi(since = "1.0.0")
    final LeafFieldsLookup fieldsLookup;
 * under the License.  
import org.opensearch.common.annotation.PublicApi;
        return this.asMap;
 *  
        this.docMap = docMap;
 */  
        this.sourceLookup = sourceLookup;
 * The OpenSearch Contributors require contributions made to  
/**  
    }  
package org.opensearch.search.lookup;
 * the Apache License, Version 2.0 (the "License"); you may
/*
        asMap.put("_source", sourceLookup);
import static java.util.Collections.unmodifiableMap;
 */  
        asMap.put("_fields", fieldsLookup);  
public class LeafSearchLookup {  
        sourceLookup.setSegmentAndDocument(ctx, docId);
 * Unless required by applicable law or agreed to in writing,
        asMap.put("_doc", docMap);
        asMap.put("doc", docMap);  
        this.fieldsLookup = fieldsLookup;  
 */
    final LeafReaderContext ctx;
    public LeafFieldsLookup fields() {  
 * SPDX-License-Identifier: Apache-2.0
