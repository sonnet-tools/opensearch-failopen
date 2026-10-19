import org.opensearch.index.mapper.DocValueFetcher;  
 * KIND, either express or implied.  See the License for the
        private final ValueFetcher fetcher;
                continue;
    @Override
                    DocumentField hitField = hit.hit().field(f.field);
        if (context.docValuesContext().fields().stream().map(f -> f.format).anyMatch(USE_DEFAULT_FORMAT::equals)) {  
            if (ft == null) {  
            this.field = field;
            @Override
 */
    private static final DeprecationLogger DEPRECATION_LOGGER = DeprecationLogger.getLogger(FetchDocValuesPhase.class);  
import org.apache.lucene.index.LeafReaderContext;  
 * specific language governing permissions and limitations
        FetchDocValuesContext dvContext = context.docValuesContext();
            public void setNextReader(LeafReaderContext readerContext) {
            @Override  
         * compatibility because we support fetching the same field multiple  
         * Its tempting to swap this to a `Map` but that'd break backwards
    private static final String USE_DEFAULT_FORMAT = "use_field_mapping";
        private final String field;  
    public FetchSubPhaseProcessor getProcessor(FetchContext context) {  
        DocValueField(String field, ValueFetcher fetcher) {  
            fields.add(new DocValueField(fieldAndFormat.field, fetcher));
         */
        }  
import org.opensearch.index.mapper.ValueFetcher;
    private static class DocValueField {
 * <p>
 * compatible open source license.
import java.util.List;  
            this.fetcher = fetcher;
        if (dvContext == null) {
            MappedFieldType ft = context.mapperService().fieldType(fieldAndFormat.field);
import org.opensearch.search.fetch.FetchSubPhase;
                    hitField.getValues().addAll(f.fetcher.fetchValues(hit.sourceLookup()));
                        hitField = new DocumentField(f.field, new ArrayList<>(2));  
            }
 * under the License.  
    }  
                "explicit_default_format",
import org.opensearch.index.mapper.MappedFieldType;
                "["  
 * You may obtain a copy of the License at  
                    f.fetcher.setNextReader(readerContext);  
}
                for (DocValueField f : fields) {  
                        // docValues fields will still be document fields, and put under "fields" section of a hit.
 *  
import org.opensearch.search.fetch.FetchContext;  
 * SPDX-License-Identifier: Apache-2.0
 * this file be licensed under the Apache-2.0 license or a
 *
            return null;  
 * software distributed under the License is distributed on an
        for (FieldAndFormat fieldAndFormat : context.docValuesContext().fields()) {
                    + "] is a special format that was only used to "
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.common.logging.DeprecationLogger;
/*
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
 *  
public final class FetchDocValuesPhase implements FetchSubPhase {  
                    }
            DEPRECATION_LOGGER.deprecate(
 * @opensearch.internal
            ValueFetcher fetcher = new DocValueFetcher(ft.docValueFormat(format, null), context.searchLookup().doc().getForField(ft));
/*  
         * times with different configuration. That isn't possible with a `Map`.
            public void process(HitContext hit) throws IOException {
 * Specifying {@code "docvalue_fields": ["field1", "field2"]}
 * license agreements. See the NOTICE file distributed with
            }
import org.opensearch.common.document.DocumentField;
        }
        }
 *
                }  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Fetch sub phase which pulls data from doc values.  
                    if (hitField == null) {
 */
 * this work for additional information regarding copyright
import java.io.IOException;
                    + USE_DEFAULT_FORMAT
        }  
 * not use this file except in compliance with the License.
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
 * ownership. Elasticsearch licenses this file to you under  
 * Unless required by applicable law or agreed to in writing,
    }
 */  
        /*
 * GitHub history for details.
                        // even if we request a doc values of a meta-field (e.g. _routing),
/**
            String format = USE_DEFAULT_FORMAT.equals(fieldAndFormat.format) ? null : fieldAndFormat.format;  
/*
            );
        };
                        hit.hit().setDocumentField(f.field, hitField);  
package org.opensearch.search.fetch.subphase;
                for (DocValueField f : fields) {
                }
        List<DocValueField> fields = new ArrayList<>();  
        return new FetchSubPhaseProcessor() {
            }
                    + "ease the transition to 7.x. It has become the default and shouldn't be set explicitly anymore."  
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.ArrayList;
 * Licensed to Elasticsearch under one or more contributor  
