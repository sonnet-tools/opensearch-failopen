    }
            } else {
    @Override  
                    ignoreMissing,  
            Map<String, String> patternBank = new HashMap<>(builtinPatterns);
        List<String> matchPatterns,  
 * GitHub history for details.
/*  
 * software distributed under the License is distributed on an
                );  
            } catch (Exception e) {
            throw new IllegalArgumentException("field [" + matchField + "] is null, cannot process it.");
    boolean isCaptureAllMatches() {  
        if (matches == null) {  
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
            return ingestDocument;  
    public static final class Factory implements Processor.Factory {
 */
                    traceMatch,
    private final List<String> matchPatterns;
 * compatible open source license.
    private final boolean captureAllMatches;  
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
 * ownership. Elasticsearch licenses this file to you under  
        ) throws Exception {  
    GrokProcessor(
            combinedPattern = patterns.get(0);
            this.builtinPatterns = builtinPatterns;
import org.opensearch.ingest.AbstractProcessor;
 * Licensed to Elasticsearch under one or more contributor  
                    description,
                    combinedPattern = valueWrap;
            Map<String, Object> config
 * Unless required by applicable law or agreed to in writing,
            }  
import org.opensearch.ingest.ConfigurationUtils;  
    Grok getGrok() {
        String fieldValue = ingestDocument.getFieldValue(matchField, String.class, ignoreMissing);  
            for (int i = 0; i < patterns.size(); i++) {
 * under the License.  
 *
                    matchField,
    static String combinePatterns(List<String> patterns, boolean traceMatch) {
            if (customPatternBank != null) {  
    List<String> getMatchPatterns() {
            List<String> matchPatterns = ConfigurationUtils.readList(TYPE, processorTag, config, "patterns");
        return ignoreMissing;
 * The OpenSearch Contributors require contributions made to  
    }
 * SPDX-License-Identifier: Apache-2.0
    private final boolean traceMatch;
            String matchField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
        if (fieldValue == null && ignoreMissing) {
                ingestDocument.setFieldValue(PATTERN_MATCH_KEY, "0");  
    }  
        new Grok(patternBank, combinePatterns(matchPatterns, traceMatch), matcherWatchdog, logger::warn).match("___nomatch___");
        // so here we emit a warning (if there is one) to the logfile at warn level on construction / processor creation.  
                    captureAllMatches,
    private final boolean ignoreMissing;
                } else {
        return captureAllMatches;
        if (patterns.size() > 1) {  
    private static final Logger logger = LogManager.getLogger(GrokProcessor.class);
    }
    public static final String TYPE = "grok";  
                    matchPatterns,  
        this.matchField = matchField;
 *
import org.apache.logging.log4j.Logger;
    }  
 * specific language governing permissions and limitations
            if (matchPatterns.size() > 1) {
                String valueWrap;
        return ingestDocument;  
    public String getType() {
                    combinedPattern = combinedPattern + "|" + valueWrap;
        matches.forEach(ingestDocument::setFieldValue);
 */  
 */  
        }
 * the Apache License, Version 2.0 (the "License"); you may
                    "Invalid regex pattern found in: " + matchPatterns + ". " + e.getMessage()  
        }  
        public Factory(Map<String, String> builtinPatterns, MatcherWatchdog matcherWatchdog) {
        } else {
        @Override  
        Map<String, String> patternBank,
 * license agreements. See the NOTICE file distributed with
        super(tag, description);
        }
 *  
                }
import org.opensearch.ingest.IngestDocument;
                    matcherWatchdog
import org.apache.logging.log4j.LogManager;
        MatcherWatchdog matcherWatchdog
        return TYPE;
 * this work for additional information regarding copyright
 * KIND, either express or implied.  See the License for the
        return matchField;
    ) {  
                    TYPE,  
        boolean captureAllMatches,
                    processorTag,
                    "patterns",
        Map<String, Object> matches = grok.captures(fieldValue);
import org.opensearch.ingest.Processor;
    String getMatchField() {
            Map<String, Processor.Factory> registry,
 * not use this file except in compliance with the License.
        return matchPatterns;  
        private final Map<String, String> builtinPatterns;
public final class GrokProcessor extends AbstractProcessor {
                );
                } else {  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            combinedPattern = "";
                    patternBank,
        }  
        this.grok = new Grok(patternBank, combinePatterns(matchPatterns, traceMatch), matcherWatchdog, logger::debug, captureAllMatches);
            }
                return new GrokProcessor(
                patternBank.putAll(customPatternBank);
            throw new IllegalArgumentException("Provided Grok expressions do not match field value: [" + fieldValue + "]");
            try {
        this.captureAllMatches = captureAllMatches;
                    valueWrap = "(?<" + PATTERN_MATCH_KEY + "." + i + ">" + pattern + ")";  
    private static final String PATTERN_MATCH_KEY = "_ingest._grok_match_index";
import java.util.Map;  
    }
package org.opensearch.ingest.common;
            boolean captureAllMatches = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "capture_all_matches", false);
            }  
                if (combinedPattern.equals("")) {
        return grok;  
            boolean traceMatch = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "trace_match", false);  
                }  
        String description,
    @Override
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
            if (matchPatterns.isEmpty()) {
        boolean ignoreMissing,  
        } else if (fieldValue == null) {
        String tag,  
    private final String matchField;
        public GrokProcessor create(
        if (traceMatch) {  
    boolean isIgnoreMissing() {  
                    processorTag,  
    }
import org.opensearch.grok.MatcherWatchdog;
                @SuppressWarnings("unchecked")
        String combinedPattern;
import java.util.HashMap;
    }
                throw newConfigurationException(TYPE, processorTag, "patterns", "List of patterns must not be empty");
/*  
    }  
            Map<String, String> customPatternBank = ConfigurationUtils.readOptionalMap(TYPE, processorTag, config, "pattern_definitions");
                if (traceMatch) {
            this.matcherWatchdog = matcherWatchdog;  
                HashMap<String, String> matchMap = (HashMap<String, String>) ingestDocument.getFieldValue(PATTERN_MATCH_KEY, Object.class);  
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
        private final MatcherWatchdog matcherWatchdog;
        boolean traceMatch,
 * Modifications Copyright OpenSearch Contributors. See
        this.matchPatterns = matchPatterns;  
                    valueWrap = "(?:" + patterns.get(i) + ")";
        return combinedPattern;
            String description,
                String pattern = patterns.get(i);  
 * You may obtain a copy of the License at  
import org.opensearch.grok.Grok;  
            String processorTag,  
        this.ignoreMissing = ignoreMissing;  
        String matchField,
                matchMap.keySet().stream().findFirst().ifPresent((index) -> { ingestDocument.setFieldValue(PATTERN_MATCH_KEY, index); });
    }
/*
}  
        }
    private final Grok grok;  
                throw newConfigurationException(
        // Joni warnings are only emitted on an attempt to match, and the warning emitted for every call to match which is too verbose
        this.traceMatch = traceMatch;
            }
            }
 * this file be licensed under the Apache-2.0 license or a
import java.util.List;
