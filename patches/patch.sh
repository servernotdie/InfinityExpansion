#!/usr/bin/env bash
set -euo pipefail

MYDIR="$(cd "$(dirname "$0")" && pwd)"
WORKTREE="$(git rev-parse --show-toplevel)"

echo "==> Applying mytai patches..."
for p in "$MYDIR"/*.patch; do
    echo "    Applying $(basename "$p")"
    git am -3 --committer-date-is-author-date "$p"
done

echo ""
echo "All patches applied."

