        is = new InputStreamIndexInput(input, 2);
        is = new InputStreamIndexInput(input, 2);
        InputStreamIndexInput is = new InputStreamIndexInput(input, 2);
        InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
    public void testReadMultiSingleByteLimit1() throws IOException {
 *     http://www.apache.org/licenses/LICENSE-2.0
        }
        }
        Directory dir = new ByteBuffersDirectory();
public class InputStreamIndexInputTests extends OpenSearchTestCase {
        byte[] read = new byte[2];
            assertThat(is.actualSizeToRead(), equalTo(1L));
        }
/*
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
        assertThat(is.read(read), equalTo(2));
        assertThat(is.read(), equalTo(1));
 * license agreements. See the NOTICE file distributed with
        assertThat(is.actualSizeToRead(), equalTo(2L));
 * KIND, either express or implied.  See the License for the
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
        assertThat(is.read(), equalTo(2));
        assertThat(is.read(read), equalTo(2));
        assertThat(input.getFilePointer(), lessThan(input.length()));
        assertThat(is.read(read), equalTo(2));
import org.opensearch.test.OpenSearchTestCase;
import org.apache.lucene.store.IOContext;
        assertThat(is.read(), equalTo(2));
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
 * specific language governing permissions and limitations
        }
        output.close();
        assertThat(read[2], equalTo((byte) 1));
        Directory dir = new ByteBuffersDirectory();
            assertThat(is.actualSizeToRead(), equalTo(1L));
 * Unless required by applicable law or agreed to in writing,
        assertThat(is.read(), equalTo(-1));
        assertThat(read[0], equalTo((byte) 2));
        assertThat(input.getFilePointer(), lessThan(input.length()));
import org.apache.lucene.store.Directory;
        }
            assertThat(is.read(), equalTo(-1));
        }
            assertThat(is.read(), equalTo(2));
 * The OpenSearch Contributors require contributions made to
        assertThat(read[0], equalTo((byte) 1));
            output.writeByte((byte) 2);
        for (int i = 0; i < 3; i++) {
        for (int i = 0; i < 3; i++) {
 */
        assertThat(is.actualSizeToRead(), equalTo(2L));
        assertThat(is.actualSizeToRead(), equalTo(0L));
        assertThat(is.read(), equalTo(1));
 * compatible open source license.
import org.apache.lucene.store.IndexOutput;
        assertThat(read[0], equalTo((byte) 1));
        }
        assertThat(is.actualSizeToRead(), equalTo(2L));
 * ownership. Elasticsearch licenses this file to you under
    public void testReadMultiTwoBytesLimit1() throws IOException {
        assertThat(read[0], equalTo((byte) 1));
        assertThat(is.read(read), equalTo(-1));
            assertThat(input.getFilePointer(), lessThan(input.length()));
        is.reset();
        InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
 * not use this file except in compliance with the License.
        byte[] read = new byte[2];
        assertThat(input.getFilePointer(), lessThan(input.length()));
        assertThat(is.read(), equalTo(1));
        is = new InputStreamIndexInput(input, 2);
            output.writeByte((byte) 1);
        Directory dir = new ByteBuffersDirectory();
 * this file be licensed under the Apache-2.0 license or a
            InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
        assertThat(is.read(), equalTo(1));
        assertThat(is.actualSizeToRead(), equalTo(4L));
        assertThat(read[3], equalTo((byte) 2));
        assertThat(input.getFilePointer(), equalTo(input.length()));
            output.writeByte((byte) 1);
import java.io.IOException;
        assertThat(is.read(), equalTo(-1));
        Directory dir = new ByteBuffersDirectory();
import static org.hamcrest.Matchers.equalTo;
        assertThat(is.read(), equalTo(2));
 * under the License.
        is = new InputStreamIndexInput(input, 2);
        assertThat(is.actualSizeToRead(), equalTo(0L));
}
    public void testReadMultiFourBytesLimit() throws IOException {
        for (int i = 0; i < 3; i++) {
        assertThat(read[1], equalTo((byte) 2));
        for (int i = 0; i < 3; i++) {
            assertThat(input.getFilePointer(), lessThan(input.length()));
        for (int i = 0; i < 3; i++) {
        assertThat(input.getFilePointer(), lessThan(input.length()));
        assertThat(input.getFilePointer(), lessThan(input.length()));
        assertThat(is.actualSizeToRead(), equalTo(2L));
        }
        assertThat(read[0], equalTo((byte) 2));
            InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
        assertThat(is.read(), equalTo(-1));
        for (int i = 0; i < 3; i++) {
/*
 * Licensed to Elasticsearch under one or more contributor
        is = new InputStreamIndexInput(input, 2);
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
        assertThat(input.getFilePointer(), lessThan(input.length()));
    public void testSingleReadSingleByteLimit() throws IOException {
        assertThat(is.read(), equalTo(1));
        assertThat(is.actualSizeToRead(), equalTo(0L));
        assertThat(is.read(read), equalTo(-1));
        assertThat(is.read(), equalTo(1));
        assertThat(input.getFilePointer(), lessThan(input.length()));
import org.apache.lucene.store.ByteBuffersDirectory;
        assertThat(is.actualSizeToRead(), equalTo(0L));
        Directory dir = new ByteBuffersDirectory();
        assertThat(is.read(read), equalTo(-1));
        for (int i = 0; i < 3; i++) {
        }
        assertThat(read[1], equalTo((byte) 1));
            assertThat(read[0], equalTo((byte) 2));
        assertThat(is.read(), equalTo(-1));
            output.writeByte((byte) 1);
        assertThat(is.read(), equalTo(2));
        assertThat(read[1], equalTo((byte) 1));
package org.opensearch.common.lucene.store;
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
        assertThat(read[1], equalTo((byte) 2));
        for (int i = 0; i < 3; i++) {
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
        }
        InputStreamIndexInput is = new InputStreamIndexInput(input, 2);
    public void testSingleReadTwoBytesLimit() throws IOException {
        output.close();
        }
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
        assertThat(is.read(read), equalTo(2));
 * Modifications Copyright OpenSearch Contributors. See
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
            output.writeByte((byte) 2);
    }
 * the Apache License, Version 2.0 (the "License"); you may
            assertThat(is.read(read), equalTo(1));
        assertThat(input.getFilePointer(), equalTo(input.length()));
 * SPDX-License-Identifier: Apache-2.0
/*
        for (int i = 0; i < 3; i++) {
        assertThat(is.actualSizeToRead(), equalTo(2L));
        assertThat(input.getFilePointer(), equalTo(input.length()));
        assertThat(input.getFilePointer(), equalTo(input.length()));
        output.close();
            assertThat(read[0], equalTo((byte) 1));
            output.writeByte((byte) 2);
        output.close();
        assertThat(is.markSupported(), equalTo(true));
            InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
            assertThat(is.read(), equalTo(-1));
            InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
        for (int i = 0; i < 3; i++) {
 * this work for additional information regarding copyright
 * software distributed under the License is distributed on an
        output.close();
        is.mark(0);
        for (int i = 0; i < 3; i++) {
            assertThat(is.read(), equalTo(1));
        assertThat(is.read(read), equalTo(4));
    }
        }
        InputStreamIndexInput is = new InputStreamIndexInput(input, 4);
        for (int i = 0; i < 3; i++) {
import static org.hamcrest.Matchers.lessThan;
            assertThat(is.actualSizeToRead(), equalTo(1L));
            output.writeByte((byte) 2);
        }
        is = new InputStreamIndexInput(input, 2);
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
        byte[] read = new byte[4];
        assertThat(input.getFilePointer(), lessThan(input.length()));
    }
            assertThat(is.actualSizeToRead(), equalTo(1L));
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
        assertThat(is.read(), equalTo(1));
 */
        assertThat(input.getFilePointer(), equalTo(input.length()));
 *
            output.writeByte((byte) 2);
    public void testMarkRest() throws Exception {
        for (int i = 0; i < 3; i++) {
        assertThat(is.actualSizeToRead(), equalTo(0L));
            output.writeByte((byte) 2);
        assertThat(is.read(), equalTo(-1));
    }
 */
 * GitHub history for details.
            assertThat(is.read(read), equalTo(1));
        assertThat(is.actualSizeToRead(), equalTo(2L));
        is = new InputStreamIndexInput(input, 4);
        is = new InputStreamIndexInput(input, 4);
        output.close();
            output.writeByte((byte) 1);
import org.apache.lucene.store.IndexInput;
            assertThat(input.getFilePointer(), lessThan(input.length()));
        for (int i = 0; i < 3; i++) {
            output.writeByte((byte) 1);
        for (int i = 0; i < 3; i++) {
 * You may obtain a copy of the License at
            assertThat(input.getFilePointer(), lessThan(input.length()));
        }
        assertThat(is.read(), equalTo(2));
    }
        assertThat(is.actualSizeToRead(), equalTo(2L));
 *
        for (int i = 0; i < 3; i++) {
        Directory dir = new ByteBuffersDirectory();
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
        }
 *
            output.writeByte((byte) 1);
    }
        }
        assertThat(read[1], equalTo((byte) 2));
        InputStreamIndexInput is = new InputStreamIndexInput(input, 4);
