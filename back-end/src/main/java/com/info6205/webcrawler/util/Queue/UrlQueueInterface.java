package com.info6205.webcrawler.util.Queue;

import com.info6205.webcrawler.pojo.Url;

public interface UrlQueueInterface {
    /** Checks if the queue is empty.
     * @return true if the queue is empty, false otherwise.
     */
    public boolean isEmpty();

    /** Retrieves the size of the queue.
     * @return The number of elements in the queue.
     */
    public int size();

    /** Adds a URL to the end of the queue.
     * @param url The URL to enqueue.
     * @return true if the URL was successfully added to the queue, false otherwise.
     */
    public boolean enqueue(Url url);

    /** Removes and returns the first URL from the queue.
     * @return The first URL in the queue, or null if the queue is empty.
     */
    public Url dequeue();

    /** Retrieves the first URL in the queue without removing it.
     * @return The first URL in the queue, or null if the queue is empty.
     */
    public Url peek();

    /** Removes all entries from the queue. */
    public void clear();

    /** Converts the queue to an array of URLs.
     * @return An array containing all URLs in the queue.
     */
    public Url[] toArray();
    
    public Node getLastUrl();

    public void setLastUrl(Node lastUrl);


    public Node getFirstUrl();

    public void setFirstUrl(Node firstUrl);
}
