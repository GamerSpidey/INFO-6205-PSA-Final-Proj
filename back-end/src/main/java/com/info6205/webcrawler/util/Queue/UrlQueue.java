package com.info6205.webcrawler.util.Queue;

import org.springframework.stereotype.Component;

import com.info6205.webcrawler.pojo.Url;

@Component
public class UrlQueue implements UrlQueueInterface {
    private Node firstUrl;       // Reference to first node
    private Node lastUrl;        // Reference to last node
	private int numberOfEntries;

 

    public UrlQueue(){
        this.firstUrl = null;
        this.lastUrl = null;
        numberOfEntries = 0;
    }

    public Node getLastUrl() {
        return this.lastUrl;
    }

    public void setLastUrl(Node lastUrl) {
        this.lastUrl = lastUrl;
    }


    public Node getFirstUrl() {
        return this.firstUrl;
    }

    public void setFirstUrl(Node firstUrl) {
        this.firstUrl = firstUrl;
    }

    public int getNumberOfEntries() {
        return this.numberOfEntries;
    }

    public void setNumberOfEntries(int numberOfEntries) {
        this.numberOfEntries = numberOfEntries;
    }

    /** Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty(){
    return numberOfEntries==0;
    }

    /** Retrieves the size of the queue.
     * @return The number of elements in the queue.
     */
    public int size(){
        return numberOfEntries;
    }

    /** Adds a URL to the end of the queue.
     * @param url The URL to enqueue.
     * @return true if the URL was successfully added to the queue, false otherwise.
     */
    public boolean enqueue(Url url){
		// Add to beginning of chain:
		Node newUrl = new Node(url);
		if(firstUrl==null){
            firstUrl=newUrl;
            lastUrl=firstUrl;
        }
        else{
            lastUrl.setNextUrl(newUrl);
            lastUrl=newUrl;
        }
        numberOfEntries++;
      
		return true;
	} // end add

    /** Removes and returns the first URL from the queue.
     * @return The first URL in the queue, or null if the queue is empty.
     */
    public Url dequeue(){
        Url remove = null;
        if(!isEmpty()) {
            remove=firstUrl.getUrl();
            firstUrl=firstUrl.getNextUrl();
            numberOfEntries--;
        }
        return remove;
    }

    /** Retrieves the first URL in the queue without removing it.
     * @return The first URL in the queue, or null if the queue is empty.
     */
    public Url peek(){
        if(!isEmpty()) return firstUrl.getUrl();
        else return null;
   }

    /** Removes all entries from the queue. */
    public void clear(){
        while (!isEmpty()) 
        dequeue();
    }

    /** Converts the queue to an array of URLs.
     * @return An array containing all URLs in the queue.
     */
    public Url[] toArray(){
        Url[] array=new Url[numberOfEntries];
        Node dummy=firstUrl;
        for(int i=0;i<numberOfEntries;i++){
            array[i]=dummy.getUrl();
            dummy=dummy.getNextUrl();
        }
        return array;
    }

    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Queue");
        Node dummy=firstUrl;
        int i=1;
        while(dummy!=null){
            sb.append(i+".\t").append(dummy.getUrl()+".\n");
            dummy=dummy.getNextUrl();
            i++;
        }
        return sb.toString();
        
    }
    
    



}
