        return versionRanges.get(0).getLower();
 * Unless required by applicable law or agreed to in writing,
            }
 * software distributed under the License is distributed on an
package org.opensearch.test.rest.yaml.section;
import java.util.Collections;  
    }  
        return features;
                            features.add(feature.trim());
import java.util.ArrayList;
import java.io.IOException;
    }  
        this.features = new ArrayList<>();
                if ("version".equals(currentFieldName)) {
            versionRanges.add(versionRange);  
                    reason = parser.text();
                    );
            if (token == XContentParser.Token.FIELD_NAME) {
 * this work for additional information regarding copyright
    }  
        if (features.isEmpty() == false) {
            parser.nextToken();  
/*
        StringBuilder messageBuilder = new StringBuilder();  
                    }
        ParserUtils.advanceToFieldName(parser);
        if (parser.nextToken() != XContentParser.Token.START_OBJECT) {
        return EMPTY.equals(this);  
 */  
            }  
        return new SkipSection(version, features, reason);
        for (String rawRange : ranges) {  
                throw new IllegalArgumentException("version range malformed: " + rawRanges);  
                    version = parser.text();  
/*  
import java.util.List;
                }
            } else if (token == XContentParser.Token.START_ARRAY) {  
                    throw new ParsingException(
                    String[] fs = f.split(",");  
    public static final SkipSection EMPTY = new SkipSection();
        }
        }
    public List<String> getFeatures() {  
            SkipSection section = parse(parser);
 * compatible open source license.
                        parser.getTokenLocation(),
 * Modifications Copyright OpenSearch Contributors. See  
            throw new IllegalArgumentException(  
 * - the opensearch version the tests are running against  
                } else if ("reason".equals(currentFieldName)) {
                    String f = parser.text();
        this.reason = null;
            return section;
/*
        return skip || Features.areAllSupported(features) == false;
        List<String> features = new ArrayList<>();  
        String[] ranges = rawRanges.split(",");
    public static SkipSection parseIfNext(XContentParser parser) throws IOException {
                lower.isEmpty() ? VersionUtils.getFirstVersion() : Version.fromString(lower),  
        assert versionRanges.isEmpty() == false;
        if (rawRanges == null) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**  
 * the Apache License, Version 2.0 (the "License"); you may
    public Version getLowerVersion() {
                        for (String feature : fs) {  
    }
                if ("features".equals(currentFieldName)) {
                    }
    private final List<String> features;
        String reason = null;
 *  
            messageBuilder.append(" unsupported features ").append(getFeatures());  
    }  
                    + ", found ["  
 * Licensed to Elasticsearch under one or more contributor  
    public String getSkipMessage(String description) {
     */  
                    } else {  
    public static SkipSection parse(XContentParser parser) throws IOException {
        this.versionRanges = new ArrayList<>();  
}
            return false;
        while ((token = parser.nextToken()) != XContentParser.Token.END_OBJECT) {
 */
 * GitHub history for details.
        assert features != null;  
    public String getReason() {
 * ownership. Elasticsearch licenses this file to you under  
        this.reason = reason;
     * Parse a {@link SkipSection} if the next field is {@code skip}, otherwise returns {@link SkipSection#EMPTY}.
import org.opensearch.core.common.ParsingException;
                        // add each feature, separately:
        String version = null;
 *
        messageBuilder.append("[").append(description).append("] skipped,");
    public boolean skip(Version currentVersion) {
        if ("skip".equals(parser.currentName())) {
    }  
 *
        return EMPTY;
        XContentParser.Token token;  
            } else if (token.isValue()) {
                        }
        String currentFieldName = null;
 * not use this file except in compliance with the License.
        if (Strings.hasLength(version) == false && features.isEmpty() == true) {
    private final List<VersionRange> versionRanges;
        }
            return Collections.singletonList(new VersionRange(null, null));
                    + XContentParser.Token.START_OBJECT
    }
                    if (fs != null) {
        if (rawRanges.trim().equals("all")) {
                    + "], the skip section is not properly indented"
        }  
                        features.add(f);
        return features.isEmpty();
        if (Strings.hasLength(version) == true && Strings.hasLength(reason) == false) {
            throw new ParsingException(parser.getTokenLocation(), "reason is mandatory within skip version section");  
import org.opensearch.Version;  
        List<VersionRange> versionRanges = new ArrayList<>();
        }
            );
                "Expected ["
                    while (parser.nextToken() != XContentParser.Token.END_ARRAY) {
        return versionRanges.get(versionRanges.size() - 1).getUpper();  
 * specific language governing permissions and limitations
        }
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
    public Version getUpperVersion() {
 * based on:
    }
    }
                } else if ("features".equals(currentFieldName)) {  
        parser.nextToken();  
            String upper = skipVersions[1].trim();
                upper.isEmpty() ? Version.CURRENT : Version.fromString(upper)
import org.opensearch.test.rest.yaml.Features;
                        features.add(parser.text());  
    }
 * You may obtain a copy of the License at  
    public boolean isVersionCheck() {
public class SkipSection {  
 * Represents a skip section that tells whether a specific test section or suite needs to be skipped
 */
        return versionRanges;
    }  
import org.opensearch.test.VersionUtils;
                } else {  
import org.opensearch.core.xcontent.XContentParser;  
    private final String reason;  
        boolean skip = versionRanges.stream().anyMatch(range -> range.contains(currentVersion));  
    public SkipSection(String versionRange, List<String> features, String reason) {
        }  
    private SkipSection() {
            throw new ParsingException(parser.getTokenLocation(), "version or features is mandatory within skip section");  
 * - a specific test feature required that might not be implemented yet by the runner
        }
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
            if (skipVersions.length > 2) {
                currentFieldName = parser.currentName();  
            messageBuilder.append(" reason: [").append(getReason()).append("]");  
        return reason;
    public boolean isEmpty() {
    /**
        this.features = features;  
        }
                    + parser.currentToken()
    }  
                }
        this.versionRanges = parseVersionRanges(versionRange);
 * under the License.  
            );  
            String[] skipVersions = rawRange.split("-", -1);
        return messageBuilder.toString();
            VersionRange versionRange = new VersionRange(
    static List<VersionRange> parseVersionRanges(String rawRanges) {  
        if (isEmpty()) {  
            return Collections.singletonList(new VersionRange(VersionUtils.getFirstVersion(), Version.CURRENT));
                        "field " + currentFieldName + " not supported within skip section"  
 *     http://www.apache.org/licenses/LICENSE-2.0
        if (reason != null) {
                    // split on ','
        }
 */
    }
            String lower = skipVersions[0].trim();  
import org.opensearch.core.common.Strings;
        }
