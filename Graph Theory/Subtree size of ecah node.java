int vis[] = new int[1000001];
int dfs(int v) {
		
		vis[v]=1;
    int curr_size=1;
		
		
		for(int child:l.get(v)) {
			if(vis[child]==0)
			curr_size+=dfs(child);
		}
    
    SubTree[v] = curr_size;
    
    return curr_size;
	}
	
