            return mediaType;
            int current;
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
    private static void setDefaultMediaType(final MediaType mediaType) {
        throw new IllegalArgumentException("No matching content type for " + type);
        }
            if (typeMap.containsKey(typeWithSubtype)) {
                        + "]"
            firstBytes[0] = (byte) current;
    /**
import org.opensearch.core.common.bytes.BytesReference;
 */
    public static MediaType xContentType(CharSequence content) {
        }
        for (int i = jsonStart; i < length; i++) {
        private final MediaType mediaType;
 * under the License.
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
 * Modifications Copyright OpenSearch Contributors. See
    @Deprecated
    public static MediaType getDefaultMediaType() {
            while (read < GUESS_HEADER_LENGTH) {
         * We need to guess the content type. To do this, we look for the first non-whitespace character and then try to guess the content
        for (var mediaType : formatToMediaType.values()) {
            if (typeSubtype.length == 2) {
        if (bytes instanceof BytesArray array) {
import java.io.UncheckedIOException;
                .flatMap(map -> map.entrySet().stream())
            return null;
 * not use this file except in compliance with the License.
    // JSON is a core type, so we create a static instance for implementations that require JSON format (e.g., tests)
            String[] split = headerValue.toLowerCase(Locale.ROOT).split(";");
                    break;
                MediaType mediaType = typeWithSubtypeToMediaType.get(type + "/" + subtype);
        }
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
        throw new IllegalArgumentException("No matching content type for " + type);
import java.util.List;
        return null;
    }
        return parsedMediaType != null ? parsedMediaType.getMediaType() : null;
         * type on the GUESS_HEADER_LENGTH bytes that follow. We do this in a way that does not modify the initial read position in the
        Map<String, MediaType> amt = new HashMap<>();
 * this work for additional information regarding copyright
            if (mediaType.detectedXContent(content, length)) {
        }
    public static MediaType xContentType(InputStream si) throws IOException {
        for (Map.Entry<String, MediaType> entry : additionalMediaTypes.entrySet()) {
    private static boolean hasSpaces(String s) {
     * @return a parsed media-type
            }
 * @opensearch.internal
    /**
            return knownMediaType;
                if (r == -1) {
        return type;
 * Licensed to Elasticsearch under one or more contributor
    }
     *
 */
        }
            throw new XContentParseException("Failed to derive xcontent");
            throw new RuntimeException(
    /**
        if (format == null) {
 * GitHub history for details.
    public static XContentBuilder contentBuilder(MediaType type, OutputStream outputStream) throws IOException {
        Map<String, MediaType> formatMap = new HashMap<>(formatToMediaType);
 *
    public static MediaType xContent(CharSequence content) {
/*
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
    // Default mediaType singleton
 */
        ParsedMediaType parsedMediaType = parseMediaType(mediaType);
                read += r;
        }
            if (c == '{') {
 * license agreements. See the NOTICE file distributed with
     * Guesses the content type based on the provided bytes.
            if (mediaType.detectedXContent(data, offset, length)) {
                return MediaType.fromMediaType("application/json");
 *
    /**
        return s.trim().equals(s) == false;
            if (Character.isWhitespace(b) == false) {
        }
            }
            this.parameters = parameters;
            return null;
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
        // fallback for json
            // scan until we find the first non-whitespace character or the end of the stream
            knownStringMap.put(mediaType.mediaTypeWithoutParameters(), mediaType);
     */
        }
        // JSON may be preceded by UTF-8 BOM
     *
            char c = content.charAt(i);
        }
     * Guesses the content type based on the provided bytes and returns the corresponding {@link XContent}
            }
 */
        try {
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
    public static XContentBuilder contentBuilder(MediaType type) throws IOException {
            formatMap.putIfAbsent(mediaType.format(), mediaType); // ignore if the additional type mapping already exists
    }
 * Parses supported internet media types
            si.reset();
/*
            typeMap.put(mediaType.typeWithSubtype(), mediaType);
        final MediaType knownMediaType = knownStringsToMediaType.get(mediaType);
            return null;
        formatToMediaType = Map.copyOf(formatMap);
    @Deprecated
        typeWithSubtypeToMediaType = Map.copyOf(typeMap);
import java.util.stream.Collectors;
     * Guesses the content type based on the provided input stream without consuming it.
            byte b = data[offset + i];
    public static class ParsedMediaType {
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
                return type.contentBuilder(outputStream);
        if (length == 0) {
     * A media type object that contains all the information provided on a Content-Type or Accept header
        for (var mediaType : formatToMediaType.values()) {
        if (length > 3 && data[offset] == (byte) 0xEF && data[offset + 1] == (byte) 0xBB && data[offset + 2] == (byte) 0xBF) {
            }
import java.io.InputStream;
     * Guesses the content type based on the provided bytes.
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
         * underlying input stream. This is why the input stream must support mark/reset and why we repeatedly mark the read position and
                String type = typeSubtype[0];
     *
        } catch (IOException e) {
import java.util.Map;
        return null;
        }
                if (mediaType != null) {
    public static MediaType xContentType(BytesReference bytes) {
     * @param headerValue a header value from Accept or Content-Type
     */
    @Deprecated
 * Unless required by applicable law or agreed to in writing,
        return formatToMediaType.get(format.toLowerCase(Locale.ROOT));
        }
     *
        int length = content.length() < GUESS_HEADER_LENGTH ? content.length() : GUESS_HEADER_LENGTH;
     */
        }
    private static MediaType DEFAULT_MEDIA_TYPE;
    public static ParsedMediaType parseMediaType(String headerValue) {
            return parameters;
    // todo we should explore moving the concrete JSON implementation from the xcontent library to core
            if (b == '{') {
    /**
 * You may obtain a copy of the License at
        } else {
                return mediaType;
    public static MediaType fromFormat(String format) {
                String subtype = typeSubtype[1];
    }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                }
     */
        Map<String, MediaType> knownStringMap = new HashMap<>(knownStringsToMediaType);
        }
                return mediaType;
                        // spaces are allowed between parameters, but not between '=' sign
    /**
        int totalLength = data.length;
 * specific language governing permissions and limitations
            amt = Stream.of(amt, provider.getAdditionalMediaTypes())
                "unable to reset the default media type from current default [" + DEFAULT_MEDIA_TYPE + "] to [" + mediaType + "]"
                        + entry.getValue().format()
    }
            do {
        public MediaType getMediaType() {
        int jsonStart = 0;
     *
            throw new XContentParseException("Failed to derive xcontent");
     */
        for (MediaType mediaType : acceptedMediaTypes) {
            }
                        + "Type already exists and is mapped to: [."
import java.io.OutputStream;
 * SPDX-License-Identifier: Apache-2.0
import java.util.ServiceLoader;
        }
     */
        if (DEFAULT_MEDIA_TYPE != null) {
            knownStringMap.put(mediaType.mediaType(), mediaType);
                        parameters.put(keyValueParam[0], keyValueParam[1]);
    }
     */
    @Deprecated
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
    }
                if (current == -1) {
         */
    /**
        if (type == null) {
        for (var mediaType : formatToMediaType.values()) {
     */
    }
            }
package org.opensearch.core.xcontent;
        return DEFAULT_MEDIA_TYPE;
    }
            if (type == mediaType) {
        return xContent(data, 0, data.length);
    }
        private final Map<String, String> parameters;
        if (mediaType == null) {
                    Map<String, String> parameters = new HashMap<>();
    public static MediaType mediaTypeFromBytes(final byte[] data, int offset, int length) {
        si.mark(Integer.MAX_VALUE);
    }
            if (formatMap.containsKey(mediaType.format())) {
        if (si.markSupported() == false) {
        // ensures the map is not overwritten:
        }
        MediaType type = xContentType(content);
/*
public final class MediaTypeRegistry {
            return xContentType(inputStream);
            return null;
import java.util.stream.Stream;
        } else if ((offset + length) > totalLength) {
                );
import java.util.HashMap;
            assert inputStream.markSupported();
                    return null;
        public ParsedMediaType(MediaType mediaType, Map<String, String> parameters) {
            final byte[] firstBytes = new byte[GUESS_HEADER_LENGTH];
    private static Map<String, MediaType> formatToMediaType = Map.of();
        }
        try {
        }
            int read = 1;
                        + entry.getKey()
        MediaType type = mediaTypeFromBytes(data, offset, length);
                        String[] keyValueParam = split[i].trim().split("=");
        }
                        }
                }
            // now guess the content type off the next GUESS_HEADER_LENGTH bytes including the current byte
                            return null;
            }
        }
    private static Map<String, MediaType> knownStringsToMediaType = Map.of();
            typeMap.put(typeWithSubtype, mediaType);
        }
                        if (keyValueParam.length != 2 || hasSpaces(keyValueParam[0]) || hasSpaces(keyValueParam[1])) {
            return null;
        knownStringsToMediaType = Map.copyOf(knownStringMap);
import java.io.IOException;
                return fromMediaType("application/json");
     */
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
    }
    }
     *
        JSON = fromMediaType("application/json");
        setDefaultMediaType(JSON);
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
 * the Apache License, Version 2.0 (the "License"); you may
            }
    /**
        if (type == null) {
    public static MediaType xContent(byte[] data) {
            return mediaTypeFromBytes(array.array(), array.offset(), array.length());
 * The OpenSearch Contributors require contributions made to
            } while (Character.isWhitespace((char) current));
 *
                        + "]. "
        }
    private static Map<String, MediaType> typeWithSubtypeToMediaType = Map.of();
    /**
            throw new IllegalArgumentException("Cannot guess the xcontent type without mark/reset support on " + si.getClass());
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
         * reset.
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
            }
            mediaTypes.addAll(provider.getMediaTypes());
        register(mediaTypes.toArray(new MediaType[0]), amt);
                current = si.read();
        }
            throw new UncheckedIOException(e);
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
                throw new IllegalArgumentException(
    static {
 * this file be licensed under the Apache-2.0 license or a
    public static final MediaType JSON;
}
        for (var mediaType : formatToMediaType.values()) {
    public static MediaType fromMediaType(String mediaType) {
    }
        return null;
            assert false : "Should not happen, we're just reading bytes from memory";
        for (int i = 0; i < length; i++) {
            jsonStart = 3;
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
        // Skip parsing if the string is an exact match for any known string value
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
                break;
                return type.contentBuilder();
    private static void register(MediaType[] acceptedMediaTypes, Map<String, MediaType> additionalMediaTypes) {
        Map<String, MediaType> typeMap = new HashMap<>(typeWithSubtypeToMediaType);
                throw new IllegalArgumentException("unable to register mediaType: [" + mediaType.format() + "]. Type already exists.");
import java.util.Locale;
        for (MediaTypeProvider provider : ServiceLoader.load(MediaTypeProvider.class, MediaTypeProvider.class.getClassLoader())) {
            DEFAULT_MEDIA_TYPE = mediaType;
        } finally {
            String[] typeSubtype = split[0].trim().split("/");
     */
        // a last chance for JSON
    @Deprecated
     * Guesses the content type based on the provided char sequence.
            if (type == mediaType) {
        }
        return type;
     * Guesses the content (type) based on the provided char sequence and returns the corresponding {@link XContent}
     * Returns a binary content builder for the provided content type.
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, Map.Entry::getValue));
            }
                break;
                final int r = si.read(firstBytes, read, GUESS_HEADER_LENGTH - read);
import org.opensearch.core.common.bytes.BytesArray;
        }
    }
    public static MediaType xContent(final byte[] data, int offset, int length) {
import org.opensearch.core.xcontent.spi.MediaTypeProvider;
        if (totalLength == 0 || length == 0) {
                    }
/**
     * Guesses the content (type) based on the provided char sequence and returns the corresponding {@link XContent}
            );
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
                    for (int i = 1; i < split.length; i++) {
     * @deprecated the content type should not be guessed except for few cases where we effectively don't know the content type.
            String typeWithSubtype = entry.getKey().toLowerCase(Locale.ROOT);
                    "unable to register mediaType: ["
        public Map<String, String> getParameters() {
     * parsing media type that follows https://tools.ietf.org/html/rfc7231#section-3.1.1.1
        if (headerValue != null) {
        }
            }
     * This method is deprecated to prevent usages of it from spreading further without specific reasons.
 * compatible open source license.
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
    }
     * The REST layer should move to reading the Content-Type header instead. There are other places where auto-detection may be needed.
        }
    @Deprecated
            if (Character.isWhitespace(c) == false) {
        if (knownMediaType != null) {
import java.util.ArrayList;
 * KIND, either express or implied.  See the License for the
    }
        /*
    @Deprecated
    public static final int GUESS_HEADER_LENGTH = 20;
                }
            return mediaTypeFromBytes(firstBytes, 0, read);
        List<MediaType> mediaTypes = new ArrayList<>();
            MediaType mediaType = entry.getValue();
    /**
            final InputStream inputStream = bytes.streamInput();
 * software distributed under the License is distributed on an
            formatMap.put(mediaType.format(), mediaType);
            this.mediaType = mediaType;
     *
                    return new ParsedMediaType(mediaType, parameters);
 * ownership. Elasticsearch licenses this file to you under
            }
    }
