public void solve(int testNumber, InputReader in, OutputWriter out) {
        int n = in.readInt();
        int[] a = new int[n];
        int total = 0;
        for (int i = 0; i < n; ++i) {
            a[i] = in.readInt();
            total += a[i];
        }
        int p = in.readInt();
        if (total <= p) {
            out.printLine(n);
            return;
        }

        double res = 0.;
        for (int blocker = 0; blocker < n; ++blocker) {
            double[][] dp = new double[n][p + 1];
            dp[0][0] = 1.0;

            for (int i = 0; i < n; ++i) {
                if (i == blocker) continue;
                int cur = a[i];

                for (int oldCount = n - 2; oldCount >= 0; --oldCount) {
                    for (int oldSum = 0; oldSum + cur <= p; ++oldSum) {
                        dp[oldCount + 1][oldSum + cur] +=
                              dp[oldCount][oldSum] / (n - oldCount) * (oldCount + 1);

                    }
                }
            }

            for (int count = 0; count < n; ++count) {
                for (int size = 0; size <= p; ++size) {
                    if (size + a[blocker] <= p) continue;
                    res += (dp[count][size] * count) / (n - count);
                }
            }
        }
        out.printLine(res);
    }
