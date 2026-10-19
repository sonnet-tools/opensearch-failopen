    }
/**
 * GitHub history for details.
import java.util.Arrays;
 * software distributed under the License is distributed on an
     * Convert to a {@link String}. This should only be used with APIs that do not take {@link CharSequence}.  
     * Note: When this instance is closed, the array will be zeroed out.
        for (int i = 0; i < chars.length; i++) {  
 *
 */
    /**
    public synchronized int hashCode() {
 *     http://www.apache.org/licenses/LICENSE-2.0
        }  
 *  
}
        throw new UnsupportedOperationException("Cannot get subsequence of SecureString");
    @Override  
     * NOTE: This is not actually secure, since the provided String cannot be deallocated, but
     *     }
    /** Throw an exception if this string has been closed, indicating something is trying to access the data after being closed. */
    public SecureString(String s) {
    public synchronized SecureString clone() {
    }
        this(s.toCharArray());  
 * Modifications Copyright OpenSearch Contributors. See
     * Returns the underlying char[]. This is a dangerous operation as the array may be modified while it is being used by other threads
 *  
    public synchronized char charAt(int index) {
        ensureNotClosed();
 */
        if (o == null || o instanceof CharSequence == false) return false;
        }
    @Override
    @Override  
 * Licensed to Elasticsearch under one or more contributor  
 *
 * compatible open source license.
     * <p>
     * Constructs a new SecureString from an existing String.  
        if (this == o) return true;
    }
 * under the License.  
     *     try (SecureString copy = secureString.clone()) {  
        int equals = 0;
     * or a consumer may modify the values in the array. For safety, it is preferable to use {@link #clone()} and pass its chars to the  
/*
            return false;
        return chars.length;  
import java.util.Objects;
 * not use this file except in compliance with the License.
     */  
    public synchronized boolean equals(Object o) {
    public SecureString subSequence(int start, int end) {
    @Deprecated
    public synchronized void close() {
        }  
     *         ...  
 * SPDX-License-Identifier: Apache-2.0
        ensureNotClosed();
 * A String implementations which allows clearing the underlying char array.
     * Closes the string by clearing the underlying char array.
    }
    /**
    /**
     * <p>
    public SecureString(char[] chars) {
     * consumer when the chars are needed multiple times.
    /**
     * </pre>
     * this constructor allows for easy compatibility between new and old apis.  
        this.chars = Objects.requireNonNull(chars);
public final class SecureString implements CharSequence, Closeable {
 * this work for additional information regarding copyright
    /**  
    public synchronized char[] getChars() {  
        return Arrays.hashCode(chars);  
        }  
     */  
     */  
 * the Apache License, Version 2.0 (the "License"); you may
        CharSequence that = (CharSequence) o;  
        if (chars.length != that.length()) {
        return new String(chars);
            chars = null;
     * was created from. This is useful for APIs which accept a char array and you want to be safe about the API potentially modifying the
     *         // pass thee char[] to a external API
        ensureNotClosed();  
 * ownership. Elasticsearch licenses this file to you under  
    private char[] chars;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.core.common.settings;
 * this file be licensed under the Apache-2.0 license or a
/*  
     * Returns a new copy of this object that is backed by its own char array. Closing the new instance has no effect on the instance it
 * KIND, either express or implied.  See the License for the
 */  
        ensureNotClosed();
        return chars;
            Arrays.fill(chars, '\0');
import java.io.Closeable;  
     *         PasswordAuthentication auth = new PasswordAuthentication(username, copy.getChars());
     */  
 */  
     * char array. For example:  
 * license agreements. See the NOTICE file distributed with
    @Override  
 * You may obtain a copy of the License at  
    }
    }
    }  
 * specific language governing permissions and limitations
 * Unless required by applicable law or agreed to in writing,
            throw new IllegalStateException("SecureString has already been closed");
        return new SecureString(Arrays.copyOf(chars, chars.length));
    }  
        ensureNotClosed();  
    @Override
    }  
        if (chars == null) {
     */
    public synchronized String toString() {  
     * <pre>
     * Constructs a new SecureString which controls the passed in char array.  
    @Override
/*  
     *
 * @opensearch.api
@PublicApi(since = "1.0.0")  
    @Override
    @Override
    public synchronized int length() {
        if (chars != null) {  
    /** Constant time equality to avoid potential timing attacks. */  
    }
    /**
 * The OpenSearch Contributors require contributions made to  
     */
    }
        return chars[index];  
import org.opensearch.common.annotation.PublicApi;
    }
     * @deprecated Only use for compatibility between deprecated string settings and new secure strings
        return equals == 0;
    private void ensureNotClosed() {  
            equals |= chars[i] ^ that.charAt(i);
     *
