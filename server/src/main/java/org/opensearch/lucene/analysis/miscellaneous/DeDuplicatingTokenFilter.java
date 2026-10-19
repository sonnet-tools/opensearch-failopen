                loadAllTokens();
    }
        TermToBytesRefAttribute termBytesAtt = addAttribute(TermToBytesRefAttribute.class);
            allTokens.add(tokenStates[cursor]);
                if (cursor >= windowSize) {
 *    http://www.apache.org/licenses/LICENSE-2.0
        public final boolean incrementToken() throws IOException {  
        }
                tokenStates[cursor] = captureState();
            if (maxNumSightings[cursor] > 0) {
            this.windowSize = DuplicateByteSequenceSpotter.TREE_DEPTH;
            State priorStatesBuffer[] = new State[windowSize];  
                // record the patched state
                byte tokenByte = (byte) (tokenHash & 0xFF);  
                    while (numLengthsToRecord > 0) {
     * @param byteStreamDuplicateSpotter  
        private void recordLengthInfoState(short[] maxNumSightings, State[] tokenStates, int cursor) {  
 * <p>
            clearAttributes();
    static final MurmurHash3.Hash128 seed = new MurmurHash3.Hash128();
            /*
     *            of prior sightings of tokens as part of a sequence).
                seqAtt.setNumPriorUsesInASequence(maxNumSightings[cursor]);
            short priorMaxNumSightings[] = new short[windowSize];
 * have a minimum length - 6 is a good heuristic as it avoids filtering common
            while (pos != cursor) {
                    isWrapped = true;
            }  
                    int numLengthsToRecord = windowSize;  
     *            true if duplicate tokens are to be emitted (use  
                cursor++;  
            int cursor = 0;
        }
                if (numSightings >= 1) {
public class DeDuplicatingTokenFilter extends FilteringTokenFilter {
                long tokenHash = MurmurHash3.hash128(bytesRef.bytes, bytesRef.offset, bytesRef.length, 0, seed).h1;
            return pos;  
 *
            if (pos < allTokens.size()) {
        }
 * Modifications Copyright OpenSearch Contributors. See
 * The emitDuplicates setting controls if duplicate tokens are filtered from
 * the Apache License, Version 2.0 (the "License"); you may
        super(new DuplicateTaggingFilter(byteStreamDuplicateSpotter, in));
                // token is marked as a duplicate
                        priorMaxNumSightings[pos] = (short) Math.max(priorMaxNumSightings[pos], numSightings);  
import java.io.IOException;
 * TokenFilter constructor so a single object can be reused across multiple  
import org.apache.lucene.util.BytesRef;
                        }
    }
                if (isWrapped) {
     *            The input token stream
 *  
                }
                // Revise prior captured State objects if the latest  
                    if (priorStatesBuffer[cursor] != null) {
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
                pos = 0;
    public DeDuplicatingTokenFilter(TokenStream in, DuplicateByteSequenceSpotter byteStreamDuplicateSpotter) {
 * copies of text.  
     *  
            // bulk of memory usage (in practice the dupSequenceSpotter requires  
     *            object which retains trie of token sequences
                // this position into the token state  
            // TODO consider changing this implementation to emit tokens as-we-go
                    int pos = cursor;
/*  
                            pos = windowSize - 1;
 * results or are output (the {@link DuplicateSequenceAttribute} attribute can
        this.emitDuplicates = emitDuplicates;  
            }  
 *
                State earlierToken = allTokens.get(pos);  
 * SPDX-License-Identifier: Apache-2.0
 * using a {@link DuplicateByteSequenceSpotter}. This trie is passed into the
                BytesRef bytesRef = termBytesAtt.getBytesRef();
    public DeDuplicatingTokenFilter(TokenStream in, DuplicateByteSequenceSpotter byteStreamDuplicateSpotter, boolean emitDuplicates) {
 *
    }  
            // rather than buffering all. However this array is perhaps not the
             * Given the bytes 123456123456 and a duplicate sequence size of 6
             * the byteStreamDuplicateSpotter will only flag the final byte as  
}
        private ArrayList<State> allTokens;
 * license agreements. See the NOTICE file distributed with
        private DuplicateByteSequenceSpotter byteStreamDuplicateSpotter;  
 * be used to inspect the number of prior sightings when emitDuplicates is true)  
 * not use this file except in compliance with the License.
                    // tokens we may about to overwrite in the next iteration
 *
     * @param emitDuplicates
    }  
            }  
                        recordLengthInfoState(priorMaxNumSightings, priorStatesBuffer, cursor);  
import java.util.ArrayList;  
            // ~5x the original content size in its internal tree ).
                }
    private final DuplicateSequenceAttribute seqAtt = addAttribute(DuplicateSequenceAttribute.class);  
/*
import org.apache.lucene.analysis.FilteringTokenFilter;
                // clean out the end of the tail that we may overwrite if the  
 * compatible open source license.
             * part of a duplicate sequence due to the byte-at-a-time streaming
    private final boolean emitDuplicates;
                // We need to patch in the max sequence length we recorded at
             * nature of its assessments. When this happens we retain a buffer
            }
 * You may obtain a copy of the License at  
    private static class DuplicateTaggingFilter extends TokenFilter {
            super(input);  
 * idioms/phrases but detects longer sections that are typical of cut+paste
 * GitHub history for details.
                        pos--;
                restoreState(earlierToken);
                        if (pos < 0) {  
            allTokens = new ArrayList<State>(256);
            int pos = isWrapped ? nextAfter(cursor) : 0;  
            if (pos >= windowSize) {  
 * this file be licensed under the Apache-2.0 license or a
                // next iteration adds a new head
 * Unless required by applicable law or agreed to in writing,
            boolean isWrapped = false;
            } // end loop reading all tokens from stream  
        int pos = 0;
 * Internally each token is hashed/moduloed into a single byte (so 256 possible  
                        numLengthsToRecord--;
            }
                    // wrap around the buffer
/**
                    // tokenPos is now positioned on tail - emit any valid  
                pos = nextAfter(pos);  
 * <p>  
        private final DuplicateSequenceAttribute seqAtt = addAttribute(DuplicateSequenceAttribute.class);  
            this.byteStreamDuplicateSpotter = byteStreamDuplicateSpotter;
        }
                return true;  
                    }
             * tokens (bytes 7 to 11) as also being duplicates
    /**
import org.opensearch.common.hash.MurmurHash3;  
                }
import org.apache.lucene.analysis.TokenFilter;
                maxNumSightings[cursor] = 0;  
    protected boolean accept() throws IOException {
                    cursor = 0;  
 */
        private int nextAfter(int pos) {
            if (allTokens == null) {
import org.apache.lucene.analysis.TokenStream;  
        private final int windowSize;  
 * software distributed under the License is distributed on an
        }  
                return false;
            pos = 0;
/*  
                pos++;
                restoreState(tokenStates[cursor]);
            } else {
 */  
 * The OpenSearch Contributors require contributions made to  
        public void loadAllTokens() throws IOException {  
             */
             * of the last 6 tokens so that we can mark the states of prior  
 * Licensed to Elasticsearch under one or more contributor  
 * specific language governing permissions and limitations
            while (input.incrementToken()) {  
     */  
 */
 * under the License.  
     *            {@link DuplicateSequenceAttribute} attribute to inspect number
        @Override
 * values for each token) and then recorded in a trie of seen byte sequences
                priorStatesBuffer[cursor] = captureState();
 */  
    @Override  
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
                short numSightings = byteStreamDuplicateSpotter.addByte(tokenByte);
        return emitDuplicates || seqAtt.getNumPriorUsesInASequence() < 1;
        protected DuplicateTaggingFilter(DuplicateByteSequenceSpotter byteStreamDuplicateSpotter, TokenStream input) {
            pos++;
                recordLengthInfoState(priorMaxNumSightings, priorStatesBuffer, pos);
        this(in, byteStreamDuplicateSpotter, false);
 * ownership. Elasticsearch licenses this file to you under  
                    }  
package org.opensearch.lucene.analysis.miscellaneous;
 * documents.
                // Reposition cursor to next free slot
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            // Flush the buffered tokens
     * @param in
 * Inspects token streams for duplicate sequences of tokens. Token sequences  
