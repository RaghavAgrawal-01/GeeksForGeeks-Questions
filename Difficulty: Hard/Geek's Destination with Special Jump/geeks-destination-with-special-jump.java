class Solution {
    private static final long MOD = 1000000007L;

    public int minTime(int a, int b, int d, int l, int r) {
        long la = a, lb = b, ld = d, ll = l, lr = r;
        long normTime = earliestReach(ld, la, lb);

        long lo = ll, hi = lr + 1;
        while(lo < hi) {
            long mid = lo + (hi - lo) / 2;
            if(earliestReach(ld - mid, la, lb) + 1 <= normTime) {
                hi = mid;
            }
            else {
                lo = mid + 1;
            }
        }
        long jStart = lo;

        long countNorm = jStart - ll;
        long ans = ((countNorm % MOD) * (normTime % MOD)) % MOD;

        if(jStart <= lr) {
            long xLo = ld - lr;
            long xHi = ld - jStart;
            long countJump = lr - jStart + 1;
            long jumpSum = (sumEarliest(xLo, xHi, la, lb) + (countJump % MOD)) % MOD;
            ans = (ans + jumpSum) % MOD;
        }

        return (int)(ans % MOD);
    }

    private long earliestReach(long x, long a, long b) {
        if(x <= 0) {
            return 0;
        }
        if(x <= a) {
            return x;
        }
        long net = a - b;
        long k = (x - a + net - 1) / net;
        return k * (a + b) + (x - k * net);
    }

    private long sumEarliest(long leftX, long rightX, long a, long b) {
        if(leftX > rightX) {
            return 0;
        }
        long total = 0;
        long endLeA = Math.min(rightX, a);
        if(leftX <= endLeA) {
            long cnt = endLeA - leftX + 1;
            total = (total + sumRangeMod(leftX, endLeA, cnt)) % MOD;
        }
        long startGtA = Math.max(leftX, a + 1);
        if(startGtA <= rightX) {
            long cnt = rightX - startGtA + 1;
            total = (total + sumRangeMod(startGtA, rightX, cnt)) % MOD;

            long net = a - b;
            long kMin = (startGtA - a + net - 1) / net;
            long kMax = (rightX - a + net - 1) / net;
            long twoB = (2 * b) % MOD;

            if(kMin == kMax) {
                long blkCnt = rightX - startGtA + 1;
                long add = ((blkCnt % MOD) * ((kMin % MOD) * twoB % MOD)) % MOD;
                total = (total + add) % MOD;
            }
            else {
                long firstEnd = Math.min(rightX, a + kMin * net);
                long firstCnt = firstEnd - startGtA + 1;
                long firstAdd = ((firstCnt % MOD) * ((kMin % MOD) * twoB % MOD)) % MOD;
                total = (total + firstAdd) % MOD;

                long lastStart = Math.max(startGtA, a + (kMax - 1) * net + 1);
                long lastCnt = rightX - lastStart + 1;
                long lastAdd = ((lastCnt % MOD) * ((kMax % MOD) * twoB % MOD)) % MOD;
                total = (total + lastAdd) % MOD;

                if(kMin + 1 <= kMax - 1) {
                    long midKStart = kMin + 1;
                    long midKEnd = kMax - 1;
                    long midKCnt = midKEnd - midKStart + 1;
                    long sumK = sumRangeMod(midKStart, midKEnd, midKCnt);
                    long midAdd = (((twoB * (net % MOD)) % MOD) * sumK) % MOD;
                    total = (total + midAdd) % MOD;
                }
            }
        }
        return total;
    }

    private long sumRangeMod(long first, long last, long count) {
        long p1 = count;
        long p2 = first + last;
        if(p1 % 2 == 0) {
            p1 /= 2;
        }
        else {
            p2 /= 2;
        }
        return ((p1 % MOD) * (p2 % MOD)) % MOD;
    }
}