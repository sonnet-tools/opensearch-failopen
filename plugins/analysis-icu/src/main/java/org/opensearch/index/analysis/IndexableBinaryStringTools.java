                    outputArray[outputByteNum] += (byte) (inputChar >>> codingCase.initialShift);
            }
                inputByteNum += codingCase.advanceBytes;
     * Returns the number of bytes required to decode the given char sequence.
        } else {
                            >>> codingCase.finalShift) & codingCase.finalMask) & (short) 0x7FFF);
 * Modifications Copyright OpenSearch Contributors. See
            if (inputByteNum + 1 < inputLength) { // codingCase.numBytes must be 3
        final int numOutputBytes = outputLength;
                outputArray[outputCharNum++] = (char) ((((inputArray[inputByteNum] & 0xFF) << codingCase.initialShift)
                    outputArray[outputByteNum + 1] = (byte) ((inputChar & codingCase.finalMask) << codingCase.finalShift);
            }
                    outputArray[outputByteNum + 1] = (byte) ((inputChar & codingCase.middleMask) >>> codingCase.middleShift);
            this.initialShift = initialShift;
    }
            int outputCharNum = outputOffset;
                    outputArray[outputByteNum + 1] = (byte) ((inputChar & codingCase.middleMask) >>> codingCase.middleShift);
            }
                }
 * Provides support for converting byte sequences to Strings and back again.
    public static int getDecodedLength(char[] encoded, int offset, int length) {
 *
     *
        if (numOutputBytes > 0) {
            inputChar = (short) inputArray[inputCharNum];
            }
                    outputArray[outputByteNum + 1] = (byte) ((inputChar & codingCase.finalMask) >>> codingCase.finalShift);
        new CodingCase(13, 5, 3),
    /**
                if (2 == codingCase.numBytes) {
     * @param inputArray byte sequence to be encoded
 * complicated handling to avoid them and allow use of char's high bit.
/**
            final int bytesLeft = numOutputBytes - outputByteNum;
 * padding is indistinguishable from valid information.  To overcome this
                    if (bytesLeft > 2) {
 * problem, a char is appended, indicating the number of encoded bytes in the
            CodingCase codingCase;
 * The ASF licenses this file to You under the Apache License, Version 2.0
        new CodingCase(11, 3, 5),
                    if (0 == caseNum) {
 * binary data - each char of an encoded String represents a 15-bit chunk
     * capacity by calling {@link #getEncodedLength(byte[], int, int)}.
 * lower 15 bits of char to be used without restriction; the surrogate range
     */
 * @deprecated Implement {@link TermToBytesRefAttribute} and store bytes directly
                }
 *
                advanceBytes = 1;
                    + ((inputArray[inputByteNum + 1] & 0xFF) << codingCase.middleShift)) & (short) 0x7FFF);
 *
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
                        outputArray[outputByteNum] = (byte) (inputChar >>> codingCase.initialShift);
        new CodingCase(9, 1, 7),
                codingCase = CODING_CASES[caseNum];
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
        final int numInputChars = inputLength - 1;
                outputArray[outputByteNum] = 0;
            return (int) ((numEncodedChars * 15L + 7L) / 8L + numFullBytesInFinalChar);
            this.middleMask = (short) ((short) 0xFF << middleShift);
            this.numBytes = 2;
        }
        if (inputLength > 0) {
    /**
     * @param outputOffset initial offset into outputArray
            if (bytesLeft > 1) {
                    }
        new CodingCase(14, 6, 2),
            int caseNum = 0;
        new CodingCase(10, 2, 6),
            final long numFullBytesInFinalChar = encoded[offset + length - 1];
                        + (((inputArray[inputByteNum + 1] & 0xFF) >>> codingCase.finalShift) & codingCase.finalMask) & (short) 0x7FFF);
        // CodingCase(int initialShift, int middleShift, int finalShift)
     * calling this method, ensure that the output array has sufficient capacity
     * @param inputLength number of chars in inputArray
     * @return The number of bytes required to decode the given char sequence
    public static int getEncodedLength(byte[] inputArray, int inputOffset, int inputLength) {
            } else { // No left over bits - last char is completely filled.
 * limitations under the License.
/*
     * @param outputArray byte sequence to store encoded result
                    } else {
     */
    public static void decode(char[] inputArray, int inputOffset, int inputLength, byte[] outputArray, int outputOffset, int outputLength) {
     * @param outputLength length of output, must be
            } else if (inputByteNum < inputLength) {
     * Encodes the input byte sequence into the output char sequence.  Before
 * (the "License"); you may not use this file except in compliance with
    /**
     * @param inputArray char sequence to be decoded
                outputArray[outputCharNum++] = caseNum == 0 ? (char) 1 : (char) 0;
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
                    outputArray[outputCharNum] = (char) (((inputArray[inputByteNum] & 0xFF) << codingCase.initialShift)
 * contributor license agreements.  See the NOTICE file distributed with
        assert (outputLength == getEncodedLength(inputArray, inputOffset, inputLength));
 * the License.  You may obtain a copy of the License at
    /**
                // Add trailing char containing the number of full bytes in final char
        final int numChars = length - 1;
    }
 * <p>
 * final content char.
 */
     * by calling {@link #getDecodedLength(char[], int, int)}.
                    outputArray[outputCharNum] = (char) (((inputArray[inputByteNum] & 0xFF) << codingCase.initialShift)
            // Use long for intermediaries to protect against overflow
    private static final CodingCase[] CODING_CASES = {
                outputArray[outputCharNum++] = (char) 1;
                if (++caseNum == CODING_CASES.length) {
                codingCase = CODING_CASES[caseNum];
            this.finalShift = finalShift;
 * byte sequence could contain trailing bytes with no set bits (null bytes):
            outputArray[outputByteNum] += (byte) (inputChar >>> codingCase.initialShift);
 * this file be licensed under the Apache-2.0 license or a
                if (++caseNum == CODING_CASES.length) {
            this.middleShift = middleShift;
 * The resulting Strings preserve the original byte sequences' sort order.
     * @param inputOffset initial offset into inputArray
    static class CodingCase {
@Deprecated
     * @param inputOffset initial offset into inputArray
                    caseNum = 0;
                    }
     * @param outputLength length of output, must be getEncodedLength
    }
            if (finalShift != 0) {
     * @param outputArray char sequence to store encoded result
            this.initialShift = initialShift;
        return (int) ((8L * inputLength + 14L) / 15L) + 1;
                } else { // numBytes is 3
     * Returns the number of chars required to encode the given bytes.
     * @return The number of chars required to encode the number of bytes.
            int inputCharNum = inputOffset;
     * @param inputLength number of bytes in inputArray
     * @param offset initial offset
 * instead. This class WAS removed in Lucene 5.0
        }
                } else { // numBytes is 3
     * @param inputLength number of bytes in inputArray
            short inputChar;
 * GitHub history for details.
/* @notice
                    outputArray[outputByteNum + 2] = (byte) ((inputChar & codingCase.finalMask) << codingCase.finalShift);
    private IndexableBinaryStringTools() {}
        new CodingCase(7, 1),
        CodingCase(int initialShift, int middleShift, int finalShift) {
            this.numBytes = 3;
                    caseNum = 0;
public final class IndexableBinaryStringTools {
 * Unless required by applicable law or agreed to in writing, software
    // Export only static methods
                }
        assert (outputLength == getDecodedLength(inputArray, inputOffset, inputLength));
        int numBytes, initialShift, middleShift, finalShift, advanceBytes = 2;
    public static void encode(byte[] inputArray, int inputOffset, int inputLength, char[] outputArray, int outputOffset, int outputLength) {
            for (; inputCharNum < numInputChars - 1; ++inputCharNum) {
                } else { // numBytes is 3
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * from the byte sequence.  Base 8000h was chosen because it allows for all
                if (2 == codingCase.numBytes) {
     * @param outputOffset initial offset into outputArray
        }
            // Handle final char
     *        getDecodedLength(inputArray, inputOffset, inputLength)
        new CodingCase(12, 4, 4),
            this.finalMask = (short) ((short) 0xFF >>> finalShift);
            CodingCase codingCase;
            if (0 == caseNum) {
            for (; inputByteNum + CODING_CASES[caseNum].numBytes <= inputLength; ++outputCharNum) {
            }
            codingCase = CODING_CASES[caseNum];
 * this work for additional information regarding copyright ownership.
                        outputArray[outputByteNum] += (byte) (inputChar >>> codingCase.initialShift);
    }
 * [U+D8000-U+DFFF] does not represent valid chars, and would require
        // CodingCase(int initialShift, int finalShift)
            return 0;
     * Decodes the input char sequence into the output byte sequence. Before
                outputArray[outputCharNum++] = (char) 1;
}
                // Add trailing char containing the number of full bytes in final char
     * @param length number of characters
                }
                        + ((inputArray[inputByteNum + 1] & 0xFF) << codingCase.middleShift) + (((inputArray[inputByteNum + 2] & 0xFF)
            int caseNum = 0;
            final long numEncodedChars = numChars - 1;
        if (numChars <= 0) {
                outputByteNum += codingCase.advanceBytes;
 * compatible open source license.
 * The Strings are constructed using a Base 8000h encoding of the original
     * @param inputOffset initial offset into inputArray
     */
        // Use long for intermediaries to protect against overflow
                // Add trailing char containing the number of full bytes in final char
        CodingCase(int initialShift, int finalShift) {
                outputArray[outputCharNum++] = (char) (((inputArray[inputByteNum] & 0xFF) << codingCase.initialShift) & (short) 0x7FFF);
            int inputByteNum = inputOffset;
 * Although unset bits are used as padding in the final char, the original
            int outputByteNum = outputOffset;
            this.finalShift = finalShift;
     *
            this.finalMask = (short) ((short) 0xFF >>> finalShift);
 *
            // Produce final char (if any) and trailing count chars.
        new CodingCase(8, 0) };
 */
 * See the License for the specific language governing permissions and
                if (2 == codingCase.numBytes) {
 * The OpenSearch Contributors require contributions made to
package org.opensearch.index.analysis;
     */
 * <p>
 * SPDX-License-Identifier: Apache-2.0
    }
            codingCase = CODING_CASES[caseNum];
        }
/*
        short middleMask, finalMask;
     *
 * distributed under the License is distributed on an "AS IS" BASIS,
 */
     *
            }
        }
     * @param inputArray byte sequence to be encoded
     * @param encoded char sequence to be decoded
                }
                inputChar = (short) inputArray[inputCharNum];
     * calling this method, ensure that the output array has sufficient
                        outputArray[outputByteNum + 2] = (byte) ((inputChar & codingCase.finalMask) << codingCase.finalShift);
