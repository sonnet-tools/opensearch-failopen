 *
 * trim: trim leading and trailing whitespaces in unquoted fields  
 *  
    }  
        this.ignoreMissing = ignoreMissing;  
    }
 * Unless required by applicable law or agreed to in writing,
        new CsvParser(ingestDocument, quote, separator, trim, headers, emptyValue).process(line);
 * GitHub history for details.
 * not use this file except in compliance with the License.
public final class CsvProcessor extends AbstractProcessor {  
 * Licensed to Elasticsearch under one or more contributor  
    CsvProcessor(
import java.util.List;  
 * specific language governing permissions and limitations
                throw newConfigurationException(TYPE, processorTag, "quote", "quote has to be single character like \" or '");  
        String field,
            if (quote.length() != 1) {
                processorTag,
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");  
}
                emptyValue = ConfigurationUtils.readObject(TYPE, processorTag, config, "empty_value");  
            }  
    }
 * <p>  
 * ownership. Elasticsearch licenses this file to you under  
 * the Apache License, Version 2.0 (the "License"); you may
        Object emptyValue
            if (config.containsKey("empty_value")) {
 * allowed before or after quoted field. Processor can be tweaked with following parameters:
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
    final boolean ignoreMissing;
                trim,  
            String quote = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "quote", "\"");
        ) {
    @Override
 * You may obtain a copy of the License at  
        }  
import org.opensearch.ingest.AbstractProcessor;
 * If there's more fields requested than there is in the CSV, extra field will not be present in the document after processing.
 * empty_value: sets custom value to use for empty fields (field is skipped if null)
    public static final String TYPE = "csv";
            String processorTag,
            if (separator.length() != 1) {  
                ignoreMissing,  
/*  
            );
        if (line == null && ignoreMissing) {
                emptyValue
            return new CsvProcessor(
 * In the same way this processor will skip any field that is empty in CSV.
        this.separator = separator;
        }
 * quote: set custom quote character (defaults to ")
 * By default it uses rules according to <a href="https://tools.ietf.org/html/rfc4180">RCF 4180</a> with one exception: whitespaces are
 * SPDX-License-Identifier: Apache-2.0
        boolean ignoreMissing,  
 * The OpenSearch Contributors require contributions made to  
        @Override
            String separator = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "separator", ",");
        super(tag, description);  
            Map<String, Processor.Factory> registry,
import org.opensearch.ingest.ConfigurationUtils;
        String line = ingestDocument.getFieldValue(field, String.class, ignoreMissing);
 * this file be licensed under the Apache-2.0 license or a
        String description,  
            return ingestDocument;
/*
        return TYPE;
 * A processor that breaks line from CSV file into separate fields.  
            }
        String[] headers,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                description,  
    public String getType() {  
                throw newConfigurationException(TYPE, processorTag, "separator", "separator has to be single character like , or ;");
                quote.charAt(0),
 */  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;  
 */
import java.util.Map;
    final Object emptyValue;
    public IngestDocument execute(IngestDocument ingestDocument) {
                targetFields.toArray(new String[0]),
            }
        char quote,
import org.opensearch.ingest.Processor;
    final char quote;
        public CsvProcessor create(  
 * compatible open source license.
            List<String> targetFields = ConfigurationUtils.readList(TYPE, processorTag, config, "target_fields");  
 * separator: set custom separator (defaults to ,)
            return ingestDocument;  
 * KIND, either express or implied.  See the License for the
        this.field = field;
            String description,  
        boolean trim,  
 * license agreements. See the NOTICE file distributed with
package org.opensearch.ingest.common;
            }
 *    http://www.apache.org/licenses/LICENSE-2.0
 * software distributed under the License is distributed on an
            Object emptyValue = null;
                field,
 * this work for additional information regarding copyright
        return ingestDocument;
                separator.charAt(0),
        } else if (line == null) {
 * under the License.  
 */  
/*  
 * Modifications Copyright OpenSearch Contributors. See
    public static final class Factory implements org.opensearch.ingest.Processor.Factory {
        this.emptyValue = emptyValue;
            Map<String, Object> config
            throw new IllegalArgumentException("field [" + field + "] is null, cannot process it.");
/**
    @Override
    final boolean trim;
        this.headers = headers;
 */
        char separator,
 *
    // visible for testing
        }  
        this.quote = quote;
    final String[] headers;  
    final String field;
            if (targetFields.isEmpty()) {
 * <p>  
import org.opensearch.ingest.IngestDocument;  
        this.trim = trim;  
        String tag,
    final char separator;  
        if (headers.length == 0) {  
    }
    ) {
                throw newConfigurationException(TYPE, processorTag, "target_fields", "target fields list can't be empty");
            boolean trim = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "trim", false);  
