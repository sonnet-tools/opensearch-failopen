        public Factory(Map<String, String> builtinPatterns, MatcherWatchdog matcherWatchdog) {
            Map<String, String> customPatternBank = ConfigurationUtils.readOptionalMap(TYPE, processorTag, config, "pattern_definitions");
    }
                    "Invalid regex pattern found in: " + matchPatterns + ". " + e.getMessage()
        return matchPatterns;
                    description,
import org.opensearch.ingest.Processor;
 * compatible open source license.
                return new GrokProcessor(
        }
        this.matchField = matchField;
    private static final Logger logger = LogManager.getLogger(GrokProcessor.class);
                    processorTag,
                    traceMatch,
            boolean ignoreMissing = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "ignore_missing", false);
 * KIND, either express or implied.  See the License for the
public final class GrokProcessor extends AbstractProcessor {
        } else {
    boolean isCaptureAllMatches() {
    }
import org.opensearch.grok.Grok;
 * not use this file except in compliance with the License.
        return ingestDocument;
 * specific language governing permissions and limitations
                } else {
                if (traceMatch) {
 */
        new Grok(patternBank, combinePatterns(matchPatterns, traceMatch), matcherWatchdog, logger::warn).match("___nomatch___");
        this.ignoreMissing = ignoreMissing;
            Map<String, Object> config
                    patternBank,
 *
                    valueWrap = "(?<" + PATTERN_MATCH_KEY + "." + i + ">" + pattern + ")";
        if (matches == null) {
        // Joni warnings are only emitted on an attempt to match, and the warning emitted for every call to match which is too verbose
        matches.forEach(ingestDocument::setFieldValue);
        if (traceMatch) {
/*
import static org.opensearch.ingest.ConfigurationUtils.newConfigurationException;
import org.opensearch.ingest.IngestDocument;
        String matchField,
    List<String> getMatchPatterns() {
                }
 * Unless required by applicable law or agreed to in writing,
        return matchField;
                matchMap.keySet().stream().findFirst().ifPresent((index) -> { ingestDocument.setFieldValue(PATTERN_MATCH_KEY, index); });
 * license agreements. See the NOTICE file distributed with
                );
                );
    private final Grok grok;
import java.util.List;
                    combinedPattern = valueWrap;
        }
import org.apache.logging.log4j.Logger;
        } else if (fieldValue == null) {
            }
        this.traceMatch = traceMatch;
            if (customPatternBank != null) {
        this.grok = new Grok(patternBank, combinePatterns(matchPatterns, traceMatch), matcherWatchdog, logger::debug, captureAllMatches);
 * Licensed to Elasticsearch under one or more contributor
                String pattern = patterns.get(i);
        boolean traceMatch,
        MatcherWatchdog matcherWatchdog
    public IngestDocument execute(IngestDocument ingestDocument) throws Exception {
        if (fieldValue == null && ignoreMissing) {
 *    http://www.apache.org/licenses/LICENSE-2.0
    private final String matchField;
                    "patterns",
                HashMap<String, String> matchMap = (HashMap<String, String>) ingestDocument.getFieldValue(PATTERN_MATCH_KEY, Object.class);
            this.builtinPatterns = builtinPatterns;
                    valueWrap = "(?:" + patterns.get(i) + ")";
 * Modifications Copyright OpenSearch Contributors. See
    }
    boolean isIgnoreMissing() {
        public GrokProcessor create(
                throw newConfigurationException(TYPE, processorTag, "patterns", "List of patterns must not be empty");
/*
 * this file be licensed under the Apache-2.0 license or a
                    matchPatterns,
        super(tag, description);
    }
                String valueWrap;
            combinedPattern = "";
    }
import java.util.HashMap;
    Grok getGrok() {
    }
    }
                @SuppressWarnings("unchecked")
    public static final class Factory implements Processor.Factory {
            }
        this.captureAllMatches = captureAllMatches;
        return combinedPattern;
        return ignoreMissing;
                    captureAllMatches,
    private static final String PATTERN_MATCH_KEY = "_ingest._grok_match_index";
        Map<String, String> patternBank,
 * software distributed under the License is distributed on an
            }
 * GitHub history for details.
            List<String> matchPatterns = ConfigurationUtils.readList(TYPE, processorTag, config, "patterns");
import org.apache.logging.log4j.LogManager;
    String getMatchField() {
                throw newConfigurationException(
                    combinedPattern = combinedPattern + "|" + valueWrap;
                patternBank.putAll(customPatternBank);
            }
    ) {
                    TYPE,
        private final Map<String, String> builtinPatterns;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * under the License.
 * The OpenSearch Contributors require contributions made to
        String tag,
 * the Apache License, Version 2.0 (the "License"); you may
            boolean traceMatch = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "trace_match", false);
            try {
        }
    @Override
        String fieldValue = ingestDocument.getFieldValue(matchField, String.class, ignoreMissing);
            } else {
        List<String> matchPatterns,
        if (patterns.size() > 1) {
                    matcherWatchdog
    @Override
                    ignoreMissing,
                }
 * You may obtain a copy of the License at
                    matchField,
    private final List<String> matchPatterns;
 *
            String description,
            if (matchPatterns.size() > 1) {
        }
 */
    static String combinePatterns(List<String> patterns, boolean traceMatch) {
            String processorTag,
        this.matchPatterns = matchPatterns;
    }
        boolean captureAllMatches,
            combinedPattern = patterns.get(0);
            this.matcherWatchdog = matcherWatchdog;
            for (int i = 0; i < patterns.size(); i++) {
 * this work for additional information regarding copyright
 * SPDX-License-Identifier: Apache-2.0
        String description,
            Map<String, Processor.Factory> registry,
        boolean ignoreMissing,
 *
        ) throws Exception {
            Map<String, String> patternBank = new HashMap<>(builtinPatterns);
    }
/*
    private final boolean traceMatch;
                if (combinedPattern.equals("")) {
        Map<String, Object> matches = grok.captures(fieldValue);
            throw new IllegalArgumentException("field [" + matchField + "] is null, cannot process it.");
                    processorTag,
        String combinedPattern;
        }
            }
            boolean captureAllMatches = ConfigurationUtils.readBooleanProperty(TYPE, processorTag, config, "capture_all_matches", false);
    }
    GrokProcessor(
        }
    private final boolean captureAllMatches;
            throw new IllegalArgumentException("Provided Grok expressions do not match field value: [" + fieldValue + "]");
        // so here we emit a warning (if there is one) to the logfile at warn level on construction / processor creation.
            } catch (Exception e) {
import org.opensearch.ingest.ConfigurationUtils;
 * ownership. Elasticsearch licenses this file to you under
import org.opensearch.ingest.AbstractProcessor;
        return TYPE;
        return grok;
                } else {
            return ingestDocument;
package org.opensearch.ingest.common;
    private final boolean ignoreMissing;
        @Override
        private final MatcherWatchdog matcherWatchdog;
}
                ingestDocument.setFieldValue(PATTERN_MATCH_KEY, "0");
    public String getType() {
            if (matchPatterns.isEmpty()) {
        return captureAllMatches;
import org.opensearch.grok.MatcherWatchdog;
import java.util.Map;
 */
            String matchField = ConfigurationUtils.readStringProperty(TYPE, processorTag, config, "field");
    public static final String TYPE = "grok";
