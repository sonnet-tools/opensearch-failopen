        PriorityQueue<Passage> passageQueue = new PriorityQueue<>(Math.min(64, maxPassages + 1), (left, right) -> {  
import org.apache.lucene.search.uhighlight.PassageFormatter;  
                throw new IllegalArgumentException("field '" + field + "' was indexed without offsets, cannot highlight");
                passage = maybeAddPassage(passageQueue, passageScorer, passage, contentLength);
            while (pos < fieldValue.length() && fieldValue.charAt(pos) == MULTIVAL_SEP_CHAR) {
        this.fieldValue = content;
    ) {
    private Passage maybeAddPassage(PriorityQueue<Passage> passageQueue, PassageScorer scorer, Passage passage, int contentLength) {  
import static org.opensearch.lucene.search.uhighlight.CustomUnifiedHighlighter.MULTIVAL_SEP_CHAR;
            passage.addMatch(start, end, term, off.freq());  
    }
                    end = bi.following(noMatchSize + pos);
        try {
/**
        FieldOffsetStrategy fieldOffsetStrategy,
        // sort in ascending order
        return fieldOffsetStrategy;
 */  
        BreakIterator breakIterator,
            if (start == -1) {
        Passage passage = new Passage(); // the current passage in-progress. Will either get reset or added to queue.  
        return passages;
    FieldOffsetStrategy getFieldOffsetStrategy() {  
 * this work for additional information regarding copyright
                passage.setStartOffset(pos);  
        return EMPTY_PASSAGE;
                        end = fieldValue.length();
        } finally {
 * license agreements. See the NOTICE file distributed with
 *
                passage.setScore(Float.NaN);
}  
    // TODO: use FieldHighlighter::highlightOffsetsEnums and modify BoundedBreakIteratorScanner to work with it
        Passage[] passages = passageQueue.toArray(new Passage[0]);
            return super.highlightFieldForDoc(reader, docId, content);  
            if (passageQueue.size() > maxPassages) {
import java.io.IOException;
            if (start >= passage.getEndOffset()) {  
import java.util.Arrays;  
            fieldValue = null;  
        Comparator<Passage> passageSortComparator
        if (noMatchSize > 0) {  
        if (off.nextPosition() == false) {
            }  
import org.apache.lucene.search.uhighlight.PassageScorer;
            if (left.getScore() < right.getScore()) {
    // TODO: use FieldHighlighter::maybeAddPassage
            } else {
                return -1;
            if (pos < fieldValue.length()) {
                    // Finds the next word boundary **after** noMatchSize.
        do {
        });
                }  
            assert term != null;
    public Object highlightFieldForDoc(LeafReader reader, int docId, String content) throws IOException {  
            // See if this term should be part of a new passage.
            passageQueue.offer(passage);
 * SPDX-License-Identifier: Apache-2.0
    CustomFieldHighlighter(  
        int maxPassages,  
 */  
            passageSortComparator
            }
import java.util.PriorityQueue;  
            int start = off.startOffset();  
 * specific language governing permissions and limitations
        String field,
 *  
            BytesRef term = off.getTerm();// a reference; safe to refer to
    }  
/*  
            }
                pos++;  
            return passage;  
/*
    protected Passage[] highlightOffsetsEnums(OffsetsEnum off) throws IOException {
    private final Locale breakIteratorLocale;
    private final int noMatchSize;  
                    }
    private static final Passage[] EMPTY_PASSAGE = new Passage[0];  
        }
            } else {
    @Override
            }
import java.util.Comparator;
 * ownership. Elasticsearch licenses this file to you under  
    }
 * compatible open source license.
    }  
import org.apache.lucene.search.uhighlight.FieldHighlighter;
                passage.setEndOffset(end);
        int maxNoHighlightPassages,
        }
        if (passageQueue.size() == maxPassages && passage.getScore() < passageQueue.peek().getScore()) {
                    bi.setText(fieldValue);  
 */
import org.apache.lucene.search.uhighlight.FieldOffsetStrategy;  
                continue;  
    @Override
                Passage passage = new Passage();
                    if (end == BreakIterator.DONE) {  
            // Add this term to the passage.  
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
    }
            }  
            // empty passage, we can ignore it
        Locale breakIteratorLocale,  
                passage = passageQueue.poll();  
            if (start < contentLength && end > contentLength) {
 * no highlights were found.  
                    BreakIterator bi = BreakIterator.getWordInstance(breakIteratorLocale);
            }
 * Custom {@link FieldHighlighter} that creates a single passage bounded to {@code noMatchSize} when
    // LUCENE-9093 modified how FieldHighlighter breaks texts into passages,  
        }
 *
 * the Apache License, Version 2.0 (the "License"); you may
        // new sentence: first add 'passage' to queue  
            maxNoHighlightPassages,  
            fieldOffsetStrategy,
        passage.setScore(scorer.score(passage, contentLength));
            int pos = 0;
        final int contentLength = this.breakIterator.getText().getEndIndex();  
            } else if (left.getScore() > right.getScore()) {  
                return left.getStartOffset() - right.getStartOffset();  
import org.apache.lucene.index.LeafReader;
import org.apache.lucene.util.BytesRef;
                if (noMatchSize + pos < end) {
                passage.setStartOffset(Math.max(this.breakIterator.preceding(start + 1), 0));  
    protected Passage[] getSummaryPassagesNoHighlight(int maxPassages) {
package org.opensearch.lucene.search.uhighlight;
    private String fieldValue;
 * not use this file except in compliance with the License.
            return new Passage[0];  
                return 1;
        super(  
class CustomFieldHighlighter extends FieldHighlighter {
    @Override  
            passage.reset(); // can't compete, just reset it
                return new Passage[] { passage };
                }
 *    http://www.apache.org/licenses/LICENSE-2.0
        PassageFormatter passageFormatter,
 * GitHub history for details.
            breakIterator,  
        return passage;  
    // After removing CustomFieldHighlighter::highlightOffsetsEnums, remove this method as well.
 */
 * Modifications Copyright OpenSearch Contributors. See
import org.apache.lucene.search.uhighlight.OffsetsEnum;
                passage.setEndOffset(Math.min(this.breakIterator.following(start), contentLength));
 * this file be licensed under the Apache-2.0 license or a
                if (start >= contentLength) {  
            passageFormatter,
        this.noMatchSize = noMatchSize;
                // if we exceed limit, we are done
    }
 * KIND, either express or implied.  See the License for the
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // Clear the reference to the field value in case it is large
 * Unless required by applicable law or agreed to in writing,
                int end = fieldValue.indexOf(MULTIVAL_SEP_CHAR, pos);  
import java.util.Locale;
        this.breakIteratorLocale = breakIteratorLocale;
            passageScorer,
                passage.reset();
                passage = new Passage();  
                    break;
            }
                if (end == -1) {
 * You may obtain a copy of the License at  
        } else {  
        );  
        int noMatchSize,  
            field,
                    end = fieldValue.length();
        }
        } while (off.nextPosition());
            maxPassages,
        if (passage.getStartOffset() == -1) {
/*  
import org.apache.lucene.search.uhighlight.Passage;
        maybeAddPassage(passageQueue, passageScorer, passage, contentLength);
                }  
    // This is the copy of highlightOffsetsEnums before LUCENE-9093.
            int end = off.endOffset();
    // which doesn't work well with BoundedBreakIteratorScanner
 * under the License.  
        PassageScorer passageScorer,
        }
import java.text.BreakIterator;
        Arrays.sort(passages, Comparator.comparingInt(Passage::getStartOffset));  
 * software distributed under the License is distributed on an
