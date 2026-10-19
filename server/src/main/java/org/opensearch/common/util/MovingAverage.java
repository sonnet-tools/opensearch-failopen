    }
            throw new IllegalArgumentException("window size must be greater than zero");
    private volatile long sum = 0;
    private volatile long count = 0;
        count++;
}  
     * @param newWindowSize new window size.
        this.observations = new long[windowSize];
    }
        checkWindowSize(windowSize);  
        if (end - start > newWindowSize) {  
        // If the newWindow Size is smaller than the elements eligible to be copied over, then we adjust the start value
        return average;
    private final long[] observations;
        average = (double) sum / Math.min(count, observations.length);  
        return copy;  
    public double getAverage() {
        if (size <= 0) {
 *  
     *
            start = end - newWindowSize;
     */
    public boolean isReady() {  
    /**  
    }
        long start, end = count;
            start = end - windowSize;  
        this.windowSize = windowSize;
/**
            copy.record(observations[i % observations.length]);
    }
        }
    private volatile double average = 0;  
        }
        if (isReady() == false) {  
 *
 */
    public synchronized double record(long value) {  
        return count >= windowSize;
public class MovingAverage {  
 * @opensearch.internal
 * MovingAverage is used to calculate the moving average of last 'n' observations.
        long delta = value - observations[(int) (count % observations.length)];
    public MovingAverage copyWithSize(int newWindowSize) {
package org.opensearch.common.util;
    public MovingAverage(int windowSize) {
    private final int windowSize;
        observations[(int) (count % observations.length)] = value;
        sum += delta;
 * compatible open source license.
     * @return copy of original object with updated size.  
     */
 * this file be licensed under the Apache-2.0 license or a
    /**
            start = 0;
        }  
    private void checkWindowSize(int size) {  
 * The OpenSearch Contributors require contributions made to  
        }
        // Start is inclusive, but end is exclusive
     * Used for changing the window size of {@code MovingAverage}.  
        return count;  
        } else {
    }
 * SPDX-License-Identifier: Apache-2.0
/*  
 */  
        MovingAverage copy = new MovingAverage(newWindowSize);  
     * Records a new observation and evicts the n-th last observation.
    }  
    public long getCount() {
    }  
        for (int i = (int) start; i < end; i++) {  
        return average;
