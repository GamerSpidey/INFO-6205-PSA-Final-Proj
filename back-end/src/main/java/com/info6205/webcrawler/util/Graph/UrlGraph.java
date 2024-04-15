package com.info6205.webcrawler.util.Graph;
import org.springframework.stereotype.Component;

import com.info6205.webcrawler.pojo.Url;
import com.info6205.webcrawler.util.ArrayBag.BagInterface;
import com.info6205.webcrawler.util.HashMap.*;

@Component
public class UrlGraph {
	 private UrlMap<String, Node> map;
	 private int size;
	 
	  public UrlGraph() {
	        this.map = new UrlMap<>();
			this.size = 0;
	    }
	  
	  
	  public boolean addVertex(Url key) {
	        if (!map.containsKey(key.getPath())) {
	            Node newNode = new Node(key);
	            map.put(key.getPath(), newNode);
				size++;
	            return true;
				
	        }
	        else return false;
	    }
		public boolean containsVertex(Url vertex) {
			return map.containsKey(vertex.getPath());
			
	   }
	  
	   public int getCurrentSize(){
		return this.size;
	   }

	    public boolean addEdge(Url source, Url destination) {
	    	 Node sourceNode = map.get(source.getPath());
	    	    if (sourceNode != null) {
	    	        sourceNode.getEdges().addUrl(destination);
	    	        return true;
	    	    }
	    	    return false;
	    }

		public boolean containsEdge(Url source, Url destination) {
			Node sourceNode = map.get(source.getPath());
			   if (sourceNode != null && sourceNode.getEdges().contains(destination)) {				   
				   return true;
			   }
			   return false;
	   }
	    
	    public Url[] getEdges(Url vertex) {
			System.out.println("inside get edges");
			System.out.println("method param "+ vertex.getPath());
	        Node n = map.get(vertex.getPath());
			System.out.println("Node n "+ n);
			if(n==null) return null;
			Url[] edges = n.getEdges().toArray();
			
			return edges;
	    }

		

		public Url getVertex(Url vertex) {
	        return map.get(vertex.getPath()).getVertex();
	    }
	    
	    @Override
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
			BagInterface<Node> values= map.getValues();
						
			sb.append(values.toString()).append("\n");
	       
	        return sb.toString();
	    }

		public void clear(){
			map.clear();
			this.size=0;
		}

       /** public String convertToJSON() {
        JSONArray nodesArray = new JSONArray();
        JSONArray edgesArray = new JSONArray();

        int i=1;
        for (T vertex : nodes.getKeys().toArray()) {
             JSONObject nodeObject = new JSONObject();
            nodeObject.put("id", i); // Assuming vertex has a meaningful toString() method
            nodeObject.put("label", i);
            nodeObject.put("title", vertex);
            nodesArray.put(nodeObject);
            i++;
        }
        
      

        JSONObject graphObject = new JSONObject();
        graphObject.put("nodes", nodesArray);
        graphObject.put("edges", edgesArray);

        return graphObject.toString();

    } **/
    
    
}
