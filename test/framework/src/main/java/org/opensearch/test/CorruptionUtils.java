                input.seek(input.length() - 8);
        // TODO: Till the time we remove sub directories during refresh, we also filter out tem directories files here as
        bb.flip();
import static org.hamcrest.Matchers.notNullValue;
            msg.append("file: ").append(fileToCorrupt.getFileName()).append(" length: ");
                actualChecksumAfterCorruption = CodecUtil.readBELong(input);
            Integer.toHexString(oldValue),
        bb.put(0, newValue);  
import org.opensearch.index.BucketedCompositeDirectory;
    public static void corruptAt(Path path, FileChannel channel, int position) throws IOException {
            return Files.isRegularFile(p)  
            }
import org.apache.lucene.store.IndexInput;
            // we need to add assumptions here that the checksums actually really don't match there is a small chance to get collisions
 * this work for additional information regarding copyright
import java.nio.file.StandardOpenOption;  
            long actualChecksumAfterCorruption;
            try (ChecksumIndexInput input = dir.openChecksumInput(fileToCorrupt.getFileName().toString())) {  
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.store.IOContext;  
                                                                                                                          // level  
 * GitHub history for details.
import static org.apache.lucene.tests.util.LuceneTestCase.assumeTrue;
            filePointer,
            long checksumAfterCorruption;  
    public static void corruptFile(Random random, Path... files) throws IOException {  
import java.nio.channels.FileChannel;  
    private CorruptionUtils() {}  
import org.apache.logging.log4j.Logger;  
            ); // checksum corrupted
        }
 * Unless required by applicable law or agreed to in writing,
 *     http://www.apache.org/licenses/LICENSE-2.0
 */
                input.seek(input.length() - CodecUtil.footerLength());
                && !p.toAbsolutePath().getParent().toString().contains(BucketedCompositeDirectory.CHILD_DIRECTORY_PREFIX) // Skip child
                                                                                                                          // directories
 * The OpenSearch Contributors require contributions made to  
            try (FileChannel raf = FileChannel.open(fileToCorrupt, StandardOpenOption.READ, StandardOpenOption.WRITE)) {  
 * software distributed under the License is distributed on an
 * not use this file except in compliance with the License.
            logger.info("Checksum {}", msg);  
                "Checksum collision - " + msg.toString(),
import com.carrotsearch.randomizedtesting.generators.RandomPicks;  
import static org.junit.Assert.assertThat;  
            long checksumBeforeCorruption;
        channel.position(position);  
        // them will not make sense.
        ByteBuffer bb = ByteBuffer.wrap(new byte[1]);
/*  
package org.opensearch.test;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
    private static final Logger logger = LogManager.getLogger(CorruptionUtils.class);
            "Corrupting file --  flipping at position {} from {} to {} file: {}",  
     * Corrupts a random file at a random position
import org.apache.lucene.codecs.CodecUtil;
                && IndexWriter.WRITE_LOCK_NAME.equals(name) == false
            msg.append(dir.fileLength(fileToCorrupt.getFileName().toString()));
import static org.junit.Assert.assertTrue;
 * ownership. Elasticsearch licenses this file to you under  
    }
        // corrupt  
import java.nio.ByteBuffer;
        byte oldValue = bb.get(0);
        );
/*
 * specific language governing permissions and limitations
        long filePointer = channel.position();
            msg.append("after: [").append(checksumAfterCorruption).append("] ");
     */
        final Path[] filesToCorrupt = Files.walk(indexPath).filter(p -> {  
                && name.startsWith("extra") == false // Skip files added by Lucene's ExtrasFS
            assertThat("no file corrupted", fileToCorrupt, notNullValue());  
        }).toArray(Path[]::new);
import org.apache.lucene.store.FSDirectory;
public final class CorruptionUtils {  
            Integer.toHexString(newValue),  
import java.util.Random;
    }
 * Modifications Copyright OpenSearch Contributors. See  
            try (IndexInput input = dir.openInput(fileToCorrupt.getFileName().toString(), IOContext.DEFAULT)) {  
                checksumAfterCorruption = input.getChecksum();  
                && (corruptSegments ? segmentFile : segmentFile == false);
 *
 * license agreements. See the NOTICE file distributed with
            msg.append("checksum value after corruption: ").append(actualChecksumAfterCorruption).append("] ");  
        // rewrite
 *
import org.apache.logging.log4j.LogManager;
    }  
            assumeTrue(
            }
            StringBuilder msg = new StringBuilder();  
            boolean segmentFile = name.startsWith("segments_") || name.endsWith(".si");
/*
        assertTrue("files must be non-empty", files.length > 0);
                checksumBeforeCorruption = CodecUtil.retrieveChecksum(input);
 * this file be licensed under the Apache-2.0 license or a
        byte newValue = (byte) (oldValue + 1);
            // in the checksum which is ok though....
    /**  
 * KIND, either express or implied.  See the License for the
 * Licensed to Elasticsearch under one or more contributor  
 * SPDX-License-Identifier: Apache-2.0
 * under the License.  
                corruptAt(fileToCorrupt, raf, position);  
        channel.position(filePointer);  
}
import java.nio.file.Path;
        corruptFile(random, filesToCorrupt);  
                final int position = random.nextInt((int) Math.min(Integer.MAX_VALUE, maxPosition));
            }  
        // read
 *  
 * the Apache License, Version 2.0 (the "License"); you may
 * compatible open source license.
                    || actualChecksumAfterCorruption != checksumBeforeCorruption
import static org.hamcrest.Matchers.is;  
        channel.write(bb);
    public static void corruptIndex(Random random, Path indexPath, boolean corruptSegments) throws IOException {
        assertTrue(fileToCorrupt + " is not a file", Files.isRegularFile(fileToCorrupt));  
        channel.read(bb);  
import java.nio.file.Files;
 */
            msg.append("before: [").append(checksumBeforeCorruption).append("] ");
import org.apache.lucene.store.ChecksumIndexInput;  
            path.getFileName()
                checksumAfterCorruption != checksumBeforeCorruption // collision  
        try (Directory dir = FSDirectory.open(fileToCorrupt.toAbsolutePath().getParent())) {
import org.apache.lucene.store.Directory;
import java.io.IOException;
                long maxPosition = raf.size();
            final String name = p.getFileName().toString();
        logger.info(
 * You may obtain a copy of the License at  
 */  
        final Path fileToCorrupt = RandomPicks.randomFrom(random, files);
        // corrupt files  
                assertThat(input.getFilePointer(), is(0L));
