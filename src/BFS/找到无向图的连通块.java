package BFS;

import java.util.*;

/**
 * Created by wyh on 2019/6/2.
 */
public class 找到无向图的连通块 {

		public List<List<Integer>> connectedSet( List<UndirectedGraphNode> nodes ) {
				List<List<Integer>> results = new ArrayList<>( );
				Set<UndirectedGraphNode> set = new HashSet<>( );
				for( UndirectedGraphNode node : nodes ) {
						if( !set.contains( node ) ) {
								bfs( set, node, results );
						}
				}
				return results;
		}

		private void bfs( Set<UndirectedGraphNode> set, UndirectedGraphNode node, List<List<Integer>> results ) {
				Queue<UndirectedGraphNode> q = new LinkedList<>( );
				q.offer( node );
				set.add( node );
				List<Integer> list = new ArrayList<>( );
				while( !q.isEmpty( ) ) {
						UndirectedGraphNode cur = q.poll( );
						list.add( cur.label );
						for( UndirectedGraphNode next : cur.neighbors ) {
								if( !set.contains( next ) ) {
										q.offer( next );
										set.add( next );
								}
						}
				}
				Collections.sort( list );
				results.add( list );
		}

}
