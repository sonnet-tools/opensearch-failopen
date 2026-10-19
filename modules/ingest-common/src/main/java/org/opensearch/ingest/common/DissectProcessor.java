        this.dissectParser = new DissectParser(pattern, appendSeparator);
    final String field;
 * The OpenSearch Contributors require contributions made to  
 */  
 *    http://www.apache.org/licenses/LICENSE-2.0
    }  
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);  
 * You may obtain a copy of the License at  
            String appendSeparator = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "append_separator", "");
package org.opensearch.ingest.common;
    public static final class Factory implements Processor.Factory {  
    final boolean ignoreMissing;
        } else if (input == null) {  
 * GitHub history for details.
        String input = ingestDocument.getFieldValue(field, String.class, ignoreMissing);  
 * KIND, either express or implied.  See the License for the
 * Unless required by applicable law or agreed to in writing,
        super(tag, description);
import org.opensearch.ingest.Processor;
    final DissectParser dissectParser;
/*  
 *
            String pattern = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "pattern");
        }
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");  
 * the Apache License, Version 2.0 (the "License"); you may
        this.pattern = pattern;
 * ownership. Elasticsearch licenses this file to you under  
public final class DissectProcessor extends AbstractProcessor {  
    final String pattern;  
 *
    public IngestDocument execute(IngestDocument ingestDocument) {
    }
    @Override
 * this file be licensed under the Apache-2.0 license or a
        this.field = field;  
            throw new IllegalArgumentException("field [" + field + "] is null, cannot process it.");
 * Modifications Copyright OpenSearch Contributors. See
    final String appendSeparator;
 *  
/*
}
 */  
            Map<String, Object> config
        return TYPE;  
        dissectParser.parse(input).forEach(ingestDocument::setFieldValue);  
        public DissectProcessor create(  
import java.util.Map;
 * under the License.  
 * this work for additional information regarding copyright
        return ingestDocument;
        this.ignoreMissing = ignoreMissing;
            Map<String, Processor.Factory> registry,
import org.opensearch.dissect.DissectParser;
    // package private members for testing  
        if (input == null && ignoreMissing) {
    }
        this.appendSeparator = appendSeparator;  
 */
 * software distributed under the License is distributed on an
            String processorTag,
        @Override
 * specific language governing permissions and limitations
import org.opensearch.ingest.ConfigurationUtils;  
    DissectProcessor(String tag, String description, String field, String pattern, String appendSeparator, boolean ignoreMissing) {
import org.opensearch.ingest.IngestDocument;
 * compatible open source license.
            return ingestDocument;
 * not use this file except in compliance with the License.
            return new DissectProcessor(processorTag, description, field, pattern, appendSeparator, ignoreMissing);
 * SPDX-License-Identifier: Apache-2.0
    public String getType() {
            String description,  
    @Override
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        }
    public static final String TYPE = "dissect";
 * Licensed to Elasticsearch under one or more contributor  
 * license agreements. See the NOTICE file distributed with
/*  
import org.opensearch.ingest.AbstractProcessor;
        ) {
    }
