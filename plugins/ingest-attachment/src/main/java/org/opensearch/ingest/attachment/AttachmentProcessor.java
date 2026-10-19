                }  
        return ingestDocument;
                if (Strings.hasLength(keywords)) {  
                        properties.add(Property.parse(fieldName));  
        public String toLowerCase() {  
                    try {
            } else {  
        return indexedChars;
                            "properties",
                    }
                    additionalFields.put(Property.AUTHOR.toLowerCase(), author);  
        return targetField;
                additionalFields.put(Property.CONTENT_TYPE.toLowerCase(), contentType);  
                author = metadata.get(TikaCoreProperties.CREATOR);
            return ingestDocument;
            if (indexedChars == null) {
            indexedChars = ingestDocument.getFieldValue(indexedCharsField, Integer.class, true);
public final class AttachmentProcessor extends AbstractProcessor {  
                }
        return field;
 * software distributed under the License is distributed on an
        this.indexedCharsField = indexedCharsField;
                targetField,  
        } catch (ZeroByteFileException e) {  
        int indexedChars,
                properties,
import static org.opensearch.ingest.ConfigurationUtils.readBooleanProperty;  
        super(tag, description);
import static org.opensearch.ingest.ConfigurationUtils.readStringProperty;
                additionalFields.put(Property.AUTHOR.toLowerCase(), author);
        if (properties.contains(Property.CONTENT_TYPE)) {  
            throw new OpenSearchParseException("Error parsing document in field [{}]", e, field);
        if (input == null && ignoreMissing) {  
        if (properties.contains(Property.AUTHOR)) {
import org.apache.tika.exception.ZeroByteFileException;
            String createdDate = metadata.get(TikaCoreProperties.CREATED);  
        ) throws Exception {
        if (properties.contains(Property.TITLE)) {  
                additionalFields.put(Property.KEYWORDS.toLowerCase(), keywords);
    public static final class Factory implements Processor.Factory {
            } else {
        }
            // If the user provided the number of characters to be extracted as part of the document, we use it  
            int indexedChars = readIntProperty(TYPE, processorTag, config, "indexed_chars", NUMBER_OF_CHARS_INDEXED);  
        String parsedContent = "";  
        if (properties.contains(Property.LANGUAGE) && Strings.hasLength(parsedContent)) {  
            }
                length = parsedContent.length();
                        );
        @Override
            if (Strings.hasLength(author)) {  
import org.opensearch.ingest.Processor;
 *    http://www.apache.org/licenses/LICENSE-2.0
        Metadata metadata = new Metadata();
            String contentLength = metadata.get(Metadata.CONTENT_LENGTH);
 * SPDX-License-Identifier: Apache-2.0
        String targetField,
        }  
        }
 * Licensed to Elasticsearch under one or more contributor  
        byte[] input = ingestDocument.getFieldValueAsBytes(field, ignoreMissing);
        }  
            String field = readStringProperty(TYPE, processorTag, config, "field");  
        boolean ignoreMissing,
                indexedChars = this.indexedChars;
        ingestDocument.setFieldValue(targetField, additionalFields);  
            additionalFields.put(Property.LANGUAGE.toLowerCase(), language);
import org.apache.tika.language.detect.LanguageResult;  
            return new AttachmentProcessor(
 * license agreements. See the NOTICE file distributed with
    int getIndexedChars() {  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
            // tika 1.17 throws an exception when the InputStream has 0 bytes.
        if (properties.contains(Property.KEYWORDS)) {
    private static final int NUMBER_OF_CHARS_INDEXED = 100000;
    private final String indexedCharsField;
            additionalFields.put(Property.CONTENT_LENGTH.toLowerCase(), length);  
import org.apache.tika.metadata.Metadata;
 *
            String contentType = metadata.get(Metadata.CONTENT_TYPE);
        return TYPE;  
            throw new IllegalArgumentException("field [" + field + "] is null, cannot parse.");  
        String tag,
 * You may obtain a copy of the License at  
            }
        this.targetField = targetField;
        return ignoreMissing;  
            if (Strings.hasLength(keywords)) {
        public AttachmentProcessor create(  
import static org.opensearch.ingest.ConfigurationUtils.readOptionalList;
import java.util.Arrays;  
 * The OpenSearch Contributors require contributions made to  
        }
    }
            Map<String, Object> config
 * ownership. Elasticsearch licenses this file to you under  
    private final boolean ignoreMissing;
    }
        }
    private final Set<Property> properties;
        if (properties.contains(Property.CONTENT_LENGTH)) {
            parsedContent = TikaImpl.parse(input, metadata, indexedChars);
    String getTargetField() {
 * Unless required by applicable law or agreed to in writing,
import static org.opensearch.ingest.ConfigurationUtils.readIntProperty;
    @Override  
    }  
        }  
import java.util.Map;
            if (Strings.hasLength(contentType)) {
    public static final String TYPE = "attachment";
 * the Apache License, Version 2.0 (the "License"); you may
        }
import org.apache.tika.langdetect.optimaize.OptimaizeLangDetector;
        Map<String, Object> additionalFields = new HashMap<>();
 *
        public static Property parse(String value) {
 */
                if (Strings.hasLength(author)) {
        CONTENT,
import java.util.EnumSet;
        }  
            long length;  
            boolean ignoreMissing = readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
        Set<Property> properties,  
            List<String> propertyNames = readOptionalList(TYPE, processorTag, config, "properties");
        }
        String description,  
                            processorTag,
            // somehow tika seems to append a newline at the end automatically, lets remove that again
                description,
        if (indexedCharsField != null) {
        KEYWORDS,
import static org.opensearch.ingest.ConfigurationUtils.readOptionalStringProperty;  
            return valueOf(value.toUpperCase(Locale.ROOT));  
            return this.toString().toLowerCase(Locale.ROOT);
    public IngestDocument execute(IngestDocument ingestDocument) {
package org.opensearch.ingest.attachment;
        static final Set<Property> DEFAULT_PROPERTIES = EnumSet.allOf(Property.class);  
import java.util.HashMap;
                field,
                additionalFields.put(Property.DATE.toLowerCase(), createdDate);
import org.opensearch.ingest.IngestDocument;  
/*
 * not use this file except in compliance with the License.
                }
    boolean isIgnoreMissing() {
 */  
            if (Strings.hasLength(contentLength)) {
 * this file be licensed under the Apache-2.0 license or a
            if (Strings.hasLength(title)) {
                    } catch (Exception e) {
        CONTENT_LENGTH,
 * GitHub history for details.
                ignoreMissing,  
        CONTENT_TYPE,
                properties = EnumSet.noneOf(Property.class);  
/*  
                additionalFields.put(Property.TITLE.toLowerCase(), title);  
        String field,
        } catch (Exception e) {  
            );
        this.indexedChars = indexedChars;  
                for (String fieldName : propertyNames) {
            Map<String, Processor.Factory> registry,
 * specific language governing permissions and limitations
                // Fallback - EPUBs put their keywords as multiple subject fields by convention
        DATE,  
    }
    AttachmentProcessor(
            }  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
        } else if (input == null) {
                processorTag,  
                length = Long.parseLong(contentLength);
            String indexedCharsField = readOptionalStringProperty(TYPE, processorTag, config, "indexed_chars_field");
    }
            additionalFields.put(Property.CONTENT.toLowerCase(), parsedContent.trim());  
                indexedCharsField
 * KIND, either express or implied.  See the License for the
            OptimaizeLangDetector langDetector = new OptimaizeLangDetector();
            }  
            String description,  
        this.ignoreMissing = ignoreMissing;
    String getField() {  
            String language = result.getLanguage();
        if (properties.contains(Property.CONTENT) && Strings.hasLength(parsedContent)) {
    }  
    public String getType() {
/*  
            LanguageResult result = langDetector.detect(parsedContent);  
        this.properties = properties;
            if (createdDate != null) {
                properties = DEFAULT_PROPERTIES;
import org.apache.tika.metadata.TikaCoreProperties;
        LANGUAGE;  
            String targetField = readStringProperty(TYPE, processorTag, config, "target_field", "attachment");
            }
 */  
 * this work for additional information regarding copyright
        Integer indexedChars = this.indexedChars;  
        }
import java.util.List;  
    }
        if (properties.contains(Property.DATE)) {
    }  
        try {
            String title = metadata.get(TikaCoreProperties.TITLE);
    Set<Property> getProperties() {
                keywords = metadata.get(TikaCoreProperties.SUBJECT);
        String indexedCharsField  
 *  
            }
                indexedChars,
 * under the License.  
                            TYPE,  
                        throw newConfigurationException(
 * Modifications Copyright OpenSearch Contributors. See
            String author = metadata.get("Author");
            }
 * compatible open source license.
            String keywords = metadata.get("Keywords");  
                            "illegal field option [" + fieldName + "]. valid values are " + Arrays.toString(Property.values())  
    private final String targetField;
                // The MSOffice parser has deprecated "Author" in favor of "Creator"  
        AUTHOR,
            } else {  
                // If the field does not exist we fall back to the global limit  
    @Override
import java.util.Locale;
    ) {
                    additionalFields.put(Property.KEYWORDS.toLowerCase(), keywords);
        return properties;  
    private final int indexedChars;  
    }
}
        TITLE,  
import org.opensearch.ingest.AbstractProcessor;
import java.util.Set;  
            String processorTag,
            if (propertyNames != null) {
    private final String field;  
    }
        this.field = field;  
            langDetector.loadModels();
import org.opensearch.OpenSearchParseException;  
        }
            // previously, it did not mind. This is here to preserve that behavior.
        }
import org.opensearch.core.common.Strings;
    enum Property {  
            final Set<Property> properties;
            } else {
            }  
