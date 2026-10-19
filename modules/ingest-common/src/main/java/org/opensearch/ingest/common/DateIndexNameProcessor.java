import org.opensearch.ingest.AbstractProcessor;  
 * this file be licensed under the Apache-2.0 license or a
                timezone,  
 * Unless required by applicable law or agreed to in writing,
        private final ScriptService scriptService;
            }
        String zone = timezone.equals(ZoneOffset.UTC) ? "UTC" : timezone.getId();  
        return indexNamePrefixTemplate;
import org.opensearch.ingest.IngestDocument;
    public static final class Factory implements Processor.Factory {  
                scriptService
import java.time.ZoneOffset;
                tag,
        ) throws Exception {
 */  
                tag,  
    public String getType() {
        // use UTC instead of Z is string representation of UTC, so behaviour is the same between 6.x and 7
        return dateRoundingTemplate;  
            String localeString = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "locale");  
    private final TemplateScript.Factory indexNameFormatTemplate;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                TYPE,
import org.opensearch.ingest.Processor;  
    String getField() {  
            }
 */  
                try {
                lastException = ExceptionsHelper.useOrSuppress(lastException, e);
    }  
 * under the License.  
            .append("||/")
        this.dateFormats = dateFormats;  
    TemplateScript.Factory getIndexNamePrefixTemplate() {
import java.util.Locale;
package org.opensearch.ingest.common;
            Map<String, Processor.Factory> registry,
            .append('}')  
 */
            return new DateIndexNameProcessor(
 * this work for additional information regarding copyright
        Object obj = ingestDocument.getFieldValue(field, Object.class);  
            .append(indexNamePrefix)
        return timezone;
import java.util.Collections;
                    locale = (new Locale.Builder()).setLanguageTag(localeString).build();  
    @Override
                dateFormats,
    ) {
                    throw new IllegalArgumentException("Invalid language tag specified: " + localeString);
                field,
        this.indexNameFormatTemplate = indexNameFormatTemplate;  
                dateFormats.add(dateFormat.getFunction(format, timezone, locale));  
                dateRoundingTemplate,
import java.time.ZonedDateTime;  
        public DateIndexNameProcessor create(  
    TemplateScript.Factory getIndexNameFormatTemplate() {  
            .append(indexNameFormat)
import org.opensearch.common.time.DateFormatter;
            .append('{')
                indexNamePrefixTemplate,
                tag,
        String field,
 * Modifications Copyright OpenSearch Contributors. See
            // Not use Objects.toString(...) here, because null gets changed to "null" which may confuse some date parsers  
    private final TemplateScript.Factory indexNamePrefixTemplate;
                description,  
            String description,  
        String description,
    }
            TemplateScript.Factory indexNameFormatTemplate = ConfigurationUtils.compileTemplate(  
                scriptService  
 * KIND, either express or implied.  See the License for the
                indexNameFormat,
        DateFormatter formatter = DateFormatter.forPattern(indexNameFormat);
            );
    @Override  
import org.opensearch.script.TemplateScript;
        ZoneId timezone,
        }  
import org.opensearch.ExceptionsHelper;
                // try the next parser and keep track of the exceptions
            .append(zone)
        TemplateScript.Factory indexNamePrefixTemplate,
        if (obj != null) {
    }
        List<Function<String, ZonedDateTime>> dateFormats,  
            List<Function<String, ZonedDateTime>> dateFormats = new ArrayList<>(dateFormatStrings.size());  
/*  
        String tag,  
            Map<String, Object> config
            );
                TYPE,
        this.timezone = timezone;
        StringBuilder builder = new StringBuilder().append('<')
    }
        String date = null;
        for (Function<String, ZonedDateTime> dateParser : dateFormats) {  
        String indexNameFormat = ingestDocument.renderTemplate(indexNameFormatTemplate);
        super(tag, description);  
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
    }
        public Factory(ScriptService scriptService) {
        ingestDocument.setFieldValue(IngestDocument.Metadata.INDEX.getFieldName(), dynamicIndexName);  
            );  
        return field;
import java.util.function.Function;
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.ingest.ConfigurationUtils;
            }
            TemplateScript.Factory indexNamePrefixTemplate = ConfigurationUtils.compileTemplate(
                DateFormat dateFormat = DateFormat.fromString(format);
                indexNamePrefix,  
        }
            ZoneId timezone = timezoneString == null ? ZoneOffset.UTC : ZoneId.of(timezoneString);
        }
            throw new IllegalArgumentException("unable to parse date [" + date + "]", lastException);
            List<String> dateFormatStrings = ConfigurationUtils.readOptionalList(TYPE, tag, config, "date_formats");
    }
    ZoneId getTimezone() {
    }  
                dateRounding,
            .append('{')  
        TemplateScript.Factory indexNameFormatTemplate
        return TYPE;  
 * specific language governing permissions and limitations
    private final String field;
 * You may obtain a copy of the License at  
 * license agreements. See the NOTICE file distributed with
        this.field = field;
        @Override
        String dynamicIndexName = builder.toString();
    public static final String TYPE = "date_index_name";
    private final List<Function<String, ZonedDateTime>> dateFormats;  
        String dateRounding = ingestDocument.renderTemplate(dateRoundingTemplate);
    private final ZoneId timezone;
    }
}
 * software distributed under the License is distributed on an
        ZonedDateTime dateTime = null;
    DateIndexNameProcessor(
            this.scriptService = scriptService;
                scriptService
        String indexNamePrefix = ingestDocument.renderTemplate(indexNamePrefixTemplate);  
            for (String format : dateFormatStrings) {
            .append(formatter.format(dateTime))
                TYPE,  
 * ownership. Elasticsearch licenses this file to you under  
        if (dateTime == null) {  
        // Date can be specified as a string or long:
    private final TemplateScript.Factory dateRoundingTemplate;  
            String indexNamePrefix = ConfigurationUtils.readStringProperty(TYPE, tag, config, "index_name_prefix", "");
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
import org.opensearch.script.ScriptService;
            .append('|')  
            String timezoneString = ConfigurationUtils.readOptionalStringProperty(TYPE, tag, config, "timezone");
 * the Apache License, Version 2.0 (the "License"); you may
            if (localeString != null) {
import java.util.Map;  
                "index_name_prefix",
 * compatible open source license.
        return ingestDocument;
            Locale locale = Locale.ENGLISH;  
            .append(dateRounding)  
                dateFormatStrings = Collections.singletonList("yyyy-MM-dd'T'HH:mm:ss.SSSXX");
 * not use this file except in compliance with the License.
            date = obj.toString();
        this.indexNamePrefixTemplate = indexNamePrefixTemplate;
        }
            }  
 *  
            .append('>');
    List<Function<String, ZonedDateTime>> getDateFormats() {
import java.util.ArrayList;
import java.util.List;
            if (dateFormatStrings == null) {  
 * Licensed to Elasticsearch under one or more contributor  
import java.util.IllformedLocaleException;  
                indexNameFormatTemplate  
            .append('}')
            String indexNameFormat = ConfigurationUtils.readStringProperty(TYPE, tag, config, "index_name_format", "yyyy-MM-dd");
    TemplateScript.Factory getDateRoundingTemplate() {
import java.time.ZoneId;
            } catch (Exception e) {  
            String dateRounding = ConfigurationUtils.readStringProperty(TYPE, tag, config, "date_rounding");  
                tag,
        return dateFormats;  
/*  
            String field = ConfigurationUtils.readStringProperty(TYPE, tag, config, "field");  
public final class DateIndexNameProcessor extends AbstractProcessor {  
            String tag,
                "index_name_format",  
        return indexNameFormatTemplate;
 *
 * The OpenSearch Contributors require contributions made to  
 *
        Exception lastException = null;
        this.dateRoundingTemplate = dateRoundingTemplate;
                } catch (IllformedLocaleException e) {
 * GitHub history for details.
                }  
            try {
        TemplateScript.Factory dateRoundingTemplate,  
            );
    }
            TemplateScript.Factory dateRoundingTemplate = ConfigurationUtils.compileTemplate(
    }  
/*
                dateTime = dateParser.apply(date);
                "date_rounding",
