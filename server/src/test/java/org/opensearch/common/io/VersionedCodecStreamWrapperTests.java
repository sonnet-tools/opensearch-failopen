/*  
    public void testReadWithNewVersionThrowsException() throws IOException {
public class VersionedCodecStreamWrapperTests extends OpenSearchTestCase {
        DummyObject expectedObject = new DummyObject("test read");  
            IndexFormatTooOldException.class,  
    public void testWriteStream() throws IOException {  
    IndexIOStreamHandlerFactory<DummyObject> ioStreamHandlerFactory;
    public void testReadWithUnexpectedCodecThrowsException() throws IOException {  
            () -> versionedCodecStreamWrapper.readStream(createHeaderFooterBytes(CODEC, 0, true, true))
    }  
 */  
        assertThrows(  
            () -> versionedCodecStreamWrapper.readStream(createHeaderFooterBytes("wrong codec", VERSION, false, true))
            dummyString = dummy;
        DummyObject expectedObject = new DummyObject("test read");
import org.apache.lucene.codecs.CodecUtil;
 * this file be licensed under the Apache-2.0 license or a
    }
import org.apache.lucene.index.IndexFormatTooOldException;
        return new ByteArrayIndexInput("dummy bytes", BytesReference.toBytes(output.bytes()));
            CorruptIndexException.class,  
        DummyObject expectedObject = new DummyObject("test read");  
import org.apache.lucene.store.BufferedChecksumIndexInput;
        DummyObject expectedObject = new DummyObject("test read");  
    public void testReadWithNoFooterThrowsException() throws IOException {
import org.opensearch.core.common.bytes.BytesReference;
        when(ioStreamHandler.readContent(any())).thenReturn(expectedObject);  
        OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096);
            CodecUtil.writeHeader(indexOutput, codec, version);
        }
        BufferedChecksumIndexInput bii = new BufferedChecksumIndexInput(indexInput);
    private static final String CODEC = "dummycodec";  
        indexOutput.close();  
        when(ioStreamHandler.readContent(any())).thenReturn(expectedObject);
    public void testReadWithOldVersionThrowsException() throws IOException {
            IndexFormatTooNewException.class,
        doAnswer(invocation -> {
 * compatible open source license.
        when(ioStreamHandlerFactory.getHandler(VERSION)).thenReturn(ioStreamHandler);
    @Before
    public void setup() throws IOException {
import org.opensearch.test.OpenSearchTestCase;  
        DummyObject expectedObject = new DummyObject("test read");
        BytesStreamOutput output = new BytesStreamOutput();
import org.junit.Before;
        }).when(ioStreamHandler).writeContent(indexOutput, expectedObject);  
    }
        when(ioStreamHandler.readContent(any())).thenReturn(expectedObject);
        assertThrows(  
    }  
            CorruptIndexException.class,
        DummyObject expectedObject = new DummyObject("test read");
        assertEquals(readData, expectedObject);
    }
    IndexIOStreamHandler<DummyObject> ioStreamHandler;  
            IndexOutput io = invocation.getArgument(0);  
        public DummyObject(String dummy) {
    VersionedCodecStreamWrapper<DummyObject> versionedCodecStreamWrapper;
import org.apache.lucene.store.OutputStreamIndexOutput;
import org.apache.lucene.index.CorruptIndexException;
    public void testReadStream() throws IOException {
    private static final int VERSION = 1;
        assertThrows(
import java.io.IOException;  
            () -> versionedCodecStreamWrapper.readStream(createHeaderFooterBytes("wrong codec", VERSION, true, false))
        assertEquals(bii.readString(), "test write");
        if (writeFooter) {  
 * Unit tests for {@link org.opensearch.common.io.VersionedCodecStreamWrapper}.
import org.opensearch.common.io.stream.BytesStreamOutput;  
        ioStreamHandler = mock(IndexIOStreamHandler.class);
            () -> versionedCodecStreamWrapper.readStream(createHeaderFooterBytes(CODEC, 2, true, true))
        when(ioStreamHandlerFactory.getHandler(VERSION)).thenReturn(ioStreamHandler);  
        when(ioStreamHandler.readContent(any())).thenReturn(expectedObject);
        );  
        CodecUtil.checkFooter(bii);
    }
    }
        }
            io.writeString("test write");
        when(ioStreamHandlerFactory.getHandler(VERSION)).thenReturn(ioStreamHandler);  
 * SPDX-License-Identifier: Apache-2.0
        if (writeHeader) {  
            () -> versionedCodecStreamWrapper.readStream(createHeaderFooterBytes("wrong codec", VERSION, true, true))  
        );
import static org.mockito.ArgumentMatchers.any;
        assertThrows(
        when(ioStreamHandlerFactory.getHandler(VERSION)).thenReturn(ioStreamHandler);
            CodecUtil.writeFooter(indexOutput);
import org.apache.lucene.store.IndexInput;  
    public void testReadWithNoHeaderThrowsException() throws IOException {
    private ByteArrayIndexInput createHeaderFooterBytes(String codec, int version, boolean writeHeader, boolean writeFooter)
        CodecUtil.checkHeader(bii, CODEC, VERSION, VERSION);  
import org.apache.lucene.store.IndexOutput;
        );  
    }
/**
        when(ioStreamHandlerFactory.getHandler(VERSION)).thenReturn(ioStreamHandler);
        throws IOException {  
            return null;
        OutputStreamIndexOutput indexOutput = new OutputStreamIndexOutput("dummy bytes", "dummy stream", output, 4096);  
        }  
import static org.mockito.Mockito.mock;
        when(ioStreamHandler.readContent(any())).thenReturn(expectedObject);
import org.apache.lucene.index.IndexFormatTooNewException;  
        assertThrows(
        ioStreamHandlerFactory = mock(IndexIOStreamHandlerFactory.class);  
import static org.mockito.Mockito.doAnswer;  
            CorruptIndexException.class,
        when(ioStreamHandlerFactory.getHandler(VERSION)).thenReturn(ioStreamHandler);
    private static class DummyObject {
        indexOutput.close();
        DummyObject readData = versionedCodecStreamWrapper.readStream(createHeaderFooterBytes(CODEC, VERSION, true, true));  
        when(ioStreamHandlerFactory.getHandler(VERSION)).thenReturn(ioStreamHandler);
        );
import org.opensearch.common.lucene.store.ByteArrayIndexInput;
}
        BytesStreamOutput output = new BytesStreamOutput();
 * The OpenSearch Contributors require contributions made to  
package org.opensearch.common.io;
        );
import static org.mockito.Mockito.when;
        private static String dummyString;
        IndexInput indexInput = new ByteArrayIndexInput("dummy bytes", BytesReference.toBytes(output.bytes()));  
 */  
    }  
        DummyObject expectedObject = new DummyObject("test read");
        when(ioStreamHandler.readContent(any())).thenReturn(expectedObject);
 *
        versionedCodecStreamWrapper = new VersionedCodecStreamWrapper(ioStreamHandlerFactory, VERSION, VERSION, CODEC);
        versionedCodecStreamWrapper.writeStream(indexOutput, expectedObject);
    }  
