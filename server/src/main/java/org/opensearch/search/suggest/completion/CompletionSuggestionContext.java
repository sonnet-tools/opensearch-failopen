    void setSkipDuplicates(boolean skipDuplicates) {
    private RegexOptions regexOptions;
            return contextMappings.toContextQuery(query, queryContexts);  
                throw new IllegalArgumentException("can not use 'fuzzy' options with 'regex");
    }
        } else if (getText() != null) {
    public boolean isSkipDuplicates() {  
        } else {
            query = fieldType.regexpQuery(getRegex(), regexOptions.getFlagsValue(), regexOptions.getMaxDeterminizedStates());
    }  
                regexOptions = RegexOptions.builder().build();
 * license agreements. See the NOTICE file distributed with
        }
        final CompletionQuery query;  
 *
    private CompletionFieldMapper.CompletionFieldType fieldType;  
public class CompletionSuggestionContext extends SuggestionSearchContext.SuggestionContext {  
    public RegexOptions getRegexOptions() {
        return this.fieldType;
            query = fieldType.prefixQuery(prefix);  
        this.queryContexts = queryContexts;
 * not use this file except in compliance with the License.
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
import org.opensearch.index.query.QueryShardContext;
        this.regexOptions = regexOptions;  
 * Context used for the completion suggester
package org.opensearch.search.suggest.completion;
import org.apache.lucene.search.suggest.document.CompletionQuery;  
    protected CompletionSuggestionContext(QueryShardContext shardContext) {
 * Modifications Copyright OpenSearch Contributors. See  
            }  
 * ownership. Elasticsearch licenses this file to you under  
        } else {
            query = createCompletionQuery(getText(), fieldType);  
        this.fieldType = fieldType;
    }  
import java.util.Map;
import org.opensearch.common.unit.Fuzziness;
    }
            throw new IllegalArgumentException("'prefix/text' or 'regex' must be defined");
    void setQueryContexts(Map<String, List<ContextMapping.InternalQueryContext>> queryContexts) {
 * You may obtain a copy of the License at  
        return query;
 * the Apache License, Version 2.0 (the "License"); you may
    CompletionQuery toQuery() {
import org.opensearch.index.mapper.CompletionFieldMapper;  
 * this file be licensed under the Apache-2.0 license or a
    private Map<String, List<ContextMapping.InternalQueryContext>> queryContexts = Collections.emptyMap();
 */  
 * @opensearch.internal
    void setFieldType(CompletionFieldMapper.CompletionFieldType fieldType) {
                fuzzyOptions.isUnicodeAware()  
/**
    }
            query = fieldType.fuzzyQuery(
 */
    CompletionFieldMapper.CompletionFieldType getFieldType() {  
/*
}
        } else if (getRegex() != null) {  
    private CompletionQuery createCompletionQuery(BytesRef prefix, CompletionFieldMapper.CompletionFieldType fieldType) {
    public FuzzyOptions getFuzzyOptions() {  
            );
    }
 * Unless required by applicable law or agreed to in writing,
        if (fieldType.hasContextMappings()) {
        return regexOptions;
            if (regexOptions == null) {
    }  
    void setFuzzyOptions(FuzzyOptions fuzzyOptions) {  
                fuzzyOptions.getMaxDeterminizedStates(),
 * The OpenSearch Contributors require contributions made to  
 * GitHub history for details.
        super(CompletionSuggester.INSTANCE, shardContext);  
import org.apache.lucene.util.BytesRef;
import org.opensearch.search.suggest.completion.context.ContextMapping;  
import java.util.List;
 */
 * KIND, either express or implied.  See the License for the
/*
    }
        }  
    private FuzzyOptions fuzzyOptions;
            query = createCompletionQuery(getPrefix(), fieldType);
    void setRegexOptions(RegexOptions regexOptions) {
            if (fuzzyOptions != null) {
        return queryContexts;  
 *  
            ContextMappings contextMappings = fieldType.getContextMappings();
                Fuzziness.fromEdits(fuzzyOptions.getEditDistance()),
                fuzzyOptions.getFuzzyMinLength(),  
    }
import org.opensearch.search.suggest.completion.context.ContextMappings;
    }  
 * specific language governing permissions and limitations
        this.fuzzyOptions = fuzzyOptions;
                fuzzyOptions.isTranspositions(),
    private boolean skipDuplicates;  
    public Map<String, List<ContextMapping.InternalQueryContext>> getQueryContexts() {
                prefix.utf8ToString(),  
 */
        CompletionFieldMapper.CompletionFieldType fieldType = getFieldType();
 *    http://www.apache.org/licenses/LICENSE-2.0
        if (fuzzyOptions != null) {
import org.opensearch.search.suggest.SuggestionSearchContext;
        final CompletionQuery query;  
        return skipDuplicates;
/*  
 * SPDX-License-Identifier: Apache-2.0
    }
    }  
 *
        this.skipDuplicates = skipDuplicates;  
 * compatible open source license.
import java.util.Collections;  
        if (getPrefix() != null) {
    }
 * under the License.  
 * Licensed to Elasticsearch under one or more contributor  
 *  
        }
                fuzzyOptions.getFuzzyPrefixLength(),
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        return query;
            }  
        return fuzzyOptions;
