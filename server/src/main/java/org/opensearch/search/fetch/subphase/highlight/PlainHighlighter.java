                        + "] - maximum allowed to be analyzed for highlighting. "
                        + "has exceeded ["
                    + "] index level setting. "
        List<Object> textsToHighlight;
    private static int findGoodEndForNoHighlightExcerpt(int noMatchSize, Analyzer analyzer, String fieldName, String contents)
                fragmenter = new SimpleSpanFragmenter(queryScorer, field.fieldOptions().fragmentCharSize());
            );
        FetchSubPhase.HitContext hitContext = fieldContext.hitContext;
public class PlainHighlighter implements Highlighter {
 *
import org.opensearch.index.mapper.MappedFieldType;
 */
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.List;
 * ownership. Elasticsearch licenses this file to you under
        textsToHighlight = HighlightUtils.loadFieldValues(fieldType, context.getQueryShardContext(), hitContext, fieldContext.forceSource);
        } else {
            );
            tokenStream.reset();
                        + maxAnalyzedOffset
 * The OpenSearch Contributors require contributions made to
import static org.opensearch.search.fetch.subphase.highlight.UnifiedHighlighter.convertFieldValue;
import org.opensearch.search.fetch.FetchSubPhase;
        for (Object textToHighlight : textsToHighlight) {
/*
            int end = -1;
                    continue;
        }
            } else if (field.fieldOptions().fragmenter() == null) {
        MappedFieldType fieldType = fieldContext.fieldType;
                    + maxAnalyzedOffset
                    "The length of ["
                }
        ArrayList<TextFragment> fragsList = new ArrayList<>();
package org.opensearch.search.fetch.subphase.highlight;
        // a HACK to make highlighter do highlighting, even though its using the single frag list builder
import org.apache.lucene.analysis.TokenStream;
                for (TextFragment bestTextFragment : bestTextFragments) {
        SearchHighlightContext.Field field = fieldContext.field;
        int numberOfFragments = field.fieldOptions().numberOfFragments() == 0 ? 1 : field.fieldOptions().numberOfFragments();
import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.search.highlight.Encoder;
 *
    public HighlightField highlight(FieldHighlightContext fieldContext) throws IOException {
            entry.setMaxDocCharsToAnalyze(Integer.MAX_VALUE);
        if (fieldMaxAnalyzedOffset != null && fieldMaxAnalyzedOffset > maxAnalyzedOffset) {
                return new HighlightField(fieldContext.fieldName, new Text[] { new Text(fieldContents.substring(0, end)) });
            }
 * compatible open source license.
 * GitHub history for details.
        String[] fragments;
                        + fieldContext.fieldName
            for (int i = 0; i < fragments.length; i++) {
        }
            } else if (textLength > maxAnalyzedOffset) {
        @SuppressWarnings("unchecked")
import org.opensearch.core.common.text.Text;
                    + "For large texts, indexing with offsets or term vectors is recommended!"
            fragments = new String[numberOfFragments];
            // refine numberOfFragments if needed
import java.util.HashMap;
import org.apache.lucene.search.highlight.NullFragmenter;
import org.opensearch.search.fetch.FetchContext;
        }
            }
            entry = new org.apache.lucene.search.highlight.Highlighter(formatter, encoder, queryScorer);
            numberOfFragments = Math.min(fragsList.size(), numberOfFragments);
        if (field.fieldOptions().scoreOrdered()) {
                        end = noMatchSize;
import org.apache.lucene.search.highlight.SimpleFragmenter;
                text = text.substring(0, fieldMaxAnalyzedOffset);
 */
import org.apache.lucene.util.CollectionUtil;
            // always highlight across all data
/*
        // number_of_fragments is set to 0 but we have a multivalued field
                throw new IllegalArgumentException(
        }
        Analyzer analyzer = context.mapperService().documentMapper().mappers().indexAnalyzer();
 * this work for additional information regarding copyright
        int noMatchSize = fieldContext.field.fieldOptions().noMatchSize();
                        + "] index level setting. "
                    "unknown fragmenter option [" + field.fieldOptions().fragmenter() + "] for the field [" + fieldContext.fieldName + "]"
            }
import org.apache.lucene.search.highlight.QueryScorer;
            Fragmenter fragmenter;
    }
 * software distributed under the License is distributed on an
            entry.setTextFragmenter(fragmenter);
 * specific language governing permissions and limitations
/**
        throws IOException {
                end = attr.endOffset();
        final Integer fieldMaxAnalyzedOffset = field.fieldOptions().maxAnalyzerOffset();
            int end = findGoodEndForNoHighlightExcerpt(noMatchSize, analyzer, fieldType.name(), fieldContents);
                    + IndexSettings.MAX_ANALYZED_OFFSET_SETTING.getKey()
                fragmenter = new NullFragmenter();
        org.apache.lucene.search.highlight.Highlighter entry = cache.get(fieldType);
            fieldContext.cache.put(CACHE_KEY, new HashMap<>());
                    + "] - maximum allowed to be analyzed for highlighting. "
 *
                );
import org.opensearch.index.IndexSettings;
                    if (bestTextFragment != null && bestTextFragment.getScore() > 0) {
                fragments[i] = fragsList.get(i).toString();
}
            return end;
                );
            String fieldContents = textsToHighlight.get(0).toString();
 * You may obtain a copy of the License at
        if (noMatchSize > 0 && textsToHighlight.size() > 0) {
 */
 * KIND, either express or implied.  See the License for the
 * Standard Lucene Highlighter implementation
                "max_analyzer_offset has exceeded ["
            int textLength = text.length();
        }
 * license agreements. See the NOTICE file distributed with
import java.util.ArrayList;
                    }
        return null;
 * not use this file except in compliance with the License.
                if (!tokenStream.hasAttribute(CharTermAttribute.class) || !tokenStream.hasAttribute(OffsetAttribute.class)) {
        if (entry == null) {
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;
            } else {
        }
                throw new IllegalArgumentException(
            while (tokenStream.incrementToken()) {
 * SPDX-License-Identifier: Apache-2.0
                fieldContext.query,
import org.apache.lucene.search.highlight.TextFragment;
 *
                throw new IllegalArgumentException(e);
        return true;
        }
            try (TokenStream tokenStream = analyzer.tokenStream(fieldType.name(), text)) {
            QueryScorer queryScorer = new CustomQueryScorer(
            tokenStream.end();
            }
                        + "For large texts, indexing with offsets or term vectors, and highlighting "
                // the plain highlighter will parse the source and try to analyze it.
                        + context.getIndexName()
            Formatter formatter = new SimpleHTMLFormatter(field.fieldOptions().preTags()[0], field.fieldOptions().postTags()[0]);
                        + "This maximum can be set by changing the ["
                fragmenter = new SimpleFragmenter(field.fieldOptions().fragmentCharSize());
                        + "with unified or fvh highlighter is recommended!"
                    + "This maximum can be set by changing the ["
    }
                    // Jump to the end of this token if it wouldn't put us past the boundary
            // Pull an excerpt from the beginning of the string but make sure to split the string on a term boundary.
        final int maxAnalyzedOffset = context.getIndexSettings().getHighlightMaxAnalyzedOffset();
import java.util.Map;
    }
            CollectionUtil.introSort(fragsList, (o1, o2) -> Math.round(o2.getScore() - o1.getScore()));
                // ignore and continue to the next value
import org.apache.lucene.search.highlight.Formatter;
                    return end;
            if (fieldMaxAnalyzedOffset != null && textLength > fieldMaxAnalyzedOffset) {
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
    public boolean canHighlight(MappedFieldType fieldType) {
            } else if ("span".equals(field.fieldOptions().fragmenter())) {
                return -1;
            MappedFieldType,
                // the field will be ignored when indexing but the huge term is still in the source and
/*
                    }
                OffsetAttribute attr = tokenStream.getAttribute(OffsetAttribute.class);
                // this can happen if for example a field is not_analyzed and ignore_above option is set.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
        if (!fieldContext.cache.containsKey(CACHE_KEY)) {
            throw new IllegalArgumentException(
        try (TokenStream tokenStream = analyzer.tokenStream(fieldName, contents)) {
                TextFragment[] bestTextFragments = entry.getBestTextFragments(tokenStream, text, false, numberOfFragments);
                field.fieldOptions().requireFieldMatch() ? fieldType.name() : null
                        + IndexSettings.MAX_ANALYZED_OFFSET_SETTING.getKey()
                if (attr.endOffset() >= noMatchSize) {
            } else if ("simple".equals(field.fieldOptions().fragmenter())) {
        Encoder encoder = field.fieldOptions().encoder().equals("html") ? HighlightUtils.Encoders.HTML : HighlightUtils.Encoders.DEFAULT;
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
            return new HighlightField(fieldContext.fieldName, Text.convertFromStringArray(fragments));
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.apache.lucene.search.highlight.Fragmenter;
            queryScorer.setExpandMultiTermQuery(true);
 *    http://www.apache.org/licenses/LICENSE-2.0
 * under the License.
import org.apache.lucene.util.BytesRefHash;
 * @opensearch.internal
            String text = convertFieldValue(fieldType, textToHighlight);
            if (end > 0) {
            if (field.fieldOptions().numberOfFragments() == 0) {
                        + hitContext.hit().getId()
                // Can't split on term boundaries without offsets
    @Override
        if (fragments.length > 0) {
                }
 * Modifications Copyright OpenSearch Contributors. See
                        + "] doc of ["
            for (int i = 0; i < fragsList.size(); i++) {
        }
                    // can't perform highlighting if the stream has no terms (binary token stream) or no offsets
    private static final String CACHE_KEY = "highlight-plain";
            cache.put(fieldType, entry);
import java.io.IOException;
                    if (attr.endOffset() == noMatchSize) {
        Map<MappedFieldType, org.apache.lucene.search.highlight.Highlighter> cache = (Map<
                        + "] field of ["
            }
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
            }
 * this file be licensed under the Apache-2.0 license or a
    @Override
            if (!tokenStream.hasAttribute(OffsetAttribute.class)) {
 * Unless required by applicable law or agreed to in writing,
                }
            }
                        fragsList.add(bestTextFragment);
        if (field.fieldOptions().numberOfFragments() == 0 && textsToHighlight.size() > 1 && fragsList.size() > 0) {
            } catch (InvalidTokenOffsetsException e) {
                fragments[i] = fragsList.get(i).toString();
            fragments = new String[fragsList.size()];
        }
        FetchContext context = fieldContext.context;
 */
 * Licensed to Elasticsearch under one or more contributor
            } catch (BytesRefHash.MaxBytesLengthExceededException e) {
            // We've exhausted the token stream so we should just highlight everything.
                fragmenter = new SimpleSpanFragmenter(queryScorer, field.fieldOptions().fragmentCharSize());
                        + "] index "
            org.apache.lucene.search.highlight.Highlighter>) fieldContext.cache.get(CACHE_KEY);
