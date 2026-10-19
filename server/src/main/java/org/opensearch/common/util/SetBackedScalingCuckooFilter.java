            other.hashes.forEach(this::add);
    public void add(BytesRef value) {
 * this file be licensed under the Apache-2.0 license or a
        // We have to ensure that, in the worst case, two full sets can be converted into
                        if (fingerprint == CuckooFilter.EMPTY || mightContainFingerprint(bucket, (int) fingerprint)) {
        if (isSetMode) {  
    public SetBackedScalingCuckooFilter(int threshold, Random rng, double fpp) {  
        if (other == null || getClass() != other.getClass()) {
/*  
        return bytes;
 * SPDX-License-Identifier: Apache-2.0
 */
    /**
        }
import org.opensearch.common.hash.MurmurHash3;
 * <p>  
    }
     * to a cuckoo if it goes over threshold
        }  
        return Objects.equals(this.hashes, that.hashes)  
                // The iterator returns an array of longs corresponding to the  
            convert();  
            );
        if (isSetMode) {  
    /**
    }
 * this work for additional information regarding copyright
        } else {
        breaker.accept(-oldSize); // this zeros out the overhead of the set
            }  
        numBuckets = t.getNumBuckets();
                            breaker.accept(t.getSizeInBytes()); // make sure we account for the new filter
            // this will fall through to the last conditional and do a cuckoo-cuckoo merge
                        }
        if (hashes != null) {
                    long[] fingerprints = iter.next();
                // fingerprints for buckets at the current position
        }
        }
        fingerprintMask = t.getFingerprintMask();
        }
            hashes.add(hash);
        } else {
import java.util.function.Consumer;  
     * the datastructure scales by adding a new filter.  This new filter's bytes will be tracked
    @Override
 */  
        }  
                        // Try to insert into the last filter in our list
        }
     * in the registered breaker when configured.  
        filters = new ArrayList<>();
            this.fingerprintMask = filters.get(0).getFingerprintMask();
            filters.add(t);
        if (isSetMode) {
     * This will be null if isSetMode = true;  
        this.isSetMode = other.isSetMode;
    /**
    public void merge(SetBackedScalingCuckooFilter other) {  
 * An approximate set membership datastructure that scales as more unique values are inserted.  
        if (isSetMode) {  
            maybeConvert();  
     */
    private MurmurHash3.Hash128 scratchHash = new MurmurHash3.Hash128();
 * You may obtain a copy of the License at  
            this.bitsPerEntry = filters.get(0).getBitsPerEntry();
/**
        addHash(hash.h1);
import java.util.Random;
        }
    private final int threshold;
    private static final int FILTER_CAPACITY = 1000000;
        int bucket = CuckooFilter.hashToIndex((int) hash, numBuckets);
        for (CuckooFilter filter : filters) {  
            throw new IllegalArgumentException("[threshold] must be smaller than [" + (FILTER_CAPACITY / 2) + "]");
    }  
     * <p>
     */
     * @param threshold The number of distinct values that should be tracked
        } else {
        }  
    /**
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
            }
    private final double fpp;
import java.util.Iterator;
            this.fingerprintMask = filters.get(0).getFingerprintMask();
            }  
        }  
            this.hashes = in.readSet(StreamInput::readZLong);  
        this.rng = rng;
    private boolean mightContainHash(long hash) {
        }  
    /**
        if (success == false) {
        // Cache the chosen numBuckets for later use  
import org.opensearch.core.common.io.stream.StreamOutput;
        filters.add(t);  
     */
        if (threshold <= 0) {
     * be the union of the two.  During the merging process, the internal Set may be upgraded  
     * Returns true if the set might contain the provided value, false otherwise.  False values are
            CuckooFilter t = new CuckooFilter(capacity, fpp, rng);  
    private void maybeConvert() {
import java.util.ArrayList;
    public void add(long value) {
        long hash = MurmurHash3.murmur64(value);  
     */
    };
    }
 * compatible open source license.
            out.writeCollection(hashes, StreamOutput::writeZLong);
            this.filters = in.readList(in12 -> new CuckooFilter(in12, rng));
     */
                }
    void convert() {
        breaker.accept(getSizeInBytes());
    /**  
    /**
     */
    public long getSizeInBytes() {
            && Objects.equals(this.fpp, that.fpp);
        }  
            && Objects.equals(this.threshold, that.threshold)
            convert();
        this.breaker = Objects.requireNonNull(breaker, "Circuit Breaker Consumer cannot be null");  
    public SetBackedScalingCuckooFilter(StreamInput in, Random rng) throws IOException {
     */
            throw new IllegalStateException(  
 * Unless required by applicable law or agreed to in writing,
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(value.bytes, value.offset, value.length, 0, scratchHash);  
            for (CuckooFilter otherFilter : other.filters) {
        if (this.capacity != other.capacity) {
            CuckooFilter currentFilter = filters.get(filters.size() - 1);
 *
        // We calculate these once up front for all the filters and use the expert API
                    // (in the same bucket/alternate bucket), or if the fingerprint is empty. In these cases
     * filter. This gives us 100% accuracy for small cardinalities.  This will be null  
    // True if we are tracking inserts with a set, false otherwise  
     */
    }
            );
    }
     * Add's the provided value to the set for tracking  
     * <p>  
     * Returns true if the set might contain the provided value, false otherwise.  False values are
    private int fingerprintMask = 0;  
 * software distributed under the License is distributed on an
     * This will create a list of CuckooFilters, and null out the set of hashes  
/*
            this.hashes = new HashSet<>(other.hashes);
 * the Apache License, Version 2.0 (the "License"); you may
        this.breaker = other.breaker;  
        this.fpp = in.readDouble();  
 * This datastructure scales as more values are inserted by growing the list of CuckooFilters.
    }
     */
    public void writeTo(StreamOutput out) throws IOException {
        }
 * Final size is dependent on the cardinality of data inserted, and the precision specified.
        if (this.threshold != other.threshold) {
    public int hashCode() {
        boolean success = filters.get(filters.size() - 1).add(hash);  
 * ownership. Elasticsearch licenses this file to you under  
 * specific language governing permissions and limitations
     * package-private for testing  
        out.writeBoolean(isSetMode);  
     */
            // Both in sets, merge collections then see if we need to convert to cuckoo
            this.numBuckets = filters.get(0).getNumBuckets();  
        hashes = null;
        this.capacity = in.readVInt();
    }
    }  
        this.capacity = other.capacity;
     * if isSetMode = false;
        return mightContainHash(hash);
        this.fpp = other.fpp;
    public boolean mightContain(long value) {
        }  
        this.capacity = FILTER_CAPACITY;
 */  
     * @param rng A random number generator needed for the cuckoo hashing process  
            throw new IllegalStateException(
                    // We check to see if the fingerprint is present in any of the existing filters
            // replay the values directly into our filter.  
     * This is the estimated insertion capacity for each individual internal CuckooFilter.  
 * @opensearch.internal
            bytes = (hashes.size() * 16);
            );  
import java.util.Set;
     * @param fpp the false-positive rate that should be used for the cuckoo filters.
        // Some basic sanity checks to make sure we can merge
            merge(other);  
        return Objects.hash(hashes, filters, threshold, isSetMode, capacity, fpp);
 * Licensed to Elasticsearch under one or more contributor  
     * If we still holding values in a set, convert this filter into an approximate, cuckoo-backed filter.
            if (filter.mightContainFingerprint(bucket, fingerprint, alternateIndex)) {
    }  
            // call the merge function again. Since both are now in set-mode  
import java.util.HashSet;  
import org.apache.lucene.util.BytesRef;
            // filter is full, create a new one and insert there
 * <p>  
        if (this.fpp != other.fpp) {  
        long oldSize = getSizeInBytes();
import org.opensearch.core.common.io.stream.Writeable;
                        if (currentFilter.mergeFingerprint(bucket, (int) fingerprint) == false) {  
                            // if we failed, the filter is now saturated and we need to create a new one
        int alternateIndex = CuckooFilter.alternateIndex(bucket, fingerprint, numBuckets);
                            filters.add(t);  
        bitsPerEntry = t.getBitsPerEntry();  
            breaker.accept(t.getSizeInBytes()); // make sure we account for the new filter  
            throw new IllegalStateException(
                    }
            out.writeList(filters);  
 * Internally, the datastructure maintains a Set of hashes up to a specified threshold.  This provides
        out.writeVInt(threshold);
        long bytes = 13; // fpp (double), threshold (int), isSetMode (boolean)  
            && Objects.equals(this.capacity, that.capacity)
            // Both are in cuckoo mode, merge raw fingerprints  
 * When the threshold is breached, a list of CuckooFilters are created and used to track membership.
        this.threshold = in.readVInt();
        if (isSetMode == false) {  
                Iterator<long[]> iter = otherFilter.getBuckets();
        // one cuckoo filter without overflowing. This keeps merging logic simpler  
            maybeConvert();
    private Consumer<Long> breaker = aLong -> {
     * This is an expert-level API since it is dealing with buckets and fingerprints, not raw values
            this.numBuckets = filters.get(0).getNumBuckets();
        }
    private void addHash(long hash) {
        int fingerprint = CuckooFilter.fingerprint((int) (hash >> 32), bitsPerEntry, fingerprintMask);  
        } else if (isSetMode && other.isSetMode == false) {
        return false;
     * This set is used to track the insertions before we convert over to an approximate
    /**
            return true;
package org.opensearch.common.util;
    }
                            continue;  
        this.threshold = threshold;
                        }
            hashes.addAll(other.hashes);
    private final int capacity;  
    }
        CuckooFilter t = new CuckooFilter(capacity, fpp, rng);
        }  
                int bucket = 0;  
     * CuckooFilter's can "saturate" and refuse to accept any new values.  When this happens,
     *                  before converting to an approximate representation
    private final Random rng;
        hashes.forEach(t::add);
     * Returns true if the set might contain the provided value, false otherwise.  False values are
    List<CuckooFilter> filters;
 * The OpenSearch Contributors require contributions made to  
            t.add(hash);
    private boolean isSetMode = true;
                            currentFilter = filters.get(filters.size() - 1);  
        out.writeDouble(fpp);
     * are tracked, not the overhead of the Set itself.  
    }  
        this.hashes = new HashSet<>(threshold);
 */
     * Returns true if any of the filters contain this fingerprint at the specified bucket.  
            && Objects.equals(this.isSetMode, that.isSetMode)  
        if (threshold * 2 > FILTER_CAPACITY) {
                "Cannot merge other CuckooFilter because thresholds do not match: [" + this.threshold + "] vs [" + other.threshold + "]"
    }
     */  
                "Cannot merge other CuckooFilter because precisions do not match: [" + this.fpp + "] vs [" + other.fpp + "]"
        final SetBackedScalingCuckooFilter that = (SetBackedScalingCuckooFilter) other;
 * 100% accurate membership queries.
/*  
    /**
}
        return false;
        // noop  
    public boolean equals(Object other) {  
    Set<Long> hashes;
            this.filters = new ArrayList<>(other.filters);  
import org.opensearch.core.common.io.stream.StreamInput;  
            if (filter.mightContainFingerprint(bucket, fingerprint, alternateIndex)) {
                while (iter.hasNext()) {
 * These filters are approximate similar to Bloom Filters.
    public boolean mightContain(BytesRef value) {
        isSetMode = false;  
     * Registers a circuit breaker with the datastructure.
 * Modifications Copyright OpenSearch Contributors. See
    public void registerBreaker(Consumer<Long> breaker) {
            return;  
     * Add's the provided value to the set for tracking
        return mightContainHash(hash.h1);
        if (isSetMode && hashes.size() > threshold) {
        }
    /**
    private boolean mightContainFingerprint(int bucket, int fingerprint) {
     * This list holds our approximate filters, after we have migrated out of a set.
        this.fpp = fpp;
    }  
 * KIND, either express or implied.  See the License for the
    private int bitsPerEntry = 0;
        }
 *     http://www.apache.org/licenses/LICENSE-2.0
    /**
        }
     * Merge `other` cuckoo filter into this cuckoo.  After merging, this filter's state will
    /**
        addHash(MurmurHash3.murmur64(value));
    // cached here for performance reasons  
 *  
        this.rng = other.rng;
    /**
            // Rather than converting the other to a cuckoo first, we can just
        }  
        this.isSetMode = in.readBoolean();  
    /**
public class SetBackedScalingCuckooFilter implements Writeable {  
        MurmurHash3.Hash128 hash = MurmurHash3.hash128(value.bytes, value.offset, value.length, 0, scratchHash);  
        if (isSetMode) {  
    }
 *
    private int numBuckets = 0;
 * license agreements. See the NOTICE file distributed with
     * 100% accurate, while true values may be a false-positive.  
    @Override  
    public SetBackedScalingCuckooFilter(SetBackedScalingCuckooFilter other) {
    @Override  
 * under the License.  
            return false;
        if (fpp < 0) {
            return hashes.contains(hash);
            throw new IllegalStateException(
                "Cannot convert SetBackedScalingCuckooFilter to approximate " + "when it has already been converted."
 * GitHub history for details.
                    bucket += 1;  
        this.rng = rng;  
 * <p>  
    }  
     */  
     * 100% accurate, while true values may be a false-positive.  
                "Cannot merge other CuckooFilter because capacities do not match: [" + this.capacity + "] vs [" + other.capacity + "]"  
        if (filters != null) {
import java.util.Objects;  
     * Get the approximate size of this datastructure.  Approximate because only the Set occupants
 *  
 * when it does not (has false positives).  Similar in usage to a Bloom Filter.
        int alternateIndex = CuckooFilter.alternateIndex(bucket, fingerprint, numBuckets);
 * not use this file except in compliance with the License.
        } else {
                return true;
            throw new IllegalArgumentException("[fpp] must be a positive double");
            && Objects.equals(this.filters, that.filters)
     */
                    for (long fingerprint : fingerprints) {
        breaker.accept(getSizeInBytes()); // this adds back in the new overhead of the cuckoo filters  
     * being hashed.
                    // we can skip the fingerprint  
     * 100% accurate, while true values may be a false-positive.  
            this.bitsPerEntry = filters.get(0).getBitsPerEntry();  
                return true;
        out.writeVInt(capacity);
        if (this == other) {
import java.util.List;
                            CuckooFilter t = new CuckooFilter(capacity, fpp, rng);
        } else if (isSetMode == false && other.isSetMode) {
        }  
import java.io.IOException;
    }
            bytes += filters.stream().mapToLong(CuckooFilter::getSizeInBytes).sum();
        for (CuckooFilter filter : filters) {  
        this.threshold = other.threshold;  
     */
            // Other is in cuckoo mode, so we convert our set to a cuckoo, then
 * Can definitively say if a member does not exist (no false negatives), but may say an item exists
            );  
            throw new IllegalArgumentException("[threshold] must be a positive integer");
        if (isSetMode && other.isSetMode) {  
