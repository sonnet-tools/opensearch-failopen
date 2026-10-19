        assertThat(read[1], equalTo((byte) 2));
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
        }
        assertThat(is.read(), equalTo(-1));
        is = new InputStreamIndexInput(input, 2);
 * ownership. Elasticsearch licenses this file to you under  
        assertThat(is.read(read), equalTo(2));  
 */
        assertThat(input.getFilePointer(), lessThan(input.length()));
        assertThat(input.getFilePointer(), equalTo(input.length()));
public class InputStreamIndexInputTests extends OpenSearchTestCase {
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
 *     http://www.apache.org/licenses/LICENSE-2.0
        Directory dir = new ByteBuffersDirectory();  
 * license agreements. See the NOTICE file distributed with
        assertThat(is.actualSizeToRead(), equalTo(2L));
        assertThat(input.getFilePointer(), equalTo(input.length()));
/*
import org.apache.lucene.store.IndexInput;
        assertThat(is.actualSizeToRead(), equalTo(0L));
            assertThat(read[0], equalTo((byte) 1));
            assertThat(read[0], equalTo((byte) 2));
        is.mark(0);
import org.apache.lucene.store.IOContext;  
 * SPDX-License-Identifier: Apache-2.0
            output.writeByte((byte) 2);
 *  
        for (int i = 0; i < 3; i++) {  
        assertThat(is.read(), equalTo(-1));
            InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
        assertThat(is.actualSizeToRead(), equalTo(0L));
        for (int i = 0; i < 3; i++) {
        is.reset();
            assertThat(is.actualSizeToRead(), equalTo(1L));
import static org.hamcrest.Matchers.lessThan;
    public void testReadMultiSingleByteLimit1() throws IOException {
 *
        assertThat(is.read(read), equalTo(-1));  
        assertThat(is.read(), equalTo(2));
import org.apache.lucene.store.Directory;
        for (int i = 0; i < 3; i++) {
        assertThat(is.read(read), equalTo(2));
        assertThat(input.getFilePointer(), lessThan(input.length()));
            output.writeByte((byte) 1);
 */  
import org.apache.lucene.store.ByteBuffersDirectory;
        assertThat(is.actualSizeToRead(), equalTo(0L));  
        }  
        assertThat(is.read(read), equalTo(2));
        byte[] read = new byte[2];
            assertThat(is.actualSizeToRead(), equalTo(1L));  
        assertThat(read[1], equalTo((byte) 1));  
        assertThat(is.actualSizeToRead(), equalTo(4L));
            assertThat(input.getFilePointer(), lessThan(input.length()));
        output.close();
 * GitHub history for details.
            assertThat(input.getFilePointer(), lessThan(input.length()));  
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);  
 * The OpenSearch Contributors require contributions made to  
            assertThat(is.read(), equalTo(-1));
        assertThat(is.read(), equalTo(2));
        assertThat(read[1], equalTo((byte) 2));
 */  
            output.writeByte((byte) 1);
}  
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
        }  
    }
        assertThat(is.actualSizeToRead(), equalTo(2L));  
            assertThat(input.getFilePointer(), lessThan(input.length()));  
        InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
        output.close();  
        is = new InputStreamIndexInput(input, 4);
        for (int i = 0; i < 3; i++) {
        for (int i = 0; i < 3; i++) {
        assertThat(is.read(), equalTo(2));  
        is = new InputStreamIndexInput(input, 2);  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
        assertThat(read[3], equalTo((byte) 2));  
        Directory dir = new ByteBuffersDirectory();
        InputStreamIndexInput is = new InputStreamIndexInput(input, 4);  
    }
        for (int i = 0; i < 3; i++) {
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
        assertThat(input.getFilePointer(), lessThan(input.length()));  
 * under the License.  
    }
        for (int i = 0; i < 3; i++) {  
        for (int i = 0; i < 3; i++) {
        InputStreamIndexInput is = new InputStreamIndexInput(input, 2);
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at  
        assertThat(is.read(), equalTo(2));
        assertThat(is.read(), equalTo(1));
    public void testReadMultiFourBytesLimit() throws IOException {
    }
            output.writeByte((byte) 2);
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);  
        for (int i = 0; i < 3; i++) {  
 *
            output.writeByte((byte) 1);
        }
        assertThat(is.read(read), equalTo(-1));
        for (int i = 0; i < 3; i++) {  
        for (int i = 0; i < 3; i++) {
        }  
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);
        }
        }  
        Directory dir = new ByteBuffersDirectory();
            assertThat(is.actualSizeToRead(), equalTo(1L));  
 * compatible open source license.
        assertThat(is.actualSizeToRead(), equalTo(2L));
        assertThat(read[0], equalTo((byte) 1));
        for (int i = 0; i < 3; i++) {
        output.close();
            assertThat(is.read(read), equalTo(1));
        assertThat(read[0], equalTo((byte) 2));  
        for (int i = 0; i < 3; i++) {
        }
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);  
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
        }
        InputStreamIndexInput is = new InputStreamIndexInput(input, 4);
        IndexInput input = dir.openInput("test", IOContext.DEFAULT);
        assertThat(is.read(), equalTo(-1));
        assertThat(input.getFilePointer(), lessThan(input.length()));
        output.close();
            assertThat(input.getFilePointer(), lessThan(input.length()));
import java.io.IOException;
        byte[] read = new byte[2];
 * this file be licensed under the Apache-2.0 license or a
            InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
        IndexOutput output = dir.createOutput("test", IOContext.DEFAULT);  
/*  
 * Modifications Copyright OpenSearch Contributors. See
import static org.hamcrest.Matchers.equalTo;
        assertThat(input.getFilePointer(), lessThan(input.length()));
        }
            InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
            assertThat(is.actualSizeToRead(), equalTo(1L));
        assertThat(input.getFilePointer(), equalTo(input.length()));
        for (int i = 0; i < 3; i++) {  
        assertThat(is.actualSizeToRead(), equalTo(2L));  
        InputStreamIndexInput is = new InputStreamIndexInput(input, 2);
        assertThat(is.actualSizeToRead(), equalTo(2L));
        is = new InputStreamIndexInput(input, 2);  
        assertThat(is.read(), equalTo(-1));  
    public void testMarkRest() throws Exception {  
        Directory dir = new ByteBuffersDirectory();
        for (int i = 0; i < 3; i++) {
        assertThat(input.getFilePointer(), lessThan(input.length()));
 * Unless required by applicable law or agreed to in writing,
    public void testReadMultiTwoBytesLimit1() throws IOException {  
/*  
        assertThat(is.read(), equalTo(2));
        assertThat(is.read(), equalTo(1));  
        assertThat(is.read(), equalTo(1));  
        for (int i = 0; i < 3; i++) {  
        is = new InputStreamIndexInput(input, 4);  
            InputStreamIndexInput is = new InputStreamIndexInput(input, 1);
        assertThat(is.actualSizeToRead(), equalTo(0L));
        }
    public void testSingleReadTwoBytesLimit() throws IOException {
        assertThat(is.actualSizeToRead(), equalTo(0L));  
        Directory dir = new ByteBuffersDirectory();
        }
            assertThat(is.read(read), equalTo(1));  
 * the Apache License, Version 2.0 (the "License"); you may
        assertThat(read[0], equalTo((byte) 1));  
            assertThat(is.read(), equalTo(2));
        }
        assertThat(input.getFilePointer(), lessThan(input.length()));
        assertThat(input.getFilePointer(), equalTo(input.length()));  
        InputStreamIndexInput is = new InputStreamIndexInput(input, 1);  
import org.opensearch.test.OpenSearchTestCase;  
    }
        assertThat(is.read(), equalTo(-1));  
 * specific language governing permissions and limitations
        assertThat(is.read(), equalTo(1));  
        assertThat(is.read(), equalTo(1));
            output.writeByte((byte) 1);  
        assertThat(read[0], equalTo((byte) 2));
        assertThat(input.getFilePointer(), lessThan(input.length()));  
package org.opensearch.common.lucene.store;
        assertThat(is.read(read), equalTo(4));
        is = new InputStreamIndexInput(input, 2);
 * KIND, either express or implied.  See the License for the
    public void testSingleReadSingleByteLimit() throws IOException {
        }  
            assertThat(is.read(), equalTo(-1));  
 * this work for additional information regarding copyright
        is = new InputStreamIndexInput(input, 2);
        assertThat(read[1], equalTo((byte) 1));
        assertThat(is.read(read), equalTo(-1));
        assertThat(input.getFilePointer(), equalTo(input.length()));  
        output.close();  
import org.apache.lucene.store.IndexOutput;
        }  
        assertThat(is.read(), equalTo(1));
        assertThat(is.read(read), equalTo(2));
        assertThat(is.read(), equalTo(1));  
        assertThat(is.markSupported(), equalTo(true));
            output.writeByte((byte) 1);  
        assertThat(is.actualSizeToRead(), equalTo(2L));
        Directory dir = new ByteBuffersDirectory();  
        assertThat(read[1], equalTo((byte) 2));
        is = new InputStreamIndexInput(input, 2);
            assertThat(is.read(), equalTo(1));
            output.writeByte((byte) 2);  
    }  
        assertThat(is.actualSizeToRead(), equalTo(2L));
            output.writeByte((byte) 1);
        }
            output.writeByte((byte) 2);
            output.writeByte((byte) 2);  
        output.close();
        assertThat(read[2], equalTo((byte) 1));
        byte[] read = new byte[4];  
            output.writeByte((byte) 2);
        assertThat(read[0], equalTo((byte) 1));  
 * Licensed to Elasticsearch under one or more contributor  
 * software distributed under the License is distributed on an
