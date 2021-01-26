package DFS;

import java.util.Arrays;

public class 攀爬字符串 {
		public boolean isScramble( String s1, String s2 ) {
				if( s1.length( ) != s2.length( ) ) {
						return false;
				}
				if( s1.equals( s2 ) ) {
						return true;
				}
				char[] ch1 = s1.toCharArray( );
				char[] ch2 = s2.toCharArray( );
				Arrays.sort( ch1 );
				Arrays.sort( ch2 );
				for( int i = 0; i < ch1.length; i++ ) {
						if( ch1[i] != ch2[i] ) {
								return false;
						}
				}
				int n = s1.length( );
				for( int i = 1; i < n; i++ ) {
						boolean res = isScramble( s1.substring( 0, i ), s2.substring( 0, i ) ) && isScramble( s1.substring( i, n ), s2.substring( i, n ) ) //长度相等
								|| isScramble( s1.substring( 0, i ), s2.substring( n - i, n ) ) && isScramble( s1.substring( i, n ), s2.substring( 0, n - i ) );
						if( res )
								return true;
				}
				return false;
		}
}
