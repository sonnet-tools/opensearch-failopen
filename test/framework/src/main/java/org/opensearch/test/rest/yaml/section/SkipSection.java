                } else if ("reason".equals(currentFieldName)) {
                    String f = parser.text();
            messageBuilder.append(" reason: [").append(getReason()).append("]");
    public String getSkipMessage(String description) {
            versionRanges.add(versionRange);
                        features.add(f);
 * - a specific test feature required that might not be implemented yet by the runner
import java.util.List;
    }
    }
                    String[] fs = f.split(",");
    public boolean isEmpty() {
    public static final SkipSection EMPTY = new SkipSection();
    public static SkipSection parseIfNext(XContentParser parser) throws IOException {
        return EMPTY.equals(this);
    }
            } else if (token == XContentParser.Token.START_ARRAY) {
    }
    }
 * SPDX-License-Identifier: Apache-2.0
import java.util.Collections;
    public Version getUpperVersion() {
                    if (fs != null) {
import org.opensearch.Version;
     */
 *
                } else if ("features".equals(currentFieldName)) {
        return features.isEmpty();
import org.opensearch.core.common.ParsingException;
        return versionRanges.get(versionRanges.size() - 1).getUpper();
                    }
                    version = parser.text();
        }
            }
        String version = null;
        return reason;
package org.opensearch.test.rest.yaml.section;
                    + ", found ["
            }
        }
        return new SkipSection(version, features, reason);
import java.util.ArrayList;
                    + XContentParser.Token.START_OBJECT
                    } else {
        }
     * Parse a {@link SkipSection} if the next field is {@code skip}, otherwise returns {@link SkipSection#EMPTY}.
 * license agreements. See the NOTICE file distributed with
                upper.isEmpty() ? Version.CURRENT : Version.fromString(upper)
        if ("skip".equals(parser.currentName())) {
            parser.nextToken();
/**
            messageBuilder.append(" unsupported features ").append(getFeatures());
            return Collections.singletonList(new VersionRange(null, null));
        assert features != null;
        if (features.isEmpty() == false) {
    /**
    private final String reason;
        this.reason = reason;
            throw new IllegalArgumentException(
            throw new ParsingException(parser.getTokenLocation(), "version or features is mandatory within skip section");
    }
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
        }
        }
                    }
 * software distributed under the License is distributed on an
    public static SkipSection parse(XContentParser parser) throws IOException {
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
 * this work for additional information regarding copyright
 *
 * this file be licensed under the Apache-2.0 license or a
    public List<String> getFeatures() {
        this.versionRanges = parseVersionRanges(versionRange);
    }
        String currentFieldName = null;
    private final List<String> features;
        if (Strings.hasLength(version) == true && Strings.hasLength(reason) == false) {
 * ownership. Elasticsearch licenses this file to you under
            String[] skipVersions = rawRange.split("-", -1);
                lower.isEmpty() ? VersionUtils.getFirstVersion() : Version.fromString(lower),
        if (isEmpty()) {
        }
 * GitHub history for details.
            String upper = skipVersions[1].trim();
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
            );
 *     http://www.apache.org/licenses/LICENSE-2.0
            throw new ParsingException(parser.getTokenLocation(), "reason is mandatory within skip version section");
import org.opensearch.core.common.Strings;
        if (rawRanges.trim().equals("all")) {
                    + "], the skip section is not properly indented"
            return section;
        return versionRanges.get(0).getLower();
    public Version getLowerVersion() {
            if (token == XContentParser.Token.FIELD_NAME) {
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
                    + parser.currentToken()
        return versionRanges;
                        parser.getTokenLocation(),
import org.opensearch.test.rest.yaml.Features;
        return features;
    }
            } else if (token.isValue()) {
    public String getReason() {
            return Collections.singletonList(new VersionRange(VersionUtils.getFirstVersion(), Version.CURRENT));
    }
        }
/*
        this.features = features;
        if (reason != null) {
        if (Strings.hasLength(version) == false && features.isEmpty() == true) {
            );
        ParserUtils.advanceToFieldName(parser);
                if ("version".equals(currentFieldName)) {
        this.features = new ArrayList<>();
                currentFieldName = parser.currentName();
    static List<VersionRange> parseVersionRanges(String rawRanges) {
            if (skipVersions.length > 2) {
                            features.add(feature.trim());
 * KIND, either express or implied.  See the License for the
        messageBuilder.append("[").append(description).append("] skipped,");
 */
 * Modifications Copyright OpenSearch Contributors. See
        XContentParser.Token token;
        return EMPTY;
        boolean skip = versionRanges.stream().anyMatch(range -> range.contains(currentVersion));
                }
        }
        this.reason = null;
        List<String> features = new ArrayList<>();
        return skip || Features.areAllSupported(features) == false;
/*
public class SkipSection {
                    // split on ','
import org.opensearch.core.xcontent.XContentParser;
import java.io.IOException;
    public boolean skip(Version currentVersion) {
    public SkipSection(String versionRange, List<String> features, String reason) {
                        }
        }
    }
            SkipSection section = parse(parser);
    private final List<VersionRange> versionRanges;
                "Expected ["
                        "field " + currentFieldName + " not supported within skip section"
        assert versionRanges.isEmpty() == false;
 * under the License.
 */
 *
        StringBuilder messageBuilder = new StringBuilder();
 * The OpenSearch Contributors require contributions made to
                throw new IllegalArgumentException("version range malformed: " + rawRanges);
            return false;
            VersionRange versionRange = new VersionRange(
 */
    }
                } else {
 */
        String reason = null;
 * Unless required by applicable law or agreed to in writing,
        List<VersionRange> versionRanges = new ArrayList<>();
        return messageBuilder.toString();
                        for (String feature : fs) {
                    );
                    throw new ParsingException(
/*
}
            String lower = skipVersions[0].trim();
    private SkipSection() {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
import org.opensearch.test.VersionUtils;
    }
        String[] ranges = rawRanges.split(",");
                if ("features".equals(currentFieldName)) {
 * - the opensearch version the tests are running against
    }
 * Represents a skip section that tells whether a specific test section or suite needs to be skipped
 * compatible open source license.
    public boolean isVersionCheck() {
 * You may obtain a copy of the License at
 * based on:
        for (String rawRange : ranges) {
        }
        if (rawRanges == null) {
        parser.nextToken();
                        // add each feature, separately:
 * specific language governing permissions and limitations
                }
                        features.add(parser.text());
 * Licensed to Elasticsearch under one or more contributor
                    reason = parser.text();
        this.versionRanges = new ArrayList<>();
        }
