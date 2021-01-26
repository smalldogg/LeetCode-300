package BFS;

import java.util.*;

/**
 * Created by wyh on 2019/6/2.
 */
public class 克隆图 {
		public UndirectedGraphNode cloneGraph( UndirectedGraphNode node ) {
				if( node == null ) {
						return node;
				}
				//1.找到所有的点
				List<UndirectedGraphNode> nodes = getAllNodes( node );
				//2.复制点
				Map<UndirectedGraphNode, UndirectedGraphNode> mapping = new HashMap<>( );
				for( UndirectedGraphNode cur : nodes ) {
						mapping.put( cur, new UndirectedGraphNode( cur.label ) );
				}
				//3.复制边
				for( UndirectedGraphNode cur : nodes ) {
						UndirectedGraphNode copy = mapping.get( cur );
						for( UndirectedGraphNode nei : cur.neighbors ) {
								UndirectedGraphNode copyNode = mapping.get( nei );
								copy.neighbors.add( copyNode );
						}
				}
				return mapping.get( node );
		}

		private List<UndirectedGraphNode> getAllNodes( UndirectedGraphNode node ) {
				Queue<UndirectedGraphNode> queue = new LinkedList<>( );
				Set<UndirectedGraphNode> set = new HashSet<>( );
				queue.add( node );
				set.add( node );
				while( !queue.isEmpty( ) ) {
						UndirectedGraphNode cur = queue.poll( );
						for( UndirectedGraphNode next : cur.neighbors ) {
								if( !set.contains( next ) ) {
										queue.add( next );
										set.add( next );
								}
						}
				}
				return new ArrayList<>( set );
		}
}
