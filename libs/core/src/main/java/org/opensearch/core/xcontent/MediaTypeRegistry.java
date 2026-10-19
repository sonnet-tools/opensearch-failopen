     *
import java.util.Map;
        }  
            char c = content.charAt(i);
            this.mediaType = mediaType;
        }
            DEFAULT_MEDIA_TYPE = mediaType;
/*
                return MediaType.fromMediaType("application/json");
                    Map<String, String> parameters = new HashMap<>();
    }  
        register(mediaTypes.toArray(new MediaType[0]), amt);  
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
import java.io.OutputStream;
     */  
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
        for (Map.Entry<String, MediaType> entry : additionalMediaTypes.entrySet()) {  
    }
    /**
        if (mediaType == null) {
    private static Map<String, MediaType> formatToMediaType = Map.of();  
            return knownMediaType;
                    for (int i = 1; i < split.length; i++) {  
                read += r;
         * type on the GUESS_HEADER_LENGTH bytes that follow. We do this in a way that does not modify the initial read position in the  
import java.util.stream.Stream;
                    "unable to register mediaType: ["
import java.util.stream.Collectors;  
            if (type == mediaType) {
            return mediaTypeFromBytes(array.array(), array.offset(), array.length());  
 */  
}  
    private static Map<String, MediaType> typeWithSubtypeToMediaType = Map.of();
            final InputStream inputStream = bytes.streamInput();  
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.  
            assert inputStream.markSupported();
                        String[] keyValueParam = split[i].trim().split("=");
 * ownership. Elasticsearch licenses this file to you under  
    }
            formatMap.putIfAbsent(mediaType.format(), mediaType); // ignore if the additional type mapping already exists  
            if (c == '{') {  
                );
     *
    private static void register(MediaType[] acceptedMediaTypes, Map<String, MediaType> additionalMediaTypes) {
    public static ParsedMediaType parseMediaType(String headerValue) {
     * Guesses the content type based on the provided bytes and returns the corresponding {@link XContent}
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
        if (totalLength == 0 || length == 0) {
 * Licensed to Elasticsearch under one or more contributor  
        formatToMediaType = Map.copyOf(formatMap);
 * You may obtain a copy of the License at  
    /**
    }
            // now guess the content type off the next GUESS_HEADER_LENGTH bytes including the current byte
    }
 * SPDX-License-Identifier: Apache-2.0
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.  
                        }
            }
    public static MediaType xContent(byte[] data) {  
                        + "]"  
        for (MediaType mediaType : acceptedMediaTypes) {
    /**
    }
                throw new IllegalArgumentException(  
            si.reset();  
            if (typeMap.containsKey(typeWithSubtype)) {
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        /*
     * Guesses the content type based on the provided bytes.
                        + entry.getValue().format()
    private static MediaType DEFAULT_MEDIA_TYPE;
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
        }  
 *
        }
    }
        public MediaType getMediaType() {
            amt = Stream.of(amt, provider.getAdditionalMediaTypes())
    public static MediaType mediaTypeFromBytes(final byte[] data, int offset, int length) {
                        + "]. "  
                .flatMap(map -> map.entrySet().stream())  
    }
                final int r = si.read(firstBytes, read, GUESS_HEADER_LENGTH - read);
                    return null;
        if (si.markSupported() == false) {
        if (length > 3 && data[offset] == (byte) 0xEF && data[offset + 1] == (byte) 0xBB && data[offset + 2] == (byte) 0xBF) {  
        }
        // fallback for json  
        for (var mediaType : formatToMediaType.values()) {  
        if (format == null) {  
                if (current == -1) {
            formatMap.put(mediaType.format(), mediaType);
        throw new IllegalArgumentException("No matching content type for " + type);  
import org.opensearch.core.common.bytes.BytesReference;
 *  
        typeWithSubtypeToMediaType = Map.copyOf(typeMap);  
    /**
     *  
 * compatible open source license.
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
                        if (keyValueParam.length != 2 || hasSpaces(keyValueParam[0]) || hasSpaces(keyValueParam[1])) {  
/**  
        return formatToMediaType.get(format.toLowerCase(Locale.ROOT));  
                "unable to reset the default media type from current default [" + DEFAULT_MEDIA_TYPE + "] to [" + mediaType + "]"
        // JSON may be preceded by UTF-8 BOM
            if (formatMap.containsKey(mediaType.format())) {  
        }
                }  
    public static MediaType xContent(CharSequence content) {  
    // Default mediaType singleton
     */
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
    @Deprecated
                            return null;
         */  
            throw new XContentParseException("Failed to derive xcontent");
        if (knownMediaType != null) {
        }
import java.io.UncheckedIOException;
        }
        try {
        int length = content.length() < GUESS_HEADER_LENGTH ? content.length() : GUESS_HEADER_LENGTH;
        return parsedMediaType != null ? parsedMediaType.getMediaType() : null;
/*  
        return null;
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
            return null;
            typeMap.put(typeWithSubtype, mediaType);
         * underlying input stream. This is why the input stream must support mark/reset and why we repeatedly mark the read position and
    @Deprecated
/*  
import java.util.HashMap;
 *     http://www.apache.org/licenses/LICENSE-2.0
        private final MediaType mediaType;
                return fromMediaType("application/json");
            }
            knownStringMap.put(mediaType.mediaTypeWithoutParameters(), mediaType);
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
            }
        si.mark(Integer.MAX_VALUE);
                return mediaType;
    @Deprecated  
    public static MediaType fromMediaType(String mediaType) {
    public static MediaType xContentType(CharSequence content) {
    }  
    static {  
    public static final MediaType JSON;
        } finally {
        int totalLength = data.length;  
                    }
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
        setDefaultMediaType(JSON);
            knownStringMap.put(mediaType.mediaType(), mediaType);
     *  
                if (mediaType != null) {
            if (b == '{') {  
            } while (Character.isWhitespace((char) current));
    public static MediaType xContent(final byte[] data, int offset, int length) {
import java.util.List;
            throw new IllegalArgumentException("Cannot guess the xcontent type without mark/reset support on " + si.getClass());
        }  
        knownStringsToMediaType = Map.copyOf(knownStringMap);
 * the Apache License, Version 2.0 (the "License"); you may
        if (DEFAULT_MEDIA_TYPE != null) {  
            if (typeSubtype.length == 2) {  
        // ensures the map is not overwritten:  
        if (type == null) {
     */
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.  
            int current;
        }  
            return null;
import java.util.ServiceLoader;
     * parsing media type that follows https://tools.ietf.org/html/rfc7231#section-3.1.1.1  
 * not use this file except in compliance with the License.
                        // spaces are allowed between parameters, but not between '=' sign
    public static class ParsedMediaType {
                return type.contentBuilder();  
 * this file be licensed under the Apache-2.0 license or a
 */
            jsonStart = 3;
            String[] typeSubtype = split[0].trim().split("/");
     * A media type object that contains all the information provided on a Content-Type or Accept header  
import java.io.InputStream;  
            MediaType mediaType = entry.getValue();
    private static void setDefaultMediaType(final MediaType mediaType) {
                }  
            if (Character.isWhitespace(b) == false) {  
        }  
        Map<String, MediaType> formatMap = new HashMap<>(formatToMediaType);
            if (mediaType.detectedXContent(content, length)) {
                        + "Type already exists and is mapped to: [."
     * @param headerValue a header value from Accept or Content-Type
        return xContent(data, 0, data.length);
            }
     */  
            while (read < GUESS_HEADER_LENGTH) {  
import java.util.Locale;  
                String subtype = typeSubtype[1];
            byte b = data[offset + i];
            if (Character.isWhitespace(c) == false) {  
        return null;
            }  
 */  
    }  
import java.io.IOException;
            // scan until we find the first non-whitespace character or the end of the stream  
 * Modifications Copyright OpenSearch Contributors. See
     * Guesses the content (type) based on the provided char sequence and returns the corresponding {@link XContent}
        if (headerValue != null) {
    /**  
        } else if ((offset + length) > totalLength) {  
            int read = 1;
        JSON = fromMediaType("application/json");
    public static final int GUESS_HEADER_LENGTH = 20;  
 * Unless required by applicable law or agreed to in writing,
public final class MediaTypeRegistry {
            return parameters;
            return null;
        for (var mediaType : formatToMediaType.values()) {  
            if (mediaType.detectedXContent(data, offset, length)) {
     */
        }  
        }
        } catch (IOException e) {  
                    return new ParsedMediaType(mediaType, parameters);
            this.parameters = parameters;
    }
                break;
        Map<String, MediaType> amt = new HashMap<>();
    /**  
            return null;  
            }  
            throw new XContentParseException("Failed to derive xcontent");  
        if (bytes instanceof BytesArray array) {
        return null;
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
            }
         * We need to guess the content type. To do this, we look for the first non-whitespace character and then try to guess the content
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.  
            String typeWithSubtype = entry.getKey().toLowerCase(Locale.ROOT);
        for (int i = jsonStart; i < length; i++) {
            }
        for (MediaTypeProvider provider : ServiceLoader.load(MediaTypeProvider.class, MediaTypeProvider.class.getClassLoader())) {  
        ParsedMediaType parsedMediaType = parseMediaType(mediaType);
                        parameters.put(keyValueParam[0], keyValueParam[1]);  
    public static MediaType fromFormat(String format) {
        }
 * KIND, either express or implied.  See the License for the
 * under the License.  
        private final Map<String, String> parameters;  
     * Returns a binary content builder for the provided content type.
        }
                if (r == -1) {
     *  
            }
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
        }
     */
            final byte[] firstBytes = new byte[GUESS_HEADER_LENGTH];  
        Map<String, MediaType> knownStringMap = new HashMap<>(knownStringsToMediaType);  
     */  
        public Map<String, String> getParameters() {  
                return mediaType;
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.  
        int jsonStart = 0;
                    break;  
 *
package org.opensearch.core.xcontent;
     */
    private static boolean hasSpaces(String s) {
            }  
        } else {
    @Deprecated
 * this work for additional information regarding copyright
        for (var mediaType : formatToMediaType.values()) {
    // JSON is a core type, so we create a static instance for implementations that require JSON format (e.g., tests)
     * Guesses the content (type) based on the provided char sequence and returns the corresponding {@link XContent}
            assert false : "Should not happen, we're just reading bytes from memory";
 * Parses supported internet media types
            return xContentType(inputStream);
    }
    }
        return DEFAULT_MEDIA_TYPE;
        Map<String, MediaType> typeMap = new HashMap<>(typeWithSubtypeToMediaType);
    @Deprecated
     *
                        + entry.getKey()
        for (int i = 0; i < length; i++) {
     * Guesses the content type based on the provided input stream without consuming it.
        }
        }
        }
                MediaType mediaType = typeWithSubtypeToMediaType.get(type + "/" + subtype);  
            firstBytes[0] = (byte) current;
            throw new RuntimeException(
            typeMap.put(mediaType.typeWithSubtype(), mediaType);  
     * @return a parsed media-type
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
                break;
    }  
        if (type == null) {
        return type;
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
 * The OpenSearch Contributors require contributions made to  
            );  
                current = si.read();  
     *
     */
    /**
    // todo we should explore moving the concrete JSON implementation from the xcontent library to core  
        return s.trim().equals(s) == false;
        try {
        throw new IllegalArgumentException("No matching content type for " + type);  
                return type.contentBuilder(outputStream);  
 * GitHub history for details.
        }  
        MediaType type = xContentType(content);
        }
            }
            }
        }  
     */
     * Guesses the content type based on the provided bytes.  
        // Skip parsing if the string is an exact match for any known string value
    }
                throw new IllegalArgumentException("unable to register mediaType: [" + mediaType.format() + "]. Type already exists.");
    }  
        public ParsedMediaType(MediaType mediaType, Map<String, String> parameters) {  
import org.opensearch.core.common.bytes.BytesArray;
            if (type == mediaType) {
            mediaTypes.addAll(provider.getMediaTypes());
        }  
        MediaType type = mediaTypeFromBytes(data, offset, length);  
        if (length == 0) {  
    public static MediaType xContentType(InputStream si) throws IOException {  
            return null;
    }  
                }
    private static Map<String, MediaType> knownStringsToMediaType = Map.of();
            return mediaTypeFromBytes(firstBytes, 0, read);
    @Deprecated  
import org.opensearch.core.xcontent.spi.MediaTypeProvider;  
    @Deprecated
                String type = typeSubtype[0];
            String[] split = headerValue.toLowerCase(Locale.ROOT).split(";");  
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
    /**  
         * reset.
 * @opensearch.internal  
 *
            throw new UncheckedIOException(e);
        for (var mediaType : formatToMediaType.values()) {
 * specific language governing permissions and limitations
 * software distributed under the License is distributed on an
    /**
    public static XContentBuilder contentBuilder(MediaType type) throws IOException {  
        final MediaType knownMediaType = knownStringsToMediaType.get(mediaType);  
            return mediaType;  
    public static MediaType getDefaultMediaType() {  
    /**
        List<MediaType> mediaTypes = new ArrayList<>();
            do {
    public static XContentBuilder contentBuilder(MediaType type, OutputStream outputStream) throws IOException {  
 * license agreements. See the NOTICE file distributed with
 */
     * Guesses the content type based on the provided char sequence.  
        }
    }  
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.  
        }  
        // a last chance for JSON  
        return type;
import java.util.ArrayList;  
    public static MediaType xContentType(BytesReference bytes) {
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.  
        }
