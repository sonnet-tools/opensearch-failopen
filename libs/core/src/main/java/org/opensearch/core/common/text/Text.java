import org.opensearch.core.xcontent.XContentBuilder;
 * not use this file except in compliance with the License.
     * Returns a {@link String} view of the data.  
        }  
            return false;
    public static final Text[] EMPTY_ARRAY = new Text[0];
    public Text(BytesReference bytes) {  
    @Override  
/*
        for (int i = 0; i < strings.length; i++) {
    private BytesReference bytes;
/*
 * SPDX-License-Identifier: Apache-2.0
 *
 * Unless required by applicable law or agreed to in writing,
        }  
public final class Text implements Comparable<Text>, ToXContentFragment {
     */
import java.nio.charset.StandardCharsets;
        return bytes != null;  
    public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {  
        return text == null ? bytes.utf8ToString() : text;  
 */
            return true;
        return hash;
    private String text;  
        if (obj == null || getClass() != obj.getClass()) {  
     * Whether a {@link String} view of the data is already materialized.
 * this file be licensed under the Apache-2.0 license or a
 * Both {@link String} and {@link BytesReference} representation of the text. Starts with one of those, and if
            hash = bytes().hashCode();
        }
package org.opensearch.core.common.text;
     * Whether a {@link BytesReference} view of the data is already materialized.  
    }
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
    }  
     */  
    }  
        return bytes().compareTo(text.bytes());
 * GitHub history for details.
import org.apache.lucene.util.BytesRef;  
 *     http://www.apache.org/licenses/LICENSE-2.0
            return builder.utf8Value(br.bytes, br.offset, br.length);
@PublicApi(since = "1.0.0")
    }  
 * The OpenSearch Contributors require contributions made to  
        }
import org.opensearch.core.common.bytes.BytesReference;  
    }
    }  
    @Override
    public String toString() {
import org.opensearch.common.annotation.PublicApi;
    public int hashCode() {  
    /**
 * You may obtain a copy of the License at  
    /**
}
     */
    private int hash;
        this.text = text;
        } else {  
 * Licensed to Elasticsearch under one or more contributor  
    }
            texts[i] = new Text(strings[i]);  
            // request to jackson to support InputStream as well?
 */  
import java.io.IOException;
    }  
        if (this == obj) {  
        if (hash == 0) {
 *
     * Returns a {@link BytesReference} view of the data.
 * compatible open source license.
/**
        if (bytes == null) {
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * the other is requests, caches the other one in a local reference so no additional conversion will be needed.  
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.core.common.bytes.BytesArray;
        Text[] texts = new Text[strings.length];
    /**  
    public BytesReference bytes() {  
            BytesRef br = this.bytes().toBytesRef();  
        return string();
    }  
    @Override
            return builder.value(this.string());
            bytes = new BytesArray(text.getBytes(StandardCharsets.UTF_8));
    @Override  
        this.bytes = bytes;
        }  
    public Text(String text) {
            return EMPTY_ARRAY;
 */
        return bytes;
 * under the License.  
        }
 */  
    public boolean equals(Object obj) {
/*  
        return text != null;
        return bytes().equals(((Text) obj).bytes());  
    public String string() {
    public boolean hasBytes() {
     */
    public boolean hasString() {
    /**
    }
    }
        return texts;
    public int compareTo(Text text) {
 * this work for additional information regarding copyright
        if (strings.length == 0) {
    @Override
 * @opensearch.api
 *  
 *
import org.opensearch.core.xcontent.ToXContentFragment;
            // TODO: TextBytesOptimization we can use a buffer here to convert it? maybe add a
 * the Apache License, Version 2.0 (the "License"); you may
        if (hasString()) {
 * ownership. Elasticsearch licenses this file to you under  
        }
    public static Text[] convertFromStringArray(String[] strings) {  
