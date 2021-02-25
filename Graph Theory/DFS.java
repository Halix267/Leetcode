
int vis[] = new int[1000001];
void dfs(int v) {
		
		vis[v]=1;
		
		
		for(int child:l.get(v)) {
			if(vis[child]==0)
			dfs(child);
		}
	}
	
