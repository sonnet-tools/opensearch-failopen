                        && fieldType.typeName().equals(KeywordFieldMapper.CONTENT_TYPE) == false
                        field,
            }
    }
                        // original field could be an alias, and highlighter implementations may instead reference the
                    if (fieldType.typeName().equals(TextFieldMapper.CONTENT_TYPE) == false
import org.apache.lucene.search.Query;
        Highlighter highlighter = highlighters.get(highlighterType);
        Map<String, Object> sharedCache
/**
package org.opensearch.search.fetch.subphase.highlight;
                );
    ) {
                // However, someone might implement a custom field type that has text and still want to
import org.opensearch.index.mapper.MappedFieldType;
                    Highlighter highlighter = getHighlighter(fieldContext.field);
                fieldNamesToHighlight = context.mapperService().simpleMatchToFullName(field.field());
                }
                    fieldType = context.getQueryShardContext().resolveDerivedFieldType(fieldName);
                fieldNamesToHighlight = Collections.singletonList(field.field());
}
 * SPDX-License-Identifier: Apache-2.0
            throw new IllegalArgumentException("unknown highlighter type [" + highlighterType + "] for the field [" + field.field() + "]");
            }
            for (String fieldName : fieldNamesToHighlight) {
 * ownership. Elasticsearch licenses this file to you under
                        hc,
                if (fieldType == null) {
 * this work for additional information regarding copyright
                for (String field : contextBuilders.keySet()) {
        Map<String, Function<HitContext, FieldHighlightContext>> contextBuilders = contextBuilders(
                        continue;
                    throw new IllegalArgumentException("source is forced for fields " + fieldNamesToHighlight + " but _source is disabled");
 * specific language governing permissions and limitations
                    }
 * software distributed under the License is distributed on an
                if (sourceFieldMapper.enabled() == false) {
                MappedFieldType fieldType = context.mapperService().fieldType(fieldName);
                hitContext.hit().highlightFields(highlightFields);
import org.opensearch.index.mapper.SourceFieldMapper;
            Collection<String> fieldNamesToHighlight;
            sharedCache
 * under the License.
                // If the field was explicitly given we assume that whoever issued the query knew
                        forceSource,
                if (fieldType == null) {
 */
import org.apache.lucene.index.LeafReaderContext;
        return new FetchSubPhaseProcessor() {
    public HighlightPhase(Map<String, Highlighter> highlighters) {
                        sharedCache
            if (highlightContext.forceSource(field)) {
import org.opensearch.common.regex.Regex;
            return null;
        for (SearchHighlightContext.Field field : highlightContext.fields()) {
                    HighlightField highlightField = highlighter.highlight(fieldContext);
            highlightContext,
    private Map<String, Function<HitContext, FieldHighlightContext>> contextBuilders(
            boolean fieldNameContainsWildcards = field.field().contains("*");
        if (highlighter == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                // what they were doing and try to highlight anyway.
        Query query,
 * GitHub history for details.
            }
                MappedFieldType finalFieldType = fieldType;
                builders.put(
import org.opensearch.index.mapper.TextFieldMapper;
 * license agreements. See the NOTICE file distributed with
    }
        Map<String, Object> sharedCache = new HashMap<>();
        }
                // highlight such a field and so we do the following:
                        highlightQuery == null ? query : highlightQuery,
            @Override
 */
    public FetchSubPhaseProcessor getProcessor(FetchContext context) {
 * the Apache License, Version 2.0 (the "License"); you may
    }
 * You may obtain a copy of the License at
                boolean forceSource = highlightContext.forceSource(field);
                Map<String, HighlightField> highlightFields = new HashMap<>();
/*
                }
        };
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.search.fetch.FetchContext;
                    FieldHighlightContext fieldContext = contextBuilders.get(field).apply(hitContext);
import java.util.Collections;
            } else {
            query,
 */
import java.util.function.Function;
        FetchContext context,
        }
                        finalFieldType,
import java.util.HashMap;
                // We should prevent highlighting if a field is anything but a text, match_only_text
        return builders;
import org.opensearch.search.fetch.FetchSubPhaseProcessor;
                }
            Highlighter highlighter = getHighlighter(field);
                        && fieldType.typeName().equals(MatchOnlyTextFieldMapper.CONTENT_TYPE) == false) {
                        highlightFields.put(field, new HighlightField(field, highlightField.fragments()));
        return getProcessor(context, context.highlight(), context.parsedQuery().query());
import java.util.Collection;
        Map<String, Function<HitContext, FieldHighlightContext>> builders = new LinkedHashMap<>();
            public void setNextReader(LeafReaderContext readerContext) {
 * Unless required by applicable law or agreed to in writing,
            highlighterType = "unified";
            if (Regex.isSimpleMatchPattern(field.field())) {
 * The OpenSearch Contributors require contributions made to
import java.util.LinkedHashMap;
        if (highlighterType == null) {
 * Highlight Phase of the search request.
/*
 * this file be licensed under the Apache-2.0 license or a
import org.opensearch.search.fetch.FetchSubPhase;
                        // concrete field it points to.
    private final Map<String, Highlighter> highlighters;
                    continue;
            }
 */
import java.io.IOException;
            @Override
        );
 * Licensed to Elasticsearch under one or more contributor
            context,
                SourceFieldMapper sourceFieldMapper = context.mapperService().documentMapper().sourceMapper();
import org.opensearch.index.mapper.MatchOnlyTextFieldMapper;
        }
    public FetchSubPhaseProcessor getProcessor(FetchContext context, SearchHighlightContext highlightContext, Query query) {
    private Highlighter getHighlighter(SearchHighlightContext.Field field) {
    }
                    )
        String highlighterType = field.fieldOptions().highlighterType();
import java.util.Map;
                        // Note that we make sure to use the original field name in the response. This is because the
 *
                    fieldName,
        if (context.highlight() == null) {
                    if (highlightField != null) {
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
                    if (highlighter.canHighlight(fieldType) == false) {
 * @opensearch.internal
/*
                    hc -> new FieldHighlightContext(
    }
                // highlight on that. We cannot know in advance if the highlighter will be able to
 * not use this file except in compliance with the License.
        }
import org.opensearch.index.mapper.KeywordFieldMapper;
                    }
        SearchHighlightContext highlightContext,
    @Override
                        finalFieldType.name(),
        this.highlighters = highlighters;
                }
                    }
            }
                        continue;
                        context,
                if (fieldNameContainsWildcards) {
 * compatible open source license.
                // If the field is only highlighted because the field matches a wildcard we assume
                Query highlightQuery = field.fieldOptions().highlightQuery();
                // it was a mistake and do not process it.
        return highlighter;
 *
            public void process(HitContext hitContext) throws IOException {
 *
public class HighlightPhase implements FetchSubPhase {
                // or keyword field.
                }
 * KIND, either express or implied.  See the License for the
