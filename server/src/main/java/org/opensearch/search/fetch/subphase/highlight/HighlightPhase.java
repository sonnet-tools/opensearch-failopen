                        // Note that we make sure to use the original field name in the response. This is because the  
        );
                    if (highlighter.canHighlight(fieldType) == false) {
                    fieldType = context.getQueryShardContext().resolveDerivedFieldType(fieldName);
                }
 * not use this file except in compliance with the License.
 * Highlight Phase of the search request.
import org.opensearch.search.fetch.FetchContext;  
        }  
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
            public void process(HitContext hitContext) throws IOException {
            if (highlightContext.forceSource(field)) {  
                // However, someone might implement a custom field type that has text and still want to
                // highlight on that. We cannot know in advance if the highlighter will be able to
                        continue;  
        return highlighter;
 * Licensed to Elasticsearch under one or more contributor  
                    continue;
                }  
                fieldNamesToHighlight = Collections.singletonList(field.field());  
            if (Regex.isSimpleMatchPattern(field.field())) {  
        this.highlighters = highlighters;
        return new FetchSubPhaseProcessor() {
/*  
    ) {
    }
    private final Map<String, Highlighter> highlighters;
                        finalFieldType.name(),
            sharedCache
public class HighlightPhase implements FetchSubPhase {
 *    http://www.apache.org/licenses/LICENSE-2.0
                for (String field : contextBuilders.keySet()) {
import org.opensearch.index.mapper.TextFieldMapper;
        Query query,
                        && fieldType.typeName().equals(MatchOnlyTextFieldMapper.CONTENT_TYPE) == false) {
        }
 * under the License.  
/*  
                        && fieldType.typeName().equals(KeywordFieldMapper.CONTENT_TYPE) == false
import org.opensearch.index.mapper.KeywordFieldMapper;
            @Override
                MappedFieldType fieldType = context.mapperService().fieldType(fieldName);  
                        continue;  
 * this file be licensed under the Apache-2.0 license or a
                        // original field could be an alias, and highlighter implementations may instead reference the
            @Override
    }  
 */  
        SearchHighlightContext highlightContext,
 */  
 *
 * compatible open source license.
import java.util.LinkedHashMap;
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;  
    }
                Query highlightQuery = field.fieldOptions().highlightQuery();
        if (highlighterType == null) {
                    Highlighter highlighter = getHighlighter(fieldContext.field);  
                fieldNamesToHighlight = context.mapperService().simpleMatchToFullName(field.field());
 * ownership. Elasticsearch licenses this file to you under  
            }
                    if (fieldType.typeName().equals(TextFieldMapper.CONTENT_TYPE) == false  
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
                // We should prevent highlighting if a field is anything but a text, match_only_text
        };
 * Modifications Copyright OpenSearch Contributors. See
                // or keyword field.  
            return null;
                        context,
                    if (highlightField != null) {
                }
import org.opensearch.index.mapper.MappedFieldType;
                MappedFieldType finalFieldType = fieldType;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        highlightFields.put(field, new HighlightField(field, highlightField.fragments()));  
 * @opensearch.internal  
import java.util.Collections;  
 * the Apache License, Version 2.0 (the "License"); you may
import org.opensearch.index.mapper.SourceFieldMapper;
        FetchContext context,  
                    FieldHighlightContext fieldContext = contextBuilders.get(field).apply(hitContext);
 * You may obtain a copy of the License at  
            }
                if (fieldNameContainsWildcards) {
        Map<String, Function<HitContext, FieldHighlightContext>> builders = new LinkedHashMap<>();
        Map<String, Function<HitContext, FieldHighlightContext>> contextBuilders = contextBuilders(  
    private Highlighter getHighlighter(SearchHighlightContext.Field field) {
 *  
import org.opensearch.search.fetch.FetchSubPhase;
        }
 */
            Collection<String> fieldNamesToHighlight;
                    HighlightField highlightField = highlighter.highlight(fieldContext);
import java.util.Collection;
            }
    }  
            highlighterType = "unified";
                    }
}
package org.opensearch.search.fetch.subphase.highlight;
                // If the field is only highlighted because the field matches a wildcard we assume
        return builders;
                SourceFieldMapper sourceFieldMapper = context.mapperService().documentMapper().sourceMapper();
                        finalFieldType,
import java.util.function.Function;
            }
import java.io.IOException;
        Highlighter highlighter = highlighters.get(highlighterType);
                    )
                Map<String, HighlightField> highlightFields = new HashMap<>();  
                        forceSource,
import java.util.HashMap;
            public void setNextReader(LeafReaderContext readerContext) {  
import org.apache.lucene.search.Query;
        String highlighterType = field.fieldOptions().highlighterType();  
                    }
    public FetchSubPhaseProcessor getProcessor(FetchContext context, SearchHighlightContext highlightContext, Query query) {
                if (sourceFieldMapper.enabled() == false) {
                builders.put(
    public FetchSubPhaseProcessor getProcessor(FetchContext context) {
                        highlightQuery == null ? query : highlightQuery,
import org.apache.lucene.index.LeafReaderContext;
                        field,  
    @Override
 * license agreements. See the NOTICE file distributed with
        }
                // highlight such a field and so we do the following:  
        for (SearchHighlightContext.Field field : highlightContext.fields()) {  
            for (String fieldName : fieldNamesToHighlight) {
 * Unless required by applicable law or agreed to in writing,
 *
                // it was a mistake and do not process it.
                }
    }  
                    }
            highlightContext,
            }  
/*
        if (highlighter == null) {
                if (fieldType == null) {
            query,  
import java.util.Map;  
                    hc -> new FieldHighlightContext(
    private Map<String, Function<HitContext, FieldHighlightContext>> contextBuilders(
        if (context.highlight() == null) {  
        return getProcessor(context, context.highlight(), context.parsedQuery().query());
                // If the field was explicitly given we assume that whoever issued the query knew  
                if (fieldType == null) {
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
                boolean forceSource = highlightContext.forceSource(field);  
                        sharedCache  
            boolean fieldNameContainsWildcards = field.field().contains("*");
            throw new IllegalArgumentException("unknown highlighter type [" + highlighterType + "] for the field [" + field.field() + "]");  
 * this work for additional information regarding copyright
        Map<String, Object> sharedCache = new HashMap<>();
import org.opensearch.common.regex.Regex;  
            Highlighter highlighter = getHighlighter(field);
 */
/**  
                // what they were doing and try to highlight anyway.
 * KIND, either express or implied.  See the License for the
            context,
 *
    public HighlightPhase(Map<String, Highlighter> highlighters) {  
                    fieldName,  
        Map<String, Object> sharedCache  
            } else {
                }  
                        hc,  
 * SPDX-License-Identifier: Apache-2.0
                    throw new IllegalArgumentException("source is forced for fields " + fieldNamesToHighlight + " but _source is disabled");  
                );
                        // concrete field it points to.
                hitContext.hit().highlightFields(highlightFields);  
