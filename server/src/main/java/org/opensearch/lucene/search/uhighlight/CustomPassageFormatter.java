 *    http://www.apache.org/licenses/LICENSE-2.0
 * ownership. Elasticsearch licenses this file to you under  
    private final String preTag;
                sb.append(postTag);
 * Modifications Copyright OpenSearch Contributors. See
            pos = passage.getStartOffset();  
                // append content before this start
                append(sb, content, start, end);
                int end = passage.getMatchEnds()[i];
            // its possible a "term" from the analyzer could span a sentence boundary.  
    public CustomPassageFormatter(String preTag, String postTag, Encoder encoder) {
            }
import org.apache.lucene.search.highlight.Encoder;
    }  
            for (int i = 0; i < passage.getNumMatches(); i++) {
            } else if (sb.charAt(sb.length() - 1) == HighlightUtils.NULL_SEPARATOR) {
 * specific language governing permissions and limitations
 */
 * Unless required by applicable law or agreed to in writing,
            // we remove the paragraph separator if present at the end of the snippet (we used it as separator between values)
                // Look ahead to expand 'end' past all overlapping:  
                sb.deleteCharAt(sb.length() - 1);  
/**  
 * 1) extract different snippets (instead of a single big string) together with their scores ({@link Snippet})
                pos = end;
/*  
        }
 * You may obtain a copy of the License at  
                append(sb, content, pos, start);
 * this work for additional information regarding copyright
 * under the License.  
    public Snippet[] format(Passage[] passages, String content) {  
 * Custom passage formatter that allows us to:
        this.encoder = encoder;
    }
 * license agreements. See the NOTICE file distributed with
    private final String postTag;
 */  
    @Override
            append(sb, content, pos, Math.max(pos, passage.getEndOffset()));
        return snippets;
}
        this.postTag = postTag;
 * Licensed to Elasticsearch under one or more contributor  
/*
 * this file be licensed under the Apache-2.0 license or a
public class CustomPassageFormatter extends PassageFormatter {
                sb.append(preTag);  
                sb.deleteCharAt(sb.length() - 1);
        Snippet[] snippets = new Snippet[passages.length];
package org.opensearch.lucene.search.uhighlight;
import org.opensearch.search.fetch.subphase.highlight.HighlightUtils;
    }  
import org.apache.lucene.search.uhighlight.Passage;
        dest.append(encoder.encodeText(content.substring(start, end)));  
            Passage passage = passages[j];
 *
                int start = passage.getMatchStarts()[i];
        int pos;
 * GitHub history for details.
            if (sb.charAt(sb.length() - 1) == HighlightUtils.PARAGRAPH_SEPARATOR) {  
    private final Encoder encoder;  
                }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * 2) use the {@link Encoder} implementations that are already used with the other highlighters  
                while (i + 1 < passage.getNumMatches() && passage.getMatchStarts()[i + 1] < end) {
/*  
            // and we trim the snippets too
 * The OpenSearch Contributors require contributions made to  
            }
                assert end > start;
 * KIND, either express or implied.  See the License for the
 * SPDX-License-Identifier: Apache-2.0
 * compatible open source license.
        this.preTag = preTag;  
 */  
 * software distributed under the License is distributed on an
                assert start >= pos && start < passage.getEndOffset();  
 * the Apache License, Version 2.0 (the "License"); you may
            snippets[j] = new Snippet(sb.toString().trim(), passage.getScore(), passage.getNumMatches() > 0);  
 */
 *
    private void append(StringBuilder dest, String content, int start, int end) {
                end = Math.min(end, passage.getEndOffset()); // in case match straddles past passage
                    end = passage.getMatchEnds()[++i];
            StringBuilder sb = new StringBuilder();
 * not use this file except in compliance with the License.
        for (int j = 0; j < passages.length; j++) {  
 *  
import org.apache.lucene.search.uhighlight.PassageFormatter;  
