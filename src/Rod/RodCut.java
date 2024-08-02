package Rod;

public class RodCut {
	int n;
	int[] p;
	int[] r;
	int[] s;

	public RodCut () {
		n = 10;
		p = new int[11];
		p[0] = 0;
		p[1] = 1;
		p[2] = 5;
		p[3] = 8;
		p[4] = 9;
		p[5] = 10;
		p[6] = 17;
		p[7] = 17;
		p[8] = 20;
		p[9] = 24;
		p[10] = 37;
	}

	public int memoized_cut_rod () {             // In this method when I pass a different number that  0 it does not work,
        r = new int[n+1];                        // it still shows 0 as the cut rod starts .
        for (int i = 0; i < n; i++) {
            r[i] = Integer.MIN_VALUE;
        }
        return memoized_cut_rod_aux(p, n, r);
	}

	public int memoized_cut_rod_aux (int p[], int n, int r[]) {
        int q;
        if (r[n] >= 0) {
            return r[n];
        }

        if (n == 0) {
            q = 0;
        } else {
            q = Integer.MIN_VALUE;
            for (int i = 1; i <= n; i++) {
                q = Math.max(q, p[i] + memoized_cut_rod_aux(p, n - i, r));
            }
        }
        r[n] = q;
        return q;
	}

	public int bottom_up_cut_rod () {
        int[] r = new int[n + 1];
        r[0] = 0;
        for (int j = 1; j <= n; j++) {
            int q = Integer.MIN_VALUE;
            for (int i = 1; i <= j; i++) {
                q = Math.max(q, p[i] + r[j - i]);
            }
            r[j] = q;
        }
        return r[n];

	}

	public void print_cut_rod_solution () {
		for (int i = 0; i <= n; i++) {
			System.out.print(i + "\t");
		}
		System.out.print("\n");
		for (int i = 0; i <= n; i++) {
			System.out.print(r[i] + "\t");
		}
		System.out.print("\n");
		for (int i = 0; i <= n; i++) {
			System.out.print(s[i] + "\t");
		}
		System.out.print("\n");
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		RodCut rc;

		rc = new RodCut();
		System.out.println("memoized_cut_rod starts ------------------");
		System.out.println(rc.memoized_cut_rod());
		System.out.println("memoized_cut_rod ends ------------------");
		System.out.print("\n\n");

		System.out.println("bottom_up_cut_rod starts ------------------");
		System.out.println(rc.bottom_up_cut_rod());
		System.out.println("bottom_up_cut_rod ends ------------------");
		System.out.print("\n\n");

	}

}