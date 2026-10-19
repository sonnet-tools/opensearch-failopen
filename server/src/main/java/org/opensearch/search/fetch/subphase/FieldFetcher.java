 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
 * license agreements. See the NOTICE file distributed with
 * specific language governing permissions and limitations
                if (ft == null || context.isMetadataField(field)) {
import org.opensearch.search.lookup.SearchLookup;  
/**
 * the Apache License, Version 2.0 (the "License"); you may
 *
                }
import org.opensearch.common.document.DocumentField;
 * You may obtain a copy of the License at  
            }
                documentFields.put(field, new DocumentField(field, parsedValues));
    }
import org.apache.lucene.index.LeafReaderContext;
        for (FieldAndFormat fieldAndFormat : fieldAndFormats) {
 * SPDX-License-Identifier: Apache-2.0
    }
import java.util.Set;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            String fieldPattern = fieldAndFormat.field;
                MappedFieldType ft = context.getFieldType(field);
            if (parsedValues.isEmpty() == false) {  
 * under the License.  
import java.util.HashMap;  
                    continue;  
    public Map<String, DocumentField> fetch(SourceLookup sourceLookup, Set<String> ignoredFields) throws IOException {
import java.util.Collection;
 */
 * @opensearch.internal  
        this.fieldContexts = fieldContexts;
            this.fieldName = fieldName;  
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
                continue;  
/*  
 * Licensed to Elasticsearch under one or more contributor  
        Map<String, DocumentField> documentFields = new HashMap<>();
import org.opensearch.index.query.QueryShardContext;
import java.io.IOException;  
 *
 */
    private final List<FieldContext> fieldContexts;
package org.opensearch.search.fetch.subphase;
import org.opensearch.index.mapper.MappedFieldType;  
 * this file be licensed under the Apache-2.0 license or a
 * Then given a specific document, it can retrieve the corresponding fields from the document's source.
                ValueFetcher valueFetcher = ft.valueFetcher(context, searchLookup, format);
    public void setNextReader(LeafReaderContext readerContext) {
            List<Object> parsedValues = valueFetcher.fetchValues(sourceLookup);
 * Modifications Copyright OpenSearch Contributors. See
    private FieldFetcher(List<FieldContext> fieldContexts) {  
 * not use this file except in compliance with the License.
            Collection<String> concreteFields = context.simpleMatchToIndexNames(fieldPattern);
            String format = fieldAndFormat.format;  
    }
/*  
        }
        final String fieldName;
import java.util.Map;
        List<FieldContext> fieldContexts = new ArrayList<>();
        }  
        }
public class FieldFetcher {
    public static FieldFetcher create(QueryShardContext context, SearchLookup searchLookup, Collection<FieldAndFormat> fieldAndFormats) {  
 */  
            }
    private static class FieldContext {
            this.valueFetcher = valueFetcher;
            field.valueFetcher.setNextReader(readerContext);  
 */  
        for (FieldContext context : fieldContexts) {  
        FieldContext(String fieldName, ValueFetcher valueFetcher) {
 * GitHub history for details.
    }  
 * this work for additional information regarding copyright
 * A helper class to {@link FetchFieldsPhase} that's initialized with a list of field patterns to fetch.  
 *  
            if (ignoredFields.contains(field)) {
 * The OpenSearch Contributors require contributions made to  
    }
            String field = context.fieldName;
import java.util.List;
        for (FieldContext field : fieldContexts) {
 *
        final ValueFetcher valueFetcher;  
            ValueFetcher valueFetcher = context.valueFetcher;  
        return new FieldFetcher(fieldContexts);
            for (String field : concreteFields) {  
        return documentFields;
}
import java.util.ArrayList;
import org.opensearch.index.mapper.ValueFetcher;
/*
                fieldContexts.add(new FieldContext(field, valueFetcher));  
            }
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
 * Unless required by applicable law or agreed to in writing,
import org.opensearch.search.lookup.SourceLookup;
