            } catch (IllegalStateException e) {
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
                    "version " + TranslogHeader.VERSION_CHECKPOINTS + " translog",
    public void testCurrentHeaderVersion() throws Exception {
            outHeader.write(channel, true);
/*  
            final TranslogHeader inHeader = TranslogHeader.read(translogUUID, translogFile, channel);  
                    e.getMessage(),
import org.opensearch.test.OpenSearchTestCase;
import static org.hamcrest.Matchers.not;
            assertThat((int) channel.position(), lessThan(TranslogHeader.headerSizeInBytes(translogUUID)));
                assertThat(  
            final Checkpoint checkpoint = new Checkpoint(
            "/org/opensearch/index/translog/translog-v1-corrupted-magic.binary",  
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
                SequenceNumbers.NO_OPS_PERFORMED,
                    "version " + TranslogHeader.VERSION_CHECKPOINTS + "-or-earlier translog",  
                        containsString("pre-2.0 translog found"),
import java.nio.file.Files;  
                // checksum on this version
/*  
        });
 * ownership. Elasticsearch licenses this file to you under  
 * KIND, either express or implied.  See the License for the
import static org.hamcrest.Matchers.containsString;
        });
            assertThat(inHeader.sizeInBytes(), equalTo((int) channel.position()));  
        final long generation = randomNonNegativeLong();
                SequenceNumbers.NO_OPS_PERFORMED,  
import static org.hamcrest.Matchers.equalTo;
 * compatible open source license.
                TranslogReader.open(channel, translogFile, checkpoint, null);  
        out.writeBytes(uuid.bytes, uuid.offset, uuid.length);
                        containsString("pre-2.0 translog found"),  
            assertThat(outHeader.sizeInBytes(), equalTo((int) channel.position()));  
 *
        final TranslogHeader outHeader = new TranslogHeader(translogUUID, randomNonNegativeLong());
        }  
        );  
                );  
                    channel
                1,
            assertThat(inHeader.getTranslogUUID(), equalTo(translogUUID));
        assertThat(error, either(instanceOf(IllegalStateException.class)).or(instanceOf(TranslogCorruptedException.class)));  
                    translogFile,
        final Path translogFile = createTempDir().resolve(Translog.getFilename(generation));
                    anyOf(
        final Path translogFile = createTempDir().resolve(Translog.getFilename(generation));  
                    translogHeader.getPrimaryTerm(),
import static org.hamcrest.Matchers.either;  
/*
        }
 * The OpenSearch Contributors require contributions made to  
 * this work for additional information regarding copyright
            }
import java.nio.file.StandardOpenOption;
        assertThat(corruption.getMessage(), not(containsString("this translog file belongs to a different translog")));
        final String translogUUID = UUIDs.randomBase64UUID();  
            "translog looks like version 1 or later, but has corrupted header"
            assertThat(inHeader.getTranslogUUID(), equalTo(translogUUID));
                assertThat(  
 */  
    }  
                    e.getMessage(),
 *  
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
        final long generation = randomNonNegativeLong();
        TestTranslog.corruptFile(logger, random(), translogFile, false);  
import java.nio.channels.Channels;
 * not use this file except in compliance with the License.
                // succeeds if the corruption corrupted the version byte making this look like a v2 translog, because we don't check the
        assertThat(error.getMessage(), containsString(expectedMessage));  
                assertThat(
        channel.force(true);  
                throw new TranslogCorruptedException(translogFile.toString(), "adjusted translog version");
    }
}
public class TranslogHeaderTests extends OpenSearchTestCase {  
        checkFailsToOpen(
    private <E extends Exception> void checkFailsToOpen(String file, Class<E> expectedErrorType, String expectedMessage) {  
        final long generation = randomNonNegativeLong();
        final Path translogFile = getDataPath(file);
                    randomBoolean() ? outHeader.getTranslogUUID() : UUIDs.randomBase64UUID(),  
    }
            outHeader.write(channel, true);  
            IllegalStateException.class,  
        checkFailsToOpen("/org/opensearch/index/translog/translog-v1-truncated.binary", IllegalStateException.class, "pre-2.0 translog");
        });  
                SequenceNumbers.NO_OPS_PERFORMED  
        }
    }
                        containsString("pre-1.4 translog found"),
                    )  
                Files.size(translogFile),
    }
    public void testHeaderWithoutPrimaryTerm() throws Exception {
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
        final E error = expectThrows(expectedErrorType, () -> {  
        TestTranslog.corruptFile(logger, random(), translogFile, false);
            final TranslogHeader inHeader = TranslogHeader.read(translogUUID, translogFile, channel);
        assertThat(mismatchUUID.getMessage(), containsString("this translog file belongs to a different translog"));
        final Path translogFile = createTempDir().resolve(Translog.getFilename(generation));  
            assertThat(outHeader.sizeInBytes(), equalTo((int) channel.position()));  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                        containsString("pre-6.3 translog found")  
    static void writeHeaderWithoutTerm(FileChannel channel, String translogUUID) throws IOException {  
        assertThat(channel.position(), equalTo(43L));
                    "version " + TranslogHeader.VERSION_CHECKPOINTS + "-or-earlier translog",
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
        expectThrows(TranslogCorruptedException.class, () -> {
import org.apache.lucene.codecs.CodecUtil;
        assertThat(corruption.getMessage(), not(containsString("this translog file belongs to a different translog")));  
        final Path translogFile = translogLocation.resolve(Translog.getFilename(generation));
 * the Apache License, Version 2.0 (the "License"); you may
 */
    }  
        final TranslogCorruptedException corruption = expectThrows(TranslogCorruptedException.class, () -> {
        }
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
                    translogHeader.getPrimaryTerm(),  
import org.apache.lucene.util.BytesRef;  
            assertThat(inHeader.getPrimaryTerm(), equalTo(SequenceNumbers.UNASSIGNED_PRIMARY_TERM));
        }  
                    )
 */  
                TranslogHeader.read(UUIDs.randomBase64UUID(), translogFile, channel);  
 * this file be licensed under the Apache-2.0 license or a
            writeHeaderWithoutTerm(channel, translogUUID);
            }
        }
        checkFailsToOpen("/org/opensearch/index/translog/translog-v1.binary", IllegalStateException.class, "pre-2.0 translog");  
            }
                final TranslogHeader translogHeader = TranslogHeader.read(
        final long generation = randomNonNegativeLong();
 * Licensed to Elasticsearch under one or more contributor  
import static org.hamcrest.Matchers.instanceOf;
                TranslogHeader.read(randomValueOtherThan(translogUUID, UUIDs::randomBase64UUID), translogFile, channel);  
            assertThat(inHeader.sizeInBytes(), equalTo((int) channel.position()));  
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
            "pre-2.0 translog"
import org.apache.lucene.store.OutputStreamDataOutput;
 * You may obtain a copy of the License at  
        final TranslogCorruptedException mismatchUUID = expectThrows(TranslogCorruptedException.class, () -> {
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {  
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
import static org.hamcrest.Matchers.anyOf;
        final String translogUUID = UUIDs.randomBase64UUID();  
            assertThat(outHeader.sizeInBytes(), equalTo((int) channel.position()));
                    equalTo(SequenceNumbers.UNASSIGNED_PRIMARY_TERM)
        );
 * GitHub history for details.
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
 * under the License.  
 * software distributed under the License is distributed on an
        final OutputStreamStreamOutput out = new OutputStreamStreamOutput(Channels.newOutputStream(channel));
                );
import static org.hamcrest.Matchers.lessThan;  
import java.nio.channels.FileChannel;
        checkFailsToOpen("/org/opensearch/index/translog/translog-v0.binary", IllegalStateException.class, "pre-1.4 translog");
                final TranslogHeader translogHeader = TranslogHeader.read(translogFile, channel);  
 * Unless required by applicable law or agreed to in writing,
            );
                        containsString("pre-6.3 translog found")
                    anyOf(  
 *
                    "version " + TranslogHeader.VERSION_CHECKPOINTS + " translog",
            assertThat(inHeader.getPrimaryTerm(), equalTo(outHeader.getPrimaryTerm()));
package org.opensearch.index.translog;
    public void testCurrentHeaderVersionWithoutUUIDComparison() throws Exception {
        final Path translogLocation = createTempDir();  
    public void testCorruptTranslogHeader() throws Exception {
                );
import org.opensearch.index.seqno.SequenceNumbers;  
    public void testLegacyTranslogVersions() throws Exception {
                TranslogHeader.read(randomValueOtherThan(translogUUID, UUIDs::randomBase64UUID), translogFile, channel);
 * Modifications Copyright OpenSearch Contributors. See
            assertThat(inHeader.sizeInBytes(), equalTo((int) channel.position()));
        final TranslogCorruptedException corruption = expectThrows(TranslogCorruptedException.class, () -> {  
        });
            assertThat(inHeader.getPrimaryTerm(), equalTo(outHeader.getPrimaryTerm()));
                    equalTo(SequenceNumbers.UNASSIGNED_PRIMARY_TERM)  
            "/org/opensearch/index/translog/translog-v1-corrupted-body.binary",
 * SPDX-License-Identifier: Apache-2.0
import org.opensearch.common.UUIDs;
            }
                assertThat(
 * license agreements. See the NOTICE file distributed with
        final String translogUUID = UUIDs.randomBase64UUID();  
 *     http://www.apache.org/licenses/LICENSE-2.0
        checkFailsToOpen(
            }
        CodecUtil.writeHeader(new OutputStreamDataOutput(out), TranslogHeader.TRANSLOG_CODEC, TranslogHeader.VERSION_CHECKPOINTS);
            assertThat(inHeader.getTranslogUUID(), equalTo(translogUUID));  
                SequenceNumbers.NO_OPS_PERFORMED,
                1,
                );
import java.io.IOException;  
            } catch (IllegalStateException e) {  
                // corruption corrupted the version byte making this look like a v2, v1 or v0 translog
        final Exception error = expectThrows(Exception.class, () -> {
                throw new TranslogCorruptedException(translogFile.toString(), "adjusted translog version", e);  
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
        final TranslogHeader outHeader = new TranslogHeader(translogUUID, randomNonNegativeLong());
import java.nio.file.Path;
        final TranslogHeader outHeader = new TranslogHeader(translogUUID, randomNonNegativeLong());
            TranslogCorruptedException.class,
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
        final String translogUUID = UUIDs.randomBase64UUID();  
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {  
                );
    }  
            final TranslogHeader inHeader = TranslogHeader.read(translogFile, channel);  
 * specific language governing permissions and limitations
        out.writeInt(uuid.length);
        });
                throw new TranslogCorruptedException(translogFile.toString(), "adjusted translog version", e);
                throw new TranslogCorruptedException(translogFile.toString(), "adjusted translog version");  
            outHeader.write(channel, true);
                1,  
            }  
        assertThat("test file [" + translogFile + "] should exist", Files.exists(translogFile), equalTo(true));
                        containsString("pre-1.4 translog found"),
        final BytesRef uuid = new BytesRef(translogUUID);  
                // corruption corrupted the version byte making this look like a v2, v1 or v0 translog
        });
        TestTranslog.corruptFile(logger, random(), translogFile, false);  
        }
