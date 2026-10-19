            assertEquals(-1, in.read(buf, 0, buf.length));
import software.amazon.awssdk.services.s3.model.S3Exception;
                java.net.URI.create("http://minio.example.com:9000"),
package org.opensearch.plugin.hive;
    }
        conf.set("fs.s3a.secret.key", "test-secret");
        assertEquals(1, statuses.length);  
    public void setUp() throws Exception {  
            assertEquals(-1, in.read(10L, buf, 0, buf.length));
                client.serviceClientConfiguration().endpointOverride().orElse(null)
        super.setUp();
        s3Client = mock(S3Client.class);
        }
        assertTrue(status.isDirectory());
            (S3Exception) S3Exception.builder().statusCode(404).message("no such key").build()  
                .build()
            assertEquals(
        conf.set("fs.s3a.path.style.access", "true");
    public void testListStatusStopsWhenTruncatedResponseHasNoToken() throws Exception {  
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenReturn(  
        when(s3Client.listObjectsV2(any(ListObjectsV2Request.class))).thenReturn(ListObjectsV2Response.builder().build());  
            assertEquals(  
    }
        try (FSDataInputStream in = fileSystem.open(new Path("s3://bucket/data/file.parquet"), 4096)) {  
        );
        fileSystem.s3Client = s3Client;
        expectThrows(FileNotFoundException.class, () -> fileSystem.getFileStatus(new Path("s3://bucket/missing/path")));
        verify(s3Client, never()).getObject(any(GetObjectRequest.class));  
            byte[] buf = new byte[4];
    }
import static org.mockito.Mockito.never;
        }
        when(s3Client.listObjectsV2(any(ListObjectsV2Request.class))).thenReturn(  
            );  
    public void testGetFileStatusThrowsFileNotFoundWhenNothingExists() {
            byte[] buf = new byte[8];  
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenReturn(HeadObjectResponse.builder().contentLength(10L).build());
            assertEquals(-1, in.read());
        );
import software.amazon.awssdk.services.s3.model.S3Object;  
    }
        // Broken S3-compatible stores can report isTruncated without a
 * SPDX-License-Identifier: Apache-2.0
        FileStatus status = fileSystem.getFileStatus(new Path("s3://bucket/data/file.parquet"));
    }  
        conf.set("fs.s3a.endpoint.region", "eu-central-1");  
    public void testGetFileStatusReturnsDirectoryWhenPrefixHasObjects() throws Exception {
            );
    public void testGetFileStatusReturnsFileWhenObjectExists() throws Exception {
        try (S3Client client = S3HadoopFileSystem.createS3Client(conf)) {  
    public void testGetFileStatusPropagatesNetworkErrorsAsIOException() {
            (S3Exception) S3Exception.builder().statusCode(403).message("access denied").build()
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenThrow(  
import java.time.Instant;  
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;  
        FileStatus[] statuses = fileSystem.listStatus(new Path("s3://bucket/data"));
    public void testGetFileStatusPropagatesAuthErrorsAsIOException() {
        );
    public void testPositionalReadAtEofReturnsEofWithoutS3Call() throws Exception {  
        try (FSDataInputStream in = fileSystem.open(new Path("s3://bucket/data/empty.parquet"), 4096)) {
            assertEquals(0, in.read(5L, buf, 0, 0));  
    public void testCreateS3ClientHonorsEndpointAndRegion() {
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenReturn(HeadObjectResponse.builder().contentLength(0L).build());
        conf.set("fs.s3a.endpoint", "http://minio.example.com:9000");  
import static org.mockito.Mockito.times;
import software.amazon.awssdk.core.exception.SdkClientException;
import static org.mockito.Mockito.verify;  
 *
    private S3Client s3Client;
 * The OpenSearch Contributors require contributions made to  
    }  
    }
            assertEquals(software.amazon.awssdk.regions.Region.US_WEST_2, client.serviceClientConfiguration().region());
import software.amazon.awssdk.services.s3.model.GetObjectRequest;  
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
/*  
 * compatible open source license.
    }
    public void testSequentialReadOfEmptyObjectReturnsEof() throws Exception {
        }
    public void testSequentialReadAtEofReturnsEofWithoutS3Call() throws Exception {  
import java.io.FileNotFoundException;
                .isTruncated(true)  
import org.apache.hadoop.fs.FSDataInputStream;
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenThrow(  
        IOException e = expectThrows(IOException.class, () -> fileSystem.getFileStatus(new Path("s3://bucket/data/file.parquet")));
import software.amazon.awssdk.services.s3.S3Client;
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenReturn(HeadObjectResponse.builder().contentLength(10L).build());
        // continuation token; the listing must terminate instead of looping.
import static org.mockito.Mockito.when;
    }  
        }  
            (S3Exception) S3Exception.builder().statusCode(404).message("no such key").build()
import java.io.IOException;
        fileSystem = new S3HadoopFileSystem();  
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenThrow(SdkClientException.create("connection reset"));  
                .contents(S3Object.builder().key("data/f1.parquet").size(1L).lastModified(Instant.ofEpochMilli(1000)).build())
        // A range like "bytes=10-9" would be rejected by S3 with 416; EOF must be
import static org.mockito.Mockito.mock;  
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
        conf.set("fs.s3a.endpoint.region", "us-west-2");
        assertTrue(e.getMessage(), e.getMessage().contains("Failed to get status"));
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenThrow(
        // reported without issuing any getObject call.
        conf.set("fs.s3a.endpoint", "s3.eu-central-1.amazonaws.com");
        try (S3Client client = S3HadoopFileSystem.createS3Client(conf)) {
        when(s3Client.listObjectsV2(any(ListObjectsV2Request.class))).thenReturn(
        try (FSDataInputStream in = fileSystem.open(new Path("s3://bucket/data/file.parquet"), 4096)) {  
        }  
 */  
public class S3HadoopFileSystemTests extends OpenSearchTestCase {  
        );
        FileStatus status = fileSystem.getFileStatus(new Path("s3://bucket/warehouse/db/table/dt=2024-01-01"));  
        );
 * this file be licensed under the Apache-2.0 license or a
        assertTrue(e.getMessage(), e.getMessage().contains("Failed to get status"));  
    public void testCreateS3ClientDefaultsToHttpsForSchemelessEndpoint() {  
    }
import org.opensearch.test.OpenSearchTestCase;
            in.seek(10);
        assertEquals(42L, status.getLen());
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
    }  
            assertEquals(-1, in.read());
        verify(s3Client, never()).getObject(any(GetObjectRequest.class));  
    private S3HadoopFileSystem fileSystem;  
            ListObjectsV2Response.builder().contents(S3Object.builder().key("warehouse/db/table/dt=2024-01-01/f.parquet").build()).build()  
        conf.set("fs.s3a.access.key", "test-access");  
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        verify(s3Client, never()).getObject(any(GetObjectRequest.class));
import org.apache.hadoop.fs.FileStatus;  
import static org.mockito.ArgumentMatchers.any;
import org.apache.hadoop.fs.Path;
        verify(s3Client, times(1)).listObjectsV2(any(ListObjectsV2Request.class));
        assertFalse(status.isDirectory());  
}
                java.net.URI.create("https://s3.eu-central-1.amazonaws.com"),
            ListObjectsV2Response.builder()
    @Override
        fileSystem.uri = java.net.URI.create("s3://bucket");
        IOException e = expectThrows(IOException.class, () -> fileSystem.getFileStatus(new Path("s3://bucket/secret/file")));
                client.serviceClientConfiguration().endpointOverride().orElse(null)  
        );
            HeadObjectResponse.builder().contentLength(42L).lastModified(Instant.ofEpochMilli(1000)).build()
    }  
