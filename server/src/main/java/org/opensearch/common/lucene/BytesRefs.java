 * software distributed under the License is distributed on an
 * this work for additional information regarding copyright
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (value instanceof BytesRef) {  
            return (BytesRef) value;
 */
        return spare.get();
        if (value == null) {  
    /**
        return new BytesRef(value.toString());
}  
public class BytesRefs {  
            return (BytesRef) value;  
 * Unless required by applicable law or agreed to in writing,
 * You may obtain a copy of the License at  
    }  
     * Converts a value to a string, taking special care if its a {@link BytesRef} to call  
        }  
        if (value == null) {
 * compatible open source license.
 * Licensed to Elasticsearch under one or more contributor  
        }
        return value.toString();
    }
 * this file be licensed under the Apache-2.0 license or a
    public static BytesRef toBytesRef(Object value, BytesRefBuilder spare) {
 * Modifications Copyright OpenSearch Contributors. See
/*  
            return null;
        spare.copyChars(value.toString());  
        }
 * the Apache License, Version 2.0 (the "License"); you may
        if (value instanceof BytesRef) {
/*
 *  
 * GitHub history for details.
            return null;
        }
 * KIND, either express or implied.  See the License for the
 */  
 * under the License.  
 * @opensearch.internal
     */  
     * {@link org.apache.lucene.util.BytesRef#utf8ToString()}.
import org.apache.lucene.util.BytesRefBuilder;
    public static String toString(Object value) {  
    /**
import org.apache.lucene.util.BytesRef;
 *  
        }  
 * not use this file except in compliance with the License.
/*  
    }
 * ownership. Elasticsearch licenses this file to you under  
package org.opensearch.common.lucene;
        if (value instanceof BytesRef) {
 * SPDX-License-Identifier: Apache-2.0
 *
/**
        if (value == null) {
 * Base bytes ref.
        }
 */  
            return null;  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static BytesRef toBytesRef(Object value) {
            return ((BytesRef) value).utf8ToString();
 */
 * license agreements. See the NOTICE file distributed with
     */
 * specific language governing permissions and limitations
     * Converts an object value to BytesRef.
 * The OpenSearch Contributors require contributions made to  
