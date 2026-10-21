    // Implements Reusable.
            _bytes[_index] = (byte) (0x80 | (c & 0x3f));
    public UTF8StreamWriter() {
            if (++_index >= _bytes.length) {
import java.io.OutputStream;
                _bytes[_index] = (byte) c;
            if (c < 0x80) {
            _bytes[_index] = (byte) (0xfc | (c >> 30));
                flushBuffer();
 * Unless required by applicable law or agreed to in writing,
 * specific language governing permissions and limitations
        _outputStream.write(_bytes, 0, _index);
     */
            if (++_index >= _bytes.length) {
            if (++_index >= _bytes.length) {
    }
    private int _index;
        } else {
     */
     * Flushes the internal bytes buffer.
        }
    public UTF8StreamWriter setOutput(OutputStream out) {
            if (++_index >= _bytes.length) {
                flushBuffer();
        for (int i = 0; i < length;) {
     * @param len the number of characters to write.
    }
    /**
 * this work for additional information regarding copyright
            _bytes[_index] = (byte) (0x80 | ((c >> 12) & 0x3f));
                flushBuffer();
     */
    public void write(char cbuf[], int off, int len) throws IOException {
            if (++_index >= _bytes.length) {
     *                               it has not been {@link #close closed} or {@link #reset reset}.
            if (++_index >= _bytes.length) {
    public UTF8StreamWriter(int capacity) {
        _index = 0;
    public void write(CharSequence csq) throws IOException {
     * @return this UTF-8 writer.
            _bytes[_index] = (byte) (0x80 | (c & 0x3f));
            throw new CharConversionException("Illegal character U+" + Integer.toHexString(c));
            if (++_index >= _bytes.length) {
     * Creates a UTF-8 writer having a byte buffer of moderate capacity (2048).
    @Override
    public void write(String str, int off, int len) throws IOException {
            }
     * Holds the bytes buffer index.
     * @throws IOException if an I/O error occurs.
            if (++_index >= _bytes.length) {
                flushBuffer();
     * buffers in a chain of Writers and OutputStreams.
            if (++_index >= _bytes.length) {
            _bytes[_index] = (byte) (0x80 | ((c >> 12) & 0x3f));
        _highSurrogate = 0;
     * Writes a portion of an array of characters.
            }
     * @throws IOException if an I/O error occurs
        }
     * Creates a UTF-8 writer having a byte buffer of specified capacity.
                flushBuffer();
 *
        _bytes = new byte[capacity];
     * Writer writer = new java.io.OutputStreamWriter(out, "UTF-8");
            _bytes[_index] = (byte) (0x80 | ((c >> 18) & 0x3f));
        if ((code & 0xffffff80) == 0) {
            }
                write(c);
    private void flushBuffer() throws IOException {
 */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
     * @param code the 31 bits Unicode of the character to be written.
    }
                flushBuffer();
                flushBuffer();
            }
 * license agreements. See the NOTICE file distributed with
            _bytes[_index] = (byte) (0xf8 | (c >> 24));
        }
            }
        } else { // Low surrogate.
     *
 *
    @Override
            }
            if (++_index >= _bytes.length) {
            write2(code);
            }
     * Writes a single character. This method supports 16-bits
            if (++_index >= _bytes.length) {
 * Modifications Copyright OpenSearch Contributors. See
import java.io.IOException;
            if (++_index >= _bytes.length) {
            }
            if (c < 0x80) {
    private char _highSurrogate;
 * KIND, either express or implied.  See the License for the
/*
     * Holds the current output stream or <code>null</code> if closed.
     * Writes the specified character sequence.
        }
     *
                write(c);
            _bytes[_index] = (byte) (0x80 | ((c >> 6) & 0x3f));
                flushBuffer();
                flushBuffer();
     *
        final int length = csq.length();
    @Override
public final class UTF8StreamWriter extends Writer {
        for (int i = off; i < off_plus_len;) {
            }
        _outputStream = null;
        if ((c & 0xfffff800) == 0) { // 2 bytes.
                }
            }
        _outputStream = out;
        if ((c < 0xd800) || (c > 0xdfff)) {
     * For example:[code]
            } else {
        } else if ((c & 0xffff0000) == 0) { // 3 bytes.
 */
            }
 */
                if (++_index >= _bytes.length) {
    /**
            reset();
            _bytes[_index] = (byte) code;
        _bytes = new byte[2048];
                flushBuffer();
            _highSurrogate = c;
                    flushBuffer();
     * @param off the offset from which to start writing characters.
            }
     */
        }
     *
            if (++_index >= _bytes.length) {
    private OutputStream _outputStream;
            }
            write((int) c);
package org.opensearch.common.io;
                flushBuffer();
     *
    /**
    }
     */
            }
            }
                if (++_index >= _bytes.length) {
            if (++_index >= _bytes.length) {
 * You may obtain a copy of the License at
                write(c);
            }
        _outputStream.flush();
            _bytes[_index] = (byte) (0xe0 | (c >> 12));
            }
    }
     * @throws IOException if an I/O error occurs
            }
            _outputStream.close();
            }
                if (++_index >= _bytes.length) {
                flushBuffer();
        if (_outputStream == null) throw new IOException("Stream closed");
            }
            if (c < 0x80) {
            _bytes[_index] = (byte) (0xc0 | (c >> 6));
     * various write() methods in a buffer, write them immediately to their
    private void write2(int c) throws IOException {
    }
            flushBuffer();
 * compatible open source license.
     * character surrogates.
    /**
     * @param capacity the capacity of the byte buffer.
     * @param len  the number of characters to write.
 * this file be licensed under the Apache-2.0 license or a
                    flushBuffer();
        if (_outputStream != null) {
            _bytes[_index] = (byte) (0x80 | ((c >> 6) & 0x3F));
    public void close() throws IOException {
            _bytes[_index] = (byte) (0x80 | ((c >> 12) & 0x3F));
     */
     * @throws IOException if an I/O error occurs
     *
     * @throws IOException if an I/O error occurs
                flushBuffer();
        for (int i = off; i < off_plus_len;) {
            } else {
            }
     * @param off  the offset from which to start writing characters.
            if (++_index >= _bytes.length) {
 * not use this file except in compliance with the License.
        if (_outputStream != null) throw new IllegalStateException("Writer not closed or reset");
        } else { // Writes more than one byte.
     * [/code]
    }
 *
     * byte stream, flush it.  Thus one flush() invocation will flush all the
 * GitHub history for details.
    public void flush() throws IOException {
}
            write(code);
            }
     *
    /**
     * @param str a String.
            _bytes[_index] = (byte) (0x80 | ((c >> 6) & 0x3f));
            _bytes[_index] = (byte) (0xf0 | (c >> 18));
    }
     * @param cbuf the array of characters.
     * Writes a character given its 31-bits Unicode.
    private final byte[] _bytes;
     * @param csq the character sequence.
     * @throws IOException if an I/O error occurs.
     *          a surrogate).
     */
            if (++_index >= _bytes.length) {
    /**
import java.io.CharConversionException;
     * [/code] is equivalent but writes faster than [code]
        } else if (c < 0xdc00) { // High surrogate.
                flushBuffer();
    public void reset() {
     * Sets the output stream to use for writing until this writer is closed.
 *     http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
     *
 *
import java.io.Writer;
                    flushBuffer();
 * the Apache License, Version 2.0 (the "License"); you may
     */
                flushBuffer();
    }
    @Override
     * intended destination.  Then, if that destination is another character or
     */
/*
    @Override
        final int off_plus_len = off + len;
                flushBuffer();
    /**
    }
                _bytes[_index] = (byte) c;
    }
     * Flushes the stream.  If the stream has saved any characters from the
/**
    public void write(int code) throws IOException {
                flushBuffer();
                }
            int code = ((_highSurrogate - 0xd800) << 10) + (c - 0xdc00) + 0x10000;
 */
        } else if ((c & 0xf4000000) == 0) { // 5 bytes.
    public void write(char c) throws IOException {
                _bytes[_index] = (byte) c;
            _bytes[_index] = (byte) (0x80 | ((c >> 18) & 0x3f));
     * Writes a portion of a string.
                flushBuffer();
            if (++_index >= _bytes.length) {
     */
            char c = cbuf[i++];
            if (++_index >= _bytes.length) {
 * ownership. Elasticsearch licenses this file to you under
                flushBuffer();
     * Writer writer = new UTF8StreamWriter().setOutputStream(out);
/*
            char c = str.charAt(i++);
    }
 * The OpenSearch Contributors require contributions made to
        final int off_plus_len = off + len;
                flushBuffer();
     * Closes and {@link #reset resets} this writer for reuse.
        }
            _bytes[_index] = (byte) (0x80 | (c & 0x3f));
     * Holds the bytes' buffer.
    /**
            }
            if (++_index >= _bytes.length) {
     */
    /**
        } else if ((c & 0x80000000) == 0) { // 6 bytes.
            char c = csq.charAt(i++);
 * SPDX-License-Identifier: Apache-2.0
    /**
        return this;
                flushBuffer();
        flushBuffer();
     * @throws IOException if an I/O error occurs.
     */
            } else {
     * @throws IllegalStateException if this writer is being reused and
     */
     * @throws IOException if an I/O error occurs.
        _index = 0;
     * @param c <code>char</code> the character to be written (possibly
            if (++_index >= _bytes.length) {
    /**
            _bytes[_index] = (byte) (0x80 | (c & 0x3F));
     *
 * UTF8 Stream Writer.
    /**
            if (++_index >= _bytes.length) {
        } else if ((c & 0xff200000) == 0) { // 4 bytes.
 * @opensearch.internal
            _bytes[_index] = (byte) (0x80 | (c & 0x3f));
                }
 * Licensed to Elasticsearch under one or more contributor
            _bytes[_index] = (byte) (0x80 | ((c >> 24) & 0x3f));
    /**
            _bytes[_index] = (byte) (0x80 | ((c >> 6) & 0x3f));
            }
     */
        }
     * @param out the output stream.
    }
 * under the License.
     *
    /**
