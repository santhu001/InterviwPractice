/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice.producerconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.stream.IntStream;

/**
 *
 * @author santhosh
 */
public class Producer implements Runnable{
    BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> queue) {
        this.queue = queue;
    }
    
    @Override
    public void run() {
        IntStream.range(1, 100).forEach(val->{
        Message m=new Message().setMsg("hello"+val);
            try {
                Thread.sleep(val);
                queue.put(m);
                System.out.println("Produced"+m.getMsg());
            } catch (InterruptedException ex) {
                System.out.println(ex);
            }
        });
        //adding exit message
        Message msg = new Message().setMsg("exit");
        try {
            queue.put(msg);
            
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
