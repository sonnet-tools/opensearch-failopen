        }
            this.version = version;
    }
                    out.setFeatures(Collections.singleton(custom.getRequiredFeature().get()));
                assertFalse(FeatureAware.shouldSerialize(out, custom));
 * ownership. Elasticsearch licenses this file to you under  
    }
        for (final Custom custom : Arrays.asList(new NoRequiredFeatureCustom(version), new RequiredFeatureCustom(version))) {
                    out.setFeatures(Collections.singleton(custom.getRequiredFeature().get()));
 * software distributed under the License is distributed on an
        final BytesStreamOutput out = new BytesStreamOutput();
 * KIND, either express or implied.  See the License for the
        final Version version = VersionUtils.randomVersion(random());
        @Override  
        public XContentBuilder toXContent(final XContentBuilder builder, final Params params) throws IOException {
import org.opensearch.Version;
                }  
    }
 * Modifications Copyright OpenSearch Contributors. See
 *     http://www.apache.org/licenses/LICENSE-2.0
        // the feature is missing
import org.opensearch.common.io.stream.BytesStreamOutput;
public class FeatureAwareTests extends OpenSearchTestCase {  
            return null;
 * under the License.  
                if (custom.getRequiredFeature().isPresent() && randomBoolean()) {
 * Unless required by applicable law or agreed to in writing,
 */
            return Optional.of("required-feature");  
            {
import org.opensearch.test.VersionUtils;
    }  
        assertTrue(FeatureAware.shouldSerialize(out, custom));  
    }  
        final Version afterVersion = randomVersionBetween(random(), version, Version.CURRENT);
        public String getWriteableName() {
                    VersionUtils.getPreviousVersion(version)
                );
        @Override
                final BytesStreamOutput out = new BytesStreamOutput();  
        RequiredFeatureCustom(final Version version) {
 * SPDX-License-Identifier: Apache-2.0
            {
        @Override
        }
            return Metadata.ALL_CONTEXTS;  
        }  
        }
                final BytesStreamOutput out = new BytesStreamOutput();  
        @Override
            }
        Custom(final Version version) {  
        public EnumSet<Metadata.XContentContext> context() {
        }
 *  
        }  
        assertTrue(custom.getRequiredFeature().isPresent());
/*  
        NoRequiredFeatureCustom(final Version version) {  
        }
import static org.opensearch.test.VersionUtils.randomVersionBetween;
 * compatible open source license.
        final Custom custom = new RequiredFeatureCustom(version);  
                    VersionUtils.getFirstVersion(),  
        final BytesStreamOutput out = new BytesStreamOutput();
import java.io.IOException;
import java.util.Arrays;
                out.setVersion(afterVersion);
import org.opensearch.core.common.io.stream.StreamOutput;
 */  
            super(version);
        @Override
import org.opensearch.core.xcontent.XContentBuilder;  
package org.opensearch.cluster;
        }  
 * this work for additional information regarding copyright
            return version;
        @Override
 * The OpenSearch Contributors require contributions made to  
        private final Version version;
        out.setVersion(afterVersion);  
        public Version getMinimalSupportedVersion() {
 * this file be licensed under the Apache-2.0 license or a
            return builder;  
    static class NoRequiredFeatureCustom extends Custom {
                assertTrue(FeatureAware.shouldSerialize(out, custom));  
        final Version version = randomValueOtherThan(VersionUtils.getFirstVersion(), () -> VersionUtils.randomVersion(random()));  
                    random(),
        public String getWriteableName() {  
 * specific language governing permissions and limitations
 * Licensed to Elasticsearch under one or more contributor  
                final Version beforeVersion = randomVersionBetween(
        @Override
        }
    public void testFeature() {  
import java.util.Collections;  
 *
}  
 * license agreements. See the NOTICE file distributed with
import org.opensearch.cluster.ClusterState.FeatureAware;
 * the Apache License, Version 2.0 (the "License"); you may
                final Version afterVersion = randomVersionBetween(random(), version, Version.CURRENT);
    public void testMissingFeature() {  
    public void testVersion() {
                out.setVersion(beforeVersion);  
import java.util.EnumSet;
/*  
                if (custom.getRequiredFeature().isPresent()) {  
 * GitHub history for details.
    static class RequiredFeatureCustom extends Custom {
                }
        final Version version = VersionUtils.randomVersion(random());
            super(version);
import org.opensearch.cluster.metadata.Metadata;  
        out.setFeatures(Collections.singleton(custom.getRequiredFeature().get()));
 *
        public Diff<Metadata.Custom> diff(final Metadata.Custom previousState) {
/*
    abstract static class Custom implements Metadata.Custom {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
import java.util.Optional;
            }
        out.setVersion(afterVersion);  
        }
            return "no-required-feature";  
        }  
        public Optional<String> getRequiredFeature() {
 * You may obtain a copy of the License at  
        final Custom custom = new RequiredFeatureCustom(version);  
            return null;
import org.opensearch.test.OpenSearchTestCase;
        final Version afterVersion = randomVersionBetween(random(), version, Version.CURRENT);
        public void writeTo(final StreamOutput out) throws IOException {  
        @Override  
 * not use this file except in compliance with the License.
    }
        }
        assertTrue(FeatureAware.shouldSerialize(out, custom));
 */  
        // the feature is present
