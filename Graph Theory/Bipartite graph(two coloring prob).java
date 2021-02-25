boolean dfs(int v,int c){

  vis[v]=1;
  col[v] = c;
  
  for(int child:l.get(v)){
    
    if(vis[child]==0){
      
      if(dfs(child,c^1)==false){
        return false;
      }
      
    }else if(col[child]==col[v]) return false;
    
  }
  
  return true;
  
}
