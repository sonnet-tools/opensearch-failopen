                        System.arraycopy(mainThreadResultFuture.actionGet(), readPos, output, readPos, mainThreadReadEnd - readPos);
                        finishLatch.await();
import org.opensearch.action.support.PlainActionFuture;
                            }
                    fail();
                                }
                case 0:
 * Test harness for verifying {@link IndexInput} implementations.
                default:  
 * Unless required by applicable law or agreed to in writing,
                                // all threads are busy, and queueing can lead this test to deadlock, so we need take no action
import java.util.concurrent.CountDownLatch;
                    final PlainActionFuture<byte[]> mainThreadResultFuture = new PlainActionFuture<>();
                                    clone.close();
                            @Override
     * different access methods. Returns an array of length {@code length} containing the bytes that were read starting at index
import org.opensearch.common.util.concurrent.OpenSearchExecutors;
                        startLatch.countDown();
     * Reads the contents of an {@link IndexInput} from {@code indexInput.getFilePointer()} to {@code length} using a wide variety of
                            public void onAfter() {
                        startLatch.await();  
                                    final int sliceEnd = between(readEnd, length);
                            @Override  
 * GitHub history for details.
 *
        }
                            @Override  
                    }
    @BeforeClass
    }
                    // Read clone or slice concurrently
                    // Seek at a random position and read a single byte,  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
                    }
}  
                case 2:  
                    System.arraycopy(temp, 0, output, readPos, len);
 * the Apache License, Version 2.0 (the "License"); you may
                    readPos = lastReadPos;  
                    System.arraycopy(temp, readPos, output, readPos, bytesToRead);
                    readPos += len;  
                                    System.arraycopy(cloneResult, maxStart, fromClone, 0, overlapLen);
        assertEquals(length, indexInput.getFilePointer());
                            protected void doRun() throws Exception {
     */
 */  
                    readPos += len;
                                final int maxStart = Math.max(mainThreadReadStart, readStart);
        );
                    for (int i = 0; i < cloneCount; i++) {
                    final int mainThreadReadStart = readPos;
 *  
import org.opensearch.core.action.ActionListener;
                    // assert that position in the original input didn't change
    protected byte[] randomReadAndSlice(IndexInput indexInput, int length) throws IOException {  
                                startLatch.countDown();
                    temp = randomReadAndSlice(slice, len);  
        while (readPos < length) {  
import java.io.IOException;  
import org.opensearch.common.util.concurrent.OpenSearchThreadPoolExecutor;
 *     http://www.apache.org/licenses/LICENSE-2.0
        byte[] output = new byte[length];
                                clone.seek(readStart);
                    try {
                                final int readStart = between(0, length);  
        return output;  
            switch (randomIntBetween(0, 5)) {
import org.opensearch.common.util.concurrent.AbstractRunnable;  
                        });
                                } else {
                    System.arraycopy(temp, 0, output, readPos, len);  
/*
                    } catch (InterruptedException e) {
                    assertEquals(readPos, indexInput.getFilePointer());
            0,
            name,
            assertEquals(readPos, indexInput.getFilePointer());  
                    break;
                    IndexInput slice = indexInput.slice("slice (" + readPos + ", " + len + ") of " + indexInput, readPos, len);
 */
                            }  
                    int len = randomIntBetween(1, length - readPos);
                    byte[] temp = new byte[len];  
                                if (randomBoolean()) {  
                    final CountDownLatch finishLatch = new CountDownLatch(cloneCount);
                                }  
        executor = OpenSearchExecutors.newFixed(
                                final int minEnd = Math.min(mainThreadReadEnd, readEnd);  
                    break;
     * {@code indexInput.getFilePointer()}. The bytes of the returned array with indices below the initial value of  
                                // the read from the clone should agree with the read from the main input on their overlap
 * SPDX-License-Identifier: Apache-2.0
 * The OpenSearch Contributors require contributions made to  
 * Licensed to Elasticsearch under one or more contributor  
 * compatible open source license.
                    final int lastReadPos = readPos;
                    final int cloneCount = between(1, 3);  
                        executor.execute(new AbstractRunnable() {  
    }
                                    clone = indexInput.slice("concurrent slice (0, " + sliceEnd + ") of " + indexInput, 0L, sliceEnd);  
                    indexInput.seek(readPos);
public class OpenSearchIndexInputTestCase extends OpenSearchTestCase {  
            new ThreadContext(Settings.EMPTY)  
 * not use this file except in compliance with the License.
        final String name = "TEST-" + getTestClass().getSimpleName() + "#randomReadAndSlice";  
                                }
                    // Read several bytes into 0-offset target
 * Modifications Copyright OpenSearch Contributors. See  
import org.opensearch.common.util.concurrent.ThreadContext;  
                    indexInput.readBytes(output, readPos, len);  
                    // Read using slice  
                    assertEquals(readPos, indexInput.getFilePointer());
                    temp = randomReadAndSlice(indexInput, readPos + bytesToRead);
                                    final byte[] fromClone = new byte[overlapLen];
    public static void destroyExecutor() {
                            }
 * You may obtain a copy of the License at  
                            @Override
                                throw new AssertionError(e);  
 */
                                finishLatch.countDown();
                    indexInput.seek(readPos);
                    readPos += len;
                    // Read by one byte at a time  
                    break;
 */
    }
                                    final byte[] fromMainThread = new byte[overlapLen];
                                if (randomBoolean()) {
 * this work for additional information regarding copyright
import org.junit.AfterClass;  
                case 1:  
                    readPos = randomIntBetween(0, length - 1);  
                case 5:
                    break;
package org.opensearch.common.lucene.store;
                        readPos = mainThreadReadEnd;  
                                startLatch.await();  
/**  
                                    clone = indexInput.clone();  
                    final CountDownLatch startLatch = new CountDownLatch(1 + cloneCount);
    @AfterClass
                                final int readEnd = between(readStart, length);
                                if (maxStart < minEnd) {
 * this file be licensed under the Apache-2.0 license or a
                                startLatch.countDown();
            }
            10,  
                            public void onFailure(Exception e) {
        int readPos = (int) indexInput.getFilePointer();
        executor.shutdown();  
                    len = randomIntBetween(1, length - readPos);
 *
/*
                    break;  
                    assertEquals(readPos, indexInput.getFilePointer());  
                            public void onRejection(Exception e) {  
                case 3:
                        throw new AssertionError(e);  
                    break;
     * {@code indexInput.getFilePointer()} may contain anything. The final value of {@code indexInput.getFilePointer()} is {@code length}.
            OpenSearchExecutors.daemonThreadFactory(name),
/*  
                                    final int overlapLen = minEnd - maxStart;  
 * specific language governing permissions and limitations
    /**  
                                    assertArrayEquals(fromMainThread, fromClone);
    public static void createExecutor() {
                                final IndexInput clone;
 * under the License.  
                    final int bytesToRead = 1;  
                                    System.arraycopy(mainThreadResult, maxStart, fromMainThread, 0, overlapLen);  
                    // then seek back to original position
 * KIND, either express or implied.  See the License for the
 * license agreements. See the NOTICE file distributed with
                                final byte[] cloneResult = randomReadAndSlice(clone, readEnd);
                        ActionListener.completeWith(mainThreadResultFuture, () -> randomReadAndSlice(indexInput, mainThreadReadEnd));
import org.apache.lucene.store.IndexInput;  
                    indexInput.seek(readPos);
import org.opensearch.test.OpenSearchTestCase;
    private static OpenSearchThreadPoolExecutor executor;
                    len = randomIntBetween(1, length - readPos);
                                    final byte[] mainThreadResult = mainThreadResultFuture.actionGet();
 * software distributed under the License is distributed on an
                            }  
 * ownership. Elasticsearch licenses this file to you under  
                    final int mainThreadReadEnd = randomIntBetween(readPos + 1, length);  
                    output[readPos++] = indexInput.readByte();
import org.opensearch.common.settings.Settings;
                    indexInput.readBytes(temp, 0, len);
                    // Read several bytes into target
import org.junit.BeforeClass;
                    assertEquals(readPos, indexInput.getFilePointer());
                case 4:
