package queue;

import queue.impl.CategoryIdQueue;
import queue.impl.RangeQueue;

public class DataCenterQueueFactory {
    /**
     *
     * @param queueName:CategoryId
     * @return
     */
    public static DataCenterQueue getQueue(String queueName){
        if(queueName.equals("CategoryId")){
            return new CategoryIdQueue();
        }else if(queueName.equals("Range")){
            return new RangeQueue();
        }

        return null;
    }
}
