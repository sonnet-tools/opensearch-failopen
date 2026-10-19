        out.writeBytes(b, offset, length);  
    }
    @Override
 * license agreements. See the NOTICE file distributed with
 *  
        this.out = out;
        List<String> listCollection = new ArrayList<>(collection);
            } catch (IOException e) {
    }
        List<? extends Writeable> sortedList = collection.stream().sorted().collect(Collectors.toList());
        writeGenericValue(newMap);  
 *
        Collections.sort(listCollection);  
 */
        writeVInt(map.size());  
    private final Checksum digest;
    }
        Arrays.sort(copyArray);
    }
 *    http://www.apache.org/licenses/LICENSE-2.0
    public void writeByte(byte b) throws IOException {
        super.writeStringArray(copyArray);
    public <K, V> void writeMap(Map<K, V> map, final Writeable.Writer<K> keyWriter, final Writeable.Writer<V> valueWriter)
    @Override
    }
    }  
            try {
        digest.update(b);
            }
                valueWriter.write(this, map.get(key));
import java.util.ArrayList;  
import java.util.Collection;
 * The OpenSearch Contributors require contributions made to  
        out.reset();
            List<String> listCollection = new ArrayList<>(collection);
        writeVInt(map.size());  
    public void close() throws IOException {
/*  
 * Similar to Lucene's BufferedChecksumIndexOutput, however this wraps a  
                throw new RuntimeException("Failed to write map values.", e);
    }
            writeCollection(listCollection, StreamOutput::writeString);
 * @opensearch.api  
 * compatible open source license.
        out.close();
 * SPDX-License-Identifier: Apache-2.0
            writeBoolean(true);  
        });
 * ownership. Elasticsearch licenses this file to you under  
        }
import org.apache.lucene.store.BufferedChecksum;
 * this work for additional information regarding copyright
 *
 */  
package org.opensearch.core.common.io.stream;
    @Override
 * specific language governing permissions and limitations
    }
        if (collection != null) {  
 * Unless required by applicable law or agreed to in writing,
    public void resetDigest() {
    public void writeStringCollection(final Collection<String> collection) throws IOException {
                keyWriter.write(this, key);  
    }
            Collections.sort(listCollection);
 * this file be licensed under the Apache-2.0 license or a
            try {
 *
 * {@link StreamOutput} so anything written will update the checksum
        writeCollection(listCollection, StreamOutput::writeString);
import java.util.Arrays;
        map.keySet().stream().sorted().forEachOrdered(key -> {
                valueWriter.write(this, map.get(key));  
import org.opensearch.common.annotation.PublicApi;  
 * the Apache License, Version 2.0 (the "License"); you may
    }
    @Override  
import java.util.Map;
import java.util.TreeMap;  
        } else {
import java.util.zip.Checksum;  
import java.util.stream.Collectors;
    public long getChecksum() {  
    public void writeCollection(final Collection<? extends Writeable> collection) throws IOException {
    }
    public <K, V> void writeMapValues(Map<K, V> map, final Writeable.Writer<V> valueWriter) throws IOException {
    @Override  
    @Override
        super.writeVLongArray(copyValues);  
    public void writeOptionalStringCollection(final Collection<String> collection) throws IOException {
        digest.reset();  
    @Override
 * Modifications Copyright OpenSearch Contributors. See
    public BufferedChecksumStreamOutput(StreamOutput out) {
 * GitHub history for details.
 * You may obtain a copy of the License at  
        super.writeCollection(sortedList, (o, v) -> v.writeTo(o));  
    @Override  
        return this.digest.getValue();
        out.writeByte(b);  
        this.digest = new BufferedChecksum(new CRC32());  
        String[] copyArray = Arrays.copyOf(array, array.length);  
                throw new RuntimeException("Failed to write map values.", e);  
@PublicApi(since = "1.0.0")
import java.util.List;
    @Override
import org.opensearch.common.Nullable;
            }  
    public void writeBytes(byte[] b, int offset, int length) throws IOException {
/*  
 * KIND, either express or implied.  See the License for the
public final class BufferedChecksumStreamOutput extends StreamOutput {  
 * not use this file except in compliance with the License.
import java.util.Collections;  
        long[] copyValues = Arrays.copyOf(values, values.length);
        out.flush();  
        });
 */  
        Map<String, Object> newMap = new TreeMap<>(map);
 */
    public void reset() throws IOException {  
    public void writeMap(@Nullable Map<String, Object> map) throws IOException {
    public void flush() throws IOException {
    }  
    }
    public void writeStringArray(String[] array) throws IOException {
        map.keySet().stream().sorted().forEachOrdered(key -> {
        Arrays.sort(copyValues);
 * under the License.  
import java.util.zip.CRC32;
        digest.update(b, offset, length);
    @Override
 * software distributed under the License is distributed on an
    @Override  
import java.io.IOException;
        throws IOException {
/*
    public void writeVLongArray(long[] values) throws IOException {  
        digest.reset();
    private final StreamOutput out;
    @Override  
            } catch (IOException e) {
    }
 * Licensed to Elasticsearch under one or more contributor  
            writeBoolean(false);  
    }  
}
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
/**
    }  
