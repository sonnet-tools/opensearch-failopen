            this.subReaderWrapper = subReaderWrapper;
    private static final class InFlightSearchers implements Closeable {
import org.opensearch.OpenSearchException;
        this.disableFlushOnClose = DISABLE_FLUSH_ON_CLOSE.get(settings);
        0.0d,
                AssertionError error = new AssertionError("Unreleased searchers found");  
        }
            synchronized (this) {
            openSearchers.remove(key);
    private final MockContext mockContext;  
         * make sure this is the searcher that will be released later on.  
/**  
                    final int refCount = searcher.getIndexReader().getRefCount();
                     * this assert seems to be paranoid but given LUCENE-5362 we  
 * under the License.  
            inFlightSearchers.add(this, searcher.source());
        }  
 * You may obtain a copy of the License at  
/*
    );
    /**
        );
public final class MockEngineSupport {
            }
import org.apache.lucene.tests.index.AssertingDirectoryReader;
            }  
                    if (parameterTypes.length == 1) {
        @Override  
                    AssertionError error = new AssertionError("Released Searcher more than once, source [" + searcher.source() + "]");
        @Override
    }
                        throw ex;
 * the Apache License, Version 2.0 (the "License"); you may
            final RuntimeException ex = new RuntimeException("Unreleased Searcher, source [" + source + "]");  
         */  
        return new Engine.Searcher(
            initialRefCount = searcher.getIndexReader().getRefCount();
        final double ratio = WRAP_READER_RATIO.get(settings);
                    }  
        } else {
 *
        if (logger.isTraceEnabled()) {
     * Returns the CloseAction to execute on the actual engine. Note this method changes the state on
 * Unless required by applicable law or agreed to in writing,
    private DirectoryReader wrapReader(DirectoryReader reader) {  
        private final Class<? extends FilterDirectoryReader> wrapper;
        final IndexReader reader = newReader(searcher.getIndexReader());
        }
        SearcherCloseable closeable = new SearcherCloseable(searcher, logger, inFlightSearchers);  
         * super.flushOnClose() calls #close() again and then we might end
 * SPDX-License-Identifier: Apache-2.0
            }  
        shardId = config.getShardId();
                        + "] expected a value > [0] - reader is already "  
            this.logger = logger;
                + "] expected a value > [0] - reader is already closed";  
            return originalAction;
 * compatible open source license.
import org.opensearch.core.index.shard.ShardId;
    /**  
import org.apache.lucene.index.FilterDirectoryReader;  
                } else {
        private final AtomicBoolean closed = new AtomicBoolean(false);  
    }
         */
import org.opensearch.test.OpenSearchIntegTestCase;  
                Class<?>[] parameterTypes = constructor.getParameterTypes();
/*
            super(in, subReaderWrapper);
            Constructor<?>[] constructors = mockContext.wrapper.getConstructors();
package org.opensearch.test.engine;
        private final boolean wrapReader;  
                + initialRefCount
                    /*
        }
import org.apache.lucene.index.DirectoryReader;
import org.apache.logging.log4j.Logger;
        }  
/*  
        public MockContext(Random random, boolean wrapReader, Class<? extends FilterDirectoryReader> wrapper, Settings indexSettings) {
            }
    public MockEngineSupport(EngineConfig config, Class<? extends FilterDirectoryReader> wrapper) {  
        public synchronized void close() {
                    assert refCount > 0 : "IndexReader#getRefCount() was ["
     * Allows tests to prevent an engine from being flushed on close ie. to test translog recovery...  
import java.util.concurrent.atomic.AtomicBoolean;
    enum CloseAction {
    }
         * get this right here
    public abstract static class DirectoryReaderWrapper extends FilterDirectoryReader {  
    }
 * KIND, either express or implied.  See the License for the
    public IndexReader newReader(IndexReader reader) throws EngineException {  
    public CloseAction flushOrClose(CloseAction originalAction) throws IOException {
import org.apache.logging.log4j.LogManager;  
         * If we wrap an index reader here must not pass the wrapped version
        }
                        nonRandom = constructor;
        this.inFlightSearchers = new InFlightSearchers();
                        + refCount
        SearcherCloseable(final Engine.Searcher searcher, Logger logger, InFlightSearchers inFlightSearchers) {
            assert initialRefCount > 0 : "IndexReader#getRefCount() was ["
        try {
import java.util.Random;  
            searcher.source(),
    }
                for (RuntimeException ex : openSearchers.values()) {
            wrappedReader = wrapReader((DirectoryReader) reader);
            Constructor<?> nonRandom = null;  
        "index.mock.disable_flush_on_close",  
        private final int initialRefCount;
        return disableFlushOnClose;
 * this file be licensed under the Apache-2.0 license or a
        }
    public boolean isFlushOnCloseDisabled() {  
            } else {
                openSearchers.put(key, ex);
 * Support class to build MockEngines like {@link MockInternalEngine}
    private static final class SearcherCloseable implements Closeable {
 * this work for additional information regarding copyright
                        searcher.close();
                        + " closed. Initial refCount was: ["
        private final Logger logger;
            searcher.getSimilarity(),
import java.util.IdentityHashMap;
                    }  
            logger.trace("Using [{}] for shard [{}] seed: [{}] wrapReader: [{}]", this.getClass().getName(), shardId, seed, wrapReader);
                }
         * to the manager on release otherwise the reader will be closed too
    }
        /*
            }
        private final InFlightSearchers inFlightSearchers;
        mockContext = new MockContext(random, wrapReader, wrapper, settings);
                     * potential problems.
 */
         * pass the original searcher to the super.newSearcher() method to
import java.io.IOException;  
                if (closed.compareAndSet(false, true)) {
            searcher.getQueryCache(),
                     */  
                return CloseAction.CLOSE;
                if (parameterTypes.length > 0 && parameterTypes[0] == DirectoryReader.class) {  
import org.apache.lucene.tests.util.LuceneTestCase;  
import org.opensearch.common.settings.Setting;
import org.opensearch.index.engine.Engine;  
     * the first call and treats subsequent calls as if the engine passed is already closed.
        if (reader instanceof DirectoryReader && mockContext.wrapReader) {  
                        + "]";  
import org.opensearch.common.settings.Setting.Property;  
    private final AtomicBoolean closing = new AtomicBoolean(false);
                    inFlightSearchers.remove(this);
     */
                    } else if (parameterTypes.length == 2 && parameterTypes[1] == Settings.class) {  
    private final ShardId shardId;
 * not use this file except in compliance with the License.
    }
                }
            synchronized (lock) {  
        false,
     */
            reader,  
    }  
        private RuntimeException firstReleaseStack;
                    error.addSuppressed(ex);
 * The OpenSearch Contributors require contributions made to  
    public static final Setting<Boolean> DISABLE_FLUSH_ON_CLOSE = Setting.boolSetting(
        return wrappedReader;  
                throw error;
import java.lang.reflect.Constructor;
    }
     * slow if {@link AssertingDirectoryReader} is used.  
                return (DirectoryReader) nonRandom.newInstance(reader);
 * since they need to subclass the actual engine
            this.wrapper = wrapper;
    private final boolean disableFlushOnClose;
import org.opensearch.common.settings.Settings;
        public DirectoryReaderWrapper(DirectoryReader in, SubReaderWrapper subReaderWrapper) throws IOException {  
        private final Engine.Searcher searcher;  
        final long seed = config.getIndexSettings().getValue(OpenSearchIntegTestCase.INDEX_TEST_SEED_SETTING);  
            searcher.getQueryCachingPolicy(),  
 *  
    private final InFlightSearchers inFlightSearchers;
        0.0d,
            this.indexSettings = indexSettings;
        /*
            for (Constructor<?> constructor : constructors) {
     */  
                    throw error;
                    } catch (RuntimeException ex) {  
import org.opensearch.index.engine.EngineConfig;
                     * better add some assertions here to make sure we catch any
        private final Random random;
                return CloseAction.FLUSH_AND_CLOSE;  
                        logger.debug("Failed to release searcher", ex);
        private final Object lock = new Object();  
    }  
 * license agreements. See the NOTICE file distributed with
            this.random = random;
        private final IdentityHashMap<Object, RuntimeException> openSearchers = new IdentityHashMap<>();
    private final Logger logger = LogManager.getLogger(Engine.class);  
        }
                    try {
import org.opensearch.index.engine.EngineException;
            this.inFlightSearchers = inFlightSearchers;  
        Random random = new Random(seed);
        "index.engine.mock.random.wrap_reader_ratio",  
        } catch (Exception e) {  
}  
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY  
 * specific language governing permissions and limitations
 */  
            if (nonRandom != null) {  
     * Allows tests to wrap an index reader randomly with a given ratio. This
 * software distributed under the License is distributed on an
    }
         * early. - good news, stuff will fail all over the place if we don't  
            this.searcher = searcher;  
            throw new OpenSearchException("Can not wrap reader", e);
            closeable
            this.wrapReader = wrapReader;  
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 */  
        CLOSE;  
        Settings settings = config.getIndexSettings().getSettings();
        Property.IndexScope
                        return (DirectoryReader) constructor.newInstance(reader, mockContext.indexSettings);
                }  
        Property.IndexScope  
         * up with a stackoverflow.
     * is disabled by default ie. {@code 0.0d} since reader wrapping is insanely
        FLUSH_AND_CLOSE,
            if (mockContext.random.nextBoolean()) {
 * Licensed to Elasticsearch under one or more contributor  
        synchronized void remove(Object key) {  
        IndexReader wrappedReader = reader;
 * ownership. Elasticsearch licenses this file to you under  
        protected final SubReaderWrapper subReaderWrapper;
 * Modifications Copyright OpenSearch Contributors. See  
    public static class MockContext {
    public static final Setting<Double> WRAP_READER_RATIO = Setting.doubleSetting(
        boolean wrapReader = random.nextDouble() < ratio;  
        if (closing.compareAndSet(false, true)) {
                        + initialRefCount
        assert reader != null;
        public void close() {
        }  
    public Engine.Searcher wrapSearcher(Engine.Searcher searcher) {
        LuceneTestCase.closeAfterSuite(inFlightSearchers); // only one suite closeable per Engine  
    /**  
            }  
        }  
         * only do the random thing if we are the first call to this since  
        return reader;  
 * GitHub history for details.
    );  
                    error.initCause(firstReleaseStack);  
import java.io.Closeable;
        void add(Object key, String source) {
 */
        private final Settings indexSettings;
            if (openSearchers.isEmpty() == false) {
import org.apache.lucene.index.IndexReader;
                    firstReleaseStack = new RuntimeException();  
        }  
