                    } catch (InterruptedException e) {
    protected byte[] randomReadAndSlice(IndexInput indexInput, int length) throws IOException {
                    final int mainThreadReadStart = readPos;
                    System.arraycopy(temp, 0, output, readPos, len);
        assertEquals(length, indexInput.getFilePointer());
                                final byte[] cloneResult = randomReadAndSlice(clone, readEnd);
        byte[] output = new byte[length];
                                    System.arraycopy(cloneResult, maxStart, fromClone, 0, overlapLen);
            OpenSearchExecutors.daemonThreadFactory(name),
                            @Override
                            public void onFailure(Exception e) {
                    indexInput.seek(readPos);
 */
                    readPos += len;
                    }
                    try {
        executor.shutdown();
                    break;
                    System.arraycopy(temp, 0, output, readPos, len);
                                }
 * You may obtain a copy of the License at
                    final int cloneCount = between(1, 3);
                        readPos = mainThreadReadEnd;
import org.opensearch.action.support.PlainActionFuture;
                    break;
                    for (int i = 0; i < cloneCount; i++) {
                                    final int sliceEnd = between(readEnd, length);
                    temp = randomReadAndSlice(slice, len);
     */
                                if (randomBoolean()) {
                        System.arraycopy(mainThreadResultFuture.actionGet(), readPos, output, readPos, mainThreadReadEnd - readPos);
                    // Read using slice
            assertEquals(readPos, indexInput.getFilePointer());
 *     http://www.apache.org/licenses/LICENSE-2.0
                    break;
}
                    fail();
                case 5:
                    final int bytesToRead = 1;
                    final CountDownLatch startLatch = new CountDownLatch(1 + cloneCount);
                                throw new AssertionError(e);
/*
                    System.arraycopy(temp, readPos, output, readPos, bytesToRead);
                    // Read clone or slice concurrently
 * Test harness for verifying {@link IndexInput} implementations.
        int readPos = (int) indexInput.getFilePointer();
                    temp = randomReadAndSlice(indexInput, readPos + bytesToRead);
                            @Override
                    break;
        }
                    // Read by one byte at a time
                                    clone = indexInput.slice("concurrent slice (0, " + sliceEnd + ") of " + indexInput, 0L, sliceEnd);
                    break;
    }
                                clone.seek(readStart);
                    int len = randomIntBetween(1, length - readPos);
 * Unless required by applicable law or agreed to in writing,
 * Modifications Copyright OpenSearch Contributors. See
     * {@code indexInput.getFilePointer()} may contain anything. The final value of {@code indexInput.getFilePointer()} is {@code length}.
import org.junit.AfterClass;
                    output[readPos++] = indexInput.readByte();
                    IndexInput slice = indexInput.slice("slice (" + readPos + ", " + len + ") of " + indexInput, readPos, len);
                            public void onAfter() {
                    indexInput.seek(readPos);
    @BeforeClass
import org.opensearch.common.util.concurrent.ThreadContext;
 *
                                finishLatch.countDown();
/*
            0,
                        startLatch.await();
                        executor.execute(new AbstractRunnable() {
            }
 * ownership. Elasticsearch licenses this file to you under
                                    clone = indexInput.clone();
                            @Override
                    final CountDownLatch finishLatch = new CountDownLatch(cloneCount);
     * different access methods. Returns an array of length {@code length} containing the bytes that were read starting at index
import org.opensearch.common.util.concurrent.AbstractRunnable;
                                if (maxStart < minEnd) {
                                final IndexInput clone;
                                } else {
                            @Override
/*
                    len = randomIntBetween(1, length - readPos);
                            public void onRejection(Exception e) {
package org.opensearch.common.lucene.store;
 * the Apache License, Version 2.0 (the "License"); you may
 * under the License.
public class OpenSearchIndexInputTestCase extends OpenSearchTestCase {
            switch (randomIntBetween(0, 5)) {
                                final int minEnd = Math.min(mainThreadReadEnd, readEnd);
 * software distributed under the License is distributed on an
    }
    public static void destroyExecutor() {
     * Reads the contents of an {@link IndexInput} from {@code indexInput.getFilePointer()} to {@code length} using a wide variety of
                            }
        );
    public static void createExecutor() {
                                final int readStart = between(0, length);
                    assertEquals(readPos, indexInput.getFilePointer());
import java.io.IOException;
                    readPos = lastReadPos;
                                    final byte[] mainThreadResult = mainThreadResultFuture.actionGet();
    private static OpenSearchThreadPoolExecutor executor;
                    break;
        return output;
        final String name = "TEST-" + getTestClass().getSimpleName() + "#randomReadAndSlice";
 * SPDX-License-Identifier: Apache-2.0
                default:
 */
                    assertEquals(readPos, indexInput.getFilePointer());
 */
                                final int maxStart = Math.max(mainThreadReadStart, readStart);
import org.junit.BeforeClass;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
                                startLatch.countDown();
 * GitHub history for details.
                                    final byte[] fromMainThread = new byte[overlapLen];
                case 0:
                    byte[] temp = new byte[len];
import org.opensearch.common.settings.Settings;
                        finishLatch.await();
                    final int mainThreadReadEnd = randomIntBetween(readPos + 1, length);
            new ThreadContext(Settings.EMPTY)
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
 *
import org.opensearch.core.action.ActionListener;
                        ActionListener.completeWith(mainThreadResultFuture, () -> randomReadAndSlice(indexInput, mainThreadReadEnd));
                    // Read several bytes into target
 * The OpenSearch Contributors require contributions made to
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
                                    System.arraycopy(mainThreadResult, maxStart, fromMainThread, 0, overlapLen);
                case 4:
        while (readPos < length) {
                            }
                    indexInput.seek(readPos);
    }
                    readPos += len;
                                    assertArrayEquals(fromMainThread, fromClone);
 *
            10,
                                startLatch.countDown();
                    }
                    readPos += len;
/**
    @AfterClass
                                // all threads are busy, and queueing can lead this test to deadlock, so we need take no action
                    readPos = randomIntBetween(0, length - 1);
                    // assert that position in the original input didn't change
                    indexInput.readBytes(output, readPos, len);
 * not use this file except in compliance with the License.
import java.util.concurrent.CountDownLatch;
                                }
                    final int lastReadPos = readPos;
                            protected void doRun() throws Exception {
                                    final byte[] fromClone = new byte[overlapLen];
                case 1:
    /**
import org.opensearch.test.OpenSearchTestCase;
                            }
                                final int readEnd = between(readStart, length);
 * compatible open source license.
                    indexInput.readBytes(temp, 0, len);
                        throw new AssertionError(e);
 * this work for additional information regarding copyright
        executor = OpenSearchExecutors.newFixed(
                                    clone.close();
 * Licensed to Elasticsearch under one or more contributor
                            }
                        });
                    // Read several bytes into 0-offset target
                    assertEquals(readPos, indexInput.getFilePointer());
            name,
                                }
 */
                                if (randomBoolean()) {
                        startLatch.countDown();
import org.apache.lucene.store.IndexInput;
                                // the read from the clone should agree with the read from the main input on their overlap
 * license agreements. See the NOTICE file distributed with
 * KIND, either express or implied.  See the License for the
 * this file be licensed under the Apache-2.0 license or a
                case 2:
     * {@code indexInput.getFilePointer()}. The bytes of the returned array with indices below the initial value of
                    len = randomIntBetween(1, length - readPos);
                    // then seek back to original position
                    final PlainActionFuture<byte[]> mainThreadResultFuture = new PlainActionFuture<>();
                                    final int overlapLen = minEnd - maxStart;
                                startLatch.await();
                    // Seek at a random position and read a single byte,
                    assertEquals(readPos, indexInput.getFilePointer());
 * specific language governing permissions and limitations
                case 3:
