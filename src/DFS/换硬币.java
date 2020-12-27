package DFS;

public class 换硬币 {
		private int ans = Integer.MAX_VALUE;

		public int coinChange( int[] coins, int amount ) {
				if( coins == null ) {
						return 0;
				}
				dfs( coins, 0, amount, 0 );
				return ans;
		}

		private void dfs( int[] coins, int x, int amount, int num ) {

				if( x == coins.length ) {
						if( amount == 0 ) {
								ans = Math.min( ans, num );
						}
						return;
				}

				if( num >= ans ) {
						return;
				}

				if( coins[x] == 0 ) {
						dfs( coins, x + 1, amount, num );
				}

				for( int i = 0; i * coins[x] < amount; i++ ) {
						dfs( coins, x + 1, amount - coins[x] * i, num );
				}
		}

}
