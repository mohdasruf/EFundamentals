package org.codingchallenge;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
 
 
 
public class consoleapp {
 
 
       static Hashtable userCache = new Hashtable();
       static Hashtable userCache1 = new Hashtable();
       static String username;
       static String command;
       static String parameter;
       static String data;
       static String[] dataarray;
       static String[] dataarray1 = new String[3];
       static String[] dataarray2 = new String[3];
       static String[] dataarray3 = new String[3];
       static Scanner read;
       static String songslistened;
 
 
                public static Hashtable storeDataPlay(String username, String command, String parameter)
                                {
 
                                if (command.equalsIgnoreCase("play"))
                                  {
                                       
                                         Hashtable playList = null;
                                         if (!userCache.containsKey(username))
                                                {
                                        	 		playList = new Hashtable();
                                                    playList.put(1, parameter);
                                                    userCache.put(username, playList);
                                                                               
                                                }
                                          else                                 
                                                {                                              
                                                       	playList = (Hashtable) userCache.get(username);
                                                        playList.put(playList.size() + 1, parameter);
                                                        userCache.put(username, playList); 
                                                 }
                                        
                                  }
								return userCache;
                                                
                                                                }
                public static Hashtable storeDataFollow(String username, String command, String parameter)
                {
                if (command.equalsIgnoreCase("follow"))
                {
                             
                  Hashtable username1 ;
                  if (!userCache1.containsKey(username))
                  {
                         username1 = new Hashtable();
                         username1.put(1, parameter);
                         userCache1.put(username, username1);
              
                  }
                  else
                  {
                         username1 = (Hashtable) userCache1.get(username);
                         username1.put(username1.size() + 1, parameter);
                         userCache1.put(username, parameter); 
                
                  }
           
            
                }
				return userCache1;
             
                }
                public static String[] returnSongsPlayed(String username)
                                         {
                                  
                                 Set set = userCache.entrySet();
                                 Iterator it = set.iterator();
                                 while (it.hasNext())
                                        {
                                         Map.Entry entry = (Map.Entry) it.next();
                                        if (entry.getKey().equals(username))
                                            {
                                                System.out.println(entry.getKey().toString() + " Listened to Songs: " + entry.getValue().toString());
                                                dataarray1[0] =  entry.getKey().toString();
                                                dataarray1[1] =	" Listened to Songs: ";
                                                dataarray1[2] = entry.getValue().toString();

                                            }
 
                                         }
                                 return dataarray1;
                                         }             
 
                public static String[] returnActivites(String username,String command)
                                         {
                                               
                                  if (command.equalsIgnoreCase("Activity")){
                                  
                                  Set set = userCache.entrySet();
                                  Iterator it = set.iterator();
                                  while (it.hasNext())
                                         {
                                                  Map.Entry entry = (Map.Entry) it.next();
                                                  if (entry.getKey().equals(username))
                                                              {
                                                              System.out.println(entry.getKey().toString() + " Listened to Songs: " + entry.getValue().toString());
                                                              dataarray2[0] =  entry.getKey().toString();
                                                              dataarray2[1] =	" Listened to Songs: ";
                                                              dataarray2[2] = entry.getValue().toString();
                                                              }
 
                                          }
                                   Set set1 = userCache1.entrySet();
                                    Iterator it1 = set1.iterator();
                                    while (it1.hasNext())
                                         {
                                      Map.Entry entry1 = (Map.Entry) it1.next();
                                     
                                      if (entry1.getKey().equals(username))
                                                {
                                                System.out.println(entry1.getKey().toString() + " follow " + entry1.getValue().toString());
                                                dataarray3[0] =  entry1.getKey().toString();
                                                dataarray3[1] =	" Follow  ";
                                                dataarray3[2] = entry1.getValue().toString();
                                                }
                                         } 
                                  }       return dataarray3;                      
                                         }
       public static void main(String[] args){
              //JavaConsole console = new JavaConsole();
              do{
                  read = new Scanner(System.in);
                  data = read.nextLine();
                  dataarray = data.split(" ");
                
                      if (dataarray.length >= 3)
                         {
                            
                                username = dataarray[0];
                                command = dataarray[1];
                                parameter = dataarray[2];
                                
                                if (command.equalsIgnoreCase("play")){
                         
                                consoleapp.storeDataPlay(username,command,parameter);}
                                
                                if (command.equalsIgnoreCase("follow")){
                                    
                                    consoleapp.storeDataFollow(username,command,parameter);}
                                
                                                }
             
                      else if(dataarray.length == 1)
                           {
                                              
                                username = dataarray[0];
                                consoleapp.returnSongsPlayed(username);
                                 
                           }
                 
                       else if(dataarray.length == 2)
                            {
                                              
                             username = dataarray[0];
                             command = dataarray[1] ;
                                                 
                             consoleapp.returnActivites(username,command);
                     
                                  
                             }
          
                  } while (!username.equalsIgnoreCase("exit"));
 
     
       }
 
}
