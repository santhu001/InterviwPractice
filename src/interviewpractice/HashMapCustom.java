/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interviewpractice;

/**
 *
 * @author santhosh
 * @param <K>
 * @param <V>
 */
public class HashMapCustom<K,V> {
  private final Entry<K,V>[] table;   //Array of Entry.
     private final int capacity= 4; 
     static class Entry<K, V> {
         K key;
         V value;
         Entry<K,V> next;
     
         public Entry(K key, V value, Entry<K,V> next){
             this.key = key;
             this.value = value;
             this.next = next;
         }
     }
      @SuppressWarnings("unchecked")
    public HashMapCustom(){
       table = new Entry[capacity];
    }
    public void put(K newKey, V data){
        if(newKey==null) return;
        int hash= hash(newKey);
        Entry<K,V> newEntry = new Entry<>(newKey, data, null);
        if(table[hash] == null){
         table[hash] = newEntry;
        }else{
           Entry<K,V> previous = null;
           Entry<K,V> current = table[hash];
            while (current!=null) {                
              if(current.key.equals(newKey)){
                  if(previous==null){
                      newEntry.next=current.next;
                      table[hash]=newEntry;
                      return;
                  }else{
                   newEntry.next=current.next;
                   previous.next=newEntry;
                   return;
                  }
              }  
             previous=current;
             current = current.next;
            }
            previous.next = newEntry;
        }
    }
     public boolean remove(K deleteKey){
       
       int hash=hash(deleteKey);
              
      if(table[hash] == null){
            return false;
      }else{
        Entry<K,V> previous = null;
        Entry<K,V> current = table[hash];
        
        while(current != null){ //we have reached last entry node of bucket.
           if(current.key.equals(deleteKey)){               
               if(previous==null){  //delete first entry node.
                     table[hash]=table[hash].next;
                     return true;
               }
               else{
                     previous.next=current.next;
                      return true;
               }
           }
           previous=current;
             current = current.next;
          }
        return false;
      }
    
    }
      public V get(K key){
        int hash = hash(key);
        if(table[hash] == null){
         return null;
        }else{
         Entry<K,V> temp = table[hash];
         while(temp!= null){
             if(temp.key.equals(key))
                 return temp.value;
             temp = temp.next; //return value corresponding to key.
         }         
         return null;   //returns null if key is not found.
        }
    }
     private int hash(K key){
        return Math.abs(key.hashCode()) % capacity;
    }
     public static void main(String[] args) {
         HashMapCustom<String,String> map=new HashMapCustom<>();
         map.put("name1", "santhu");
         map.put("name10", "santhu");
         map.remove("name10");
          map.get("name1");
    }
}
