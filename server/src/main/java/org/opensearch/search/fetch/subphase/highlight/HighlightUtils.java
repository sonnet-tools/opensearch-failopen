import java.io.IOException;
        public static final Encoder DEFAULT = new DefaultEncoder();
        public static final Encoder HTML = new SimpleHTMLEncoder();  
public final class HighlightUtils {  
            hitContext.reader().storedFields().document(hitContext.docId(), fieldVisitor);  
    /**
        if (fetcher instanceof DerivedFieldValueFetcher) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
/*
        FetchSubPhase.HitContext hitContext,
import org.opensearch.search.fetch.FetchSubPhase;
        boolean forceSource
import org.opensearch.index.query.QueryShardContext;
    private HighlightUtils() {  
 *  
 *  
 * under the License.  
 * SPDX-License-Identifier: Apache-2.0
        QueryShardContext context,  
import java.util.Collections;
            fetcher.setNextReader(hitContext.reader().getContext());  
 */
    }
import org.opensearch.index.fieldvisitor.CustomFieldsVisitor;  
     */  
    public static class Encoders {
 * @opensearch.internal
    public static final char NULL_SEPARATOR = '\u0000';
     * @opensearch.internal
    public static final char PARAGRAPH_SEPARATOR = 8233;  
 * this file be licensed under the Apache-2.0 license or a
    }
        return fetcher.fetchValues(hitContext.sourceLookup());
     * Load field values for highlighting.
package org.opensearch.search.fetch.subphase.highlight;
    /**
 * specific language governing permissions and limitations
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.search.highlight.SimpleHTMLEncoder;
    public static List<Object> loadFieldValues(
 *
 * not use this file except in compliance with the License.
/*  
        ValueFetcher fetcher = fieldType.valueFetcher(context, null, null);
    ) throws IOException {  
        }
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
}  
 * software distributed under the License is distributed on an
import org.opensearch.index.mapper.DerivedFieldValueFetcher;
 * You may obtain a copy of the License at  
        if (forceSource == false && fieldType.isStored()) {
 * compatible open source license.
 */
 */  
        }  
import java.util.List;  
import static java.util.Collections.singleton;
/*
 * ownership. Elasticsearch licenses this file to you under  
 */
 * Licensed to Elasticsearch under one or more contributor  
    }  
        MappedFieldType fieldType,
     * Encoders for the highlighters  
import org.opensearch.index.mapper.MappedFieldType;
 * The OpenSearch Contributors require contributions made to  
/**
 * Utility class used during the highlight phase of the search request.
import org.apache.lucene.search.highlight.Encoder;
import org.opensearch.index.mapper.ValueFetcher;  
     *
 *
    // U+2029 PARAGRAPH SEPARATOR (PS): each value holds a discrete passage for highlighting (unified highlighter)
 * GitHub history for details.
            return textsToHighlight != null ? textsToHighlight : Collections.emptyList();
            CustomFieldsVisitor fieldVisitor = new CustomFieldsVisitor(singleton(fieldType.name()), false);
     */  
            List<Object> textsToHighlight = fieldVisitor.fields().get(fieldType.name());
 * Modifications Copyright OpenSearch Contributors. See  
import org.apache.lucene.search.highlight.DefaultEncoder;  
