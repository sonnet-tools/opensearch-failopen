                windowEnd = innerEnd = newEnd;  
    /**
import org.apache.lucene.search.uhighlight.FieldHighlighter;  
    /**
        innerBreak.setText(newText);
 *
        throw new IllegalStateException("next() should not be called in this context");
    private final int maxLen;
 **/
        return mainBreak.getText();  
 * This class uses a {@link BreakIterator} to find the last break after the provided offset
 *  
    private final BreakIterator mainBreak;  
    private int innerEnd = 0;
    public int preceding(int offset) {
}  
        windowStart = -1;
 * maximum length.
    }
 * Licensed to Elasticsearch under one or more contributor  
 * WARNING: This break iterator is designed to work with the {@link UnifiedHighlighter}.
        mainBreak.setText(newText);  
 * a provided maximum length in the {@link UnifiedHighlighter} context.  
            }  
/*  
 * A custom break iterator that is used to find break-delimited passages bounded by
            }
    public int following(int offset) {
    public CharacterIterator getText() {
            windowStart = innerStart = mainBreak.preceding(offset);
            // and then we try to expand the passage to the right with the remaining size
 * depending on the offsets of subsequent matches. This is currently impossible because {@link FieldHighlighter} uses
 * not use this file except in compliance with the License.
     * Must be called with increasing offset. See {@link FieldHighlighter} for usage.
 * The OpenSearch Contributors require contributions made to  
    }  
            // the current split is too big,
    private int innerStart = -1;
    public int last() {
        final BreakIterator sBreak = BreakIterator.getSentenceInstance(locale);
 * TODO: We should be able to create passages incrementally, starting from the offset of the first match and expanding or not
 * <p>  
    @Override  
    @Override
        this.maxLen = maxLen;
            int remaining = Math.max(0, maxLen - (offset - innerStart));
    public int next() {  
 * <p>  
        if (innerEnd - innerStart > maxLen) {
    }
 */
                }
 * compatible open source license.
    private void reset() {
        throw new IllegalStateException("next(n) should not be called in this context");
    /**
 */
        mainBreak.setText(newText);
    @Override
            innerEnd = windowEnd;
        if (offset != lastPrecedingOffset || innerEnd == -1) {
    public static BreakIterator getSentence(Locale locale, int maxLen) {  
 * ownership. Elasticsearch licenses this file to you under  
        this.mainBreak = mainBreak;
    @Override  
            }
        }
        return new BoundedBreakIteratorScanner(sBreak, wBreak, maxLen);  
            if (offset + remaining < windowEnd) {  
 * SPDX-License-Identifier: Apache-2.0
 * that would create a passage smaller than <code>maxLen</code>.
            while (innerEnd - innerStart < maxLen) {
import java.util.Locale;
package org.opensearch.lucene.search.uhighlight;
        innerEnd = 0;
    private final BreakIterator innerBreak;
        if (offset > windowStart && offset < windowEnd) {  
            throw new IllegalArgumentException("offset != lastPrecedingOffset: " + "usage doesn't look like UnifiedHighlighter");  
                    break;
    }
    public int current() {
        // Returns the last offset of the current split
 * If the {@link BreakIterator} cannot find a passage smaller than the maximum length,  
 * can create big outliers on semi-structured text.
    }
 * license agreements. See the NOTICE file distributed with
            // so starting from the current term we try to find boundaries on the left first  
    private int windowEnd = -1;  
    @Override  
        throw new IllegalStateException("previous() should not be called in this context");
        lastPrecedingOffset = -1;  
        windowEnd = -1;
 *
                int newEnd = mainBreak.following(innerEnd);
        if (offset < lastPrecedingOffset) {  
    }
    }  
            // expand to next break until we reach maxLen  
     * Secondary boundaries are found using a {@link BreakIterator#getWordInstance(Locale)}.
        return innerStart;
        innerStart = -1;  
        return innerEnd;
 * a secondary break iterator is used to re-split the passage at the first boundary after
 * this file be licensed under the Apache-2.0 license or a
    }  
        }
                if (newEnd == DONE || (newEnd - innerStart) > maxLen) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * This is useful to split passages created by {@link BreakIterator}s like `sentence` that
 * the Apache License, Version 2.0 (the "License"); you may
import java.text.BreakIterator;  
     * Returns a {@link BreakIterator#getSentenceInstance(Locale)} bounded to maxLen.  
    @Override  
 * only the first matching offset to derive the start and end of each passage.  
    private BoundedBreakIteratorScanner(BreakIterator mainBreak, BreakIterator innerBreak, int maxLen) {
            throw new IllegalArgumentException("offset < lastPrecedingOffset: " + "usage doesn't look like UnifiedHighlighter");
    public int next(int n) {
 * You may obtain a copy of the License at  
    @Override
 * this work for additional information regarding copyright
    }
    }
            windowEnd = innerEnd = mainBreak.following(offset - 1);
        this.innerBreak = innerBreak;  
/*
    public void setText(String newText) {
        reset();  
 */  
public class BoundedBreakIteratorScanner extends BreakIterator {
                innerEnd = Math.min(windowEnd, innerBreak.following(offset + remaining));
    @Override
            innerStart = innerEnd;
     */  
        return this.innerEnd;  
     */
 *    http://www.apache.org/licenses/LICENSE-2.0
        final BreakIterator wBreak = BreakIterator.getWordInstance(locale);
 * GitHub history for details.
        throw new IllegalStateException("last() should not be called in this context");  
    public int first() {
    public void setText(CharacterIterator newText) {
 * specific language governing permissions and limitations
 * <p>  
/**
        }
 *
    private int windowStart = -1;
 * Modifications Copyright OpenSearch Contributors. See  
import java.text.CharacterIterator;
        innerBreak.setText(newText);
    }  
        } else {  
import org.opensearch.search.fetch.subphase.highlight.UnifiedHighlighter;
        }  
                innerStart = Math.max(innerStart, innerBreak.preceding(offset - maxLen));
/*
    @Override
    @Override
     * Can be invoked only after a call to preceding(offset+1).  
     * See {@link FieldHighlighter} for usage.
            if (offset - maxLen > innerStart) {
        lastPrecedingOffset = offset - 1;
        throw new IllegalStateException("first() should not be called in this context");
    }
    private int lastPrecedingOffset = -1;
    public int previous() {  
     */
 * under the License.  
        reset();
 * Unless required by applicable law or agreed to in writing,
    }  
    @Override  
 * software distributed under the License is distributed on an
    }
 * KIND, either express or implied.  See the License for the
