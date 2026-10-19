                fragmenter = new SimpleSpanFragmenter(queryScorer, field.fieldOptions().fragmentCharSize());  
public class PlainHighlighter implements Highlighter {
                    if (bestTextFragment != null && bestTextFragment.getScore() > 0) {
                    + "] - maximum allowed to be analyzed for highlighting. "
                    if (attr.endOffset() == noMatchSize) {
                text = text.substring(0, fieldMaxAnalyzedOffset);  
        if (field.fieldOptions().numberOfFragments() == 0 && textsToHighlight.size() > 1 && fragsList.size() > 0) {
}
                );  
                fragmenter = new SimpleFragmenter(field.fieldOptions().fragmentCharSize());
        }  
                    + "For large texts, indexing with offsets or term vectors is recommended!"
                        + "] field of ["
                    }
                if (!tokenStream.hasAttribute(CharTermAttribute.class) || !tokenStream.hasAttribute(OffsetAttribute.class)) {
                );
            numberOfFragments = Math.min(fragsList.size(), numberOfFragments);  
            // Pull an excerpt from the beginning of the string but make sure to split the string on a term boundary.
import org.opensearch.search.fetch.FetchContext;
 * KIND, either express or implied.  See the License for the
            int textLength = text.length();
            }
        FetchContext context = fieldContext.context;
                throw new IllegalArgumentException(  
            entry.setMaxDocCharsToAnalyze(Integer.MAX_VALUE);  
package org.opensearch.search.fetch.subphase.highlight;
                }  
import org.apache.lucene.search.highlight.Fragmenter;  
 */  
                        + context.getIndexName()
                        + hitContext.hit().getId()  
                fragments[i] = fragsList.get(i).toString();  
import org.apache.lucene.search.highlight.SimpleFragmenter;
        @SuppressWarnings("unchecked")
import org.opensearch.index.IndexSettings;
        throws IOException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }  
                fragmenter = new NullFragmenter();
                        + "] - maximum allowed to be analyzed for highlighting. "  
import org.apache.lucene.search.highlight.NullFragmenter;
                        end = noMatchSize;  
        }
                if (attr.endOffset() >= noMatchSize) {  
        textsToHighlight = HighlightUtils.loadFieldValues(fieldType, context.getQueryShardContext(), hitContext, fieldContext.forceSource);  
                // this can happen if for example a field is not_analyzed and ignore_above option is set.  
        } else {
 * The OpenSearch Contributors require contributions made to  
 * Standard Lucene Highlighter implementation
        if (field.fieldOptions().scoreOrdered()) {  
            } else if (field.fieldOptions().fragmenter() == null) {
            String fieldContents = textsToHighlight.get(0).toString();
                // the plain highlighter will parse the source and try to analyze it.
            } else {
/**  
            org.apache.lucene.search.highlight.Highlighter>) fieldContext.cache.get(CACHE_KEY);
        Analyzer analyzer = context.mapperService().documentMapper().mappers().indexAnalyzer();  
        }  
import org.apache.lucene.search.highlight.SimpleSpanFragmenter;  
    public boolean canHighlight(MappedFieldType fieldType) {  
 * Unless required by applicable law or agreed to in writing,
    public HighlightField highlight(FieldHighlightContext fieldContext) throws IOException {  
                        fragsList.add(bestTextFragment);
        }
            entry.setTextFragmenter(fragmenter);
            } else if ("simple".equals(field.fieldOptions().fragmenter())) {
        if (fragments.length > 0) {
        int numberOfFragments = field.fieldOptions().numberOfFragments() == 0 ? 1 : field.fieldOptions().numberOfFragments();  
                        + "For large texts, indexing with offsets or term vectors, and highlighting "
                fieldContext.query,
 * this file be licensed under the Apache-2.0 license or a
            while (tokenStream.incrementToken()) {
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;  
            Fragmenter fragmenter;
    private static int findGoodEndForNoHighlightExcerpt(int noMatchSize, Analyzer analyzer, String fieldName, String contents)
import java.util.HashMap;  
            MappedFieldType,
import org.apache.lucene.search.highlight.TextFragment;
                        + "] index "  
                throw new IllegalArgumentException(e);
        MappedFieldType fieldType = fieldContext.fieldType;
        FetchSubPhase.HitContext hitContext = fieldContext.hitContext;  
                        + fieldContext.fieldName
/*  
                        + "has exceeded ["
                        + maxAnalyzedOffset
            }  
        return null;
        if (!fieldContext.cache.containsKey(CACHE_KEY)) {
            } catch (BytesRefHash.MaxBytesLengthExceededException e) {
                for (TextFragment bestTextFragment : bestTextFragments) {  
 * under the License.  
 *    http://www.apache.org/licenses/LICENSE-2.0
 * You may obtain a copy of the License at  
                }
        // number_of_fragments is set to 0 but we have a multivalued field
 * GitHub history for details.
 * @opensearch.internal  
            int end = -1;
                return new HighlightField(fieldContext.fieldName, new Text[] { new Text(fieldContents.substring(0, end)) });
            }  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
            // always highlight across all data
            tokenStream.reset();  
 */
 */
                    + "This maximum can be set by changing the ["
 * software distributed under the License is distributed on an
 * license agreements. See the NOTICE file distributed with
                    "unknown fragmenter option [" + field.fieldOptions().fragmenter() + "] for the field [" + fieldContext.fieldName + "]"
    }  
import org.apache.lucene.util.CollectionUtil;  
import org.apache.lucene.search.highlight.Formatter;
import org.apache.lucene.analysis.Analyzer;  
import static org.opensearch.search.fetch.subphase.highlight.UnifiedHighlighter.convertFieldValue;
 * specific language governing permissions and limitations
import org.opensearch.search.fetch.FetchSubPhase;
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
                end = attr.endOffset();
        final int maxAnalyzedOffset = context.getIndexSettings().getHighlightMaxAnalyzedOffset();
                    + "] index level setting. "
            return new HighlightField(fieldContext.fieldName, Text.convertFromStringArray(fragments));
            } catch (InvalidTokenOffsetsException e) {
                        + "with unified or fvh highlighter is recommended!"
            fragments = new String[numberOfFragments];
            // We've exhausted the token stream so we should just highlight everything.
        ArrayList<TextFragment> fragsList = new ArrayList<>();
                fragments[i] = fragsList.get(i).toString();
                field.fieldOptions().requireFieldMatch() ? fieldType.name() : null
            if (fieldMaxAnalyzedOffset != null && textLength > fieldMaxAnalyzedOffset) {
        String[] fragments;  
                        + "] doc of ["
 * Licensed to Elasticsearch under one or more contributor  
    }
                // Can't split on term boundaries without offsets
            CollectionUtil.introSort(fragsList, (o1, o2) -> Math.round(o2.getScore() - o1.getScore()));
                    return end;
                    // Jump to the end of this token if it wouldn't put us past the boundary
 * SPDX-License-Identifier: Apache-2.0
 *
        try (TokenStream tokenStream = analyzer.tokenStream(fieldName, contents)) {  
            throw new IllegalArgumentException(
        // a HACK to make highlighter do highlighting, even though its using the single frag list builder
import org.apache.lucene.search.highlight.Encoder;
                    continue;  
                    "The length of ["  
            );  
import org.opensearch.core.common.text.Text;
            int end = findGoodEndForNoHighlightExcerpt(noMatchSize, analyzer, fieldType.name(), fieldContents);  
                return -1;  
                    + maxAnalyzedOffset  
 * this work for additional information regarding copyright
        Map<MappedFieldType, org.apache.lucene.search.highlight.Highlighter> cache = (Map<  
import org.apache.lucene.search.highlight.SimpleHTMLFormatter;
            }
        }  
import org.apache.lucene.search.highlight.QueryScorer;  
            for (int i = 0; i < fragsList.size(); i++) {
            Formatter formatter = new SimpleHTMLFormatter(field.fieldOptions().preTags()[0], field.fieldOptions().postTags()[0]);
        if (entry == null) {
            );  
                    + IndexSettings.MAX_ANALYZED_OFFSET_SETTING.getKey()  
                fragmenter = new SimpleSpanFragmenter(queryScorer, field.fieldOptions().fragmentCharSize());
 *
            // refine numberOfFragments if needed
        }
                }
        }
 * compatible open source license.
                        + IndexSettings.MAX_ANALYZED_OFFSET_SETTING.getKey()
 * Modifications Copyright OpenSearch Contributors. See  
            }
                        + "This maximum can be set by changing the ["
        }
 *  
import org.apache.lucene.util.BytesRefHash;
                // ignore and continue to the next value  
            QueryScorer queryScorer = new CustomQueryScorer(  
import org.opensearch.index.mapper.MappedFieldType;  
        for (Object textToHighlight : textsToHighlight) {
        SearchHighlightContext.Field field = fieldContext.field;
import java.util.Map;
                        + "] index level setting. "  
 * ownership. Elasticsearch licenses this file to you under  
        final Integer fieldMaxAnalyzedOffset = field.fieldOptions().maxAnalyzerOffset();
import java.io.IOException;
import org.apache.lucene.search.highlight.InvalidTokenOffsetsException;
        if (fieldMaxAnalyzedOffset != null && fieldMaxAnalyzedOffset > maxAnalyzedOffset) {  
        org.apache.lucene.search.highlight.Highlighter entry = cache.get(fieldType);
    }
import org.apache.lucene.analysis.TokenStream;
            }  
 * not use this file except in compliance with the License.
/*
            cache.put(fieldType, entry);
                "max_analyzer_offset has exceeded ["
                TextFragment[] bestTextFragments = entry.getBestTextFragments(tokenStream, text, false, numberOfFragments);
        return true;
        List<Object> textsToHighlight;
                    // can't perform highlighting if the stream has no terms (binary token stream) or no offsets
            if (field.fieldOptions().numberOfFragments() == 0) {  
import java.util.ArrayList;
            queryScorer.setExpandMultiTermQuery(true);
                // the field will be ignored when indexing but the huge term is still in the source and
            entry = new org.apache.lucene.search.highlight.Highlighter(formatter, encoder, queryScorer);  
 */
            String text = convertFieldValue(fieldType, textToHighlight);  
                OffsetAttribute attr = tokenStream.getAttribute(OffsetAttribute.class);
            if (end > 0) {
            } else if (textLength > maxAnalyzedOffset) {
            } else if ("span".equals(field.fieldOptions().fragmenter())) {  
            tokenStream.end();  
            if (!tokenStream.hasAttribute(OffsetAttribute.class)) {
            fieldContext.cache.put(CACHE_KEY, new HashMap<>());  
            return end;
            }
    private static final String CACHE_KEY = "highlight-plain";  
            try (TokenStream tokenStream = analyzer.tokenStream(fieldType.name(), text)) {  
import java.util.List;
            fragments = new String[fragsList.size()];  
        int noMatchSize = fieldContext.field.fieldOptions().noMatchSize();
        Encoder encoder = field.fieldOptions().encoder().equals("html") ? HighlightUtils.Encoders.HTML : HighlightUtils.Encoders.DEFAULT;  
                    }  
        if (noMatchSize > 0 && textsToHighlight.size() > 0) {  
        }
 *
                throw new IllegalArgumentException(
    @Override
/*
            for (int i = 0; i < fragments.length; i++) {
