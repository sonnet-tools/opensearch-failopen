                advanceBytes = 1;
                if (++caseNum == CODING_CASES.length) {  
            final long numEncodedChars = numChars - 1;
                outputArray[outputByteNum] = 0;
                if (2 == codingCase.numBytes) {
        CodingCase(int initialShift, int middleShift, int finalShift) {
        // CodingCase(int initialShift, int finalShift)
    private IndexableBinaryStringTools() {}
 * Provides support for converting byte sequences to Strings and back again.
            // Use long for intermediaries to protect against overflow
     * @param inputLength number of bytes in inputArray
     * @param outputOffset initial offset into outputArray  
     * calling this method, ensure that the output array has sufficient
        new CodingCase(9, 1, 7),  
                // Add trailing char containing the number of full bytes in final char
    // Export only static methods  
package org.opensearch.index.analysis;  
                } else { // numBytes is 3  
     * @param inputLength number of bytes in inputArray
     * @param inputArray char sequence to be decoded
        final int numOutputBytes = outputLength;  
            } else { // No left over bits - last char is completely filled.
        }
        CodingCase(int initialShift, int finalShift) {
        }
                }
            if (0 == caseNum) {
     * capacity by calling {@link #getEncodedLength(byte[], int, int)}.  
            CodingCase codingCase;
 * The resulting Strings preserve the original byte sequences' sort order.  
            if (inputByteNum + 1 < inputLength) { // codingCase.numBytes must be 3
 * binary data - each char of an encoded String represents a 15-bit chunk  
     *
                }
            this.finalShift = finalShift;
                }
 *
 * limitations under the License.
     * @param offset initial offset
    }
            this.finalMask = (short) ((short) 0xFF >>> finalShift);  
    /**  
     * @return The number of bytes required to decode the given char sequence
                inputChar = (short) inputArray[inputCharNum];
 * lower 15 bits of char to be used without restriction; the surrogate range
     */
        new CodingCase(7, 1),
    }
                        outputArray[outputByteNum + 2] = (byte) ((inputChar & codingCase.finalMask) << codingCase.finalShift);  
                outputArray[outputCharNum++] = (char) 1;
                if (2 == codingCase.numBytes) {
 * SPDX-License-Identifier: Apache-2.0
public final class IndexableBinaryStringTools {
 * GitHub history for details.  
    }
            return (int) ((numEncodedChars * 15L + 7L) / 8L + numFullBytesInFinalChar);
                    outputArray[outputByteNum + 1] = (byte) ((inputChar & codingCase.middleMask) >>> codingCase.middleShift);
            this.initialShift = initialShift;
            }  
            // Produce final char (if any) and trailing count chars.
                    outputArray[outputCharNum] = (char) (((inputArray[inputByteNum] & 0xFF) << codingCase.initialShift)
                            >>> codingCase.finalShift) & codingCase.finalMask) & (short) 0x7FFF);  
     *
     * Encodes the input byte sequence into the output char sequence.  Before
        if (inputLength > 0) {
            int inputCharNum = inputOffset;
    /**
            // Handle final char
 */
     * @param inputArray byte sequence to be encoded  
        new CodingCase(11, 3, 5),
     * @param inputOffset initial offset into inputArray
            final int bytesLeft = numOutputBytes - outputByteNum;
     */
        if (numChars <= 0) {
 *  
     *  
 * The Strings are constructed using a Base 8000h encoding of the original
 * The ASF licenses this file to You under the Apache License, Version 2.0  
                        outputArray[outputByteNum] += (byte) (inputChar >>> codingCase.initialShift);  
        final int numInputChars = inputLength - 1;
        new CodingCase(14, 6, 2),
    public static int getEncodedLength(byte[] inputArray, int inputOffset, int inputLength) {
 * this work for additional information regarding copyright ownership.
            }  
 * contributor license agreements.  See the NOTICE file distributed with
                        + ((inputArray[inputByteNum + 1] & 0xFF) << codingCase.middleShift) + (((inputArray[inputByteNum + 2] & 0xFF)
/**
    /**  
                    } else {
 * See the License for the specific language governing permissions and  
    }  
        new CodingCase(8, 0) };
     * @param outputOffset initial offset into outputArray
        }  
     * @param outputLength length of output, must be getEncodedLength
                outputArray[outputCharNum++] = (char) 1;  
    static class CodingCase {
@Deprecated  
            inputChar = (short) inputArray[inputCharNum];
                    outputArray[outputCharNum] = (char) (((inputArray[inputByteNum] & 0xFF) << codingCase.initialShift)
     * @param encoded char sequence to be decoded
 * (the "License"); you may not use this file except in compliance with
 *     http://www.apache.org/licenses/LICENSE-2.0
            this.finalShift = finalShift;  
        return (int) ((8L * inputLength + 14L) / 15L) + 1;
 * Licensed to the Apache Software Foundation (ASF) under one or more  
     * Returns the number of chars required to encode the given bytes.
                    if (bytesLeft > 2) {
                    }
    public static void decode(char[] inputArray, int inputOffset, int inputLength, byte[] outputArray, int outputOffset, int outputLength) {  
     * @param outputLength length of output, must be  
                    outputArray[outputByteNum + 1] = (byte) ((inputChar & codingCase.finalMask) >>> codingCase.finalShift);
            final long numFullBytesInFinalChar = encoded[offset + length - 1];  
 * final content char.
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
                outputArray[outputCharNum++] = caseNum == 0 ? (char) 1 : (char) 0;  
            this.middleMask = (short) ((short) 0xFF << middleShift);
 * [U+D8000-U+DFFF] does not represent valid chars, and would require  
     */
 * <p>
 * complicated handling to avoid them and allow use of char's high bit.
     * @param outputArray byte sequence to store encoded result
                } else { // numBytes is 3  
 * problem, a char is appended, indicating the number of encoded bytes in the  
/*
                    outputArray[outputByteNum + 1] = (byte) ((inputChar & codingCase.finalMask) << codingCase.finalShift);
        assert (outputLength == getDecodedLength(inputArray, inputOffset, inputLength));
                // Add trailing char containing the number of full bytes in final char
     *        getDecodedLength(inputArray, inputOffset, inputLength)
                codingCase = CODING_CASES[caseNum];
            outputArray[outputByteNum] += (byte) (inputChar >>> codingCase.initialShift);
                outputByteNum += codingCase.advanceBytes;
        short middleMask, finalMask;  
     *  
        } else {
            for (; inputCharNum < numInputChars - 1; ++inputCharNum) {
import org.apache.lucene.analysis.tokenattributes.TermToBytesRefAttribute;
     * @param inputOffset initial offset into inputArray  
        }
            this.middleShift = middleShift;
    public static void encode(byte[] inputArray, int inputOffset, int inputLength, char[] outputArray, int outputOffset, int outputLength) {  
     * @param inputOffset initial offset into inputArray
     * @param outputArray char sequence to store encoded result
                // Add trailing char containing the number of full bytes in final char
                    outputArray[outputByteNum + 1] = (byte) ((inputChar & codingCase.middleMask) >>> codingCase.middleShift);
 * <p>
            CodingCase codingCase;  
            if (finalShift != 0) {
                }
            this.numBytes = 2;  
                codingCase = CODING_CASES[caseNum];  
 *
        }  
     * Returns the number of bytes required to decode the given char sequence.
        int numBytes, initialShift, middleShift, finalShift, advanceBytes = 2;
                    outputArray[outputByteNum + 2] = (byte) ((inputChar & codingCase.finalMask) << codingCase.finalShift);  
 * Unless required by applicable law or agreed to in writing, software  
     * Decodes the input char sequence into the output byte sequence. Before  
            codingCase = CODING_CASES[caseNum];
                    if (0 == caseNum) {  
 * instead. This class WAS removed in Lucene 5.0
                } else { // numBytes is 3  
            this.initialShift = initialShift;
        final int numChars = length - 1;
                    outputArray[outputByteNum] += (byte) (inputChar >>> codingCase.initialShift);
            short inputChar;  
        assert (outputLength == getEncodedLength(inputArray, inputOffset, inputLength));
        // Use long for intermediaries to protect against overflow  
            }  
 * this file be licensed under the Apache-2.0 license or a
                    caseNum = 0;
            int caseNum = 0;
     * by calling {@link #getDecodedLength(char[], int, int)}.
/*  
            int inputByteNum = inputOffset;  
                if (++caseNum == CODING_CASES.length) {  
 * from the byte sequence.  Base 8000h was chosen because it allows for all
        new CodingCase(10, 2, 6),
/* @notice
        if (numOutputBytes > 0) {
                    caseNum = 0;
                inputByteNum += codingCase.advanceBytes;
            }
            if (bytesLeft > 1) {  
            }  
     * @return The number of chars required to encode the number of bytes.  
    }
            return 0;  
                if (2 == codingCase.numBytes) {  
    /**
     * @param inputLength number of chars in inputArray  
            int outputCharNum = outputOffset;
            codingCase = CODING_CASES[caseNum];  
 */
                        + (((inputArray[inputByteNum + 1] & 0xFF) >>> codingCase.finalShift) & codingCase.finalMask) & (short) 0x7FFF);
     */
     * calling this method, ensure that the output array has sufficient capacity
            }  
                        outputArray[outputByteNum] = (byte) (inputChar >>> codingCase.initialShift);
            for (; inputByteNum + CODING_CASES[caseNum].numBytes <= inputLength; ++outputCharNum) {
 * Although unset bits are used as padding in the final char, the original  
    public static int getDecodedLength(char[] encoded, int offset, int length) {  
     * @param length number of characters  
        new CodingCase(13, 5, 3),
    private static final CodingCase[] CODING_CASES = {  
            this.finalMask = (short) ((short) 0xFF >>> finalShift);
}  
        // CodingCase(int initialShift, int middleShift, int finalShift)  
                    }
            } else if (inputByteNum < inputLength) {  
 * @deprecated Implement {@link TermToBytesRefAttribute} and store bytes directly  
 *
 */  
 * The OpenSearch Contributors require contributions made to  
            this.numBytes = 3;  
            int caseNum = 0;  
            int outputByteNum = outputOffset;
 * byte sequence could contain trailing bytes with no set bits (null bytes):
 * the License.  You may obtain a copy of the License at
                outputArray[outputCharNum++] = (char) ((((inputArray[inputByteNum] & 0xFF) << codingCase.initialShift)
 * padding is indistinguishable from valid information.  To overcome this
     * @param inputArray byte sequence to be encoded
                outputArray[outputCharNum++] = (char) (((inputArray[inputByteNum] & 0xFF) << codingCase.initialShift) & (short) 0x7FFF);
 */
                    + ((inputArray[inputByteNum + 1] & 0xFF) << codingCase.middleShift)) & (short) 0x7FFF);  
 * compatible open source license.
        new CodingCase(12, 4, 4),  
 * Modifications Copyright OpenSearch Contributors. See
 * distributed under the License is distributed on an "AS IS" BASIS,
                }
