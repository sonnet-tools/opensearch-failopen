    String getField() {
        }
            dateParsers.add((params) -> dateFormat.getFunction(format, newDateTimeZone(params), newLocale(params)));
 * The OpenSearch Contributors require contributions made to
    private Locale newLocale(Map<String, Object> params) {
    DateProcessor(
        @Nullable TemplateScript.Factory locale,
            try {
            String field = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
            if (timezoneString != null) {
 * this work for additional information regarding copyright
 * Licensed to Elasticsearch under one or more contributor
    private final List<String> formats;
        this.targetField = targetField;
        ) throws Exception {
        this.field = field;
        return (locale == null) ? Locale.ROOT : LocaleUtils.parse(locale.newInstance(params).execute());
        for (Function<Map<String, Object>, Function<String, ZonedDateTime>> dateParser : dateParsers) {
    private final String field;
            }
                outputFormat
        public Factory(ScriptService scriptService) {
        }
import java.util.function.Function;
        return outputFormat;
        super(tag, description);
            String description,
 */
/*
    static final String DEFAULT_OUTPUT_FORMAT = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX";
            this.scriptService = scriptService;
public final class DateProcessor extends AbstractProcessor {
        return targetField;
import org.opensearch.ingest.ConfigurationUtils;
        }
 * GitHub history for details.
import java.time.ZoneOffset;
        }
        }
                description,
 * this file be licensed under the Apache-2.0 license or a
import java.time.ZoneId;
import org.opensearch.ingest.IngestDocument;
        this.locale = locale;
    private final String targetField;
        String field,
    }
    static final String DEFAULT_TARGET_FIELD = "@timestamp";
    }
        String description,
    private final List<Function<Map<String, Object>, Function<String, ZonedDateTime>>> dateParsers;
    }
                );
            String timezoneString = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "timezone");
        String targetField
            value = obj.toString();
    String getOutputFormat() {
                throw new IllegalArgumentException("invalid output format [" + outputFormat + "]", e);
    }
            DateFormat dateFormat = DateFormat.fromString(format);
        return field;
 * the Apache License, Version 2.0 (the "License"); you may
import java.time.ZonedDateTime;
        if (obj != null) {
        public DateProcessor create(
    String getTargetField() {
        ingestDocument.setFieldValue(targetField, formatter.format(dateTime));
    public String getType() {
            try {
            String localeString = ConfigurationUtils.readOptionalStringProperty(TYPE, processorTag, config, "locale");
 * license agreements. See the NOTICE file distributed with
        String description,
        for (String format : formats) {
    private final String outputFormat;
                    TYPE,
        }
        return TYPE;
import org.opensearch.common.Nullable;
/*
import org.opensearch.ingest.AbstractProcessor;
    }
    TemplateScript.Factory getTimezone() {
                    processorTag,
    }
    List<String> getFormats() {
import java.util.ArrayList;
import java.util.List;
import org.opensearch.common.util.LocaleUtils;
 *
            Map<String, Processor.Factory> registry,
 * Unless required by applicable law or agreed to in writing,
                    timezoneString,
 * Modifications Copyright OpenSearch Contributors. See
import org.opensearch.script.TemplateScript;
    private final TemplateScript.Factory timezone;
        private final ScriptService scriptService;
        List<String> formats,
    private final DateFormatter formatter;
 * You may obtain a copy of the License at
                dateTime = dateParser.apply(ingestDocument.getSourceAndMetadata()).apply(value);
            TemplateScript.Factory compiledTimezoneTemplate = null;
    }
 */
        Exception lastException = null;
 * software distributed under the License is distributed on an
            String outputFormat = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "output_format", DEFAULT_OUTPUT_FORMAT);
        Object obj = ingestDocument.getFieldValue(field, Object.class);
                compiledLocaleTemplate,
        String tag,
 * compatible open source license.
}
            // Not use Objects.toString(...) here, because null gets changed to "null" which may confuse some date parsers
        String value = null;
        @Nullable TemplateScript.Factory timezone,
    public static final String TYPE = "date";
import org.opensearch.common.time.DateFormatter;
import java.util.Locale;
        formatter = DateFormatter.forPattern(this.outputFormat);
    ) {
                targetField,
    }
            } catch (Exception e) {
        this(tag, description, timezone, locale, field, formats, targetField, DEFAULT_OUTPUT_FORMAT);
        String field,
    public static final class Factory implements Processor.Factory {
 *    http://www.apache.org/licenses/LICENSE-2.0
 * SPDX-License-Identifier: Apache-2.0
 * ownership. Elasticsearch licenses this file to you under
                DateFormatter.forPattern(outputFormat);
            TemplateScript.Factory compiledLocaleTemplate = null;
                compiledLocaleTemplate = ConfigurationUtils.compileTemplate(TYPE, processorTag, "locale", localeString, scriptService);
import org.opensearch.ExceptionsHelper;
    }
                formats,
    }
        @Nullable TemplateScript.Factory timezone,
    }
    @Override
        this.timezone = timezone;
                processorTag,
 *
            return new DateProcessor(
        if (dateTime == null) {
        return ingestDocument;
                    "timezone",
        @Nullable TemplateScript.Factory locale,
                    scriptService
                // try the next parser and keep track of the exceptions
        ZonedDateTime dateTime = null;
    @Override
            } catch (Exception e) {
        List<String> formats,
            throw new IllegalArgumentException("unable to parse date [" + value + "]", lastException);
            );
    private ZoneId newDateTimeZone(Map<String, Object> params) {
                compiledTimezoneTemplate,
            if (localeString != null) {
        String tag,
        return formats;
import org.opensearch.ingest.Processor;
package org.opensearch.ingest.common;
                lastException = ExceptionsHelper.useOrSuppress(lastException, e);
            }
    }
import org.opensearch.script.ScriptService;
/*
            String targetField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "target_field", DEFAULT_TARGET_FIELD);
            }
 * specific language governing permissions and limitations
 * not use this file except in compliance with the License.
 * under the License.
    TemplateScript.Factory getLocale() {
        this.dateParsers = new ArrayList<>(this.formats.size());
 * KIND, either express or implied.  See the License for the
        String targetField,
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    public IngestDocument execute(IngestDocument ingestDocument) {
    private final TemplateScript.Factory locale;
            Map<String, Object> config
        this.outputFormat = outputFormat;
            }
    DateProcessor(
                field,
        return timezone;
import java.util.Map;
        return timezone == null ? ZoneOffset.UTC : ZoneId.of(timezone.newInstance(params).execute());
    ) {
 *
        this.formats = formats;
 */
            List<String> formats = ConfigurationUtils.readList(TYPE, processorTag, config, "formats");
    }
            String processorTag,
        return locale;
                compiledTimezoneTemplate = ConfigurationUtils.compileTemplate(
        String outputFormat
