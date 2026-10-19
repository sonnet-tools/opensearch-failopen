                            break;
        }
        Format format = new Format("foo-");
        public void noFailures() {  
                    stream.write(0);
            randomLong(),
                Format.FAIL_DELETE_TMP_FILE,
        }
                randomInt(),  
                checksumAfterCorruption = input.getChecksum();
                Files.createDirectories(stateDir);
            possibleStates.add(newState);
        };  
            }  
        Path path = createTempDir();  
                    Integer.toHexString(oldValue),
            }  
    public void testReadClusterState() throws IOException {  
import java.util.Set;  
        Format format = new Format("foo-");  
            return builder;
                            }  
            NO_FAILURES,
                randomRealisticUnicodeOfCodepointLengthBetween(1, 100),
        public boolean equals(Object o) {
        int realId = -1;  
        assertEquals(state, format.loadLatestState(logger, NamedXContentRegistry.EMPTY, paths));
        }
        DummyState initialState = writeAndReadStateSuccessfully(format, paths);
import java.io.InputStream;  
                ByteBuffer bb = ByteBuffer.wrap(new byte[1]);
                    @Override
        Format format = new Format("foo-");
            assertEquals(initialState, format.loadLatestState(logger, NamedXContentRegistry.EMPTY, path));  
        @Override  
            this.failureMode = FailureMode.NO_FAILURES;
            try (Directory dir = new NIOFSDirectory(path.resolve(MetadataStateFormat.STATE_DIR_NAME))) {
        }  
            assertThat(read, equalTo(state));
            format.noFailures();
         * {@link #failRandomly()} method calls.
        DummyState state = new DummyState(
                actualChecksumAfterCorruption = CodecUtil.readBELong(input);
                randomInt(),
                try (  
         */
            // now corrupt it
            }
        public void toXContent(XContentBuilder builder, DummyState state) throws IOException {  
                mock.failOn(fail);
        DummyState() {
        for (int i = 0; i < dirs.length; i++) {
                    aBoolean = parser.booleanValue();
                fail("corrupted file");  
        public void failOnMethods(String... failureMethods) {
                randomBoolean()
            public void toXContent(XContentBuilder builder, Metadata state) {
            );  
import org.opensearch.core.xcontent.NamedXContentRegistry;
            while (parser.nextToken() != XContentParser.Token.END_OBJECT) {
 *
        Path tmp = createTempDir();
                    || actualChecksumAfterCorruption != checksumBeforeCorruption
            assertThat(read, equalTo(state2));
            assertEquals(list.length, 1);
            ); // checksum corrupted
 * GitHub history for details.
        Path paths[] = new Path[randomIntBetween(1, 5)];  
            @Override  
 *
                    actualPrefix = "dummy-";
            StringBuilder msg = new StringBuilder();
            long checksumAfterCorruption;
            randomDouble(),  
            );  
        format.writeAndCleanup(state, dirs);  
            WriteStateException ex = expectThrows(WriteStateException.class, () -> format.writeAndCleanup(newState, path));  
        DummyState state = new DummyState(
        final InputStream resource = this.getClass().getResourceAsStream("global-3.st");
                        for (StackTraceElement e : Thread.currentThread().getStackTrace()) {  
            list = content("foo-*", stateDir);  
 * Modifications Copyright OpenSearch Contributors. See  
            dirs[i] = createTempDir();  
                }
            builder.field("string", string);
        }  
            this.failureMethods = failureMethods;  
    }
        for (Path path : paths) {
            assertThat(Files.isDirectory(stateDir), is(true));  
            );
            this.aInt = aInt;
                };
    }  
                + "string='"
        }
            if (failureMode == FailureMode.FAIL_ON_METHOD) {
                        case "int":
                String actualPrefix = prefix;
        assertThat(read.clusterUUID(), equalTo("y9XcwLJGTROoOEfixlRwfQ"));
            DummyState read = format.read(NamedXContentRegistry.EMPTY, list[0]);  
 * You may obtain a copy of the License at  
import java.nio.ByteBuffer;
                }
        @Override
        format.writeAndCleanup(state2, dirs);
                            if (failMethod.equals(e.getMethodName())) {
        static final String FAIL_DELETE_TMP_FILE = "deleteFile";  
                + aBoolean
            Path stateDir = list[0];
    }
import org.apache.logging.log4j.Logger;  
        static final String FAIL_FSYNC_TMP_FILE = "sync";  
                } else if (token == XContentParser.Token.VALUE_NUMBER) {  
    public void testVersionMismatch() throws IOException {  
            int result;  
import org.apache.lucene.store.ChecksumIndexInput;
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
            assertThat(list[0].getFileName().toString(), equalTo("foo-" + (id + 1) + ".st"));
            logger.debug("{}", msg.toString());  
        writeAndReadStateSuccessfully(format, paths);  
                Format.FAIL_FSYNC_TMP_FILE,
        @Override
            randomBoolean()  
            } catch (WriteStateException e) {
 * this work for additional information regarding copyright
            assertEquals(list.length, 1);  
            result = 31 * result + Long.hashCode(temp);  
        public DummyState parse(XContentParser parser) throws IOException {
                    "Corrupting file {} --  flipping at position {} from {} to {} ",
                    fieldName = parser.currentName();
            msg.append(" after: [").append(checksumAfterCorruption).append("]");  
            Path[] list = content("*", file);
     * The {@link NamedXContentRegistry} to use for most {@link XContentParser} in this test.
                } else {  
        boolean aBoolean;
            WriteStateException ex = expectThrows(WriteStateException.class, () -> format.writeAndCleanup(newState, paths));
import org.apache.lucene.store.Directory;  
            randomBoolean()
    public Path[] content(String glob, Path dir) throws IOException {
                    string = parser.text();
                checksumBeforeCorruption = CodecUtil.retrieveChecksum(input);
                possibleStates.clear();  
            randomLong(),
            if (possibleStates.size() > 1) {
            randomBoolean()
            format.noFailures();
                + ", aDouble="
            }  
                );  
            if (o == null || getClass() != o.getClass()) return false;
            closeAfterSuite(mock);
                }  
            long actualChecksumAfterCorruption;  
            assertThat(list[0].getFileName().toString(), equalTo(MetadataStateFormat.STATE_DIR_NAME));
            Path[] randomPaths = randomSubsetOf(randomIntBetween(1, paths.length), paths).toArray(new Path[0]);
    /**  
            assertEquals(list.length, 1);
            DummyState that = (DummyState) o;  
        double aDouble;
        for (int i = 0; i < paths.length; i++) {  
        }  
                randomLong(),  
        );
            list = content("foo-*", stateDir);  
            randomLong(),
        }
import static org.hamcrest.Matchers.is;
            this.aBoolean = aBoolean;
                .append(" length: ")
                XContentParser.Token token = parser.currentToken();  
            if (this == o) return true;  
            assertFalse(ex.isDirty());  
                randomDouble(),
public class MetadataStateFormatTests extends OpenSearchTestCase {
                                throw new MockDirectoryWrapper.FakeIOException();
                } else {  
import java.nio.file.DirectoryStream;
            FAIL_RANDOMLY
            long checksumBeforeCorruption;  
        public String toString() {
                byte newValue = (byte) ~oldValue;  
            paths[i] = createTempDir();
        }
 * specific language governing permissions and limitations
            randomInt(),  
        for (Path path : paths) {
        final long id = addDummyFiles("foo-", dirs);
    }
            randomInt(),  
    protected final NamedXContentRegistry xContentRegistry() {  
            String fieldName = null;  
        }  
            DummyState stateOnDisk = format.loadLatestState(logger, NamedXContentRegistry.EMPTY, randomPaths);
            DummyState newState = new DummyState(  
            format.failOnMethods(  
        // indices are empty since they are serialized separately  
                byte oldValue = bb.get(0);
         * Constructs a MetadataStateFormat object for storing/retrieving DummyState.
        assertThat(resource, notNullValue());  
            }  
    }
            assertThat(read, equalTo(state));
                            throw new MockDirectoryWrapper.FakeIOException();
 * Licensed to Elasticsearch under one or more contributor  
            DummyState read = format.read(NamedXContentRegistry.EMPTY, list[0]);  
 * under the License.  
                            fail("unexpected numeric value " + token);  
    }  
                + '\''  
                    fileToCorrupt.getFileName().toString(),
            try (FileChannel raf = FileChannel.open(fileToCorrupt, StandardOpenOption.READ, StandardOpenOption.WRITE)) {
                    )  
 *    http://www.apache.org/licenses/LICENSE-2.0
/*
            assertTrue(ex.isDirty());
            Path[] list = content("*", file);
        Set<DummyState> possibleStates = new HashSet<>();  
            // we call loadLatestState not on full path set, but only on random paths from this set. This is to emulate disk failures.  
            try (ChecksumIndexInput input = dir.openChecksumInput(fileToCorrupt.getFileName().toString())) {
                        }
     */
        static final String FAIL_FSYNC_STATE_DIRECTORY = "syncMetaData";
        public void failRandomly() {  
        @Override
                    }
        }
        }
            dirs[i] = createTempDir();  
                input.seek(input.length() - 8); // one long is the checksum... 8 bytes  
            FAIL_ON_METHOD,  
    }  
                    fail("unexpected value " + token);
            if (randomBoolean()) {
            assertThat(list[0].getFileName().toString(), equalTo("foo-" + id + ".st"));  
                            aInt = parser.intValue();  
    }
 */
                randomInt(),  
                        }
        }
                possibleStates.clear();
}  
            this.aDouble = aDouble;
            } else if (failureMode == FailureMode.FAIL_RANDOMLY) {
            Path[] list = content("*", file);
        protected Directory newDirectory(Path dir) {
            Path stateDir = list[0];
    }
            DummyState newState = new DummyState(
        format.noFailures();
            assertThat(read, equalTo(state));
                    possibleStates.add(newState);
    public void testFailWriteAndReadAnyState() throws IOException {  
            builder.field("boolean", aBoolean);  
        }  
 * this file be licensed under the Apache-2.0 license or a
        Path[] dirs = new Path[randomIntBetween(1, 5)];
            list = content("foo-*", stateDir);  
                format.writeAndCleanup(newState, paths);
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
            Path[] list = content("*", file);
            paths[i] = createTempDir();
                randomDouble(),
        private FailureMode failureMode;
            result = 31 * result + aInt;  
        for (Path file : dirs) {
        Files.copy(resource, dst);
import org.apache.lucene.tests.util.LuceneTestCase;
                    filePointer,  
        for (int i = 0; i < dirs.length; i++) {
                        default:
                bb.flip();
            return mock;
        for (int i = 0; i < dirs.length; i++) {
        Path dst = tmp.resolve("global-3.st");
                randomBoolean()  
                raf.position(randomIntBetween(0, (int) Math.min(Integer.MAX_VALUE, raf.size() - 1)));
            format.failRandomly();
        assertThat(read, notNullValue());
            assertEquals(list.length, 1);
            assertThat(list[0].getFileName().toString(), equalTo(MetadataStateFormat.STATE_DIR_NAME));  
                possibleStates.add(newState);
import org.apache.lucene.store.IOContext;
                newState = writeAndReadStateSuccessfully(format, paths);  
            this.failureMode = FailureMode.FAIL_ON_METHOD;
                randomBoolean()
            this.string = string;
                assertThat(input.getFilePointer(), is(0L));
                Path stateDir = path.resolve(MetadataStateFormat.STATE_DIR_NAME);  
            format.failOnMethods(Format.FAIL_FSYNC_STATE_DIRECTORY);  
        }
        Path[] dirs = new Path[randomIntBetween(1, 5)];
        return new NamedXContentRegistry(ClusterModule.getNamedXWriteables());
        Metadata read = format.read(xContentRegistry(), dst);  
            super(prefix);
            msg.append(" file: ")
                } else if (token == XContentParser.Token.VALUE_STRING) {  
            randomLong(),  
/*  
            assertTrue(possibleStates.contains(stateOnDisk));  
    }
                + aInt
    }
        format.writeAndCleanup(state, dirs);
    public void testReadWriteState() throws IOException {  
    /**  
            assertEquals(list.length, 1);
                        case "double":
        }
            return string.equals(that.string);  
            state.toXContent(builder, null);
        @Override
import java.util.HashSet;
                    @Override
            builder.field("int", aInt);  
        public int hashCode() {
        format.writeAndCleanup(state, dirs);
        }
        DummyState initialState = writeAndReadStateSuccessfully(format, paths);
import org.opensearch.core.xcontent.XContentParser;
        @Override
                logger.debug(  
                .append(dir.fileLength(fileToCorrupt.getFileName().toString()));
        format.writeAndCleanup(state, paths);  
            try {
            randomInt(),
            }
            Path stateDir = list[0];
    }
        final MetadataStateFormat<Metadata> format = new MetadataStateFormat<Metadata>("global-") {
    private static class DummyState implements ToXContentFragment {  
                    realId = Math.max(realId, id);
    private static class Format extends MetadataStateFormat<DummyState> {  
                Format.FAIL_RENAME_TMP_FILE
            }  
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            assertEquals(list.length, 1);
        for (int i = 0; i < paths.length; i++) {
            DummyState read = format.read(NamedXContentRegistry.EMPTY, list[0]);
                mock.failOn(fail);
import org.apache.lucene.tests.store.MockDirectoryWrapper;
        }
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
            randomInt(),
                    public void eval(MockDirectoryWrapper dir) throws IOException {
            if (aInt != that.aInt) return false;
        }
            DummyState newState = new DummyState(  
        Path path = createTempDir();
            randomInt(),
            );  
                + ", aLong="  
 * software distributed under the License is distributed on an
                Format.FAIL_CREATE_OUTPUT_FILE,
            parser.nextToken();  // start object
                fail("this test doesn't write");
 */  
            );
        for (int i = 0; i < randomIntBetween(1, 5); i++) {
 * license agreements. See the NOTICE file distributed with
                long filePointer = raf.position();  
            assertTrue(possibleStates.contains(format.loadLatestState(logger, NamedXContentRegistry.EMPTY, path)));
package org.opensearch.gateway;
import org.opensearch.core.xcontent.XContentBuilder;
            result = string.hashCode();
        }
            assertThat(Files.isDirectory(stateDir), is(true));
            randomRealisticUnicodeOfCodepointLengthBetween(1, 1000),
                            break;
    public long addDummyFiles(String prefix, Path... paths) throws IOException {
                randomLong(),
import java.nio.file.StandardOpenOption;
            assertThat(list[0].getFileName().toString(), equalTo(MetadataStateFormat.STATE_DIR_NAME));  
                    assertTrue("boolean".equals(fieldName));
        }  
        return realId + 1;  
            if (Double.compare(that.aDouble, aDouble) != 0) return false;  
            public Metadata fromXContent(XContentParser parser) throws IOException {  
        return state;  
import org.opensearch.cluster.ClusterModule;  
                    switch (fieldName) {
        Format format = new Format("foo-");
        DummyState state = new DummyState(
 * Unless required by applicable law or agreed to in writing,
        Format format = new Format("foo-");  
            return this;
            if (aBoolean != that.aBoolean) return false;
                + aLong
            assertThat(Files.isDirectory(stateDir), is(true));
    private DummyState writeAndReadStateSuccessfully(Format format, Path... paths) throws IOException {  
                randomInt(),
                + ", aBoolean="
                format.read(NamedXContentRegistry.EMPTY, list[0]);
                // expected
        public XContentBuilder toXContent(XContentBuilder builder, Params params) throws IOException {
 * compatible open source license.
            result = 31 * result + (aBoolean ? 1 : 0);
 * SPDX-License-Identifier: Apache-2.0
                if (e.isDirty()) {  
        Format(String prefix) {  
                    OutputStream stream = Files.newOutputStream(
    }  
            corruptFile(list[0], logger);  
        ensureOnlyOneStateFile(paths);
            msg.append("Checksum before: [").append(checksumBeforeCorruption).append("]");
            randomRealisticUnicodeOfCodepointLengthBetween(1, 1000),
            try {
    }
 * the Apache License, Version 2.0 (the "License"); you may
            assertEquals(list.length, 1);
    }
        final long id = addDummyFiles("foo-", dirs);
        DummyState initialState = writeAndReadStateSuccessfully(format, path);
        for (Path file : dirs) {  
        static final String FAIL_OPEN_STATE_FILE_WHEN_COPYING = "openInput";
            assertThat(list[0].getFileName().toString(), equalTo("foo-" + id + ".st"));
            this.failureMode = FailureMode.FAIL_RANDOMLY;
 */
            builder.field("double", aDouble);
                if (randomBoolean()) {
                + '}';  
            list = content("foo-*", stateDir);
import org.apache.lucene.codecs.CodecUtil;
        possibleStates.add(initialState);  
        Set<DummyState> possibleStates = new HashSet<>();
        static final String FAIL_CREATE_OUTPUT_FILE = "createOutput";
        }
            assertEquals(list.length, 1);
                randomLong(),
        static final String FAIL_RENAME_TMP_FILE = "rename";
    public void testCorruption() throws IOException {  
            randomRealisticUnicodeOfCodepointLengthBetween(1, 1000),
                + string
            assertFalse(ex.isDirty());
        }  
import java.util.stream.StreamSupport;
    public void testFailWriteAndReadPreviousState() throws IOException {
        }
        possibleStates.add(initialState);
            assertEquals(initialState, format.loadLatestState(logger, NamedXContentRegistry.EMPTY, paths));
        }
            }  
        static final String FAIL_WRITE_TO_OUTPUT_FILE = "writeBytes";
        }
import java.io.OutputStream;
            randomBoolean()  
        }
            } catch (CorruptStateException ex) {
     * Ensure we can read a pre-generated cluster state.
                    assertTrue("string".equals(fieldName));
            format.noFailures();
    private static void ensureOnlyOneStateFile(Path[] paths) throws IOException {  
        private String[] failureMethods;
                + aDouble  
            MockDirectoryWrapper mock = newMockFSDirectory(dir);  
        );
        Path paths[] = new Path[randomIntBetween(2, 5)];
                    Integer.toHexString(newValue)
                assertThat(dir.listAll().length, equalTo(1));  
                Format.FAIL_WRITE_TO_OUTPUT_FILE,  
        );
            long temp;
 * not use this file except in compliance with the License.
@LuceneTestCase.SuppressFileSystems("ExtrasFS") // TODO: fix test to work with ExtrasFS
                bb.put(0, newValue);
            assumeTrue(
    public void testFailCopyTmpFileToExtraLocation() throws IOException {
import java.nio.file.Files;
                        case "long":
                            break;
        );  
import org.opensearch.cluster.metadata.Metadata;
            Path stateDir = list[0];
        Path[] dirs = new Path[randomIntBetween(1, 5)];
            assertThat(list[0].getFileName().toString(), equalTo(MetadataStateFormat.STATE_DIR_NAME));  
            dirs[i] = createTempDir();  
    }
        }
            }  
                if (token == XContentParser.Token.FIELD_NAME) {
            result = 31 * result + Long.hashCode(aLong);
                return Metadata.Builder.fromXContent(parser);
        }  
                int id = randomIntBetween(0, 10);  
                    public void eval(MockDirectoryWrapper dir) throws IOException {
            }
        );
                + ", aInt="
                "Checksum collision - " + msg.toString(),
     */
            return result;
            randomDouble(),
                checksumAfterCorruption != checksumBeforeCorruption // collision  
                            break;
                };  
        for (Path file : dirs) {  
                randomRealisticUnicodeOfCodepointLengthBetween(1, 100),
                randomBoolean()  
            randomBoolean()
/*
            randomDouble(),  
            randomRealisticUnicodeOfCodepointLengthBetween(1, 100),  
        writeAndReadStateSuccessfully(format, path);
        int aInt;
            assertThat(list[0].getFileName().toString(), equalTo("foo-" + id + ".st"));
import java.nio.channels.FileChannel;  
                        if (randomIntBetween(0, 20) == 0) {  
            assertThat(Files.isDirectory(stateDir), is(true));
        public DummyState fromXContent(XContentParser parser) throws IOException {
            DummyState newState = new DummyState(
                possibleStates.add(newState);
        }
                MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {  
        Format format = new Format("foo-");  
            return new DummyState().parse(parser);  
         * By default no I/O failures are injected.
            return StreamSupport.stream(stream.spliterator(), false).toArray(length -> new Path[length]);
                // if there was a WriteStateException we need to override current state before we continue
    public static void corruptFile(Path fileToCorrupt, Logger logger) throws IOException {
        long aLong;  
import static org.hamcrest.Matchers.notNullValue;
                randomDouble(),
                    }  
            }
                raf.read(bb);
            format.noFailures();  
                            aLong = parser.longValue();  
 * The OpenSearch Contributors require contributions made to  
        }  
        writeAndReadStateSuccessfully(format, paths);
import org.apache.lucene.store.IndexInput;
                } else if (token == XContentParser.Token.VALUE_BOOLEAN) {  
            temp = Double.doubleToLongBits(aDouble);
    public void testFailRandomlyAndReadAnyState() throws IOException {
                randomLong(),  
                randomRealisticUnicodeOfCodepointLengthBetween(1, 100),
            }  
        DummyState state2 = new DummyState(  
                }
            WriteStateException ex = expectThrows(WriteStateException.class, () -> format.writeAndCleanup(newState, path));
import org.apache.lucene.store.NIOFSDirectory;  
import java.nio.file.Path;  
import org.opensearch.test.OpenSearchTestCase;  
        Format format = new Format("foo-");
        /**  
import org.opensearch.core.xcontent.ToXContentFragment;  
            this.failureMode = FailureMode.NO_FAILURES;
            format.failOnMethods(Format.FAIL_OPEN_STATE_FILE_WHEN_COPYING);
        final long id = addDummyFiles("foo-", dirs);
        DummyState initialState = writeAndReadStateSuccessfully(format, path);  
            this.aLong = aLong;  
        }
                ) {
                final String failMethod = randomFrom(failureMethods);
                raf.write(bb, filePointer);
            randomDouble(),
            try (IndexInput input = dir.openInput(fileToCorrupt.getFileName().toString(), IOContext.DEFAULT)) {
        try (NIOFSDirectory dir = new NIOFSDirectory(fileToCorrupt.getParent())) {
        for (Path file : dirs) {  
        private enum FailureMode {
import static org.hamcrest.Matchers.equalTo;  
        writeAndReadStateSuccessfully(format, path);  
                randomRealisticUnicodeOfCodepointLengthBetween(1, 100),
                        stateDir.resolve(actualPrefix + id + MetadataStateFormat.STATE_FILE_EXTENSION)
                    }
            DummyState read = format.read(NamedXContentRegistry.EMPTY, list[0]);  
         * I/O failure behaviour can be controlled by {@link #noFailures()}, {@link #failOnMethods(String...)} and  
            @Override
        DummyState(String string, int aInt, long aLong, double aDouble, boolean aBoolean) {  
                randomDouble(),
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(dir, glob)) {  
 *  
        String string;
                            aDouble = parser.doubleValue();  
            return "DummyState{"  
        DummyState state = new DummyState(
            randomRealisticUnicodeOfCodepointLengthBetween(1, 1000),  
            if (aLong != that.aLong) return false;
            randomLong(),
                MockDirectoryWrapper.Failure fail = new MockDirectoryWrapper.Failure() {  
import java.io.IOException;
            msg.append(" checksum value after corruption: ").append(actualChecksumAfterCorruption).append("]");
            builder.field("long", aLong);
        @Override
                .append(fileToCorrupt.getFileName().toString())  
            randomDouble(),
