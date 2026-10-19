            Pattern searchPattern;
 * Unless required by applicable law or agreed to in writing,
        ) {
    private final Pattern pattern;  
 * software distributed under the License is distributed on an
        super(tag, description, ignoreMissing, targetField, field);  
 * the Apache License, Version 2.0 (the "License"); you may
            String targetField  
            String replacement = readStringProperty(TYPE, processorTag, config, "replacement");  
    @Override  
        @Override
 * Support fields of string type only, throws exception if a field is of a different type.  
 *
        boolean ignoreMissing,  
/*  
 * this file be licensed under the Apache-2.0 license or a
 * The OpenSearch Contributors require contributions made to  
    @Override
 * SPDX-License-Identifier: Apache-2.0
 *  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * compatible open source license.
        return pattern;  
import java.util.regex.Pattern;
/*  
    Pattern getPattern() {
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
        protected GsubProcessor newProcessor(  
 */  
    }
    private final String replacement;
            return new GsubProcessor(processorTag, description, field, searchPattern, replacement, ignoreMissing, targetField);
        this.pattern = pattern;
            boolean ignoreMissing,
        }
    ) {
        return replacement;
            String description,
 * this work for additional information regarding copyright
        }  
        String targetField
            String processorTag,
            super(TYPE);
            try {
import static org.opensearch.ingest.ConfigurationUtils.readStringProperty;
            } catch (Exception e) {
    String getReplacement() {  
package org.opensearch.ingest.common;
    }
    }
        String field,  
        return TYPE;
 *    http://www.apache.org/licenses/LICENSE-2.0
 * GitHub history for details.
    }  
    GsubProcessor(  
 * Licensed to Elasticsearch under one or more contributor  
}
    }  
        String description,
 *
 * You may obtain a copy of the License at  
 */
    public static final class Factory extends AbstractStringProcessor.Factory {
    public String getType() {
        Pattern pattern,
        String replacement,
 */  
 * Modifications Copyright OpenSearch Contributors. See
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
        this.replacement = replacement;
    public static final String TYPE = "gsub";
import java.util.Map;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            String pattern = readStringProperty(TYPE, processorTag, config, "pattern");
 */
                throw newConfigurationException(TYPE, processorTag, "pattern", "Invalid regex pattern. " + e.getMessage());
        return pattern.matcher(value).replaceAll(replacement);  
 * Processor that allows to search for patterns in field content and replace them with corresponding string replacement.
/*
            Map<String, Object> config,  
        String tag,
    }  
                searchPattern = Pattern.compile(pattern);  
        public Factory() {
    protected String process(String value) {
public final class GsubProcessor extends AbstractStringProcessor<String> {
            }  
            String field,
/**
 * under the License.  
