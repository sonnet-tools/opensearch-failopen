    public FetchSubPhaseProcessor getProcessor(FetchContext fetchContext) {
        if (nestedHit) {
            value = getNestedSource((Map<String, Object>) value, hitContext);
                // being return in this situation in 5.x and earlier.
            }
        // If source is disabled in the mapping, then attempt to return early.
 * You may obtain a copy of the License at  
import org.opensearch.search.fetch.FetchContext;
                );  
 * Unless required by applicable law or agreed to in writing,
/*
                throw new IllegalArgumentException(
import org.opensearch.search.fetch.FetchSubPhaseProcessor;  
public final class FetchSourcePhase implements FetchSubPhase {
                    "unable to fetch fields from _source field: _source is disabled in the mappings " + "for index [" + index + "]"
                builder.value(value);
 * ownership. Elasticsearch licenses this file to you under  
        Object value = source.filter(fetchSourceContext);  
                // it is. In certain cases, for example response serialization we fail if no xcontent type can't be
 * this work for additional information regarding copyright
 *
 *
            }
        }  
 * The OpenSearch Contributors require contributions made to  
        return new FetchSubPhaseProcessor() {
        if (fetchSourceContext == null || fetchSourceContext.fetchSource() == false) {
            XContentBuilder builder = new XContentBuilder(source.sourceContentType().xContent(), streamOutput);
        // If this is a parent document and there are no source filters, then add the source as-is.
 *  
            } else {
    @Override
    private void hitExecute(String index, FetchSourceContext fetchSourceContext, HitContext hitContext) {
/**  
    private static boolean containsFilters(FetchSourceContext context) {
            BytesStreamOutput streamOutput = new BytesStreamOutput(initialCapacity);
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.common.io.stream.BytesStreamOutput;  
        } catch (IOException e) {  
import org.opensearch.search.SearchHit;  
 * license agreements. See the NOTICE file distributed with
                hitExecute(index, fetchSourceContext, hitContext);  
 */
 * GitHub history for details.
        try {
    }  
 * Fetches the document source during search phase
            return null;
 * under the License.  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
                // Just doing `builder.value(null)` is valid, but the xcontent validation can't detect what format
import org.opensearch.search.lookup.SourceLookup;
                return null;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import org.opensearch.OpenSearchException;
        return sourceAsMap;
            if (sourceAsMap == null) {  
        }
                // This happens if the source filtering could not find the specified in the _source.  
 * not use this file except in compliance with the License.
 * compatible open source license.
        }  
 * @opensearch.internal  
 * Modifications Copyright OpenSearch Contributors. See
/*  
        };
 *    http://www.apache.org/licenses/LICENSE-2.0
        }  
        // Otherwise, filter the source and add it to the hit.
import org.opensearch.core.common.bytes.BytesReference;
 */  
        for (SearchHit.NestedIdentity o = hitContext.hit().getNestedIdentity(); o != null; o = o.getChild()) {
            public void setNextReader(LeafReaderContext readerContext) {  
            final int initialCapacity = nestedHit ? 1024 : Math.min(1024, source.internalSourceRef().length());  
import java.io.IOException;  
        }  
 * this file be licensed under the Apache-2.0 license or a
        assert fetchSourceContext.fetchSource();
import org.apache.lucene.index.LeafReaderContext;
            if (value != null) {  
/*  
            if (containsFilters(fetchSourceContext)) {  
 * SPDX-License-Identifier: Apache-2.0
}  
package org.opensearch.search.fetch.subphase;
                builder.endObject();  
            sourceAsMap = (Map<String, Object>) sourceAsMap.get(o.getField().string());
        FetchSourceContext fetchSourceContext = fetchContext.fetchSourceContext();  
        String index = fetchContext.getIndexName();
        if (nestedHit == false && containsFilters(fetchSourceContext) == false) {  
            hitContext.hit().sourceRef(source.internalSourceRef());
            }
        }  
                // detected. So instead we just return an empty top level object. Also this is in inline with what was  
    }
import org.opensearch.search.fetch.FetchSubPhase;
            }
            }
    private Map<String, Object> getNestedSource(Map<String, Object> sourceAsMap, HitContext hitContext) {  
 *
            @Override
        return context.includes().length != 0 || context.excludes().length != 0;  
            throw new OpenSearchException("Error filtering source", e);
                builder.startObject();
            hitContext.hit().sourceRef(BytesReference.bytes(builder));
        SourceLookup source = hitContext.sourceLookup();
    }  
        final boolean nestedHit = hitContext.hit().getNestedIdentity() != null;
import org.opensearch.core.xcontent.XContentBuilder;
import java.util.Map;
            return;
 */  
        if (source.source() == null && source.internalSourceRef() == null) {
    }
            @Override
 * software distributed under the License is distributed on an
 * specific language governing permissions and limitations
            public void process(HitContext hitContext) {
 */
            return;
