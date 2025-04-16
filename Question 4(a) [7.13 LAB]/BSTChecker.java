import java.util.*;

public class BSTChecker {
	public static Node checkBSTValidity(Node rootNode) {
		Node answer = NODE_CHECK(rootNode, null, null);
		return answer;
	}
		
	public static Node NODE_CHECK(Node node, Integer min, Integer max) {
		if (node == null) {
			return null;
		}
		
		if(min != null && (node.key <= min)){
		   return node;
		   }
		   
		 if(max != null && (node.key >= max)){
		   return node;
		   }
		   
		   if (NODE_CHECK(node.left, min, node.key) != null){
	      
	      
	      	   	return NODE_CHECK(node.left, min, node.key);
		   }
		      
		      
		 if (NODE_CHECK(node.right, node.key, max) != null){
		    
	      	   	return NODE_CHECK(node.right, node.key, max);
		   }
		      
		      
		return null;
	}
}
