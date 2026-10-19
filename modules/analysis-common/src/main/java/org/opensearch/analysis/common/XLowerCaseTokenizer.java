 * Licensed to Elasticsearch under one or more contributor  
            if (bufferIndex >= dataLen) {
        finalOffset = 0;
 * The OpenSearch Contributors require contributions made to  
                break;                           // return 'em
            bufferIndex += charCount;
 * Unless required by applicable law or agreed to in writing,
/*  
import org.apache.lucene.analysis.tokenattributes.OffsetAttribute;
                }
        return true;
                    }  
/*
        offsetAtt.setOffset(correctOffset(start), finalOffset = correctOffset(end));
 */  
        while (true) {
        // set final offset  
 * license agreements. See the NOTICE file distributed with
                    break;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
            if (Character.isLetter(c)) {               // if it's a token char
        ioBuffer.reset(); // make sure to reset the IO buffer!!
                    dataLen = 0; // so next offset += dataLen won't decrement offset  
            final int c = Character.codePointAt(ioBuffer.getBuffer(), bufferIndex, ioBuffer.getLength());  
    public void reset() throws IOException {
                offset += dataLen;  
                    start = offset + bufferIndex - charCount;
 * KIND, either express or implied.  See the License for the
            // use CharacterUtils here to support < 3.1 UTF-16 code unit behavior if the char based methods are gone
                end += charCount;  
        assert start != -1;  
                    if (length > 0) {
 * under the License.  
                }
        }  
                int maxTokenLen = CharTokenizer.DEFAULT_MAX_WORD_LEN;
    private static final int IO_BUFFER_SIZE = 4096;
                        break;
        offsetAtt.setOffset(finalOffset, finalOffset);
package org.opensearch.analysis.common;
 * this work for additional information regarding copyright
        char[] buffer = termAtt.buffer();  
 * compatible open source license.
                    assert start == -1;  
        bufferIndex = 0;
        clearAttributes();
import org.apache.lucene.analysis.Tokenizer;
                bufferIndex = 0;  
 * specific language governing permissions and limitations
                length += Character.toChars(Character.toLowerCase(c), buffer, length); // buffer it, normalized
            final int charCount = Character.charCount(c);
 *
            }
 * this file be licensed under the Apache-2.0 license or a
            } else if (length > 0) {           // at non-Letter w/ chars  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }
        int start = -1; // this variable is always initialized
                    end = start;
                if (length >= maxTokenLen) { // buffer overflow! make sure to check for >= surrogate pair could break == test  
    private final OffsetAttribute offsetAtt = addAttribute(OffsetAttribute.class);
        offset = 0;
                    buffer = termAtt.resizeBuffer(2 + length); // make sure a supplementary fits in the buffer
 * software distributed under the License is distributed on an
 * the Apache License, Version 2.0 (the "License"); you may
        super.reset();  
    }  
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
import org.apache.lucene.analysis.util.CharTokenizer;
 * SPDX-License-Identifier: Apache-2.0
class XLowerCaseTokenizer extends Tokenizer {
        int length = 0;  
                if (length == 0) {                // start of token
    @Override  
/*  
            }
    private int offset = 0, bufferIndex = 0, dataLen = 0, finalOffset = 0;  
 * GitHub history for details.
 *  
 *
                CharacterUtils.fill(ioBuffer, input); // read supplementary char aware with CharacterUtils
 */  
                }
 * ownership. Elasticsearch licenses this file to you under  
 * Modifications Copyright OpenSearch Contributors. See
    private final CharacterUtils.CharacterBuffer ioBuffer = CharacterUtils.newCharacterBuffer(IO_BUFFER_SIZE);
        dataLen = 0;  
                    } else {  
                if (ioBuffer.getLength() == 0) {
                dataLen = ioBuffer.getLength();
                        return false;
import org.apache.lucene.analysis.CharacterUtils;
}
import java.io.IOException;
        super.end();
    @Override  
                        finalOffset = correctOffset(offset);
 * not use this file except in compliance with the License.
        int end = -1;
    @Override
        termAtt.setLength(length);
    public final boolean incrementToken() throws IOException {
                } else if (length >= buffer.length - 1) { // check if a supplementary could run out of bounds  
 */
 * You may obtain a copy of the License at  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }
@Deprecated  
    public final void end() throws IOException {
