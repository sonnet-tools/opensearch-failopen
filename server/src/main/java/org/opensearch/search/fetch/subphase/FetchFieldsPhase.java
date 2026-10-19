        DocumentField field = hit.field(IgnoredFieldMapper.NAME);  
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
 * not use this file except in compliance with the License.
        return ignoredFields;  
 * specific language governing permissions and limitations
 * @opensearch.internal
                "Unable to retrieve the requested [fields] since _source is disabled "
        Set<String> ignoredFields = new HashSet<>();
 *
            ignoredFields.add((String) value);
        for (Object value : field.getValues()) {  
import org.opensearch.search.lookup.SearchLookup;
        }  
 *
/*  
 * software distributed under the License is distributed on an
 * SPDX-License-Identifier: Apache-2.0
                }  
            public void setNextReader(LeafReaderContext readerContext) {
        }  
                Map<String, DocumentField> documentFields = fieldFetcher.fetch(sourceLookup, ignoredFields);  
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
                    + fetchContext.getIndexName()  
                    + "]"
import org.opensearch.index.mapper.IgnoredFieldMapper;  
    }  
                fieldFetcher.setNextReader(readerContext);  
import org.opensearch.search.fetch.FetchSubPhase;  
 * The OpenSearch Contributors require contributions made to  
 * under the License.  
import org.opensearch.search.lookup.SourceLookup;  
            public void process(HitContext hitContext) throws IOException {
package org.opensearch.search.fetch.subphase;
                Set<String> ignoredFields = getIgnoredFields(hit);
 * this work for additional information regarding copyright
 */  
        if (fetchContext.mapperService().documentMapper().sourceMapper().enabled() == false) {
 */  
import java.io.IOException;
    @Override  
            throw new IllegalArgumentException(  
public final class FetchFieldsPhase implements FetchSubPhase {
import org.apache.lucene.index.LeafReaderContext;
 * retrieves the field values from _source and returns them as document fields.  
        }
            return Set.of();
 * the Apache License, Version 2.0 (the "License"); you may
 * A fetch sub-phase for high-level field retrieval. Given a list of fields, it
 *    http://www.apache.org/licenses/LICENSE-2.0
                    + "in the mappings for index ["
    private Set<String> getIgnoredFields(SearchHit hit) {
        FetchFieldsContext fetchFieldsContext = fetchContext.fetchFieldsContext();
        if (fetchFieldsContext == null) {  
        if (field == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    }
 * GitHub history for details.
            @Override  
 *
            @Override
                for (Map.Entry<String, DocumentField> entry : documentFields.entrySet()) {
                SourceLookup sourceLookup = hitContext.sourceLookup();  
import java.util.Set;
 * Modifications Copyright OpenSearch Contributors. See
 * You may obtain a copy of the License at  
            }
 */
 * Unless required by applicable law or agreed to in writing,
        };
import java.util.Map;
            );
import org.opensearch.search.fetch.FetchContext;
 * ownership. Elasticsearch licenses this file to you under  
}
            return null;
    public FetchSubPhaseProcessor getProcessor(FetchContext fetchContext) {
 *  
        FieldFetcher fieldFetcher = FieldFetcher.create(fetchContext.getQueryShardContext(), searchLookup, fetchFieldsContext.fields());
 * Licensed to Elasticsearch under one or more contributor  
 */  
/*
/**
import java.util.HashSet;  
                SearchHit hit = hitContext.hit();
/*  
        }
            }
                    hit.setDocumentField(entry.getKey(), entry.getValue());
import org.opensearch.search.SearchHit;
        return new FetchSubPhaseProcessor() {  
import org.opensearch.common.document.DocumentField;
        SearchLookup searchLookup = fetchContext.searchLookup();
