        Compressor compressor = CompressorRegistry.compressor(source);
        throws OpenSearchParseException {
                            Map.Entry<String, Object> entry = map.entrySet().iterator().next();
                contentType = mediaType != null ? mediaType : MediaTypeRegistry.mediaTypeFromBytes(raw, offset, length);
     * @throws IOException if the reformatting fails, e.g. because the JSON is not well-formed  
                NamedXContentRegistry.EMPTY,  
                        // just make sure not to add the same value twice
                return false;
                bytes,
            } else {  
     * @deprecated this method relies on auto-detection of content type. Use {@link #convertToMap(BytesReference, boolean, MediaType)}  
    }  
import org.opensearch.core.xcontent.XContentParser;
            )  
 *
        parser.nextToken();
import org.opensearch.core.xcontent.NamedXContentRegistry;
import java.util.Map;  
                    List contentList = (List) content.get(defaultEntry.getKey());  
     * Converts the given {@link MediaType} to a json string  
                builder.rawField(field, compressedStreamInput, xContentType);
        Compressor compressor = CompressorRegistry.compressor(bytes);
 * not use this file except in compliance with the License.
            if (compressor != null) {  
        return convertToJson(bytes, reformatJson, false);
    }  
     */
    private static boolean allListValuesAreMapsOfOne(List list) {
    }  
            throw new OpenSearchParseException("Failed to parse content to map", e);
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
                    )
        }
                    (Map<String, Object>) changesEntry.getValue(),
                                mergedList.add(o);  
                source.put(changesEntry.getKey(), changesEntry.getValue());
            throw new OpenSearchParseException("Failed to parse content to map", e);  
import java.io.BufferedInputStream;  
        }
    public static String stripWhitespace(String json) throws IOException {
                builder.rawField(field, stream, xContentType);
/**  
        } catch (IOException e) {
        if (Objects.isNull(xContentType) == false && xContentType instanceof XContentType == false) {
    /**  
     * Convert a byte array in some {@link XContent} format to a {@link Map}. Throws an {@link OpenSearchParseException} if there is any  
        BytesReference bytes,
        try (  
            if (modified) {  
     *
     */
    /**
                    (Map<String, Object>) source.get(changesEntry.getKey()),
 *
                final int offset = arr.offset();
                final byte[] raw = arr.array();
                        for (Map<String, Object> map : processed.values()) {  
        builder.copyCurrentStructure(parser);
            InputStream compressedInput = null;  
     * @return reformatted JSON
                }
 *  
            }  
        // It is safe to use EMPTY here because this never uses namedObject
    /**
        } catch (IOException e) {
                            if (processed.containsKey(entry.getKey())) {
            builder.prettyPrint();
import org.opensearch.OpenSearchParseException;
            try (InputStream stream = input) {  
     * @deprecated use {@link #convertToMap(BytesReference, boolean, MediaType)} instead  
            }  
     */  
    public static XContentParser createParser(
    }
                final int length = arr.length();  
    /**
    @Deprecated
            Object old = source.get(changesEntry.getKey());  
                        for (Object o : contentList) {  
            return MediaTypeRegistry.xContentType(bytes).xContent().createParser(xContentRegistry, deprecationHandler, bytes.streamInput());
@SuppressWarnings("unchecked")
import org.opensearch.core.xcontent.DeprecationHandler;
    }
    @Deprecated  
    }
     */  
            )
        try {
            try (InputStream compressedStreamInput = compressor.threadLocalInputStream(source.streamInput())) {  
import org.opensearch.core.xcontent.ToXContent;
                content.put(defaultEntry.getKey(), defaultEntry.getValue());
        throws OpenSearchParseException {
    }
            }
        return convertToJson(new BytesArray(json), true, MediaTypeRegistry.JSON);  
                    List defaultList = (List) defaultEntry.getValue();
        DeprecationHandler deprecationHandler,
            ) {
import java.util.Objects;
     * This is useful for things like mappings where we're copying bytes around but don't
                return toJsonString(prettyPrint, parser);  
                return new Tuple<>(Objects.requireNonNull(contentType), convertToMap(contentType.xContent(), stream, ordered));
            }
        }
                        for (Object o : defaultList) {
     * Converts the XContentType to a json string
            throw new OpenSearchParseException("Failed to parse content to map", e);
            // update the field
 * Unless required by applicable law or agreed to in writing,
                XContentParser parser = mediaType.xContent()
            if (bytes instanceof BytesArray array) {
                    .createParser(xContentRegistry, deprecationHandler, array.array(), array.offset(), array.length());
                NamedXContentRegistry.EMPTY,
            XContentParser parser = xContent.createParser(
    /**
    }
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,
        MediaType mediaType  
}
        return convertToMap(bytes, ordered, null);  
    public static String convertToJson(BytesReference bytes, boolean reformatJson, boolean prettyPrint, MediaType mediaType)
            try (  
 * SPDX-License-Identifier: Apache-2.0
    public static String convertToJson(BytesReference bytes, boolean reformatJson, boolean prettyPrint, XContentType xContentType)  
                        array.array(),
    public static String convertToJson(BytesReference bytes, boolean reformatJson) throws IOException {
     */
     * Creates a parser for the bytes using the supplied content-type  
 * ownership. Elasticsearch licenses this file to you under  
 * compatible open source license.
                return mediaType.xContent().createParser(xContentRegistry, deprecationHandler, compressedInput);
        return convertToJson(bytes, reformatJson, false, mediaType);
     * @param json the JSON to format
        ) {
            return bytes.utf8ToString();  
    @Deprecated  
        for (Object o : list) {
     * Convert a string in some {@link XContent} format to a {@link Map}. Throws an {@link OpenSearchParseException} if there is any
        DeprecationHandler deprecationHandler,
     * whitespace e.g. for comparison in a test.
            try (InputStream stream = source.streamInput()) {  
                        }
package org.opensearch.common.xcontent;
     * unnecessarily
                        }
 */
     * @deprecated use {@link #createParser(NamedXContentRegistry, DeprecationHandler, BytesReference, MediaType)}
    /**
import java.io.InputStream;
        return BytesReference.bytes(builder);
                    List mergedList = new ArrayList();
        } else {
 * license agreements. See the NOTICE file distributed with
        NamedXContentRegistry xContentRegistry,  
            Compressor compressor = CompressorRegistry.compressor(bytes);
                            Map<String, Object> map = (Map<String, Object>) o;
                length  
 * Licensed to Elasticsearch under one or more contributor  
    }
    }  
                offset,
                // recursive merge maps
import org.opensearch.core.common.bytes.BytesArray;  
 * the Apache License, Version 2.0 (the "License"); you may
                modified = true;  
     * Returns the bytes that represent the XContent output of the provided {@link ToXContent} object, using the provided
        for (Map.Entry<String, Object> changesEntry : changes.entrySet()) {
            if (!(o instanceof Map)) {  
 * GitHub history for details.
    public static void mergeDefaults(Map<String, Object> content, Map<String, Object> defaults) {
        for (Map.Entry<String, Object> defaultEntry : defaults.entrySet()) {
            if (!checkUpdatesAreUnequal) {  
        if (bytes instanceof BytesArray array) {
        return org.opensearch.core.xcontent.XContentHelper.toXContent(toXContent, xContentType, ToXContent.EMPTY_PARAMS, humanReadable);
    public static BytesReference childBytes(XContentParser parser) throws IOException {  
                );
     * @deprecated use {@link #convertToJson(BytesReference, boolean, boolean, MediaType)} instead  
        throws IOException {  
        }
        try (
            }  
        }  
    /**
     */
    /**  
                        array.length()  
    }
                }
        return (Tuple<XContentType, Map<String, Object>>) convertToMap(bytes, ordered, (MediaType) xContentType);  
        ) {
        } else {  
    public static void writeRawField(String field, BytesReference source, XContentType xContentType, XContentBuilder builder, Params params)
 * @opensearch.internal  
import org.opensearch.core.xcontent.XContent;
                throw new XContentParseException(  
                    checkUpdatesAreUnequal && !modified  
    /**
    }
/*  
    public static XContentParser createParser(
            return ordered ? parser.mapOrdered() : parser.map();
     */
                    mergeDefaults((Map<String, Object>) content.get(defaultEntry.getKey()), (Map<String, Object>) defaultEntry.getValue());  
                InputStream compressedStreamInput = compressor.threadLocalInputStream(bytes.streamInput());
            try (InputStream stream = source.streamInput()) {
            }  
        // It is safe to use EMPTY here because this never uses namedObject
        throws OpenSearchParseException {
                            if (!mergedList.contains(o)) {
import org.opensearch.core.compress.CompressorRegistry;  
        }
                }
            if (old instanceof Map && changesEntry.getValue() instanceof Map) {
                }
     * by the {@link ToXContent#isFragment()} method returns.
                // safe to copy, change does not exist in source
    public static BytesReference toXContent(ToXContent toXContent, XContentType xContentType, boolean humanReadable) throws IOException {
        ) {  
                    }  
 * You may obtain a copy of the License at  
                );  
                    .createParser(
     * Returns the contents of an object as an unparsed BytesReference  
        if (compressor != null) {
     *
     * @deprecated use {@link #writeRawField(String, BytesReference, XContentType, XContentBuilder, Params)} to avoid content type
        } else {
        return true;
    private static String toJsonString(boolean prettyPrint, XContentParser parser) throws IOException {
                continue;
     * for inner maps.
        }  
    @Deprecated  
     * error.
    /**  
                            }
                        Map<String, Map<String, Object>> processed = new LinkedHashMap<>();
    /**
        }
     * Converts the given bytes into a map that is optionally ordered.
        return builder.toString();
        Compressor compressor = CompressorRegistry.compressor(bytes);  
import org.opensearch.core.common.bytes.BytesReference;
                    parser.getTokenLocation(),
                if (compressedInput.markSupported() == false) {
            }
                        for (Object o : contentList) {
                if (content.get(defaultEntry.getKey()) instanceof Map && defaultEntry.getValue() instanceof Map) {
            final MediaType contentType;  
import org.opensearch.core.xcontent.MediaType;
                throw e;
     * unless both are Maps, in which case it recursively updated it.
    /**  
            return ordered ? parser.mapOrdered() : parser.map();
                builder.rawField(field, compressedStreamInput);  
                continue;
     * @return true if the source map was modified
                                mergeDefaults(processed.get(entry.getKey()), map);  
            if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
    public static Tuple<XContentType, Map<String, Object>> convertToMap(BytesReference bytes, boolean ordered)
    @Deprecated
 */  
     * {@link XContentType}. Wraps the output into a new anonymous object according to the value returned  
                if (compressedInput != null) compressedInput.close();  
     * <p>
                    compressedInput = new BufferedInputStream(compressedInput);  
                // in the content and in the default, only merge compound ones (maps)
                            Map<String, Object> map = (Map<String, Object>) o;  
                            mergedList.add(map);
                            } else {
                } else if (content.get(defaultEntry.getKey()) instanceof List && defaultEntry.getValue() instanceof List) {
        if (parser.currentToken() != XContentParser.Token.START_OBJECT) {
import java.util.ArrayList;  
/*  
        return convertToJson(bytes, reformatJson, prettyPrint, MediaTypeRegistry.xContent(bytes.toBytesRef().bytes));
    }
import java.io.IOException;
     * Convert a string in some {@link XContent} format to a {@link Map}. Throws an {@link OpenSearchParseException} if there is any
            } else if (bytes instanceof BytesArray arr) {  
    }
     * to avoid content type auto-detection
                continue;
    ) throws IOException {
            if (!source.containsKey(changesEntry.getKey())) {  
 *
        if (compressor != null) {
     * Writes a "raw" (bytes) field, handling cases where the bytes are compressed, and tries to optimize writing using
                input = bytes.streamInput();
                    compressedStreamInput = new BufferedInputStream(compressedStreamInput);  
                        array.offset(),
                DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
            }
                return false;
    }  
            try (
            }
     */
     *
 * Helper for xcontent utilities.
                return toJsonString(prettyPrint, parser);
import org.opensearch.core.xcontent.ToXContent.Params;  
        Objects.requireNonNull(mediaType);
        }
    public static String convertToJson(BytesReference bytes, boolean reformatJson, boolean prettyPrint) throws IOException {  
    @Deprecated
                return contentType.xContent().createParser(xContentRegistry, deprecationHandler, compressedInput);
        }  
    }
     * Converts the given bytes into a map that is optionally ordered. The provided {@link XContentType} must be non-null.
                NamedXContentRegistry.EMPTY,
    public static Tuple<? extends MediaType, Map<String, Object>> convertToMap(BytesReference bytes, boolean ordered, MediaType mediaType)  
            return ordered ? parser.mapOrdered() : parser.map();  
        NamedXContentRegistry xContentRegistry,  
     * Writes a "raw" (bytes) field, handling cases where the bytes are compressed, and tries to optimize writing using
     * where a piece of JSON is formatted for legibility, but needs to be stripped of unnecessary
    public static String convertToJson(BytesReference bytes, boolean reformatJson, MediaType mediaType) throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
                        DeprecationHandler.THROW_UNSUPPORTED_OPERATION,  
        }
     */
import org.opensearch.common.collect.Tuple;
                if (compressedInput.markSupported() == false) {  
        } else {  
            try {  
            if (((Map) o).size() != 1) {  
    public static void writeRawField(String field, BytesReference source, XContentBuilder builder, Params params) throws IOException {
import org.opensearch.core.xcontent.XContentParseException;  
 * this file be licensed under the Apache-2.0 license or a
                if (compressedStreamInput.markSupported() == false) {
                return new Tuple<>(Objects.requireNonNull(contentType), convertToMap(contentType.xContent(), raw, offset, length, ordered));
    }
    public static boolean update(Map<String, Object> source, Map<String, Object> changes, boolean checkUpdatesAreUnequal) {  
        }  
/*
 * specific language governing permissions and limitations
        throws IOException {
    }  
    /**
     * error. Note that unlike {@link #convertToMap(BytesReference, boolean)}, this doesn't automatically uncompress the input.  
        if (compressor != null) {
                compressedInput = compressor.threadLocalInputStream(bytes.streamInput());
        builder.copyCurrentStructure(parser);
     * auto-detection
     *  
            }
     * {@link XContentBuilder#rawField(String, InputStream)}.  
     * error. Note that unlike {@link #convertToMap(BytesReference, boolean)}, this doesn't automatically uncompress the input.
                                processed.put(entry.getKey(), map);  
                continue;
                        // if both are lists, simply combine them, first the defaults, then the content
                    } else {  
                string
            InputStream input;
    ) throws IOException {  
        return modified;  
     * Creates a parser based on the bytes provided  
        return convertToJson(bytes, reformatJson, prettyPrint, (MediaType) xContentType);
            XContentParser parser = xContent.createParser(
                modified |= update(  
    @Deprecated
     */  
        // It is safe to use EMPTY here because this never uses namedObject  
            return mediaType.xContent().createParser(xContentRegistry, deprecationHandler, bytes.streamInput());  
            } catch (Exception e) {
    }  
        }
                return mediaType.xContent()  
    public static Map<String, Object> convertToMap(XContent xContent, InputStream input, boolean ordered) throws OpenSearchParseException {
            } catch (Exception e) {  
            }
        }
                builder.rawField(field, stream);
import org.opensearch.core.xcontent.XContentBuilder;
     */
     * Converts the given bytes into a map that is optionally ordered. The provided {@link XContentType} must be non-null.
            }
                throw e;
    /**
                        NamedXContentRegistry.EMPTY,
        }  
            throw new IllegalArgumentException(
        throws IOException {
                        mergedList.addAll(defaultList);  
import java.util.List;
            }
        } catch (IOException e) {  
        XContentBuilder builder = XContentBuilder.builder(parser.contentType().xContent());  
                InputStream stream = bytes.streamInput();
    }
 * KIND, either express or implied.  See the License for the
        try (  
     * @param source                 the original map to be updated  
                            Map.Entry<String, Object> entry = map.entrySet().iterator().next();
        Objects.requireNonNull(mediaType);
                final MediaType contentType = MediaTypeRegistry.xContentType(compressedInput);  
                    compressedInput = new BufferedInputStream(compressedInput);
                                // put the default entries after the content ones.
                        }
                input = compressedStreamInput;
                    if (allListValuesAreMapsOfOne(defaultList) && allListValuesAreMapsOfOne(contentList)) {  
     *             instead with the proper {@link XContentType}
 * under the License.  
            ) {
        XContentBuilder builder = XContentFactory.jsonBuilder();  
    public static Map<String, Object> convertToMap(XContent xContent, String string, boolean ordered) throws OpenSearchParseException {
     */
        } catch (IOException e) {
                contentType = mediaType != null ? mediaType : MediaTypeRegistry.xContentType(stream);
            }
    @Deprecated
        } else {
 * The OpenSearch Contributors require contributions made to  
import org.opensearch.core.compress.Compressor;
            }  
    public static Tuple<XContentType, Map<String, Object>> convertToMap(BytesReference bytes, boolean ordered, XContentType xContentType) {  
    /**  
        Objects.requireNonNull(xContentType);  
            throw new OpenSearchParseException("Failed to parse content to map", e);
                    "Expected [START_OBJECT] but got [" + parser.currentToken() + "]"
     */
     * @param changes                the changes to update into updated
            try (InputStream compressedStreamInput = compressor.threadLocalInputStream(source.streamInput())) {
        if (prettyPrint) {
     */  
            modified = !Objects.equals(old, changesEntry.getValue());
    public static Map<String, Object> convertToMap(XContent xContent, byte[] bytes, int offset, int length, boolean ordered)  
 */
        if (mediaType == MediaTypeRegistry.JSON && !reformatJson) {
                input
        }
            } else {  
     */  
                modified = true;
            }
        if (compressor != null) {
     * @param checkUpdatesAreUnequal should this method check if updates to the same key (that are not both maps) are
            InputStream compressedInput = null;
 * Modifications Copyright OpenSearch Contributors. See
            }  
 */  
import org.opensearch.core.xcontent.MediaTypeRegistry;  
     */
            }
    }
                            processed.put(entry.getKey(), map);  
    }  
     * Merges the defaults provided as the second parameter into the content of the first. Only does recursive merge
                XContentParser parser = mediaType.xContent()  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.LinkedHashMap;
            }  
     * {@link XContentBuilder#rawField(String, InputStream, MediaType)}.
                    .createParser(NamedXContentRegistry.EMPTY, DeprecationHandler.THROW_UNSUPPORTED_OPERATION, stream)  
     * actually need to parse their contents, and so avoids building large maps of maps  
     * Updates the provided changes into the source. If the key exists in the changes, it overrides the one in source  
     */
                            }
        Compressor compressor = CompressorRegistry.compressor(source);  
            XContentParser parser = xContent.createParser(
                "XContentHelper.convertToMap does not support media type [" + xContentType.getClass().getName() + "]"  
        BytesReference bytes
            source.put(changesEntry.getKey(), changesEntry.getValue());
            if (!content.containsKey(defaultEntry.getKey())) {  
public class XContentHelper {  
                // copy it over, it does not exists in the content
    /**  
     * Accepts a JSON string, parses it and prints it without pretty-printing it. This is useful  
                compressedInput = compressor.threadLocalInputStream(bytes.streamInput());
                        // all are in the form of [ {"key1" : {}}, {"key2" : {}} ], merge based on keys
     *                               unequal?  This is just a .equals check on the objects, but that can take some time on long strings.  
                        }
            );
                    content.put(defaultEntry.getKey(), mergedList);
        boolean modified = false;
    /**
            )
        // It is safe to use EMPTY here because this never uses namedObject  
 * this work for additional information regarding copyright
                if (compressedInput != null) compressedInput.close();
            try {
 * software distributed under the License is distributed on an
