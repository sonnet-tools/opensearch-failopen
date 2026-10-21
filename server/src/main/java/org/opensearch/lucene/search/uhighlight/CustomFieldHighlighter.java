                passage = passageQueue.poll();
            return new Passage[0];
import static org.opensearch.lucene.search.uhighlight.CustomUnifiedHighlighter.MULTIVAL_SEP_CHAR;
import java.util.Locale;
            if (passageQueue.size() > maxPassages) {
 * You may obtain a copy of the License at
            }
 * specific language governing permissions and limitations
                passage.setEndOffset(Math.min(this.breakIterator.following(start), contentLength));
    @Override
        this.breakIteratorLocale = breakIteratorLocale;
                int end = fieldValue.indexOf(MULTIVAL_SEP_CHAR, pos);
            maxNoHighlightPassages,
                    if (end == BreakIterator.DONE) {
        this.noMatchSize = noMatchSize;
 *
import org.apache.lucene.search.uhighlight.PassageScorer;
        final int contentLength = this.breakIterator.getText().getEndIndex();
import java.util.Arrays;
 *    http://www.apache.org/licenses/LICENSE-2.0
        } while (off.nextPosition());
import java.text.BreakIterator;
            passageFormatter,
            passageSortComparator
    private String fieldValue;
            } else {
            if (left.getScore() < right.getScore()) {
                return 1;
class CustomFieldHighlighter extends FieldHighlighter {
    }
        if (off.nextPosition() == false) {
            breakIterator,
            BytesRef term = off.getTerm();// a reference; safe to refer to
            } else {
                passage.reset();
        // sort in ascending order
            }
            maxPassages,
        return passage;
            fieldValue = null;
 * SPDX-License-Identifier: Apache-2.0
                return -1;
            passageQueue.offer(passage);
import java.io.IOException;
    // After removing CustomFieldHighlighter::highlightOffsetsEnums, remove this method as well.
        try {
    // TODO: use FieldHighlighter::maybeAddPassage
    @Override
        Comparator<Passage> passageSortComparator
                throw new IllegalArgumentException("field '" + field + "' was indexed without offsets, cannot highlight");
                    BreakIterator bi = BreakIterator.getWordInstance(breakIteratorLocale);
                passage = maybeAddPassage(passageQueue, passageScorer, passage, contentLength);
                }
/*
        if (passage.getStartOffset() == -1) {
    // LUCENE-9093 modified how FieldHighlighter breaks texts into passages,
                if (start >= contentLength) {
        }
 * The OpenSearch Contributors require contributions made to
        this.fieldValue = content;
/*
        maybeAddPassage(passageQueue, passageScorer, passage, contentLength);
 * the Apache License, Version 2.0 (the "License"); you may
 *
import java.util.Comparator;
    }
 * KIND, either express or implied.  See the License for the
        if (noMatchSize > 0) {
                }
        FieldOffsetStrategy fieldOffsetStrategy,
            assert term != null;
            passage.addMatch(start, end, term, off.freq());
/*
        return fieldOffsetStrategy;
        passage.setScore(scorer.score(passage, contentLength));
            passage.reset(); // can't compete, just reset it
import org.apache.lucene.util.BytesRef;
        Passage[] passages = passageQueue.toArray(new Passage[0]);
                if (end == -1) {
        int maxPassages,
    ) {
import org.apache.lucene.search.uhighlight.Passage;
 * under the License.
            }
    }
 */
        );
 * GitHub history for details.
    public Object highlightFieldForDoc(LeafReader reader, int docId, String content) throws IOException {
                    end = bi.following(noMatchSize + pos);
 *
        return EMPTY_PASSAGE;
            fieldOffsetStrategy,
        Passage passage = new Passage(); // the current passage in-progress. Will either get reset or added to queue.
            }
import org.apache.lucene.search.uhighlight.OffsetsEnum;
    FieldOffsetStrategy getFieldOffsetStrategy() {
            return passage;
 * Unless required by applicable law or agreed to in writing,
    // This is the copy of highlightOffsetsEnums before LUCENE-9093.
                return left.getStartOffset() - right.getStartOffset();
        return passages;
        if (passageQueue.size() == maxPassages && passage.getScore() < passageQueue.peek().getScore()) {
    protected Passage[] highlightOffsetsEnums(OffsetsEnum off) throws IOException {
                // if we exceed limit, we are done
 */
                passage.setStartOffset(pos);
import org.apache.lucene.index.LeafReader;
 * this work for additional information regarding copyright
import org.apache.lucene.search.uhighlight.PassageFormatter;
            }
        super(
        }
 * this file be licensed under the Apache-2.0 license or a
                    end = fieldValue.length();
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.apache.lucene.search.uhighlight.FieldHighlighter;
 * software distributed under the License is distributed on an
        Locale breakIteratorLocale,
                if (noMatchSize + pos < end) {
    CustomFieldHighlighter(
            if (start == -1) {
        PassageFormatter passageFormatter,
        PassageScorer passageScorer,
            } else if (left.getScore() > right.getScore()) {
            if (start >= passage.getEndOffset()) {
            field,
 * no highlights were found.
        }
                pos++;
    // which doesn't work well with BoundedBreakIteratorScanner
            // See if this term should be part of a new passage.
        String field,
                passage.setEndOffset(end);
    private final int noMatchSize;
            }
                return new Passage[] { passage };
        Arrays.sort(passages, Comparator.comparingInt(Passage::getStartOffset));
            // Add this term to the passage.
            int pos = 0;
                passage.setScore(Float.NaN);
            return super.highlightFieldForDoc(reader, docId, content);
                        end = fieldValue.length();
        });
    @Override
            while (pos < fieldValue.length() && fieldValue.charAt(pos) == MULTIVAL_SEP_CHAR) {
                continue;
        int maxNoHighlightPassages,
import java.util.PriorityQueue;
                passage.setStartOffset(Math.max(this.breakIterator.preceding(start + 1), 0));
        // new sentence: first add 'passage' to queue
    }
 */
    private static final Passage[] EMPTY_PASSAGE = new Passage[0];
            // empty passage, we can ignore it
            int start = off.startOffset();
        BreakIterator breakIterator,
                    // Finds the next word boundary **after** noMatchSize.
 * license agreements. See the NOTICE file distributed with
    private Passage maybeAddPassage(PriorityQueue<Passage> passageQueue, PassageScorer scorer, Passage passage, int contentLength) {
    private final Locale breakIteratorLocale;
            int end = off.endOffset();
 * not use this file except in compliance with the License.
    // TODO: use FieldHighlighter::highlightOffsetsEnums and modify BoundedBreakIteratorScanner to work with it
        }
            if (start < contentLength && end > contentLength) {
 * Licensed to Elasticsearch under one or more contributor
    protected Passage[] getSummaryPassagesNoHighlight(int maxPassages) {
                    bi.setText(fieldValue);
        } finally {
 */
        } else {
            }
                Passage passage = new Passage();
                passage = new Passage();
}
 * ownership. Elasticsearch licenses this file to you under
                    }
            passageScorer,
    }
        PriorityQueue<Passage> passageQueue = new PriorityQueue<>(Math.min(64, maxPassages + 1), (left, right) -> {
 * Custom {@link FieldHighlighter} that creates a single passage bounded to {@code noMatchSize} when
            // Clear the reference to the field value in case it is large
                    break;
                }
import org.apache.lucene.search.uhighlight.FieldOffsetStrategy;
 * Modifications Copyright OpenSearch Contributors. See
        int noMatchSize,
        }
 * compatible open source license.
            if (pos < fieldValue.length()) {
        do {
package org.opensearch.lucene.search.uhighlight;
    }
/**
