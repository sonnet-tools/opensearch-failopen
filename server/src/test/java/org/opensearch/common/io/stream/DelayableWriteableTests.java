        roundTripTestCase(original, Example::new);
        assertTrue(original.isSerialized());
            }
        public void writeTo(StreamOutput out) throws IOException {
            version = Version.CURRENT;
    public void testRoundTripFromDelayedFromOldVersionWithNamedWriteable() throws IOException {
        public void writeTo(StreamOutput out) throws IOException {
        }
    @Override
        assertTrue(original.isSerialized());
    private static class NamedHolder implements Writeable {
/*
import org.opensearch.Version;
        }
        }
        assertThat(roundTripped.expand(), equalTo(original.expand()));
import org.opensearch.core.common.io.stream.NamedWriteable;
    }
        }
}
 * compatible open source license.
        NamedHolder n = new NamedHolder(new Example(randomAlphaOfLength(5)));
import java.io.IOException;
        private final Version version;
            in -> DelayableWriteable.delayed(reader, in),
        SneakOtherSideVersionOnWire() {
        DelayableWriteable<NamedHolder> original = roundTrip(DelayableWriteable.referencing(n), NamedHolder::new, randomOldVersion());
        NamedHolder(StreamInput in) throws IOException {
 * The OpenSearch Contributors require contributions made to
    }
 * software distributed under the License is distributed on an
        DelayableWriteable<SneakOtherSideVersionOnWire> original = DelayableWriteable.referencing(new SneakOtherSideVersionOnWire());
        NamedHolder(Example e) {
        Example e = new Example(randomAlphaOfLength(5));
        NamedHolder n = new NamedHolder(new Example(randomAlphaOfLength(5)));
    public void testRoundTripFromReferencing() throws IOException {
        Version version
        roundTripTestCase(original, NamedHolder::new);
    }
        }
        DelayableWriteable<T> roundTripped = roundTrip(original, reader, Version.CURRENT);
 *
 * this work for additional information regarding copyright
 *
import static java.util.Collections.singletonList;
package org.opensearch.common.io.stream;
        DelayableWriteable<T> original,
import org.opensearch.core.common.io.stream.Writeable;
    }
        assertSame(d, d.asSerialized(Example::new, writableRegistry()));
        DelayableWriteable<NamedHolder> original = DelayableWriteable.referencing(n).asSerialized(NamedHolder::new, writableRegistry());
        Example e = new Example(randomAlphaOfLength(5));
    }
            out.writeNamedWriteable(e);
    }
        Example(String s) {
        private final String s;
    private static class Example implements NamedWriteable {
/*
        return new NamedWriteableRegistry(singletonList(new NamedWriteableRegistry.Entry(Example.class, "example", Example::new)));
            writableRegistry(),
 * Modifications Copyright OpenSearch Contributors. See
 * SPDX-License-Identifier: Apache-2.0
    public void testRoundTripFromDelayed() throws IOException {
        public int hashCode() {
        assertFalse(original.isSerialized());
            out.writeString(s);
        }
        @Override
    }
        assertTrue(roundTripped.isSerialized());
        assertTrue(original.isSerialized());
        private final Example e;
        return randomValueOtherThanMany(Version.CURRENT::before, () -> VersionUtils.randomCompatibleVersion(random(), Version.CURRENT));
    ) throws IOException {
            return "example";
        }
 * specific language governing permissions and limitations
 */
        public String getWriteableName() {
            version
import org.opensearch.test.OpenSearchTestCase;
/*
        }
    public void testRoundTripFromReferencingWithNamedWriteable() throws IOException {
 * ownership. Elasticsearch licenses this file to you under
        assertFalse(original.isSerialized());
        Writeable.Reader<T> reader,
        public void writeTo(StreamOutput out) throws IOException {
            NamedHolder other = (NamedHolder) obj;
            original,
            if (obj == null || getClass() != obj.getClass()) {
        }
        assertThat(roundTrip(original, SneakOtherSideVersionOnWire::new, remoteVersion).expand().version, equalTo(remoteVersion));
        );
    }
public class DelayableWriteableTests extends OpenSearchTestCase {
        Version remoteVersion = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);
        return copyInstance(
        DelayableWriteable<Example> original = DelayableWriteable.referencing(e);
        SneakOtherSideVersionOnWire(StreamInput in) throws IOException {
            version = in.readVersion();
 * license agreements. See the NOTICE file distributed with
 * the Apache License, Version 2.0 (the "License"); you may
        DelayableWriteable<Example> original = DelayableWriteable.referencing(e).asSerialized(Example::new, writableRegistry());
        assertTrue(d.isSerialized());
            this.e = e;
        @Override
            (out, d) -> d.writeTo(out),
 * Licensed to Elasticsearch under one or more contributor
 */
 * Unless required by applicable law or agreed to in writing,
        Example e = new Example(randomAlphaOfLength(5));
    private <T extends Writeable> DelayableWriteable<T> roundTrip(
            out.writeVersion(out.getVersion());
        public int hashCode() {
        DelayableWriteable<Example> d = DelayableWriteable.referencing(e).asSerialized(Example::new, writableRegistry());
        DelayableWriteable<Example> original = roundTrip(DelayableWriteable.referencing(e), Example::new, randomOldVersion());
    public void testAsSerializedIsNoopOnSerialized() throws IOException {
    }
 */
            this.s = s;
            return e.hashCode();
                return false;
        }
            return s.hashCode();
    }
import org.opensearch.core.common.io.stream.StreamInput;
    }
    }
                return false;
        @Override
        @Override
    }
        @Override
        roundTripTestCase(original, NamedHolder::new);
        Example(StreamInput in) throws IOException {
        Example e = new Example(randomAlphaOfLength(5));
        @Override
            Example other = (Example) obj;
            e = in.readNamedWriteable(Example.class);
    public void testRoundTripFromDelayedWithNamedWriteable() throws IOException {
 * KIND, either express or implied.  See the License for the
 * GitHub history for details.
 * You may obtain a copy of the License at
import org.opensearch.core.common.io.stream.StreamOutput;
        }
    // NOTE: we don't use AbstractWireSerializingTestCase because we don't implement equals and hashCode.
        DelayableWriteable<NamedHolder> original = DelayableWriteable.referencing(n);
    }
import static org.hamcrest.Matchers.equalTo;
import org.opensearch.test.VersionUtils;
        public boolean equals(Object obj) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
    }
        roundTripTestCase(original, Example::new);
 * this file be licensed under the Apache-2.0 license or a
            if (obj == null || getClass() != obj.getClass()) {
            s = in.readString();
    public void testRoundTripFromDelayedFromOldVersion() throws IOException {
 *
            return s.equals(other.s);
        roundTripTestCase(original, NamedHolder::new);
    protected NamedWriteableRegistry writableRegistry() {
    public void testSerializesWithRemoteVersion() throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
    private <T extends Writeable> void roundTripTestCase(DelayableWriteable<T> original, Writeable.Reader<T> reader) throws IOException {
        roundTripTestCase(original, Example::new);
        @Override
        NamedHolder n = new NamedHolder(new Example(randomAlphaOfLength(5)));
        }
        public boolean equals(Object obj) {
    private static class SneakOtherSideVersionOnWire implements Writeable {
 * under the License.
        }
        }
        assertTrue(original.isSerialized());
 * not use this file except in compliance with the License.
    private static Version randomOldVersion() {
            return e.equals(other.e);
        @Override
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;
