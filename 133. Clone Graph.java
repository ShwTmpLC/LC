class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        
        dfsClone(node, map);
        
        return copyNode;
    }
    
    private void dfsClone(Node node, Map<Node, Node> map) {
        
        Node copyNode = map.get(node);
        for (int i = 0; i < node.neighbors.size(); i++) {
            Node next = node.neighbors.get(i);
            if (!map.containsKey(next)) { // unvisited
                Node copyNext = new Node(next.val);
                map.put(next, copyNext);
                dfsClone(next, map);
            }
            Node copyNext = map.get(next);
            copyNode.neighbors.add(copyNext);   
        
        }
    }
}
