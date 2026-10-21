            }
     * Snapshot of the translog location before the current refresh if there is a refresh going on or null. Doesn't have to be volatile
                    if (closed) {
                if (listenersToFire == null) {
        }
 */
    }
        requireNonNull(listener, "listener cannot be null");
    /**
        this.refreshMetric = refreshMetric;
            refreshListeners = null;
         * newly registered listener. If we're not closed we just add the listeners to the list of listeners we check next time. If we are
        for (Tuple<Translog.Location, Consumer<Boolean>> tuple : candidates) {
            if (refreshForcers == 0 && maxRefreshes > 0 && (listeners == null || listeners.size() < maxRefreshes)) {
     * @param listener for the refresh. Called with true if registering the listener ran it out of slots and forced a refresh. Called with
        this.forceRefresh = forceRefresh;
import org.opensearch.common.lease.Releasable;
        currentRefreshLocation = currentRefreshLocationSupplier.get();
         * refresh that has already passed is just a volatile read but the cost is that any check whether or not we've advanced the
        });
                refreshListeners = listeners;
    /**
            if (closed) {
            } else {
        // A null list means we haven't accumulated any listeners. Otherwise we need the size.
import java.util.function.Consumer;
 * When {@link Closeable#close()}d it will no longer accept listeners and flush any existing listeners.
        List<Tuple<Translog.Location, Consumer<Boolean>>> listenersToFire = null;
        }
     * Add a listener for refreshes, calling it immediately if the location is already visible. If this runs out of listener slots then it
        forceRefresh.run();
            Translog.Location location = tuple.v1();
 * SPDX-License-Identifier: Apache-2.0
                        listenersToFire.addAll(preservedListeners);
 * {@link IndexShard} but kept here so it can be tested without standing up the entire thing.
            return;
     */
                if (preservedListeners == null) {
    /**
         * in the list we iterate over and very likely won't be candidates for refresh anyway because we've already moved the
        synchronized (this) {
                        storedContext.restore();
    /**
    private int refreshForcers;
         * lastRefreshedLocation. */
     * Force-refreshes new refresh listeners that are added while {@code >= 0}. Used to prevent becoming blocked on operations waiting for
    }
        return listeners == null ? 0 : listeners.size();
}
 * this file be licensed under the Apache-2.0 license or a
        assert refreshListeners == null;
        }
     */
 */
     * because when it is used by the refreshing thread.
        requireNonNull(location, "location cannot be null");
     * Time in nanosecond when beforeRefresh() is called. Used for calculating refresh metrics.
        }
    }
 * @opensearch.internal
     * Setup the translog used to find the last refreshed location.
        fireListeners(oldListeners);
        if (lastRefreshedLocation != null && lastRefreshedLocation.compareTo(location) >= 0) {
            synchronized (this) {
                listenersToFire.add(tuple);
        return true;
                return;
        }
                    }
     * The translog location that was last made visible by a refresh.
        this.threadContext = threadContext;
        listener.accept(true);
                        listener.accept(forced);
        fireListeners(listenersToFire);
        final RunOnce runOnce = new RunOnce(() -> {
                    }
            final int maxRefreshes = getMaxRefreshListeners.getAsInt();
    /**
        /* Now deal with the listeners that it isn't time yet to fire. We need to do this under lock so we don't miss a concurrent close or
        }
 * ownership. Elasticsearch licenses this file to you under
 *
                listeners.add(new Tuple<>(location, contextPreservingListener));
     * We never set this to non-null while closed it {@code true}.
            if (location.compareTo(currentRefreshLocation) <= 0) {
        final Runnable forceRefresh,
     * from it, rather, it is nulled and rebuilt when needed again. The (hopefully) rare entries that didn't make the current refresh cycle
                } catch (final Exception e) {
 *
        // Iterate the list of listeners, copying the listeners to fire to one list and those to preserve to another list.
                refreshForcers -= 1;
    ) {
                }
    @Override
        /* Grab the current refresh listeners and replace them with null while synchronized. Any listeners that come in after this won't be
 * Unless required by applicable law or agreed to in writing,
        if (preservedListeners != null) {
     */
                    refreshListeners.addAll(preservedListeners);
            synchronized (RefreshListeners.this) {
    private volatile boolean closed = false;
/*
     * List of refresh listeners. Defaults to null and built on demand because most refresh cycles won't need it. Entries are never removed
                    preservedListeners = new ArrayList<>();
        final Logger logger,
                    listenersToFire = new ArrayList<>();
        final MeanMetric refreshMetric
            refreshForcers += 1;
            // No listeners to check so just bail early
                    logger.warn("error firing refresh listener", e);
    }
 * this work for additional information regarding copyright
     * refresh during relocation.
            refreshListeners = null;
public final class RefreshListeners implements ReferenceManager.RefreshListener, Closeable {
                runOnce.run();
    private void fireListeners(final List<Tuple<Translog.Location, Consumer<Boolean>>> listenersToFire) {
         * closed we fire the listeners even though it isn't time for them. */
    /**
    public boolean refreshNeeded() {
     */
 * You may obtain a copy of the License at
package org.opensearch.index.shard;
    }
        /* Set the lastRefreshedLocation so listeners that come in for locations before that will just execute inline without messing
     */
            oldListeners = refreshListeners;
        if (null == currentRefreshLocation) {
/**
    /**
        synchronized (this) {
                try {
    public int pendingCount() {
                throw new IllegalStateException("can't wait for refresh on a closed index");
     * are just added back to the new list. Both the reference and the contents are always modified while synchronized on {@code this}.
import java.io.IOException;
            }
    private final Logger logger;
                    listeners = new ArrayList<>();
 *    http://www.apache.org/licenses/LICENSE-2.0
        // A null list doesn't need a refresh. If we're closed we don't need a refresh either.
        // Lastly, fire the listeners that are ready
                forceRefresh.run();
    private volatile Translog.Location lastRefreshedLocation;
    /**
import java.util.function.IntSupplier;
        // No need to synchronize here because we're doing a single volatile read
            }
        }
 * specific language governing permissions and limitations
         * assignment into the synchronized block below and double checking lastRefreshedLocation in addOrNotify's synchronized block but
    private long currentRefreshStartTime;
     */
        currentRefreshStartTime = System.nanoTime();
     */
                    try (ThreadContext.StoredContext ignore = threadContext.stashContext()) {
 * license agreements. See the NOTICE file distributed with
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    private final ThreadContext threadContext;
                    listener.v2().accept(false);
    /**
            }
    public RefreshListeners(
     * Force-refreshes newly added listeners and forces a refresh if there are currently listeners registered. See {@link #refreshForcers}.
import static java.util.Objects.requireNonNull;
import org.opensearch.index.translog.Translog;
import java.io.Closeable;
            listener.accept(false);
        List<Tuple<Translog.Location, Consumer<Boolean>>> candidates;
    }
     */
     * The number of pending listeners.
    private Translog.Location currentRefreshLocation;
    public void beforeRefresh() throws IOException {
             * usually happens during recovery. The next refresh cycle out to pick up this refresh. */
 * the Apache License, Version 2.0 (the "License"); you may
    }
import java.util.ArrayList;
            return true;
            }
import org.opensearch.common.collect.Tuple;
        if (listenersToFire != null) {
        final IntSupplier getMaxRefreshListeners,
 * compatible open source license.
            List<Tuple<Translog.Location, Consumer<Boolean>>> listeners = refreshListeners;
        }
                if (refreshListeners == null) {
    /**
 * Allows for the registration of listeners that are called when a change becomes visible for search. This functionality is exposed from
                return false;
     */
            } catch (Exception e) {
/*
    private final IntSupplier getMaxRefreshListeners;
            }
     * @param location the location to listen for
    private final MeanMetric refreshMetric;
    public void afterRefresh(boolean didRefresh) throws IOException {
        synchronized (this) {
    }
import org.apache.lucene.search.ReferenceManager;
         * position here because we set and read lastRefreshedLocation outside of a synchronized block. We do that so that waiting for a
 * <p>
         * don't know about. */
        lastRefreshedLocation = currentRefreshLocation;
 * under the License.
        // Fire any listeners we might have had
         * that doesn't seem worth it given that we already skip this process early if there aren't any listeners to iterate. */
         * position will introduce a race between adding the listener and the position check. We could work around this by moving this
        this.getMaxRefreshListeners = getMaxRefreshListeners;
                };
        }
import java.util.List;
 *
        /* We intentionally ignore didRefresh here because our timing is a little off. It'd be a useful flag if we knew everything that made
 *
/*
     * Fire some listeners. Does nothing if the list of listeners is null.
                        refreshListeners = preservedListeners;
    @Override
         * it into the refresh, but the way we snapshot the translog position before the refresh, things can sneak into the refresh that we
            // Location already visible, just call the listener
 * not use this file except in compliance with the License.
        // No free slot so force a refresh and call the listener in this thread
                } else {
 * Modifications Copyright OpenSearch Contributors. See
                if (listeners == null) {
                    assert closed == false : "Can't be closed and have non-null refreshListeners";
import org.apache.logging.log4j.Logger;
    /**
                Consumer<Boolean> contextPreservingListener = forced -> {
        List<Tuple<Translog.Location, Consumer<Boolean>>> oldListeners;
                    } else {
            }
     * <p>
                // We have a free slot so register the listener
            /* The translog had an empty last write location at the start of the refresh so we can't alert anyone to anything. This
    private Supplier<Translog.Location> currentRefreshLocationSupplier;
            }
                }
     * @return did we call the listener (true) or register the listener to call later (false)?
    public Releasable forceRefreshes() {
    }
            for (final Tuple<Translog.Location, Consumer<Boolean>> listener : listenersToFire) {
     *        false otherwise.
            candidates = refreshListeners;
         * around with refreshListeners or synchronizing at all. Note that it is not safe for us to abort early if we haven't advanced the
        synchronized (this) {
import org.opensearch.common.util.concurrent.ThreadContext;
 */
                ThreadContext.StoredContext storedContext = threadContext.newStoredContext(true);
            if (candidates == null) {
    public void close() throws IOException {
        if (refreshNeeded()) {
     * forces a refresh and calls the listener immediately as well.
                }
 * The OpenSearch Contributors require contributions made to
     */
                }
 * Licensed to Elasticsearch under one or more contributor
    public boolean addOrNotify(Translog.Location location, Consumer<Boolean> listener) {
import org.opensearch.common.util.concurrent.RunOnce;
        List<Tuple<Translog.Location, Consumer<Boolean>>> preservedListeners = null;
        this.currentRefreshLocationSupplier = currentRefreshLocationSupplier;
    public void setCurrentRefreshLocationSupplier(Supplier<Translog.Location> currentRefreshLocationSupplier) {
     * Is this closed? If true then we won't add more listeners and have flushed all pending listeners.
    }
        }
import org.opensearch.common.metrics.MeanMetric;
        // Increment refresh metric before communicating to listeners.
 * software distributed under the License is distributed on an
     */
                }
        this.logger = logger;
    private final Runnable forceRefresh;
                assert refreshForcers > 0;
 */
 * GitHub history for details.
        return refreshListeners != null && false == closed;
import java.util.function.Supplier;
    /**
     *
            try {
            assert refreshForcers >= 0;
 * KIND, either express or implied.  See the License for the
        List<Tuple<Translog.Location, Consumer<Boolean>>> listeners = refreshListeners;
                preservedListeners.add(tuple);
    @Override
        final ThreadContext threadContext,
                throw e;
            closed = true;
        refreshMetric.inc(System.nanoTime() - currentRefreshStartTime);
     * Returns true if there are pending listeners.
     */
        return () -> runOnce.run();
    private volatile List<Tuple<Translog.Location, Consumer<Boolean>>> refreshListeners = null;
