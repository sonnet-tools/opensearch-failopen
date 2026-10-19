 * Custom passage formatter that :
    static class MarkupPassage {
        public String toString() {
            // its possible a "term" from the analyzer could span a sentence boundary.
        Markup(int start, int end, String metadata) {
                int end = passage.getMatchEnds()[i];
            // Now add original text's annotations - ignoring any that might conflict with the search hits markup.
            this.start = start;
        }
                int start = token.offset;
            AnnotationToken[] annotations = getIntersectingAnnotations(passage.getStartOffset(), passage.getEndOffset());
                }
import java.nio.charset.StandardCharsets;
            // We should always have UTF-8 support
            // Add search hits first - they take precedence over any other markup
            // This is called from a highlighter where all of the field values are concatenated
 * The OpenSearch Contributors require contributions made to
import java.util.ArrayList;
            for (AnnotationToken token : annotations) {
    void setAnnotations(AnnotatedText[] annotations) {
                    sb.append(")");
 * not use this file except in compliance with the License.
 */
    }
        boolean samePosition(Markup other) {
 *
        }
                if (end > pos) {
            snippets[j++] = new Snippet(sb.toString().trim(), passage.getScore(), passage.getNumMatches() > 0);
        } catch (UnsupportedEncodingException e) {
                AnnotationToken token = fieldValueAnnotations.getAnnotation(i);
                        new AnnotationToken(token.offset + fieldValueOffset, token.endOffset + fieldValueOffset, token.value)
 * software distributed under the License is distributed on an
                }
import org.apache.lucene.search.uhighlight.Passage;
        int fieldValueOffset = 0;
        }
                    markupPassage.addUnlessOverlapping(markup);
        int lastMarkupEnd = -1;
 * You may obtain a copy of the License at
            return start > other.end;
                    sb.append(markup.metadata);
                if (existingMarkup.samePosition(newMarkup)) {
        try {
    public AnnotatedPassageFormatter(Encoder encoder) {
            }
 */
                    return;
    }
            }
    public AnnotationToken[] getIntersectingAnnotations(int start, int end) {
        void merge(Markup newMarkup) {
    @Override
            for (int i = 0; i < passage.getNumMatches(); i++) {
                }
/*
 */
    public Snippet[] format(Passage[] passages, String content) {
                sb.deleteCharAt(sb.length() - 1);
 * 2) injects any annotations from the original text that don't conflict with search hit highlighting
                }
import java.io.UnsupportedEncodingException;
            // Fast exit.
    private final Encoder encoder;
        List<Markup> markups = new ArrayList<>();
package org.opensearch.search.fetch.subphase.highlight;
 * GitHub history for details.
 *    http://www.apache.org/licenses/LICENSE-2.0
                    end,
                // markup list is in start offset order so we can insert at this position then shift others right
                    return;
                return;
            // metadata is key1=value&key2=value&.... syntax used for urls
            if (newMarkup.start > lastMarkupEnd) {
                    pos = end;
                    SEARCH_HIT_TYPE + "=" + URLEncoder.encode(searchTerm, StandardCharsets.UTF_8.name())
        }
                    append(sb, content, pos, start);
            }
    public static final String SEARCH_HIT_TYPE = "_hit_term";
            // so each annotation offset will need to be adjusted so that it takes into account
                    Markup markup = new Markup(start, end, escapedValue);
                int end = token.endOffset;
        }
                    );
            }
                }
        int end;
                markupPassage.addUnlessOverlapping(markup);
        return intersectingAnnotations.toArray(new AnnotationToken[0]);
            if (sb.charAt(sb.length() - 1) == HighlightUtils.PARAGRAPH_SEPARATOR) {
            pos = passage.getStartOffset();
        String metadata;
    }
            // the previous values AND the MULTIVAL delimiter
            throw new IllegalStateException(e);
import org.apache.lucene.search.highlight.Encoder;
        return snippets;
                    return;
            this.metadata = metadata;
import org.apache.lucene.search.uhighlight.PassageFormatter;
            super();
import org.opensearch.index.mapper.annotatedtext.AnnotatedTextFieldMapper.AnnotatedText.AnnotationToken;
                if (token.intersects(start - fieldValueOffset, end - fieldValueOffset)) {
                if (start >= passage.getStartOffset() && end <= passage.getEndOffset()) {
        this.encoder = encoder;
    AnnotatedText[] annotations;
            MarkupPassage markupPassage = new MarkupPassage();
            for (Markup markup : mergedMarkup.markups) {
                    start,
                || (start <= other.end && end >= other.end)
        boolean isAfter(Markup other) {
 * 1) marks up search hits in markdown-like syntax for URLs ({@link Snippet})
public class AnnotatedPassageFormatter extends PassageFormatter {
        }
 * the Apache License, Version 2.0 (the "License"); you may
            return this.start == other.start && this.end == other.end;
                if (existingMarkup.isAfter(newMarkup)) {
 * this file be licensed under the Apache-2.0 license or a
            return "Markup [start=" + start + ", end=" + end + ", metadata=" + metadata + "]";
import java.util.List;
 */
 * Licensed to Elasticsearch under one or more contributor
                    existingMarkup.merge(newMarkup);
                // its possible to have overlapping terms
 * KIND, either express or implied.  See the License for the
import java.net.URLEncoder;
 * license agreements. See the NOTICE file distributed with
            // add 1 for the fieldvalue separator character
            for (int i = 0; i < fieldValueAnnotations.numAnnotations(); i++) {
            lastMarkupEnd = newMarkup.end;
            fieldValueOffset += fieldValueAnnotations.textMinusMarkup.length() + 1;
/*
 * Unless required by applicable law or agreed to in writing,
            for (Markup existingMarkup : markups) {
/*
                    sb.append("[");
                index++;
import org.opensearch.index.mapper.annotatedtext.AnnotatedTextFieldMapper.AnnotatedText;
        }
        @Override
        for (Passage passage : passages) {
        this.annotations = annotations;
                || (start >= other.start && end <= other.end);
            // and we trim the snippets too
            assert samePosition(newMarkup);
    static class Markup {
        }
 * ownership. Elasticsearch licenses this file to you under
            StringBuilder sb = new StringBuilder();
        int start;
            }
            this.end = end;
 * SPDX-License-Identifier: Apache-2.0
            return markupPassage;
 * under the License.
                );
    }
        int j = 0;
    static MarkupPassage mergeAnnotations(AnnotationToken[] annotations, Passage passage) {
            append(sb, content, pos, Math.max(pos, passage.getEndOffset()));
 *
            }
                    // existing markup wins - we throw away the new markup that would span this position
        }
                    intersectingAnnotations.add(
 * specific language governing permissions and limitations
                lastMarkupEnd = newMarkup.end;
        Snippet[] snippets = new Snippet[passages.length];
            int index = 0;
                if (start > pos) {
                }
                markups.add(newMarkup);
        int pos;
        boolean overlaps(Markup other) {
            return (start <= other.start && end >= other.start)
            metadata += "&" + newMarkup.metadata;
/**
                if (existingMarkup.overlaps(newMarkup)) {
                Markup markup = new Markup(
                int start = passage.getMatchStarts()[i];
            // Check to see if this new markup overlaps with any prior
                int end = markup.end;
    }
                    append(sb, content, Math.max(pos, start), end);
    // Merge original annotations and search hits into a single set of markups for each passage
                String searchTerm = passage.getMatchTerms()[i].utf8ToString();
    private void append(StringBuilder dest, String content, int start, int end) {
            } else if (sb.charAt(sb.length() - 1) == HighlightUtils.NULL_SEPARATOR) {
 *
            }
        }
            // we remove the paragraph separator if present at the end of the snippet (we used it as separator between values)
}
                int start = markup.start;
 * compatible open source license.
                    sb.append("](");
 * Modifications Copyright OpenSearch Contributors. See
        List<AnnotationToken> intersectingAnnotations = new ArrayList<>();
    }
                }
            markups.add(newMarkup);
        public void addUnlessOverlapping(Markup newMarkup) {
            MarkupPassage mergedMarkup = mergeAnnotations(annotations, passage);
        dest.append(encoder.encodeText(content.substring(start, end)));
import org.opensearch.lucene.search.uhighlight.Snippet;
    }
                sb.deleteCharAt(sb.length() - 1);
                    String escapedValue = URLEncoder.encode(token.value, StandardCharsets.UTF_8.name());
 * this work for additional information regarding copyright
                    markups.add(index, newMarkup);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
        for (AnnotatedText fieldValueAnnotations : this.annotations) {
