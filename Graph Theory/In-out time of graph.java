int timer=1;
boolean dfs(int v){

  vis[v]=1;
  In[v] = timer++;
  
  for(int child:l.get(v)){
    
    if(vis[child]==0){
      
      dfs(child);
      
    }
    
  }
  
  Out[v] = timer++;
  
}


// In and out time help in fiinding articulation poimt of a graph
