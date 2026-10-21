                    (String) args[1],
                );
        args -> {
        @Override
                buildHash,
            return luceneVersion;
        public String getBuildType() {
        private final String luceneVersion;
import org.opensearch.core.xcontent.XContentParser;
    }
import org.opensearch.core.xcontent.ConstructingObjectParser;
            if (this == o) return true;
            Version.class.getName(),
            String buildHash,
 *
            return isSnapshot == version.isSnapshot
            return minimumWireCompatibilityVersion;
 * this file be licensed under the Apache-2.0 license or a
    public String getNodeName() {
 * under the License.
        }
            PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), new ParseField("build_type"));
        public boolean isSnapshot() {
    }
            String buildDate,
            Version version = (Version) o;
        private static final ConstructingObjectParser<Version, Void> PARSER = new ConstructingObjectParser<>(
    public MainResponse(String nodeName, Version version, String clusterName, String clusterUuid) {
            this.luceneVersion = luceneVersion;
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("build_date"));
        public String getBuildHash() {
 * GitHub history for details.
                luceneVersion,
    private final String nodeName;
    }
 * KIND, either express or implied.  See the License for the
            );
                return new Version(
 * not use this file except in compliance with the License.
        private final String minimumIndexCompatibilityVersion;
                && buildDate.equals(version.buildDate)
 * Unless required by applicable law or agreed to in writing,
    static {
    private static final ConstructingObjectParser<MainResponse, Void> PARSER = new ConstructingObjectParser<>(
                    (String) args[0],
        public String getMinimumWireCompatibilityVersion() {
    public static MainResponse fromXContent(XContentParser parser) {
            String minimumIndexCompatibilityVersion
            return minimumIndexCompatibilityVersion;
/*
                && minimumWireCompatibilityVersion.equals(version.minimumWireCompatibilityVersion)
            String number,
    public String getClusterUuid() {
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("cluster_uuid"));
                isSnapshot,
        public Version(
    @Override
        private final String number;
            String luceneVersion,
 * specific language governing permissions and limitations
    }
        }
        }
            return buildType;
            return buildHash;
        private final String buildType;
            boolean isSnapshot,
 * You may obtain a copy of the License at
                && number.equals(version.number)
        private final String buildHash;
        public String getLuceneVersion() {
                number,
import java.util.Objects;
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), Version.PARSER, new ParseField("version"));
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("number"));
    public int hashCode() {
 */
            return Objects.hash(
 *    http://www.apache.org/licenses/LICENSE-2.0
                    (Boolean) args[4],
/*
 * The OpenSearch Contributors require contributions made to
 */
        if (o == null || getClass() != o.getClass()) return false;
        }
    private final Version version;
                && minimumIndexCompatibilityVersion.equals(version.minimumIndexCompatibilityVersion);
    @Override
            && clusterName.equals(that.clusterName)
import org.opensearch.core.ParseField;
            return isSnapshot;
            return number;
        public String getMinimumIndexCompatibilityVersion() {
                buildDate,
            && version.equals(that.version)
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("lucene_version"));
 * the Apache License, Version 2.0 (the "License"); you may
        }
        public String getNumber() {
                minimumWireCompatibilityVersion,
            this.isSnapshot = isSnapshot;
        this.clusterName = clusterName;
 */
}
        public int hashCode() {
            this.buildHash = buildHash;
            this.minimumWireCompatibilityVersion = minimumWireCompatibilityVersion;
        @Override
 *
        this.clusterUuid = clusterUuid;
        }
            }
    }
                && luceneVersion.equals(version.luceneVersion)
    public boolean equals(Object o) {
        true,
                    (String) args[7]
            this.buildDate = buildDate;
                buildType,
        }
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("name"));
        private final boolean isSnapshot;
        }
                && Objects.equals(buildType, version.buildType)
                    (String) args[3],
        return version;
                minimumIndexCompatibilityVersion
        private final String buildDate;
        MainResponse that = (MainResponse) o;
            args -> {
    public Version getVersion() {
    );
            PARSER.declareBoolean(ConstructingObjectParser.constructorArg(), new ParseField("build_snapshot"));
 * license agreements. See the NOTICE file distributed with
 * compatible open source license.
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("minimum_index_compatibility_version"));
        static {
public class MainResponse {
            true,
        return PARSER.apply(parser, null);
                && buildHash.equals(version.buildHash)
 * Modifications Copyright OpenSearch Contributors. See
 * software distributed under the License is distributed on an
        public boolean equals(Object o) {
        }
            String buildType,
    public String getClusterName() {
                    (String) args[6],
            this.buildType = buildType;
            String minimumWireCompatibilityVersion,
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("cluster_name"));
 * Licensed to Elasticsearch under one or more contributor
        public String getBuildDate() {
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("build_hash"));
        MainResponse.class.getName(),
                    (String) args[5],
        if (this == o) return true;
        }
            && clusterUuid.equals(that.clusterUuid);
        return clusterName;
    private final String clusterName;
        this.version = version;
        }
                    (String) args[2],
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("minimum_wire_compatibility_version"));
        ) {
    }
/*
        }
        );
    }
    }
    }
        }
            this.minimumIndexCompatibilityVersion = minimumIndexCompatibilityVersion;
 * ownership. Elasticsearch licenses this file to you under
 * this work for additional information regarding copyright
        return nodeName;
    private final String clusterUuid;
    }
            return buildDate;
package org.opensearch.client.core;
            return new MainResponse((String) args[0], (Version) args[1], (String) args[2], (String) args[3]);
 *
            if (o == null || getClass() != o.getClass()) return false;
            this.number = number;
        return Objects.hash(nodeName, version, clusterName, clusterUuid);
 * SPDX-License-Identifier: Apache-2.0
        return clusterUuid;
        return nodeName.equals(that.nodeName)
        private final String minimumWireCompatibilityVersion;
        this.nodeName = nodeName;
    public static class Version {
