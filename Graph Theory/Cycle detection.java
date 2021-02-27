boolean dfsboolean dfs(int v,int parent){

  vis[v]=1;
  
  
  for(int child:l.get(v)){
    
    if(vis[child]==0){
      
      if(dfs(child,v)==true){
        return true;
      }
      
    }else if(child!=parent) return true;
    
  }
  
  return false;
  
}
