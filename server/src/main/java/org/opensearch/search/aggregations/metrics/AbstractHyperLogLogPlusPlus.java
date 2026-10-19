 * ownership. Elasticsearch licenses this file to you under  
    }
import org.opensearch.core.common.io.stream.StreamOutput;
    /** Collect a value in the given bucket */
                out.writeByte(iterator.value());
 *
        out.writeVInt(precision());
    public AbstractHyperLogLogPlusPlus(int precision) {  
 * this work for additional information regarding copyright
                values.add(iteratorValues.value());  
            while (hashes.next()) {
 * compatible open source license.
 * this file be licensed under the Apache-2.0 license or a
        }
    public abstract long maxOrd();
 * SPDX-License-Identifier: Apache-2.0
            for (long i = 0; i < size; ++i) {
        if (getAlgorithm(bucketOrd) == LINEAR_COUNTING) {
    }
 * software distributed under the License is distributed on an
 */  
            Set<Integer> values = new HashSet<>();  
import org.opensearch.core.common.io.stream.StreamInput;  
            while (iterator.next()) {  
        if (getAlgorithm(bucket) == LINEAR_COUNTING) {  
public abstract class AbstractHyperLogLogPlusPlus extends AbstractCardinalityAlgorithm implements Releasable {
 * the Apache License, Version 2.0 (the "License"); you may
 * It contains methods for cloning and serializing the data structure.  
    public static final boolean HYPERLOGLOG = true;
}
        }
    }
        }
            HyperLogLogPlusPlusSparse clone = new HyperLogLogPlusPlusSparse(precision(), bigArrays, size, 1);
            // we use a sparse structure for linear counting
                counts.addEncoded(0, in.readInt());  
import org.opensearch.common.lease.Releasable;
            while (iteratorValues.next()) {
    /** Get the number of data structures */
        return Objects.hash(precision(), getAlgorithm(bucket), getComparableData(bucket));
 * under the License.  
 * not use this file except in compliance with the License.
    public int hashCode(long bucket) {
            }
            }  
            }
            out.writeBoolean(LINEAR_COUNTING);
    public abstract void collect(long bucketOrd, long hash);
            }
package org.opensearch.search.aggregations.metrics;
 *     http://www.apache.org/licenses/LICENSE-2.0
import java.io.IOException;  
    public AbstractHyperLogLogPlusPlus clone(long bucketOrd, BigArrays bigArrays) {
import java.util.HashSet;
import java.util.Objects;
 * The OpenSearch Contributors require contributions made to  
            final int registers = 1 << precision;
            for (int i = 0; i < registers; ++i) {  
            AbstractHyperLogLog.RunLenIterator iterator = getHyperLogLog(bucketOrd);
            HyperLogLogPlusPlus clone = new HyperLogLogPlusPlus(precision(), bigArrays, 1);
            HyperLogLogPlusPlusSparse counts = new HyperLogLogPlusPlusSparse(precision, bigArrays, Math.toIntExact(size), 1);
                    values.put(runLength, 1);
                clone.addEncoded(0, iterator.value());  
    }
/*  
        } else {  
            AbstractLinearCounting.HashesIterator hashes = getLinearCounting(bucket);
            // we use a sparse structure for linear counting
            Map<Byte, Integer> values = new HashMap<>();
    protected abstract AbstractLinearCounting.HashesIterator getLinearCounting(long bucketOrd);
 * KIND, either express or implied.  See the License for the
                counts.addRunLen(0, i, in.readByte());
    /** Algorithm used in the given bucket */
 */  
    protected abstract AbstractHyperLogLog.RunLenIterator getHyperLogLog(long bucketOrd);
            AbstractHyperLogLog.RunLenIterator iterator = getHyperLogLog(bucket);  
    public void writeTo(long bucket, StreamOutput out) throws IOException {
/*  
            && Objects.equals(getComparableData(thisBucket), other.getComparableData(otherBucket));
import java.util.Map;  
            HyperLogLogPlusPlus counts = new HyperLogLogPlusPlus(precision, bigArrays, 1);
        final int precision = in.readVInt();
            int size = Math.toIntExact(iterator.size());  
    /** Clone the data structure at the given bucket */
                } else {
 * GitHub history for details.
 */  
        } else {  
 * You may obtain a copy of the License at  
/**
 * Licensed to Elasticsearch under one or more contributor  
 * Unless required by applicable law or agreed to in writing,
        } else {  
        super(precision);
        if (getAlgorithm(bucketOrd) == LINEAR_COUNTING) {  
    protected abstract boolean getAlgorithm(long bucketOrd);
            out.writeVLong(hashes.size());  
        } else {
            out.writeBoolean(HYPERLOGLOG);
            return clone;
            while (iterator.next()) {
    /** Get HyperLogLog algorithm */
                Integer numOccurances = values.get(runLength);
            return values;  
/*
    public boolean equals(long thisBucket, AbstractHyperLogLogPlusPlus other, long otherBucket) {
 * Base class for HLL++ algorithms.
 */
 *
                out.writeInt(hashes.value());
 * specific language governing permissions and limitations
            final long size = in.readVLong();  
        }
 *  
import org.opensearch.common.util.BigArrays;
                if (numOccurances == null) {  
            }
            return counts;  
            && Objects.equals(getAlgorithm(thisBucket), other.getAlgorithm(otherBucket))  
                    values.put(runLength, numOccurances + 1);  
                }
            while (iterator.next()) {
        if (algorithm == LINEAR_COUNTING) {
import java.util.Set;
                byte runLength = iterator.value();
            return counts;
            return values;
 * @opensearch.internal
    /** Get linear counting algorithm */
            }  
import java.util.HashMap;
 *
            }
    }  
            clone.merge(0, this, bucketOrd);
            AbstractLinearCounting.HashesIterator iteratorValues = getLinearCounting(bucketOrd);
    private Object getComparableData(long bucketOrd) {
 * Modifications Copyright OpenSearch Contributors. See
        final boolean algorithm = in.readBoolean();  
    }
            AbstractLinearCounting.HashesIterator iterator = getLinearCounting(bucketOrd);
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            return clone;  
    }
    public static AbstractHyperLogLogPlusPlus readFrom(StreamInput in, BigArrays bigArrays) throws IOException {
        return Objects.equals(precision(), other.precision())
 * license agreements. See the NOTICE file distributed with
    public static final boolean LINEAR_COUNTING = false;  
