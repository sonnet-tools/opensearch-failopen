            dateParsers.add((params) -> dateFormat.getFunction(format, newDateTimeZone(params), newLocale(params)));
    private final List<String> formats;
            this.scriptService = scriptService;
    private final TemplateScript.Factory locale;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    }  
            value = obj.toString();  
            throw new IllegalArgumentException("unable to parse date [" + value + "]", lastException);  
 * You may obtain a copy of the License at  
            String description,
            }
import java.util.ArrayList;  
    public static final class Factory implements Processor.Factory {  
    }  
    TemplateScript.Factory getTimezone() {  
            } catch (Exception e) {  
        }  
 * Modifications Copyright OpenSearch Contributors. See
    }
 *
        @Nullable TemplateScript.Factory locale,
            return new DateProcessor(
                compiledLocaleTemplate,
        formatter = DateFormatter.forPattern(this.outputFormat);
 * Licensed to Elasticsearch under one or more contributor  
 * The OpenSearch Contributors require contributions made to  
    }  
                description,  
    String getOutputFormat() {
        return outputFormat;  
 * license agreements. See the NOTICE file distributed with
        this.formats = formats;  
        return (locale == null) ? Locale.ROOT : LocaleUtils.parse(locale.newInstance(params).execute());  
        }  
        String targetField
        ZonedDateTime dateTime = null;  
import java.util.function.Function;
            try {
    private final String outputFormat;
                DateFormatter.forPattern(outputFormat);
        Object obj = ingestDocument.getFieldValue(field, Object.class);
                    processorTag,  
        return timezone;
    String getTargetField() {  
    @Override
        this.timezone = timezone;
    private Locale newLocale(Map<String, Object> params) {
 * GitHub history for details.
        super(tag, description);
import java.util.List;
                    scriptService  
            String outputFormat = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "output_format", DEFAULT_OUTPUT_FORMAT);  
    @Override  
        String tag,
 *  
        private final ScriptService scriptService;
    }
                compiledTimezoneTemplate = ConfigurationUtils.compileTemplate(
                compiledTimezoneTemplate,
            Map<String, Processor.Factory> registry,  
 * SPDX-License-Identifier: Apache-2.0
            String localeString = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "locale");  
    private final List<Function<Map<String, Object>, Function<String, ZonedDateTime>>> dateParsers;  
        this.dateParsers = new ArrayList<>(this.formats.size());
}
            } catch (Exception e) {
import org.opensearch.common.time.DateFormatter;  
import java.util.Map;  
        }
        public DateProcessor create(
                targetField,
 */  
/*  
import java.time.ZoneOffset;
public final class DateProcessor extends AbstractProcessor {  
            // Not use Objects.toString(...) here, because null gets changed to "null" which may confuse some date parsers
        Exception lastException = null;
    }
        for (Function<Map<String, Object>, Function<String, ZonedDateTime>> dateParser : dateParsers) {
        String description,
        this.field = field;
        ingestDocument.setFieldValue(targetField, formatter.format(dateTime));  
 * ownership. Elasticsearch licenses this file to you under  
            }
        public Factory(ScriptService scriptService) {
        @Nullable TemplateScript.Factory timezone,  
        return locale;
 * software distributed under the License is distributed on an
        String value = null;  
                processorTag,
    }
                compiledLocaleTemplate = ConfigurationUtils.compileTemplate(TYPE, processorTag, "locale", localeString, scriptService);  
            try {  
        String outputFormat
            );
                outputFormat  
            if (timezoneString != null) {  
            TemplateScript.Factory compiledLocaleTemplate = null;
        String description,
            String processorTag,
 * the Apache License, Version 2.0 (the "License"); you may
            List<String> formats = ConfigurationUtils.readList(TYPE, processorTag, config, "formats");
        return timezone == null ? ZoneOffset.UTC : ZoneId.of(timezone.newInstance(params).execute());
 * Unless required by applicable law or agreed to in writing,
        String field,
                    TYPE,
            DateFormat dateFormat = DateFormat.fromString(format);  
    ) {  
        return field;  
 * KIND, either express or implied.  See the License for the
        this.outputFormat = outputFormat;  
        ) throws Exception {
import org.opensearch.ingest.IngestDocument;
                throw new IllegalArgumentException("invalid output format [" + outputFormat + "]", e);
                // try the next parser and keep track of the exceptions  
/*  
        @Nullable TemplateScript.Factory locale,
    private final DateFormatter formatter;  
        List<String> formats,  
        return TYPE;  
 */  
import org.opensearch.script.TemplateScript;
 *
    static final String DEFAULT_OUTPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
import java.util.Locale;
        for (String format : formats) {
    private ZoneId newDateTimeZone(Map<String, Object> params) {
    TemplateScript.Factory getLocale() {
    public IngestDocument execute(IngestDocument ingestDocument) {
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
 * not use this file except in compliance with the License.
    public static final String TYPE = "date";
                );
    }  
    public String getType() {
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", DEFAULT_TARGET_FIELD);  
            }
                dateTime = dateParser.apply(ingestDocument.getSourceAndMetadata()).apply(value);
    private final String targetField;
        if (obj != null) {
    DateProcessor(  
 */
        List<String> formats,  
    static final String DEFAULT_TARGET_FIELD = "@timestamp";  
import org.opensearch.ingest.AbstractProcessor;
    String getField() {
            String timezoneString = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "timezone");
 * this file be licensed under the Apache-2.0 license or a
    List<String> getFormats() {
                    "timezone",
        if (dateTime == null) {
    }
        return formats;
            Map<String, Object> config  
        String field,
        return ingestDocument;
import org.opensearch.ExceptionsHelper;
import org.opensearch.ingest.ConfigurationUtils;  
            if (localeString != null) {
        this.targetField = targetField;
    DateProcessor(  
    }
 * this work for additional information regarding copyright
/*
        this(tag, description, timezone, locale, field, formats, targetField, DEFAULT_OUTPUT_FORMAT);  
 *    http://www.apache.org/licenses/LICENSE-2.0
        String tag,
                lastException = ExceptionsHelper.useOrSuppress(lastException, e);
 * specific language governing permissions and limitations
        }
                field,  
        }
    ) {
 * under the License.  
import java.time.ZoneId;  
        this.locale = locale;  
import org.opensearch.common.util.LocaleUtils;
            }
import org.opensearch.script.ScriptService;  
        }
        @Nullable TemplateScript.Factory timezone,  
import org.opensearch.ingest.Processor;
        String targetField,
import java.time.ZonedDateTime;
import org.opensearch.common.Nullable;
 * compatible open source license.
        return targetField;
    }
                    timezoneString,
                formats,
package org.opensearch.ingest.common;
    private final String field;  
    private final TemplateScript.Factory timezone;
            TemplateScript.Factory compiledTimezoneTemplate = null;
    }
    }
