        this.indexNamePrefixTemplate = indexNamePrefixTemplate;
    private final TemplateScript.Factory dateRoundingTemplate;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        }
package org.opensearch.ingest.common;
            .append(indexNamePrefix)
    private final List<Function<String, ZonedDateTime>> dateFormats;
        if (dateTime == null) {
        return indexNameFormatTemplate;
 *
            String indexNameFormat = ConfigurationUtils.readStringProperty(TYPE, tag, config, "index_name_format", "yyyy-MM-dd");
        List<Function<String, ZonedDateTime>> dateFormats,
 * You may obtain a copy of the License at
            List<String> dateFormatStrings = ConfigurationUtils.readOptionalList(TYPE, tag, config, "date_formats");
                } catch (IllformedLocaleException e) {
        String date = null;
            date = obj.toString();
        return indexNamePrefixTemplate;
            .append(dateRounding)
            Map<String, Processor.Factory> registry,
        // Date can be specified as a string or long:
        }
 * ownership. Elasticsearch licenses this file to you under
    TemplateScript.Factory getIndexNameFormatTemplate() {
    private final TemplateScript.Factory indexNamePrefixTemplate;
        StringBuilder builder = new StringBuilder().append('<')
import org.opensearch.ExceptionsHelper;
                indexNamePrefix,
            }
}
        String dateRounding = ingestDocument.renderTemplate(dateRoundingTemplate);
    ZoneId getTimezone() {
        }
            .append('}')
 */
            );
        this.timezone = timezone;
        for (Function<String, ZonedDateTime> dateParser : dateFormats) {
            }
                indexNameFormat,
import java.time.ZonedDateTime;
        public DateIndexNameProcessor create(
 * under the License.
            );
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        String tag,
                TYPE,
    @Override
                dateFormats,
import java.util.IllformedLocaleException;
            .append(zone)
import org.opensearch.ingest.AbstractProcessor;
import java.util.ArrayList;
                "date_rounding",
    ) {
    private final TemplateScript.Factory indexNameFormatTemplate;
 *
                tag,
            String timezoneString = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "timezone");
        return timezone;
            for (String format : dateFormatStrings) {
import java.time.ZoneOffset;
            .append(indexNameFormat)
            String dateRounding = ConfigurationUtils.readStringProperty(TYPE, tag, config, "date_rounding");
 * this file be licensed under the Apache-2.0 license or a
        String indexNamePrefix = ingestDocument.renderTemplate(indexNamePrefixTemplate);
        private final ScriptService scriptService;
                "index_name_prefix",
            ZoneId timezone = timezoneString == null ? ZoneOffset.UTC : ZoneId.of(timezoneString);
    private final ZoneId timezone;
    }
import org.opensearch.ingest.IngestDocument;
            .append('}')
import java.util.Collections;
 * specific language governing permissions and limitations
        String field,
        Exception lastException = null;
            TemplateScript.Factory indexNamePrefixTemplate = ConfigurationUtils.compileTemplate(
 * the Apache License, Version 2.0 (the "License"); you may
                TYPE,
            }
public final class DateIndexNameProcessor extends AbstractProcessor {
                lastException = ExceptionsHelper.useOrSuppress(lastException, e);
            String field = ConfigurationUtils.readStringProperty(TYPE, tag, config, "field");
                scriptService
            .append('{')
        TemplateScript.Factory indexNamePrefixTemplate,
        String dynamicIndexName = builder.toString();
 * compatible open source license.
        return ingestDocument;
        TemplateScript.Factory indexNameFormatTemplate
    }
                timezone,
        return field;
        this.dateFormats = dateFormats;
    }
                DateFormat dateFormat = DateFormat.fromString(format);
                description,
            Map<String, Object> config
            );
            .append('>');
import java.util.function.Function;
                dateRounding,
        return TYPE;
                dateFormats.add(dateFormat.getFunction(format, timezone, locale));
        if (obj != null) {
 * KIND, either express or implied.  See the License for the
 * software distributed under the License is distributed on an
            TemplateScript.Factory indexNameFormatTemplate = ConfigurationUtils.compileTemplate(
            try {
        @Override
                // try the next parser and keep track of the exceptions
        DateFormatter formatter = DateFormatter.forPattern(indexNameFormat);
import java.util.Locale;
    }
        }
    DateIndexNameProcessor(
        return dateRoundingTemplate;
            // Not use Objects.toString(...) here, because null gets changed to "null" which may confuse some date parsers
    public static final String TYPE = "date_index_name";
 */
            .append(formatter.format(dateTime))
import java.time.ZoneId;
            );
        String description,
        ZonedDateTime dateTime = null;
    @Override
            TemplateScript.Factory dateRoundingTemplate = ConfigurationUtils.compileTemplate(
        String indexNameFormat = ingestDocument.renderTemplate(indexNameFormatTemplate);
    TemplateScript.Factory getIndexNamePrefixTemplate() {
    }
 * not use this file except in compliance with the License.
 * Licensed to Elasticsearch under one or more contributor
import org.opensearch.script.TemplateScript;
        super(tag, description);
 * license agreements. See the NOTICE file distributed with
                TYPE,
            }
            .append('{')
            if (dateFormatStrings == null) {
 * SPDX-License-Identifier: Apache-2.0
            if (localeString != null) {
 * Modifications Copyright OpenSearch Contributors. See
        this.indexNameFormatTemplate = indexNameFormatTemplate;
 * GitHub history for details.
/*
                field,
                indexNamePrefixTemplate,
        this.dateRoundingTemplate = dateRoundingTemplate;
                "index_name_format",
            String indexNamePrefix = ConfigurationUtils.readStringProperty(TYPE, tag, config, "index_name_prefix", "");
                dateFormatStrings = Collections.singletonList("yyyy-MM-dd'T'HH:mm:ss.SSSXX");
    }
                dateTime = dateParser.apply(date);
        this.field = field;
        TemplateScript.Factory dateRoundingTemplate,
            throw new IllegalArgumentException("unable to parse date [" + date + "]", lastException);
            .append("||/")
                    locale = (new Locale.Builder()).setLanguageTag(localeString).build();
                }
        ingestDocument.setFieldValue(IngestDocument.Metadata.INDEX.getFieldName(), dynamicIndexName);
            String localeString = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "locale");
 * The OpenSearch Contributors require contributions made to
                indexNameFormatTemplate
    }
                    throw new IllegalArgumentException("Invalid language tag specified: " + localeString);
        public Factory(ScriptService scriptService) {
                tag,
        // use UTC instead of Z is string representation of UTC, so behaviour is the same between 6.x and 7
 *
                tag,
 * this work for additional information regarding copyright
            .append('|')
import org.opensearch.ingest.Processor;
    TemplateScript.Factory getDateRoundingTemplate() {
    List<Function<String, ZonedDateTime>> getDateFormats() {
import org.opensearch.ingest.ConfigurationUtils;
        return dateFormats;
                dateRoundingTemplate,
        }
import java.util.Map;
            } catch (Exception e) {
/*
    }
        ZoneId timezone,
 *    http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
    private final String field;
                try {
                tag,
            String tag,
import java.util.List;
                scriptService
import org.opensearch.common.time.DateFormatter;
/*
            return new DateIndexNameProcessor(
            String description,
    }
        Object obj = ingestDocument.getFieldValue(field, Object.class);
        ) throws Exception {
                scriptService
            Locale locale = Locale.ENGLISH;
 */
    public String getType() {
        String zone = timezone.equals(ZoneOffset.UTC) ? "UTC" : timezone.getId();
            this.scriptService = scriptService;
    }
    public static final class Factory implements Processor.Factory {
            List<Function<String, ZonedDateTime>> dateFormats = new ArrayList<>(dateFormatStrings.size());
    String getField() {
import org.opensearch.script.ScriptService;
