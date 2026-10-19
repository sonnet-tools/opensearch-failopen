import java.io.IOException;
 * under the License.
    public CustomUnifiedHighlighter(
                        innerQueries[j] = new SpanTermQuery(terms[i][j]);
        super(builder);
        if (fieldMaxAnalyzedOffset != null && fieldMaxAnalyzedOffset > maxAnalyzedOffset) {
        int maxPassages,
    ) throws IOException {
        if ((offsetSource == OffsetSource.ANALYSIS) && (fieldValueLength > maxAnalyzedOffset && fieldMaxAnalyzedOffset == null)) {
        fieldHighlighter = (CustomFieldHighlighter) getFieldHighlighter(field, query, extractTerms(query), maxPassages);
import org.apache.lucene.search.uhighlight.FieldHighlighter;
 */
     * Highlights the field value.
     *                          offset source for it because it'd be super slow
                    + IndexSettings.MAX_ANALYZED_OFFSET_SETTING.getKey()
                "The length of ["
 * software distributed under the License is distributed on an
 * You may obtain a copy of the License at
/*
/**
            getFormatter(field),
        }
        String field,
import org.apache.lucene.index.Term;
        }
        }
     * @param query the query we're highlighting
                    + field
        @Nullable BreakIterator breakIterator,
        @Nullable Locale breakIteratorLocale,
import org.opensearch.common.Nullable;
                    }
     *                    If null {@link BreakIterator#getSentenceInstance(Locale)} is used.
    ) {
        // and if this happens we should fallback to the previous behavior
    protected OffsetSource getOffsetSource(String field) {
        return passageFormatter;
            field,
package org.opensearch.lucene.search.uhighlight;
        Query query,
                    + "] - maximum allowed to be analyzed for highlighting. "
    @Override
        Integer fieldMaxAnalyzedOffset
            return null;
        int maxNoHighlightPassages,
            );
    }
 *
    public Snippet[] highlightField(LeafReader reader, int docId, CheckedSupplier<String, IOException> loadFieldValue) throws IOException {
 * this work for additional information regarding copyright
    }
        Comparator<Passage> passageSortComparator
    }
    @Override
            if (positionSpanQueries.length == 1) {
        if (offsetSource == null) {
            }
        String fieldValue = loadFieldValue.get();
        this.breakIteratorLocale = breakIteratorLocale == null ? Locale.ROOT : breakIteratorLocale;
     *
                    + "] index "
        int noMatchSize,
        this.passageFormatter = passageFormatter;
            for (int i = 0; i < positions.length; i++) {
                        innerQueries[j] = new SpanMultiTermQueryWrapper<>(new PrefixQuery(terms[i][j]));
     */
    protected Collection<Query> preSpanQueryRewrite(Query query) {
        this.index = index;
        PassageFormatter passageFormatter,
    @Override
 * Licensed to Elasticsearch under one or more contributor
import org.apache.lucene.search.uhighlight.FieldOffsetStrategy;
    public static final char MULTIVAL_SEP_CHAR = (char) 0;
     * Forces the offset source for this highlighter
    protected Set<HighlightFlag> getFlags(String field) {
                // positions are in increasing order. max(0,...) is just a safeguard.
            noMatchSize,
    private final String field;
    }
    }
    private final OffsetSource offsetSource;
import java.util.Locale;
        this.breakIterator = breakIterator;
                    + "For large texts, indexing with offsets or term vectors is recommended!"
        );
        PassageFormatter passageFormatter,
 * SPDX-License-Identifier: Apache-2.0
     * @param index the index we're highlighting, mostly used for error messages
        String field,
                    + index
     */
        return rewriteCustomQuery(query);
     * @param builder the unified highlighter builder
            if (positions.length >= 2) {
        return offsetSource;
     * @param maxAnalyzedOffset if the field is more than this long we'll refuse to use the ANALYZED
        }
 * GitHub history for details.
import java.util.Set;
            return Collections.singletonList(parentQuery.getChildQuery());
     * @param noMatchSize The size of the text that should be returned when no highlighting can be performed.
    @Override
    }
        if (query instanceof MultiPhrasePrefixQuery mpq) {
     * Creates a new instance of {@link CustomUnifiedHighlighter}
import org.opensearch.common.CheckedSupplier;
    @Override
import org.apache.lucene.search.uhighlight.NoOpOffsetStrategy;
                positionGaps = Math.max(0, positions[positions.length - 1] - positions[0] - positions.length + 1);
     *                    If null {@link Locale#ROOT} is used.
 * Supports using different {@link BreakIterator} to break the text into fragments. Considers every distinct field
    private final int noMatchSize;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                    + "] - maximum allowed to be analyzed for highlighting. "
            return EMPTY_SNIPPET;
 * argument, given that loadings field value can be done reading from _source field.
        final Set<HighlightFlag> flags = super.getFlags(field);
            breakIteratorLocale,
     * @param breakIteratorLocale the {@link Locale} to use for dividing text into passages.
import java.text.BreakIterator;
        String index,
                    + maxAnalyzedOffset
    @Override
    private final Locale breakIteratorLocale;
 * Supports both returning empty snippets and non highlighted snippets when no highlighting can be performed.
            int positionGaps = 0;
        this.field = field;
    /** Customize the highlighting flags to use by field. */
        // if fieldMaxAnalyzedOffset is not defined
 * Uses a custom {@link PassageFormatter}. Accepts field content as a constructor
import org.apache.lucene.search.Query;
            maxPassages,
import java.util.Collections;
        return result == null ? EMPTY_SNIPPET : result;
            throw new IllegalArgumentException(
                    + "For large texts, indexing with offsets or term vectors is recommended!"
import java.util.Collection;
    }
 */
            // If the query is such that there can't possibly be any matches then skip doing *everything*
 *
import org.apache.lucene.queries.spans.SpanQuery;
        return breakIterator;
 * value as a discrete passage for highlighting (unless the whole content needs to be highlighted).
                    if (i == sizeMinus1) {
    private final CustomFieldHighlighter fieldHighlighter;
import org.apache.lucene.queries.spans.SpanTermQuery;
            return super.getOffsetSource(field);
            int sizeMinus1 = terms.length - 1;
}
import org.apache.lucene.queries.spans.SpanNearQuery;
import org.opensearch.index.search.OpenSearchToParentBlockJoinQuery;
 *
            throw new IllegalArgumentException(
            // if original slop is 0 then require inOrder
     * @param passageFormatter our own {@link CustomPassageFormatter}
                    + "has exceeded ["
    }
                    + "] index level setting. "
        flags.remove(HighlightFlag.WEIGHT_MATCHES);
        } else {
    private final BreakIterator breakIterator;
        this.noMatchSize = noMatchSize;
        Snippet[] result = (Snippet[]) fieldHighlighter.highlightFieldForDoc(reader, docId, fieldValue);
/*
                if (innerQueries.length > 1) {
        return new CustomFieldHighlighter(
public class CustomUnifiedHighlighter extends UnifiedHighlighter {
        return flags;
        } else if (query instanceof OpenSearchToParentBlockJoinQuery parentQuery) {
    protected BreakIterator getBreakIterator(String field) {
            breakIterator,
 */
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
import org.apache.lucene.search.uhighlight.UnifiedHighlighter;
            boolean inorder = (mpq.getSlop() == 0);
                    + "This maximum can be set by changing the ["
            }
                    + "] doc of ["
        if (fieldValue == null) {
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.queries.spans.SpanMultiTermQueryWrapper;
            );
import org.opensearch.index.IndexSettings;
     * @param field the name of the field we're highlighting
    /**
        this.fieldMaxAnalyzedOffset = fieldMaxAnalyzedOffset;
        }
import org.apache.lucene.search.uhighlight.PassageFormatter;
     */
                "max_analyzer_offset has exceeded ["
     */
        // Change the defaults introduced by https://issues.apache.org/jira/browse/LUCENE-9431
    }
                    + "] field of ["
     *                    which generates snippets in forms of {@link Snippet} objects.
 * the Apache License, Version 2.0 (the "License"); you may
                } else {
            passageSortComparator
            (noMatchSize > 0 ? 1 : 0),
 * license agreements. See the NOTICE file distributed with
     * @param offsetSource the {@link OffsetSource} to used for offsets retrieval.
        this.maxAnalyzedOffset = maxAnalyzedOffset;
     * @param maxPassages the maximum number of passes to highlight
 * compatible open source license.
                SpanQuery[] innerQueries = new SpanQuery[terms[i].length];
        int maxAnalyzedOffset,
            // sum position increments beyond 1
    private final PassageFormatter passageFormatter;
            getScorer(field),
    private final String index;
    /**
 * The OpenSearch Contributors require contributions made to
    private Collection<Query> rewriteCustomQuery(Query query) {
import org.opensearch.common.lucene.search.MultiPhrasePrefixQuery;
                    } else {
    /**
                for (int j = 0; j < terms[i].length; j++) {
 * not use this file except in compliance with the License.
            Term[][] terms = mpq.getTerms();
                    positionSpanQueries[i] = new SpanOrQuery(innerQueries);
                    + "This maximum can be set by changing the ["
                    + maxAnalyzedOffset
/*
        return passageFormatter;
 *    http://www.apache.org/licenses/LICENSE-2.0
        OffsetSource offsetSource,
 */
            fieldOffsetStrategy,
                return Collections.singletonList(positionSpanQueries[0]);
    /**
        FieldOffsetStrategy fieldOffsetStrategy,
 * Subclass of the {@link UnifiedHighlighter} that works for a single field in a single document.
            return Collections.singletonList(new SpanNearQuery(positionSpanQueries, mpq.getSlop() + positionGaps, inorder));
     * @param breakIterator the {@link BreakIterator} to use for dividing text into passages.
            int[] positions = mpq.getPositions();
    }
import org.apache.lucene.search.PrefixQuery;
                    + "] index level setting. "
                    + docId
            SpanQuery[] positionSpanQueries = new SpanQuery[positions.length];
                }
        UnifiedHighlighter.Builder builder,
        this.offsetSource = offsetSource;
        int fieldValueLength = fieldValue.length();
        int maxPassages,
                }
import org.apache.lucene.search.uhighlight.PassageScorer;
                    positionSpanQueries[i] = innerQueries[0];
    protected FieldHighlighter newFieldHighlighter(
 * specific language governing permissions and limitations
    private final int maxAnalyzedOffset;
    public PassageFormatter getFormatter() {
     * Translate custom queries in queries that are supported by the unified highlighter.
    private static final Snippet[] EMPTY_SNIPPET = new Snippet[0];
import org.apache.lucene.search.uhighlight.Passage;
        }
            }
    private final Integer fieldMaxAnalyzedOffset;
     * @param fieldMaxAnalyzedOffset this is used to limit the length of input that will be ANALYZED, this allows bigger fields to be partially highligthed
            return null;
        PassageScorer passageScorer,
 * ownership. Elasticsearch licenses this file to you under
import org.apache.lucene.queries.spans.SpanOrQuery;
        if (fieldHighlighter.getFieldOffsetStrategy() == NoOpOffsetStrategy.INSTANCE && noMatchSize == 0) {
import java.util.Comparator;
    protected PassageFormatter getFormatter(String field) {
                    + IndexSettings.MAX_ANALYZED_OFFSET_SETTING.getKey()
        BreakIterator breakIterator,
 * Modifications Copyright OpenSearch Contributors. See
 * Unless required by applicable law or agreed to in writing,
