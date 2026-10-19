        assertThat(e, hasToString(containsString("duplicate retention lease ID [" + retentionLease.id() + "]")));  
import java.util.Collections;
            final RetentionLease retentionLease = new RetentionLease(id, retainingSequenceNumber, timestamp, source);
            IllegalArgumentException.class,
    public void testVersionOutOfRange() {
        assertThat(e, hasToString(containsString("version must be non-negative but was [" + version + "]")));
 *
        assertFalse(left.supersedes(right));  
 * Unless required by applicable law or agreed to in writing,
        final long higherVersion = randomLongBetween(lowerVersion + 1, Long.MAX_VALUE);
        final long lowerPrimaryTerm = randomLongBetween(1, Long.MAX_VALUE);  
        return new RetentionLeases(primaryTerm, version, leases);
import java.io.IOException;
        final RetentionLeases left = new RetentionLeases(primaryTerm, lowerVersion, Collections.emptyList());
        assertTrue(right.supersedes(left.primaryTerm(), left.version()));
    }
            () -> new RetentionLeases(randomLongBetween(1, Long.MAX_VALUE), version, Collections.emptyList())  
import static org.hamcrest.Matchers.equalTo;  
package org.opensearch.index.seqno;
 * ownership. Elasticsearch licenses this file to you under  
        final Path path = createTempDir();
        assertThat(e, hasToString(containsString("primary term must be positive but was [" + primaryTerm + "]")));
    }
    public void testLeasesPreservesIterationOrder() {  
    public void testPrimaryTermOutOfRange() {
            final long retainingSequenceNumber = randomNonNegativeLong();
import static org.hamcrest.Matchers.hasToString;
        final long lowerVersion = randomLongBetween(1, Long.MAX_VALUE);  
            IllegalStateException.class,
        if (retentionLeases.leases().isEmpty()) {
 * software distributed under the License is distributed on an
        );
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private RetentionLeases randomRetentionLeases(boolean allowEmpty) {
    }
            final String source = randomAlphaOfLength(8);
        }
    }
import java.util.ArrayList;  
 * under the License.  
import static org.hamcrest.Matchers.containsString;
 * GitHub history for details.
        );
import java.util.stream.Stream;
        final long primaryTerm = randomNonNegativeLong();
        }  
 *     http://www.apache.org/licenses/LICENSE-2.0
                Stream.concat(retentionLeases.leases().stream(), Stream.of(retentionLease)).collect(Collectors.toList())  
        final RetentionLeases retentionLeases = randomRetentionLeases(false);
        assertFalse(left.supersedes(right.primaryTerm(), right.version()));
            final long timestamp = randomNonNegativeLong();  
        final int length = randomIntBetween(allowEmpty ? 0 : 1, 8);
 * You may obtain a copy of the License at  
 *  
 * SPDX-License-Identifier: Apache-2.0
 * license agreements. See the NOTICE file distributed with
 *
 * The OpenSearch Contributors require contributions made to  
    public void testRetentionLeasesMetadataStateFormat() throws IOException {  
import java.nio.file.Path;
        assertFalse(left.supersedes(right.primaryTerm(), right.version()));
        assertFalse(left.supersedes(right));  
 */
            () -> new RetentionLeases(primaryTerm, randomNonNegativeLong(), Collections.emptyList())  
        assertTrue(right.supersedes(left.primaryTerm(), left.version()));
 * Modifications Copyright OpenSearch Contributors. See
            leases.add(retentionLease);  
        final RetentionLeases retentionLeases = randomRetentionLeases(true);
        final long version = randomNonNegativeLong();  
        final IllegalStateException e = expectThrows(
    public void testRetentionLeasesRejectsDuplicates() {
            IllegalArgumentException.class,
    public void testSupersedesByVersion() {
        final RetentionLeases retentionLeases = randomRetentionLeases(true);
 * specific language governing permissions and limitations
    }  
        );
 */  
    }  
        final IllegalArgumentException e = expectThrows(
        final long version = randomLongBetween(Long.MIN_VALUE, -1);  
            )
        final RetentionLeases right = new RetentionLeases(primaryTerm, higherVersion, Collections.emptyList());  
        assertTrue(right.supersedes(left));
 * Licensed to Elasticsearch under one or more contributor  
/*  
    }
            () -> new RetentionLeases(  
        final RetentionLeases left = new RetentionLeases(lowerPrimaryTerm, randomLongBetween(1, Long.MAX_VALUE), Collections.emptyList());
        RetentionLeases.FORMAT.writeAndCleanup(retentionLeases, path);  
                retentionLeases.primaryTerm(),
        for (int i = 0; i < length; i++) {  
        assertThat(RetentionLeases.FORMAT.loadLatestState(logger, NamedXContentRegistry.EMPTY, path), equalTo(retentionLeases));
            assertThat(retentionLeases.leases(), empty());  
import org.opensearch.test.OpenSearchTestCase;
 * compatible open source license.
        final RetentionLeases right = new RetentionLeases(higherPrimaryTerm, randomLongBetween(1, Long.MAX_VALUE), Collections.emptyList());  
        final IllegalArgumentException e = expectThrows(
import static org.hamcrest.Matchers.contains;  
import java.util.stream.Collectors;  
import static org.hamcrest.Matchers.empty;
import java.util.List;
        final long primaryTerm = randomLongBetween(Long.MIN_VALUE, 0);  
        final long primaryTerm = randomLongBetween(1, Long.MAX_VALUE);
        assertTrue(right.supersedes(left));
    public void testSupersedesByPrimaryTerm() {
            final String id = randomAlphaOfLength(8);
 * this work for additional information regarding copyright
/*  
 * this file be licensed under the Apache-2.0 license or a
 * KIND, either express or implied.  See the License for the
 */  
public class RetentionLeasesTests extends OpenSearchTestCase {  
            assertThat(retentionLeases.leases(), contains(retentionLeases.leases().toArray(new RetentionLease[0])));
        } else {
                retentionLeases.version(),
        final long higherPrimaryTerm = randomLongBetween(lowerPrimaryTerm + 1, Long.MAX_VALUE);
}
import org.opensearch.core.xcontent.NamedXContentRegistry;
        final RetentionLease retentionLease = randomFrom(retentionLeases.leases());  
    }  
/*
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
        final List<RetentionLease> leases = new ArrayList<>(length);
