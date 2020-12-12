package other;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wangyh
 * @create 2020-12-03 17:51
 */

public class WordMatch {
		private boolean state; // 是否是最后一个字
		//这里为了省事，直接new一个出来
		private Map<Character, WordMatch> next = new HashMap<>( ); // 下一个状态

		public void add( String word ) {
				if( word != null && word.length( ) != 0 )
						this.add( word, 0 );
		}



		/**
		 * 这里最好使用2的次数幂
		 *
		 * @param size
		 */
		public void init( int size ) {
				this.next = new HashMap<>( size );
		}


		/**
		 * @param word
		 * @param startIdx
		 */
		public void add( String word, int startIdx ) {
				char c = word.charAt( startIdx );
				WordMatch wordMatch = this.next.get( c );
				//如果不为空的话，继续向下层寻找
				if( wordMatch == null ) {
						wordMatch = new WordMatch( );
						this.next.put( c, wordMatch );
				}
				++startIdx;
				if( word.length( ) == startIdx )
						wordMatch.state = true; //这句话已经结束了
				else {
						//如果没有结束的话，继续向下寻找
						add( word, startIdx );
				}
		}


		public void del( String word ) {
				if( word != null && word.length( ) != 0 )
						this.del( word, 0 );
		}

		/**
		 * @param word
		 * @param startIdx 这里说明一下删除的条件
		 *                 1.如果某个字结尾了，那么应该把这个词的state设置为false,并删除这个节点
		 *                 2.另一种情况，以这个字结尾，但是它还有下一层节点，那么只能将这个字设置为false，
		 *                 但是不能这个字
		 */
		public void del( String word, int startIdx ) {
				char c = word.charAt( startIdx );
				WordMatch match = this.next.get( c );
				if( match != null ) {
						if( ++startIdx == word.length( ) ) {
								if( match.state ) {
										match.state = false;
										if( match.next.size( ) == 0 )
												this.next.remove( c );
								}
						}
				} else {
						del( word, ++startIdx );
				}
		}

		/**
		 * @param word
		 * @return
		 */
		public boolean matches( String word ) {
				if( word == null || word.length( ) == 0 )
						return false;
				if( this.next.size( ) == 0 )
						return false;
				//开始向下寻找
				char[] chs = word.toCharArray( );
				for( int i = 0; i < chs.length; ++i )
						return find( chs, i );
				return false;
		}


		/**
		 * @param chs
		 * @param startIdx
		 * @return
		 */
		public boolean find( char[] chs, int startIdx ) {
				if( startIdx >= chs.length )
						return false;
				char ch = chs[startIdx];
				WordMatch wordMatch = this.next.get( ch );
				if( wordMatch != null && wordMatch.state )
						return true;
				if( wordMatch == null )
						return false;
				return find( chs, ++startIdx );
		}



		public static void main( String[] args ) {
				WordMatch match = new WordMatch( );
				match.add( "我擦" );
				match.add( "我去" );
				match.del( "我" );
				match.add( "我" );
				System.out.println( match.matches( "我去" ) );
		}
}
