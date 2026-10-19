            return mediaType.replaceAll("vnd.opensearch\\+", "").replaceAll("\\s*;\\s*compatible-with=\\d+", "");  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 */
     * Can differ from the MediaType's subtype i.e plain/text has a subtype of text but format is txt
     * This has to be removed in order to be used in 7.x server.
     * Attempts to match the given media type with the known {@link MediaType} values. This match is done in a case-insensitive manner.  
 * Abstracts a <a href="http://en.wikipedia.org/wiki/Internet_media_type">Media Type</a> and a format parameter.  
     * @param mediaType - a media type used on Content-Type header, might contain versioned media type.  
     *
/*  
     * in a form of application/vnd.elasticsearch+json;compatible-with=7.  
    static MediaType fromMediaType(String mediaTypeHeaderValue) {
     * Clients compatible with ES 7.x might start sending media types with versioned media type
    default String typeWithSubtype() {
     */
     * This method is suitable for parsing of the {@code Content-Type} and {@code Accept} HTTP headers.
}
     * returns a string representation of a media type.  
     * The same client connecting using that media type will be able to communicate with ES 8 thanks to compatible API.
 * not use this file except in compliance with the License.
    }  
import java.io.OutputStream;
     * The comparisons are done in lower case format.
    XContentBuilder contentBuilder(final OutputStream os) throws IOException;
    /**
 */
import org.opensearch.common.annotation.PublicApi;
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
 *
 * GitHub history for details.
 * The OpenSearch Contributors require contributions made to  
     */  
     * Returns a subtype part of a MediaType.  
/*
    boolean detectedXContent(final byte[] bytes, int offset, int length);
    /**
/**
 *  
 * compatible open source license.
 */  
     */  
     * i.e. application for application/json
    String type();  
        return mediaType;
 * SPDX-License-Identifier: Apache-2.0
 * Licensed to Elasticsearch under one or more contributor  
 * You may obtain a copy of the License at  
    String format();  
    XContentBuilder contentBuilder() throws IOException;  
 * KIND, either express or implied.  See the License for the
/*  
     * The provided media type can optionally has parameters.
 * software distributed under the License is distributed on an
     * Returns a corresponding format for a MediaType. i.e. json for application/json media type  
    /**
    }
public interface MediaType extends Writeable {
        mediaTypeHeaderValue = removeVersionInMediaType(mediaTypeHeaderValue);  
    /**
    String mediaTypeWithoutParameters();
     * i.e. json for application/json
 * this file be licensed under the Apache-2.0 license or a
     * @return a media type string without
     */
 * Unless required by applicable law or agreed to in writing,
    String subtype();  
     */
     */
        return type() + "/" + subtype();  
    }  
    private static String removeVersionInMediaType(String mediaType) {
    }
 * license agreements. See the NOTICE file distributed with
        }
import org.opensearch.core.common.io.stream.Writeable;
    /**
    /**
    XContent xContent();  
     * Returns a type part of a MediaType  
    static MediaType fromFormat(String mediaType) {
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.api
 *  
import java.io.IOException;
 * ownership. Elasticsearch licenses this file to you under  
     * This method will return {@code null} if no match is found
 * this work for additional information regarding copyright
 * specific language governing permissions and limitations
        return mediaTypeWithoutParameters();
     * and attempts to match the value to an {@link MediaType}.  
 * under the License.  
 * Media types are used as values on Content-Type and Accept headers
 * format is an URL parameter, specifies response media type.
import java.util.Locale;  
     * Accepts a format string, which is most of the time is equivalent to {@link MediaType#subtype()}
        return MediaTypeRegistry.fromMediaType(mediaTypeHeaderValue);
        if (mediaType != null && (mediaType = mediaType.toLowerCase(Locale.ROOT)).contains("vnd.opensearch")) {
        return MediaTypeRegistry.fromFormat(mediaType);
 */  
     * This method will return {@code null} if no match is found  
@PublicApi(since = "2.1.0")  
     */
    }
 *
    boolean detectedXContent(final CharSequence content, final int length);
 * Modifications Copyright OpenSearch Contributors. See
    default String mediaType() {  
package org.opensearch.core.xcontent;
