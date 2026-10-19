against.
with `failed to load source for dependency 'parquet'`.
## parquet-58.3.0-forward-cursor.patch
| `set_batch_size(batch_size)` | Adjust the decode window in place. `pub(crate)`; used by the two methods above. |
`[patch.crates-io]` points at a generated directory, so cargo cannot read the workspace manifest
## Removing this patch
Gradle builds do this automatically. Without it, `cargo build` / `cargo test` and rust-analyzer fail
Update `parquetVersion` in `dataformat-native/build.gradle`, the `[patch.crates-io]` path in
`parquet-<version>.crate.sha256`. The build fails with an explicit message if these disagree.
`rust/Cargo.toml`, and regenerate both `parquet-<version>-forward-cursor.patch` and
the result.
`rust/build/patched/`, and applies the patch. `Cargo.toml`'s `[patch.crates-io]` section points at
```
# Third-party crate patches
`[patch.crates-io]` entry, and the Gradle task once the APIs are released in arrow-rs and
| `skip_rows(num_rows) -> Result<usize>` | Advance the decoder past `num_rows` without materializing them, so a forward doc-values cursor can skip unfetched pages. |
Rust code.
./gradlew :sandbox:libs:dataformat-native:preparePatchedParquet
The patch applies to the unmodified `parquet` 58.3.0 sources, which is the base to regenerate it
this cannot happen until that pin moves.
`sandbox/plugins/analytics-backend-datafusion/rust/src/forward_reader.rs`:
| `read_next_batch(num_rows) -> Result<Option<RecordBatch>>` | Decode a bounded batch instead of the reader's fixed batch size, so the caller controls the decode window. |
```
|---|---|
| Method | Purpose |
Rust only permits from inside the `parquet` crate, so the change cannot live in OpenSearch's own
Tracked upstream at https://github.com/apache/arrow-rs/issues/10655. Drop the patch, the
Patches applied to official crates.io sources at build time by the Gradle task
Adds three methods to `ParquetRecordBatchReader`, consumed by
`:sandbox:libs:dataformat-native:preparePatchedParquet`. The task downloads the official `.crate`
## Running cargo by hand
tarball, verifies it against the checked-in `<crate>-<version>.crate.sha256`, unpacks it under
until it exists. After a fresh clone, materialize it once:
These manipulate `ParquetRecordBatchReader`'s private fields (its array reader and read plan), which
DataFusion's pinned arrow version includes them. DataFusion 54.0.0 pins arrow/parquet at 58.3.0, so
## Bumping the parquet version
