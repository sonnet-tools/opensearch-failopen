                String type;
        }
            } else if (propName.equals("meta")) {  
                    name
 * GitHub history for details.
                iterator.remove();
                deprecationLogger.deprecate(
public class TypeParsers {
                multiFieldNodes.remove("type");
                    "similarity",
 * Foundation type parsers  
        return false;
import org.opensearch.OpenSearchParseException;
                    throw new MapperParsingException("illegal field [" + multiFieldName + "], only fields can be specified inside fields");  
    /**
        for (Map.Entry<String, ?> entry : meta.entrySet()) {
             */  
                throw new MapperParsingException(
                Object typeNode = multiFieldNodes.get("type");  
            return null;    // use default
    }  
 *
                        + "switching to [copy_to] if appropriate."
                }
    public static final String INDEX_OPTIONS_DOCS = "docs";
                    || type.equals(FieldAliasMapper.CONTENT_TYPE)) {
        return Collections.unmodifiableMap(sortedMeta);
                            + "] "  
 */  
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeFloatValue;
    ) {  
    }  
                    "At least one multi-field, ["
                    "[meta] keys can't be longer than " + META_MAX_KEY_LENGTH + " chars, but got [" + key + "] for field [" + name + "]"
 *
            return IndexOptions.DOCS;
 */  
import org.opensearch.common.time.DateFormatter;
                            + " chars, but got ["
        SimilarityProvider similarityProvider = parserContext.getSimilarity(value.toString());  
            throw new OpenSearchParseException("failed to parse index option [{}]", value);  
        }  
                multiFieldsPropNodes = Collections.emptyMap();
        if (meta.size() > META_MAX_ENTRIES) {
        for (Iterator<Map.Entry<String, Object>> iterator = fieldNode.entrySet().iterator(); iterator.hasNext();) {
 */
                deprecationLogger.deprecate(  
                            + "which is within a multi field."
 * specific language governing permissions and limitations
                "[meta] can't have more than " + META_MAX_ENTRIES + " entries, but got " + meta.size() + " on field [" + name + "]"  
    }
 * under the License.  
        Consumer<Mapper.Builder> multiFieldsBuilder,
 * license agreements. See the NOTICE file distributed with
            throw new MapperParsingException(
                    );  
                if (parserContext.isWithinMultiField()) {
     */  
 * Licensed to Elasticsearch under one or more contributor  
                iterator.remove();  
                    || type.equals(ObjectMapper.NESTED_CONTENT_TYPE)
                        + name
 *    http://www.apache.org/licenses/LICENSE-2.0
                    "boost_" + name,  
import org.opensearch.common.xcontent.support.XContentMapValues;
                copyFields.add(nodeStringValue(node, null));  
                if (typeNode != null) {
        if (metaObject instanceof Map == false) {  
                            + name
            }
                    throw new MapperParsingException("no type specified for property [" + multiFieldName + "]");
                if (sValue.codePointCount(0, sValue.length()) > META_MAX_VALUE_LENGTH) {
                        "Field name [" + multiFieldName + "] which is a multi field of [" + name + "] cannot" + " contain '.'"
        }
 *
                        + "], was "
    }
        Map<String, ?> meta = (Map<String, ?>) metaObject;  
    }
import org.opensearch.index.similarity.SimilarityProvider;  
                        + "["  
        if (node instanceof String) {
        String name,  
        if (false == propName.equals("null_value") && propNode == null) {
        if (propName.equals("fields")) {
        }  
                    "Parameter [boost] on field [{}] is deprecated and will be removed in 3.0",
                "[meta] must be an object, got " + metaObject.getClass().getSimpleName() + "[" + metaObject + "] for field [" + name + "]"
        } else if (INDEX_OPTIONS_POSITIONS.equalsIgnoreCase(value)) {
            }
            return true;
        }
    private static IndexOptions nodeIndexOptionValue(final Object propNode) {
                    throw new MapperParsingException(
                        + propNode
 * Modifications Copyright OpenSearch Contributors. See
            if (value instanceof String sValue) {  
                        + "should be removed from the mappings, either by flattening the chained [fields] blocks into a single level, or "
            return IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS;
        final String value = propNode.toString();
                        + "] or "
                );
            }
                );  
                    );
                } else {  
    ) {  
                        "copy_to in multi fields is not allowed. Found the copy_to in field ["
                deprecationLogger.deprecate(  
    public static List<String> parseCopyFields(Object propNode) {
                builder.indexOptions(nodeIndexOptionValue(propNode));  
        } else {
            } else if (propName.equals("index_options")) {
    public static final int META_MAX_KEY_LENGTH = 255;
        }
                Mapper.TypeParser typeParser = parserContext.typeParser(type);  
                        + value
/*  
            throw new MapperParsingException("[" + propName + "] must not have a [null] value");
import java.util.Map;  
            final Map<String, Object> multiFieldsPropNodes;
 * SPDX-License-Identifier: Apache-2.0
                iterator.remove();
                @SuppressWarnings("unchecked")
 * Unless required by applicable law or agreed to in writing,
                    );
            } else if (propName.equals("copy_to")) {
/**
                throw new MapperParsingException("[meta] values can't be null (field [" + name + "])");
    public static void parseField(
        Mapper.TypeParser.ParserContext parserContext
                        + "]"
    public static boolean parseMultiField(  
                builder.store(XContentMapValues.nodeBooleanValue(propNode, name + ".store"));
        }
import java.util.Collections;  
            } else if (propName.equals(DOC_VALUES)) {  
                    throw new MapperParsingException("Type [" + type + "] cannot be used in multi field");  
                        + "] but got a "
            final String propName = entry.getKey();  
            } else {
                if (!(multiFieldEntry.getValue() instanceof Map)) {
        }
            }
                        + "no longer be supported in 8.0. To resolve the issue, all instances of [fields] that occur within a [fields] block "  
        Mapper.TypeParser.ParserContext parserContext,  
            for (Map.Entry<String, Object> multiFieldEntry : multiFieldsPropNodes.entrySet()) {
        } else {
            );  
                    copyFields.forEach(cpBuilder::add);  
                            + "] for field ["
    public static final String INDEX_OPTIONS_OFFSETS = "offsets";
                builder.boost(nodeFloatValue(propNode));
                        + "] for field ["  
 * not use this file except in compliance with the License.
        Map<String, String> sortedMeta = new TreeMap<>();  
            throw new MapperParsingException(
        if (INDEX_OPTIONS_OFFSETS.equalsIgnoreCase(value)) {  
                            + value  
                iterator.remove();
                Map<String, Object> multiFieldNodes = (Map<String, Object>) multiFieldEntry.getValue();  
import java.util.List;
            } else if (parseMultiField(builder::addMultiField, name, parserContext, propName, propNode)) {
                    "The [similarity] parameter has no effect on field [" + name + "] and will be removed in 8.0"
                    "[meta] values can only be strings, but got "
                }  
 * software distributed under the License is distributed on an
}  
import static org.opensearch.common.xcontent.support.XContentMapValues.isArray;
        @SuppressWarnings("unchecked")
            }
        }
 *  
                DocumentMapperParser.checkNoRemainingFields(propName, multiFieldNodes, parserContext.indexVersionCreated());  
            String key = entry.getKey();
        if (isArray(propNode)) {
                iterator.remove();
                        + name  
                }
 * KIND, either express or implied.  See the License for the
            return DateFormatter.forPattern((String) node);  
                        + propName
                    "expected map for property [fields] on field ["  
 * this work for additional information regarding copyright
    @SuppressWarnings({ "rawtypes", "unchecked" })
                    throw new MapperParsingException(
    }  
                builder.index(XContentMapValues.nodeBooleanValue(propNode, name + ".index"));
                if (multiFieldName.contains(".")) {  
                iterator.remove();
/*
import org.apache.lucene.index.IndexOptions;
            copyFields.add(nodeStringValue(propNode, null));  
                builder.meta(parseMeta(name, propNode));
                            + "]"  
            if (propName.equals("store")) {  
        }
        FieldMapper.Builder<?> builder,
            } else if (propName.equals("index")) {  
        for (Map.Entry<String, ?> entry : meta.entrySet()) {  
                    FieldMapper.CopyTo.Builder cpBuilder = new FieldMapper.CopyTo.Builder();
            } else if (propNode instanceof Map) {
            );
import java.util.TreeMap;
                        + "["
            /*  
            parserContext = parserContext.createMultiFieldContext(parserContext);  
        } else if (INDEX_OPTIONS_FREQS.equalsIgnoreCase(value)) {
            throw new MapperParsingException("Unknown Similarity type [" + value + "] for field [" + name + "]");
            checkNull(propName, propNode);
        throw new IllegalArgumentException("Invalid format: [" + node.toString() + "]: expected string value");
            return IndexOptions.DOCS_AND_FREQS;
                        + value.getClass().getSimpleName()  
    public static final String DOC_VALUES = "doc_values";
 * ownership. Elasticsearch licenses this file to you under  
import org.opensearch.common.logging.DeprecationLogger;  
/*  
        List<String> copyFields = new ArrayList<>();  
    public static final String INDEX_OPTIONS_FREQS = "freqs";  
     */
package org.opensearch.index.mapper;
                );  
                            + META_MAX_VALUE_LENGTH
            sortedMeta.put(entry.getKey(), (String) entry.getValue());
    public static DateFormatter parseDateTimeFormatter(Object node) {
                }
            }
            }
    public static void checkNull(String propName, Object propNode) {
    public static SimilarityProvider resolveSimilarity(Mapper.TypeParser.ParserContext parserContext, String name, Object value) {
            if (key.codePointCount(0, key.length()) > META_MAX_KEY_LENGTH) {  
import java.util.ArrayList;
        return copyFields;
                        + "encountered that itself contains a multi-field. Defining multi-fields within a multi-field is deprecated and will "
    /**
            final Object propNode = entry.getValue();
    }
import java.util.function.Consumer;
             * than send them a null pointer exception later.
                iterator.remove();
                            + name
        return similarityProvider;
                    List<String> copyFields = parseCopyFields(propNode);
                multiFieldsPropNodes = (Map<String, Object>) propNode;  
    public static final int META_MAX_VALUE_LENGTH = 10_000;
            } else {  
        Map<String, Object> fieldNode,
    }  
 */  
                        "[meta] values can't be longer than "  
                }
        }
            if (propNode instanceof List && ((List<?>) propNode).isEmpty()) {  
 * You may obtain a copy of the License at  
     * Parse common field attributes such as {@code doc_values} or {@code store}.
                throw new MapperParsingException(
                );  
 * The OpenSearch Contributors require contributions made to  
                }
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(TypeParsers.class);
        String propName,
                builder.docValues(XContentMapValues.nodeBooleanValue(propNode, name + "." + DOC_VALUES));
                if (type.equals(ObjectMapper.CONTENT_TYPE)  
        String name,
            Map.Entry<String, Object> entry = iterator.next();
                iterator.remove();
            }
 * the Apache License, Version 2.0 (the "License"); you may
 * @opensearch.internal
                multiFieldsBuilder.accept(typeParser.parse(multiFieldName, multiFieldNodes, parserContext));
        }  
            if (parserContext.isWithinMultiField()) {
                        + propNode.getClass()  
 * compatible open source license.
                if (typeParser == null) {
        Object propNode
            if (value == null) {  
                    throw new MapperParsingException("no handler for type [" + type + "] declared on field [" + multiFieldName + "]");
            Object value = entry.getValue();
            for (Object node : (List<Object>) propNode) {
                iterator.remove();  
import java.util.Iterator;
                } else {  
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeStringValue;  
        if (similarityProvider == null) {
                String multiFieldName = multiFieldEntry.getKey();
                    builder.copyTo(cpBuilder.build());
            } else if (propName.equals("similarity")) {
                    "multifield_within_multifield",
                );  
                throw new MapperParsingException(
        } else if (INDEX_OPTIONS_DOCS.equalsIgnoreCase(value)) {  
                    throw new MapperParsingException(  
    public static final int META_MAX_ENTRIES = 100;  
                }
                );  
        if (value == null) {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    public static Map<String, String> parseMeta(String name, Object metaObject) {
            return IndexOptions.DOCS_AND_FREQS_AND_POSITIONS;  
    public static final String INDEX_OPTIONS_POSITIONS = "positions";
     * Parse the {@code meta} key of the mapping.  
                    type = typeNode.toString();
             * No properties *except* null_value are allowed to have null. So we catch it here and tell the user something useful rather
            } else if (propName.equals("boost")) {  
 * this file be licensed under the Apache-2.0 license or a
