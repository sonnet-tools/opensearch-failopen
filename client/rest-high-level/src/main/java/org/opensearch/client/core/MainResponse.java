/*  
    }  
            true,
            );  
            return Objects.hash(  
            && clusterName.equals(that.clusterName)
 * this work for additional information regarding copyright
        ) {  
                && minimumWireCompatibilityVersion.equals(version.minimumWireCompatibilityVersion)  
 * this file be licensed under the Apache-2.0 license or a
 */
                    (String) args[5],  
        );
                && Objects.equals(buildType, version.buildType)
            if (this == o) return true;  
        return nodeName;
    }  
    }
        public String getLuceneVersion() {
            args -> {
 * under the License.  
            this.number = number;
            }
        public Version(  
        @Override
                luceneVersion,  
                buildHash,  
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("cluster_uuid"));  
    }
    private final String nodeName;
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("minimum_wire_compatibility_version"));
    @Override  
import org.opensearch.core.xcontent.XContentParser;  
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("lucene_version"));
 * The OpenSearch Contributors require contributions made to  
        public int hashCode() {
    public boolean equals(Object o) {
            this.buildDate = buildDate;
                buildDate,
        MainResponse that = (MainResponse) o;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/*
                    (String) args[1],
            return isSnapshot == version.isSnapshot  
        private final String minimumWireCompatibilityVersion;  
            return number;  
                minimumWireCompatibilityVersion,
 * not use this file except in compliance with the License.
                isSnapshot,
            Version.class.getName(),  
            String buildDate,
        }
                && luceneVersion.equals(version.luceneVersion)
            String number,
    }
 */  
 * You may obtain a copy of the License at  
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("build_hash"));
    public static class Version {
                    (String) args[3],
        public boolean equals(Object o) {
        return version;  
                && buildHash.equals(version.buildHash)  
        this.clusterName = clusterName;  
            String minimumIndexCompatibilityVersion
import java.util.Objects;
        }
 *    http://www.apache.org/licenses/LICENSE-2.0
            return minimumWireCompatibilityVersion;  
        private final String buildDate;  
    }
        @Override
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("minimum_index_compatibility_version"));  
        public String getBuildType() {  
                minimumIndexCompatibilityVersion
 * compatible open source license.
    static {
        }
    public String getClusterName() {  
    );  
                && buildDate.equals(version.buildDate)
            Version version = (Version) o;
 * software distributed under the License is distributed on an
        static {
        return clusterUuid;
                buildType,
        private static final ConstructingObjectParser<Version, Void> PARSER = new ConstructingObjectParser<>(
            String luceneVersion,  
        this.clusterUuid = clusterUuid;
            return luceneVersion;
    public MainResponse(String nodeName, Version version, String clusterName, String clusterUuid) {  
            PARSER.declareString(ConstructingObjectParser.optionalConstructorArg(), new ParseField("build_type"));  
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("build_date"));
 * Modifications Copyright OpenSearch Contributors. See
    }
            && version.equals(that.version)  
/*  
            this.buildType = buildType;
    private final Version version;
        }
        private final String buildHash;
        public String getMinimumWireCompatibilityVersion() {
            PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("number"));
    }
    public static MainResponse fromXContent(XContentParser parser) {
 * Licensed to Elasticsearch under one or more contributor  
        return clusterName;
                && number.equals(version.number)
            && clusterUuid.equals(that.clusterUuid);
    public String getNodeName() {
        private final String number;  
                number,
    public Version getVersion() {
    @Override
    private final String clusterName;  
        }
        }  
        public String getBuildDate() {
}  
 * GitHub history for details.
    private final String clusterUuid;
            String buildType,
        this.nodeName = nodeName;
            return isSnapshot;
            String minimumWireCompatibilityVersion,
        this.version = version;
        }
        public boolean isSnapshot() {  
 *
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("name"));  
    }  
        private final String buildType;
        return nodeName.equals(that.nodeName)
            this.minimumWireCompatibilityVersion = minimumWireCompatibilityVersion;
public class MainResponse {
            return buildDate;  
        if (this == o) return true;
        }
        }  
        PARSER.declareObject(ConstructingObjectParser.constructorArg(), Version.PARSER, new ParseField("version"));
            this.buildHash = buildHash;  
        true,
        return Objects.hash(nodeName, version, clusterName, clusterUuid);
        PARSER.declareString(ConstructingObjectParser.constructorArg(), new ParseField("cluster_name"));
        private final String luceneVersion;
        }
            return new MainResponse((String) args[0], (Version) args[1], (String) args[2], (String) args[3]);
            return buildType;
            if (o == null || getClass() != o.getClass()) return false;
package org.opensearch.client.core;
                    (Boolean) args[4],
            return minimumIndexCompatibilityVersion;
        if (o == null || getClass() != o.getClass()) return false;  
                    (String) args[6],
 */  
            String buildHash,  
                && minimumIndexCompatibilityVersion.equals(version.minimumIndexCompatibilityVersion);
    public int hashCode() {  
 * KIND, either express or implied.  See the License for the
 * ownership. Elasticsearch licenses this file to you under  
                return new Version(  
        MainResponse.class.getName(),
        private final String minimumIndexCompatibilityVersion;
        return PARSER.apply(parser, null);  
        }
        public String getNumber() {
            return buildHash;
                );  
import org.opensearch.core.ParseField;
 * license agreements. See the NOTICE file distributed with
            this.minimumIndexCompatibilityVersion = minimumIndexCompatibilityVersion;
        public String getMinimumIndexCompatibilityVersion() {  
    }
 * specific language governing permissions and limitations
                    (String) args[2],  
            PARSER.declareBoolean(ConstructingObjectParser.constructorArg(), new ParseField("build_snapshot"));  
    private static final ConstructingObjectParser<MainResponse, Void> PARSER = new ConstructingObjectParser<>(  
 * SPDX-License-Identifier: Apache-2.0
 * the Apache License, Version 2.0 (the "License"); you may
 *
            boolean isSnapshot,
    public String getClusterUuid() {
        }
 * Unless required by applicable law or agreed to in writing,
        public String getBuildHash() {
        }  
                    (String) args[7]
                    (String) args[0],
            this.luceneVersion = luceneVersion;  
import org.opensearch.core.xcontent.ConstructingObjectParser;
        args -> {  
 *  
        private final boolean isSnapshot;
            this.isSnapshot = isSnapshot;
