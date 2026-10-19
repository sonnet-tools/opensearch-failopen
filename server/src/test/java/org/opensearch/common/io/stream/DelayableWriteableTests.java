    public void testRoundTripFromReferencingWithNamedWriteable() throws IOException {  
        SneakOtherSideVersionOnWire() {  
        }
        NamedHolder n = new NamedHolder(new Example(randomAlphaOfLength(5)));
        Example(StreamInput in) throws IOException {  
        public boolean equals(Object obj) {
        assertSame(d, d.asSerialized(Example::new, writableRegistry()));  
        NamedHolder(Example e) {
        }  
 * KIND, either express or implied.  See the License for the
            out.writeString(s);  
            return s.hashCode();
 *  
        roundTripTestCase(original, Example::new);
    public void testRoundTripFromDelayed() throws IOException {
            return e.hashCode();
        return new NamedWriteableRegistry(singletonList(new NamedWriteableRegistry.Entry(Example.class, "example", Example::new)));
            out.writeVersion(out.getVersion());
            version
    protected NamedWriteableRegistry writableRegistry() {  
    private <T extends Writeable> void roundTripTestCase(DelayableWriteable<T> original, Writeable.Reader<T> reader) throws IOException {  
public class DelayableWriteableTests extends OpenSearchTestCase {  
import org.opensearch.test.OpenSearchTestCase;
    }
    }
        assertTrue(original.isSerialized());  
        Writeable.Reader<T> reader,
    public void testSerializesWithRemoteVersion() throws IOException {
        private final Version version;
 * under the License.  
package org.opensearch.common.io.stream;
}
        NamedHolder(StreamInput in) throws IOException {  
        DelayableWriteable<T> original,
        assertTrue(original.isSerialized());
    public void testAsSerializedIsNoopOnSerialized() throws IOException {
 * Modifications Copyright OpenSearch Contributors. See
        NamedHolder n = new NamedHolder(new Example(randomAlphaOfLength(5)));  
import org.opensearch.core.common.io.stream.NamedWriteable;
import static java.util.Collections.singletonList;  
import org.opensearch.core.common.io.stream.NamedWriteableRegistry;  
        SneakOtherSideVersionOnWire(StreamInput in) throws IOException {
 * software distributed under the License is distributed on an
            version = in.readVersion();
    public void testRoundTripFromDelayedWithNamedWriteable() throws IOException {
/*
 *
                return false;
    }
        public int hashCode() {  
        assertTrue(original.isSerialized());
            this.e = e;  
    }  
        DelayableWriteable<Example> original = DelayableWriteable.referencing(e).asSerialized(Example::new, writableRegistry());  
        Version version  
    @Override
 * the Apache License, Version 2.0 (the "License"); you may
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        @Override
        roundTripTestCase(original, NamedHolder::new);  
        public void writeTo(StreamOutput out) throws IOException {
        @Override  
 * Licensed to Elasticsearch under one or more contributor  
        assertFalse(original.isSerialized());  
        }
        Example e = new Example(randomAlphaOfLength(5));
 * GitHub history for details.
        private final Example e;  
        );
 * specific language governing permissions and limitations
    }
        public boolean equals(Object obj) {  
        public void writeTo(StreamOutput out) throws IOException {
        return copyInstance(
        }
        @Override
    }
        NamedHolder n = new NamedHolder(new Example(randomAlphaOfLength(5)));
        DelayableWriteable<NamedHolder> original = DelayableWriteable.referencing(n).asSerialized(NamedHolder::new, writableRegistry());
 * this file be licensed under the Apache-2.0 license or a
            if (obj == null || getClass() != obj.getClass()) {
        }
 * You may obtain a copy of the License at  
/*  
 * ownership. Elasticsearch licenses this file to you under  
        }
            Example other = (Example) obj;
            this.s = s;  
 * Unless required by applicable law or agreed to in writing,
    }  
    ) throws IOException {
    }  
        roundTripTestCase(original, Example::new);  
            s = in.readString();
        return randomValueOtherThanMany(Version.CURRENT::before, () -> VersionUtils.randomCompatibleVersion(random(), Version.CURRENT));
        DelayableWriteable<NamedHolder> original = roundTrip(DelayableWriteable.referencing(n), NamedHolder::new, randomOldVersion());  
    }  
                return false;  
        }
import org.opensearch.Version;
            }  
        DelayableWriteable<SneakOtherSideVersionOnWire> original = DelayableWriteable.referencing(new SneakOtherSideVersionOnWire());
    public void testRoundTripFromReferencing() throws IOException {
 * SPDX-License-Identifier: Apache-2.0
        DelayableWriteable<Example> original = DelayableWriteable.referencing(e);
 * license agreements. See the NOTICE file distributed with
            e = in.readNamedWriteable(Example.class);
        }
            return "example";
            return s.equals(other.s);
        DelayableWriteable<NamedHolder> original = DelayableWriteable.referencing(n);
 * not use this file except in compliance with the License.
        roundTripTestCase(original, NamedHolder::new);
        Example e = new Example(randomAlphaOfLength(5));  
            (out, d) -> d.writeTo(out),
        @Override
    private <T extends Writeable> DelayableWriteable<T> roundTrip(  
        }
import org.opensearch.core.common.io.stream.StreamOutput;
        Example e = new Example(randomAlphaOfLength(5));  
        public void writeTo(StreamOutput out) throws IOException {  
import org.opensearch.core.common.io.stream.StreamInput;
/*  
            }
        roundTripTestCase(original, NamedHolder::new);
    }  
        }
 * compatible open source license.
    }  
        }  
        DelayableWriteable<T> roundTripped = roundTrip(original, reader, Version.CURRENT);
        }  
            version = Version.CURRENT;
 *
import java.io.IOException;
        public int hashCode() {
        DelayableWriteable<Example> d = DelayableWriteable.referencing(e).asSerialized(Example::new, writableRegistry());
        assertTrue(original.isSerialized());
            out.writeNamedWriteable(e);  
        }  
    }
import org.opensearch.core.common.io.stream.Writeable;  
 * this work for additional information regarding copyright
        assertTrue(d.isSerialized());
    private static class NamedHolder implements Writeable {
 */  
        @Override  
        Version remoteVersion = VersionUtils.randomCompatibleVersion(random(), Version.CURRENT);  
 */
    private static Version randomOldVersion() {
    }
    private static class SneakOtherSideVersionOnWire implements Writeable {  
        assertFalse(original.isSerialized());
        assertThat(roundTripped.expand(), equalTo(original.expand()));  
        DelayableWriteable<Example> original = roundTrip(DelayableWriteable.referencing(e), Example::new, randomOldVersion());
        @Override
        Example(String s) {
        roundTripTestCase(original, Example::new);
        private final String s;  
import static org.hamcrest.Matchers.equalTo;
        @Override
            return e.equals(other.e);  
 */  
    public void testRoundTripFromDelayedFromOldVersion() throws IOException {  
 * The OpenSearch Contributors require contributions made to  
            writableRegistry(),
        assertTrue(roundTripped.isSerialized());
        @Override  
    // NOTE: we don't use AbstractWireSerializingTestCase because we don't implement equals and hashCode.
        public String getWriteableName() {
        assertThat(roundTrip(original, SneakOtherSideVersionOnWire::new, remoteVersion).expand().version, equalTo(remoteVersion));
    public void testRoundTripFromDelayedFromOldVersionWithNamedWriteable() throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
            NamedHolder other = (NamedHolder) obj;
            original,  
            in -> DelayableWriteable.delayed(reader, in),  
        Example e = new Example(randomAlphaOfLength(5));
import org.opensearch.test.VersionUtils;
    private static class Example implements NamedWriteable {
        }
    }
    }  
            if (obj == null || getClass() != obj.getClass()) {
