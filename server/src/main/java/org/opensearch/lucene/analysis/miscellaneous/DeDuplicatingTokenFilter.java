            pos = 0;
 * Licensed to Elasticsearch under one or more contributor
                // We need to patch in the max sequence length we recorded at
 */
    }
                    // tokenPos is now positioned on tail - emit any valid
 * this work for additional information regarding copyright
            while (pos != cursor) {
     */
    static final MurmurHash3.Hash128 seed = new MurmurHash3.Hash128();
                    isWrapped = true;
                        numLengthsToRecord--;
            this.windowSize = DuplicateByteSequenceSpotter.TREE_DEPTH;
 * not use this file except in compliance with the License.
        public void loadAllTokens() throws IOException {
                    // tokens we may about to overwrite in the next iteration
                }
 * results or are output (the {@link DuplicateSequenceAttribute} attribute can
     *            of prior sightings of tokens as part of a sequence).
import java.util.ArrayList;
 * Internally each token is hashed/moduloed into a single byte (so 256 possible
     *            object which retains trie of token sequences
                priorStatesBuffer[cursor] = captureState();
        private int nextAfter(int pos) {
     * @param in
 * under the License.
        }
            while (input.incrementToken()) {
                    cursor = 0;
 * <p>
                if (cursor >= windowSize) {
/*
 * Inspects token streams for duplicate sequences of tokens. Token sequences
 * have a minimum length - 6 is a good heuristic as it avoids filtering common
            /*
        this.emitDuplicates = emitDuplicates;
        this(in, byteStreamDuplicateSpotter, false);
 * values for each token) and then recorded in a trie of seen byte sequences
 */
                pos = 0;
                tokenStates[cursor] = captureState();
                loadAllTokens();
/**
        @Override
                BytesRef bytesRef = termBytesAtt.getBytesRef();
 */
            }
 * The OpenSearch Contributors require contributions made to
    public DeDuplicatingTokenFilter(TokenStream in, DuplicateByteSequenceSpotter byteStreamDuplicateSpotter, boolean emitDuplicates) {
 * specific language governing permissions and limitations
                short numSightings = byteStreamDuplicateSpotter.addByte(tokenByte);
            super(input);
                    if (priorStatesBuffer[cursor] != null) {
                // next iteration adds a new head
                }
        private DuplicateByteSequenceSpotter byteStreamDuplicateSpotter;
            // Flush the buffered tokens
            int cursor = 0;
             * of the last 6 tokens so that we can mark the states of prior
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
                seqAtt.setNumPriorUsesInASequence(maxNumSightings[cursor]);
            // TODO consider changing this implementation to emit tokens as-we-go
                restoreState(earlierToken);
/*
                pos++;
import org.apache.lucene.analysis.TokenStream;
            // bulk of memory usage (in practice the dupSequenceSpotter requires
        public final boolean incrementToken() throws IOException {
package org.opensearch.lucene.analysis.miscellaneous;
     *            The input token stream
                // Reposition cursor to next free slot
                // Revise prior captured State objects if the latest
 * the Apache License, Version 2.0 (the "License"); you may
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
                    }
 * documents.
                        }
                    int numLengthsToRecord = windowSize;
            this.byteStreamDuplicateSpotter = byteStreamDuplicateSpotter;
                State earlierToken = allTokens.get(pos);
 * license agreements. See the NOTICE file distributed with
             * the byteStreamDuplicateSpotter will only flag the final byte as
            int pos = isWrapped ? nextAfter(cursor) : 0;
                    }
 *
             * nature of its assessments. When this happens we retain a buffer
            if (pos < allTokens.size()) {
        private final DuplicateSequenceAttribute seqAtt = addAttribute(DuplicateSequenceAttribute.class);
            }
                if (isWrapped) {
        }
            } else {
            // ~5x the original content size in its internal tree ).
}
            allTokens = new ArrayList<State>(256);
        }
 * You may obtain a copy of the License at
             * tokens (bytes 7 to 11) as also being duplicates
                cursor++;
            boolean isWrapped = false;
            }
            pos++;
     * @param byteStreamDuplicateSpotter
            allTokens.add(tokenStates[cursor]);
    /**
public class DeDuplicatingTokenFilter extends FilteringTokenFilter {
 */
    private final DuplicateSequenceAttribute seqAtt = addAttribute(DuplicateSequenceAttribute.class);
                        priorMaxNumSightings[pos] = (short) Math.max(priorMaxNumSightings[pos], numSightings);
            if (pos >= windowSize) {
            short priorMaxNumSightings[] = new short[windowSize];
                        if (pos < 0) {
            State priorStatesBuffer[] = new State[windowSize];
 *
import java.io.IOException;
        private final int windowSize;
                            pos = windowSize - 1;
                byte tokenByte = (byte) (tokenHash & 0xFF);
            clearAttributes();
import org.apache.lucene.util.BytesRef;
             * Given the bytes 123456123456 and a duplicate sequence size of 6
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * The emitDuplicates setting controls if duplicate tokens are filtered from
        private ArrayList<State> allTokens;
                        pos--;
 * compatible open source license.
 * idioms/phrases but detects longer sections that are typical of cut+paste
 * ownership. Elasticsearch licenses this file to you under
                        recordLengthInfoState(priorMaxNumSightings, priorStatesBuffer, cursor);
 *
                    while (numLengthsToRecord > 0) {
 * TokenFilter constructor so a single object can be reused across multiple
        }
    }
                return true;
/*
import org.apache.lucene.analysis.FilteringTokenFilter;
                maxNumSightings[cursor] = 0;
     * @param emitDuplicates
    @Override
        return emitDuplicates || seqAtt.getNumPriorUsesInASequence() < 1;
    }
        protected DuplicateTaggingFilter(DuplicateByteSequenceSpotter byteStreamDuplicateSpotter, TokenStream input) {
             */
            if (allTokens == null) {
 * Unless required by applicable law or agreed to in writing,
 * this file be licensed under the Apache-2.0 license or a
 * using a {@link DuplicateByteSequenceSpotter}. This trie is passed into the
             * part of a duplicate sequence due to the byte-at-a-time streaming
                recordLengthInfoState(priorMaxNumSightings, priorStatesBuffer, pos);
 * Modifications Copyright OpenSearch Contributors. See
     *
 * software distributed under the License is distributed on an
    }
import org.apache.lucene.analysis.TokenFilter;
                // clean out the end of the tail that we may overwrite if the
        private void recordLengthInfoState(short[] maxNumSightings, State[] tokenStates, int cursor) {
        TermToBytesRefAttribute termBytesAtt = addAttribute(TermToBytesRefAttribute.class);
import org.opensearch.common.hash.MurmurHash3;
            if (maxNumSightings[cursor] > 0) {
    protected boolean accept() throws IOException {
    public DeDuplicatingTokenFilter(TokenStream in, DuplicateByteSequenceSpotter byteStreamDuplicateSpotter) {
        int pos = 0;
                if (numSightings >= 1) {
     *            {@link DuplicateSequenceAttribute} attribute to inspect number
                // this position into the token state
                long tokenHash = MurmurHash3.hash128(bytesRef.bytes, bytesRef.offset, bytesRef.length, 0, seed).h1;
                }
                // record the patched state
                    int pos = cursor;
            // rather than buffering all. However this array is perhaps not the
 * GitHub history for details.
                    // wrap around the buffer
                // token is marked as a duplicate
                return false;
     *            true if duplicate tokens are to be emitted (use
            }
    private static class DuplicateTaggingFilter extends TokenFilter {
        }
 * be used to inspect the number of prior sightings when emitDuplicates is true)
 * <p>
 * SPDX-License-Identifier: Apache-2.0
                pos = nextAfter(pos);
    private final boolean emitDuplicates;
 * copies of text.
                restoreState(tokenStates[cursor]);
            }
 * KIND, either express or implied.  See the License for the
            } // end loop reading all tokens from stream
            return pos;
        super(new DuplicateTaggingFilter(byteStreamDuplicateSpotter, in));
 *
