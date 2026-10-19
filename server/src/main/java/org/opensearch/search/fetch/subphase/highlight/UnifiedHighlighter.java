        fieldValues = fieldValues.stream().map((s) -> convertFieldValue(fieldType, s)).collect(Collectors.toList());
        String[] fragments = new String[snippets.size()];  
        if (numberOfFragments == 0
import org.apache.lucene.search.uhighlight.CustomSeparatorBreakIterator;
            case SENTENCE:
import java.util.HashMap;  
 * this work for additional information regarding copyright
            }
        };
        org.apache.lucene.search.uhighlight.UnifiedHighlighter.Builder builder = org.apache.lucene.search.uhighlight.UnifiedHighlighter
        if (snippets.isEmpty()) {  
 * under the License.  
        QueryShardContext context,
    public AnalyzerWrapper getLimitedOffsetAnalyzer(Analyzer analyzer, int limit) {
    }  
import java.util.Locale;
    protected static String convertFieldValue(MappedFieldType type, Object value) {  
        );
        if (fieldSnippets == null || fieldSnippets.length == 0) {  
 * ownership. Elasticsearch licenses this file to you under  
            return null;
                throw new IllegalArgumentException("Invalid boundary scanner type: " + type.toString());
            ? HighlightUtils.Encoders.HTML
                fieldContext.forceSource  
            // let's sort the snippets by score if needed
            : HighlightBuilder.BoundaryScannerType.SENTENCE;
        } else {  
        if (matchedFields != null && !matchedFields.isEmpty()) {
        }
        return rawValue.substring(0, Math.min(rawValue.length(), Integer.MAX_VALUE - 1));  
 * SPDX-License-Identifier: Apache-2.0
        IndexSearcher searcher = fieldContext.context.searcher();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return mergeFieldValues(fieldValues, MULTIVAL_SEP_CHAR);
import org.opensearch.index.mapper.TextSearchInfo;
        int maxLen = fieldOptions.fragmentCharSize();  
        Encoder encoder = fieldContext.field.fieldOptions().encoder().equals("html")
import org.opensearch.lucene.search.uhighlight.Snippet;
            fieldContext.context.getIndexName(),  
import org.opensearch.index.mapper.DocumentMapper;
            : HighlightUtils.Encoders.DEFAULT;  
            @Override  
            passageFormatter,  
            ? fieldOptions.boundaryScannerType()
        FetchSubPhase.HitContext hitContext,
        Integer fieldMaxAnalyzedOffset = fieldContext.field.fieldOptions().maxAnalyzerOffset();
        return builder;  
            UnifiedHighlighter.class.getName(),
}
import java.util.Map;  
            // non-tokenized fields should not use any break iterator (ignore boundaryScannerType)  
            .builder(searcher, analyzer);
        }
        Analyzer analyzer,
        // ignore terms that targets the _id field since they use a different encoding  
        }
        for (Snippet fieldSnippet : fieldSnippets) {
        final SearchHighlightContext.FieldOptions fieldOptions = field.fieldOptions();
 * Uses lucene's unified highlighter implementation
        Set<String> matchedFields = fieldContext.field.fieldOptions().matchedFields();  
        OffsetSource offsetSource = getOffsetSource(fieldContext.fieldType);
    @Override  
        Snippet[] fieldSnippets = highlighter.highlightField(hitContext.reader(), hitContext.docId(), loadFieldValues);
import org.opensearch.index.mapper.MappedFieldType;
             * only char that the custom break iterator breaks the text
            }
                return new TokenStreamComponents(components.getSource(), new LimitTokenOffsetFilter(components.getTokenStream(), limit));
import org.opensearch.lucene.search.uhighlight.BoundedBreakIteratorScanner;
 * not use this file except in compliance with the License.
    }
import org.opensearch.index.mapper.IdFieldMapper;  
    protected BreakIterator getBreakIterator(SearchHighlightContext.Field field) {  
        }
        return docMapper.mappers().indexAnalyzer();  
 */  
            );
/*
            breakIterator = new CustomSeparatorBreakIterator(MULTIVAL_SEP_CHAR);
import org.apache.lucene.analysis.AnalyzerWrapper;
    }
    protected Analyzer getAnalyzer(DocumentMapper docMapper) {
import org.opensearch.core.common.text.Text;  
import org.opensearch.index.query.QueryShardContext;  
    }  
    }
    }
            return value.toString();
        SearchHighlightContext.Field field = fieldContext.field;  
 * You may obtain a copy of the License at  
        TextSearchInfo tsi = fieldType.getTextSearchInfo();
 * specific language governing permissions and limitations
            higlighterNumberOfFragments = numberOfFragments;
import static org.opensearch.lucene.search.uhighlight.CustomUnifiedHighlighter.MULTIVAL_SEP_CHAR;
            higlighterNumberOfFragments = numberOfFragments == 0 ? Integer.MAX_VALUE - 1 : numberOfFragments;  
        Map<String, CustomUnifiedHighlighter> cache = (Map<String, CustomUnifiedHighlighter>) fieldContext.cache.computeIfAbsent(  
        if (fieldMaxAnalyzedOffset != null) {  
        int maxAnalyzedOffset = fieldContext.context.getIndexSettings().getHighlightMaxAnalyzedOffset();
        }
            fieldContext.field.fieldOptions().noMatchSize(),  
import java.util.List;
                hitContext,
 * Licensed to Elasticsearch under one or more contributor  
import org.apache.lucene.search.highlight.Encoder;
    public boolean canHighlight(MappedFieldType fieldType) {
        FetchSubPhase.HitContext hitContext = fieldContext.hitContext;
        @SuppressWarnings("unchecked")
            newBuilder(searcher, analyzer, fieldContext),
            fieldContext.fieldName,
import org.opensearch.search.fetch.FetchSubPhase;
            if (fieldValues.size() == 0) {
            fieldContext.field.fieldOptions().boundaryScannerLocale(),
import org.opensearch.lucene.search.uhighlight.CustomPassageFormatter;
    CustomUnifiedHighlighter buildHighlighter(FieldHighlightContext fieldContext) throws IOException {  
        if (field.fieldOptions().scoreOrdered()) {
                fieldContext.context.getQueryShardContext(),  
        String rawValue = Strings.collectionToDelimitedString(fieldValues, String.valueOf(valuesSeparator));
        return name -> IdFieldMapper.NAME.equals(name) == false;
import java.util.Collections;
    protected static String mergeFieldValues(List<Object> fieldValues, char valuesSeparator) {
            Map<String, Set<String>> maskedFields = Collections.singletonMap(fieldContext.fieldName, matchedFields);
            Set<String> matchedFields = fieldContext.field.fieldOptions().matchedFields();  
import org.opensearch.common.CheckedSupplier;
        final HighlightBuilder.BoundaryScannerType type = fieldOptions.boundaryScannerType() != null  
 *  
                return null;  
    }  
 * Modifications Copyright OpenSearch Contributors. See  
/**
 */
            case WORD:
            fieldMaxAnalyzedOffset  
import org.opensearch.lucene.search.uhighlight.CustomUnifiedHighlighter;  
 * software distributed under the License is distributed on an
        return true;  
        boolean forceSource
import java.util.stream.Collectors;  
import java.util.Set;
            cache.put(fieldContext.fieldName, buildHighlighter(fieldContext));
                return BreakIterator.getWordInstance(locale);  
            protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
        // postings highlighter accepts all values in a single string, as offsets etc. need to match with content  
import org.apache.lucene.analysis.miscellaneous.LimitTokenOffsetFilter;
import org.opensearch.core.common.Strings;
            offsetSource,
            builder.withMaskedFieldsFunc(f -> maskedFields.getOrDefault(f, Collections.emptySet()));  
            fieldContext.query,
        if (tsi.termVectors() == TextSearchInfo.TermVector.OFFSETS) {
        };  
        if (cache.containsKey(fieldContext.fieldName) == false) {
            CollectionUtil.introSort(snippets, (o1, o2) -> Double.compare(o2.getScore(), o1.getScore()));  
        builder.withFieldMatcher(fieldMatcher(fieldContext));
    private org.apache.lucene.search.uhighlight.UnifiedHighlighter.Builder newBuilder(
        List<Snippet> snippets = new ArrayList<>(fieldSnippets.length);  
/*  
                if (maxLen > 0) {  
        }
                return analyzer;  
    }
import org.apache.lucene.analysis.Analyzer;  
 * license agreements. See the NOTICE file distributed with
        IndexSearcher searcher,  
        if (tsi.hasOffsets()) {
 * GitHub history for details.
        }  
            return OffsetSource.TERM_VECTORS;  
 * this file be licensed under the Apache-2.0 license or a
 */
                    return BoundedBreakIteratorScanner.getSentence(locale, maxLen);
import java.io.IOException;
        switch (type) {
public class UnifiedHighlighter implements Highlighter {  
 */
        MappedFieldType fieldType = fieldContext.fieldType;
                snippets.add(fieldSnippet);  
    }
    public HighlightField highlight(FieldHighlightContext fieldContext) throws IOException {
        }
            @Override
            fragments[i] = snippets.get(i).getText();
            return tsi.termVectors() != TextSearchInfo.TermVector.NONE ? OffsetSource.POSTINGS_WITH_TERM_VECTORS : OffsetSource.POSTINGS;  
import org.apache.lucene.util.CollectionUtil;  
        FieldHighlightContext fieldContext
            // using paragraph separator we make sure that each field value holds a discrete passage for highlighting
        }
        }  
package org.opensearch.search.fetch.subphase.highlight;
import org.opensearch.index.mapper.DerivedFieldType;
            breakIterator = getBreakIterator(fieldContext.field);  
        int numberOfFragments = fieldContext.field.fieldOptions().numberOfFragments();  
        MappedFieldType derivedFieldType = fieldContext.context.getQueryShardContext().resolveDerivedFieldType(fieldContext.fieldName);
                fieldType,
            List<Object> fieldValues = loadFieldValues(
    ) {  
    private Predicate<String> fieldMatcher(FieldHighlightContext fieldContext) {  
        // loaded from stored fields, we merge all values using a proper separator
 *
        for (int i = 0; i < fragments.length; i++) {
            protected Analyzer getWrappedAnalyzer(String fieldName) {
        return OffsetSource.ANALYSIS;
        if (value instanceof BytesRef) {
import org.apache.lucene.search.uhighlight.PassageFormatter;  
 *
        if (derivedFieldType != null) {  
        final Locale locale = fieldOptions.boundaryScannerLocale() != null ? fieldOptions.boundaryScannerLocale() : Locale.ROOT;
        }  
                highlighter,
import java.text.BreakIterator;  
            || fieldContext.fieldType.getTextSearchInfo().isTokenized() == false) {
            analyzer = getLimitedOffsetAnalyzer(analyzer, fieldMaxAnalyzedOffset);
        CustomUnifiedHighlighter highlighter,
                return BreakIterator.getSentenceInstance(locale);  
        }
             */
            }
            if (Strings.hasText(fieldSnippet.getText())) {
             * values of a field and we get back a snippet per value  
        PassageFormatter passageFormatter = getPassageFormatter(fieldContext.hitContext, fieldContext.field, encoder);  
import org.apache.lucene.search.uhighlight.UnifiedHighlighter.OffsetSource;
        } else {
        return new CustomUnifiedHighlighter(  
 * Unless required by applicable law or agreed to in writing,
            String fieldName = fieldContext.fieldName;
 * compatible open source license.
                // ignore maxLen
        int higlighterNumberOfFragments;
    protected List<Object> loadFieldValues(  
            /*
        return new AnalyzerWrapper(analyzer.getReuseStrategy()) {  
    }
        return fieldValues;  
import org.apache.lucene.util.BytesRef;
    protected PassageFormatter getPassageFormatter(HitContext hitContext, SearchHighlightContext.Field field, Encoder encoder) {
        // that is not compatible with utf8
        BreakIterator breakIterator;  
        List<Object> fieldValues = HighlightUtils.loadFieldValues(fieldType, context, hitContext, forceSource);
            }  
        MappedFieldType fieldType,  
    ) throws IOException {  
        );  
import org.opensearch.search.fetch.FetchSubPhase.HitContext;  
        if (fieldContext.field.fieldOptions().requireFieldMatch()) {
import java.util.function.Predicate;
        return new CustomPassageFormatter(field.fieldOptions().preTags()[0], field.fieldOptions().postTags()[0], encoder);
            higlighterNumberOfFragments,
    }
    @Override
 * The OpenSearch Contributors require contributions made to  
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.ArrayList;
    }  
             * We use a control char to separate values, which is the  
        CustomUnifiedHighlighter highlighter = cache.get(fieldContext.fieldName);
 * @opensearch.internal
            k -> new HashMap<>()
    }  
            maxAnalyzedOffset,
             * on, so we don't lose the distinction between the different
                }
        CheckedSupplier<String, IOException> loadFieldValues = () -> {  
        }
            return f -> fieldName.equals(f) || (matchedFields != null && matchedFields.contains(f));
        }
/*
            return type.valueForDisplay(value).toString();
            breakIterator,
        return new HighlightField(fieldContext.fieldName, Text.convertFromStringArray(fragments));
import org.apache.lucene.search.IndexSearcher;  
 *  
        }
 * KIND, either express or implied.  See the License for the
        Analyzer analyzer = getAnalyzer(fieldContext.context.mapperService().documentMapper());
            default:
            return null;
 *    http://www.apache.org/licenses/LICENSE-2.0
            analyzer = ((DerivedFieldType) derivedFieldType).getIndexAnalyzer();
    protected OffsetSource getOffsetSource(MappedFieldType fieldType) {  
