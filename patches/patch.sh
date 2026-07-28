#!/usr/bin/env bash
set -euo pipefail

MYDIR="$(cd "$(dirname "$0")" && pwd)"
WORKTREE="$(git rev-parse --show-toplevel)"

echo "==> Applying mytai patches..."
for p in "$MYDIR"/*.patch; do
    # Skip empty patches (no hunks)
    if ! grep -q '^@@ ' "$p" 2>/dev/null; then
        echo "    Skipping $(basename "$p") (empty/no hunks)"
        continue
    fi
    echo "    Applying $(basename "$p")"
    git am -3 --committer-date-is-author-date "$p"
done

echo ""
echo "All patches applied."
