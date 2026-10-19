            try (InputStream stream = source.streamInput()) {
    public static String convertToJson(BytesReference bytes, boolean reformatJson, boolean prettyPrint, MediaType mediaType)
            builder.prettyPrint();
            return ordered ? parser.mapOrdered() : parser.map();
    /**
    /**
    public static void mergeDefaults(Map<String, Object> content, Map<String, Object> defaults) {
 */
        } else {
                );
    /**
        builder.copyCurrentStructure(parser);
                input = bytes.streamInput();
                if (compressedInput.markSupported() == false) {
    }
            )
import org.opensearch.core.xcontent.MediaType;
     * to avoid content type auto-detection
import org.opensearch.core.xcontent.XContentBuilder;
                        array.offset(),
        }
                NamedXContentRegistry.EMPTY,
    @Deprecated
                            Map.Entry<String, Object> entry = map.entrySet().iterator().next();
        throws IOException {
     */
        } catch (IOException e) {
    public static BytesReference childBytes(XContentParser parser) throws IOException {
        MediaType mediaType
                        mergedList.addAll(defaultList);
        throws IOException {
            ) {
    /**
                        for (Object o : contentList) {
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        }
                }
        }
    }
                compressedInput = compressor.threadLocalInputStream(bytes.streamInput());
            throw new OpenSearchParseException("Failed to parse content to map", e);
            }
                }
import java.util.Objects;
            if (modified) {
                            if (!mergedList.contains(o)) {
            if (compressor != null) {
                content.put(defaultEntry.getKey(), defaultEntry.getValue());
     * error. Note that unlike {@link #convertToMap(BytesReference, boolean)}, this doesn't automatically uncompress the input.
                        }
    /**
 * the Apache License, Version 2.0 (the "License"); you may
 *
        }
                    )
    }
        BytesReference bytes,
        for (Map.Entry<String, Object> changesEntry : changes.entrySet()) {
    ) throws IOException {
    public static boolean update(Map<String, Object> source, Map<String, Object> changes, boolean checkUpdatesAreUnequal) {
     * unnecessarily
        Objects.requireNonNull(mediaType);
 * Licensed to Elasticsearch under one or more contributor
    @Deprecated
                if (content.get(defaultEntry.getKey()) instanceof Map && defaultEntry.getValue() instanceof Map) {
     * This is useful for things like mappings where we're copying bytes around but don't
            InputStream compressedInput = null;
            if (old instanceof Map && changesEntry.getValue() instanceof Map) {
     * Convert a string in some {@link XContent} format to a {@link Map}. Throws an {@link OpenSearchParseException} if there is any
        return BytesReference.bytes(builder);
     * Convert a string in some {@link XContent} format to a {@link Map}. Throws an {@link OpenSearchParseException} if there is any
                                processed.put(entry.getKey(), map);
                return toJsonString(prettyPrint, parser);
import java.util.LinkedHashMap;
        }
            return ordered ? parser.mapOrdered() : parser.map();
     */
     * Merges the defaults provided as the second parameter into the content of the first. Only does recursive merge
                    List contentList = (List) content.get(defaultEntry.getKey());
    public static XContentParser createParser(
    @Deprecated
                } else if (content.get(defaultEntry.getKey()) instanceof List && defaultEntry.getValue() instanceof List) {
import org.opensearch.common.collect.Tuple;
                // recursive merge maps
    /**
            if (!(o instanceof Map)) {
            }
                    parser.getTokenLocation(),
 * Helper for xcontent utilities.
import java.util.ArrayList;
 */
                string
    @Deprecated
    }
     */
            }
    }
        }
import org.opensearch.core.xcontent.NamedXContentRegistry;
        } catch (IOException e) {
                    content.put(defaultEntry.getKey(), mergedList);
    public static Map<String, Object> convertToMap(XContent xContent, byte[] bytes, int offset, int length, boolean ordered)
            } catch (Exception e) {
                throw e;
        return convertToMap(bytes, ordered, null);
 *
            try (InputStream stream = input) {
            }
        }
     */
        XContentBuilder builder = XContentFactory.jsonBuilder();
    }
     * actually need to parse their contents, and so avoids building large maps of maps
     * {@link XContentBuilder#rawField(String, InputStream)}.
    /**
import java.io.IOException;
 * this work for additional information regarding copyright
 *     http://www.apache.org/licenses/LICENSE-2.0
     * @param checkUpdatesAreUnequal should this method check if updates to the same key (that are not both maps) are
    public static Map<String, Object> convertToMap(XContent xContent, InputStream input, boolean ordered) throws OpenSearchParseException {
        Objects.requireNonNull(mediaType);
    /**
        return convertToJson(new BytesArray(json), true, MediaTypeRegistry.JSON);
            }
            if (!content.containsKey(defaultEntry.getKey())) {
                    .createParser(xContentRegistry, deprecationHandler, array.array(), array.offset(), array.length());
    /**
        }
                modified |= update(
        } catch (IOException e) {
     * @param changes                the changes to update into updated
        Compressor compressor = CompressorRegistry.compressor(bytes);
                    }
        }
     * @return reformatted JSON
     * Returns the bytes that represent the XContent output of the provided {@link ToXContent} object, using the provided
                XContentParser parser = mediaType.xContent()
/*
                contentType = mediaType != null ? mediaType : MediaTypeRegistry.xContentType(stream);
     */
                final MediaType contentType = MediaTypeRegistry.xContentType(compressedInput);
     */
     */
import java.util.List;
package org.opensearch.common.xcontent;
    public static String convertToJson(BytesReference bytes, boolean reformatJson) throws IOException {
     * Writes a "raw" (bytes) field, handling cases where the bytes are compressed, and tries to optimize writing using
                    (Map<String, Object>) changesEntry.getValue(),
            return MediaTypeRegistry.xContentType(bytes).xContent().createParser(xContentRegistry, deprecationHandler, bytes.streamInput());
                    .createParser(
            }
        throws OpenSearchParseException {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, stream)
            }
    public static String convertToJson(BytesReference bytes, boolean reformatJson, boolean prettyPrint) throws IOException {
     */
        Compressor compressor = CompressorRegistry.compressor(source);
 * this file be licensed under the Apache-2.0 license or a
     * @deprecated use {@link #createParser(NamedXContentRegistry, DeprecationHandler, BytesReference, MediaType)}
import org.opensearch.core.compress.Compressor;
        } else {
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
     * @param json the JSON to format
     */
            try {
                        for (Map<String, Object> map : processed.values()) {
        if (compressor != null) {
                continue;
                throw e;
 * GitHub history for details.
        ) {
                InputStream stream = bytes.streamInput();
    }
                        array.array(),
        // It is safe to use EMPTY here because this never uses namedObject
                if (compressedInput != null) compressedInput.close();
 * under the License.
            }
            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
        DeprecationHandler deprecationHandler,
                        // all are in the form of [ {"key1" : {}}, {"key2" : {}} ], merge based on keys
                );
            }
        DeprecationHandler deprecationHandler,
                        }
    /**
import java.util.Map;
                compressedInput = compressor.threadLocalInputStream(bytes.streamInput());
     * Converts the given bytes into a map that is optionally ordered. The provided {@link XContentType} must be non-null.
        Compressor compressor = CompressorRegistry.compressor(bytes);
        boolean modified = false;
    public static void writeRawField(String field, BytesReference source, XContentType xContentType, XContentBuilder builder, Params params)
                    compressedStreamInput = new BufferedInputStream(compressedStreamInput);
    /**
        NamedXContentRegistry xContentRegistry,
            XContentParser parser = xContent.createParser(
                NamedXContentRegistry.EMPTY,
     * @param source                 the original map to be updated
            // update the field
                    (Map<String, Object>) source.get(changesEntry.getKey()),
                        for (Object o : defaultList) {
            }
            return mediaType.xContent().createParser(xContentRegistry, deprecationHandler, bytes.streamInput());
        ) {
                    } else {
import org.opensearch.core.xcontent.XContent;
        }
     */
    @Deprecated
        throws IOException {
    public static Tuple<XContentType, Map<String, Object>> convertToMap(BytesReference bytes, boolean ordered, XContentType xContentType) {
                builder.rawField(field, compressedStreamInput);
        parser.nextToken();
    }
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
        }
 * license agreements. See the NOTICE file distributed with
                return new Tuple<>(Objects.requireNonNull(contentType), convertToMap(contentType.xContent(), stream, ordered));
     * Convert a byte array in some {@link XContent} format to a {@link Map}. Throws an {@link OpenSearchParseException} if there is any
                            }
        // It is safe to use EMPTY here because this never uses namedObject
            }
            } catch (Exception e) {
        for (Object o : list) {
                            Map<String, Object> map = (Map<String, Object>) o;
        return convertToJson(bytes, reformatJson, false);
     *
 * compatible open source license.
                if (compressedStreamInput.markSupported() == false) {
            try (
            Object old = source.get(changesEntry.getKey());
                modified = true;
import org.opensearch.core.xcontent.MediaTypeRegistry;
        if (prettyPrint) {
        return convertToJson(bytes, reformatJson, prettyPrint, MediaTypeRegistry.xContent(bytes.toBytesRef().bytes));
     * Creates a parser based on the bytes provided
    private static boolean allListValuesAreMapsOfOne(List list) {
        }
     * Creates a parser for the bytes using the supplied content-type
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
     * @deprecated this method relies on auto-detection of content type. Use {@link #convertToMap(BytesReference, boolean, MediaType)}
            if (!checkUpdatesAreUnequal) {
     * whitespace e.g. for comparison in a test.
                return new Tuple<>(Objects.requireNonNull(contentType), convertToMap(contentType.xContent(), raw, offset, length, ordered));
                final int offset = arr.offset();
     * Updates the provided changes into the source. If the key exists in the changes, it overrides the one in source
            Compressor compressor = CompressorRegistry.compressor(bytes);
    /**
    }
    }
    public static Map<String, Object> convertToMap(XContent xContent, String string, boolean ordered) throws OpenSearchParseException {
            throw new OpenSearchParseException("Failed to parse content to map", e);
        for (Map.Entry<String, Object> defaultEntry : defaults.entrySet()) {
import org.opensearch.OpenSearchParseException;
            }
     * unless both are Maps, in which case it recursively updated it.
        try {
        if (bytes instanceof BytesArray array) {
        if (compressor != null) {
        try (
                builder.rawField(field, compressedStreamInput, xContentType);
            }
        } else {
    public static String convertToJson(BytesReference bytes, boolean reformatJson, boolean prettyPrint, XContentType xContentType)
        return builder.toString();
        return convertToJson(bytes, reformatJson, prettyPrint, (MediaType) xContentType);
            ) {
import java.io.BufferedInputStream;
            XContentParser parser = xContent.createParser(
        if (compressor != null) {
     * Converts the given bytes into a map that is optionally ordered. The provided {@link XContentType} must be non-null.
            } else {
            }
                        }
                            if (processed.containsKey(entry.getKey())) {
                }
        builder.copyCurrentStructure(parser);
    }
                return mediaType.xContent()
     *             instead with the proper {@link XContentType}
     */
            return ordered ? parser.mapOrdered() : parser.map();
            }
                        NamedXContentRegistry.EMPTY,
     */
public class XContentHelper {
        ) {
     * {@link XContentBuilder#rawField(String, InputStream, MediaType)}.
     * Accepts a JSON string, parses it and prints it without pretty-printing it. This is useful
import org.opensearch.core.compress.CompressorRegistry;
            source.put(changesEntry.getKey(), changesEntry.getValue());
                        // if both are lists, simply combine them, first the defaults, then the content
                contentType = mediaType != null ? mediaType : MediaTypeRegistry.mediaTypeFromBytes(raw, offset, length);
            }
/**
            if (!source.containsKey(changesEntry.getKey())) {
 */
                source.put(changesEntry.getKey(), changesEntry.getValue());
            final MediaType contentType;
                builder.rawField(field, stream, xContentType);
import org.opensearch.core.xcontent.XContentParser;
                            } else {
     * for inner maps.
                continue;
                    checkUpdatesAreUnequal && !modified
}
 * KIND, either express or implied.  See the License for the
                // safe to copy, change does not exist in source
                    compressedInput = new BufferedInputStream(compressedInput);
    public static void writeRawField(String field, BytesReference source, XContentBuilder builder, Params params) throws IOException {
                            }
                    List defaultList = (List) defaultEntry.getValue();
     */
                            processed.put(entry.getKey(), map);
                return false;
        }
    }
     * @deprecated use {@link #convertToJson(BytesReference, boolean, boolean, MediaType)} instead
        return modified;
                    mergeDefaults((Map<String, Object>) content.get(defaultEntry.getKey()), (Map<String, Object>) defaultEntry.getValue());
        if (Objects.isNull(xContentType) == false && xContentType instanceof XContentType == false) {
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
                return toJsonString(prettyPrint, parser);
     * where a piece of JSON is formatted for legibility, but needs to be stripped of unnecessary
                // copy it over, it does not exists in the content
    ) throws IOException {
    }
            try (InputStream stream = source.streamInput()) {
        if (mediaType == MediaTypeRegistry.JSON && !reformatJson) {
    }
    /**
            } else if (bytes instanceof BytesArray arr) {
     */
                // in the content and in the default, only merge compound ones (maps)
     *
import org.opensearch.core.xcontent.DeprecationHandler;
     * Converts the XContentType to a json string
 *
 * specific language governing permissions and limitations
            throw new OpenSearchParseException("Failed to parse content to map", e);
import org.opensearch.core.common.bytes.BytesReference;
    public static XContentParser createParser(
                            mergedList.add(map);
    public static BytesReference toXContent(ToXContent toXContent, XContentType xContentType, boolean humanReadable) throws IOException {
 * software distributed under the License is distributed on an
                        }
    @Deprecated
            if (((Map) o).size() != 1) {
                    compressedInput = new BufferedInputStream(compressedInput);
                input
     * Converts the given bytes into a map that is optionally ordered.
     * {@link XContentType}. Wraps the output into a new anonymous object according to the value returned
        Objects.requireNonNull(xContentType);
                    "Expected [START_OBJECT] but got [" + parser.currentToken() + "]"
import org.opensearch.core.xcontent.ToXContent;
        if (compressor != null) {
                                mergedList.add(o);
                if (compressedInput != null) compressedInput.close();
     */
                        // just make sure not to add the same value twice
     * error.
     */
    }
                                mergeDefaults(processed.get(entry.getKey()), map);
                            Map.Entry<String, Object> entry = map.entrySet().iterator().next();
    /**
    }
     * Converts the given {@link MediaType} to a json string
                if (compressedInput.markSupported() == false) {
                throw new XContentParseException(
                InputStream compressedStreamInput = compressor.threadLocalInputStream(bytes.streamInput());
            throw new IllegalArgumentException(
        return convertToJson(bytes, reformatJson, false, mediaType);
                    if (allListValuesAreMapsOfOne(defaultList) && allListValuesAreMapsOfOne(contentList)) {
        throws OpenSearchParseException {
                "XContentHelper.convertToMap does not support media type [" + xContentType.getClass().getName() + "]"
     *
 * Modifications Copyright OpenSearch Contributors. See
        Compressor compressor = CompressorRegistry.compressor(source);
 * The OpenSearch Contributors require contributions made to
                        for (Object o : contentList) {
                }
            )
            InputStream compressedInput = null;
                builder.rawField(field, stream);
            modified = !Objects.equals(old, changesEntry.getValue());
                continue;
import java.io.InputStream;
     * @deprecated use {@link #writeRawField(String, BytesReference, XContentType, XContentBuilder, Params)} to avoid content type
                final byte[] raw = arr.array();
        }
            } else {
        // It is safe to use EMPTY here because this never uses namedObject
/*
                    List mergedList = new ArrayList();
                return contentType.xContent().createParser(xContentRegistry, deprecationHandler, compressedInput);
    }
            try {
    }
        return (Tuple<XContentType, Map<String, Object>>) convertToMap(bytes, ordered, (MediaType) xContentType);
                input = compressedStreamInput;
                continue;
    }
    public static Tuple<XContentType, Map<String, Object>> convertToMap(BytesReference bytes, boolean ordered)
            try (InputStream compressedStreamInput = compressor.threadLocalInputStream(source.streamInput())) {
            throw new OpenSearchParseException("Failed to parse content to map", e);
     * Returns the contents of an object as an unparsed BytesReference
import org.opensearch.core.xcontent.ToXContent.Params;
     * @return true if the source map was modified
 * Unless required by applicable law or agreed to in writing,
        // It is safe to use EMPTY here because this never uses namedObject
            );
 */
                length
            }
                            Map<String, Object> map = (Map<String, Object>) o;
        }
            try (
                offset,
        XContentBuilder builder = XContentBuilder.builder(parser.contentType().xContent());
        try (
     * @throws IOException if the reformatting fails, e.g. because the JSON is not well-formed
        }
    /**
    public static Tuple<? extends MediaType, Map<String, Object>> convertToMap(BytesReference bytes, boolean ordered, MediaType mediaType)
        NamedXContentRegistry xContentRegistry,
    }
        } else {
    public static String convertToJson(BytesReference bytes, boolean reformatJson, MediaType mediaType) throws IOException {
                modified = true;
     * @deprecated use {@link #convertToMap(BytesReference, boolean, MediaType)} instead
        return org.opensearch.core.xcontent.XContentHelper.toXContent(toXContent, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
                        array.length()
    @Deprecated
    /**
                XContentParser parser = mediaType.xContent()
    private static String toJsonString(boolean prettyPrint, XContentParser parser) throws IOException {
            return bytes.utf8ToString();
                return false;
            }
            )
            InputStream input;
        return true;
     * Writes a "raw" (bytes) field, handling cases where the bytes are compressed, and tries to optimize writing using
     */
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.core.common.bytes.BytesArray;
    public static String stripWhitespace(String json) throws IOException {
                                // put the default entries after the content ones.
    /**
        BytesReference bytes
import org.opensearch.core.xcontent.XContentParseException;
                        Map<String, Map<String, Object>> processed = new LinkedHashMap<>();
 * @opensearch.internal
                final int length = arr.length();
        throws OpenSearchParseException {
     *
    }
/*
 *
        } else {
     * auto-detection
     * <p>
 * not use this file except in compliance with the License.
            XContentParser parser = xContent.createParser(
                NamedXContentRegistry.EMPTY,
    @Deprecated
        try (
            try (InputStream compressedStreamInput = compressor.threadLocalInputStream(source.streamInput())) {
                bytes,
        } catch (IOException e) {
     * by the {@link ToXContent#isFragment()} method returns.
            if (bytes instanceof BytesArray array) {
                return mediaType.xContent().createParser(xContentRegistry, deprecationHandler, compressedInput);
    }
 * ownership. Elasticsearch licenses this file to you under
     *                               unequal?  This is just a .equals check on the objects, but that can take some time on long strings.
 * You may obtain a copy of the License at
     * error. Note that unlike {@link #convertToMap(BytesReference, boolean)}, this doesn't automatically uncompress the input.
@SuppressWarnings("unchecked")
