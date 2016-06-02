/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice.producerconsumer;

import java.util.concurrent.BlockingQueue;

/**
 *
 * @author santhosh
 */
public class Consumer implements Runnable{
private BlockingQueue<Message> queue;
     
    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }
    @Override
    public void run() {
     try{
            Message msg;
            //consuming messages until exit message is received
            while(!"exit".equals((msg = queue.take()).getMsg())){
            Thread.sleep(10);
            System.out.println("Consumed : s"+msg.getMsg());
            }
        }catch(InterruptedException e) {
            
        }
    }
    
}
