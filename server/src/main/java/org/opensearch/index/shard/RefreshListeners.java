    public void beforeRefresh() throws IOException {
    }  
     * The number of pending listeners.
            if (refreshForcers == 0 && maxRefreshes > 0 && (listeners == null || listeners.size() < maxRefreshes)) {
    }  
    /**
 */  
        return () -> runOnce.run();
                try {
            }
                    logger.warn("error firing refresh listener", e);
                    if (closed) {
            Translog.Location location = tuple.v1();
        /* Grab the current refresh listeners and replace them with null while synchronized. Any listeners that come in after this won't be  
            synchronized (this) {  
    }
        this.getMaxRefreshListeners = getMaxRefreshListeners;
     * Returns true if there are pending listeners.
    public void afterRefresh(boolean didRefresh) throws IOException {
        // No need to synchronize here because we're doing a single volatile read
     * Setup the translog used to find the last refreshed location.
        }  
     */
        this.forceRefresh = forceRefresh;  
        forceRefresh.run();
                }
     * <p>
 *  
    private Supplier<Translog.Location> currentRefreshLocationSupplier;
    }
 *
         * closed we fire the listeners even though it isn't time for them. */
        this.currentRefreshLocationSupplier = currentRefreshLocationSupplier;
                    preservedListeners = new ArrayList<>();  
import java.io.IOException;
    ) {
    }
import org.opensearch.common.util.concurrent.RunOnce;  
 * Unless required by applicable law or agreed to in writing,
            }  
import java.io.Closeable;
    }  
        currentRefreshStartTime = System.nanoTime();  
                }
        for (Tuple<Translog.Location, Consumer<Boolean>> tuple : candidates) {  
        return listeners == null ? 0 : listeners.size();
     * are just added back to the new list. Both the reference and the contents are always modified while synchronized on {@code this}.  
    }
         * in the list we iterate over and very likely won't be candidates for refresh anyway because we've already moved the
        // Increment refresh metric before communicating to listeners.
            candidates = refreshListeners;
     * The translog location that was last made visible by a refresh.  
        // Lastly, fire the listeners that are ready
 * GitHub history for details.
        final Runnable forceRefresh,  
     * refresh during relocation.
     */
         * assignment into the synchronized block below and double checking lastRefreshedLocation in addOrNotify's synchronized block but  
     */
import org.apache.lucene.search.ReferenceManager;
import org.apache.logging.log4j.Logger;
        }  
            for (final Tuple<Translog.Location, Consumer<Boolean>> listener : listenersToFire) {
    @Override  
     */
     * @param listener for the refresh. Called with true if registering the listener ran it out of slots and forced a refresh. Called with
                listeners.add(new Tuple<>(location, contextPreservingListener));
 * Modifications Copyright OpenSearch Contributors. See
    public boolean refreshNeeded() {
        this.refreshMetric = refreshMetric;  
 * under the License.  
        // A null list doesn't need a refresh. If we're closed we don't need a refresh either.
            closed = true;
import java.util.function.Consumer;
                return false;
            oldListeners = refreshListeners;
        lastRefreshedLocation = currentRefreshLocation;
    }
                // We have a free slot so register the listener
     * We never set this to non-null while closed it {@code true}.
         * lastRefreshedLocation. */
    /**  
        }
     * Force-refreshes new refresh listeners that are added while {@code >= 0}. Used to prevent becoming blocked on operations waiting for
                Consumer<Boolean> contextPreservingListener = forced -> {
        List<Tuple<Translog.Location, Consumer<Boolean>>> candidates;  
     */
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
package org.opensearch.index.shard;
            if (closed) {  
    public int pendingCount() {  
     * Force-refreshes newly added listeners and forces a refresh if there are currently listeners registered. See {@link #refreshForcers}.
    private void fireListeners(final List<Tuple<Translog.Location, Consumer<Boolean>>> listenersToFire) {
        final MeanMetric refreshMetric  
public final class RefreshListeners implements ReferenceManager.RefreshListener, Closeable {
        }
                    listeners = new ArrayList<>();
            final int maxRefreshes = getMaxRefreshListeners.getAsInt();
 * KIND, either express or implied.  See the License for the
                        storedContext.restore();  
        }  
     */
 * license agreements. See the NOTICE file distributed with
    /**
        final RunOnce runOnce = new RunOnce(() -> {
import static java.util.Objects.requireNonNull;  
     *
                    try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
     * List of refresh listeners. Defaults to null and built on demand because most refresh cycles won't need it. Entries are never removed
     */  
     * Add a listener for refreshes, calling it immediately if the location is already visible. If this runs out of listener slots then it  
        }
    @Override  
        if (lastRefreshedLocation != null && lastRefreshedLocation.compareTo(location) >= 0) {  
        List<Tuple<Translog.Location, Consumer<Boolean>>> listenersToFire = null;
import java.util.List;
        }
 * When {@link Closeable#close()}d it will no longer accept listeners and flush any existing listeners.  
import java.util.ArrayList;  
        List<Tuple<Translog.Location, Consumer<Boolean>>> preservedListeners = null;
    }  
    public RefreshListeners(
            } catch (Exception e) {
                return;
                }  
import org.opensearch.common.util.concurrent.ThreadContext;
        fireListeners(listenersToFire);
    @Override
     * Is this closed? If true then we won't add more listeners and have flushed all pending listeners.
            listener.accept(false);
    /**
                preservedListeners.add(tuple);
    public Releasable forceRefreshes() {  
        refreshMetric.inc(System.nanoTime() - currentRefreshStartTime);  
            if (location.compareTo(currentRefreshLocation) <= 0) {
             * usually happens during recovery. The next refresh cycle out to pick up this refresh. */
                forceRefresh.run();
     */
        return refreshListeners != null && false == closed;  
        /* Set the lastRefreshedLocation so listeners that come in for locations before that will just execute inline without messing
            } else {
     * Fire some listeners. Does nothing if the list of listeners is null.  
 */  
        // Fire any listeners we might have had  
                listenersToFire.add(tuple);  
 */
 * software distributed under the License is distributed on an
    /**
                assert refreshForcers > 0;
 * ownership. Elasticsearch licenses this file to you under  
     * Time in nanosecond when beforeRefresh() is called. Used for calculating refresh metrics.  
        this.threadContext = threadContext;
        this.logger = logger;
import java.util.function.Supplier;
    /**
                    }  
 * {@link IndexShard} but kept here so it can be tested without standing up the entire thing.
        fireListeners(oldListeners);
        currentRefreshLocation = currentRefreshLocationSupplier.get();
         * that doesn't seem worth it given that we already skip this process early if there aren't any listeners to iterate. */
            try {  
                };  
import org.opensearch.common.collect.Tuple;  
 */  
        synchronized (this) {
                runOnce.run();  
        assert refreshListeners == null;
    private final Runnable forceRefresh;  
        List<Tuple<Translog.Location, Consumer<Boolean>>> oldListeners;  
     */  
        // No free slot so force a refresh and call the listener in this thread
                }  
 *
                        listenersToFire.addAll(preservedListeners);  
         * position will introduce a race between adding the listener and the position check. We could work around this by moving this
        synchronized (this) {
     * forces a refresh and calls the listener immediately as well.
                }
            List<Tuple<Translog.Location, Consumer<Boolean>>> listeners = refreshListeners;  
    public void setCurrentRefreshLocationSupplier(Supplier<Translog.Location> currentRefreshLocationSupplier) {
                        listener.accept(forced);
        requireNonNull(location, "location cannot be null");
            }  
            if (candidates == null) {
            // Location already visible, just call the listener
                        refreshListeners = preservedListeners;
        }
            }
        final ThreadContext threadContext,
     * @param location the location to listen for  
        if (listenersToFire != null) {  
 * SPDX-License-Identifier: Apache-2.0
         * newly registered listener. If we're not closed we just add the listeners to the list of listeners we check next time. If we are  
                } catch (final Exception e) {
            synchronized (RefreshListeners.this) {  
import java.util.function.IntSupplier;  
        listener.accept(true);  
                    assert closed == false : "Can't be closed and have non-null refreshListeners";
     * Snapshot of the translog location before the current refresh if there is a refresh going on or null. Doesn't have to be volatile  
    private long currentRefreshStartTime;
 * the Apache License, Version 2.0 (the "License"); you may
        /* Now deal with the listeners that it isn't time yet to fire. We need to do this under lock so we don't miss a concurrent close or
        }
        /* We intentionally ignore didRefresh here because our timing is a little off. It'd be a useful flag if we knew everything that made
/*  
    private int refreshForcers;
 * The OpenSearch Contributors require contributions made to  
            refreshListeners = null;
}
        // Iterate the list of listeners, copying the listeners to fire to one list and those to preserve to another list.  
                    }
                refreshListeners = listeners;  
            refreshListeners = null;  
 * compatible open source license.
         * refresh that has already passed is just a volatile read but the cost is that any check whether or not we've advanced the
     */  
 * Licensed to Elasticsearch under one or more contributor  
                    } else {
 * Allows for the registration of listeners that are called when a change becomes visible for search. This functionality is exposed from  
/*  
         * it into the refresh, but the way we snapshot the translog position before the refresh, things can sneak into the refresh that we  
         * position here because we set and read lastRefreshedLocation outside of a synchronized block. We do that so that waiting for a  
import org.opensearch.common.lease.Releasable;
        requireNonNull(listener, "listener cannot be null");  
            return;
    /**
    /**  
         * don't know about. */
    private final IntSupplier getMaxRefreshListeners;
                    listener.v2().accept(false);  
        }  
            return true;  
 * this work for additional information regarding copyright
            }  
        synchronized (this) {
                    listenersToFire = new ArrayList<>();
/*
            refreshForcers += 1;  
        return true;
            assert refreshForcers >= 0;
    public void close() throws IOException {
                if (preservedListeners == null) {
 * not use this file except in compliance with the License.
    private final ThreadContext threadContext;
                if (listenersToFire == null) {  
                throw new IllegalStateException("can't wait for refresh on a closed index");
 * <p>
        if (null == currentRefreshLocation) {
    /**
                ThreadContext.StoredContext storedContext = threadContext.newStoredContext(true);  
 *    http://www.apache.org/licenses/LICENSE-2.0
            }
     * from it, rather, it is nulled and rebuilt when needed again. The (hopefully) rare entries that didn't make the current refresh cycle
    }
    private volatile Translog.Location lastRefreshedLocation;
    /**  
            }
        synchronized (this) {
                throw e;
        if (refreshNeeded()) {
            /* The translog had an empty last write location at the start of the refresh so we can't alert anyone to anything. This  
    /**
        // A null list means we haven't accumulated any listeners. Otherwise we need the size.  
    private Translog.Location currentRefreshLocation;  
import org.opensearch.index.translog.Translog;
        final Logger logger,
     */  
 * @opensearch.internal
    private volatile List<Tuple<Translog.Location, Consumer<Boolean>>> refreshListeners = null;
 * this file be licensed under the Apache-2.0 license or a
/**
                if (refreshListeners == null) {
 * specific language governing permissions and limitations
            // No listeners to check so just bail early  
    /**  
        });
    private final MeanMetric refreshMetric;  
        if (preservedListeners != null) {
                refreshForcers -= 1;
                    refreshListeners.addAll(preservedListeners);  
 *
     * because when it is used by the refreshing thread.
        final IntSupplier getMaxRefreshListeners,
        List<Tuple<Translog.Location, Consumer<Boolean>>> listeners = refreshListeners;
     */  
     *        false otherwise.
    private volatile boolean closed = false;
    private final Logger logger;
            }
                if (listeners == null) {
         * around with refreshListeners or synchronizing at all. Note that it is not safe for us to abort early if we haven't advanced the
                } else {
 * You may obtain a copy of the License at  
     * @return did we call the listener (true) or register the listener to call later (false)?  
import org.opensearch.common.metrics.MeanMetric;
    public boolean addOrNotify(Translog.Location location, Consumer<Boolean> listener) {
