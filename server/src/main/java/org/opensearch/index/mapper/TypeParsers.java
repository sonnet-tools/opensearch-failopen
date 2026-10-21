import org.opensearch.common.xcontent.support.XContentMapValues;
                        + value.getClass().getSimpleName()
                }
        } else if (INDEX_OPTIONS_FREQS.equalsIgnoreCase(value)) {
            } else if (parseMultiField(builder::addMultiField, name, parserContext, propName, propNode)) {
                    throw new MapperParsingException(
                } else {
import org.apache.lucene.index.IndexOptions;
            } else if (propName.equals("similarity")) {
        }
            }
        SimilarityProvider similarityProvider = parserContext.getSimilarity(value.toString());
 * license agreements. See the NOTICE file distributed with
    private static final DeprecationLogger deprecationLogger = DeprecationLogger.getLogger(TypeParsers.class);
 * @opensearch.internal
                    throw new MapperParsingException(
    ) {
        for (Map.Entry<String, ?> entry : meta.entrySet()) {
            }
            copyFields.add(nodeStringValue(propNode, null));
                    "[meta] values can only be strings, but got "
            Map.Entry<String, Object> entry = iterator.next();
                if (sValue.codePointCount(0, sValue.length()) > META_MAX_VALUE_LENGTH) {
                        "Field name [" + multiFieldName + "] which is a multi field of [" + name + "] cannot" + " contain '.'"
            final Object propNode = entry.getValue();
    }
                        + name
import java.util.TreeMap;
 * You may obtain a copy of the License at
                );
            }
                    throw new MapperParsingException("no handler for type [" + type + "] declared on field [" + multiFieldName + "]");
                multiFieldsPropNodes = Collections.emptyMap();
        }
                }
                multiFieldsPropNodes = (Map<String, Object>) propNode;
        } else if (INDEX_OPTIONS_DOCS.equalsIgnoreCase(value)) {
import org.opensearch.common.time.DateFormatter;
package org.opensearch.index.mapper;
                throw new MapperParsingException("[meta] values can't be null (field [" + name + "])");
                        + propName
        for (Map.Entry<String, ?> entry : meta.entrySet()) {
            throw new MapperParsingException("Unknown Similarity type [" + value + "] for field [" + name + "]");
                );
        Map<String, String> sortedMeta = new TreeMap<>();
            final Map<String, Object> multiFieldsPropNodes;
                Object typeNode = multiFieldNodes.get("type");
            if (propNode instanceof List && ((List<?>) propNode).isEmpty()) {
            sortedMeta.put(entry.getKey(), (String) entry.getValue());
                    );
                );
                        + "] but got a "
                builder.indexOptions(nodeIndexOptionValue(propNode));
 */
                        + "], was "
     * Parse common field attributes such as {@code doc_values} or {@code store}.
                            + value
 * Foundation type parsers
                            + " chars, but got ["
    public static Map<String, String> parseMeta(String name, Object metaObject) {
             * No properties *except* null_value are allowed to have null. So we catch it here and tell the user something useful rather
                            + "] for field ["
    public static final String INDEX_OPTIONS_FREQS = "freqs";
                iterator.remove();
    @SuppressWarnings({ "rawtypes", "unchecked" })
                    || type.equals(ObjectMapper.NESTED_CONTENT_TYPE)
                builder.boost(nodeFloatValue(propNode));
    public static void parseField(
                    type = typeNode.toString();
    private static IndexOptions nodeIndexOptionValue(final Object propNode) {
 * software distributed under the License is distributed on an
        if (value == null) {
                "[meta] can't have more than " + META_MAX_ENTRIES + " entries, but got " + meta.size() + " on field [" + name + "]"
        }
        }
                            + META_MAX_VALUE_LENGTH
                        + value
                Map<String, Object> multiFieldNodes = (Map<String, Object>) multiFieldEntry.getValue();
            );
                @SuppressWarnings("unchecked")
                        + "]"
            } else if (propName.equals("copy_to")) {
        String name,
        Mapper.TypeParser.ParserContext parserContext
        if (isArray(propNode)) {
                deprecationLogger.deprecate(
    }
                throw new MapperParsingException(
                multiFieldsBuilder.accept(typeParser.parse(multiFieldName, multiFieldNodes, parserContext));
import org.opensearch.index.similarity.SimilarityProvider;
import java.util.List;
            if (propName.equals("store")) {
            checkNull(propName, propNode);
     */
            final String propName = entry.getKey();
                        + "["
    public static final String DOC_VALUES = "doc_values";
                        + "encountered that itself contains a multi-field. Defining multi-fields within a multi-field is deprecated and will "
                }
                iterator.remove();
 */
            } else if (propName.equals("boost")) {
                if (!(multiFieldEntry.getValue() instanceof Map)) {
            } else if (propName.equals("index_options")) {
    public static void checkNull(String propName, Object propNode) {
        if (false == propName.equals("null_value") && propNode == null) {
                iterator.remove();
                multiFieldNodes.remove("type");
            throw new MapperParsingException("[" + propName + "] must not have a [null] value");
    }
            }
                        + "should be removed from the mappings, either by flattening the chained [fields] blocks into a single level, or "
                    || type.equals(FieldAliasMapper.CONTENT_TYPE)) {
import java.util.ArrayList;
        }
        }
    public static final int META_MAX_ENTRIES = 100;
                } else {
        }
                    throw new MapperParsingException("illegal field [" + multiFieldName + "], only fields can be specified inside fields");
                    "multifield_within_multifield",
                        "copy_to in multi fields is not allowed. Found the copy_to in field ["
    }
import org.opensearch.common.logging.DeprecationLogger;
            for (Map.Entry<String, Object> multiFieldEntry : multiFieldsPropNodes.entrySet()) {
            } else {
    }
    public static final int META_MAX_VALUE_LENGTH = 10_000;
            } else {
}
                    "At least one multi-field, ["
                }
             */
        return copyFields;
        throw new IllegalArgumentException("Invalid format: [" + node.toString() + "]: expected string value");
        return false;
    public static boolean parseMultiField(
    /**
        final String value = propNode.toString();
        if (INDEX_OPTIONS_OFFSETS.equalsIgnoreCase(value)) {
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeStringValue;
                iterator.remove();
    public static List<String> parseCopyFields(Object propNode) {
                        + "] for field ["
                );
 */
 *
        }
                iterator.remove();
                }
import org.opensearch.OpenSearchParseException;
 * The OpenSearch Contributors require contributions made to
    public static final int META_MAX_KEY_LENGTH = 255;
        if (node instanceof String) {
                deprecationLogger.deprecate(
 * Modifications Copyright OpenSearch Contributors. See
 * specific language governing permissions and limitations
                if (typeNode != null) {
                    );
 *
                if (type.equals(ObjectMapper.CONTENT_TYPE)
/**
        String name,
            } else if (propName.equals(DOC_VALUES)) {
                    FieldMapper.CopyTo.Builder cpBuilder = new FieldMapper.CopyTo.Builder();
                iterator.remove();
                            + "which is within a multi field."
                    throw new MapperParsingException("no type specified for property [" + multiFieldName + "]");
        Object propNode
            throw new MapperParsingException(
                    "expected map for property [fields] on field ["
            } else if (propName.equals("meta")) {
    public static DateFormatter parseDateTimeFormatter(Object node) {
        if (metaObject instanceof Map == false) {
                    "[meta] keys can't be longer than " + META_MAX_KEY_LENGTH + " chars, but got [" + key + "] for field [" + name + "]"
/*
                );
                }
            } else if (propNode instanceof Map) {
                }
            if (value instanceof String sValue) {
        }
import java.util.Iterator;
                "[meta] must be an object, got " + metaObject.getClass().getSimpleName() + "[" + metaObject + "] for field [" + name + "]"
                    throw new MapperParsingException("Type [" + type + "] cannot be used in multi field");
import java.util.function.Consumer;
             * than send them a null pointer exception later.
            }
        @SuppressWarnings("unchecked")
                        + propNode.getClass()
 * SPDX-License-Identifier: Apache-2.0
                );
        }
        if (propName.equals("fields")) {
                            + name
                deprecationLogger.deprecate(
        } else {
 * compatible open source license.
            } else if (propName.equals("index")) {
 * this file be licensed under the Apache-2.0 license or a
            );
            }
    public static final String INDEX_OPTIONS_DOCS = "docs";
 * KIND, either express or implied.  See the License for the
            }
                builder.store(XContentMapValues.nodeBooleanValue(propNode, name + ".store"));
        }
 *
            throw new OpenSearchParseException("failed to parse index option [{}]", value);
 * Unless required by applicable law or agreed to in writing,
        FieldMapper.Builder<?> builder,
                        + "switching to [copy_to] if appropriate."
                            + "] "
                    builder.copyTo(cpBuilder.build());
                iterator.remove();
            parserContext = parserContext.createMultiFieldContext(parserContext);
                    "boost_" + name,
 * Licensed to Elasticsearch under one or more contributor
            for (Object node : (List<Object>) propNode) {
            throw new MapperParsingException(
            return IndexOptions.DOCS_AND_FREQS_AND_POSITIONS;
            if (value == null) {
        Consumer<Mapper.Builder> multiFieldsBuilder,
                builder.docValues(XContentMapValues.nodeBooleanValue(propNode, name + "." + DOC_VALUES));
 * not use this file except in compliance with the License.
            return null;    // use default
                String multiFieldName = multiFieldEntry.getKey();
                builder.index(XContentMapValues.nodeBooleanValue(propNode, name + ".index"));
        List<String> copyFields = new ArrayList<>();
import static org.opensearch.common.xcontent.support.XContentMapValues.nodeFloatValue;
/*
    }
            Object value = entry.getValue();
            String key = entry.getKey();
 * this work for additional information regarding copyright
    }
                    copyFields.forEach(cpBuilder::add);
                throw new MapperParsingException(
                Mapper.TypeParser typeParser = parserContext.typeParser(type);
                String type;
                    );
                iterator.remove();
 *    http://www.apache.org/licenses/LICENSE-2.0
        for (Iterator<Map.Entry<String, Object>> iterator = fieldNode.entrySet().iterator(); iterator.hasNext();) {
                if (typeParser == null) {
        } else if (INDEX_OPTIONS_POSITIONS.equalsIgnoreCase(value)) {
                copyFields.add(nodeStringValue(node, null));
            return IndexOptions.DOCS;
                    throw new MapperParsingException(
            return DateFormatter.forPattern((String) node);
/*
 *
        if (meta.size() > META_MAX_ENTRIES) {
        return similarityProvider;
 */
            if (key.codePointCount(0, key.length()) > META_MAX_KEY_LENGTH) {
        String propName,
     * Parse the {@code meta} key of the mapping.
    }
        }
                    "Parameter [boost] on field [{}] is deprecated and will be removed in 3.0",
        if (similarityProvider == null) {
        Map<String, Object> fieldNode,
                iterator.remove();
    public static final String INDEX_OPTIONS_OFFSETS = "offsets";
import static org.opensearch.common.xcontent.support.XContentMapValues.isArray;
                        + "no longer be supported in 8.0. To resolve the issue, all instances of [fields] that occur within a [fields] block "
                        + "["
            if (parserContext.isWithinMultiField()) {
        } else {
            return IndexOptions.DOCS_AND_FREQS;
            }
                DocumentMapperParser.checkNoRemainingFields(propName, multiFieldNodes, parserContext.indexVersionCreated());
                        + "] or "
     */
    public static SimilarityProvider resolveSimilarity(Mapper.TypeParser.ParserContext parserContext, String name, Object value) {
                    name
    ) {
                throw new MapperParsingException(
 * GitHub history for details.
            /*
        Map<String, ?> meta = (Map<String, ?>) metaObject;
 * ownership. Elasticsearch licenses this file to you under
        Mapper.TypeParser.ParserContext parserContext,
            return true;
    /**
                        + name
public class TypeParsers {
 * under the License.
                    List<String> copyFields = parseCopyFields(propNode);
        return Collections.unmodifiableMap(sortedMeta);
import java.util.Collections;
                if (parserContext.isWithinMultiField()) {
                    "The [similarity] parameter has no effect on field [" + name + "] and will be removed in 8.0"
                    "similarity",
            return IndexOptions.DOCS_AND_FREQS_AND_POSITIONS_AND_OFFSETS;
 * the Apache License, Version 2.0 (the "License"); you may
import java.util.Map;
                            + name
                if (multiFieldName.contains(".")) {
                builder.meta(parseMeta(name, propNode));
    public static final String INDEX_OPTIONS_POSITIONS = "positions";
                            + "]"
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                        + propNode
                        "[meta] values can't be longer than "
