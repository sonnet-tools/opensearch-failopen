        final TranslogHeader outHeader = new TranslogHeader(translogUUID, randomNonNegativeLong());
public class TranslogHeaderTests extends OpenSearchTestCase {
        CodecUtil.writeHeader(new OutputStreamDataOutput(out), TranslogHeader.TRANSLOG_CODEC, TranslogHeader.VERSION_CHECKPOINTS);
                1,
                final TranslogHeader translogHeader = TranslogHeader.read(
 *
        final OutputStreamStreamOutput out = new OutputStreamStreamOutput(Channels.newOutputStream(channel));
                    "version " + TranslogHeader.VERSION_CHECKPOINTS + " translog",
            assertThat(inHeader.getTranslogUUID(), equalTo(translogUUID));
                // succeeds if the corruption corrupted the version byte making this look like a v2 translog, because we don't check the
        final String translogUUID = UUIDs.randomBase64UUID();
                assertThat(
        });
 */
                    anyOf(
 * under the License.
 * Modifications Copyright OpenSearch Contributors. See
            final TranslogHeader inHeader = TranslogHeader.read(translogUUID, translogFile, channel);
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
    }
        TestTranslog.corruptFile(logger, random(), translogFile, false);
 * specific language governing permissions and limitations
                    equalTo(SequenceNumbers.UNASSIGNED_PRIMARY_TERM)
        });
                SequenceNumbers.NO_OPS_PERFORMED
        channel.force(true);
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
                    equalTo(SequenceNumbers.UNASSIGNED_PRIMARY_TERM)
        }
 *
            "/org/opensearch/index/translog/translog-v1-corrupted-magic.binary",
 */
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
        final TranslogCorruptedException corruption = expectThrows(TranslogCorruptedException.class, () -> {
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
        checkFailsToOpen("/org/opensearch/index/translog/translog-v0.binary", IllegalStateException.class, "pre-1.4 translog");
        final TranslogCorruptedException corruption = expectThrows(TranslogCorruptedException.class, () -> {
            "pre-2.0 translog"
        }
import static org.hamcrest.Matchers.instanceOf;
                1,
                assertThat(
            "/org/opensearch/index/translog/translog-v1-corrupted-body.binary",
        final String translogUUID = UUIDs.randomBase64UUID();
        assertThat(corruption.getMessage(), not(containsString("this translog file belongs to a different translog")));
import static org.hamcrest.Matchers.lessThan;
                assertThat(
        }
                    e.getMessage(),
 * Licensed to Elasticsearch under one or more contributor
            assertThat(inHeader.sizeInBytes(), equalTo((int) channel.position()));
        );
        final BytesRef uuid = new BytesRef(translogUUID);
                    randomBoolean() ? outHeader.getTranslogUUID() : UUIDs.randomBase64UUID(),
        checkFailsToOpen(
                TranslogHeader.read(UUIDs.randomBase64UUID(), translogFile, channel);
                        containsString("pre-2.0 translog found"),
            "translog looks like version 1 or later, but has corrupted header"
                throw new TranslogCorruptedException(translogFile.toString(), "adjusted translog version", e);
 * not use this file except in compliance with the License.
        final Path translogLocation = createTempDir();
            IllegalStateException.class,
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
import static org.hamcrest.Matchers.not;
        final Path translogFile = createTempDir().resolve(Translog.getFilename(generation));
        }
                    "version " + TranslogHeader.VERSION_CHECKPOINTS + "-or-earlier translog",
/*
            } catch (IllegalStateException e) {
 *     http://www.apache.org/licenses/LICENSE-2.0
                throw new TranslogCorruptedException(translogFile.toString(), "adjusted translog version");
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
            assertThat((int) channel.position(), lessThan(TranslogHeader.headerSizeInBytes(translogUUID)));
        final long generation = randomNonNegativeLong();
 *
package org.opensearch.index.translog;
        final String translogUUID = UUIDs.randomBase64UUID();
                SequenceNumbers.NO_OPS_PERFORMED,
    public void testLegacyTranslogVersions() throws Exception {
                // checksum on this version
 * SPDX-License-Identifier: Apache-2.0
    }
                throw new TranslogCorruptedException(translogFile.toString(), "adjusted translog version", e);
            assertThat(inHeader.getPrimaryTerm(), equalTo(outHeader.getPrimaryTerm()));
        TestTranslog.corruptFile(logger, random(), translogFile, false);
            assertThat(inHeader.getPrimaryTerm(), equalTo(SequenceNumbers.UNASSIGNED_PRIMARY_TERM));
                    translogHeader.getPrimaryTerm(),
            assertThat(inHeader.sizeInBytes(), equalTo((int) channel.position()));
                    anyOf(
    }
 * this work for additional information regarding copyright
                1,
    private <E extends Exception> void checkFailsToOpen(String file, Class<E> expectedErrorType, String expectedMessage) {
                        containsString("pre-6.3 translog found")
                    "version " + TranslogHeader.VERSION_CHECKPOINTS + "-or-earlier translog",
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
            final TranslogHeader inHeader = TranslogHeader.read(translogFile, channel);
                        containsString("pre-2.0 translog found"),
            assertThat(outHeader.sizeInBytes(), equalTo((int) channel.position()));
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
            assertThat(inHeader.getTranslogUUID(), equalTo(translogUUID));
 * software distributed under the License is distributed on an
                );
                    )
 */
}
            outHeader.write(channel, true);
            outHeader.write(channel, true);
        );
                final TranslogHeader translogHeader = TranslogHeader.read(translogFile, channel);
 * compatible open source license.
        }
        out.writeBytes(uuid.bytes, uuid.offset, uuid.length);
                Files.size(translogFile),
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.CREATE_NEW, StandardOpenOption.WRITE)) {
        assertThat(channel.position(), equalTo(43L));
import org.apache.lucene.codecs.CodecUtil;
            }
/*
        out.writeInt(uuid.length);
            assertThat(inHeader.sizeInBytes(), equalTo((int) channel.position()));
            final Checkpoint checkpoint = new Checkpoint(
        final Path translogFile = createTempDir().resolve(Translog.getFilename(generation));
        try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
                );
import org.apache.lucene.store.OutputStreamDataOutput;
import org.apache.lucene.util.BytesRef;
import static org.hamcrest.Matchers.anyOf;
import java.nio.file.Path;
import java.nio.channels.FileChannel;
        final TranslogCorruptedException mismatchUUID = expectThrows(TranslogCorruptedException.class, () -> {
    public void testCorruptTranslogHeader() throws Exception {
            TranslogCorruptedException.class,
    public void testHeaderWithoutPrimaryTerm() throws Exception {
            assertThat(inHeader.getPrimaryTerm(), equalTo(outHeader.getPrimaryTerm()));
        checkFailsToOpen("/org/opensearch/index/translog/translog-v1.binary", IllegalStateException.class, "pre-2.0 translog");
        });
                );
    }
    static void writeHeaderWithoutTerm(FileChannel channel, String translogUUID) throws IOException {
 * GitHub history for details.
                        containsString("pre-1.4 translog found"),
                        containsString("pre-6.3 translog found")
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
        assertThat(error.getMessage(), containsString(expectedMessage));
            }
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
            }
 * the Apache License, Version 2.0 (the "License"); you may
import java.nio.channels.Channels;
        final Exception error = expectThrows(Exception.class, () -> {
import java.nio.file.Files;
    }
 * You may obtain a copy of the License at
        assertThat("test file [" + translogFile + "] should exist", Files.exists(translogFile), equalTo(true));
import org.opensearch.common.UUIDs;
        final long generation = randomNonNegativeLong();
                    "version " + TranslogHeader.VERSION_CHECKPOINTS + " translog",
                    e.getMessage(),
 * KIND, either express or implied.  See the License for the
            assertThat(outHeader.sizeInBytes(), equalTo((int) channel.position()));
        checkFailsToOpen(
import java.nio.file.StandardOpenOption;
            }
import org.opensearch.core.common.io.stream.OutputStreamStreamOutput;
                    translogHeader.getPrimaryTerm(),
    }
                );
                // corruption corrupted the version byte making this look like a v2, v1 or v0 translog
import java.io.IOException;
                    )
        final TranslogHeader outHeader = new TranslogHeader(translogUUID, randomNonNegativeLong());
 * license agreements. See the NOTICE file distributed with
        final long generation = randomNonNegativeLong();
 * Unless required by applicable law or agreed to in writing,
        checkFailsToOpen("/org/opensearch/index/translog/translog-v1-truncated.binary", IllegalStateException.class, "pre-2.0 translog");
                        containsString("pre-1.4 translog found"),
import static org.hamcrest.Matchers.equalTo;
            writeHeaderWithoutTerm(channel, translogUUID);
            assertThat(outHeader.sizeInBytes(), equalTo((int) channel.position()));
import org.opensearch.test.OpenSearchTestCase;
        });
        final String translogUUID = UUIDs.randomBase64UUID();
            );
        assertThat(error, either(instanceOf(IllegalStateException.class)).or(instanceOf(TranslogCorruptedException.class)));
        assertThat(mismatchUUID.getMessage(), containsString("this translog file belongs to a different translog"));
            outHeader.write(channel, true);
    public void testCurrentHeaderVersion() throws Exception {
    }
        });
                TranslogHeader.read(randomValueOtherThan(translogUUID, UUIDs::randomBase64UUID), translogFile, channel);
                assertThat(
        expectThrows(TranslogCorruptedException.class, () -> {
 * ownership. Elasticsearch licenses this file to you under
            }
            final TranslogHeader inHeader = TranslogHeader.read(translogUUID, translogFile, channel);
        final Path translogFile = createTempDir().resolve(Translog.getFilename(generation));
 * this file be licensed under the Apache-2.0 license or a
    public void testCurrentHeaderVersionWithoutUUIDComparison() throws Exception {
import static org.hamcrest.Matchers.either;
                SequenceNumbers.NO_OPS_PERFORMED,
        assertThat(corruption.getMessage(), not(containsString("this translog file belongs to a different translog")));
        final Path translogFile = getDataPath(file);
import static org.hamcrest.Matchers.containsString;
                TranslogReader.open(channel, translogFile, checkpoint, null);
        }
        TestTranslog.corruptFile(logger, random(), translogFile, false);
        final TranslogHeader outHeader = new TranslogHeader(translogUUID, randomNonNegativeLong());
import org.opensearch.index.seqno.SequenceNumbers;
 * The OpenSearch Contributors require contributions made to
                    translogFile,
        }
                throw new TranslogCorruptedException(translogFile.toString(), "adjusted translog version");
            assertThat(inHeader.getTranslogUUID(), equalTo(translogUUID));
            try (FileChannel channel = FileChannel.open(translogFile, StandardOpenOption.READ)) {
                SequenceNumbers.NO_OPS_PERFORMED,
        final E error = expectThrows(expectedErrorType, () -> {
        final long generation = randomNonNegativeLong();
        final Path translogFile = translogLocation.resolve(Translog.getFilename(generation));
                // corruption corrupted the version byte making this look like a v2, v1 or v0 translog
        });
/*
                );
                TranslogHeader.read(randomValueOtherThan(translogUUID, UUIDs::randomBase64UUID), translogFile, channel);
            } catch (IllegalStateException e) {
            }
                    channel
