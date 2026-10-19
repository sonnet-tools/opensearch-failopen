/**
        };
 *
            return type.valueForDisplay(value).toString();
import org.opensearch.lucene.search.uhighlight.CustomPassageFormatter;
        );
             * We use a control char to separate values, which is the
    }
        }
import org.opensearch.lucene.search.uhighlight.BoundedBreakIteratorScanner;
        }
    protected List<Object> loadFieldValues(
            ? fieldOptions.boundaryScannerType()
            protected Analyzer getWrappedAnalyzer(String fieldName) {
        Set<String> matchedFields = fieldContext.field.fieldOptions().matchedFields();
    protected OffsetSource getOffsetSource(MappedFieldType fieldType) {
        org.apache.lucene.search.uhighlight.UnifiedHighlighter.Builder builder = org.apache.lucene.search.uhighlight.UnifiedHighlighter
        List<Object> fieldValues = HighlightUtils.loadFieldValues(fieldType, context, hitContext, forceSource);
import java.util.function.Predicate;
        }
        PassageFormatter passageFormatter = getPassageFormatter(fieldContext.hitContext, fieldContext.field, encoder);
        OffsetSource offsetSource = getOffsetSource(fieldContext.fieldType);
            return mergeFieldValues(fieldValues, MULTIVAL_SEP_CHAR);
        return new CustomPassageFormatter(field.fieldOptions().preTags()[0], field.fieldOptions().postTags()[0], encoder);
            .builder(searcher, analyzer);
        if (snippets.isEmpty()) {
/*
            analyzer = ((DerivedFieldType) derivedFieldType).getIndexAnalyzer();
            higlighterNumberOfFragments,
            fieldContext.query,
            @Override
        final Locale locale = fieldOptions.boundaryScannerLocale() != null ? fieldOptions.boundaryScannerLocale() : Locale.ROOT;
            passageFormatter,
import java.util.stream.Collectors;
 * You may obtain a copy of the License at
 * the Apache License, Version 2.0 (the "License"); you may
            maxAnalyzedOffset,
 */
        FetchSubPhase.HitContext hitContext = fieldContext.hitContext;
            newBuilder(searcher, analyzer, fieldContext),
        IndexSearcher searcher,
 * software distributed under the License is distributed on an
        if (tsi.hasOffsets()) {
                // ignore maxLen
import java.util.Locale;
            breakIterator = getBreakIterator(fieldContext.field);
        if (fieldContext.field.fieldOptions().requireFieldMatch()) {
    private Predicate<String> fieldMatcher(FieldHighlightContext fieldContext) {
        if (derivedFieldType != null) {
 * this work for additional information regarding copyright
        FieldHighlightContext fieldContext
        }
 */
            }
            );
            default:
        @SuppressWarnings("unchecked")
 * under the License.
    }
        if (cache.containsKey(fieldContext.fieldName) == false) {
        SearchHighlightContext.Field field = fieldContext.field;
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
            }
            return null;
        }
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        BreakIterator breakIterator;
        }
        // that is not compatible with utf8
 * The OpenSearch Contributors require contributions made to
        } else {
        CustomUnifiedHighlighter highlighter,
    }
                throw new IllegalArgumentException("Invalid boundary scanner type: " + type.toString());
        IndexSearcher searcher = fieldContext.context.searcher();
        TextSearchInfo tsi = fieldType.getTextSearchInfo();
        switch (type) {
 * GitHub history for details.
    }
 * ownership. Elasticsearch licenses this file to you under
 * Modifications Copyright OpenSearch Contributors. See
                if (maxLen > 0) {
import org.opensearch.index.mapper.DerivedFieldType;
        }
        // loaded from stored fields, we merge all values using a proper separator
import org.opensearch.index.mapper.IdFieldMapper;
        int maxAnalyzedOffset = fieldContext.context.getIndexSettings().getHighlightMaxAnalyzedOffset();
                }
            : HighlightBuilder.BoundaryScannerType.SENTENCE;
import java.util.Collections;
            fragments[i] = snippets.get(i).getText();
    }
        return rawValue.substring(0, Math.min(rawValue.length(), Integer.MAX_VALUE - 1));
            ? HighlightUtils.Encoders.HTML
    ) {
                snippets.add(fieldSnippet);
        } else {
    public HighlightField highlight(FieldHighlightContext fieldContext) throws IOException {
            return tsi.termVectors() != TextSearchInfo.TermVector.NONE ? OffsetSource.POSTINGS_WITH_TERM_VECTORS : OffsetSource.POSTINGS;
                return BreakIterator.getWordInstance(locale);
            /*
        Analyzer analyzer = getAnalyzer(fieldContext.context.mapperService().documentMapper());
    }
        }
            || fieldContext.fieldType.getTextSearchInfo().isTokenized() == false) {
import org.apache.lucene.search.uhighlight.UnifiedHighlighter.OffsetSource;
        if (value instanceof BytesRef) {
        return OffsetSource.ANALYSIS;
        if (numberOfFragments == 0
            CollectionUtil.introSort(snippets, (o1, o2) -> Double.compare(o2.getScore(), o1.getScore()));
        Integer fieldMaxAnalyzedOffset = fieldContext.field.fieldOptions().maxAnalyzerOffset();
                hitContext,
import org.apache.lucene.search.IndexSearcher;
                fieldContext.context.getQueryShardContext(),
            case SENTENCE:
            fieldContext.context.getIndexName(),
                return analyzer;
            // using paragraph separator we make sure that each field value holds a discrete passage for highlighting
public class UnifiedHighlighter implements Highlighter {
            Set<String> matchedFields = fieldContext.field.fieldOptions().matchedFields();
        }
        return new AnalyzerWrapper(analyzer.getReuseStrategy()) {
    }
            cache.put(fieldContext.fieldName, buildHighlighter(fieldContext));
        };
import java.util.List;
        for (Snippet fieldSnippet : fieldSnippets) {
            fieldContext.fieldName,
        Snippet[] fieldSnippets = highlighter.highlightField(hitContext.reader(), hitContext.docId(), loadFieldValues);
    protected PassageFormatter getPassageFormatter(HitContext hitContext, SearchHighlightContext.Field field, Encoder encoder) {
        return builder;
    }
 */
            return f -> fieldName.equals(f) || (matchedFields != null && matchedFields.contains(f));
    }
                    return BoundedBreakIteratorScanner.getSentence(locale, maxLen);
        final HighlightBuilder.BoundaryScannerType type = fieldOptions.boundaryScannerType() != null
        fieldValues = fieldValues.stream().map((s) -> convertFieldValue(fieldType, s)).collect(Collectors.toList());
import org.opensearch.index.query.QueryShardContext;
        int maxLen = fieldOptions.fragmentCharSize();
        return docMapper.mappers().indexAnalyzer();
 * specific language governing permissions and limitations
        );
        QueryShardContext context,
        Map<String, CustomUnifiedHighlighter> cache = (Map<String, CustomUnifiedHighlighter>) fieldContext.cache.computeIfAbsent(
            breakIterator,
            fieldContext.field.fieldOptions().boundaryScannerLocale(),
 * Uses lucene's unified highlighter implementation
}
        // postings highlighter accepts all values in a single string, as offsets etc. need to match with content
            Map<String, Set<String>> maskedFields = Collections.singletonMap(fieldContext.fieldName, matchedFields);
import org.opensearch.core.common.Strings;
        MappedFieldType fieldType = fieldContext.fieldType;
    protected static String convertFieldValue(MappedFieldType type, Object value) {
import org.opensearch.core.common.text.Text;
            return OffsetSource.TERM_VECTORS;
            String fieldName = fieldContext.fieldName;
            k -> new HashMap<>()
        }
    @Override
        MappedFieldType fieldType,
        boolean forceSource
            }
        if (matchedFields != null && !matchedFields.isEmpty()) {
        String[] fragments = new String[snippets.size()];
    public AnalyzerWrapper getLimitedOffsetAnalyzer(Analyzer analyzer, int limit) {
                return BreakIterator.getSentenceInstance(locale);
        for (int i = 0; i < fragments.length; i++) {
        if (field.fieldOptions().scoreOrdered()) {
import org.opensearch.search.fetch.FetchSubPhase.HitContext;
    CustomUnifiedHighlighter buildHighlighter(FieldHighlightContext fieldContext) throws IOException {
    }
        builder.withFieldMatcher(fieldMatcher(fieldContext));
             */
        if (tsi.termVectors() == TextSearchInfo.TermVector.OFFSETS) {
import java.util.Map;
            }
        if (fieldSnippets == null || fieldSnippets.length == 0) {
        return true;
    }
        return fieldValues;
import org.apache.lucene.search.uhighlight.PassageFormatter;
 */
        String rawValue = Strings.collectionToDelimitedString(fieldValues, String.valueOf(valuesSeparator));
        return name -> IdFieldMapper.NAME.equals(name) == false;
            offsetSource,
        return new CustomUnifiedHighlighter(
 * Licensed to Elasticsearch under one or more contributor
 * @opensearch.internal
import org.apache.lucene.analysis.miscellaneous.LimitTokenOffsetFilter;
            if (Strings.hasText(fieldSnippet.getText())) {
    private org.apache.lucene.search.uhighlight.UnifiedHighlighter.Builder newBuilder(
 *    http://www.apache.org/licenses/LICENSE-2.0
                return null;
 * KIND, either express or implied.  See the License for the
        CheckedSupplier<String, IOException> loadFieldValues = () -> {
            return value.toString();
    }
import org.opensearch.index.mapper.DocumentMapper;
        MappedFieldType derivedFieldType = fieldContext.context.getQueryShardContext().resolveDerivedFieldType(fieldContext.fieldName);
            case WORD:
import java.io.IOException;
        List<Snippet> snippets = new ArrayList<>(fieldSnippets.length);
            UnifiedHighlighter.class.getName(),
            higlighterNumberOfFragments = numberOfFragments;
import org.apache.lucene.util.BytesRef;
            if (fieldValues.size() == 0) {
            breakIterator = new CustomSeparatorBreakIterator(MULTIVAL_SEP_CHAR);
import org.apache.lucene.analysis.AnalyzerWrapper;
        }
            @Override
             * values of a field and we get back a snippet per value
import org.apache.lucene.search.highlight.Encoder;
             * only char that the custom break iterator breaks the text
        final SearchHighlightContext.FieldOptions fieldOptions = field.fieldOptions();
import org.apache.lucene.util.CollectionUtil;
        Encoder encoder = fieldContext.field.fieldOptions().encoder().equals("html")
        CustomUnifiedHighlighter highlighter = cache.get(fieldContext.fieldName);
            // non-tokenized fields should not use any break iterator (ignore boundaryScannerType)
            List<Object> fieldValues = loadFieldValues(
import org.opensearch.common.CheckedSupplier;
        }
             * on, so we don't lose the distinction between the different
            fieldMaxAnalyzedOffset
            protected TokenStreamComponents wrapComponents(String fieldName, TokenStreamComponents components) {
            higlighterNumberOfFragments = numberOfFragments == 0 ? Integer.MAX_VALUE - 1 : numberOfFragments;
    protected Analyzer getAnalyzer(DocumentMapper docMapper) {
            builder.withMaskedFieldsFunc(f -> maskedFields.getOrDefault(f, Collections.emptySet()));
        if (fieldMaxAnalyzedOffset != null) {
        // ignore terms that targets the _id field since they use a different encoding
    }
            fieldContext.field.fieldOptions().noMatchSize(),
            // let's sort the snippets by score if needed
import java.text.BreakIterator;
 * compatible open source license.
        }
import org.opensearch.index.mapper.TextSearchInfo;
/*
import java.util.HashMap;
    protected static String mergeFieldValues(List<Object> fieldValues, char valuesSeparator) {
                fieldContext.forceSource
            : HighlightUtils.Encoders.DEFAULT;
import org.apache.lucene.analysis.Analyzer;
    ) throws IOException {
 *
 *
    @Override
                return new TokenStreamComponents(components.getSource(), new LimitTokenOffsetFilter(components.getTokenStream(), limit));
    protected BreakIterator getBreakIterator(SearchHighlightContext.Field field) {
                fieldType,
        }
 * Unless required by applicable law or agreed to in writing,
        Analyzer analyzer,
import org.opensearch.index.mapper.MappedFieldType;
                highlighter,
        int higlighterNumberOfFragments;
        int numberOfFragments = fieldContext.field.fieldOptions().numberOfFragments();
import org.opensearch.lucene.search.uhighlight.Snippet;
        return new HighlightField(fieldContext.fieldName, Text.convertFromStringArray(fragments));
 *
import java.util.Set;
        }
    public boolean canHighlight(MappedFieldType fieldType) {
import org.opensearch.search.fetch.FetchSubPhase;
import org.opensearch.lucene.search.uhighlight.CustomUnifiedHighlighter;
/*
            analyzer = getLimitedOffsetAnalyzer(analyzer, fieldMaxAnalyzedOffset);
        FetchSubPhase.HitContext hitContext,
import static org.opensearch.lucene.search.uhighlight.CustomUnifiedHighlighter.MULTIVAL_SEP_CHAR;
import java.util.ArrayList;
package org.opensearch.search.fetch.subphase.highlight;
            return null;
import org.apache.lucene.search.uhighlight.CustomSeparatorBreakIterator;
 * this file be licensed under the Apache-2.0 license or a
