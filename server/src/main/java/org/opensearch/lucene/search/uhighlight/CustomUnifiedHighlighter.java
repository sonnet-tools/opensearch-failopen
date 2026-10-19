     * @param noMatchSize The size of the text that should be returned when no highlighting can be performed.
                }
 * software distributed under the License is distributed on an
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;  
import java.util.Collection;
 *  
        return breakIterator;
        return result == null ? EMPTY_SNIPPET : result;  
 * Modifications Copyright OpenSearch Contributors. See
        PassageFormatter passageFormatter,
            int[] positions = mpq.getPositions();
    private final CustomFieldHighlighter fieldHighlighter;
        this.breakIteratorLocale = breakIteratorLocale == null ? Locale.ROOT : breakIteratorLocale;
                    + "For large texts, indexing with offsets or term vectors is recommended!"
     * @param passageFormatter our own {@link CustomPassageFormatter}
    @Override  
            int positionGaps = 0;
 */
 * Uses a custom {@link PassageFormatter}. Accepts field content as a constructor  
            passageSortComparator
 *
 * Supports both returning empty snippets and non highlighted snippets when no highlighting can be performed.
                }  
            maxPassages,
    public PassageFormatter getFormatter() {
        int maxAnalyzedOffset,
import java.util.Locale;
        } else if (query instanceof OpenSearchToParentBlockJoinQuery parentQuery) {  
                } else {
     *
     * @param maxAnalyzedOffset if the field is more than this long we'll refuse to use the ANALYZED
        OffsetSource offsetSource,
     *                    If null {@link BreakIterator#getSentenceInstance(Locale)} is used.
    private Collection<Query> rewriteCustomQuery(Query query) {
    }  
 * Licensed to Elasticsearch under one or more contributor  
     * @param index the index we're highlighting, mostly used for error messages
            }
    private final String field;
     * Creates a new instance of {@link CustomUnifiedHighlighter}
     */
    }
        @Nullable BreakIterator breakIterator,
    protected BreakIterator getBreakIterator(String field) {
                // positions are in increasing order. max(0,...) is just a safeguard.  
            return Collections.singletonList(new SpanNearQuery(positionSpanQueries, mpq.getSlop() + positionGaps, inorder));
            getScorer(field),  
        } else {
 * KIND, either express or implied.  See the License for the
    @Override  
import org.apache.lucene.search.Query;  
     * Highlights the field value.  
import org.apache.lucene.search.PrefixQuery;
                SpanQuery[] innerQueries = new SpanQuery[terms[i].length];  
package org.opensearch.lucene.search.uhighlight;
            }
            return EMPTY_SNIPPET;
     *                          offset source for it because it'd be super slow
 * under the License.  
    private final int maxAnalyzedOffset;  
        if (fieldValue == null) {
    public static final char MULTIVAL_SEP_CHAR = (char) 0;
     * @param field the name of the field we're highlighting  
 * specific language governing permissions and limitations
        }
        FieldOffsetStrategy fieldOffsetStrategy,
                    + "] doc of ["
import org.apache.lucene.queries.spans.SpanNearQuery;
            Term[][] terms = mpq.getTerms();
     */
 * You may obtain a copy of the License at  
            breakIterator,
    protected OffsetSource getOffsetSource(String field) {
        BreakIterator breakIterator,  
     *                    If null {@link Locale#ROOT} is used.
        this.fieldMaxAnalyzedOffset = fieldMaxAnalyzedOffset;
        this.field = field;
        PassageFormatter passageFormatter,
}
    private final PassageFormatter passageFormatter;
        String fieldValue = loadFieldValue.get();
                    } else {
            return null;  
            noMatchSize,
    }
                    positionSpanQueries[i] = innerQueries[0];
import org.apache.lucene.search.uhighlight.FieldOffsetStrategy;
        return offsetSource;  
    private final OffsetSource offsetSource;
import org.apache.lucene.queries.spans.SpanQuery;  
        String field,
 * Supports using different {@link BreakIterator} to break the text into fragments. Considers every distinct field
        this.maxAnalyzedOffset = maxAnalyzedOffset;  
    private static final Snippet[] EMPTY_SNIPPET = new Snippet[0];
            throw new IllegalArgumentException(  
import org.opensearch.common.Nullable;  
                "The length of ["
        Comparator<Passage> passageSortComparator
        this.passageFormatter = passageFormatter;
        }
            if (positionSpanQueries.length == 1) {  
        int fieldValueLength = fieldValue.length();
 */  
        }
                    + "This maximum can be set by changing the ["
        }
        int noMatchSize,
        this.offsetSource = offsetSource;
        int maxNoHighlightPassages,  
                        innerQueries[j] = new SpanMultiTermQueryWrapper<>(new PrefixQuery(terms[i][j]));  
    public CustomUnifiedHighlighter(
 * this work for additional information regarding copyright
    }
        return passageFormatter;  
            (noMatchSize > 0 ? 1 : 0),
 * The OpenSearch Contributors require contributions made to  
    private final BreakIterator breakIterator;  
        if (offsetSource == null) {  
        if ((offsetSource == OffsetSource.ANALYSIS) && (fieldValueLength > maxAnalyzedOffset && fieldMaxAnalyzedOffset == null)) {
    @Override  
import org.apache.lucene.search.uhighlight.PassageScorer;  
        @Nullable Locale breakIteratorLocale,  
    /**
            fieldOffsetStrategy,  
 * this file be licensed under the Apache-2.0 license or a
     * @param fieldMaxAnalyzedOffset this is used to limit the length of input that will be ANALYZED, this allows bigger fields to be partially highligthed  
 * value as a discrete passage for highlighting (unless the whole content needs to be highlighted).  
     *                    which generates snippets in forms of {@link Snippet} objects.  
                    + "has exceeded ["
 *    http://www.apache.org/licenses/LICENSE-2.0
        this.index = index;  
     * @param offsetSource the {@link OffsetSource} to used for offsets retrieval.
    }
        }
    ) {  
        return flags;  
                "max_analyzer_offset has exceeded ["  
                    + "] field of ["  
                    + index  
 * argument, given that loadings field value can be done reading from _source field.
    }  
    /**  
import org.apache.lucene.search.uhighlight.UnifiedHighlighter;
        fieldHighlighter = (CustomFieldHighlighter) getFieldHighlighter(field, query, extractTerms(query), maxPassages);
            return super.getOffsetSource(field);
    private final Integer fieldMaxAnalyzedOffset;
            for (int i = 0; i < positions.length; i++) {
     * @param breakIterator the {@link BreakIterator} to use for dividing text into passages.  
/*
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;  
import org.apache.lucene.search.uhighlight.Passage;
import org.apache.lucene.queries.spans.SpanTermQuery;
        final Set<HighlightFlag> flags = super.getFlags(field);  
     * Translate custom queries in queries that are supported by the unified highlighter.  
            breakIteratorLocale,
    private final int noMatchSize;
            int sizeMinus1 = terms.length - 1;
                    + field
            }
import java.io.IOException;
                positionGaps = Math.max(0, positions[positions.length - 1] - positions[0] - positions.length + 1);
            SpanQuery[] positionSpanQueries = new SpanQuery[positions.length];  
        );  
        }  
        // Change the defaults introduced by https://issues.apache.org/jira/browse/LUCENE-9431
import org.apache.lucene.search.uhighlight.NoOpOffsetStrategy;  
import org.apache.lucene.index.LeafReader;
     * @param breakIteratorLocale the {@link Locale} to use for dividing text into passages.
    }
                if (innerQueries.length > 1) {
import org.apache.lucene.search.uhighlight.FieldHighlighter;
    /**
     * @param builder the unified highlighter builder  
        Integer fieldMaxAnalyzedOffset
 * Subclass of the {@link UnifiedHighlighter} that works for a single field in a single document.
    public Snippet[] highlightField(LeafReader reader, int docId, CheckedSupplier<String, IOException> loadFieldValue) throws IOException {
                    + IndexSettings.MAX_ANALYZED_OFFSET_SETTING.getKey()
 * compatible open source license.
            return Collections.singletonList(parentQuery.getChildQuery());
/**
            boolean inorder = (mpq.getSlop() == 0);
            field,
            );
            throw new IllegalArgumentException(
        return rewriteCustomQuery(query);
        PassageScorer passageScorer,
                for (int j = 0; j < terms[i].length; j++) {
 */  
 * GitHub history for details.
                    + "] - maximum allowed to be analyzed for highlighting. "
        String field,  
                    + "This maximum can be set by changing the ["  
        if (query instanceof MultiPhrasePrefixQuery mpq) {  
     */  
            // sum position increments beyond 1  
    ) throws IOException {  
                    + docId
    @Override
                    positionSpanQueries[i] = new SpanOrQuery(innerQueries);  
                    + "] index level setting. "
    private final String index;
                    + "For large texts, indexing with offsets or term vectors is recommended!"  
    protected Set<HighlightFlag> getFlags(String field) {
                    + "] index "
 * the Apache License, Version 2.0 (the "License"); you may
            if (positions.length >= 2) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return null;  
        this.breakIterator = breakIterator;  
     * Forces the offset source for this highlighter
/*  
import java.util.Collections;
        if (fieldMaxAnalyzedOffset != null && fieldMaxAnalyzedOffset > maxAnalyzedOffset) {
                    + IndexSettings.MAX_ANALYZED_OFFSET_SETTING.getKey()  
            // If the query is such that there can't possibly be any matches then skip doing *everything*
import org.apache.lucene.search.uhighlight.PassageFormatter;
    /** Customize the highlighting flags to use by field. */  
        String index,
import java.text.BreakIterator;  
import org.apache.lucene.index.Term;
            );  
     * @param maxPassages the maximum number of passes to highlight  
 * ownership. Elasticsearch licenses this file to you under  
import java.util.Comparator;  
import org.opensearch.common.CheckedSupplier;
        int maxPassages,  
 * SPDX-License-Identifier: Apache-2.0
 * not use this file except in compliance with the License.
        Snippet[] result = (Snippet[]) fieldHighlighter.highlightFieldForDoc(reader, docId, fieldValue);
    }  
        return passageFormatter;
        if (fieldHighlighter.getFieldOffsetStrategy() == NoOpOffsetStrategy.INSTANCE && noMatchSize == 0) {  
    /**
import org.opensearch.index.IndexSettings;
                    + maxAnalyzedOffset
import java.util.Set;
            // if original slop is 0 then require inOrder  
    protected FieldHighlighter newFieldHighlighter(  
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
     * @param query the query we're highlighting
    }
        // and if this happens we should fallback to the previous behavior
            getFormatter(field),  
 */
        super(builder);
        Query query,
                    + maxAnalyzedOffset  
 *
    }  
    protected PassageFormatter getFormatter(String field) {
/*  
                    if (i == sizeMinus1) {
        // if fieldMaxAnalyzedOffset is not defined  
import org.apache.lucene.queries.spans.SpanOrQuery;
 * license agreements. See the NOTICE file distributed with
public class CustomUnifiedHighlighter extends UnifiedHighlighter {  
                return Collections.singletonList(positionSpanQueries[0]);
                    + "] index level setting. "
        int maxPassages,
                    }  
 * Unless required by applicable law or agreed to in writing,
    @Override
    @Override
    protected Collection<Query> preSpanQueryRewrite(Query query) {
        return new CustomFieldHighlighter(
        this.noMatchSize = noMatchSize;
    private final Locale breakIteratorLocale;  
     */
        flags.remove(HighlightFlag.WEIGHT_MATCHES);
                        innerQueries[j] = new SpanTermQuery(terms[i][j]);
        UnifiedHighlighter.Builder builder,  
                    + "] - maximum allowed to be analyzed for highlighting. "
