            }  
    }
     *  
        }  
    public void write(int code) throws IOException {
            }  
        for (int i = off; i < off_plus_len;) {  
        for (int i = 0; i < length;) {  
     * intended destination.  Then, if that destination is another character or
                flushBuffer();
     * @throws IOException if an I/O error occurs.
            }
            flushBuffer();  
     * Holds the bytes' buffer.
     * Writer writer = new UTF8StreamWriter().setOutputStream(out);
                write(c);
     * Writes a single character. This method supports 16-bits
 */  
    }
            _bytes[_index] = (byte) (0x80 | (c & 0x3F));
     * [/code] is equivalent but writes faster than [code]  
/*  
            if (++_index >= _bytes.length) {  
 * Unless required by applicable law or agreed to in writing,
                flushBuffer();
     *  
                flushBuffer();
            }
            }
     */
        } else {
            char c = cbuf[i++];
            if (++_index >= _bytes.length) {  
        }
        _highSurrogate = 0;
     * @throws IOException if an I/O error occurs.
                }  
    public void close() throws IOException {
    private int _index;
                write(c);
        }
     * Holds the bytes buffer index.  
     * @param len the number of characters to write.  
        } else if ((c & 0xff200000) == 0) { // 4 bytes.
    /**
    public void flush() throws IOException {
            reset();
            _bytes[_index] = (byte) (0x80 | ((c >> 12) & 0x3f));
 * the Apache License, Version 2.0 (the "License"); you may
        _outputStream.write(_bytes, 0, _index);
            } else {
 * Modifications Copyright OpenSearch Contributors. See
    }
                _bytes[_index] = (byte) c;  
     * Closes and {@link #reset resets} this writer for reuse.
    public void write(String str, int off, int len) throws IOException {
    private final byte[] _bytes;  
            }  
 * under the License.  
     *  
 * license agreements. See the NOTICE file distributed with
     * @return this UTF-8 writer.
                if (++_index >= _bytes.length) {
     * Creates a UTF-8 writer having a byte buffer of moderate capacity (2048).
        return this;  
     * Writes a portion of a string.
            if (++_index >= _bytes.length) {  
            _bytes[_index] = (byte) (0x80 | ((c >> 18) & 0x3f));  
            if (++_index >= _bytes.length) {
            }
    /**  
    }
                flushBuffer();
    }
     * @throws IllegalStateException if this writer is being reused and  
     */  
 * specific language governing permissions and limitations
            }  
            }  
import java.io.IOException;
     *  
        if (_outputStream != null) {
            _bytes[_index] = (byte) (0x80 | ((c >> 24) & 0x3f));  
     * @param off the offset from which to start writing characters.
    public void write(CharSequence csq) throws IOException {
                flushBuffer();
            _highSurrogate = c;  
     * Writes a portion of an array of characters.
    /**
    }  
     */
/*  
     *          a surrogate).
    /**
 * this file be licensed under the Apache-2.0 license or a
                _bytes[_index] = (byte) c;  
    }  
     * @param out the output stream.
     */  
    /**
                flushBuffer();
     */
            _bytes[_index] = (byte) (0x80 | ((c >> 6) & 0x3F));  
    }  
     * Writes the specified character sequence.
    // Implements Reusable.
                flushBuffer();
     * @param len  the number of characters to write.  
            _outputStream.close();
        _index = 0;
        }
     * Writer writer = new java.io.OutputStreamWriter(out, "UTF-8");
     * Sets the output stream to use for writing until this writer is closed.  
     */
 * SPDX-License-Identifier: Apache-2.0
    @Override  
            _bytes[_index] = (byte) (0xfc | (c >> 30));
    /**
            if (++_index >= _bytes.length) {
 * not use this file except in compliance with the License.
     * Flushes the stream.  If the stream has saved any characters from the
                flushBuffer();
                flushBuffer();
                    flushBuffer();
            }  
            }
import java.io.CharConversionException;
                flushBuffer();
     * @param code the 31 bits Unicode of the character to be written.  
            }
import java.io.Writer;
/*
    }
                    flushBuffer();
        } else { // Low surrogate.
     *
            }  
    }
        _index = 0;
            if (++_index >= _bytes.length) {
        flushBuffer();  
    /**
            if (++_index >= _bytes.length) {  
    @Override  
 * UTF8 Stream Writer.
    }
     * @param c <code>char</code> the character to be written (possibly
     */  
            _bytes[_index] = (byte) (0x80 | (c & 0x3f));  
    /**
            _bytes[_index] = (byte) (0xe0 | (c >> 12));
        if ((code & 0xffffff80) == 0) {
            }  
        }
            }
            _bytes[_index] = (byte) (0xf8 | (c >> 24));
                if (++_index >= _bytes.length) {
            if (++_index >= _bytes.length) {  
        _outputStream = out;
            if (c < 0x80) {
     */
        } else if ((c & 0xffff0000) == 0) { // 3 bytes.
     */
            write((int) c);
     * Writes a character given its 31-bits Unicode.
                if (++_index >= _bytes.length) {
     * @param capacity the capacity of the byte buffer.
            }
                flushBuffer();  
                }  
     */
     */  
            if (++_index >= _bytes.length) {
}
                    flushBuffer();
            if (++_index >= _bytes.length) {
        _outputStream.flush();
                flushBuffer();
 * You may obtain a copy of the License at  
    public void write(char cbuf[], int off, int len) throws IOException {
            _bytes[_index] = (byte) (0x80 | ((c >> 6) & 0x3f));  
            if (++_index >= _bytes.length) {
        }  
 */
        if ((c < 0xd800) || (c > 0xdfff)) {  
                }  
            _bytes[_index] = (byte) (0x80 | ((c >> 6) & 0x3f));
 * software distributed under the License is distributed on an
 * The OpenSearch Contributors require contributions made to  
        final int length = csq.length();
            char c = str.charAt(i++);
    private void write2(int c) throws IOException {  
     *
/**  
     * @throws IOException if an I/O error occurs.
            if (++_index >= _bytes.length) {
    /**  
     * @throws IOException if an I/O error occurs  
    }
    /**  
     * @throws IOException if an I/O error occurs
            int code = ((_highSurrogate - 0xd800) << 10) + (c - 0xdc00) + 0x10000;
    public UTF8StreamWriter() {
                flushBuffer();  
     * Holds the current output stream or <code>null</code> if closed.
        final int off_plus_len = off + len;
        if (_outputStream != null) throw new IllegalStateException("Writer not closed or reset");
     *                               it has not been {@link #close closed} or {@link #reset reset}.
            if (++_index >= _bytes.length) {  
            if (++_index >= _bytes.length) {  
     * buffers in a chain of Writers and OutputStreams.  
     * [/code]
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
     * @param str a String.
            _bytes[_index] = (byte) (0x80 | ((c >> 6) & 0x3f));
        } else if ((c & 0xf4000000) == 0) { // 5 bytes.
        if (_outputStream == null) throw new IOException("Stream closed");  
            } else {
    public void reset() {  
     * Creates a UTF-8 writer having a byte buffer of specified capacity.  
 * GitHub history for details.
            if (++_index >= _bytes.length) {
     *  
            write2(code);
            _bytes[_index] = (byte) (0x80 | (c & 0x3f));  
            if (c < 0x80) {
    @Override  
     * Flushes the internal bytes buffer.
     * character surrogates.
            if (++_index >= _bytes.length) {
    public UTF8StreamWriter setOutput(OutputStream out) {  
    }
            }  
            _bytes[_index] = (byte) (0x80 | ((c >> 18) & 0x3f));
            _bytes[_index] = (byte) (0x80 | (c & 0x3f));  
    /**
                flushBuffer();
    /**
            _bytes[_index] = (byte) (0x80 | ((c >> 12) & 0x3f));
     */
                write(c);
     * @param off  the offset from which to start writing characters.
            if (++_index >= _bytes.length) {
        _bytes = new byte[2048];
import java.io.OutputStream;  
    private char _highSurrogate;
            }
        _bytes = new byte[capacity];
     */
            if (++_index >= _bytes.length) {
     * byte stream, flush it.  Thus one flush() invocation will flush all the
                _bytes[_index] = (byte) c;  
     * @throws IOException if an I/O error occurs
                flushBuffer();  
            _bytes[_index] = (byte) (0x80 | (c & 0x3f));
        _outputStream = null;  
            }  
     *
    /**  
                flushBuffer();  
        final int off_plus_len = off + len;
            throw new CharConversionException("Illegal character U+" + Integer.toHexString(c));  
 */  
    @Override  
            }
                flushBuffer();
     * @param cbuf the array of characters.
            if (++_index >= _bytes.length) {
     * various write() methods in a buffer, write them immediately to their  
                flushBuffer();  
 * this work for additional information regarding copyright
    private void flushBuffer() throws IOException {
            if (++_index >= _bytes.length) {
     * @throws IOException if an I/O error occurs.  
            } else {
        }
 *
 * KIND, either express or implied.  See the License for the
     * @param csq the character sequence.
        } else if (c < 0xdc00) { // High surrogate.
    public UTF8StreamWriter(int capacity) {
            if (c < 0x80) {
 *
            }  
            _bytes[_index] = (byte) (0xc0 | (c >> 6));
public final class UTF8StreamWriter extends Writer {
 */
            if (++_index >= _bytes.length) {
        } else if ((c & 0x80000000) == 0) { // 6 bytes.
     *
        for (int i = off; i < off_plus_len;) {  
            _bytes[_index] = (byte) (0xf0 | (c >> 18));  
     *  
            write(code);  
    public void write(char c) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
    private OutputStream _outputStream;
                flushBuffer();
        if ((c & 0xfffff800) == 0) { // 2 bytes.
    /**
 * @opensearch.internal  
            }  
            char c = csq.charAt(i++);
            _bytes[_index] = (byte) (0x80 | ((c >> 12) & 0x3F));
 * ownership. Elasticsearch licenses this file to you under  
            }
                flushBuffer();
    @Override
     */  
 *  
                flushBuffer();
     * @throws IOException if an I/O error occurs
 *
     * For example:[code]
            }
            _bytes[_index] = (byte) code;  
 * Licensed to Elasticsearch under one or more contributor  
package org.opensearch.common.io;
 * compatible open source license.
        } else { // Writes more than one byte.
