 * Modifications Copyright OpenSearch Contributors. See
            if (mockContext.random.nextBoolean()) {
     * slow if {@link AssertingDirectoryReader} is used.
                return CloseAction.CLOSE;
                return CloseAction.FLUSH_AND_CLOSE;
        this.inFlightSearchers = new InFlightSearchers();
    public MockEngineSupport(EngineConfig config, Class<? extends FilterDirectoryReader> wrapper) {
            throw new OpenSearchException("Can not wrap reader", e);
        }
 * Unless required by applicable law or agreed to in writing,
        return wrappedReader;
                        + "]";
import java.lang.reflect.Constructor;
                        + " closed. Initial refCount was: ["
            this.wrapper = wrapper;
 * Support class to build MockEngines like {@link MockInternalEngine}
         * only do the random thing if we are the first call to this since
        }
     */
            Constructor<?> nonRandom = null;
            if (openSearchers.isEmpty() == false) {
    }
        private final int initialRefCount;
import org.opensearch.common.settings.Setting.Property;
            }
        if (closing.compareAndSet(false, true)) {
         */
 * ownership. Elasticsearch licenses this file to you under
            initialRefCount = searcher.getIndexReader().getRefCount();
    }
        "index.engine.mock.random.wrap_reader_ratio",
 */
                Class<?>[] parameterTypes = constructor.getParameterTypes();
     * is disabled by default ie. {@code 0.0d} since reader wrapping is insanely
                     * this assert seems to be paranoid but given LUCENE-5362 we
                if (parameterTypes.length > 0 && parameterTypes[0] == DirectoryReader.class) {
        "index.mock.disable_flush_on_close",
        this.disableFlushOnClose = DISABLE_FLUSH_ON_CLOSE.get(settings);
        } else {
        public synchronized void close() {
 */
         * early. - good news, stuff will fail all over the place if we don't
 * compatible open source license.
    private final MockContext mockContext;
     */
        void add(Object key, String source) {
import org.opensearch.index.engine.EngineConfig;
import java.io.IOException;
        SearcherCloseable closeable = new SearcherCloseable(searcher, logger, inFlightSearchers);
        /*
                    throw error;
                        + refCount
                openSearchers.put(key, ex);
                for (RuntimeException ex : openSearchers.values()) {
import org.apache.lucene.index.IndexReader;
        Settings settings = config.getIndexSettings().getSettings();
        return disableFlushOnClose;
 */
    /**
    public static final Setting<Double> WRAP_READER_RATIO = Setting.doubleSetting(
            synchronized (lock) {
        private final AtomicBoolean closed = new AtomicBoolean(false);
 *
        shardId = config.getShardId();
            } else {
            wrappedReader = wrapReader((DirectoryReader) reader);
        private final Engine.Searcher searcher;
    private DirectoryReader wrapReader(DirectoryReader reader) {
                        + initialRefCount
        Property.IndexScope
                        + "] expected a value > [0] - reader is already "
 * You may obtain a copy of the License at
            final RuntimeException ex = new RuntimeException("Unreleased Searcher, source [" + source + "]");
        SearcherCloseable(final Engine.Searcher searcher, Logger logger, InFlightSearchers inFlightSearchers) {
    /**
            reader,
 * not use this file except in compliance with the License.
     * the first call and treats subsequent calls as if the engine passed is already closed.
            this.subReaderWrapper = subReaderWrapper;
        private final Class<? extends FilterDirectoryReader> wrapper;
        private RuntimeException firstReleaseStack;
                    final int refCount = searcher.getIndexReader().getRefCount();
        final long seed = config.getIndexSettings().getValue(OpenSearchIntegTestCase.INDEX_TEST_SEED_SETTING);
            synchronized (this) {
            for (Constructor<?> constructor : constructors) {
 * the Apache License, Version 2.0 (the "License"); you may
                    try {
import org.opensearch.common.settings.Setting;
 *
         * to the manager on release otherwise the reader will be closed too
         */
        private final IdentityHashMap<Object, RuntimeException> openSearchers = new IdentityHashMap<>();
 *     http://www.apache.org/licenses/LICENSE-2.0
        final IndexReader reader = newReader(searcher.getIndexReader());
        IndexReader wrappedReader = reader;
            this.inFlightSearchers = inFlightSearchers;
            Constructor<?>[] constructors = mockContext.wrapper.getConstructors();
            logger.trace("Using [{}] for shard [{}] seed: [{}] wrapReader: [{}]", this.getClass().getName(), shardId, seed, wrapReader);
 * this work for additional information regarding copyright
                if (closed.compareAndSet(false, true)) {
         * make sure this is the searcher that will be released later on.
                        searcher.close();
        protected final SubReaderWrapper subReaderWrapper;
        return new Engine.Searcher(
         * pass the original searcher to the super.newSearcher() method to
    );
                } else {
            openSearchers.remove(key);
            searcher.getQueryCache(),
import org.apache.lucene.tests.index.AssertingDirectoryReader;
        Property.IndexScope
    }
/*
                        nonRandom = constructor;
 * SPDX-License-Identifier: Apache-2.0
 *
                throw error;
                }
        }
        private final Logger logger;
                    error.initCause(firstReleaseStack);
            inFlightSearchers.add(this, searcher.source());
        }
        }
            searcher.source(),
                }
        0.0d,
        }
        CLOSE;
    private final boolean disableFlushOnClose;
    }
            searcher.getSimilarity(),
                return (DirectoryReader) nonRandom.newInstance(reader);
    public Engine.Searcher wrapSearcher(Engine.Searcher searcher) {
                    assert refCount > 0 : "IndexReader#getRefCount() was ["
import org.opensearch.index.engine.EngineException;
                        return (DirectoryReader) constructor.newInstance(reader, mockContext.indexSettings);
public final class MockEngineSupport {
        private final Settings indexSettings;
            this.searcher = searcher;
        mockContext = new MockContext(random, wrapReader, wrapper, settings);
        private final Object lock = new Object();
                        logger.debug("Failed to release searcher", ex);
            }
         * up with a stackoverflow.
            this.indexSettings = indexSettings;
            this.random = random;
        FLUSH_AND_CLOSE,
import org.opensearch.common.settings.Settings;
 * Licensed to Elasticsearch under one or more contributor
 * The OpenSearch Contributors require contributions made to
    public IndexReader newReader(IndexReader reader) throws EngineException {
import java.util.IdentityHashMap;
    private static final class InFlightSearchers implements Closeable {
        if (reader instanceof DirectoryReader && mockContext.wrapReader) {
 */
                     * potential problems.
 * under the License.
                + "] expected a value > [0] - reader is already closed";
            }
            }
                    AssertionError error = new AssertionError("Released Searcher more than once, source [" + searcher.source() + "]");
        }
    public CloseAction flushOrClose(CloseAction originalAction) throws IOException {
import org.apache.lucene.tests.util.LuceneTestCase;
        }
            assert initialRefCount > 0 : "IndexReader#getRefCount() was ["
        0.0d,
        private final Random random;
    public static class MockContext {
                    inFlightSearchers.remove(this);
import org.opensearch.OpenSearchException;
 * software distributed under the License is distributed on an
    public boolean isFlushOnCloseDisabled() {
        /*
                AssertionError error = new AssertionError("Unreleased searchers found");
    enum CloseAction {
        false,
     * Allows tests to wrap an index reader randomly with a given ratio. This
    private static final class SearcherCloseable implements Closeable {
        try {
            super(in, subReaderWrapper);
 * license agreements. See the NOTICE file distributed with
        public DirectoryReaderWrapper(DirectoryReader in, SubReaderWrapper subReaderWrapper) throws IOException {
                     */
                    } catch (RuntimeException ex) {
        boolean wrapReader = random.nextDouble() < ratio;
import org.opensearch.test.OpenSearchIntegTestCase;
import java.util.Random;
        }
    }
     */
import java.util.concurrent.atomic.AtomicBoolean;
package org.opensearch.test.engine;
 * specific language governing permissions and limitations
import java.io.Closeable;
                    if (parameterTypes.length == 1) {
        } catch (Exception e) {
        private final boolean wrapReader;
                     * better add some assertions here to make sure we catch any
 * KIND, either express or implied.  See the License for the
        assert reader != null;
    }
                    /*
            }
 * since they need to subclass the actual engine
    }
import org.apache.logging.log4j.Logger;
                }
 * this file be licensed under the Apache-2.0 license or a
            this.wrapReader = wrapReader;
        if (logger.isTraceEnabled()) {
    public static final Setting<Boolean> DISABLE_FLUSH_ON_CLOSE = Setting.boolSetting(
/*
        }
            return originalAction;
        public void close() {
/**
        Random random = new Random(seed);
        synchronized void remove(Object key) {
import org.opensearch.core.index.shard.ShardId;
            searcher.getQueryCachingPolicy(),
                    } else if (parameterTypes.length == 2 && parameterTypes[1] == Settings.class) {
         * super.flushOnClose() calls #close() again and then we might end
    /**
                    }
import org.apache.lucene.index.FilterDirectoryReader;
         * get this right here
    private final InFlightSearchers inFlightSearchers;
        public MockContext(Random random, boolean wrapReader, Class<? extends FilterDirectoryReader> wrapper, Settings indexSettings) {
}
        final double ratio = WRAP_READER_RATIO.get(settings);
        private final InFlightSearchers inFlightSearchers;
     * Allows tests to prevent an engine from being flushed on close ie. to test translog recovery...
                    firstReleaseStack = new RuntimeException();
            closeable
            if (nonRandom != null) {
        @Override
                        throw ex;
        LuceneTestCase.closeAfterSuite(inFlightSearchers); // only one suite closeable per Engine
    );
            }
import org.opensearch.index.engine.Engine;
        }
                    }
    private final Logger logger = LogManager.getLogger(Engine.class);
import org.apache.logging.log4j.LogManager;
            this.logger = logger;
    }
 * GitHub history for details.
    private final AtomicBoolean closing = new AtomicBoolean(false);
        @Override
        return reader;
         * If we wrap an index reader here must not pass the wrapped version
     * Returns the CloseAction to execute on the actual engine. Note this method changes the state on
                    error.addSuppressed(ex);
import org.apache.lucene.index.DirectoryReader;
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
    }
                + initialRefCount
    }
/*
    private final ShardId shardId;
    }
        );
    public abstract static class DirectoryReaderWrapper extends FilterDirectoryReader {
