```
The repository-s3 plugin enables the use of S3 as a place to store snapshots.
## Testing
See [S3 API call timeout](API_TIMEOUTS.md) for configuring a timeout that covers
AWS_REGION=us-west-2 amazon_s3_access_key=$AWS_ACCESS_KEY_ID amazon_s3_secret_key=$AWS_SECRET_ACCESS_KEY amazon_s3_base_path=path amazon_s3_bucket=dblock-opensearch ./gradlew :plugins:repository-s3:s3ThirdPartyTest
-  `amazon_s3_secret_key`: The secret access key (`AWS_SECRET_ACCESS_KEY`).
```
# repository-s3
-  `AWS_REGION`: The region in which the S3 bucket was created. While S3 buckets are global, credentials must scoped to a specific region and cross-region access is not allowed. (TODO: rename this to `amazon_s3_region` in https://github.com/opensearch-project/opensearch-build/issues/3615 and https://github.com/opensearch-project/OpenSearch/pull/7974.)
-  `amazon_s3_base_path`: A relative path inside the S3 bucket, e.g. `opensearch`.
- `amazon_s3_path_style_access`: Possible values true or false. Default is false.
Optional environment variables:
-  `amazon_s3_bucket`: Name of the S3 bucket to use.
### Unit Tests
-  `amazon_s3_access_key`: The access key ID (`AWS_ACCESS_KEY_ID`) with r/w access to the S3 bucket.
### Integration Tests
```
./gradlew :plugins:repository-s3:test
an SDK call and its retries for both synchronous and asynchronous clients.
Integration tests require several environment variables.
- `amazon_s3_endpoint`: s3 custom endpoint url if aws s3 default endpoint is not being used.
```
