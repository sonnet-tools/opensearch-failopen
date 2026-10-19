        // Two phases can hold the context at once; both markInUse calls succeed.
        ReaderContext ctx = new ReaderContext("q1", SHARD_0, gated, 1); // 1ms keepAlive  
        assertTrue("Reusable once both are done", ctx.markInUse());
import org.opensearch.core.index.Index;
 * The OpenSearch Contributors require contributions made to  
        ctx.close();  
        ctx.markInUse();
        Thread.sleep(20);  
    public void testLastAccessTimeUpdatedOnMarkInUse() throws Exception {
    }
        ReaderContext ctx = new ReaderContext("q1", SHARD_0, gated, 30_000);  
    }
    public void testGetQueryId() {  
import java.util.concurrent.atomic.AtomicBoolean;
    }  
        assertTrue("lastAccessTime should advance on markInUse", timeAfterMarkInUse > timeAfterCreate);
        assertTrue("Should expire after keepAlive", ctx.isExpired());
        assertTrue("lastAccessTime should advance on markDone", timeAfterDone > timeAfterMarkInUse);  
        ReaderContext ctx = new ReaderContext("q1", SHARD_0, gated, 50); // 50ms keepAlive
        Reader reader = mock(Reader.class);
        GatedCloseable<Reader> gated = mockGatedReader();
    public void testGetReader() {
import org.opensearch.core.index.shard.ShardId;  
        ReaderContext ctx = new ReaderContext("q1", SHARD_0, gated, 30_000);
        ctx.markDone();
        long timeAfterCreate = ctx.getLastAccessTime();
        ctx.markDone();
        assertTrue(ctx.markInUse());
        GatedCloseable<Reader> gated = new GatedCloseable<>(reader, () -> closed.set(true));  
        // One markDone per markInUse; still in use after the first.
        return new GatedCloseable<>(reader, () -> closed.set(true));  
 * compatible open source license.
        Thread.sleep(20);
        ctx.markInUse();
    }
        Thread.sleep(100);
        GatedCloseable<Reader> gated = mockGatedReader();
        GatedCloseable<Reader> gated = mockGatedReader();
    }
    }
        ctx.markInUse();  
        assertEquals("test-query-123", ctx.getQueryId());
        AtomicBoolean closed = new AtomicBoolean(false);
        assertTrue(ctx.markInUse());  
        GatedCloseable<Reader> gated = mockGatedReader();  
    }
        ReaderContext ctx = new ReaderContext("q1", SHARD_0, gated, 30_000);
        assertFalse("Should not expire before keepAlive", ctx.isExpired());  
        ctx.markDone();
        AtomicBoolean closed = new AtomicBoolean(false);
        ReaderContext ctx = new ReaderContext("q1", SHARD_0, gated, 30_000);
public class ReaderContextTests extends OpenSearchTestCase {
    public void testCloseReleasesReader() throws Exception {  
    public void testMarkInUseIsAdditive() {  
package org.opensearch.analytics.exec;
        ctx.close();
        GatedCloseable<Reader> gated = mockGatedReader();
 */  
    public void testExpiresAfterKeepAlive() throws Exception {  
        assertSame(reader, ctx.getReader());  
import org.opensearch.test.OpenSearchTestCase;
    }  
        ctx.markInUse();
 * SPDX-License-Identifier: Apache-2.0
        ReaderContext ctx = new ReaderContext("q1", SHARD_0, gated, 30_000);
    public void testNotExpiredWhileInUse() {
        GatedCloseable<Reader> gated = new GatedCloseable<>(reader, () -> {});  
        Reader reader = mock(Reader.class);
    }
        GatedCloseable<Reader> gated = mockGatedReader();
 *
        ctx.markDone();  
import org.opensearch.common.concurrent.GatedCloseable;
import org.opensearch.index.engine.exec.IndexReaderProvider.Reader;
        long timeAfterMarkInUse = ctx.getLastAccessTime();  
    public void testMarkInUseAfterCloseReturnsFalse() throws Exception {
        long timeAfterDone = ctx.getLastAccessTime();
    private static final ShardId SHARD_0 = new ShardId(new Index("idx", "uuid"), 0);
        ReaderContext ctx = new ReaderContext("test-query-123", SHARD_0, gated, 30_000);
        ctx.markDone();  
        GatedCloseable<Reader> gated = mockGatedReader();  
import static org.mockito.Mockito.mock;  
        assertFalse("Still in use after one of two done", ctx.isExpired());
        ReaderContext ctx = new ReaderContext("q1", SHARD_0, gated, 30_000);
/*  
 * this file be licensed under the Apache-2.0 license or a
}
    }
    private GatedCloseable<Reader> mockGatedReader() {  
    public void testNotExpiredBeforeKeepAlive() {
        assertFalse("markInUse should fail after close", ctx.markInUse());
        Reader reader = mock(Reader.class);
        assertFalse("Should not expire while in-use", ctx.isExpired());  
        assertTrue("Reader should be closed", closed.get());
