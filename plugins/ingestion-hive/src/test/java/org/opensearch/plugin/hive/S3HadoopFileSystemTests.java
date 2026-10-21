        );
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
        fileSystem.uri = java.net.URI.create("s3://bucket");
                client.serviceClientConfiguration().endpointOverride().orElse(null)
        assertTrue(status.isDirectory());
            assertEquals(-1, in.read());
        FileStatus status = fileSystem.getFileStatus(new Path("s3://bucket/data/file.parquet"));
        when(s3Client.listObjectsV2(any(ListObjectsV2Request.class))).thenReturn(ListObjectsV2Response.builder().build());
            byte[] buf = new byte[8];
    public void testGetFileStatusPropagatesNetworkErrorsAsIOException() {
        );
        assertEquals(42L, status.getLen());
        try (FSDataInputStream in = fileSystem.open(new Path("s3://bucket/data/file.parquet"), 4096)) {
        );
                .contents(S3Object.builder().key("data/f1.parquet").size(1L).lastModified(Instant.ofEpochMilli(1000)).build())
        // A range like "bytes=10-9" would be rejected by S3 with 416; EOF must be
package org.opensearch.plugin.hive;
        }
            );
 * The OpenSearch Contributors require contributions made to
    }
import org.opensearch.test.OpenSearchTestCase;
            (S3Exception) S3Exception.builder().statusCode(404).message("no such key").build()
            byte[] buf = new byte[4];
import software.amazon.awssdk.services.s3.model.S3Object;
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenThrow(
        conf.set("fs.s3a.access.key", "test-access");
        fileSystem = new S3HadoopFileSystem();
import software.amazon.awssdk.services.s3.model.S3Exception;
            assertEquals(
        IOException e = expectThrows(IOException.class, () -> fileSystem.getFileStatus(new Path("s3://bucket/data/file.parquet")));
        try (FSDataInputStream in = fileSystem.open(new Path("s3://bucket/data/file.parquet"), 4096)) {
        FileStatus status = fileSystem.getFileStatus(new Path("s3://bucket/warehouse/db/table/dt=2024-01-01"));
        verify(s3Client, never()).getObject(any(GetObjectRequest.class));
    @Override
        );
    public void testGetFileStatusPropagatesAuthErrorsAsIOException() {
        );
import software.amazon.awssdk.services.s3.S3Client;
        verify(s3Client, never()).getObject(any(GetObjectRequest.class));
        IOException e = expectThrows(IOException.class, () -> fileSystem.getFileStatus(new Path("s3://bucket/secret/file")));
    public void testGetFileStatusThrowsFileNotFoundWhenNothingExists() {
 *
    public void testListStatusStopsWhenTruncatedResponseHasNoToken() throws Exception {
    public void testSequentialReadAtEofReturnsEofWithoutS3Call() throws Exception {
    }
            ListObjectsV2Response.builder().contents(S3Object.builder().key("warehouse/db/table/dt=2024-01-01/f.parquet").build()).build()
}
        conf.set("fs.s3a.secret.key", "test-secret");
        conf.set("fs.s3a.endpoint.region", "eu-central-1");
        conf.set("fs.s3a.path.style.access", "true");
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
        expectThrows(FileNotFoundException.class, () -> fileSystem.getFileStatus(new Path("s3://bucket/missing/path")));
        // reported without issuing any getObject call.
        // continuation token; the listing must terminate instead of looping.
        when(s3Client.listObjectsV2(any(ListObjectsV2Request.class))).thenReturn(
import java.io.IOException;
        // Broken S3-compatible stores can report isTruncated without a
            );
        conf.set("fs.s3a.endpoint", "http://minio.example.com:9000");
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenReturn(HeadObjectResponse.builder().contentLength(10L).build());
import java.io.FileNotFoundException;
    public void testGetFileStatusReturnsDirectoryWhenPrefixHasObjects() throws Exception {
 * SPDX-License-Identifier: Apache-2.0
        assertFalse(status.isDirectory());
    }
        when(s3Client.listObjectsV2(any(ListObjectsV2Request.class))).thenReturn(
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenReturn(HeadObjectResponse.builder().contentLength(10L).build());
        }
    public void testCreateS3ClientDefaultsToHttpsForSchemelessEndpoint() {
import org.apache.hadoop.fs.Path;
    }
                .isTruncated(true)
            assertEquals(software.amazon.awssdk.regions.Region.US_WEST_2, client.serviceClientConfiguration().region());
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
    }
import static org.mockito.Mockito.never;
import org.apache.hadoop.fs.FileStatus;
 */
            (S3Exception) S3Exception.builder().statusCode(404).message("no such key").build()
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenThrow(
    public void testPositionalReadAtEofReturnsEofWithoutS3Call() throws Exception {
    private S3Client s3Client;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
        s3Client = mock(S3Client.class);
import java.time.Instant;
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenThrow(
            (S3Exception) S3Exception.builder().statusCode(403).message("access denied").build()
    }
    }
 * this file be licensed under the Apache-2.0 license or a
            assertEquals(-1, in.read(buf, 0, buf.length));
            assertEquals(-1, in.read());
import static org.mockito.Mockito.times;
        try (S3Client client = S3HadoopFileSystem.createS3Client(conf)) {
    }
            ListObjectsV2Response.builder()
                java.net.URI.create("http://minio.example.com:9000"),
            assertEquals(
import static org.mockito.Mockito.mock;
    }
            assertEquals(-1, in.read(10L, buf, 0, buf.length));
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
                java.net.URI.create("https://s3.eu-central-1.amazonaws.com"),
    public void testGetFileStatusReturnsFileWhenObjectExists() throws Exception {
            assertEquals(0, in.read(5L, buf, 0, 0));
    public void setUp() throws Exception {
        }
    public void testSequentialReadOfEmptyObjectReturnsEof() throws Exception {
        }
        try (FSDataInputStream in = fileSystem.open(new Path("s3://bucket/data/empty.parquet"), 4096)) {
import static org.mockito.ArgumentMatchers.any;
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenReturn(HeadObjectResponse.builder().contentLength(0L).build());
public class S3HadoopFileSystemTests extends OpenSearchTestCase {
import static org.mockito.Mockito.when;
                .build()
        conf.set("fs.s3a.endpoint.region", "us-west-2");
        assertTrue(e.getMessage(), e.getMessage().contains("Failed to get status"));
            in.seek(10);
    private S3HadoopFileSystem fileSystem;
    }
    }
        super.setUp();
        FileStatus[] statuses = fileSystem.listStatus(new Path("s3://bucket/data"));
        verify(s3Client, times(1)).listObjectsV2(any(ListObjectsV2Request.class));
import org.apache.hadoop.fs.FSDataInputStream;
            HeadObjectResponse.builder().contentLength(42L).lastModified(Instant.ofEpochMilli(1000)).build()
        assertTrue(e.getMessage(), e.getMessage().contains("Failed to get status"));
/*
import static org.mockito.Mockito.verify;
        );
        fileSystem.s3Client = s3Client;
        }
                client.serviceClientConfiguration().endpointOverride().orElse(null)
        org.apache.hadoop.conf.Configuration conf = new org.apache.hadoop.conf.Configuration();
 * compatible open source license.
        assertEquals(1, statuses.length);
import software.amazon.awssdk.core.exception.SdkClientException;
        verify(s3Client, never()).getObject(any(GetObjectRequest.class));
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenReturn(
        try (S3Client client = S3HadoopFileSystem.createS3Client(conf)) {
    public void testCreateS3ClientHonorsEndpointAndRegion() {
        conf.set("fs.s3a.endpoint", "s3.eu-central-1.amazonaws.com");
        when(s3Client.headObject(any(HeadObjectRequest.class))).thenThrow(SdkClientException.create("connection reset"));
    }
