    protected final NamedXContentRegistry xContentRegistry() {
            DummyState read = format.read(NamedXContentRegistry.EMPTY, list[0]);
            }
        }
        for (Path file : dirs) {
                }
                + '}';
                format.read(NamedXContentRegistry.EMPTY, list[0]);
            String fieldName = null;
        DummyState initialState = writeAndReadStateSuccessfully(format, path);
    }
        }
                possibleStates.clear();
            paths[i] = createTempDir();
        }
            format.noFailures();
            assertThat(list[0].getFileName().toString(), equalTo(MetadataStateFormat.STATE_DIR_NAME));
                .append(fileToCorrupt.getFileName().toString())
                    }
                mock.failOn(fail);
        DummyState state = new DummyState(
            possibleStates.add(newState);
import java.io.InputStream;
import org.apache.lucene.tests.util.LuceneTestCase;
            assertThat(list[0].getFileName().toString(), equalTo("foo-" + id + ".st"));
            this.aBoolean = aBoolean;
                            }
            builder.field("boolean", aBoolean);
            result = 31 * result + (aBoolean ? 1 : 0);
                    Integer.toHexString(newValue)
            Path stateDir = list[0];
            assertThat(read, equalTo(state));
                            break;
        Format(String prefix) {
 * the Apache License, Version 2.0 (the "License"); you may
                    }
         * Constructs a MetadataStateFormat object for storing/retrieving DummyState.
                MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {
            try (FileChannel raf = FileChannel.open(fileToCorrupt, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
            list = content("foo-*", stateDir);
    public void testReadWriteState() throws IOException {
                MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {
                        }
        for (int i = 0; i < dirs.length; i++) {
            DummyState stateOnDisk = format.loadLatestState(logger, NamedXContentRegistry.EMPTY, randomPaths);
                    assertTrue("string".equals(fieldName));
            randomDouble(),
        Path path = createTempDir();
        }
 * SPDX-License-Identifier: Apache-2.0
                randomBoolean()
        final long id = addDummyFiles("foo-", dirs);
        @Override
                    }
                } else if (token == XContentParser.Token.VALUE_NUMBER) {
            assertThat(list[0].getFileName().toString(), equalTo(MetadataStateFormat.STATE_DIR_NAME));
 * not use this file except in compliance with the License.
    }
            }
        Path[] dirs = new Path[randomIntBetween(1, 5)];
            Path[] list = content("*", file);
        }
            );
            return this;
            WriteStateException ex = expectThrows(WriteStateException.class, () -> format.writeAndCleanup(newState, path));
                randomBoolean()
            if (o == null || getClass() != o.getClass()) return false;
        DummyState state2 = new DummyState(
    }
        static final String FAIL_WRITE_TO_OUTPUT_FILE = "writeBytes";
                            break;
 * compatible open source license.
 *
        static final String FAIL_DELETE_TMP_FILE = "deleteFile";
                return Metadata.Builder.fromXContent(parser);
        public int hashCode() {
                );
            try {
    private DummyState writeAndReadStateSuccessfully(Format format, Path... paths) throws IOException {
 * KIND, either express or implied.  See the License for the
import org.apache.lucene.tests.store.MockDirectoryWrapper;
        DummyState initialState = writeAndReadStateSuccessfully(format, path);
                randomLong(),
        Path paths[] = new Path[randomIntBetween(2, 5)];
    }
                Format.FAIL_FSYNC_TMP_FILE,
                ) {
            assertThat(read, equalTo(state2));
        }
                Format.FAIL_WRITE_TO_OUTPUT_FILE,
        public void toXContent(XContentBuilder builder, DummyState state) throws IOException {
            randomRealisticUnicodeOfCodepointLengthBetween(1, 1000),
        private enum FailureMode {
        static final String FAIL_FSYNC_STATE_DIRECTORY = "syncMetaData";
            this.aInt = aInt;
    public void testFailCopyTmpFileToExtraLocation() throws IOException {
                randomDouble(),
import static org.hamcrest.Matchers.is;
import org.apache.lucene.store.ChecksumIndexInput;
                + aInt
import org.opensearch.cluster.metadata.Metadata;
            // we call loadLatestState not on full path set, but only on random paths from this set. This is to emulate disk failures.
        Path dst = tmp.resolve("global-3.st");
            if (randomBoolean()) {
            FAIL_ON_METHOD,
import static org.hamcrest.Matchers.notNullValue;
        for (int i = 0; i < dirs.length; i++) {
        @Override
                String actualPrefix = prefix;
    }
        DummyState initialState = writeAndReadStateSuccessfully(format, paths);
        static final String FAIL_CREATE_OUTPUT_FILE = "createOutput";
            assertEquals(initialState, format.loadLatestState(logger, NamedXContentRegistry.EMPTY, paths));
import java.io.IOException;
                };
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            DummyState that = (DummyState) o;
                ByteBuffer bb = ByteBuffer.wrap(new byte[1]);
 * specific language governing permissions and limitations
                XContentParser.Token token = parser.currentToken();
                randomLong(),
    public void testVersionMismatch() throws IOException {
        private String[] failureMethods;
                bb.flip();
 * Unless required by applicable law or agreed to in writing,
        return state;
        for (Path path : paths) {
                            break;
 * under the License.
                int id = randomIntBetween(0, 10);
                }
        for (Path file : dirs) {
        public void failRandomly() {
                assertThat(input.getFilePointer(), is(0L));
import org.apache.lucene.store.NIOFSDirectory;
        Set<DummyState> possibleStates = new HashSet<>();
    public void testCorruption() throws IOException {
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
    }
                logger.debug(
        Format format = new Format("foo-");
        @Override
     * The {@link NamedXContentRegistry} to use for most {@link XContentParser} in this test.
                "Checksum collision - " + msg.toString(),
                checksumAfterCorruption != checksumBeforeCorruption // collision
            long temp;
        Metadata read = format.read(xContentRegistry(), dst);
            }
            format.noFailures();
            DummyState newState = new DummyState(
        );
            StringBuilder msg = new StringBuilder();
            msg.append("Checksum before: [").append(checksumBeforeCorruption).append("]");
import java.nio.ByteBuffer;
        format.writeAndCleanup(state, dirs);
            }
        }
            try (ChecksumIndexInput input = dir.openChecksumInput(fileToCorrupt.getFileName().toString())) {
    public Path[] content(String glob, Path dir) throws IOException {
    /**
            Path stateDir = list[0];
            this.aLong = aLong;
            randomRealisticUnicodeOfCodepointLengthBetween(1, 1000),
            if (aBoolean != that.aBoolean) return false;
                        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {
        }
            msg.append(" file: ")
        for (Path file : dirs) {
            long checksumBeforeCorruption;
    public void testFailWriteAndReadAnyState() throws IOException {
            super(prefix);
        writeAndReadStateSuccessfully(format, paths);
                raf.write(bb, filePointer);
            } catch (CorruptStateException ex) {
                    filePointer,
                            break;
            assertFalse(ex.isDirty());
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
                        }
        long aLong;
                format.writeAndCleanup(newState, paths);
         * By default no I/O failures are injected.
            result = string.hashCode();
            public Metadata fromXContent(XContentParser parser) throws IOException {
                randomBoolean()
                fail("this test doesn't write");
            assertThat(list[0].getFileName().toString(), equalTo("foo-" + id + ".st"));
         */
/*
                        stateDir.resolve(actualPrefix + id + MetadataStateFormat.STATE_FILE_EXTENSION)
            assertThat(list[0].getFileName().toString(), equalTo("foo-" + (id + 1) + ".st"));
                Files.createDirectories(stateDir);
        Path[] dirs = new Path[randomIntBetween(1, 5)];
         * I/O failure behaviour can be controlled by {@link #noFailures()}, {@link #failOnMethods(String...)} and
    public static void corruptFile(Path fileToCorrupt, Logger logger) throws IOException {
        writeAndReadStateSuccessfully(format, paths);
        public DummyState parse(XContentParser parser) throws IOException {
        Format format = new Format("foo-");
            assertFalse(ex.isDirty());
import org.opensearch.core.xcontent.ToXContentFragment;
            format.failOnMethods(Format.FAIL_OPEN_STATE_FILE_WHEN_COPYING);
            randomDouble(),
 * GitHub history for details.
import java.nio.file.StandardOpenOption;
            builder.field("string", string);
            randomBoolean()
            format.noFailures();
import org.apache.lucene.store.Directory;
            assertEquals(initialState, format.loadLatestState(logger, NamedXContentRegistry.EMPTY, path));
 */
    public void testFailWriteAndReadPreviousState() throws IOException {
    }
import java.util.Set;
        Path paths[] = new Path[randomIntBetween(1, 5)];
import static org.hamcrest.Matchers.equalTo;
            WriteStateException ex = expectThrows(WriteStateException.class, () -> format.writeAndCleanup(newState, path));
            assertThat(list[0].getFileName().toString(), equalTo("foo-" + id + ".st"));
            format.failOnMethods(Format.FAIL_FSYNC_STATE_DIRECTORY);
        for (int i = 0; i < paths.length; i++) {
                        case "int":
                            aLong = parser.longValue();
import java.util.HashSet;
                    assertTrue("boolean".equals(fieldName));
            }
                            aDouble = parser.doubleValue();
         * {@link #failRandomly()} method calls.
                } else {
            assertThat(Files.isDirectory(stateDir), is(true));
import java.nio.channels.FileChannel;
            builder.field("int", aInt);
                }
        );
                } else if (token == XContentParser.Token.VALUE_BOOLEAN) {
        return realId + 1;
        Format format = new Format("foo-");
        return new NamedXContentRegistry(ClusterModule.getNamedXWriteables());
    public long addDummyFiles(String prefix, Path... paths) throws IOException {
            int result;
            DummyState newState = new DummyState(
        try (NIOFSDirectory dir = new NIOFSDirectory(fileToCorrupt.getParent())) {
        int aInt;
                actualChecksumAfterCorruption = CodecUtil.readBELong(input);
            return mock;
        assertThat(resource, notNullValue());
        final long id = addDummyFiles("foo-", dirs);
package org.opensearch.gateway;
                if (e.isDirty()) {
            if (failureMode == FailureMode.FAIL_ON_METHOD) {
            if (aLong != that.aLong) return false;
            assertEquals(list.length, 1);
        }
        }
            }
        // indices are empty since they are serialized separately
                };
                byte oldValue = bb.get(0);
                randomRealisticUnicodeOfCodepointLengthBetween(1, 100),
        }
                input.seek(input.length() - 8); // one long is the checksum... 8 bytes
        }
            Path[] list = content("*", file);
 * this file be licensed under the Apache-2.0 license or a
            if (Double.compare(that.aDouble, aDouble) != 0) return false;
            return builder;
            list = content("foo-*", stateDir);
            parser.nextToken();  // start object
        static final String FAIL_RENAME_TMP_FILE = "rename";
                }
        Files.copy(resource, dst);
        assertEquals(state, format.loadLatestState(logger, NamedXContentRegistry.EMPTY, paths));
            try (Directory dir = new NIOFSDirectory(path.resolve(MetadataStateFormat.STATE_DIR_NAME))) {
        static final String FAIL_FSYNC_TMP_FILE = "sync";
import org.opensearch.core.xcontent.XContentBuilder;
            return string.equals(that.string);
            DummyState read = format.read(NamedXContentRegistry.EMPTY, list[0]);
import org.opensearch.core.xcontent.NamedXContentRegistry;
            this.string = string;
            FAIL_RANDOMLY
import java.nio.file.Files;
            list = content("foo-*", stateDir);
            return new DummyState().parse(parser);
            return StreamSupport.stream(stream.spliterator(), false).toArray(length -> new Path[length]);
 * ownership. Elasticsearch licenses this file to you under
    }
        public boolean equals(Object o) {
                + "string='"
            );
 *
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
        Set<DummyState> possibleStates = new HashSet<>();
        public DummyState fromXContent(XContentParser parser) throws IOException {
            if (possibleStates.size() > 1) {
/*
        possibleStates.add(initialState);
            paths[i] = createTempDir();
                    public void eval(MockDirectoryWrapper dir) throws IOException {
            assumeTrue(
        final MetadataStateFormat<Metadata> format = new MetadataStateFormat<Metadata>("global-") {
                    Integer.toHexString(oldValue),
    }
        static final String FAIL_OPEN_STATE_FILE_WHEN_COPYING = "openInput";
                randomInt(),
                        case "double":
     */
                    possibleStates.add(newState);
            long checksumAfterCorruption;
                            aInt = parser.intValue();
                + aLong
        @Override
                randomLong(),
            this.failureMode = FailureMode.NO_FAILURES;
        Path tmp = createTempDir();
                        default:
            assertEquals(list.length, 1);
            assertTrue(ex.isDirty());
            } else if (failureMode == FailureMode.FAIL_RANDOMLY) {
            dirs[i] = createTempDir();
            @Override
                    @Override
        possibleStates.add(initialState);
    private static class Format extends MetadataStateFormat<DummyState> {
                raf.read(bb);
        }
    }
            );
        }
        }
public class MetadataStateFormatTests extends OpenSearchTestCase {
            msg.append(" checksum value after corruption: ").append(actualChecksumAfterCorruption).append("]");
                if (randomBoolean()) {
            try (IndexInput input = dir.openInput(fileToCorrupt.getFileName().toString(), IOContext.DEFAULT)) {
            this.failureMethods = failureMethods;
     */
        DummyState state = new DummyState(
            randomDouble(),
            dirs[i] = createTempDir();
            assertThat(Files.isDirectory(stateDir), is(true));
        }
        Path[] dirs = new Path[randomIntBetween(1, 5)];
            corruptFile(list[0], logger);
        }
@LuceneTestCase.SuppressFileSystems("ExtrasFS") // TODO: fix test to work with ExtrasFS
                randomInt(),
        };
            result = 31 * result + Long.hashCode(aLong);
                            if (failMethod.equals(e.getMethodName())) {
                long filePointer = raf.position();
                                throw new MockDirectoryWrapper.FakeIOException();
                    "Corrupting file {} --  flipping at position {} from {} to {} ",
                // if there was a WriteStateException we need to override current state before we continue
                randomDouble(),
    }
        public void noFailures() {
            state.toXContent(builder, null);
        DummyState(String string, int aInt, long aLong, double aDouble, boolean aBoolean) {
            DummyState newState = new DummyState(
            long actualChecksumAfterCorruption;
            assertEquals(list.length, 1);
        DummyState() {
        public String toString() {
        @Override
            list = content("foo-*", stateDir);
                + ", aLong="
                Path stateDir = path.resolve(MetadataStateFormat.STATE_DIR_NAME);
                    stream.write(0);
            WriteStateException ex = expectThrows(WriteStateException.class, () -> format.writeAndCleanup(newState, paths));
        for (Path path : paths) {
        }
        assertThat(read.clusterUUID(), equalTo("y9XcwLJGTROoOEfixlRwfQ"));
                + string
            result = 31 * result + aInt;
            Path stateDir = list[0];
        );
                + aBoolean
            }
                    fail("unexpected value " + token);
 *    http://www.apache.org/licenses/LICENSE-2.0
        );
                    string = parser.text();
                Format.FAIL_CREATE_OUTPUT_FILE,
        Path path = createTempDir();
                randomLong(),
import org.apache.lucene.store.IndexInput;
                bb.put(0, newValue);
                if (token == XContentParser.Token.FIELD_NAME) {
            randomInt(),
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
        Format format = new Format("foo-");
        for (int i = 0; i < paths.length; i++) {
 * Modifications Copyright OpenSearch Contributors. See
                .append(dir.fileLength(fileToCorrupt.getFileName().toString()));
        format.writeAndCleanup(state, paths);
        for (Path file : dirs) {
    }
            try {
        }
 * Licensed to Elasticsearch under one or more contributor
        @Override
        Format format = new Format("foo-");
            randomBoolean()
                randomInt(),
    /**
            assertEquals(list.length, 1);
        }
            ); // checksum corrupted
            this.failureMode = FailureMode.FAIL_RANDOMLY;
            assertEquals(list.length, 1);
            randomInt(),
        /**
 * software distributed under the License is distributed on an
            randomLong(),
                possibleStates.clear();
                Format.FAIL_RENAME_TMP_FILE
                checksumAfterCorruption = input.getChecksum();
        protected Directory newDirectory(Path dir) {
                            fail("unexpected numeric value " + token);
            randomBoolean()
            }
        double aDouble;
                    switch (fieldName) {
        writeAndReadStateSuccessfully(format, path);
    public void testFailRandomlyAndReadAnyState() throws IOException {
            randomLong(),
                    OutputStream stream = Files.newOutputStream(
        format.noFailures();
                try (
 * this work for additional information regarding copyright
 * license agreements. See the NOTICE file distributed with
                possibleStates.add(newState);
                    || actualChecksumAfterCorruption != checksumBeforeCorruption
                        case "long":
            this.aDouble = aDouble;
        );
            assertThat(list[0].getFileName().toString(), equalTo(MetadataStateFormat.STATE_DIR_NAME));
            randomLong(),
 * You may obtain a copy of the License at
                final String failMethod = randomFrom(failureMethods);
    private static void ensureOnlyOneStateFile(Path[] paths) throws IOException {
                + aDouble
            randomInt(),
            randomBoolean()
        ensureOnlyOneStateFile(paths);
            randomLong(),
                randomRealisticUnicodeOfCodepointLengthBetween(1, 100),
        boolean aBoolean;
            msg.append(" after: [").append(checksumAfterCorruption).append("]");
            }
                    fileToCorrupt.getFileName().toString(),
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, glob)) {
        private FailureMode failureMode;
            if (aInt != that.aInt) return false;
            MockDirectoryWrapper mock = newMockFSDirectory(dir);
                    aBoolean = parser.booleanValue();
            assertThat(Files.isDirectory(stateDir), is(true));
        for (int i = 0; i < dirs.length; i++) {
            format.failOnMethods(
        int realId = -1;
            }
            return "DummyState{"
            }
            builder.field("long", aLong);
}
            NO_FAILURES,
        }
import org.apache.logging.log4j.Logger;
            Path stateDir = list[0];
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
            assertEquals(list.length, 1);
    }
                mock.failOn(fail);
            assertThat(Files.isDirectory(stateDir), is(true));
    }
            // now corrupt it
        }
            randomBoolean()
            return result;
        }
        format.writeAndCleanup(state2, dirs);
                Format.FAIL_DELETE_TMP_FILE,
import java.util.stream.StreamSupport;
            }
    private static class DummyState implements ToXContentFragment {
            DummyState read = format.read(NamedXContentRegistry.EMPTY, list[0]);
            randomDouble(),
        }
                .append(" length: ")
            randomLong(),
            if (this == o) return true;
                byte newValue = (byte) ~oldValue;
            closeAfterSuite(mock);
            this.failureMode = FailureMode.NO_FAILURES;
/*
        format.writeAndCleanup(state, dirs);
 */
                    fieldName = parser.currentName();
        }
            assertEquals(list.length, 1);
                + '\''
    }
            assertEquals(list.length, 1);
            this.failureMode = FailureMode.FAIL_ON_METHOD;
            public void toXContent(XContentBuilder builder, Metadata state) {
            @Override
            result = 31 * result + Long.hashCode(temp);
        }
            } catch (WriteStateException e) {
            logger.debug("{}", msg.toString());
            );
        DummyState state = new DummyState(
     * Ensure we can read a pre-generated cluster state.
import org.opensearch.core.xcontent.XContentParser;
            randomRealisticUnicodeOfCodepointLengthBetween(1, 1000),
                            throw new MockDirectoryWrapper.FakeIOException();
        assertThat(read, notNullValue());
            DummyState read = format.read(NamedXContentRegistry.EMPTY, list[0]);
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
                    public void eval(MockDirectoryWrapper dir) throws IOException {
            Path[] randomPaths = randomSubsetOf(randomIntBetween(1, paths.length), paths).toArray(new Path[0]);
        writeAndReadStateSuccessfully(format, path);
import java.io.OutputStream;
            Path[] list = content("*", file);
                + ", aInt="
            temp = Double.doubleToLongBits(aDouble);
                    realId = Math.max(realId, id);
            assertThat(read, equalTo(state));
                randomBoolean()
                assertThat(dir.listAll().length, equalTo(1));
    public void testReadClusterState() throws IOException {
                newState = writeAndReadStateSuccessfully(format, paths);
        public void failOnMethods(String... failureMethods) {
        }
                    @Override
        String string;
        final long id = addDummyFiles("foo-", dirs);
        Format format = new Format("foo-");
        }
        }
            builder.field("double", aDouble);
                + ", aDouble="
                    )
        }
            assertThat(read, equalTo(state));
        DummyState initialState = writeAndReadStateSuccessfully(format, paths);
            randomRealisticUnicodeOfCodepointLengthBetween(1, 1000),
import org.apache.lucene.codecs.CodecUtil;
                randomRealisticUnicodeOfCodepointLengthBetween(1, 100),
            assertThat(list[0].getFileName().toString(), equalTo(MetadataStateFormat.STATE_DIR_NAME));
            randomInt(),
import org.apache.lucene.store.IOContext;
            );
        final InputStream resource = this.getClass().getResourceAsStream("global-3.st");
 *
                randomRealisticUnicodeOfCodepointLengthBetween(1, 100),
        DummyState state = new DummyState(
import org.opensearch.test.OpenSearchTestCase;
            DummyState newState = new DummyState(
                possibleStates.add(newState);
            randomRealisticUnicodeOfCodepointLengthBetween(1, 100),
                checksumBeforeCorruption = CodecUtil.retrieveChecksum(input);
                } else {
            randomDouble(),
            Path[] list = content("*", file);
                        if (randomIntBetween(0, 20) == 0) {
            format.noFailures();
        @Override
 * The OpenSearch Contributors require contributions made to
import java.nio.file.Path;
            assertTrue(possibleStates.contains(format.loadLatestState(logger, NamedXContentRegistry.EMPTY, path)));
            dirs[i] = createTempDir();
            format.failRandomly();
        Format format = new Format("foo-");
                } else if (token == XContentParser.Token.VALUE_STRING) {
                + ", aBoolean="
 */
                raf.position(randomIntBetween(0, (int) Math.min(Integer.MAX_VALUE, raf.size() - 1)));
        }
        format.writeAndCleanup(state, dirs);
                randomInt(),
import org.opensearch.cluster.ClusterModule;
            assertTrue(possibleStates.contains(stateOnDisk));
    }
                randomDouble(),
                randomDouble(),
        }
                fail("corrupted file");
import java.nio.file.DirectoryStream;
                // expected
            randomInt(),
                    actualPrefix = "dummy-";
