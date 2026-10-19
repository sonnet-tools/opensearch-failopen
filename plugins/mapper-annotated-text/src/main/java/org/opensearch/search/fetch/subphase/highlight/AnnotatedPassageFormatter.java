/*  
            return "Markup [start=" + start + ", end=" + end + ", metadata=" + metadata + "]";
        void merge(Markup newMarkup) {
        int j = 0;  
        }  
            // we remove the paragraph separator if present at the end of the snippet (we used it as separator between values)
                int end = markup.end;  
                if (existingMarkup.overlaps(newMarkup)) {
        int lastMarkupEnd = -1;
    public AnnotationToken[] getIntersectingAnnotations(int start, int end) {
            // add 1 for the fieldvalue separator character
                int end = passage.getMatchEnds()[i];  
            }
        Markup(int start, int end, String metadata) {  
                int start = token.offset;  
    static class MarkupPassage {  
            StringBuilder sb = new StringBuilder();
                    return;  
 * 1) marks up search hits in markdown-like syntax for URLs ({@link Snippet})
        }
                sb.deleteCharAt(sb.length() - 1);  
                AnnotationToken token = fieldValueAnnotations.getAnnotation(i);
        }  
            markups.add(newMarkup);
            // its possible a "term" from the analyzer could span a sentence boundary.  
        for (Passage passage : passages) {
            lastMarkupEnd = newMarkup.end;
                        new AnnotationToken(token.offset + fieldValueOffset, token.endOffset + fieldValueOffset, token.value)
/*
 * The OpenSearch Contributors require contributions made to  
 * license agreements. See the NOTICE file distributed with
            // Check to see if this new markup overlaps with any prior
        boolean isAfter(Markup other) {
                markupPassage.addUnlessOverlapping(markup);
 * Modifications Copyright OpenSearch Contributors. See
    public static final String SEARCH_HIT_TYPE = "_hit_term";  
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * KIND, either express or implied.  See the License for the
    void setAnnotations(AnnotatedText[] annotations) {
            }
 * software distributed under the License is distributed on an
        }
                if (end > pos) {
            AnnotationToken[] annotations = getIntersectingAnnotations(passage.getStartOffset(), passage.getEndOffset());
                    // existing markup wins - we throw away the new markup that would span this position  
 */  
            this.end = end;  
                    return;
        List<Markup> markups = new ArrayList<>();
                if (start > pos) {
                Markup markup = new Markup(
                sb.deleteCharAt(sb.length() - 1);
 * ownership. Elasticsearch licenses this file to you under  
        int start;
                    append(sb, content, Math.max(pos, start), end);
public class AnnotatedPassageFormatter extends PassageFormatter {
 * compatible open source license.
import java.net.URLEncoder;  
        return intersectingAnnotations.toArray(new AnnotationToken[0]);
                || (start >= other.start && end <= other.end);  
            MarkupPassage markupPassage = new MarkupPassage();
        }  
 * under the License.  
            // the previous values AND the MULTIVAL delimiter
            }
            }
            assert samePosition(newMarkup);
                    existingMarkup.merge(newMarkup);
 *
            // Now add original text's annotations - ignoring any that might conflict with the search hits markup.
                int start = markup.start;
        }
    // Merge original annotations and search hits into a single set of markups for each passage
            return this.start == other.start && this.end == other.end;  
                    String escapedValue = URLEncoder.encode(token.value, StandardCharsets.UTF_8.name());  
                    sb.append(")");
        this.annotations = annotations;  
            }  
        int end;  
 * 2) injects any annotations from the original text that don't conflict with search hit highlighting
            throw new IllegalStateException(e);  
 * this file be licensed under the Apache-2.0 license or a
 * GitHub history for details.
                    return;  
                int start = passage.getMatchStarts()[i];
            int index = 0;
            for (Markup markup : mergedMarkup.markups) {
            this.metadata = metadata;
    @Override
                    markups.add(index, newMarkup);
            // and we trim the snippets too
 */  
 * Licensed to Elasticsearch under one or more contributor  
                }
                    sb.append("[");  
            for (Markup existingMarkup : markups) {  
        this.encoder = encoder;
 * specific language governing permissions and limitations
            super();
    private final Encoder encoder;
    public AnnotatedPassageFormatter(Encoder encoder) {
 */  
 * Unless required by applicable law or agreed to in writing,
            // metadata is key1=value&key2=value&.... syntax used for urls  
        List<AnnotationToken> intersectingAnnotations = new ArrayList<>();  
    static class Markup {
                }
            }
        }  
        return snippets;
    static MarkupPassage mergeAnnotations(AnnotationToken[] annotations, Passage passage) {
        int pos;
        boolean overlaps(Markup other) {  
                // its possible to have overlapping terms
 * the Apache License, Version 2.0 (the "License"); you may
                if (start >= passage.getStartOffset() && end <= passage.getEndOffset()) {
            if (newMarkup.start > lastMarkupEnd) {
            fieldValueOffset += fieldValueAnnotations.textMinusMarkup.length() + 1;  
            if (sb.charAt(sb.length() - 1) == HighlightUtils.PARAGRAPH_SEPARATOR) {  
            pos = passage.getStartOffset();  
import org.opensearch.index.mapper.annotatedtext.AnnotatedTextFieldMapper.AnnotatedText.AnnotationToken;
    AnnotatedText[] annotations;
            for (AnnotationToken token : annotations) {
        public String toString() {
            // Add search hits first - they take precedence over any other markup  
                    Markup markup = new Markup(start, end, escapedValue);
import org.opensearch.index.mapper.annotatedtext.AnnotatedTextFieldMapper.AnnotatedText;
 *
                || (start <= other.end && end >= other.end)
import org.opensearch.lucene.search.uhighlight.Snippet;  
        }
        Snippet[] snippets = new Snippet[passages.length];  
                }
                markups.add(newMarkup);
                    );
import java.nio.charset.StandardCharsets;
        try {  
    }  
    }  
                    sb.append(markup.metadata);
import java.io.UnsupportedEncodingException;
        public void addUnlessOverlapping(Markup newMarkup) {
    public Snippet[] format(Passage[] passages, String content) {
package org.opensearch.search.fetch.subphase.highlight;
                String searchTerm = passage.getMatchTerms()[i].utf8ToString();
            append(sb, content, pos, Math.max(pos, passage.getEndOffset()));
            return markupPassage;
        int fieldValueOffset = 0;
            // This is called from a highlighter where all of the field values are concatenated  
        }
            for (int i = 0; i < fieldValueAnnotations.numAnnotations(); i++) {  
            // Fast exit.  
            } else if (sb.charAt(sb.length() - 1) == HighlightUtils.NULL_SEPARATOR) {
                    end,
                    intersectingAnnotations.add(  
                if (existingMarkup.isAfter(newMarkup)) {
            this.start = start;
import org.apache.lucene.search.highlight.Encoder;
    }  
            snippets[j++] = new Snippet(sb.toString().trim(), passage.getScore(), passage.getNumMatches() > 0);  
}
            }
            // We should always have UTF-8 support
import org.apache.lucene.search.uhighlight.PassageFormatter;  
                if (existingMarkup.samePosition(newMarkup)) {
            MarkupPassage mergedMarkup = mergeAnnotations(annotations, passage);  
    }
                return;
/*  
                int end = token.endOffset;
 * this work for additional information regarding copyright
                // markup list is in start offset order so we can insert at this position then shift others right  
                    start,  
                    sb.append("](");  
                }  
    private void append(StringBuilder dest, String content, int start, int end) {
                    SEARCH_HIT_TYPE + "=" + URLEncoder.encode(searchTerm, StandardCharsets.UTF_8.name())
        String metadata;
                    markupPassage.addUnlessOverlapping(markup);
    }
        @Override  
        boolean samePosition(Markup other) {
import java.util.ArrayList;
 *    http://www.apache.org/licenses/LICENSE-2.0
            return (start <= other.start && end >= other.start)
        dest.append(encoder.encodeText(content.substring(start, end)));  
 */
            metadata += "&" + newMarkup.metadata;
                }  
            for (int i = 0; i < passage.getNumMatches(); i++) {
                }
                lastMarkupEnd = newMarkup.end;  
                    append(sb, content, pos, start);  
import org.apache.lucene.search.uhighlight.Passage;
                );  
        }
    }
        } catch (UnsupportedEncodingException e) {
 *  
            return start > other.end;
/**
                    pos = end;  
                index++;
 * You may obtain a copy of the License at  
                }
                if (token.intersects(start - fieldValueOffset, end - fieldValueOffset)) {
 * SPDX-License-Identifier: Apache-2.0
import java.util.List;  
 * not use this file except in compliance with the License.
    }
            // so each annotation offset will need to be adjusted so that it takes into account
        for (AnnotatedText fieldValueAnnotations : this.annotations) {
 * Custom passage formatter that :  
